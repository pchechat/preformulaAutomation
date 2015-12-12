package pages;

import java.util.List;

import org.openqa.selenium.By;

import utils.AbstractContainer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class RegisterPage extends AbstractContainer {

	static String url = "https://stage.pureformulas.com/account/register.jsp";

	EditMyProfilePage editPage = new EditMyProfilePage(); 
	AddressPage addrPage = new AddressPage();
	
	By emailaddressFld = By.cssSelector("#acc_email");
	By comfirmEmailFld = By.cssSelector("#acc_confirmEmail");
	By promoSignChkBx = By.cssSelector("#acc_promosign");
	By passwordFld = By.cssSelector("#acc_password");
	By passwordConfFld = By.cssSelector("#acc_confirmPassword");
	By termsCondChckBox = By.cssSelector("#acc_terms_cond");
	By firstName = editPage.firstName;
	By lastName = editPage.lastName;
	By addrFld1 = addrPage.address1Fld;
	By city = addrPage.cityFld;
	By state = addrPage.stateSelect;
	By zipFld = addrPage.zipFld;
	By phoneFld = addrPage.phoneFld;
	
	By createAccBtn = By
			.cssSelector(".button[onclick=\"return accountRegister()\"]");


	@Given("^user is on Registration page$")
	public void isLoad() {
		navigateTo(url);
		isLoaded();
	}

	@When("^user enters registration data$")
	public void setCredentials(List<String> credentialsData) {
		sleepFor(2000);
		String email = textGenerator(credentialsData.get(7));
		getElement(firstName).sendKeys(credentialsData.get(0));
		getElement(lastName).sendKeys(credentialsData.get(1));
		getElement(addrFld1).sendKeys(credentialsData.get(2));
		getElement(city).sendKeys(credentialsData.get(3));
		selectVisibleTextBy(state, credentialsData.get(4));
		getElement(zipFld).sendKeys(credentialsData.get(5));
//		getElement(phoneFld).sendKeys(credentialsData.get(6));
		getElement(emailaddressFld).sendKeys(email);
		getElement(comfirmEmailFld).sendKeys(email);
		getElement(passwordFld).sendKeys(credentialsData.get(8));
		getElement(passwordConfFld).sendKeys(credentialsData.get(8));
		sleepFor(1000);
		specialInput(phoneFld, credentialsData.get( 6));
		sleepFor(1000);
		getElement(phoneFld).click();
		getElement(termsCondChckBox).click();
		
	}

	@When("^user accepting term of use and privacy policy marking checkbox$")
	public void acceptUserTerms() {
		getElement(termsCondChckBox).click();
	}

	@When("^user clicks Create my account button$")
	public void clickCreateAccount() {
		getElement(createAccBtn).click();
		sleepFor(2500);
		checkForErrors(By.cssSelector("#error"), "");
	}

	@Override
	protected By getUniqueElement() {
		return termsCondChckBox;
	}

}