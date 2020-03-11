package pages.acquisition.ulayer;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.VPPPlanSummaryPage;

public class VPPTestHarnessPage extends UhcDriver {

	@FindBy(xpath = "//h3[text()='Enter ZIP Code']/parent::div//input[@id='vpp-zip-search']")
	public WebElement enterVppzipcode;

	@FindBy(xpath = "//h3[text()='Enter ZIP Code']/parent::div//button[text()='Go']")
	public WebElement enterVppGoButton;

	@FindBy(xpath = "//a[@id='showLookupZIPformlink']")
	public WebElement lookupZipcodeLink;

	@FindBy(xpath = "//input[@id='address']")
	public WebElement addressInput;

	@FindBy(xpath = "//input[@id='city']")
	public WebElement cityInput;

	@FindBys(value = { @FindBy(xpath = "//select[@id='state_select']/option") })
	private List<WebElement> stateDropDownValues;

	@FindBy(xpath = "//button[@id='searchzip']")
	public WebElement lookupSearchButton;

	@FindBy(xpath = "//h3[text()='VPP to OLE']/parent::div//input[@id='vpp-zip-search']")
	public WebElement enterOleZip;

	@FindBy(xpath = "//h3[text()='VPP to OLE']/parent::div//button[text()='Load Plans']")
	public WebElement loadPlansButton;

	@FindBys(value = { @FindBy(xpath = "//select[@id='js-ole-plan-select']/option") })
	private List<WebElement> olePlanSelectValues;

	@FindBy(xpath = "//button[text()='Set OLE Cookies Information']")
	public WebElement setOLECookieButton;

	@FindBy(xpath = "//div[@class='modal-title']")
	private WebElement countyModal;

	@FindBy(xpath = "//div[contains(@class,'overview-main')]/h2")
	private WebElement vppTop;

	@FindBy(xpath = "//input[@id='zipcode']")
	private WebElement shopForAPlanOptionZipcodeFieldBox;

	@FindBy(xpath = "//button[text()='Go']")
	private WebElement shopForAPlanOptionFindPlanButton;

	@FindBy(xpath = "//input[@name='planSummaryZIP']")
	private WebElement planSummaryZIP;

	@FindBy(xpath = "//button[contains(@ng-click,'plansummary') and not (contains(@ng-click,'email'))]")
	private WebElement planSummaryCreateButton;

	@FindBy(xpath = "//a[@class='custom_deeplink_anchor' and attribute::href]")
	private WebElement createDeepLinkURL;

	@FindBy(xpath = "//button[contains(@ng-click,'connectormodal')]")
	private WebElement connectorModalCreateButton;

	@FindBy(xpath = "//h4[contains(text(),'Plan Summary')]//parent::div//input[@name='emailplansummaryZIPcode']")
	private WebElement planSummZipCode;

	@FindBy(xpath = "//h4[contains(text(),'Plan Summary')]//parent::div//input[@name='emailplansummarydeeplink']")
	private WebElement planSummDeepLink;

	@FindBy(xpath = "//h4[contains(text(),'Plan Summary')]//parent::div//input[@name='emailplansummaryplantype']")
	private WebElement planSummPlanType;

	@FindBy(xpath = "//h4[contains(text(),'Plan Summary')]//parent::div//input[@name='emailplansummaryyear']")
	private WebElement planSummYear;

	@FindBy(xpath = "//button[contains(@ng-click,'emailplansummary')]")
	private WebElement planSummCreateButton;

	@FindBy(xpath = "//h4[contains(text(),'Plan Compare')]//parent::div//input[@name='plancompareZIPcode']")
	private WebElement planCompZIPcode;

	@FindBy(xpath = "//h4[contains(text(),'Plan Compare')]//parent::div//input[@name='plancompareplans']")
	private WebElement planCompPlans;

	@FindBy(xpath = "//h4[contains(text(),'Plan Compare')]//parent::div//input[@name='plancompareplanyear']")
	private WebElement planCompPlanYear;

	@FindBy(xpath = "//h4[contains(text(),'Plan Compare')]//parent::div//input[@name='plancomparefipscounty']")
	private WebElement planCompFisCounty;

	@FindBy(xpath = "//h4[contains(text(),'Plan Compare')]//parent::div//input[@name='plancompareexpirydate']")
	private WebElement planCompexpirydate;

	@FindBy(xpath = "//h4[contains(text(),'Plan Compare')]//parent::div//input[@name='plancompareproduct']")
	private WebElement planCompProduct;

