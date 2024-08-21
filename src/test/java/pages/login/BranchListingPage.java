package pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import common.CommonKeyWords;

public class BranchListingPage extends CommonKeyWords {

	public WebDriver driver;
	public WebDriverWait wait;

	public BranchListingPage(WebDriver driver, long timeoutInSeconds) {
		super(driver, timeoutInSeconds);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"auto-complete\"]")
	public WebElement branchElement;

	@FindBy(xpath = "//*[@id=\"auto-complete-option-0\"]")
	public WebElement clickBranchCode;

	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div/form/div[3]/div/button\n" + "")
	public WebElement submit;

	@FindBy(xpath = "//*[contains(text(),'Customer 360')]\n" + "")
	public WebElement customer360Tab;

	@FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]")
	public WebElement createCustomerWebElement;	

	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[1]")
	public WebElement createCustomerDashboardIconWebElement;
	
	@FindBy(xpath = "/html/body/div/div/div[2]/div[2]/div[2]/button")
	public WebElement createCustomerButtonWebElement;
	
	
	

			
	public void selectBranchCode() throws InterruptedException {
		
		branchElement.sendKeys("GLB0003");
		Thread.sleep(1200);
		click(clickBranchCode);
		click(submit);
	}
	
	public void selectcustomer360tab() {
		click(customer360Tab);

	}
	
	public void clickcreateCustomerDashboardIconWebElement() {
		click(createCustomerDashboardIconWebElement);

	}
	
	public void clickCreateCustomerButtonWebElement() {
		click(createCustomerButtonWebElement);

	}	
	

}
