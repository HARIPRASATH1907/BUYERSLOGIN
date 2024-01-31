package testRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions      
(
	    features=".//Features/",
			glue="stepdefinitions",
	      dryRun=false,        
	                             
	  monochrome=true,          
			   
	    plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)

 
public class TestRun {

}
