package modules;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;

import pages.LoginPage;
import cucumber.api.java.en.When;
import utils.AbstractContainer;

public class FacebookLoginModule extends AbstractContainer {

	By emailFB = By.cssSelector("input#email.inputtext");
	By passFB = By.cssSelector("input#pass.inputpassword");
	By fbLogin = By.cssSelector("#dialog_buttons > #loginbutton > input#u_0_2");
	By fbError = By.cssSelector(".login_error_box[role=\"alert\"]");

	public void atFBLoginPage() {
		isLoaded();
	}

	@When("^user enter Facebook data$")
	public void user_enter_fecebook_data(List<String> fbData) throws Throwable {
		sleepFor(2500);
		
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Assert.assertTrue(getElement(emailFB).isDisplayed(),
				"No FB login field");
		
		getElement(emailFB).sendKeys(fbData.get(0));
		getElement(passFB).sendKeys(fbData.get(1));
		
		getElement(fbLogin).click();
		
	
		
		try{
			driver.close();
		}catch(Exception ex){}
		
		
		sleepFor(3000);
		driver.switchTo().window(LoginPage.winHandleBefore);
		
	}

	@Override
	protected By getUniqueElement() {
		return fbLogin;
	}

}
