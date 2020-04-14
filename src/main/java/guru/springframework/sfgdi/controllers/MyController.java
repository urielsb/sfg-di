package guru.springframework.sfgdi.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import guru.springframework.sfgdi.services.GreetingService;

@Controller
public class MyController {

	private static final Logger log = LoggerFactory.getLogger(MyController.class);

	private final GreetingService greetingService;
	
	public MyController(GreetingService greetingService) {
		super();
		this.greetingService = greetingService;
	}

	public String sayHello() {
		log.info("sayHello() -->");
		return greetingService.sayGreetings();
	}
}
