package testngpractice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import resources.CustomListener;
import testBase.Base;
@Listeners(CustomListener.class)
public class Selenium extends Base {

	
	@BeforeTest
	@Parameters("browser")
	public void intialization(String browser) throws IOException
	{
		loadPropertiesFile();
		launchBrowser(browser);
	}
	
	@Test(priority=1)
	public void getTitle()
	{
		String title= driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Learn Selenium with Best Practices and Examples | Selenium Easy", title);
	}
	@Test(priority=2)
	public void clickonDemoSite()
	{
		driver.findElement(By.xpath("//*[text()='Demo Website!']")).click();
	}
	@Test(priority=3)
	public void titleofDemoWebsite()
	{
		String title= driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Selenium Easy - Best Demo website to practice Selenium Webdriver Online", title);
	    
	}
	@Test(priority=4)
	public void click_on_input_forms()  {
		driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[1]")).click();
	    
	}
@Test(priority=5)
public void click_on_input_form_submit()  {
	driver.findElement(By.xpath("//*[text()='Input Form Submit']")).click();
    
}
@Test(priority=6)
public void user_enters_details_and_click_on_send()   {
	
	driver.findElement(By.name("first_name")).sendKeys("sujith");
	driver.findElement(By.name("last_name")).sendKeys("reddy");
	driver.findElement(By.name("email")).sendKeys("sujith.talamanchi@gmail.com");
	driver.findElement(By.name("phone")).sendKeys("8686214972");
	driver.findElement(By.name("address")).sendKeys("marathahalli");
	driver.findElement(By.name("city")).sendKeys("banglore");
	
	Select s= new Select(driver.findElement(By.name("state")));
	s.selectByVisibleText("Georgia");
	driver.findElement(By.name("zip")).sendKeys("500038");
	driver.findElement(By.name("website")).sendKeys("www.google.com");
	driver.findElement(By.xpath("(//*[@name='hosting'])[1]")).click();
	driver.findElement(By.name("comment")).sendKeys("input form testing");
	
	driver.findElement(By.xpath("//*[@type='submit']")).click();
  
}
@AfterTest
public void close_the_browser()
{
	closeBrowser();
}
}
