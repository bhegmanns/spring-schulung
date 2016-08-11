package de.hegmanns.spring.schulung.k002.e03;

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

import de.hegmanns.spring.schulung.k002.e02.HalloWelt02Applikation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = BeanDefinition.class)
public class SpringScopeUnitTest {
	private static final String BEAN_SINGLETON_DEFAULT = "hallowelt_singleton_default";
	private static final String BEAN_SINGLETON_EXPLIZIT = "hallowelt_singleton_explizit";
	private static final String BEAN_PROTOTYPE = "hallowelt_prototype";
	
	@Autowired
	private ApplicationContext applicationContext;

	@Test
	public void default_ist_singleton(){
		HalloWelt03 halloWeltBean = applicationContext.getBean(BEAN_SINGLETON_DEFAULT, HalloWelt03.class);
		assertThat(halloWeltBean.getMessage(), is("HalloWelt von HalloWelt03.singleton.default"));
		
		halloWeltBean.setMessage(null);
		HalloWelt03 halloWeltBeanZweitesFetch = applicationContext.getBean(BEAN_SINGLETON_DEFAULT, HalloWelt03.class);
		assertThat(halloWeltBeanZweitesFetch.getMessage(), nullValue());
		assertThat(halloWeltBean, sameInstance(halloWeltBeanZweitesFetch));
	}
	
	@Test
	public void explizit_singleton(){
		HalloWelt03 halloWeltBean = applicationContext.getBean(BEAN_SINGLETON_EXPLIZIT, HalloWelt03.class);
		assertThat(halloWeltBean.getMessage(), is("HalloWelt von HalloWelt03.singleton.explizit"));
		
		halloWeltBean.setMessage(null);
		HalloWelt03 halloWeltBeanZweitesFetch = applicationContext.getBean(BEAN_SINGLETON_EXPLIZIT, HalloWelt03.class);
		assertThat(halloWeltBeanZweitesFetch.getMessage(), nullValue());
		assertThat(halloWeltBean, sameInstance(halloWeltBeanZweitesFetch));
	}
	
	@Test
	public void prototype_gibt_eigene_instanz_mit_jedem_fetch(){
		HalloWelt03 halloWeltBean = applicationContext.getBean(BEAN_PROTOTYPE, HalloWelt03.class);
		assertThat(halloWeltBean.getMessage(), is("HalloWelt von HalloWelt03.prototype"));
		
		halloWeltBean.setMessage(null);
		HalloWelt03 halloWeltBeanZweitesFetch = applicationContext.getBean(BEAN_PROTOTYPE, HalloWelt03.class);
		assertThat(halloWeltBeanZweitesFetch.getMessage(), is("HalloWelt von HalloWelt03.prototype"));
		assertThat(halloWeltBean, not(sameInstance(halloWeltBeanZweitesFetch)));
	}
	
	@Test
	public void hallowelt03application_fehlerfrei_ausfuehren() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class<HalloWelt03Applikation> mainClass = HalloWelt03Applikation.class;
		Method method = mainClass.getMethod("main", String[].class);
		String[] args = new String[0];
		method.invoke(null, (Object)args);
	}
}
