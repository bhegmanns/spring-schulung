package hegmanns.de.spring_schulung_002;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.hegmanns.spring.schulung.demo.configuration.TestBean;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/bean-context-01.xml")
public class TestBean01UnitTest {

	@Autowired
	private TestBean testBean;
	
	@Test
	public void einWert(){
		assertThat(testBean.getEinWert(), is("Wert"));
	}
	
	@Test
	public void wertAusContext(){
		assertThat(testBean.getValueFromContext(), is("Hegmanns"));
	}
	
	@Test
	public void beanName(){
		assertThat(testBean.getBeanName(), is("testBean"));
	}
}
