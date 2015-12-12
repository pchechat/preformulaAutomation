package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import utils.AbstractContainer;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PasswordForgotPage extends AbstractContainer {

	By forgotPaswForm = By.cssSelector("#forgotPassword");
	By emailFld = By.cssSelector("#acc_login");
	By continueButton = By.cssSelector(".button[onclick=\"return forgotPassword();\"]");
	By successMsg = By.cssSelector("#success > p > b");
	
	@When("^user sends reset request for \"([^\"]*)\" email$")
	public void sendResetRequest(String email){
		getElement(emailFld).sendKeys(email);
		Assert.assertEquals(getElement(emailFld).getAttribute("value"), email);
		getElement(continueButton).click();
	}
	
	@Then("^System displays confirmation message  \"([^\"]*)\"$")
	public void validateConfirmationMsg(String expectedMessage){
		Assert.assertEquals(getElement(successMsg).getText(), expectedMessage);
	}
	
	@Then("^user recevies email with a link for password reset$")
	public void user_recevies_email_with_a_link_for_password_reset() throws Throwable {
		//TODO: add POP3/SMTP check for new email
	}

	@Override
	protected By getUniqueElement() {
		return forgotPaswForm;
	}

}
