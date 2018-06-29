package com.elead.platform.common.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;

/**
 * 人员Entity类
 *
 * @author zhangwei
 * @version 2017-03-30
 */
@Data
@TableName("sys_eluser")
public class ELUser extends ELItem {

    private static final long serialVersionUID = 1L;

    // 所属组织编码，登录用户中存入orgId，方便UI端使用
    private String orgId;

    // 所属组织名称
    @TableField(exist = false)
    private String orgName;

    // 真实名称(显示名)
    private String displayName;

    // 密码
    private String password;

    // 手机号码
    private String mobile;

    // 电子邮箱
    private String email;

    // 头像
    private String avatar;

    // 用户类型
    private String type;

    // 用户状态
    private String status;

    //是否有效
    private String active;
//    //英文名称
//    private String displayEn;

//    // 模糊查询条件
//    @TableField(exist = false)
//    private String fuzzyQueryCondition;
}
