package pages;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import utils.AbstractContainer;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomePage extends AbstractContainer{

	static String url = "https://stage.pureformulas.com";
	By slideShowCntr = By.cssSelector(".slideshow-content");
	By headerLogo = By.cssSelector(".header-logo");
	
	
	@Then("^system redirects user on Home page$")
	@Given("^user is on Home page$")
	public void onHomePage(){
		navigateTo(url);
		isLoaded();
	}
	
	@Override
	protected By getUniqueElement() {
		return headerLogo;
	}	
	
	@Before
	public void before(){
		
	}

	@After
	public void embedScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				byte[] screenshot = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException wde) {
				System.err.println(wde.getMessage());
			} catch (ClassCastException cce) {
				cce.printStackTrace();
			}
		}
	}
}