package pages;

import java.util.List;

import org.openqa.selenium.By;

import utils.AbstractContainer;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SurvayPage extends AbstractContainer{
	

	By survayForm = By.cssSelector("#surveyForm");
	By bdayMonth = By.cssSelector("#acc_month");
	By bdayDay = By.cssSelector("#acc_day");
	By bdayYear = By.cssSelector("#acc_year");
	By accPersonalize = By.cssSelector(".form-check");
	
	
	@Then("^system redirects user to Thank you Registration page / Survey page$")
	public void isLoad(){
		isLoaded();
	}
	
	
	@When("^user enter additional data on Survey page$")
	public void user_enter_additional_data_on_Survey_page(List<String> arg1) throws Throwable {
		selectVisibleTextBy(bdayMonth, arg1.get(0));
		selectVisibleTextBy(bdayDay, arg1.get(1));
		selectVisibleTextBy(bdayYear, arg1.get(2));
	}

	@When("^click \"([^\"]*)\" button$")
	public void click_button(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    throw new PendingException();
	}

	@Override
	protected By getUniqueElement() {
		return survayForm;
	}

}
