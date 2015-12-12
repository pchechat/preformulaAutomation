package pages;

import org.openqa.selenium.By;

import utils.AbstractContainer;

public class BrandsPage extends AbstractContainer{

	static String url = "https://stage.pureformulas.com/brands";
	By allBrands = By.cssSelector("a[href='/brands?professional=false']");
	By professionalBrands = By.cssSelector("a[href='/brands?professional=true']");
	By alphaNavigation = By.cssSelector(".alpha-nav-ul");
	By alphaList = By.cssSelector(".alpha-list");
	By doctorTrustedBrands = By.cssSelector(".brand-pro");
	
	@Override
	protected By getUniqueElement() {
		return alphaList;
	}
	

}