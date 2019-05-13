package pages.acquisition.ulayer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
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

import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import junit.framework.Assert;

import pages.acquisition.ole.WelcomePage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;

/**
 * @author pperugu
 *
 */
public class AcquisitionHomePage extends GlobalWebElements {

	@FindBy(id = "cta-zipcode")
	private WebElement zipCodeField;

	@FindBy(className = "fd_myPlans")
	private WebElement myPlansTab;

	@FindBy(id = "dce")
	private WebElement getStartedButton;

	@FindBy(id = "learnfindplanBtn")
	private WebElement learnfindPlansButton;

	@FindBy(id = "Find a pharmacy near you")
	private WebElement pharmacyNearLink;

	@FindBy(className = "zip-button")
	private WebElement FindPlansButton1;

	@FindBy(xpath = "//*[@id='ghn_lnk_2']")
	private WebElement OurPlansLink1;

	@FindBy(id = "zipcodebtn")
	private WebElement findPlansButton;

	@FindBy(id = "learn-zipcode")
	private WebElement learnzipCodeField;

	@FindBy(id = "lookzip")
	private WebElement lookzip;

	@FindBy(xpath = "//div[@class='modal-title']")
	private WebElement countyModal;

	@FindBy(id = "homefooter")
	private WebElement homefooter;

	@FindBys(value = { @FindBy(id = "selectCounty") })
	List<WebElement> countyRows;

	@FindBy(xpath = "/html/body/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/div[2]/div/div/div[2]/div/ul/li[2]/a")
	WebElement zipCodebtn;

	@FindBy(xpath = "//a[contains(text(),'Request More Help')]")
	private WebElement pdp_moreHelpInfoLink;

	@FindBy(xpath = ".//*[@id='atdd_ma_plans']/span")
	private WebElement ma_moreHelpInfoLink;

	@FindBy(xpath = "//a[contains(text(),'Request More')]")
	private WebElement moreHelpInfoLink;

	@FindBy(xpath = "//div[@id='subnav_2']//h3/a[contains(text(),'Pharmacy')]")
	private WebElement pharmacylocator;

	@FindBy(id = "ghn_lnk_1")
	public static WebElement navigationSectionHomeLink;

	@FindBy(id = "ghn_lnk_2")
	public static WebElement ourPlansHoverLink;

	@FindBy(id = "subnav_2")
	public static WebElement ourPlansDropdownText;

	@FindBy(xpath = "//html[@id='ctl00_MasterHtmlTag']/head/title")
	public static WebElement test;

	@FindBy(id = "provider")
	private WebElement po7Link;

	@FindBy(id = "dce")
	private WebElement enterYourDrugListButton;

	@FindBy(xpath = "//*[@id='ghn_lnk_4']")
	private WebElement hoverhealthandwellnesslink;

	@FindBy(xpath = "//*[@id='subnav_4']/div/div/div[2]/div/a")
	public static WebElement forgotusernamepasswordlink;

	@FindBy(xpath = "//*[@id='subnav_4']/div/div/div[2]/div/span[2]/a")
	public static WebElement registerherelink;

	@FindBy(xpath = "//div[@class='overview-main']/h2")
	private WebElement vppTop;

	@FindBy(xpath = "//table[@id='colhowdoesthiswork_dce']//div[@itemprop='significantLink']/a[contains(@class,'cta-button')]")
	public WebElement getStarted;

	@FindBy(xpath = ".//*[@id='collapse2heading_article_mededaccordion0']")
	private WebElement requestAgentApptDropdown;

	@FindBy(xpath = "//*[@class='textalign']//p[2]/a")
	private WebElement county;

	@FindBy(xpath = "//*[@id='ole-county-select']/option[@value=1]")
	private WebElement countyDropdown;

	@FindBy(xpath = "//*[@id='js-ole-plan-select']//optgroup[1]/option[@value=0]")
	private WebElement selectFirstOptionOnPlanSelect;

	@FindBy(xpath = "//*[@id='js-ole-plan-select']//optgroup[2]/option[1]")
	private WebElement StandaloneSNPoptions;

	@FindBy(xpath = "//*[@id='js-ole-plan-select']//following::button")
	private WebElement enrollButton;

	@FindBy(id = "js-ole-zip-search")
	private WebElement StandaloneZipcode;

