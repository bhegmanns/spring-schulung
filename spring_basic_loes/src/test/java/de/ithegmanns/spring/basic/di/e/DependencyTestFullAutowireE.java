package de.ithegmanns.spring.basic.di.e;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:de/ithegmanns/spring/basic/di/e/beans.xml")
public class DependencyTestFullAutowireE {

	@Autowired
	private ApplicationContext ctx;
	
	@Autowired
	private RechnungsBuilder rechnungsbuilder;
	
	@Test
	public void vollesAutowiredFindetInstanzen(){
		Assert.assertNotNull(rechnungsbuilder);
		Assert.assertNotNull(rechnungsbuilder.getTarif());
	}
}
