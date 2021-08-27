package pages.mobile.acquisition.commonpages;

import static atdd.framework.Assertion.assertTrue;
import static acceptancetests.data.CommonConstants.PLANTYPE.MAPD;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import pages.acquisition.commonpages.PageTitleConstants;

public class ShopPage extends GlobalWebElements {

	@FindBy(xpath = "//*[@id='ghn_lnk_2']")
	private WebElement ShopForaplan;

	@FindBy(xpath = ".//*[@id='updates-mobile-form']/div/div[2]/button")
	private WebElement submit;

	@FindBy(xpath = "//button[@type='submit' and @zipcompindex='0']")
	private WebElement GetStartedShopPage;

	@FindBy(id = "updates-email")
	private WebElement updatesemail;

	@FindBy(xpath = "//*[@id='subnav_2']/div[2]/div/p")
	private WebElement successMessage;

	@FindBy(xpath = ".//*[@id='updates-mobile-form']/div/div[2]/span[@class='errmsgcolor']")
	private WebElement errorMessage;

	@FindBy(xpath = ".//*[contains(@class,'email-col thankYouMsg')]")
	private WebElement validatesuccessmsg;

	@FindBy(xpath = "//a[text()='Plan Selector']")
	private WebElement PlanSelector;

	@FindBy(xpath = "")
	private WebElement shopHeader;

	@FindBy(xpath = "//div[@id='widget_POmb5hgvb0afo9HIaTIbiQ']/div/a")
	private WebElement GetStarted;

	@FindBy(xpath = "//*[contains(@id,'zipcodemeded-0')]")
	private WebElement zipCodeField1;

	@FindBy(xpath = "//*[contains(@id,'zipcodemeded-1')]")
	private WebElement zipCodeField2;

	@FindBy(xpath = "//a[text()='Drug Cost Estimator']")
	private WebElement Drugcostestimator;

	@FindBy(xpath = "//a[text()='Pharmacy Search']")
	private WebElement Pharmacysearch;

	@FindBy(xpath = "//a[text()='Provider Search']")
	private WebElement Providersearch;

	@FindBy(xpath = "//a[@class='cta-button secondary']")
	private WebElement canceldrugsearch;

	@FindBy(xpath = "//input[@id='zipcodeTxt']")
	private WebElement zipcodetxt;

	@FindBy(xpath = "//select[@id='plan-type']")
	private WebElement chooseaplan;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement pcontinue;

	@FindBy(xpath = "//div[@id='planTypesColumn']//a[text()='Enroll']")
	private WebElement enrollLink;

	@FindBy(xpath = "//div[@id='planTypesColumn']//a[text()='Shop']")
	private WebElement enrollShopLink;

	@FindBy(xpath = "//a[contains(@href,'ma-enrollment')]")
	private WebElement maLeanHowToEnrollLink;

	// @FindBy(xpath = "//*[contains(@href,'/shop/dual-special-needs-plans.html')and
	// contains(text(),'Shop')]")
	@FindBy(xpath = "(//a[contains(@href,'/shop/dual-special-needs-plans')])[3]")
	private WebElement dsnpShopLink;

	@FindBy(xpath = "(//*[contains(@href,'/shop/prescription-drug-plans')])[3]")
	private WebElement pdpShopLink;

	@FindBy(xpath = "(//*[contains(@href,'/shop/medicare-advantage-plans')])[3]")
	private WebElement MAShopLink;

	@FindBy(xpath = "(//a[contains(@href,'/shop/medicare-supplement-plans.html')])[3]")
	private WebElement medSupShopLink;

	@FindBy(xpath = "//div[@id='accordion2']//h3[text()='Enrollment']")
	private WebElement EnrollmentLink;

	@FindBy(xpath = "//h1/span[@class='heading-1']")
	private WebElement ShopHeader;

	@FindBy(xpath = "//*[contains(text(),'See more benefits')]")
	private WebElement seeMoreBenefitsLink;

	@FindBy(xpath = "//form[contains(@class,'zipForm')]")
	List<WebElement> zipForm;

	@FindBy(xpath = "(//form[contains(@class,'zipForm')]//input[contains(@class,'zip-input')])")
	// @FindBy(xpath = "(//form[contains(@class,'zip-form')]//input)[2]")
	List<WebElement> ZipCodeText;

