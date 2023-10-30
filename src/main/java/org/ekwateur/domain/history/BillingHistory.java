package org.ekwateur.domain.history;

import org.ekwateur.domain.Billing;
import org.ekwateur.domain.data.Bill;

import java.util.List;

public interface BillingHistory {
    void save(Bill clientBill);

    List<Bill> asList();
}
