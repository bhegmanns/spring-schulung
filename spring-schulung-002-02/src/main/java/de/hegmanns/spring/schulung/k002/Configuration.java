package de.hegmanns.spring.schulung.k002;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@org.springframework.context.annotation.Configuration
public class Configuration {
	private static final Logger LOG = Logger.getLogger(Configuration.class);
	
	@Autowired
	private ApplicationContext applicationContext;
	
	public static final String BEAN_SINGLETON = "hallowelt.singleton";
	public static final String BEAN_PROTOTYPE = "hallowelt.prototype";
	public static final String BEAN_REQUEST   = "hallowelt.request";
	public static final String BEAN_SESSION   = "hallowelt.session";
	public static final String BEAN_GLOBALSESSION = "hallowelt.globalsession";

	@Bean(name = BEAN_SINGLETON)
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public HalloWelt singleton(){
		return createHalloWelt(BEAN_SINGLETON);
	}
	
	@Bean(name = BEAN_PROTOTYPE)
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public HalloWelt prototype(){
		return createHalloWelt(BEAN_PROTOTYPE);
	}
	
	@Bean(name = BEAN_REQUEST)
	@Scope("request")
	public HalloWelt request(){
		return createHalloWelt(BEAN_REQUEST);
	}
	
	@Bean(name = BEAN_SESSION)
	@Scope("session")
	public HalloWelt session(){
		return createHalloWelt(BEAN_SESSION);
	}
	
	@Bean(name = BEAN_GLOBALSESSION)
	@Scope("session")
	public HalloWelt globalSession(){
		return createHalloWelt(BEAN_GLOBALSESSION);
	}
	
	private HalloWelt createHalloWelt(String messagetext){
		HalloWelt halloWelt = new HalloWelt();
		halloWelt.setMessage(messagetext);
		return halloWelt;
	}
	
	@PostConstruct
	public void constructHook(){
		LOG.info("Configuration startet");
		LOG.info("" + applicationContext.getBean(BEAN_SINGLETON, HalloWelt.class).getMessage());
		LOG.info("" + applicationContext.getBean(BEAN_PROTOTYPE, HalloWelt.class).getMessage());
		
//		LOG.info("" + applicationContext.getBean(BEAN_REQUEST, HalloWelt.class).getMessage());
//		LOG.info("" + applicationContext.getBean(BEAN_SESSION, HalloWelt.class).getMessage());
//		LOG.info("" + applicationContext.getBean(BEAN_GLOBALSESSION, HalloWelt.class).getMessage());
	}
}
