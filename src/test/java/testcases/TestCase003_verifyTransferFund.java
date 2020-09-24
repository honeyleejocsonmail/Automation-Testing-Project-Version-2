package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;


import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import pages.AccountSummaryPage;
import pages.TransferFundPage;



public class TestCase003_verifyTransferFund  extends BaseClass {


	@Test 
	public void verifyTransferFund() {
		
		test = rep.startTest("verifyTransferFund Test Started");
		
		app_logs.info("verifyTransferFund test started");
		
		AccountSummaryPage asp=new AccountSummaryPage(driver);
		asp.doClickTransferFund();
		test.log(LogStatus.INFO,"Clicked Transfer tab");
		
		TransferFundPage tf=new TransferFundPage(driver);		
		tf.doTransferFund("1", "2", "300", "August Transfer");
		test.log(LogStatus.INFO,"Entered From Account, To Account, Amount, Description, clicked Continue and clicked Submit");
		
		Assert.assertTrue(tf.alertContainer.isDisplayed());
		test.log(LogStatus.PASS,"Successfully Transferred a Fund");
		
		app_logs.info("verifyTransferFund test completed");

	}
	
	
}
