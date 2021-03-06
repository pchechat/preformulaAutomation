package pages;

import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.AbstractContainer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoppingCartPage extends AbstractContainer {

	By cartUpdateItems = By.cssSelector("#cartUpdateItems");
	By cartUpdateItemss = By.cssSelector("#cartUpdateItems");
	By cartRomoveItem = By.cssSelector(".red");
	By proceedToCheckoutBtn = By
			.cssSelector("[onclick=\"moveToPurchase('cartUpdateItems'); return false;\"]");
	By interCheckoutBtn = By
			.cssSelector("[onclick=\"return goToInternationalCheckout('cartUpdateItems')\"]");
	By expressCheckoutBtn = By.cssSelector(".cart-express > a");
	By errorMsg = By
			.cssSelector("#cart-content > [class=\"message message-red\"] > p");
	By productHolders = By.cssSelector(".item-cart > li");
	By productName = By.cssSelector("a > .item-title");
	By autoshipForItem = By.cssSelector(".autoship");
	By pricePerUnitItem = By.cssSelector(".item-price-single");
	By itemQtyInput = By.cssSelector(".form-qty-box > input");
	// By updateQtyProductBtn =
	// By.cssSelector("[onclick=\"cartItemUpdate();return false;\"]");
	//By updateQtyProductBtn = By.cssSelector(".first > a");
	By updateQtyProductBtn = By.cssSelector(".item-actions > .first > a");
	By itemPrice = By.cssSelector(".item-price-total");
	By promoCodeFld = By.cssSelector("[onkeypress=\"submitOnEnter(event, cartApplyCoupon)\"]");
	By applyPromoBtn = By.cssSelector("[onclick=\"cartApplyCoupon();\"]");
	By promoFld = By.cssSelector("#cartPromo1>dt");
	By removePromoBtn = By.cssSelector("#cartPromo1>dt>a[title=\"Remove\"]");
	By totalPrice = By.cssSelector("dd.totals-final");
	
	// By totalPrice = By.cssSelector("#orderTotalSpan");
	float initialTotal = 0;

	@Then("^system redirects user to Shopping cart page$")
	public void onShoppingAddressPage() {
		isLoaded();
	}

	@Given("^user has product in Your Shopping Cart page$")
	public void productInCart() {
		Assert.assertTrue(getElement(cartUpdateItems).isDisplayed());
	}

	@When("^user clicks 'Proceed to checkout' button$")
	public void toCheckout() throws Throwable {
		sleepFor(3500);
		getElement(proceedToCheckoutBtn).click();
	}

	@When("^user clicks on 'International Checkout' button$")
	public void toInternatiolCheckout() throws Throwable {
		sleepFor(1500);
		getElement(interCheckoutBtn).click();
	}

	@When("^user clicks on 'Remove' link for item \"([^\"]*)\" that should be present in list on Shopping Cart Page$")
	public void removeItem(String product) throws Throwable {
		sleepFor(2500);
		List<WebElement> presentItems = getElements(productHolders);
		for (WebElement item : presentItems) {
			if (item.getText().contains(product)) {
				item.findElement(cartRomoveItem).click();
			}

		}
	}

	@Given("^user increase quantity to '(\\d+)' for \"([^\"]*)\" that should be present in list on Shoping Cart page$")
	public void changeProductQuantity(int qty, String product) throws Throwable {

		List<WebElement> products = getElements(productHolders);
		for (WebElement item : products) {
			WebElement productTitle = item.findElement(productName);
			if (productTitle.getText().replace("eligible", "").trim().equals(product)) {
				String pQuantity = Integer.toString(qty);
				WebElement qInput = item.findElement(itemQtyInput);
				qInput.clear();
				qInput.sendKeys(pQuantity);
			}

		}

	}

	@Then("^system updates the quantiy to '(\\d+)' for \"([^\"]*)\"  product$")
	public void checkQty(int qty, String product) throws Throwable {
		sleepFor(1500);
		List<WebElement> products = getElements(productHolders);
		for (WebElement item : products) {
			WebElement productTitle = getElement(productName);
			if (productTitle.getText().equals(product)) {
				String pQuantityExpected = Integer.toString(qty);
				String pQuantityActual = item.findElement(itemQtyInput).getAttribute("value");
						
				Assert.assertEquals(pQuantityExpected, pQuantityActual);
				return;
			}
		}
	}

	@Then("^item \"([^\"]*)\" that should be present in list on Shoping Cart page$")
	public void itemIsPresent(String arg1) throws Throwable {
		sleepFor(1500);
		List<WebElement> products = getElements(productHolders);
		for (WebElement item : products) {
			String productTitle = item.findElement(productName).getText();
//			Assert.assertEquals(productTitle, arg1, "product " + arg1
//					+ "absent in list");
			Assert.assertTrue(productTitle.contains(arg1), "Product " + arg1
					+ "absent in list");
			break;
		}
	}

	@Then("^system displays autoship information for \"([^\"]*)\" item$")
	public void autoshipInformationIsPresent(String product)
			throws Throwable {
		List<WebElement> products = getElements(productHolders);
		for (WebElement item : products) {
			WebElement productTitle = item.findElement(productName);
			if (productTitle.getText().equals(product)) {
				Assert.assertTrue(getElement(autoshipForItem).isDisplayed(),
						"Autoship properties for " + product
								+ " is not displayed on Shoping Cart list");
			}
		}
	}

	@Then("^system displays price per unit for \"([^\"]*)\" item on Shoping Cart page$")
	public void pricePerUnitInformationIsPresent(
			String product) throws Throwable {
		List<WebElement> products = getElements(productHolders);
		for (WebElement item : products) {
			WebElement productTitle = item.findElement(productName);
			if (productTitle.getText().equals(product)) {
				Assert.assertTrue(getElement(pricePerUnitItem).isDisplayed(),
						"Price per unit for " + product
								+ " is not displayed on Shoping Cart list");
				return;
			} else {
				System.out.println("Product " + product
						+ " no found in shoping cart list");
			}
		}
	}

	@Then("^system displays quantity of product for \"([^\"]*)\" item on Shoping Cart page$")
	public void quantityItem(
			String product) throws Throwable {
		List<WebElement> products = getElements(productHolders);
		for (WebElement item : products) {
			WebElement productTitle = item.findElement(productName);
			if (productTitle.getText().equals(product)) {
				Assert.assertTrue(getElement(itemQtyInput).isDisplayed(),
						"Quantity for " + product
								+ " is not displayed on Shoping Cart list");
				return;
			}
		}
	}

	@Then("^system displays total price for \"([^\"]*)\" item on Shoping Cart page$")
	public void totalPriceForItem(
			String product) throws Throwable {
		List<WebElement> products = getElements(productHolders);
		for (WebElement item : products) {
			WebElement productTitle = item.findElement(productName);
			if (productTitle.getText().equals(product)) {
				Assert.assertTrue(getElement(itemPrice).isDisplayed(),
						"Sysytem doesn't display item total price for "
								+ product);
			}
		}
	}

	@Then("^system display order total price$")
	public void orederTotalPrice() throws Throwable {
	   Assert.assertTrue(getElement(totalPrice).isDisplayed(), "Order total price is not displaying");
	}
	
	@When("^user press on 'Update Cart' link for item \"([^\"]*)\" that should be present in list on Shoping Cart page$")
	public void updateQtyProduct(String product) throws Throwable {
		sleepFor(1500);
		List<WebElement> products = getElements(productHolders);
		for (WebElement item : products) {
			WebElement productTitle = item.findElement(productName);
			if (productTitle.getText().replace("eligible", "").trim().equals(product)) {
				item.findElement(updateQtyProductBtn).click();
				break;
			}
		}
	}

	@When("^user enter \"([^\"]*)\" in promo code field$")
	public void promoInput(String promo) throws Throwable {
		sleepFor(2000);
		initialTotal = convertPrice(getElement(totalPrice).getText());
		getElement(promoCodeFld).sendKeys(promo);
	}

	@When("^user clicks on 'Apply' button$")
	public void promoApply() throws Throwable {
		getElement(applyPromoBtn).click();
	}

	@Then("^system displays \"([^\"]*)\" code name and amount of saving in order price area$")
	public void promoCodeDisplayed(String arg1) throws Throwable {
		sleepFor(2000);
		String promoName;
		promoName = getElement(promoFld).getText();
		Assert.assertTrue(promoName.contains(arg1), "Promo code '" + arg1
				+ "' is not found in " + promoName);
	}

	@Then("^system recalculates order total price considering applied promo code value")
	public void recalculateTotal() throws Throwable {
		sleepFor(1500);
		float actualTotal = convertPrice(getElement(totalPrice).getText());
		
		Assert.assertTrue(getElement(totalPrice).isDisplayed());
		
		Assert.assertTrue(actualTotal < initialTotal,
				"Actual total price is not less then Initial  total price");
	}

	@Then("^system recalculates order total price$")
	public void checkTotalPrice() throws Throwable {
		sleepFor(1500);
		float actualTotal = convertPrice(getElement(totalPrice).getText());
		System.out.println(actualTotal);
		Assert.assertTrue(getElement(totalPrice).isDisplayed());
		Assert.assertTrue(actualTotal > initialTotal,
				"Actual total price is not more then Initial total price");
	}

	@When("^user click on 'Express Checkout' button$")
	public void toExpressCheckout() throws Throwable {
		sleepFor(3000);
		getElement(expressCheckoutBtn).click();
	}

	@Then("^item \"([^\"]*)\" should be absent in list on Shopping Cart Page$")
	public void productPresentVerify(String product) throws Throwable {
		sleepFor(2500);
		boolean itemAbsent = true;
		List<WebElement> products = getElements(productHolders);
		for (WebElement item : products) {
			// WebElement productTitle = getElement(productName);
			if (item.findElement(productName).getText().equals(product)) {
				itemAbsent = false;
			}
		}
		Assert.assertTrue(itemAbsent, product + " Present in Shoping Cart list");
	}

	private float convertPrice(String sPrice) {
		String[] allTextPrice = sPrice.split(Pattern.quote("$"));
		// System.out.println(allTextPrice);
		String textPrice = allTextPrice[1];
		float price = Float.parseFloat(textPrice);
		return price;
	}

	@When("^user doesnt have applied promo code$")
	public void userDoesntHavePromo() throws Throwable {
	 
		if(getElements(promoFld).size()>0){
			
			getElement(removePromoBtn).click();
		}
		
	}
	
	@Override
	protected By getUniqueElement() {
		return cartUpdateItems;
	}
}
