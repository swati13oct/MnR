package pages.mobile.acquisition.bluelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/*@author pagarwa5*/

import acceptancetests.data.MRConstants;
import atdd.framework.MRScenario;

public class AcquisitionHomePageMobile extends GlobalWebElementsMobile {
	private static String UMS_ACQISITION_PAGE_URL = MRConstants.UHC_URL;
	private static String AARP_ACQISITION_PAGE_URL = MRConstants.AARP_URL;
	
	public AcquisitionHomePageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void openPRE() {
		if(MRScenario.environment.equalsIgnoreCase("digital-uatv2-uhc")){
			//startNewMobile(UMS_ACQISITION_PAGE_URL.replace("digital-uatv2-uhc", "digital-uatv2").replace("www.", ""));
			startNewMobile(UMS_ACQISITION_PAGE_URL.replace("digital-uatv2-uhc", "digital-uatv2"));
		} else {
			//startNewMobile(AARP_ACQISITION_PAGE_URL.replace("www.", ""));
			startNewMobile(AARP_ACQISITION_PAGE_URL);
		}
		System.out.println("Current mobile page URL: "+driver.getCurrentUrl());
	}
	
	public void openMobileURL() {
		startNewMobile(AARP_ACQISITION_PAGE_URL);
		System.out.println("Current mobile page URL: "+driver.getCurrentUrl());
	}
	
	public void fixPrivateConnectionMobile() {
		try {
			//String URL = "https://self-signed.badssl.com/";
			threadsleep(1000);
			if (driver.findElement(By.cssSelector("body.ssl h1")).getText().contains("Your connection is not private")) {
				driver.findElement(By.cssSelector("button#details-button")).click();
				threadsleep(1000);
				driver.findElement(By.cssSelector("a#proceed-link")).click();
				threadsleep(1000);
				pageloadcomplete();
			}
		} catch (Exception e) {
			System.out.println("No SSL error / Exception");
		}
	}
}
