package pdsp;

import java.util.Properties;

import pdsp.access.Accessor;
import pdsp.auth.Authenticator;
import pdsp.map.Mapper;

public class Service {
	
	private Properties conf;

	private Authenticator auth;
	private Accessor acc;
	private Mapper map;

	public Service(Properties props) {
		conf = props;
	}

	public Properties getConf() {
		return conf;
	}

	public void setConf(Properties conf) {
		this.conf = conf;
	}

	public Authenticator getAuthenticator() {
		return auth;
	}

	public void setAuthenticator(Authenticator authenticator) {
		this.auth = authenticator;
	}

	public Accessor getAccessor() {
		return acc;
	}

	public void setAccessor(Accessor accessor) {
		this.acc = accessor;
	}

	public Mapper getMapper() {
		return map;
	}

	public void setMapper(Mapper mapper) {
		this.map = mapper;
	}
	
}
