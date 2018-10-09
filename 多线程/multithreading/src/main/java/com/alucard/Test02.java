package com.alucard;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author alucard
 * @Description
 * @Date Create in 10:07 2018/10/8
 */
public class Test02 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            int temp = i;
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+",temp:"+temp);
            });
        }
    }
}
