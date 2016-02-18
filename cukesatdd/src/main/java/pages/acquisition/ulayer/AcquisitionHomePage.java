package pages.acquisition.ulayer;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;


import atdd.framework.UhcDriver;


/**
 * @author pperugu
 *
 */
public class AcquisitionHomePage extends GlobalFooterWebElements {

	@FindBy(id = "zipcodevalue")
	private WebElement zipCodeField;

	@FindBy(linkText = "prescriptions")
	private WebElement prescriptionsLink;

	@FindBy(className = "viewplansbtn")
	private WebElement viewPlansButton;

	@FindBy(id = "vpp_selectcounty_box")
	private WebElement countyModal;

	@FindBy(id = "homefooter")
	private WebElement homefooter;

	@FindBy(linkText = "Look up ZIP code")
	private WebElement lookupZipcode;
	
	@FindBy(id = "medicareTitle")
	private WebElement medicareTitleText;

	@FindBy(linkText = "pharmacy")
	private WebElement pharmacyLink;

	@FindBys(value = { @FindBy(xpath = "//table[@id='selectcountytable']/tbody/tr/td") })
	List<WebElement> countyRows;


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

	@FindBy(linkText = "Request More Help and Information")
	private WebElement ma_moreHelpInfoLink;

	@FindBy(id = "ipeL")
	private WebElement feedBackPopUp;

	@FindBy(xpath = "//div[@id='ipeL']/div[2]/map/area[3]")
	private WebElement popUpcloseLink;


	private static String AARP_ACQISITION_PAGE_URL = MRConstants.AARP_URL;
	private PageData globalFooter;
	public JSONObject globalFooterJson;

	private PageData homePageDisclaimer;
	public JSONObject homePageDisclaimerJson;
	
	@FindBy(id = "ghn_lnk_1")
	 public static WebElement navigationSectionHomeLink;

	private PageData homePageDisclaimerHide;
	public JSONObject homePageDisclaimerHideJson;
	
	private PageData alreadyPlanMember;
	public JSONObject alreadyPlanMemberJson;
	
	private PageData header;
	public JSONObject headerJson;
	
	private PageData globalHeader;

    public JSONObject globalHeaderJson;

