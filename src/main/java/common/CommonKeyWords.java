package common;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonKeyWords  {

	public WebDriver driver;
	public WebDriverWait wait;

	public CommonKeyWords(WebDriver driver, long timeoutInSeconds) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(150));
	}

	public void click(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		if (element.isDisplayed()) {
		    element.click();
		}
	}
	
	public void waitForElementToBeClickable(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));		
		
	}

	public int randomNumber() {
		 Random random = new Random();
	        int randomNumber = 10000000 + random.nextInt(90000000);
		
		return randomNumber;
	}
	
	public void JavaScriptclick(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public void EnableButton(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('disabled','disabled')", element);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public void getLocation(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element)).getLocation();
	}

	public void enterText(WebElement element, String text) {
		wait.until(ExpectedConditions.visibilityOf(element)).clear();
		element.sendKeys(text);
	}
	public void waitForAlertAndAccept() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
	}

	public void enter(WebElement element, Keys enter) {
		wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(enter);
	}

	public String getText(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).getText();
	}

	public void getList(List<WebElement> elements) {
		wait.until(ExpectedConditions.visibilityOfAllElements(elements)).toArray();
	}

	public boolean isDisplayed(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
	}

	public void navigateTo(String url) {
		driver.navigate().to(url);
	}

	public void selectDropdown(WebElement element, Object value) {
		Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(element)));
		dropdown.selectByIndex((int) value);
	}

	public void selectDropdownValue(WebElement element, Object value) {
		Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(element)));
		dropdown.selectByValue((String) value);
	}

	public void selectDropdownText(WebElement element, String Text) {
		Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(element)));
		dropdown.selectByVisibleText((String) Text);
	}

	public void getFirstSelectedOption(WebElement element) {
		Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(element)));
		dropdown.getFirstSelectedOption();
	}

	public void submit(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).submit();
	}

	public void Size(List<WebElement> elements) {
		wait.until(ExpectedConditions.visibilityOfAllElements(elements)).size();
	}

	public void getURL(WebElement element, String Text) {
		driver.get(Text);
	}

}
