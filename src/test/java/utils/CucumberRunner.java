package utils;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
		format = { "pretty", "html:target/cucumber-html-report" }, 
		features = { "src/test/resources/SmokeSuite" }, 
		glue = { "pages", "modules"}
		//tags = {"Smoke"}
		)

public class CucumberRunner {
	@AfterClass
	static public void close() {
		WebDriverSingleton.getInstance().driver.quit();
	}
	
}