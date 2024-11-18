package testcases.customer.creation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import driver.BrowserFactory;
import listeners.ScreenshotListener;
import pages.customer.creation.OccuptionPages;
import property.PropertyFile;
import utility.BaseFile;

public class OccupationTest extends BaseFile {

	
	private ExtentReports extent;
	private WebDriver driver;
	private OccuptionPages occupationPage;
	private ExtentTest test;
	
	public WebDriverWait wait;

	PropertyFile propReader = new PropertyFile();
	BrowserFactory browserFactory = new BrowserFactory();

	// This method is calling driver and extent report.
	@BeforeMethod
	private void navigateToBaseURL() throws Exception {
		driver = BaseFile.driver;
		occupationPage = new OccuptionPages(driver, 5);
		extent = extentBase;
		ScreenshotListener.setDriver(driver);

	}

	

	@Test
	private void swarnimLoginPage() throws Exception {
    
		test = extent.createTest("Validating The Occupation Detail page");
		
				
		occupationPage.Buttonclick(occupationPage.no);
		occupationPage.Buttonclick(occupationPage.next);
		
				
		

					// Validate the login with empty email ID
					

				
				}
			}
		

	

