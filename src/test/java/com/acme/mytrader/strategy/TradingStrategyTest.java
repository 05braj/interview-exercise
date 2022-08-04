package com.acme.mytrader.strategy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TradingStrategyTest {

    @Mock
    private TradingExecuteBuyOrder tradingExecuteBuyOrder;

    @InjectMocks
    private TradingStrategy tradingStrategy;


    @Test
    public void testPriceUpdateWhenPriceLessThan55() {
        tradingStrategy.priceUpdate("IBM", 44);
        Mockito.verify(tradingExecuteBuyOrder).totalStockCount(100);
    }

    @Test
    public void testPriceUpdateWhenPriceGreaterThan55() {
        tradingStrategy.priceUpdate("IBM", 66);
        Mockito.verify(tradingExecuteBuyOrder).totalStockCount(0);
    }

    @Test
    public void testPriceUpdateWhenSecurityIsNotIBM() {
        tradingStrategy.priceUpdate("TCS", 44);
        Mockito.verify(tradingExecuteBuyOrder).totalStockCount(0);
    }
}
