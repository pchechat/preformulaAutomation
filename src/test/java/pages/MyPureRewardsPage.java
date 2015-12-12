package pages;

import org.openqa.selenium.By;

import utils.AbstractContainer;

public class MyPureRewardsPage extends AbstractContainer{

	static String url = "https://stage.pureformulas.com/account/rewards.jsp";
	By rewardsStatusBox = By.cssSelector(".rewards-status");
	By referalLink = By.cssSelector("#shareReferralCodeLink");
	By copyButton = By.cssSelector("#ZeroClipboardMovie_1");
	By uniqueReferalCode = By.cssSelector(".rewards-referral-code-code");
	By purchasesTab = By.cssSelector("a[href='#rewards-purchase']");
	By productsReview = By.cssSelector("a[href='#rewards-review']");
	By referals = By.cssSelector("a[href='#rewards-referral']");
	By other = By.cssSelector("a[href='#rewards-other']");
	By redemtions = By.cssSelector("a[href='#rewards-redeem']");
	
	@Override
	protected By getUniqueElement() {
		return rewardsStatusBox;
	}

}
