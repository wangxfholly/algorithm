package org.learn.disruptors;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.*;

public class DisruptorMain {
    public static void main(String[] args) throws InterruptedException {
        //The factory for the event
        LongEventFactory factory = new LongEventFactory();
        //specify the size of the ring buffer, must be power of 2.
        int bufferSize = 1024 * 1024;
        //Construct the Disruptor
        Disruptor<LongEvent> disruptor = new Disruptor<>(factory, bufferSize, Executors.defaultThreadFactory());
        //Connect the handler
        LongEventHandler handler = new LongEventHandler();
        LongEventHandler handler2 = new LongEventHandler();
        disruptor.handleEventsWith(handler, handler2);
        //Start the Disruptor, starts all threads running

        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        //================================================================================================
        final int threadCount = 3;
        CyclicBarrier barrier = new CyclicBarrier(threadCount);
        ExecutorService service = Executors.newCachedThreadPool();
        for (long i = 0; i < threadCount; i++) {
            final long threadNum = i;
            service.submit(() -> {
                System.out.printf("Thread %s ready to start!\n", threadNum);
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

                for (int j = 0; j < 2; j++) {
                    final int seq = j;
                    ringBuffer.publishEvent((event, sequence) -> {
                        event.set(seq);
                        System.out.println(threadNum + "线程生产了序号为" + sequence + ",消息为" + seq);
                    });
                }
            });
        }
        service.shutdown();
        TimeUnit.SECONDS.sleep(3);
        System.out.println(LongEventHandler.count);
        disruptor.start();
    }
}
