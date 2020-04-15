package guru.springframework.sfgdi.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleDemoBean
		implements InitializingBean, DisposableBean, BeanNameAware, 
		BeanFactoryAware, ApplicationContextAware {
	
	private static final Logger log = LoggerFactory.getLogger(LifeCycleDemoBean.class);

	public LifeCycleDemoBean() {
		log.info("## LifeCycleDemoBean Constructor");
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		log.info("## The application context has been set");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		log.info("## Bean Factory has been set.");
	}

	@Override
	public void setBeanName(String name) {
		log.info("## My bean name is: " + name);
	}

	@Override
	public void destroy() throws Exception {
		log.info("## The life cycle bean has been terminated");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("## The life cycle bean has its properties set.");
	}

}
