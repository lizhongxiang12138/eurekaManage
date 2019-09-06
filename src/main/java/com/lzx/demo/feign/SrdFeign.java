package com.lzx.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 描述:
 *
 * @Auther: lzx
 * @Date: 2019/4/28 16:18
 */
@FeignClient(value = "srd",url="${eureka.client.service-url.defaultZone}")
public interface SrdFeign {

    @GetMapping("/apps")
    String getApps();

    @GetMapping("/apps/{app}")
    String getAppsApp(@PathVariable("app") String app);

    @PutMapping("/apps/{app}/{instanceId}/status")
    void outOf(@PathVariable("app")String app, @PathVariable("instanceId")String instanceId, @RequestParam("value")String value);

    @DeleteMapping("/apps/{app}/{instanceId}/status")
    void up(@PathVariable("app")String app, @PathVariable("instanceId")String instanceId, @RequestParam("value")String value);


    @DeleteMapping("/apps/{app}/{instanceId}")
    void delete(@PathVariable("app")String app, @PathVariable("instanceId")String instanceId);
}
