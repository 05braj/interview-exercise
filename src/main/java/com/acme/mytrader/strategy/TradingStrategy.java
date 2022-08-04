package com.acme.mytrader.strategy;

import com.acme.mytrader.price.PriceListener;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy implements PriceListener {

    private TradingExecuteBuyOrder tradingExecuteBuyOrder;

    private static final String STOCK = "IBM";

    private static final double stockPriceBuyTriggerLimit = 55.0;

    private static int stockCount = 0;
    private static int totalStock = 0;

    private static int numberOfStocksToPurchase = 100;

    public TradingStrategy(TradingExecuteBuyOrder tradingExecuteBuyOrder) {
        this.tradingExecuteBuyOrder = tradingExecuteBuyOrder;
    }

    @Override
    public void priceUpdate(String security, double price) {
        //compare the security and apply the business rule to execute buy order when stock price is less than buy limit
        if (STOCK.equalsIgnoreCase(security) && price < stockPriceBuyTriggerLimit) {
            totalStock = stockCount + numberOfStocksToPurchase;
            stocksPurchased(totalStock);
        } else {
            stocksPurchased(totalStock);
        }
    }

    private void stocksPurchased(int total) {
        tradingExecuteBuyOrder.totalStockCount(total);
    }
}
