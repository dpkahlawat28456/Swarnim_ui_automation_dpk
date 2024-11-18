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
import pages.customer.creation.PersonalInformationPage;

import property.PropertyFile;
import utility.BaseFile;

public class PersonalInformationTest extends BaseFile {

	private static final String TESTCASES_SHEET = "CustomerpersonalinformationFile";
	private static final String SHEET_NAME = "swarnimCustomerDedupeSheet";
	private ExtentReports extent;
	private WebDriver driver;
	public PersonalInformationPage personalPage;
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
		personalPage = new PersonalInformationPage(driver, 50);
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

				String residenceYear= null;
				String education = null;
				String gender = null;
				String mobile = null;
				String marital= null;
				String religion = null;
				String motherName= null;
				String fathername = null;
				String socialStaus=null;
				String testId=null;
				String testScenario=null;
				String placeOfBirth=null;
				

		try {
					JSONObject testData = (JSONObject) entry.getValue();
					String str = Integer.toString(personalPage.randomNumber());
					StringBuilder sb = new StringBuilder();
					sb.append("45");
					sb.append(str);
					testScenario = new String((String) testData.get("testsenario"));
					testId= new String((String) testData.get("testId")).toString();
					residenceYear= new String((String) testData.get("yearsofResident")).toString();
					gender= new String((String) testData.get("gender")).toString();
					education= new String((String) testData.get("education")).toString();
					mobile= sb.toString();
					marital= new String((String) testData.get("mertalStatus")).toString();
					religion= new String((String) testData.get("religion")).toString();
					motherName= new String((String) testData.get("motherName")).toString();
					fathername= new String((String) testData.get("fatherName")).toString();
					socialStaus = new String((String) testData.get("socialStatus")).toString();
					placeOfBirth = new String((String) testData.get("placeOfBirth")).toString();
					String resultValue = testData.get("result").toString();
					
					
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		test = extent.createTest(testScenario);
               
	
       try {
    	   
    	   
    	        
    	        if(testId.equals("TC_01")) {   
                 personalPage.enterValue(residenceYear, personalPage.noOfyear);
                 personalPage.Buttonclick(personalPage.education);
                 Thread.sleep(200);
		      	 driver.findElement(By.cssSelector("[data-value='" + education + "']")).click();
                 personalPage.enterValue(mobile,personalPage.phoneNumber);
                 personalPage.Buttonclick(personalPage.maritalStatus);
                 Thread.sleep(200);
		      	 driver.findElement(By.cssSelector("[data-value='" + marital + "']")).click();
		      	personalPage.Buttonclick(personalPage.gender);
                Thread.sleep(200);
		      	 driver.findElement(By.cssSelector("[data-value='" + gender + "']")).click();
		      	personalPage.Buttonclick(personalPage.relegion);
                Thread.sleep(200);
		      	 driver.findElement(By.cssSelector("[data-value='" + religion + "']")).click();
		      	personalPage.Buttonclick(personalPage.socialStatus);
                Thread.sleep(200);
		      	 driver.findElement(By.cssSelector("[data-value='" + socialStaus + "']")).click();
		      	 personalPage.enterValue(motherName, personalPage.motherName);
		      	 personalPage.enterValue(fathername, personalPage.fatherName);
		      	 personalPage.enterValue(placeOfBirth, personalPage.placeOfBirth);
		      	
		      	 personalPage.Buttonclick(personalPage.next);
		      	 
    	        }
    	        
    	        if(testId.equals("TC_02")) {
					Thread.sleep(1000);
					personalPage.Buttonclick(personalPage.back);
					
					personalPage.Buttonclick(personalPage.relegion);
	                Thread.sleep(200);
			      	 driver.findElement(By.cssSelector("[data-value='" + religion + "']")).click();
			      	personalPage.Buttonclick(personalPage.next);
			      	 
					
					Thread .sleep(500);
			    	//Assert.assertEquals(kycPage.isElementdisplayed(kycPage.back), true);
					test.log(Status.PASS, "User abel to proceed with Religion Muslim");
				}	    
    	        if(testId.equals("TC_03")) {
					Thread.sleep(1000);
					personalPage.Buttonclick(personalPage.back);
					
					personalPage.Buttonclick(personalPage.relegion);
	                Thread.sleep(200);
			      	 driver.findElement(By.cssSelector("[data-value='" + religion + "']")).click();
			      	personalPage.Buttonclick(personalPage.next);
			      	 
					
					Thread .sleep(500);
			    	//Assert.assertEquals(kycPage.isElementdisplayed(kycPage.back), true);
					test.log(Status.PASS, "User abel to proceed with Religion Christian ");
				}	    
    	        if(testId.equals("TC_04")) {
					Thread.sleep(1000);
					personalPage.Buttonclick(personalPage.back);
					
					personalPage.Buttonclick(personalPage.relegion);
	                Thread.sleep(200);
			      	 driver.findElement(By.cssSelector("[data-value='" + religion + "']")).click();
			      	personalPage.Buttonclick(personalPage.next);
			      	 
					
					Thread .sleep(500);
			    	//Assert.assertEquals(kycPage.isElementdisplayed(kycPage.back), true);
					test.log(Status.PASS, "User abel to proceed with Religion Sikh ");
				}	    
    	        if(testId.equals("TC_05")) {
					Thread.sleep(1000);
					personalPage.Buttonclick(personalPage.back);
					
					personalPage.Buttonclick(personalPage.relegion);
	                Thread.sleep(200);
			      	 driver.findElement(By.cssSelector("[data-value='" + religion + "']")).click();
			      	personalPage.Buttonclick(personalPage.next);
			      	 
					
					Thread .sleep(500);
			    	//Assert.assertEquals(kycPage.isElementdisplayed(kycPage.back), true);
					test.log(Status.PASS, "User abel to proceed with Religion ");
				}	    
    	        if(testId.equals("TC_06")) {
					Thread.sleep(1000);
					personalPage.Buttonclick(personalPage.back);
					//test = extent.createTest("Validate the positive online verification flow with prefix Mrs");
					personalPage.Buttonclick(personalPage.relegion);
	                Thread.sleep(200);
			      	 driver.findElement(By.cssSelector("[data-value='" + religion + "']")).click();
			      	personalPage.Buttonclick(personalPage.next);
			      	 
					
					Thread .sleep(500);
			    	//Assert.assertEquals(kycPage.isElementdisplayed(kycPage.back), true);
					test.log(Status.PASS, "User abel to proceed with prefix Mrs ");
				}	    
    	        if(testId.equals("TC_07")) {
					Thread.sleep(1000);
					personalPage.Buttonclick(personalPage.back);
					//test = extent.createTest("Validate the positive online verification flow with prefix Mrs");
					personalPage.Buttonclick(personalPage.relegion);
	                Thread.sleep(200);
			      	 driver.findElement(By.cssSelector("[data-value='" + religion + "']")).click();
			      	personalPage.Buttonclick(personalPage.next);
			      	 
					
					Thread .sleep(500);
			    	//Assert.assertEquals(kycPage.isElementdisplayed(kycPage.back), true);
					test.log(Status.PASS, "User abel to proceed with prefix Mrs ");
				}	    
    	        if(testId.equals("TC_08")) {
					Thread.sleep(1000);
					personalPage.Buttonclick(personalPage.back);
					//test = extent.createTest("Validate the positive online verification flow with prefix Mrs");
					personalPage.Buttonclick(personalPage.relegion);
	                Thread.sleep(200);
			      	 driver.findElement(By.cssSelector("[data-value='" + religion + "']")).click();
			      	personalPage.Buttonclick(personalPage.next);
			      	 
					
					Thread .sleep(500);
			    	//Assert.assertEquals(kycPage.isElementdisplayed(kycPage.back), true);
					test.log(Status.PASS, "User abel to proceed with prefix Mrs ");
				}	    
    	        if(testId.equals("TC_09")) {
					Thread.sleep(1000);
					personalPage.Buttonclick(personalPage.back);
					//test = extent.createTest("Validate the positive online verification flow with prefix Mrs");
					personalPage.Buttonclick(personalPage.relegion);
	                Thread.sleep(200);
			      	 driver.findElement(By.cssSelector("[data-value='" + religion + "']")).click();
			      	personalPage.Buttonclick(personalPage.next);
			      	 
					
					Thread .sleep(500);
			    	//Assert.assertEquals(kycPage.isElementdisplayed(kycPage.back), true);
					test.log(Status.PASS, "User abel to proceed with prefix Mrs ");
				}	  
    	        if(testId.equals("TC_10")) {
					Thread.sleep(1000);
					personalPage.Buttonclick(personalPage.back);
					//test = extent.createTest("Validate the positive online verification flow with prefix Mrs");
					personalPage.Buttonclick(personalPage.socialStatus);
	                Thread.sleep(200);
			      	 driver.findElement(By.cssSelector("[data-value='" + socialStaus + "']")).click();
			      	personalPage.Buttonclick(personalPage.next);
			      	 
					
					Thread .sleep(500);
			    	//Assert.assertEquals(kycPage.isElementdisplayed(kycPage.back), true);
					test.log(Status.PASS, "User abel to proceed with prefix Mrs ");
				}	    
    	        if(testId.equals("TC_11")) {
					Thread.sleep(1000);
					personalPage.Buttonclick(personalPage.back);
					//test = extent.createTest("Validate the positive online verification flow with prefix Mrs");
					personalPage.Buttonclick(personalPage.socialStatus);
	                Thread.sleep(200);
			      	 driver.findElement(By.cssSelector("[data-value='" + socialStaus + "']")).click();
			      	personalPage.Buttonclick(personalPage.next);
			      	 
					
					Thread .sleep(500);
			    	//Assert.assertEquals(kycPage.isElementdisplayed(kycPage.back), true);
					test.log(Status.PASS, "User abel to proceed with prefix Mrs ");
				}	    
    	        if(testId.equals("TC_12")) {
					Thread.sleep(1000);
					personalPage.Buttonclick(personalPage.back);
					//test = extent.createTest("Validate the positive online verification flow with prefix Mrs");
					personalPage.Buttonclick(personalPage.socialStatus);
	                Thread.sleep(200);
			      	 driver.findElement(By.cssSelector("[data-value='" + socialStaus + "']")).click();
			      	personalPage.Buttonclick(personalPage.next);
			      	 
					
					Thread .sleep(500);
			    	//Assert.assertEquals(kycPage.isElementdisplayed(kycPage.back), true);
					test.log(Status.PASS, "User abel to proceed with prefix Mrs ");
				}	    
    	        if(testId.equals("TC_13") || testId.equals("TC_14")) {
					Thread.sleep(1000);
					personalPage.Buttonclick(personalPage.back);
					//test = extent.createTest("Validate the positive online verification flow with prefix Mrs");
					personalPage.Buttonclick(personalPage.gender);
	                Thread.sleep(200);
			      	 driver.findElement(By.cssSelector("[data-value='" + gender + "']")).click();
			      	personalPage.Buttonclick(personalPage.next);
			      	 
					
					Thread .sleep(500);
			    	//Assert.assertEquals(kycPage.isElementdisplayed(kycPage.back), true);
					test.log(Status.PASS, "User abel to proceed with prefix Mrs ");
				}	    
    	        if(testId.equals("TC_15") || testId.equals("TC_16")|| testId.equals("TC_17")|| testId.equals("TC_18")|| testId.equals("TC_19")) {
					Thread.sleep(1000);
					personalPage.Buttonclick(personalPage.back);
					//test = extent.createTest("Validate the positive online verification flow with prefix Mrs");
					personalPage.Buttonclick(personalPage.education);
	                Thread.sleep(200);
			      	 driver.findElement(By.cssSelector("[data-value='" + education + "']")).click();
			      	personalPage.Buttonclick(personalPage.next);
			      	 
					
					Thread .sleep(500);
			    	//Assert.assertEquals(kycPage.isElementdisplayed(kycPage.back), true);
					test.log(Status.PASS, "User abel to proceed with prefix Mrs ");
				}	 
    	        if(testId.equals("TC_20") || testId.equals("TC_21")) {
					Thread.sleep(1000);
					personalPage.Buttonclick(personalPage.back);
					//test = extent.createTest("Validate the positive online verification flow with prefix Mrs");
					personalPage.Buttonclick(personalPage.maritalStatus);
	                Thread.sleep(200);
			      	 driver.findElement(By.cssSelector("[data-value='" + marital + "']")).click();
			      	personalPage.Buttonclick(personalPage.next);
			      	 
					
					Thread .sleep(500);
			    	//Assert.assertEquals(kycPage.isElementdisplayed(kycPage.back), true);
					test.log(Status.PASS, "User abel to proceed with prefix Mrs ");
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