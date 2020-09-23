package pages.regression.guestPayments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;


/**
 * @author akapoo18
 *
 */
public class guestPaymentsLoginWebElements extends UhcDriver{
	
	/**
	 * Lists all the elements of Guest Payments Portal
	 */

	
	public guestPaymentsLoginWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();

	}

	public void openAndValidate() { 
		
	}

	@FindBy(className= "uhc-tempo-header__h1")
     public static WebElement guestPaymentsHeader;
	
	@FindBy(className= "medicare-only")
    public static WebElement staticContentBelowHeader;
	
	@FindBy(xpath= "//a[contains(text(),'sign in')]")
    public static WebElement signInLink;
	
	@FindBy(xpath= "//a[contains(text(),'Help me find my ID')]")
    public static WebElement helpMeFindMyIdLink;
		
	@FindBy(xpath= "//input[@placeholder='Member ID']")
    public static WebElement  memberIdTextfield;
	
	@FindBy(xpath= "//input[@id='dob']")
    public static WebElement dobTextfield;
	
	@FindBy(xpath= "//button[contains(text(),'Next')]")
    public static WebElement nextButton ;

	@FindBy(className= "row have-troble")
    public static WebElement havingTroubleText;

	@FindBy(className= "row member-footer")
    public static WebElement footerText;

	@FindBy(className= "memberID")
	public static WebElement MemberID;
	
	@FindBy(className= "memberID") // need to update class id
	public static WebElement memberIdCardImage;
	
	@FindBy(className= "memberID") // need to update class id
	public static WebElement textOnFindMyIdPopup;

	@FindBy(className= "memberID") // need to update class id
	public static WebElement CancelButtononID;
	
	@FindBy(className= "invalid-feedback") 
	public static WebElement errorMessage;
	
	@FindBy(xpath= "//div[contains(text(),'unable to recognize your plan information')]") 
	public static WebElement errorMessageFromGPS;
	
	@FindBy(className= "uhc-tempo-header__h1")
	public static WebElement errorMessageOnErrorPage;
	
	@FindBy(xpath= "//a[contains(text(),'Sign In')]") 
	public static WebElement signInLinkOnErrorPage;
	
	@FindBy(xpath= "//h1[contains(text(),'Make a One-time Payment')]")
	public static WebElement makeAPaymentsHeader;
	
	@FindBy(className= "magnfy-icon")
	public static WebElement magnifyIcon;
	
	
	
	

	
	
	

	

}

