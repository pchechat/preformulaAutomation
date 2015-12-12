package pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.AbstractContainer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductListingPage extends AbstractContainer {

	By compareArea = By.cssSelector(".compare-bar");
	By compareNowBtn = By
			.cssSelector("[onclick=\"return goToComparisonPage();\"]");
	By productItem = By.cssSelector(".item-grid > li.item-item");
	By itemTitle = By.cssSelector("li > .item-title");
	By itemThumb = By.cssSelector("item-qv-wrap > a > .item-thumb");
	By itemCmpareBtn = By.cssSelector("[name=\"compareCheck\"]");
	By compareThumbItems = By.cssSelector(".compare-list > li");
	By removeThumbItem = By.cssSelector("[title=\"Remove\"]");
	By pegenationPage = By.cssSelector(".pagination-paging > li > a");
	By previousPage = By.cssSelector(".pagination-paging > li.paging-left > a");
	private By SelectedPage = By
			.cssSelector(".pagination-paging > li > strong");
	By sortByDropdown = By.cssSelector(".pagination-sorting > select");
	// By sortByDropdown =
	// By.cssSelector("[onchange=\"location = this.options[this.selectedIndex].value\"]");
	private List<String> actualSorting = new ArrayList<String>();

	@Given("^user clicks 'Compare' button for first (\\d+) products$")
	public void compareProducts(int max) throws Throwable {
		int i = 0;
		List<WebElement> productList = getElements(productItem);

		for (WebElement item : productList) {
			   sleepFor(1500);
			   if (item.findElement(itemCmpareBtn).isSelected() == false)
			   item.findElement(itemCmpareBtn).click();
			   i++;
			   if (i >= max) {
			    return;
			   }
			  }

	}

	@When("^user clicks button 'X' to delete first (\\d+) product from comparison$")
	public void removeCompareItem(int rm) throws Throwable {
		int i = 0;
		List<WebElement> compareList = getElements(compareThumbItems);
		for (WebElement compareItem : compareList) {
			compareItem.findElement(removeThumbItem).click();
			i++;
			if (i >= rm) {
				return;
			}
		}
	}

	@Then("^(\\d+) product remane for compare$")
	public void product_remane_for_compare(int expected) throws Throwable {
		sleepFor(1500);
		List<WebElement> compareList = getElements(compareThumbItems);
		Assert.assertEquals(compareList.size(), expected,
				"Expected item in compare list is not equal actual");
	}

	@When("^user clicks 'Compare Now' button$")
	public void toCompareProductPage() throws Throwable {
		sleepFor(1500);
		getElement(compareNowBtn).click();
	}

	@Given("^user navigate to \"([^\"]*)\" page from pegination area$")
	public void navigateToSelectPage(String arg1) throws Throwable {
		sleepFor(1500);
		if (!checkSelectedPage(arg1)) {
			List<WebElement> pages = getElements(pegenationPage);
			for (WebElement webElement : pages) {
				if (webElement.getText().equals(arg1)) {
					webElement.click();
					return;
				}
			}
		}
		Assert.assertTrue(checkSelectedPage(arg1));
	}

	@Then("^system redirect user to \"([^\"]*)\" page$")
	public void previusPageVerify(String arg1) throws Throwable {

		Assert.assertTrue(checkSelectedPage(arg1), "Expected page is not load");
	}

	@Given("^user clicks on '<' link$")
	public void toPreviusPage() throws Throwable {
		sleepFor(1500);
		getElement(previousPage).click();
	}

	public boolean checkSelectedPage(String expectedPage) throws Throwable {
		WebElement selection = getElement(SelectedPage);
		if (selection.getText().equals(expectedPage)) {
			return true;
		}
		return false;
	}

	@When("^user select \"([^\"]*)\" category from 'Sort By' dropdown$")
	public void sortProduct(String sortCondition) throws Throwable {
		sleepFor(1500);
		selectVisibleTextBy(sortByDropdown, sortCondition);
	}

	@Then("^system refreshes page & sorts product list by selected sorting criterion in ascending order \\(A-Z\\)$")
	public void getProductsName() throws Throwable {
		sleepFor(2500);
		String productName = "";
		List<WebElement> products = getElements(productItem);
		for (WebElement name : products) {
			productName = name.findElement(itemTitle).getText();
			actualSorting.add(productName);
		}
		String actRes = actualSorting.toString();
		String expectedSorting = getSortedList(actualSorting);
		Assert.assertEquals(actRes, expectedSorting);
	}

	private String getSortedList(List<String> s) {
		Collections.sort(s, String.CASE_INSENSITIVE_ORDER);
		return s.toString();
	}

	@Override
	protected By getUniqueElement() {
		// TODO Auto-generated method stub
		return null;
	}

}
