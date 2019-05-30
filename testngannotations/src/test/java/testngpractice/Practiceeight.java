package testngpractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import resources.CustomListener;
@Listeners(CustomListener.class)
public class Practiceeight {
	@BeforeClass
	public void m7()
	{
		System.out.println("hi i'm executing before every class");
	}
	@AfterClass
	public void m8()
	{
		System.out.println("hi i'm executing after evey class");
	}
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
	@Test
	public void method1()
	{
		System.out.println("Hi this is from practice8 from method1");
	}
	@Test
	public void method2()
	{
		System.out.println("Hi this is from practice8 from method2");
	}
	
}
