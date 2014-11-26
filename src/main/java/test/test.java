package test;



import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alliedtesting.elibrarytesting.HomePage;
import com.alliedtesting.elibrarytesting.REST;


/* Test some functionalities *.
 * Make API for UI
 */

public class test {

	@BeforeTest
	public void init()
	{
		System.out.println("RUNNING INIIIIIIT");
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
