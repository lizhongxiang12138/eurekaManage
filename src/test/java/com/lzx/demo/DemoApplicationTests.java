package com.lzx.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Hashtable;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class DemoApplicationTests {

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    static Hashtable<String,Integer> TEST_HASHTABLE ;

    static {
        TEST_HASHTABLE = new Hashtable<String, Integer>();
        TEST_HASHTABLE.put("one",1);
        TEST_HASHTABLE.put("tow",2);
    }

    CountDownLatch countDownLatch = new CountDownLatch(2);

    @Test
    public void contextLoads() throws InterruptedException {
        threadPoolTaskExecutor.execute(()->{
            test();
        });

        threadPoolTaskExecutor.execute(()->{
            test();
        });

        countDownLatch.await();

    }

    private void test() {
        Integer one = TEST_HASHTABLE.get("one");
        log.info("============== 获取one的值："+one);
        try {
            Thread.sleep(20*1000);
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        one++;
        //TEST_HASHTABLE.put("one",TEST_HASHTABLE.get("one")+1);
        log.info("=================== 加完后的数据："+TEST_HASHTABLE.get("one"));
    }

}
