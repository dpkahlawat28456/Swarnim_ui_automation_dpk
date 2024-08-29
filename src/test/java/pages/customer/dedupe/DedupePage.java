package pages.customer.dedupe;

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

public class DedupePage extends CommonKeyWords {

	public WebDriver driver;
	public WebDriverWait wait;
	ArrayList<String> credData = new ArrayList<String>();
	PropertyFile propReader = new PropertyFile();
	private static final String PAGE_URL = "dedupeurl";


	public DedupePage(WebDriver driver, long timeoutInSeconds) {
		super(driver, timeoutInSeconds);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div/div/div/input")
	public WebElement firstname;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/div/div/div/input")
	public WebElement lastname;
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[2]/form/div[1]/div[3]/div/div/div/input")
	public WebElement fathername;
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[2]/form/div[1]/div[4]/div/div/div/div/button")
	public WebElement dob;
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[2]/form/div[1]/div[5]/div/div/div/input")
	public WebElement pannumber;
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[2]/form/div[1]/div[6]/div/div/div/input")
	public WebElement mobilenumber;
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[2]/form/div[2]/div/button[2]")
	public WebElement clickCustomerdedupebutton;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[1]/div[1]/button")
	public WebElement yeardroupDown;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/div[1]/div[2]/button[2]")
	public WebElement month;
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[2]/form/div[1]/div[1]/div/p")
	public WebElement firstnamevalidator;
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[2]/form/div[1]/div[2]/div/p")
	public WebElement lastnamevalidator;
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/form/div[1]/div[3]/div/p")
	public WebElement fathernamevalidator;
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[2]/form/div[1]/div[4]/div/p")
	public WebElement dobvalidator;
	@FindBy(xpath = "html/body/div/div/div[2]/div[2]/div[2]/form/div[1]/div[6]/div/p ")
	public WebElement mobilenumbervalidator;
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[2]/form/div[2]/div/button[1]")
	public WebElement resetbutton;
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[2]/form/div[1]/div[5]/div/p")
	public WebElement panvalidator;
	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[1]/button")
	public WebElement createcustomerbtn;
//	public void openURL() throws Exception {
//		driver.navigate().to(propReader.getProp().get(PAGE_URL).toString().trim());
//	}

	public void firstnamefeild(String Firstname) {
		enterText(firstname, Firstname);
		
	}
	public void lastnamefeild(String Lastname) {
		enterText(lastname, Lastname);
		
	}

	public String fathernamefeild(String Fathername) {
		enterText(fathername, Fathername);
		return Fathername;
	}
	public void dobButtonclick() throws InterruptedException {
		Thread.sleep(300);
		click(dob);
	}
	public void yeardroupDownclick() {
		click(yeardroupDown);
	}
	public void clickresetbutton() {
		click(resetbutton);
	}
	public String panfeild(String pan) {
		enterText(pannumber, pan);
		return pan;
	}	
	public String mobileNumberfeild(String mobile) {
		enterText(mobilenumber, mobile);
		return mobile;
	}
	public void customerDedupeButtonclick() {
		click(clickCustomerdedupebutton);
	}
   public void monthclick() {
	   click(month);
   }
   public String gettext(WebElement element) {
		return getText(element);
	}
   public boolean isElementdisplayed(WebElement element) {
		return isDisplayed(element);
	}
}
