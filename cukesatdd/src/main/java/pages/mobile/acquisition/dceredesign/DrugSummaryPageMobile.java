package pages.mobile.acquisition.dceredesign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.Ordering;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.dceredesign.DrugDetailsPage;

public class DrugSummaryPageMobile extends UhcDriver {

	public DrugSummaryPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@FindBy(xpath = "//h2[contains(text(),'Your estimated')]")
	public WebElement reviewDrugCostPageHeading;

	@FindBy(xpath = "//*[@id='guest-flow-widget-head']/../..")
	public WebElement dceNBAModal;

	@FindBy(xpath = "//*[@id='guest-flow-widget-head' and text()='Save your work for later']")
	public WebElement dceNBAModalMsg;

	@FindBy(xpath = "//button/*[text()='Create Your Profile']")
	public WebElement dceNBAModalBtn;

	@FindBy(id = "SignIn")
	public WebElement signInBtn;

	@FindBy(xpath = "//body/div[@id='site-wrapper']/div[3]/div[1]/div[1]/div[1]/app-root[1]/app-dceplansummary[1]/div[1]/div[3]/div[2]/select[1]")
	public WebElement planTypeToggle;

	@FindBy(xpath = "//span[text()='Pharmacy:']/..")
	public WebElement pharmacyLink;

	@FindBy(xpath = "//*[@class='column column-12']//*[@class='uhc-select uhc-select--block']")
	public WebElement sortDropdown;

	@FindBy(xpath = "//*[@class='uhc-card__header']//h4")
	public WebElement planCardHeader;

	@FindBy(xpath = "//*[text()='Average Monthly Drug Cost']/following-sibling::div")
	public WebElement avgMonthlyDrugCost;

	@FindBy(xpath = "//*[text()='Monthly Premium']/following-sibling::div")
	public WebElement monthlyPremium;

	@FindBy(xpath = "//h5[contains(text(), 'Annual Estimated')]//following-sibling::div")
	public WebElement annualEstimatedTotal;

	@FindBy(xpath = "//*[text()='Drugs Covered']/following-sibling::div")
	public WebElement drugsCovered;

	@FindBy(xpath = "//*[contains(@id,'averageLinkBtn')]")
	public WebElement whyAverageLink;

	@FindBy(xpath = "//*[contains(@id,'includeLinkBtn')]")
	public WebElement whatsIncludedLink;

	@FindBy(xpath = "//*[contains(@id,'priceLinkBtn')]")
	public WebElement drugPricingLink;

	@FindBy(xpath = "//button/span[text()='View Drug Costs']")
	public WebElement viewDrugCostBtn;

	@FindBy(xpath = "//button/span[text()='View Plan Details']")
	public WebElement viewPlanDetailsBtn;

	@FindBy(xpath = "//span[contains(text(),' Save ')]")
	public WebElement saveBtn;

	@FindBy(xpath = "//*[@id='accordion-1-button']")
	public WebElement disclaimer;

	@FindBy(xpath = "//*[@class='heading-4 mb-10 ng-star-inserted']")
	public WebElement planTypeHeading;

	@FindBy(xpath = "//button/span[text()='View Plan Details']")
	public WebElement viewPlanButton;

	@FindBy(id = "changePharmacyLink")
	public WebElement changePharmacy;

	@FindBy(id = "modal-label")
	public WebElement selectPharmacyHeader;

	@FindBy(id = "cancelicon")
	public WebElement selectPharmacyModalCloseBtn;

	@FindBy(xpath = "//*[@class='uhc-card__content']//*[contains(text(),'We are currently')]")
	public WebElement selectedPharmacyLink;

	@FindBy(id = "milesDropdown")
	public WebElement distanceDrpDown;

	@FindBy(id = "pharmacy-zip-filter")
	public WebElement pharmacyZipcodeSearch;

