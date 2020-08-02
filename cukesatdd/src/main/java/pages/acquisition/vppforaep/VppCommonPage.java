/**
 * 
 */
package pages.acquisition.vppforaep;


import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.acquisition.dce.DrugCostEstimatorPage;
import pages.acquisition.ole.WelcomePage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;


/**
 * @author gumeshna
 *
 */
public class VppCommonPage extends UhcDriver {

	private static String AARP_ACQISITION_PAGE_URL = MRConstants.AARP_URL;
	private static String AARP_ACQISITION_OFFLINE_PAGE_URL = MRConstants.AARP_URL_OFFLINE;
	private static String AARP_ACQISITION_PROD_PAGE_URL = MRConstants.AARP_URL_PROD;
	private static String UMS_ACQISITION_PAGE_URL = MRConstants.UHC_URL;
	private static String UMS_ACQISITION_OFFLINE_PAGE_URL = MRConstants.UHC_URL_OFFLINE;
	private static String UMS_ACQISITION_PROD_PAGE_URL = MRConstants.UHCM_URL_PROD;

	public VppCommonPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public VppCommonPage(WebDriver driver, String site,String deeplinkUrl) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(site,deeplinkUrl);
	}
	
	
	

	public String getPlanDetails() {
		// TODO write implementation of the method
		return null;
	}


	@Override
	public void openAndValidate() {
	
	}

	//this method is used for direct deeplink to plan details page for plan validation
	public void openAndValidate(String site, String deeplinkUrl) {
		
		String tempUrl = "";
		if ("AARP".equalsIgnoreCase(site)) {
			if (MRScenario.environment.equals("offline")) {
				tempUrl=AARP_ACQISITION_OFFLINE_PAGE_URL;
				driver.get(tempUrl+deeplinkUrl);
				checkModelPopup(driver,45);
				
			} else if (MRScenario.environment.equals("prod")) {
				tempUrl=AARP_ACQISITION_PROD_PAGE_URL+deeplinkUrl;
				driver.get(tempUrl+deeplinkUrl);
				checkModelPopup(driver,45);
				
			} else {
				tempUrl=AARP_ACQISITION_PAGE_URL;
				driver.get(tempUrl+deeplinkUrl);
				checkModelPopup(driver,10);
				
			}
			System.out.println("Current page URL: "+driver.getCurrentUrl());
		}else {
			if (MRScenario.environment.equals("offline")) {
				tempUrl=UMS_ACQISITION_OFFLINE_PAGE_URL;
				driver.get(tempUrl+deeplinkUrl);
				checkModelPopup(driver);
				
			} else if (MRScenario.environment.equals("prod")) {
				tempUrl=UMS_ACQISITION_PROD_PAGE_URL+deeplinkUrl;
				driver.get(tempUrl+deeplinkUrl);
				checkModelPopup(driver);
				
			} else {
				tempUrl=UMS_ACQISITION_PAGE_URL;
				driver.get(tempUrl+deeplinkUrl);
				checkModelPopup(driver,20);
			}
			System.out.println("Current page URL: "+driver.getCurrentUrl());
		}

	}

	
}
