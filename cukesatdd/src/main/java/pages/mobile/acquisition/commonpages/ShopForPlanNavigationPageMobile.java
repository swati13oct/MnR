package pages.mobile.acquisition.commonpages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.Assertion;

public class ShopForPlanNavigationPageMobile extends GlobalWebElements {

	@FindBy(xpath = "//*[@id='ghn_lnk_2']")
	private WebElement ShopForaplan;

	@FindBy(xpath = ".//*[@id='updates-mobile-form']/div/div[2]/button")
	private WebElement submit;

	@FindBy(id = "updates-email")
	private WebElement updatesemail;

	@FindBy(xpath = "//*[@id='subnav_2']/div[2]/div/p")
	private WebElement successMessage;

	@FindBy(xpath = "//a[text()='Plan Selector']")
	private WebElement PlanSelector;

	@FindBy(xpath = "//div[contains(@id,'aside-second')]//h1")
	private WebElement heading;

	@FindBy(xpath = "//div[@id='widget_POmb5hgvb0afo9HIaTIbiQ']/div/a")
	private WebElement GetStarted;

	@FindBy(xpath = "//input[contains(@title,'ZIP Code')]")
	private WebElement ZIPcode;

	@FindBy(xpath = "//a[@class='cta-button secondary']")
	private WebElement canceldrugsearch;

	@FindBy(xpath = "//input[@id='zipcodeTxt']")
	private WebElement zipcodetxt;

	@FindBy(xpath = "//select[@id='plan-type']")
	private WebElement chooseaplan;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement pcontinue;

	@FindBy(xpath = "//*[contains(@id,'shop-scroll')]//a[text()='Enroll']")
	private WebElement enrollLink;
	
	@FindBy(xpath = "//*[contains(@id,'shop-scroll')]//a[text()='Member Resources']")
	private WebElement memberResourcesLink;
	
	@FindBy (css = "nav-zipcode")
	private WebElement zipCodeField;

	@FindBy(xpath = "//*[contains(@id,'shop-scroll')]//a[contains(text(),'Shop')]")
	private WebElement shopLink;

	@FindBy(xpath = "//*[contains(@id,'shop-scroll')]//*[contains(text(),'Shop')]/../following-sibling::p[1]")
	private WebElement shopLinkMsg;
	
	@FindBy(css = "#subnav_2 div[class*='section-1']")
	private WebElement shopForPlanContainer;
	
	@FindBy(css = "#subnav_2 .nav-back")
	private WebElement shopPlanBack;
	
	@FindBy(xpath = "//p[contains(@class,'dropdown-btn')][normalize-space()='Plan Types']")
	private WebElement planTypesTab;
	
	@FindBy(css = "div[class*='mob-sctn section-2'] > div[class*='container']")
	private WebElement planTypesContainer;
	
	@FindBy(css = "div[class*='mob-sctn section-2'] span[class='nav-srch-back']")
	private WebElement planTypeBack;
	
	@FindBy(xpath = "//p[contains(@class,'dropdown-btn')][normalize-space()='Tools to help you choose a plan']")
	public WebElement toolsToChoosePlanTab;
	
	@FindBy(css = "div[class*='mob-sctn section-3'] > div[class*='container']")
	private WebElement toolsContainer;
	
	@FindBy(css = "div[class*='mob-sctn section-3'] span[class='nav-srch-back']")
	private WebElement toolsToChooseBack;

	@FindBy(xpath = "//a[contains(@href,'ma-enrollment')]")
	private WebElement maLeanHowToEnrollLink;

	@FindBy(xpath = "(//a[contains(@href,'/shop/dual-special-needs-plans.html')])[2]")
	private WebElement dsnpLeanHowToshopLink;

	@FindBy(xpath = "(//a[contains(@href,'/shop/prescription-drug-plans.html')])[2]")
	private WebElement pdpLeanHowToshopLink;
	
	@FindBy(xpath = "(//a[contains(@href,'/shop/medicare-advantage-plans')])[2]")
	private WebElement maLeanHowToshopLink;

	@FindBy(xpath = "(//a[contains(@href,'/shop/medicare-supplement-plans.html')])[3]")
	private WebElement msLeanHowToshopLink;
	
