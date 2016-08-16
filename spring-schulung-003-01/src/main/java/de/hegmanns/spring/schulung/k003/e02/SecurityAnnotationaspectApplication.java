package de.hegmanns.spring.schulung.k003.e02;

public class SecurityAnnotationaspectApplication {

	public static void main(String[] args) {
		HalloWelt02 halloWelt2 = new HalloWelt02();
		
		halloWelt2.setMessageText("hello world");
		System.out.println("HUHU");
		halloWelt2.sayHallo();

	}

}
