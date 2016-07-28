package de.hegmanns.spring.schulung.aufgabe.hallowelt;

public class LoginProvider {

	public void doLogin(String kdnr, String firstname, String lastname, String password){
		CallContext cc = new CallContext();
		if (cc.getCallUser()!=null){
			cc.doLogout();
			throw new RuntimeException("already logged in");
		}
		if (!kdnr.equals(password)){
			cc.doLogout();
		}else{
			cc.doLogin(kdnr, firstname, lastname);
		}
	}
	
	public void doLogout(String kdnr){
		CallContext cc = new CallContext();
		if (cc.getCallUser()==null){
			throw new RuntimeException("already logged out");
		}
		if (cc.getCallUser().getKdnr().equals(kdnr)){
			cc.doLogout();
		}else{
			throw new RuntimeException("login/out problems");
		}
	}
}
