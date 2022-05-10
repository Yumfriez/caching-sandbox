package com.budaev.caching.redis.service.messaging.subscriber;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public class RedisMessageSubscriber implements MessageListener {
	@Override
	public void onMessage(Message message, byte[] pattern) {
		System.out.println(message.toString());
	}
}
