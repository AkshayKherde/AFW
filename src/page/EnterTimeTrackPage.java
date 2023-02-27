package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class EnterTimeTrackPage {

	
		@FindBy(xpath="//span[text()='Logout']")
		private WebElement logoutLink;
		
		
		public EnterTimeTrackPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}
		
		/*below method will verify whether logout link is visible or not
		
		 */
		public boolean verifyHomePageIsDisplayed(WebDriverWait wait)
		{
			try
			{
			
				wait.until(ExpectedConditions.visibilityOf(logoutLink));
				Reporter.log("Logout link is visible",true);
				
				return true;
			}
			catch (Exception e) 
			{
				Reporter.log("Logout link is not visible",true);
				return false;
			}
	}

}
