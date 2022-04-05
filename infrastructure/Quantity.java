package infrastructure;

/**
 * Returns and defines
 * the quantity for a
 * coin during trading.
 */
public class Quantity {
    private Boolean isCrypto;  // true for crypto, false for CAD
    private double amount;

    /**
     * determines whether the given
     * coin is CAD or crypto and
     * the amount regardless.
     * @param type
     * @param amount
     */
    public Quantity(Boolean type, double amount) {
        isCrypto = type;
        this.amount = amount;
    }

    /**
     * @param coin
     * @return the amount of crypto.
     */
    public double getAmountCrypto(Coin coin) {
        if (isCrypto) return amount;
        else {
            return amount / coin.getPrice();
        }
    }
}
