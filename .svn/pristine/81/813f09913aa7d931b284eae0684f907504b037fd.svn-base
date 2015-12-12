package modules;

import org.openqa.selenium.By;

import utils.AbstractContainer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class AccountModule extends AbstractContainer {

	By accountlink = By.cssSelector("a[href='/account/landing.jsp']");
	By profileLink = By.cssSelector("a[href='/account/profile.jsp']");
	By pureRewardsLink = By.cssSelector("a[href='/account/rewards.jsp']");
	By addressLink = By.cssSelector("a[href='/account/address.jsp']");
	By creditLink = By.cssSelector("a[href='/account/payment.jsp']");
	By orderLink = By.cssSelector("a[href='/account/orders.jsp']");
	By favoritesLink = By.cssSelector("a[href='/account/favorites.jsp']");
	By autoshipLink = By.cssSelector("a[href='/account/autoship.jsp']");
	By expressLink = By.cssSelector("a[href='/account/express.jsp']");
	By logoutLink = By.cssSelector("a[href='javascript: void(0)']");
	By sidebarForm = By.cssSelector("#sidebar");

	public void isLoad() {
		isLoaded();
	}

	@When("^user navigates to Address Book page$")
	public void toAddressBookPage() {
		getElement(addressLink).click();
	}

	@When("^user navigates to Credit Cards page$")
	public void toCreditCardsPage() {
		getElement(creditLink).click();
	}

	@When("^user navigate to Autoship Settings page$")
	public void toAutoshipSettingsPage() throws Throwable {
	    getElement(autoshipLink).click();
	}	
	
	@When("^user navigates to My Orders page$")
	public void user_navigates_to_My_Orders_page() throws Throwable {
	    getElement(orderLink).click();
	}
	
	@Given("^user navigate to Favorites Settings page$")
	public void toFavoritesSettingsPage() throws Throwable {
		getElement(favoritesLink).click();
	}
	
	@Given("^user navidates to Address page$")
	public void user_navidates_to_Address_page() throws Throwable {
	    sleepFor(1500);
		getElement(addressLink).click();
	}
	
	@Given("^user navidates to Express Checkout page$")
	public void toExpressCheckoutPage() throws Throwable {
	    getElement(expressLink).click();
	}
		
	@Override
	protected By getUniqueElement() {
		return sidebarForm;
	}

}
