package com.alucard;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author alucard
 * @Description
 * @Date Create in 10:09 2018/10/8
 */
public class Test03 {
    private static final long initialDelay = 0;
    private static final long period = 500;// 500 millseconds

    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = Executors.defaultThreadFactory();
        ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(10, namedThreadFactory);
        scheduledPool.scheduleAtFixedRate(
                ()->{

                    System.out.println(Thread.currentThread().getName()+">>>111");
                },
                initialDelay,
                period,
                TimeUnit.MILLISECONDS
        );
    }
}