	@FindBy(xpath = "//h4[contains(text(),'Plan Compare')]//parent::div//input[@name='plancomparewtmcid']")
	private WebElement planCompWtmcid;

	@FindBy(xpath = "//h4[contains(text(),'Plan Compare')]//parent::div//input[@name='plancomparemcrid']")
	private WebElement planCompMcrid;

	@FindBy(xpath = "//button[contains(@ng-click,'plancompare')]")
	private WebElement planCompCreateButton;

	@FindBy(xpath = "//h4[contains(text(),'Plan Details')]//parent::div//input[@name='plandetailsZIPcode']")
	private WebElement planDetailsZipCode;

	@FindBy(xpath = "//h4[contains(text(),'Plan Details')]//parent::div//input[@name='plandetailsplanids']")
	private WebElement planDetailsPlanIds;

	@FindBy(xpath = "//h4[contains(text(),'Plan Details')]//parent::div//input[@name='plandetailsplanyear']")
	private WebElement planDetailsPlanYear;

	@FindBy(xpath = "//h4[contains(text(),'Plan Details')]//parent::div//input[@name='plandetailssysyear']")
	private WebElement planDetailsPlanSYSYear;

	@FindBy(xpath = "//h4[contains(text(),'Plan Details')]//parent::div//input[@name='plandetailsdeeplink']")
	private WebElement planDetailsDeepLink;

	@FindBy(xpath = "//h4[contains(text(),'Plan Details')]//parent::div//input[@name='plandetailsmrcid']")
	private WebElement planDetailsMrcid;

	@FindBy(xpath = "//h4[contains(text(),'Plan Details')]//parent::div//input[@name='plandetailsfips']")
	private WebElement planDetailsFips;

	@FindBy(xpath = "//h4[contains(text(),'Plan Details')]//parent::div//input[@name='plandetailsyeardis']")
	private WebElement planDetailsYearID;

	@FindBy(xpath = "//h4[contains(text(),'Plan Details')]//parent::div//input[@name='plandetailsmonth']")
	private WebElement planDetailsMonth;

	@FindBy(xpath = "//h4[contains(text(),'Plan Details')]//parent::div//input[@name='plandetailsyeartoggle']")
	private WebElement planDetailsYearToggle;

	@FindBy(xpath = "//h4[contains(text(),'Plan Details')]//parent::div//input[@name='plandetailswtmcid']")
	private WebElement planDetailsWtmcid;

	@FindBy(xpath = "//button[contains(@ng-click,'plandetails')]")
	private WebElement planDetailsCreateButton;

	@FindBy(id = "backtoplansummarypage")
	private WebElement backToAllPlansLink;

	@FindBy(xpath = "//h4[contains(text(),'Plan Selector')]//parent::div//input[@name='contractnumber']")
	private WebElement planSelectorcontractnumber;

	@FindBy(xpath = "//h4[contains(text(),'Plan Selector')]//parent::div//input[@name='countycode']")
	private WebElement planSelectorcountycode;

	@FindBy(xpath = "//h4[contains(text(),'Plan Selector')]//parent::div//input[@name='pbpnumber']")
	private WebElement planSelectorpbpnumber;

	@FindBy(xpath = "//h4[contains(text(),'Plan Selector')]//parent::div//input[@name='wtsrch']")
	private WebElement planSelectorwtsrch;

	@FindBy(xpath = "//h4[contains(text(),'Plan Selector')]//parent::div//input[@name='segmentid']")
	private WebElement planSelectorsegmentid;

	@FindBy(xpath = "//h4[contains(text(),'Plan Selector')]//parent::div//input[@name='planselectoryear']")
	private WebElement planSelectorplanselectoryear;

	@FindBy(xpath = "//h4[contains(text(),'Plan Selector')]//parent::div//input[@name='ZIPcode']")
	private WebElement planSelectorZIPcode;

	@FindBy(xpath = "//h4[contains(text(),'Plan Selector')]//parent::div//input[@name='wtmcid']")
	private WebElement planSelectorwtmcid;

	@FindBy(xpath = "//h4[contains(text(),'Plan Selector')]//parent::div//input[@name='usergroup']")
	private WebElement planSelectorusergroup;

	@FindBy(xpath = "//button[contains(@ng-click,'planselector')]")
	private WebElement planSelectorCreateButton;

	@FindBy(xpath = "//h4[contains(text(),'Medsup Deeplink')]//parent::div//input[@name='medsupZIPcode']")
	private WebElement MedsupZipcode;

