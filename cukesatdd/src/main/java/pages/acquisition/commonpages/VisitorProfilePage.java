
package pages.acquisition.commonpages;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.mysql.jdbc.StringUtils;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.vpp.VPPTestHarnessPage;

public class VisitorProfilePage extends UhcDriver {

	@FindBy(id = "dupIconFlyOut")
	private WebElement shoppingCartIcon;

	@FindBy(xpath = "//li//a[contains(text(),'Sign In')]")
	private WebElement signIn;
	
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

	@FindBy(xpath = "(//a[contains(text(),'Sign Out')])[2]")
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
	
	@FindBy(css="div.print-back>a:first-child")
	private WebElement legacyBackToPlans;

	@FindBy(xpath = "//div[@class='multi-year-select']")
	private WebElement profileMultiYear;

	@FindBy(xpath = "//div[@class='multi-year-select']/button[contains(@class,'select-year')][2]")
	private WebElement profileNxtYrPlans;

	@FindBy(xpath = "//div[@class='multi-year-select']/button[contains(@class,'select-year')][1]")
	private WebElement profileCrntYrPlans;

	@FindBy(xpath = "//button[contains(@id,'addDrug')]")
	public WebElement AddMyDrugsBtn;

	// New Shopper profile page objects

	@FindBy(xpath = "//h4[contains(text(),'drug')]/following::button[1]")
	public WebElement drugGetStarted;

	@FindBy(xpath = "//a[contains(@dtmname,'Saved Drugs')]/span[2]")
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

	@FindBy(xpath = "//span[text()='ZIP Code']/following-sibling::span")
	public WebElement enrolledPlanZipcode;

	@FindBy(xpath = "//span[text()='Monthly Premium']/following-sibling::span")
	public WebElement enrolledMonthlyPremium;

	@FindBy(xpath = "//span[text()='Yes, cancel application']/..")
	public WebElement cancelEnrollment;

	@FindBy(xpath = "//*[contains(@dtmname,'Add Drugs') and contains(@dtmid, 'visitor_profile')]")
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

	@FindBy(xpath = "//*[@id='saved-drugs']/../a[contains(text(),'Edit Your Drugs and Pharmacy')]")
	public WebElement editDrugsGlobal;

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/..//a[contains(text(),'Sign In')]")
	public WebElement loginLink;

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/..//a[contains(text(),'Sign Out')]")
	public WebElement signOutLink;

	@FindBy(xpath = "//button[@aria-expanded='true']/..//*[contains(@id,'plan-providers-dropdown')]//button[@aria-label='Remove drug']")
	public List<WebElement> removeDrugsPlanCard;

	@FindBy(xpath = "//*[contains(@aria-controls,'plan-providers-dropdown')]/img")
	public WebElement expandProvidersPlanCard;

	@FindBy(xpath = "//*[contains(@id,'plan-providers-dropdown')]//button[@aria-label='Remove provider']")
	public List<WebElement> removeProvidersPlanCard;

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
	
	@FindBy(xpath = "//button[text()='Yes, Remove']")
	private WebElement removeDrugBtn;
	
	@FindBy(xpath = "//h2[@id='saved-drugs-and-doctors']/following::a[contains(text(),'Import')]")
	private WebElement importLnk;
	
	@FindAll({ @FindBy(xpath = "//div[contains(@id,'DrugName')]") })
	private List<WebElement> savedDrugsList;
	
	@FindAll({ @FindBy(xpath = "//div[contains(@id,'ProviderName')]") })
	private List<WebElement> savedProvidersList;
	
	@FindBy(xpath = "//img[@class='uhc-modal__close']/parent::button")
	private WebElement modalClose;
	
	@FindBy(xpath = "(//h1)[1]")
	private WebElement profileName;
	
	@FindBy(css="nav.uhc-profile-header-nav ul li:first-child>a>span:nth-child(2)")
	private WebElement savedInsuredPlans;
	
	@FindBy(css="nav.uhc-profile-header-nav ul li:nth-child(2)>a>span:nth-child(2)")
	private WebElement yourSavedPharmacyAndDrugs;
	
