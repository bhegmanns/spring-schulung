package de.ithegmanns.spring.basic.di.a;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:de/ithegmanns/spring/basic/di/a/beans_autowired.xml")
public class DependencyTestMitIntegration {

	@Autowired
	private ApplicationContext ctx;
	
	@Autowired
	private RechnungsBuilder rechnungsBuilder;
	
	@Test
	public void testMal(){
		System.out.println("Klasse = " + rechnungsBuilder.getClass().getName());
		Assert.assertNotNull(rechnungsBuilder);
	}
}
