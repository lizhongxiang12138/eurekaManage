package com.lzx.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 描述:
 *
 * @Auther: lzx
 * @Date: 2019/6/17 15:20
 */
@FeignClient(value = "self",url="http://127.0.0.1:3001",path = "/lock")
public interface SelfFeign {

    @GetMapping("/redisLockTest")
    String redisLockTest();

    @GetMapping("/noLockTest")
    String noLockTest();

}
