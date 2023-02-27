package script;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Utility;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class ValidLoginPage extends BaseTest {

	
	@Test(priority = 1)
	public void testValidLogin() throws Exception
	{
		//take the data from TestData excel file
		String un= Utility.getXLData(dataPath, "ValidLogin",1, 0);
		String pw= Utility.getXLData(dataPath, "ValidLogin",1, 1);
		
//        1. Enter valid user name
		LoginPage loginPage=new LoginPage(driver);
		loginPage.setUserName(un);
		
//		2. enter valid password
		loginPage.setPassword(pw);
		
//		3. click on login button
		loginPage.clickLoginButton();
		EnterTimeTrackPage ettPage=new EnterTimeTrackPage(driver);
		boolean res = ettPage.verifyHomePageIsDisplayed(wait);
		//true->PASS     false->FAIL
		Assert.assertEquals(res, true);
		
		
		
		
			
			
//			
	}

		}

