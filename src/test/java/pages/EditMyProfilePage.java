package pages;

import org.openqa.selenium.By;

import utils.AbstractContainer;

public class EditMyProfilePage extends AbstractContainer{

	static String url ="https://stage.pureformulas.com/account/profile-edit.jsp";
	By firstName = By.cssSelector("#acc_firstName");
	By lastName = By.cssSelector("#acc_lastName");
	By emailAddress = By.cssSelector("#acc_email");
	By confirmEmailAddress = By.cssSelector("#acc_confirmEmail");
	By specialOffersChkBx = By.cssSelector(".account-email-show");
	By phoneNumber = By.cssSelector("#acc_phoneNumber");
	By altPhoneNumber = By.cssSelector("#acc_phoneNumberAlt");
	By newPassword = By.cssSelector("#acc_password");
	By confirmNewPassword = By.cssSelector("#acc_confirmPassword");
	By birthdayMonthSelect = By.cssSelector(".select[name='/atg/userprofiling/ProfileFormHandler.value.month']");
	By birthdayDaySelect = By.cssSelector(".select[name='/atg/userprofiling/ProfileFormHandler.value.day']");
	By birthdayYearSelect = By.id("acc_year");

	
	
	
	@Override
	protected By getUniqueElement() {
		
		return confirmEmailAddress;
	}

}
