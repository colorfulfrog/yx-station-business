package com.elead.platform.common.constants;


/**
 * 业务类型（计划[1];任务[2];问题[3]；需求[4];风险[5]）
 * @author liu.tao
 *
 */
public enum BusinessType {

	/**
	 * 计划[1]
	 */
	PLAN(1), 
	/**
	 * 任务[2]
	 */
	TASK(2), 
	/**
	 * 问题[3]
	 */
	ISSUE(3), 
	/**
	 * 需求[4]
	 */
	REQUIREMENT(4), 
	/**
	 * 风险[5]
	 */
	RISK(5),
	/**
	 * 日程[6]
	 */
	AGENDA(6);

	private Integer value;

	BusinessType(Integer value) {
		this.setValue(value);
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
}
