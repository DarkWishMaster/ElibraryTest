package test;




/*
 * Homework, add logger and reports to a test 
 * 	+ Listener to generate HTML with some styles/css ok
 */

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;




/* Test some functionalities *.
 * Make API for UI
 */

@Listeners({MyListener.class})
public class test {

	final static Logger logger = Logger.getLogger(test.class);
	
	
	@BeforeTest
	public void init()
	{
		logger.debug("DEBUG");
		logger.info("INFO");
		logger.error("ERROR");
		logger.info("INIT");
		
		Reporter.log("Start test\n");
	}
	
	@DataProvider(name = "userprovider")
	public Object[][] dataProvider()
	{
	
		return new Object[][] {
				new Object[]{"user", "password"},
				new Object[]{"user", "pppp"}
		};
	}
	
	@Test(dataProvider = "userprovider",  dependsOnGroups = {"login"})
	public static void Test(String user, String password){
		logger.info("Hello, world\n");
		Reporter.log("Hello, world!!!!");
		Assert.assertEquals(user, "user", "Not equal!!!");
		Assert.assertEquals(password, "passwdf", "Not equal!!!");
	}
	
	/* First will be executed Test , if it won't fail, then will be executed test 1 */
	@Test(description = "123", groups = {"login"})
	public static void Test2()
	{	
		Assert.assertEquals(2, 2, "Not Equal 2 3");
	}
	
	/* Tear down , after all tests etc. classes */
	@AfterTest
	public void TearDown(){
		System.out.println("RUNNING TEARDOWN");
	}
	
	
	
	
}
