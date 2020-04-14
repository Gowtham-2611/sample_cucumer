package com.cloudzen.ets.runner;

import java.io.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.aventstack.extentreports.ExtentReports;
import com.cloudzen.ets.utils.ConfigFileReader;
import com.cloudzen.ets.utils.DriverManager;
import com.cloudzen.ets.utils.PropertyUtil;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import static com.cloudzen.ets.helper.Constants.*;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/ETSStories", glue = {
		"com.cloudzen.ets.stepdef" }, plugin = {
				"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" }, monochrome = true)

public class Runner {
	
	@BeforeClass
	public static void loadEnvProp() throws IOException{
		System.out.println("Loading Properties from--->"+CONFIG_PROPERTY_FILE_PATH);
		PropertyUtil.loadProperties(CONFIG_PROPERTY_FILE_PATH);
		System.out.println("Properties Loaded Successfully.!");
	}
	
	@AfterClass
	public static void writeExtentReport() {
		DriverManager.getDriver().close();
		DriverManager.getDriver().quit();
		Reporter.loadXMLConfig(new File("./configs/Extent-Config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 10" + "64 Bit");
		Reporter.setSystemInfo("Selenium", "3.141.59");
		Reporter.setSystemInfo("Maven", "3.6.3");
		Reporter.setSystemInfo("Java Version", "1.8.0_231");
	}
}