	@FindBy(xpath = "//h4[contains(text(),'Medsup Deeplink')]//parent::div//input[@name='medsupproduct']")
	private WebElement MedsupProduct;
	@FindBy(xpath = "//h4[contains(text(),'Medsup Deeplink')]//parent::div//input[@name='ebrc']")
	private WebElement MedsupEbrc;
	@FindBy(xpath = "//h4[contains(text(),'Medsup Deeplink')]//parent::div//input[@name='intref']")
	private WebElement MedsupIntref;
	@FindBy(xpath = "//h4[contains(text(),'Medsup Deeplink')]//parent::div//input[@name='mpbed']")
	private WebElement MedsupBED;
	@FindBy(xpath = "//h4[contains(text(),'Medsup Deeplink')]//parent::div//input[@name='dpsd']")
	private WebElement MedsupPSD;
	@FindBy(xpath = "//h4[contains(text(),'Medsup Deeplink')]//parent::div//input[@name='mpaed']")
	private WebElement MedsupAED;
	@FindBy(xpath = "//h4[contains(text(),'Medsup Deeplink')]//parent::div//input[@name='medsupwtmcid']")
	private WebElement MedsupMCID;
	@FindBy(xpath = "//h4[contains(text(),'Medsup Deeplink')]//parent::div//input[@name='dob']")
	private WebElement MedsupDOB;

	@FindBys(value = { @FindBy(xpath = "//select[@id='medsupuri']/option") })
	private List<WebElement> urlValues;
	@FindBys(value = { @FindBy(xpath = "//select[@id='gendercode']/option") })
	private List<WebElement> genderValues;
	@FindBys(value = { @FindBy(xpath = "//select[@id='tobaccouser']/option") })
	private List<WebElement> userValues;

	@FindBy(xpath = "//button[contains(@ng-click,'medsup')]")
	private WebElement medsupCreateButton;

	@FindBy(xpath = "//div[@id='Plan F']//h2")
	private WebElement medsupPlanF;

	@FindBy(xpath = "//input[@id='vpp-zip-search']")
	private WebElement providerZipInput;

	@FindBy(xpath = "//input[@id='vpp-planid']")
	private WebElement providerPlanID;

	@FindBy(xpath = "//input[@id='vpp-planYear']")
	private WebElement ProviderYear;

	@FindBy(xpath = "//button[text()='Go']")
	private WebElement ProviderGo;

	@FindBy(xpath = "//button[@id='launch_vpp']")
	private WebElement ProviderLaunchVPP;

	@FindBy(xpath = "//input[@id='helperModeCheckboxLaunchVpp']")
	private WebElement scen4Helper;

	@FindBy(xpath = "//a[text()='Launch VPP with Providers data']")
	private WebElement launchVPPwithProvidersdata;

	@FindBy(xpath = "//input[contains(@ng-model, 'Zip')]")
	public WebElement ZipCode;

	@FindBy(xpath = "//button[contains(@type ,'submit') and contains(text(), 'Search')]")
	public WebElement ZipSearch;

	@FindBy(xpath = "//select[contains(@id ,'dce-county-select')]")
	public WebElement CountyDropDown;

	@FindBy(xpath = "//select[contains(@id ,'plan-select')]")
	public WebElement PlanDropDown;

	@FindBy(xpath = "//button[contains(@type ,'submit') and contains(text(), 'DCE')]")
	public WebElement DCEbutton_StartDCE;

	@FindBy(xpath = "//input[@id='helperModeCheckbox1']")
	private WebElement scen3HelperDCE;

	@FindBy(xpath = "//a[text()='Redirect to VPP from DCE']")
	private WebElement redirecttoVPPfromDCE;

