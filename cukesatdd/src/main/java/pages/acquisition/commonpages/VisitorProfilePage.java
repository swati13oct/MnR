package pages.acquisition.commonpages;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import com.mysql.jdbc.StringUtils;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;
import io.cucumber.datatable.DataTable;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.vpp.VPPTestHarnessPage;

public class VisitorProfilePage extends UhcDriver {

	@FindBy(id = "dupIconFlyOut")
	private WebElement shoppingCartIcon;

    @FindBy(xpath = "(//a[contains(text(),'Sign In')])[2]")
    private WebElement signIn;

	@FindBy(xpath = "//button[contains(@class,'optum_sign_in')]")
	private WebElement signInButton;

	@FindBy(css = "div.signupCTA a.signin-font")
	private WebElement signInLegacy;

	@FindBy(css = "div.signupCTA a.profileBtn")
	private WebElement btnCreateProfile;

	@FindBy(xpath = "//div[contains(@class,'find-plans')]/button")
	private WebElement addPlans;

	@FindBy(css = "div.dashboardCard.plans a.empty-message-link")
	private WebElement addplans;

	@FindBy(css = "a.addrugs")
	private WebElement addrugs;

	@FindBy(css = "a.add-provider")
	private WebElement addprovider;

	@FindBy(xpath = "//div[contains(@class,'drug-list-accordion open')]//button[contains(@class,'drug-list-toggle')][contains(@class,'collapsed')]")
	private WebElement expandDrugBlock;

	@FindBy(xpath = "//div[contains(@class,'provider--block card')]//button[contains(@class,'provider-title')][contains(@class,'collapsed')]")
	private WebElement expandProviderBlock;

	@FindBy(css = "div.drug-list-accordion.open div.drug-info-container span:first-child")
	private WebElement drugname;

	@FindBy(css = "ul.drugs-list>li>div>div>div>div:first-child")
	private WebElement drugName;

	@FindBy(css = "ul.drugs-list>li:last-child>span")
	private WebElement pharmacyAddress;

	@FindAll({ @FindBy(xpath = "//li[@class='drug']") })
	private List<WebElement> savedDrugs;

	@FindBy(xpath = "//div[contains(@class,'drug--block card')]//ul")
	private WebElement drugBlock;

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/..//a[contains(text(),'Sign Out')]")
	private WebElement signOut;

	@FindBy(id = "enrollment-next-button")
	private WebElement NextBtn;

	@FindBy(xpath = "//h2[@id='saved-plans']/following::button[contains(@aria-label,'Enroll')][1]")
	private WebElement enrollInPlan;

	@FindBy(id = "header-number")
	private WebElement shoppingCartNumber;

	@FindBy(xpath = "//a[text()='Compare Plans']")
	private WebElement comparePlans;

	@FindBy(css = "button.cta-button.create-profile")
	private WebElement comparePlansOnPopup;

	@FindBy(xpath = "//*[contains(@id,'enrollbtnplancompare0')]")
	private WebElement enrollBtn;

	@FindBy(css = "div#navLinks>a:first-child")
	private WebElement backToPlans;

	@FindBy(css = "div.print-back>a:first-child")
	private WebElement legacyBackToPlans;

	@FindBy(xpath = "//div[@class='multi-year-select']")
	private WebElement profileMultiYear;

	@FindBy(xpath = "//div[@class='multi-year-select']/button[contains(@class,'select-year')][2]")
	private WebElement profileNxtYrPlans;

	@FindBy(xpath = "//div[@class='multi-year-select']/button[contains(@class,'select-year')][1]")
	private WebElement profileCrntYrPlans;

	@FindBy(xpath = "(//button[contains(@dtmname,'add my drugs')])[1]")
    public WebElement AddMyDrugsBtn;

	// New Shopper profile page objects

	@FindBy(xpath = "//h4[contains(text(),'drug')]/following::button[1]")
	public WebElement drugGetStarted;

	@FindBy(xpath = "//a[contains(@dtmname,'Saved Drugs')]")
	public WebElement drugHeader;

	@FindBy(css = "h3#saved-drugs")
	public WebElement savedDrugsHeader;

	@FindBy(css = "h2#saved-drugs-and-doctors")
	public WebElement savedDrugsAndDoctorsHeader;

	@FindBy(xpath = "//h3[@id='saved-drugs']/following::button[contains(@dtmname,'Add Drugs')]")
	public WebElement editDrugsPharmacy;

	// OLE Details
	@FindBy(xpath = "//h3[contains(@id,'enrollName')]")
	public WebElement enrolledPlanName;

	@FindBy(xpath = "//span[text()='Status']/following-sibling::span")
	public WebElement enrolledStatus;

	@FindBy(xpath = "//span[text()='Zip Code']/following-sibling::span")
	public WebElement enrolledPlanZipcode;

	@FindBy(xpath = "//span[text()='Monthly Premium']/following-sibling::span")
	public WebElement enrolledMonthlyPremium;

	@FindBy(xpath = "//span[text()='Yes, cancel application']/..")
	public WebElement cancelEnrollment;

	@FindBy(xpath = "//button[@dtmname='Visitor Profile:Save Drugs and Doctors:Add Drugs']")
	public WebElement addDrugsGlobal;

	@FindBy(xpath = "(//button[contains(@dtmname,'Add drugs') and contains(@dtmid, 'visitor_profile')]/*[contains(text(), 'Add')])[1]")
	public WebElement enterDrugInfoPlanCard;

	@FindBy(xpath = "//a[contains(text(),'Back to Drug Cost Estimator')]")
	public WebElement backToDrugCostEstimatorLink;

	@FindBy(xpath = "//*[contains(@aria-controls,'plan-drugs-dropdown')]/img")
	public WebElement expandDrugsPlanCard;

	@FindBy(xpath = "//*[text()='Edit Drugs']")
	//// *[contains(@aria-controls,'plan-drugs-dropdown')]/..//*[contains(@id,'plan-providers-dropdown')]//*[contains(text(),'Edit
	//// Drugs')]
	public WebElement editDrugsPlanCard;

	// @FindBy(xpath = "//*[contains(@aria-controls,'plan-drugs-dropdown')]")
	// public WebElement expandDrugsGlobal;

	@FindBy(xpath = "//button[contains(@dtmname, 'Add Drugs')]/span")
	public WebElement AddDrugsGlobal;

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/..//a[contains(text(),'Sign In')]")
	public WebElement loginLink;

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/..//a[contains(text(),'Sign Out')]")
	public WebElement signOutLink;

	@FindBy(xpath = "//button[contains(@dtmname,'Visitor Profile:Saved Drugs/Pharmacy:Remove')]")
	public List<WebElement> removeDrugs;

	@FindBy(xpath = "//*[contains(@aria-controls,'plan-providers-dropdown')]/img")
	public WebElement expandProvidersPlanCard;

	@FindBy(xpath = "//button[contains(@dtmname,'Visitor Profile:Saved Doctors/Providers:Remove')]")
	public List<WebElement> removeProviders;

	@FindBy(xpath = "//*[contains(@id,'ghn_lnk')]/span[text()='Home']")
	private WebElement homeTab;

	@FindBy(xpath = "//button[contains(@class,'remove-button') and contains(@aria-label,'Delete')]")
	private List<WebElement> deletePlan;

	@FindBy(xpath = "//*[@id='navLinks']/a[1]")
	private WebElement breadCrumbLink;

	@FindBy(xpath = "(//div[@class='provider-accordion'])[1]")
	private WebElement providerAccordin;

	@FindBy(xpath = "//button[@id='ProviderDelete-noplan-0']")
	private WebElement legactRemoveProvider;

	// Shopper profile UI version 2

	@FindBy(xpath = "//span[text()='Add Drugs']/parent::button")
	private WebElement addDrugsBtn;

	@FindBy(xpath = "(//button[contains(text(),'View Drug Pricing')])[1]")
	private WebElement viewDrugPricingLink;

	//@FindBy(xpath = "//button[text()='Yes, Remove']")
	@FindBy(xpath = "//div[contains(@class,'modal')]//button[contains(text(),'Remove')]")
	private WebElement removeDrugBtn;

	@FindBy(xpath = "//h2[@id='saved-drugs-and-doctors']/following::a[contains(text(),'Import')]")
	private WebElement importLnk;

	@FindAll({ @FindBy(xpath = "//div[contains(@id,'DrugName')]") })
	private List<WebElement> savedDrugsList;
	
	@FindBy(xpath = "//div[contains(@id,'DrugName')]")
	private WebElement savedDrug;

	@FindAll({ @FindBy(xpath = "//div[contains(@id,'ProviderName')]") })
	private List<WebElement> savedProvidersList;

	@FindBy(xpath = "//img[@class='uhc-modal__close']/parent::button")
	private WebElement modalClose;

