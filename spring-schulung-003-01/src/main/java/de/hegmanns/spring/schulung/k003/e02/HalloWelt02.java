package de.hegmanns.spring.schulung.k003.e02;

public class HalloWelt02 {

	
	private String messageText;
	
	public HalloWelt02(){}
	
	@Security("ROLE_AUTHOR")
	public void setMessageText(String messageText){
		this.messageText = messageText;
	}
	
	@Security("ROLE_AUTHOR")
	public String getMessageText(){
		return this.messageText;
	}
	
	public void sayHallo(){
		System.out.println("HelloWelt02 says '" + this.messageText + "'");
	}
}
