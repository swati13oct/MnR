package pages.acquisition.ulayer;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;

/**
 * @author pperugu
 *
 */
public class AcquisitionHomePage extends GlobalWebElements {

	@FindBy(id = "cta-zipcode")
	private WebElement zipCodeField;

	@FindBy(id = "topic-selectSelectBoxIt")
	private WebElement selectSelectBoxIt;

	@FindBy(className = "fd_myPlans")
	private WebElement myPlansTab;

	@FindBy(id = "dce")
	private WebElement enterYourDrugListButton;

	@FindBy(id = "learnfindplanBtn")
	private WebElement learnfindPlansButton;
	
	@FindBy(linkText = "Find a pharmacy near you")
	private WebElement pharmacyNearLink;

	@FindBy(className = "zip-button")
	private WebElement FindPlansButton1;

	@FindBy(xpath = "//*[@id='ghn_lnk_2']")
	private WebElement OurPlansLink1;

	@FindBy(xpath = "//a[text()='Look up ZIP code']")
	private WebElement LookUpZipCode1;

	@FindBy(xpath = "//*[@id='zipLookup']/p/a")
	private WebElement lookupZipcode21;

	@FindBy(xpath = "//*[@id='subnav_2']/div/div/div[2]/form/span/span")
	private WebElement errormessage1;

	@FindBy(className = "zip-button")
	private WebElement FindPlansButton;

	@FindBy(id = "zipcodebtn")
	private WebElement findPlansButton;
	
	@FindBy(id="takequizbtn")
	private WebElement takequizbtn;

	@FindBy(id = "compareplans")
	private WebElement compareplans;

	@FindBy(id = "picktopicbtn")
	private WebElement picktopicbtn;

	@FindBy(id = "learn-zipcode")
	private WebElement learnzipCodeField;

	@FindBy(id = "chooseUhcBtn")
	private WebElement chooseUhcButton;

	@FindBy(id = "state_select")
	private WebElement stateDropDown;

	@FindBy(id = "topic-selectSelectBoxIt")
	private WebElement topicselect;

	@FindBy(id = "pageHeader")
	private WebElement pageHeader;

	@FindBys(value = { @FindBy(xpath = "//ul[@id='topic-selectSelectBoxItOptions']/li") })
	private List<WebElement> topicDropDownValues;

	@FindBy(id = "lookzip")
	private WebElement lookzip;

	@FindBy(id = "findazip_box")
	private WebElement zipCodeSearchPopup;

	@FindBy(xpath = "//*[@id='ghn_lnk_2']")
	private WebElement OurPlansLink;

	@FindBy(xpath = "//a[text()='Look up ZIP code']")
	private WebElement LookUpZipCode;

	@FindBy(xpath = "//*[@id='zipLookup']/p/a")
	private WebElement LookUpZipCode2;

	@FindBy(xpath = "//*[@id='subnav_2']/div/div/div[2]/form/span/span")
	private WebElement errormessage;

	@FindBy(id = "zipcodebtn")
	private WebElement viewPlansButton;

	@FindBy(id = "vpp_selectcounty_box")
	private WebElement countyModal;

	@FindBy(id = "homefooter")
	private WebElement homefooter;

	@FindBy(id = "lookzip")
	private WebElement lookupZipcode;

	@FindBy(id = "medicareTitle")
	private WebElement medicareTitleText;

	@FindBy(linkText = "pharmacy")
	private WebElement pharmacyLink;

	@FindBys(value = { @FindBy(xpath = "//table[@id='selectcountytable']/tbody/tr/td") })
	List<WebElement> countyRows;

	@FindBy(xpath = "//div[@id='findazip_box']/div/div/div/h4")
	private WebElement zipCodeSearchPopupHeading;

	@FindBy(xpath = "/html/body/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/div[2]/div/div/div[2]/div/ul/li[2]/a")
	WebElement zipCodebtn;

	@FindBy(className = "disclaimer hideLink")
	private WebElement disclaimerHideLink;

	@FindBy(linkText = "View all disclaimer information")
	private WebElement disclaimerViewLink;

