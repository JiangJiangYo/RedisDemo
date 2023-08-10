package jiang.yo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());
        return template;
    }

    /**
     * 创建 多个 订阅者
     *
     * @param subscriber
     * @return
     */
    @Bean
    public MessageListenerAdapter channelOneListenerAdapter(ChannelOneSubscriber subscriber) {
        return new MessageListenerAdapter(subscriber);
    }

    @Bean
    public MessageListenerAdapter channelTwoListenerAdapter(ChannelTwoSubscriber subscriber) {
        return new MessageListenerAdapter(subscriber);
    }

    // ... 更多订阅者 ...

    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(
            RedisConnectionFactory connectionFactory,
            MessageListenerAdapter channelOneListenerAdapter,
            MessageListenerAdapter channelTwoListenerAdapter
            // ... 更多订阅者 ...
    ) {

        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);

        container.addMessageListener(channelOneListenerAdapter, new PatternTopic("channel-one"));
        container.addMessageListener(channelTwoListenerAdapter, new PatternTopic("channel-two"));
        // ... 添加更多频道 ...

        return container;
    }
}

