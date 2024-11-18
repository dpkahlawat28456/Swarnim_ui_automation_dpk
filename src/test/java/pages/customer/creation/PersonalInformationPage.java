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

public class PersonalInformationPage extends CommonKeyWords {

	public WebDriver driver;
	public WebDriverWait wait;
	ArrayList<String> credData = new ArrayList<String>();
	PropertyFile propReader = new PropertyFile();
	//private static final String PAGE_URL = "dedupeurl";


	public PersonalInformationPage(WebDriver driver, long timeoutInSeconds) {
		super(driver, timeoutInSeconds);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	
	
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[1]/div/div/div/input")
	public WebElement noOfyear;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[2]/div ")
	public WebElement education;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[3]/div/div/div/input")  
	public WebElement phoneNumber;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[6]/div/div")
	public WebElement maritalStatus;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[7]/div/div")
	public WebElement gender;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[8]/div/div ")
	public WebElement relegion;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[9]/div/div/div/input")
	public WebElement motherName;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[10]/div/div") 
	public WebElement socialStatus;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[11]/div/div/div/input") 
	public WebElement fatherName;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[12]/div/div/div/input")
	public WebElement placeOfBirth;
	@FindBy(xpath ="//button[@type='submit']")
	public WebElement next;
	@FindBy(xpath ="//button[text()='Back']")
	public WebElement back;
	
	
	

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
