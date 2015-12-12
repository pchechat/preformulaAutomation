package pages;

import org.openqa.selenium.By;

import utils.AbstractContainer;
import cucumber.api.java.en.When;

public class OrderDetailPage extends AbstractContainer{

	static String url = "https://stage.pureformulas.com/account/order-detail.jsp";
	By topRightTopButton = By.cssSelector(".top-right");
	By billingPaymentSidebar = By.cssSelector("#sidebar");
	By cancelOrderBtn = By.linkText("Cancel Order");
	By submitCancelOrderBtn = By.cssSelector("#modal-yes");
	@When("^user navigates to Order detail page$")
	public void atOrderDetailPage() {
	    isLoaded();
	}

	@When("^user clicks 'Cancel Order' button$")
	public void user_clicks_Cancel_Order_button() throws Throwable {
	    getElement(cancelOrderBtn).click();
	    
	}

	@When("^user clicks 'Yes' button to cancel order$")
	public void user_clicks_Yes_button() throws Throwable {
	   // sleepFor(2500);
		getElement(submitCancelOrderBtn).click();
	}
	
	@Override
	protected By getUniqueElement() {
	return topRightTopButton;
	}

}