	@FindBy(css="nav.uhc-profile-header-nav ul li:nth-child(3)>a>span:nth-child(2)")
	private WebElement yourSavedDoctorsAndProviders;
	
	@FindBy(css="nav.uhc-profile-header-nav ul li:nth-child(4)>a>span:nth-child(2)")
	private WebElement yourRecommendations;
	
	@FindBy(css="nav.uhc-profile-header-nav ul li:last-child>div>a:first-child")
	private WebElement yourEnrollments;
	
	@FindBy(css="nav.uhc-profile-header-nav ul li:last-child>div>a:nth-child(2)")
	private WebElement manageProfile;
	
	@FindBy(css="nav.uhc-profile-header-nav ul li:last-child>div>a:last-child")
	private WebElement signOutText;
	
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

		/*if(!StringUtils.isEmpty(CommonConstants.SELECTED_STATE) && (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Pennsylvania")
				|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Puerto Rico")
				|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) ) {*/
		if(!StringUtils.isEmpty(CommonConstants.SELECTED_STATE) && StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {
				
			jsClickNew(addplans);
		} else {
			jsClickNew(addPlans);
		}
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
	public void validateAddedDrugAndPharmacy(String drug) {

		/*if (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Pennsylvania")
				|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Puerto Rico")
				|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {*/
		if (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {
			jsClickNew(expandDrugBlock);
			Assert.assertTrue(drugname.getText().trim().contains(drug));
		} else {
			CommonUtility.waitForPageLoad(driver, pharmacyAddress, 10);
			Assert.assertEquals("Your Saved Drugs (1) & Pharmacy", drugHeader.getText().trim());
			jsClickNew(drugHeader);
			Assert.assertTrue(drugName.getText().trim().contains(drug));
			Assert.assertEquals("Drugs (1) & Pharmacy", savedDrugsHeader.getText().trim());
			Assert.assertEquals("Saved Drugs (1) & Pharmacy | Doctors & Providers (0)",
					savedDrugsAndDoctorsHeader.getText().trim());
			Assert.assertTrue(pharmacyAddress.isDisplayed());
		}
	}

	public void validateAddedPlans(String planNames) {
		List<String> listOfTestPlans = Arrays.asList(planNames.split(","));

		/*if (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Pennsylvania")
				|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Puerto Rico")
				|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {*/
		if (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {
			for (String plan : listOfTestPlans) {
				Assert.assertEquals(plan,
						driver.findElement(By.xpath("//h4[contains(text(),'" + plan + "')]")).getText().trim());
				Assert.assertTrue(driver.findElement(By.xpath(
						"//h4[contains(text(),'" + plan + "')]/following::a[contains(@class,'add-provider')][1]"))
						.isDisplayed());
				System.out.println(driver.findElement(By.xpath("//h4[contains(text(),'" + plan + "')]")).getText());
			}
		} else {
			for (String plan : listOfTestPlans) {
				Assert.assertEquals(plan,
						driver.findElement(By.xpath(
								"//button[contains(@class,'remove')]/following::h3[contains(text(),'" + plan + "')]"))
								.getText().trim());
				Assert.assertTrue(driver
						.findElement(By.xpath("//button[contains(@class,'remove')]/following::h3[contains(text(),'"
								+ plan + "')]/following::span[contains(@class,'search-provider')]"))
						.isDisplayed());
				System.out.println(driver
						.findElement(By.xpath(
								"//button[contains(@class,'remove')]/following::h3[contains(text(),'" + plan + "')]"))
						.getText());
			}
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
					Assert.fail("Drug List Validation FAILED for Drug : " + currentDrug);
				}
			}
		}
	}

	public PlanDetailsPage navigateToPlanDetails(String planName) {
		try {
			/*if (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Pennsylvania")
					|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Puerto Rico")
					|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {*/
			if (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {
				jsClickNew(driver.findElement(By.xpath("//h4[text()='" + planName + "']")));
			} else {
				jsClickNew(driver.findElement(By.xpath(
						"//button[contains(@class,'remove')]/following::h3[contains(text(),'" + planName + "')]")));
			}
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
		if (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {
			jsClickNew(addrugs);
		} else {
			jsClickNew(addDrugsBtn);
		}
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
			if (!StringUtils.isEmpty(CommonConstants.SELECTED_STATE)
					&& StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {
				List<String> listOfTestPlans = Arrays.asList(plans.split(","));
				for (String plan : listOfTestPlans) {
					jsClickNew(driver.findElement(By.xpath("//h4[text()='" + plan + "']/preceding::button[1]")));
					Thread.sleep(5000);
				}

			} else if (driver.findElements(By.xpath("//span[contains(text(),'Plan Summary')]")).size() > 0) {
				List<String> listOfTestPlans = Arrays.asList(plans.split(","));
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
		Assert.assertTrue(!(driver.findElements(By.xpath("//div[@class='title dropdown-open']")).size() > 0));
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
		Assert.assertTrue(addrugs.isDisplayed());
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
		if (mproviderinfo.toLowerCase().contains("providers covered")) {
			return true;
		}
		return false;
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
		if (mproviderinfo.toLowerCase().contains("providers covered")) {
			return true;
		}
		return false;
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
					"//h3[contains(text(),'" + planName + "')]/following::button[text()=' View Providers '][1]"));
			viewProviders.click();
			Thread.sleep(2000);
			String mproviderinfo = driver
					.findElement(By.xpath(
							"//table//td/div/div/div[@id='ProviderName-noplan-undefined']"))
					.getText().trim();
			
			String rallyProviderName = MRConstants.PROV_NAME;
			rallyProviderName = rallyProviderName.replaceAll(".", "").replaceAll(",", "");
			mproviderinfo = mproviderinfo.replaceAll(".", "").replaceAll(",", "");
			System.out.println(mproviderinfo);
			Assert.assertTrue(mproviderinfo.contains(rallyProviderName));
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
			if(!StringUtils.isEmpty(CommonConstants.SELECTED_STATE) && StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {
				Thread.sleep(3000);
				signInLegacy.click();
				
			}else {
				jsClickNew(signIn);
			}
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
			}

			else if (Question.equalsIgnoreCase("What is your favorite color?")) {
				System.out.println("Question is related to color");
				securityAnswer.sendKeys("color1");
			} else {
				System.out.println("Question is related to phone");
				securityAnswer.sendKeys("number1");
			}
			jsClickNew(driver.findElement(By.cssSelector("input#authQuesSubmitButton")));
			waitForPageLoadSafari();
			CommonUtility.waitForPageLoadNew(driver, signOut, 15);

		} catch (Exception e) {
			Assert.fail("###############Optum Id Sign In failed###############");
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
		Assert.assertEquals(plancount, shoppingCartNumber.getText());
		System.out.println("count mapped on Shopping cart icon with : " + plancount);

	}

	public VPPTestHarnessPage switchBackToVPTestharness() {
		driver.close();
		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
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
		validateNew(enrollBtn);
		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("/plan-compare")) {
			System.out.println("Navigation to Plan Compare page is Passed");
			return new ComparePlansPage(driver);
		} else {
			Assert.fail("Navigation to Plan Compare page is failed");
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
			if(!StringUtils.isEmpty(CommonConstants.SELECTED_STATE) && StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {
				legacyBackToPlans.click();
			}else
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
			List<String> listOfTestPlans = Arrays.asList(planNames.split(","));
			CommonUtility.checkPageIsReadyNew(driver);
			Thread.sleep(20000);
			for (String plan : listOfTestPlans) {

				/*if (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Pennsylvania")
						|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Puerto Rico")
						|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {*/
				if (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {
					Assert.assertEquals(plan, driver.findElement(By.xpath("//h2[text()='" + plan + "']")).getText());
					Assert.assertTrue(driver.findElement(By
							.xpath("//div/a[contains(@aria-describedby,'" + plan + "')] [contains(@class,'pdf-link')]"))
							.isDisplayed());
				} else {
					Assert.assertEquals(plan, driver.findElement(By.xpath("//h2[text()='" + plan + "']")).getText());
					// No pdf link is availbel now
					// Assert.assertTrue(driver.findElement(By.xpath("//div/a[contains(@aria-describedby,'"+plan+"')]
					// [contains(@class,'pdf-link')]")).isDisplayed());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateAddedPlansPDFLinks(String planNames) {
		List<String> listOfTestPlans = Arrays.asList(planNames.split(","));
		for (String plan : listOfTestPlans) {
			Assert.assertTrue(driver
					.findElement(By
							.xpath("//div/a[contains(@aria-describedby,'" + plan + "')] [contains(@class,'pdf-link')]"))
					.isDisplayed());
		}
	}

	/**
	 * Validate the enrolled plan details on profile page
	 * 
	 * @param oleDetails
	 */
	public void validateOLEDetails(DataTable oleDetails) {

		List<DataTableRow> givenAttributesRow = oleDetails.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String planName = givenAttributesMap.get("Plan Name");
		String zipCode = givenAttributesMap.get("Zip Code");
		String status = givenAttributesMap.get("Status");
		String monthlyPremium = givenAttributesMap.get("Monthly Premium");

		Assert.assertEquals(planName, enrolledPlanName.getText().trim());
		Assert.assertEquals(zipCode, enrolledPlanZipcode.getText().trim());
		Assert.assertEquals(status, enrolledStatus.getText().trim());
		waitforElementVisibilityInTime(enrolledMonthlyPremium, 10);
		Assert.assertEquals(monthlyPremium, enrolledMonthlyPremium.getText().trim());

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
			Assert.fail("Navigation to visitor profile is failed");
		}
		return null;
	}

	public void validateAddedPlansNew(String planNames) {
		List<String> listOfTestPlans = Arrays.asList(planNames.split(","));
		CommonUtility.checkPageIsReadyNew(driver);
		for (String plan : listOfTestPlans) {
			System.out.println("Checking Saved Plan on VP for : "+plan);
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
			 * Assert.assertEquals(plan, driver.findElement(By.xpath(
			 * "//h2[@id='saved-plans']/..//*[contains(@id,'planName') and contains(text(),'"
			 * + plan + "')]")) .getText().trim());
			 */
			Assert.assertEquals(plan, addedPlan.getText().trim());
			/*
			 * Assert.assertTrue(driver .findElement(By.
			 * xpath("//h2[@id='saved-plans']/..//*[contains(@id,'planName') and contains(text(),'"
			 * + plan + "')]/following::button[1]")) .isDisplayed());
			 */
/*			Assert.assertTrue(driver
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
			}

			else if (Question.equalsIgnoreCase("What is your favorite color?")) {
				System.out.println("Question is related to color");
				securityAnswer.sendKeys("color1");
			} else {
				System.out.println("Question is related to phone");
				securityAnswer.sendKeys("number1");
			}
			driver.findElement(By.cssSelector("input#authQuesSubmitButton")).click();
			CommonUtility.waitForPageLoadNew(driver, signOutLink, 20);

		} catch (Exception e) {
			Assert.fail("###############Optum Id Sign In failed###############");
		}

	}

	/**
	 * click edit drugs globally
	 */
	public void clickEditDrugs() {
		editDrugsGlobal.click();
	}

	public void clearDrugsFromPlanCard() {
		try {
			if (expandDrugsPlanCard.isDisplayed()) {
				expandDrugsPlanCard.click();
				System.out.println(removeDrugsPlanCard.size());
				while (removeDrugsPlanCard.size() != 0) {
					removeDrugsPlanCard.get(0).click();
					expandDrugsPlanCard.click();
					System.out.println(removeDrugsPlanCard.size());
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
			}
		} catch (Exception e) {
			System.out.println("No existing drugs found");
		}
	}

	public void clearProvider() {
		try {
			if (expandProvidersPlanCard.isDisplayed()) {
				expandProvidersPlanCard.click();

				while (removeProvidersPlanCard.size() != 0) {
					/*
					 * for(int i=0;i<editDrugs.size();i++) { totalDrugs.get(0).click();
					 * validate(editDrugs.get(i)); editDrugs.get(i).click(); }
					 */
					removeProvidersPlanCard.get(0).click();
					System.out.println("Removed provider");
					// validate(addrugs);
				}
			}
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
			}
			Assert.assertTrue(!(driver.findElements(By.xpath("//div[@class='title dropdown-open']")).size() > 0));
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
		Assert.assertTrue("Expected breadcrumb " + breadCrumb + "not displayed",
				breadCrumbLink.getText().equals(breadCrumb));
	}

	public void validateViewDrugPricingModel(DataTable drugInfo) {

		List<DataTableRow> givenAttributesRow = drugInfo.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String planName = givenAttributesMap.get("Plan Name");
		String zipCode = givenAttributesMap.get("Zip Code");
		String status = givenAttributesMap.get("Status");
		String monthlyPremium = givenAttributesMap.get("Monthly Premium");

		viewDrugPricingLink.click();
		Assert.assertTrue(validate(driver.findElement(By.xpath("//h1[contains(text(),'" + planName + "')]"))));

	}
	
	/**
	 * Delete all the drugs from the profile
	 */
	public void deleteAllDrugs(String drugList) {
		CommonUtility.waitForPageLoadNew(driver, savedDrugsList.get(0), 45);
		if(drugList.contains(",")) {
			String drugs[] = drugList.split(",");
			for(String drugName:drugs) {
				driver.findElement(By.xpath("//div[contains(text(),'"+drugName+"')]/following::button[text()='Remove']")).click();
				removeDrugBtn.click();
			}
		}else {
			driver.findElement(By.xpath("//div[contains(text(),'"+drugList+"')]/following::button[text()='Remove']")).click();
			removeDrugBtn.click();
		}
		
		
		CommonUtility.waitForPageLoadNew(driver, importLnk, 45);
		Assert.assertTrue(importLnk.isDisplayed());
	}
	
	/**
	 * Delete all the providers from the profile
	 */
	public void deleteProviders() {
		/*if(!StringUtils.isEmpty(CommonConstants.SELECTED_STATE) && (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Pennsylvania")
				|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Puerto Rico")
				|| StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) ) {*/
		if(!StringUtils.isEmpty(CommonConstants.SELECTED_STATE) && StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {
			providerAccordin.click();
			legactRemoveProvider.click();
			
		}else {
			CommonUtility.waitForPageLoadNew(driver, savedProvidersList.get(0), 45);
			for (WebElement provider : savedProvidersList) {
				driver.findElement(By.xpath("//div[contains(text(),'"+provider.getText().trim()+"')]/following::button[text()='Remove']")).click();
				removeDrugBtn.click();
			}
			CommonUtility.waitForPageLoadNew(driver, importLnk, 45);
			Assert.assertTrue(importLnk.isDisplayed());
		}
	}
	
	/**
	 * Validate the new header
	 * @param data
	 */
	public void validateNewHeader(DataTable data) {
		Map<String,String> expectedData = data.asMap(String.class, String.class);
		Assert.assertEquals("Welcome, "+expectedData.get("Name"), profileName.getText().trim());
		Assert.assertEquals("Your Saved Insurance Plans (1)", savedInsuredPlans.getText().trim());
		Assert.assertEquals("Your Saved Drugs (1) & Pharmacy", yourSavedPharmacyAndDrugs.getText().trim());
		Assert.assertEquals("Your Saved Doctors & Providers (1)", yourSavedDoctorsAndProviders.getText().trim());
		Assert.assertEquals("Your Plan Recommendations", yourRecommendations.getText().trim());
		Assert.assertEquals("Your Enrollments", yourEnrollments.getText().trim());
		Assert.assertEquals("Manage Profile", manageProfile.getText().trim());
		Assert.assertEquals("Sign Out", signOutText.getText().trim());
		
	}
	
	
}

