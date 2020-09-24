package testcases;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import base.BaseClass;
import pages.AccountSummaryPage;
import pages.OnlineStatementsPage;


public class TestCase005_verifyOnlineStatementDownload extends BaseClass {
		

		
			@Test  
			public void verifyOnlineStatement() {
				
				test = rep.startTest("verifyOnlineStatement Test Started");
				
				app_logs.info("verifyOnlineStatement test started");
				
				AccountSummaryPage asp=new AccountSummaryPage(driver);
				asp.doClickOnlineStatement(); 
				test.log(LogStatus.INFO,"Clicked Online Statement tab");
				
				
				OnlineStatementsPage osp=new OnlineStatementsPage(driver);
				osp.doAccount("Checking");
				test.log(LogStatus.INFO,"Entered Account Type");
						
				
				//click the year - try/catch code for StaleElementReferenceException Error
				try {
					osp.doclickyearlink();
					test.log(LogStatus.INFO,"Clicked the year link");
				}
				catch(org.openqa.selenium.StaleElementReferenceException ex)
				{
					osp.doclickyearlink();
					test.log(LogStatus.INFO,"Clicked the year link");
				}
				
				osp.doclickstatementlink();
				test.log(LogStatus.INFO,"Clicked the statement link");
				
				//navigate to downloads
				driver.navigate().to("chrome://Downloads/");
				test.log(LogStatus.INFO,"Opened the path = chrome://Downloads/");
				
				String filename = driver.findElement(By.tagName("body")).getText();
				Assert.assertTrue(filename.contains("8534567-05-12-11"), "File not Found");
				test.log(LogStatus.PASS,"Successfully Downloaded an Online Statement");
				
				app_logs.info("verifyOnlineStatement test completed");
				
			}
			


}
