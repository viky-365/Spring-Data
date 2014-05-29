package com.spike;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spike.msg.MessageService;

@Component
public class HelloWorld {

	@Autowired
	private MessageService messageService;

	public String getMessage() {
		return "Hi, " + messageService.getName(2);
	}
}
