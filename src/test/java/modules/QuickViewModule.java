package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import cucumber.api.java.en.Then;
import utils.AbstractContainer;

public class QuickViewModule extends AbstractContainer{

	By quickViewModal = By.cssSelector("#modal > .pdp");
	
	@Then("^system displays Quick View Modal$")
	public void system_displays_Quick_View_Modal() throws Throwable {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(quickViewModal));
		Assert.assertTrue(getElement(quickViewModal).isDisplayed(), "System doesn't display Quick View Modal");
	}
	
	@Override
	protected By getUniqueElement() {
		// TODO Auto-generated method stub
		return quickViewModal;
	}
	

}