	@FindBy(xpath = "(//h1)[1]")
	private WebElement profileName;

	@FindBy(css = "nav.uhc-profile-header-nav ul li:first-child>a>span:nth-child(2)")
	private WebElement savedInsuredPlans;

	@FindBy(css = "nav.uhc-profile-header-nav ul li:nth-child(2)>a>span:nth-child(2)")
	private WebElement yourSavedPharmacyAndDrugs;

	@FindBy(css = "nav.uhc-profile-header-nav ul li:nth-child(3)>a>span:nth-child(2)")
	private WebElement yourSavedDoctorsAndProviders;

	@FindBy(css = "nav.uhc-profile-header-nav ul li:nth-child(4)>a>span:nth-child(2)")
	private WebElement yourRecommendations;

	@FindBy(css = "nav.uhc-profile-header-nav ul li:last-child>div>a:first-child")
	private WebElement yourEnrollments;

	@FindBy(css = "nav.uhc-profile-header-nav ul li:last-child>div>a:nth-child(2)")
	private WebElement manageProfile;

	@FindBy(css = "nav.uhc-profile-header-nav ul li:last-child>div>a:last-child")
	private WebElement signOutText;
	
	@FindBy(xpath = "//span[contains(text(),'Add Doctors')]/parent::button")
    private WebElement addDoctor;
	
	@FindBy(xpath = "//a[contains(text(),'Import')]")
    private WebElement lnkImport;
	
	@FindBy(xpath = "(//span[contains(text(),'Get')])[2]")
    private WebElement btnGetStarted;
	
	@FindBy(xpath = "//button[@dlassetid='vp_havemedicare_next']")
    private WebElement btnNext;
	
	@FindBy(id = "member-firstName")
    private WebElement txtFName;
	
	@FindBy(id = "member-lastName")
    private WebElement txtLName;
	
	@FindBy(id = "member-date-of-birth")
    private WebElement txtDOB;
	
	@FindBy(id = "member-zip-code")
    private WebElement txtZipCode;
	
	@FindBy(id = "member-medicare-number")
    private WebElement txtMedicareId;
	
	@FindBy(xpath = "//div[text()='UnitedHealthcare']/parent::label")
	private WebElement chkUHC;
	
	@FindBy(xpath = "//div[text()='Aetna']/parent::label")
	private WebElement chkAetna;
	
	@FindBy(xpath = "//div[contains(text(),'Aetna')]/parent::label")
	private WebElement chkMAwithAetna;
	
	@FindBy(xpath = "//div[contains(text(),'Humana')]/parent::label")
	private WebElement chkMAwithHumana;
	
	@FindBy(xpath = "//div[text()='Humana']/parent::label")
	private WebElement chkHumana;
	
	@FindBy(xpath = "//input[@id='acceptReqAccess']/parent::label")
	private WebElement chkReqAccess;
	
	@FindBy(xpath = "//input[@id='acceptTermsOfUse']/parent::label")
	private WebElement chkTermsOfUse;
	
	@FindBy(xpath = "//span[text()='Continue']/parent::button")
	private WebElement flexContinueBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Import')]/parent::button")
	private WebElement flexImportBtn;
	
	@FindBy(xpath = "//div[contains(text(),'don')]/parent::label")
	private WebElement chkMilliman;
	
	@FindBy(xpath = "//button[@dlassetid='vp_confimp_next']")
	private WebElement btnNonMemNext;
	
	@FindBy(id = "agreementName")
    private WebElement txtAgreementName;
	
	@FindBy(xpath = "//button[@dlassetid='vp_impcons_prev']")
	private WebElement btnNonMemNext2;
	
	@FindBy(id = "non-member-firstName")
    private WebElement txtNonMemFName;
	
	@FindBy(id = "non-member-lastName")
    private WebElement txtNonMemLName;
	
	@FindBy(id = "non-member-date-of-birth")
    private WebElement txtNonMemDOB;
	
	@FindBy(id = "non-member-zip-code")
    private WebElement txtNonMemZipCode;
	
	@FindBy(xpath = "//label[@for='male']")
    private WebElement genderMale;
	
	@FindBy(name = "isAttested")
    private WebElement chkAttest;
	
	@FindBy(xpath  = "//button[@dlassetid='vp_imp_mem_det_next']")
    private WebElement btnViewDrugsAndDocs;
	
	@FindBy(xpath  = "(//button[@dlassetid='vp_nonmemdetl_next'])[2]")
    private WebElement btnNonMemViewDrugsAndDocs;
	
	@FindBy(xpath  = "(//a[contains(text(),'Back')])[1]")
    private WebElement lnkbackToProfile;
	
	@FindBy(xpath  = "//*[text()='Basic Costs']")
    private WebElement headingBasicCost;
	
	@FindBy(xpath  = "//*[text()='Doctor Visits']")
    private WebElement headingDocVisits;
	
	@FindBy(id="dateOfBirth")
	private WebElement msDOB;
	
	@FindBy(xpath = "//span[text()='Continue Application']")
	private WebElement btnContinueApplication;
	
	@FindBy(xpath = "(//button[contains(@class,'back-to-plans')])[1]")
	private WebElement closeMSApplication;
	
	@FindBy(xpath  = "//h2[text()='Gym Membership']")
    private WebElement headingGymMembership;
	
	@FindBy(xpath  = "//h2[text()='Brain Health']")
    private WebElement headingBH;
	
	@FindBy(xpath  = "//h1[text()='Add your information']")
    private WebElement headingAddYourInfo;
	
	@FindBy(xpath = "//span[contains(text(),'Get')]")
    private WebElement btnPREGetStarted;

	@FindBy(xpath = "//div[contains(@class,'data-import')]//button//span[contains(text(),'Review My Drugs')]")
	WebElement btnReviewDrugs;

