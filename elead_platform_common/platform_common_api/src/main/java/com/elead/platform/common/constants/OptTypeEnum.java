package com.elead.platform.common.constants;

/**
 * @author wangxz
 * @enum_name KanbanTypeEnum
 * @description 看板类型枚举
 * @date 2017/6/7
 */
public enum OptTypeEnum {
    ADD("add", 1), UPDATE("update", 2), DELETE("delete", 3);

    private OptTypeEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (OptTypeEnum c : OptTypeEnum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private String name;
    private int index;
}