	public VPPTestHarnessPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// CommonUtility.waitForPageLoad(driver, ZipCode, 10);
		try {
			openAndValidate();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void openAndValidate() throws InterruptedException {
		// validateNew(ZipCode);
		// validateNew(ZipSearch);
	}

	public void enterVppZipcode(String zipcode) {
		validateNew(enterVppzipcode);
		sendkeys(enterVppzipcode, zipcode);
		enterVppGoButton.click();
	}

	public void enterAddressDetails(String address, String city, String state) {
		validateNew(lookupZipcodeLink);
		lookupZipcodeLink.click();
		validateNew(addressInput);
		sendkeys(addressInput, address);
		sendkeys(cityInput, city);
		selectFromDropDown(stateDropDownValues, state.toUpperCase());
		lookupSearchButton.click();
		validateNew(enterVppGoButton);
		enterVppGoButton.click();

	}

	public void SelectCounty(String countyName) {
		if (validate(countyModal)) {
			CommonUtility.waitForPageLoad(driver, countyModal, 45);
			System.out.println("County should be selected : " + countyName);
			driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")).click();
			CommonUtility.waitForPageLoadNew(driver, vppTop, 35);

		} else {
			System.out.println("No County to be selected ");
		}

	}

	public VPPPlanSummaryPage navigateToVPP() {
		validateNew(vppTop);
		CommonUtility.waitForPageLoad(driver, vppTop, 30);
		return new VPPPlanSummaryPage(driver);
	}

	public VPPPlanSummaryPage navigateToShopPlanenterZipcodeToVPP(String zipcode, String countyName,
			String isMultiCounty) {
		validateNew(enterVppzipcode);
		enterVppGoButton.click();
		CommonUtility.waitForPageLoadNew(driver, shopForAPlanOptionZipcodeFieldBox, 35);
		validateNew(shopForAPlanOptionZipcodeFieldBox);
		shopForAPlanOptionZipcodeFieldBox.sendKeys(zipcode);
		shopForAPlanOptionFindPlanButton.click();
		SelectCounty(countyName);
		if (driver.findElement(By.xpath("//*[contains(text(),'" + zipcode + " " + countyName + "')]")).isDisplayed()) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public void enterZipcodeforPlanSummaryDeepLink(String zipcode) {
		validateNew(planSummaryZIP);
		sendkeys(planSummaryZIP, zipcode);
		validateNew(planSummaryCreateButton);
		jsClickNew(planSummaryCreateButton);
		validateNew(createDeepLinkURL);
		System.out.println("Genertated Deeplink url : " + createDeepLinkURL.getText());
		jsClickNew(createDeepLinkURL);
	}

	public void enterEmailPlanSummaryDeepLink(String zipcode, String DeepLink, String PlanType, String PlayYear) {
		validateNew(planSummZipCode);
		sendkeys(planSummZipCode, zipcode);
		sendkeys(planSummDeepLink, DeepLink);
		sendkeys(planSummPlanType, PlanType);
		sendkeys(planSummYear, PlayYear);
		validateNew(planSummCreateButton);
		jsClickNew(planSummCreateButton);

		validateNew(createDeepLinkURL);
		System.out.println("Genertated Deeplink url : " + createDeepLinkURL.getText());
		jsClickNew(createDeepLinkURL);
	}

	public void enterEmailPlanCompareDeepLink(String zipcode, String Plans, String ExpDate, String product,
			String PlanYear, String fiscountyCode) {
		validateNew(planCompZIPcode);
		sendkeys(planCompZIPcode, zipcode);
		sendkeys(planCompPlans, Plans);
		sendkeys(planCompPlanYear, PlanYear);
		sendkeys(planCompFisCounty, fiscountyCode);
		sendkeys(planCompexpirydate, ExpDate);
		sendkeys(planCompProduct, product);

		validateNew(planCompCreateButton);
		jsClickNew(planCompCreateButton);

		validateNew(createDeepLinkURL);
		System.out.println("Genertated Deeplink url : " + createDeepLinkURL.getText());
		jsClickNew(createDeepLinkURL);
	}

	public void enterEmailPlanDetailsDeepLink(String zipcode, String hnpbp, String PlanYear, String DeepLink,
			String fiscountyCode) {
		validateNew(planDetailsZipCode);
		sendkeys(planDetailsZipCode, zipcode);
		sendkeys(planDetailsPlanIds, hnpbp);
		sendkeys(planDetailsPlanYear, PlanYear);
		sendkeys(planDetailsDeepLink, DeepLink);
		sendkeys(planDetailsFips, fiscountyCode);
		validateNew(planDetailsCreateButton);
		jsClickNew(planDetailsCreateButton);

		validateNew(createDeepLinkURL);
		System.out.println("Genertated Deeplink url : " + createDeepLinkURL.getText());
		jsClickNew(createDeepLinkURL);
	}

	public void enterEmailPlanSelectorDeepLink(String contractnum, String countyCode, String pbpnumber, String segId,
			String year, String zipcode, String usergroup, String Mutlicounty, String countyName)
			throws InterruptedException {
		validateNew(planSelectorcontractnumber);
		sendkeys(planSelectorcontractnumber, contractnum);
		sendkeys(planSelectorcountycode, countyCode);
		sendkeys(planSelectorpbpnumber, pbpnumber);
		sendkeys(planSelectorsegmentid, segId);
		sendkeys(planSelectorplanselectoryear, year);
		sendkeys(planSelectorZIPcode, zipcode);
		sendkeys(planSelectorusergroup, usergroup);

		validateNew(planSelectorCreateButton);
		jsClickNew(planSelectorCreateButton);

		validateNew(createDeepLinkURL);
		System.out.println("Genertated Deeplink url : " + createDeepLinkURL.getText());
		jsClickNew(createDeepLinkURL);
		Thread.sleep(10000);
		if (Mutlicounty.equalsIgnoreCase("YES")) {
			CommonUtility.waitForPageLoad(driver, countyModal, 45);
			System.out.println("County should be selected : " + countyName);
			driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")).click();
			Thread.sleep(10000);
			driver.getCurrentUrl().contains("#/details");

		} else {
			System.out.println("No County to be selected ");

		}

	}

	public void enterMedSupDetailsDeepLink(String zipcode, String ebrc, String intref, String mpbed, String dpsd,
			String mpaed, String dob, String uri, String genderCode, String tobaccoUser) {
		validateNew(planDetailsZipCode);
		sendkeys(MedsupZipcode, zipcode);
		sendkeys(MedsupEbrc, ebrc);
		sendkeys(MedsupIntref, intref);
		sendkeys(MedsupBED, mpbed);
		sendkeys(MedsupPSD, dpsd);
		sendkeys(MedsupAED, mpaed);
		sendkeys(MedsupDOB, dob);
		selectFromDropDown(urlValues, uri);
		selectFromDropDown(genderValues, genderCode);
		selectFromDropDown(userValues, tobaccoUser);
		validateNew(medsupCreateButton);
		jsClickNew(medsupCreateButton);

		validateNew(createDeepLinkURL);
		System.out.println("Genertated Deeplink url : " + createDeepLinkURL.getText());
		jsClickNew(createDeepLinkURL);
	}

	public ComparePlansPage navigateToPlanCompare() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			validate(backToAllPlansLink);
		return new ComparePlansPage(driver);
	}

	public PlanDetailsPage navigateToPlanDetails() {

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("#/details")) {
			return new PlanDetailsPage(driver);
		}
		return null;
	}

