package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.AbstractContainer;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CompareProductsPage extends AbstractContainer{

	By compareTable = By.cssSelector(".compare-show");
	By addToCardBtn = By.cssSelector("[class=\"button button-cart\"]");
	By productsSet = By.cssSelector("div.item-item");
	private By inStockProductSet = By.cssSelector("span.item-status.green");
	
	
	
	@Then("^system redirects user to Compare Product page$")
	public void onCompareProductPage() throws Throwable {
		isLoaded();
	}
	
	@When("^user clicks 'Add to cart' button on Compare Product Page$")
	public void addToCart() {
		int i = getProductIndex();
		Assert.assertTrue(i>=0, "No product in stock was found");
		List<WebElement> elements = getElements(addToCardBtn);
		elements.get(i).click();
	}
	
	public int getProductIndex() {
		int i = 0;
		List<WebElement> elements = getElements(productsSet);
		while (elements.size() >= i) {
			if (elements.get(i).findElement(inStockProductSet) != null) {
				return i;
			}
			i++;
		}
		return -1;
	}
	
	@Override
	protected By getUniqueElement() {
		return compareTable;
	}

}
