package com.lzx.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 商品协议
 * @author:  lizhongxiang
 * @pdOid a8fc8f3c-0e33-41f1-a88c-f0e031b9b4f0 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "商品协议")
public class ProductProtocolDTO {
    /**
     * id
     *主键
     */
    @ApiModelProperty(value = "主键",required = true,example = "主键")
    private String id;
    /**
     * 协议名称
     */
	@ApiModelProperty(value = "协议名称",required = true,example = "协议名称")
    private String name;
    
    /**
     * 协议类型
     * PARK :针对停车场发布共享车位
     * PERSON:针对个人发布的共享车位
     * 
     */
    @ApiModelProperty(value = "协议类型",required = true,example = "协议类型: PARK:停车;PERSON:个人")
    private String type;
    /******** 协议类型 *************************/
    public final static String TYPE_PARK = "PARK";
    public final static String TYPE_PERSON = "PERSON";
	/******** 协议类型 *************************/

    /**
     * 停车场Id
     */
    @ApiModelProperty(value = "停车场id",required = true,example = "停车场id")
    private String parkId;
    
    /**
     * 状态
     * 1:生效
     * 0：失效
     */
    @ApiModelProperty(value = "状态",required = true,example = "状态: 1:生效;0：失效")
    private Integer status;
    
    /*************协议状态  *****************************/
	public static final Integer STATUS_HAS_USE = 1;
	public static final Integer STATUS_NOT_USE = 0;
	/************* 协议状态 *****************************/
    
    /**
     * 协议规则
     * 分成占比
     */
    @ApiModelProperty(value = "协议规则json格式字符串",required = true,example = "协议规则json格式字符串")
    private String protocolRule;

	/**
	 * 分成类型
	 */
	@ApiModelProperty(value = "分成类型",required = true,example = "分成类型: RATIO:比例分成;FIXED:固定金额")
	private DistributeType distributeType;
	@Getter
	@AllArgsConstructor
	public enum DistributeType{
		RATIO("RATIO","比例分成"),
		FIXED("FIXED","固定金额");
		private String code;
		private String name;
	}

	/**
	 * 商品id
	 */
	@ApiModelProperty(value = "商品id",required = true,example = "商品id")
	private String productId;
}