package pages.acquisition.ulayer;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.apache.regexp.recompile;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import pages.acquisition.ulayer.ZipcodeLookupHomePage;
import acceptancetests.atdd.data.CommonConstants;
import pages.member.ulayer.AccountHomePage;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;


/**
 * @author pperugu
 *
 */
public class AcquisitionHomePage extends GlobalFooterWebElements {

	@FindBy(id = "cta-zipcode")
	private WebElement zipCodeField;
	
	@FindBy(className = "fd_myPlans")
	private WebElement myPlansTab;

	@FindBy(id = "dce")
	private WebElement dce;
	
	@FindBy(id = "learn-zipcode")
  private WebElement learnzipCodeField;

  @FindBy(id = "learnfindplanBtn")
  private WebElement learnfindPlansButton;
  
  @FindBys(value = {@FindBy(xpath = "//ul[@id='topic-selectSelectBoxItOptions']/li")})
	private List<WebElement> topicDropDownValues;
		
	@FindBy(id = "picktopicbtn")
	private WebElement picktopicbtn;

	@FindBy(id = "topic-selectSelectBoxIt")
	private WebElement selectSelectBoxIt;
	
	@FindBy(className = "zip-button")
	private WebElement FindPlansButton1;
	
	@FindBy(xpath = "//*[@id='ghn_lnk_2']")
	private WebElement OurPlansLink1;
	
	@FindBy(xpath= "//a[text()='Look up ZIP code']")
	private WebElement LookUpZipCode1;
	
	@FindBy(xpath = "//*[@id='zipLookup']/p/a")
	private WebElement lookupZipcode21;
	
	@FindBy(xpath = "//*[@id='subnav_2']/div/div/div[2]/form/span/span")
	private WebElement errormessage1;
	
	@FindBy(className = "zip-button")
	private WebElement FindPlansButton;
	
	@FindBy(id = "findazip_box")
	private WebElement zipCodeSearchPopup;
	
	@FindBy(xpath = "//*[@id='ghn_lnk_2']")
	private WebElement OurPlansLink;
	
	@FindBy(xpath= "//a[text()='Look up ZIP code']")
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
	
	@FindBy(xpath = "//div[@id='insuranceplan_nav']/div/div[3]/ul/li[4]/a/span")
	private WebElement pdp_moreHelpInfoLink;

	@FindBy(linkText = "Request More Help and Information")
	private WebElement ma_moreHelpInfoLink;

	@FindBy(id = "ipeL")
	private WebElement feedBackPopUp;

	@FindBy(xpath = "//div[@id='ipeL']/div[2]/map/area[3]")
	private WebElement popUpcloseLink;

	@FindBy(id = "ghn_lnk_1")
	public static WebElement navigationSectionHomeLink;

	@FindBy(id="ghn_lnk_2")
	public static WebElement ourPlansHoverLink;
	
	@FindBy(id="subnav_2")
	public static WebElement ourPlansDropdownText;

	private static String AARP_ACQISITION_PAGE_URL = MRConstants.AARP_URL;
	
	private PageData globalFooter;
	
