package org.ekwateur.domain;

import org.ekwateur.domain.data.*;
import org.ekwateur.domain.exception.ClientTypeNotSupportedException;
import org.ekwateur.domain.history.BillingHistory;
import org.ekwateur.infrastructure.dao.BillingHistoryDao;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.*;

@Service
public class BillingService implements Billing {

    private final Client client;
    private final Map<Date, Map<Energy, Double>> consumptions;
    private final BillingHistory particularBillingHistory;
    private final BillingHistory professionalBillingHistory;

    public BillingService(Client client, BillingHistory particularBillingHistory, BillingHistory professionalBillingHistory) {
        this.client = client;
        this.consumptions = new HashMap<>();
        this.particularBillingHistory = particularBillingHistory;
        this.professionalBillingHistory = professionalBillingHistory;
    }

    @Override
    public void addConsumption(Energy energy, double consumption) {
        Date sysDate = new Date();
        consumptions.put(sysDate, new HashMap<>());
        consumptions.get(sysDate).put(energy,consumption);
    }


    //Imperative approach
    /*@Override
    public double calculateCost() {

        double totalCost = 0.0;

        for (Map.Entry<Energy, Double> entry : consumptions.entrySet()) {
            Energy energy = entry.getKey();
            double consumption = entry.getValue();

            double priceKwh = 0.0;
            if (client instanceof ParticularClient) {
                priceKwh = (energy.equals(Energy.Electricity)) ? priceKwhElectricityParticular : priceKwhGasParticular;
            } else if (client instanceof ProfessionalClient) {
                double salesRevenue = ((ProfessionalClient) client).getSalesRevenue();
                if (salesRevenue > 1000000) {
                    priceKwh = (energy.equals(Energy.Electricity)) ? priceKwhElectricityProSup1M : priceKwhGasProSup1M;
                } else {
                    priceKwh = (energy.equals(Energy.Electricity)) ? priceKwhElectricityProInf1M : priceKwhGasProInf1M;
                }
            }

            totalCost += consumption * priceKwh;
        }
        return totalCost;
    }*/

    //Declarative approach using the Stream API
    public double calculateCost(Date month) {

        double totalCost = consumptions.entrySet().stream()
                .filter(entry -> isSameMonth(entry.getKey(), month))
                .mapToDouble(entry -> entry.getValue().entrySet().stream()
                        .mapToDouble(innerEntry -> {
                            Energy energy = innerEntry.getKey();
                            double consumption = innerEntry.getValue();
                            double priceKwh = getPriceKwh(energy);
                            return consumption * priceKwh;
                        })
                        .sum())
                .sum();
        Bill clientBill = new Bill();
        clientBill.setClient(client);
        clientBill.setDate(new Date());
        clientBill.setTotalCost(totalCost);
        if (client instanceof ParticularClient) {
            particularBillingHistory.save(clientBill);
        } else {
            professionalBillingHistory.save(clientBill);
        }
        return totalCost;
    }

    double getPriceKwh(Energy energy) {
        if (client instanceof ParticularClient) {
            return (energy.equals(Energy.Electricity)) ? priceKwhElectricityParticular : priceKwhGasParticular;
        } else if (client instanceof ProfessionalClient) {
            double salesRevenue = ((ProfessionalClient) client).getSalesRevenue();
            if (salesRevenue > 1000000) {
                return (energy.equals(Energy.Electricity)) ? priceKwhElectricityProSup1M : priceKwhGasProSup1M;
            } else {
                return (energy.equals(Energy.Electricity)) ? priceKwhElectricityProInf1M : priceKwhGasProInf1M;
            }
        }
        throw new ClientTypeNotSupportedException();
    }
    public List<Bill> fetchHistory() {
        if (client instanceof ParticularClient) {
            return particularBillingHistory.asList();
        }
        return professionalBillingHistory.asList();
    }
    private static boolean isSameMonth(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
    }

    public Map<Date, Map<Energy, Double>> getConsumptions() {
        return consumptions;
    }
}
