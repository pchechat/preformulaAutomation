package pages;

import org.openqa.selenium.By;

import utils.AbstractContainer;
import cucumber.api.java.en.Given;

public class CheckoutPaymentPage extends AbstractContainer {
	
	By cPaymentForm = By.cssSelector("[class=\"form checkout-payment\"]");
	
	@Given("^user is not on the Checkout Payment pages$")
	public void onCheckoutPaymentPage() {
		isLoaded();
	}

	@Override
	protected By getUniqueElement() {
		// TODO Auto-generated method stub
		return cPaymentForm;
	}
}
