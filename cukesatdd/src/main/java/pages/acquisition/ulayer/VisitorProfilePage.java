package pages.acquisition.ulayer;

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
import pages.acquisition.dceredesign.GetStartedPage;
import pages.acquisition.ole.WelcomePage;

public class VisitorProfilePage extends UhcDriver {

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

	@FindBy(xpath = "//*[contains(text(),'Your Drugs (')]")
	private List<WebElement> totalDrugs;

	@FindBy(xpath = "//button[contains(@id,'DrugDelete')]")
	private List<WebElement> editDrugs;
	
	@FindBy(xpath = "//button[contains(@id,'ProviderDelete')]")
	private List<WebElement> editProviders;

	@FindBy(xpath = "//*[contains(text(),'Your Providers (')]")
	private List<WebElement> totalProviders;
	
	@FindBy(xpath = "//button[@aria-label='Delete Plan']")
	private List<WebElement> deletPlan;


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
	
	@FindBy(xpath = "//*[contains(@id,'ghn_lnk')]/span[text()='Shop For a Plan']")
	private WebElement homeTab;
	
	@FindBy(xpath = "//*[@class='locationEnrollment']//*[contains(@class,'drug-list-accordion')]/button")
	public WebElement expandDrugsGlobal;
	
	@FindBy(xpath = "//*[@class='locationEnrollment']//*[@class='edit-drugs']/a")
	public WebElement editDrugsGlobal;
	
	@FindBy(xpath = "//*[@id='dashPlansContainer']//*[@class='add-drug']")
	public WebElement addDrugsPlanCard;
	
	@FindBy(xpath = "//a[contains(text(),'Back to Drug Cost Estimator')]")
	public WebElement backToDrugCostEstimatorLink;
	
	@FindBy(xpath = "(//*[contains(@class,'uhc-coverage-dropdown-trigger d-flex align-items-center justify-content-between pr-20 p-20')])[2]")
	public WebElement expandDrugsPlanCard;
	
	@FindBy(xpath = "//*[text()='Edit Drugs']")
	public WebElement editDrugsPlanCard;
	
	@FindBy(xpath = "//*[contains(@class,'add-drug')]")
	public WebElement enterDrugInfoPlanCard;
	
	@FindBy(xpath = "//a[text()='Log In']")
	public WebElement loginLink;

