package de.hegmanns.spring.schulung.k002.e04;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanDefinition {

	@Bean(name="hallowelt_singleton_default")
	public HalloWelt04 getHalloWeltSingletonDefault(){
		HalloWelt04 halloWelt = new HalloWelt04();
		halloWelt.setMessage("HalloWelt von HalloWelt03.singleton.default");
		return halloWelt;
	}
	
}
