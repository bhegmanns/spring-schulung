package de.hegmanns.spring.schulung.k003.e01;

public class HalloWelt {

	public void main(String text){
		System.out.println("" + text);
	}
	
	public void rufeMain(String text){
		main(text);
	}
	
	public void keinMain(String text){
		System.out.println("" + text);
	}
}
