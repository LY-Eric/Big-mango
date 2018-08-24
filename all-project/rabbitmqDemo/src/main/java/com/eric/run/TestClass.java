package com.eric.run;

import com.eric.producer.MessageProducer;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestClass {

    private Logger logger = LoggerFactory.getLogger(TestClass.class);  
  
    private ApplicationContext context = null;  
  
    @Before
    public void setUp() throws Exception {  
        context = new ClassPathXmlApplicationContext("classpath:springmvc.xml");
    }  
  
    @Test  
    public void should_send_a_amq_message() throws Exception {  
        MessageProducer messageProducer = (MessageProducer) context.getBean("messageProducer");
        int a = 20;
        while (a > 0) {
            logger.info("发送时间：" + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss SSS").format(new Date()));
            messageProducer.sendMessage("Hello, I am amq sender num :" + a--);
            try {
                //暂停一下，好让消息消费者去取消息打印出来  
                Thread.sleep(10000);
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }
  
        }  
    }  
}