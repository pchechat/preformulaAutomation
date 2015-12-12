package pages;

import org.openqa.selenium.By;

import utils.AbstractContainer;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;



import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class ReportExtender extends AbstractContainer {

    private Scenario scenario;
    public String scenarioName;
    

    @Before
    public void before(Scenario scenario) {
        
    	this.scenario = scenario;
        scenarioName = scenario.getName();
        getRunTest(scenarioName);
    }
     
    @After
    public void after() throws Throwable {
        
    	getTestResultMessage(scenarioName, scenario.getStatus());
    	
    	if (scenario.isFailed()) {
    		
    		//stackTrack();
    		
    		try {
                
            	byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
               
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots
                        .getMessage());
            }
        }
    	

    }
    
    @Override
    protected By getUniqueElement() {
        return null;
    }

}