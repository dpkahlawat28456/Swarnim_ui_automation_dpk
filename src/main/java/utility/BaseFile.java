package utility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;

import driver.BrowserFactory;
import report.ExtentManager;

public class BaseFile {

	public static WebDriver driver;
	BrowserFactory driverObj = new BrowserFactory();

	ExtentManager reportObj = new ExtentManager();
	public static ExtentReports extentBase;

	@BeforeSuite
	public ExtentReports callBaseReport() {
		extentBase = ExtentManager.report();
		return extentBase;
	}

	@Parameters("browser")
	@BeforeTest
	public WebDriver calldriver(String browser) {		
		driver = driverObj.initializeDriver(browser);
		return driver;
	}

	@AfterTest
	public WebDriver closedriver() {
		driver.close();
		return driver;
	}

	@AfterSuite
	public void flushReport() {
		reportObj.flushReport();
	}

}
