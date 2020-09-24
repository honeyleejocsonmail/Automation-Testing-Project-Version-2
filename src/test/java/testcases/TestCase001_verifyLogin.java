package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import pages.LoginPage;


public class TestCase001_verifyLogin extends BaseClass {

	HomePage hp;
	LoginPage lp;

	
	@Test 
	public void verifyLogin() {
		
		test = rep.startTest("verifyLogin Test Started");
		
		app_logs.info("verify login test started");
		
		hp = new HomePage(driver);
		hp.doClick();
		test.log(LogStatus.INFO,"Clicked Signin Button");
		
		
		lp=new LoginPage(driver);
		lp.doLogin("username", "password");
		test.log(LogStatus.INFO,"Entered Username, Password and click Submit Button");
		
		String actual = driver.getTitle();
		String expected="Zero - Account Summary";
		Assert.assertEquals(actual, expected);
		test.log(LogStatus.PASS,"Login Successfully");
		
		app_logs.info("verify login test completed");
		}


}
