package de.hegmanns.spring.schulung.k002.e04;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;

import de.hegmanns.spring.schulung.k002.e03.HalloWelt03;

public class HalloWelt04 {
	private static final Logger LOG = Logger.getLogger(HalloWelt03.class);

	private String message;
	
	public HalloWelt04(){}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@PostConstruct
	public void nachErzeugung(){
		LOG.info("Bean erzeugt");
	}
	
	@PreDestroy
	public void nachAbbau(){
		LOG.info("Bean wird abgebaut");
	}
}