	@FindBy(xpath = "//*[@id='js-ole-zip-search']/following-sibling::button")
	private WebElement StandalonSearch;

	@FindBy(xpath = "//*[@id='js-ole-plan-result']/p/following-sibling::button")
	private WebElement StandaloneVPP;

	@FindBy(xpath = "//button[text()='View Plans & Pricing']")
	private WebElement ViewPlansPricingButton;

	@FindBy(xpath = "//*[@class='btn--bottom']")
	private WebElement StandalonSearchCounty;

	@FindBy(xpath = "//*[@id='planTypesColumn']/h3[2]/a")
	private WebElement PDPLandingLink;

	@FindBy(xpath = "//*[@id='planTypesColumn']/h3[1]/a")
	private WebElement MALandingLink;

	@FindBy(xpath = "//*[@class='container meded-article-header']/h1']")
	private WebElement MALandingHeading;

	@FindBy(id = "zipcodebtn")
	private WebElement viewPlansButton;

	/*
	 * @FindBy(id = "vpp_selectcounty_box") private WebElement countyModal;
	 */

	@FindBy(id = "zipcode")
	private WebElement zipCodeF;

	@FindBy(className = "textalign")
	private WebElement countyModal1;

	@FindBy(xpath = "//*[@id='ghn_lnk_2']")
	private WebElement OurPlans;

	@FindBy(id = "nav-zipcode")
	private WebElement OurPlans_zipfield;

	@FindBy(xpath = "//*[@id = 'nav-zipcode']/following-sibling::button[@class = 'zip-button']")
	public WebElement OurPlans_viewPlansButton;
	
	@FindBy(xpath = "(//*[@class='zip-button'])[2]")
	private WebElement GoButton;
	
	@FindBy(id = "cobrowse-disclaimer")
	private WebElement requestAssistanceModal;
	
	@FindBy(xpath = "//div[@id='cobrowse-disclaimer']//*[contains(@class,'modal-title')]")
	private WebElement requestAssistanceTitle;
	
	@FindBy(id = "correlationId")
	private WebElement requestAssistanceAgentID;
	
	@FindBy(xpath = "//a[contains(@class,'closer')]")
	private WebElement requestAssistanceClose;
	
	@FindBy(id = "gbqfbb")
	private WebElement feelingluckyBtn;
	
	@FindBy(id = "medicareTitle")
	public WebElement siteMapHeader;
	
	@FindBy(xpath = "//*[@class='container meded-article-header']//span[contains(text(),'Privacy Policy')]")
	public WebElement privacyHeader;
	
	@FindBy(xpath = "//*[@class='container meded-article-header']//span[contains(text(),'Health Insurance Broker')]")
	public WebElement brokerHeader;
	
	/* LearnAboutMedicare link */
	@FindBy(xpath = "//*[@id='ghn_lnk_3']")
	private WebElement lnkLearnAboutMedicare;
	
	@FindBy(xpath = "//*[@id='subnav_2']/div[1]/div/div[3]/div/h3[7]/a")
	private WebElement providerSearchFromGlobalHeader;

	@FindBy(xpath ="//*[@id='colhowdoesthiswork_provider']/tbody/tr/td/div/a")
	private WebElement providerSearchFromHomeScreen;
	
	@FindBy(id="ghn_lnk_2")
	private WebElement ShopForaplan;
	
    @FindBy(xpath=".//*[@id='updates-mobile-form']/div/div[2]/button")
	private WebElement submit;


	private static String TeamC_ACQUISITION_PAGE_URL = MRConstants.TeamC_UHC_URL;

	private static String AARP_ACQISITION_PAGE_URL = MRConstants.AARP_URL;
	private static String AARP_ACQISITION_OFFLINE_PAGE_URL = MRConstants.AARP_URL_OFFLINE;
	private static String AARP_ACQISITION_PROD_PAGE_URL = MRConstants.AARP_URL_PROD;
	private static String UMS_ACQISITION_PAGE_URL = MRConstants.UHC_URL;
	private static String UMS_ACQISITION_OFFLINE_PAGE_URL = MRConstants.UHC_URL_OFFLINE;
	private static String UMS_ACQISITION_PROD_PAGE_URL = MRConstants.UHCM_URL_PROD;	

