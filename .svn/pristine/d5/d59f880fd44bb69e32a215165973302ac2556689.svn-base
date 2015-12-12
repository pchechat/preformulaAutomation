package modules;

import org.openqa.selenium.By;

import utils.AbstractContainer;
import cucumber.api.java.en.Then;

public class AvsModule extends AbstractContainer {

	By avsModalWnd = By.cssSelector("#addressOkDiv");
	By avsValidatedValues = By.cssSelector("[name=i-address-entry]");
	By continueBtn = By.cssSelector("#addressOkDiv > div > a.button");

	@Then("^AVS check pass validation$")
	public void selectSugestedAddress() {
		sleepFor(1500);
		try {
			selectRadioBox(findElementByAttributeValue(avsValidatedValues,"value", "AVS_VALIDATED=true"));
			getElement(continueBtn).click();
		} catch (NullPointerException ex) {
			System.out.println("No suggested address was found");
		}
	}

	@Override
	protected By getUniqueElement() {
		return avsModalWnd;
	}
}
