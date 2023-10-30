package org.ekwateur.infrastructure.dao;

import org.ekwateur.domain.data.Bill;
import org.ekwateur.domain.history.HistoryConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BillingHistoryDaoTest {
        private BillingHistoryDao billingHistoryDao;
        private HistoryConfiguration historyConfig;

        @BeforeEach
        public void setUp() {
            historyConfig = new HistoryConfiguration();
            billingHistoryDao = new BillingHistoryDao(historyConfig);
        }

        @Test
        public void testSave() {
            Bill bill1 = new Bill();
            Bill bill2 = new Bill();

            billingHistoryDao.save(bill1);
            billingHistoryDao.save(bill2);

            assertEquals(2, billingHistoryDao.asList().size());
        }

        @Test
        public void testSaveWithMaxSizeExceeded() {
            historyConfig.setMaxSize(2);

            Bill bill1 = new Bill();
            Bill bill2 = new Bill();
            Bill bill3 = new Bill();

            billingHistoryDao.save(bill1);
            billingHistoryDao.save(bill2);
            billingHistoryDao.save(bill3);

            assertEquals(2, billingHistoryDao.asList().size());
            assertEquals(bill2, billingHistoryDao.asList().get(0));
            assertEquals(bill3, billingHistoryDao.asList().get(1));
        }
}