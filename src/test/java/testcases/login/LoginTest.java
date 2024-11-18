package testcases.login;

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
import pages.login.LoginPage;
import property.PropertyFile;
import utility.BaseFile;

public class LoginTest extends BaseFile {

	private static final String TESTCASES_SHEET = "swarnimLoginFile";
	private static final String SHEET_NAME = "swarnimLoginSheet";
	private ExtentReports extent;
	private WebDriver driver;
	private LoginPage loginPage;
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
		loginPage = new LoginPage(driver, 5);
		loginPage.openURL();
		extent = extentBase;
		ScreenshotListener.setDriver(driver);

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
	private void swarnimLoginPage(Map<String, Object> fetchData) throws InterruptedException {

		if (fetchData.entrySet() != null) {
			for (Map.Entry<String, Object> entry : fetchData.entrySet()) {

				String testScenarioRequest = null;
				String emailCred = null;
				String passCred = null;
				String messageData = null;
				boolean status = false;

				try {
					//There are several other ways to add data 
					 //TODO Switch case can be use in pace of if 
					JSONObject testData = (JSONObject) entry.getValue();
					testScenarioRequest = new String((String) testData.get("testScenario"));
					emailCred = new String((String) testData.get("email")).toString();
					passCred = new String((String) testData.get("pass")).toString();
					messageData = new String((String) testData.get("message"));
					String resultValue = testData.get("result").toString();
					status = Boolean.parseBoolean(resultValue);
                         // Instead of providing hardcode we have another way to make dynamic
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}



				test = extent.createTest(testScenarioRequest);

				try {

					// Validate the login with valid cred
					if (status == true) {
						loginPage.loginCredential(emailCred);
						loginPage.passWord(passCred);
						loginPage.clickloginButton();
						Assert.assertEquals(loginPage.isElementdisplayed(loginPage.branchElement), true);
						test.log(Status.PASS, "User is able to login successfully: ");
					}

					// Validate the login with empty email ID
					if (emailCred.isEmpty() && status == false) {
						loginPage.passWord(passCred);
						loginPage.clickloginButton();
						Assert.assertEquals(loginPage.gettext(loginPage.EmailValidation), messageData);
						test.log(Status.PASS, "Validation message validated successfully for empty email");
					}

					// Validate the login with empty Pass
					if (passCred.isEmpty() && status == false) {
						loginPage.loginCredential(emailCred);
						loginPage.clickloginButton();
						Assert.assertEquals(loginPage.gettext(loginPage.passwordElementValidation), messageData);
						test.log(Status.PASS, "Validation message validated successfully for empty Password");
					}

					// Validate the login with invalid email and pass
					if (!passCred.isEmpty() && !emailCred.isEmpty() && status == false) {
						loginPage.loginCredential(emailCred);
						loginPage.passWord(passCred);
						loginPage.clickloginButton();
						Assert.assertEquals(loginPage.gettext(loginPage.invaidCredElementValidation), messageData);
						test.log(Status.PASS, "Validation message validated successfully for invalid email and pass");
					}

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