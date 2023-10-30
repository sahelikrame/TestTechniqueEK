package org.ekwateur.domain;

import org.ekwateur.domain.data.Bill;
import org.ekwateur.domain.data.Energy;

import java.util.Date;
import java.util.List;

public interface Billing {

    static final double priceKwhElectricityParticular = 0.121;
    static final double priceKwhGasParticular = 0.115;
    static final double priceKwhElectricityProSup1M = 0.114;
    static final double priceKwhGasProSup1M = 0.111;
    static final double priceKwhElectricityProInf1M = 0.118;
    static final double priceKwhGasProInf1M = 0.113;

    public void addConsumption(Energy energy, double consumption);
    public double calculateCost(Date month);

    public List<Bill> fetchHistory();

}