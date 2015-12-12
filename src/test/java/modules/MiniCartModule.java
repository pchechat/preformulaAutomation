package modules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.AbstractContainer;

public class MiniCartModule extends AbstractContainer{
	By miniCartItem = By.cssSelector(".item-minicart > li");
	By removeMiniCartItem = By.cssSelector(".item-remove");
	private By miniCart = By.cssSelector("#minicart-li");;

	@When("^user clicks on 'Remove' link for item \"([^\"]*)\" that should be present in mini-cart list$")
	public void removeItemFromMiniCart(String arg1) throws Throwable {
	    sleepFor(2500);
	    hoverElement(miniCart);
		List<WebElement> products = getElements(miniCartItem);
	    for (WebElement item : products) {
			if(item.getText().contains(arg1)){
				item.findElement(removeMiniCartItem).click();
			}
		}
	}
	
	@Then("^item \"([^\"]*)\" should be absent in mini-cart list$")
	public void elementAbsent(String arg1) throws Throwable {
	  boolean itemAbsent = true;
	  hoverElement(miniCart);
	  Assert.assertTrue(getElement(miniCart).isDisplayed());
	  List<WebElement> products = getElements(miniCartItem);
	    for (WebElement item : products) {
	    	if(item.getText().contains(arg1)){
	    		itemAbsent = false;
	    	}
	    }
	    Assert.assertTrue(itemAbsent, arg1 + "present in mini-cart list");
	}
	
	@Override
	protected By getUniqueElement() {
		// TODO Auto-generated method stub
		return null;
	}

}
