package de.hegmanns.spring.schulung.demo.configuration;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;

public class TestBean implements BeanNameAware, ApplicationContextAware{

	private String einWert;
	private String beanName;
	private ApplicationContext applicationContext;
	
	public TestBean(){}

	public String getEinWert() {
		return einWert;
	}

	public void setEinWert(String einWert) {
		this.einWert = einWert;
	}

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	
	public String getValueFromContext(){
		if (applicationContext != null){
			String stringValue = applicationContext.getBean("stringValue", String.class);
			return stringValue;
		}
		
		return null;
	}

	public String getBeanName() {
		return beanName;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.applicationContext = ctx;
		
		if (ctx instanceof GenericApplicationContext){
			((GenericApplicationContext) ctx).registerShutdownHook();
		}
	}
	
	
}
