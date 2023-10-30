package org.ekwateur.domain.data;

import java.util.Date;

public class Bill {
    private Date date;
    private double totalCost;
    private Client client;

    public Bill() {}

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "date=" + date +
                ", totalCost=" + totalCost + " €"+
                ", client=" + client +
                "}\n";
    }

    public Date getDate() {
        return date;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public Client getClient() {
        return client;
    }
}
