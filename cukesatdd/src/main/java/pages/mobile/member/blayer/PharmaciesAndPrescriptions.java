package pages.mobile.member.blayer;

import org.openqa.selenium.WebDriver;

import acceptancetests.data.MRConstants;
import atdd.framework.UhcDriver;

public class PharmaciesAndPrescriptions extends UhcDriver{
	
	//Need to update the URL in MRConstant
	private static String AARP_ACQISITION_PAGE_URL = MRConstants.AARP_URL;

	public PharmaciesAndPrescriptions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public void openMobileURL() {
		startNewMobile(AARP_ACQISITION_PAGE_URL);
		System.out.println("Current mobile page URL: " + driver.getCurrentUrl());
	}
	
	@Override
	public void openAndValidate() throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

}
