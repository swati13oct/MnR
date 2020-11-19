package pages.mobile.acquisition.ulayer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
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
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import pages.acquisition.ulayer.VPPTestHarnessPage;
import pages.mobile.acquisition.dceredesign.GetStartedPageMobile;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.ComparePlansPage;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.ole.WelcomePage;

public class VisitorProfilePageMobile extends UhcDriver {

	@FindBy(id = "dupIconFlyOut")
	private WebElement shoppingCartIcon;

	@FindBy(css = "div.signupCTA a:first-child")
	private WebElement signIn;

	@FindBy(css = "div.signupCTA a.profileBtn")
	private WebElement btnCreateProfile;

	@FindBy(css = "div.dashboardCard.plans a.empty-message-link")
	private WebElement addPlans;

	@FindBy(css = "a.addrugs")
	private WebElement addrugs;

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

	@FindBy(css = "div.print-back>a:first-child")
	private WebElement backToPlans;

	@FindBy(xpath = "//div[@class='multi-year-select']")
	private WebElement profileMultiYear;

	@FindBy(xpath = "//div[@class='multi-year-select']/button[contains(@class,'js-select-year select-year')][2]")
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

	public AcquisitionHomePage addPlan() {
		addPlans.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("zipcode")) {
			String page = "health-plans";
			return new AcquisitionHomePage(driver, page);
		}
		return null;
	}

	public void validateAddedDrugAndPharmacy(String drug) {
		expandDrugBlock.click();

		Assert.assertTrue(drugName.getText().trim().contains(drug));
		Assert.assertTrue(pharmacyAddress.isDisplayed());
	}

	public void validateAddedPlans(String planNames) {
		List<String> listOfTestPlans = Arrays.asList(planNames.split(","));
		for (String plan : listOfTestPlans) {
			Assert.assertEquals(plan, driver.findElement(By.xpath("//h4[text()='" + plan + "']")).getText());
			Assert.assertTrue(
					driver.findElement(By.xpath("//h4[text()='" + plan + "']/following::button[1]")).isDisplayed());
			Assert.assertTrue(driver
					.findElement(By.xpath("//h4[text()='" + plan + "']/following::div[@class='provider-list'][1]/a"))
					.isDisplayed());
		}
	}

	public PlanDetailsPage navigateToPlanDetails(String planName) {
		try {
			driver.findElement(By.xpath("//h4[text()='" + planName + "']")).click();
			Thread.sleep(20000);
			if (driver.getCurrentUrl().contains("#/details")) {
				return new PlanDetailsPage(driver);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@FindBy(xpath = "//h3[contains(text(),'Save your information')]")
	private WebElement saveYourInformation;

	@FindBy(xpath = "//button[contains(@dtmname,'acq_visitor_profile')]//span[contains(text(),'Get Started')]")
	private WebElement GetStartedDrug;

	public GetStartedPageMobile addDrug_DCERedesign() {

		// addrugs.click();
		jsClickNew(GetStartedDrug);
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
			profileNxtYrPlans.click();
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
		Assert.assertTrue(!(driver.findElements(By.xpath("//div[@class='title dropdown-open']")).size() > 0));
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
		Assert.assertTrue(addrugs.isDisplayed());
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
			Assert.assertTrue(validateNonPresenceOfElement(expandProviderBlock));
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

		enrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '" + planName
				+ "')]/ancestor::*[contains(@class,'title-container')]//*[contains(@class,'btn') and contains(@dtmname,'Enroll in Plan')]"));
		if (enrollForPlan != null) {
			jsClickNew(enrollForPlan);
		}
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
			Assert.fail("Navigation to Plan Compare page is failed");
		}
		return null;
	}

	/**
	 * Back to VPP
	 */
	public VPPPlanSummaryPage backToPlans() {
		try {
			backToPlans.click();
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
				Assert.assertEquals(plan, driver.findElement(By.xpath("//h2[text()='" + plan + "']")).getText());
				Assert.assertTrue(driver
						.findElement(By.xpath(
								"//div/a[contains(@aria-describedby,'" + plan + "')] [contains(@class,'pdf-link')]"))
						.isDisplayed());
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
}