	@FindBy(xpath = "//*[@class='uhc-card__content']//*[contains(text(),'Search')]")
	public WebElement pharmacySearchBtn;

	@FindBy(id = "mailSelectPharmacyBtn0")
	public WebElement preferredMailPharmacy;

	@FindBy(id = "optumRxTxt")
	public WebElement optumRxMsg;

	@FindBy(xpath = "//*[@role='list']")
	public WebElement pharmacyListSection;

	@FindBy(id = "matchingLbl")
	public WebElement matchingPharmacyCount;

	@FindBy(id = "sortDropdown")
	public WebElement sortDrpdown;

	@FindBy(id = "paginationBackBtn")
	public WebElement backBtn;

	@FindBy(id = "paginationNextBtn")
	public WebElement nextBtn;

	@FindBy(id = "changePharmacyLink")
	public WebElement changePharmacyLinkDetailsPage;

	@Override
	public void openAndValidate() {
		// validateNew(reviewDrugCostPageHeading);

	}

	public DrugSummaryPageMobile validateDrugSummaryPage() throws InterruptedException {
		// && validateNew(whyAverageLink)
		// && validateNew(whatsIncludedLink)

		if (validateNew(reviewDrugCostPageHeading) && validateNew(planTypeToggle) && validateNew(pharmacyLink)
				&& validateNew(planCardHeader) && validateNew(avgMonthlyDrugCost) && validateNew(monthlyPremium)
				&& validateNew(annualEstimatedTotal) && validateNew(drugsCovered) && validateNew(whyAverageLink)
				&& validateNew(whatsIncludedLink) && validateNew(drugPricingLink) && validateNew(viewDrugCostBtn)
				&& validateNew(viewPlanDetailsBtn) && validateNew(saveBtn) && validateNew(disclaimer)) {
			return new DrugSummaryPageMobile(driver);
		}

		return null;
	}

	public DrugSummaryPageMobile verifyDefaultPlanType() {
		scrollToView(planTypeHeading);
		validateNew(planTypeHeading);
		if (planTypeHeading.getText().contains("Medicare Advantage Plans")) {
			return new DrugSummaryPageMobile(driver);
		}
		return null;
	}

	public DrugSummaryPageMobile verifyPDPPlanToggle() {

		jsClickNew(pdpPlanToggle);
		if (planTypeHeading.getText().contains("Medicare Prescription Drug Plans")) {
			return new DrugSummaryPageMobile(driver);
		}
		return null;
	}

	public DrugSummaryPageMobile verifySNPPlanToggle() {

		jsClickNew(snpPlanToggle);
		if (planTypeHeading.getText().contains("Medicare Special Needs Plans")) {
			return new DrugSummaryPageMobile(driver);
		}
		return null;
	}

	@FindBy(id = "priceLinkBtn_0")
	private WebElement viewProceBtn;

	@FindBy(xpath = "//a[contains(@id,'switchToGenericLink')]")
	private WebElement switchToGenericBtn;

	@FindBy(xpath = "//button[@type='submit']//span[text()='Switch to Generic']")
	private WebElement switchToGenericSubmitBtn;

	@FindBy(xpath = "//table/tbody/tr/td[1]")
	private WebElement drugNames;

	@FindBy(id = "drugPricingTitleTxt")
	private WebElement drugTitle;

	public void clickViewPricing() {
		// validate(viewProceBtn);
		// viewProceBtn.click();
		validate(drugPricingLink);

		jsClickNew(drugPricingLink);
	}

	public void clickswitchToGeneric() throws InterruptedException {
		Thread.sleep(6000);
		validate(drugTitle);
		validate(switchToGenericBtn);

		jsClickNew(switchToGenericBtn);
		validate(switchToGenericSubmitBtn);

		jsClickNew(switchToGenericSubmitBtn);
	}

