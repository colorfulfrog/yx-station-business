package com.elead.ppm.project.domain.entity;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.elead.platform.common.entity.ELTreeItem;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName(value="proj_elproject")
public class ELProject  extends ELTreeItem<ELProject>{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("是否模板(是:1; 否:0)")
	private char isTemplate;
	
	@ApiModelProperty("模板ID")
	private String templateId;

	@ApiModelProperty("项目类型")
	private String type;

	@ApiModelProperty("项目经理ID")
	private String pmId;
	
	@TableField(exist=false)
    @ApiModelProperty("多个项目经理ID的列表")
    private List<String> pmIds;
	
	@ApiModelProperty("项目经理姓名")
	@TableField(exist=false)
	private String pmName;

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

	@ApiModelProperty("在子项目列表中表示是否是第一层子项目")
	@TableField(exist=false)
	private Boolean isFirstLevel;
	
	@ApiModelProperty("项目分类")
	private String projCategory;
	
	@ApiModelProperty("产品-产品分类")
	private String productCategoryId;
	
	@ApiModelProperty("用于却分项目/项目计划(Project/Portfolio)")
	@TableField(exist=false)
	private String contextType;
	
	@ApiModelProperty("状态模板ID")
	private String stateTemplateId;

}
