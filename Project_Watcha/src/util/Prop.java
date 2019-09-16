package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Prop {
	private static Prop instance = new Prop();
	private static Properties dao = null;
	private Prop() {};
	
	public static Prop getInstance() {
		return instance;
	}
	public Properties loadDAOProp() {
		InputStream is = getClass().getResourceAsStream("dao.properties");
		Properties prop = new Properties();
		try {
			prop.load(is);
			is.close();
			return prop;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Properties loadWebProp() {
		InputStream is = getClass().getResourceAsStream("web.properties");
		Properties prop = new Properties();
		try {
			prop.load(is);
			is.close();
			return prop;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
