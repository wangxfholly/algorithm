package org.learn.disruptors;

import com.lmax.disruptor.EventHandler;

public class LongEventHandler implements EventHandler<LongEvent> {
    public static long count = 0;

    @Override
    public void onEvent(LongEvent longEvent, long sequence, boolean endOfBatch) throws Exception {
        count++;
        System.out.println("[" + Thread.currentThread().getName() + "]" + "Event: " + longEvent + ", sequence: " + sequence + ", endOfBatch: " + endOfBatch);
    }
}
