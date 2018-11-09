package table;

import table.strategies.DataStrategy;

// TODO: Auto-generated Javadoc
/**
 * The Class DataRunnable.
 *
 */
public class DataRunnable implements Runnable {


    /** The thread. */
    private Thread thread;
    
    /** The strategy. */
    private DataStrategy strategy;

    /**
     * Instantiates a new data runnable.
     *
     * @param strategy the strategy
     */
    public DataRunnable(DataStrategy strategy) {
        this.strategy = strategy;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {

        this.strategy.fetch();

    }

    /**
     * Start.
     */
    public void start () {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }

    }

    /**
     * Interrupt.
     */
    public void interrupt() {
        thread.interrupt();
    }
}
