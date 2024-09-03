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
	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div[1]/div[1]/div/button") 
	public WebElement frontImagebutton;
	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div[1]/div[2]/div/button") 
	public WebElement backImagebutton;
	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div[1]/div[1]/div/div/button[1]")
	public WebElement frontimageconfirm;
	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div[1]/div[2]/div/div/button[1]")
	public WebElement backImageconfirm;
	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div[2]/button")
	public WebElement saveImageconfirm;
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div/form/div[2]/div[5]/div/div/div/fieldset[1]/label")  
    public WebElement aadharOSVyes;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[7]/div/div/div/input")
	public WebElement firstName;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[9]/div/div/div/input")
	public WebElement lastName;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div/form/div[2]/div[11]/div/div/div/div/button")
	public WebElement calender;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[1]/div[1]/button") // /html/body/div[3]/div[2]/div/div/div/div[1]/div[1]/button
	public WebElement yearDropdown;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[1]/div[2]/button[2]")  
    public WebElement monthSelector;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[12]/div/div/div/textarea[1]")
	public WebElement addressOne;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[13]/div/div/div/textarea[1]")
	public WebElement addressTwo;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[14]/div/div/div/input")
	public WebElement pinCode;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[6]/div/div/div")
	public WebElement prefix;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[19]/div/div")
	public WebElement Idprrof;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[23]/div/div/div/fieldset[1]/label")
	public WebElement IdproofOsvyes;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[24]/div/div/div/fieldset[1]/label")  
    public WebElement isAddresssameasaadhaarYes;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[29]/div/div/div/fieldset[1]/label")
	public WebElement isAddressosvyes;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[30]/div/div/div/fieldset[1]/label")
	public WebElement currentSameYes;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[18]/div/div/div/fieldset[2]/label")
	public WebElement panDetailno;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[31]/div/button")
	public WebElement customerImage;
	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div/div/div/button")
	public WebElement customerTakeimagebtn;
	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div/div[2]/div/button")       
	public WebElement customerImageconfirm;
	@FindBy(xpath ="//button[@type='submit']")
	public WebElement next;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[1]/div/div/div/input")
	public WebElement noOfyear;
	

	public void enterValue(String Firstname,WebElement element) {
		enterText(element, Firstname);
		}
	public String alert="Details Already Present in goldloan for this customer with customer id 1163122";
	
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
