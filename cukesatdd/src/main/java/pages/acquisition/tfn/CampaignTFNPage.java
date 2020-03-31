package pages.acquisition.tfn;

import org.junit.Assert;
import org.openqa.selenium.By;

/**
 * @author sdwaraka
 *
 */

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.AcquisitionHomePage;



public class CampaignTFNPage extends UhcDriver {
	
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	public static String PSC_CODE = "psccode";
	public static String FEDERAL_TFN = "federaltfn";
	public static String MEDSUPP_TFN = "medsupptfn";


	public CampaignTFNPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		System.out.println("Current URL - "+driver.getCurrentUrl());

	}

	public void retrieveTFNcookie() {
		System.out.println("Current URL - "+driver.getCurrentUrl());
		Cookie cookietfn = driver.manage().getCookieNamed("TFNSessionCookie");
		System.err.println(cookietfn);
		String str = cookietfn.toString();
		System.out.println("TFN Cookie Value - "+str);
		String[] arrOfStr = str.split("%2C"); 
		String PSC_Code;
		String FedTFN;
		String MedSuppTFN ;
		for (String a : arrOfStr)
		        
		            System.out.println(a); 
		String PSC_Code_Str= arrOfStr[0];
		String[] arrStr_1 = PSC_Code_Str.split("="); 
		PSC_Code = arrStr_1[1];
		FedTFN=arrOfStr[2];
		MedSuppTFN = arrOfStr[3];
		
		System.out.println("Campaign PSC code - "+PSC_Code);
		System.out.println("Federal TFN - "+FedTFN);
		System.out.println("MedSupp TFN - "+MedSuppTFN);
		
		PSC_CODE = PSC_Code;
		FEDERAL_TFN=FedTFN;
		MEDSUPP_TFN=MedSuppTFN;
		
		/*
		 * getLoginScenario().saveBean(TFNCommonConstants.PSC_CODE, PSC_Code);
		 * getLoginScenario().saveBean(TFNCommonConstants.FEDERAL_TFN, FedTFN);
		 * getLoginScenario().saveBean(TFNCommonConstants.MEDSUPP_TFN, MedSuppTFN);
		 */		

	}

	public void validatePSCcode(String ExpectedpscCode) {
		
		String PSC_Code = PSC_CODE;
		System.out.println("Expected PSC code: "+ExpectedpscCode);
		System.out.println("Actual PSC code: "+PSC_Code);
		
		if(ExpectedpscCode.contentEquals(PSC_Code)) {
			System.out.println("****************Expected PSC Code matches Actual PSC code from TFN cookie ***************");

			Assert.assertTrue(true);
		}
		else {
			Assert.fail("****************Expected PSC Code DOES NOT match Actual PSC code from TFN cookie ***************");
		}
		// TODO Auto-generated method stub
		
	}

	public void navigateToUrl(String uRLpath) {

		String CurrentURL = driver.getCurrentUrl();
		System.out.println("Current URL : "+CurrentURL);
		String SiteURL = CurrentURL.split(".com")[0];
		System.out.println("Split URL : "+SiteURL);
		SiteURL = SiteURL+".com/";
		System.out.println("Site URL : "+SiteURL);
		String NavigateToURL = SiteURL+uRLpath;
		System.out.println("Navigating to URL : "+NavigateToURL);
		driver.navigate().to(NavigateToURL);
		CommonUtility.waitForPageLoad(driver, driver.findElement(By.xpath("//header[contains(@class,'header')]")), 30);
		System.out.println("Page Title : "+(driver.findElement(By.xpath("//title")).getText()));
	}

	public void validateFederalTFN(String tFN_Xpath) {
		WebElement TFNelement = driver.findElement(By.xpath(tFN_Xpath));
		validateNew(TFNelement);	
		if(validateNew(TFNelement) && TFNelement.isDisplayed()) {
			System.out.println("TFN is Displayed on Page : "+TFNelement.getText());
		}
		else {
			Assert.fail("TFN elemnet is not found / displayed on page : "+tFN_Xpath);
		}
		String TFNonPage = TFNelement.getText();
		if(TFNonPage.contains(FEDERAL_TFN)) {
			System.out.println("Correct Federal TFN is Displayed on Page : "+TFNelement.getText());
		}
		else {
			Assert.fail("TFN displayed is INCORRECT for Federal : "+tFN_Xpath);
		}


	}

	public void validateMedSuppTFN(String tFN_Xpath) {
		WebElement TFNelement = driver.findElement(By.xpath(tFN_Xpath));
		validateNew(TFNelement);	
		if(validateNew(TFNelement) && TFNelement.isDisplayed()) {
			System.out.println("TFN is Displayed on Page : "+TFNelement.getText());
		}
		else {
			Assert.fail("TFN elemnet is not found / displayed on page : "+tFN_Xpath);
		}
		String TFNonPage = TFNelement.getText();
		if(TFNonPage.contains(FEDERAL_TFN)) {
			System.out.println("Correct Med Supp TFN is Displayed on Page : "+TFNelement.getText());
		}
		else {
			Assert.fail("TFN displayed is INCORRECT for Med Supp Page : "+tFN_Xpath);
		}
	}
	
	
	public void navigateToCampaignURL(String campaignUrl , String envUrl) {
		System.out.println("Environment URL : "+envUrl);
		String NavigateToURL = envUrl+campaignUrl;
		System.out.println("Campaign URL : "+NavigateToURL);
		driver.navigate().to(NavigateToURL);
		CommonUtility.waitForPageLoad(driver, driver.findElement(By.xpath("//header[contains(@class,'header')]")), 30);
		System.out.println("Page Title : "+(driver.findElement(By.xpath("//title")).getText()));		
	}
	

	
}