	@FindBy(xpath = "(//form[contains(@class,'zipForm')]//button[contains(@class,'uhc-zip-button')])")
	// @FindBy(xpath =
	// "(//form[contains(@class,'zip-form')]//button[contains(@class,'zip-button')])[2]")
	List<WebElement> ZipcodeButton;

	@FindBy(xpath = "//span[@class='heading-1' and contains(text(),'Plan')]")
	private WebElement findYourPlanHeader;

	@FindBy(xpath = "//div[contains(@class,'NewCustomRTE')]//span[contains(@class,'heading-3')]")
	List<WebElement> findurPlanOptions;

	// @FindBy(xpath = "//a[contains(text(),'Compare')]")
	@FindBy(xpath = "//a[contains(@href,'/shop/compare')]")
	private WebElement comparePlanBtn;

	// @FindBy(xpath = "//a[contains(text(),'Learn')]")
	@FindBy(xpath = "//a[contains(@href,'/shop/estimate')]")
	private WebElement LearnEstimateCosts;

	// @FindBy(xpath = "//a[contains(text(),'How To')]")
	@FindBy(xpath = "//a[contains(@href,'/shop/switch')]")
	private WebElement howToSwitchPlans;

	// @FindBy(xpath = "//a[contains(text(),'Learn More')]")
	@FindBy(xpath = "//a[contains(@href,'/safe-shopping')]")
	private WebElement learnSafeShopping;

	// @FindBy(xpath = "//a[contains(text(),'Get Resources')]")
	@FindBy(xpath = "(//a[contains(@href,'/resources')])[2]")
	private WebElement getMemberResources;

	@FindBy(xpath = "//span[@class='heading-1' and contains(text(),'Personalize')]")
	private WebElement personalizeUrResults;

	@FindBy(xpath = "(//a[contains(@href,'/health-plans/estimate-drug-costs.html#/drug-cost-estimator')])[3]")
	private WebElement checkDrugCostsBtn;

	@FindBy(xpath = "(//a[contains(@href,'connect.werally.com/county-plan-selection/uhc.mnr/zip')])")
	private WebElement findAProviderBtn;

	@FindBy(xpath = "(//a[contains(@href,'/health-plans/aarp-pharmacy.html')])[3]")
	private WebElement locatePharmacyBtn;

	@FindBy(xpath = "//a[contains(@href,'https://www.myuhcagent.com/')]")
	private WebElement FindAnAgent;

