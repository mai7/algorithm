package org.mai.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A time delayed trigger
 * It can only be triggered after a delayed time, so user can use it to control some works rhythm.
 * Created by vincent on 1/26/16.
 *
 */
public class TimeDelayedTrigger {

    private final int delay;
    private final TimeUnit timeUnit;
    private final AtomicBoolean flag;
    private final ExecutorService sc;

    public TimeDelayedTrigger(int delay, TimeUnit timeUnit) {
        this.delay = delay;
        this.timeUnit = timeUnit;
        this.flag = new AtomicBoolean(true);
        this.sc = Executors.newFixedThreadPool(1);

    }

    /**
     * trigger to fire if possible
     * @return true when trigger successfully
     */
    public boolean trigger() {
        boolean currentFlag = flag.get();
        if (currentFlag) {
            if (!flag.compareAndSet(currentFlag, false)) {
                return false;
            }
            this.sc.execute(() -> {
                try {
                    timeUnit.sleep(delay);
                    flag.set(true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            });
        }
        return currentFlag;

    }
}
