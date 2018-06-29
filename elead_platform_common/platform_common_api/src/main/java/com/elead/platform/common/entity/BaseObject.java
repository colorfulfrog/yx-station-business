package com.elead.platform.common.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

/**
 * BaseEntity
 *
 * @author wangxz
 * @date 2017/3/22
 */
@Data
public abstract class BaseObject implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private String id;
    
}

