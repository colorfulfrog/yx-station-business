package com.elead.common.mq;
import org.springframework.amqp.core.Message;

/**
 * @author wangxz
 * @class_name BaseMessageReceiver
 * @description 接收mq消息
 * @date 2017/7/6
 */

public abstract class BaseMessageReceiver {

    public abstract void receiver(Message msg);
}