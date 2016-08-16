package de.hegmanns.spring.schulung.k003.e02;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Rule;
import org.junit.Test;

import de.hegmanns.test.utils.rules.consoleredirect.ConsoleRedirectRule;

public class SecurityFieldAccessUnitTest {

	@Rule
	public ConsoleRedirectRule consoleRedirectRule = ConsoleRedirectRule.instance();
	
	@Test
	public void foo(){
		HalloWelt02 halloWelt02 = new HalloWelt02();
		halloWelt02.setMessageText("Hallo Welt");
		
		halloWelt02.sayHallo();
		
		assertThat(consoleRedirectRule.getOutput(), containsString("Rolle"));
		assertThat(consoleRedirectRule.getOutput(), containsString("benoetigt"));
	}
}
