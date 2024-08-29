package testcases.customer.creation;

import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import driver.BrowserFactory;
import excel.ExcelRead;
import listeners.ScreenshotListener;
import pages.customer.creation.KYCPage;
import property.PropertyFile;
import utility.BaseFile;

public class KYCTest extends BaseFile {

	private static final String TESTCASES_SHEET = "swarnimLoginFile";
	private static final String SHEET_NAME = "swarnimLoginSheet";
	private ExtentReports extent;
	private WebDriver driver;
	private KYCPage kycPage;
	private ExtentTest test;
	private int rownum;
	private Map<String, Object>[][] empdata;
	public WebDriverWait wait;

	PropertyFile propReader = new PropertyFile();
	BrowserFactory browserFactory = new BrowserFactory();

	// This method is calling driver and extent report.
	@BeforeMethod
	private void navigateToBaseURL() throws Exception {
		driver = BaseFile.driver;
		kycPage = new KYCPage(driver, 5);
		//kycPage.openURL();
		extent = extentBase;
		ScreenshotListener.setDriver(driver);

	}
	@Test
	public void swarnimKyc() throws InterruptedException {
		kycPage.enterValue("256374354757",kycPage.aadharfeild);
		kycPage.Buttonclick(kycPage.sendotp);
		kycPage.Buttonclick(kycPage.crossbutton);
	    kycPage.Buttonclick(kycPage.biomatricsradioButton);
		kycPage.Buttonclick(kycPage.crossbutton);
		kycPage.Buttonclick(kycPage.crossbutton);
		Thread.sleep(2000);
		kycPage.Buttonclick(kycPage.offlineradioButton);
		
	}
	

	// This method is used to read from excel.

	@DataProvider(name = "loginPageDataProvider")
	private Map<String, Object>[][] callTestDataFromExcel() throws Exception {
		String testDataSheet = propReader.getProp().get(SHEET_NAME).toString().trim();
		String filePath = System.getProperty("user.dir") + propReader.getProp().get(TESTCASES_SHEET).toString().trim();

		{
			List<Map<String, Object>> dataList = ExcelRead.getExcelData(filePath, testDataSheet);
			rownum = dataList.size();
			empdata = (Map<String, Object>[][]) new HashMap[rownum][1];
			for (int i = 0; i < rownum; i++) {
				empdata[i][0] = dataList.get(i);
			}
			return (empdata);
		}
	}

	@Test(dataProvider = "loginPageDataProvider")
	private void swarnimKYCPage(Map<String, Object> fetchData) throws InterruptedException {

		if (fetchData.entrySet() != null) {
			for (Map.Entry<String, Object> entry : fetchData.entrySet()) {

				String testScenarioRequest = null;
				String emailCred = null;
				String passCred = null;
				String messageData = null;
				boolean status = false;

				try {
					JSONObject testData = (JSONObject) entry.getValue();
					testScenarioRequest = new String((String) testData.get("testScenario"));
					emailCred = new String((String) testData.get("email")).toString();
					passCred = new String((String) testData.get("pass")).toString();
					messageData = new String((String) testData.get("message"));
					String resultValue = testData.get("result").toString();
					status = Boolean.parseBoolean(resultValue);

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}



				test = extent.createTest(testScenarioRequest);

				try {

					

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

	}
}