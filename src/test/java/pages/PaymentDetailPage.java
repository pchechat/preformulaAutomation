package pages;

import java.util.List;

import org.openqa.selenium.By;

import utils.AbstractContainer;
import cucumber.api.java.en.When;

public class PaymentDetailPage extends AbstractContainer {
	static String url = "https://stage.pureformulas.com/account/payment-detail.jsp";
	By cardTypeSelect = By.cssSelector("#ccType");
	By cardNumberFld = By.cssSelector("#ccNumber");
	By expdateMonthSelect = By.cssSelector("#ccExpirationMonth");
	By expdateYearSelect = By.cssSelector("#ccExpirationYear");
	By firstNameFld = By.cssSelector("#ccFirstName");
	By lastNameFld = By.cssSelector("#ccLastName");
	By createCardBtn = By.cssSelector("[onclick=\"return createCreditCard();\"]");
	By updateCardBtn = By.cssSelector("[onclick=\"return createCreditCard();\"]");

	@When("^user enter credit card data$")
	public void fillCreditCardData(List<String> data) {
		isLoaded();
		selectVisibleTextBy(cardTypeSelect, data.get(0));
		getElement(cardNumberFld).sendKeys(data.get(1));
		selectVisibleTextBy(expdateMonthSelect, data.get(2));
		selectVisibleTextBy(expdateYearSelect, data.get(3));
	}

	@When("^user enter personal data on credit card section$")
	public void fillUserData(List<String> data) {
		getElement(firstNameFld).sendKeys(data.get(0));
		getElement(lastNameFld).sendKeys(data.get(2));
	}

	@When("^user update expiration date$")
	public void updateCreditCardData(List<String> data) {
		selectVisibleTextBy(expdateMonthSelect, data.get(0));
		selectVisibleTextBy(expdateYearSelect, data.get(1));
	}
	
	@When("^user click 'Create Card' button$")
	public void doSave() {
		sleepFor(1500);
		getElement(createCardBtn).click();
	}

	@When("^user click 'Update Card' button$")
	public void user_click_Update_Card_button() throws Throwable {
	    getElement(updateCardBtn).click();
	}
	
	@Override
	protected By getUniqueElement() {
		return cardTypeSelect;
	}
}