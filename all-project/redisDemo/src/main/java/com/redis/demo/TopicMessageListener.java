package com.redis.demo;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class TopicMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] bytes) {

        // 请使用valueSerializer
        byte[] body = message.getBody();

        byte[] channel = message.getChannel();

        //设置监听频道
        String topic = new String(channel);

        String itemValue = new String(body);

        System.out.println("频道topic:"+topic);
        System.out.println("过期的键值对的K:"+itemValue);
    }
}


