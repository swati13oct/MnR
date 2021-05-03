package pages.mobile.acquisition.commonpages;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;
import atdd.framework.UhcDriver;

import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
import pages.mobile.acquisition.ole.WelcomePageMobile;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.ComparePlansPage;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.commonpages.VisitorProfilePage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.vpp.VPPTestHarnessPage;

public class VisitorProfilePageMobile extends UhcDriver {

	@FindBy(id = "dupIconFlyOut")
	private WebElement shoppingCartIcon;

	@FindBy(css = "div.signupCTA a:first-child")
	private WebElement signIn;

	@FindBy(css = "div.signupCTA a.profileBtn")
	private WebElement btnCreateProfile;

	@FindBy(xpath = "//div[contains(@class,'find-plans')]/button")
	private WebElement addPlans;

	@FindBy(css = "a.addrugs")
	private WebElement addrugs;

	@FindBy(xpath = "//span[text()='Add Drugs']/parent::button")
	private WebElement addDrugsBtn;

	@FindBy(css = "a.add-provider")
	private WebElement addprovider;

	@FindBy(xpath = "//div[contains(@class,'drug-list-accordion')]//button[contains(@class,'drug-list-toggle')][contains(@class,'collapsed')]")
	private WebElement expandDrugBlock;

	@FindBy(xpath = "//div[contains(@class,'provider--block card')]//button[contains(@class,'provider-title')][contains(@class,'collapsed')]")
	private WebElement expandProviderBlock;

	@FindBy(xpath = "//*[contains(@id,'DrugName-noplan-0')]")
	private WebElement drugName;

	@FindBy(xpath = "//*[contains(@class,'pharminfo')]")
	private WebElement pharmacyAddress;

	@FindAll({ @FindBy(xpath = "//li[@class='drug']") })
	private List<WebElement> savedDrugs;

	@FindBy(xpath = "//div[contains(@class,'drug--block card')]//ul")
	private WebElement drugBlock;

	@FindBy(css = "div.signupCTA.signupContainer a")
	private WebElement signOut;

	@FindBy(id = "enrollment-next-button")
	private WebElement NextBtn;

	@FindBy(xpath = "//div[@id='dashPlansContainer']//div[contains(@class,'Plan')][1]//div[@class='enroll-container']/button")
	private WebElement enrollInPlan;

	@FindBy(id = "header-number")
	private WebElement shoppingCartNumber;

	@FindBy(xpath = "//div[contains(@class,'compare')]/button")
	private WebElement comparePlans;

	@FindBy(css = "button.cta-button.create-profile")
	private WebElement comparePlansOnPopup;

	@FindBy(xpath = "//*[contains(@id,'enrollbtnplancompare0')]")
	private WebElement enrollBtn;

	@FindBy(css = "div#navLinks>a:first-child")
	private WebElement backToPlans;

	@FindBy(xpath = "//div[@class='multi-year-select']")
	private WebElement profileMultiYear;

	@FindBy(xpath = "//div[@class='multi-year-select']/button[contains(@class,'select-year')][2]")
	private WebElement profileNxtYrPlans;

	@FindBy(xpath = "//div[@class='multi-year-select']/button[contains(@class,'js-select-year select-year')][1]")
	private WebElement profileCrntYrPlans;

	@FindBy(xpath = "//button[contains(@id,'addDrug')]")
	public WebElement AddMyDrugsBtn;

