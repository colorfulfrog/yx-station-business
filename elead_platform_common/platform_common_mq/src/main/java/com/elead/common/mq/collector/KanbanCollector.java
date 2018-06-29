package com.elead.common.mq.collector;

import com.elead.common.mq.KanbanMessageSender;
import com.elead.platform.common.message.KanbanMessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wangxz
 * @class_name KanbanCollector
 * @description 看板信息同步类
 * @date 2017/6/7
 */
@Component
public class KanbanCollector {

    private static final Logger LOG = LoggerFactory.getLogger(KanbanCollector.class);

    @Autowired
    private KanbanMessageSender messageSender;

    public void sendMsg(KanbanMessageDto messageDto) {
        /**
         * 进入rabbitmq
         */
        LOG.info("进入rabbitmq" + messageDto.toString());
        try {
            messageSender.send(messageDto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