	private PageData globalFooter;

	public JSONObject globalFooterJson;
	public JSONObject browserCheckJson;

	public JSONObject homePageDisclaimerJson;

	public JSONObject homePageDisclaimerHideJson;

	public JSONObject alreadyPlanMemberJson;
	public JSONObject medicareEducationDropDownJson;

	public JSONObject headerJson;

	private PageData globalHeader;

	public JSONObject globalHeaderJson;

	public JSONObject ourplansdropdownJson;

	public JSONObject homeJson;

	private PageData healthandwellnessdropdown;

	public JSONObject healthandwellnessdropdownJson;

	public JSONObject globalFooterDTMJson;

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
	
	public AcquisitionHomePage(WebDriver driver, String site) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate(site);
	}

	@Override
	public void openAndValidate() {
	
		
		if (MRScenario.environment.equals("offline")) {
			start(AARP_ACQISITION_OFFLINE_PAGE_URL);
		}
		else if (MRScenario.environment.equals("prod")) {
			start(AARP_ACQISITION_PROD_PAGE_URL);
		}else {
			start(AARP_ACQISITION_PAGE_URL);
		}
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: "+driver.getCurrentUrl());
		checkModelPopup(driver);
		CommonUtility.waitForPageLoadNew(driver, navigationSectionHomeLink, 45);
		CommonUtility.waitForPageLoad(driver, proactiveChatExitBtn,20); // do not change this to waitForPageLoadNew as we're not trying to fail the test if it isn't found
		try{
		if(proactiveChatExitBtn.isDisplayed())
			jsClickNew(proactiveChatExitBtn);
		}catch(Exception e){
			System.out.println("Proactive chat popup not displayed");
		}
	}

	public void openAndValidate(String site) {
		if ("BLayer".equalsIgnoreCase(site)) {
			if (MRScenario.environment.equals("offline")) {
				startNew(UMS_ACQISITION_OFFLINE_PAGE_URL);
			} else if (MRScenario.environment.equals("prod")) {
				startNew(UMS_ACQISITION_PROD_PAGE_URL);
			} else {
				startNew(UMS_ACQISITION_PAGE_URL);
			}
			CommonUtility.checkPageIsReadyNew(driver);
			System.out.println("Current page URL: " + driver.getCurrentUrl());
			CommonUtility.waitForPageLoadNew(driver, navigationSectionHomeLink, 45);
			CommonUtility.waitForPageLoad(driver, proactiveChatExitBtn, 20); // do not change this to waitForPageLoadNew
																				// as
																				// we're not trying to fail the test if
																				// it
																				// isn't found
			try {
				if (proactiveChatExitBtn.isDisplayed())
					jsClickNew(proactiveChatExitBtn);
			} catch (Exception e) {
				System.out.println("Proactive chat popup not displayed");
			}
		} else {
			Assert.fail("**********Please specify site as BLayer*********");
		}
	}
	@SuppressWarnings("deprecation")
	public void openAndValidate(boolean alreadyOnSite) {
		if (alreadyOnSite) {
			
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Current page URL: "+driver.getCurrentUrl());
		checkModelPopup(driver);
		CommonUtility.waitForPageLoadNew(driver, zipCodeField, 45);
		try{
			if(proactiveChatExitBtn!=null)
			jsClickNew(proactiveChatExitBtn);
			
			else 
				Assert.fail("Please check booleanvalue");
			
		}catch(Exception e){
			System.out.println("Proactive chat popup not displayed");
		}
		}
	}
	
	public VPPPlanSummaryPage searchPlans(String zipcode, String countyName) {

		CommonUtility.waitForPageLoadNew(driver, zipCodeField, 30);
		sendkeys(zipCodeField, zipcode);

		viewPlansButton.click();
		CommonUtility.waitForPageLoad(driver, countyModal, 45);
				driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='" + countyName + "']")).click();
		CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
		if (driver.getCurrentUrl().contains("plan-summary")) {
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
		if (getTitle().equalsIgnoreCase(PageTitleConstants.ULAYER_PLAN_SUMMARY_PAGE_TITLE)) {
			return new VPPPlanSummaryPage(driver);
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

	public String selectsHomeFooter() {

		return homefooter.getText();
	}

	public VPPPlanSummaryPage enterZipcode(String zipCode, String county, String planYear) {
		sendkeys(zipCodeField, zipCode);
		zipCodebtn.click();
		return new VPPPlanSummaryPage(driver);
	}

	public JSONObject accessGlobalFooter() {
		String fileName = CommonConstants.GLOBAL_FOOTER_PAGE_DATA;
		globalFooter = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : globalFooter.getExpectedData().keySet()) {
			WebElement element = findElement(globalFooter.getExpectedData().get(key));
			if (element != null) {
				if (validateNew(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		globalFooterJson = jsonObject;

		return globalFooterJson;
	}

	public AcquisitionHomePage veiwAllDisclaimerLinkSectionLinksClick() {
		validateNew(viewAllDisclaimerInformationLink);
		viewAllDisclaimerInformationLink.click();

		validateNew(disclaimerBackToTopLink);
		disclaimerBackToTopLink.click();

		validateNew(hideDiscliamerInformation);
		hideDiscliamerInformation.click();

		if (getTitle().equalsIgnoreCase("Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new AcquisitionHomePage(driver);
		}
		return null;
	}

	public Boolean visitAARPOrgClick() {
		validateNew(visitAARPLink);
		visitAARPLink.click();
		validateNew(visitAARPLink);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase("You are now leaving AARPMedicarerx.com")) {
			proceedLink.click();
			if (driver.getCurrentUrl().equals("http://www.aarp.org/")) {
				return true;

			}
		}
		return false;
	}

	public Boolean validate_alreadyPlanMemberButton_inactive() {
		return validateNew(alreadyPlanMemberButtonInactive);

	}

	public Boolean validate_alreadyPlanMemberButton_active() {
		validateNew(alreadyPlanMemberButton);
		alreadyPlanMemberButton.click();
		return validateNew(alreadyPlanMemberButtonActive);

	}

	public Boolean validate_textField() {

		validateNew(usernameField);
		usernameField.click();
		usernameField.sendKeys("q1ulayer");
		String user = usernameField.getAttribute("value");
		validateNew(passwordField);
		passwordField.click();
		passwordField.sendKeys("Password");
		String pass = passwordField.getAttribute("value");
		if (user.equalsIgnoreCase("q1ulayer") && pass.equalsIgnoreCase("Password")) {
			return true;
		}
		return false;
	}

	public AcquisitionHomePage navigationSectionHomeLinkClick() {
		validateNew(navigationSectionHomeLink);
		navigationSectionHomeLink.click();
		validateNew(navigationSectionHomeLink);
		if (getTitle().equalsIgnoreCase("Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new AcquisitionHomePage(driver);
		}

		return null;
	}

	public Boolean navigationSectionEnterSearchClick() {
		validateNew(navigationSectionEnterSearch);
		navigationSectionEnterSearch.click();
		navigationSectionEnterSearch.sendKeys("home");
		String search = navigationSectionEnterSearch.getAttribute("value");
		if (search.equalsIgnoreCase("home")) {
			return true;
		}

		return false;
	}

	public Boolean enterInvalidUserNamePassword() {
		validateNew(usernameField);
		usernameField.click();
		usernameField.sendKeys("");
		// usernameField.sendKeys(givenAttributesRow.get(0).getCells().get(0));
		String user = usernameField.getAttribute("value");
		validateNew(passwordField);
		passwordField.click();
		passwordField.sendKeys("pas");
		// passwordField.sendKeys(givenAttributesRow.get(0).getCells().get(1));
		String pass = passwordField.getAttribute("value");
		if (user.equalsIgnoreCase("") && pass.equalsIgnoreCase("pas")) {
			return true;
		}
		return false;
	}

	public Boolean checkErrorMessage() {
		validateNew(signInButton);
		signInButton.click();
		validateNew(signInButton);
		return validateNew(alreadyMemberInvalidCredsErrorMessage);
	}

	public Boolean enterValidUserNamePassword() {
		validateNew(usernameField);
		usernameField.click();
		usernameField.sendKeys("q3ulayer_090");
		// usernameField.sendKeys(givenAttributesRow.get(0).getCells().get(0));
		String user = usernameField.getAttribute("value");
		validateNew(passwordField);
		passwordField.click();
		passwordField.sendKeys("Password@1");
		// passwordField.sendKeys(givenAttributesRow.get(0).getCells().get(1));
		String pass = passwordField.getAttribute("value");
		if (user.equalsIgnoreCase("q3ulayer_090") && pass.equalsIgnoreCase("Password@1")) {
			return true;
		}
		return false;
	}

	public void hoverourplanslink() {
		validateNew(OurPlansLink1);
		// Hover over text
		Actions action = new Actions(driver);
		PageFactory.initElements(driver, this);
		action.moveToElement(OurPlansLink1).build().perform();

		// to click
		// action.click().build().perform();

		validateNew(OurPlansLink1);

		// TODO Auto-generated method stub

	}

	public AcquisitionHomePage findplansbuttonclick() {
		validateNew(FindPlansButton1);
		FindPlansButton1.click();
		validateNew(FindPlansButton1);
		if (getTitle().equalsIgnoreCase("Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new AcquisitionHomePage(driver);
		}

		return null;
	}

	// private PageData ourPlansNav;
	public JSONObject ourPlansNavJson;

	public void ourPlansHover() {
		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
		actions.moveToElement(ourPlansHoverLink);
		actions.moveToElement(ourPlansDropdownText);
		actions.click();
		actions.perform();

	}

	public Boolean cookieValid() {
		validateNew(signInButton);
		signInButton.click();
		// validateNew(signInButton);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		validateNew(myPlansTab);
		if (getCookieName("membervisited") != null) {
			driver.switchTo().window(tabs.get(0));
			if (getCookieName("membervisited") != null) {
				return true;
			}
		}

		return false;
	}

	public Boolean alreadyMemberActiveValid() {

		validateNew(signInButton);
		String timerId = alreadyPlanMemberButtonInactive.getAttribute("id");
		if (timerId.contains("cookie")) {
			if (cookieValid()) {
				driver.navigate().refresh();
				String[] parts = timerId.split("-");
				String timerString = parts[1];
				int timer = Integer.parseInt(timerString);
				if (timer > 0) {
					return validateNew(signInButton);
				}
			}
		} else if (timerId.contains("visitor")) {
			String[] parts = timerId.split("-");
			String timerString = parts[1];
			int timer = Integer.parseInt(timerString);
			if (timer > 0) {
				return validateNew(signInButton);
			}

		}
		return false;
	}

	public Boolean cookieTimerValid() {
		driver.navigate().refresh();
		validateNew(signInButton);
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
		return validateNew(signInButton);
	}

	public Boolean stopTimerValid() {
		validateNew(signInButton);
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
					return validateNew(signInButton);
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
				return validateNew(signInButton);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		return null;
	}

	public void hoverhealthandwellnesslink() {

		validateNew(hoverhealthandwellnesslink);
		// Hover over text
		Actions action = new Actions(driver);
		PageFactory.initElements(driver, this);
		action.moveToElement(hoverhealthandwellnesslink).build().perform();

		// TODO Auto-generated method stub

	}

	public JSONObject accessinghealthandwellnesslink() {

		hoverhealthandwellnesslink();
		return getHealthandWellnessDropdownJson();
	}

	public JSONObject getHealthandWellnessDropdownJson() {

		String fileName = CommonConstants.HEALTH_AND_WELLNESS_DROPDOWN_DATA;
		healthandwellnessdropdown = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : healthandwellnessdropdown.getExpectedData().keySet()) {
			WebElement element = findElement(healthandwellnessdropdown.getExpectedData().get(key));
			if (element != null) {
				if (validateNew(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		healthandwellnessdropdownJson = jsonObject;

		return healthandwellnessdropdownJson;

	}

	public JSONObject validatesDTMTags() {
		String fileName = CommonConstants.GLOBAL_FOOTER_PAGE_DATA;
		String filePath = CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ;
		String dtmFilePath = CommonConstants.DTM_TAG_ACQ_FILENAME;
		String dtmDir = CommonConstants.PAGE_OBJECT_DTM_TAG_DIR;
		globalFooterDTMJson = getDTMPageJson(fileName, filePath, dtmFilePath, dtmDir);
		return globalFooterDTMJson;

	}

	public void multiple_county(String zipcode) {
		System.out.println("Hi");
		sendkeys(zipCodeField, zipcode);
		System.out.println("Hi");
		viewPlansButton.click();
		if (countyModal.isDisplayed()) {
			System.out.println("County model window appeared");
		} else {
			System.out.println("County model window not found");
		}
	}

	public VPPPlanSummaryPage searchPlansWithOutCounty(String zipcode) {
		
		CommonUtility.waitForPageLoadNew(driver, zipCodeField, 30);
		sendkeys(zipCodeField, zipcode);

		viewPlansButton.click();
		CommonUtility.waitForPageLoadNew(driver, vppTop, 30);
		if (driver.getCurrentUrl().contains("health-plans")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public void navigateToRequestMoreHelpAndInformation(String planType) {
		Actions action = new Actions(driver);
		PageFactory.initElements(driver, this);
		action.moveToElement(navigationSectionHomeLink).moveToElement(ourPlansHoverLink).build().perform();
		moreHelpInfoLink.click();
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

	public void OurPlanMALanding() {

		Actions action = new Actions(driver);
		action.moveToElement(navigationSectionOurPlansLink).build().perform();

		MALandingLink.click();

		try {
			Thread.sleep(15000);
			System.out.println("Thread Sleep completed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public PharmacySearchPage navigateToPharmacyLocator() {
		Actions action = new Actions(driver);
		action.moveToElement(navigationSectionHomeLink).moveToElement(ourPlansHoverLink).build().perform();
		pharmacylocator.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().toLowerCase().contains((PageTitleConstants.BLAYER_LOCATE_A_PHARMACY_UNITEDHEALTHCARE).toLowerCase())) {
			return new PharmacySearchPage(driver);
		}
		return null;

	}

	public PDPRequestHelpAndInformationPage navigateToPDPMoreHelpAndInfo() {

		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
		actions.moveToElement(ourPlansHoverLink);
		actions.moveToElement(pdp_moreHelpInfoLink);
		actions.click().build().perform();
		if (currentUrl().contains("prescription-drug-plans/request-information.html")) {
			return new PDPRequestHelpAndInformationPage(driver);
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
		CommonUtility.waitForPageLoadNew(driver, requestAgentApptDropdown, 60);
		if (validateNew(requestAgentApptDropdown)) {
			return new RequestHelpAndInformationPage(driver);
		}

		return null;
	}

	public AboutUsAARPPage aboutUsFooterClick() {
		validateNew(footerAboutUsLink);
		footerAboutUsLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (getTitle().contains("About UnitedHealthcare")) {
			return new AboutUsAARPPage(driver);
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
		//validateNew(footerRequestforAssistancelink);
		validateNew(footerAccessibilitylink);
		validateNew(aarpOrgLink);
		validateNew(medicareAdvantagePlansLink);
		validateNew(medicareSupplementInsurancePlansLink);
		validateNew(medicarePrescriptionDrug_PlansLink);
		validateNew(learnAboutMedicareLink);
		validateNew(viewAllDisclaimerInformationLink);

	}

	public ContactUsAARPPage contactUsFooterClick() {
		validateNew(footerContactUsLink);
		footerContactUsLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("contact-us")) {
			return new ContactUsAARPPage(driver);
		}
		return null;
	}
	
	public SiteMapAARPPage siteMapFooterClick() {
		validateNew(footerSiteMapLink);
		footerSiteMapLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(siteMapHeader);
		if (driver.getCurrentUrl().contains("sitemap.html")){
			return new SiteMapAARPPage(driver);
		}
		return null;
	}
	
		
	
	public PrivacyPolicyAARPPage privacypolicyFooterClick() {
		validateNew(footerPrivacyPolicyLink);
		footerPrivacyPolicyLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(privacyHeader);
		if (driver.getCurrentUrl().contains("privacy_policy.html")) {
			return new PrivacyPolicyAARPPage(driver);
		}
		return null;
	}

	public TermsnConditionsAARPPage termsnconditionsFooterClick() {
		validate(footerTermsnConditionsLink);
		footerTermsnConditionsLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("terms_and_conditions")) {
			return new TermsnConditionsAARPPage(driver);
		}
		return null;
	}
	
	public DisclaimersAARPPage disclaimersFooterClick() {
		validate(footerDisclaimersLink);
		footerDisclaimersLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("disclaimer")) {
			return new DisclaimersAARPPage(driver);
		}
		return null;
	}
	
	public AgentsnBrokersAARPPage agentsnbrokersFooterClick() {
		validate(footerAgentsnBrokersLink);
		footerAgentsnBrokersLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(brokerHeader);
		if(driver.getCurrentUrl().contains("health-insurance-brokers")){
			return new AgentsnBrokersAARPPage(driver);
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
	
	public void clickRequestAsistancce() {
		validateNew(footerRequestforAssistancelink);
		if(proactiveChatExitBtn!=null)
			proactiveChatExitBtn.click();
		footerRequestforAssistancelink.click();
		CommonUtility.waitForPageLoadNew(driver, requestAssistanceModal, 30);
		validateNew(requestAssistanceTitle);
		validateNew(requestAssistanceAgentID);
		requestAssistanceClose.click();
		waitforElementDisapper(By.id("cobrowse-disclaimer"), 30);
	}
	public boolean validateSomeElementsOnPage() {
		if (validateNew(zipCodeField) && validateNew(findPlansButton) && validateNew(lookzip))
			return true; // if all three
		return false;

	}

	public boolean validateAllElementsOnPage() {
		if (!validateNew(zipCodeField) && !validateNew(findPlansButton) && !validateNew(lookzip))
			return false; // if all three elements return false for validation
							// then this condition passes due to ! and returns
							// false meaning all three elements were not found
							// on page
		return true;
	}

	public GetStartedPage navigateToPrescriptionDrug() {
		enterYourDrugListButton.click();
		if (getTitle().equalsIgnoreCase("Our Medicare Plan Types | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new GetStartedPage(driver);
		} else {
			return null;
		}
	}

	public DrugCostEstimatorPage navigateToDCEToolFromHome() throws InterruptedException {
		validateNew(getStarted);
		getStarted.click();

		if (driver.getCurrentUrl().contains("health-plans/estimate-drug-costs.html"))
			return new DrugCostEstimatorPage(driver);
		return null;
	}

	public VPPPlanSummaryPage ZipcodeSearch(String zipcode) {
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
		ViewPlansPricingButton.click();

		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
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
	
	public WebElement getLnkLearnAboutMedicare() {
		return lnkLearnAboutMedicare;
	}

	public LearnAboutMedicareHomePage openLearnAboutMedicarePage() {

		getLnkLearnAboutMedicare().click();
		validateNonPresenceOfElement(zipCodeField);
		return new LearnAboutMedicareHomePage(driver);
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
	
	public ProviderSearchPage clicksOnRallyToolFromGlobalHeader() {

		Actions action = new Actions(driver);
		action.moveToElement(navigationSectionHomeLink).moveToElement(ourPlansHoverLink).build().perform();
		validateNew(providerSearchFromGlobalHeader);

		switchToNewTabNew(providerSearchFromGlobalHeader);

		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("werally")) {

			return new ProviderSearchPage(driver);

		}
		return null;
	}

	public ProviderSearchPage clicksOnRallyToolFromHomePage() {
		validateNew(providerSearchFromHomeScreen);

		switchToNewTabNew(providerSearchFromHomeScreen);

		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("werally")) {

			return new ProviderSearchPage(driver);

		}
		return null;
	}
	public AcquisitionHomePage hovershopaplan() throws InterruptedException {
		
		waitforElement(ShopForaplan);
		if (ShopForaplan.isDisplayed()) {
			Actions actions = new Actions(driver);
			actions.moveToElement(ShopForaplan);
			waitforElementNew(submit);
			System.out.println("Submit button is displayed");
			return new AcquisitionHomePage(driver);
	      }
		else {
			return null;}
	
	
}
	public DrugCostEstimatorPage navigationDrugCostEstimator() {
     	navigateToMenuLinks(ShopForaplan, headerDrugCostEstimatorLink);

     	
     		return new DrugCostEstimatorPage(driver);
	 }
	
	public ShopforaplanAARPlayer Hoveronaplan() throws InterruptedException
    {             
           waitforElement(ShopForaplan);
     if (ShopForaplan.isDisplayed()) {
            Actions action = new Actions(driver);
            action.moveToElement(ShopForaplan).build().perform();
            return new ShopforaplanAARPlayer(driver);
     }
           else {
                  return null;}
    }
	
}