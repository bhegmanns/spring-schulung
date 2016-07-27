package de.hegmanns.spring.schulung.aufgabe.hallowelt;

public class CallContext {

	private static ThreadLocal<CallUser> callUserThreadLocal = new ThreadLocal<>();
	
	public void doLogin(String kdnr, String firstName, String lastName){
		CallUser callUser = new CallUser(kdnr, firstName, lastName);
		callUserThreadLocal.set(callUser);
	}
	
	public void doLogout(){
		callUserThreadLocal.set(null);
	}
	
	public CallUser getCallUser(){
		return callUserThreadLocal.get();
	}
}
