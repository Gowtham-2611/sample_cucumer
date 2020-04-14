package com.cloudzen.ets.test;

import static com.cloudzen.ets.helper.Constants.APP_URL;
import static com.cloudzen.ets.helper.Constants.ENVIRONMENT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cloudzen.ets.utils.DriverManager;
import com.cloudzen.ets.utils.PropertyUtil;

public class Login {
	
	public void loginToApp(String userName, String password) throws InterruptedException {
		if (PropertyUtil.getProperty(ENVIRONMENT).equalsIgnoreCase("dev")) {
			Thread.sleep(5000);
			DriverManager.getDriver().findElement(By.xpath("//input[@formcontrolname='userName']")).clear();
			DriverManager.getDriver().findElement(By.xpath("//input[@formcontrolname='userName']")).sendKeys(userName);
			DriverManager.getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).clear();
			DriverManager.getDriver().findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(password);
			DriverManager.getDriver().findElement(By.xpath("//span[text()='LOGIN']")).click();
			Thread.sleep(30000);
		} else if (PropertyUtil.getProperty(ENVIRONMENT).equalsIgnoreCase("qa")) {
			if (DriverManager.getDriver().findElement(By.xpath("//button[@id='details-button']")).isDisplayed()) {
				DriverManager.getDriver().findElement(By.xpath("//button[@id='details-button']")).click();
				DriverManager.getDriver().findElement(By.id("proceed-link")).click();
			}
			DriverManager.getDriver().findElement(By.id("userNameInput")).clear();
			DriverManager.getDriver().findElement(By.id("userNameInput")).sendKeys(userName);
			DriverManager.getDriver().findElement(By.id("passwordInput")).clear();
			DriverManager.getDriver().findElement(By.id("passwordInput")).sendKeys(password);
			DriverManager.getDriver().findElement(By.xpath("//span[text()='Sign in']")).click();
			Thread.sleep(5000);
		}
		try {
			String Title = DriverManager.getDriver().getTitle(); // trade
																	// browser
			if (Title.equalsIgnoreCase("Trade Browser")) {
				System.out.println("login success");
			} else if (DriverManager.getDriver().getTitle().contains("Login")) {
				WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'login')]")));
				WebElement errormsg = DriverManager.getDriver()
						.findElement(By.xpath("//span[contains(text(),'This is your login attempt')]"));
				if (errormsg.isDisplayed()) {
					System.out.println("dshgfj");
				}
			} else if (DriverManager.getDriver().findElement(By.xpath("///div[@class='ets-login--error']/span"))
					.isDisplayed()) {
				System.out.println(" login failed ");
			} else {
				System.out.println("User is locked ");
			}
		} catch (Exception e) {
			// TODO: handle exception
			WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'login')]")));
			WebElement errormessage = DriverManager.getDriver()
					.findElement(By.xpath("//div[@class='ets-login--error']/span"));
			System.out.println("login failed " + errormessage.getText());
		}
	}

	public void logout() {
		WebElement DropDownicon = DriverManager.getDriver().findElement(By.xpath(
				"//div[@class='ets-shell--toolbar-logo']//following::mat-icon[@class='ets-shell--toolbar-avatar mat-icon notranslate material-icons mat-icon-no-color']"));
		DropDownicon.click();

	}

}
