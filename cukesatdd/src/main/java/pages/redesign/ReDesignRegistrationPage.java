/**
 * 
 */
package pages.redesign;


import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnsupportedCommandException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author sdwaraka
 *
 */
public class ReDesignRegistrationPage extends UhcDriver {


	// Page URL
	private static String PAGE_URL = MRConstants.AARPM_URL;
	private static String REDESIGN_REGISTRATION_PAGE_URL = MRConstants.NEW_REDESIGN_REGISTRATION_URL;
	private static String SetServerDate_URL = "http://mrrest-teama.ose.optum.com/MRRestWAR/rest/zadmin/time/joda?millis=";
	private static String REDESIGN_REGISTRATION_URL = "https://"+MRScenario.environment+"-medicare.uhc.com/medicare/member-registration.html#/get-started";
	
	
	@FindBy(id = "member-id")
	private WebElement memberIdField;

	@FindBy(id = "password")
	private WebElement passwordField;
	
	@FindBy(id="date-mm")
	private WebElement month;
	
	@FindBy(id="date-dd")
	private WebElement date;
	
	@FindBy(id="date-yyyy")
	private WebElement year;
	
	@FindBy(id="continue-btn")
	private WebElement ContinueBtn;
	
	//Personal Identification - Additional Information
	@FindBy(id="medicareID")
	private WebElement MedicareIDField;

	
	
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
	
	@FindBy(id="continue-btn")
	private WebElement btn_ConfirmRegistration;
	

	@FindBy(linkText = "Forgot your username or password?")
	private WebElement forgotUsernamePasswordLink;

	@FindBy(id = "usercheckbox")
	private WebElement userNameCheckBox;

	
	public ReDesignRegistrationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public ReDesignRegistrationPage SetServerDate(String ServerDate_MilliSeconds){
		
		start(SetServerDate_URL+ServerDate_MilliSeconds);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return new ReDesignRegistrationPage(driver);
	}
	
	public ReDesignRegistrationPage NavigateToRegistrationPage(){
		
		start(REDESIGN_REGISTRATION_URL);
		if(validate(memberIdField)){
			return new ReDesignRegistrationPage(driver);
		}
		return null;
	}
	
	public ReDesignRegistrationPage Enter_MemberNo_DOB(String MemberNo, String DOB){
		
		
		String[] DateOfBirth= DOB.split("/");
		System.out.println("The memberNo is : "+MemberNo);
		System.out.println("The DOB is : "+DOB);

		if(validate(memberIdField)){
			memberIdField.sendKeys(MemberNo);
			}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Select Month = new Select(month);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Select Day = new Select(date);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Select Year = new Select(year);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Month.selectByVisibleText(DateOfBirth[0]);
		Day.selectByVisibleText(DateOfBirth[1]);
		Year.selectByVisibleText(DateOfBirth[2]);
		ContinueBtn.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		if(validate(MedicareIDField)){
			return new ReDesignRegistrationPage(driver);
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
