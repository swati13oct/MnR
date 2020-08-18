package pages.regression.guestPayments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	public void validateHeaderSection() {
		
	}


}