	public VisitorProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(shoppingCartIcon);

	}

	public void clearDrugs() {
		if (totalDrugs.size()!=0) {
			for(int i=0;i<editDrugs.size();i++) {
				totalDrugs.get(0).click();
				validate(editDrugs.get(i));
				editDrugs.get(i).click();
			}
			validate(addrugs);
		}
	}
	
	public void clearProvider() {
		if (totalProviders.size()!=0) {
			for(int i=0;i<editProviders.size();i++) {
				totalProviders.get(0).click();
				validate(editProviders.get(i));
				editProviders.get(i).click();
			}
		}
	}
	
	public void deletePlans() {
		if (deletPlan.size()!=0) {
			for(int i=0;i<deletPlan.size();i++) {
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				validate(deletPlan.get(i));
				deletPlan.get(i).click();
			}
		}
	}

	public DrugCostEstimatorPage addDrug() {

		addrugs.click();
		if (currentUrl().contains("/estimate-drug-costs.html"))
			return new DrugCostEstimatorPage(driver);
		return null;
	}

	@FindBy(xpath = "//button[contains(@id,'addDrug')]")
	public WebElement AddMyDrugsBtn;

	public GetStartedPage addDrug_DCERedesign() {

		addrugs.click();
		if (validateNew(AddMyDrugsBtn))
			return new GetStartedPage(driver);
		return null;
	}

	public AcquisitionHomePage addPlan() throws Exception {
		addPlans.click();
		Thread.sleep(10000);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("health-plans.html")) {
			String page = "health-plans";
			return new AcquisitionHomePage(driver, page);
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

	public void validateAddedDrugAndPharmacy(String drug) {
		validateNew(expandDrugBlock);
		jsClickNew(expandDrugBlock);
		System.out.println("Drug Name Text : " + drugName.getText().trim());
		Assert.assertTrue(drugName.getText().trim().contains(drug));
		// Assert.assertTrue(pharmacyAddress.isDisplayed());
		System.out.println("Verified Drug Displayed :" + drugName.getText().trim());
	}

	public void validateAddedPlans(String planNames) {
		List<String> listOfTestPlans = Arrays.asList(planNames.split(","));
		CommonUtility.checkPageIsReadyNew(driver);
		for (String plan : listOfTestPlans) {
			Assert.assertEquals(plan, driver.findElement(By.xpath("//h3[text()=' " + plan + " ']")).getText());
			Assert.assertTrue(
					driver.findElement(By.xpath("//h3[text()=' " + plan + " ']/following::button[1]")).isDisplayed());
			System.out.println("Verified plans are added on vistior profile page");
		}
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

	/**
	 * Validate the pdf links available
	 * 
	 * @param planNames
	 */
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
	 * Navigate to the plan details page
	 * 
	 * @param planName
	 * @return
	 */
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
			if(driver.findElements(By.xpath("//div[@class='title dropdown-open']")).size()>0){
				if(driver.findElements(By.xpath("//div[@class='title dropdown-open']")).size()==1)
					driver.findElement(By.xpath("//div[@class='multi-year-select']/button[contains(@class,'js-select-year select-year')][2]/following::button[2]")).click();
				else {
					List<String> listOfTestPlans = Arrays.asList(plans.split(","));
					for (String plan: listOfTestPlans) {
						driver.findElement(By.xpath("//h4[text()='"+plan+"']/preceding::button[1]")).click();
						Thread.sleep(5000);
						}
					}
				System.out.println("##############All saved plans deleted##############");
				}
				else
					System.out.println("##############No saved plans available here##############");
		}	catch (Exception e) {
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
			CommonUtility.waitForPageLoadNew(driver, signOut, 20);

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

	public void backtoPlan() {
		backToPlans.click();
		CommonUtility.checkPageIsReadyNew(driver);
	}
	
	
	public AcquisitionHomePage clickHomeTab() {
		try {
			//homeTab.click();
			jsClickNew(homeTab);
			CommonUtility.checkPageIsReadyNew(driver);
			if (driver.getCurrentUrl().contains("#/plan-summary")) {
				return new AcquisitionHomePage(driver);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public VisitorProfilePage validateVisitorProfilePageDisplayed() {
		if (driver.getCurrentUrl().contains("profile")) {
			return new VisitorProfilePage(driver);
		} else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}
	
	/**
	 * click edit drugs globally
	 */
	public void clickEditDrugs() {
		expandDrugsGlobal.click();
		editDrugsGlobal.click();
	}
	
	/**
	 * click add drugs from plan card
	 */
	public void clickAddDrugsPlancard() {
		addDrugsPlanCard.click();
	}
	
	public void validateBackToDceLink() {
		validate(backToDrugCostEstimatorLink);
	}
	
	/**
	 * click edit drugs from plan card
	 */
	public void clickEditDrugsPlancard() {
		expandDrugsPlanCard.click();
		editDrugsPlanCard.click();
	}
	
	public void validateAddedPlansNew(String planNames) {
		List<String> listOfTestPlans = Arrays.asList(planNames.split(","));
		CommonUtility.checkPageIsReadyNew(driver);
		for (String plan: listOfTestPlans) {
			Assert.assertEquals(plan, driver.findElement(By.xpath("//h3[text()=' "+plan+" ']")).getText());
			Assert.assertTrue(driver.findElement(By.xpath("//h3[text()=' "+plan+" ']/following::button[1]")).isDisplayed());
			System.out.println("Verified plans are added on vistior profile page");
		}
	}
	
	/**
	 * click add drugs from plan card
	 */
	public void clickAddDrugsPlancardNew() {
		enterDrugInfoPlanCard.click();
	}
	
	public void logIn(String username, String password) {
		try {

			loginLink.click();
			driver.findElement(By.cssSelector("input#userNameId_input")).sendKeys(username);
			driver.findElement(By.cssSelector("input#passwdId_input")).sendKeys(password);
			System.out.println("before signin");
			driver.findElement(By.cssSelector("input#SignIn")).click();
			System.out.println("before wait");
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
			CommonUtility.waitForPageLoadNew(driver, signOut, 20);

		} catch (Exception e) {
			Assert.fail("###############Optum Id Sign In failed###############");
		}

	}
}
