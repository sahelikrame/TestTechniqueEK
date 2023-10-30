package org.ekwateur.domain;

import org.ekwateur.domain.data.Energy;
import org.ekwateur.domain.data.ParticularClient;
import org.ekwateur.domain.data.ProfessionalClient;
import org.ekwateur.domain.history.BillingHistory;
import org.ekwateur.domain.history.HistoryConfiguration;
import org.ekwateur.infrastructure.dao.BillingHistoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Month;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class EkwateurBilling {

    public static void main(String[] args) {

        ParticularClient particularClient = new ParticularClient("EKW12345678", "M.", "Defraine", "Anthony");
        ProfessionalClient professionalClient = new ProfessionalClient("EKW87654321", "1234567890", "Ekwateur Entreprises", 1500000.0);

        HistoryConfiguration historyConfiguration = new HistoryConfiguration();
        BillingHistory particularBillingHistory = new BillingHistoryDao(historyConfiguration);
        BillingHistory professionalBillingHistory = new BillingHistoryDao(historyConfiguration);

        Billing particularBill = new BillingService(particularClient,particularBillingHistory,professionalBillingHistory);
        Billing professionalBill = new BillingService(professionalClient,particularBillingHistory,professionalBillingHistory);

        particularBill.addConsumption(Energy.Electricity, 500);
        particularBill.addConsumption(Energy.Gas, 300);

        professionalBill.addConsumption(Energy.Electricity, 1000);
        professionalBill.addConsumption(Energy.Gas, 800);

        particularBill.calculateCost(getDate(2023,10,24));
        professionalBill.calculateCost(getDate(2023,10,24));

        System.out.println(particularBill.fetchHistory());
        System.out.println(professionalBill.fetchHistory());

    }

    private static Date getDate(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);
        return cal.getTime();
    }

}
