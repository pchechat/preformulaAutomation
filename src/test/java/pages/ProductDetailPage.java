package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.AbstractContainer;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductDetailPage extends AbstractContainer {

	By addedToFavMsg = By.cssSelector(".pdp-order-added");
	By addtocartButton = By.cssSelector(".button-green");
	By pdpUnique = By.cssSelector("[itemtype=\"http://schema.org/Product\"]");
	By autoshipDropdown = By.cssSelector("#pdpAutoshipDropdown");
	By addToFavBtn = By.cssSelector("#addToFavoritesButton");
	By breadcrumbHomeLnk = By.cssSelector("p>a[href=\"/\"]");
	By pdpProdOverview = By.cssSelector(".pdp-overview > ul > li");
	By favoriteAddMsg = By.cssSelector(".pdp-favorites-added");
	
	@Given("^user is on Product Detail Page$")
	@Then("^system redirects user to Product Detail Page$")
	public void onPDP() {
		isLoaded();
	}
	
	@When("^user clicks 'Add to cart' button$")
	public void addProductToCart() {
		
		getElement(addtocartButton).click();
	}

	@When("^user choose \"([^\"]*)\" from autoship dropdown$")
	public void setAutoshipPeriod(String autoshipValue) {
		try {
			selectVisibleTextBy(autoshipDropdown, autoshipValue);
		} catch (Exception ex) {
			String message = getElement(By.cssSelector(".pdp-order-autoship")).getText();
			Assert.assertNotNull(null,
					"Autoship dropdown was not found due to following reason:\n" + message);
		}
	}
	
	@Given("^user clicks 'ADD TO FAVORITES' button$")
	public void addToFav() throws Throwable {
		
		try{
		if(getElement(favoriteAddMsg).isDisplayed()){
		   getSystemMessage("Product is added to Favorites");
		}
		        
		}catch(NullPointerException e){
			retryingFindElement(addToFavBtn);
			
		}
		
		Assert.assertNotNull(getElement(addedToFavMsg));
	}
	
	@Then("^product overview area contain brand name \"([^\"]*)\" on product detail page$")
	public void checkBrandPresent(String arg1) throws Throwable {
	    List<WebElement> prodOverview = getElements(pdpProdOverview);
	    for (WebElement webElement : prodOverview) {
	    	Assert.assertTrue(webElement.getText().contains(arg1), "Product overview area doesn't contain brand " + arg1);
			break;
		}
	}
	
	@Given("^user navigates to Favorites page from PDP$")
	public void user_navigates_to_Favorites_page_from_PDP() throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	
	@When("^user clicks on element Home in breadcrumbs trail$")
	public void navigateViaBreadcrumbstrail() throws Throwable {
	    getElement(breadcrumbHomeLnk).click();
	}
	
	@Override
	protected By getUniqueElement() {
		return pdpUnique;
	}

}
