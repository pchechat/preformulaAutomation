package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import utils.AbstractContainer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CheckoutReviewSubmitPage extends AbstractContainer {

	By orderSubmitForm = By.cssSelector("#orderSubmitForm");
	By commitOrderButton = By.cssSelector("#commitOrderButton");
	By billingInfoContainer = By
			.cssSelector("[class=\"review-list inspectlet-sensitive\"]");
	By billingEmailContainer = By
			.cssSelector("[class=\"payment-emial-block-d\"]");
	By billingAddressContainer = By
			.cssSelector(".review-list > dd:nth-child(5)");
	
	@Given("^user is on Review & Submit page$")
	@Then("^system redirects user to Review & Submit page$")
	public void atReviewSubmitPage() {
		isLoaded();
	}

	@When("^compare email to \"([^\"]*)\"$")
	public void validateEmail(String email) {
		email = email.toLowerCase();
		String billingEmail = getElement(billingEmailContainer).getText()
				.toLowerCase();
		Assert.assertEquals(billingEmail, email);
	}

	@When("^compare address to previusly enterd$")
	public void validateAddress(List<String> data) {
		Assert.assertTrue(isDataCorrect(getElement(billingAddressContainer),
				data));
	}

	@When("^user clicks on 'Submit my order' button on Review & Submit page$")
	public void clickSubmitBtn() {
		sleepFor(2000);
		getElement(commitOrderButton).click();
		checkForErrors();
	}

	@Override
	protected By getUniqueElement() {
		return orderSubmitForm;
	}

}
