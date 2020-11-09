package pages.regression.guestPayments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.regression.login.HSIDLoginPage;
import pages.regression.planDocumentsAndResources.PlanDocumentsAndResourcesPage;
import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;

public class guestPaymentsLogin extends guestPaymentsLoginWebElements{
	
	private static String AARP_GUEST_PAYMENTS_PAGE_URL  = MRConstants.AARP_GUEST_PAYMENTS_PAGE_URL;
	private static String UHC_GUEST_PAYMENTS_PAGE_URL = MRConstants.UHC_GUEST_PAYMENTS_PAGE_URL;
	private static String RETIREE_GUEST_PAYMENTS_PAGE_URL = MRConstants.RETIREE_GUEST_PAYMENTS_PAGE_URL;
	private static String PCP_GUEST_PAYMENTS_PAGE_URL = MRConstants.PCP_GUEST_PAYMENTS_PAGE_URL;
	private static String  MEDICA_GUEST_PAYMENTS_PAGE_URL= MRConstants.MEDICA_GUEST_PAYMENTS_PAGE_URL;
	private static String AARP_GUEST_PAYMENTS_PAGE_URL_PROD  = MRConstants.AARP_GUEST_PAYMENTS_PAGE_URL_PROD;
	private static String UHC_GUEST_PAYMENTS_PAGE_URL_PROD = MRConstants.UHC_GUEST_PAYMENTS_PAGE_URL_PROD;
	private static String RETIREE_GUEST_PAYMENTS_PAGE_URL_PROD = MRConstants.RETIREE_GUEST_PAYMENTS_PAGE_URL_PROD;
	private static String PCP_GUEST_PAYMENTS_PAGE_URL_PROD = MRConstants.PCP_GUEST_PAYMENTS_PAGE_URL_PROD;
	private static String  MEDICA_GUEST_PAYMENTS_PAGE_URL_PROD= MRConstants.MEDICA_GUEST_PAYMENTS_PAGE_URL_PROD;
	


	public guestPaymentsLogin(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();

	}

