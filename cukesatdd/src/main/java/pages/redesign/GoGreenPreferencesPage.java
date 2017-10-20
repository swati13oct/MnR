package pages.redesign;
/**
 * @author sdwaraka
 */

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import junit.framework.Assert;

public class GoGreenPreferencesPage extends UhcDriver{
	
	//h1[@class="h4 margin-none"]
		
	@FindBy(xpath = "//*[@class = 'h3 medium margin-small atdd-goGreenHeader']")
	private WebElement myPreferencesHeader;
	
	@FindBy(xpath = "//*[@href = '/content/aarpm/home/profileandpreferences.html']")
	private WebElement GoToProfilePageLink;

	@FindBy(id = "save-prefs-btn")
	private WebElement SavePreferencesButton;
	
	@FindBy(id = "goPaperless-error")
	private WebElement TermsAgreeError;

	
	@FindBy(xpath = "//a[contains(text(), 'Medicare Advantage Plan')]")
	private WebElement MAPlanTab;

	@FindBy(xpath = "//a[contains(text(), 'Hospital Indemnity')]")
	private WebElement HIPplanTab;
	
	@FindBy(xpath = "//a[contains(text(), 'Medicare Prescription Drug Plan')]")
	private WebElement PDPPlanTab;

	@FindBy(xpath = "//a[contains(text(), 'Medicare Supplement Insurance Plan')]")
	private WebElement MedSuppPlanTab;
	
	@FindBy(xpath = "//a[contains(text(), 'Senior Supplement Plan')]")
	private WebElement SrSuppTab;

	@FindBy(xpath="//a[contains(text(),'Personal Health Insurance')]")
	private WebElement PHIPtab;

	private PageData myProfiles;

	public JSONObject myProfilesJson;

	public GoGreenPreferencesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.MY_PREFERENCES_PAGE_DATA;
		myProfiles = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
	openAndValidate();
	}

	public boolean Validate_Single_Tab_SHIP(){
		List<WebElement> PlanTabs = driver.findElements(By.xpath("//a[contains(text(),'Supplemental  Insurance Plans')]"));
		System.out.println("No of tabs: "+PlanTabs.size());
		if(PlanTabs.size()>1){
			return false;
		}
		else{
			return true;
		}
	}

	@Override
	public void openAndValidate() {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		validate(myPreferencesHeader);
		validate(GoToProfilePageLink);
		
		System.out.println("******** Go Green Page Header Displayed : "+myPreferencesHeader.getText()+"********");
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject myProfilesPageExpectedJson = expectedDataMap
				.get(CommonConstants.MY_PROFILES);
		myProfilesPageExpectedJson = CommonUtility.mergeJson(
				myProfilesPageExpectedJson, globalExpectedJson);
		return myProfilesPageExpectedJson;
	}


	public boolean navigatePlanTabs(String PlanType){
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Plan Type : "+PlanType);

		if (PlanType.contentEquals("MA") || PlanType.contentEquals("MAPD")) {
			if (validate(MAPlanTab)){
				MAPlanTab.click();
				System.out.println("*************Displaying Medicare Advantage Plan Tab **********");
				return true;
			}
		}
		
		if (PlanType.contentEquals("SHIP")) {
			if (validate(MedSuppPlanTab)){
				MedSuppPlanTab.click();
				System.out.println("*************Displaying SHIP - Med Supp Plan Tab Plan Tab **********");
				return true;
			}
			else if (validate(HIPplanTab)){
				HIPplanTab.click();
				System.out.println("*************Displaying SHIP - HIP Plan Tab **********");
				return true;
			}
			else {
				System.out.println("*************No SHIP Plans available for this Member **********");
				return false;
			}
		}
		if (PlanType.contentEquals("HIP")) {
			if (validate(HIPplanTab)){
				HIPplanTab.click();
				System.out.println("*************Displaying SHIP - HIP Plan Tab **********");
				return true;
			}
		}
		if (PlanType.contentEquals("PDP")) {
			if (validate(PDPPlanTab)){
				PDPPlanTab.click();
				System.out.println("*************Displaying PDP Plan Tab **********");
				return true;
			}
		}
		if (PlanType.contentEquals("MedSupp")) {
			if (validate(MedSuppPlanTab)){
				MedSuppPlanTab.click();
				System.out.println("*************Displaying SHIP - Med Supp Plan Tab Plan Tab **********");
				return true;
			}
		}
		if (PlanType.contentEquals("SSUP")) {
			if (validate(SrSuppTab)){
				SrSuppTab.click();
				//Assert.assertTrue("Cant navigate to Med Supp PlanTab Plan Tab", MemberIDcardField.isDisplayed());
				System.out.println("*************Displaying Senior Supplement Plan Tab **********");
				return true;
			}
		}
		if (PlanType.contentEquals("PHIP")){
			System.out.println("Plan Name Displayed is : "+PHIPtab.getText());

			if (PHIPtab.isDisplayed()){
				PHIPtab.click();
				System.out.println("*************Displaying Personal Health Insurance Plan Tab **********");
				return true;

			}
		}
		System.out.println("@@@@@@@@@@@@ Invalid Plan Type / Plan Tab not found @@@@@@@@@@@@@@");
		return false;
	}
	
	public void NavigateTo_GoGreen_MyPreferences_Page(){
		//GoGreenPreferencesPage
	}
}
