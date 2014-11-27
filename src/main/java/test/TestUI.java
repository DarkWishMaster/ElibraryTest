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
				new Object[]{"user@alliedtesting.com", "123", true},
				new Object[]{"user@alliedtesting.com", "321", false},
				new Object[]{"user@alliedtesting.com", "", false},
				new Object[]{"worker@alliedtesting.com", "123", true},
				new Object[]{"worker@alliedtesting.com", "321", false},
				new Object[]{"worker@alliedtesting.com", "", false},
				new Object[]{"superuser@alliedtesting.com", "123", true},
				new Object[]{"superuser@alliedtesting.com", "321", false},
				new Object[]{"superuser@alliedtesting.com", "", false},
				new Object[]{"", "123", false},
				new Object[]{"", "", false}
		};
	}
	
	@Test(dataProvider = "userprovider")
	public static void TestLogin(String user, String password, boolean pass){
		
		HomePage home = new HomePage();
		
		home.openPage();
		home.clickSignInBtn();
		home.loginAs(user, password);
		if (pass)
			Assert.assertEquals(user, home.getLogged(), "Not logged in!");
		else
		{
			String logged;
			try {
			    logged = home.getLogged();
			} catch (Exception e)
			{
				logged = "EXCEPTION";
			}
			Assert.assertNotEquals(user, logged, "You can't be logged in!");
		}
		
		try {
			home.clickSignOutBtn();
		} catch (Exception e)
		{

		}
	}
}
