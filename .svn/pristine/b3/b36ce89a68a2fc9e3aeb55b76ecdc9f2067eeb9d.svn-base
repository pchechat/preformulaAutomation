package pages;

import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import utils.AbstractContainer;

public class ExpressCheckoutPage extends AbstractContainer{

	static String url ="https://stage.pureformulas.com/account/express.jsp";
	By shippingAddressSelect = By.cssSelector("#shippingAddress");
	//By shippingMethodSelect = By.cssSelector(".select[name='/atg/userprofiling/ProfileFormHandler.value.shippingMethod']");
	By shippingMethodSelect = By.cssSelector("[name=\"/atg/userprofiling/ProfileFormHandler.value.shippingMethod\"]");
	By billingAddressSelect = By.cssSelector("#billingAddress");
	//By paymentMethodSelect = By.cssSelector(".select[name='/atg/userprofiling/ProfileFormHandler.value.paymentMethod']");
	By paymentMethodSelect = By.cssSelector("[name=\"/atg/userprofiling/ProfileFormHandler.value.paymentMethod\"]");
	By saveChangesButton = By.cssSelector(".button[onclick=\"javascript: submitAccExpressCheckout();\"]");
	
	@Given("^user select '(\\d+)' index as default shipping address on Express Checkout page$")
	public void setDelaultShipingAddress(int arg1) throws Throwable {
		selectIndexBy(shippingAddressSelect, arg1);
	}
		
	@Given("^user select '(\\d+)' index as default shipping method on Express Checkout page$")
	public void setDefaultShippingMethod(int arg1) throws Throwable {
		selectIndexBy(shippingMethodSelect, arg1);
	}
	
	@Given("^user select '(\\d+)' index as default billing address on Express Checkout page$")
	public void setDefaultBillingAddress(int arg1) throws Throwable {
		selectIndexBy(billingAddressSelect, arg1);
	}

	@Given("^user select '(\\d+)' index as default payment method on Express Checkout page$")
	public void setDefaultPaymentMethod(int arg1) throws Throwable {
		selectIndexBy(paymentMethodSelect, arg1);
	}

	@Given("^user clicks 'Save Changes' button on Express Checkout page$")
	public void user_clicks_Save_Changes_button_on_Express_Checkout_page() throws Throwable {
	    sleepFor(1500);
		getElement(saveChangesButton).click();
	}
	
	@Override
	protected By getUniqueElement() {
		return shippingAddressSelect;
	}

}
