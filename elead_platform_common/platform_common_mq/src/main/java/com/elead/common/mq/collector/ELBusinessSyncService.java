package com.elead.common.mq.collector;

import com.elead.platform.common.constants.KanbanTypeEnum;
import com.elead.platform.common.constants.OptFieldEnum;
import com.elead.platform.common.constants.OptTypeEnum;
import com.elead.platform.common.message.BusinessMessageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wangxz
 * @class_name ELBusinessSyncService
 * @description 业务对象数据同步到mongodb
 * @date 2017/7/6
 */

@Component
public class ELBusinessSyncService {

    @Autowired
    private BusinessCollector businessCollector;

    /**
     * @param id           业务对象id
     * @param content      更新字段内容
     * @param fieldEnum    更新字段类型
     * @param ownerCode    业务对象所属用户id
     * @param code         业务对象code
     * @param typeEnum     操作类型
     * @param businessType 业务类型
     * @return
     * @description 同步业务对象主题
     * @author wangxz
     * @version v1.0
     * @date 2017/6/13
     */
    public void sendMq(String id, String code, String ownerCode, KanbanTypeEnum businessType,
                       OptTypeEnum typeEnum, OptFieldEnum fieldEnum, String content) {

        BusinessMessageDto dto = new BusinessMessageDto();
        dto.setId(id);
        dto.setCardId(id);
        dto.setCode(code);
        dto.setOwnerCode(ownerCode);
        dto.setCardType(businessType.getName());
        dto.setOptField(fieldEnum.getName());
        dto.setOptType(typeEnum.getName());
        dto.setContent(content);
        dto.setToWhere("mongodb");
        businessCollector.sendMsg(dto);
    }

    /**
     * @param id           业务对象id
     * @param businessType 业务类型
     * @param content      更新字段内容
     * @param createBy     创建人id
     * @param ownerId      所属id，项目id或者用户id
     * @param typeEnum     操作类型
     * @param fieldEnum    操作字段名称
     * @return
     * @description 同步主题关联信息
     * @author wangxz
     * @version v1.0
     * @date 2017/6/13
     */
    public void sendRelMq(String id, String ownerId, String createBy, OptFieldEnum fieldEnum, OptTypeEnum typeEnum,
                          KanbanTypeEnum businessType, String content) {

        BusinessMessageDto dto = new BusinessMessageDto();
        dto.setId(id);
        dto.setCardId(ownerId);
        dto.setOwnerCode(ownerId);
        dto.setCardType(businessType.getName());
        dto.setOptType(typeEnum.getName());
        dto.setOptField(fieldEnum.getName());
        dto.setContent(content);
        dto.setToWhere("mongodb");
        businessCollector.sendMsg(dto);
    }
}
