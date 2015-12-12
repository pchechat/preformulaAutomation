package pages;

import org.openqa.selenium.By;

import utils.AbstractContainer;
import cucumber.api.java.en.When;

public class ForgotPasswordPage extends AbstractContainer{

	static String url = "https://stage.pureformulas.com/account/password-forgot.jsp";
	By emailField = By.cssSelector("#acc_login");
	By continueButton = By.cssSelector(".button[onclick=\"return forgotPassword();\"]");
	
	@Override
	protected By getUniqueElement() {
		return continueButton;
	}

	@When("^user enters in Email address field \"([^\"]*)\"  on Forgot Password page$")
	public void enterEmailResetPass(String email) throws Throwable {
	    getElement(emailField).sendKeys(email);
	}
	
	@When("^user clicks Continue button on Forgot Password page$")
	public void clickContinueBtnForgotPsw() throws Throwable {
	    getElement(continueButton).click();
	}
}
