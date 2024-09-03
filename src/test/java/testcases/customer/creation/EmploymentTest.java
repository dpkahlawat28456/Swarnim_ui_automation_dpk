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
import pages.customer.creation.EmploymentPage;

import property.PropertyFile;
import utility.BaseFile;

public class EmploymentTest extends BaseFile {

	private static final String TESTCASES_SHEET = "CustomeremploymentinformationFile";
	private static final String SHEET_NAME = "swarnimCustomerKycsheet";
	private ExtentReports extent;
	private WebDriver driver;
	public EmploymentPage employmentPage;
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
		employmentPage = new EmploymentPage(driver, 50);
		extent = extentBase;
		ScreenshotListener.setDriver(driver);
		
	
	}

	// This method is used to read from excel.

	@DataProvider(name = "employmentdataprovider")
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

	@Test(dataProvider = "employmentdataprovider")
	private void swarnimLoginPage(Map<String, Object> fetchData) throws InterruptedException {

		
		System.out.println(fetchData.toString());
		if (fetchData.entrySet() != null) {
			for (Map.Entry<String, Object> entry : fetchData.entrySet()) {

				
				
				String occupation = null;
				String income=null;
				String testId=null;
				String testScenario=null;
				
				

		try {
					JSONObject testData = (JSONObject) entry.getValue();
					testScenario = new String((String) testData.get("testsenario"));
					testId= new String((String) testData.get("testId")).toString();
					
					occupation = new String((String) testData.get("occuption")).toString();
					income = new String((String) testData.get("income")).toString();
					String resultValue = testData.get("result").toString();
					
					
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		test = extent.createTest(testScenario);
               
	
       try {
    	           
                
    	   employmentPage.Buttonclick(employmentPage.occupation);
                 Thread.sleep(200);
		      	 driver.findElement(By.cssSelector("[data-value='" + occupation + "']")).click();
		      	 Thread.sleep(1000);
                employmentPage.Buttonclick(employmentPage.income);
                 Thread.sleep(200);
		      	 driver.findElement(By.cssSelector("[data-value='" + income + "']")).click();
		      	
		      	employmentPage.Buttonclick(employmentPage.next);
		      	 
		      	 
                 

			
					
					
						
                    
					

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