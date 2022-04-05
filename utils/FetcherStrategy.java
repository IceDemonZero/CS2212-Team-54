package utils;

import com.google.gson.JsonObject;

/**
 * Main class for strategy design pattern.
 * Provides the below methods for modification.
 * @author Jay
 */
public abstract class FetcherStrategy {
    /**
     * @param context
     * @param id
     * @param date
     * @return crypto data for coin
     */
    protected abstract JsonObject getDataForCrypto(DataContext context, String id, String date);

    /**
     * @param context
     * @param id
     * @param date
     * @return price for coin.
     */
    protected abstract double getPriceForCoin(DataContext context, String id, String date);
}
