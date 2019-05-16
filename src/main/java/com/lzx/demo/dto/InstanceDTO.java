package com.lzx.demo.dto;

import com.ctc.wstx.util.StringUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 描述:
 *
 * @Auther: lzx
 * @Date: 2019/4/28 16:37
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "instanceDTO")
@AllArgsConstructor
@NoArgsConstructor
public class InstanceDTO {

    @JacksonXmlProperty(localName = "instanceId")
     private String instanceId;
    @JacksonXmlProperty(localName = "hostName")
     private String hostName;
    @JacksonXmlProperty(localName = "app")
     private String app;
    @JacksonXmlProperty(localName = "ipAddr")
     private String ipAddr;
    @JacksonXmlProperty(localName = "status")
     private String status;
    @JacksonXmlProperty(localName = "overriddenstatus")
     private String overriddenstatus;
    @JacksonXmlProperty(localName = "port")
    private Port port;
    @JacksonXmlRootElement(localName = "port")
    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Port{
        @JacksonXmlProperty(isAttribute = true)
        private String enabled;
        @JacksonXmlText
        private String value;
    }

    @JacksonXmlProperty(localName = "homePageUrl")
    private String homePageUrl;
    @JacksonXmlProperty(localName = "statusPageUrl")
    private String statusPageUrl;
    @JacksonXmlProperty(localName = "healthCheckUrl")
    private String healthCheckUrl;
    @JacksonXmlProperty(localName = "vipAddress")
    private String vipAddress;
    @JacksonXmlProperty(localName = "secureVipAddress")
    private String secureVipAddress;
    @JacksonXmlProperty(localName = "isCoordinatingDiscoveryServer")
    private String isCoordinatingDiscoveryServer;
    @JacksonXmlProperty(localName = "lastUpdatedTimestamp")
    private String lastUpdatedTimestamp;
    @JacksonXmlProperty(localName = "lastDirtyTimestamp")
    private String lastDirtyTimestamp;
    @JacksonXmlProperty(localName = "actionType")
    private String actionType;

}
