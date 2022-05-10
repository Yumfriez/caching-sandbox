package com.budaev.caching.redis.controller;

import com.budaev.caching.redis.service.messaging.publisher.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:ivan_budayeu@epam.com">Ivan Budayeu</a>
 */
@RestController
@RequestMapping(value = "/message")
public class MessageController {

	private final MessagePublisher<String> messagePublisher;

	@Autowired
	public MessageController(MessagePublisher<String> messagePublisher) {
		this.messagePublisher = messagePublisher;
	}

	@GetMapping(value = "/publish")
	public void publish(@RequestParam(value = "message") String message) {
		messagePublisher.publish(message);
	}
}
