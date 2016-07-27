package hegmanns.de.spring_schulung_002;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.hegmanns.spring.schulung.demo.configuration.Mensch;

/**
 * 
 * ctx.getEnvironment().setActiveProfiles("kind")
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/bean-profile-01.xml")
@ActiveProfiles(profiles="kind")
public class ProfileKindTest {

	@Autowired
	@Qualifier("maennlich")
	private Mensch maennlich;
	

	@Autowired
	@Qualifier("weiblich")
	private Mensch weiblich;
	
	@Test
	public void maennnlich(){
		assertThat(maennlich.getLieblingsgetraenk(), is("Kakao"));
	}
	
	@Test
	public void weiblich(){
		assertThat(weiblich.getBezeichnung(), is("Maedchen"));
	}
}
