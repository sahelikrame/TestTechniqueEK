package org.ekwateur.infrastructure.dao;

import org.ekwateur.domain.Billing;
import org.ekwateur.domain.data.Bill;
import org.ekwateur.domain.history.BillingHistory;
import org.ekwateur.domain.history.HistoryConfiguration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BillingHistoryDao implements BillingHistory {

    private final HistoryConfiguration historyConfig;
    private final List<Bill> history;

    public BillingHistoryDao(HistoryConfiguration historyConfig) {
        this.historyConfig = historyConfig;
        this.history = new ArrayList<>(historyConfig.getMaxSize());
    }
    @Override
    public void save(Bill clientBill) {
        if (history.size() == historyConfig.getMaxSize()) {
            history.remove(0);
        }
        history.add(clientBill);
    }

    @Override
    public List<Bill> asList() {
        return history;
    }
}
