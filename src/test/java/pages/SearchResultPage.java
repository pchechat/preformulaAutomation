package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.AbstractContainer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchResultPage extends AbstractContainer {

	By productsSet = By.cssSelector(".item-grid > li.item-item");
	By inStockProductSet = By.cssSelector(".item-item > .button-green");
	By titleProductSet = By.cssSelector("[class=\"item-title\"] > a");
	By outOfStockProductSet = By.cssSelector("[class=\"item-status orange\"]");
	By itemThumb = By.cssSelector(".item-qv-wrap > a > .item-thumb");
	By quickViewBtn = By.cssSelector(".item-qv-wrap > .item-qv");
	By facetSearchBar = By.cssSelector(".facet-search");
	By facetSelectedBarItem = By.cssSelector(".facet-selected > li > ul > li");
	By facetSortByBrand = By.cssSelector(".facet-collapse > .first > ul > li");
	By facetBrandSelect = By.cssSelector("a > input");

	@Given("^user is on search results page$")
	@Then("^system redirects user search results page$")
	public void onSearchResultPage() {
		isLoaded();
	}

	@When("^user opens first available product$")
	public void openAvailableProduct() {
		sleepFor(2500);
		for (WebElement element : getElements(productsSet)) {
			if (element.findElement(inStockProductSet) != null) {
				try {
					element.findElement(titleProductSet).click();
				} catch (NoSuchElementException ex) {
				}
				return;
			}
		}
	}

	@When("^user clicks 'Quick View' button for first available product in list on Product Listing page$")
	public void toItemQuickView() throws Throwable {
		sleepFor(1500);
		for (WebElement element : getElements(productsSet)) {
			if (element.findElement(inStockProductSet) != null) {
				try {
					hoverElement(itemThumb);
					element.findElement(quickViewBtn).click();
				} catch (NoSuchElementException ex) {
				}
				return;
			}
		}
	}

	@Given("^user choose brand \"([^\"]*)\" in brand facet group$")
	public void user_choose_brand_in_brand_facet_group(String arg1) throws Throwable {
	    sleepFor(1550);
		List<WebElement> brands = getElements(facetSortByBrand);
	    for (WebElement brand : brands) {
	    	if(brand.getText().contains(arg1)){
	    		brand.findElement(facetBrandSelect).click();
	    		break;
	    	}
			
		}
	    
	}
	
	@Then("^system displays \"([^\"]*)\" brand facet value in the selected facets section$")
	public void system_displays_brand_facet_value_in_the_selected_facets_section(String arg1) throws Throwable {
		boolean elementPresent = false;
		List<WebElement> selectedCriteria = getElements(facetSelectedBarItem);
		for (WebElement item : selectedCriteria) {
			if(item.getText().contains(arg1)){
				elementPresent = true;
				return;
			}
		}
		Assert.assertTrue(elementPresent,  "Facet selected bar does't contain " + arg1 + " value");
	}
	
	@Override
	protected By getUniqueElement() {
		return facetSearchBar;
	}
}