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
import pages.customer.creation.NomineePage;

import property.PropertyFile;
import utility.BaseFile;

public class NomineeTest extends BaseFile {

	private static final String TESTCASES_SHEET = "CustomernomineeFile";
	private static final String SHEET_NAME = "swarnimCustomerDedupeSheet";
	private ExtentReports extent;
	private WebDriver driver;
	public NomineePage nomineePage;
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
		nomineePage = new NomineePage(driver, 50);
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

				String nomineeRelation= null;
				String nomineeName = null;
				String year = null;
				String month = null;
				String date= null;
				String mobile = null;
				String testId=null;
				String testScenario=null;
				int monthval=0;
				
				

		try {
					JSONObject testData = (JSONObject) entry.getValue();
					testScenario = new String((String) testData.get("testsenario"));
					testId= new String((String) testData.get("testId")).toString();
					nomineeRelation= new String((String) testData.get("nominerelation")).toString();
					nomineeName= new String((String) testData.get("nomineName")).toString();
					year= new String((String) testData.get("nominedobyear")).toString();
					month= new String((String) testData.get("nominedobmonth")).toString();
					date= new String((String) testData.get("nominedobday")).toString();
					mobile= new String((String) testData.get("mobile")).toString();
					
					
					String resultValue = testData.get("result").toString();
					
					
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		test = extent.createTest(testScenario);
               
	
       try {
    	   monthval=Integer.valueOf(month);
                 
    	   nomineePage.Buttonclick(nomineePage.nomineeRelation);
                 Thread.sleep(200);
		      	 driver.findElement(By.cssSelector("[data-value='" + nomineeRelation + "']")).click();
		      	nomineePage.enterValue(nomineeName,nomineePage.nomineeName);
		      	nomineePage.Buttonclick(nomineePage.calender);
		      	nomineePage.Buttonclick(nomineePage.yearDropdown);
				
				Thread.sleep(200);
		      	 
			      driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
			      	 Thread.sleep(200);
			      	 for(int i=1;i<monthval;i++) {
			      		nomineePage.Buttonclick(nomineePage.month);
			      		 
			      	 }
			      	 Thread.sleep(500);
			      	 driver.findElement(By.xpath("//button[text()='"+date+"']")).click();
		      	nomineePage.enterValue(mobile, nomineePage.mobile);
		      	nomineePage.Buttonclick(nomineePage.next);
		      	 
		      	 
                 

			
					
					
						
                    
					

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