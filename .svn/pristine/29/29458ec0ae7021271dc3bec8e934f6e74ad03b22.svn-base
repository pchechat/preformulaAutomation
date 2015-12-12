package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utils.AbstractContainer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FavoritesPage extends AbstractContainer {

	By accFavorites = By.cssSelector("#acc-favorites");
	By elementHolders = By.cssSelector("[class=\"item item-cart\"] > li");
	//By elementHolders = By.cssSelector(".item-cart > li");
	By titleElement = By.cssSelector(".item-title > a");
	By addToCartBtn = By.cssSelector(".item-actions > .first > a");
	By updateFavBtn = By.cssSelector(".item-actions > .first > a");
	By removeFavBtn = By.cssSelector(".item-actions > .last > a");
	By itemQtyInput = By.cssSelector(".form-qty-box > input");
	

	@Given("^user is on Favorites page in My Account area$")
	public void atFavoritesPage() {
		isLoaded();
	}

	@Given("^user press on 'Add to Cart' link for item \"([^\"]*)\" that should be present in list on Favorites Settings page$")
	public void itemPresentInFavList(String favProduct) throws Throwable {
		wait.until(ExpectedConditions.visibilityOfElementLocated(accFavorites));
		boolean elementPresent = false;
		List<WebElement> favoriteItem = getElements(elementHolders);
		for (WebElement item : favoriteItem) {
			WebElement elementTitle = item.findElement(titleElement);
			System.out.print(elementTitle);
			if (elementTitle.getText().equals(favProduct)) {
				elementPresent= true;
				item.findElement(addToCartBtn).click();
				break;
			}
		}

		Assert.assertTrue(favProduct + " doesnt display in Favorites", elementPresent);
		
	}

	@Then("^user press on 'Update Favorites' link for item \"([^\"]*)\" that should be present in list on Favorites Settings page$")
	public void updateFavoriteItem(String favProduct) throws Throwable {
		List<WebElement> favoriteItem = getElements(elementHolders);
		for (WebElement item : favoriteItem) {
			WebElement elementTitle = item.findElement(titleElement);
			if (elementTitle.getText().equals(favProduct)) {
				item.findElement(updateFavBtn).click();
				return;
			}
		}
	}

	@When("^user press on 'Remove' link for item \"([^\"]*)\" that should be present in list on Favorites Settings page$")
	public void removeItemFromFavList(
			String favProduct) throws Throwable {
		List<WebElement> favoriteItem = getElements(elementHolders);
		for (WebElement item : favoriteItem) {
			WebElement elementTitle = item.findElement(titleElement);
			if (elementTitle.getText().equals(favProduct)) {
				item.findElement(removeFavBtn).click();
				return;
			}
		}
	}

	@Then("^user increase quantity to '(\\d+)' for \"([^\"]*)\" that should be present in list on Favorites Settings page$")
	public void increaseQuantityFavProd(
			int qty, String favProduct) throws Throwable {
		List<WebElement> favoriteItem = getElements(elementHolders);
		for (WebElement item : favoriteItem) {
			WebElement elementTitle = item.findElement(titleElement);
			if (elementTitle.getText().equals(favProduct)) {
				String sQuantity = Integer.toString(qty);
				WebElement qInput = item.findElement(itemQtyInput);
				qInput.clear();
				qInput.sendKeys(sQuantity);
			}
		}
	}

	@Override
	protected By getUniqueElement() {
		return accFavorites;
	}
}
