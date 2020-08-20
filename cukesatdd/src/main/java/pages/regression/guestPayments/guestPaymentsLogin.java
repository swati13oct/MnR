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

public class guestPaymentsLogin extends guestPaymentsLoginWebElements{
	
	private static String AARP_GUEST_PAYMENTS_PAGE_URL  = MRConstants.AARP_GUEST_PAYMENTS_PAGE_URL;
	private static String UHC_GUEST_PAYMENTS_PAGE_URL = MRConstants.UHC_GUEST_PAYMENTS_PAGE_URL;
	private static String RETIREE_GUEST_PAYMENTS_PAGE_URL = MRConstants.RETIREE_GUEST_PAYMENTS_PAGE_URL;
	private static String PCP_GUEST_PAYMENTS_PAGE_URL = MRConstants.PCP_GUEST_PAYMENTS_PAGE_URL;
	private static String  MEDICA_GUEST_PAYMENTS_PAGE_URL= MRConstants.MEDICA_GUEST_PAYMENTS_PAGE_URL;

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

		 else {
			Assert.assertTrue(">>>>>>>>Guest Payments url is incorrectly formed. Please check<<<<<<<<<<<<<<<", false);
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
		Assert.assertTrue("PROBLEM - unable to locate Having Trouble Text ",guestPaymentsValidate(havingTroubleText));
		Assert.assertTrue("PROBLEM - unable to locate Footer Text ",guestPaymentsValidate(footerText));

	}

	public void validateFindMyID() {
		helpMeFindMyIdLink.click();
		CancelButtononID.click();

	}

	public void enterIDandBirthDate() {
		memberIdTextfield.sendKeys("123456");
		dobTextfield.sendKeys("01/01/2000");

	}

	public void clickNext() {
		nextButton.click();

	}

}

