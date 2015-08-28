package hm.orz.sumpic.samples.propertiesloadforbean;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.Properties;

public class Settings {

	private String url;
	private String driver;
	private String user;
	private String password;

	public static Settings get() {
		Settings obj = new Settings();
		try {
			Properties prop = new Properties();
			String propFileName = obj.getClass().getSimpleName().toLowerCase()
					+ ".properties";
			prop.load(Settings.class.getResourceAsStream(propFileName));
			setValueBeanByProperties(obj, prop);
		} catch (IOException | IntrospectionException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return obj;
	}

	private static void setValueBeanByProperties(Object bean,
			Properties prop) throws IntrospectionException,
			IllegalAccessException, InvocationTargetException {
		for (Object name : Collections.list(prop.propertyNames())) {
			PropertyDescriptor desc = new PropertyDescriptor(name.toString(),
					bean.getClass());
			desc.getWriteMethod().invoke(bean,
					new Object[] { prop.get(name) });
		}
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
