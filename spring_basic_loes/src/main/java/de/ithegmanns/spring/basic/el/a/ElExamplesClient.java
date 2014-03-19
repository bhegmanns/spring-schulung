package de.ithegmanns.spring.basic.el.a;

import java.util.HashMap;
import java.util.Map;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class ElExamplesClient {

	/**
	 * @param args arguments
	 */
	public static void main(String[] args) {
		demo1();
		demo2();
		demo3();
	}
	
	private static void demo1() {
		ExpressionParser parser = new SpelExpressionParser();
		// invokes 'getBytes().length'
		Expression exp = parser.parseExpression("'Hello World'.bytes.length");
		int length = (Integer) exp.getValue();
		System.out.println("Length of 'Hello World': " + length);
	}
	
	private static void demo2() {
		Configuration conf = new Configuration();
		conf.setAnzahlBodyguards(8);
		conf.setVeranstalter("Tutego");
		
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("veranstalter");
		String kategorie = (String) exp.getValue(conf);
		System.out.println("Veranstalter: " + kategorie);
	}
	
	private static void demo3() {
		Configuration conf1 = new Configuration();
		conf1.setAnzahlBodyguards(8);
		conf1.setVeranstalter("Tutego");
		Configuration conf2 = new Configuration();
		conf2.setAnzahlBodyguards(5);
		conf2.setVeranstalter("Raiffeisen");
		
		Map<String, Configuration> map = new HashMap<String, Configuration>();
		map.put("key1", conf1);
		map.put("key2", conf2);
		
		ExpressionParser parser = new SpelExpressionParser();
		
		String res1 =
			parser.parseExpression("['key1'].veranstalter").getValue(map,
			String.class);
		
		String res2 =
			parser.parseExpression("['key2'].veranstalter").getValue(map,
			String.class);

		System.out.println("['key1'].veranstalter: " + res1);
		System.out.println("['key2'].veranstalter: " + res2);
	}

}
