package com.budaev.caching.redis.service.messaging.publisher;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;

import java.io.Serializable;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class RedisStringMessagePublisher implements MessagePublisher<String> {

	private final RedisTemplate<String, Serializable> redisTemplate;
	private final ChannelTopic channelTopic;

	public RedisStringMessagePublisher(RedisTemplate<String, Serializable> redisTemplate, ChannelTopic channelTopic) {
		this.redisTemplate = redisTemplate;
		this.channelTopic = channelTopic;
	}

	@Override
	public void publish(String message) {
		redisTemplate.convertAndSend(channelTopic.getTopic(), message);
	}
}
