package com.metacube.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * The Class SearchQueryTesting.
 * 
 * 
 *  @author Pawan Manglani
 * @version 1.1 10-Sep-2017
 */
public class SearchQueryTesting {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		try {
			/*registering the driver*/
			WebDriver driver = new InternetExplorerDriver();
			 /*navigate to the link*/
			driver.get("http://automationpractice.com/index.php");
			Thread.sleep(1000);
			/*finding the element search box by id*/
			driver.findElement(By.id("search_query_top")).click();
			/*In element search box  providing the input Faded*/
			driver.findElement(By.id("search_query_top")).sendKeys("Faded");
			System.out.println("test over");
			/*finding the element submit button to search the element*/
			driver.findElement(By.name("submit_search")).click();
//			Thread.sleep(6000);
//			driver.quit();
		} catch (InterruptedException e) {
			System.out.println("Error: "+e);
		}
	}
}
