package strategy;
import infrastructure.*;
import utils.AvailableCryptoList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * 3rd of 4 strategies for trading
 * @author Nick
 */
public class Strategy_C implements AbstractStrategy {
    private static final String name = "Strategy-C";

    private static Strategy_C instance;
    private AvailableCryptoList list;
    private HashMap<String, Coin> hmap;

    private Strategy_C() {
        list = AvailableCryptoList.getInstance();
        hmap = list.getMap();
    }

    public static Strategy_C getInstance() {
        if (instance == null)
            instance = new Strategy_C();

        return instance;
    }

    public static String getName() {
        return name;
    }

    /**
     * This method determines and compiles the data for the first rule of the Strategy_C trading strategy.
     * 
     * @return The resulting data of employing this rule in the trade strategy.
     */
    @Override
    public TradeResult rule_1() {

        Condition c1 = new Condition(hmap.get("eth"), 4000, "<=");  // ETH is less than or equal to 4000
        Condition c2 = new Condition(hmap.get("bnb"), 350, ">");  // BNB is more than 350
        
        Quantity quan = new Quantity(true, 10);  // true for crypto amount

        if (c1.evaluate() && c2.evaluate()) {
            return new TradeResult(
                    name,                             // Strategy-C
                    hmap.get("eth"),                  // coin ETH
                    "Buy",                            // action
                    quan,                             // buy 10 ETH
                    hmap.get("eth").getPrice());      // ETH price
        }
        else return null;
    }

    /**
     * This method determines and compiles the data for the second rule of the Strategy_C trading strategy.
     * 
     * @return The resulting data of employing this rule in the trade strategy.
     */
    @Override
    public TradeResult rule_2() {

        Condition c1 = new Condition(hmap.get("eth"), 4500, "<=");  // ETH is less than or equal to 4500
        Condition c2 = new Condition(hmap.get("sol"), 50, ">");  // SOL is less than 50
        
        Quantity quan = new Quantity(true, 5);  // true for crypto amount

        if (c1.evaluate() && c2.evaluate()) {
            return new TradeResult(
                    name,                             // Strategy-C
                    hmap.get("eth"),                  // coin ETH
                    "Buy",                            // action
                    quan,                             // buy 5 ETH
                    hmap.get("eth").getPrice());      // ETH price
        }
        else return null;
    }

    /**
     * This method determines and compiles the data for the third rule of the Strategy_C trading strategy.
     * 
     * @return The resulting data of employing this rule in the trade strategy.
     */
    @Override
    public TradeResult rule_3() {

        Condition c1 = new Condition(hmap.get("eth"), 5000, ">");  // ETH is less than or equal to 5000
        Condition c2 = new Condition(hmap.get("xmr"), 150, ">");  // XMR is more than 150
        
        Quantity quan = new Quantity(false, 4000);  // false for CAD amount

        if (c1.evaluate() && c2.evaluate()) {
            return new TradeResult(
                    name,                             // Strategy-C
                    hmap.get("eth"),                  // coin ETH
                    "Sell",                           // action
                    quan,                             // sell $4000 worth of ETH
                    hmap.get("eth").getPrice());      // ETH price
        }
        else return null;
    }

    /**
     * This method determines and compiles the data for the fourth rule of the Strategy_C trading strategy.
     * 
     * @return The resulting data of employing this rule in the trade strategy.
     */
    @Override
    public TradeResult rule_4() {

        Condition c1 = new Condition(hmap.get("eth"), 6000, ">");  // ETH is more than 6000
        
        Quantity quan = new Quantity(true, 10);  // true for crypto amount

        if (c1.evaluate()) {
            return new TradeResult(
                    name,                             // Strategy-C
                    hmap.get("eth"),                  // coin ETH
                    "Sell",                           // action
                    quan,                             // sell 10 ETH
                    hmap.get("eth").getPrice());      // ETH price
        }
        else return null;
    }

    /**
     * This method determines the result after employing all rules for Strategy_C and returns a list of the resulting data.
     * 
     * @return A list of all the results after all the rules are used.
     */
    @Override
    public ArrayList<TradeResult> trade() {
        ArrayList<TradeResult> results = new ArrayList<TradeResult>();
        results.add(rule_1());
        results.add(rule_2());
        results.add(rule_3());
        results.add(rule_4());

        results.removeAll(Collections.singleton(null));  // remove all unsuccessful trades
        return results;
    }
}
