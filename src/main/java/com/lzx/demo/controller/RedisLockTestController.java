package com.lzx.demo.controller;

import com.lzx.demo.annotation.LzxLockDistributed;
import com.lzx.demo.feign.SelfFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * 描述: redis 锁配置
 *
 * @Auther: lzx
 * @Date: 2019/6/17 15:08
 */
@RestController
@RequestMapping("/lock")
@Slf4j
public class RedisLockTestController {

    private SelfFeign selfFeign;

    public static int inventory = 0;

    private RedisLockRegistry redisLockRegistry;

    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    public static String[] strArr=new String[]{"1号","2号","3号","4号","5号"};

    public RedisLockTestController(RedisLockRegistry redisLockRegistry,SelfFeign selfFeign,ThreadPoolTaskExecutor threadPoolTaskExecutor) {
        this.redisLockRegistry = redisLockRegistry;
        this.selfFeign = selfFeign;
        this.threadPoolTaskExecutor = threadPoolTaskExecutor;
    }

    @GetMapping("/redisLockTest")
    @LzxLockDistributed(value = "redisLockRegistry",time = 60)
    public String redisLockTest() throws InterruptedException {
        if(inventory >= 5){
            return "已经抢购完了~~~";
        }
        String s = strArr[inventory];
        Thread.sleep(10*1000);
        inventory++;
        return s;

    }

    @GetMapping("/noLockTest")
    @LzxLockDistributed(value = "redisLockRegistry",time = 10)
    public String noLockTest() throws InterruptedException {
        if(inventory >= 5){
            return "已经抢购完了~~~";
        }
        String s = strArr[inventory];
        Thread.sleep(1*1000);
        inventory++;
        return s;
    }


    @GetMapping("/testLockFor")
    public String testLockFor() throws InterruptedException {
        inventory = 0;
        StringBuffer bf = new StringBuffer("");
        int count = 30;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for(int i=0;i<count;i++){
            int finalI = i;
            threadPoolTaskExecutor.execute(()->{
                String s = selfFeign.redisLockTest();
                bf.append("第"+ finalI +"个抢购，抢到【"+s+"】<br/>");
                log.info("第"+ finalI +"个抢购，抢到【"+s+"】");
                countDownLatch.countDown();
            });

        }
        countDownLatch.await();
        return bf.toString();
    }

    @GetMapping("/testNoLockFor")
    public String testNoLockFor() throws InterruptedException {
        inventory = 0;
        StringBuffer bf = new StringBuffer("");
        int count = 30;
        CountDownLatch countDownLatch = new CountDownLatch(count);
        for(int i=0;i<count;i++){
            int finalI = i;
            threadPoolTaskExecutor.execute(()->{
                String s = selfFeign.noLockTest();
                bf.append("第"+ finalI +"个抢购，抢到【"+s+"】<br/>");
                log.info("第"+ finalI +"个抢购，抢到【"+s+"】");
                countDownLatch.countDown();
            });

        }
        countDownLatch.await();
        return bf.toString();
    }

}
