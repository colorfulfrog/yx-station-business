package com.elead.platform.common.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.elead.platform.common.constants.DomainConstants;

import lombok.Data;

/**
 * 数据Entity类
 */
@Data
public abstract class ELObject extends BaseObject {

    private static final long serialVersionUID = 1L;

    private String createBy; // 创建者
    @TableField(fill = FieldFill.INSERT)
    private Date createTime; // 创建时间
    private String updateBy; // 更新者
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime; // 更新
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String delFlag; // 删除标记（0：正常；1：删除；2：审核）

    public ELObject() {
        super();
        this.delFlag = DomainConstants.DEL_FLAG_NORMAL;
    }
}
