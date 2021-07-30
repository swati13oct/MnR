package pages.mobile.acquisition.commonpages;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
import pages.mobile.acquisition.dceredesign.BuildYourDrugListMobile;
import pages.mobile.acquisition.dceredesign.DrugDetailsPageMobile;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
import pages.mobile.acquisition.ole.WelcomePageMobile;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.ComparePlansPage;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.commonpages.VisitorProfilePage;
import pages.acquisition.dceredesign.BuildYourDrugList;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.ole.WelcomePage;
import pages.acquisition.vpp.VPPTestHarnessPage;

public class VisitorProfilePageMobile extends UhcDriver {

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

//	@FindBy(id = "dupIconFlyOut")
	@FindBy(css = "div[class^='shoppingcartwidget'] button[aria-describedby='savedItemsFlyout']")
	private WebElement shoppingCartIcon;

	@FindBy(xpath = "//a[@class='text-small header-link-mobile'][normalize-space()='Or, Sign In to your Profile']")
	private WebElement signIn;

	@FindBy(css = "div.signupCTA a.signin-font")
	private WebElement signInLegacy;

	// @FindBy(css = "div.signupCTA a.profileBtn")
	@FindBy(css = "header[class*='profile-header-mobile'] a[dtmname*='Create Profile']")
	private WebElement btnCreateProfile;

	@FindBy(xpath = "//button[@class='uhc-button uhc-button--outlined uhc-button--secondary mt-20']")
	private WebElement addPlans;

	@FindBy(xpath = "//span[normalize-space()='Add Drugs']")
	private WebElement addrugs;

	@FindBy(xpath = "//span[normalize-space()='Add Drugs']")
	private WebElement addDrugsBtn;

	@FindBy(css = "a.add-provider")
	private WebElement addprovider;

	@FindBy(xpath = "//div[contains(@class,'drug-list-accordion')]//button[contains(@class,'drug-list-toggle')][contains(@class,'collapsed')]")
	private WebElement expandDrugBlock;

	@FindBy(xpath = "//div[contains(@class,'provider--block card')]//button[contains(@class,'provider-title')][contains(@class,'collapsed')]")
	private WebElement expandProviderBlock;

	@FindBy(xpath = "//*[contains(@id,'DrugName-noplan-0')]")
	private WebElement drugName;

	@FindBy(css = "ul.drugs-list>li:last-child>span")
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

	@FindBy(xpath = "//a[text()='Compare Plans']")
	private WebElement comparePlans;

	@FindBy(css = "button.cta-button.create-profile")
	private WebElement comparePlansOnPopup;

	@FindBy(xpath = "//*[contains(@id,'enrollbtnplancompare0')]")
	private WebElement comparePlansPageControl;

	@FindBy(xpath = "//*[@id='enrollbtnplancompare0']/button/span")
	private WebElement enrollButton;

	@FindBy(xpath = "//div[@class='uhc-compare-header__controls']")
	private WebElement comparePlansConrol;

	@FindBy(css = "div#navLinks>a:first-child")
	private WebElement backToPlans;

	@FindBy(xpath = "//div[@class='multi-year-select']")
	private WebElement profileMultiYear;

	@FindBy(xpath = "//div[@class='multi-year-select']/button[contains(@class,'select-year')][2]")
	private WebElement profileNxtYrPlans;

	@FindBy(xpath = "//div[@class='multi-year-select']/button[contains(@class,'js-select-year select-year')][1]")
	private WebElement profileCrntYrPlans;

	@FindBy(xpath = "//*[@id='addDrug']")
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
		jsClickNew(addPlans);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			String page = "health-plans";

