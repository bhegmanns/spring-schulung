package hegmanns.de.spring.schulung.demo.ohnespring;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.startsWith;

import de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.HalloWelt;
import de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.extended.HalloWeltExtended;
import de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.konfiguration.HalloWeltKonfiguration;
import de.hegmanns.spring.schulung.demo.hallowelt.ohnespring.konfigurationmitfactory.HalloWeltKonfigurationMitFactory;

@RunWith(Parameterized.class)
public class HalloWeltOhneSpringUnitTest {

	private PrintStream realPrintStream = null;
	private PrintStream testPrintStream = null;
	private ByteArrayOutputStream byteArrayOutputStream = null; 
	
	@Parameters(name= "{1}")
 	public static Iterable<Object[]> data() {
 		return Arrays.asList(new Object[][] { {"1",  HalloWelt.class }, {"2", HalloWeltExtended.class}
 		, {"2", HalloWeltKonfiguration.class}, {"3", HalloWeltKonfigurationMitFactory.class}});
     }

 	private Class<?> mainclass;
 	public HalloWeltOhneSpringUnitTest(String name, Class<?> mainclass) {
 		this.mainclass = mainclass;
	}
	
	@Before
	public void beforeAnyTest(){
		realPrintStream = System.out;
		byteArrayOutputStream = new ByteArrayOutputStream();
		testPrintStream = new PrintStream(byteArrayOutputStream);
		System.setOut(testPrintStream);
	}
	
	@After
	public void afterAnyTest(){
		String output = new String(byteArrayOutputStream.toByteArray());
		System.setOut(realPrintStream);
		
		testPrintStream.close();
		try {
			byteArrayOutputStream.close();
		} catch (IOException e) {}
		System.out.println("" + output);
	}
	
	@Test
	public void halloWeltWasPrinted() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Method method = mainclass.getMethod("main", String[].class);
		String[] args = new String[0];
		method.invoke(null, (Object)args);
		String outputtetText = new String(byteArrayOutputStream.toByteArray());
		assertThat(outputtetText, startsWith("Hallo Welt"));
		assertThat(mainclass.getName(), not(containsString("Konfiguration")));
	}
	
	@Test
	public void halloWelt(){
		System.out.println("" + mainclass.getName());
		assertThat(mainclass.getName(),containsString("Konfiguration"));
	}
	
	
}
