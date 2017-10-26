/**
 * 
 */
package pages.member.redesign;


import java.text.SimpleDateFormat;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class NewRegistrationPage extends UhcDriver {

	// Page URL
	private static String PAGE_URL = MRConstants.AARPM_URL;
	private static String REDESIGN_REGISTRATION_PAGE_URL = MRConstants.NEW_REDESIGN_REGISTRATION_URL;

	@FindBy(id = "sign-in-btn")
	private WebElement btnSignIn;
	
	@FindBy(id = "member-id")
	private WebElement memberIdField;

	@FindBy(id = "password")
	private WebElement passwordField;
	
	@FindBy(xpath="//span[@id='select2-date-mm-container']/span")
	private WebElement month;
	
	@FindBy(xpath="//span[@id='select2-date-dd-container']/span")
	private WebElement date;
	
	@FindBy(xpath="//span[@id='select2-date-yyyy-container']/span")
	private WebElement year;
	
	@FindBy(id="continue-btn")
	private WebElement btnNext;
	

	@FindBy(linkText = "Forgot your username or password?")
	private WebElement forgotUsernamePasswordLink;

	@FindBy(id = "usercheckbox")
	private WebElement userNameCheckBox;

	public NewRegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	
	public Object registerWith(String memberId, String dob) {
			
		try{
			
			String str[] = dob.split("/");
			String strDate = str[0];
			String strMonth = str[1];
			String strYear = str[2];
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			sendkeys(memberIdField, memberId);
			driver.findElement(By.xpath("//span[@id='select2-date-mm-container']/following::span[1]")).click();
			if(strMonth!="01")
				driver.findElement(By.xpath("//ul[@id='select2-date-mm-results']//li[(@class='select2-results__option') and text()='"+strMonth+"']")).click();
			else
				driver.findElement(By.xpath("//ul[@id='select2-date-mm-results']//li[(@class='select2-results__option select2-results__option--highlighted')]")).click();
			
			driver.findElement(By.xpath("//span[@id='select2-date-dd-container']/following::span[1]")).click();
			driver.findElement(By.xpath("//ul[@id='select2-date-dd-results']//li[(@class='select2-results__option') and text()='"+strDate+"']")).click();
			driver.findElement(By.xpath("//span[@id='select2-date-yyyy-container']/following::span[1]")).click();
			driver.findElement(By.xpath("//ul[@id='select2-date-yyyy-results']//li[(@class='select2-results__option') and text()='"+strYear+"']")).click();
			btnNext.click();
			Thread.sleep(10000);
			driver.findElement(By.id("continue-btn")).click();
			waitforElement(passwordField);
			Thread.sleep(10000);
			GoGreenSplashPage goGreenSplashPage = new GoGreenSplashPage(driver);
			if(currentUrl().contains("GoGreenSplashPage.html"))
			{
				return new GoGreenSplashPage(driver);
			}
						
		}catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	
	@Override
	public void openAndValidate() {
		start(MRConstants.NEW_REDESIGN_REGISTRATION_URL);
		validate(memberIdField);
	}
}
