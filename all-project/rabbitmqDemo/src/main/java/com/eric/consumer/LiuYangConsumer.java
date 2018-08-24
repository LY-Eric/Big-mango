package com.eric.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LiuYangConsumer implements MessageListener {
    private Logger logger = LoggerFactory.getLogger(LiuYangConsumer.class);

    @Override
    public void onMessage(Message message) {
        logger.info("LiuYang receive message------->:{}", message.toString());
        logger.info("消费时间：" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS").format(new Date()));

    }  
}