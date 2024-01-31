package stepdefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pageobjects.LoginPage;
import pageobjects.PendingPO_OverllAllReports;
import pageobjects.PendingPurchaseOrdersPage;



public class Steps extends BaseClass{

	
	@Before 
	
	public void setup() throws Exception {
		ScreenRecorderUtil.startRecord("Steps");
		File file=new File("F:\\eclipse-workspace\\VendoraBuyers\\config.properties");
		FileInputStream configPropfile=new FileInputStream(file);
		configprop=new Properties(); 
		configprop.load(configPropfile);
	
		
		String br=configprop.getProperty("browser");	
	if(br.equals("chrome")) {	
	System.setProperty("webdriver.chrome.driver",configprop.getProperty("chromepath"));
	driver=new ChromeDriver();
	}
	else if(br.equals("firefox")) {	
	System.setProperty("webdriver.gecko.driver",configprop.getProperty("firefoxpath"));
	driver=new FirefoxDriver();
	}

		
	}
@After
public void tearDown() throws Exception {
	ScreenRecorderUtil.stopRecord();;
}
	
	//STEPS
	
	@Given("User Launch Chrome browser")
	public void user_Launch_Chrome_browser() {	
	lp=new LoginPage(driver);
	driver.manage().window().maximize();
	}
	
	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
	
	driver.get(url);
	}
	
	@When("User enters Username as {string} and Password as {string}")
	public void user_enters_Username_as_and_Password_as(String email, String password) {
	
	lp.setUserName(email);
	lp.setPassword(password);
	}
	
	@When("Click on Login")
	public void Click_on_Login() {
	
	lp.clickLogin();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Then("Page Title should be {string}")
	public void Page_Title_should_be(String title) {
	if(driver.getPageSource().contains("Your username or password is incorrect.")) {
	driver.close() ;
	
	Assert.assertTrue(false) ;
	} 
	else{
	
	Assert.assertEquals(title, driver.getTitle());
	}	
	}
	
	@Then("Error Message Should be {string}")
	public void Error_Message_Should_be(String title) {
	if(driver.getPageSource().contains("Your username or password is incorrect.")) {
	driver.close() ;
	
	Assert.assertTrue(true) ;
	} 
	else{
	
	Assert.assertEquals(title, driver.getTitle());
	}	
	}
	
	
	@When("User click on Signout link")
	public void user_click_on_Sign_out_link() throws InterruptedException {
		Thread.sleep(3000);
	lp.clickLoginUser();
	Thread.sleep(3000);
    lp.clickSignout () ;
	
    }

	@Then("close browser")
	public void close_browser () {
	driver.quit() ;
	}
	
	
	
	
	
	
	
	@When("User click on Reports Menu")
	public void user_click_on_reports_menu() {
		ppo=new PendingPurchaseOrdersPage(driver);
		ppo.clickReport();
	}

	@When("click on pending POs Menu Item")
	public void click_on_pending_p_os_menu_item() throws InterruptedException  {
	   
		ppo.clickPendingPOs();
	}

	@When("click on Show Filter button")
	public void click_on_show_filter_button() {
	    ppo.clickShowFilter();
	}

	@And("Select Delivery Location and Click Filter Button")
	public void select_delivery_location_And_Click_Filter_Button() {
	    ppo.clickCloseAllLocations();
	    ppo.SelectQaTest();
	    ppo.clickFilter();
	}

	@Then("User should found Pending POs in the Search Table with respect to the Delivery Location Entered")
	public void User_should_found_Pending_POs_in_the_Search_Table_with_respect_to_the_Delivery_Location_Entered() {
		boolean status= ppo.SearchPendingPOsBasedOnLocation("01 - QA test");
		   Assert.assertEquals(true,status);
		   }
	

	
	
	
	
	@And("Select Vendor and Click Filter Button")
	public void select_vendor_And_Click_Filter_Button() throws InterruptedException {
	    
	    ppo.clickCloseAllVendors();
	    ppo.clickFilter();
	   
	}

	@Then("User should found Pending POs in the Search Table  with respect to the Vendor Name Entered")
	public void User_should_found_Pending_POs_in_the_Search_Table_with_respect_to_the_Vendor_Name_Entered() {
		
		boolean status= ppo.SearchPendingPOsBasedOnVendor("600639 - Sharp liqech test1");
		   Assert.assertEquals(true,status);
		//ppo.SearchPendingPOsBasedOnVendor("600639 - Sharp liqech test1");
	}

		
	
		
	
	
		@When("Click on Pending POs Overall Report")
	public void click_on_pending_p_os_overall_report() {
			 ppoReport=new PendingPO_OverllAllReports(driver);
	ppoReport.ClickPendingPOsReport();
		}

	

	@Then("Take Screenshot Of Pending POs Overall Report")
	public void take_screenshot_of_pending_p_os_overall_report() throws InterruptedException, IOException {
		 ppoReport =new PendingPO_OverllAllReports(driver);
		 ppoReport.PendingPoOverallReportScreenshot();
	}

	
	
	
	
}

