package com.cloudzen.ets.stepdef;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.DriverAction;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cloudzen.ets.utils.ConfigFileReader;
import com.cloudzen.ets.utils.DriverManager;
import com.cloudzen.ets.utils.PropertyUtil;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class AmortandExecriseScheduleStepDefintion {

	public static Properties xpathProp = PropertyUtil.loadPropertyFromFilePath("./configs/xpath.properties");

	@Then("^user clicks on \"(.*?)\" option$")
	public static void user_click_on_Trade_capture_option(String arg1) {
		try{DriverManager.getDriver().findElement(By.xpath("//*[text()=' TRADE CAPTURE ']")).click();
		Thread.sleep(1000);
		}catch(Exception e){}
		
	}

	@Then("^user select the \"(.*?)\" option$")
	public static void user_selects_the_Advance_option(String arg1) {
		try {
			String xpath = xpathProp.getProperty("emenuOptions").replace("#OPT#",arg1);
			DriverManager.getDriver().findElement(By.xpath(xpath)).click();
			Thread.sleep(3000);
		} catch (Exception e) {
		}

	}

	@Then("^user validate new pop window with \"(.*?)\" title$")
	public static void user_validate_new_pop_window_with_title_is_displayed(String arg1) {
		try {
			Thread.sleep(6000);
			System.out.println(DriverManager.getDriver().getTitle());
		} catch (Exception e) {
		}
	}

	// Product DropDown
	@Then("^user clicks 'Product' DropDown under \"(.*?)\"$")
	public static void clickProduct(String Product) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement DropDown_product = DriverManager.getDriver()
				.findElement(By.xpath("//input[@formcontrolname='product_code']"));
		DropDown_product.click();
	}

	// ST-FIX
	@Then("^user selects 'ST-FIX' from 'Product' dropdown under \"(.*?)\"$")
	public static void user_select_ST_FIX_from_Product_dropdown_under(String arg1) {
		DriverManager.getDriver().findElement(By.xpath("//span[text()=' ST-FIX ']")).click();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	private static final WebElement value = null;

	@Then("^user click \"(.*?)\" option in advance$")
	public static void userclickAddoptioninadvance(String arg1) {
		DriverManager.getDriver().findElement(By.xpath("//div[@class='ag-menu ag-ltr']")).click();
	}

	// AmortSchedule with ST-FIX
	@Then("user click on userinfo \"(.*?)\"$")
	public static void user_click_on_userinfo_icon(String arg1) {
		DriverManager.getDriver()
				.findElement(By
						.xpath("//*[text()='Key Attributes']/parent::*/parent::*/following-sibling::*/child::div/*/button"))
				.click();

	}

	@Then("^user verify \"(.*?)\" screen is displayed$")
	public static void userverifyAmortExcriseschedulescreenisdisplayed(String arg1) {
		String xpath = "//*[normalize-space(text())='AMORT SCHEDULE']";
	}

	@Then("^user click the Amort \"(.*?)\" Button$")
	public static void userclicktheAmortgenerateButton(String arg1) {
		DriverManager.getDriver().findElement(By.xpath("(//*[text()='GENERATE']/parent::*)[1]")).click();
	}

	@And("^user click \"(.*?)\" Execrise schedule$")
	public static void userclickNotificationdateExecriseschedule(String arg1) {
		DriverManager.getDriver()
				.findElement(By
						.xpath("//*[contains(text(),'Notification, days')]//parent::div[@class='ag-filter-toolpanel-header ag-header-cell-label']"))
				.click();

	}

	@And("^user enter some \"(.*?)\"$")
	public static void userentersomevalue(String arg1) {
		DriverManager.getDriver()
				.findElement(By
						.xpath("//*[contains(text(),'Notification, days')]//parent::div[@class='ag-filter-toolpanel-header ag-header-cell-label']"))
				.sendKeys(arg1);
		// value.click();
	}

	@And("^user clicks \"(.*?)\"$")
	public static void userclickscallput(String arg1) {
		DriverManager.getDriver()
				.findElement(By
						.xpath("//*[contains(text(),'Call/Put')]//parent::div[@class='ag-filter-toolpanel-header ag-header-cell-label']"))
				.click();
	}

	@And("^user clicks \"(.*?)\" option")
	public static void userclicksHolderoption(String arg1) {
		DriverManager.getDriver()
				.findElement(By
						.xpath("//*[contains(text(),'Option Holder')]//parent::div[@class='ag-filter-toolpanel-header ag-header-cell-label']"))
				.click();
	}

	@And("^user selects \"(.*?)\" option$")
	public static void userselectsshortlongoption(String arg1) {
		DriverManager.getDriver().findElement(By.xpath("")).click();
	}

	@Then("^user clicks on \"(.*?)\" button$")
	public static void userclicksoncloseoption(String arg1) {
		DriverManager.getDriver()
				.findElement(By
						.xpath("//button[@class='mat-icon-button mat-button-base']/following::mat-icon[text()='close'][2]"))
				.click();
	}

	@Then("^user verify new \"(.*?)\" is populated$")
	public static void userverifynewconfirmationwindowispopulated(String arg1) {

	}

	@And("^user click the \"(.*?)\" button$")
	public static void userclickthesavebutton(String arg1) {
		DriverManager.getDriver().findElement(By.xpath("//*[contains(text(),' YES ')]/parent::button")).click();
	}

	@Then("^user verify \"(.*?)\" Icon button Grey to Orange$")
	public static void userverifyAmortExecrisescheduleIconbuttonGreytoOrange(String arg1) {

	}

	@And("^user selects \"(.*?)\" under emenu button$")
	public static void userselectsPincolumnunderemenubutton(String Pincolumn) {
		String xpath = xpathProp.getProperty("emenuOptions").replace("#OPT#", Pincolumn);
		DriverManager.getDriver().findElement(By.xpath(xpath)).click();
	}

	@And("^user click \"(.*?)\" column")
	public static void userclickPinTorightcolumn(String PinToright) {
		DriverManager.getDriver().findElement(By.xpath("//Span[text() ='Pin Right']")).click();
	}

	@Then("^user click \"(.*?)\" button and click checkbox option$")
	public static void userclickFilterbuttonandclickcheckboxoption(String filter) {
		WebElement DropDown_filter = DriverManager.getDriver().findElement(By.xpath(
				"//div[@class='ets-exercise-toolbar-title']//following::mat-icon[@class='mat-icon notranslate material-icons mat-icon-no-color'][4]"));
		DropDown_filter.click();
	}

	@And("^user selects \"(.*?)\" in filter$")
	public static void userslectedSingleormultiplecheckboxinfilter(String arg) {
		String xpath = "//span[text()='#OPT#']".replace("#OPT#", arg);
		DriverManager.getDriver().findElement(By.xpath(xpath)).click();
		DriverManager.getDriver()
				.findElement(By.xpath(xpathProp.getProperty("panelFilterIcon").replace("#SECTION#", "AMORT SCHEDULE")))
				.click();
		DriverManager.getDriver()
				.findElement(By.xpath(xpathProp.getProperty("panelFilterIcon").replace("#SECTION#", "AMORT SCHEDULE")))
				.click();
		DriverManager.getDriver().findElement(By.xpath(xpath)).click();
		DriverManager.getDriver()
				.findElement(By.xpath(xpathProp.getProperty("panelFilterIcon").replace("#SECTION#", "AMORT SCHEDULE")))
				.click();
	}

	@And("^user verify Filtered option applicable$")
	public static void user_verify_Filtered_option_applicable(String arg) {

	}

	@Then("^user click \"(.*?)\" button$")
	public static void user_click_Dots_button_and_selects_resetgridlayout(String args) {
		WebElement DropDowntogglebutton = DriverManager.getDriver().findElement(By.xpath(
				"//button[@class='mat-menu-trigger mat-icon-button mat-button-base']//following::mat-icon[text()='more_vert'][8]"));
		DropDowntogglebutton.click();
	}

	@And("^selects \"(.*?)\" options$")
	public static void selects_resetgridlayout(String arg1) {
		String xpath = "//*[normalize-space(text())='#OPT#']".replace("#OPT#", arg1);
		DriverManager.getDriver().findElement(By.xpath(xpath)).click();
	}

	@Then("^I click on emenu button of \"(.*?)\" column under \"(.*?)\"$")
	public static void clickOnEMenuButton(String columnHeader, String section) {
		String xpath = xpathProp.getProperty("emenuButton").replace("#SECTION#", section).replace("#COL#",
				columnHeader);
		DriverManager.getDriver().findElement(By.xpath(xpath)).click();
	}

	@Then("^I enter \"(.*?)\" in \"(.*?)\" textbox$")
	public static void typeValueInTextBox(String value, String textBoxLabel) {
		String xpath = xpathProp.getProperty("textBox").replace("#LABEL#", textBoxLabel);
		DriverManager.getDriver().findElement(By.xpath(xpath)).sendKeys(value);
		;
	}

	@And("^The user select \"(.*?)\" from \"(.*?)\" dropdown$")
	public static void selectFromDropdown(String optionValue, String dropdown) {
		String xpath = xpathProp.getProperty("dropdown").replace("#LABEL#", dropdown);
		String valueXpath = "//*[text()='" + optionValue + "']";
		DriverManager.getDriver().findElement(By.xpath(xpath)).click();
		DriverManager.getDriver().findElement(By.xpath(valueXpath)).click();
	}

	@Then("^the user click on Grid icon under \"(.*?)\"$")
	public static void clickOnGridIcon(String section) {
		String xpath = xpathProp.getProperty("panelgridIcon").replace("#SECTION#", section);
		DriverManager.getDriver().findElement(By.xpath(xpath)).click();
	}

	@Then("^user click the Exercise \"(.*?)\" Button$")
	public static void userclicktheExercisegenerateButton(String arg1) {
		DriverManager.getDriver().findElement(By.xpath("(//*[text()='GENERATE']/parent::*)[2]")).click();
	}

	@Then("^the user click on Filter icon under \"(.*?)\"$")
	public static void clickOnFilterIcon(String section) {
		String xpath = xpathProp.getProperty("panelFilterIcon").replace("#SECTION#", section);
		DriverManager.getDriver().findElement(By.xpath(xpath)).click();
	}

	@Then("^the user click on \"(.*?)\" option from Filter$")
	public static void clickOnFilterOption(String option) {
		String xpath = xpathProp.getProperty("panelFilterOption").replace("#OPT#", option);
		DriverManager.getDriver().findElement(By.xpath(xpath)).click();
	}

	@Then("^user enters \"(.*?)\" in \"(.*?)\" textbox under \"(.*?)\"$")
	public static void enterInTextBoxUnderSection(String value, String label, String section) {
		String xpath = xpathProp.getProperty("textBoxunderSection").replace("#SECTION#", section).replace("#LABEL#",
				label);
		DriverManager.getDriver().findElement(By.xpath(xpath)).clear();
		DriverManager.getDriver().findElement(By.xpath(xpath)).sendKeys(value);
	}

	@SuppressWarnings("deprecation")
	@Then("^I validate \"(.*?)\" textbox under \"(.*?)\" should populate \"(.*?)\"$")
	public static void validateValueInTextBox(String label, String section, String value) {
		String xpath = xpathProp.getProperty("textBoxunderSection").replace("#SECTION#", section).replace("#LABEL#",
				label);
		if (label.equals("Start Date") && value.equals("Current Date")) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
			LocalDateTime now = LocalDateTime.now();
			Assert.assertEquals(dtf.format(now),
					DriverManager.getDriver().findElement(By.xpath(xpath)).getAttribute("value"));
		} else
			Assert.assertEquals(value, DriverManager.getDriver().findElement(By.xpath(xpath)).getAttribute("value"));

	}

	@Then("^user select '(.*?)' from \"(.*?)\" textbox under \"(.*?)\"$")
	public static void selectFromTextBox(String value, String field, String section) {
		String xpath = xpathProp.getProperty("textBoxunderSection").replace("#SECTION#", section).replace("#LABEL#",
				field);
		DriverManager.getDriver().findElement(By.xpath(xpath)).click();
		String valueXpath = "//*[normalize-space(text())='#VALUE#']".replace("#VALUE#", value);
		DriverManager.getDriver().findElement(By.xpath(valueXpath)).click();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Then("^User click on \"(.*?)\" button under \"(.*?)\"$")
	public static void clickOnButtonUnderSection(String btnName, String section) {
		String xpath = xpathProp.getProperty("textBoxunderSection").replace("#SECTION#", section).replace("#LABEL#",
				btnName);
		DriverManager.getDriver().findElement(By.xpath(xpath)).click();
	}

	@And("^user click on '(.*?)' in \"(.*?)\" menu under \"(.*?)\"$")
	public static void clickOnDotMenuOption(String menuOption, String menu, String section) {
		try {
			String dotsMenuXpath = xpathProp.getProperty("dotsMenuUnderSection").replace("#SECTION#", section);
			DriverManager.getDriver().findElement(By.xpath(dotsMenuXpath)).click();
			String menuOptXpath = xpathProp.getProperty("emenuOptions").replace("#OPT#", menuOption);
			DriverManager.getDriver().findElement(By.xpath(menuOptXpath)).click();
			Thread.sleep(15000);
		} catch (Exception e) {
		}
	}
}
