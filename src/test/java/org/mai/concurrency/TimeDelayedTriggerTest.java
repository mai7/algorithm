package org.mai.concurrency;

import junit.framework.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by vincent on 1/26/16.
 */
public class TimeDelayedTriggerTest {

    @Test
    public void testTimeDelayedBox() throws InterruptedException {
        TimeDelayedTrigger tdbox = new TimeDelayedTrigger(10, TimeUnit.SECONDS);
        AtomicInteger a = new AtomicInteger(0);
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    if (tdbox.trigger()) {
                        a.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });
        es.execute(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    if (tdbox.trigger()) {
                        a.incrementAndGet();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });

        es.shutdown();
        es.awaitTermination(40, TimeUnit.SECONDS);
        Assert.assertTrue(a.get() < 3);
    }
}