	public guestPaymentsLogin(WebDriver driver, String siteName) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(siteName);
	}
	
    public void openAndValidate() { 
		
	}

	public boolean guestPaymentsValidate(WebElement element) {
		long timeoutInSec=0;
		return guestPaymentsValidate(element, timeoutInSec);
	} 
	
	/**
	 * to validate whether element exists with input timeout value control
	 * note: use this instead of the one from UhcDriver which takes up to 30 sec to timeout
	 * @param element
	 * @param timeoutInSec
	 * @return
	 */
	public boolean guestPaymentsValidate(WebElement element, long timeoutInSec) {
		//note: if ever need to control the wait time out, use the one in UhcDriver validate(element, timeoutInSec)
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		try {
			if (element.isDisplayed()) {
				System.out.println("Element '"+element.toString()+"' found!!!!");
				return true;
			} else {
				System.out.println("Element '"+element.toString()+"' not found/not visible");
			}
		} catch (Exception e) {
			System.out.println("Element '"+element.toString()+"' not found/not visible. Exception");
		}
		//note: default in UhcDriver is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		return false;
	} 


	public void sleepBySec(int sec) {
		System.out.println("Sleeping for '"+sec+"' sec");
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void openAndValidate(String siteName) {
		
		if (MRScenario.environment.equalsIgnoreCase("prod")){
		if ("AARP".equalsIgnoreCase(siteName)) {
				startNew(AARP_GUEST_PAYMENTS_PAGE_URL_PROD);
			
			}
		
		else if ("UHC".equalsIgnoreCase(siteName)) {
			startNew(UHC_GUEST_PAYMENTS_PAGE_URL_PROD);
			
		}
		
		else if ("RETIREE".equalsIgnoreCase(siteName)) {
			startNew(RETIREE_GUEST_PAYMENTS_PAGE_URL_PROD);
			
		}
		
		else if ("PCP".equalsIgnoreCase(siteName)) {
			startNew(PCP_GUEST_PAYMENTS_PAGE_URL_PROD);
			
		}
		
		else if ("MEDICA".equalsIgnoreCase(siteName)) {
			startNew(MEDICA_GUEST_PAYMENTS_PAGE_URL_PROD);
			
		}
	}
		else{
			
			if ("AARP".equalsIgnoreCase(siteName)) {
				startNew(AARP_GUEST_PAYMENTS_PAGE_URL);
			}
		
		else if ("UHC".equalsIgnoreCase(siteName)) {
			startNew(UHC_GUEST_PAYMENTS_PAGE_URL);		
		}
		
		else if ("RETIREE".equalsIgnoreCase(siteName)) {
			startNew(RETIREE_GUEST_PAYMENTS_PAGE_URL);	
		}
		
		else if ("PCP".equalsIgnoreCase(siteName)) {
			startNew(PCP_GUEST_PAYMENTS_PAGE_URL);
		}
		
		else if ("MEDICA".equalsIgnoreCase(siteName)) {
			startNew(MEDICA_GUEST_PAYMENTS_PAGE_URL);
		}
			
	}

		
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println(">>>>>>>>>Current page URL: " + driver.getCurrentUrl());
		checkModelPopup(driver, 45);
		CommonUtility.waitForPageLoadNew(driver, guestPaymentsHeader, 45);
		
	}

	
	/**
	 * method to validate the page Elements
	 */

	public void validateHeaderAndBody() {
		
		Assert.assertTrue("PROBLEM - unable to locate the Guest payments Header",guestPaymentsValidate(guestPaymentsHeader));
		Assert.assertTrue("PROBLEM - unable to locate the static content below header ",guestPaymentsValidate(staticContentBelowHeader));
		Assert.assertTrue("PROBLEM - unable to locate the sign in link ",guestPaymentsValidate(signInLink));
		Assert.assertTrue("PROBLEM - unable to locate help Me Find My Id Link ",guestPaymentsValidate(helpMeFindMyIdLink));
		Assert.assertTrue("PROBLEM - unable to locate the Member ID textfield",guestPaymentsValidate(memberIdTextfield));
		Assert.assertTrue("PROBLEM - unable to locate the DOB textfield ",guestPaymentsValidate(dobTextfield));
		Assert.assertTrue("PROBLEM - unable to locate the Next Button ",guestPaymentsValidate(nextButton));
		Assert.assertTrue("PROBLEM - unable to locate Footer Text ",guestPaymentsValidate(footerText));

	}

	public void validateFindMyID() {
		helpMeFindMyIdLink.click();
		
		Assert.assertTrue("PROBLEM - unable to locate Image on the Find my Id link",guestPaymentsValidate(memberIdCardImage));
		Assert.assertTrue("PROBLEM - unable to locate text on the Find my Id link",guestPaymentsValidate(textOnFindMyIdPopup));
		
		CancelButtononID.click();

	}

	public void enterIDandBirthDate(String memberID, String dob) {
		memberIdTextfield.clear();
		memberIdTextfield.sendKeys(memberID);
		dobTextfield.sendKeys(dob);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();



	}

	public OneTimeGuestPaymentsPage clickNext() {
		
		nextButton.click();
		System.out.println(">>>>>>Next button is clicked<<<<<<");
		
		CommonUtility.checkPageIsReady(driver);
		checkModelPopup(driver,5);
		CommonUtility.waitForPageLoad(driver, makeAPaymentsHeader, 5);
		
		if (validate(makeAPaymentsHeader)) {
			return new OneTimeGuestPaymentsPage(driver);
		}
		return null;
	}

	public void clicksNextButton() {
	
		nextButton.click();
		System.out.println(">>>>>>Next button is clicked<<<<<<");
		CommonUtility.checkPageIsReady(driver);
		
		
		
	}

	public void checkErrorMessage() {
		
		Assert.assertTrue("PROBLEM - unable to locate error message on the Page",guestPaymentsValidate(errorMessage));
		
	}

	public void checkErrorMessageFromGPS() {
		
		Assert.assertTrue("PROBLEM - unable to locate error message on the Page",guestPaymentsValidate(errorMessageFromGPS));
		
	}

	public guestPaymentsLogin clickAndLandOnErrorPage() {
		nextButton.click();
		System.out.println(">>>>>>Next button is clicked<<<<<<");
		
		CommonUtility.checkPageIsReady(driver);
		checkModelPopup(driver,5);
		CommonUtility.waitForPageLoad(driver, magnifyIcon, 5);
		
		if (driver.getCurrentUrl().contains("member-not-found")) {
			return new guestPaymentsLogin(driver);
		}
		
		return null;
	
	}

	public void verifyDetailsOnErrorPage() {
		
		Assert.assertTrue("PROBLEM - unable to locate error message on the Page",guestPaymentsValidate(errorMessageOnErrorPage));

		Assert.assertTrue("PROBLEM - unable to locate error text on the Page",errorMessageOnErrorPage.getText().contains("not available"));

		
		
	}

	public void verifySignInLinkShouldNotBePresent() {
		Assert.assertTrue("PROBLEM - unable to locate signIn Page message on the Page",!guestPaymentsValidate(signInLinkOnErrorPage));
		
		
	}
	
	public void verifySignInLinkShouldBePresent() {
		Assert.assertTrue("PROBLEM - unable to locate signIn Page message on the Page",guestPaymentsValidate(signInLinkOnErrorPage));
		
		
	}
	


	public void clickOnSignInLink() {
		signInLink.click();
	
		System.out.println(">>>>>>Sign In button is clicked<<<<<<");
		
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		CommonUtility.checkPageIsReady(driver);

		
	}
	
	public void validateBrand(String siteName) {
		
		validateNew(logoOnLoginPage);
		String brandSource =logoOnLoginPage.getAttribute("src");
		if(siteName=="RETIREE")
			//logo for retiree site also have UHC on the dashboard
			siteName="UHC";
		
	  
		Assert.assertTrue("PROBLEM - unable to locate correct logo on HSID login page", brandSource.contains(siteName));
		
		
	}

	public void validateSignInButton() {

		Assert.assertTrue("PROBLEM - unable to locate Sign In Button on HSID login page", validate(signInButton));
		
		
	} 

}

