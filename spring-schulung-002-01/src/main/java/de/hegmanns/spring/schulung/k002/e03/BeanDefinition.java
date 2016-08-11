package de.hegmanns.spring.schulung.k002.e03;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanDefinition {

	@Bean(name="hallowelt_singleton_default")
	public HalloWelt03 getHalloWeltSingletonDefault(){
		HalloWelt03 halloWelt = new HalloWelt03();
		halloWelt.setMessage("HalloWelt von HalloWelt03.singleton.default");
		return halloWelt;
	}
	
	@Bean(name="hallowelt_singleton_explizit")
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public HalloWelt03 getHalloWeltSingletonExplizit(){
		HalloWelt03 halloWelt = new HalloWelt03();
		halloWelt.setMessage("HalloWelt von HalloWelt03.singleton.explizit");
		return halloWelt;
	}
	
	@Bean(name="hallowelt_prototype")
	@Scope(value = "prototype")
	public HalloWelt03 getHalloWeltPrototype(){
		HalloWelt03 halloWelt = new HalloWelt03();
		halloWelt.setMessage("HalloWelt von HalloWelt03.prototype");
		return halloWelt;
	}
}
