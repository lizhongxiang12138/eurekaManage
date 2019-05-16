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
 * @Date: 2019/4/28 16:52
 */
@JacksonXmlRootElement(localName = "leaseInfo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LeaseInfoDTO {

    @JacksonXmlProperty(localName = "renewalIntervalInSecs")
    private String renewalIntervalInSecs;
    @JacksonXmlProperty(localName = "durationInSecs")
    private String durationInSecs;
    @JacksonXmlProperty(localName = "registrationTimestamp")
    private String registrationTimestamp;
    @JacksonXmlProperty(localName = "lastRenewalTimestamp")
    private String lastRenewalTimestamp;
    @JacksonXmlProperty(localName = "evictionTimestamp")
    private String evictionTimestamp;
    @JacksonXmlProperty(localName = "serviceUpTimestamp")
    private String serviceUpTimestamp;


}
