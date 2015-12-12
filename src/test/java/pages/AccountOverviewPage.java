package pages;

import org.openqa.selenium.By;

import utils.AbstractContainer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AccountOverviewPage extends AbstractContainer {

	By shareRewardsInfoContainer = By.cssSelector("#shareRewardsInfo");
	By logoutBtn = By.cssSelector("[onclick=\"return logout();\"]");
	By userInfo = By.cssSelector("#profile > p");
	By addressBookLink = By.cssSelector("[href=\"/account/address.jsp\"]");
	By creditCardsLink = By.cssSelector("[href=\"/account/payment.jsp\"]");
	By editMyProfileBtn = By.cssSelector("[href=\"/account/profile-edit.jsp\"]");
	
	
	@Given("^user is on Account Overview page$")
	
	
	@Then("^system redirects user to the Account Overview page$")
	public void atAccountOverviewPage() {
		isLoaded();
	}
	
	
	
	@When("^user clicks 'Edit My profile' button$")
	public void clickEditMyProfileBtn() throws Throwable {
	    getElement(editMyProfileBtn).click();
	}

	public void doLogout() {
		getElement(logoutBtn).click();
	}
	
	@Override
	protected By getUniqueElement() {
		return shareRewardsInfoContainer;
	}
	
}