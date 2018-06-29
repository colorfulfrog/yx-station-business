package com.elead.ppm.project.domain.dto;

import java.util.Date;

import com.elead.platform.common.entity.ELObject;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class ELProjectDto extends ELObject {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("父项目id")
	private String parentId;

	@ApiModelProperty("项目编号")
	private String code;

	@ApiModelProperty("项目名称")
	private String name;

	@ApiModelProperty("详细描述")
	private String description;

	@ApiModelProperty("项目类型")
	private String type;

	@ApiModelProperty("项目经理ID")
	private String pmId;

	@ApiModelProperty("项目是否归档")
	private Byte isArchived;

	@ApiModelProperty("项目状态")
	private String state;

	@ApiModelProperty("所属产品线ID")
	private String productId;

	@ApiModelProperty("所属部门")
	private String departmentId;

	@ApiModelProperty("启动时间")
	private Date startTime;

	@ApiModelProperty("完成时间")
	private Date finishTime;

	@ApiModelProperty("项目阶段")
	private Byte phase;

	@ApiModelProperty("预算人民币")
	private Float budget;

	@ApiModelProperty("工作量")
	private Short workload;

	@ApiModelProperty("项目可见范围")
	private Byte visibleRange;
	
	@ApiModelProperty("项目可见范围名称")
	private String visibleRangeName;
}
