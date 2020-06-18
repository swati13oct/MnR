package pages.vbfacquisition_deprecated.ulayer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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


	@FindBy(id = "zipcodebtn")
	private WebElement viewPlansButton;
	
	@FindBy(xpath = "//div[@class='modal-title']")
	private WebElement countyModal;
	

	@FindBy(id = "homefooter")
	private WebElement homefooter;

	@FindBys(value = { @FindBy(id="selectCounty")})
	List<WebElement> countyRows;

	@FindBy(xpath = "/html/body/div[3]/div/table/tbody/tr[3]/td/table/tbody/tr[2]/td/div/div[2]/div/div/div[2]/div/ul/li[2]/a")
	WebElement zipCodebtn;

	@FindBy(xpath="//a[contains(text(),'Request More Help')]")
	private WebElement pdp_moreHelpInfoLink;

	@FindBy(xpath = ".//*[@id='atdd_ma_plans']/span")
	private WebElement ma_moreHelpInfoLink;
	
	@FindBy(xpath="//a[contains(text(),'Request More')]")
	private WebElement moreHelpInfoLink;

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

	private static String AARP_ACQISITION_PAGE_URL = MRConstants.AARP_URL;
	private static String AARP_ACQISITION_OFFLINE_PAGE_URL = MRConstants.AARP_URL_OFFLINE;

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
		if (MRScenario.environment.equals("offline")) {
			start(AARP_ACQISITION_OFFLINE_PAGE_URL);
		}else{
			start(AARP_ACQISITION_PAGE_URL);
		}
		validate(navigationSectionHomeLink);
		validate(navigationSectionOurPlansLink);
		validate(navigationSectionMedicareEducationLink);
		validate(navigationSectionEnterSearch);
		//validate(getStartedButton);

		validate(zipCodeField);
		validate(viewPlansButton);
		//validate(po7Link);

		validate(footerAboutUsLink);
		validate(footerContactUsLink);
		validate(footerSiteMapLink);
		validate(footerPrivacyPolicyLink);
		validate(footerTermsAndConditionsLink);
		validate(footerDisclaimersLink);
		validate(footerAgentsAndBrokersLink);

	}

	public VPPPlanSummaryPage searchPlans(String zipcode, String countyName) {
		
		
		try {
			Thread.sleep(10000);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sendkeys(zipCodeField, zipcode);
		
		viewPlansButton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			if (countyModal.isDisplayed()) {
				driver.findElement(By.xpath("//div[@id='selectCounty']//a[text()='"+countyName+"']")).click();
			}
		} catch (Exception e) {
			System.out.println("county box not found");
		}
		
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
	
	public VPPPlanSummaryPage navigateToVpp(String zipcode)
	{
		
		sendkeys(zipCodeField, zipcode);
		viewPlansButton.click();
		
		try {	
			Thread.sleep(4000);	
		} catch (InterruptedException e) {	
			// TODO Auto-generated catch block	
			e.printStackTrace();	
		}

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
		PageFactory.initElements(driver, this);
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

	

	public void ourPlansHover() {
		Actions actions = new Actions(driver);
		PageFactory.initElements(driver, this);
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
		PageFactory.initElements(driver, this);
		action.moveToElement(navigationSectionHomeLink).moveToElement(ourPlansHoverLink).build().perform();
		/*if(planType.contains("MA"))
				ma_moreHelpInfoLink.click();
		else if(planType.contains("PDP")){
				pdp_moreHelpInfoLink.click();		
		}*/
		moreHelpInfoLink.click();
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
		driver.manage().window().maximize();
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
		if (driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_LOCATE_A_PHARMACY_UNITEDHEALTHCARE)) {
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
	
	public AboutUsAARPPage aboutUsFooterClick() {
		validate(GlobalWebElements.footerAboutUsLink);
		GlobalWebElements.footerAboutUsLink.click();
		validate(GlobalWebElements.footerAboutUsLink);

		if (getTitle().equalsIgnoreCase("About UnitedHealthcare® | AARP® Medicare Plans from UnitedHealthcare")) {
			return new AboutUsAARPPage(driver);
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
			if(!jsonObj.get("footerAgentsnBrokersLink").equals("Agents & Brokers"))
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
	
	public boolean validateSomeElementsOnPage(){
		if(validate(zipCodeField)&&validate(findPlansButton)&&validate(lookzip))
			return true; //if all three
		return false;
		
	}
	
	public boolean validateAllElementsOnPage(){
		if(!validate(zipCodeField)&&!validate(findPlansButton)&&!validate(lookzip))
			return false; //if all three elements return false for validation then this condition passes due to ! and returns false meaning all three elements were not found on page
		return true;
	}

	public GetStartedPage navigateToPrescriptionDrug() {
        enterYourDrugListButton.click();
        if (getTitle().equalsIgnoreCase("Our Medicare Plan Types | AARP® Medicare Plans from UnitedHealthcare®")) {
                return new GetStartedPage(driver);
        } else {
                return null;
        }

}}