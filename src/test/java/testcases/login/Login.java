package testcases.login;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import driver.BrowserFactory;
import listeners.ScreenshotListener;
import pages.login.LoginPage;
import property.PropertyFile;
import utility.BaseFile;

public class Login extends BaseFile {

	private static final String Email = "emailid";
	private static final String Pass = "Passward";
	private ExtentReports extent;
	private WebDriver driver;
	private LoginPage loginPage;
	private ExtentTest test;
	
	public WebDriverWait wait;

	PropertyFile propReader = new PropertyFile();
	BrowserFactory browserFactory = new BrowserFactory();

	// This method is calling driver and extent report.
	@BeforeMethod
	private void navigateToBaseURL() throws Exception {
		driver = BaseFile.driver;
		loginPage = new LoginPage(driver, 5);
		extent = extentBase;
		ScreenshotListener.setDriver(driver);

	}

	

	@Test
	private void swarnimLoginPage() throws Exception {

		
				

				
		String email = propReader.getProp().get(Email).toString().trim();
		String Passward = propReader.getProp().get(Pass).toString().trim();


				
		                  
		
		
		                loginPage.openURL();
				        loginPage.loginCredential(email);
						loginPage.passWord(Passward);
						loginPage.clickloginButton();
						Assert.assertEquals(loginPage.isElementdisplayed(loginPage.branchElement), true);
						test.log(Status.PASS, "User is able to login successfully: ");
					

					// Validate the login with empty email ID
					

				
				}
			}
		

	