	public VisitorProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(shoppingCartIcon);

	}

	public AcquisitionHomePage addPlan() {

		/*
		 * if(!StringUtils.isEmpty(CommonConstants.SELECTED_STATE) &&
		 * (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Pennsylvania")
		 * || StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE,
		 * "Puerto Rico") ||
		 * StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) ) {
		 */
		/*
		 * String State = CommonConstants.getSelectedState(); if
		 * (!StringUtils.isEmpty(State) && StringUtils.equalsIgnoreCase(State,
		 * "Virginia")) {
		 * 
		 * jsClickNew(addplans); } else { jsClickNew(addPlans); }
		 */
		jsClickNew(addPlans);
		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("plan-summary")) {
			String page = "health-plans";
			return new AcquisitionHomePage(driver, page);
		}
		return null;
	}

	/*
	 * jsClickNew(addPlans); waitForPageLoadSafari();
	 * if(driver.getCurrentUrl().contains("profile")) { return new
	 * AcquisitionHomePage(driver); }else {
	 * System.out.println("Navigation to visitor profile is failed"); return null; }
	 *
	 * }
	 */
	public void validateAddedDrugAndPharmacy(String drug,String user_state) {

		/*
		 * if (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE,
		 * "Pennsylvania") ||
		 * StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Puerto Rico")
		 * || StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia"))
		 * {
		 */
		/*
		 * String State = CommonConstants.getSelectedState(); if
		 * (StringUtils.equalsIgnoreCase(State, "Virginia")) {
		 * jsClickNew(expandDrugBlock);
		 * Assertion.assertTrue(drugname.getText().trim().contains(drug)); } else {
		 * CommonUtility.waitForPageLoad(driver, pharmacyAddress, 10);
		 * Assertion.assertEquals("Your Saved Drugs (1) & Pharmacy",
		 * drugHeader.getText().trim()); jsClickNew(drugHeader);
		 * Assertion.assertTrue(drugName.getText().trim().contains(drug));
		 * Assertion.assertEquals("Drugs (1) & Pharmacy",
		 * savedDrugsHeader.getText().trim());
		 * Assertion.assertEquals("Saved Drugs (1) & Pharmacy | Doctors & Providers (0)"
		 * , savedDrugsAndDoctorsHeader.getText().trim());
		 * Assertion.assertTrue(pharmacyAddress.isDisplayed()); }
		 */
		//CommonUtility.waitForPageLoad(driver, pharmacyAddress, 10);
		if (user_state.equalsIgnoreCase("auth")) {
			System.out.println(drugHeader.getText().trim().replace("\n", " "));
			Assertion.assertTrue(
					(drugHeader.getText().trim().replace("\n", " ").contains("Your Saved Drugs & Pharmacy (1)")));
		} else if (user_state.equalsIgnoreCase("unauth")) {
			System.out.println(drugHeader.getText());
			Assertion.assertTrue(
					(drugHeader.getText().trim().replace("\n", " ").contains("Your Saved Drugs & Pharmacy (1)")));
		}
	     //Assertion.assertEquals("Your Saved Drugs (1) & Pharmacy �", drugHeader.getText().trim());
	     jsClickNew(drugHeader);
	     Assertion.assertTrue(drugName.getText().trim().contains(drug));
	     Assertion.assertEquals("Drugs (1) & Pharmacy", savedDrugsHeader.getText().trim());
	     System.out.println(savedDrugsAndDoctorsHeader.getText().trim());
	     Assertion.assertEquals("Saved Drugs (1) & Pharmacy | Doctors & Dentists (0)",
	             savedDrugsAndDoctorsHeader.getText().trim());
	    // Assertion.assertTrue(pharmacyAddress.isDisplayed());
		
	}
	
	public void validateAddedPlans(String planNames) {
        String[] listOfTestPlans = planNames.split(",");

		/*if (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Pennsylvania")
				|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Puerto Rico")
				|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {*/
            for (String plan : listOfTestPlans) {
                Assertion.assertEquals(plan,
                        driver.findElement(By.xpath(
                                "//button[contains(@class,'remove')]/following::h3[contains(text(),'" + plan + "')]"))
                                .getText().trim());
                Assertion.assertTrue(driver
                        .findElement(By.xpath("//button[contains(@class,'remove')]/following::h3[contains(text(),'"
                                + plan + "')]/following::span[contains(@class,'search-provider')]"))
                        .isDisplayed());
                System.out.println(driver
                        .findElement(By.xpath(
                                "//button[contains(@class,'remove')]/following::h3[contains(text(),'" + plan + "')]"))
                        .getText());
            }
        }

    public void validateAddedDrugs(String druglist) {
//		expandDrugBlock.click();

        String[] DrugListItems = druglist.split(":");
        System.out.println("Added Drug Count : " + DrugListItems.length);
        for (String currentDrug : DrugListItems) {
            System.out.println("Current Added Drug Name : " + currentDrug);
            /*
             * List<WebElement> DrugName = driver.findElements(By.xpath(
             * "//div[contains(@class,'drug-list-accordion')]//button[contains(@class,'add-drugs')]/following-sibling::div//*[contains(@id,'DrugName')]"
             * ));
             */

            List<WebElement> DrugName = driver
                    .findElements(By.xpath("//ul[@class='drugs-list']//*[contains(@id,'DrugName')]"));

            for (int j = 0; j < DrugName.size(); j++) {
                String drugInfo = DrugName.get(j).getText();
                System.out.println("Drug name seen on Plan Summary: " + drugInfo);
                if (drugInfo.contains(currentDrug))
                    System.out.println(currentDrug + ": Drug name matched");
                else if (j > DrugName.size()) {
                    System.out.println("========Drug name not matched=====");
                    Assertion.fail("Drug List Validation FAILED for Drug : " + currentDrug);
                }
            }
        }
    }

    public PlanDetailsPage navigateToPlanDetails(String planName) {
        try {
			/*if (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Pennsylvania")
					|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Puerto Rico")
					|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {*/
            /*String State = CommonConstants.getSelectedState();
//			if (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {
            if (StringUtils.equalsIgnoreCase(State, "Virginia")) {
                jsClickNew(driver.findElement(By.xpath("//h4[text()='" + planName + "']")));
            } else {
                jsClickNew(driver.findElement(By.xpath(
                        "//button[contains(@class,'remove')]/following::h3[contains(text(),'" + planName + "')]")));
            }*/
            jsClickNew(driver.findElement(By.xpath(
                    "//button[contains(@class,'remove')]/following::h3[contains(text(),'" + planName + "')]")));
            Thread.sleep(20000);
            if (driver.getCurrentUrl().contains("#/details")) {
                return new PlanDetailsPage(driver);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public GetStartedPage addDrug_DCERedesign() {

		/*if (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Pennsylvania")
				|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Puerto Rico")
				|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {*/
//		if (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {
            jsClickNew(addDrugsBtn);
        waitForPageLoadSafari();
        if (validateNew(AddMyDrugsBtn))
            return new GetStartedPage(driver);
        return null;
    }

    /**
     * Deletes the specified plans
     *
     * @param plans
     */
    public void deletePlans(String plans) {
        if (validate(profileMultiYear, 10)) {
            jsClickNew(profileNxtYrPlans);
            waitForPageLoadSafari();
            if (driver.findElements(By.xpath("//div[@class='title dropdown-open']")).size() > 0)
                jsClickNew(driver.findElement(By.xpath(
                        "//div[@class='multi-year-select']/button[contains(@class,'js-select-year select-year')][2]/following::button[2]")));
            else
                System.out.println("##############No saved plans available for 2021##############");

            jsClickNew(profileCrntYrPlans);
        } else {
            System.out.println("##############MultiYear not displayed##############");
        }

        try {
			/*if (!StringUtils.isEmpty(CommonConstants.SELECTED_STATE)
					&& (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Pennsylvania")
							|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Puerto Rico")
							|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia"))) {*/
            /*String State = CommonConstants.getSelectedState();
			*//*if (!StringUtils.isEmpty(CommonConstants.SELECTED_STATE)
					&& StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {*//*
            if (!StringUtils.isEmpty(State)
                    && StringUtils.equalsIgnoreCase(State, "Virginia")) {
                String[] listOfTestPlans = plans.split(",");
                for (String plan : listOfTestPlans) {
                    jsClickNew(driver.findElement(By.xpath("//h4[text()='" + plan + "']/preceding::button[1]")));
                    Thread.sleep(5000);
                }
            } else if (driver.findElements(By.xpath("//span[contains(text(),'Plan Summary')]")).size() > 0) {
                String[] listOfTestPlans = plans.split(",");
                for (String plan : listOfTestPlans) {
                    jsClickNew(driver.findElement(By.xpath(
                            "//h3[contains(text(),'" + plan + "')]/preceding::button[contains(@class,'remove')][1]")));
                    Thread.sleep(5000);
                }
            } else
                System.out.println("##############No saved plans available here##############");*/
            if (driver.findElements(By.xpath("//span[contains(text(),'Plan Summary')]")).size() > 0) {
                String[] listOfTestPlans = plans.split(",");
                for (String plan : listOfTestPlans) {
                    jsClickNew(driver.findElement(By.xpath(
                            "//h3[contains(text(),'" + plan + "')]/preceding::button[contains(@class,'remove')][1]")));
                    Thread.sleep(5000);
                }
            } else
                System.out.println("##############No saved plans available here##############");

        } catch (Exception e) {
            e.printStackTrace();
        }
        Assertion.assertTrue(!(driver.findElements(By.xpath("//div[@class='title dropdown-open']")).size() > 0));
    }

    /**
     * Delete all the drugs from the profile
     */
    public void deleteAllDrugs() {
        CommonUtility.waitForPageLoadNew(driver, savedDrugs.get(0), 45);
        jsClickNew(driver.findElement(By.xpath("//li[@class='drug']//button")));
        /*
         * for (WebElement drug: savedDrugs) {
         * drug.findElement(By.xpath("//button")).click(); }
         */
        CommonUtility.waitForPageLoadNew(driver, addrugs, 45);
        Assertion.assertTrue(addrugs.isDisplayed());
    }

    public BuildYourDrugList clickOnEditDrugAndPharmacy() {
        CommonUtility.waitForPageLoadNew(driver, editDrugsPharmacy, 45);
        jsClickNew(editDrugsPharmacy);
        if (driver.getCurrentUrl().contains("buildyourdruglist"))
            return new BuildYourDrugList(driver);
        return null;
    }

    /**
     * Get the added provider information
     *
     * @param planName
     * @return
     */
    public boolean providerinfo(String planName) {
        WebElement ProviderSearchLink = driver
                .findElement(By.xpath("//button[contains(@class,'remove')]/following::h3[contains(text(),'" + planName
                        + "')]/following::button[contains(@aria-controls, 'plan-providers')][1]/span/span"));
        String mproviderinfo = ProviderSearchLink.getText();
        System.out.println(mproviderinfo);
        return mproviderinfo.toLowerCase().contains("providers covered");
    }

    /**
     * Get the added provider information
     *
     * @param planName
     * @return
     */
    public boolean legacyProviderinfo(String planName) {
        WebElement ProviderSearchLink = driver
                .findElement(By.xpath("//button[contains(@class,'remove')]/following::h4[contains(text(),'" + planName
                        + "')]/following::div[@class='provider-accordion']/button"));
        String mproviderinfo = ProviderSearchLink.getText();
        System.out.println(mproviderinfo);
        return mproviderinfo.toLowerCase().contains("providers covered");
    }

    /**
     * Get the added provider information
     *
     * @param planName
     * @return
     */
    public void validteProviderinfo(String planName) {
        try {
            WebElement viewProviders = driver.findElement(By.xpath(
                    "//h3[contains(text(),'" + planName + "')]/following::button[text()=' View Doctors & Dentists '][1]"));
            viewProviders.click();
            Thread.sleep(2000);
            String mproviderinfo = driver
                    .findElement(By.xpath(
                            "(//div[@id='ProviderName-noplan-0'])[1]"))
                    .getText().trim();

            String rallyProviderName = MRConstants.PROV_NAME;
            rallyProviderName = rallyProviderName.replaceAll(".", "").replaceAll(",", "");
            mproviderinfo = mproviderinfo.replaceAll(".", "").replaceAll(",", "");
            System.out.println(mproviderinfo);
            Assertion.assertTrue(mproviderinfo.contains(rallyProviderName));
            modalClose.click();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Delete all the providers from the profile
     */
    public void deleteProviders(String planName) {
        WebElement ProviderSearchLink = driver
                .findElement(By.xpath("//button[contains(@class,'remove')]/following::h3[contains(text(),'" + planName
                        + "')]/following::button[contains(@aria-controls, 'plan-providers')][1]/span/span"));
        jsClickNew(ProviderSearchLink);
        WebElement removeProvider = driver
                .findElement(By.xpath("//button[contains(@class,'remove')]/following::h3[contains(text(),'" + planName
                        + "')]/following::button[contains(@aria-controls, 'plan-providers')][1]/following::button[1]"));
        jsClickNew(removeProvider);
    }

    /**
     * Sign In with Optum Id credentials
     *
     * @param username
     * @param password
     */
    public void signIn(String username, String password) {
        try {
			/*if(!StringUtils.isEmpty(CommonConstants.SELECTED_STATE) && (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Pennsylvania")
					|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Puerto Rico")
					|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) ) {*/
//			if(!StringUtils.isEmpty(CommonConstants.SELECTED_STATE) && StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {
                jsClickNew(signIn);
            Thread.sleep(3000);
            waitForPageLoadSafari();
            // driver.findElement(By.cssSelector("input#userNameId_input")).sendKeys(username);
            driver.findElement(By.xpath("//input[contains(@id,'userNameId_input')]")).sendKeys(username);
            driver.findElement(By.cssSelector("input#passwdId_input")).sendKeys(password);
            jsClickNew(driver.findElement(By.cssSelector("input#SignIn")));
            waitForPageLoadSafari();
            Thread.sleep(3000);
            String Question = driver.findElement(By.cssSelector("span#challengeQuestionLabelId")).getText().trim();
            WebElement securityAnswer = driver.findElement(By.cssSelector("input#UnrecognizedSecAns_input"));
            waitforElement(securityAnswer);
            if (Question.equalsIgnoreCase("What is your best friend's name?")) {
                System.out.println("Question is related to friendname");
                securityAnswer.sendKeys("name1");
            } else if (Question.equalsIgnoreCase("What is your favorite color?")) {
                System.out.println("Question is related to color");
                securityAnswer.sendKeys("color1");
            } else {
                System.out.println("Question is related to phone");
                securityAnswer.sendKeys("number1");
            }
            jsClickNew(driver.findElement(By.cssSelector("input#authQuesSubmitButton")));
            waitForPageLoadSafari();
			CommonUtility.checkPageIsReadyNew(driver);
            CommonUtility.waitForPageLoadNew(driver, signOut, 15);

        } catch (Exception e) {
            Assertion.fail("###############Optum Id Sign In failed###############");
        }

    }

    /**
     * Enroll in a plan
     *
     * @param planName
     * @return
     */
    public WelcomePage Enroll_OLE_Plan(String planName) {
        WebElement enrollForPlan = null;

        enrollForPlan = driver
                .findElement(By.xpath("//button[contains(@class,'remove')]/following::h3[contains(text(),'" + planName
                        + "')]/following::button[contains(@dtmname,'Enroll in Plan')][1]"));
        if (enrollForPlan != null) {
            jsClickNew(enrollForPlan);
        }
        waitForPageLoadSafari();
        validateNew(NextBtn);
        if (driver.getCurrentUrl().contains("welcome")) {
            System.out.println("OLE Welcome Page is Displayed");
            return new WelcomePage(driver);
        }
        return null;
    }

    /**
     * Validate Enroll plan is Clickable or not
     *
     * @return
     */
    public boolean validateEnrollInPlanIsClickable() {
        boolean enrollInNotPossible = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(enrollInPlan));
            enrollInNotPossible = true;
            return enrollInNotPossible;
        } catch (Exception e) {
            e.printStackTrace();
            return enrollInNotPossible;
        }
    }

    /**
     * Validate the plan count on the shopping cart icon
     *
     * @param plancount
     */
    public void validatePlanCountOnCartIcon(String plancount) {
        Assertion.assertEquals(plancount, shoppingCartNumber.getText());
        System.out.println("count mapped on Shopping cart icon with : " + plancount);

    }

    public VPPTestHarnessPage switchBackToVPTestharness() {
        driver.close();
//		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
        driver.switchTo().window(CommonConstants.getMainWindowHandle());
        System.out.println("Switching back to MainWindow");
        if (driver.getCurrentUrl().contains("visitorprofiletestharness")) {
            System.out.println("visitorprofiletestharness Page is Displayed");
            return new VPPTestHarnessPage(driver);
        }
        return null;
    }

    /**
     * Select plans and compare
     *
     * @param plans
     * @return
     */
    public ComparePlansPage planCompare(String plans) {

        jsClickNew(comparePlans);
        //validateNew(enrollBtn);
		validateNew(driver.findElement(By.xpath("(//*[contains(@id,'enrollbtnplancompare0')])[2]")));
        waitForPageLoadSafari();
        if (driver.getCurrentUrl().contains("/plan-compare")) {
            System.out.println("Navigation to Plan Compare page is Passed");
            return new ComparePlansPage(driver);
        } else {
            Assertion.fail("Navigation to Plan Compare page is failed");
        }
        return null;
    }

    /**
     * Back to VPP
     */
    public VPPPlanSummaryPage backToPlans() {
        try {
			/*if(!StringUtils.isEmpty(CommonConstants.SELECTED_STATE) && (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Pennsylvania")
					|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Puerto Rico")
					|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) ) {*/
//			if(!StringUtils.isEmpty(CommonConstants.SELECTED_STATE) && StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {
                backToPlans.click();

            waitForPageLoadSafari();
            CommonUtility.checkPageIsReadyNew(driver);
            if (driver.getCurrentUrl().contains("#/plan-summary")) {
                return new VPPPlanSummaryPage(driver);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public VPPPlanSummaryPage addPlanForMember() throws Exception {
        addPlans.click();
        Thread.sleep(10000);
        CommonUtility.checkPageIsReadyNew(driver);
        if (driver.getCurrentUrl().contains("plan-summary")) {
            return new VPPPlanSummaryPage(driver);
        }
        return null;
    }

    public void validateAddedMsPlans(String planNames) {
        try {
            String[] listOfTestPlans = planNames.split(",");
            CommonUtility.checkPageIsReadyNew(driver);
            Thread.sleep(20000);
            for (String plan : listOfTestPlans) {

				/*if (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Pennsylvania")
						|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Puerto Rico")
						|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {*/
//				if (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {
                    Assertion.assertEquals(plan, driver.findElement(By.xpath("//h2[text()='" + plan + "']")).getText());
                    // No pdf link is availbel now
                    // Assertion.assertTrue(driver.findElement(By.xpath("//div/a[contains(@aria-describedby,'"+plan+"')]
                    // [contains(@class,'pdf-link')]")).isDisplayed());
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
}

    public void validateAddedPlansPDFLinks(String planNames) {
        String[] listOfTestPlans = planNames.split(",");
        for (String plan : listOfTestPlans) {
            Assertion.assertTrue(driver
                    .findElement(By
                            .xpath("//div/a[contains(@aria-describedby,'" + plan + "')] [contains(@class,'pdf-link')]"))
                    .isDisplayed());
        }
    }

    /**
     * Validate the enrolled plan details on profile page
     *
     * @param
     */
    public void validateOLEDetails(Map<String, String> givenAttributesMap) {
        //Handled data table in step definition
		/*List<DataTableRow> givenAttributesRow = oleDetails.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
        String planName = givenAttributesMap.get("Plan Name");
        String zipCode = givenAttributesMap.get("Zip Code");
        String status = givenAttributesMap.get("Status");
        String monthlyPremium = givenAttributesMap.get("Monthly Premium");

        Assertion.assertEquals(planName, enrolledPlanName.getText().trim());
        Assertion.assertEquals(zipCode, enrolledPlanZipcode.getText().trim());
        Assertion.assertEquals(status, enrolledStatus.getText().trim());
        waitforElementVisibilityInTime(enrolledMonthlyPremium, 10);
        Assertion.assertEquals(monthlyPremium, enrolledMonthlyPremium.getText().trim());

    }

    /**
     * This method is to cancel the given enrollment
     *
     * @param planName
     */
    public void cancelEnrollment(String planName) {

        if (driver.findElements(By.xpath("//button[@aria-label='Remove " + planName + "']")).size() > 0) {
            WebElement removeEnrolledPlan = driver
                    .findElement(By.xpath("//button[@aria-label='Remove " + planName + "']"));
            jsClickNew(removeEnrolledPlan);
            waitforElement(cancelEnrollment);
            jsClickNew(cancelEnrollment);
            waitforElementDisapper(By.xpath("//button[@aria-label='Remove " + planName + "']"), 5);
        } else {
            System.out.println("#############No saved Enrollment found#############");
        }
    }

    public VisitorProfilePage validateVisitorProfilePage() {
        if (driver.getCurrentUrl().contains("profile")) {
            validate(btnCreateProfile);
            return new VisitorProfilePage(driver);
        } else {
            Assertion.fail("Navigation to visitor profile is failed");
        }
        return null;
    }

    public void validateAddedPlansNew(String planNames) {
        String[] listOfTestPlans = planNames.split(",");
        CommonUtility.checkPageIsReadyNew(driver);
        for (String plan : listOfTestPlans) {
            System.out.println("Checking Saved Plan on VP for : " + plan);
            WebElement addedPlan = driver
                    .findElement(By.xpath("//*[contains(@id,'planName') and contains(text(),'" + plan + "')]"));
            validateNew(addedPlan);
            /*
             * System.out.println(driver.findElement(By.xpath(
             * "//h2[@id='saved-plans']/..//*[contains(@id,'planName') and contains(text(),'"
             * + plan + "')]")) .getText());
             */
            System.out.println(addedPlan.getText());
            /*
             * Assertion.assertEquals(plan, driver.findElement(By.xpath(
             * "//h2[@id='saved-plans']/..//*[contains(@id,'planName') and contains(text(),'"
             * + plan + "')]")) .getText().trim());
             */
            Assertion.assertEquals(plan, addedPlan.getText().trim());
            /*
             * Assertion.assertTrue(driver .findElement(By.
             * xpath("//h2[@id='saved-plans']/..//*[contains(@id,'planName') and contains(text(),'"
             * + plan + "')]/following::button[1]")) .isDisplayed());
             */
/*			Assertion.assertTrue(driver
					.findElement(By.xpath(
							"//*[contains(@id,'planName') and contains(text(),'" + plan + "')]/./following::button[1]"))
					.isDisplayed());
*/
            System.out.println("Verified plans are added on visitior profile page");
        }
    }

    public void clickAddDrugsGlobal() {
        validateNew(addDrugsGlobal);
        addDrugsGlobal.click();
    }

    /**
     * click add drugs from plan card
     */

    @FindBy(xpath = "//*[contains(@class, 'add-drug-doctor-dropdown')]//button[contains(@dtmname,'Add Drugs')]")
    private WebElement PlanCard_AddDrugProvider_AddDrugbtn;


    public void clickAddDrugsPlancardNew() {
        validateNew(enterDrugInfoPlanCard);
        enterDrugInfoPlanCard.click();
        validateNew(PlanCard_AddDrugProvider_AddDrugbtn);
        jsClickNew(PlanCard_AddDrugProvider_AddDrugbtn);
    }

    public void validateBackToDceLink() {
        validate(backToDrugCostEstimatorLink);
    }

    public DrugDetailsPage clickBackToDCELink() {
        jsClickNew(backToDrugCostEstimatorLink);
        waitForPageLoadSafari();
        if (driver.getCurrentUrl().contains("drugdetails")) {
            return new DrugDetailsPage(driver);
        } else
            return null;
    }

    /**
     * click edit drugs from plan card
     */
    @FindBy(xpath = "//*[contains(@class, 'plan-drug-doctor')]//a[contains(@dtmname, 'Update your drugs')]")
    private WebElement DrugPricingModal_EditDrugslink;


    public void clickEditDrugsPlancard() {
        //validateNew(expandDrugsPlanCard);
        //expandDrugsPlanCard.click();
        // New Plan Card does not have Edit drugs
        //		editDrugsPlanCard.click();

        validateNew(viewDrugPricingLink);
        viewDrugPricingLink.click();
        System.out.println("View Drug Pricing is clicked for Plan Card");
        validateNew(DrugPricingModal_EditDrugslink);
        jsClickNew(DrugPricingModal_EditDrugslink);
        System.out.println("View Drug Pricing - Edit Drugs link is clicked for Plan Card");
    }

    @FindBy(xpath = "//input[contains(@id, 'agreeButton')]")
    public WebElement ShareOneHealth_AgreeButton;

    @FindBy(xpath = "//*[contains(@id, 'identity-confirm-title')]")
    public WebElement ConfirmIdentity_ModalHdr;

    @FindBy(xpath = "//*[contains(@class, 'identity-confirm')]//button[contains(@class, 'close')]")
    public WebElement ConfirmIdentity_ModalClose;


    public void logIn(String username, String password) {
        try {

            loginLink.click();
            waitForPageLoadSafari();
            driver.findElement(By.cssSelector("input#userNameId_input")).sendKeys(username);
            driver.findElement(By.cssSelector("input#passwdId_input")).sendKeys(password);
            System.out.println("before signin");
            driver.findElement(By.cssSelector("input#SignIn")).click();
            System.out.println("before wait");
            waitForPageLoadSafari();
            waitforElement(driver.findElement(By.cssSelector("#securityQues")));
            System.out.println("after wait");
            String Question = driver.findElement(By.cssSelector("#challengeQuestionLabelId")).getText().trim();
            WebElement securityAnswer = driver.findElement(By.cssSelector("#UnrecognizedSecAns_input"));
            if (Question.equalsIgnoreCase("What is your best friend's name?")) {
                System.out.println("Question is related to friendname");
                securityAnswer.sendKeys("name1");
            } else if (Question.equalsIgnoreCase("What is your favorite color?")) {
                System.out.println("Question is related to color");
                securityAnswer.sendKeys("color1");
            } else {
                System.out.println("Question is related to phone");
                securityAnswer.sendKeys("number1");
            }
            driver.findElement(By.cssSelector("input#authQuesSubmitButton")).click();
            try {
                validate(ShareOneHealth_AgreeButton);
                System.out.println("Share My One Healthcare ID Page is Dispalyed for VP Login - Clicking on I Agree");
                jsClickNew(ShareOneHealth_AgreeButton);

            } catch (Exception e) {
                System.out.println("Share My One Healthcare ID Page is NOT Dispalyed for VP Login - Continuing to VP");
            }
            try {
                validate(ConfirmIdentity_ModalHdr);
                validate(ConfirmIdentity_ModalClose);
                jsClickNew(ConfirmIdentity_ModalClose);
            } catch (Exception e) {
                System.out.println("Confirm Identity and Import Modal is NOT Dispalyed for VP Login - Continuing to VP");
            }
            CommonUtility.waitForPageLoadNew(driver, signOutLink, 20);
        } catch (Exception e) {
            Assertion.fail("###############Optum Id Sign In failed###############");
        }

    }

    /**
     * click edit drugs globally
     */
    public void clickAddDrugsBtn() {
        AddDrugsGlobal.click();
    }

    @FindBy(xpath = "//button[contains(@dtmname,'Visitor Profile:Saved Drugs/Pharmacy:Remove Modal:Yes Remove')]")
    public WebElement ConfirmRemoveDrug;
    @FindBy(xpath = "//a[contains(@dtmname, 'Visitor Profile:Header:Auth:Your Saved Drugs & Pharmacy')]/span[contains(@class, 'uhc-profile-header-nav__item-bottom')]")
    public WebElement VPHeader_DrugsLinks;


    public void clearDrugs() {
        CommonUtility.waitForPageLoadNew(driver, VPHeader_DrugsLinks, 20);
        jsClickNew(VPHeader_DrugsLinks);
        try {
/*
			if (expandDrugsPlanCard.isDisplayed()) {
				expandDrugsPlanCard.click();
*/
            System.out.println(removeDrugs.size());
            while (removeDrugs.size() != 0) {
                waitforElementNew(removeDrugs.get(0));
                validateNew(removeDrugs.get(0));
                removeDrugs.get(0).click();
                validateNew(ConfirmRemoveDrug);
                jsClickNew(ConfirmRemoveDrug);
                System.out.println(removeDrugs.size());
                System.out.println("Removed drugs");

            }
            /*
             * while (removeDrugsPlanCard.size() != 0) {
             *
             * for(int i=0;i<editDrugs.size();i++) { totalDrugs.get(0).click();
             * validate(editDrugs.get(i)); editDrugs.get(i).click(); }
             *
             * removeDrugsPlanCard.get(0).click(); System.out.println("Removed drugs");
             * validate(addrugs); }
             */
//			}
        } catch (Exception e) {
            System.out.println("No existing drugs found");
        }
    }

    @FindBy(xpath = "//button[contains(@dtmname,'Visitor Profile:Saved Doctors/Providers:Remove Modal:Yes Remove')]")
    public WebElement ConfirmRemoveProvider;


    public void clearProvider() {
        try {
/*
			if (expandProvidersPlanCard.isDisplayed()) {
				expandProvidersPlanCard.click();
*/

            while (removeProviders.size() != 0) {
                /*
                 * for(int i=0;i<editDrugs.size();i++) { totalDrugs.get(0).click();
                 * validate(editDrugs.get(i)); editDrugs.get(i).click(); }
                 */
                waitforElementNew(removeProviders.get(0));
                validateNew(removeProviders.get(0));
                removeProviders.get(0).click();
                validateNew(ConfirmRemoveProvider);
                jsClickNew(ConfirmRemoveProvider);

                System.out.println("Removed provider");
                // validate(addrugs);
            }
//			}
        } catch (Exception e) {
            System.out.println("No existing providers found");
        }
    }

    public AcquisitionHomePage clickHomeMenu() {
        try {
            // homeTab.click();
            jsClickNew(homeTab);
            CommonUtility.checkPageIsReadyNew(driver);
            if (driver.getTitle().equals("AARP Medicare Plans from UnitedHealthcare")
                    || driver.getTitle().equals("Medicare Coverage Options from UnitedHealthcare")) {
                return new AcquisitionHomePage(driver);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Deletes the specified MS plans
     *
     * @param plans
     */
    public void deleteMSPlans(String plans) {
        try {
            String[] plan = plans.split(",");
            for (String planName : plan) {
                jsClickNew(driver.findElement(By.xpath(
                        "//h2[contains(text(),'" + planName + "')]/preceding::button[contains(@class,'remove')][1]")));
                threadsleep(4000);
            }
            Assertion.assertTrue(!(driver.findElements(By.xpath("//div[@class='title dropdown-open']")).size() > 0));
        } catch (Exception e) {
        }
    }

    public void deletePlans() {
        if (deletePlan.size() != 0) {
            for (int i = 0; i < deletePlan.size(); i++) {
                validate(deletePlan.get(i));
                // deletePlan.get(i).click();
                jsClickNew(deletePlan.get(i));
                System.out.println("Deleted existing saved plan from visitor profile");
            }
        }
    }

    public void verifyBreadCrumb(String breadCrumb) {
        Assertion.assertTrue("Expected breadcrumb " + breadCrumb + "not displayed",
                breadCrumbLink.getText().equals(breadCrumb));
    }

    public void validateViewDrugPricingModel(Map<String, String> givenAttributesMap) {

        //Handled from step definition file
		/*List<DataTableRow> givenAttributesRow = drugInfo.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
        String planName = givenAttributesMap.get("Plan Name");
        String zipCode = givenAttributesMap.get("Zip Code");
        String status = givenAttributesMap.get("Status");
        String monthlyPremium = givenAttributesMap.get("Monthly Premium");

        viewDrugPricingLink.click();
        Assertion.assertTrue(validate(driver.findElement(By.xpath("//h1[contains(text(),'" + planName + "')]"))));

    }

    /**
     * Delete all the drugs from the profile
     */
    public void deleteAllDrugs(String drugList) {
		if (validate(savedDrug, 45)) {
			CommonUtility.waitForPageLoadNew(driver, savedDrugsList.get(0), 45);
			if (drugList.contains(",")) {
				String[] drugs = drugList.split(",");
				for (String drugName : drugs) {
					driver.findElement(
							By.xpath("//div[contains(text(),'" + drugName + "')]/following::button[text()='Remove']"))
							.click();
					removeDrugBtn.click();
				}
			} else {
				driver.findElement(
						By.xpath("//div[contains(text(),'" + drugList + "')]/following::button[text()='Remove']"))
						.click();
				removeDrugBtn.click();
			}
		}


        CommonUtility.waitForPageLoadNew(driver, importLnk, 45);
        Assertion.assertTrue(importLnk.isDisplayed());
    }

    /**
     * Delete all the providers from the profile
     */
    public void deleteProviders() {
		/*if(!StringUtils.isEmpty(CommonConstants.SELECTED_STATE) && (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Pennsylvania")
				|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Puerto Rico")
				|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) ) {*/
        String State = CommonConstants.getSelectedState();
//		if(!StringUtils.isEmpty(CommonConstants.SELECTED_STATE) && StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {
            CommonUtility.waitForPageLoadNew(driver, savedProvidersList.get(0), 45);
            for (WebElement provider : savedProvidersList) {
                driver.findElement(By.xpath("//div[contains(text(),'" + provider.getText().trim() + "')]/following::button[text()='Remove']")).click();
                removeDrugBtn.click();
            }
            CommonUtility.waitForPageLoadNew(driver, addDoctor, 45);
            Assertion.assertTrue(addDoctor.isDisplayed());
    }

    /**
     * Validate the new header
     *
     * @param data
     */
    public void validateNewHeader(DataTable data) {
        Map<String, String> expectedData = data.asMap(String.class, String.class);
        Assertion.assertEquals("welcome," + expectedData.get("Name").toLowerCase(), profileName.getText().trim().toLowerCase());
        Assertion.assertEquals("Your Saved\n" + "Insurance Plans (1)", savedInsuredPlans.getText().trim());
        Assertion.assertEquals("Your Saved\n"+"Drugs & Pharmacy (1)", yourSavedPharmacyAndDrugs.getText().trim());
        Assertion.assertEquals("Your Saved\n"+"Doctors & Dentists (1)", yourSavedDoctorsAndProviders.getText().trim());
        Assertion.assertEquals("Your Plan Recommendations", yourRecommendations.getText().trim());
        Assertion.assertEquals("Your Enrollments", yourEnrollments.getText().trim());
        Assertion.assertEquals("Manage Profile", manageProfile.getText().trim());
        Assertion.assertEquals("Sign Out", signOutText.getText().trim());

    }


    public void ValidateDrugsProviders(String drugsFlag, String providersFlag) {
        CommonUtility.waitForPageLoadNew(driver, VPHeader_DrugsLinks, 20);
        jsClickNew(VPHeader_DrugsLinks);

        if (drugsFlag.equalsIgnoreCase("true") || drugsFlag.equalsIgnoreCase("yes")) {
            System.out.println("Total Drugs Added Count - " + removeDrugs.size());
            Assertion.assertTrue(">>>>>> Validation Failed for drugs Added <<<<<<<<< - No Drugs Added ", removeDrugs.size() > 0);
        }
        if (drugsFlag.equalsIgnoreCase("false") || drugsFlag.equalsIgnoreCase("no")) {
            System.out.println("Total Drugs Added Count - " + removeDrugs.size());
            Assertion.assertTrue(">>>>>> Validation Failed for drugs NOT Added <<<<<<<<< - Drugs Added ", removeDrugs.size() == 0);
        }
        if (providersFlag.equalsIgnoreCase("true") || providersFlag.equalsIgnoreCase("yes")) {
            System.out.println("Total Providers Added Count - " + removeProviders.size());
            Assertion.assertTrue(">>>>>> Validation Failed for Providers Added <<<<<<<<< - No Providers Added ", removeProviders.size() > 0);
        }
        if (providersFlag.equalsIgnoreCase("false") || providersFlag.equalsIgnoreCase("no")) {
            System.out.println("Total Providers Added Count - " + removeProviders.size());
            Assertion.assertTrue(">>>>>> Validation Failed for Providers NOT Added <<<<<<<<< - Providers Added ", removeProviders.size() == 0);
        }
    }

	public ProviderSearchPage addDoctor() {
		 switchToNewTabNew(addDoctor);
		 sleepBySec(15);
		 
		 if (driver.getCurrentUrl().contains("werally")) {
			 return new ProviderSearchPage(driver);	
		 }
		 return null;
		
	}
	
	  /**
     * Back to VPP
     */
	
	@FindBy(xpath = "//*[contains(@dlassetid,'pd_lnk_1')]")
	private WebElement backtoProfile;

    public void selectPlan(String planName) {
        
        	WebElement plan = driver.findElement(
    				By.xpath("//*[contains(@dtmname,'"+planName+"')]"));
			
        	plan.click();

            waitForPageLoadSafari();
            CommonUtility.checkPageIsReadyNew(driver);
            waitforElementNew(backtoProfile);
            backtoProfile.click();
           
    }
    
    @FindBy(xpath = "//*[contains(@dtmname,'Your Saved Drugs & Pharmacy')]")
	private WebElement viewDrugs;

    
    public void viewDrugs() { 
    viewDrugs.click();
    }
    
    @FindBy(xpath = "//input[contains(@id, 'drugsearch')]")
	public WebElement EnterDrugNameTxt;

    public BuildYourDrugList editDrugfromProfile(String editDrug) {
		WebElement editLink = driver.findElement(By.xpath("//*[contains(@aria-label,'Edit " + editDrug + "')]"));
		jsClickNew(editLink);
		CommonUtility.waitForPageLoadNew(driver, EnterDrugNameTxt, 20);
		if (validateNew(EnterDrugNameTxt)) {
			return new BuildYourDrugList(driver);
		} else {
			Assertion.fail("Tell Us About Drug Page is NOT Displayed");
			return null;
		}
    }
    
	@FindBy(xpath = "//button[contains(@dtmname, 'Yes Remove')]")
	public WebElement DeleteYesBtn;

	public void deleteDrugProfile(String deleteDrug) {
		 waitForPageLoadSafari();
         CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Drug to be removed : " + deleteDrug);
		WebElement removeLink = driver.findElement(By.xpath("//*[contains(@aria-label,'Remove " + deleteDrug + "')]"));
		waitforElementNew(removeLink);
		//validateNew(removeLink);
		jsClickNew(removeLink);
	//	validateNew(DeleteYesBtn);
		jsClickNew(DeleteYesBtn);
	}
	
	/**
	 * Select plans and compare
	 * 
	 * @param plans
	 * @return
	 */
	public void compareAPlan(String plans) {
		WebElement compareaPlan;
		if (plans.equals("PDP")) {
			compareaPlan = driver
					.findElement(By.xpath("//*[contains(@dtmname,'Prescription Drug Plans:Compare Plan')]"));
		} else if ((plans.equals("MAPD")) || (plans.equals("MA"))) {
			compareaPlan = driver
					.findElement(By.xpath("//*[contains(@dtmname,'Medicare Advantage Plans:Compare Plan')]"));
			System.out.println("MAPD plan");
		} else {
			compareaPlan = driver.findElement(By.xpath("//*[contains(@dtmname,'Compare Plan')]"));
		}

		jsClickNew(compareaPlan);
		System.out.println("adding plans to compare");

	}


	@FindBy(xpath = "//*[contains(@id,'ErrorMsg')][contains(text(),'Save at least two')]")
	private WebElement errMsgCompareplans;

	public void validateFailureMsg(String planType) {
		
		String errorMessage = errMsgCompareplans.getText();

		if(planType.equals("PDP")) {
			Assertion.assertEquals("Error message text doesnot match", "*Save at least two Prescription Drug Plans to compare", errorMessage);
				}
		else if(planType.equals("MA") || planType.equals("MAPD")) {
			Assertion.assertEquals("Error message text doesnot match", "*Save at least two Medicare Advantage Plans to compare", errorMessage);
		}
		else
		{Assertion.assertEquals("Error message text doesnot match", "*Save at least two ", errorMessage);
		}
	}

		
	@FindBy(xpath = "//*[contains(@dtmname,'Next')]")
	private WebElement nextBtnMS;

	public WelcomePage enrollInMSPlan(String planName) {

		WebElement EnrolledPlan = driver.findElement(
				By.xpath("//*[contains(@aria-describedby,'" + planName + "') and contains(@dtmname,'Start')]"));
		jsClickNew(EnrolledPlan);

		waitforElementDisapper(
				By.xpath("//*[contains(@aria-describedby,'" + planName + "') and contains(@dtmname,'Start')]"), 5);
		sleepBySec(3);
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, nextBtnMS, 30);
		if (driver.getCurrentUrl().contains("welcome")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;

	}

	public WelcomePage enrollInPlan(String planName) {

		WebElement EnrolledPlan = driver.findElement(By.xpath("//button[@aria-label='Enroll " + planName + "']"));
		jsClickNew(EnrolledPlan);

		waitforElementDisapper(By.xpath("//button[@aria-label='Enroll " + planName + "']"), 5);
		sleepBySec(3);
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoadNew(driver, NextBtn, 30);
		if (driver.getCurrentUrl().contains("welcome")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;

	}
	
	public void importDrugsAndDoctors(DataTable data) {
        Map<String, String> testData = data.asMap(String.class, String.class);
        jsClickNew(importLnk);
        jsClickNew(btnGetStarted);
        switch (testData.get("Member")) {
		case "Aetna":
			jsClickNew(chkAetna);
	        jsClickNew(btnNext);
	        jsClickNew(chkMAwithAetna);
	        jsClickNew(btnNext);
	        waitforElementNew(chkReqAccess);
	        jsClickNew(chkReqAccess);
	        jsClickNew(chkTermsOfUse);
	        jsClickNew(flexContinueBtn);
	        waitforElement(flexImportBtn);
	        jsClickNew(flexImportBtn);
	        threadsleep(5000);
	        switchToNewTab();
	        Assert.assertTrue(driver.getCurrentUrl().contains("aetna.com"));
			break;
		case "Humana":
			jsClickNew(chkHumana);
	        jsClickNew(btnNext);
	        jsClickNew(chkMAwithHumana);
	        jsClickNew(btnNext);
	        waitforElementNew(chkReqAccess);
	        jsClickNew(chkReqAccess);
	        jsClickNew(chkTermsOfUse);
	        jsClickNew(flexContinueBtn);
	        waitforElement(flexImportBtn);
	        jsClickNew(flexImportBtn);
	        threadsleep(5000);
	        switchToNewTab();
	        Assert.assertTrue(driver.getCurrentUrl().contains("humana.com"));
			break;	
		case "UHC":
			jsClickNew(chkUHC);
	        jsClickNew(btnNext);
			txtFName.sendKeys(testData.get("FirstName"));
			txtLName.sendKeys(testData.get("LastName"));
			txtDOB.sendKeys(testData.get("DOB"));
			txtZipCode.sendKeys(testData.get("ZipCode"));
			txtMedicareId.sendKeys(testData.get("MBI"));
			jsClickNew(chkAttest);
			jsClickNew(btnViewDrugsAndDocs);
			waitforElementNew(savedDrugsAndDoctorsHeader);
			break;
		case "NonMember":
			jsClickNew(chkMilliman);
	        jsClickNew(btnNext);
	        jsClickNew(btnNonMemNext);
	        txtAgreementName.sendKeys(testData.get("FirstName")+" "+testData.get("LastName"));
	        jsClickNew(btnNonMemNext2);
			txtNonMemFName.sendKeys(testData.get("FirstName"));
			txtNonMemLName.sendKeys(testData.get("LastName"));
			txtNonMemDOB.sendKeys(testData.get("DOB"));
			jsClickNew(genderMale);
			txtNonMemZipCode.sendKeys(testData.get("ZipCode"));
			jsClickNew(chkAttest);
			jsClickNew(btnNonMemViewDrugsAndDocs);
			sleepBySec(15);
			waitforElementNew(savedDrugsAndDoctorsHeader);
			break;

		default:
			break;
		}
		
	}
	
	/**
	 * Validate MS Plan Details Page
	 */
	public void validateMSPlanDetailsPage() {
		Assert.assertTrue(lnkbackToProfile.isDisplayed());
		Assert.assertTrue(headingBasicCost.isDisplayed());
		Assert.assertTrue(headingDocVisits.isDisplayed());
	}
	
	public void clickOnMSPlanDetailsPage(String planName) {
	    //WebElement btnMSPlanDetails = driver.findElement(By.xpath("//h2[text()='"+planName+"']/following::span[text()='Plan Details'][1]"));
	    CommonUtility.checkPageIsReadyNew(driver);
		WebElement btnMSPlanDetails = driver.findElement(By.xpath("//h2[text()='"+planName+"']/following::span[text()=' Plan Details' or text()='Plan Details'][1]"));
		jsClickNew(btnMSPlanDetails);
		waitforElementNew(lnkbackToProfile);
	}
	
	/**
	 * Validate MS Start application Page
	 */
	public void validateMSStartApplicationPage() {
		Assert.assertTrue(msDOB.isDisplayed());
		Assert.assertTrue(btnContinueApplication.isDisplayed());
		Assert.assertTrue(closeMSApplication.isDisplayed());
	}
	
	public void clickOnMStartApplication(String planName) {
	    WebElement btnStartApplication = driver.findElement(By.xpath("//h2[text()='"+planName+"']/following::span[text()='Start Application'][1]"));
		jsClickNew(btnStartApplication);
		waitforElementNew(msDOB);
	}
	
	public void clickOnBackToProfile() {
		jsClickNew(lnkbackToProfile);
		waitforElementNew(addPlans);
	}
	
	public void clickOnCloseMSApplication() {
		jsClickNew(closeMSApplication);
		waitforElementNew(addPlans);
	}
	
	public void clickOnMLearnMore(String planName) {
	    WebElement btnStartApplication = driver.findElement(By.xpath("//h2[text()='"+planName+"']/following::a[text()='Learn More'][1]"));
		jsClickNew(btnStartApplication);
		waitforElementNew(lnkbackToProfile);
	}
	
	/**
	 * Validate MS LearnMore Page
	 */
	public void validateMSLearnMorePage() {
		Assert.assertTrue(lnkbackToProfile.isDisplayed());
		//Assert.assertTrue(headingGymMembership.isDisplayed());
		Assert.assertTrue(headingBH.isDisplayed());
	}
	
	public void clickOnMSAddYourInformation(String planName) {
	    WebElement btnAddInfo = driver.findElement(By.xpath("//h2[text()='"+planName+"']/following::a[text()='Add your information'][1]"));
		jsClickNew(btnAddInfo);
		waitforElementNew(msDOB);
	}
	
	/**
	 * Validate MS Add Your Information Page
	 */
	public void validateMSAddYourInfoPage() {
		waitforElementNew(msDOB);
		Assert.assertTrue(headingAddYourInfo.isDisplayed());
	}
	
	public void validateMSSP4ProfilePage(String componentCode) {
		Assert.assertTrue(btnPREGetStarted.isDisplayed());
		Assert.assertTrue(lnkImport.isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'"+componentCode+"')]")).isDisplayed());
	}

	public void validateNameOnFlyout(String name) {
		sleepBySec(3);
		driver.findElement(By.xpath("//*[contains(@class,'saved_items')]")).click();
		WebElement authName=driver.findElement(By.xpath("//h2[@id='auth-profile']"));
		if(authName.getText().trim().equalsIgnoreCase("Welcome, "+name)){
			System.out.println(" Correct Text present on Flyout: "+ authName.getText().trim());
		}else{
			Assert.fail("Wrong Text present on Flyout: "+authName.getText().trim());
		}


	}

	public void clickOnImportLinkOnDCE() {
		sleepBySec(2);
		WebElement lnkImportDCE=driver.findElement(By.xpath("(//button[@id='importDrug'])[1]"));
		if (validateNew(lnkImportDCE)){
			System.out.println("Import Link on DCE present");
			jsClickNew(lnkImportDCE);
			System.out.println("Import Link on DCE clicked");
			sleepBySec(4);
			WebElement ImportHeader =driver.findElement(By.xpath("(//div[@id='modal'])//div//div[contains(@class,'header')]//h2"));
			if (ImportHeader.getText().trim().equalsIgnoreCase("import drugs and doctors")){
				System.out.println("Import Pop-Up opened");
			}else{
				System.out.println("\n"+ImportHeader.getText().trim());
				Assert.fail("Import Pop-Up not opened");
			}
		}else{
			Assert.fail("Import link on DCE not present");
		}

	}

	public void importOnDCE(DataTable data) {
		Map<String, String> testData = data.asMap(String.class, String.class);
		WebElement btnGetStarted =driver.findElement(By.xpath("//div[contains(@class,'data-import')]//button//span[contains(text(),'Get')]"));
		validateNew(btnGetStarted);
		jsClickNew(btnGetStarted);
		sleepBySec(1);
		WebElement rdbYes=driver.findElement(By.xpath("//span[contains(@class,'radio-button__label') and contains(text(),'Yes')]"));
		jsClickNew(rdbYes);
		WebElement btnNext =driver.findElement(By.xpath("//div[contains(@class,'data-import')]//button//span[contains(text(),'Next')]"));
		jsClickNew(btnNext);
		sleepBySec(3);

		WebElement txtFirstName=driver.findElement(By.xpath("//input[@id='member-first-name']"));
		WebElement txtLastName =driver.findElement(By.xpath("//input[@id='member-last-name']"));
		WebElement txtYourDOB =driver.findElement(By.xpath("//input[@id='member-date-of-birth']"));
		WebElement txtYourZIP =driver.findElement(By.xpath("//input[@id='member-zip-code']"));
		WebElement txtYourMBI =driver.findElement(By.xpath("//input[@id='member-medicare-number']"));
		WebElement chkAttest =driver.findElement(By.xpath("//input[@id='member-attestation-field']"));
		WebElement btnViewDrugsDoc =driver.findElement(By.xpath("//div[contains(@class,'data-import')]//button//span[contains(text(),'View Your ')]"));

		txtFirstName.sendKeys(testData.get("FirstName"));
		txtLastName.sendKeys(testData.get("LastName"));
		txtYourDOB.sendKeys(testData.get("DOB"));
		txtYourZIP.sendKeys(testData.get("ZipCode"));
		txtYourMBI.sendKeys(testData.get("MBI"));
		//jsClickNew(driver.findElement(By.xpath("//div[@id='modal']//div//div[contains(@class,'header')]//h2")));
		//jsClickNew(txtYourMBI);
		sleepBySec(2);
		jsClickNew(chkAttest);
		sleepBySec(2);
		//jsClickNew(btnViewDrugsDoc);
		btnViewDrugsDoc.click();
		sleepBySec(10);
		waitforElementNew(btnReviewDrugs,60);
		if (validateNew(btnReviewDrugs)){
			System.out.println("Drug import is successfull");
		}else{
			Assert.fail("Drug import unsuccessfull");
		}
	}

	public void signInOnDCEImport(String username, String password) {
		try {
			jsClickNew(signIn);
			Thread.sleep(3000);
			waitForPageLoadSafari();
			// driver.findElement(By.cssSelector("input#userNameId_input")).sendKeys(username);
			driver.findElement(By.xpath("//input[contains(@id,'userNameId_input')]")).sendKeys(username);
			driver.findElement(By.cssSelector("input#passwdId_input")).sendKeys(password);
			jsClickNew(driver.findElement(By.cssSelector("input#SignIn")));
			waitForPageLoadSafari();
			Thread.sleep(3000);
			String Question = driver.findElement(By.cssSelector("span#challengeQuestionLabelId")).getText().trim();
			WebElement securityAnswer = driver.findElement(By.cssSelector("input#UnrecognizedSecAns_input"));
			waitforElement(securityAnswer);
			if (Question.equalsIgnoreCase("What is your best friend's name?")) {
				System.out.println("Question is related to friendname");
				securityAnswer.sendKeys("name1");
			} else if (Question.equalsIgnoreCase("What is your favorite color?")) {
				System.out.println("Question is related to color");
				securityAnswer.sendKeys("color1");
			} else {
				System.out.println("Question is related to phone");
				securityAnswer.sendKeys("number1");
			}
			jsClickNew(driver.findElement(By.cssSelector("input#authQuesSubmitButton")));
			waitForPageLoadSafari();
			CommonUtility.checkPageIsReadyNew(driver);
			sleepBySec(3);
			if(driver.getCurrentUrl().contains("health-plans/estimate-drug-costs")){
				System.out.println("Redirect to DCE page is successful");
				Assert.assertTrue(true);
			}else{
				System.out.println("Redirect to DCE page is not successful");
			}
		} catch (Exception e) {
			Assertion.fail("###############Optum Id Sign In failed###############");
		}
	}

	public WelcomePage Enroll_OLE_Plan_SignInUser(String planName) throws InterruptedException {



		System.out.println("Enroll in Plan for Plan through Vistor Profile: " + planName);
		WebElement EnrollinPlan = driver.findElement(By.xpath("//*[contains(text(), '" + planName + "')]/following::*[contains(text(), 'Enroll in Plan')]"));
		jsClickNew(EnrollinPlan);

		if (driver.getCurrentUrl().contains("welcome")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;
	}

	public void signInOptumId(String username, String password) {

		validateNew(signIn);
		jsClickNew(signIn);
		waitForPageLoadSafari();
		driver.findElement(By.cssSelector("input#userNameId_input")).sendKeys(username);
		driver.findElement(By.cssSelector("input#passwdId_input")).sendKeys(password);
		jsClickNew(driver.findElement(By.cssSelector("input#SignIn")));
		waitForPageLoadSafari();
		String Question = driver.findElement(By.cssSelector("#challengeQuestionLabelId")).getText().trim();
		WebElement securityAnswer = driver.findElement(By.xpath("//input[@id='UnrecognizedSecAns_input']"));
		if (Question.equalsIgnoreCase("What is your best friend's name?")) {
			System.out.println("Question is related to friendname");
			securityAnswer.sendKeys("name1");
		} else if (Question.equalsIgnoreCase("What is your favorite color?")) {
			System.out.println("Question is related to color");
			securityAnswer.sendKeys("color1");
		} else {
			System.out.println("Question is related to phone");
			securityAnswer.sendKeys("number1");
		}

	}
}

