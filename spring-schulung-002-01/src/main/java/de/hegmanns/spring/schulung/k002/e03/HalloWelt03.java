package de.hegmanns.spring.schulung.k002.e03;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanNameAware;

public class HalloWelt03 implements BeanNameAware{
	private static final Logger LOG = Logger.getLogger(HalloWelt03.class);

	private String message;
	private String beanName;
	
	public HalloWelt03(){}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@PostConstruct
	public void nachErzeugung01(){
		LOG.info("Bean der Klasse " + this.getClass().getSimpleName() + " erstellt: " + this.hashCode());
	}
	
	@PostConstruct
	public void nachErzeugung02(){
		LOG.info("Bean mit dem Namen '" + beanName + "' erstellt.");
	}
	
	@PreDestroy
	public void nachAbbau01(){
		LOG.info("Bean der Klasse " + this.getClass().getSimpleName() + " abgebaut: " + this.hashCode());
	}
	
	@PreDestroy
	public void nachAbbau02(){
		LOG.info("Bean mit dem Namen '" + beanName + "' abgebaut");
	}

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
}
