package com.yxhl.platform.common.entity;

import lombok.Data;

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

	public ELItem() {
		super();
	}

}
