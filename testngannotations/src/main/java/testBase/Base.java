package testBase;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;

public class Base {
	
	public static WebDriver driver;
	
	public static Properties prop;
	public static final String USERNAME = "sujith.talamanchi140";

	//enter your access key here
	public static final String ACCESS_KEY = "0bf1ff42-bd1b-4398-acb0-3301b0f0922c";
	public static final String SauceLabURL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

	
	public static void loadPropertiesFile() throws IOException
	{
		prop=new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		prop.load(fis);
		
	}
	//@Parameters("browser")
	public static void launchBrowser(String browsername) throws MalformedURLException
	{
	if(browsername.equalsIgnoreCase("chrome"))
	{
//	System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverpath"));
//	ChromeOptions co=new ChromeOptions();
//	co.addArguments("headless");
//	driver=new ChromeDriver(c0);
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "74");
		caps.setCapability("name", "Testing on chrome 74");
		driver = new RemoteWebDriver(new URL(SauceLabURL), caps);
		
	}
	else if(browsername.equalsIgnoreCase("firefox"))
	{
//		System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxdriverpath"));
//		driver=new FirefoxDriver();
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "67");
		caps.setCapability("name", "Testing on firefox 67");
		driver = new RemoteWebDriver(new URL(SauceLabURL), caps);
		
		
	}
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	
	}
	
	public static void closeBrowser()
	{
		driver.quit();
	}
//	private Date getTime(long millis) {
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(millis);
//        return calendar.getTime();  
//	}
	
	public static void takeScreenshotForFailedTestCases(String methodname) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"//screenshots//"
		              +methodname+".jpg"));		
	}
	
}
