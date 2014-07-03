/**
 * 
 */
package pdsp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


/**
 * @author laura
 *
 */
public class PDSP {
	
	private Properties config;
	private Map<String, Service> services; 
	
	public PDSP() {
		this("conf/pdsp.properties");
	}
	
	public PDSP(String configFile) {
		config = new Properties();
		try {
			config.load(new FileInputStream(configFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		services = new HashMap<String, Service>();
		init();
	}

	private void init() {
		for (Object key : config.keySet()) {
			String k = (String)key;
			if (k.startsWith("service.")) {
				try {
					Class s = Class.forName(config.getProperty(k));
					if (Service.class.isAssignableFrom(s)) {
						services.put(k, (Service)s.newInstance());
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(services);
	}
	
	public void run() {
		
	}

	public static void main(String[] args) {
		Map<String, String> argMap = parseArguments(args);
		PDSP pdsp = new PDSP(argMap.get("configFile"));
		pdsp.run();	
	}

	private static Map<String, String> parseArguments(String[] args) {
		Map<String, String> argMap = new HashMap<String, String>();
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-f") && (i+1)<args.length) {
				String configFile = args[i+1];
				argMap.put("configFile", configFile);
			}
		}
		return argMap;
	}
}
