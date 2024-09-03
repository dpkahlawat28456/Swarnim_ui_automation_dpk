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

public class OccuptionPages extends CommonKeyWords {

	public WebDriver driver;
	public WebDriverWait wait;
	ArrayList<String> credData = new ArrayList<String>();
	PropertyFile propReader = new PropertyFile();
	private static final String PAGE_URL = "url";

	public OccuptionPages(WebDriver driver, long timeoutInSeconds) {
		super(driver, timeoutInSeconds);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div/div/div/div/fieldset[2]/label")
	public WebElement no;

	
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