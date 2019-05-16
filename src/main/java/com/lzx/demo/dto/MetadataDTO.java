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
 * @Date: 2019/4/28 16:57
 */
@JacksonXmlRootElement(localName = "metadata")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MetadataDTO {

    @JacksonXmlProperty(localName = "management.port")
    private String managementPort;
}
