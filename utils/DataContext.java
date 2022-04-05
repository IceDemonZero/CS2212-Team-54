package utils;

/**
 * Context class for strategy design pattern
 * @author Jay.
 */
public class DataContext {
    private FetcherStrategy strategy;

    /**
     * Attach the strategy for this context.
     * @param strategy
     */
    public DataContext(FetcherStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Change the strategy of this context.
     * @param strategy
     */
    public void setStrategy(FetcherStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Retrieve crypto data
     * and retrieve pric for the given
     * coin on method execution.
     */
    public void execute() {
        strategy.getDataForCrypto(this, "", "");
        strategy.getPriceForCoin(this, "", "");
    }

}
