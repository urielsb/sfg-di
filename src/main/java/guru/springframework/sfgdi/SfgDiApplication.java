package guru.springframework.sfgdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import guru.springframework.sfgdi.controllers.I18nController;
import guru.springframework.sfgdi.controllers.MyController;

@SpringBootApplication
public class SfgDiApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SfgDiApplication.class);

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);
		
		MyController myController = (MyController)ctx.getBean("myController");
		String msg = myController.sayHello();
		log.info(msg);
		
		I18nController i18nController = (I18nController)ctx.getBean("i18nController");
		String i18nMsg = i18nController.sayHello();
		log.info(i18nMsg);
	}

}
