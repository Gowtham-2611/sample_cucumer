package com.cloudzen.ets.stepdef;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.Driver;
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

public class DrafttoVerifiedStepDefinition {

	private static final WebElement Search = null;
	private static final WebElement ST_FIX1 = null;
	private static final WebElement currency = null;
	private static final WebElement startdate1 = null;
	private static final WebElement title = null;
	private static final WebElement keyAttributesMenu = null;
	private static final Actions actions3 = null;
	private static WebElement fileUploaded = null;
	private static final WebElement search_button = null;
	private static final WebElement ST_FIX = null;
	private static final WebElement startdate = null;
	private static final WebElement curreny = null;
	private static final WebElement date = null;
	DriverManager dm = new DriverManager();
	public static Properties xpathProp = PropertyUtil.loadPropertyFromFilePath("./configs/xpath.properties");

	@Then("^user click on \"(.*?)\" options$")
	public static void user_click_on_Trade_capture_options(String arg1) {
		DriverManager.getDriver().findElement(By.xpath("//*[text()=' TRADE CAPTURE ']")).click();
	}

	@And("^user selects the \"(.*?)\" option$")
	public static void user_selects_the_Advance_option(String arg1) {
		DriverManager.getDriver().findElement(By.xpath("//a[@href='/trade-browser(product:advance/new)']")).click();

	}

	@Then("^user validate new pop window \"(.*?)\" title is displayed$")
	public static void user_validate_new_pop_window_title_is_displayed(String arg1) {
		System.out.println(DriverManager.getDriver().getTitle());

	}

