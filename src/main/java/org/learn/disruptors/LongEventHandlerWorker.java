package org.learn.disruptors;

import com.lmax.disruptor.WorkHandler;

public class LongEventHandlerWorker implements WorkHandler<LongEvent> {
    public static long count = 0;

    @Override
    public void onEvent(LongEvent longEvent) throws Exception {
        count ++;
        System.out.println("[" + Thread.currentThread().getName() + "]" + "event=" + longEvent.toString());
    }
}
