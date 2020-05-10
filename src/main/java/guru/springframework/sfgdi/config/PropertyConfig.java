package guru.springframework.sfgdi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

import guru.springframework.sfgdi.beans.CountryDataBean;
import guru.springframework.sfgdi.beans.UserDataBean;

@Configuration
@PropertySources({
	@PropertySource("classpath:user_data.properties"),
	@PropertySource("classpath:country_data.properties")
})
public class PropertyConfig {

	@Value("${user.firstname}")
	private String firstName;
	@Value("${user.lastname}")
	private String lastName;
	
	@Value("${country.name}")
	private String countryName;
	@Value("${country.code}")
	private String countryCode;
	
	@Value("${custom.value}")
	private String customValue;
	
	@Autowired
	private Environment env;
	
	@Bean
	public UserDataBean getUserDataBean() {
		return new UserDataBean(this.firstName, this.lastName);
	}
	
	@Bean
	public CountryDataBean getCountryDataName() {
		return new CountryDataBean(this.countryName, this.countryCode);
	}
	
	@Bean("javaHomeValue")
	public String javaHomeValue() {
		return env.getProperty("JAVA_HOME");
	}
	
	@Bean("customValue")
	public String getCustomValue() {
		return this.customValue;
	}
}
