package de.hegmanns.spring.schulung.k002.e01;

import static org.hamcrest.MatcherAssert.assertThat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/e01/bean_e01.xml")
public class SpringScopeUnitTest {
	private static final String BEAN_SINGLETON_DEFAULT = "hallowelt_singleton_default";
	private static final String BEAN_SINGLETON_EXPLIZIT = "hallowelt_singleton_explizit";
	private static final String BEAN_PROTOTYPE = "hallowelt_prototype";
	
	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void default_ist_singleton(){
		HalloWelt01 halloWeltBean = applicationContext.getBean(BEAN_SINGLETON_DEFAULT, HalloWelt01.class);
		assertThat(halloWeltBean.getMessage(), is("HalloWelt von HalloWelt01.singleton.default"));
		
		halloWeltBean.setMessage(null);
		HalloWelt01 halloWeltBeanZweitesFetch = applicationContext.getBean(BEAN_SINGLETON_DEFAULT, HalloWelt01.class);
		assertThat(halloWeltBeanZweitesFetch.getMessage(), nullValue());
		assertThat(halloWeltBean, sameInstance(halloWeltBeanZweitesFetch));
	}
	
	@Test
	public void explizit_singleton(){
		HalloWelt01 halloWeltBean = applicationContext.getBean(BEAN_SINGLETON_EXPLIZIT, HalloWelt01.class);
		assertThat(halloWeltBean.getMessage(), is("HalloWelt von HalloWelt01.singleton.explizit"));
		
		halloWeltBean.setMessage(null);
		HalloWelt01 halloWeltBeanZweitesFetch = applicationContext.getBean(BEAN_SINGLETON_EXPLIZIT, HalloWelt01.class);
		assertThat(halloWeltBeanZweitesFetch.getMessage(), nullValue());
		assertThat(halloWeltBean, sameInstance(halloWeltBeanZweitesFetch));
	}
	
	@Test
	public void prototype_gibt_eigene_instanz_mit_jedem_fetch(){
		HalloWelt01 halloWeltBean = applicationContext.getBean(BEAN_PROTOTYPE, HalloWelt01.class);
		assertThat(halloWeltBean.getMessage(), is("HalloWelt von HalloWelt01.prototype"));
		
		halloWeltBean.setMessage(null);
		HalloWelt01 halloWeltBeanZweitesFetch = applicationContext.getBean(BEAN_PROTOTYPE, HalloWelt01.class);
		assertThat(halloWeltBeanZweitesFetch.getMessage(), is("HalloWelt von HalloWelt01.prototype"));
		assertThat(halloWeltBean, not(sameInstance(halloWeltBeanZweitesFetch)));
	}
	
	@Test
	public void hallowelt01application_fehlerfrei_ausfuehren() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class<HalloWelt01Applikation> mainClass = HalloWelt01Applikation.class;
		Method method = mainClass.getMethod("main", String[].class);
		String[] args = new String[0];
		method.invoke(null, (Object)args);
	}
}
