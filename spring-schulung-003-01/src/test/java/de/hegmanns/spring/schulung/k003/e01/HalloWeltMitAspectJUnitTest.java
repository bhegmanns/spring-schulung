package de.hegmanns.spring.schulung.k003.e01;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;


import de.hegmanns.test.utils.rules.consoleredirect.ConsoleRedirectRule;

public class HalloWeltMitAspectJUnitTest {

	@Rule
	public ConsoleRedirectRule consoleRedirectRule = ConsoleRedirectRule.instance();
	
	@Test
	public void aspect_works(){
		HalloWelt halloWelt = new HalloWelt();
		halloWelt.main("ein Test");
		assertThat(consoleRedirectRule.getOutput(), containsString("ein Test"));
		assertThat(consoleRedirectRule.getOutput(), containsString("Aspect before"));
		assertThat(consoleRedirectRule.getOutput(), containsString("Aspect after"));
	}
}
