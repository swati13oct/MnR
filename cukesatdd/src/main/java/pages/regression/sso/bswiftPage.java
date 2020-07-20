/**
 * 
 */
package pages.regression.sso;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.regression.memberauth.MemberAuthPage;

/**
 * @author pminhas
 *
 */
public class bswiftPage extends UhcDriver {

	@FindBy(xpath="//input[@name='PARTNER']")
	private WebElement PARTNER;
	
	@FindBy(xpath="//input[@name='TARGET']")
	private WebElement targetURL;
	
	@FindBy(xpath="//input[@name='ISTS']")
	private WebElement appLandingURL;
	
	@FindBy(xpath="//input[@name='samlSubject']")
	private WebElement samlSubject;
	
	@FindBy(xpath="//input[@name='DOB']")
	private WebElement dateofBirth;
	
	@FindBy(xpath="//input[@name='EAID']")
	private WebElement EAID;  
	
	@FindBy(xpath="//input[@name='EMPGROUPNUMBER']")
	private WebElement EMPGROUPNUMBER; 
	
	@FindBy(xpath="//input[@name='EMPNUMBER']")
	private WebElement EMPNUMBER; 
	
	@FindBy(xpath="//input[@name='FIRSTNAME']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@name='LASTNAME']")
	private WebElement lastName;
	
	
	@FindBy(xpath="//input[@name='MBI']")
	private WebElement MBI ;
	
	@FindBy(xpath="//input[@name='UHC_ID']")
	private WebElement UHC_ID;  
		
	@FindBy(xpath="//input[@name='submit']")
	private WebElement submitButton;
	
	@FindBy(xpath = "//*[contains(@class,'btn btn-outline-primary')]")
	private WebElement homePageNotice;
	
	
	public bswiftPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	
	//page from MR constants 	
	 private static String STAGE_SSO_TESTHANESS_URL_bswift = MRConstants.STAGE_SSO_TESTHANESS_URL_bswift;
	
	 /*This method will open ping federate SSO Test Harness page */
	 public bswiftPage navigateToLoginURL1(){
		driver.manage().deleteAllCookies();
		start(STAGE_SSO_TESTHANESS_URL_bswift);
		return null;
		}
	
	// This method validated the elements on the test harness page 
		public void validatePageElements(){
			System.out.println("Validating elements on the test harness page");
			
			validateNew(appLandingURL);
			validateNew(dateofBirth);
			validateNew(firstName);
			validateNew(lastName);
			validateNew(MBI);
			validateNew(submitButton);
			appLandingURL.clear();
			samlSubject.clear();
		    dateofBirth.clear();
		    EAID.clear();
			firstName.clear();
			lastName.clear();
			MBI.clear();
			UHC_ID.clear();
			EMPGROUPNUMBER.clear();
			EMPNUMBER.clear();
		}
	
	@Override
	public void openAndValidate() {
			
	}
	/*This method will enter first name on SSO Test Harness page */
	   public void enterFirstName(String fname) {
		    	sendkeys(firstName, fname);
		        }
	   public void entersamlSubject(String samlsubject) {
			    	sendkeys(samlSubject, samlsubject);
	   }
	   /*This method will enter last name on SSO Test Harness page */
	   public void enterLastName(String lname) {
	   	sendkeys(lastName, lname);
	       }	
	   /*This method will enter dob on SSO Test Harness page */
	   public void enterDOB(String dob) {
		   	sendkeys(dateofBirth, dob);
		       }
	   /*This method will enter mbi on SSO Test Harness page */
	   public void enterMBI(String mbi) {
		   	sendkeys(MBI, mbi);
		       }
	   
	   /*This method will enter eaid on SSO Test Harness page */
	   public void enterEAID(String eaid) {
		   	sendkeys(EAID, eaid);
		       }
	   
	   /*This method will enter uhcid on SSO Test Harness page */
	   public void enterUHCID(String uhcid) {
		   	sendkeys(UHC_ID, uhcid);
		       }
	   
	   /*This method will enter appLandingURL on SSO Test Harness page */
	   public void enterapplandingURL(String URL) {
		   			sendkeys(appLandingURL, URL);
	   }
	   
	   /*This method will click submit button on SSO test harness page */
	   public void clickSubmit() throws InterruptedException {
		   submitButton.click();
		    Thread.sleep(5000);
		    new MemberAuthPage(driver).emailAddressRequiredWorkaround();	   
		   	CommonUtility.checkPageIsReadyNew(driver);
			new MemberAuthPage(driver).goGreenSplashPageWorkaround();
			CommonUtility.checkPageIsReadyNew(driver);
			new MemberAuthPage(driver).anocSplashPageWorkaround();
			CommonUtility.checkPageIsReadyNew(driver);
			new MemberAuthPage(driver).paymentSplashPageWorkaround();
			CommonUtility.checkPageIsReadyNew(driver);
		    Thread.sleep(2000);
		     }

	public void checkCovid19Page() {
		// TODO Auto-generated method stub
		 if(validate(homePageNotice)) {
			   System.out.println("User landed on covid-19 banner page, clicking continue/home button"); 
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", homePageNotice);
				homePageNotice.click();
				 System.out.println("Continue/home button was clicked"); 
			}
		 else
		 {
		   System.out.println("Either Covid-19 banner page was not displayed or the Continue/Home button was not displayed, returing AccountHomePage"); 
	}
	}

	
}
