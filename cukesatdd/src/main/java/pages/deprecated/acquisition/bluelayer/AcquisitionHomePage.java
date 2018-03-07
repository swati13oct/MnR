package pages.deprecated.acquisition.bluelayer;

/*@author pagarwa5*/

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

//import pages.acquisition.ulayer.MaViewPlansAndPricingPage;
//import pages.acquisition.ulayer.MsViewPlansAndPricingPage;
//import pages.acquisition.ulayer.PdpViewPlansAndPricingPage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;

public class AcquisitionHomePage extends GlobalWebElements {

	@FindBy(id = "lookzip")
	private WebElement lookupZipcode;

	@FindBy(id = "takequizbtn")
	private WebElement takequizbtn;

	@FindBy(id = "compareplans")
	private WebElement compareplans;

	@FindBys(value = {@FindBy(xpath = "//ul[@id='topic-selectSelectBoxItOptions']/li")})
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

	@FindBy(id = "vpp_selectcounty_box")
	private WebElement countyModal;

	@FindBy(id = "ipeL")
	private WebElement feedBackPopUp;

	@FindBy(id = "dce")
	private WebElement prescriptionsLink;
	
	@FindBys(value = { @FindBy(xpath = "//table[@id='colhowdoesthiswork']/tbody/tr/td/span/span/a") })
	private List<WebElement> howdoesthiswork;

	@FindBy(id = "learn-zipcode")
	private WebElement learnzipCodeField;

	@FindBy(xpath = "//*[@id='subnav_2']/div/div/div[1]/div[1]/div[2]/h3/a/span")
	private WebElement pdpVppLink;

	@FindBy(id = "learnfindplanBtn")
	private WebElement learnfindPlansButton;

	@FindBy(id = "homefooter")
	private WebElement homefooter;

	@FindBy(id = "atdd_ma_plans")
	private WebElement ma_moreHelpInfoLink;

	@FindBy(id = "atdd_mpd_plans")
	private WebElement pdp_moreHelpInfoLink;

	@FindBys(value = { @FindBy(xpath = "//table[@id='selectcountytable']/tbody/tr/td") })
	List<WebElement> countyRows;

	@FindBy(linkText = "View all disclaimer information")
	private WebElement disclaimerViewLink;

	@FindBy(id = "Find a pharmacy near you")
	private WebElement pharmacyNearLink_MA;

	@FindBy(id = "Find a pharmacy near you")
	private WebElement pharmacyNearLink;

	@FindBy(className = "disclaimer hideLink")
	private WebElement disclaimerHideLink;

	@FindBy(id = "medicareTitle")
	private WebElement medicareTitleText;
	@FindBy(className = "fd_myPlans")
	private WebElement myPlansTab;

	@FindBy(linkText = "pharmacy")
	private WebElement pharmacyLink;

	@FindBy(id = "ghn_lnk_2")
	private WebElement ourPlans;

	@FindBy(id = "ghn_lnk_1")
	private WebElement Home;

	@FindBy(linkText = "Request More Help and Information")
	private WebElement requestInfoLink;

	@FindBy(xpath = "//*[@id='subnav_2']/div/div/div[1]/div[1]/div[2]/h3/a/span")
	private WebElement maVppLink;

	@FindBy(id = "findazip_box")
	private WebElement zipCodeSearchPopup;

	@FindBy(xpath = "//div[@id='findazip_box']/div/div/div/h4")
	private WebElement zipCodeSearchPopupHeading;

	@FindBy(id = "cobrowse-disclaimer")
	private WebElement cobrowsemodelwindow;

	private PageData homePageDisclaimer;
	public JSONObject homePageDisclaimerJson;
	private PageData homePageDisclaimerHide;
	public JSONObject homePageDisclaimerHideJson;

	private PageData globalFooter;

	public JSONObject globalFooterJson;

	private PageData globalHeader;
	public JSONObject globalHeaderJson;

	private PageData alreadyPlanMember;
	public JSONObject alreadyPlanMemberJson;

