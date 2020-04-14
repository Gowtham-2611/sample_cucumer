package com.cloudzen.ets.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

	static Properties props = new Properties();

	public static void loadProperties(String envFilePath) throws IOException {
		InputStream file = new FileInputStream(envFilePath);
		props.load(file);
	}

	public static String getProperty(String propKey) {
		return props.getProperty(propKey);
	}

	public static Properties loadPropertyFromFilePath(String filePath){
		Properties fileProp = new Properties();
		try {
			InputStream file = new FileInputStream(filePath);
			fileProp.load(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileProp;
	}
}
