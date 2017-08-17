package test;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;




import DefaultNamespace.MyService;
import DefaultNamespace.MyServiceServiceLocator;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


/**
 * The Class ServiceTest.
 * 
 * This class will test the service
 */
@RunWith(Parameterized.class)
public class ServiceTest {
	
     /** The input number. */
     double inputNumber;
     
     /** The expected. */
     double expected;
	
	/** The service locator. */
	private static MyServiceServiceLocator serviceLocator;
	
	/** The service. */
	private static MyService service;
	
	/**
	 * Sets the up before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		serviceLocator = new MyServiceServiceLocator();
		serviceLocator.setMyServiceEndpointAddress("http://localhost:8080/FareheightToCelcius/services/MyService");
		service = serviceLocator.getMyService();
	}

	/**
	 * Tear down after class.
	 *
	 * @throws Exception the exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		serviceLocator = null;
	}
	
	 /**
 	 * Instantiates a new service test.
 	 *
 	 * @param inputNumber the input number
 	 * @param expected the expected
 	 */
 	public ServiceTest(double inputNumber, double expected) {
	      this.inputNumber = inputNumber;
	      this.expected = expected;
	   }

	   /**
   	 *  numbers.
   	 *
   	 * @return the collection
   	 */
   	@Parameters
	   public static Collection<Object[]> numbers() {
	      return Arrays.asList(new Object[][] {
	         { 32, 0.0},
	         { 35,2.0 },
	         { 19,-7.0},
	         { 40,4.0},
	         { 60,16.0}
	      });
	   }
	   
		/**
		 * Test.
		 */
		@Test
	  	public void test() {
				try {
					double actual = Math.round((service.converter(inputNumber)*100)/100);
					assertEquals(Double.toString(expected), Double.toString(actual));
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  	}      
}
