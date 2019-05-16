package com.lzx.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 描述: 分页数据模型
 *
 * @Auther: lzx
 * @Date: 2019/4/25 13:15
 */
@ApiModel(value = "分页数据模型")
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageDataDTO<T> {

    @ApiModelProperty(value = "数据列表",required = true,example = "数据列表")
    private List<T> content;

    @ApiModelProperty(value = "分页信息",required = true,example = "分页信息")
    private PageableDTO pageable;

    @ApiModelProperty(value = "是否是最后一页",required = true,example = "是否是最后一页")
    private boolean last;

    @ApiModelProperty(value = "总记录数",required = true,example = "总记录数")
    private String totalElements;

    @ApiModelProperty(value = "总页数",required = true,example = "总页数")
    private String totalPages;

    @ApiModelProperty(value = "是否是第一页",required = true,example = "是否是第一页")
    private boolean first;


}
