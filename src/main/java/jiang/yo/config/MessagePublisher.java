package jiang.yo.config;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessagePublisher {

    private final RedisTemplate<String, String> redisTemplate;

    public MessagePublisher(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void publishMessage(String channel, String message) {
        redisTemplate.convertAndSend(channel, message);
    }
}
