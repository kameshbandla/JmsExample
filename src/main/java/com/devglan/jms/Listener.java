package com.devglan.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Listener {

	@Value("${jms.queue.destination}")
	String destinationQueue;

	@Autowired
	JmsTemplate jmsTemplate;

	/*
	 * @JmsListener(destination = "inbound.queue") public String
	 * receiveMessage(final Message jsonMessage) throws JMSException { String
	 * messageData = null; System.out.println("Received message " + jsonMessage);
	 * String response = null; if(jsonMessage instanceof TextMessage) { TextMessage
	 * textMessage = (TextMessage)jsonMessage; messageData = textMessage.getText();
	 * Map<String, String> map = new Gson().fromJson(messageData, Map.class);
	 * response = "Hello " + map.get("name"); } return response; }
	 */

	public void receive() {
		String message = (String) jmsTemplate.receiveAndConvert(destinationQueue);
		System.out.println("--------------MESSAGE RECEIVED--------" + message);
	}

}
