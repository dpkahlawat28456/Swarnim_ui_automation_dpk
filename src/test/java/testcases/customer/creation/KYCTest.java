package testcases.customer.creation;

import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

	private static final String TESTCASES_SHEET = "swarnimCustomerKycFile";
	private static final String SHEET_NAME = "swarnimCustomerKycsheet";
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
		
		extent = extentBase;
		ScreenshotListener.setDriver(driver);

	}
	@Test(priority = 1)
	public void swarnimKyc() throws InterruptedException {
		driver.get("https://swarnim-uat.capriglobal.in/customer-creation");
		kycPage.enterValue("256374354567",kycPage.aadharfeild);
		kycPage.Buttonclick(kycPage.sendotp);
		kycPage.Buttonclick(kycPage.crossbutton);
	    kycPage.Buttonclick(kycPage.biomatricsradioButton);
	    Thread.sleep(2000);
		kycPage.Buttonclick(kycPage.crossbutton);
		Thread.sleep(500);
		kycPage.Buttonclick(kycPage.crossbutton);
		
		test = extent.createTest("Validate if offline button is enable after biometric faliure");
		 Assert.assertTrue(kycPage.offlineradioButton.isDisplayed() && kycPage.offlineradioButton.isEnabled());
		 test.log(Status.PASS, "Successfully offile button is enable");

		kycPage.Buttonclick(kycPage.offlineradioButton);

		
		
	}
	

	// This method is used to read from excel.

	@DataProvider(name = "KycPageDataProvider")
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

	@Test(dataProvider = "KycPageDataProvider",priority = 2)
	private void swarnimKYCPage(Map<String, Object> fetchData) throws InterruptedException {

		if (fetchData.entrySet() != null) {
			for (Map.Entry<String, Object> entry : fetchData.entrySet()) {

				String testScenarioRequest = null;
				String testId = null;
			    String aadharno= null;
			    String firstName = null;
				String lastName= null;
			    String prefix= null;
			    String addressOne=null;
			    String addressTwo=null;
			    String pinCode=null;
			    String year=null;
			    String month=null;
			    String date=null;
			    String idProof=null;
			    int monthval=0;

				try {
					JSONObject testData = (JSONObject) entry.getValue();
					testScenarioRequest = new String((String) testData.get("testSenario"));
					testId = new String((String) testData.get("testID")).toString();
					aadharno= new String((String) testData.get("aadharno")).toString();
					firstName = new String((String) testData.get("firstName"));
					lastName= new String((String) testData.get("lastName"));
					prefix = new String((String) testData.get("prefix")).toString();
					addressOne= new String((String) testData.get("addressOne")).toString();
					addressTwo = new String((String) testData.get("addressTwo"));
					pinCode = new String((String) testData.get("pinCode")).toString();
					year= new String((String) testData.get("dobYear")).toString();
					month = new String((String) testData.get("dobMonth"));
					date = new String((String) testData.get("dobDay")).toString();
					idProof= new String((String) testData.get("Idproof")).toString();

					

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}



				test = extent.createTest(testScenarioRequest);

				try {
					 monthval=Integer.valueOf(month);
					kycPage.enterValue(aadharno,kycPage.aadharfeild);
					kycPage.Buttonclick(kycPage.verifyAaadhar);
					kycPage.Buttonclick(kycPage.aadharImagebox);
					for(int i=0;i<3;i++) {
					Thread.sleep(1500);
					
						kycPage.Buttonclick(kycPage.frontImagebutton);
						
					}
					for(int i=0;i<3;i++) {
						Thread.sleep(1500);
						
							kycPage.Buttonclick(kycPage.backImagebutton);
							
						}	
					kycPage.Buttonclick(kycPage.frontimageconfirm);
					kycPage.Buttonclick(kycPage.backImageconfirm);
					kycPage.Buttonclick(kycPage.saveImageconfirm);
					kycPage.Buttonclick(kycPage.aadharOSVyes);
					kycPage.enterValue(firstName,kycPage.firstName);
					
					kycPage.enterValue(lastName,kycPage.lastName);
					kycPage.Buttonclick(kycPage.calender);
					//Thread.sleep(500);
					kycPage.Buttonclick(kycPage.yearDropdown);
					
					Thread.sleep(200);
			      	 
				      driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
				      	 Thread.sleep(200);
				      	 for(int i=1;i<monthval;i++) {
				      		kycPage.Buttonclick(kycPage.monthSelector);
				      		 
				      	 }
				      	 Thread.sleep(500);
				      	 driver.findElement(By.xpath("//button[text()='"+date+"']")).click();
				      	 Thread.sleep(1000);
				      kycPage.enterValue(addressOne,kycPage.addressOne);
				      	kycPage.enterValue(addressTwo,kycPage.addressTwo);
				      	kycPage.enterValue(pinCode,kycPage.pinCode);
				      	kycPage.Buttonclick(kycPage.prefix);
				      	Thread.sleep(200);
				      	 driver.findElement(By.cssSelector("[data-value='" + prefix + "']")).click();
				      	 kycPage.Buttonclick(kycPage.panDetailno);
				      	kycPage.Buttonclick(kycPage.Idprrof);
				      	Thread.sleep(200);
				      	 driver.findElement(By.cssSelector("[data-value='" + idProof + "']")).click();
				      	 Thread.sleep(500);
				     	kycPage.Buttonclick(kycPage.IdproofOsvyes);
				      	kycPage.Buttonclick(kycPage.isAddresssameasaadhaarYes);
				      	 Thread.sleep(500);
				      	kycPage.Buttonclick(kycPage.isAddressosvyes);
				      	kycPage.Buttonclick(kycPage.currentSameYes);
				 
				    	kycPage.Buttonclick(kycPage.customerImage);
				     	Thread.sleep(3000);
				    	kycPage.waitForElementToBeClickable(kycPage.customerTakeimagebtn);
				    	kycPage.Buttonclick(kycPage.customerTakeimagebtn);
				    	kycPage.waitForAlertAndAccept();
				
				      	kycPage.waitForElementToBeClickable(kycPage.customerImageconfirm);
				      	kycPage.Buttonclick(kycPage.customerImageconfirm);
				      	kycPage.Buttonclick(kycPage.next);
				      	Thread.sleep(1000);
				      	
				      	Assert.assertEquals(kycPage.isElementdisplayed(kycPage.noOfyear), true);
						
						test.log(Status.PASS, "Successfully completed the customer KYC journey ");
					
					
					

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