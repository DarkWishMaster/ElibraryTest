package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alliedtesting.elibrarytesting.HomePage;

public class TestUI {

	
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
		
		home.openPage();
		home.clickSignInBtn();
		home.loginAs(user, password);
		
		Assert.assertEquals(user, home.getLogged(), "Not logged in!");
		
		home.clickSignOutBtn();
	}
	
	

	
	

}
