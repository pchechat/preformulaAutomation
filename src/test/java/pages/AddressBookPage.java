package pages;

import java.util.List;

import modules.AccountModule;
import modules.HeaderModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.AbstractContainer;

import com.google.common.collect.Iterables;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddressBookPage extends AbstractContainer {

	static String url = "https://stage.pureformulas.com/account/address.jsp";

	By addNewAddressLink = By
			.cssSelector("a[href='/account/address-detail.jsp']");
	By editLinkSet = By.cssSelector("a");
	By deleteLinkSet = By.cssSelector(".red");
	By addressesSet = By.cssSelector(".account-list > li");
	By nameData = By.cssSelector("strong");
	

	@Given("^user is on Address Book page$")
	public void toAddressPage() {
		new HeaderModule().navigateToAccountOverview();
		new AccountModule().isLoad();
		new AccountModule().toAddressBookPage();
		atAddressBookPage();
	}

	@When("^user clicks 'Add a New Address' button$")
	public void clickAddAddress() {
		getElement(addNewAddressLink).click();
	}

	@Given("^user press on 'Edit' link for address that contain \"([^\"]*)\" name that should be present in list on Address Book page$")
	public void user_press_on_Edit_link_for_address_that_contain_name_name_that_should_be_present_in_list_on_Address_Book_page(String arg1) throws Throwable {
		List<WebElement> addItems = getElements(addressesSet);
		for (WebElement item : addItems) {
			if (item.getText().contains(arg1)) {
				item.findElement(editLinkSet).click();
			}
		}
	}
	
	@When("^user press on 'Delete' link for address that contain \"([^\"]*)\" name that should be present in list on Address Book page$")
	public void deleteAddress(String arg1) throws Throwable {
	    List<WebElement> addItems = getElements(addressesSet);
	    for (WebElement item : addItems) {
			if(item.getText().contains(arg1)){
				item.findElement(deleteLinkSet).click();
			}
		}	    
	  
	}
	
	@When("^user clicks Edit button for existing address$")
	public void openEditOfAddress(List<String> data) {
		for (WebElement element : getElements(addressesSet)) {
			if (isDataCorrect(element, data) == true) {
				element.findElement(editLinkSet).click();
				return;
			}
		}
	}

	@When("^user click 'Delete' button next to address$")
	public void clickDeleteAddress(List<String> data) {
		for (WebElement element : getElements(addressesSet)) {
			if (isDataCorrect(element, data) == true) {
				while (elementVisible(element)) {
					element.findElement(deleteLinkSet).click();
				}
				return;
			}
		}
	}

	@Then("^address wich contain \"([^\"]*)\" should be present in Address Book list$")
	public void addressPresent(String addSet) throws Throwable {
		sleepFor(1500);
		boolean addPresent = false;
	    List<WebElement> addressItems = getElements(addressesSet);
	    for (WebElement item : addressItems) {
			if(item.getText().contains(addSet)){
				addPresent = true;
				break;
			}
		}
	   Assert.assertTrue(addPresent, "Address " + addSet + " is not present in address book list");
	}
	
	@Then("^address wich contain \"([^\"]*)\" should be absent in Address Book list$")
	public void addressAbsent(String arg1) throws Throwable {
	    sleepFor(1500);
		boolean addAbsent = true;
	    List<WebElement> addressItems = getElements(addressesSet);
	    for (WebElement item : addressItems) {
	    	if(item.getText().contains(arg1)){
	    		addAbsent = false;
	    		break;
	    	}
			
		}
	    Assert.assertTrue(addAbsent, "Address " + arg1 + " present in address book list");
	}
	
	@When("^user deletes all addresses except firts$")
	public void deleteAllButFirstAddress() {
		while (getElements(addressesSet).size() > 1) {
			WebElement lastElement = Iterables
					.getLast(getElements(addressesSet));
			lastElement.findElement(deleteLinkSet).click();
			driver.navigate().refresh();
		}
	}

	

	@Then("^system displays address on Address Book page$")
	public void isAddressPresent(List<String> data) {
		boolean addressFound = false;

		for (WebElement element : getElements(addressesSet)) {
			if (isDataCorrect(element, data) == true) {
				System.out.println(element.getText());
				addressFound = true;
			}
		}
		Assert.assertTrue(addressFound,
				"Cannot find address following parameters: " + data.toString());
	}

	@Then("^user navidates to the Address Book page$")
	public void atAddressBookPage() {
		isLoaded();
	}

	@Override
	protected By getUniqueElement() {
		return addNewAddressLink;
	}
}