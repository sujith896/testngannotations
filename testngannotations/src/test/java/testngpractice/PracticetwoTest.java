package testngpractice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;
import resources.CustomListener;
@Listeners(CustomListener.class)
public class PracticetwoTest {
	@BeforeMethod
	public void m5()
	{
		System.out.println("Hi i'm running before method");
	}
	@AfterMethod
	public void m6()
	{
		System.out.println("Hi i'm executing after method");
	}
	
	@Test(priority=2)
	public void method1()
	{
		System.out.println("Hi this is from practice2 from method1");
		
	}
	@Test(priority=1)
	public void method2()
	{
		System.out.println("Hi this is from practice2 from method2");
	}
	

}
