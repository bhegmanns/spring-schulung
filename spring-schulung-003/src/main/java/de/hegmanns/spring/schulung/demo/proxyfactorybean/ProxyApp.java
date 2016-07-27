package de.hegmanns.spring.schulung.demo.proxyfactorybean;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProxyApp {

	public static void main(String [] args){
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:/declarative.xml");
        ctx.refresh();

        Bean bean1 = ctx.getBean("bean1", Bean.class);
        Bean bean2 = ctx.getBean("bean2", Bean.class);

        System.out.println("Bean 1");
        bean1.doAll();
        bean1.doEnglish();
        bean1.doGerman();

        System.out.println("\nBean 2");
        bean2.doAll();
        bean2.doEnglish();
        bean2.doGerman();
	}
}
