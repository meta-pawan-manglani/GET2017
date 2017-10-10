package com.metacube.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * The Class SignInTesting.
 *   Test class to perform automatic testing in Firefox
 * 
 * @author Pawan Manglani
 * @version 1.1 10-Sep-2017
 */
public class SignInTesting {

	/** The driver. */
	WebDriver driver = new FirefoxDriver();
	
	/**
	 * Signin test.
	 */
	@Test
	public void signinTest() {
		System.out.println("In Test 1");
		System.out.println("In After Test");
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("Test@example.com");
		driver.findElement(By.id("passwd")).sendKeys("Test");
		System.out.println("test over");
		driver.findElement(By.id("SubmitLogin")).click();
	}


	/**
	 * Sets the up.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@BeforeTest
	public void setUp() throws InterruptedException {
		System.out.println("In Before Test");
		driver.get("http://automationpractice.com/");
		Thread.sleep(1000);
	}

	/**
	 * Tear down.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		//			driver.quit();
	}

}
