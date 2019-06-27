package com.lzx.demo.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.lzx.demo.dto.*;
import com.lzx.demo.feign.SrdFeign;
import com.lzx.demo.service.KafkaService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 *
 * @Auther: lzx
 * @Date: 2019/4/25 13:06
 */
@RestController
@RequestMapping("/testController")
@Slf4j
public class TestController {

    private SrdFeign srdFeign;

    private KafkaService kafkaService;

    public TestController(SrdFeign srdFeign,
                          KafkaService kafkaService) {
        this.srdFeign = srdFeign;
        this.kafkaService = kafkaService;
    }

    @GetMapping("/findByPage")
    @ApiOperation(value = "分页获取协议信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page",value = "页码:1开始",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "size",value = "每页数据",paramType = "query",dataType = "String"),
            @ApiImplicitParam(name = "sort",value = "排序",paramType = "query",dataType = "String")
    }
    )
    public PageDataDTO<ProductProtocolDTO> findByPage(
            @RequestParam("page") String page,
            @RequestParam("size") String size,
            @RequestParam("sort") String sort
    ){
        List content = new ArrayList<ProductProtocolDTO>();
        return new PageDataDTO<ProductProtocolDTO>(
                content,
                new PageableDTO("2","0"),
                false,
                "2",
                "1",
                true
        );
    }

    @PostMapping("/save")
    @ApiOperation(value = "保存协议信息")
    public ProductProtocolDTO save(@RequestBody ProductProtocolDTO productProtocolDTO){
        return productProtocolDTO;
    }

    @GetMapping("/getApps")
    @ApiOperation(value = "获取所有应用")
    public ApplicationsDTO getApps() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String apps = srdFeign.getApps();
        log.info(apps);
        ApplicationsDTO applicationsDTO =  xmlMapper.readValue(apps, ApplicationsDTO.class);

        return applicationsDTO;
    }

    @GetMapping("/getAppsApp/{app}")
    public ApplicationsDTO getAppsApp(@PathVariable("app")String app) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String apps = srdFeign.getAppsApp(app);
        log.info(apps);
        ApplicationDTO applicationDTO =  xmlMapper.readValue(apps, ApplicationDTO.class);
        ArrayList<ApplicationDTO> applicationDTOList = new ArrayList<ApplicationDTO>();
        applicationDTOList.add(applicationDTO);
        ApplicationsDTO applicationsDTO = new ApplicationsDTO(applicationDTOList);

        return applicationsDTO;
    }

    @GetMapping("/outOf/apps/{app}/{instanceId}")
    public void outOf(@PathVariable("app")String app,@PathVariable("instanceId")String instanceId){
        srdFeign.outOf(app,instanceId,"OUT_OF_SERVICE");
        try {
            Thread.sleep(2*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/up/apps/{app}/{instanceId}")
    public void up(@PathVariable("app")String app,@PathVariable("instanceId")String instanceId){
        srdFeign.up(app,instanceId,"UP");
    }

    @PostMapping("/testSendToKafka")
    public Boolean testSendToKafka(@RequestBody KafkaMessDTO kafkaMessDTO){
        kafkaService.sendChannelMess("myChannel",kafkaMessDTO.getMess());
        return true;
    }
}
