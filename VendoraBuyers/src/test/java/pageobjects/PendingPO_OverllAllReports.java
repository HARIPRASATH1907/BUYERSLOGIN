package pageobjects;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PendingPO_OverllAllReports {

	
	public  WebDriver ldriver;
	
	public PendingPO_OverllAllReports(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	
	}
	
	
	//LOCATORS
	@FindBy (xpath= "//a[@title='Pending P.Os - Overall Report']")
	@CacheLookup
	public WebElement PendingPOsReport;
	
	
	//ACTIONS
	public void ClickPendingPOsReport() {
		PendingPOsReport.click();
	}
	
	
		public void PendingPoOverallReportScreenshot() throws InterruptedException, IOException {
		
		Date date=new Date();
		SimpleDateFormat TimeFormat=new SimpleDateFormat(" HH-mm-ss a");
		String Time=TimeFormat.format(date);
		File screenshot = ((TakesScreenshot) ldriver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("F:\\eclipse-workspace\\VendoraBuyers\\target\\Screenshot @ "+ Time +".png"));
		}

	
}
