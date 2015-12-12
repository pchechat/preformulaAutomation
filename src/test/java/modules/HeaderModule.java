package modules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pages.AccountOverviewPage;
import utils.AbstractContainer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HeaderModule extends AbstractContainer {

	// Special Stores elements
	By beautyLink = By.cssSelector("a[href='/beauty']");
	By fitnessLink = By.cssSelector("a[href='/fitness']");
	By foodLink = By.cssSelector("a[href='/food']");
	By petLink = By.cssSelector("a[href='/pet']");

	// Account related elements
	By favoritesLink = By.cssSelector("a[href='/account/favorites.jsp']");
	By loginLink = By.cssSelector("a[href='/account/login.jsp']");
	By registerLink = By.cssSelector("a[href='/account/register.jsp']");
	By miniCartBtn = By.cssSelector(".my-cart-label");
	By myAccountLink = By.cssSelector("a[href='/account/landing.jsp']");
	By logoutLink = By
			.cssSelector("#global > div > ul.global-actions.hoverdelay > li.parent > ul > li.last > a");
	//By toCheckoutBtn = By.cssSelector(".checkout-button");
	By toCheckoutBtn = By.cssSelector("a[onclick=\"minicartCheckout()\"]");
	
	// Other header elements
	By homeLink = By.cssSelector(".header-logo");
	By pfLink = By.cssSelector("#header > div > a['/']");
	By promoLink = By.cssSelector("#ul.header-promo");
	By searchFld = By.cssSelector("#header-search-term");
	By searchBtn = By.cssSelector("#headerSearch > input.header-search-submit");
	By searchDropdown = By.cssSelector(".ui-menu-item");
	By searchPreviewPopularSearches  = By.cssSelector(".ui-autocomplete > .suggest > .ui-corner-all");
	//By searchPreviewPopularSearches = By.cssSelector("a.ui-corner-all");
	//By searchPreviewProductSugesstions = By.cssSelector(".ui-autocomplete > .product");
	By searchPreviewProductSugesstions = By.cssSelector(".ui-autocomplete > .product > a.ui-corner-all > span");
	
	By categoryDropdown = By.cssSelector("[href=\"/categories\"]");
	By chelatedMineralCategory = By.cssSelector("[href=\"/category/chelated-minerals.html\"]");

	
	
	@When("^user clicks 'Go to cart and checkout' button$")
	public void goToChecout() throws Throwable {
		sleepFor(3000);
		//hoverElement(miniCartBtn);
		click(miniCartBtn);
		//getElement(toCheckoutBtn).click();
	}
	
	@When("^user enters \"([^\"]*)\" in search field$")
	public void enterSearchData(String data) {
		sleepFor(1500);
		getElement(searchFld).sendKeys(data);
	}

	@When("^select \"([^\"]*)\" category from search results$")
	public void selectSearchData(String data) {
		sleepFor(2500);
		boolean elementFound = false;
		for (WebElement element : getElements(searchPreviewProductSugesstions)) {
			if (element.getText().contains(data)) {
				element.click();
				elementFound = true;
				return;
			}
		}
		Assert.assertTrue(elementFound,
				"Can not found search preview with text: " + data);
	}

	@When("^select \"([^\"]*)\" category from popular search results$")
	public void selectPopularSearchData(String category) throws Throwable {
		sleepFor(2500);
		boolean categoryFound = false;
		for (WebElement element : getElements(searchPreviewPopularSearches)) {
			if (element.getText().equals(category)) {
				element.click();
				categoryFound = true;
				return;
			}

		}
		Assert.assertTrue(categoryFound, "Can not found category with text: "
				+ category);
	}

	@When("^user click \"([^\"]*)\" button$")
	public void userClickSearchBtn() {
		getElement(searchBtn).click();
	}

	
	@Given("^user select 'Chelated Minerals' category from 'Shop By Category' dropdown$")
	public void selectChelatedMineralscategory() throws Throwable{
	    hoverElement(categoryDropdown);
	    sleepFor(1500);
		getElement(chelatedMineralCategory).click();
	}
	
	@Given("^user navigates to Home page$")
	public void toHomePage() {
		getElement(homeLink).click();
	}
	
	@Given("^user is not logged in$")
	public void userNotLogedIn(){
		sleepFor(1500);
		if (elementExist(By.cssSelector("a[href=\"/account/login.jsp\"]")) == false){
			hoverElement(myAccountLink);
			getElement(logoutLink).click();
		}
	}
		
	@Given("user navidates to the Account Overview page$")
	public void navigateToAccountOverview() {
		getElement(myAccountLink).click();
		new AccountOverviewPage().atAccountOverviewPage();
	}

	@When("^user clicks LogOut link$")
	public void doLogout() {
		navigateToAccountOverview();
		AccountOverviewPage accpage = new AccountOverviewPage();
		accpage.atAccountOverviewPage();
		accpage.doLogout();
	}

	@Then("^Login or Register link present on the page$")
	public void userLogedOut() {
		Assert.assertTrue(getElement(loginLink).isDisplayed(),
				"Login link is not visible");
		Assert.assertTrue(getElement(registerLink).isDisplayed(),
				"Register link is not visible");
	}

	@Given("^user navigates to Login page$")
	public void toLoginPage() {
		getElement(loginLink).click();
	}
	
	@Then("^system displays search result drop down with '(\\d+)' popular result search$")
	public void system_displays_search_result_drop_down_with_popular_result_search(int arg1) throws Throwable {
		List<WebElement> searchResult = getElements(searchPreviewPopularSearches);
		Assert.assertEquals(searchResult.size(), arg1);
	
	}

	@Then("^suggested Items up to '(\\d+)' most relevant products$")
	public void suggested_Items_up_to_most_relevant_products(int arg1) throws Throwable {
		List<WebElement> searchResult = getElements(searchPreviewProductSugesstions);
		Assert.assertEquals(searchResult.size(), arg1);

	}
	
	@When("^user hovers mouse cursor on My Account link$")
	public void hoversOnMyAccount() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		hoverElement(myAccountLink);
	}

	

	@Override
	protected By getUniqueElement() {
		return pfLink;
	}
}
