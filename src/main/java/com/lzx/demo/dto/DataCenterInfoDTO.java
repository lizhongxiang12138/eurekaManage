package com.lzx.demo.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 描述:
 *
 * @Auther: lzx
 * @Date: 2019/4/28 16:50
 */
@JacksonXmlRootElement(localName = "dataCenterInfo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataCenterInfoDTO {

    @JacksonXmlProperty(localName = "name")
    private String name;
}
