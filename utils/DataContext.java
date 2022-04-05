package utils;

/**
 * Context class for observer design pattern
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

    public void execute() {
        strategy.getDataForCrypto(this, "", "");
        strategy.getPriceForCoin(this, "", "");
    }

}