	@FindBy(className = "disclaimerCon")
	private WebElement disclaimerCon;

	@FindBy(className = "disclaimer-extended")
	private WebElement disclaimerExtented;

	@FindBy(id = "insuranceplan")
	private WebElement ourPlans;

	@FindBy(xpath = "//div[@id='insuranceplan_nav']/div/div[1]/ul/li/a/span")
	private WebElement maVppLink;

	@FindBy(xpath = "//div[@id='insuranceplan_nav']/div/div[3]/ul/li/a/span")
	private WebElement pdpVppLink;
	                 
	@FindBy(xpath = ".//*[@id='subnav_2']/div/div/div[1]/div[1]/div[2]/p[2]/a/span")
	private WebElement pdp_moreHelpInfoLink;

	@FindBy(xpath = "//div[@id='subnav_2']/div/div/div/div/div[1]/p[2]/a/span")
	private WebElement ma_moreHelpInfoLink;

	@FindBy(id = "ipeL")
	private WebElement feedBackPopUp;

	@FindBy(xpath = "//div[@id='ipeL']/div[2]/map/area[3]")
	private WebElement popUpcloseLink;

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

	@FindBy(xpath = "//*[@id='ghn_lnk_4']")
	private WebElement hoverhealthandwellnesslink;

	@FindBy(xpath = "//*[@id='subnav_4']/div/div/div[2]/div/a")
	public static WebElement forgotusernamepasswordlink;

	@FindBy(xpath = "//*[@id='medicareTitle']/h1")
	private WebElement usernameassistancetext;

	@FindBy(xpath = "//*[@id='subnav_4']/div/div/div[2]/div/span[2]/a")
	public static WebElement registerherelink;

	@FindBy(xpath = "//*[@id='subnav_4']/div/div/div[1]/div[1]/div[1]/h3/a/span")
	private WebElement healthcenterslink;

	private static String AARP_ACQISITION_PAGE_URL = MRConstants.AARP_URL;

	private PageData globalFooter;
	private PageData browserCheckData;

	public JSONObject globalFooterJson;
	public JSONObject browserCheckJson;

	private PageData homePageDisclaimer;
	public JSONObject homePageDisclaimerJson;

	private PageData homePageDisclaimerHide;
	public JSONObject homePageDisclaimerHideJson;

	private PageData alreadyPlanMember;
	public JSONObject alreadyPlanMemberJson;

	private PageData medicareEducationDropDown;
	public JSONObject medicareEducationDropDownJson;

	private PageData header;
	public JSONObject headerJson;

	private PageData globalHeader;

	public JSONObject globalHeaderJson;

	public JSONObject ourplansdropdownJson;

	private PageData ourplansdropdown;

	public JSONObject homeJson;

	private PageData healthandwellnessdropdown;

	public JSONObject healthandwellnessdropdownJson;

	public JSONObject globalFooterDTMJson;

	public AcquisitionHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	
	public JSONObject accessingGlobalHeader() {

		String fileName = CommonConstants.GLOBAL_HEADER_PAGE_DATA;
		globalHeader = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : globalHeader.getExpectedData().keySet()) {
			WebElement element = findElement(globalHeader.getExpectedData().get(key));
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
		globalHeaderJson = jsonObject;

		return globalHeaderJson;

	}



	@Override
	public void openAndValidate() {
		if (!(currentUrl().contains("aarpmedicareplans"))) {
			start(AARP_ACQISITION_PAGE_URL);
		}
		validate(navigationSectionHomeLink);
		validate(navigationSectionOurPlansLink);
		validate(navigationSectionMedicareEducationLink);
		validate(navigationSectionEnterSearch);
		validate(enterYourDrugListButton);

		validate(zipCodeField);
		validate(viewPlansButton);
		validate(po7Link);

		validate(footerAboutUsLink);
		validate(footerContactUsLink);
		validate(footerSiteMapLink);
		validate(footerPrivacyPolicyLink);
		validate(footerTermsAndConditionsLink);
		validate(footerDisclaimersLink);
		validate(footerAgentsAndBrokersLink);

	}

