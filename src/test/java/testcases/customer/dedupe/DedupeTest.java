package testcases.customer.dedupe;


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
import pages.customer.dedupe.DedupePage;

import property.PropertyFile;
import utility.BaseFile;

public class DedupeTest extends BaseFile {

	private static final String TESTCASES_SHEET = "swarnimCustomerDeupeFile";
	private static final String SHEET_NAME = "swarnimCustomerDedupeSheet";
	private ExtentReports extent;
	private WebDriver driver;
	public DedupePage dedupePage;
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
		dedupePage = new DedupePage(driver, 50);
		extent = extentBase;
		ScreenshotListener.setDriver(driver);
		//wait=new WebDriverWait(driver, Duration.ofSeconds(50));
	
	}

	// This method is used to read from excel.

	@DataProvider(name = "customerDedupeDataProvider")
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

	@Test(dataProvider = "customerDedupeDataProvider")
	private void swarnimLoginPage(Map<String, Object> fetchData) throws InterruptedException {

		
		System.out.println(fetchData.toString());
		if (fetchData.entrySet() != null) {
			for (Map.Entry<String, Object> entry : fetchData.entrySet()) {

				String firstName= null;
				String lastName = null;
				String fatherName = null;
				String year = null;
				String month= null;
				String date = null;
				String pan= null;
				String mobilenumber = null;
				String message=null;
				String testId=null;
				String testScenario=null;
				

		try {
					JSONObject testData = (JSONObject) entry.getValue();
					testScenario = new String((String) testData.get("Test_Senario"));
					testId= new String((String) testData.get("TestID")).toString();
					firstName= new String((String) testData.get("Firstname")).toString();
					lastName= new String((String) testData.get("Lastname")).toString();
					fatherName= new String((String) testData.get("Fathername")).toString();
					year= new String((String) testData.get("DOB_Year")).toString();
					month= new String((String) testData.get("DOB_month")).toString();
					date= new String((String) testData.get("DOB_date")).toString();
					pan= new String((String) testData.get("PAN")).toString();
					mobilenumber= new String((String) testData.get("mobile_Number")).toString();
					message = new String((String) testData.get("Message"));
					
					String resultValue = testData.get("result").toString();
					
					
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		test = extent.createTest(testScenario);
               
	
       try {
    	             int monthval=0;
				if(!testId.equals("TC_05")) {
				 monthval=Integer.valueOf(month);}
				     //Validating the Positive Journey
				if(testId.equals("TC_01")) {
					
						dedupePage.firstnamefeild(firstName);
						dedupePage.lastnamefeild(lastName);
						dedupePage.fathernamefeild(fatherName);
						dedupePage.dobButtonclick();
						
						dedupePage.yeardroupDownclick();
						Thread.sleep(200);
				      	 
				      driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
				      	 Thread.sleep(200);
				      	 for(int i=1;i<monthval;i++) {
				      		 dedupePage.monthclick();
				      		 
				      	 }
				      	 Thread.sleep(200);
				      	 driver.findElement(By.xpath("//button[text()='"+date+"']")).click();
						dedupePage.panfeild(pan);
						dedupePage.mobileNumberfeild(mobilenumber);
						dedupePage.customerDedupeButtonclick();
						Assert.assertEquals(dedupePage.isElementdisplayed(dedupePage.createcustomerbtn), true);
						dedupePage.createcustomerbtn.click();
						test.log(Status.PASS, "Validation the Positive Journey of Customer dedupe");
						Thread.sleep(1000);
				}


			
					
					//Validating the Dedupe if First Name is not present	
						if(testId.equals("TC_02")) {
							dedupePage.lastnamefeild(lastName);
							dedupePage.fathernamefeild(fatherName);
							dedupePage.dobButtonclick();
						    dedupePage.yeardroupDownclick();
							Thread.sleep(200);
					      	 
					      	 driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
					      	 Thread.sleep(200);
					      	 for(int i=1;i<monthval;i++) {
					      		 dedupePage.monthclick();
					      		 
					      	 }
					      	 Thread.sleep(200);
					      	 driver.findElement(By.xpath("//button[text()='"+date+"']")).click();
							dedupePage.panfeild(pan);
							dedupePage.mobileNumberfeild(mobilenumber);
							dedupePage.customerDedupeButtonclick();
							Assert.assertEquals(dedupePage.gettext(dedupePage.firstnamevalidator), message);
							test.log(Status.PASS, "Validation first name error message when first name is empty ");
							dedupePage.clickresetbutton();
						}
						
						//Validating the validation on Last Name
						if(testId.equals("TC_03")) {
							dedupePage.firstnamefeild(firstName);
							dedupePage.fathernamefeild(fatherName);
							dedupePage.dobButtonclick();
							Thread.sleep(500);
							
							dedupePage.yeardroupDownclick();
							Thread.sleep(200);
					      	 driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
					      	 Thread.sleep(200);
					      	 for(int i=1;i<monthval;i++) {
					      		 dedupePage.monthclick();
					      		 
					      	 }
					      	 Thread.sleep(200);
					      	 driver.findElement(By.xpath("//button[text()='"+date+"']")).click();
							dedupePage.panfeild(pan);
							dedupePage.mobileNumberfeild(mobilenumber);
							dedupePage.customerDedupeButtonclick();
							Assert.assertEquals(dedupePage.gettext(dedupePage.lastnamevalidator), message);
							test.log(Status.PASS, "Validation last name error message when  last name is empty ");
							dedupePage.clickresetbutton();
						}
						
						//Validating the Validation on father name
						if(testId.equals("TC_04")) {
							dedupePage.firstnamefeild(firstName);
							dedupePage.lastnamefeild(lastName);
							dedupePage.dobButtonclick();
							Thread.sleep(500);
							dedupePage.yeardroupDownclick();
							Thread.sleep(200);
					      	 driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
					      	 Thread.sleep(200);
					      	 for(int i=1;i<monthval;i++) {
					      		 dedupePage.monthclick();
					      		 
					      	 }
					      	 Thread.sleep(200);
					      	 driver.findElement(By.xpath("//button[text()='"+date+"']")).click();
							dedupePage.panfeild(pan);
							dedupePage.mobileNumberfeild(mobilenumber);
							dedupePage.customerDedupeButtonclick();
							Assert.assertEquals(dedupePage.gettext(dedupePage.fathernamevalidator), message);
							test.log(Status.PASS, "Validation error message when  father name is empty ");
							
							dedupePage.clickresetbutton();
						}
						//Validating the validation if mobile number is empty
						if(testId.equals("TC_06")) {
							dedupePage.firstnamefeild(firstName);
							dedupePage.lastnamefeild(lastName);
							dedupePage.fathernamefeild(fatherName);
							dedupePage.dobButtonclick();
							Thread.sleep(500);
							
							dedupePage.yeardroupDownclick();
							Thread.sleep(200);
					      	 
					      	 driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
					      	 Thread.sleep(200);
					      	 for(int i=1;i<monthval;i++) {
					      		 dedupePage.monthclick();
					      		 
					      	 }
					      	 Thread.sleep(200);
					      	 driver.findElement(By.xpath("//button[text()='"+date+"']")).click();
							dedupePage.panfeild(pan);
							dedupePage.customerDedupeButtonclick();
							Assert.assertEquals(dedupePage.gettext(dedupePage.mobilenumbervalidator), message);
							test.log(Status.PASS, "Validation  error message when mobile  is empty ");
							
							dedupePage.clickresetbutton();
							
						}
						//Validating the validation on DOB Field
						if(testId.equals("TC_05")) {
						
						dedupePage.firstnamefeild(firstName);
						dedupePage.lastnamefeild(lastName);
						dedupePage.fathernamefeild(fatherName);
                        dedupePage.panfeild(pan);
						dedupePage.mobileNumberfeild(mobilenumber);
						dedupePage.customerDedupeButtonclick();
						Assert.assertEquals(dedupePage.gettext(dedupePage.dobvalidator), message);
						test.log(Status.PASS, "Validation  error message when mobile  is empty ");
						
						dedupePage.clickresetbutton();
					}
						// Validating the validation on mobile number
						if(testId.equals("TC_07") || testId.equals("TC_08") || testId.equals("TC_09")) {
						
						dedupePage.firstnamefeild(firstName);
						dedupePage.lastnamefeild(lastName);
						dedupePage.fathernamefeild(fatherName);
						dedupePage.dobButtonclick();
						Thread.sleep(500);
						dedupePage.yeardroupDownclick();
						Thread.sleep(200);
				      	 //This use to select year form the provided year Matrix on the basis of text.
				      	 driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
				      	 Thread.sleep(200);
				      	 for(int i=1;i<monthval;i++) {
				      		 dedupePage.monthclick();
				      		 
				      	 }
				      	 Thread.sleep(200);
				      	//This use to select date form the provided year Matrix on the basis of text.
				      	 driver.findElement(By.xpath("//button[text()='"+date+"']")).click();
						dedupePage.panfeild(pan);
						dedupePage.mobileNumberfeild(mobilenumber);
						dedupePage.customerDedupeButtonclick();
						Thread.sleep(500);
						Assert.assertEquals(dedupePage.gettext(dedupePage.mobilenumbervalidator), message);
						test.log(Status.PASS, "Validation  error message when mobile  is incorrect");
						dedupePage.clickresetbutton();
					}
						//Validating the validation on PAN Field
						
						if(testId.equals("TC_10")) {
						dedupePage.firstnamefeild(firstName);
						dedupePage.lastnamefeild(lastName);
						dedupePage.fathernamefeild(fatherName);
						dedupePage.dobButtonclick();
						Thread.sleep(500);
						dedupePage.yeardroupDownclick();
						Thread.sleep(200);
				      	 
				      driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
				      	 Thread.sleep(200);
				      	 for(int i=1;i<monthval;i++) {
				      		 dedupePage.monthclick();
				      		 
				      	 }
				      	 Thread.sleep(200);
				      	 driver.findElement(By.xpath("//button[text()='"+date+"']")).click();
						dedupePage.panfeild(pan);
						dedupePage.mobileNumberfeild(mobilenumber);
						dedupePage.customerDedupeButtonclick();
						Assert.assertEquals(dedupePage.gettext(dedupePage.panvalidator), message);
						test.log(Status.PASS, "Validation  error message when mobile  is empty ");
						dedupePage.clickresetbutton();
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