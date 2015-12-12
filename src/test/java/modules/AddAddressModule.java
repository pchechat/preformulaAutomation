package modules;

import org.openqa.selenium.By;

import utils.AbstractContainer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddAddressModule extends AbstractContainer {

	By addAddressModal = By.cssSelector("#address-modal");
	By createAddressBtn = By
			.cssSelector("#address-modal > [class=\"form-submit\"] > input.button");

	@Then("^system opens Add Address modal$")
	@Given("^user has Add Address modal open$")
	public void isOpened() {
		isLoaded();
	}

	@When("^user save new address$")
	public void saveNewAddress() {
		getElement(createAddressBtn).click();
	}

	@Override
	protected By getUniqueElement() {
		return addAddressModal;
	}

}
