package test;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.alliedtesting.elibrarytesting.HomePage;

@Listeners({MyListener.class})
public class TestUI {

	final static Logger logger = Logger.getLogger(test.class);
	
	
	@BeforeTest
	public void init()
	{
		logger.debug("DEBUG");
		logger.info("INFO");
		logger.error("ERROR");
		logger.info("INIT");
		Reporter.log("Init");
		Reporter.log("Init");
	}

	
	@DataProvider(name = "userprovider")
	public Object[][] dataProvider()
	{
		return new Object[][] {
				new Object[]{"user@alliedtesting.com", "123"},
				new Object[]{"user@alliedtesting.com", "321"},
				new Object[]{"user@alliedtesting.com", ""},
				new Object[]{"worker@alliedtesting.com", "123"},
				new Object[]{"worker@alliedtesting.com", "321"},
				new Object[]{"worker@alliedtesting.com", ""},
				new Object[]{"superuser@alliedtesting.com", "123"},
				new Object[]{"superuser@alliedtesting.com", "321"},
				new Object[]{"superuser@alliedtesting.com", ""},
				new Object[]{"invalid_login", "123"},
				new Object[]{"invalid_login", "invalid_password"},
				new Object[]{"", "123"},
				new Object[]{"", ""}
		};
	}
	
	@Test(dataProvider = "userprovider") 
	public static void TestLogin(String user, String password)
			throws Exception{
		
		HomePage home = new HomePage();
		Reporter.log(user);
		Reporter.log(password);
		home.openPage();
		home.clickSignInBtn();
		home.loginAs(user, password);
		
		Assert.assertEquals(user, home.getLogged(), "Not logged in!");
		home.clickSignOutBtn();
//		try {
//			Assert.assertEquals(user, home.getLogged(), "Not logged in!");
//			home.clickSignOutBtn();
//		} catch(org.openqa.selenium.NoSuchElementException e)
//		{
//			Assert.assertTrue(true);
//		}

		
	}
	
	
	
	

}
