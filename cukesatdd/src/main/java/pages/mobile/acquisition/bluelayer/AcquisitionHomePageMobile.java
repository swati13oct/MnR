package pages.mobile.acquisition.bluelayer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

/*@author pagarwa5*/

import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import junit.framework.Assert;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.pharmacyLocator.PharmacySearchPage;
import pages.acquisition.ulayer.PageTitleConstants;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;


public class AcquisitionHomePageMobile extends GlobalWebElementsMobile {
	@FindBy(id = "lookzip")
	private WebElement lookupZipcode;
	
	public JSONObject browserCheckJson;

	private PageData cobrowseData;
	public JSONObject cobrowseJson;
	private static String UMS_ACQISITION_PAGE_URL = MRConstants.UHC_URL;
	private static String UMS_ACQISITION_OFFLINE_PAGE_URL = MRConstants.UHC_URL_OFFLINE;
	private static String UMS_ACQISITION_PROD_PAGE_URL = MRConstants.UHCM_URL_PROD;
	private static String AARP_ACQISITION_PROD_PAGE_URL = MRConstants.AARP_URL_PROD;	
	private static String Local_AARP_URL = MRConstants.Local_URL;	
	private static String DIGITAL_AARP_URL = MRConstants.TeamDigital_URL;
	private static String AARP_ACQISITION_PAGE_URL = MRConstants.AARP_URL;
	private static String AARP_ACQISITION_OFFLINE_PAGE_URL = MRConstants.AARP_URL_OFFLINE;

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
		} else if(MRScenario.environment.equals("team-digital")){
			startNew(DIGITAL_AARP_URL);
		}else {
			startNew(UMS_ACQISITION_PAGE_URL);
			checkModelPopup(driver,10);
		}
	//	CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: "+driver.getCurrentUrl());
		
		//clickIfElementPresentInTime(driver, proactiveChatExitBtn,20);
	//	CommonUtility.waitForPageLoadNew(driver, navigationSectionHomeLink, 45);
	}	

}