	public VPPPlanSummaryPage searchPlans(String zipcode, String countyName) {
		
		sendkeys(zipCodeField, zipcode);
		
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
		
		if (driver.getTitle().equalsIgnoreCase("Our Medicare Plans | AARP® Medicare Plans From UnitedHealthcare®")) {
			System.out.println("title matches");
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
		globalFooterJson = jsonObject;

		return globalFooterJson;
	}
	
	public JSONObject getBrowserCheck() {
		String fileName = CommonConstants.AARP_BROWSER_CHECK_DATA;
		browserCheckData = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : browserCheckData.getExpectedData().keySet()) {
			WebElement element = findElement(browserCheckData.getExpectedData()
					.get(key));
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
		browserCheckJson = jsonObject;

		return browserCheckJson;
	}

	public JSONObject accessingOurPlanslink() {

		hoverourplanslink();
		return getOurPlanDropDownJson();
	}

	public JSONObject getOurPlanDropDownJson() {

		String fileName = CommonConstants.OUR_PLANS_DROPDOWN_DATA;
		ourplansdropdown = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : ourplansdropdown.getExpectedData().keySet()) {
			WebElement element = findElement(ourplansdropdown.getExpectedData().get(key));
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
		ourplansdropdownJson = jsonObject;

		return ourplansdropdownJson;

	}

	public JSONObject accessViewAllDisclaimerInformation() {
		validate(disclaimerViewLink);
		disclaimerViewLink.click();
		validate(disclaimerViewLink);
		String fileName = CommonConstants.HOME_PAGE_DISCLAIMER_DATA;
		homePageDisclaimer = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : homePageDisclaimer.getExpectedData().keySet()) {
			WebElement element = findElement(homePageDisclaimer.getExpectedData().get(key));
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
		homePageDisclaimerJson = jsonObject;

		return homePageDisclaimerJson;
	}

	public JSONObject accessViewAllDisclaimerHideInformation() {
		validate(disclaimerHideLink);
		disclaimerHideLink.click();
		validate(disclaimerHideLink);
		String fileName = CommonConstants.HOME_PAGE_DISCLAIMER_DATA;
		homePageDisclaimerHide = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : homePageDisclaimerHide.getExpectedData().keySet()) {
			WebElement element = findElement(homePageDisclaimerHide.getExpectedData().get(key));
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
		homePageDisclaimerHideJson = jsonObject;

		return homePageDisclaimerHideJson;
	}

	

	public AcquisitionHomePage veiwAllDisclaimerLinkSectionLinksClick() {
		validate(GlobalWebElements.viewAllDisclaimerInformationLink);
		GlobalWebElements.viewAllDisclaimerInformationLink.click();

		validate(GlobalWebElements.disclaimerBackToTopLink);
		GlobalWebElements.disclaimerBackToTopLink.click();

		validate(GlobalWebElements.hideDiscliamerInformation);
		GlobalWebElements.hideDiscliamerInformation.click();

		if (getTitle().equalsIgnoreCase("Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new AcquisitionHomePage(driver);
		}
		return null;
	}

	public JSONObject accessBrandSection() {
		String fileName = CommonConstants.HEADER_PAGE_DATA;
		header = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : header.getExpectedData().keySet()) {
			WebElement element = findElement(header.getExpectedData().get(key));
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
		headerJson = jsonObject;

		return headerJson;

	}

	

	public Boolean visitAARPOrgClick() {
		validate(GlobalWebElements.visitAARPLink);
		GlobalWebElements.visitAARPLink.click();
		validate(GlobalWebElements.visitAARPLink);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase("You are now leaving AARPMedicarerx.com")) {
			GlobalWebElements.proceedLink.click();
			if (driver.getCurrentUrl().equals("http://www.aarp.org/")) {
				return true;

			}
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
		alreadyPlanMember = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

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

	public JSONObject accessMedicareEducationDropDown() {

		validate(navigationSectionMedicareEducationLink);

		Actions actions = new Actions(driver);
		actions.moveToElement(navigationSectionMedicareEducationLink);
		actions.moveToElement(learnAboutMedicareMedicareEducationLink);
		actions.perform();
		String fileName = CommonConstants.MEDICARE_EDUCATION_SECTION_DATA;
		medicareEducationDropDown = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

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

	public Boolean validate_textField() {

		validate(usernameField);
		usernameField.click();
		usernameField.sendKeys("q1ulayer");
		String user = usernameField.getAttribute("value");
		validate(passwordField);
		passwordField.click();
		passwordField.sendKeys("Password");
		String pass = passwordField.getAttribute("value");
		if (user.equalsIgnoreCase("q1ulayer") && pass.equalsIgnoreCase("Password")) {
			return true;
		}
		return false;
	}

	

	public AcquisitionHomePage navigationSectionHomeLinkClick() {
		validate(navigationSectionHomeLink);
		navigationSectionHomeLink.click();
		validate(navigationSectionHomeLink);
		if (getTitle().equalsIgnoreCase("Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®")) {
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

	public Boolean checkErrorMessage() {
		validate(signInButton);
		signInButton.click();
		validate(signInButton);
		return validate(alreadyMemberInvalidCredsErrorMessage);
	}

	public Boolean enterValidUserNamePassword() {
		validate(usernameField);
		usernameField.click();
		usernameField.sendKeys("q3ulayer_090");
		// usernameField.sendKeys(givenAttributesRow.get(0).getCells().get(0));
		String user = usernameField.getAttribute("value");
		validate(passwordField);
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
		validate(OurPlansLink1);
		// Hover over text
		Actions action = new Actions(driver);
		action.moveToElement(OurPlansLink1).build().perform();

		// to click
		// action.click().build().perform();

		validate(OurPlansLink1);

		// TODO Auto-generated method stub

	}

	public AcquisitionHomePage findplansbuttonclick() {
		validate(FindPlansButton1);
		FindPlansButton1.click();
		validate(FindPlansButton1);
		if (getTitle().equalsIgnoreCase("Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new AcquisitionHomePage(driver);
		}

		return null;
	}

	

	// private PageData ourPlansNav;
	public JSONObject ourPlansNavJson;

	public JSONObject accessingOurPlansNav() {
		ourPlansHover();
		return getOurPlanDropDownJson();
	}

	public void ourPlansHover() {
		Actions actions = new Actions(driver);
		actions.moveToElement(ourPlansHoverLink);
		actions.moveToElement(ourPlansDropdownText);
		actions.click();
		actions.perform();

	}

	public Boolean cookieValid() {
		validate(signInButton);
		signInButton.click();
		// validate(signInButton);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
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

	
	public void hoverhealthandwellnesslink() {

		validate(hoverhealthandwellnesslink);
		// Hover over text
		Actions action = new Actions(driver);
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


	public void multiple_county(String zipcode)
	{
		System.out.println("Hi");
		sendkeys(zipCodeField, zipcode);
		System.out.println("Hi");
		viewPlansButton.click();
		if (countyModal.isDisplayed())
		{
			System.out.println("County model window appeared");
		}
		else
		{
			System.out.println("County model window not found");
		}
	}
	public VPPPlanSummaryPage searchPlansWithOutCounty(String zipcode) {
		sendkeys(zipCodeField, zipcode);
		viewPlansButton.click();
		if (driver.getTitle().equalsIgnoreCase(
				"Our Medicare Plan Types | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	public void navigateToRequestMoreHelpAndInformation(String planType){
		Actions action = new Actions(driver);
		action.moveToElement(navigationSectionHomeLink).moveToElement(ourPlansHoverLink).build().perform();
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
	
	public PharmacySearchPage navigateToPharmacyLocator() {
		pharmacyNearLink.click();
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
		if (driver.getTitle().equalsIgnoreCase("Find a Pharmacy | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new PharmacySearchPage(driver);
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
	public RequestHelpAndInformationPage navigateToMaMoreHelpAndInfo() {

		Actions actions = new Actions(driver);
		actions.moveToElement(ourPlansHoverLink);
		actions.moveToElement(ma_moreHelpInfoLink);
		actions.click().build().perform();

		try {
			if (zipCodeField.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, zipCodeField,
						20);
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


}