	public JSONObject globalFooterJson;

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
    
    
	public AcquisitionHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public GetStartedPage navigateToPrescriptionDrug() {
			dce.click();		
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

	public ZipcodeLookupHomePage looksupforZipcodes() {

		lookupZipcode.click();

		if (getTitle()
				.equalsIgnoreCase(
						"Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®")
						) {
			return new ZipcodeLookupHomePage(driver);
		}
		return null;
	}

	@Override
	public void openAndValidate() {
		if (!(currentUrl().contains("aarpmedicareplans"))) {
			start(AARP_ACQISITION_PAGE_URL);
		}
		
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
        if (getTitle()
                     .equalsIgnoreCase(
                                   "Our Medicare Plan Types | AARP® Medicare Plans from UnitedHealthcare®")) {
               return new VPPPlanSummaryPage(driver);
        }
        return null;
 }
	
	public String selectsHomeFooter() {

		return homefooter.getText();
	}
	
	public VPPPlanSummaryPage enterZipcode(String zipCode, String county, String planYear){
		sendkeys(zipCodeField, zipCode);		
		zipCodebtn.click();
		return new VPPPlanSummaryPage(driver);	
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

	 public JSONObject accessingOurPlanslink() {
		 
		 hoverourplanslink();
		 return getOurPlanDropDownJson();
		}
		 
		 public JSONObject getOurPlanDropDownJson(){
			 
		 
	        String fileName = CommonConstants.OUR_PLANS_DROPDOWN_DATA;
	        ourplansdropdown = CommonUtility.readPageData(fileName,
	                     CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
	        
	        JSONObject jsonObject = new JSONObject();
	        for (String key : ourplansdropdown.getExpectedData().keySet()) {
	        WebElement element = findElement(ourplansdropdown.getExpectedData()
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
	        ourplansdropdownJson = jsonObject;
	        
	        
	        return ourplansdropdownJson;
	        
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
		}
		return null;
	}
	
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
		WebElement element = findElement(medicareEducationDropDown.getExpectedData()
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

	public LearnAboutMedicarePage learnAboutMedicareClick() {
		validate(navigationSectionMedicareEducationLink);
		Actions actions = new Actions(driver);
        actions.moveToElement(navigationSectionMedicareEducationLink);
        actions.moveToElement(learnAboutMedicareMedicareEducationLink);
        actions.click().build().perform();
        if(driver.getTitle().equalsIgnoreCase("Learn About Medicare | AARP® Medicare Plans from UnitedHealthcare®")){
            return new LearnAboutMedicarePage(driver);
            }

		return null;
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


	public PDPRequestHelpAndInformationPage navigateToPDPMoreHelpAndInfo() {
		
		
		Actions actions = new Actions(driver);
		actions.moveToElement(ourPlans);
		actions.moveToElement(pdp_moreHelpInfoLink);
		actions.click().build().perform();
		
		if(currentUrl().contains("prescription-drug-plans/request-information.html")){
			return new PDPRequestHelpAndInformationPage(driver);
		}
				
		return null;
				
	}



	public Boolean enterInvalidUserNamePassword() {
		validate(usernameField);
		usernameField.click();
		usernameField.sendKeys("");
		//usernameField.sendKeys(givenAttributesRow.get(0).getCells().get(0));
		String user = usernameField.getAttribute("value");
		validate(passwordField);
		passwordField.click();
		passwordField.sendKeys("pas");
		//passwordField.sendKeys(givenAttributesRow.get(0).getCells().get(1));
		String pass = passwordField.getAttribute("value");
		if(user.equalsIgnoreCase("") && pass.equalsIgnoreCase("pas")){
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
		//usernameField.sendKeys(givenAttributesRow.get(0).getCells().get(0));
		String user = usernameField.getAttribute("value");
		validate(passwordField);
		passwordField.click();
		passwordField.sendKeys("Password@1");
		//passwordField.sendKeys(givenAttributesRow.get(0).getCells().get(1));
		String pass = passwordField.getAttribute("value");
		if(user.equalsIgnoreCase("q3ulayer_090") && pass.equalsIgnoreCase("Password@1")){
			return true;
		}
		return false;
	}
	public AccountHomePage signInValid() {
		validate(signInButton);
		signInButton.click();
		//validate(signInButton);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
		if(driver.getTitle().equalsIgnoreCase("AARP Medicare Plans | My Account Home")){
            return new AccountHomePage(driver);
            }

		return null;
	}
	public void hoverourplanslink() {
		validate(OurPlansLink1);
			//Hover over text
			Actions action = new Actions(driver);
			action.moveToElement(OurPlansLink1).build().perform();
			
		// to click
		//	action.click().build().perform();
			
			validate(OurPlansLink1);
			
			// TODO Auto-generated method stub
		
		}
			


		
		
		public AcquisitionHomePage findplansbuttonclick() {
			validate(FindPlansButton1);
			FindPlansButton1.click();
			validate(FindPlansButton1);
			if(driver.getTitle().equalsIgnoreCase("Medicare Plans | AARP® Medicare Plans from UnitedHealthcare®")){
		          return new AcquisitionHomePage(driver);
		          }

		          return null;
		}

		
		




		
		

		public OurPlansPage lookupzipcodeclick() {
			
			hoverourplanslink();
				validate(LookUpZipCode1);
				LookUpZipCode1.click();
				validate(LookUpZipCode1);
				if(driver.getTitle().equalsIgnoreCase("Our Medicare Plan Types | AARP® Medicare Plans from UnitedHealthcare®")){
			          return new OurPlansPage(driver);
			          }

			          return null;
			
		}		
				
				
				
	


	
	private PageData ourPlansNav;
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
		//validate(signInButton);
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
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
		if(timerId.contains("cookie")){
			if(cookieValid()){
			driver.navigate().refresh();
			String[] parts = timerId.split("-");
			String timerString = parts[1];
			int timer = Integer.parseInt(timerString);
			if(timer > 0){
			return validate(signInButton);
			}
			}
		}else if(timerId.contains("visitor")){
			String[] parts = timerId.split("-");
			String timerString = parts[1];
			int timer = Integer.parseInt(timerString);
			if(timer > 0){
			return validate(signInButton);
			}

		}
		return false;
	}

	public Boolean cookieTimerValid() {
		driver.navigate().refresh();
		validate(signInButton);
		String timerId = alreadyPlanMemberButtonInactive.getAttribute("id");
		if(timerId.contains("cookie") || timerId.contains("visitor")){
			
			String[] parts = timerId.split("-");
			String timerString = parts[1];
			int timer = Integer.parseInt(timerString);
			timer = timer*1000;
			System.out.println("timer in milli secs "+timer);
			try {
				Thread.sleep(timer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return validate(signInButton);
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
        	if(getTitle().equals("Learn About Medicare | AARP® Medicare Plans from UnitedHealthcare®")){
        		return new LearnAboutMedicarePage(driver);
        	}
        } else if(currentUrl().contains("medicare-education/enroll")){
        	if(getTitle().equals("Medicare Initial Enrollment Period | AARP® Medicare Plans from UnitedHealthcare®")){
        	return new PrepareforInitialEnrollmentPage(driver);
        	}
        }
		
		return null;

		} 

}
