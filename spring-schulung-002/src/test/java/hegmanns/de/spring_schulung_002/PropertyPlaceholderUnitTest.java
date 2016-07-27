package hegmanns.de.spring_schulung_002;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.hegmanns.spring.schulung.demo.configuration.TestBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/bean-context-properties.xml")
public class PropertyPlaceholderUnitTest {

//	@Autowired
	@Resource(name="testBean")
	public TestBean testbean;
	
	@Test
	public void foo(){
		assertThat(testbean.getEinWert(), is("TESTBeanWert"));
	}
}
