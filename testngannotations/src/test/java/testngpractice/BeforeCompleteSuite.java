package testngpractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import resources.CustomListener;
@Listeners(CustomListener.class)
public class BeforeCompleteSuite{
	
	@BeforeSuite
	public void m1()
	{
		System.out.println("hi i'm executing before test suite");
	}
	
	@AfterSuite
	public void m2()
	{
		System.out.println("hi i'm executing after test suite");
	}
	
	@BeforeTest
	public void m3()
	{
		System.out.println("Hi i;m executing before test");
	}
	@AfterTest
	public void m4()
	{
		System.out.println("Hi i'm executing after test");
	}
	
	
}
