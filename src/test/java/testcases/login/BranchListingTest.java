package testcases.login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import driver.BrowserFactory;
import listeners.ScreenshotListener;
import pages.login.BranchListingPage;
import property.PropertyFile;
import utility.BaseFile;

public class BranchListingTest extends BaseFile {
	public ExtentReports extent;
	public WebDriver driver;
	public BranchListingPage branchListingPage;
	private ExtentTest test;
	

	PropertyFile propReader = new PropertyFile();
	BrowserFactory browserFactory = new BrowserFactory();

	// This method is calling driver and extent report.
	@BeforeMethod
	private void pageURL() {
		driver = BaseFile.driver;
		branchListingPage = new BranchListingPage(driver, 5);
		ScreenshotListener.setDriver(driver);
		extent = extentBase;
		

	}

	@Test(priority = 1)
	private void selectBranchCodeFromBranchListingAfterLogin() throws InterruptedException {
		try {
			test = extent.createTest("Validate navigation to dashboard from branch selection page");
			branchListingPage.selectBranchCode();
			Assert.assertEquals(branchListingPage.customer360Tab.getText(), "Customer 360");

			test.log(Status.PASS, "Successfully navigated from branch selction page to Dashboard");
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// Capture the NoSuchElementException message
			test.log(Status.SKIP, e.getMessage());
			Assert.fail("Deliberate failure to capture screenshot");

		} catch (AssertionError e) {
			// Capture the exception message
			test.log(Status.FAIL, e.getMessage());
			Assert.fail("Deliberate failure to capture screenshot");
		}

	}

	@Test(priority = 2)
	private void selectCutomer360TabFromDashBoard() {
		try {
			test = extent.createTest("Validate navigation to Customer 360 page from Dashboard page");
			branchListingPage.selectcustomer360tab();
			Assert.assertEquals(branchListingPage.createCustomerWebElement.getText(), "Customer Creation");

			test.log(Status.PASS, "Successfully navigated from Dashboard page to Customer 360 page");
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// Capture the NoSuchElementException message
			test.log(Status.SKIP, e.getMessage());
			Assert.fail("Deliberate failure to capture screenshot");

		} catch (AssertionError e) {
			// Capture the exception message
			test.log(Status.FAIL, e.getMessage());
			Assert.fail("Deliberate failure to capture screenshot");
		}

	}
	
	
	@Test(priority = 3)
	private void clickCreateCustomerButton() throws InterruptedException {
		try {
			test = extent.createTest("Validate navigation to Customer 360 page from Dashboard page");
			branchListingPage.clickcreateCustomerDashboardIconWebElement();
			branchListingPage.clickCreateCustomerButtonWebElement();

			Thread.sleep(1500);
//			Assert.assertEquals(branchListingPage.createCustomerWebElement.getText(), "Customer Creation");

			test.log(Status.PASS, "Successfully navigated from Dashboard page to Customer 360 page");
		} catch (org.openqa.selenium.NoSuchElementException e) {
			// Capture the NoSuchElementException message
			test.log(Status.SKIP, e.getMessage());
			Assert.fail("Deliberate failure to capture screenshot");

		} catch (AssertionError e) {
			// Capture the exception message
			test.log(Status.FAIL, e.getMessage());
			Assert.fail("Deliberate failure to capture screenshot");
		}

	}
}