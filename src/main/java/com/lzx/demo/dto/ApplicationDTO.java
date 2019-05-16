package com.lzx.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 描述:
 *
 * @Auther: lzx
 * @Date: 2019/4/28 16:20
 */
@JacksonXmlRootElement(localName = "application")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationDTO {

     @JacksonXmlProperty(localName = "name")
     private String name;
     @JacksonXmlProperty(localName = "instance")
     @JacksonXmlElementWrapper(useWrapping = false)
     private List<InstanceDTO> instance;

}
