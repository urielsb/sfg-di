package guru.springframework.sfgdi.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanPostProcesor implements BeanPostProcessor {

	private static final Logger log = LoggerFactory.getLogger(CustomBeanPostProcesor.class);
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		log.info("## Before initialization bean: " + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		log.info("## After initialization bean: " + beanName);
		return bean;
	}

	
}
