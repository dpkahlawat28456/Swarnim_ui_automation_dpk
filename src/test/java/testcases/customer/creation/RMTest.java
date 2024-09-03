package testcases.customer.creation;

import org.openqa.selenium.By;
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
import pages.customer.creation.RMPage;
import property.PropertyFile;
import utility.BaseFile;

public class RMTest extends BaseFile {

	
	private ExtentReports extent;
	private WebDriver driver;
	private RMPage rmPage;
	private ExtentTest test;
	
	public WebDriverWait wait;

	PropertyFile propReader = new PropertyFile();
	BrowserFactory browserFactory = new BrowserFactory();

	// This method is calling driver and extent report.
	@BeforeMethod
	private void navigateToBaseURL() throws Exception {
		driver = BaseFile.driver;
		rmPage = new RMPage(driver, 5);
		extent = extentBase;
		ScreenshotListener.setDriver(driver);

	}

	

	@Test
	private void swarnimLoginPage() throws Exception {

		
				
		 rmPage.Buttonclick(rmPage.RM);
		
		 Thread.sleep(200);
      	 driver.findElement(By.cssSelector("[data-value='DD Test']")).click();
        
		rmPage.Buttonclick(rmPage.next);
		
				
		

					// Validate the login with empty email ID
					

				
				}
			}