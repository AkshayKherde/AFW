package generic;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


		public class BaseTest {
			public WebDriver driver;
			public WebDriverWait wait;
			public static String configPath = "./config.properties";
			public static String dataPath = "./data/TestData.xlsx";

			static {
				try {
					String key = Utility.getPropertyValue(configPath, "DriverKey");
					String value = Utility.getPropertyValue(configPath, "DriverValue");
					System.setProperty(key, value);
				} catch (Exception e) {

				}

			}

			@BeforeMethod
			public void openApp() throws Exception {
				String appURL = Utility.getPropertyValue(configPath, "URL");
				Reporter.log("App URL:" + appURL, true);
				

				String strITO = Utility.getPropertyValue(configPath, "ITO");
				Reporter.log("strITO :" + strITO, true);
				int intITO = Integer.parseInt(strITO);

				String strETO = Utility.getPropertyValue(configPath, "ETO");
				Reporter.log("ETO :" + strETO, true);
				int intETO = Integer.parseInt(strETO);

				String browser = Utility.getPropertyValue(configPath, "Browser");

				if (browser.equalsIgnoreCase("Chrome")) {
					driver = new ChromeDriver();
					Reporter.log("Opening Chrome Browser", true);
				} else if (browser.equalsIgnoreCase("Firefox")) {
					driver = new FirefoxDriver();
				} else if (browser.equalsIgnoreCase("Edge")) {
					driver = new EdgeDriver();
				} else {
					Reporter.log("Invalid Browser", true);
				}

				driver.manage().window().maximize();
				Reporter.log("Maximize the Window", true);
				driver.get(appURL);
				Reporter.log("Enter the URL and Load The page :" +appURL,true);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(intITO));
				Reporter.log("intITO :" +intITO,true);
				wait = new WebDriverWait(driver, Duration.ofSeconds(intETO));
				Reporter.log("intETO :" +intETO,true);
			}

			@AfterMethod
			public void closeApp() {
				driver.quit();
				Reporter.log("Closing the Browser", true);
			}
		}

	
		
	