	public void verifyDrugListsUpdated(String genericDrug) throws InterruptedException {
		Thread.sleep(6000);
		validate(drugTitle);
		/*
		 * for(int i=0;i<drugNames.size();i++) {
		 * System.out.println(drugNames.get(i).getText()); }
		 */
		System.out.println(drugNames);
		Assert.assertTrue("Drug not switched to generic", drugNames.getText().contains(genericDrug));
	}

	@FindBy(id = "sign-up-modal-header")
	private WebElement createProfilePopup;

	public void savePlan(String planName) {
		try {
			List<String> listOfTestPlans = Arrays.asList(planName.split(","));
			System.out.println(
					"Going to mark the following " + listOfTestPlans.size() + " number of test plans as favorite");
			Thread.sleep(5000);
			for (String plan : listOfTestPlans) {
				// WebElement savePlan =
				// driver.findElement(By.xpath("//*[contains(text(),'"+plan+"')]/following::div[contains(@class,'favorite-plan-container')][1]//img[contains(@src,'unfilled.png')]"));
				WebElement savePlan = driver
						.findElement(By.xpath("//button[contains(@id,'saveBtn') and @aria-label='Save " + plan + "']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", savePlan);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", savePlan);
			}
			/*
			 * if(createProfilePopup.isDisplayed()) { closeProfilePopup.click(); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FindBy(xpath = "//label[contains(@class,'uhc-filter')]/input[@name='plans-filter' and @value='PDP']")
	private WebElement clickPdpplan;

	@FindBy(xpath = "//label[contains(@class,'uhc-filter')]/input[@name='plans-filter' and @value='SNP']")
	private WebElement clickSnpplan;

	@FindBy(xpath = "//div[@class='d-flex align-items-lg-center flex-lg-row']")
	private WebElement alertTextImg;

	public void clickOnPDPPlan() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(clickPdpplan);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click()", clickPdpplan);
		// clickPdpplan.click();

	}

	@FindBy(xpath = "//div[contains(text(),'If you qualify for LIS,')]")
	public WebElement drugPricingDeductText;

	public void verifyTheTextAlert() {

		validate(alertTextImg);
		validate(viewProceBtn);
	}

	public void verifyDrugPricingText() {

		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(drugTitle);
		validate(switchToGenericBtn);
		validate(drugPricingDeductText);

	}

	public void clickOnSNPPlan() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(clickSnpplan);
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click()", clickSnpplan);
	}

	@FindBy(xpath = "//*[contains(text(), 'Change Pharmacy') or @id='changePharmacyLink']")
	public WebElement DrugDetails_ChangePharmacyLnk;

	@FindBy(xpath = "//h2[contains(text(), 'Drug Cost Details')]")
	public WebElement DrugDetails_DrugCostsHeading;

	@FindBy(xpath = "//body/div[@id='site-wrapper']/div[3]/div[1]/div[1]/div[1]/app-root[1]/app-dceplansummary[1]/div[1]/div[3]/div[2]/select[1]")
	public WebElement ToggleDropDown;

	
	public void validateDefaultDistance() {
		Select distance = new Select(distanceDrpDown);
		Assert.assertTrue("Default distance is not 15 miles",
				distance.getFirstSelectedOption().getText().trim().equals("15 Miles"));
	}

	public DrugDetailsPageMobile clickViewDrugDetailsForPlan(String plantype, String planName) {
		if (plantype.equalsIgnoreCase("MAPD")) {
			pageloadcomplete();
			scrollToView(mapdPlanToggle);
			// validateNew(mapdPlanToggle);
			jsClickNew(mapdPlanToggle);
			System.out.println("MAPD Plan Toggle Clicked");
			WebElement DrugCostsLinkforPlan = driver.findElement(
					By.xpath("//button[contains(@aria-label, 'View Drug Costs') and contains(@aria-label, '" + planName
							+ "')]"));
			validateNew(DrugCostsLinkforPlan);
			jsClickNew(DrugCostsLinkforPlan);
			System.out.println("View Drug Costs Clicked for MAPD Plan : " + planName);

		} else if (plantype.equalsIgnoreCase("PDP")) {
			scrollToView(pdpPlanToggle);
			// validateNew(pdpPlanToggle);
			jsClickNew(pdpPlanToggle);
			System.out.println("PDP Plan Toggle Clicked");
			WebElement DrugCostsLinkforPlan = driver.findElement(
					By.xpath("//button[contains(@aria-label, 'View Drug Costs') and contains(@aria-label, '" + planName
							+ "')]"));
			validateNew(DrugCostsLinkforPlan);
			jsClickNew(DrugCostsLinkforPlan);
			System.out.println("View Drug Costs Clicked for PDP Plan : " + planName);

		} else {
			scrollToView(snpPlanToggle);
			// validateNew(snpPlanToggle);
			jsClickNew(snpPlanToggle);
			System.out.println("SNP Plan Toggle Clicked");
			WebElement DrugCostsLinkforPlan = driver.findElement(
					By.xpath("//button[contains(@aria-label, 'View Drug Costs') and contains(@aria-label, '" + planName
							+ "')]"));
			validateNew(DrugCostsLinkforPlan);
			jsClickNew(DrugCostsLinkforPlan);
			System.out.println("View Drug Costs Clicked for SNP Plan : " + planName);
		}
		waitForPageLoadSafari();
		CommonUtility.waitForPageLoadNew(driver, DrugDetails_DrugCostsHeading, 30);
		if (validateNew(changePharmacy) && validateNew(DrugDetails_DrugCostsHeading)) {
			return new DrugDetailsPageMobile(driver);
		} else {
			Assert.fail("Drug Details Page is NOT Displayed");
			return null;
		}
	}

	public void clickChangePharmacy() {
		changePharmacy.click();
	}

	public DrugSummaryPageMobile selectPharmacyModalDisplayed() throws InterruptedException {
		waitforElementNew(selectPharmacyHeader, 30);
		if (validateNew(selectPharmacyHeader)) {
			return new DrugSummaryPageMobile(driver);
		}
		return null;
	}

	public DrugSummaryPageMobile validateSelectPharmacyPage() throws InterruptedException {
		if (validateNew(selectPharmacyModalCloseBtn) && validateNew(selectedPharmacyLink)
				&& validateNew(distanceDrpDown) && validateNew(pharmacyZipcodeSearch) && validateNew(pharmacySearchBtn)
				&& validateNew(preferredMailPharmacy) && validateNew(pharmacyListSection)
				&& validateNew(matchingPharmacyCount) && validateNew(sortDrpdown) && validateNew(backBtn)
				&& validateNew(nextBtn)) {
			return new DrugSummaryPageMobile(driver);
		}

		return null;
	}

	public void clickViewDrugCostBtn() {
		viewDrugCostBtn.click();
	}

	@FindBy(xpath = "//button//span[text()='Back to Profile']")
	public List<WebElement> backToProfileBtn;

	public void clickBackToProfileBtn() {
		try {
			backToProfileBtn.get(1).click();
			System.out.println("Back to profile clicked");
		} catch (Exception e) {
			Assert.fail("Back to profile not displayed ");
		}
	}

	@FindBy(xpath = "//*[text()='Return to Profile']")
	public WebElement returnToProfileLink;

	public void verifyReturnToProfileDisplayed() {

		validateNew(returnToProfileLink, 3);
		scrollToView(returnToProfileLink);
		try {
			if (returnToProfileLink.isDisplayed()) {
				System.out.println("Return to profile displayed");
			}
		} catch (Exception e) {
			Assert.fail("Return to profile not displayed");
		}
	}

	@FindBy(xpath = "//*[@class='plane-name-block']")
	public List<WebElement> planNames;

	public void verifyBackToProfileDisplayed() {
		try {
			if (backToProfileBtn.size() == planNames.size()) {
				System.out.println("Back to profile displayed for each plan card");
			}
		} catch (Exception e) {
			Assert.fail("Back to profile not displayed for each plan card");
		}
	}
	
	public void sortPharmacies(String sortOption) {
		Select sort = new Select(sortDrpdown);
		sort.selectByVisibleText(sortOption);
	}
	
	@FindBy(xpath = "//*[@id='mailSelectPharmacyBtn0']/../../following-sibling::div[1]")
	private WebElement mailOrderPharmacyMsg;
	
	public void validatePreferredMailOrderPharmacyMessage(String expectedMsg) {
		waitforElement(mailOrderPharmacyMsg);
		Assert.assertTrue("Message for Mail order pharmacy not correct" + expectedMsg + "/n" + mailOrderPharmacyMsg,
				mailOrderPharmacyMsg.getText().trim().equals(expectedMsg));
	}


	// @FindBy(xpath =
	// "//label[contains(@class,'uhc-filter')]//span[contains(text(),'Medicare
	// Advantage Plans')]")
	// public WebElement mapdPlanToggle;
	//
	// @FindBy(xpath =
	// "//label[contains(@class,'uhc-filter')]//span[contains(text(),'Medicare
	// Prescription Drug Plans')]")
	// public WebElement pdpPlanToggle;
	//
	// @FindBy(xpath =
	// "//label[contains(@class,'uhc-filter')]//span[contains(text(),'Medicare
	// Special Needs Plans')]")
	// public WebElement snpPlanToggle;

	@FindBy(xpath = "//label[@for='ma-plans-radio']//span[contains(text(),'Medicare Advantage Plans')]")
	public WebElement mapdPlanToggle;

	@FindBy(xpath = "//label[@for='pdp-plans-radio']//span[contains(text(),'Medicare Prescription Drug Plans')]")
	public WebElement pdpPlanToggle;

	@FindBy(xpath = "//label[@for='snp-plans-radio']//span[contains(text(),'Medicare Special Needs Plans')]")
	public WebElement snpPlanToggle;

	public void validatePremiumForPlan(String premium, String plantype, String planName) {
		if (plantype.equalsIgnoreCase("MAPD")) {
			scrollToView(mapdPlanToggle);
			// validateNew(mapdPlanToggle,10);
			jsClickNew(mapdPlanToggle);
			System.out.println("MAPD Plan Toggle Clicked");
		} else if (plantype.equalsIgnoreCase("PDP")) {
			scrollToView(pdpPlanToggle);
			// validateNew(pdpPlanToggle,10);
			jsClickNew(pdpPlanToggle);
			System.out.println("PDP Plan Toggle Clicked");
		} else {
			scrollToView(snpPlanToggle);
			// validateNew(snpPlanToggle,10);
			jsClickNew(snpPlanToggle);
			System.out.println("SNP Plan Toggle Clicked");
		}
		WebElement PremiumforPlan = driver.findElement(By.xpath("//*[contains(text(), '" + planName
				+ "')]//ancestor::*[contains(@class, 'uhc-card__header')]//following-sibling::*//*[contains(text(), 'Monthly Premium')]//following-sibling::*[contains(text(), '$')]"));
		validateNew(PremiumforPlan);
		String PremiumDisplayed = PremiumforPlan.getText();
		System.out.println("Premium Displayed for Plan : " + PremiumDisplayed);
		if (!PremiumDisplayed.contains(premium)) {
			Assert.fail("Expected Premium not displayed, Expected : " + premium + "    Actual Displayed : "
					+ PremiumDisplayed);
		}
	}

	public void validateDCENBAModal() {

		scrollToView(dceNBAModal);
		if (validateNew(dceNBAModal)) {
			validateNew(dceNBAModalMsg);
			validateNew(dceNBAModalBtn);

			jsClickNew(dceNBAModalBtn);
			waitforElement(signInBtn);
			Assert.assertTrue("user not navigated to login page",
					driver.getCurrentUrl().contains("app/index.html#/login"));
		}
	}

	public void verifyReviewDrugCostPageDisplayed() {
		CommonUtility.waitForPageLoad(driver, reviewDrugCostPageHeading, 30);
		if (validateNew(reviewDrugCostPageHeading)) {
			Assert.assertTrue("Review drug cost page not displayed", true);
		} else {
			Assert.assertTrue("Review drug cost page not displayed", false);
		}

	}
	public void selectPreferredMailOrderPharmacy() {
		waitforElement(preferredMailPharmacy);
	//	preferredMailPharmacy.click();
		jsClickMobile(preferredMailPharmacy);
	}
	@FindBy(xpath = "//*[contains(@id,'selectPharmacyBtn')]/../div//span[1]")
	private List<WebElement> pharmacyNameList;
	
	public void validatePharmaciesAscendingOrder() {
		List<String> pharmacListAfterSort = new ArrayList<String>();
		for (WebElement e : pharmacyNameList) {
			pharmacListAfterSort.add(e.getText());
		}
		System.out.println("After sort" + pharmacListAfterSort);
		Boolean sorted = Ordering.natural().isOrdered(pharmacListAfterSort);
		Assert.assertTrue("Pharmacies are not sorted in ascending order", sorted);
	}
	
	public void validatePharmaciesDescendingOrder() {
		List<String> pharmacListAfterSort = new ArrayList<String>();
		for (WebElement e : pharmacyNameList) {
			pharmacListAfterSort.add(e.getText());
		}
		System.out.println("After sort" + pharmacListAfterSort);
		Boolean sorted = Ordering.natural().reverse().isOrdered(pharmacListAfterSort);
		Assert.assertTrue("Pharmacies are not sorted in ascending order", sorted);
	}
	
	public void clickNextButton() {
		jsClickMobile(nextBtn);
	}
	@FindBy(xpath = "//*[@class='pagination']/../p")
	private WebElement pageNumber;

	public void validateSecondPageDisplayed() {
		String page = pageNumber.getText();
		Pattern p = Pattern.compile("Page (\\d*) of (\\d*)");
		java.util.regex.Matcher m = p.matcher(page);
		if (m.find()) {
			page = m.group(1);
		}
		Assert.assertTrue("Second page not displayed", page.equals("2"));
	}
	public void clickBackButton() {
		jsClickMobile(backBtn);
	}

	public void validateFirstPageDisplayed() {
		String page = pageNumber.getText();
		Pattern p = Pattern.compile("Page (\\d*) of (\\d*)");
		java.util.regex.Matcher m = p.matcher(page);
		if (m.find()) {
			page = m.group(1);
		}
		Assert.assertTrue("First page not displayed", page.equals("1"));
	}
	
	public void searchPharmaciesByZipcode(String zipcode) {
		pharmacyZipcodeSearch.clear();
		pharmacyZipcodeSearch.sendKeys(zipcode);
		jsClickMobile(pharmacySearchBtn);
	}


	@FindBy(xpath = "//*[@id='selectaPharmacy-overlay']//*[@class='field-error-msgfordceui']")
	private WebElement noResultsMessage;

	public void validateNoResultsMsg(String expectedMsg) {
		waitforElement(noResultsMessage);
		System.out.println(noResultsMessage.getText());
		System.out.println(expectedMsg);
		Assert.assertTrue("No results message not displayed", noResultsMessage.getText().equals(expectedMsg));
	}
	@FindBy(id = "inValidZipcodeLbl")
	private WebElement invalidZipCodeMsg;


	public void validateInvalidZipCodeMsg(String expectedMsg) {
		waitforElement(invalidZipCodeMsg);
		System.out.println(invalidZipCodeMsg.getText().trim());
		Assert.assertTrue("Invalid zipcode message not displayed", invalidZipCodeMsg.getText().trim().equals(expectedMsg));
	}
}
