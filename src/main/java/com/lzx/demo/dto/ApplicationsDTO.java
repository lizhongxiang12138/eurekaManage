package com.lzx.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import jdk.nashorn.internal.ir.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 描述:
 *
 * @Auther: lzx
 * @Date: 2019/4/29 09:48
 */
@JacksonXmlRootElement(localName = "applications")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationsDTO {

//    @JacksonXmlProperty(localName = "versions__delta")
//    private String versionsDelta;
//    @JacksonXmlProperty(localName = "apps__hashcode")
//    private String appsHashcode;
    @JacksonXmlProperty(localName = "application")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<ApplicationDTO>  application;
}
