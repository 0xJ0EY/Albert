package table;

import table.strategies.DataStrategy;

public class DataRunnable implements Runnable {


    private Thread thread;
    private DataStrategy strategy;

    public DataRunnable(DataStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void run() {

        this.strategy.fetch();

    }

    public void start () {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }

    }

    public void interrupt() {
        thread.interrupt();
    }
}
