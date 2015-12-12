package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class AbstractContainer {
	public static WebDriver driver = WebDriverSingleton.getInstance()
			.getWebDriver();
	protected WebDriverWait wait = new WebDriverWait(driver, 30);

	protected abstract By getUniqueElement();

	protected void isLoaded() throws Error {
		List<WebElement> uniqueElement = driver
				.findElements(getUniqueElement());

		Assert.assertTrue((uniqueElement.size() > 0), "Unique Element \'"
				+ getUniqueElement().toString() + "\' not found for "
				+ this.getClass().getSimpleName());

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	protected void checkForErrors() {
		checkForErrors("");
	}

	public String getCurrentTime(){
		
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		 Date date = new Date();

		return dateFormat.format(date);
		
		
	}
	protected boolean elementVisible(WebElement element) {
		try {
			if (element.isDisplayed() && element.isEnabled()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		}
	}

	protected void specialInput(By by, String value) {
		getElement(by).clear();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		String sBy = getElement(by).getAttribute("id");
		executor.executeScript("document.getElementById('" + sBy
				+ "').value = '" + value + "';");
		getElement(by).sendKeys(Keys.TAB);

	}

	protected boolean elementExist(By by) {
		try {
			WebElement element = getElement(by);
			return elementVisible(element);
		} catch (Exception e) {
			return false;
		}
	}

	protected void selectRadioBox(WebElement element) {
		while (!element.isSelected()) {
			element.click();
		}
	}

	protected void sleepFor(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
		}
	}

	protected void replaceText(By by, String newString) {
		replaceText(getElement(by), newString);
	}

	protected void replaceText(WebElement element, String newString) {
		element.clear();
		element.sendKeys(newString);
		Assert.assertEquals(element.getAttribute("value"), newString);
	}

	public boolean isDataCorrect(WebElement element, List<String> address) {
		boolean correct = false;
		for (String string : address) {
			if (element.getText().toLowerCase().contains(string.toLowerCase())) {
				correct = true;
			} else {
				System.out.println(element.getText() + " doesn't contains \n"
						+ string);
				correct = false;
				break;
			}
		}
		return correct;
	}

	protected void stopExecution() {
		driver.close();
	}

	protected WebElement getElement(By by) {
		List<WebElement> elements = getElements(by);
		for (WebElement e : elements) {
			if (e.isDisplayed() && e.isEnabled()) {
				return e;
			}
		}
		return null;
	}

	protected List<WebElement> getElements(By by) {
		return driver.findElements(by);
	}

	protected void selectValueBy(By by, String value) {
		WebElement selector = getElement(by);
		new Select(selector).selectByValue(value);
	}

	protected void selectIndexBy(By by, Integer index) {
		WebElement selector = getElement(by);
		new Select(selector).selectByIndex(index);
	}

	protected void selectVisibleTextBy(By by, String text) {
		WebElement selector = getElement(by);
		new Select(selector).selectByVisibleText(text);
	}

	protected void click(By by) {
		click(getElement(by), "");
	}

	protected void click(By by, String error) {
		click(getElement(by), error);
	}

	protected void click(WebElement element) {
		click(element, "");
	}

	protected void click(WebElement element, String error) {
		element.click();
		closeAlert();
		checkForErrors(error);
	}

	protected boolean checkForErrors(String error) {
		By by = By.cssSelector("#error-messages");
		return checkForErrors(by, error);
	}

	protected boolean checkForErrors(By by) {
		return checkForErrors(by, "");
	}

	protected boolean checkForErrors(By by, String error) {
		if (error.equals("")) {
			Assert.assertEquals(getError(by, error), "",
					"Error message was found on the page/module.");
			return true;
		} else {
			Assert.assertEquals(getError(by, error), error,
					"Incorrect error message was found on the page/module.");
			return true;
		}
	}

	protected String getError(By by, String error) {
		try {
			if (error.equals("")) {
				return getElement(by).getText();
			} else {
				return getElement(by).getText();
			}
		} catch (NullPointerException e) {
			return "";
		}
	}

	protected void closeAlert() {
		try {
			sleepFor(500);
			Alert alert = driver.switchTo().alert();
			System.out.println("Sysytem show following message on alert:\n"
					+ alert.getText());
			alert.accept();
		} catch (NoAlertPresentException ex) {
		}
	}

	protected WebElement findElementByAttributeValue(By by, String attribute,
			String value) {
		for (WebElement element : getElements(by)) {
			if (element.getAttribute(attribute).contains(value)) {
				return element;
			}
		}
		return null;
	}

	protected void navigateTo(String url) {
		driver.get(url);
	}

	protected void typeText(By by, String text) {
		typeText(getElement(by), text);
	}

	protected void typeText(WebElement element, String text) {
		Assert.assertTrue(element.isEnabled(),
				"Cannot type text since element is not enabled");
		if (isTextGeneration(text)) {
			text = textGenerator(text);
		}
		sleepFor(1000);
		element.sendKeys(text);
		sleepFor(500);
		Assert.assertTrue(element.getAttribute("value").contains(text));
	}

	protected void hoverElement(By by) {
		Actions actions = new Actions(driver);
		WebElement menuHoverLink = driver.findElement(by);
		actions.moveToElement(menuHoverLink);
		actions.perform();
	}

	public void retryingFindElement(By by) {
        
		boolean elementPresent = false;
        int attempts = 0;
        while(attempts < 2) {    
        	
        	try {
                
        		click(by);
        		elementPresent = true;
                break;
                
            } catch(StaleElementReferenceException e) {
            	
            }
        	
            attempts++;
        }
       
        Assert.assertTrue(elementPresent, "The element is not found on the page");
        
}
	
	protected boolean isTextGeneration(String text) {
		if (text.startsWith("{") && text.endsWith("}") && text.contains("^")) {
			return true;
		} else {
			return false;
		}
	}

	public String textGenerator(String stringParameter) {
		String[] parts = stringParameter.split(Pattern.quote("^"));
		String s = parts[0].replace("{", "");
		s += generateString(parts[1], Integer.parseInt(parts[2]));
		s += parts[3].replace("}", "");
		return s;
	}

	public WebElement getElementByValue(String value, By by) {

		for (WebElement element : getElements(by)) {

			if (element.getText().equals(value)) {
				return element;
			}
		}
		return null;
	}

	
	protected String generateString(String parameters, int length) {
		final String dCase = "abcdefghijklmnopqrstuvwxyz";
		final String uCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		final String sChar = "!@#$%^&*";
		final String intChar = "0123456789";
		String charSet = "";

		Random rnd = new Random();
		if (parameters.contains("a")) {
			charSet += dCase;
		}
		if (parameters.contains("A")) {
			charSet += uCase;
		}
		if (parameters.contains("!")) {
			charSet += sChar;
		}
		if (parameters.contains("1")) {
			charSet += intChar;
		}

		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append(charSet.charAt(rnd.nextInt(charSet.length())));
		}

		return sb.toString();
	}
	
public void getSystemMessage(String text){
		
		System.out.println("[INFO] : " + getCurrentTime() + " -  " + text);
		
	}
	
    public void getWarningMessage(String text){
		
		System.out.println("[WARNING] : " + getCurrentTime() + " -  " + text);
		
	}
	
	
	public void getRunTest(String scenario){
	
		System.out.println("[INFO] : " + getCurrentTime() + " - Running '" + scenario + "' test case");
	
	}
	
	public void stackTrack(){
		
		   StackTraceElement[] stes = Thread.currentThread().getStackTrace();
	        for (StackTraceElement element : stes) {
	            System.out.println(element);
	        }
		
	}
	
	
	public void getTestResultMessage (String scenario, String status){
		
		if(status == "failed"){
		
			System.err.println("[WARNING] : " + getCurrentTime() + "  -  '" + scenario + "' test case  - " + status.toUpperCase() );
	
			
		}
	   
		if(status == "passed"){
			
			System.out.println("[INFO] : " + getCurrentTime() + "  -  '"  + scenario + "' test case  - " + status.toUpperCase() );
		}
	}
}
