package com.cloudzen.ets.helper;

public class Constants {

	public static String CONFIG_PROPERTY_FILE_PATH;
	
	public static String ENVIRONMENT="env";
	
	public static String APP_URL="app_url";
	
	
	static{
		if(System.getProperty("TestEnv")!=null && !"".equals(System.getProperty("TestEnv"))){
			CONFIG_PROPERTY_FILE_PATH="./configs/"+System.getProperty("TestEnv")+"/environment.properties";
		}
		else if(System.getProperty("configfile.path", "N").equals("N")){
			CONFIG_PROPERTY_FILE_PATH="./configs/dev/environment.properties";
		}
	}
}
