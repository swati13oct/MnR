package pages.acquisition.dceredesign;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class DrugSummaryPage extends UhcDriver {

	public DrugSummaryPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@FindBy(xpath = "//h2[contains(text(),'Your estimated')]")
	public WebElement reviewDrugCostPageHeading;

	@FindBy(xpath = "//*[@class='uhc-filter-group']")
	public WebElement planTypeToggle;
	
	@FindBy(xpath = "//*[text()='Pharmacy:']/..")
	public WebElement pharmacyLink;
	
	@FindBy(xpath = "//*[@class='column column-12']//*[@class='uhc-select uhc-select--block']")
	public WebElement sortDropdown;
	
	@FindBy(xpath = "//*[@class='uhc-card__header']//h4")
	public WebElement planCardHeader;
	
	@FindBy(xpath = "//*[text()='Average Monthly Drug Cost']/following-sibling::div")
	public WebElement avgMonthlyDrugCost;
	
	@FindBy(xpath = "//*[text()='Monthly Premium']/following-sibling::div")
	public WebElement monthlyPremium;
	
	@FindBy(xpath = "//div[contains(text(), 'Annual Estimated')]//following-sibling::div")
	public WebElement annualEstimatedTotal;
	
	@FindBy(xpath = "//*[text()='Drugs Covered']/following-sibling::div")
	public WebElement drugsCovered;
	
	@FindBy(xpath = "//*[contains(@id,'averageLinkBtn')]/following-sibling::button")
	public WebElement whyAverageLink;
	
	@FindBy(xpath = "//*[contains(@id,'includeLinkBtn')]/following-sibling::button")
	public WebElement whatsIncludedLink;
	
	@FindBy(xpath = "//*[contains(@id,'priceLinkBtn')]")
	public WebElement drugPricingLink;
	
	@FindBy(xpath = "//button/span[text()='View Drug Costs']")
	public WebElement viewDrugCostBtn;
	
	@FindBy(xpath = "//button/span[text()='View Plan Details']")
	public WebElement viewPlanDetailsBtn;
	
	@FindBy(xpath = "//button//span[text()='Save']")
	public WebElement saveBtn;
	
	@FindBy(xpath = "//*[@id='accordion-1-button']")
	public WebElement disclaimer;
	
	@FindBy(xpath = "//*[@class='heading-4 mb-10 ng-star-inserted']")
	public WebElement planTypeHeading;
	
	@FindBy(xpath = "//button/span[text()='View Plan Details']")
	public WebElement viewPlanButton;

	@FindBy(xpath = "//label[contains(@class,'uhc-filter')]//span[contains(text(),'Medicare Advantage Plans')]")
	public WebElement mapdPlanToggle;

	@FindBy(xpath = "//label[contains(@class,'uhc-filter')]//span[contains(text(),'Medicare Prescription Drug Plans')]")
	public WebElement pdpPlanToggle;
	
	@FindBy(xpath = "//label[contains(@class,'uhc-filter')]//span[contains(text(),'Medicare Special Needs Plans')]")
	public WebElement snpPlanToggle;
	
	@FindBy(id = "changePharmacyLink")
	public WebElement changePharmacy;
	
	@FindBy(id = "selectaPharmacyHeader")
	public WebElement selectPharmacyHeader;
	
	@FindBy(id = "selectPharmcyModalCloseLink")
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
	
	@FindBy(xpath = "//*[text()='Return to Profile']")
	public WebElement returnToProfileLink;
	
	@FindBy(xpath = "//button//span[text()='Back to Profile']")
	public List<WebElement> backToProfileBtn;
	
	@FindBy(xpath = "//*[@class='plane-name-block']")
	public List<WebElement> planNames;

	@Override
	public void openAndValidate() {
		validateNew(reviewDrugCostPageHeading);
		
	}
	
	public DrugSummaryPage validateDrugSummaryPage(){
		if(validateNew(reviewDrugCostPageHeading) && validateNew(planTypeToggle) &&	validateNew(pharmacyLink) &&
		validateNew(planCardHeader)&&
		validateNew(avgMonthlyDrugCost) &&
		validateNew(monthlyPremium)&&
		validateNew(annualEstimatedTotal) &&
		validateNew(drugsCovered)&&
		validateNew(whyAverageLink)&&
		validateNew(whatsIncludedLink)&&
		validateNew(drugPricingLink)&&
		validateNew(viewDrugCostBtn)&&
		validateNew(viewPlanDetailsBtn)&&
		validateNew(saveBtn)&&
		validateNew(disclaimer)) {
		return new DrugSummaryPage(driver);
		}
		
		return null;
	}
	
	@FindBy(xpath = "//button[@ng-click='backToDceDrugDetailsOrSummary()']")
	public WebElement backtoDrugEstBtn;
	
	@FindBy(xpath = "//button[@ng-click='backToPlanSummary()']")
	public WebElement backtoSummaryBtn;
	
	public void validateDrugandPanButton() {
		validateNew(backtoDrugEstBtn);
		validateNew(backtoSummaryBtn);
	}
	
	public void clickOnBacktoDrugBtn() {
		validateNew(backtoDrugEstBtn);
		backtoDrugEstBtn.click();
	}
	
	public void validatePlanDrugDetails(String planName) {
		WebElement PlanName_PlanDetails = driver.findElement(By.xpath("//h1[contains(text(), '"+planName+"')]"));
		CommonUtility.waitForPageLoadNew(driver, PlanName_PlanDetails, 20);
		validateNew(PlanName_PlanDetails);
	}
	
	public DrugSummaryPage verifyDefaultPlanType(){
		validateNew(planTypeHeading);
		if(planTypeHeading.getText().contains("Medicare Advantage Plans")) {
			return new DrugSummaryPage(driver);
		}
		return null;
	}
	
	public void clickOnViewPlan(){
		validateNew(viewPlanButton);
		viewPlanButton.click();
	}
	
   @FindBy(xpath = "//*[@class='back-to-view-all-pla']")
	public WebElement returnToHomeBtn;
	
	public void clickOnReturnToHome(){
		validateNew(returnToHomeBtn);
		returnToHomeBtn.click();
	}

	public DrugSummaryPage verifyPDPPlanToggle(){
		pdpPlanToggle.click();
		if(planTypeHeading.getText().contains("Medicare Prescription Drug Plans")) {
			return new DrugSummaryPage(driver);
		}
		return null;
	}
	
	public DrugSummaryPage verifySNPPlanToggle(){
		snpPlanToggle.click();
		if(planTypeHeading.getText().contains("Medicare Special Needs Plans")) {
			return new DrugSummaryPage(driver);
		}
		return null;
	}
	
	@FindBy(id = "priceLinkBtn_0")
	private WebElement viewProceBtn;
	
	@FindBy(xpath = "//a[contains(@id,'switchToGenericLink')]")
	private WebElement switchToGenericBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Lipitor')]/following::a[contains(@id,'switchToGenericLink')]")
	private WebElement lipitorSwitchToGenericBtn;
	
	@FindBy(xpath = "//button[@type='submit']//span[text()='Switch to Generic']")
	private WebElement switchToGenericSubmitBtn;
	
	@FindBy(xpath = "//table/tbody/tr/td[1]")
	private WebElement drugNames;
	
	@FindBy(id = "drugPricingClose")
	private WebElement drugClose;
	
	@FindBy(xpath = "//label/span[contains(text(),'Medicare Prescription Drug Plans')]")
	private WebElement pdpPlan;
	
	@FindBy(id = "drugPricingTitleTxt")
	private WebElement drugTitle;
	
	
	public void clickViewPricing() {
		//validate(viewProceBtn);
		//viewProceBtn.click();
		validate(drugPricingLink);
		drugPricingLink.click();
	}
	
	public void clickswitchToGeneric() throws InterruptedException {
		Thread.sleep(6000);
		validate(drugTitle);
		validate(switchToGenericBtn);
		switchToGenericBtn.click();
		validate(switchToGenericSubmitBtn);
		switchToGenericSubmitBtn.click();
	}
	
	public void clicklipitorswitchToGeneric() throws InterruptedException {
		Thread.sleep(6000);
		validate(drugTitle);
		validate(lipitorSwitchToGenericBtn);
		lipitorSwitchToGenericBtn.click();
		validate(switchToGenericSubmitBtn);
		switchToGenericSubmitBtn.click();
	}
	
	public void clickOnPdpPlan() throws InterruptedException {
		Thread.sleep(6000);
		validate(pdpPlan);
		pdpPlan.click();
		validate(viewProceBtn);
		viewProceBtn.click();
	}
	
	public void verifyDrugListsUpdated(String genericDrug) throws InterruptedException {
		Thread.sleep(6000);
		validate(drugTitle);
		/*
		 * for(int i=0;i<drugNames.size();i++) {
		 * System.out.println(drugNames.get(i).getText()); }
		 */
		validate(drugNames);
		System.out.println(drugNames.getText()+"   "+genericDrug);
		Assert.assertTrue("Drug not switched to generic",drugNames.getText().contains(genericDrug));
		validate(drugClose);
		drugClose.click();
	}
	
	@FindBy(id = "sign-up-modal-header")
	private WebElement createProfilePopup;
	
	public void savePlan(String planName)
	{		
		try {
			List<String> listOfTestPlans = Arrays.asList(planName.split(","));
			System.out.println("Going to mark the following "+listOfTestPlans.size()+" number of test plans as favorite");
			Thread.sleep(5000);
			for (String plan: listOfTestPlans) {
				//WebElement savePlan = driver.findElement(By.xpath("//*[contains(text(),'"+plan+"')]/following::div[contains(@class,'favorite-plan-container')][1]//img[contains(@src,'unfilled.png')]"));
				WebElement savePlan = driver.findElement(By.xpath("//button[contains(@id,'saveBtn') and @aria-label='Save "+plan+"']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", savePlan);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", savePlan);
			}
			/*if(createProfilePopup.isDisplayed()) {
				closeProfilePopup.click();
			}*/
				
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
	
	
	public void clickOnPDPPlan()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(clickPdpplan);
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].click()", clickPdpplan);
		//clickPdpplan.click();
		
		
	}
	
	@FindBy(xpath = "//div[contains(text(),'If you qualify for LIS,')]")
	public WebElement drugPricingDeductText;
	
	
	public void verifyTheTextAlert()
	{
		
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
	
	public void clickOnSNPPlan()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(clickSnpplan);
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].click()", clickSnpplan);
	}

	@FindBy(xpath = "//button[@id='changePharmacyLink']")
	public WebElement DrugDetails_ChangePharmacyLnk;

	@FindBy(xpath = "//h2[contains(text(), 'Drug Cost Details')]")
	public WebElement DrugDetails_DrugCostsHeading;

	public DrugDetailsPage clickViewDrugDetailsForPlan(String plantype, String planName) {
		if (plantype.equalsIgnoreCase("MAPD")) {
			validateNew(mapdPlanToggle);
			jsClickNew(mapdPlanToggle);
			System.out.println("MAPD Plan Toggle Clicked");
			WebElement DrugDetailsLinkforPlan = driver.findElement(By.xpath("//button[contains(@aria-label, 'View Drug Costs') and contains(@aria-label, '"+planName+"')]"));
			validateNew(DrugDetailsLinkforPlan);
			jsClickNew(DrugDetailsLinkforPlan);
			System.out.println("View Drug Details Clicked for MAPD Plan : "+planName);

		}
		else if(plantype.equalsIgnoreCase("PDP")){
			validateNew(pdpPlanToggle);
			jsClickNew(pdpPlanToggle);
			System.out.println("PDP Plan Toggle Clicked");
			WebElement DrugDetailsLinkforPlan = driver.findElement(By.xpath("//button[contains(@aria-label, 'View Drug Costs') and contains(@aria-label, '"+planName+"')]"));
			validateNew(DrugDetailsLinkforPlan);
			jsClickNew(DrugDetailsLinkforPlan);
			System.out.println("View Drug Details Clicked for PDP Plan : "+planName);

		}
		else{
			validateNew(snpPlanToggle);
			jsClickNew(snpPlanToggle);
			System.out.println("SNP Plan Toggle Clicked");
			WebElement DrugDetailsLinkforPlan = driver.findElement(By.xpath("//button[contains(@aria-label, 'View Drug Costs') and contains(@aria-label, '"+planName+"')]"));
			validateNew(DrugDetailsLinkforPlan);
			jsClickNew(DrugDetailsLinkforPlan);
			System.out.println("View Drug Details Clicked for SNP Plan : "+planName);

		}
		CommonUtility.waitForPageLoadNew(driver, DrugDetails_DrugCostsHeading, 30);
		if(validateNew(changePharmacy) && validateNew(DrugDetails_DrugCostsHeading))
		{
			return new DrugDetailsPage(driver);
		}
		else {
			Assert.fail("Drug Details Page is NOT Displayed");
			return null;
		}		
	}
	
	public void clickChangePharmacy() {
		changePharmacy.click();
	}
	
	public DrugSummaryPage selectPharmacyModalDisplayed() throws InterruptedException {
		waitforElementNew(selectPharmacyHeader, 30);
		if(validateNew(selectPharmacyHeader)) {
			return new DrugSummaryPage(driver);
		}
		return null;
	}
	
	public DrugSummaryPage validateSelectPharmacyPage() throws InterruptedException {
		if(validateNew(selectPharmacyModalCloseBtn) && validateNew(selectedPharmacyLink) &&	validateNew(distanceDrpDown) &&
		validateNew(pharmacyZipcodeSearch)&&
		validateNew(pharmacySearchBtn) &&
		validateNew(preferredMailPharmacy)&&
		validateNew(pharmacyListSection)&&
		validateNew(matchingPharmacyCount)&&
		validateNew(sortDrpdown)&&
		validateNew(backBtn)&&
		validateNew(nextBtn)) {
		return new DrugSummaryPage(driver);
		}
		
		return null;
	}
	
	public void clickViewDrugCostBtn() {
		viewDrugCostBtn.click();
	}
	
	public void verifyReturnToProfileDisplayed() {
		try {
			if(returnToProfileLink.isDisplayed()) {
				System.out.println("Return to profile displayed");
			}
		}
		catch(Exception e) {
			Assert.fail("Return to profile not displayed");
		}
	}
	
	public void verifyBackToProfileDisplayed() {
		try {
			if(backToProfileBtn.size()==planNames.size()) {
				System.out.println("Back to profile displayed for each plan card");
			}
		}
		catch(Exception e) {
			Assert.fail("Back to profile not displayed for each plan card");
		}
	}
	
	public void clickBackToProfileBtn() {
		try {
			backToProfileBtn.get(1).click();
				System.out.println("Back to profile clicked");
		}
		catch(Exception e) {
			Assert.fail("Back to profile not displayed ");
		}
	}
	
}