	private PageData medicareEducationDropDown;
	public JSONObject medicareEducationDropDownJson;

	private PageData ourPlansNav;
	public JSONObject ourPlansNavJson;

	private PageData browserCheckData;
	public JSONObject browserCheckJson;

	private PageData cobrowseData;
	public JSONObject cobrowseJson;
	private static String UMS_ACQISITION_PAGE_URL = MRConstants.UHC_URL;

	public AcquisitionHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		driver.manage().window().maximize();
	}

	public GetStartedPage navigateToPrescriptionDrug() {
		prescriptionsLink.click();

		for(int i = 0; i<10;i++){
			if (driver.getTitle().equalsIgnoreCase(
					"Our Medicare Plan Types | UnitedHealthcare®")) {

				return new GetStartedPage(driver);
			}else{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;

	}

	public ZipcodeLookupHomePage looksupforZipcodes() {

		lookupZipcode.click();

		CommonUtility.waitForPageLoadNew(driver, zipCodeSearchPopup,
				CommonConstants.TIMEOUT_30);
		if (zipCodeSearchPopupHeading.getText().equalsIgnoreCase(
				"Find a ZIP code")) {
			System.out.println("zipCodeSearchPopupHeading");
			return new ZipcodeLookupHomePage(driver);
		}
		return null;

	}

	public JSONObject accessingGlobalFooter() {

		String fileName = CommonConstants.GLOBAL_FOOTER_PAGE_DATA;
		globalFooter = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : globalFooter.getExpectedData().keySet()) {
			WebElement element = findElement(globalFooter.getExpectedData()
					.get(key));
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

	public JSONObject accessingGlobalHeader() {

		String fileName = CommonConstants.GLOBAL_HEADER_PAGE_DATA;
		globalHeader = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : globalHeader.getExpectedData().keySet()) {
			WebElement element = findElement(globalHeader.getExpectedData()
					.get(key));
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
		globalHeaderJson = jsonObject;

		return globalHeaderJson;

	}

	public JSONObject getBrowserCheck() {
		String fileName = CommonConstants.UHC_BROWSER_CHECK_DATA;
		browserCheckData = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : browserCheckData.getExpectedData().keySet()) {
			WebElement element = findElement(browserCheckData.getExpectedData()
					.get(key));
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
		browserCheckJson = jsonObject;

		return browserCheckJson;
	}

	public JSONObject accessViewAllDisclaimerInformation() {
		disclaimerViewLink.click();
		String fileName = CommonConstants.HOME_PAGE_DISCLAIMER_DATA;
		homePageDisclaimer = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : homePageDisclaimer.getExpectedData().keySet()) {
			WebElement element = findElement(homePageDisclaimer
					.getExpectedData().get(key));
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
		homePageDisclaimerJson = jsonObject;

		return homePageDisclaimerJson;
	}

	public JSONObject accessViewAllDisclaimerHideInformation() {
		disclaimerHideLink.click();
		String fileName = CommonConstants.HOME_PAGE_DISCLAIMER_DATA;
		homePageDisclaimerHide = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : homePageDisclaimerHide.getExpectedData().keySet()) {
			WebElement element = findElement(homePageDisclaimerHide
					.getExpectedData().get(key));
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
		homePageDisclaimerHideJson = jsonObject;

		return homePageDisclaimerHideJson;
	}

	public SiteMapUMSPage siteMapFooterClick() {
		validateNew(footerSiteMapLink);
		footerSiteMapLink.click();
		validateNew(footerSiteMapLink);
		if (driver.getTitle().equalsIgnoreCase("Site Map | UnitedHealthcare®")) {
			return new SiteMapUMSPage(driver);
		}
		return null;

	}

	@Override
	public void openAndValidate() {
		//startNew(UMS_ACQISITION_PAGE_URL);
		validateNew(navigationSectionHomeLink);
		validateNew(navigationSectionOurPlansLink);
		validateNew(navigationSectionmedicareEducationLink);
		validateNew(navigationSectionEnterSearch);

		validateNew(zipCodeField);
		validateNew(viewPlansButton);

		validateNew(footerAboutUsLink);
		validateNew(footerContactUsLink);
		validateNew(footerSiteMapLink);
		validateNew(footerPrivacyPolicyLink);
		validateNew(footerTermsAndConditionsLink);
		validateNew(footerDisclaimersLink);
		validateNew(footerAgentsAndBrokersLink);

	}

	public VPPPlanSummaryPage searchPlans(String zipcode, String countyName) {
		sendkeysNew(zipCodeField, zipcode);
		viewPlansButton.click();
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
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getTitle().equalsIgnoreCase(
				"Our Medicare Plan Types | UnitedHealthcare®")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public VPPPlanSummaryPage searchPlansForLearnFindPlans(String zipcode,
			String countyName) {
		sendkeysNew(learnzipCodeField, zipcode);
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
		if (getTitle().equalsIgnoreCase(
				"Our Medicare Plan Types | UnitedHealthcare®")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public String selectsHomeFooter() {
		// TODO Auto-generated method stub
		return null;
	}

	public MedicareAdvantagePlansuhcPage medicareAdvantagePlansClick() {
		validateNew(medicareAdvantagePlansLink);
		medicareAdvantagePlansLink.click();
		validateNew(medicareAdvantagePlansLink);
		if (driver.getTitle().equalsIgnoreCase(
				"Medicare Advantage Plans | UnitedHealthcare®")) {
			return new MedicareAdvantagePlansuhcPage(driver);
		}

		return null;
	}

	public AcquisitionHomePage veiwAllDisclaimerLinkSectionLinksClick() {
		validateNew(GlobalWebElements.viewAllDisclaimerInformationLink);
		GlobalWebElements.viewAllDisclaimerInformationLink.click();

		validateNew(GlobalWebElements.disclaimerBackToTopLink);
		GlobalWebElements.disclaimerBackToTopLink.click();

		validateNew(GlobalWebElements.viewAllDisclaimerInformationLink);
		GlobalWebElements.viewAllDisclaimerInformationLink.click();

		validateNew(GlobalWebElements.hideDiscliamerInformation);
		GlobalWebElements.hideDiscliamerInformation.click();
		if (driver.getTitle().equalsIgnoreCase(
				"Medicare Plans for Different Needs | UnitedHealthcare®")) {
			return new AcquisitionHomePage(driver);
		}
		return null;
	}

	public DisclaimersPage importantDisclaimersClick() {
		validateNew(importantDisclosuresLink);
		importantDisclosuresLink.click();
		validateNew(importantDisclosuresLink);
		if (driver.getTitle().equalsIgnoreCase(
				"Disclaimers | UnitedHealthcare®")) {
			return new DisclaimersPage(driver);
		}
		return null;
	}

	public AcquisitionHomePage navigationSectionHomeLinkClick() {
		validateNew(navigationSectionHomeLink);
		navigationSectionHomeLink.click();
		validateNew(navigationSectionHomeLink);
		if (driver.getTitle().equalsIgnoreCase(
				"Medicare Plans for Different Needs | UnitedHealthcare®")) {
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

	public Boolean validate_alreadyPlanMemberButton_inactive() {

		return validateNew(alreadyPlanMemberButtonInactive);
	}

	public Boolean validate_alreadyPlanMemberButton_active() {
		validateNew(alreadyPlanMemberButton);
		alreadyPlanMemberButton.click();
		return validateNew(alreadyPlanMemberButtonActive);
	}

	public JSONObject getAlreadyPlanMemberJSON() {
		String fileName = CommonConstants.ALREADY_PLAN_MEMBER_PAGE_DATA;
		alreadyPlanMember = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : alreadyPlanMember.getExpectedData().keySet()) {
			WebElement element = findElement(alreadyPlanMember
					.getExpectedData().get(key));
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
		alreadyPlanMemberJson = jsonObject;

		return alreadyPlanMemberJson;
	}

	public Boolean validate_textField() {
		validateNew(usernameField);
		usernameField.click();
		usernameField.sendKeys("q1blayer");
		String user = usernameField.getAttribute("value");
		validateNew(passwordField);
		passwordField.click();
		passwordField.sendKeys("Password");
		String pass = passwordField.getAttribute("value");
		if (user.equalsIgnoreCase("q1blayer")
				&& pass.equalsIgnoreCase("Password")) {
			return true;
		}
		return false;
	}

	public LoginAssistancePage forgotUsernamePasswordClick() {
		validateNew(forgotUsernameLink);
		forgotUsernameLink.click();
		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		validateNew(medicareTitleText);
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"UnitedHealthcare Medicare Solutions |Username and Password Assistance")) {
			return new LoginAssistancePage(driver);
		}
		return null;

	}

	public VPPPlanSummaryPage enterZipcode(String zipCode, String county,
			String planYear) {
		sendkeysNew(zipCodeField, zipCode);
		viewPlansButton.click();
		return new VPPPlanSummaryPage(driver);
	}

	public RegistrationHomePage registerHereLinkClick() {
		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		/*
		 * validate(alreadyPlanMemberButton); alreadyPlanMemberButton.click();
		 */
		validateNew(registerHereLink);
		registerHereLink.click();
		ArrayList<String> tabs1 = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs1.get(2));
		validateNew(medicareTitleText);
		if (driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Registration")) {
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
		ourPlansNav = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : ourPlansNav.getExpectedData().keySet()) {
			WebElement element = findElement(ourPlansNav.getExpectedData().get(
					key));
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
		ourPlansNavJson = jsonObject;

		return ourPlansNavJson;
	}

	public JSONObject accessMedicareEducationDropDown() {

		validateNew(navigationSectionMedicareEducationLink);

		Actions actions = new Actions(driver);
		actions.moveToElement(navigationSectionMedicareEducationLink);
		actions.moveToElement(learnAboutMedicareMedicareEducationLink);
		actions.perform();
		String fileName = CommonConstants.MEDICARE_EDUCATION_SECTION_DATA;
		medicareEducationDropDown = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : medicareEducationDropDown.getExpectedData().keySet()) {
			WebElement element = findElement(medicareEducationDropDown
					.getExpectedData().get(key));
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
		medicareEducationDropDownJson = jsonObject;

		return medicareEducationDropDownJson;
	}

	public JSONObject enterZipCode(String zipCode) {
		ourPlansHover();
		validateNew(zipcodeField);
		zipcodeField.sendKeys(zipCode);
		findPlansButton.click();
		return getOurPlanDropDownJson();

	}

	public LearnAboutMedicareuhcPage learnAboutMedicareClick() {
		validateNew(navigationSectionMedicareEducationLink);
		Actions actions = new Actions(driver);
		actions.moveToElement(navigationSectionMedicareEducationLink);
		actions.moveToElement(learnAboutMedicareMedicareEducationLink);
		actions.click().build().perform();
		if (driver.getTitle().equalsIgnoreCase(
				"Learn About Medicare | UnitedHealthcare®")) {
			return new LearnAboutMedicareuhcPage(driver);
		}

		return null;
	}

	public MedicareAdvantagePlansuhcPage headerMedicareAdvantageClick() {
		ourPlansHover();
		validateNew(headerMedicareAdvantagePlansLink);
		headerMedicareAdvantagePlansLink.click();
		validateNew(headerMedicareAdvantagePlansLink);
		if (driver.getTitle().equalsIgnoreCase(
				"Medicare Advantage Plans | UnitedHealthcare®")) {
			return new MedicareAdvantagePlansuhcPage(driver);
		}
		return null;
	}

	public void navigateToRequestMoreHelpAndInformation(String planType){
		Actions action = new Actions(driver);
		action.moveToElement(Home).moveToElement(ourPlans).build().perform();
		if(planType.contains("MA"))
			ma_moreHelpInfoLink.click();
		else if(planType.contains("PDP")){
			pdp_moreHelpInfoLink.click();		
		}
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(driver.getCurrentUrl().contains("request-information"))
				break;
		}

	}

	public PharmacySearchPage navigateToPharmacyLocator(String planType) {


		if(planType.contains("MA"))
			pharmacyNearLink_MA.click();
		else if(planType.contains("PDP")){
			pharmacyNearLink.click();		
		}


		for(int i=0;i<10;i++){
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(driver.getCurrentUrl().contains("-pharmacy."))
				break;
		}
		if (driver.getTitle().equalsIgnoreCase(
				"Locate a Pharmacy | UnitedHealthcare®")) {
			return new PharmacySearchPage(driver);
		}
		return null;

	}

	public MedicareSpecialNeedsPlansuhcPage medicareSpecialNeedPlansLinkClick() {
		ourPlansHover();
		validateNew(headerMedicareSpecialNeedPlansLink);
		headerMedicareSpecialNeedPlansLink.click();
		validateNew(headerMedicareSpecialNeedPlansLink);
		if (driver.getTitle().equalsIgnoreCase(
				"Medicare Special Needs Plans | UnitedHealthcare®")) {
			return new MedicareSpecialNeedsPlansuhcPage(driver);
		}
		return null;
	}

	public OurPlansPage findPlanButtonClick(String zipCode) {
		ourPlansHover();
		validateNew(zipcodeField);
		zipcodeField.sendKeys(zipCode);
		findPlansButton.click();
		if (driver.getTitle().equalsIgnoreCase(
				"Our Medicare Plan Types | UnitedHealthcare®")) {
			return new OurPlansPage(driver);
		}
		return null;
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
	public Object navigatesToVppSection(String planType) {

		if (validateNew(feedBackPopUp)) {
			popUpcloseLink.click();
		}

		Actions actions = new Actions(driver);
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
		if (currentUrl().contains("medicare-advantage-plans.html")) {
			return new MaViewPlansAndPricingPage(driver);
		}
		if (currentUrl().contains("prescription-drug-plans.html")) {
			return new PdpViewPlansAndPricingPage(driver);
		}
		if (currentUrl().contains("medicare-supplement-plans.html")) {
			return new MsViewPlansAndPricingPage(driver);
		}
		 */
		return null;
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
		usernameField.sendKeys("q1blayer_001");
		// usernameField.sendKeys(givenAttributesRow.get(0).getCells().get(0));
		String user = usernameField.getAttribute("value");
		validateNew(passwordField);
		passwordField.click();
		passwordField.sendKeys("Password@1");
		// passwordField.sendKeys(givenAttributesRow.get(0).getCells().get(1));
		String pass = passwordField.getAttribute("value");
		if (user.equalsIgnoreCase("q1blayer_001")
				&& pass.equalsIgnoreCase("Password@1")) {
			return true;
		}
		return false;
	}

	/*public AccountHomePage signInValid() {
		validate(signInButton);
		signInButton.click();
		// validate(signInButton);

		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | My Account Home")) {
			return new AccountHomePage(driver);
		}

		return null;
	}*/

	public Boolean cookieValid() {
		validateNew(signInButton);
		signInButton.click();
		// validate(signInButton);
		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());
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

	public OurPlansPage navigationSectionOurPlansLinkClick() {
		navigationSectionOurPlansLink.click();
		if (getTitle()
				.equalsIgnoreCase(
						"Our Medicare Plan Types | UnitedHealthcare®")) {
			return new OurPlansPage(driver);
		}

		return null;
	}
	public Object pickatopic(String picktopic) {

		selectSelectBoxIt.click();
		for (WebElement element : topicDropDownValues) {
			if(element.getText().equalsIgnoreCase(picktopic)){
				element.click();
				picktopicbtn.click();
				break;
			}
		}

		if (currentUrl().contains("/medicare-education/about")) {
			if(getTitle().equals("Learn About Medicare | UnitedHealthcare®")){
				return new LearnAboutMedicareuhcPage(driver);
			}
		} else if(currentUrl().contains("medicare-education/enroll")){
			if(getTitle().equals("Prepare for Your Medicare Initial Enrollment Period | UnitedHealthcare®")){
				return new PrepareForInitialEnrollmentuhcPage(driver);
			}
		}

		return null;
	}

	public PlanSelectorPage  planselector() {
		takequizbtn.click();
		if (getTitle().equalsIgnoreCase("Plan Selector")) {
			return new PlanSelectorPage(driver);
		} 
		return null;
	}
	public ContactUsUmsPage contactUsFooterClick()
	{
		validateNew(footerContactUsLink);
		footerContactUsLink.click();
		validateNew(footerContactUsLink);
		if (driver.getCurrentUrl().contains("/contact-us.html"))
		{
			return new ContactUsUmsPage(driver);
		}
		else
		{
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
		actions.moveToElement(ourPlansHoverLink);
		actions.moveToElement(ma_moreHelpInfoLink);
		actions.click().build().perform();

		try {
			if (zipCodeField.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, zipCodeField,
						CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("zipCodeField not found");
		} catch (TimeoutException ex) {
			System.out.println("zipCodeField not found");
		} catch (Exception e) {
			System.out.println("zipCodeField not found");
		}
		if (currentUrl().contains(
				"medicare-advantage-plans/request-information.html")) {
			return new RequestHelpAndInformationPage(driver);
		}

		return null;
	}

	public VPPPlanSummaryPage navigateToVpp(String zipcode)
	{
		
		sendkeysNew(zipCodeField, zipcode);
		viewPlansButton.click();
		
		if (getTitle().equalsIgnoreCase(
				"Our Medicare Plan Types | UnitedHealthcare®")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public RequestForAssistanceUMSPage requestforassistanceclick()
	{
		validateNew(footerRequestforAssistanceLink);
		footerRequestforAssistanceLink.click();
		if (cobrowsemodelwindow.isDisplayed())
		{
			return new RequestForAssistanceUMSPage(driver);
		}
		else
		{
			return null;
		}
	}

	public JSONObject validatecobrowsemodelwindow()
	{
		String fileName=CommonConstants.COBROWSE_MODEL_WINDOW;
		cobrowseData=CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

		JSONObject jsonObject= new JSONObject();
		for (String key : cobrowseData.getExpectedData().keySet()) {
			WebElement element = findElement(cobrowseData.getExpectedData()
					.get(key));
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
		cobrowseJson= jsonObject;
		return cobrowseJson;
	}
	public VPPPlanSummaryPage searchPlansWithOutCounty(String zipcode) {
		sendkeysNew(zipCodeField, zipcode);
		viewPlansButton.click();
		/*try {
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
					}*/
		if (driver.getTitle().equalsIgnoreCase(
				"Our Medicare Plan Types | UnitedHealthcare®")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public PDPRequestHelpAndInformationPage navigateToPDPMoreHelpAndInfo() {

		Actions actions = new Actions(driver);
		actions.moveToElement(ourPlansHoverLink);
		actions.moveToElement(pdp_moreHelpInfoLink);
		actions.click().build().perform();

		if (currentUrl().contains("prescription-drug-plans/request-information.html")) {
			return new PDPRequestHelpAndInformationPage(driver);
		}

		return null;

	}
	
	public boolean validateFooterLinks(JSONObject jsonObj){
		boolean flag = true;
		
		try {
			if(!jsonObj.get("footerPrivacyPolicyLink").equals("Privacy Policy"))
				flag = false;
			if(!jsonObj.get("footerDisclaimersLink").equals("Disclaimers"))
				flag = false;
			if(!jsonObj.get("footerHomeLink").equals("Home"))
				flag = false;
			if(!jsonObj.get("footerContactUsLink").equals("Contact Us"))
				flag = false;
			if(!jsonObj.get("footerAgentsAndBrokersLink").equals("Agents & Brokers"))
				flag = false;
			if(!jsonObj.get("footerAboutUsLink").equals("About Us"))
				flag = false;
			if(!jsonObj.get("footerSiteMapLink").equals("Site Map"))
				flag = false;
			if(!jsonObj.get("footerTermsofUseLink").equals("Terms of Use"))
				flag = false;
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
}

