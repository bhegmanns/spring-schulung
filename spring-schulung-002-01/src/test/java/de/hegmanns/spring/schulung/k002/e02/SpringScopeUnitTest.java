package de.hegmanns.spring.schulung.k002.e02;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;

import de.hegmanns.spring.schulung.k002.e01.HalloWelt01Applikation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/e02/bean_e02.xml")
public class SpringScopeUnitTest {
	private static final String BEAN_SINGLETON_DEFAULT = "hallowelt.singleton.default";
	private static final String BEAN_SINGLETON_EXPLIZIT = "hallowelt.singleton.explizit";
	private static final String BEAN_PROTOTYPE = "hallowelt.prototype";
	
	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void default_ist_singleton(){
		HalloWelt02 halloWeltBean = applicationContext.getBean(BEAN_SINGLETON_DEFAULT, HalloWelt02.class);
		assertThat(halloWeltBean.getMessage(), is("HalloWelt von HalloWelt02.singleton.default"));
		
		halloWeltBean.setMessage(null);
		HalloWelt02 halloWeltBeanZweitesFetch = applicationContext.getBean(BEAN_SINGLETON_DEFAULT, HalloWelt02.class);
		assertThat(halloWeltBeanZweitesFetch.getMessage(), nullValue());
		assertThat(halloWeltBean, sameInstance(halloWeltBeanZweitesFetch));
	}
	
	@Test
	public void explizit_singleton(){
		HalloWelt02 halloWeltBean = applicationContext.getBean(BEAN_SINGLETON_EXPLIZIT, HalloWelt02.class);
		assertThat(halloWeltBean.getMessage(), is("HalloWelt von HalloWelt02.singleton.explizit"));
		
		halloWeltBean.setMessage(null);
		HalloWelt02 halloWeltBeanZweitesFetch = applicationContext.getBean(BEAN_SINGLETON_EXPLIZIT, HalloWelt02.class);
		assertThat(halloWeltBeanZweitesFetch.getMessage(), nullValue());
		assertThat(halloWeltBean, sameInstance(halloWeltBeanZweitesFetch));
	}
	
	@Test
	public void prototype_gibt_eigene_instanz_mit_jedem_fetch(){
		HalloWelt02 halloWeltBean = applicationContext.getBean(BEAN_PROTOTYPE, HalloWelt02.class);
		assertThat(halloWeltBean.getMessage(), is("HalloWelt von HalloWelt02.prototype"));
		
		halloWeltBean.setMessage(null);
		HalloWelt02 halloWeltBeanZweitesFetch = applicationContext.getBean(BEAN_PROTOTYPE, HalloWelt02.class);
		assertThat(halloWeltBeanZweitesFetch.getMessage(), is("HalloWelt von HalloWelt02.prototype"));
		assertThat(halloWeltBean, not(sameInstance(halloWeltBeanZweitesFetch)));
	}
	
	@Test
	public void hallowelt02application_fehlerfrei_ausfuehren() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class<HalloWelt02Applikation> mainClass = HalloWelt02Applikation.class;
		Method method = mainClass.getMethod("main", String[].class);
		String[] args = new String[0];
		method.invoke(null, (Object)args);
	}
}
