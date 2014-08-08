package pdsp.auth;

import pdsp.Service;


public abstract class Authenticator {
	
	private Service service;
	
	public Authenticator(Service s) {
		service = s;
	}

	public abstract boolean needsAuthentication();
	
	public abstract boolean isAuthenticated() ;
	
	public abstract boolean authenticate(); // needs some sort of credentials
	
}