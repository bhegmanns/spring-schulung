package de.hegmanns.spring.schulung.k002.e02;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanDefinition {

	@Bean(name="hallowelt.singleton.default")
	public HalloWelt02 getHalloWeltSingletonDefault(){
		HalloWelt02 halloWelt = new HalloWelt02();
		halloWelt.setMessage("HalloWelt von HalloWelt02.singleton.default");
		return halloWelt;
	}
	
	@Bean(name="hallowelt.singleton.explizit")
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public HalloWelt02 getHalloWeltSingletonExplizit(){
		HalloWelt02 halloWelt = new HalloWelt02();
		halloWelt.setMessage("HalloWelt von HalloWelt02.singleton.explizit");
		return halloWelt;
	}
	
	@Bean(name="hallowelt.prototype")
	@Scope(value = "prototype")
	public HalloWelt02 getHalloWeltPrototype(){
		HalloWelt02 halloWelt = new HalloWelt02();
		halloWelt.setMessage("HalloWelt von HalloWelt02.prototype");
		return halloWelt;
	}
}
