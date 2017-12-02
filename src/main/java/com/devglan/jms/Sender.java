/**
 * 
 */
package com.devglan.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author nisum
 *
 */
@Component
public class Sender {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Value("${jms.queue.destination}")
	private String destinationQueue;
	
	public void send(String message) {
		message = "This is sample message";
		jmsTemplate.convertAndSend(destinationQueue, message);
	}

}
