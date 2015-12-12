package pages;

import org.openqa.selenium.By;

import utils.AbstractContainer;

public class OrderStatusPage extends AbstractContainer{

	static String url = "https://stage.pureformulas.com/order-status";
	By orderNumber = By.cssSelector("#osOrderNumber");
	By orderDateField = By.cssSelector("#osDate");
	By orderDatePicker = By.cssSelector(".ui-datepicker-trigger");
	By zipCode = By.cssSelector("#osZip");
	By findOrderButton = By.cssSelector(".button");
	
	@Override
	protected By getUniqueElement() {
		return findOrderButton;
	}

}
