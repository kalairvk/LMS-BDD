package com.lms.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
	
	private static Properties properties;
	
	public static String getProperty(String key) {
		if(properties==null) {
			properties = new Properties();
			try {
			    //load a properties file from given path, inside static method
				InputStream is= new FileInputStream("src/test/resources/properties/lms.properties");
			    properties.load(is);
			} 
			catch (IOException ex) {
			    ex.printStackTrace();
			}
		}
		return properties.getProperty(key);
			
	}

	public static String getAppUrl() {
		return getProperty("app.url");
	}
}