	@FindBy(xpath = "//a[@href='/shop/medicare-supplement-plans-classic.html']")
	private WebElement MedSuppClassicUrl;
	
	@FindBy(css = "a[dtmname='NavLinks:Shop for a Plan:Plan Types:Get a Plan Recommendation']")
	private WebElement getPlanRecommendation;
	
	@FindBy(css = "a[dtmname='NavLinks:Shop for a Plan:Plan Types:Drug Cost Estimator']")
	private WebElement drugCostEstimator;
	
	@FindBy(css = "a[dtmname='NavLinks:Shop for a Plan:Plan Types:Pharmacy Search']")
	private WebElement pharmacySearch;
	
	@FindBy(css = "a[dtmname='NavLinks:Shop for a Plan:Plan Types:Provider Search']")
	private WebElement providerSearch;

	@FindBy(xpath = "//div[@id='accordion2']//h3[text()='Enrollment']")
	private WebElement EnrollmentLink;

	@FindBy(xpath = "(//a[contains(@href,'/medicare-education/medicare-supplement-plans.html')])[1]")
	private WebElement MedicareSupplementLink;

	@FindBy(xpath = "//a[contains(text(),'Member Resources')]")
	private WebElement ResourcesLink;
	
	@FindBy(css = "#nav-zipcode")
	private WebElement zipcodeField;
	
	@FindBy(xpath = "//*[contains(text(),'Find Plans')]/parent::button")
	private WebElement findPlansButton;

