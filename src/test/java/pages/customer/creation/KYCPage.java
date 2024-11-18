package pages.customer.creation;

import java.util.ArrayList;
import java.util.List;


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

	
	
	@FindBy(xpath = "//input[@name='aadharCardOnline']")
	public WebElement aadharfeild;
	@FindBy(xpath = "//button[text()='SEND OTP']")
	public WebElement sendotp;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[4]/div/div/div/div/input")
	public WebElement enterOtp;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[4]/div/div/button")
	public WebElement verifyBtn;
	@FindBy(xpath = "//input[@name='father_or_spouse_name']")
	public WebElement fatherSpouseName;
	@FindBy(xpath = "//input[@name='pincode']") 
	public WebElement pincode;
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div/form/div[2]/div[17]/div/div/div/fieldset[2]/label") 
	public WebElement panNo;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[18]/div/div/div")
	public WebElement ID;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[5]/div/div/div")
	public WebElement prefix;
	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div[1]/div[1]/div/button")
	public WebElement frontImage;
	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div[1]/div[2]/div/button")  
    public WebElement backImage;
	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div[1]/div[1]/div/div/button[1]")
	public WebElement firstConfirm;
	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div[1]/div[2]/div/div/button[1]")
	public WebElement lastConfirm;
	@FindBy(xpath = "//input[@name='id_proof_number']")
	public WebElement idProofNumber;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[19]/div/button") // /html/body/div[3]/div[2]/div/div/div/div[1]/div[1]/button
	public WebElement idProofImage;
	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div/div[2]/button")  
    public WebElement imageSave;
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div/form/div[2]/div[22]/div/div/div/fieldset[1]/label")  
    public WebElement idOSV;
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div/form/div[2]/div[23]/div/div/div/fieldset[1]/label")  
    public WebElement isAdressproofSameYes;
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div/form/div[2]/div[28]/div/div/div/fieldset[1]/label")  
    public WebElement addressOsv;
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div/form/div[2]/div[29]/div/div/div/fieldset[1]/label")  
    public WebElement currentSameasPerm_Yes;
	@FindBy(xpath = "//button[text()='Customer Live Photo Upload* ']")  
    public WebElement customerUploadImage;
	@FindBy(xpath = "//button[text()='Take Snapshot']")  
    public WebElement takeImage;
	@FindBy(xpath = "//button[text()='Confirm']")
   public WebElement button_ConfirmCapturedCustomerLivePhoto;
	
	@FindBy(xpath = "/html/body/div[2]/div[3]/div/div")  
    public WebElement customerImageBox;
	@FindBy(xpath ="//button[@type='submit']")
	public WebElement next;
	@FindBy(xpath ="//button[text()='Back']")
	public WebElement back;
	
	

	public void enterValue(String Firstname,WebElement element) {
		enterText(element, Firstname);
		}
	//public String alert="Details Already Present in goldloan for this customer with customer id 1163122";
	
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
