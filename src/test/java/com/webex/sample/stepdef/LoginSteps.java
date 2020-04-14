package com.cloudzen.ets.stepdef;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cloudzen.ets.test.Login;
import com.cloudzen.ets.utils.ConfigFileReader;
import com.cloudzen.ets.utils.DriverManager;
import com.cloudzen.ets.utils.PropertyUtil;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import static com.cloudzen.ets.helper.Constants.*;

public class LoginSteps {

	private static final WebElement title = null;
	private static final WebElement keyAttributesMenu = null;
	private static final Actions actions3 = null;
	private static final WebElement fileUploaded = null;
	String currentUser = "";
	DriverManager dm = new DriverManager();

	@Given("^User enters Credentials to LogIn$")
	public void user_enters_Credentials_to_LogIn(DataTable usercredentials) throws Throwable {
		List<Map<String, String>> list = usercredentials.asMaps(String.class, String.class);
		Login login = new Login();
		if (DriverManager.getDriver() == null) {
			dm.ChromeDriver();
			DriverManager dm = new DriverManager();
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().deleteAllCookies();
			DriverManager.getDriver().get(PropertyUtil.getProperty(APP_URL));
			currentUser = list.get(0).get("Username");
			login.loginToApp(list.get(0).get("Username"), list.get(0).get("Password"));
		} else if (DriverManager.getDriver().getTitle().contains("Login")) {
			currentUser = list.get(0).get("Username");
			login.loginToApp(list.get(0).get("Username"), list.get(0).get("Password"));
		} else{
			DriverManager.getDriver().get(PropertyUtil.getProperty(APP_URL)+"/trade-browser");
		}
	}
}