	public ShopForPlanNavigationPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, ShopForaplan, 60);
		validateNew(ShopForaplan);
	}

	public EnrollmentBasicsPageMobile enrollLinkOnShopPlan() throws Exception {
		
		selectShopOption("Enroll");
		/*waitforElement(enrollLink);
		scrollToView(enrollLink);
		jsClickNew(enrollLink);*/
		Thread.sleep(4000);
		if (validate(maLeanHowToEnrollLink)) {
//			waitforElement(maLeanHowToEnrollLink);
			System.out.println("OLE Learn More Modal is Displayed");
			return new EnrollmentBasicsPageMobile(driver);
		}
		return null;
	}

	public ShopPage ShopLinkOnShopPlan() throws Exception {
		selectShopOption("Shop");
		/*scrollToView(shopLink);
		waitforElement(shopLink);
		jsClickNew(shopLink);*/
		Thread.sleep(4000);
		return new ShopPage(driver);

	}

	public void CheckShopLinkOnShopPlan() {
		waitforElement(shopLink);
		waitforElement(shopLinkMsg);
		String expMsg = "Get help making the right decision when shopping for coverage.";
		String actualMsg = shopLinkMsg.getText();
		// System.out.println("Message: "+actualMsg);
		if (expMsg.equalsIgnoreCase(actualMsg))
			System.out.println("Validated the content under the Shop link: " + actualMsg);
		else
			System.out.println("content under the Shop link does not match");
	}

	public void clickONshopLink(String plantype, String planName) throws Exception {
		if (plantype.equals("SNP")) {
			scrollToView(dsnpLeanHowToshopLink);
			waitforElement(dsnpLeanHowToshopLink);
			jsClickNew(dsnpLeanHowToshopLink);
			Thread.sleep(5000);

		} else if (plantype.equals("PDP")) {
			scrollToView(pdpLeanHowToshopLink);
			waitforElement(pdpLeanHowToshopLink);
			jsClickNew(pdpLeanHowToshopLink);
			Thread.sleep(5000);
		}

		else if (plantype.equals("MAPD") || plantype.equals("MA")) {
			scrollToView(maLeanHowToshopLink);
			waitforElement(maLeanHowToshopLink);
			jsClickNew(maLeanHowToshopLink);
			Thread.sleep(5000);
		}
	}

	public ShopPage ShopLinkOnMedsuppPlan() throws Exception {
		scrollToView(shopLink);
		waitforElement(shopLink);
		jsClickNew(shopLink);
		Thread.sleep(4000);
		if (validate(msLeanHowToshopLink)) {
			scrollToView(msLeanHowToshopLink);
			waitforElement(msLeanHowToshopLink);
			jsClickNew(msLeanHowToshopLink);
			threadsleep(2000);
			System.out.println("Shop Page Medsupp Plan is Displayed");
			// return new ShopPage(driver);
		}
		// return null;
		return null;
	}

	public void providersearch() {
		MobileMenuProviderSearch();
		driver.switchTo().activeElement().getText().contains("location");
	}

	public ShopPage medicareductaionOnMedsuppPlan() throws Exception {
		scrollToView(MedicareSupplementLink);
		waitforElement(MedicareSupplementLink);
		jsClickNew(MedicareSupplementLink);
		Thread.sleep(4000);
		/*
		 * if (validate(msLeanHowToshopLink)) { waitforElement(msLeanHowToshopLink);
		 * jsClickNew(msLeanHowToshopLink); threadsleep(2000);
		 * System.out.println("Shop Page Medsupp Plan is Displayed"); //return new
		 * ShopPage(driver); }
		 */
		// return null;
		return null;
	}

	@FindBy(xpath = "//input[@id='updates-email']")
	private WebElement requestshoppageemailaddress;
	
	@FindBy(xpath = "(//button[contains(text(),'Submit')])[2]")
	private WebElement requestplaninformationShopsubmit;
	
	@FindBy(xpath = "(//p[contains(text(),'Your guide will arrive in your inbox')])[2]")
	private WebElement requestplaninformationshopsubmitpopup;
	
	@FindBy(xpath = "(//*[contains(text(),'Please enter a valid email address')])[2]")
	private WebElement RequestPlanInformationShoppages_ErrorMessage;

	public boolean RequestPlanIInformationshoppages(String EmailAddress) throws InterruptedException {

		boolean RequestPlanIInformation_Validation = true;

		boolean flag = true;

		sendkeysMobile(requestshoppageemailaddress, "(*^*_asb@t.c");
		jsClickNew(requestplaninformationShopsubmit);
		if (validate(RequestPlanInformationShoppages_ErrorMessage)
				&& RequestPlanInformationShoppages_ErrorMessage.isDisplayed()) {
			if (!RequestPlanInformationShoppages_ErrorMessage.getText()
					.contains("Please enter a valid email address")) {
				System.out.println("Email Invalid Error is Not  displayed : "
						+ RequestPlanInformationShoppages_ErrorMessage.getText());
				flag = false;
			}
			System.out.println("Email Invalid Error : " + RequestPlanInformationShoppages_ErrorMessage.getText());

		} else {
			System.out.println("Email Invalid Error field is not displayed");

		}
		validateNew(requestshoppageemailaddress);
		sendkeysMobile(requestshoppageemailaddress, EmailAddress);
		System.out.println("Email Address is enetered : " + EmailAddress);
		
		scrollToView(requestplaninformationShopsubmit);
		validateNew(requestplaninformationShopsubmit);
		jsClickNew(requestplaninformationShopsubmit);
		if (requestplaninformationshopsubmitpopup.getText().contains("Your guide will arrive in your inbox shortly")) {
			System.out.println("****************Request  information is displayed  ***************");

			Assertion.assertTrue(true);
		} else {
			System.out.println("****************Request information is displayed  ***************");
		}
		return RequestPlanIInformation_Validation;

	}

	public ResourcesPage clickMemberResourceLink() {
		scrollToView(ResourcesLink);
		waitforElement(ResourcesLink);
		jsClickNew(ResourcesLink);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("/resources.html")) {
			return new ResourcesPage(driver);
		} else {
			return null;
		}
	}
	
	
	public void selectShopOption(String shopOption) {
		switch (shopOption.toLowerCase()) {
		case "shop":
			jsClickNew(shopLink);
			break;
		case "enroll":
			jsClickNew(enrollLink);
			break;
		case "member resources":
			jsClickNew(memberResourcesLink);
			break;
		default:
			throw new IllegalArgumentException(
					"Option " + shopOption + " is not available under 'Shop for a Plan' menu");
		}
		CommonUtility.checkPageIsReadyNew(driver);
	}

	public void selectPlanTypeOption(String planType, boolean classicUrl) {
		
		if(!planTypesContainer.isDisplayed()) {
			jsClickNew(planTypesTab);
		}
		switch (planType.toLowerCase()) {
		case "ma":
		case "mapd":
			jsClickNew(maLeanHowToshopLink);
		case "dsnp":
		case "snp":
			jsClickNew(dsnpLeanHowToshopLink);
			break;
		case "medsupp":
		case "ms":
			if (classicUrl)
				jsClickNew(MedSuppClassicUrl);
			else
				jsClickNew(msLeanHowToshopLink);
			
			break;
		case "pdp":
			jsClickNew(pdpLeanHowToshopLink);
			break;
		default:
			throw new IllegalArgumentException("Plan type " + planType + " is not available under 'Plan Types' menu");
		}
		CommonUtility.checkPageIsReadyNew(driver);
	}

	public void selectTool(String tool) {
		if(!toolsContainer.isDisplayed()) {
			jsClickNew(toolsToChoosePlanTab);
		}
		switch (tool.toLowerCase()) {
		case "pre":
			jsClickNew(getPlanRecommendation);
			break;
		case "dce":
			jsClickNew(drugCostEstimator);
			break;
		case "pharmacy search":
			jsClickNew(pharmacySearch);
			break;
		case "provider search":
			jsClickNew(providerSearch);
			break;
		default:
			throw new IllegalArgumentException(
					"Tool " + tool + " is not available under 'Tools to help you choose a plan' menu");
		}
		CommonUtility.checkPageIsReadyNew(driver);
	}
	
	public boolean validateShopForPlanMenu() {
		boolean validateMenuOptions = false;
		
		try {
			scrollToView(shopLink);
			validateMenuOptions = shopLink.isDisplayed();
			
			scrollToView(enrollLink);
			validateMenuOptions = validateMenuOptions && enrollLink.isDisplayed();
			
			scrollToView(memberResourcesLink);
			validateMenuOptions = validateMenuOptions && memberResourcesLink.isDisplayed();
			
		} catch (Exception e) {
			Assertion.fail("Failed to validate the menu option for Shop for a plan menu");
		}
		return validateMenuOptions;
		
	}
	
	public boolean validatePlanTypeMenu() {
		boolean validatePlanTypeOptions = false;

		if(!planTypesContainer.isDisplayed()) {
			jsClickNew(planTypesTab);
		}
		try {
			validatePlanTypeOptions = maLeanHowToshopLink.isDisplayed();
			validatePlanTypeOptions = validatePlanTypeOptions &&  dsnpLeanHowToshopLink.isDisplayed();
			
			validatePlanTypeOptions = validatePlanTypeOptions && (msLeanHowToshopLink.isDisplayed() || MedSuppClassicUrl.isDisplayed());
			
			validatePlanTypeOptions = validatePlanTypeOptions && pdpLeanHowToshopLink.isDisplayed();
			
		} catch (Exception e) {
			Assertion.fail("Failed to validate the Plan Types menu");
		}
		
		jsClickNew(planTypeBack);
		return validatePlanTypeOptions;
		
	}
	
	
	public boolean validateToolsMenu() {
		boolean validateToolsOptions = false;

		if(!toolsContainer.isDisplayed()) {
			jsClickNew(toolsToChoosePlanTab);
		}
		try {
			validateToolsOptions = getPlanRecommendation.isDisplayed();
			validateToolsOptions = validateToolsOptions &&  drugCostEstimator.isDisplayed();
			
			validateToolsOptions = validateToolsOptions && pharmacySearch.isDisplayed();
			
			validateToolsOptions = validateToolsOptions && providerSearch.isDisplayed();
			
		} catch (Exception e) {
			Assertion.fail("Failed to validate the Tools menu");
		}
		jsClickNew(toolsToChooseBack);
		return validateToolsOptions;
		
	}
	
	
	public void searchPlanForZipcodeFromShopMenu(String zipcode) {
		sendkeysMobile(zipcodeField, zipcode);
		jsClickNew(findPlansButton);
	}
	
	
	public boolean checkForClassicURL(String state) {
		//This list can be a constant rather than updating in each page class 
		List<String> classicUrlStates = Arrays.asList("Oregon");
		return classicUrlStates.contains(state);
	}
}
