package hegmanns.de.spring.schulung.demo.mitspring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.hegmanns.spring.schulung.demo.hallowelt.mitspring.annotations.HalloWeltApplikationMitSpringAnnotations;
import de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.extended.MessageProvider;
import de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.extended.MessageRenderer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HalloWeltApplikationMitSpringAnnotations.class)
public class HalloWeltMitSpringUnitTest {

	@Autowired
	private MessageRenderer renderer;
	
	
	@Test
	public void foo(){
		renderer.render();
	}
}
