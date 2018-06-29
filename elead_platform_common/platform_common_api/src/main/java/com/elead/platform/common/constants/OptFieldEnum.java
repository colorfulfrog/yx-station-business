package com.elead.platform.common.constants;

/**
 * @author wangxz
 * @enum_name KanbanTypeEnum
 * @description 看板类型枚举
 * @date 2017/6/7
 */
public enum OptFieldEnum {
    //标题/名称
    TITLE("title", 1),
    //关注人id
    WATCHERID("watcherid", 2),
    //负责人id
    MEMBERID("memberid", 3),
    //标签
    LABEL("label", 4),
    //检查项
    CHECKITEM("checkitem", 5),
    //工作量
    ESVALUETIME("esvaluetime", 6),
    //截止时间
    ENDTIME("endtime", 7),
    //描述
    DESCRIPTION("desc", 8),
    //删除标记
    DELFLAG("del_flag", 9),
    //评论
    DISCUSS("discuss", 10),
    //附件
    ATTACHMENT("attachment", 11),
    //项目id
    PROJECTID("projectid",12);

    private OptFieldEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (OptFieldEnum c : OptFieldEnum.values()) {
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
