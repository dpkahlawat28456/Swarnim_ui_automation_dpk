package pages.customer.creation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.CommonKeyWords;
import property.PropertyFile;

public class SendotpPage extends CommonKeyWords {

	public WebDriver driver;
	public WebDriverWait wait;
	ArrayList<String> credData = new ArrayList<String>();
	PropertyFile propReader = new PropertyFile();
	private static final String PAGE_URL = "url";

	public SendotpPage(WebDriver driver, long timeoutInSeconds) {
		super(driver, timeoutInSeconds);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div/div/div/button[1]")
	public WebElement sendOtp;

	
	@FindBy(xpath ="/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[2]/div/div/div/div/input")
	public WebElement otpInput;
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[2]/div/div/button")
	public WebElement verifyBtn;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[3]/div/button")
	public WebElement createBtn;
	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div/form/div[1]/div[1]/div/div/div/input")
	public WebElement customerCreate;

	public void enterValue(String Firstname,WebElement element) {
		enterText(element, Firstname);
		}
	
	
	public void Buttonclick(WebElement element) {
		
		click(element);
		}
	
   public String gettext(WebElement element) {
		return getText(element);
	}
   public boolean isElementdisplayed(WebElement element) {
		return isDisplayed(element);
	}
	


	

}