	public void navigateToMedSupPlans() {

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("medicare-supplement-plans")) {
			System.out.println("Medsup plans loaded");
		}

	}

	public void validateMedSupSpecificPlanInfo(String PlanName) throws InterruptedException {
		Assert.assertTrue("Not anble to See medsup plan", medsupPlanF.getText().contains(PlanName));
		System.out.println("Validate we are on medsup page from deeplink");

	}

	public ProviderSearchPage enterMandatoryFieldsToProviderSearch(String zipcode, String planId, String planyear)
			throws Exception {
		CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();
		validateNew(providerZipInput);
		sendkeys(providerZipInput, zipcode);
		sendkeys(providerPlanID, planId);
		sendkeys(ProviderYear, planyear);
		validateNew(ProviderGo);
		switchToNewTabNew(ProviderGo);
		if (driver.getCurrentUrl().contains("werally")) {
			return new ProviderSearchPage(driver);
		}
		return null;
	}

	public void clickOnLaunchVVP() {
		validateNew(ProviderLaunchVPP);
		ProviderLaunchVPP.isEnabled();
		ProviderLaunchVPP.click();
	}

	public void navigatetoVPPwithProvidersdata() throws Exception {
		validateNew(scen4Helper);
		jsClickNew(scen4Helper);
		validate(launchVPPwithProvidersdata);
		jsClickNew(launchVPPwithProvidersdata);
	}

	public void enterZipandSearch(String ZIP) {
		ZipCode.sendKeys(ZIP);
		jsClickNew(ZipSearch);
	}

	public void SelectCountyDCE(String countyName) {
		validateNew(CountyDropDown);
		jsClickNew(CountyDropDown);
		WebElement CountySelection = driver.findElement(By.xpath("//option[contains(text(), '" + countyName + "')]"));
		CountySelection.click();

	}

	public void selectPlan(String planName) {
		validateNew(PlanDropDown);
		jsClickNew(PlanDropDown);
		WebElement CountySelection = driver.findElement(By.xpath("//option[contains(text(), '" + planName + "')]"));
		CountySelection.click();
	}

	public void redirecttoVPPfromDCE() throws Exception {
		validateNew(scen3HelperDCE);
		jsClickNew(scen3HelperDCE);
		validate(redirecttoVPPfromDCE);
		jsClickNew(redirecttoVPPfromDCE);
	}

}