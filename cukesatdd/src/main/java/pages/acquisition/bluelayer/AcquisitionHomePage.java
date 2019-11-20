package pages.acquisition.bluelayer;

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

	@FindBy(xpath= "//*[contains(@id,'cta-zipcode')]")
	private WebElement zipCodeField;
	
	@FindBy(id = "zipcode")
	private WebElement zipCodeHealthPlans;

	@FindBy(xpath = "//*[contains(@id,'zipcodebtn') or (contains(@class,'zip-button' ) and contains( text(),'Go'))]")
	private WebElement viewPlansButton;
	
	@FindBy(xpath = "//form[@name='zipcodeform']//button[contains(@class,'zip-button')]")
	private WebElement GoBtnHealthPlans;
	

	@FindBy(xpath = "//div[@id='ipeL']/div[2]/map/area[3]")
	private WebElement popUpcloseLink;

	@FindBy(xpath = "//div[contains(@class,'popup-modal')][contains(@class,'active')]/div[@class='modal-title']")
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
	
	@FindBy(id= "zipcode")
	private WebElement healthPlansZipcode;

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
	
	@FindBy(xpath = "//a[contains(text(), 'Get a Plan Recommendation')]")
	private WebElement takeTheQuizBtn;

	@FindBy(xpath = ".//*[contains(@id,'colhowdoesthiswork')]//*[@itemprop='significantLink']/*[contains(@class,'cta-button secondary')and contains(text(),'Get')]")
	public WebElement getStarted;

	@FindBy(xpath = "//div[@id='subnav_2']//h3/a[contains(text(),'Pharmacy')]")
	private WebElement pharmacysearchbtn;

	@FindBy(xpath = ".//*[@id='selector']")
	private WebElement PSTButton;
	
	@FindBy(xpath = ".//*[@id='change-location']")
	private WebElement changeLocationLink;


	@FindBy(xpath = ".//*[contains(@class, 'meded-article-content__section')]//*[contains(text(), 'Request an Appointment')]")
	private WebElement requestAgentApptDropdown;

	@FindBy(id = "js-ole-zip-search")
	private WebElement StandaloneZipcode;

	@FindBy(xpath = "//*[@id='js-ole-zip-search']/following-sibling::button")
	private WebElement StandalonSearch;

	@FindBy(xpath = "//*[@id='js-ole-plan-result']/button")
	private WebElement StandaloneVPP;

	@FindBy(xpath = "//*[@id='js-ole-plan-select']//optgroup[2]/option[1]")
	private WebElement StandaloneSNPoptions;

	@FindBy(xpath = "//*[contains(@class,'btn--bottom')]")
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
	
	@FindBy(id = "zipcode")
	private WebElement zipCode;

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
	
	@FindBy(xpath="//*[@id='ghn_lnk_2']")
	private WebElement ShopForaplan;
	
	@FindBy(id= "search-field")
	private static WebElement searchfield;
	
	@FindBy(css=".icon-search")
	private WebElement searchbutton;
	
	@FindBy(xpath="//button[contains(@class,'proactive-offer__close')]")
	public static WebElement proactiveChatExitBtn;
	
	@FindBy(xpath = "//h3//*[contains(@onclick,'loadCachedProviderSearch')]")
	private WebElement providerSearchFromGlobalHeader;
	
	@FindBy(xpath ="//*[contains(@class,'cta-button secondary') and contains(text(),'Provider')]")
	private WebElement providerSearchFromHomeScreen;

	
	  @FindBy(xpath = "//*[@id='sam-call-button']/div/span[2]/img")
			private WebElement callsam;
			
			@FindBy(xpath = "//*[@id='sam-call-button']/div/span[1]")
			private WebElement callsamtooltip;
			
			@FindBy(xpath ="//*[@id='sam-call-modal']/div/div")
			private WebElement callSamPopup;
			
			
			@FindBy(xpath ="//*[@id='sam-call-modal']/div/div/div[2]/p[1]/a[1]")
			private WebElement CallSamModel;
			
			@FindBy(xpath ="//*[@id='sam-call-modal']/div/div/div[2]/p[1]/a[1]")
			private WebElement CallSamTFN;
			
			@FindBy(xpath ="//*[@id='sam-call-modal']/div/div/div[1]/a")
			private WebElement CallSamTFNClose;
			
			String CallSam= "Call a Licensed Insurance Agent";
			@FindBy(xpath = "//*[@id='sam-button--chat']/div/span[2]/img")
			private WebElement chatsam;
			
			@FindBy(xpath = "//*[@id='sam-button--chat']/div/span[1]")
			private WebElement chatsamtooltip;
			
			@FindBy(xpath ="//*[@id='inner-chat']")
			private WebElement chatSamPopup;
			
				@FindBy(xpath ="//*[@id='agent-name']")
			private WebElement ChatSamHead;
			
			@FindBy(xpath ="//*[@id='sp-close-frame']")
			private WebElement ChatSamTFNClose;
			
			String ChatSamText= "Chat with a Licensed Insurance Agent";
			
			
	
	
	
	  @FindBy(id="state-select")
	  private WebElement stateDropDown;
    
	  @FindBy(id="dupIconFlyOut")
	  private WebElement shoppingCartIcon;
	
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
	private static String UMS_ACQISITION_PROD_PAGE_URL = MRConstants.UHCM_URL_PROD;
	private static String AARP_ACQISITION_PROD_PAGE_URL = MRConstants.AARP_URL_PROD;	
	private static String Local_AARP_URL = MRConstants.Local_URL;	
	private static String AARP_ACQISITION_PAGE_URL = MRConstants.AARP_URL;
	private static String AARP_ACQISITION_OFFLINE_PAGE_URL = MRConstants.AARP_URL_OFFLINE;

	public static boolean isHealthPlan = false;
	
	public AcquisitionHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	public AcquisitionHomePage(WebDriver driver, String planType, boolean details) {
		super(driver);
		PageFactory.initElements(driver, this);		
	}
	
	public AcquisitionHomePage(WebDriver driver, boolean alreadyOnSite) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(alreadyOnSite);
	}
	
	public AcquisitionHomePage(WebDriver driver, int visitorProfile) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(visitorProfile);
	}

	public AcquisitionHomePage(WebDriver driver, String siteOrPage) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(siteOrPage);
	}

	@SuppressWarnings("deprecation")
	public void openAndValidate(boolean alreadyOnSite) {
		if (alreadyOnSite) {
			
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: "+driver.getCurrentUrl());
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
			startNew(UMS_ACQISITION_OFFLINE_PAGE_URL);
			checkModelPopup(driver,45);
		}else if (MRScenario.environment.equals("prod")) {
			startNew(UMS_ACQISITION_PROD_PAGE_URL);
			checkModelPopup(driver,45);
		} else if(MRScenario.environment.equals("local")){
			startNew(Local_AARP_URL);
		}else {
			startNew(UMS_ACQISITION_PAGE_URL);
			checkModelPopup(driver,10);
		}
	//	CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: "+driver.getCurrentUrl());
		
		clickIfElementPresentInTime(driver, proactiveChatExitBtn,20);
	//	CommonUtility.waitForPageLoadNew(driver, navigationSectionHomeLink, 45);
	
	}	
	
	public void openAndValidate(String siteOrPage) {
		if ("ULayer".equalsIgnoreCase(siteOrPage)) {

			if (MRScenario.environment.equals("offline")) {
				startNew(AARP_ACQISITION_OFFLINE_PAGE_URL);
			}else if (MRScenario.environment.equals("prod")) {
				startNew(AARP_ACQISITION_PROD_PAGE_URL);
			} else {
				startNew(AARP_ACQISITION_PAGE_URL);
			}
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: "+driver.getCurrentUrl());
			checkModelPopup(driver);
			CommonUtility.waitForPageLoadNew(driver, navigationSectionHomeLink, 45);
			
			/*CommonUtility.waitForPageLoad(driver, proactiveChatExitBtn,20); // do not change this to waitForPageLoadNew as we're not trying to fail the test if it isn't found
			try{
				if(proactiveChatExitBtn.isDisplayed())
					jsClickNew(proactiveChatExitBtn);
			}catch(Exception e){
				System.out.println("Proactive chat popup not displayed");
			}*/
			clickIfElementPresentInTime(driver, proactiveChatExitBtn,20);
		} else if("health-plans".equalsIgnoreCase(siteOrPage)){
			isHealthPlan = true;
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: "+driver.getCurrentUrl());
			checkModelPopup(driver);
			CommonUtility.waitForPageLoadNew(driver, zipCode, 45);
			try{
				if(proactiveChatExitBtn!=null)
				jsClickNew(proactiveChatExitBtn);
				
				else 
					Assert.fail("Please check booleanvalue");
				
			}catch(Exception e){
				System.out.println("Proactive chat popup not displayed");
			}
	}else {
			openAndValidate();
		}
	}
	
	public void openAndValidate(int visitorProfile) {
		
		if (visitorProfile>0) {				
		System.out.println("Current page URL: "+driver.getCurrentUrl());
		//checkModelPopup(driver);
		clickIfElementPresentInTime(driver, proactiveChatExitBtn,20);
		CommonUtility.waitForPageLoadNew(driver, zipCode, 45);
	//	clickIfElementPresentInTime(driver, proactiveChatExitBtn,2);
		/*try{
			if(proactiveChatExitBtn!=null)
			jsClickNew(proactiveChatExitBtn);			
			else 
				Assert.fail("Please check booleanvalue");		
		}catch(Exception e){
			System.out.println("Proactive chat popup not displayed");
		}*/
		}
	}

	public  VPPPlanSummaryPage searchPlans(String zipcode, String countyName) {
		if(isHealthPlan){
			CommonUtility.waitForPageLoadNew(driver, zipCodeHealthPlans, 45);
			sendkeys(zipCodeHealthPlans, zipcode);

			GoBtnHealthPlans.click();
			CommonUtility.waitForPageLoadNew(driver, vppTop, 30);

		}else{
		CommonUtility.waitForPageLoadNew(driver, zipCodeField, 20);
		sendkeys(zipCodeField, zipcode);
		viewPlansButton.click();
		}
		CommonUtility.waitForPageLoad(driver, countyModal, 45);
		if (validate(countyModal))
			driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")).click();
	//	CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, vppTop, 35);
			
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);

		}
		return null;
		/*try {

			if (countyModal.isDisplayed()) {
				driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")).click();
			}
			System.out.println("countyModal.getText() " + countyModal.getText());
			;
		} catch (Exception e) {
			System.out.println("county box not found");
		}
		
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
		CommonUtility.waitForPageLoad(driver, changeLocationLink, 30);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;*/
	}

	public VPPPlanSummaryPage searchPlans(String zipcode) {
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
		if (driver.getTitle().equalsIgnoreCase("Medicare Plans for Different Needs | UnitedHealthcare�")) {
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
		if (driver.getTitle().equalsIgnoreCase("Medicare Advantage Plans | UnitedHealthcare�")) {
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
		//checkModelPopup(driver);
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
		if (driver.getTitle().equalsIgnoreCase("Medicare Special Needs Plans | UnitedHealthcare�")) {
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

	public VPPPlanSummaryPage navigateToVpp(String zipcode) {
		CommonUtility.waitForPageLoadNew(driver, zipCodeField, 3000);
		sendkeys(zipCodeField, zipcode);
		viewPlansButton.click();
		CommonUtility.waitForPageLoadNew(driver, vppTop, 3000);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
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
		//The below was commented out because the xpath for zipcode and viewplans button was combined into one to work for both cases. Reach out to Aayush for any questions.
				/*if(isHealthPlan){
					CommonUtility.waitForPageLoadNew(driver, zipCode, 30);
					sendkeys(zipCode, zipcode);

					btnGO.click();
				}else{*/
		CommonUtility.waitForPageLoadNew(driver, zipCodeField, 45);
		sendkeys(zipCodeField, zipcode);

		viewPlansButton.click();
		CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
	//	}
		/*
		 * try { if (countyModal.isDisplayed()) { for (WebElement county :
		 * countyRows) { if (county.getText().equalsIgnoreCase(countyName)) {
		 * county.click(); break; }
		 * 
		 * } } } catch (Exception e) { System.out.println("county box not found"
		 * ); }
		 */
		CommonUtility.waitForPageLoadNew(driver, changeLocationLink, 30);
		
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("health-plans")) {
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
		//	validateNew(footerRequestforAssistancelink);
			validateNew(footerAccessibilitylink);
			validateNew(medicareAdvantagePlansLink);
			validateNew(medicareSupplementInsurancePlansLink);
			validateNew(medicarePrescriptionDrug_PlansLink);
			validateNew(learnAboutMedicareLink);
			validateNew(viewAllDisclaimerInformationLink);

		}

	public PlanSelectorNewPage quizButton() {
		validateNew(ourPlans);
		Actions action = new Actions(driver);
		action.moveToElement(ourPlans).build().perform();
		validateNew(takeTheQuizBtn);
		takeTheQuizBtn.click();
		CommonUtility.checkPageIsReadyNew(driver);

		return new PlanSelectorNewPage(driver);
	}
	
	public PlanSelectorNewPage PSTButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
		js.executeScript("window.scrollBy(0,1200)");
		waitforElement(PSTButton);
		PSTButton.click();
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
	
	public AboutUsPage aboutUsClick() {
		validateNew(footerAboutUsLink);
		footerAboutUsLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (getTitle().contains("About")) {
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

	public MultiCountyModalPage SubNav_ValidateMultiCOuntyPopUp(String zipcode) {
		// TODO Auto-generated method stub
		return null;
	}

	public MultiCountyModalPage ValidateMultiCOuntyPopUp(String zipcode) {
		// TODO Auto-generated method stub
		return null;
	}

	public ShopforaplanUHClayer Hoveronaplan() throws InterruptedException
	{		
		waitforElement(ShopForaplan);
        if (ShopForaplan.isDisplayed()) {
               Actions action = new Actions(driver);
//               PageFactory.initElements(driver, this);
               action.moveToElement(ShopForaplan).build().perform();
               return new ShopforaplanUHClayer(driver);
        }
		else {
			return null;}
	}

	public  KeywordSearch searchfield() {
		validate (searchfield);		
		System.out.println("search field is seen ==>" + searchfield.isDisplayed());
		validate (searchbutton);
		System.out.println("search button is seen"  + searchbutton.isDisplayed());
		searchfield.clear();		
		searchfield.sendKeys("medicare");
		searchbutton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getCurrentUrl().contains("medicare.html?q=medicare"))
		return new  KeywordSearch(driver);
		return null;	
	}
	
	public DrugCostEstimatorPage navigationDrugCostEstimator() {
     	navigateToMenuLinks(ShopForaplan, headerDrugCostEstimatorLink);

     	
     		return new DrugCostEstimatorPage(driver);
	 }

	public pages.acquisition.bluelayer.ProviderSearchPage clicksOnRallyToolFromGlobalHeader() {
		// TODO Auto-generated method stub
		
		Actions action = new Actions(driver);
		action.moveToElement(navigationSectionHomeLink).moveToElement(ourPlansHoverLink).build().perform();
		validateNew(providerSearchFromGlobalHeader);

		switchToNewTabNew(providerSearchFromGlobalHeader);

		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("werally")) {

			return new pages.acquisition.bluelayer.ProviderSearchPage(driver);

		}
		return null;
		
	}

	public pages.acquisition.bluelayer.ProviderSearchPage clicksOnRallyToolFromHomePage() {
		validateNew(providerSearchFromHomeScreen);

		switchToNewTabNew(providerSearchFromHomeScreen);
		//providerSearchFromHomeScreen.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("werally")) {

			return new pages.acquisition.bluelayer.ProviderSearchPage(driver);

		}
		return null;
	}

	public WelcomePage ZipcodeSearchToOLEWithOutCounty(String zipcode,String planName) throws Exception {
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
		jse.executeScript("window.scrollBy(0,100)", "");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("page took time to load");
		}
		//String planYear=ZipCodeLabel.getText();
		driver.findElement(By.xpath("//*[@id='js-ole-plan-select']//option[text()='" + planName + "']")).click();
		waitforElement(enrollButton);
		enrollButton.click();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		if (driver.getTitle().contains("Online Enrollment")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;
	}
	
	public WelcomePage ZipcodeSearchToOLEWithCounty(String zipcode, String countyName,String planName) throws Exception {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("page took time to load");
		}
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,300)", "");

		sendkeys(StandaloneZipcode, zipcode);
		StandalonSearchCounty.click();
		driver.findElement(By.xpath("//select[@id='ole-county-select']//option[text()='" + countyName + "']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		jse.executeScript("window.scrollBy(0,100)", "");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			System.out.println("page took time to load");
		}
		driver.findElement(By.xpath("//*[@id='js-ole-plan-select']//option[text()='" + planName + "']")).click();
		waitforElement(enrollButton);
		enrollButton.click();
		Thread.sleep(5000);
		if (driver.getTitle().contains("Online Enrollment")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;
	}
	
	public void selectState(String state) {
		selectFromDropDownByValue(stateDropDown, state);
	}
	/**
	 * This method used to navigate to visitor profile dashboard
	 * @return
	 */
	public VisitorProfilePage navigateToVisitorProfilePage() {
		waitforElement(shoppingCartIcon);
		shoppingCartIcon.click();
		if(driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePage(driver);
		}else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}
	
	public VPPPlanSummaryPage findPlans(String txtZipCode){
		
		zipCode.sendKeys(txtZipCode);
		
		
		return new VPPPlanSummaryPage(driver);
	}
	
	
	public AcquisitionHomePage validateCallSam() throws InterruptedException {
		boolean present;
		try {
			validateNew(callsam);
			present = true;
			} catch (NoSuchElementException e) {
			present = false;
			}
			if (present) {
			  System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
			  return new AcquisitionHomePage(driver);
			}
		else
			System.out.println("@@@@@@@@@ No TFN widget @@@@@@@@@");
		return null;
	}
	
	public AcquisitionHomePage validateCallSamContent() throws InterruptedException {
	
	Actions action = new Actions(driver);
	WebElement element = callsam;
	action.moveToElement(element).perform();
	String toolTipText = callsamtooltip.getText();
	System.out.println("====================================================================");
	System.out.println(toolTipText);
	System.out.println("====================================================================");
	
	if (CallSam.equalsIgnoreCase(toolTipText)) {
	  System.out.println("Call sticky action menu roll out and contain the text Call a Licensed Insurance Agent");
	  return new AcquisitionHomePage(driver);
	}
	else
		System.out.println("No Call sticky action menu didn't roll out and doesn't contain the text Call a Licensed Insurance Agent");
	return null;
	}
	
	public AcquisitionHomePage  validateCallpopup() throws InterruptedException {
	//CommonUtility.checkPageIsReady(driver);
	callsam.click();
	System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");		
	driver.switchTo().activeElement();
	System.out.println(CallSamTFN.getText());
	CallSamTFNClose.click();
	validateNew(callsam);		
	return null;
	}
	
	public AcquisitionHomePage validateChatSam() throws InterruptedException {
	boolean present;
	try {
	validateNew(chatsam);
	present = true;
	} catch (NoSuchElementException e) {
	present = false;
	}
	if (present) {
	  System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
	  return new AcquisitionHomePage(driver);
	}
	else
		System.out.println("@@@@@@@@@ No TFN widget @@@@@@@@@");
	return null;
	}
	
	public AcquisitionHomePage validateChatSamContent() throws InterruptedException {
	
	Actions action = new Actions(driver);
	WebElement element = chatsam;
	action.moveToElement(element).perform();
	String ChattoolTipText = chatsamtooltip.getText();
	System.out.println("====================================================================");
	System.out.println(ChattoolTipText);
	System.out.println("====================================================================");
	
	if (ChatSamText.equalsIgnoreCase(ChattoolTipText)) {
	  System.out.println("Chat sticky action menu roll out and contain the text Chat with a Licensed Insurance Agent");
	  return new AcquisitionHomePage(driver);
	}
	else
		System.out.println("No Chat sticky action menu didn't roll out and doesn't contain the text Chat with a Licensed Insurance Agent");
	return null;
	}
	
	public AcquisitionHomePage  validateChatpopup() throws InterruptedException {
	//CommonUtility.checkPageIsReady(driver);
	chatsam.click();
	System.out.println("@@@@@@@@@@@@@@@ Chat Icon Clicked @@@@@@@@@@@@@@@");	
	chatsamtooltip.click();
	driver.switchTo().activeElement();
	System.out.println(ChatSamHead.getText());
	ChatSamTFNClose.click();
	validateNew(chatsam);		
	return null;
	}

	public VPPPlanSummaryPage searchPlanOnHealthPlansPage(String zipcode, String county, String isMultiCounty){
		CommonUtility.waitForPageLoadNew(driver, healthPlansZipcode, 30);
		sendkeys(healthPlansZipcode, zipcode);
		viewPlansButton.click();
		
		if(isMultiCounty.equalsIgnoreCase("YES")){
			CommonUtility.waitForPageLoad(driver, countyModal, 45);
			if (validate(countyModal))
				driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + county + "']")).click();
		}
		CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}
	
}
