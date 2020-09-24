package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import pages.PayBillsPage;
import pages.AccountSummaryPage;



public class TestCase004_verifyPayBills  extends BaseClass {
		
		
		@Test  
		public void verifyPayBills() {
			
			test = rep.startTest("verifyPayBills Test Started");
			
			app_logs.info("verifyPayBills test started");
			
			AccountSummaryPage asp=new AccountSummaryPage(driver);
			asp.doClickPayBills(); 
			test.log(LogStatus.INFO,"Clicked Pay Bills tab");
			
			PayBillsPage pb=new PayBillsPage(driver);	
			pb.doClickPaySavedPayee(); 
			test.log(LogStatus.INFO,"Clicked Pay Saved Payee tab");
			
			pb.doPayBills("Wells Fargo", "Checking", "250", "2020-08-20", "payment for mortgage");
			test.log(LogStatus.INFO,"Entered Payee Name , Account, Amount,  Date, Description and clicked Pay Buttton");
		
			Assert.assertTrue(pb.alertContainer.isDisplayed());
			test.log(LogStatus.PASS,"Successfully Paid the Bill");
			
			app_logs.info("verifyPayBills test started");
		}
		

}
