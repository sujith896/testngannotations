package testBase;

import java.net.URL;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SaucelabsIntegration {
	
	
	// enter your saucelabs user name here
	public static final String USERNAME = "sujith.talamanchi140";

	//enter your access key here
	public static final String ACCESS_KEY = "0bf1ff42-bd1b-4398-acb0-3301b0f0922c";
	public static final String SauceLabURL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
	private WebDriver driver;

	@Test
	public void test_Windows_Firefox() throws Exception {
	DesiredCapabilities caps = DesiredCapabilities.chrome();
	caps.setCapability("platform", "Windows 10");
	caps.setCapability("version", "74");
	caps.setCapability("name", "Testing on chrome 74");
	this.driver = new RemoteWebDriver(new URL(SauceLabURL), caps);
	driver.get("https://www.google.com");
	System.out.println(driver.getTitle());

	System.out.println("BrowserName :" + caps.getBrowserName() + " – "+ "Version : " + caps.getVersion());
	System.out.println("————————————————————————————");
	driver.switchTo().activeElement().sendKeys("hi",Keys.ENTER);
	//driver.close();
	}

}
