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

public class NomineePage extends CommonKeyWords {

	public WebDriver driver;
	public WebDriverWait wait;
	ArrayList<String> credData = new ArrayList<String>();
	PropertyFile propReader = new PropertyFile();
	//private static final String PAGE_URL = "dedupeurl";


	public NomineePage(WebDriver driver, long timeoutInSeconds) {
		super(driver, timeoutInSeconds);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[1]/div/div")
	public WebElement nomineeRelation;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[2]/div/div/div/input ")
	public WebElement nomineeName;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[3]/div/div/div/div/button")  
	public WebElement calender;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[1]/div[1]/button")
	public WebElement yearDropdown;
	@FindBy(xpath ="/html/body/div[2]/div[2]/div/div/div/div[1]/div[2]/button[2]")
	public WebElement month;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[4]/div/div/div/input")
	public WebElement mobile;
	@FindBy(xpath ="//button[@type='submit']")
	public WebElement next;
	
	
	
	

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

