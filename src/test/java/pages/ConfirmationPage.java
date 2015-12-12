package pages;

import org.openqa.selenium.By;

import utils.AbstractContainer;
import cucumber.api.java.en.Then;

public class ConfirmationPage extends AbstractContainer{

	By returnPolicyLink = By.cssSelector("a[href='/returns-and-exchanges']");
	By printButton = By.cssSelector(".confirm-print");
	By productInformation = By.cssSelector(".item-item");
	By billingSidebar = By.cssSelector("#sidebar");
	By orderNumberFld = By.cssSelector("tr>td>h3>.orange");
		

	@Then("^system redirects user to Confirmation page$")
	public void onConfirmationPage(){
		sleepFor(3000);
		isLoaded();
		String orderNumber = getOrderNumber();
		getSystemMessage("Order number - " + orderNumber);
	}
	
	
	public String getOrderNumber(){
		
		String orderNumber = getElement(orderNumberFld).getText();
		
		return orderNumber;
	}
	
	@Override
	protected By getUniqueElement() {
		
		return returnPolicyLink;
	}

}
