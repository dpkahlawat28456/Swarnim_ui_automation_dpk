package testcases.customer.creation;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

	@Test(dataProvider = "KycPageDataProvider")
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
			    String idProofnum=null;
			    int monthval=0;

				try {
					String str = Integer.toString(kycPage.randomNumber());
					StringBuilder sb = new StringBuilder();
					sb.append("9999");
					sb.append(str);
					JSONObject testData = (JSONObject) entry.getValue();
					testScenarioRequest = new String((String) testData.get("testSenario"));
					testId = new String((String) testData.get("testID")).toString();
					aadharno= sb.toString();
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
					idProofnum= new String((String) testData.get("IdproofNo")).toString();

					

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}



				test = extent.createTest(testScenarioRequest);

				try {
					if(testId.equals("TC_01")) {
					//test = extent.createTest("Validate the positive online verification flow");
					 monthval=Integer.valueOf(month);
					driver.get("https://cggl-dev.capriglobal.in/customer-creation");
						kycPage.enterValue(aadharno,kycPage.aadharfeild);
						Thread.sleep(1000);
						kycPage.Buttonclick(kycPage.sendotp);
						Thread.sleep(1500);
						
					    kycPage.enterValue("111111",kycPage.enterOtp);
					    kycPage.Buttonclick(kycPage.verifyBtn);
					    Thread.sleep(1500);
					    kycPage.enterValue("RAMS",kycPage.fatherSpouseName);
					    kycPage.enterValue(pinCode,kycPage.pincode);
					    kycPage.Buttonclick(kycPage.prefix);
					    driver.findElement(By.cssSelector("[data-value='" + prefix + "']")).click();
					    Thread.sleep(500);
					    kycPage.Buttonclick(kycPage.panNo);
					    kycPage.Buttonclick(kycPage.ID);
					    driver.findElement(By.cssSelector("[data-value='" + idProof + "']")).click();
					    Thread.sleep(500);
					    kycPage.enterValue(idProofnum,kycPage.idProofNumber);
					    
					    kycPage.Buttonclick(kycPage.idProofImage);
					    Thread.sleep(1500);
					    kycPage.Buttonclick(kycPage.frontImage);
					    kycPage.Buttonclick(kycPage.backImage);
					    Thread.sleep(1500);
					    kycPage.Buttonclick(kycPage.firstConfirm);
					    kycPage.Buttonclick(kycPage.lastConfirm);
					    Thread.sleep(1500);
					    kycPage.Buttonclick(kycPage.imageSave);
					    kycPage.Buttonclick(kycPage.idOSV);
					    kycPage.Buttonclick(kycPage.isAdressproofSameYes);
					    kycPage.Buttonclick(kycPage.addressOsv);
					    kycPage.Buttonclick(kycPage.currentSameasPerm_Yes);
					    kycPage.Buttonclick(kycPage.customerUploadImage);
					   
					    	//System.out.println("rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
					    	Thread.sleep(2000);
					    	kycPage.Buttonclick(kycPage.takeImage);
					    	kycPage.waitForAlertAndAccept();
					    	kycPage.Buttonclick(kycPage.button_ConfirmCapturedCustomerLivePhoto);
					    	Thread.sleep(1000);
					    	kycPage.Buttonclick(kycPage.next);
					    	Thread .sleep(500);
					    	Assert.assertEquals(kycPage.isElementdisplayed(kycPage.back), true);
							test.log(Status.PASS, "User abel to proceed with prefix Mr ");
					    	
					    	}
					if(testId.equals("TC_02")) {
						Thread.sleep(1000);
						kycPage.Buttonclick(kycPage.back);
						//test = extent.createTest("Validate the positive online verification flow with prefix Mrs");
						kycPage.Buttonclick(kycPage.prefix);
						
						driver.findElement(By.cssSelector("[data-value='" + prefix + "']")).click();
						kycPage.Buttonclick(kycPage.next);
						Thread .sleep(500);
				    	Assert.assertEquals(kycPage.isElementdisplayed(kycPage.back), true);
						test.log(Status.PASS, "User abel to proceed with prefix Mrs ");
					}
					if(testId.equals("TC_03")) {
						Thread.sleep(1000);
						kycPage.Buttonclick(kycPage.back);
						//test = extent.createTest("Validate the positive online verification flow with prefix Ms");
						kycPage.Buttonclick(kycPage.prefix);
						driver.findElement(By.cssSelector("[data-value='" + prefix + "']")).click();
						kycPage.Buttonclick(kycPage.next);
						Thread .sleep(500);
				    	Assert.assertEquals(kycPage.isElementdisplayed(kycPage.back), true);
						test.log(Status.PASS, "User abel to proceed with prefix Ms ");
					}
					
					if(testId.equals("TC_04")|| testId.equals("TC_05")|| testId.equals("TC_06")) {
						Thread.sleep(1000);
						kycPage.Buttonclick(kycPage.back);
						//test = extent.createTest("Validate the positive online verification flow with ID proof as Government issued ID Card");
						 kycPage.Buttonclick(kycPage.ID);
						    driver.findElement(By.cssSelector("[data-value='" + idProof + "']")).click();
						    Thread.sleep(500);
						    kycPage.enterValue(idProofnum,kycPage.idProofNumber);
						    
						    kycPage.Buttonclick(kycPage.idProofImage);
						    Thread.sleep(1500);
						    kycPage.Buttonclick(kycPage.frontImage);
						    kycPage.Buttonclick(kycPage.backImage);
						    Thread.sleep(1500);
						    kycPage.Buttonclick(kycPage.firstConfirm);
						    kycPage.Buttonclick(kycPage.lastConfirm);
						    Thread.sleep(1500);
						    kycPage.Buttonclick(kycPage.imageSave);
						    kycPage.Buttonclick(kycPage.idOSV);
						    kycPage.Buttonclick(kycPage.isAdressproofSameYes);
						    kycPage.Buttonclick(kycPage.addressOsv);
						    kycPage.Buttonclick(kycPage.next);
						    Thread .sleep(500);
					    	Assert.assertEquals(kycPage.isElementdisplayed(kycPage.back), true);
							test.log(Status.PASS, "User abel to proceed with ID Proof Government Issued ID Card ");
					
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