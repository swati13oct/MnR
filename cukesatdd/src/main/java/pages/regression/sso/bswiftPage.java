/**
 * 
 */
package pages.regression.sso;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pminhas
 *
 */
public class bswiftPage extends UhcDriver {

	@FindBy(id="username")
	private WebElement cqusername;
	
	@FindBy(id="password")
	private WebElement cqpassword;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement submitButton;
	
	@FindBy(xpath="//input[@name='DOB']")
	private WebElement DOBField;
	
	@FindBy(xpath="//input[@name='FIRSTNAME']")
	private WebElement FirstName;
	
	@FindBy(xpath="//input[@name='LASTNAME']")
	private WebElement LastName;
	
	@FindBy(xpath="//input[@name='MBI']")
	private WebElement MIB ;
	
	@FindBy(xpath="//input[@name='TARGET']")
	private WebElement targetURL;
	
	@FindBy(xpath="//input[@name='FIRSTNAME']")
	private WebElement firstName1;
	
	@FindBy(xpath="//input[@name='LASTNAME']")
	private WebElement lastName1;
	
	@FindBy(xpath="//input[@name='DOB']")
	private WebElement dateofBirth1;
	
	@FindBy(xpath="//input[@name='MBI']")
	private WebElement mbi22;  
	
	@FindBy(xpath="//input[@name='samlSubject']")
	private WebElement ssopart;
;

	private Object dob;
	
	public bswiftPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	/*private static String STAGE_SSO_TESTHANESS_URL = MRConstants.STAGE_SSO_TESTHANESS_URL;
	
	 This method will open CQ SSO Test Harness page 
	public bswiftPage navigateToLoginURL(){
		start(STAGE_SSO_TESTHANESS_URL);
		driver.manage().deleteAllCookies();
		//driver.get("http://apsr8048:4500/cf#/content/admin-tools/sso-test.html");
		CommonUtility.waitForPageLoad(driver, cqusername, 60);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}
	*/
	//page from MR constants 	
	private static String STAGE_SSO_TESTHANESS_URL_bswift = MRConstants.STAGE_SSO_TESTHANESS_URL_bswift;
	
	 /*This method will open ping federate SSO Test Harness page */
	public bswiftPage navigateToLoginURL1(){
		start(STAGE_SSO_TESTHANESS_URL_bswift);
		driver.manage().deleteAllCookies();
		//driver.get("http://apsr8048:4500/cf#/content/admin-tools/sso-test.html");
		CommonUtility.waitForPageLoad(driver, cqusername, 60);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
		}
	
/*	 This method will enter AEM Username and Password and click on signin button
	public ssoTestHarnessPage enterValuesAndSubmit(String username, String password)
	
	{
		cqusername.click();
		sendkeys(cqusername, username);
		cqpassword.click();
		sendkeys(cqpassword, password);
		try {
		    Thread.sleep(3000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		submitButton.click();
		return new ssoTestHarnessPage(driver);
	}*/
	// This method validated the elements on the test harness page 
		public void validatePageElements(){
			System.out.println("Big 4's being validated on the testharness");
			validateNew(DOBField);
			validateNew(FirstName);
			validateNew(LastName);
			validateNew(MIB);
			validateNew(targetURL);			
			DOBField.clear();
			FirstName.clear();
			LastName.clear();
			MIB.clear();
			targetURL.clear();
		}
	
	@Override
	public void openAndValidate() {
			
	}
	/*This method will enter first name on SSO Test Harness page */
	   public void enterFirstName1(String fname) {
		    	sendkeys(firstName1, fname);
		        }
	   public void enterssopartner(String ssopartner) {
			    	sendkeys(ssopart, ssopartner);
	   }
	   /*This method will enter last name on SSO Test Harness page */
	   public void enterLastName1(String lname) {
	   	sendkeys(lastName1, lname);
	       }	
	   /*This method will enter dob on SSO Test Harness page */
	   public void enterDOB1(String dob) {
		   	sendkeys(dateofBirth1, dob);
		       }
	   /*This method will enter mbi on SSO Test Harness page */
	   public void enterMBI(String mbi) {
		   	sendkeys(mbi22, mbi);
		       }
	   /*This method will enter url on SSO Test Harness page */
	   public void enterURL(String url) {
		   			sendkeys(targetURL, url);
	   }
	   
	   /*This method will click submit button on SSO test harness page */
	   public void clickSubmit1() throws InterruptedException {
		   submitButton.click();
		   Thread.sleep(2000);
		       }

	
}
