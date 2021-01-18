
package pages.regression.healthRecord;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class HealthRecordWebElements  extends UhcDriver {

	public HealthRecordWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate(){
	}

	@FindBy(tagName = "arcade-header") 
	protected WebElement shadowRootHeader;

	@FindBy(tagName = "arcade-footer") 
	protected WebElement shadowRootFooter;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//a[contains(@id,'findcare')]")
	protected WebElement findCareTopMenuLnk;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//a[contains(@id,'claims')]")
	protected WebElement claimsTopMenuLnk;
	
	@FindBy(xpath="//h1[contains(.,'Sign In')]")
	protected WebElement claimsSysTestPg;

	@FindBy(xpath="//header[contains(@class,'sub-nav-header')]//a[contains(@track,'explanation') or contains(@data-testid,'explanation')]")
	protected WebElement eobTopSubMenuLnk;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//a[contains(@id,'coveragebenefits')]")
	protected WebElement benefitsTopMenuLnk;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//a[contains(@id,'formsandresources')]")
	protected WebElement planDocTopMenuLnk;
	
	@FindBy(xpath="//h1[contains(text(),'Plan Documents')]")
	protected WebElement planDocHeaderTxt;

	@FindBy(xpath="//a[contains(@id,'myDoc')]")
	protected WebElement myDocLnk;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//a[contains(@id,'order')]")
	protected WebElement orderTopMenuLnk;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//a[contains(@id,'payment')]")
	protected WebElement paymentTopMenuLnk;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//a[contains(@id,'pharmacies')]")
	protected WebElement pnpTopMenuLnk;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//a[contains(@id,'health')]")
	protected WebElement hwTopMenuLnk;

	@FindBy(xpath="//a[contains(text(),'Go to EOB')]")
	protected WebElement testharnessTblEobLnk;

	@FindBy(xpath="//a[contains(text(),'Go to Pharmacy')]")
	protected WebElement testharnessTblPharmacyLocatorLnk;

	@FindBy(xpath="//a[contains(text(),'Go to DCE')]")
	protected WebElement testharnessTblDceLnk;

	@FindBy(xpath="//a[@id='contactUsAtdd']")
	protected WebElement ContactUsLnk;

	@FindBy(xpath = "//*[@ng-src='/images/icons/icon-pharmacy-locator.svg']")
	protected WebElement pharmacySearchLink;

	@FindBy(xpath = "//span[contains (text(), 'Look up Drugs')]")
	protected WebElement drugLookup;

	@FindBy(xpath="//header[@class='section-header']//a[contains(@class,'pharmacy-locator')]")
	protected WebElement section_pharmacySearchLink;

	@FindBy(xpath="//input[@id='zipcodeTxt']")
	protected WebElement pharmacySearchPgZipcodeField;
	
	@FindBy(xpath="//input[@data-component='SearchBarInput']")
	protected WebElement pharmacySearchPgZipcodeField_newRally;

	@FindBy(xpath="//header[@class='section-header']//a[contains(@class,'drug-lookup')]")
	protected WebElement section_drugLocator;
	
	@FindBy(xpath = "//h1[contains(text(),'Drug')]")
	public WebElement dcePgHeaderTxt;

	
	@FindBy(xpath="//a[contains(@class,'btn') and contains(text(),'VIEW PLAN')]")
	protected WebElement preeff_goToPlanDocBtn;

	@FindBy(xpath="//button[contains(@id,'accountprofile') and @aria-expanded='false']")
	protected WebElement acctProfileBtn_closed;

	@FindBy(xpath="//button[contains(@id,'accountprofile') and @aria-expanded='true']")
	protected WebElement acctProfileBtn_expanded;

	@FindBy(xpath="//a[contains(@id,'accsettings')]")
	protected WebElement acctSettingsLnk;

	@FindBy(xpath= "//button[@id='accountprofile' or @id='dropdown-toggle-3' or @id='dropdown-toggle-2']//*[contains(text(),'Account')]")
	protected WebElement testHarn_AcctProfBtn;

	@FindBy(xpath= "//button[@id='accountprofile' or contains(@id,'dropdown-toggle')]/*[contains(text(),'Account')]")
	protected WebElement testHarn_AcctProfBtn_claims;

	
	@FindBy(xpath="//ul[contains(@class,'dropdown-menu')]//li")
	protected List<WebElement> testHarn_AcctProfDropdown;

	@FindBy(xpath="//div[contains(@class,'account-btn')]//ul[contains(@class,'dropdown-menu') or contains(@id,'dropdown-options')]//a")
	protected List<WebElement> testHarn_AcctProfDropdown_claims;

	@FindBy(xpath="//ul[contains(@id,'dropdown-options-3') or contains(@id,'dropdown-options-2')]//a")
	protected List<WebElement> testHarn_AcctProfDropdown_react;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//div[contains(@class,'dropdown') and contains(@class,'open')]//a[contains(@id,'ihr') or contains(text(),'Health record')]")
	protected WebElement testHarn_desktop_AcctProf_IHRLnk;
	
	@FindBy(xpath="//ul[@id='dropdown-options-3']//a[contains(@data-testid,'TARGET_AWARE_HEALTH_RECORD')]")
	protected WebElement testHarn_desktop_AcctProf_IHRLnk_pharmacyLocator;

	@FindBy(xpath="//div[contains(@class,'account-btn')]//ul[contains(@class,'dropdown-menu') or contains(@id,'dropdown-options')]//a[contains(@href,'ihr')]")
	protected WebElement testHarn_desktop_AcctProf_IHRLnk_claims;

	//tbd @FindBy(xpath="//div[@data-testid='shared-header']//ul[@aria-expanded='true' and (@id='dropdown-options-3' or @id='dropdown-options-2')]//a[@data-testid='TARGET_AWARE_HEALTH_RECORD']")
	@FindBy(xpath="//div[@data-testid='shared-header']//ul[@aria-expanded='true' and contains(@id,'dropdown-options')]//a[@data-testid='TARGET_AWARE_HEALTH_RECORD']")
	protected WebElement testHarn_desktop_AcctProf_IHRLnk_react;
	
	@FindBy(xpath="//li[@class='accountSettings']//a[contains(text(),'Health record')]")
	protected WebElement testHarn_IHRLnk;
	
	@FindBy(xpath="//h1[contains(text(),'Welcome') and contains(text(),'Health Record')]")
	protected WebElement heathRecordPgHeaderText;

	//--------------------------
	@FindBy(xpath="//p[contains(@class,'siteleaving')]")
	protected WebElement siteLeavingPopup;

	@FindBy(xpath="//a[contains(@id,'proceedbtn')]")
	protected WebElement siteLeavingPopup_proceedBtn;

	@FindBy(xpath="//a[contains(@id,'cancelbtn')]")
	protected WebElement siteLeavingPopup_cancelBtn;

	@FindBy(xpath="//*[contains(text(),'Sorry')]")
	protected WebElement sorryError;

	@FindBy(xpath="//div[contains(@class,'tabs')]//a[not(contains(text(),'Supplement')) and not(contains(text(),'Prescription')) and contains(text(),'Medicare')]") 
	protected WebElement comboTab_MA;

	@FindBy(xpath="//div[contains(@class,'formsAndResourcesContainer')]//a[not(contains(text(),'Supplement')) and not(contains(text(),'Prescription')) and contains(text(),'Medicare')]") 
	protected WebElement comboTab_MA_planDoc;

	@FindBy(xpath="//div[contains(@class,'tabs')]//a[contains(text(),'Prescription') and contains(text(),'Medicare')]") 
	protected WebElement comboTab_MAPD;

	@FindBy(xpath="//div[contains(@class,'formsAndResourcesContainer')]//a[contains(text(),'Prescription') and contains(text(),'Medicare')]") 
	protected WebElement comboTab_MAPD_planDoc;

	@FindBy(xpath="//div[contains(@class,'tabs')]//a[contains(text(),'Supplement')]") 
	protected WebElement comboTab_SHIP;

	@FindBy(xpath="//div[contains(@class,'formsAndResourcesContainer')]//a[contains(text(),'Supplement')]") 
	protected WebElement comboTab_SHIP_planDoc;

	@FindBy(xpath="//div[contains(@class,'tabs')]//a[contains(text(),'Hospital Indemnity')]") 
	protected WebElement comboTab_SHIP_HIP;

	@FindBy(xpath="//div[contains(@class,'formsAndResourcesContainer')]//a[contains(text(),'Hospital Indemnity')]") 
	protected WebElement comboTab_SHIP_HIP_planDoc;

	@FindBy(xpath="//div[contains(@class,'tabs')]//a[contains(text(),'Prescription') and not(contains(text(),'Medicare'))]") 
	protected WebElement comboTab_PDP;

	@FindBy(xpath="//div[contains(@class,'formsAndResourcesContainer')]//a[contains(text(),'Prescription') and not(contains(text(),'Medicare'))]") 
	protected WebElement comboTab_PDP_planDoc;

	@FindBy(xpath="//div[contains(@class,'tabs')]//a[contains(text(),'Senior Supplement Plan')]") 
	protected WebElement comboTab_SSP;

	@FindBy(xpath="//div[contains(@class,'formsAndResourcesContainer')]//a[contains(text(),'Senior Supplement Plan')]")
	protected WebElement comboTab_SSP_planDoc;
	
	@FindBy(xpath="//h1[contains(.,'Benefit Summary')]")
	protected WebElement benefitsPgHeader;
	
	@FindBy(xpath="//a[contains(@class,'atdd-bnc-locatepharmacybtn')]")
	protected WebElement benefitsPgLocatePharmacyLnk;
	
	@FindBy(xpath="//button[contains(text(),'Close')]")
	protected WebElement stagePharmacyLocatorCloseBtn;


}