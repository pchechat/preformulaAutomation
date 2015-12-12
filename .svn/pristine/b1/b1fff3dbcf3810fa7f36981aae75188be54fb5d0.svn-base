package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import utils.AbstractContainer;
import cucumber.api.java.en.Then;

public class MessagesModule extends AbstractContainer{
	By addToCartNotifyMsg = By.cssSelector(".add-to-cart-notify");
	//By addToCartNotifyMsg = By.cssSelector("#addToCartNotifyMsgDivComparison");
	By successMsg = By.cssSelector("#success");
	By errorMsg = By.cssSelector("#error");
	
	@Override
	protected By getUniqueElement() {
		return null;
	}
	
	@Then("^system displays success message \"([^\"]*)\"$")
	public void successMessage(String expectedMsg){
		wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg));
		String actualMsg = getElement(successMsg).getText();
		Assert.assertEquals(actualMsg, expectedMsg);
	}

	@Then("^system displays error message \"([^\"]*)\"$")
	public void errorMessage(String expectedMsg){
		sleepFor(5000);
		String actualMsg = getElement(errorMsg).getText();
		Assert.assertEquals(actualMsg, expectedMsg);
	}
	
	@Then("^system displays confirmation message \"([^\"]*)\"$")
	public void confirmationMessage(String expectedMsg){
		wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartNotifyMsg));
		String actualMsg = getElement(addToCartNotifyMsg).getText();
		//Assert.assertEquals(actualMsg, expectedMsg);
		
		System.out.println(actualMsg);
		Assert.assertTrue(actualMsg.contains(expectedMsg), "Actual message not equal expected");
	    
	}
}