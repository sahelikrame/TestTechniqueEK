package org.ekwateur.domain.history;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoryConfigurationTest {
    @Test
    public void testGetMaxSizeDefault() {
        HistoryConfiguration historyConfiguration = new HistoryConfiguration();
        int expectedMaxSize = 20; // Valeur par défaut

        int maxSize = historyConfiguration.getMaxSize();

        assertEquals(expectedMaxSize, maxSize);
    }

    @Test
    public void testSetMaxSize() {
        HistoryConfiguration historyConfiguration = new HistoryConfiguration();
        int expectedMaxSize = 30;

        historyConfiguration.setMaxSize(expectedMaxSize);

        int maxSize = historyConfiguration.getMaxSize();

        assertEquals(expectedMaxSize, maxSize);
    }
}