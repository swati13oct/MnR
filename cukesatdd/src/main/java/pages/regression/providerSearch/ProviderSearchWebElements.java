package pages.regression.providerSearch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import atdd.framework.UhcDriver;

public class ProviderSearchWebElements  extends UhcDriver {

	public ProviderSearchWebElements(WebDriver driver) {
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

	@FindBy(xpath="//header[contains(@class,'sub-nav-header')]//a[contains(@track,'explanation')]")
	protected WebElement eobTopSubMenuLnk;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//a[contains(@id,'coveragebenefits')]")
	protected WebElement benefitsTopMenuLnk;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//a[contains(@id,'formsandresources')]")
	protected WebElement planDocTopMenuLnk;

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

	@FindBy(xpath="//header[@class='section-header']//a[contains(@class,'drug-lookup')]")
	protected WebElement section_drugLocator;
	
	@FindBy(xpath="//a[contains(@class,'btn') and contains(text(),'VIEW PLAN')]")
	protected WebElement preeff_goToPlanDocBtn;

	@FindBy(xpath="//button[contains(@id,'accountprofile') and @aria-expanded='false']")
	protected WebElement acctProfileBtn_closed;

	@FindBy(xpath="//button[contains(@id,'accountprofile') and @aria-expanded='true']")
	protected WebElement acctProfileBtn_expanded;

	@FindBy(xpath="//a[contains(@id,'accsettings')]")
	protected WebElement acctSettingsLnk;


	@FindBy(xpath= "//button[@id='accountprofile']")
	protected WebElement testHarn_AcctProfBtn;

	@FindBy(xpath="//div[@class='deskHeaderContainer']//div[contains(@class,'dropdown') and contains(@class,'open')]//a[contains(@id,'ihr')]")
	protected WebElement testHarn_desktop_AcctProf_IHRLnk;

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
	
	//--------
	@FindBy(xpath="//a[@data-track-id='FIND_PROVIDER']")
	protected WebElement dashboard_findProviderLnk;
	
	@FindBy(xpath="//button[contains(@class,'primary-searchbox')]")
	protected WebElement uhcProviderSearchBtn;
	
	@FindBy(xpath="//header[contains(@class,'hide-mobile')]//a[@data-testid='nav-link-claims']")
	protected WebElement uhcProviderSearchClaimsLnk;

	@FindBy(xpath="//header[contains(@class,'hide-mobile')]//a[@data-testid='nav-link-coverage']")
	protected WebElement uhcProviderSearchBenefitsLnk;

	@FindBy(xpath="//header[contains(@class,'hide-mobile')]//a[@data-testid='nav-link-premium-payments']")
	protected WebElement uhcProviderSearchPaymentsLnk;

	@FindBy(xpath="//header[contains(@class,'hide-mobile')]//a[@data-testid='nav-link-health-wellness']")
	protected WebElement uhcProviderSearchHwLnk;
	
	@FindBy(xpath="//button[@id='dropdown-toggle-2']")
	protected WebElement uhcProviderSearchAcctProfBtn;
	
	@FindBy(xpath="//ul[@id='dropdown-options-2']//a[@data-testid='TARGET_AWARE_ACCOUNT_SETTINGS']")
	protected WebElement uhcProviderSearchAcctSettingsOpt;

	@FindBy(xpath="//button[contains(@class,'dialog-btn')]")
	protected WebElement uhcProviderSearchContBtn;

}