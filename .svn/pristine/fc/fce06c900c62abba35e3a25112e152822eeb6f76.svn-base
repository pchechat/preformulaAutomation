package pages;

import org.openqa.selenium.By;

import utils.AbstractContainer;

public class CategoriesPage extends AbstractContainer{

	static String url = "https://stage.pureformulas.com/categories";
	By categoryLink = By.cssSelector("a[href='/categories']");
	By healthNeedLink = By.cssSelector("a[href='/healthneeds']");
	By ingredientLink = By.cssSelector("a[href='/ingredients']");
	By categoryTable = By.cssSelector(".catlist");
	
	
	@Override
	protected By getUniqueElement() {
	
		return categoryTable;
	}
	

}