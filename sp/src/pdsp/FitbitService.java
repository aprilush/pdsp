package pdsp;

import java.util.Properties;

public class FitbitService extends Service {

	public FitbitService(Properties props) {
		super(props);
		setAuthenticator(new OAuth10Authenticator(this));
		setAccessor(new FitbitAccessor(this));
		setMapper(new FitbitMapper(this)); // or use a factory for mappers, based on map files
	}
	
	

}
