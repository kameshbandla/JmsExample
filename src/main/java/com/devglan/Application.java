package com.devglan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.annotation.EnableJms;

import com.devglan.jms.Sender;

@SpringBootApplication
@EnableJms
public class Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		Sender sender = applicationContext.getBean(Sender.class);
		sender.send("Hai");
	}

}