package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import utils.AbstractContainer;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class AddressPage extends AbstractContainer {

	JavascriptExecutor executor = (JavascriptExecutor) driver;

	By firstNameFld = By.cssSelector("#acc_firstName");
	By lastNameFld = By.cssSelector("#acc_lastName");
	By address1Fld = By.cssSelector("#acc_address1");
	By address2Fld = By.cssSelector("#acc_address2");
	By cityFld = By.cssSelector("#acc_city");
	By stateSelect = By.cssSelector("#acc_state");
	By zipFld = By.cssSelector("#acc_postalCode");
	By countrySelect = By.cssSelector("#acc_country");
	By phoneFld = By.cssSelector("#acc_phoneNumber");
	By phoneAltFld = By.cssSelector("#acc_phoneNumberAlt");
	By createAddressBtn = By
			.cssSelector("[class=\"form-submit\"] > input.button");

	public void atAddressPage() {
		isLoaded();
	}

	@When("^user fill address data$")
	public void user_fill_address_data(List<String> address) throws Throwable {
		getElement(firstNameFld).sendKeys(address.get(0));
		getElement(lastNameFld).sendKeys(address.get(1));
		getElement(address1Fld).sendKeys(address.get(2));
		getElement(cityFld).sendKeys(address.get(3));
		selectVisibleTextBy(stateSelect, address.get(4));
		getElement(zipFld).sendKeys(address.get(5));
		sleepFor(1500);
		specialInput(phoneFld, address.get(6));
	}

	@Given("^user update address data$")
	public void user_update_address_data(List<String> updatedAddress)
			throws Throwable {
		replaceText(getElement(firstNameFld), updatedAddress.get(0));
		replaceText(getElement(address1Fld), updatedAddress.get(2));
		replaceText(getElement(cityFld), updatedAddress.get(3));
		specialInput(phoneFld, updatedAddress.get(6));
		selectVisibleTextBy(stateSelect, updatedAddress.get(4));
		replaceText(getElement(zipFld), updatedAddress.get(5));
		getElement(phoneFld).click();
	}

	@When("^user updates First and Last name$")
	public void updateNameSurname(List<String> data) {
		String firstName = data.get(0);
		String lastName = data.get(1);

		setName(firstName, lastName);
	}

	@When("^user clicks 'Update Address' button$")
	public void user_clicks_Update_Address_button() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@When("^user enters personal data on address section$")
	public void setName(String firstName, String lastName) {
		replaceText(getElement(firstNameFld), firstName);
		replaceText(getElement(lastNameFld), lastName);
		Assert.assertEquals(getElement(firstNameFld).getAttribute("value"),
				firstName);
		Assert.assertEquals(getElement(lastNameFld).getAttribute("value"),
				lastName);
	}

	@When("^user enters address data on address section$")
	public void setAddress(List<String> data) {

		Assert.assertEquals(data.size(), 8,
				"Incorrect number of input parameters");

		setAddress1(data.get(0));
		setAddress2(data.get(1));
		setCity(data.get(2));
		setState(data.get(3));
		setZip(data.get(4));
		setCountry(data.get(5));
		setPhone(data.get(6));
		setAltPhone(data.get(6));
	}

	@When("^user fill data into Add Address modal fields$")
	public void setAddressWithName(List<String> data) {
		sleepFor(5000);
		setName(data.get(0), data.get(1));
		setPhone(data.get(6));
		setAddress1(data.get(2));
		setCity(data.get(3));
		setState(data.get(4));
		setZip(data.get(5));
		sleepFor(1500);
		getElement(phoneFld).click();
	}

	@When("^user saves changes on Address page$")
	public void saveChanges() {
		getElement(createAddressBtn).click();
	}

	private void setAddress1(String value) {
		getElement(address1Fld).sendKeys(value);
	}

	private void setAddress2(String value) {
		getElement(address2Fld).sendKeys(value);
	}

	private void setCity(String value) {
		getElement(cityFld).sendKeys(value);
	}

	private void setState(String value) {
		selectValueBy(stateSelect, value);
	}

	private void setZip(String value) {
		getElement(zipFld).sendKeys(value);
	}

	private void setCountry(String value) {
		selectVisibleTextBy(countrySelect, value);
	}

	private void setPhone(String value) {
		specialInput(phoneFld, value);

	}

	private void setAltPhone(String value) {
		executor.executeScript("document.getElementById('acc_phoneNumberAlt').value = "
				+ value);
		getElement(phoneAltFld).sendKeys(Keys.TAB);
	}

	@Override
	protected By getUniqueElement() {
		return address1Fld;
	}

}
