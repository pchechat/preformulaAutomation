package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.AbstractContainer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheckoutShippingMethodPage extends AbstractContainer {

	By checkoutShipping = By.cssSelector(".checkout-shipping");
	By checkoutShippingMethod = By.cssSelector("[class=\"section checkout-shipping\"] > li > label");
	By continueBtn = By.cssSelector("[onclick=\"return continueWithShipping();\"]");


	@Given("^user is on Shipping Method page$")
	@Then("^system redirects user to Shipping Method page$")
	public void onCheckoutPaymentPage() {
		isLoaded();
	}
	
	@When("^selects shipping method with cost \"([^\"]*)\"$")
	public void selectsShippingMethod(String data) {
	    for (WebElement element : getElements(checkoutShippingMethod)) {
			if(element.getText().contains(data)){
				element.findElement(By.cssSelector("input")).click();
			}
		}
	}

	@When("^user clicks 'Continue' button on Shipping Method page$")
	public void clickContinueBtn() {
	    sleepFor(2500);
		getElement(continueBtn).click();
	}
	

	@Override
	protected By getUniqueElement() {
		return checkoutShipping;
	}
}
