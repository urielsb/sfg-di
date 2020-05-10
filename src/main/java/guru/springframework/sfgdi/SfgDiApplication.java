package guru.springframework.sfgdi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import guru.springframework.other.OtherController;
import guru.springframework.sfgdi.beans.CountryDataBean;
import guru.springframework.sfgdi.beans.UserDataBean;
import guru.springframework.sfgdi.controllers.I18nController;
import guru.springframework.sfgdi.controllers.MyController;

@SpringBootApplication
@ComponentScan(basePackages = {"guru.springframework.other", "guru.springframework.sfgdi"})
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
		
		OtherController otherController = (OtherController)ctx.getBean("otherController");
		String testMsg = otherController.test();
		log.info(testMsg);
		
		// Properies
		UserDataBean dataBean = (UserDataBean)ctx.getBean(UserDataBean.class);
		log.info(dataBean.toString());
		
		CountryDataBean countryDataBean = (CountryDataBean)ctx.getBean(CountryDataBean.class);
		log.info(countryDataBean.toString());
		
		// Read value from enviroment variables
		String javaHome = (String)ctx.getBean("javaHomeValue");
		log.info(javaHome);
	}

}
