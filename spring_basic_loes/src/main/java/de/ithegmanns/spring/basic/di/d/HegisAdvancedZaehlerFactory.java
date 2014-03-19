package de.ithegmanns.spring.basic.di.d;

import org.springframework.beans.factory.FactoryBean;

public class HegisAdvancedZaehlerFactory implements FactoryBean<SimpleZaehler>{

	public SimpleZaehler getObject() throws Exception {
		return new SimpleZaehler();
	}

	public Class<?> getObjectType() {
		return SimpleZaehler.class;
	}

	public boolean isSingleton() {
		return false;
	}

}