	public ShopPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(MAShopLink);
		// validateNew(ShopForaplan); //This option is under Menu navigation
		if (!driver.getCurrentUrl().contains("shop.html")) {
			Assert.fail("Shop page did not load properly");
		}
	}

	public EnrollmentBasicsPageMobile enrollLinkOnShopPlan() throws Exception {
		waitforElement(enrollLink);
		enrollLink.click();
		Thread.sleep(4000);
		if (validate(maLeanHowToEnrollLink)) {
			waitforElement(maLeanHowToEnrollLink);
			System.out.println("OLE Learn More Modal is Displayed");
			return new EnrollmentBasicsPageMobile(driver);
		}
		return null;
	}

	public ShopPage ShopLinkOnShopPlan() throws Exception {
		waitforElement(enrollShopLink);
		jsClickNew(enrollShopLink);
		Thread.sleep(4000);
		if (validate(dsnpShopLink)) {
			waitforElement(dsnpShopLink);
			System.out.println("Shop Page Plan is Displayed");
			return new ShopPage(driver);
		}
		return null;
	}

	public void clickONEnrollShopLink(String plantype, String planName) throws Exception {
		if (plantype.equals("SNP")) {
			waitforElement(dsnpShopLink);
			scrollToView(dsnpShopLink);
			jsClickNew(dsnpShopLink);
			// Thread.sleep(5000);

		} else if (plantype.equals("PDP")) {
			waitforElement(pdpShopLink);
			scrollToView(pdpShopLink);
			jsClickNew(pdpShopLink);
			// Thread.sleep(5000);
		}

		else if (plantype.equals("MAPD") || plantype.equals("MA")) {
			waitforElement(MAShopLink);
			scrollToView(MAShopLink);
			jsClickNew(MAShopLink);
			// Thread.sleep(5000);
		}
	}

	public ShopPage ShopLinkOnMedsuppPlan() throws Exception {
		waitforElement(enrollShopLink);
		scrollToView(enrollShopLink);
		jsClickNew(enrollShopLink);
		// Thread.sleep(4000);
		if (validate(medSupShopLink)) {
			// waitforElement(medSupShopLink);
			scrollToView(medSupShopLink);
			jsClickNew(medSupShopLink);
			System.out.println("Shop Page Medsupp Plan is Displayed");
			return new ShopPage(driver);
		}
		return null;
	}

	public void clickOnMAShopButton() {

		validateNew(MAShopLink);
		jsClickNew(MAShopLink);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(zipCodeField1);
		if (!driver.getCurrentUrl().contains("shop/medicare-advantage-plans")) {
			Assert.fail("MA plans page did not load properly");
		}
		validateNew(ShopHeader);
		System.out.println("Page Heading: " + ShopHeader.getText());
	}

	public void clickOnPDPShopButton() {
		waitForPageLoadSafari();
		// MobileMenuToShopToolToShop();
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(pdpShopLink);
		jsClickNew(pdpShopLink);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(zipCodeField1);
		if (!driver.getCurrentUrl().contains("shop/prescription-drug-plans.html")) {
			Assert.fail("PDP plans page did not load properly");
		}
		validateNew(ShopHeader);
		System.out.println("Page Heading: " + ShopHeader.getText());
	}

	public void clickOnSNPShopButton() {
		// MobileMenuToShopToolToShop();
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(dsnpShopLink);
		jsClickNew(dsnpShopLink);
		waitForPageLoadSafari();
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(zipCodeField1);
		if (!driver.getCurrentUrl().contains("shop/dual-special-needs-plans")) {
			Assert.fail("SNP plans page did not load properly");
		}
		validateNew(ShopHeader);
		System.out.println("Page Heading: " + ShopHeader.getText());
	}

	public void clickOnSeeMoreBenefitsLink() throws Exception {
		CommonUtility.waitForPageLoadNew(driver, seeMoreBenefitsLink, 60);
		validateNew(seeMoreBenefitsLink);
		String parentWindow = driver.getWindowHandle();
		jsClickNew(seeMoreBenefitsLink);
		Thread.sleep(4000);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
				if (!driver.getCurrentUrl().contains("shop/medicare-advantage-plans/ma-plan-benefits.html"))
					Assert.fail("Medicare Advantage Plan Benefits Page loaded");
				Thread.sleep(2000);
			}
		}
	}

	public void validateZipComp(String zipCode) {
		try {
			int zipCodeNumber = 1;
			System.out.println("Total " + zipForm.size() + " Zip code component[s] display on page");

			while (zipCodeNumber <= zipForm.size()) {
//				Thread.sleep(3000);
//				ZipCodeText.get(zipCodeNumber - 1).clear();
//				ZipCodeText.get(zipCodeNumber - 1).sendKeys(zipCode);
//				waitForPageLoadSafari();
//				jsClickNew(ZipcodeButton.get(zipCodeNumber - 1));
//				System.out.println("Clicked on " + zipCodeNumber + " Zip Code Component");
//				System.out.println("Validating VPP page for Zip code " + zipCode);
				scrollToView(zipcodeFieldShopPage);
				sendkeysMobile(zipcodeFieldShopPage, zipCode);
				jsClickNew(GetStartedShopPage);

				Thread.sleep(20000);
				String vppPageTitle = driver.getTitle();
				if (driver.getWindowHandles().size() > 1) {
					String currentPage = driver.getWindowHandle();
					Set<String> newWindow = driver.getWindowHandles();
					for (String tabs : newWindow) {
						if (!tabs.equalsIgnoreCase(currentPage))
							vppPageTitle = driver.switchTo().window(tabs).getTitle();
					}
				}

				System.out.println("Actual : " + vppPageTitle);
				System.out.println("Curent URL *****" + driver.getCurrentUrl());
				if (driver.getCurrentUrl().contains("aarpmedicareplans")) {
					if (vppPageTitle.contains(PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_MEDICARE))
						System.out.println("Page Title : " + PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_MEDICARE);
					else if (vppPageTitle.contains(PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE))
						System.out
								.println("Page Title : " + PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE);
					else
						assertTrue("Not redirected to VPP page",
								vppPageTitle.contains(PageTitleConstants.ULAYER_VPP_PLAN_PAGE_AARP_MEDICARE));
				} else {
					if (vppPageTitle.contains(PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_MEDICARE))
						System.out.println("Page Title : " + PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_MEDICARE);
					else if (vppPageTitle.contains(PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE))
						System.out
								.println("Page Title : " + PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_SHOP_MEDICARE);
					else
						assertTrue("Not redirected to VPP page",
								vppPageTitle.contains(PageTitleConstants.BLAYER_VPP_PLAN_PAGE_AARP_MEDICARE));
				}
				if (driver.getWindowHandles().size() > 1) {
					String currentPage = driver.getWindowHandle();
					Set<String> newWindow = driver.getWindowHandles();
					for (String parentWindow : newWindow) {
						if (!parentWindow.equalsIgnoreCase(currentPage)) {
							driver.switchTo().window(currentPage).close();
							vppPageTitle = driver.switchTo().window(parentWindow).getTitle();
							break;
						}
					}
				} else {
					driver.navigate().back();
				}
				zipCodeNumber++;
				/*
				 * driver.navigate().refresh(); //Adding refresh since element are not located
				 * in Safari browser after using navigate back threadsleep(2000);
				 */
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void findYourPlan() {
		validateNew(findYourPlanHeader);
		List<WebElement> list = driver
				.findElements(By.xpath("//div[contains(@class,'NewCustomRTE')]//span[contains(@class,'heading-3')]"));
		for (int i = 0; i < 5; i++)
			System.out.println(list.get(i).getText());
	}

	public void comparePlans() {
		CommonUtility.checkPageIsReadyNew(driver);
		jsClickNew(comparePlanBtn);
		CommonUtility.checkPageIsReadyNew(driver);
		waitForPageLoadSafari();
		validateNew(zipCodeField1);
		if (!driver.getCurrentUrl().contains("shop/compare.html"))
			Assert.fail("Shop Plan Compare page did not load properly");
	}

	public void estimateCosts() {
		CommonUtility.checkPageIsReadyNew(driver);
		scrollToView(LearnEstimateCosts);
		validateNew(LearnEstimateCosts);
		 jsClickNew(LearnEstimateCosts);
		 CommonUtility.checkPageIsReadyNew(driver);
		waitForPageLoadSafari();
		validateNew(zipCodeField1);
		if (!driver.getCurrentUrl().contains("shop/estimate.html"))
			Assert.fail("Shop Plan Estimate Costs page did not load properly");
	}

	public void switchPlans() {
		CommonUtility.checkPageIsReadyNew(driver);
		scrollToView(howToSwitchPlans);
		validateNew(howToSwitchPlans);
		jsClickNew(howToSwitchPlans);
		CommonUtility.checkPageIsReadyNew(driver);
		waitForPageLoadSafari();
		validateNew(zipCodeField1);
		if (!driver.getCurrentUrl().contains("shop/switch.html"))
			Assert.fail("Switch plans page did not load properly");
	}

	public void safeShopping() {
		CommonUtility.checkPageIsReadyNew(driver);
		scrollToView(learnSafeShopping);
		validateNew(learnSafeShopping);
		jsClickNew(learnSafeShopping);
		CommonUtility.checkPageIsReadyNew(driver);
		waitForPageLoadSafari();
		if (!driver.getCurrentUrl().contains("safe-shopping.html"))
			Assert.fail("Learn Safe Shopping of Plans page did not load properly");
	}

	public void memberResources() {
		CommonUtility.checkPageIsReadyNew(driver);
		scrollToView(getMemberResources);
		validateNew(getMemberResources);
		jsClickNew(getMemberResources);
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.checkPageIsReadyNew(driver);
		waitForPageLoadSafari();
		if (!driver.getCurrentUrl().contains("resources.html"))
			Assert.fail("Get Member Resources page did not load properly");
	}

	public void personalizeUrResults() {
		CommonUtility.checkPageIsReadyNew(driver);
		scrollToView(personalizeUrResults);
		validateNew(personalizeUrResults);
		List<WebElement> list = driver
				.findElements(By.xpath("//div[contains(@class,'NewCustomRTE')]//span[contains(@class,'heading-3')]"));
		for (int i = 5; i < list.size(); i++)
			System.out.println(list.get(i).getText());

	}

	public void navigatetoDCE() {
		CommonUtility.checkPageIsReadyNew(driver);
		scrollToView(checkDrugCostsBtn);
		validateNew(checkDrugCostsBtn);
		jsClickNew(checkDrugCostsBtn);
		CommonUtility.checkPageIsReadyNew(driver);
		waitForPageLoadSafari();
		if (!driver.getCurrentUrl().contains("estimate-drug-costs.html#/drug-cost-estimator"))
			Assert.fail("DCE page did not load properly");
	}

	public void findAProvider() throws Exception {
		CommonUtility.checkPageIsReadyNew(driver);
		validateNew(findAProviderBtn);
		// String parentWindow = driver.getWindowHandle();

		switchToNewTabNew(findAProviderBtn);
		// jsClickNew(findAProviderBtn);
		// findAProviderBtn.click();
		// Thread.sleep(10000);
		// waitForPageLoadSafari();
		// Set<String> tabs_windows = driver.getWindowHandles();
		// Iterator<String> itr = tabs_windows.iterator();
		// while (itr.hasNext()) {
		// String window = itr.next();
		// if (!parentWindow.equals(window)) {
		// driver.switchTo().window(window);
		if (!driver.getCurrentUrl().contains("werally"))
			Assert.fail("Provider Search page failed to load");
		Thread.sleep(2000);

		driver.close();
		driver.switchTo().window(CommonConstants.getMainWindowHandle());

		// driver.close();
	}

	public void locateAPharmacy() {
		CommonUtility.checkPageIsReadyNew(driver);
		scrollToView(locatePharmacyBtn);
		validateNew(locatePharmacyBtn);
		jsClickNew(locatePharmacyBtn);
		waitForPageLoadSafari();
		if (!driver.getTitle().toLowerCase()
				.contains((PageTitleConstants.BLAYER_LOCATE_A_PHARMACY_UNITEDHEALTHCARE).toLowerCase()))
			Assert.fail("Pharmacy locator page did not load properly");
	}

	public void enterEmailAndSubmit(String emailID) {
		if (!emailID.isEmpty()) {
			updatesemail.sendKeys(emailID);
			System.out.println("!!!Entered valid Email!!!");
			jsClickNew(submit);
			Assert.assertTrue(validate(validatesuccessmsg),
					"PROBLEM - unable to get success message after clicking send");
			// Validating email success message
			System.out.println("Email was successfully send to user");
			validateNew(validatesuccessmsg);
			System.out.println("Confirmation message validated! :" + validatesuccessmsg.getText());
		} else {
			System.out.println("!!!Email address is empty!!!");
			navigateToMenuLinks(ShopForaplan, submit);
			// jsClickNew(submit);
			validateNew(errorMessage);
			System.out.println("Error message validated! :" + errorMessage.getText());
		}
	}

	public void sleepBySec(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickonFindanAgentlinkfromShop(String ExpectedUHCAgentURL) {

		CommonUtility.waitForPageLoadNew(driver, FindAnAgent, 30);
		validateNew(FindAnAgent);
		String parentWindow = driver.getWindowHandle();
		// FindAnAgent.click();
		jsClickNew(FindAnAgent);
		sleepBySec(3);
		Set<String> tabs_windows = driver.getWindowHandles();
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			if (!parentWindow.equals(window)) {
				driver.switchTo().window(window);
			}
		}

		/*
		 * CommonUtility.checkPageIsReadyNew(driver); String CurrentUHCAgentURL =
		 * driver.getCurrentUrl();
		 * System.out.println("myuhcagent Page is displayed : "+CurrentUHCAgentURL);
		 * System.out.println("Expected myuhcagent URL: "+ExpectedUHCAgentURL);
		 * 
		 * if(ExpectedUHCAgentURL.equalsIgnoreCase(CurrentUHCAgentURL)) { System.out.
		 * println("****************myuhcagent Page is displayed  ***************");
		 * 
		 * Assertion.assertTrue(true); } else { Assertion.
		 * fail("****************myuhcagent Page is not loaded ***************"); }
		 */
		CommonUtility.checkPageIsReadyNew(driver);
		String CurrentUHCAgentURL = driver.getCurrentUrl();
		String ActualCurrentUHCAgentURL = CurrentUHCAgentURL.substring(0, 27).trim();
		System.out.println("myuhcagent Page is displayed : " + ActualCurrentUHCAgentURL);
		System.out.println("Expected myuhcagent URL: " + ExpectedUHCAgentURL);
		System.out.println("Actual myuhcagent URL: " + ActualCurrentUHCAgentURL);

		if (ExpectedUHCAgentURL.equalsIgnoreCase(ActualCurrentUHCAgentURL)) {
			System.out.println("****************myuhcagent Page is displayed  ***************");

			Assert.assertTrue(true);
		} else {
			Assert.fail("****************myuhcagent Page is not loaded ***************");
		}

		driver.close();
		driver.switchTo().window(parentWindow);

	}
}
