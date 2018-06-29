package com.elead.platform.common.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import com.google.common.collect.Maps;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 数据QueryDto类
 */
@Data
public class QueryDto implements Serializable {
    private static final long serialVersionUID = 1L;

//    @ApiModelProperty("编码")
//    private String code;
//
//    @ApiModelProperty("名称")
//    private String name;
//
//    @ApiModelProperty("创建者")
//    private String createBy; // 创建者
//
//    @ApiModelProperty("创建时间")
//    private Date createTime; // 创建时间
//
//    @ApiModelProperty("更新者")
//    private String updateBy; // 更新者
//
//    @ApiModelProperty("更新")
//    private Date updateTime; // 更新
//
//    @ApiModelProperty("删除标记（0：正常；1：删除；2：审核）")
//    private String delFlag = "0"; // 删除标记（0：正常；1：删除；2：审核）

    @ApiModelProperty("页数，默认1")
    private int pageIndex = 1;

    @ApiModelProperty("每页条数，默认10")
    private int pageSize = 10;

    @ApiModelProperty("过滤规则，&filter=id_L_3_EQ_OR_,name_S_张三_EQ_OR_,name_S_李四_EQ_OR_")
    private String filter;

    @ApiModelProperty("排序，默认createTime_desc")
    private String orderBy = "createTime_desc";

    @ApiModelProperty("扩展条件")
    private Map<String, Object> ext = Maps.newHashMap();
}
