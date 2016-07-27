package hegmanns.de.spring_schulung_002;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.hegmanns.spring.schulung.demo.configuration.TestBean;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/bean-context-properties.xml")
@TestPropertySource("classpath:/test-application.properties")
public class PropertyPlaceholderTestconfigUnitTest {

	@Autowired
	private Environment env;
	
//	@Autowired
	@Resource(name="testBean")
	public TestBean testbean;
	
	@Test
	public void stringValue(){
		assertThat(env.getProperty("stringvalue"), is("TEST"));
	}
	@Test
	public void einWert(){
		assertThat(testbean.getEinWert(), is("TEST"));
	}
}
