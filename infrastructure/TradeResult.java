package infrastructure;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This is a data structure to
 * return the results of trades.
 * @author Jiangqi
 */
public class TradeResult {

    // this is just a data structure, no need to hide the data
    public String strategy;
    public Coin coin;
    public String action;
    public Quantity quantity;
    public double price;
    public String date;
    public Trader trader;

    /**
     * @param strategy
     * @param coin
     * @param action
     * @param quantity
     * @param price
     */
    public TradeResult(String strategy, Coin coin, String action, Quantity quantity, double price) {
        this.strategy = strategy;
        this.coin = coin;
        this.action = action;
        this.quantity = quantity;
        this.price = price;
        this.date  = new SimpleDateFormat("dd-MM-yyyy").format(new Date());;
    }

}
