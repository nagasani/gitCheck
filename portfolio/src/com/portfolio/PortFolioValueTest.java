package com.portfolio;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.math.BigDecimal;

import org.junit.Test;


public class PortFolioValueTest {
	
	@Test
    public void testGetExchangeRates() throws Exception {
        
        final BigDecimal tickerValue = PortFolioValue.getTickerValue("BTC");
        assertThat(BigDecimal.valueOf(58623.22), is(tickerValue));
    }
}
