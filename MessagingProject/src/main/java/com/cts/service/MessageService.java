package com.cts.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MessageService {

	@JmsListener(destination="payment.queue")
	private void notify(String paymentMessage) {
		log.info(paymentMessage);
	}
}
