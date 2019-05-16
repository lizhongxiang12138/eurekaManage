package com.lzx.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 描述:
 *
 * @Auther: lzx
 * @Date: 2019/4/25 13:31
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "分页信息")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PageableDTO {

    @ApiModelProperty(value = "每页记录数",required = true,example = "每页记录数")
    private String  pageSize;
    @ApiModelProperty(value = "页码，从0开始",required = true,example = "页码，从0开始")
    private String pageNumber;

}
