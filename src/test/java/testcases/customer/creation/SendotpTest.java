package testcases.customer.creation;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
import pages.customer.creation.SendotpPage;

import property.PropertyFile;
import utility.BaseFile;

public class SendotpTest extends BaseFile {

	private static final String TESTCASES_SHEET = "CustomersendOtpfile";
	private static final String SHEET_NAME = "swarnimCustomerDedupeSheet";
	private ExtentReports extent;
	private WebDriver driver;
	public SendotpPage sendotpPage;
	private ExtentTest test;
	private int rownum;
	private Map<String, Object>[][] empdata;
	public WebDriverWait wait;

	PropertyFile propReader = new PropertyFile();
	BrowserFactory browserFactory = new BrowserFactory();

	// This method is calling driver and extent report.
	@BeforeMethod
	private void navigateToBaseURL() {
		driver = BaseFile.driver;
		sendotpPage = new SendotpPage(driver, 50);
		extent = extentBase;
		ScreenshotListener.setDriver(driver);
		
	
	}

	// This method is used to read from excel.

	@DataProvider(name = "personalInformationdataprovider")
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

	@Test(dataProvider = "personalInformationdataprovider")
	private void swarnimLoginPage(Map<String, Object> fetchData) throws InterruptedException {

		
		System.out.println(fetchData.toString());
		if (fetchData.entrySet() != null) {
			for (Map.Entry<String, Object> entry : fetchData.entrySet()) {

				
				String otp=null;
				String testId=null;
				String testScenario=null;
				
				

		try {
					JSONObject testData = (JSONObject) entry.getValue();
					testScenario = new String((String) testData.get("testsenario"));
					testId= new String((String) testData.get("testId")).toString();
					
					otp = new String((String) testData.get("Otp")).toString();
					
					String resultValue = testData.get("result").toString();
					
					
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		test = extent.createTest(testScenario);
               
	
       try {
    	           
                
    	   sendotpPage.Buttonclick(sendotpPage.sendOtp);
           sendotpPage.enterValue(otp, sendotpPage.otpInput);
           sendotpPage.Buttonclick(sendotpPage.verifyBtn);
           Thread.sleep(5000);
           sendotpPage.Buttonclick(sendotpPage.createBtn);
           Assert.assertEquals(sendotpPage.isElementdisplayed(sendotpPage.customerCreate), true);
					
					
				
				Thread.sleep(2000);
					

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