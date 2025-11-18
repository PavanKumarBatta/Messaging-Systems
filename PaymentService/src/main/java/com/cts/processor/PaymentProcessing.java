package com.cts.processor;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class PaymentProcessing {

	private final JmsTemplate jmsTemplate;
	
	@JmsListener(destination="order.queue")
	public void processOrder(String orderMessage) {
		log.info("processing payment for "+orderMessage);
		jmsTemplate.convertAndSend("payment.queue","Payment confirmed for "+orderMessage);
		
	}
}
