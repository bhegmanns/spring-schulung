package de.hegmanns.spring.schulung.demo.proxyfactorybean;

public class Bean {

	private HalloWeltBean halloWeltBean;
	
	public void doAll(){
		halloWeltBean.sageHallo();
		halloWeltBean.sayHello();
	}
	
	public void doGerman(){
		halloWeltBean.sageHallo();
	}
	
	public void doEnglish(){
		halloWeltBean.sayHello();
	}

	public void setHalloWeltBean(HalloWeltBean halloWeltBean) {
		this.halloWeltBean = halloWeltBean;
	}

	
}
