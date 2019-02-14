package pages.acquisition.bluelayer;

/*@author pagarwa5*/

import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import junit.framework.Assert;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.ole.WelcomePage;
import pages.acquisition.ulayer.PageTitleConstants;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class AcquisitionHomePage extends GlobalWebElements {

	@FindBy(id = "lookzip")
	private WebElement lookupZipcode;
	
	@FindBy(id = "takequizbtn")
	private WebElement takequizbtn;

	@FindBy(id = "compareplans")
	private WebElement compareplans;

	@FindBys(value = { @FindBy(xpath = "//ul[@id='topic-selectSelectBoxItOptions']/li") })
	private List<WebElement> topicDropDownValues;

	@FindBy(id = "topic-selectSelectBoxIt")
	private WebElement selectSelectBoxIt;

	@FindBy(id = "picktopicbtn")
	private WebElement picktopicbtn;

	@FindBy(id = "cta-zipcode")
	private WebElement zipCodeField;

	@FindBy(id = "zipcodebtn")
	private WebElement viewPlansButton;

	@FindBy(xpath = "//div[@id='ipeL']/div[2]/map/area[3]")
	private WebElement popUpcloseLink;

	@FindBy(xpath = "//div[@class='modal-title']")
	private WebElement countyModal;

	@FindBy(id = "ipeL")
	private WebElement feedBackPopUp;

	@FindBy(id = "dce")
	private WebElement prescriptionsLink;

	@FindBy(id = "learn-zipcode")
	private WebElement learnzipCodeField;

	@FindBy(xpath = "//*[@id='subnav_2']/div/div/div[1]/div[1]/div[2]/h3/a/span")
	private WebElement pdpVppLink;

	@FindBy(id = "learnfindplanBtn")
	private WebElement learnfindPlansButton;

	@FindBy(xpath = "//*[@id='planTypesColumn']/h3[1]/a")
	private WebElement ma_moreHelpInfoLink;

	@FindBy(xpath = "//a[contains(text(),'Request More')]")
	private WebElement moreHelpInfoLink;

	@FindBy(xpath = "//a[contains(text(),'Request More Help')]")
	private WebElement pdp_moreHelpInfoLink;

	@FindBys(value = { @FindBy(xpath = "//table[@id='selectcountytable']/tbody/tr/td") })
	List<WebElement> countyRows;

	@FindBy(linkText = "View all disclaimer information")
	private WebElement disclaimerViewLink;

	@FindBy(id = "Find a pharmacy near you")
	private WebElement pharmacyNearLink_MA;

	@FindBy(id = "Find a pharmacy near you")
	private WebElement findPharmacyNearYou;

	@FindBy(id = "Find a pharmacy near you")
	private WebElement pharmacyNearLink;

	@FindBy(className = "disclaimer hideLink")
	private WebElement disclaimerHideLink;

	@FindBy(id = "medicareTitle")
	private WebElement medicareTitleText;
	@FindBy(className = "fd_myPlans")
	private WebElement myPlansTab;

	@FindBy(id = "ghn_lnk_2")
	private WebElement ourPlans;
	
	@FindBy(xpath = "//*[@id='ghn_lnk_2']")
	private WebElement OurPlansLink1;

	@FindBy(id = "ghn_lnk_1")
	private WebElement Home;

	@FindBy(xpath = "//*[@id='subnav_2']/div/div/div[1]/div[1]/div[2]/h3/a/span")
	private WebElement maVppLink;

	@FindBy(id = "findazip_box")
	private WebElement zipCodeSearchPopup;
	
	@FindBy(id = "nav-zipcode")
	private WebElement OurPlans_zipfield;
	
	@FindBy(xpath = "//*[@id = 'nav-zipcode']/following-sibling::button[@class = 'zip-button']")
	public WebElement OurPlans_viewPlansButton;

	@FindBy(xpath = "//div[@id='findazip_box']/div/div/div/h4")
	private WebElement zipCodeSearchPopupHeading;

	@FindBy(id = "cobrowse-disclaimer")
	private WebElement cobrowsemodelwindow;

	/*@FindBy(xpath = "//a[@class='cta-button']")
	private WebElement takeTheQuizBtn;*/
	
	@FindBy(xpath = "//a[contains(text(), 'Plan Selector')]")
	private WebElement takeTheQuizBtn;
	
	@FindBy(xpath = ".//*[@id='colhowdoesthiswork_dce']//*[@itemprop='significantLink']/*[@class='cta-button secondary']")
	public WebElement getStarted;

	@FindBy(xpath = "//div[@id='subnav_2']//h3/a[contains(text(),'Pharmacy')]")
	private WebElement pharmacysearchbtn;

	@FindBy(xpath = ".//*[@id='change-location']")
	private WebElement changeLocationLink;

	@FindBy(xpath = ".//*[@id='collapse2heading_article_mededaccordion0']")
	private WebElement requestAgentApptDropdown;

	@FindBy(id = "js-ole-zip-search")
	private WebElement StandaloneZipcode;

	@FindBy(xpath = "//*[@id='js-ole-zip-search']/following-sibling::button")
	private WebElement StandalonSearch;

	@FindBy(xpath = "//*[@id='js-ole-plan-result']/button")
	private WebElement StandaloneVPP;

	@FindBy(xpath = "//*[@id='js-ole-plan-select']//optgroup[2]/option[1]")
	private WebElement StandaloneSNPoptions;	

	@FindBy(xpath = "//*[@class='btn--bottom']")
	private WebElement StandalonSearchCounty;

	@FindBy(xpath = "//*[@class='container meded-article-header']/h1']")
	private WebElement MALandingHeading;

	@FindBy(xpath = "//*[@id='planTypesColumn']/h3[1]/a")
	private WebElement MALandingLink;

	@FindBy(xpath = "//*[@id='planTypesColumn']/h3[2]/a")
	private WebElement PDPLandingLink;

	/*
	 * @FindBy(id = "vpp_selectcounty_box") private WebElement countyModal;
	 */

	@FindBy(id = "zipcode")
	private WebElement zipCodeF;

	@FindBy(className = "textalign")
	private WebElement countyModal1;

	@FindBy(xpath = "//*[@id='js-ole-plan-select']//optgroup[1]/option[@value=0]")
	private WebElement selectFirstOptionOnPlanSelect;

	@FindBy(xpath = "//*[@id='js-ole-plan-select']//following::button")
	private WebElement enrollButton;

	@FindBy(xpath = "//*[@class='textalign']//p[2]/a")
	private WebElement county;

	@FindBy(xpath = "//*[@id='ole-county-select']/option[@value=1]")
	private WebElement countyDropdown;

	@FindBy(xpath = "//*[@id='ghn_lnk_2']")
	private WebElement OurPlans;

	@FindBy(xpath = "(//*[@class='zip-button'])[2]")
	private WebElement GoButton;

	@FindBy(xpath="//div[contains(@class,'proactive-offer__close')]")
	public static List<WebElement> proactiveChatExistBtn;
	
	@FindBy(xpath = "//div[@class='overview-main']/h2")
	private WebElement vppTop;
	
	
	@FindBy(id = "cobrowse-disclaimer")
	private List<WebElement> requestAssistanceModal;
	
	@FindBy(xpath = "//div[@id='cobrowse-disclaimer']//*[contains(@class,'modal-title')]")
	private WebElement requestAssistanceTitle;
	
	@FindBy(id = "correlationId")
	private WebElement requestAssistanceAgentID;
	
	@FindBy(xpath = "//a[contains(@class,'closer')]")
	private WebElement requestAssistanceClose;

	/* LearnAboutMedicare link */
	@FindBy(xpath = "//*[@id='ghn_lnk_3']")
	private WebElement lnkLearnAboutMedicare;

	public JSONObject homePageDisclaimerJson;
	public JSONObject homePageDisclaimerHideJson;

	public JSONObject globalFooterJson;

	public JSONObject globalHeaderJson;

	private PageData alreadyPlanMember;
	public JSONObject alreadyPlanMemberJson;

	private PageData medicareEducationDropDown;
	public JSONObject medicareEducationDropDownJson;

	private PageData ourPlansNav;
	public JSONObject ourPlansNavJson;

	public JSONObject browserCheckJson;

	private PageData cobrowseData;
	public JSONObject cobrowseJson;
	private static String UMS_ACQISITION_PAGE_URL = MRConstants.UHC_URL;
	private static String UMS_ACQISITION_OFFLINE_PAGE_URL = MRConstants.UHC_URL_OFFLINE;
	private static String AARP_ACQISITION_PAGE_URL = MRConstants.AARP_URL;
	private static String AARP_ACQISITION_OFFLINE_PAGE_URL = MRConstants.AARP_URL_OFFLINE;

	public AcquisitionHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	

	public AcquisitionHomePage(WebDriver driver, boolean alreadyOnSite) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(alreadyOnSite);
	}

	public AcquisitionHomePage(WebDriver driver, String string) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(string);
	}

	@SuppressWarnings("deprecation")
	public void openAndValidate(boolean alreadyOnSite) {
		if (alreadyOnSite) {
			
		CommonUtility.checkPageIsReadyNew(driver);
		checkModelPopup(driver);
		CommonUtility.waitForPageLoadNew(driver, zipCodeField, 45);
		if(proactiveChatExistBtn.size()!=0)
			jsClickNew(proactiveChatExistBtn.get(0));
		}
		else {
			Assert.fail("Please check booleanvalue");
		}
		
	}
	public DrugCostEstimatorPage navigateToDCEToolFromHome() throws InterruptedException {
		validateNew(getStarted);
		getStarted.click();

		if (driver.getCurrentUrl().contains("health-plans/estimate-drug-costs.html"))
			return new DrugCostEstimatorPage(driver);
		return null;
	}

	public ZipcodeLookupHomePage looksupforZipcodes() {

		lookupZipcode.click();

		CommonUtility.waitForPageLoad(driver, zipCodeSearchPopup, CommonConstants.TIMEOUT_30);
		if (zipCodeSearchPopupHeading.getText().equalsIgnoreCase("Find a ZIP code")) {
			System.out.println("zipCodeSearchPopupHeading");
			return new ZipcodeLookupHomePage(driver);
		}
		return null;

	}

	public SiteMapUMSPage siteMapFooterClick() {
		validateNew(footerSiteMapLink);
		footerSiteMapLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("sitemap.html")){
			return new SiteMapUMSPage(driver);
		}
		return null;

	}

	@Override
	public void openAndValidate() {
		if (MRScenario.environment.equals("offline")) {
			start(UMS_ACQISITION_OFFLINE_PAGE_URL);
		} else {
			start(UMS_ACQISITION_PAGE_URL);
		}
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, navigationSectionHomeLink, 45);
	}
	
	
	public void openAndValidate(String Ulayer) {
		if (MRScenario.environment.equals("offline")) {
			startNew(AARP_ACQISITION_PAGE_URL);
		} else {
			startNew(AARP_ACQISITION_PAGE_URL);
		}
		CommonUtility.checkPageIsReadyNew(driver);
		checkModelPopup(driver);
		CommonUtility.waitForPageLoadNew(driver, navigationSectionHomeLink, 45);
	}
	
	

	  public VPPPlanSummaryPage searchPlans(String zipcode, String countyName){
		CommonUtility.waitForPageLoad(driver, zipCodeField, 20);
		sendkeys(zipCodeField, zipcode);
		viewPlansButton.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {

			if (countyModal.isDisplayed()) {
				driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")).click();
			}
			System.out.println("countyModal.getText() " + countyModal.getText());
			;
		} catch (Exception e) {
			System.out.println("county box not found");
		}
		// try {
		// if (countyModal.isDisplayed()) {
		// for (WebElement county : countyRows) {
		// if (county.getText().equalsIgnoreCase(countyName)) {
		// county.click();
		// break;
		// }
		//
		// }
		// }
		// } catch (Exception e) {
		// System.out.println("county box not found");
		// }
		try {
			if (countyModal.isDisplayed()) {
				for (WebElement county : countyRows) {
					if (county.getText().equalsIgnoreCase(countyName)) {
						county.click();
						break;
					}

				}
			}
		} catch (Exception e) {
			System.out.println("county box not found");
		}
		
		//CommonUtility.waitForPageLoad(driver, changeLocationLink, 60);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new pages.acquisition.bluelayer.VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public pages.acquisition.bluelayer.VPPPlanSummaryPage searchPlans(String zipcode) {
		sendkeys(zipCodeField, zipcode);
		viewPlansButton.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_PLAN_TYPES_TITLE)) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public VPPPlanSummaryPage searchPlansForLearnFindPlans(String zipcode, String countyName) {
		sendkeys(learnzipCodeField, zipcode);
		learnfindPlansButton.click();
		try {
			if (countyModal.isDisplayed()) {
				for (WebElement county : countyRows) {
					if (county.getText().equalsIgnoreCase(countyName)) {
						county.click();
						break;
					}

				}
			}
		} catch (Exception e) {
			System.out.println("county box not found");
		}
		if (getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_PLAN_TYPES_TITLE)) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public String selectsHomeFooter() {
		// TODO Auto-generated method stub
		return null;
	}

	public MedicareAdvantagePlansuhcPage medicareAdvantagePlansClick() {
		validate(medicareAdvantagePlansLink);
		medicareAdvantagePlansLink.click();
		validate(medicareAdvantagePlansLink);
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_ADVANTAGE_PLANS)) {
			return new MedicareAdvantagePlansuhcPage(driver);
		}

		return null;
	}

	public AcquisitionHomePage veiwAllDisclaimerLinkSectionLinksClick() {
		validate(GlobalWebElements.viewAllDisclaimerInformationLink);
		GlobalWebElements.viewAllDisclaimerInformationLink.click();

		validate(GlobalWebElements.disclaimerBackToTopLink);
		GlobalWebElements.disclaimerBackToTopLink.click();

		validate(GlobalWebElements.viewAllDisclaimerInformationLink);
		GlobalWebElements.viewAllDisclaimerInformationLink.click();

		validate(GlobalWebElements.hideDiscliamerInformation);
		GlobalWebElements.hideDiscliamerInformation.click();
		if (driver.getTitle().equalsIgnoreCase("Medicare Plans for Different Needs | UnitedHealthcare®")) {
			return new AcquisitionHomePage(driver);
		}
		return null;
	}

	public DisclaimersPage importantDisclaimersClick() {
		validate(importantDisclosuresLink);
		importantDisclosuresLink.click();
		validate(importantDisclosuresLink);
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_DISCLAIMERS)) {
			return new DisclaimersPage(driver);
		}
		return null;
	}

	public AcquisitionHomePage navigationSectionHomeLinkClick() {
		validate(navigationSectionHomeLink);
		navigationSectionHomeLink.click();
		validate(navigationSectionHomeLink);
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_PLANS_FOR_DIFFERENT_NEEDS)) {
			return new AcquisitionHomePage(driver);
		}

		return null;
	}

	public Boolean navigationSectionEnterSearchClick() {
		validate(navigationSectionEnterSearch);
		navigationSectionEnterSearch.click();
		navigationSectionEnterSearch.sendKeys("home");
		String search = navigationSectionEnterSearch.getAttribute("value");
		if (search.equalsIgnoreCase("home")) {
			return true;
		}

		return false;
	}

	public Boolean validate_alreadyPlanMemberButton_inactive() {

		return validate(alreadyPlanMemberButtonInactive);
	}

	public Boolean validate_alreadyPlanMemberButton_active() {
		validate(alreadyPlanMemberButton);
		alreadyPlanMemberButton.click();
		return validate(alreadyPlanMemberButtonActive);
	}

	public JSONObject getAlreadyPlanMemberJSON() {
		String fileName = CommonConstants.ALREADY_PLAN_MEMBER_PAGE_DATA;
		alreadyPlanMember = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : alreadyPlanMember.getExpectedData().keySet()) {
			WebElement element = findElement(alreadyPlanMember.getExpectedData().get(key));
			if (element != null) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		alreadyPlanMemberJson = jsonObject;

		return alreadyPlanMemberJson;
	}

	public Boolean validate_textField() {
		validate(usernameField);
		usernameField.click();
		usernameField.sendKeys("q1blayer");
		String user = usernameField.getAttribute("value");
		validate(passwordField);
		passwordField.click();
		passwordField.sendKeys("Password");
		String pass = passwordField.getAttribute("value");
		if (user.equalsIgnoreCase("q1blayer") && pass.equalsIgnoreCase("Password")) {
			return true;
		}
		return false;
	}

	public LoginAssistancePage forgotUsernamePasswordClick() {
		validate(forgotUsernameLink);
		forgotUsernameLink.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		validate(medicareTitleText);
		if (driver.getTitle()
				.equalsIgnoreCase("UnitedHealthcare Medicare Solutions |Username and Password Assistance")) {
			return new LoginAssistancePage(driver);
		}
		return null;

	}

	public VPPPlanSummaryPage enterZipcode(String zipCode, String county, String planYear) {
		sendkeys(zipCodeField, zipCode);
		viewPlansButton.click();
		return new VPPPlanSummaryPage(driver);
	}

	public RegistrationHomePage registerHereLinkClick() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		/*
		 * validate(alreadyPlanMemberButton); alreadyPlanMemberButton.click();
		 */
		validate(registerHereLink);
		registerHereLink.click();
		ArrayList<String> tabs1 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs1.get(2));
		validate(medicareTitleText);
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_SOLUTIONS_REGISTRATION)) {
			return new RegistrationHomePage(driver);
		}
		return null;
	}

	public JSONObject accessingOurPlansNav() {
		ourPlansHover();
		return getOurPlanDropDownJson();
	}

	public JSONObject getOurPlanDropDownJson() {
		String fileName = CommonConstants.OUR_PLANS_NAV_PAGE_DATA;
		ourPlansNav = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : ourPlansNav.getExpectedData().keySet()) {
			WebElement element = findElement(ourPlansNav.getExpectedData().get(key));
			if (element != null) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		ourPlansNavJson = jsonObject;

		return ourPlansNavJson;
	}

	public JSONObject accessMedicareEducationDropDown() {

		validate(navigationSectionMedicareEducationLink);

		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
		actions.moveToElement(navigationSectionMedicareEducationLink);
		actions.moveToElement(learnAboutMedicareMedicareEducationLink);
		actions.perform();
		String fileName = CommonConstants.MEDICARE_EDUCATION_SECTION_DATA;
		medicareEducationDropDown = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : medicareEducationDropDown.getExpectedData().keySet()) {
			WebElement element = findElement(medicareEducationDropDown.getExpectedData().get(key));
			if (element != null) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		medicareEducationDropDownJson = jsonObject;

		return medicareEducationDropDownJson;
	}

	public JSONObject enterZipCode(String zipCode) {
		ourPlansHover();
		validate(zipcodeField);
		zipcodeField.sendKeys(zipCode);
		findPlansButton.click();
		return getOurPlanDropDownJson();

	}

	public LearnAboutMedicareuhcPage learnAboutMedicareClick() {
		validate(navigationSectionMedicareEducationLink);
		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
		actions.moveToElement(navigationSectionMedicareEducationLink);
		actions.moveToElement(learnAboutMedicareMedicareEducationLink);
		actions.click().build().perform();
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_LEARN_ABOUT_MEDICARE)) {
			return new LearnAboutMedicareuhcPage(driver);
		}

		return null;
	}

	public MedicareAdvantagePlansuhcPage headerMedicareAdvantageClick() {
		ourPlansHover();
		validate(headerMedicareAdvantagePlansLink);
		headerMedicareAdvantagePlansLink.click();
		validate(headerMedicareAdvantagePlansLink);
		if (driver.getTitle().equalsIgnoreCase("Medicare Advantage Plans | UnitedHealthcare®")) {
			return new MedicareAdvantagePlansuhcPage(driver);
		}
		return null;
	}

	public void navigateToRequestMoreHelpAndInformation(String planType) {
		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
		actions.moveToElement(ourPlansHoverLink);
		actions.moveToElement(moreHelpInfoLink);
		actions.click().build().perform();

		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (driver.getCurrentUrl().contains("request-information"))
				break;
		}

	}

	public PharmacySearchPage navigateToPharmacyLocator() {
		Actions action = new Actions(driver);
		PageFactory.initElements(driver, this);
		action.moveToElement(navigationSectionHomeLink).moveToElement(ourPlansHoverLink).build().perform();
		pharmacysearchbtn.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().toLowerCase().contains(PageTitleConstants.BLAYER_LOCATE_A_PHARMACY_UNITEDHEALTHCARE.toLowerCase())) {
			return new PharmacySearchPage(driver);
		}
		return null;

	}

	public MedicareSpecialNeedsPlansuhcPage medicareSpecialNeedPlansLinkClick() {
		ourPlansHover();
		validate(headerMedicareSpecialNeedPlansLink);
		headerMedicareSpecialNeedPlansLink.click();
		validate(headerMedicareSpecialNeedPlansLink);
		if (driver.getTitle().equalsIgnoreCase("Medicare Special Needs Plans | UnitedHealthcare®")) {
			return new MedicareSpecialNeedsPlansuhcPage(driver);
		}
		return null;
	}

	public OurPlansPage findPlanButtonClick(String zipCode) {
		ourPlansHover();
		validate(zipcodeField);
		zipcodeField.sendKeys(zipCode);
		findPlansButton.click();
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_PLAN_TYPES_TITLE)) {
			return new OurPlansPage(driver);
		}
		return null;
	}

	public Boolean enterInvalidUserNamePassword() {
		validate(usernameField);
		usernameField.click();
		usernameField.sendKeys("");
		// usernameField.sendKeys(givenAttributesRow.get(0).getCells().get(0));
		String user = usernameField.getAttribute("value");
		validate(passwordField);
		passwordField.click();
		passwordField.sendKeys("pas");
		// passwordField.sendKeys(givenAttributesRow.get(0).getCells().get(1));
		String pass = passwordField.getAttribute("value");
		if (user.equalsIgnoreCase("") && pass.equalsIgnoreCase("pas")) {
			return true;
		}
		return false;

	}

	public Object navigatesToVppSection(String planType) {

		if (validate(feedBackPopUp)) {
			popUpcloseLink.click();
		}

		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
		actions.moveToElement(ourPlans);

		if (planType.equalsIgnoreCase("MA")) {
			actions.moveToElement(maVppLink);
			actions.click().build().perform();
		}
		if (planType.equalsIgnoreCase("PDP")) {
			actions.moveToElement(pdpVppLink);
			actions.click().build().perform();
		}
		/*
		 * if (currentUrl().contains("medicare-advantage-plans.html")) { return
		 * new MaViewPlansAndPricingPage(driver); } if
		 * (currentUrl().contains("prescription-drug-plans.html")) { return new
		 * PdpViewPlansAndPricingPage(driver); } if
		 * (currentUrl().contains("medicare-supplement-plans.html")) { return
		 * new MsViewPlansAndPricingPage(driver); }
		 */
		return null;
	}

	public Boolean checkErrorMessage() {
		validate(signInButton);
		signInButton.click();
		validate(signInButton);
		return validate(alreadyMemberInvalidCredsErrorMessage);
	}

	public Boolean enterValidUserNamePassword() {
		validate(usernameField);
		usernameField.click();
		usernameField.sendKeys("q1blayer_001");
		// usernameField.sendKeys(givenAttributesRow.get(0).getCells().get(0));
		String user = usernameField.getAttribute("value");
		validate(passwordField);
		passwordField.click();
		passwordField.sendKeys("Password@1");
		// passwordField.sendKeys(givenAttributesRow.get(0).getCells().get(1));
		String pass = passwordField.getAttribute("value");
		if (user.equalsIgnoreCase("q1blayer_001") && pass.equalsIgnoreCase("Password@1")) {
			return true;
		}
		return false;
	}
	
	public void hoverourplanslink() {
		validate(OurPlansLink1);
		// Hover over text
		Actions action = new Actions(driver);
		PageFactory.initElements(driver, this);
		action.moveToElement(OurPlansLink1).build().perform();

		// to click
		// action.click().build().perform();

		validate(OurPlansLink1);

		// TODO Auto-generated method stub

	}
	/*
	 * public AccountHomePage signInValid() { validate(signInButton);
	 * signInButton.click(); // validate(signInButton);
	 * 
	 * ArrayList<String> tabs = new ArrayList<String>(
	 * driver.getWindowHandles()); driver.switchTo().window(tabs.get(1)); if
	 * (driver.getTitle().equalsIgnoreCase(
	 * "UnitedHealthcare Medicare Solutions | My Account Home")) { return new
	 * AccountHomePage(driver); }
	 * 
	 * return null; }
	 */

	public Boolean cookieValid() {
		validate(signInButton);
		signInButton.click();
		// validate(signInButton);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		validate(myPlansTab);
		if (getCookieName("membervisited") != null) {
			driver.switchTo().window(tabs.get(0));
			if (getCookieName("membervisited") != null) {
				return true;
			}
		}

		return false;
	}

	public Boolean alreadyMemberActiveValid() {
		validate(signInButton);
		String timerId = alreadyPlanMemberButtonInactive.getAttribute("id");
		if (timerId.contains("cookie")) {
			if (cookieValid()) {
				driver.navigate().refresh();
				String[] parts = timerId.split("-");
				String timerString = parts[1];
				int timer = Integer.parseInt(timerString);
				if (timer > 0) {
					return validate(signInButton);
				}
			}
		} else if (timerId.contains("visitor")) {
			String[] parts = timerId.split("-");
			String timerString = parts[1];
			int timer = Integer.parseInt(timerString);
			if (timer > 0) {
				return validate(signInButton);
			}

		}
		return false;

	}

	public Boolean cookieTimerValid() {
		driver.navigate().refresh();
		validate(signInButton);
		String timerId = alreadyPlanMemberButtonInactive.getAttribute("id");
		if (timerId.contains("cookie") || timerId.contains("visitor")) {
			String[] parts = timerId.split("-");
			String timerString = parts[1];
			int timer = Integer.parseInt(timerString);
			timer = timer * 1000;
			try {
				Thread.sleep(timer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return validate(signInButton);
	}

	public Boolean stopTimerValid() {
		validate(signInButton);
		String timerId = alreadyPlanMemberButtonInactive.getAttribute("id");
		if (timerId.contains("cookie")) {
			if (cookieValid()) {
				driver.navigate().refresh();
				String[] parts = timerId.split("-");
				String timerString = parts[1];
				int timer = Integer.parseInt(timerString);
				timer = timer * 1000;
				usernameField.click();
				try {
					Thread.sleep(timer);
					return validate(signInButton);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		} else if (timerId.contains("visitor")) {
			String[] parts = timerId.split("-");
			String timerString = parts[1];
			int timer = Integer.parseInt(timerString);
			try {
				Thread.sleep(timer);
				return validate(signInButton);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	public OurPlansPage navigationSectionOurPlansLinkClick() {
		navigationSectionOurPlansLink.click();
		if (getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_PLAN_TYPES_TITLE)) {
			return new OurPlansPage(driver);
		}

		return null;
	}

	public Object pickatopic(String picktopic) {

		selectSelectBoxIt.click();
		for (WebElement element : topicDropDownValues) {
			if (element.getText().equalsIgnoreCase(picktopic)) {
				element.click();
				picktopicbtn.click();
				break;
			}
		}

		if (currentUrl().contains("/medicare-education/about")) {
			if (getTitle().equals(PageTitleConstants.BLAYER_LEARN_ABOUT_MEDICARE)) {
				return new LearnAboutMedicareuhcPage(driver);
			}
		} else if (currentUrl().contains("medicare-education/enroll")) {
			if (getTitle().equals(PageTitleConstants.BLAYER_PREPARE_FOR_YOUR_MEDICARE_INITIAL_ENROLLMENT_PERIOD)) {
				return new PrepareForInitialEnrollmentuhcPage(driver);
			}
		}

		return null;
	}

	public PlanSelectorPage planselector() {
		takequizbtn.click();
		if (getTitle().equalsIgnoreCase("Plan Selector")) {
			return new PlanSelectorPage(driver);
		}
		return null;
	}

	public ContactUsUmsPage contactUsFooterClick() {
		validate(footerContactUsLink);
		footerContactUsLink.click();
		validate(footerContactUsLink);
		if (driver.getCurrentUrl().contains("/contact-us.html")) {
			return new ContactUsUmsPage(driver);
		} else {
			System.out.println("Contact us page not found");
			return null;
		}
	}

	public PlanSelectorPage planselector_click() {
		compareplans.click();
		if (getTitle().equalsIgnoreCase("Plan Selector")) {
			return new PlanSelectorPage(driver);
		}
		return null;
	}

	public RequestHelpAndInformationPage navigateToMaMoreHelpAndInfo() {
		
		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
		actions.moveToElement(ourPlansHoverLink);
		actions.moveToElement(moreHelpInfoLink);
		actions.click().build().perform();

		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoad(driver, requestAgentApptDropdown, 60);
		if (validateNew(requestAgentApptDropdown)) {
			return new RequestHelpAndInformationPage(driver);
		}

		return null;
	}

	public pages.acquisition.bluelayer.VPPPlanSummaryPage navigateToVpp(String zipcode) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sendkeys(zipCodeField, zipcode);
		viewPlansButton.click();

		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new pages.acquisition.bluelayer.VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public void clickRequestAsistancce() {
		validateNew(footerRequestforAssistancelink);
		if(proactiveChatExistBtn.size()!=0)
			proactiveChatExistBtn.get(0).click();
		footerRequestforAssistancelink.click();
		CommonUtility.waitForPageLoadNew(driver, requestAssistanceModal.get(0), 30);
		validateNew(requestAssistanceTitle);
		validateNew(requestAssistanceAgentID);
		requestAssistanceClose.click();
		waitforElementDisapper(By.id("cobrowse-disclaimer"), 30);
		}



	public JSONObject validatecobrowsemodelwindow() {
		String fileName = CommonConstants.COBROWSE_MODEL_WINDOW;
		cobrowseData = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : cobrowseData.getExpectedData().keySet()) {
			WebElement element = findElement(cobrowseData.getExpectedData().get(key));
			if (element != null) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		cobrowseJson = jsonObject;
		return cobrowseJson;
	}

	public VPPPlanSummaryPage searchPlansWithOutCounty(String zipcode) {
		sendkeys(zipCodeField, zipcode);
		viewPlansButton.click();
		/*
		 * try { if (countyModal.isDisplayed()) { for (WebElement county :
		 * countyRows) { if (county.getText().equalsIgnoreCase(countyName)) {
		 * county.click(); break; }
		 * 
		 * } } } catch (Exception e) { System.out.println("county box not found"
		 * ); }
		 */
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

		public void validateFooterLinks() {
			validateNew(footerHomeLink);
			validateNew(footerAboutUsLink);
			validateNew(footerContactUsLink);
			validateNew(footerSiteMapLink);
			validateNew(footerPrivacyPolicyLink);
			validateNew(footerTermsnConditionsLink);
			validateNew(footerDisclaimersLink);
			validateNew(footerAgentsnBrokersLink);
			validateNew(footerRequestforAssistancelink);
			validateNew(footerAccessibilitylink);
			validateNew(medicareAdvantagePlansLink);
			validateNew(medicareSupplementInsurancePlansLink);
			validateNew(medicarePrescriptionDrug_PlansLink);
			validateNew(learnAboutMedicareLink);
			validateNew(viewAllDisclaimerInformationLink);

		}

	public PlanSelectorNewPage quizButton() {
		waitforElement(ourPlans);
		Actions action = new Actions(driver);
		PageFactory.initElements(driver, this);
		action.moveToElement(ourPlans).build().perform();
		waitforElement(takeTheQuizBtn);
		takeTheQuizBtn.click();
		return new PlanSelectorNewPage(driver);
		}

	public VPPPlanSummaryPage searchPlans1(String zipcode, String countyName) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Zipcode CTA took time to load");
		}
		sendkeys(zipCodeField, zipcode);
		viewPlansButton.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try {
			if (countyModal.isDisplayed()) {
				if (county.getText().equalsIgnoreCase(countyName)) {
					county.click();
				}

			}

		} catch (Exception e) {
			System.out.println("county box not found");
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public VPPPlanSummaryPage searchPlansF(String zipcode) {

		OurPlans.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sendkeys(zipCodeF, zipcode);
		GoButton.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public pages.acquisition.bluelayer.VPPPlanSummaryPage GotoVPP(String zipcode) {
		try {
			Thread.sleep(8000);
			System.out.println("Sleep done");
		} catch (InterruptedException e) {
			System.out.println("page took time to load");
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,300)", "");

		sendkeys(StandaloneZipcode, zipcode);
		StandalonSearchCounty.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (countyDropdown.isDisplayed()) {
				countyDropdown.click();
				Thread.sleep(3000);
				// StandalonSearchCounty.click();
			}

		} catch (Exception e) {
			System.out.println("county box not found");
		}
		jse.executeScript("window.scrollBy(0,150)", "");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("page took time to load");
		}
		StandaloneVPP.click();

		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new pages.acquisition.bluelayer.VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public void OurPlanMALanding() {

		Actions action = new Actions(driver);
		action.moveToElement(OurPlans).build().perform();

		MALandingLink.click();

		try {
			Thread.sleep(15000);
			System.out.println("Thread Sleep completed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void OurPlansMALandingForSNP() {

		Actions action = new Actions(driver);
		action.moveToElement(OurPlans).build().perform();

		MALandingLink.click();

	}

	public void OurPlansPDPLanding() {

		Actions action = new Actions(driver);
		action.moveToElement(navigationSectionOurPlansLink).build().perform();

		PDPLandingLink.click();

		try {
			Thread.sleep(15000);
			System.out.println("Thread Sleep completed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public WelcomePage ZipcodeSearchToOLE(String zipcode) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("page took time to load");
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,300)", "");

		sendkeys(StandaloneZipcode, zipcode);
		StandalonSearchCounty.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (countyDropdown.isDisplayed()) {
				countyDropdown.click();
				Thread.sleep(3000);
				// StandalonSearchCounty.click();
			}

		} catch (Exception e) {
			System.out.println("county box not found");
		}
		jse.executeScript("window.scrollBy(0,100)", "");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("page took time to load");
		}
		selectFirstOptionOnPlanSelect.click();
		enrollButton.click();
		if (driver.getCurrentUrl().contains("welcome")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;
	}

	public WelcomePage SpecialNeedPlansZipcodeSearchToOLE(String zipcode) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("page took time to load");
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,300)", "");

		sendkeys(StandaloneZipcode, zipcode);
		StandalonSearchCounty.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (countyDropdown.isDisplayed()) {
				countyDropdown.click();
				Thread.sleep(3000);
				// StandalonSearchCounty.click();
			}

		} catch (Exception e) {
			System.out.println("county box not found");
		}
		jse.executeScript("window.scrollBy(0,100)", "");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("page took time to load");
		}
		StandaloneSNPoptions.click();
		enrollButton.click();
		if (driver.getCurrentUrl().contains("welcome")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;
	}
public MultiCountyModalPage ValidateMultiCOuntyPopUp(String zipcode) {
		
		CommonUtility.waitForPageLoad(driver, zipCodeField, 30);
		sendkeys(zipCodeField, zipcode);

		viewPlansButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (countyModal.isDisplayed()) {
			return new MultiCountyModalPage(driver);
		}
		return null;
	}

	public MultiCountyModalPage SubNav_ValidateMultiCOuntyPopUp(String zipcode) {
		hoverourplanslink();
		validate(OurPlans_zipfield);
		OurPlans_zipfield.click();
		OurPlans_zipfield.sendKeys(zipcode);
		validate(OurPlans_viewPlansButton);
		OurPlans_viewPlansButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (countyModal.isDisplayed()) {
			return new MultiCountyModalPage(driver);
		}
		return null;
	}
	public static void checkModelPopup(WebDriver driver) {
		int counter = 0;
		do {

			System.out.println("current value of conter: " + counter);
			List<WebElement> IPerceptionsFrame = driver.findElements(By.id("IPerceptionsEmbed"));

			if (IPerceptionsFrame.isEmpty()) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			} else {
				driver.switchTo().frame(IPerceptionsFrame.get(0));
				driver.findElement(By.className("btn-no")).click();
				driver.switchTo().defaultContent();
			}
			counter++;
		} while (counter < 2);
	}
	
	public AboutUsPage aboutUsClick() {
		validateNew(footerAboutUsLink);
		footerAboutUsLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (getTitle().contains("About UnitedHealthcare")) {
			return new AboutUsPage(driver);
		}
		return null;
			
		}
	
	public ContactUsUmsPage contactUsClick() {
		validateNew(footerContactUsLink);
		footerContactUsLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("contact-us")) {
			return new ContactUsUmsPage(driver);
		}
		return null;
			
		}
	
	public PrivacyPolicyUmsPage privacyPolicyClick() {
		validateNew(footerPrivacyPolicyLink);
		footerPrivacyPolicyLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("privacy_policy.html")) {
			return new PrivacyPolicyUmsPage(driver);
		}
		return null;
			
		}
	
	public TermsOfUseUmsPage termsOfUseClick() {
		validateNew(footerTermsnConditionsLink);
		footerTermsnConditionsLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("terms_and_conditions")) {
			return new TermsOfUseUmsPage(driver);
		}
		return null;
			
		}
	
	public DisclaimersPage disclaimersClick() {
		validateNew(footerDisclaimersLink);
		footerDisclaimersLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("disclaimer")) {
			return new DisclaimersPage(driver);
		}
		return null;
			
		}
	
	public AgentsAndBrokersPage agentsAndBrokersClick() {
		validateNew(footerAgentsnBrokersLink);
		footerAgentsnBrokersLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if(driver.getCurrentUrl().contains("health-insurance-brokers")){
			return new AgentsAndBrokersPage(driver);
		}
		return null;
			
		}
	
	public AcquisitionHomePage homeFooterClick() {
		validateNew(footerHomeLink);
		footerHomeLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (validateNew(zipCodeField)) {
			return new AcquisitionHomePage(driver, true);
		}
		return null;
	}

	public WebElement getLnkLearnAboutMedicare() {
		return lnkLearnAboutMedicare;
}

	public LearnAboutMedicareHomePage openLearnAboutMedicarePage() {

		getLnkLearnAboutMedicare().click();
		validateNonPresenceOfElement(zipCodeField);
		return new LearnAboutMedicareHomePage(driver);
	}

}
