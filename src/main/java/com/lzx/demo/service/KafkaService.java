package com.lzx.demo.service;

/**
 * 描述: kafka业务接口
 *
 * @Auther: lzx
 * @Date: 2019/6/27 11:08
 */
public interface KafkaService {

    void sendChannelMess(String channel,String message);

}
