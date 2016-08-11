package de.hegmanns.spring.schulung.k002;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanNameAware;

public class HalloWelt implements BeanNameAware{
	private static final Logger LOG = Logger.getLogger(HalloWelt.class);

	private String message;
	private String beanName;
	
	public HalloWelt(){}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@PostConstruct
	public void constructHook(){
		LOG.info("HalloWelt-Bean '" + beanName + " instance " + this.hashCode() + " was created");
	}
	
	@PreDestroy
	public void destroyHook(){
		LOG.info("HalloWelt-Bean '" + beanName + " instance " + this.hashCode() + " will be destroyed");
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
}
