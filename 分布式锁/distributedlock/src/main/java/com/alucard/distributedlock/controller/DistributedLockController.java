package com.alucard.distributedlock.controller;

import com.alucard.distributedlock.service.LockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author alucard
 * @Description
 * @Date Create in 10:31 2018/9/17
 */
@RestController
public class DistributedLockController {

    @Autowired
    LockService lockService;

    @GetMapping("testRedisLock")
    public String testRedisLock(){
        // 模拟50个线程
        for (int i = 0; i < 50; i++) {
            ThreadRedis threadRedis = new ThreadRedis(lockService);
            threadRedis.start();
        }
        return "ok";
    }
}

@Component
class ThreadRedis extends Thread {
    @Autowired
    private LockService lockService;

    public ThreadRedis(LockService lockService) {
        this.lockService = lockService;
    }

    @Override
    public void run() {
        lockService.seckill();
    }

}
