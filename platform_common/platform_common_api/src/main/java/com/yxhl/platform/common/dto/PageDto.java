package com.yxhl.platform.common.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.validation.constraints.NotNull;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.yxhl.platform.common.constants.DomainConstants;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 数据PageDto类
 */
@Data
public class PageDto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @ApiModelProperty("页数，默认1")
    private int pageIndex = 1;
    
    @ApiModelProperty("每页条数，默认10")
    private int pageSize = 10;
    
    @ApiModelProperty("排序字段，默认create_time")
    private String orderBy = "create_time";
    
    @ApiModelProperty("排序顺序,倒序")
    private String sortBy = "DESC";
}
