/**
 * 
 */
package pages.member.redesign;


import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.data.MRConstants;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class NewRegistrationPage extends UhcDriver {

	// Page URL

	
	@FindBy(id = "member-id")
	private WebElement memberIdField;

	@FindBy(id = "password")
	private WebElement passwordField;
	
	
	@FindBy(id="continue-btn")
	private WebElement btnNext;
	
	@FindBy(id="username")
	private WebElement txtUsername;
	
	@FindBy(id="password")
	private WebElement txtPassword;
	
	@FindBy(id="password-confirm")
	private WebElement txtConfirmPassword;
	
	@FindBy(id="email")
	private WebElement emailAddress;
	
	@FindBy(id="email-confirm")
	private WebElement confrmEmailAddress;
	

	public NewRegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	
	public Object registerWith(Map<String, String> registrationData) {
		
		// get parameter username and password
		String memberId = registrationData.get("MemberId");
		String dob = registrationData.get("DOB");
		String username = registrationData.get("Username");
		String password = registrationData.get("Password");
		String confirmPassword = registrationData.get("ConfirmPassword");
		String email = registrationData.get("Email");
		String confirmEmail = registrationData.get("ConfirmEmail");
					
		WebDriverWait wait = new WebDriverWait(driver,30);	
		try{
			
			String str[] = dob.split("/");
			String strDate = str[0];
			String strMonth = str[1];
			String strYear = str[2];
			
			wait.until(ExpectedConditions.visibilityOf(memberIdField));
			sendkeys(memberIdField, memberId);
			driver.findElement(By.xpath("//span[@id='select2-date-mm-container']/following::span[1]")).click();
			if(!strMonth.equals("01"))
				driver.findElement(By.xpath("//ul[@id='select2-date-mm-results']//li[(@class='select2-results__option') and text()='"+strMonth+"']")).click();
			else
				driver.findElement(By.xpath("//ul[@id='select2-date-mm-results']//li[(@class='select2-results__option select2-results__option--highlighted')]")).click();
			
			driver.findElement(By.xpath("//span[@id='select2-date-dd-container']/following::span[1]")).click();
			if(!strDate.equals("01"))
				driver.findElement(By.xpath("//ul[@id='select2-date-dd-results']//li[(@class='select2-results__option') and text()='"+strDate+"']")).click();
			else
				driver.findElement(By.xpath("//ul[@id='select2-date-dd-results']//li[@class='select2-results__option select2-results__option--highlighted']")).click();
			
			driver.findElement(By.xpath("//span[@id='select2-date-yyyy-container']/following::span[1]")).click();
			driver.findElement(By.xpath("//ul[@id='select2-date-yyyy-results']//li[(@class='select2-results__option') and text()='"+strYear+"']")).click();
			btnNext.click();
			Thread.sleep(15000);
			driver.findElement(By.id("continue-btn")).click();
			waitforElement(passwordField);
			sendkeys(txtUsername, username);
			sendkeys(txtPassword, password);
			sendkeys(txtConfirmPassword, confirmPassword);
			sendkeys(emailAddress, email);
			sendkeys(confrmEmailAddress, confirmEmail);
			driver.findElement(By.id("continue-btn")).click();
			Thread.sleep(30000);
			if(currentUrl().contains("memberRegistration-Confirm"))
			{
				return new RegistrationConfirmationPage(driver);
			}
			/*GoGreenSplashPage goGreenSplashPage = 
			if(currentUrl().contains("GoGreenSplashPage.html"))
			{
				return new GoGreenSplashPage(driver);
			}*/
						
		}catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}
	
	@Override
	public void openAndValidate() {
		if (MRScenario.environment.equals("stage")){
			start(MRConstants.NEW_REDESIGN_STAGE_REGISTRATION_URL);
		}else{
			start(MRConstants.NEW_REDESIGN_REGISTRATION_URL);
		}
		validate(memberIdField);
	}
}
