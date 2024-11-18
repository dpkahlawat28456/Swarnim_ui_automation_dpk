package pages.login;

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

public class LoginPage extends CommonKeyWords {

	public WebDriver driver;
	public WebDriverWait wait;
	ArrayList<String> credData = new ArrayList<String>();
	PropertyFile propReader = new PropertyFile();
	private static final String PAGE_URL = "url";

	public LoginPage(WebDriver driver, long timeoutInSeconds) {
		super(driver, timeoutInSeconds);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Relative xpath need to be taken

	@FindBy(xpath = "//*[@id=\"undefined-basic\"]")
	public WebElement EmailID;

	@FindBy(xpath = "//*[@id=\"filled-adornment-password\"]\n" + "")
	public WebElement Pass;

	@FindBy(xpath = "//*[contains(text(),'Login')]")
	public WebElement Login;

	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div/form/div[1]/div[1]/div/p\n" + "")
	public WebElement EmailValidation;

	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/form/div[3]/div/button\n" + "")
	public WebElement branchElement;

	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div/form/div[1]/div[2]/div/p")
	public WebElement passwordElementValidation;

	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/div/form/div[2]/div[2]/div/div[2]\n" + "")
	public WebElement invaidCredElementValidation;

	public void openURL() throws Exception {
		driver.navigate().to(propReader.getProp().get(PAGE_URL).toString().trim());
	}

	public void clickloginButton() {
		click(Login);
	}

	public String validatePopUPInvalidCredential() {
		Alert alert = driver.switchTo().alert();
		// Get the text of the alert
		String alertText = alert.getText();
		return alertText;
	}

	public String loginCredential(String Email) {
		enterText(EmailID, Email);
		return Email;
	}

	public String passWord(String Password) {
		enterText(Pass, Password);
		return Password;
	}
	public String gettext(WebElement element) {
		return getText(element);
	}
	public boolean isElementdisplayed(WebElement element) {
		return isDisplayed(element);
	}

}