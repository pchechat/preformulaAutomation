package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.AbstractContainer;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyProfilePage extends AbstractContainer{

	static String url = "https://stage.pureformulas.com/account/profile.jsp";
	By editProfileButton = By.cssSelector("a.button");
	By MNameFld = By.cssSelector("#acc_middleInitial");
	By SaveChngBtn = By.cssSelector("[onclick=\"return accountUpdate();\"]");
	By profileInfo = By.cssSelector("dl.form");
	
	@When("^user change middle name to \"([^\"]*)\"$")
	public void user_change_middle_name_to(String mname) throws Throwable {
	    getElement(MNameFld).clear();
		getElement(MNameFld).sendKeys(mname);
	}
	
	
	@When("^user clicks on 'Save changes' button$")
	public void user_clicks_on_Save_changes_button() throws Throwable {
	    getElement(SaveChngBtn).click();
	}
	
	@Then("^system displays an updated name \"([^\"]*)\" on My Profile Page$")
	public void updateProfileInfo(String name) throws Throwable {
		boolean namePresent = false;
		List<WebElement> pInfo = getElements(profileInfo);
	    for (WebElement webElement : pInfo) {
			if(webElement.getText().contains(name)){
				namePresent = true;
			}
		}
	    Assert.assertTrue("Name is absent", namePresent);
	}
	
	@Then("^system displays an updated My Profile information$")
	public void system_displays_an_updated_My_Profile_information(List<String> arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    // For automatic conversion, change DataTable to List<YourType>
	    throw new PendingException();
	}
	
	@Override
	protected By getUniqueElement() {
		return editProfileButton;
	}

}
