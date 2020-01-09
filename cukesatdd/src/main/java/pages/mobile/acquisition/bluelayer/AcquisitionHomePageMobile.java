package pages.mobile.acquisition.bluelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/*@author pagarwa5*/

import acceptancetests.data.MRConstants;
import atdd.framework.MRScenario;

public class AcquisitionHomePageMobile extends GlobalWebElementsMobile {

	private static String UMS_ACQISITION_PAGE_URL = MRConstants.UHC_URL;
	private static String UMS_ACQISITION_OFFLINE_PAGE_URL = MRConstants.UHC_URL_OFFLINE;
	private static String UMS_ACQISITION_PROD_PAGE_URL = MRConstants.UHCM_URL_PROD;
	private static String Local_AARP_URL = MRConstants.Local_URL;	
	private static String DIGITAL_AARP_URL = MRConstants.TeamDigital_AARP_URL;
	private static String DIGITAL_UHC_URL = MRConstants.TeamDigital_UHC_URL;
	
	public static boolean isHealthPlan = false;
	
	public AcquisitionHomePageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		if (MRScenario.environment.equals("offline")) {
			startNew(UMS_ACQISITION_OFFLINE_PAGE_URL);
			checkModelPopup(driver,45);
		}else if (MRScenario.environment.equals("prod")) {
			startNew(UMS_ACQISITION_PROD_PAGE_URL);
			checkModelPopup(driver,45);
		} else if(MRScenario.environment.equals("local")){
			startNew(Local_AARP_URL);
		} else if(MRScenario.environmentName.equals("TEAMDIGITAL_AARP_URL")){
			startNew(DIGITAL_AARP_URL);
		} else if(MRScenario.environmentName.equals("TEAMDIGITAL_UHC_URL")){
			startNew(DIGITAL_UHC_URL);
		}else {
			startNew(UMS_ACQISITION_PAGE_URL);
			checkModelPopup(driver,10);
		}
		System.out.println("Current page URL: "+driver.getCurrentUrl());
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