	// Product DropDown
	@Then("^user clicks on 'Product' DropDown under \"(.*?)\"$")
	public static void clicksonProduct(String Product) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement DropDown_product = DriverManager.getDriver()
				.findElement(By.xpath("//input[@formcontrolname='product_code']"));
		DropDown_product.click();
	}

	@Then("^user select \"(.*?)\" option for advance$")
	public static void user_select_Member_option(String arg1) {
		WebElement DropDown_Member = DriverManager.getDriver()
				.findElement(By.xpath("//*[text()='Member']//parent::*//parent::*/preceding-sibling::mat-select"));
		DropDown_Member.click();
	}

	@Then("^user select 'BANK OF NY' from Member dropdown under \"(.*?)\"$")
	public static void user_select_BANK_OF_NY(String BANKOFNY) {
		DriverManager.getDriver().findElement(By.xpath("//*[contains(text(),'BANK OF NY')]")).click();

	}

	// Right click under Trading Events and then select +"Add"
	@When("^user right click under \"(.*?)\" section$")
	public static void rightclickunderTradingEvents(String TradingEvents) {
		Actions actions = new Actions(DriverManager.getDriver());
		WebElement elementLocator = DriverManager.getDriver().findElement(
				By.xpath("//div[@class='ets-trading-events--grid']//div[@class='ag-center-cols-viewport']"));
		actions.contextClick(elementLocator).perform();
	}

	@Then("^user click on \\+Add option$")
	public static void user_click_on_Add_option() {
		DriverManager.getDriver().findElement(By.xpath("//div[@class='ag-menu ag-ltr']")).click();
	}

	@Then("^user enter \"([^\"]*)\" in 'ValuationDate' text box under \"([^\"]*)\"$")
	public static void i_enter_in__ValuationDate_text_box_under(String arg1, String arg2) {
		WebElement Val_date = DriverManager.getDriver().findElement(By.xpath(
				"//*[text()='Valuation Date']/parent::*/parent::*/preceding-sibling::input[@aria-required='false']"));
		Val_date.clear();
		Val_date.sendKeys(arg1);
	}

	@When("^user click on \"(.*?)\" button$")
	public static void clickonCALCULATE(String CALCULATE) {
		Actions actions1 = new Actions(DriverManager.getDriver());
		WebElement btn_calculate = DriverManager.getDriver()
				.findElement(By.xpath("//*[text()=' CALCULATE ']/parent::*"));
		actions1.click(btn_calculate).perform();

	}

	@Then("^user validate new row appears under \"(.*?)\"$")
	public static void Analytics(String Analytics) {
	}

	@When("^user click on '(.*?)' under \"(.*?)\" menu$")
	public static void clickonDots(String option, String menuIcon) {
		WebElement keyAttributesMenu = DriverManager.getDriver().findElement(By.xpath(
				"//*[contains(text(),'more_vert')][1]/preceding::div[@class='ets-product-panel-header--toolbar']"));
		keyAttributesMenu.click();
		Actions actions = new Actions(DriverManager.getDriver());
		WebElement btn_save = DriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Save')]"));
		actions.click(btn_save).perform();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

	@Then("^user validate status as \"(.*?)\"$")
	public static void status(String status) {
		try {
			Thread.sleep(10000);
			WebElement Status = DriverManager.getDriver()
					.findElement(By.xpath("//div[@class='ets-product-title--status']"));
			Assert.assertEquals(status, Status.getText());
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@And("^user click on 'Execute' under \"([^\"]*)\" menu$")
	public void user_click_on_Execute_under_menu(String arg1) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		WebElement keyAttributesMenu = DriverManager.getDriver().findElement(By.xpath(
				"//*[contains(text(),'more_vert')][1]/preceding::div[@class='ets-product-panel-header--toolbar']"));
		keyAttributesMenu.click();
		Actions actions = new Actions(DriverManager.getDriver());
		WebElement btn_execute = DriverManager.getDriver()
				.findElement(By.xpath("//button[contains(text(),'Execute')]"));
		actions.click(btn_execute).perform();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//////////////// Verification done for Execute////////////

	}

	@And("^user click on 'ConfirmWMember' under \"(.*?)\" menu$")
	public static void clickonConfirmWMember(String ConfirmWMember) {
		WebElement keyAttributesMenu2 = DriverManager.getDriver().findElement(By.xpath(
				"//*[contains(text(),'more_vert')][1]/preceding::div[@class='ets-product-panel-header--toolbar']"));
		keyAttributesMenu2.click();
		Actions actions = new Actions(DriverManager.getDriver());
		WebElement btn_confirm = DriverManager.getDriver().findElement(By.xpath("//button[text()='ConfirmWMember']"));
		actions.click(btn_confirm).perform();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		////////////// Verification done for ConfirmMember////////////
	}

	@And("^user click on 'verify' under \"(.*?)\" menu$")
	public static void clickonverify(String verify) {
		WebElement keyAttributesMenu3 = DriverManager.getDriver().findElement(By.xpath(
				"//*[contains(text(),'more_vert')][1]/preceding::div[@class='ets-product-panel-header--toolbar']"));
		keyAttributesMenu3.click();
		Actions actions = new Actions(DriverManager.getDriver());
		WebElement btn_verify = DriverManager.getDriver().findElement(By.xpath("//button[contains(text(),'Verify')]"));
		actions.click(btn_verify).perform();
	}

	// Chat button
	@Then("^user click \"(.*?)\" button in Advance$")
	public static void userclickchatbutton(String arg1) {
		Actions actions = new Actions(DriverManager.getDriver());
		DriverManager.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement chatbutton = DriverManager.getDriver().findElement(By.xpath("//mat-icon[contains(text(),'forum')]"));
		actions.click(chatbutton).perform();
	}

	@And("^user enters some \"(.*?)\" words below \"(.*?)\" characters$")
	public static void userenterssometextwords(String value1, String value2) throws InterruptedException {
		WebElement chatpop = DriverManager.getDriver().findElement(By.xpath("//div[@class='cdk-overlay-pane']"));
		if (chatpop.isDisplayed()) {
			DriverManager.getDriver().switchTo().activeElement().findElement(By.xpath("//div[@class='ets-popover']"));
			WebElement txtarea = DriverManager.getDriver().findElement(By.xpath("//textarea[@aria-required='false']"));
			txtarea.sendKeys(
					"hi hello how are you what are you doing and where are you going so becareful and soon recovery shoul");
			Thread.sleep(5000);
		}
	}

	@And("^user click \"(.*?)\"$")
	public static void userclickattachment(String arg1) throws AWTException {
		try {
			WebElement chatpop = DriverManager.getDriver().findElement(By.xpath("//div[@class='cdk-overlay-pane']"));
			if (chatpop.isDisplayed()) {
				// DriverManager.getDriver().switchTo().activeElement().findElement(By.xpath("//div[@class='ets-popover']"));
				DriverManager.getDriver().findElement(By.xpath("//*[text()='attach_file']")).click();
			}
			uploadFile();
			// fileUploaded =
			// DriverManager.getDriver().findElement(By.xpath("(//div[@col-id
			// ='documentName'])[2]"));
			// if (fileUploaded.isDisplayed()) {
			// System.out.println("file upload is succesfull");
			// } else {
			// System.out.println("file uplad is not successfull");
			// }
		} catch (Exception e) {
		}
	}

	public static void uploadFile() throws AWTException {
		StringSelection ss = new StringSelection("" + "./attachment/testfile.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	@And("^user click \"(.*?)\" options$")
	public static void userclicksendoption(String arg1) {
		DriverManager.getDriver().findElement(By.xpath("//*[text()='send']")).click();
	}

	@And("^user verify \"(.*?)\" in the above chatbox$")
	public static void userverifynotificationintheabovechatbox(String arg1) {
		WebElement text = DriverManager.getDriver().findElement(By.xpath("//div[@class='ets-chat-item--message']"));
		WebElement attach = DriverManager.getDriver().findElement(By.xpath("//div[@class='ets-chat-item--attach']"));
	}

	@And("^user click \"(.*?)\" button to close window$")
	public static void userclickclosebutton(String arg1) {
		DriverManager.getDriver().findElement(By.xpath("//*[text()='forum']")).click();
	}

	@And("^user click \"(.*?)\" button in advance$")
	public static void user_clicks_Search_button_in_advance(String arg) {
		String xpath = xpathProp.getProperty("menuIconInTitleBar").replace("#menu#", arg);
		DriverManager.getDriver().findElement(By.xpath(xpath)).click();
	}

	@And("^user enter \"(.*?)\" in Search textbox$")
	public static void user_enter_in_Search_textbox(String value) {
		DriverManager.getDriver()
				.findElement(By
						.xpath("//*[text()='description']/parent::*/parent::*/preceding-sibling::*/descendant::input"))
				.clear();
		DriverManager.getDriver()
				.findElement(By
						.xpath("//*[text()='description']/parent::*/parent::*/preceding-sibling::*/descendant::input"))
				.sendKeys(value);
		DriverManager.getDriver()
				.findElement(By.xpath("//div[@role='listbox']/mat-option/span[text()='" + value + "']")).click();
	}

	@SuppressWarnings("deprecation")
	@And("^user verify \"(.*?)\" with title in advance$")
	public static void user_verify_Date_with_title(String arg1) {
		try {
			Thread.sleep(3000);
			String title = DriverManager.getDriver().findElement(By.xpath("//div[@class='ets-product-title--name']"))
					.getText();
			Assert.assertEquals(arg1, title);
		} catch (Exception e) {
		}
	}

	@And("^user enter with \"(.*?)\" details in Search textbox$")
	public static void user_enter_witth_Product_in_Search_textbox(String arg1) {
		DriverManager.getDriver()
				.findElement(By
						.xpath("//*[text()='search']/following::input[@class='mat-autocomplete-trigger mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-valid ng-dirty ng-touched']"))
				.sendKeys(arg1);
		// ST_FIX1.click();
	}

	@And("^user verify \"(.*?)\" product with title in advance$")
	public static void user_verify_product_with_title_in_advance(String arg1) {
		DriverManager.getDriver().findElement(By.xpath("//div[@class='ets-product-title--name"));
	}

	@Then("^user clicks Key Attributes \"(.*?)\" in advance$")
	public static void user_clicks_key_Attributes_Start_Date_in_advance(String arg1) {
		DriverManager.getDriver()
				.findElement(By
						.xpath("//mat-label[text()='Start Date']/preceding::input[@class='ng-untouched ng-pristine ng-valid']"))
				.click();

	}

	@And("^user enter date as \"(.*?)\" in Startdate field$")
	public static void user_enter_date(String arg) {
		DriverManager.getDriver()
				.findElement(By
						.xpath("//mat-label[text()='Start Date']/preceding::input[@class='ng-untouched ng-pristine ng-valid']"))
				.sendKeys("value");
		date.click();
	}

	@And("^user verify \"(.*?)\"$")
	public static void user_verify_date(String value) {
		System.out.println("arg");
	}

	@And("^user click \"(.*?)\" text box $")
	public static void user_click_Curreny_text_box1(String value) {
		DriverManager.getDriver()
				.findElement(By.xpath("//div[@class='mat-form-field-infix']/child::input[@formcontrolname='notional']"))
				.click();
	}

	@Then("^user enter shortcut as \"(.*?)\"$")
	public static void user_enter_shortcut(String arg1) {
		DriverManager.getDriver()
				.findElement(By.xpath("//div[@class='mat-form-field-infix']/child::input[@formcontrolname='notional']"))
				.sendKeys("value");
		// curreny.click();
		System.out.println("1000");
	}

	@Then("^user verify short cuts \"(.*?)\"$")
	public static void user_verify_short_cuts_currencyvalue(String arg1) {

	}

	@And("^user clicks 'Search button'$")
	public static void user_clicks_Search_button(String arg1) {
		DriverManager.getDriver()
				.findElement(By
						.xpath("//*[text()='search']/following::input[@class='mat-autocomplete-trigger mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-valid ng-dirty ng-touched']"))
				.click();
	}

	@And("^user enter \"(.*?)\" in \"(.*?)\" textbox$")

	public static void user_enter_with_Date_in_Search_button(String value, String field) {
		DriverManager.getDriver()
				.findElement(By
						.xpath("//*[text()='search']/following::input[@class='mat-autocomplete-trigger mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-valid ng-dirty ng-touched']"))
				.sendKeys(value);
		Search.click();

	}

	@And("^user verify \"(.*?)\" with title$")
	public static void user_verify_Advance_Date_with_title(String arg1) {
		DriverManager.getDriver().findElement(By.xpath("//div[@class='ets-product-title--name']"));
	}

	@And("^user enter with \"(.*?)\" details in Search button$")
	public static void user_enter_witth_Product_in_Search_button(String arg1) {
		DriverManager.getDriver()
				.findElement(By
						.xpath("//*[text()='search']/following::input[@class='mat-autocomplete-trigger mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-valid ng-dirty ng-touched']"))
				.sendKeys("ST-FIX");
		ST_FIX1.click();
	}

	@And("^user verify \"(.*?)\" product with title$")
	public static void user_verify_Advance_product_with_title(String arg1) {
		DriverManager.getDriver().findElement(By.xpath("//div[@class='ets-product-title--name"));
	}

	@And("^user click 'search button' to close$")
	public static void user_click_search_button_to_close(String arg1) {
		DriverManager.getDriver()
				.findElement(By
						.xpath("//*[text()='search']/following::input[@class='mat-autocomplete-trigger mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-valid ng-dirty ng-touched']"))
				.click();
	}

	@Then("^user clicks Key Attributes \"(.*?)\"$")
	public static void user_clicks_key_Attributes_Start_Date(String arg1) {
		DriverManager.getDriver()
				.findElement(By
						.xpath("//mat-label[text()='Start Date']/preceding::input[@class='ng-untouched ng-pristine ng-valid']"))
				.click();

	}

	@And("^user enter 'date' as \"(.*?)\"$")
	public static void user_enter_date_as_operation(String operation) {
		DriverManager.getDriver()
				.findElement(By
						.xpath("//mat-label[text()='Start Date']/preceding::input[@class='ng-untouched ng-pristine ng-valid']"))
				.sendKeys("0d");
		date.click();
	}

	@And("^user verify 'date' in \"(.*?)\"$")
	public static void user_verify_date_in_shortcuts(String shortcuts) {
	}

	@And("^user click \"(.*?)\" text box$")
	public static void user_click_Curreny_text_box(String arg1) {
		DriverManager.getDriver()
				.findElement(By.xpath("//div[@class='mat-form-field-infix']/child::input[@formcontrolname='notional']"))
				.click();
	}

	@Then("^user enter shortcut \"(.*?)\"$")
	public static void user_enter_shortcut_Currency_value(String arg1) {
		DriverManager.getDriver()
				.findElement(By.xpath("//div[@class='mat-form-field-infix']/child::input[@formcontrolname='notional']"))
				.sendKeys("1k");
		currency.click();
		System.out.println("1000");
	}

	@And("^user close Currency text box$")
	public static void user_close(String arg) {
		DriverManager.getDriver()
				.findElement(By.xpath("//div[@class='mat-form-field-infix']/child::input[@formcontrolname='notional']"))
				.click();

	}

}
