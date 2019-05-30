package testngpractice;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import resources.CustomListener;
@Listeners(CustomListener.class)
public class PracticeoneTest {
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
	
	@Test(dependsOnMethods= {"method2"},alwaysRun=true)
	public void method1()
	{
		System.out.println("Hi this is from practice1 from method1");
	}
	@Test(dependsOnMethods= {"method3"})
	public void method2()
	{
		System.out.println("Hi this is from practice1 from method2");
	}
	@Test
	public void method3()
	{
		System.out.println("Hi this is from practice1 from method3");
	}
	
	@Test(enabled=false)
	public void method4()
	{
		System.out.println("Hi this is from practice1 from method4");
	}
	

}
