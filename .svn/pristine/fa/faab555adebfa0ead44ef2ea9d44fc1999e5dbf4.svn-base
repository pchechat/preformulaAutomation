package utils;

import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverSingleton {
	public static WebDriverSingleton instance;
	public String browser = "";
	public WebDriver driver;

	private WebDriverSingleton() {
		 switch (browser) {
	        case "chrome":
	            String chromePath = "D:/drivers/chromedriver";
	            if (getOperatingSystemType().toString() == "Windows") {
	                chromePath += ".exe";
	            }
	            System.setProperty("webdriver.chrome.driver", chromePath);
	            System.out.println("Trying to start chrome driver from: "
	                    + chromePath);
	            ChromeOptions options = new ChromeOptions();
	            options.addArguments("--start-maximized");
	            driver = new ChromeDriver();
	            break;
	        case "ie":
	            String iePath = System.getenv("webdrivers") + "IEDriverServer.exe";
	            System.setProperty("webdriver.ie.driver", iePath);
	            driver = new InternetExplorerDriver();
	            break;
	        default:
	            driver = new FirefoxDriver();
	            break;
	        }
		driver.manage().window().maximize();
		//driver.get("https://stage.pureformulas.com/");
	}

	public static synchronized WebDriverSingleton getInstance() {
		if (instance == null) {
			instance = new WebDriverSingleton();
		}
		return instance;
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public static void closeWebDriver() {
		WebDriverSingleton.getInstance().getWebDriver().close();
	}

	public enum OSType {
		Windows, MacOS, Linux, Other
	};

	protected static OSType detectedOS;

	public static OSType getOperatingSystemType() {
		if (detectedOS == null) {
			String OS = System.getProperty("os.name", "generic").toLowerCase(
					Locale.ENGLISH);
			if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
				detectedOS = OSType.MacOS;
			} else if (OS.indexOf("win") >= 0) {
				detectedOS = OSType.Windows;
			} else if (OS.indexOf("nux") >= 0) {
				detectedOS = OSType.Linux;
			} else {
				detectedOS = OSType.Other;
			}
		}
		return detectedOS;
	}
}
