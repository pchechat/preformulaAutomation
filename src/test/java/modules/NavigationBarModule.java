package modules;

import org.openqa.selenium.By;

import utils.AbstractContainer;

public class NavigationBarModule extends AbstractContainer{
	
	By shopByBrand = By.cssSelector("a[href='/brands']");
	By shopByCategory = By.cssSelector("a[href='/categories']");
	By discover = By.cssSelector("a[href='/discover']");
	By customerServices = By.cssSelector("a[href='#'");
	By deals = By.cssSelector("a[href='/campaign/new-year-sale.html']");
	By dropDown = By.cssSelector(".nav-brand > div:nth-child(2)");

	@Override
	protected By getUniqueElement() 
	{
		return deals;
	}

}
