package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public  WebDriver ldriver;

	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	//LOCATORS
	@FindBy(xpath="//input[@name='username']")
	@CacheLookup
	public WebElement Username;
	
	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	public WebElement Password;

	@FindBy(xpath="//button[@class='btn btn-warning btn-block']")
	@CacheLookup
	public WebElement LoginBtn;
	
	@FindBy(xpath="//span[@class='hidden-xs']")
	@CacheLookup
	public WebElement LoginUsername;
	
	
	@FindBy(xpath="//a[contains(text(),'Sign out')]")
	@CacheLookup
	public WebElement SignoutBtn ;

	
	
	
	
	//ACTIONS
	public void setUserName(String uname) {
		Username.clear();
		Username.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		Password.clear();
		Password.sendKeys(pwd);
	}
	
	public void clickLogin() {
	    LoginBtn.click();
	}
	
	public void clickLoginUser() {
	    LoginUsername.click();
	}
	
	public void clickSignout() {
		SignoutBtn.click();
	}	
		
		
}

	
	
	
	
	
	
	
	