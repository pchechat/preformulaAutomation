package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import utils.AbstractContainer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPage extends AbstractContainer {

	static String url = "https://stage.pureformulas.com/account/login.jsp";
	By emailFld = By.cssSelector("#login_email");
	By passFld = By.cssSelector("#login_password");
	//By continueBtn = By.cssSelector("[onclick=\"return login('0','','checkout');\"]");
	By loginBtn = By.cssSelector("input[onclick=\"return login('0','');\"]");
	By continueBtn = By.cssSelector(".form-submit > input.button");
	By loginLink = By.cssSelector("a[href='/account/login.jsp']");
	By registerLink = By.cssSelector("a[href='/account/register.jsp']");
	By forgotpassLink = By
			.cssSelector("a[href='/account/password-forgot.jsp']");
	By RemembermeChkBx = By.cssSelector("#rememberMe");
	By errorMessageContainer = By.cssSelector("#error");
	By FacebookBtn = By.cssSelector("[onclick=\"pd_fb_login2('0','');\"]");
	By checkoutLoginBtn = By.cssSelector("input.button:nth-child(5)");
	public static String winHandleBefore;
	
	
	@Then("^system redirects user to Login page$")
	public void atLoginPage() {
		sleepFor(3000);
		isLoaded();
	}

	@Given("^user is on Login page$")
	public void toLoginPage() {
		driver.get(url);
		sleepFor(3000);
		atLoginPage();
	}

	@When("^user clicks 'Login with Facebook' button$")
	public void loginFacebook() {
		winHandleBefore = driver.getWindowHandle();
		getElement(FacebookBtn).click();
	}

	@Given("^user is logged in the system with credentials$")
	public void doLogin(List<String> data) {
		if (elementExist(By.cssSelector("a[href=\"/account/login.jsp\"]"))) {
	
			navigateTo(url);
			sleepFor(2500);
			isLoaded();
		
			doLogin(data.get(0), data.get(1));
			
			click(loginBtn);
			
			sleepFor(4000);
			
		}
	}

	public void doLogin(String email, String password) {
		
		enterEmail(email);
		enterPassword(password);
		/*try {

			clickContinueBtn();
			
		} catch (Exception e) {
			
			try {
				clickLoginBtn();
			} catch (Exception e2) {
			
			}
		}*/

	}

	@When("^user enters in Email address field \"([^\"]*)\"$")
	public void enterEmail(String email) {
		driver.findElement(emailFld).sendKeys(email);
		Assert.assertEquals(getElement(emailFld).getAttribute("value"), email);
	}

	@When("^user enters in Password field \"([^\"]*)\"$")
	public void enterPassword(String pass) {
		getElement(passFld).sendKeys(pass);
	}

	public void setRememberMe(boolean check) {

	}

	@Given("^user on reset password page$")
	public void clickForgetPassword() {
		getElement(forgotpassLink).click();
	}

	@Then("^system shows \"([^\"]*)\" on login page$")
	public void validateErrorMsg(String expectedMsg)
			throws InterruptedException {

		Thread.sleep(1000);
		String actualMsg = getElement(errorMessageContainer).getText();
		System.out.println(actualMsg);
		Assert.assertEquals(actualMsg, expectedMsg);
	}

	@When("^user clicks checkout Login button$")
	public void clickContinueBtn() {
		getElement(checkoutLoginBtn).click();
	}

	@When("^user clicks Login button$")
	public void clickLoginBtn() {
		getElement(loginBtn).click();
	}

	public void clickFacebookLoginBtn() {

	}

	@Then("^Login and Register link present on the page$")
	public void isUserGuest() {
		try {
			Assert.assertTrue(getElement(loginLink).isDisplayed());
		} catch (NoSuchElementException ex) {
			System.out.println(ex.getMessage());
		}
	}

	@When("^user clicks 'Forgot password' link$")
	public void clickForgotPassword() {
		getElement(forgotpassLink).click();
	}

	@Given("^user is on log in page$")
	public void user_is_on_log_in_page() throws Throwable {
	   navigateTo(url);
	}

	@Given("^user enters:$")
	public void user_enters(List<String> mess) throws Throwable {
                	getElement(emailFld).sendKeys(mess.get(0));
                	getElement(passFld).sendKeys(mess.get(1));
		
	}

	@When("^user clicks button$")
	public void user_clicks_button() throws Throwable {
	    getElement(continueBtn).click();
	}
	
	
	@Override
	protected By getUniqueElement() {
		return emailFld;
	}

}