	public VisitorProfilePageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(shoppingCartIcon);

	}

	public AcquisitionHomePageMobile addPlan() {
		// addPlans.click();
		scrollToView(addPlans);
		jsClickMobile(addPlans);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			String page = "health-plans";
			// System.out.println("validating zipcode and returning
			// value-----------------------------------------------------");
			return new AcquisitionHomePageMobile(driver);
		}
		return null;
	}

	public void validateAddedDrugAndPharmacy(String drug) {
		expandDrugBlock.click();

		Assertion.assertTrue(drugName.getText().trim().contains(drug));
		Assertion.assertTrue(pharmacyAddress.isDisplayed());
	}

	public void validateAddedPlans(String planNames) {
		List<String> listOfTestPlans = Arrays.asList(planNames.split(","));

		String State = CommonConstants.getSelectedState();
		/*
		 * if (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE,
		 * "Pennsylvania") ||
		 * StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Puerto Rico")
		 * || StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia"))
		 * {
		 */
		if (StringUtils.equalsIgnoreCase(State, "Pennsylvania") || StringUtils.equalsIgnoreCase(State, "Puerto Rico")
				|| StringUtils.equalsIgnoreCase(State, "Virginia")) {
			for (String plan : listOfTestPlans) {
				Assertion.assertEquals(plan,
						driver.findElement(By.xpath("//h4[contains(text(),'" + plan + "')]")).getText().trim());
				Assertion.assertTrue(driver.findElement(By.xpath(
						"//h4[contains(text(),'" + plan + "')]/following::a[contains(@class,'add-provider')][1]"))
						.isDisplayed());
				System.out.println(driver.findElement(By.xpath("//h4[contains(text(),'" + plan + "')]")).getText());
			}
		} else {
			for (String plan : listOfTestPlans) {
				Assertion.assertEquals(plan,
						driver.findElement(By.xpath(
								"//button[contains(@class,'remove')]/following::h3[contains(text(),'" + plan + "')]"))
								.getText().trim());
				Assertion.assertTrue(driver
						.findElement(By.xpath(
								"//button[contains(@class,'remove')]/following::h3[contains(text(),'" + plan + "')]"))
						.isDisplayed());
				System.out.println(driver
						.findElement(By.xpath(
								"//button[contains(@class,'remove')]/following::h3[contains(text(),'" + plan + "')]"))
						.getText());
			}
		}
	}

	public PlanDetailsPageMobile navigateToPlanDetails(String planName) {
		try {
			driver.findElement(By.xpath("//h4[text()='" + planName + "']")).click();
			Thread.sleep(20000);
			if (driver.getCurrentUrl().contains("#/details")) {
				return new PlanDetailsPageMobile(driver);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@FindBy(xpath = "//h3[contains(text(),'Save your information')]")
	private WebElement saveYourInformation;

	@FindBy(xpath = "//button[contains(@dtmid,'acq_visitor_profile')]//span[contains(text(),'Get Started')]")
	private WebElement GetStartedDrug;

	public GetStartedPageMobile addDrug_DCERedesign() {

		String State = CommonConstants.getSelectedState();
		/*
		 * if (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE,
		 * "Pennsylvania") ||
		 * StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Puerto Rico")
		 * || StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia"))
		 * {
		 */
		if (StringUtils.equalsIgnoreCase(State, "Pennsylvania") || StringUtils.equalsIgnoreCase(State, "Puerto Rico")
				|| StringUtils.equalsIgnoreCase(State, "Virginia")) {
			jsClickNew(addrugs);
		} else {
			jsClickNew(addDrugsBtn);
		}
		waitForPageLoadSafari();
		if (validateNew(AddMyDrugsBtn))
			return new GetStartedPageMobile(driver);
		return null;
	}

	/**
	 * Deletes the specified plans
	 * 
	 * @param plans
	 */
	public void deletePlans(String plans) {
		if (validate(profileMultiYear, 10)) {
			// profileNxtYrPlans.click();
			jsClickMobile(profileNxtYrPlans);
			if (driver.findElements(By.xpath("//div[@class='title dropdown-open']")).size() > 0)
				driver.findElement(By.xpath(
						"//div[@class='multi-year-select']/button[contains(@class,'js-select-year select-year')][2]/following::button[2]"))
						.click();
			else
				System.out.println("##############No saved plans available for 2021##############");

			profileCrntYrPlans.click();
		} else {
			System.out.println("##############MultiYear not displayed##############");
		}

		try {
			if (driver.findElements(By.xpath("//div[@class='title dropdown-open']")).size() > 0) {
				List<String> listOfTestPlans = Arrays.asList(plans.split(","));
				for (String plan : listOfTestPlans) {
					driver.findElement(By.xpath("//h4[text()='" + plan + "']/preceding::button[1]")).click();
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
		driver.findElement(By.xpath("//li[@class='drug']//button")).click();
		/*
		 * for (WebElement drug: savedDrugs) {
		 * drug.findElement(By.xpath("//button")).click(); }
		 */
		CommonUtility.waitForPageLoadNew(driver, addrugs, 45);
		Assertion.assertTrue(addrugs.isDisplayed());
	}

	/**
	 * Get the added provider information
	 * 
	 * @param planName
	 * @return
	 */
	public boolean providerinfo(String planName) {
		WebElement ProviderSearchLink = driver.findElement(By.xpath("//*[contains(text(),'" + planName
				+ "')]/following::div[contains(@class, 'providers--drugs')][1]//div[contains(@class,'provider-list added')]/div/button"));
		String mproviderinfo = ProviderSearchLink.getText();
		System.out.println(mproviderinfo);
		if (mproviderinfo.toLowerCase().contains("providers covered")) {
			return true;
		}
		return false;

	}

	/**
	 * Delete all the providers from the profile
	 */
	public void deleteAllProviders() {
		if (!(driver.findElements(By.cssSelector("div.no-providers")).size() > 0)) {
			CommonUtility.waitForPageLoadNew(driver, expandProviderBlock, 20);
			expandProviderBlock.click();
			driver.findElement(By.xpath("//li[@class='provider']//button")).click();
			waitforElementDisapper(By.xpath(
					"//div[contains(@class,'provider--block card')]//button[contains(@class,'provider-title')][contains(@class,'collapsed')]"),
					5);
			Assertion.assertTrue(validateNonPresenceOfElement(expandProviderBlock));
		} else {
			System.out.println("############No Providers##############");
		}
	}

	/**
	 * Sign In with Optum Id credentials
	 * 
	 * @param username
	 * @param password
	 */
	public void signIn(String username, String password) {
		try {

			signIn.click();
			driver.findElement(By.cssSelector("input#userNameId_input")).sendKeys(username);
			driver.findElement(By.cssSelector("input#passwdId_input")).sendKeys(password);
			driver.findElement(By.cssSelector("input#SignIn")).click();
			String Question = driver.findElement(By.cssSelector("label#challengeQuestionLabelId")).getText().trim();
			WebElement securityAnswer = driver.findElement(By.cssSelector("div#challengeSecurityAnswerId >input"));
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
	public WelcomePageMobile Enroll_OLE_Plan(String planName) {
		WebElement enrollForPlan = null;

		enrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '" + planName
				+ "')]/ancestor::*[contains(@class,'title-container')]//*[contains(@class,'btn') and contains(@dtmname,'Enroll in Plan')]"));
		if (enrollForPlan != null) {
			jsClickNew(enrollForPlan);
		}
		validateNew(NextBtn);
		if (driver.getCurrentUrl().contains("welcome")) {
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePageMobile(driver);
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
		// driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
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

		comparePlans.click();
		/*
		 * CommonUtility.waitForPageLoad(driver, comparePlansOnPopup, 20); String[] plan
		 * = plans.split(","); for(int i=0;i<4;i++) {
		 * driver.findElement(By.xpath("//label[text()='"+plan[i]+
		 * "']/preceding-sibling::input")).click(); } comparePlansOnPopup.click();
		 */
		validateNew(enrollBtn);
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
	public VPPPlanSummaryPageMobile backToPlans() {
		try {
			// Thread.sleep(10000);
			// SbackToPlans.click();
			jsClickMobile(backToPlans);

			CommonUtility.checkPageIsReadyNew(driver);
			if (driver.getCurrentUrl().contains("#/plan-summary")) {
				return new VPPPlanSummaryPageMobile(driver);
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

	@FindBy(xpath = "//span[text()='Add Drugs']")
	public WebElement addDrugsGlobal;

	public void clickAddDrugsGlobal() {
		pageloadcomplete();
		validateNew(addDrugsGlobal);
		// addDrugsGlobal.click();
		jsClickNew(addDrugsGlobal);
	}

	@FindBy(xpath = "//*[contains(@aria-controls,'plan-drugs-dropdown')]/img")
	public WebElement expandDrugsPlanCard;

	@FindBy(xpath = "//*[text()='Edit Drugs']")
	public WebElement editDrugsPlanCard;

	/**
	 * click edit drugs from plan card
	 */
	public void clickEditDrugsPlancard() {
		expandDrugsPlanCard.click();
		editDrugsPlanCard.click();
	}

	@FindBy(xpath = "//*[contains(@class,'add-drug')]")
	public WebElement enterDrugInfoPlanCard;

	/**
	 * click add drugs from plan card
	 */
	public void clickAddDrugsPlancardNew() {
		enterDrugInfoPlanCard.click();
	}

	@FindBy(xpath = "//a[contains(text(),'Back to Drug Cost Estimator')]")
	public WebElement backToDrugCostEstimatorLink;

	public void validateBackToDceLink() {
		validate(backToDrugCostEstimatorLink);
	}

	public void validateAddedPlansNew(String planNames) {
		List<String> listOfTestPlans = Arrays.asList(planNames.split(","));
		CommonUtility.checkPageIsReadyNew(driver);
		for (String plan : listOfTestPlans) {
			System.out.println(plan);/*
										 * System.out.println(driver.findElement(By.xpath(
										 * "//h2[@id='saved-plans']/..//*[contains(@id,'planName') and contains(text(),'"
										 * + plan + "')]")) .getText());
										 */
			Assertion.assertEquals(plan, driver.findElement(By.xpath(
					"//h2[@id='saved-plans']/..//*[contains(@id,'planName') and contains(text(),'" + plan + "')]"))
					.getText());
			Assertion.assertTrue(driver
					.findElement(By.xpath("//h2[@id='saved-plans']/..//*[contains(@id,'planName') and contains(text(),'"
							+ plan + "')]/following::button[1]"))
					.isDisplayed());
			System.out.println("Verified plans are added on visitior profile page");
		}
	}

	public void validateAddedMsPlans(String planNames) {
		try {
			List<String> listOfTestPlans = Arrays.asList(planNames.split(","));
			CommonUtility.checkPageIsReadyNew(driver);
			Thread.sleep(20000);
			for (String plan : listOfTestPlans) {
				Assertion.assertEquals(plan, driver.findElement(By.xpath("//h2[text()='" + plan + "']")).getText());
				Assertion.assertTrue(driver
						.findElement(By.xpath(
								"//div/a[contains(@aria-describedby,'" + plan + "')] [contains(@class,'pdf-link')]"))
						.isDisplayed());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/..//a[contains(text(),'Sign In')]")
	public WebElement loginLink;

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/..//a[contains(text(),'Sign Out')]")
	public WebElement signOutLink;

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
				//securityAnswer.sendKeys("color1");
				sendkeysMobile(securityAnswer, "color1");
			} else {
				System.out.println("Question is related to phone");
				//securityAnswer.sendKeys("number1");
				sendkeysMobile(securityAnswer, "number1");
			}
			driver.findElement(By.cssSelector("input#authQuesSubmitButton")).click();
			CommonUtility.waitForPageLoadNew(driver, signOutLink, 20);

		} catch (Exception e) {
			Assertion.fail("###############Optum Id Sign In failed###############");
		}

	}

	public VisitorProfilePageMobile validateVisitorProfilePage() {
		if (driver.getCurrentUrl().contains("profile")) {
			validate(btnCreateProfile);
			return new VisitorProfilePageMobile(driver);
		} else {
			Assertion.fail("Navigation to visitor profile is failed");
		}
		return null;
	}

	public void validateAddedPlansPDFLinks(String planNames) {
		List<String> listOfTestPlans = Arrays.asList(planNames.split(","));
		for (String plan : listOfTestPlans) {
			Assertion.assertTrue(driver
					.findElement(By
							.xpath("//div/a[contains(@aria-describedby,'" + plan + "')] [contains(@class,'pdf-link')]"))
					.isDisplayed());
		}
	}
}
