package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.AbstractContainer;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyOrderPage extends AbstractContainer{

	static String url ="https://stage.pureformulas.com/account/orders.jsp";
	By orderInstance = By.cssSelector(".account-orders > li");
	By orderNumber = By.cssSelector(".order-no > a");
	By orderDate = By.cssSelector(".order-date");
	By totalPrice = By.cssSelector(".order-total");
//	By statusOrder = By.cssSelector(".order-status tooltip");
	By statusOrder = By.cssSelector(".order-status");
	By pagination = By.cssSelector(".pagination-paging");
	By detailButton = By.cssSelector(".first last");
	
	
	@Given("^user is on My Orders page$")
	public void atMyOrderspage() throws Throwable {
	    isLoaded();
	}

	@Then("^system displays list of My Orders$")
	public void orderPresents() throws Throwable {
	    List<WebElement> orders = getElements(orderInstance);
	    Assert.assertTrue(orders.size()>0, "No orders in profile");
	   
	}

	@When("^user open first order from My Orders page$")
	public void user_open_first_order_from_My_Orders_page() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}
	
	@Given("^user select first order in list with status \"([^\"]*)\"$")
	public void user_select_first_order_in_list_with_status(String arg1) throws Throwable {
		sleepFor(2500);
		List<WebElement> orders = getElements(orderInstance);
	    for (WebElement element : orders) {
			if(element.findElement(statusOrder).getText().contains(arg1)){
				element.findElement(orderNumber).click();
				break;
			}
		}
	}
	
	@Override
	protected By getUniqueElement() {		
		return pagination;
	}

}
