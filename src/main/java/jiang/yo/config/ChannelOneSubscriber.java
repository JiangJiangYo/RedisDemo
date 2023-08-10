package jiang.yo.config;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class ChannelOneSubscriber implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String channel = new String(message.getChannel());
        String messageContent = new String(message.getBody());
        System.out.println("Received message from channel " + channel + ": " + messageContent);
    }
}
