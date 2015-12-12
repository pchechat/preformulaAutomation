package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import utils.AbstractContainer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CheckoutPage extends AbstractContainer {
	@Given("^user is not on the Checkout pages$")
	public void notLoad() {
	}

	
	@Then("^system redirects user to Bongos transaction page$")
	public void systemRedirectsUserBongosTransactionPage() throws Throwable {
	    
		sleepFor(3000);
		boolean locationUrl = false; 
	    if(driver.getCurrentUrl().contains("tranzaction.bongous.com/pay/pureformulas")){
	    	
	    	locationUrl = true;
	    }
	    	
	    Assert.assertTrue("User is not on Bongos transaction page", locationUrl);
	    
	}

	
	@Override
	protected By getUniqueElement() {
		// TODO Auto-generated method stub
		return null;
	}
}
