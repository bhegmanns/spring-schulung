package hegmanns.de.spring.schulung.demo.ohnespring;

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
	
	@Parameters(name= "{0}")
 	public static Iterable<Object[]> data() {
 		return Arrays.asList(new Object[][] { { HalloWelt.class }, {HalloWeltExtended.class}
 		, {HalloWeltKonfiguration.class}, {HalloWeltKonfigurationMitFactory.class}});
     }

 	private Class<?> mainclass;
 	public HalloWeltOhneSpringUnitTest(Class<?> mainclass) {
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
		
		System.setOut(realPrintStream);
		
		testPrintStream.close();
		try {
			byteArrayOutputStream.close();
		} catch (IOException e) {}
	}
	
	@Test
	public void foo() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		Method method = mainclass.getMethod("main", String[].class);
		String[] args = new String[0];
		method.invoke(null, (Object)args);
		String outputtetText = new String(byteArrayOutputStream.toByteArray());
		assertThat(outputtetText, startsWith("Hallo Welt"));
	}
}
