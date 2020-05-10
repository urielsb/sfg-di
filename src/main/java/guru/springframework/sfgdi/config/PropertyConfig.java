package guru.springframework.sfgdi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import guru.springframework.sfgdi.beans.UserDataBean;

@Configuration
@PropertySource("classpath:user_data.properties")
public class PropertyConfig {

	@Value("${user.firstname}")
	private String firstName;
	@Value("${user.lastname}")
	private String lastName;
	@Autowired
	private Environment env;
	
	@Bean
	public UserDataBean getUserDataBean() {
		return new UserDataBean(this.firstName, this.lastName);
	}
	
	@Bean("javaHomeValue")
	public String javaHomeValue() {
		return env.getProperty("JAVA_HOME");
	}
}
