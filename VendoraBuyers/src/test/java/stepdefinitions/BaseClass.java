package stepdefinitions;
import org.openqa.selenium.WebDriver;

import pageobjects.LoginPage;
import pageobjects.PendingPO_OverllAllReports;
import pageobjects.PendingPurchaseOrdersPage;

import java.util.Properties;
public class BaseClass {


	public WebDriver driver;
	public Properties configprop;
	
    public LoginPage lp;
    public PendingPurchaseOrdersPage ppo;
    public PendingPO_OverllAllReports ppoReport;
   
    
}