			return new AcquisitionHomePageMobile(driver);
		}
		return null;
	}

	@FindBy(css = "h2#saved-drugs-and-doctors")
	public WebElement savedDrugsAndDoctorsHeader;
	
    @FindBy(css = "#landrover > main > app-dashboard-header > header.uhc-profile-header-mobile.position-relative.pt-20.mb-40 > div:nth-child(2) > nav > a:nth-child(2) > span")
    public WebElement drugHeader;

    @FindBy(css = "h3#saved-drugs")
    public WebElement savedDrugsHeader;

	public void validateAddedDrugAndPharmacy(String drug) throws InterruptedException {

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
		// CommonUtility.waitForPageLoad(driver, pharmacyAddress, 10);
		
		Assertion.assertTrue((drugHeader.getText().trim().contains("Your Saved (1) Drugs & Pharmacy")));
		// Assertion.assertEquals("Your Saved Drugs (1) & Pharmacy §",
		// drugHeader.getText().trim());
		jsClickNew(drugHeader);
		System.out.println("Drug Name in VP page: " + drugName.getText());
		Assertion.assertTrue(drugName.getText().trim().contains(drug));
		Assertion.assertEquals("Drugs (1) & Pharmacy", savedDrugsHeader.getText().trim());
		Assertion.assertEquals("Saved Drugs (1) & Pharmacy | Doctors & Providers (0)",
				savedDrugsAndDoctorsHeader.getText().trim());
		// Assertion.assertTrue(pharmacyAddress.isDisplayed());
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
			WebElement plan = driver.findElement(By.xpath("//button[contains(@class,'remove')]/following::h3[contains(text(),'" + planName + "')]"));
           scrollToView(plan);
			jsClickNew(plan);
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
			// jsClickNew(addrugs);
			removeAddedDrugsFromVP();
			iosScroll(addDrugsBtn);
			jsClickNew(addDrugsBtn);
		} else {
			removeAddedDrugsFromVP();
			iosScroll(addDrugsBtn);
			jsClickNew(addDrugsBtn);
		}
		waitForPageLoadSafari();

		if (validateNew(AddMyDrugsBtn))
			return new GetStartedPageMobile(driver);
		return null;
	}

	@FindBy(xpath = "//*[@id='navLinks']/a[1]")
	private WebElement breadCrumbLink;

	public void verifyBreadCrumb(String breadCrumb) {
		Assertion.assertTrue("Expected breadcrumb " + breadCrumb + "not displayed",
				breadCrumbLink.getText().equals(breadCrumb));
	}

	@FindBy(xpath = "//button[contains(text(),'Remove')]")
	private WebElement remove;

	public void removeAddedDrugsFromVP() {
		pageloadcomplete();

		try {

			if (remove.isDisplayed()) {
				System.out.println("Remove links present - Existing drugs available..........");
				List<Dimension> drugListRemoveLinks = Arrays.asList(remove.getSize());
				for (Dimension wb : drugListRemoveLinks) {
					remove.click();

				}

			} else {
				System.out.println("Remove link not available - No existing drugs available..........");
			}
		} catch (Exception e) {
			System.out.println("Unable to check existing drugs.......");
		}

	}

	public GetStartedPageMobile addDrug_DCERedesigns() {

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
			scrollToView(addrugs);
			jsClickNew(addrugs);
		} else {
			scrollToView(addDrugsBtn);
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
			jsClickNew(profileNxtYrPlans);
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
			/*
			 * if (!StringUtils.isEmpty(CommonConstants.SELECTED_STATE) &&
			 * (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Pennsylvania")
			 * || StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE,
			 * "Puerto Rico") ||
			 * StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia"))) {
			 */
			String State = CommonConstants.getSelectedState();
			/*
			 * if (!StringUtils.isEmpty(CommonConstants.SELECTED_STATE) &&
			 * StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {
			 */
			if (!StringUtils.isEmpty(State) && StringUtils.equalsIgnoreCase(State, "Virginia")) {
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
	 * Validate the enrolled plan details on profile page
	 * 
	 * @param oleDetails
	 */
	public void validateOLEDetails(Map<String, String> givenAttributesMap) {
		// Handled data table in step definition
		/*
		 * List<DataTableRow> givenAttributesRow = oleDetails.getGherkinRows();
		 * Map<String, String> givenAttributesMap = new HashMap<String, String>(); for
		 * (int i = 0; i < givenAttributesRow.size(); i++) {
		 * 
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */
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

	@FindBy(xpath = "//button[normalize-space()='Edit']")
	public WebElement editDrugsPharmacy;

	public BuildYourDrugListMobile clickOnEditDrugAndPharmacy() {
		CommonUtility.waitForPageLoadNew(driver, editDrugsPharmacy, 45);
		jsClickNew(editDrugsPharmacy);
		if (driver.getCurrentUrl().contains("buildyourdruglist"))
			return new BuildYourDrugListMobile(driver);
		return null;
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

	@FindBy(css = "a[dlassetid^='vp_add_drug']")
	public WebElement AddDrugsGlobal;

	/**
	 * click edit drugs globally
	 */
	public void clickAddDrugsBtn() {
		jsClickNew(AddDrugsGlobal);
	}

	@FindBy(xpath = "//button[contains(@dtmname,'Visitor Profile:Saved Doctors/Providers:Remove Modal:Yes Remove')]")
	public WebElement ConfirmRemoveProvider;

	@FindBy(xpath = "//button[contains(@dtmname,'Visitor Profile:Saved Doctors/Providers:Remove')]")
	public List<WebElement> removeProviders;

	public void clearProvider() {
		try {
			/*
			 * if (expandProvidersPlanCard.isDisplayed()) { expandProvidersPlanCard.click();
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
			// }
		} catch (Exception e) {
			System.out.println("No existing providers found");
		}
	}

	@FindBy(xpath = "//button[contains(@dtmname,'Visitor Profile:Saved Drugs/Pharmacy:Remove Modal:Yes Remove')]")
	public WebElement ConfirmRemoveDrug;

	@FindBy(css = "header[class^='uhc-profile-header-mobile'] a[dtmname$='Header:Auth:Your Saved Drugs & Pharmacy']")
	public WebElement VPHeader_DrugsLinks;

	@FindBy(xpath = "//button[contains(@dtmname,'Visitor Profile:Saved Drugs/Pharmacy:Remove')]")
	public List<WebElement> removeDrugs;

	public void clearDrugs() {
		CommonUtility.waitForPageLoadNew(driver, VPHeader_DrugsLinks, 20);
		jsClickNew(VPHeader_DrugsLinks);
		try {
			/*
			 * if (expandDrugsPlanCard.isDisplayed()) { expandDrugsPlanCard.click();
			 */
			System.out.println(removeDrugs.size());
			while (removeDrugs.size() != 0) {
				waitforElementNew(removeDrugs.get(0));
				validateNew(removeDrugs.get(0));
				jsClickNew(removeDrugs.get(0));
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
			// }
		} catch (Exception e) {
			System.out.println("No existing drugs found");
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
			/*
			 * if(!StringUtils.isEmpty(CommonConstants.SELECTED_STATE) &&
			 * (StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Pennsylvania")
			 * || StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE,
			 * "Puerto Rico") ||
			 * StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) ) {
			 */
			String State = CommonConstants.getSelectedState();
			// if(!StringUtils.isEmpty(CommonConstants.SELECTED_STATE) &&
			// StringUtils.equalsIgnoreCase(CommonConstants.SELECTED_STATE, "Virginia")) {
			if (!StringUtils.isEmpty(State) && StringUtils.equalsIgnoreCase(State, "Virginia")) {
				Thread.sleep(3000);
				// signInLegacy.click();
				scrollToView(signIn);
				signIn.click();

			} else {
				System.out.println("Clicking on SignIn from Visitor Profile guest page");
				scrollToView(signIn);
				signIn.click();
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
			// CommonUtility.waitForPageLoadNew(driver, signOut, 15);

		} catch (Exception e) {
			Assertion.fail("###############Optum Id Sign In failed###############");
		}

	}

	public DrugDetailsPageMobile clickBackToDCELink() {
		jsClickNew(backToDrugCostEstimatorLink);
		waitForPageLoadSafari();
		if (driver.getCurrentUrl().contains("drugdetails")) {
			return new DrugDetailsPageMobile(driver);
		} else
			return null;
	}

	/**
	 * Enroll in a plan
	 * 
	 * @param planName
	 * @return
	 */
	public WelcomePageMobile Enroll_OLE_Plan(String planName) {

		WebElement enrollForPlan = null;

		enrollForPlan = driver
				.findElement(By.xpath("//button[contains(@class,'remove')]/following::h3[contains(text(),'" + planName
						+ "')]/following::button[contains(@dtmname,'Enroll in Plan')][1]"));
		if (enrollForPlan != null) {
			jsClickNew(enrollForPlan);
		}
		waitForPageLoadSafari();
		waitforElementVisibilityInTime(NextBtn, 20);
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
	public ComparePlansPageMobile planCompare(String plans) {

		comparePlans.click();
		waitforElementVisibilityInTime(comparePlansPageControl, 10);
		/*
		 * CommonUtility.waitForPageLoad(driver, comparePlansOnPopup, 20); String[] plan
		 * = plans.split(","); for(int i=0;i<4;i++) {
		 * driver.findElement(By.xpath("//label[text()='"+plan[i]+
		 * "']/preceding-sibling::input")).click(); } comparePlansOnPopup.click();
		 */
		validateNew(enrollButton);
		if (driver.getCurrentUrl().contains("/plan-compare")) {

			System.out.println("Navigation to Plan Compare page is Passed");
			return new ComparePlansPageMobile(driver);
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
			jsClickNew(backToPlans);

			CommonUtility.checkPageIsReadyNew(driver);
			if (driver.getCurrentUrl().contains("#/plan-summary")) {
				return new VPPPlanSummaryPageMobile(driver);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public VPPPlanSummaryPageMobile addPlanForMember() throws Exception {
		addPlans.click();
		Thread.sleep(10000);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("plan-summary")) {
			return new VPPPlanSummaryPageMobile(driver);
		}
		return null;
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

	@FindBy(xpath = "//span[text()='Add Drugs']")
	public WebElement addDrugsGlobal;

	public void clickAddDrugsGlobal() {
		pageloadcomplete();
		validateNew(addDrugsGlobal);
		// addDrugsGlobal.click();
		jsClickNew(addDrugsGlobal);
	}

	@FindBy(xpath = "(//button[contains(text(),'View Drug Pricing')])[1]")
    private WebElement viewDrugPricingLink;

	@FindBy(xpath = "//*[contains(@class, 'plan-drug-doctor')]//a[contains(@dtmname, 'Update your drugs')]")
    private WebElement DrugPricingModal_EditDrugslink;

	/**
	 * click edit drugs from plan card
	 */
	public void clickEditDrugsPlancard() {
		validateNew(viewDrugPricingLink);
        viewDrugPricingLink.click();
        System.out.println("View Drug Pricing is clicked for Plan Card");
        validateNew(DrugPricingModal_EditDrugslink);
        jsClickNew(DrugPricingModal_EditDrugslink);
        System.out.println("View Drug Pricing - Edit Drugs link is clicked for Plan Card");
	}

	@FindBy(xpath = "//*[contains(@class,'add-drug')]")
	public WebElement enterDrugInfoPlanCard;
	
	@FindBy(xpath = "(//div[@role='list']/div[starts-with(@class,'d-inline-block')]//a[contains(@dtmname,'Add Drugs')])[1]")
	public WebElement addDrugLinkFirstPlanCard;

	/**
	 * click add drugs from plan card
	 */
	public void clickAddDrugsPlancardNew() {
//		enterDrugInfoPlanCard.click();
		jsClickNew(addDrugLinkFirstPlanCard);
	}

	@FindBy(xpath = "//a[contains(text(),'Back to Drug Cost Estimator')]")
	public WebElement backToDrugCostEstimatorLink;

	public void validateBackToDceLink() {
		validate(backToDrugCostEstimatorLink);
	}

	public void validateAddedPlansNew(List<String> planNames) {
		CommonUtility.checkPageIsReadyNew(driver);
		for (String plans : planNames) {
			String[] listOfTestPlans = plans.split(",");
			for (String plan : listOfTestPlans) {
				System.out.println("Checking Saved Plan on VP for : " + plan);
				WebElement addedPlan = driver.findElement(By.cssSelector("[dtmname$='Card:" + plan + "']"));
				validateNew(addedPlan);
				Assertion.assertEquals(plan, addedPlan.getText().trim());
				System.out.println("Verified plans are added on visitior profile page");
			}
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

	public VisitorProfilePageMobile clickOnShoppingCart() {
		shoppingCartIcon.click();
		if (driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePageMobile(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}

	public void validateAddedDrugs(String druglist) {
		// expandDrugBlock.click();

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

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/..//a[contains(text(),'Sign In')]")
	public WebElement loginLink;

	@FindBy(xpath = "//input[contains(@id, 'agreeButton')]")
	public WebElement ShareOneHealth_AgreeButton;

	@FindBy(xpath = "//*[contains(@id, 'identity-confirm-title')]")
	public WebElement ConfirmIdentity_ModalHdr;

	@FindBy(xpath = "//*[contains(@class, 'identity-confirm')]//button[contains(@class, 'close')]")
	public WebElement ConfirmIdentity_ModalClose;

//	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/..//a[contains(text(),'Sign Out')]")
	@FindBy(css = "header[class*='uhc-profile-header-mobile'] a[dtmname$='Sign Out']")
	public WebElement signOutLink;

	public void logIn(String username, String password) {
		try {

			// loginLink.click();
			jsClickNew(loginLink);
			waitForPageLoadSafari();
			sendkeysMobile(driver.findElement(By.cssSelector("input#userNameId_input")), username);
			sendkeysMobile(driver.findElement(By.cssSelector("input#passwdId_input")), password);
			System.out.println("before signin");
			jsClickNew(driver.findElement(By.cssSelector("input#SignIn")));
			System.out.println("before wait");
			waitForPageLoadSafari();
			waitforElement(driver.findElement(By.cssSelector("#securityQues")));
			System.out.println("after wait");
			String Question = driver.findElement(By.cssSelector("#challengeQuestionLabelId")).getText().trim();
			WebElement securityAnswer = driver.findElement(By.cssSelector("#UnrecognizedSecAns_input"));
			if (Question.equalsIgnoreCase("What is your best friend's name?")) {
				System.out.println("Question is related to friendname");
				sendkeysMobile(securityAnswer, "name1");
			}

			else if (Question.equalsIgnoreCase("What is your favorite color?")) {
				System.out.println("Question is related to color");
				sendkeysMobile(securityAnswer, "color1");
			} else {
				System.out.println("Question is related to phone");
				sendkeysMobile(securityAnswer, "number1");
			}
			jsClickNew(driver.findElement(By.cssSelector("input#authQuesSubmitButton")));
			try {
				if (validate(ShareOneHealth_AgreeButton)) {
					System.out
							.println("Share My One Healthcare ID Page is Dispalyed for VP Login - Clicking on I Agree");
					jsClickNew(ShareOneHealth_AgreeButton);
				}

			} catch (Exception e) {
				System.out.println("Share My One Healthcare ID Page is NOT Dispalyed for VP Login - Continuing to VP");
			}
			try {
				if (validate(ConfirmIdentity_ModalHdr) && validate(ConfirmIdentity_ModalClose)) {
					jsClickNew(ConfirmIdentity_ModalClose);
				}
			} catch (Exception e) {
				System.out
						.println("Confirm Identity and Import Modal is NOT Dispalyed for VP Login - Continuing to VP");
			}
			CommonUtility.waitForPageLoadNew(driver, signOutLink, 20);
		} catch (Exception e) {
			Assertion.fail("###############Optum Id Sign In failed###############");
		}

	}

}
