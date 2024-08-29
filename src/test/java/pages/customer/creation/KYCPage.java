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

public class KYCPage extends CommonKeyWords {

	public WebDriver driver;
	public WebDriverWait wait;
	ArrayList<String> credData = new ArrayList<String>();
	PropertyFile propReader = new PropertyFile();
	//private static final String PAGE_URL = "dedupeurl";


	public KYCPage(WebDriver driver, long timeoutInSeconds) {
		super(driver, timeoutInSeconds);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[3]/div/div/div/div/input")
	public WebElement aadharfeild;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[3]/div/div/button ")
	public WebElement sendotp;
	@FindBy(xpath = "/html/body/div[2]/div[3]/div/h2/button")  
	public WebElement crossbutton;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[2]/div/div/div/fieldset[2]/label")
	public WebElement biomatricsradioButton;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[2]/div/div/div/fieldset[3]/label")
	public WebElement offlineradioButton;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[3]/div/div/button ")
	public WebElement verifyAaadhar;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[4]/div/button")
	public WebElement aadharImagebox;
	@FindBy(xpath = "/html/body/div[3]/div[3]/div/div/div[1]/div[1]/div/button")  
	public WebElement frontImagebutton;
	@FindBy(xpath = "/html/body/div[3]/div[3]/div/div/div[1]/div[3]/div/button")
	public WebElement backImagebutton;
	@FindBy(xpath = "/html/body/div[3]/div[3]/div/div/div[1]/div[1]/div/div/button[1]")
	public WebElement firstImageconfirm;
	@FindBy(xpath = "/html/body/div[3]/div[3]/div/div/div[1]/div[2]/div/div/button[1]")
	public WebElement lastImageconfirm;
	@FindBy(xpath = "/html/body/div[3]/div[3]/div/div/div[2]/button")
	public WebElement saveImageconfirm;
	@FindBy(xpath = "/html/body/div[3]/div[3]/div/div/div/p")
	public WebElement aadharAlert;

	public void enterValue(String Firstname,WebElement element) {
		enterText(element, Firstname);
		}
	String alert="Details Already Present in goldloan for this customer with customer id 1163122";
	
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
