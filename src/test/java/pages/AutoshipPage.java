package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.AbstractContainer;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AutoshipPage extends AbstractContainer {

	static String url = "https://stage.pureformulas.com/account/autoship.jsp";

	static By autoShip = By.cssSelector("#autoship");
	static By itemTitleSet = By.cssSelector(".item-title");
	static By autoshipItem = By.cssSelector(".item-item");
	static By autoshipItemValue = By.cssSelector(".item-autoship");
	static By editAutoShipItem = By.cssSelector(".item-autoship-action");
	static By setAutoShipFreq = By.cssSelector("#asFrec");
	static By SaveAutoShipSeting = By
			.cssSelector("#deleteAutoship > input:nth-child(4)");
	static By SuccessMsg = By.cssSelector("#success");
	static By canselAutoShip = By.linkText("Cancel Autoship for this item");

	@Then("^\"([^\"]*)\" should be present in list on Autoship Settings page$")
	public void itemPresentInAutoshipList(String product) throws Throwable {
		boolean elementPresent = false;
		List<WebElement> autoShipItems = getElements(autoshipItem);
		for (WebElement item : autoShipItems) {
			String autoshipItemName = item.findElement(itemTitleSet).getText();
			if (autoshipItemName.equals(product)) {
				elementPresent = true;
				return;
			}
		}
		Assert.assertTrue(elementPresent, "Item " + product
				+ " not present in list");
	}

	@When("^user click on 'Edit' link for \"([^\"]*)\" item on Autoship product$")
	public void user_click_on_Edit_link_for_item_on_Autoship_product(
			String product) throws Throwable {
		List<WebElement> autoShipItems = getElements(autoshipItem);
		for (WebElement item : autoShipItems) {
			String autoshipItemName = item.findElement(itemTitleSet).getText();
			if (autoshipItemName.equals(product)) {
				item.findElement(editAutoShipItem).click();
			}
		}
	}


	@When("^user change frequency to \"([^\"]*)\"$")
	public void changeFrequencyForAutoshipItem(String aFrequency)
			throws Throwable {
		selectVisibleTextBy(setAutoShipFreq, aFrequency);
	}

	@When("^user clicks on 'Save Autoship Settings' button$")
	public void user_clicks_on_Save_Autoship_Settings_button() throws Throwable {
		getElement(SaveAutoShipSeting).click();
	}

	@Then("^user clicks on \"([^\"]*)\" link$")
	public void user_clicks_on_link(String arg1) throws Throwable {
		getElement(canselAutoShip).click();
	}

	@When("^autoship frequency is change to \"([^\"]*)\" for item \"([^\"]*)\"$")
	public void autoship_frequency_for_item_is_change_to_for_item(
			String prodFreq, String product) throws Throwable {
		sleepFor(2500);
		boolean validItemFreq = false;
		List<WebElement> autoShipItems = getElements(autoshipItem);
		for (WebElement item : autoShipItems) {
			String autoshipItemName = item.findElement(itemTitleSet).getText();
			if (autoshipItemName.equals(product)
					&& item.findElement(autoshipItemValue).getText()
							.contains(prodFreq)) {
				{
					validItemFreq = true;
				}
			}
		}
		Assert.assertTrue(validItemFreq, "Frequency autoship for product "
				+ product + " not equal " + prodFreq);
	}

	@When("^Item \"([^\"]*)\"  removes from Autoship Item list$")
	public void Item_removes_from_Autoship_Item_list(String product) throws Throwable {
		sleepFor(1500);
		boolean elementAbsent = true;
		List<WebElement> autoShipItems = getElements(autoshipItem);
		for (WebElement item : autoShipItems) {
			String autoshipItemName = item.findElement(itemTitleSet).getText();
			if (autoshipItemName.equals(product)) {
				elementAbsent = false;
				return;
			}
		}
		Assert.assertTrue(elementAbsent, "Item " + product
				+ " present in list");
	}
	
	@Override
	protected By getUniqueElement() {
		return autoShip;
	}

}
