package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.AbstractContainer;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PaymentPage extends AbstractContainer {

	static String url = "https://stage.pureformulas.com/account/payment.jsp";

	By addNewCardLink = By.cssSelector("a[href='/account/payment-detail.jsp']");
	By editLinkSet = By.cssSelector("a");
	By deleteLinkSet = By.cssSelector(".red");
	By paymentSet = By.cssSelector(".account-list > li");

	@Given("^user is on Credit cards page$")
	@When("^user is on Credit card page$")
	public void atPaymentPage() {
		isLoaded();
	}

	@When("^user clicks 'Add a New Card' button$")
	public void clickAddCreditCard() {
		getElement(addNewCardLink).click();
	}

	@Then("^no credit cards are present on the Credit Cards page$")
	public void noCreditCards() {
		try {
			Thread.sleep(3000);
			driver.navigate().refresh();
			Assert.assertEquals(getElement(paymentSet).getSize(), 0);
		} catch (Exception ex) {
		}
	}

	@When("^user press on 'Edit' link for item \"([^\"]*)\" that should be present in list on Credit Cards page$")
	public void user_press_on_Edit_link_for_item_that_should_be_present_in_list_on_Credit_Cards_page(String arg1) throws Throwable {
		List<WebElement> cardItem = getElements(paymentSet);
		for (WebElement item : cardItem) {
			if (item.getText().contains(arg1)) {
				item.findElement(editLinkSet).click();
				return;
			}
		}
	}
	
	@Given("^user press on 'Delete' link for item \"([^\"]*)\" that should be present in list on Credit Cards page$")
	public void deleteCreditCard(String arg1) throws Throwable {
		List<WebElement> cardItems = getElements(paymentSet);
		for (WebElement item : cardItems) {
			if (item.getText().contains(arg1)) {
				item.findElement(deleteLinkSet).click();
				return;
			}
		}
	}

	@Then("^credit card \"([^\"]*)\" should be present in credit card list$")
	public void cardPresent(String cardName) throws Throwable {
		sleepFor(2000);
		boolean cardPresent = false;
	    List<WebElement> cardItem = getElements(paymentSet);
	    for (WebElement item : cardItem) {
	    	if(item.getText().contains(cardName)){
	    		cardPresent = true;
	    		
	    	}
			
		}
	    Assert.assertTrue(cardPresent, "Card " + cardName + " is absent in credit card list"); 
	}
	
	
	
	
	@Then("^credit card \"([^\"]*)\" should be absent in credit card list$")
	public void cardAbsent(String arg1) throws Throwable {
		sleepFor(2000);
	    boolean cardAbsent = true;
	    List<WebElement> cardItem = getElements(paymentSet);
	    for (WebElement item : cardItem) {
			if(item.getText().contains(arg1)){
				//System.out.println("Contains " + item.getText().replace("\n", "|"));
				cardAbsent = false;
				Assert.assertTrue(cardAbsent, "Element \"" + arg1 + "\" present in credit card list");
			}
	    }
	}

	@When("^user deletes all credit cards$")
	public void deleteAllCards() {
		for (WebElement element : getElements(paymentSet)) {
			element.findElement(deleteLinkSet).click();
		}
	}

	@Then("^system displays an updated Credit Card page$")
	public void system_displays_an_updated_Credit_Card_page(List<String> arg1)
			throws Throwable {
		// Express the Regexp above with the code you wish you had
		// For automatic conversion, change DataTable to List<YourType>
		throw new PendingException();
	}

	

	@Override
	protected By getUniqueElement() {
		return addNewCardLink;
	}

}
