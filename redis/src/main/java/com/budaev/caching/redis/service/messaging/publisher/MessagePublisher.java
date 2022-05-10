package com.budaev.caching.redis.service.messaging.publisher;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
public interface MessagePublisher<T> {

	void publish(T message);
}
