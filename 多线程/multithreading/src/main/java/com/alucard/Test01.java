package com.alucard;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author alucard
 * @Description
 * @Date Create in 10:00 2018/10/8
 */
public class Test01 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 30; i++) {
            final int temp = i;
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + ",temp:" + temp);
            });
        }
    }
}
