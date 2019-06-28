package com.lzx.demo.service.impl;

import com.lzx.demo.service.KafkaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * 描述: Kafka业务实现
 *
 * @Auther: lzx
 * @Date: 2019/6/27 11:20
 */
@Service
@Slf4j
public class KafkaServiceImpl implements KafkaService {

    private KafkaTemplate<String,String> kafkaTemplate;

    public KafkaServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * 发布消息到 topic
     * @param channel topic 名称
     * @param message 消息内容
     */
    @Override
    public void sendChannelMess(String channel, String message) {
        kafkaTemplate.send(channel,message);
    }
}
