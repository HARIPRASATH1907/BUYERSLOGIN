package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class PendingPurchaseOrdersPage {
	
		public  WebDriver ldriver;
				
		public PendingPurchaseOrdersPage(WebDriver rdriver){
			ldriver=rdriver;
			PageFactory.initElements(ldriver, this);
		
		}


//LOCATORS	
		@FindBy (xpath= "//a[contains(text(),'Reports ')]")
		@CacheLookup
		public WebElement Reports;
		
		@FindBy (xpath= "//a[@title='Pending P.Os']")
		@CacheLookup
		public WebElement PendingPOs ;
		
		@FindBy (xpath="//button[@class='btn btn-success showFilter']")
		@CacheLookup
		public WebElement ShowFilter;
		
		@FindBy (xpath= "//a[@title='Pending P.Os - Overall Report']")
		@CacheLookup
		public WebElement PendingPOsOverallReport;
		
		@FindBy (xpath= "//*[@class='select2-selection__rendered']/li[@title='All Locations']/span[@class='select2-selection__choice__remove']")
		@CacheLookup
		public WebElement CloseAllLocations;
		
		@FindBy (xpath= "//li[contains(text(),'01 - QA test')]")
		@CacheLookup
		public WebElement QATEST1;
				
		@FindBy (xpath= "//*[@class='select2-selection__rendered']/li[@title='All Vendors']/span[@class='select2-selection__choice__remove']")
		@CacheLookup
		public WebElement CloseAllVendor;
						 
		@FindBy (xpath= "//button[@class='btn btn-info']")
		@CacheLookup
		public WebElement Filter;
		
		
		
//ACTIONS
		public void clickReport() {
		    Reports.click();
		}
		
		public void clickPendingPOs() throws InterruptedException {
		    Thread.sleep(3000);
			PendingPOs.click();
		}


		public void clickShowFilter() {
			ShowFilter.click();
		}
		
		public void clickCloseAllLocations() {
			CloseAllLocations.click();
		}

		public void SelectQaTest() {
			QATEST1.click();
		}

		public void clickFilter() {
			Filter.click();
			
		}


		
		public void clickCloseAllVendors() throws InterruptedException {
		CloseAllVendor.click();
	    Thread.sleep(10000);
	    try {
	    List<WebElement> allrow=ldriver.findElements(By.xpath("//ul[@class='select2-results__options']/li"));
	
	    for(WebElement row:allrow)
	    {
	     String actualrow=row.getText();
	     //System.out.println(actualrow);
	                                      
	    if(actualrow.equalsIgnoreCase("600639 - Sharp liqech test1")) {
		row.click();	
	    }
	    }
	    }catch(StaleElementReferenceException e) {
		List<WebElement> allrow=ldriver.findElements(By.xpath("//ul[@class='select2-results__options']/li"));
		
		for(WebElement row:allrow)
		{
		String actualrow=row.getText();
		//System.out.println(actualrow);
		                                      
		if(actualrow.equalsIgnoreCase("600639 - Sharp liqech test1")) {
			row.click();	
		}
		}	
	    }
		}	
		
		
		
		
		public boolean SearchPendingPOsBasedOnLocation(String Name) {
			boolean flag=false;
			List<WebElement> allrow=ldriver.findElements(By.xpath("//tbody/tr/td[5][contains(text(),'01 - QA test')]"));
			
			for(WebElement row:allrow)
			{
			String actualrow=row.getText();
			System.out.println(actualrow);
					                                      
			if(actualrow.equals("01 - QA test"))
			{
			flag=true;
			}
			}
			return flag;
			}

		
		
				
		public boolean SearchPendingPOsBasedOnVendor(String Name) {
			boolean flag=false;
			List<WebElement> allrow=ldriver.findElements(By.xpath("//tbody/tr/td[4][contains(text(),'600639 - Sharp liqech test1')]"));
			
			for(WebElement row:allrow)
			{
			String actualrow=row.getText();
			//System.out.println(actualrow);
					                                      
			if(actualrow.equals("600639 - Sharp liqech test1"))
			{
			flag=true;
			}
			}
			return flag;
			}
		
}













 














