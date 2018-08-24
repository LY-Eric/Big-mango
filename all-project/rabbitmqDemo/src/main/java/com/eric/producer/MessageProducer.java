package com.eric.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class MessageProducer {
    private Logger logger = LoggerFactory.getLogger(MessageProducer.class);

    @Resource(name="amqpTemplate")
    private AmqpTemplate amqpTemplate;

    @Resource(name="amqpTemplate2")
    private AmqpTemplate amqpTemplate2;

    public void sendMessage(Object message) throws IOException {  
        logger.info("to send message:{}", message);
        amqpTemplate.convertAndSend("queueTestKey", message);
        amqpTemplate.convertAndSend("queueTestEric", message);
        amqpTemplate2.convertAndSend("liuyang.xxxx.wsdwd", message);


    }  
}