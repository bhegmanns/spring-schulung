package de.ithegmanns.spring.basic.aop.a;

import java.util.Collection;

public class DefaultBootService implements Bootservice {
	
	private BootTypenDAO bootentypendao;
	
	public DefaultBootService(){}
	
	public DefaultBootService(BootTypenDAO boottypendao)
	{
		this.bootentypendao = boottypendao;
	}
	
	

	public BootTypenDAO getBootentypendao() {
		return bootentypendao;
	}


	public void setBootentypendao(BootTypenDAO bootentypendao) {
		this.bootentypendao = bootentypendao;
	}


	public Collection<String> getAlleBootstypen(int anzahl) {
		Collection<String> typen = bootentypendao.getAlleBoottypen();
		
		if (typen.size() < 3)
		{
			throw new RuntimeException("zu wenig Typen");
		}
		return typen;
	}

}