	public AcquisitionHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public GetStartedPage navigateToPrescriptionDrug() {
		prescriptionsLink.click();
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Our Medicare Plan Types | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new GetStartedPage(driver);
		} else {
			return null;
		}

	}
	
	
	 public JSONObject accessingGlobalHeader() {
	        
	        String fileName = CommonConstants.GLOBAL_HEADER_PAGE_DATA;
	        globalHeader = CommonUtility.readPageData(fileName,
	                     CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
	        
	        JSONObject jsonObject = new JSONObject();
	        for (String key : globalHeader.getExpectedData().keySet()) {
	        WebElement element = findElement(globalHeader.getExpectedData()
	        .get(key));
	        if (element != null) {
	        if(validate(element)){
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

	public ZipcodeLookupPage looksupforZipcodes() {

		lookupZipcode.click();

		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Medicare Plans | AARP?? Medicare Plans from UnitedHealthcare??")
						|| driver.getTitle().equalsIgnoreCase(
								"Our Medicare Plan Types | UnitedHealthcare®")) {
			return new ZipcodeLookupPage(driver);
		}
		return null;
	}

	@Override
	public void openAndValidate() {
		if (!(currentUrl().contains("aarpmedicareplans"))) {
			start(AARP_ACQISITION_PAGE_URL);
		}
		validate(prescriptionsLink);
		validate(zipCodeField);
		validate(viewPlansButton);
		validate(footnotesContent);
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
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Our Medicare Plan Types | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}

	
	public String selectsHomeFooter() {

		return homefooter.getText();
	}


	public JSONObject accessGlobalFooter() {
		String fileName = CommonConstants.GLOBAL_FOOTER_PAGE_DATA;
		globalFooter = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : globalFooter.getExpectedData().keySet()) {
			WebElement element = findElement(globalFooter.getExpectedData()
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
		globalFooterJson = jsonObject;

		return globalFooterJson;
	}

	public JSONObject accessViewAllDisclaimerInformation() {
		validate(disclaimerViewLink);
		disclaimerViewLink.click();
		validate(disclaimerViewLink);
		String fileName = CommonConstants.HOME_PAGE_DISCLAIMER_DATA;
		homePageDisclaimer = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : homePageDisclaimer.getExpectedData().keySet()) {
			WebElement element = findElement(homePageDisclaimer
					.getExpectedData().get(key));
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
		homePageDisclaimerHide = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : homePageDisclaimerHide.getExpectedData().keySet()) {
			WebElement element = findElement(homePageDisclaimerHide
					.getExpectedData().get(key));
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

	public AboutUsAARPPage aboutUsFooterClick() {
		validate(GlobalFooterWebElements.footerAboutUsLink);
		GlobalFooterWebElements.footerAboutUsLink.click();
		validate(GlobalFooterWebElements.footerAboutUsLink);

		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"About UnitedHealthcare® | AARP® Medicare Plans from UnitedHealthcare")) {
			return new AboutUsAARPPage(driver);

	public PharmacySearchPage navigateToPharmacyLocator() {
		pharmacyLink.click();
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Find a Pharmacy | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new PharmacySearchPage(driver);

		}
		return null;
	}


	public MedicareAdvantagePlansPage medicareAdvantagePlansClick() {
		validate(GlobalFooterWebElements.medicareAdvantagePlansLink);
		GlobalFooterWebElements.medicareAdvantagePlansLink.click();
		validate(GlobalFooterWebElements.medicareAdvantagePlansLink);
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Medicare Advantage Plans | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new MedicareAdvantagePlansPage(driver);
		}
		return null;
	}

	
	public AcquisitionHomePage veiwAllDisclaimerLinkSectionLinksClick() {
		validate(GlobalFooterWebElements.viewAllDisclaimerInformationLink);
		GlobalFooterWebElements.viewAllDisclaimerInformationLink.click();
		
		validate(GlobalFooterWebElements.disclaimerBackToTopLink);
		GlobalFooterWebElements.disclaimerBackToTopLink.click();
		
		validate(GlobalFooterWebElements.hideDiscliamerInformation);
		GlobalFooterWebElements.hideDiscliamerInformation.click();
				
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new AcquisitionHomePage(driver);
		}
		return null;
	}
	
	public JSONObject accessBrandSection() {
		String fileName = CommonConstants.HEADER_PAGE_DATA;
		header = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : header.getExpectedData().keySet()) {
			WebElement element = findElement(header.getExpectedData()
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
		headerJson = jsonObject;

		return headerJson;

	}

	public DisclaimersAARPPage importantDisclosuresClick() {
		validate(GlobalFooterWebElements.importantDisclosuresLink);
		GlobalFooterWebElements.importantDisclosuresLink.click();
		validate(GlobalFooterWebElements.importantDisclosuresLink);
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Disclaimers | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new DisclaimersAARPPage(driver);
		}
		
		return null;
	}

	public Boolean visitAARPOrgClick() {
		validate(GlobalFooterWebElements.visitAARPLink);
		GlobalFooterWebElements.visitAARPLink.click();
		validate(GlobalFooterWebElements.visitAARPLink);
		  ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs.get(1));
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"You are now leaving AARPMedicarerx.com")) {
			GlobalFooterWebElements.proceedLink.click();
			if(driver.getCurrentUrl().equals("http://www.aarp.org/")){
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
		alreadyPlanMember = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);

		JSONObject jsonObject = new JSONObject();
		for (String key : alreadyPlanMember.getExpectedData().keySet()) {
			WebElement element = findElement(alreadyPlanMember.getExpectedData()
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
		alreadyPlanMemberJson = jsonObject;

		return alreadyPlanMemberJson;
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
		if(user.equalsIgnoreCase("q1ulayer") && pass.equalsIgnoreCase("Password")){
			return true;
		}
		return false;
	}

	public LoginAssistancePage forgotUsernamePasswordClick() {
		
		validate(forgotUsernameLink);
		forgotUsernameLink.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    validate(medicareTitleText);
		if(driver.getTitle().equalsIgnoreCase("AARP Medicare Plans |Username and Password Assistance"))
		{
			return new LoginAssistancePage(driver);
		}
		return null;
	}
	

	public RegistrationHomePage registerHereLinkClick() {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(0));
	    validate(alreadyPlanMemberButton);
		alreadyPlanMemberButton.click();
	    validate(registerHereLink);
		registerHereLink.click();
		ArrayList<String> tabs1= new ArrayList<String> (driver.getWindowHandles());
		 driver.switchTo().window(tabs1.get(2));
	    validate(medicareTitleText);
		if(driver.getTitle().equalsIgnoreCase("AARP Medicare Plans | Registration"))
		{
			return new RegistrationHomePage(driver);
		}
		return null;
	}
	public DisclaimersAARPPage importantDisclaimersClick() {
	    validate(importantDisclosuresLink);
	    importantDisclosuresLink.click();
          validate(importantDisclosuresLink);
          if(driver.getTitle().equalsIgnoreCase("Disclaimers | AARP® Medicare Plans from UnitedHealthcare®")){
          return new DisclaimersAARPPage(driver);
          }

          return null;
          }
	
	public AcquisitionHomePage navigationSectionHomeLinkClick() {
	    validate(navigationSectionHomeLink);
	    navigationSectionHomeLink.click();
          validate(navigationSectionHomeLink);
          if(driver.getTitle().equalsIgnoreCase("Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®")){
          return new AcquisitionHomePage(driver);
          }

          return null;
          }
	public OurPlansPage navigationSectionOurPlansLinkClick() {
	    validate(navigationSectionOurPlansLink);
	    navigationSectionOurPlansLink.click();
          validate(navigationSectionOurPlansLink);
          if(driver.getTitle().equalsIgnoreCase("Our Medicare Plan Types | AARP® Medicare Plans from UnitedHealthcare®")){
          return new OurPlansPage(driver);
          }

          return null;
          }
	
	public Boolean navigationSectionEnterSearchClick() {
	    validate(navigationSectionEnterSearch);
	    navigationSectionEnterSearch.click();
	    navigationSectionEnterSearch.sendKeys("home");
	    String search = navigationSectionEnterSearch.getAttribute("value");
          if(search.equalsIgnoreCase("home")){
        	  return true;
          }

          return false;
          }
	

	public RequestHelpAndInformationPage navigateToMaMoreHelpAndInfo() {
		Actions actions = new Actions(driver);
		actions.moveToElement(ourPlans);
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

	public Object navigatesToVppSection(String planType) {

		if (validate(feedBackPopUp)) {
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

		if (currentUrl().contains("medicare-advantage-plans.html")) {
			return new MaViewPlansAndPricingPage(driver);
		}
		if (currentUrl().contains("prescription-drug-plans.html")) {
			return new PdpViewPlansAndPricingPage(driver);
		}
		if (currentUrl().contains("medicare-supplement-plans.html")) {
			return new MsViewPlansAndPricingPage(driver);
		}
		return null;
	}


}
