package pages;

import java.util.List;

import org.openqa.selenium.By;

import utils.AbstractContainer;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PayPalPage extends AbstractContainer{

	By paypalFrame = By.cssSelector("iframe[name=\"injectedUl\"]"); 
	By payPalLoginForm = By.cssSelector("#loginModule");
	By payPalMiniCart = By.cssSelector("#miniCartContent");
	By paypalLogoFld = By.cssSelector("#paypalLogo"); 
	By loginField = By.cssSelector("#email");
	By passwordField = By.cssSelector("#password");
	By loginBtn = By.cssSelector("#btnLogin");
	By continueBtn = By.cssSelector("#confirmButtonTop");

	
	@When("^user login into PayPal$")
	public void userLoginIntoPayPal(List<String> credentials) throws Throwable {
		sleepFor(2500);
		driver.switchTo().frame(getElement(paypalFrame));
		isLoaded();

		getElement(loginField).clear();
		getElement(loginField).sendKeys(credentials.get(0));
	    getElement(passwordField).sendKeys(credentials.get(1));
	    
	}

	
	@When("^user clicks on 'Log in' button$")
	public void userClicksOnLogBtn() throws Throwable {
	    getElement(loginBtn).click();
	}

	@When("^user clicks on 'Continue' button$")
	public void userClicksOnContinueBtn() throws Throwable {
		
		driver.switchTo().defaultContent();
		getElement(continueBtn).click();
	   
	}

	@Then("^user clicks on 'Submit my order' button$")
	public void userClicksOnSubmitMyOrderBtn() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	
	@Override
	protected By getUniqueElement() {
		return loginField;
	}

}
