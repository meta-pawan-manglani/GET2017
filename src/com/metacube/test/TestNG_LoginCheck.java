package com.metacube.test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * The Class TestNG_LoginCheck.
 * This class test the login functionality of the website 
 * 
 * 
 * @author Pawan Manglani
 * @version 1.1 11-10-2017
 */
public class TestNG_LoginCheck {
	
	/** The driver chrome. */
	WebDriver driverChrome;
	
	/**
	 * Before test.
	 * Instantiate the driver and move to the url automationpractice.com
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	@BeforeTest
	public void beforeTest() throws InterruptedException {
		driverChrome =  new ChromeDriver();
		driverChrome.get("http://automationpractice.com/index.php");
	}

	/**
	 * Test forgot password.
	 * This test check the login functionality when user forget the password 
	 * @throws InterruptedException the interrupted exception
	 */
	@Test(priority=2)
	public void testForgotPassword() throws InterruptedException {
		driverChrome.findElement(By.className("login")).click();
		driverChrome.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		assertEquals(driverChrome.getTitle(), "Forgot your password - My Store");
	}

	/**
	 * Test account creation.
	 * This test will check the data when user have to create a new account
	 * @throws InterruptedException the interrupted exception
	 */
	@Test(priority = 1)
	public void testAccountCreation() throws InterruptedException {
		driverChrome.findElement(By.className("login")).click();
		Thread.sleep(1000);
		driverChrome.findElement(By.id("email_create")).sendKeys("pawan.manglani@metacube.com");
		driverChrome.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(2000);
		assertEquals(driverChrome.getCurrentUrl(), 
				"http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
	}

	/**
	 * After test.
	 *
	 *closing the driver
	 * @throws InterruptedException the interrupted exception
	 */
	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(1000);
		driverChrome.quit();
	}
}
