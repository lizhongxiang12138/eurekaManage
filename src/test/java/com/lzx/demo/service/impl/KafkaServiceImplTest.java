package com.lzx.demo.service.impl;

import com.lzx.demo.service.KafkaService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 描述:
 *
 * @Auther: lzx
 * @Date: 2019/6/27 13:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class KafkaServiceImplTest {

    @Autowired
    private KafkaService kafkaService;

    @Test
    public void sendChannelMess() {

        kafkaService.sendChannelMess("myChannel","这是一条测试数据");

    }
}