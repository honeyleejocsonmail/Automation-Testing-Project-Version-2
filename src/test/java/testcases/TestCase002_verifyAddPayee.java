package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import base.BaseClass;
import pages.AccountSummaryPage;
import pages.PayBillsPage;



public class TestCase002_verifyAddPayee extends BaseClass {


	
	@Test  
	public void verifyAddPayee() {
		
		test = rep.startTest("verifyAddPayee Test Started");
		
		app_logs.info("verifyAddPayee test started");
		
		AccountSummaryPage asp=new AccountSummaryPage(driver);
		asp.doClickPayBills(); 
		test.log(LogStatus.INFO,"Clicked Pay Bills tab");

		PayBillsPage pb=new PayBillsPage(driver);
		pb.doClickAddPayee(); 
		test.log(LogStatus.INFO,"Clicked Add Payee tab");
		
		pb.doAddPayee("HydroOne Utility", "200 RoberSpec Pkwy, Mississauga, ON L6R1K9", "123234434", "Natural Gas Utility");
		test.log(LogStatus.INFO,"Entered Payee Name , Adress, Account Number, Account Details and clicked Add Button");
		
		Assert.assertTrue(pb.alertContainer.isDisplayed());
		test.log(LogStatus.PASS,"Payee Successfully Added");
		
		app_logs.info("verifyAddPayee test completed");
		
	}
		



}
