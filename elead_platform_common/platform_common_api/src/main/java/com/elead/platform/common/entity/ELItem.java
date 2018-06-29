package com.elead.platform.common.entity;

import java.util.Map;

import com.google.common.collect.Maps;
import lombok.Data;

import com.baomidou.mybatisplus.annotations.TableField;

import javax.validation.constraints.NotNull;

/**
 * 业务对象基础类：ELItem
 */
@Data
public class ELItem extends ELObject {
	private static final long serialVersionUID = 1L;

	/**
	 * 编码
	 */
	private String code;

	/**
	 * 名称
	 */

	private String name;

	/**
	 * 描述
	 */
	private String description;


	@TableField(exist = false)
	//private Map<String, Object> extAttr;
	private Map<String, Object> flexAttrs = Maps.newHashMap();

	public ELItem() {
		super();
	}

}
