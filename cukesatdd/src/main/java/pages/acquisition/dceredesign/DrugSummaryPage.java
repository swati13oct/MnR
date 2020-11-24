package pages.acquisition.dceredesign;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;

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
	
	//@FindBy(xpath = "//div[contains(text(), 'Annual Estimated')]//following-sibling::div")
	@FindBy(xpath="(//div//h5[contains(text(), 'Annual Estimated')])[1]")
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
	
	@FindBy(xpath = "//*[contains(@id,'drugtable')]//button[contains(text(),'Switch to Generic')]")
	private WebElement switchToGenericBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Lipitor')]/following::a[contains(@id,'switchToGenericLink')]")
	private WebElement lipitorSwitchToGenericBtn;
	
	@FindBy(xpath = "//button[contains(@type,'submit')]//*[contains(text(),'Switch to Generic')]")
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
		//validateNew(viewProceBtn);
		//viewProceBtn.click();
		validateNew(drugPricingLink);
		drugPricingLink.click();
	}
	
	public void clickswitchToGeneric() throws InterruptedException {
		
		//validateNew(drugTitle);
		validateNew(switchToGenericBtn);
		jsClickNew(switchToGenericBtn);
		validateNew(switchToGenericSubmitBtn);
		jsClickNew(switchToGenericSubmitBtn);
	}
	
	public void clicklipitorswitchToGeneric() throws InterruptedException {
		Thread.sleep(6000);
		validateNew(drugTitle);
		validateNew(lipitorSwitchToGenericBtn);
		lipitorSwitchToGenericBtn.click();
		validateNew(switchToGenericSubmitBtn);
		switchToGenericSubmitBtn.click();
	}
	
	public void clickOnPdpPlan() throws InterruptedException {
		Thread.sleep(6000);
		validateNew(pdpPlan);
		pdpPlan.click();
		validateNew(viewProceBtn);
		viewProceBtn.click();
	}
	
	public void verifyDrugListsUpdated(String genericDrug) throws InterruptedException {
		Thread.sleep(6000);
		validateNew(drugTitle);
		/*
		 * for(int i=0;i<drugNames.size();i++) {
		 * System.out.println(drugNames.get(i).getText()); }
		 */
		validateNew(drugNames);
		System.out.println(drugNames.getText()+"   "+genericDrug);
		Assert.assertTrue("Drug not switched to generic",drugNames.getText().contains(genericDrug));
		validateNew(drugClose);
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
		validateNew(clickPdpplan);
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].click()", clickPdpplan);
		//clickPdpplan.click();
		
		
	}
	
	@FindBy(xpath = "//div[contains(text(),'If you qualify for LIS,')]")
	public WebElement drugPricingDeductText;
	
	
	public void verifyTheTextAlert()
	{
		
		validateNew(alertTextImg);
		validateNew(viewProceBtn);
	}
	public void verifyDrugPricingText() {
		
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validateNew(drugTitle);
		validateNew(switchToGenericBtn);
		validateNew(drugPricingDeductText);
		
	}
	
	public void clickOnSNPPlan()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validateNew(clickSnpplan);
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
			WebElement DrugCostsLinkforPlan = driver.findElement(By.xpath("//button[contains(@aria-label, 'View Drug Costs') and contains(@aria-label, '"+planName+"')]"));
			validateNew(DrugCostsLinkforPlan);
			jsClickNew(DrugCostsLinkforPlan);
			System.out.println("View Drug Costs Clicked for MAPD Plan : "+planName);

		}
		else if(plantype.equalsIgnoreCase("PDP")){
			validateNew(pdpPlanToggle);
			jsClickNew(pdpPlanToggle);
			System.out.println("PDP Plan Toggle Clicked");
			WebElement DrugCostsLinkforPlan = driver.findElement(By.xpath("//button[contains(@aria-label, 'View Drug Costs') and contains(@aria-label, '"+planName+"')]"));
			validateNew(DrugCostsLinkforPlan);
			jsClickNew(DrugCostsLinkforPlan);
			System.out.println("View Drug Costs Clicked for PDP Plan : "+planName);

		}
		else{
			validateNew(snpPlanToggle);
			jsClickNew(snpPlanToggle);
			System.out.println("SNP Plan Toggle Clicked");
			WebElement DrugCostsLinkforPlan = driver.findElement(By.xpath("//button[contains(@aria-label, 'View Drug Costs') and contains(@aria-label, '"+planName+"')]"));
			validateNew(DrugCostsLinkforPlan);
			jsClickNew(DrugCostsLinkforPlan);
			System.out.println("View Drug Costs Clicked for SNP Plan : "+planName);

		}
		waitForPageLoadSafari();
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

	// Code change Start - Added by F&F for Change Pharmacy to NC Pharmacy scenario

	@FindBy(xpath = "//*[@class='uhc-button__text'][contains(text(),'Save and Update Drug Costs')]")
	public WebElement saveDrugBtn;

	public void SelectPharmacy(String PharmacytoSelect) {

		validateSelectPharmacyPage();
		WebElement PharmacyName = driver.findElement(By.xpath("(//button[contains(@id, 'selectPharmacyBtn') and contains(@aria-label, 'Select "+PharmacytoSelect+"')])[1]"));
		jsClickNew(PharmacyName);
		validateNew(saveDrugBtn);
		saveDrugBtn.click();		
	}
	
	@FindBy(xpath = "//*[contains(@class, 'pharmacy-plan-desc')]")
	private WebElement PharmacyNameText;

	public void validatePharmacyName(String PharmacyName) {

		if(validateNew(PharmacyNameText) && PharmacyNameText.getText().contains(PharmacyName)) {
			Assert.assertTrue("Correct Pharmacy Name is Displayed : "+PharmacyNameText.getText(),true);
		}
		else {
			Assert.fail("Correct Pharmacy Name is NOT Displayed : "+PharmacyNameText.getText());
		}
	}
	
	// Code change End - Added by F&F for Change Pharmacy to NC Pharmacy scenario	
	
	public DrugSummaryPage selectPharmacyModalDisplayed() throws InterruptedException {
		waitforElementNew(selectPharmacyHeader, 30);
		if(validateNew(selectPharmacyHeader)) {
			return new DrugSummaryPage(driver);
		}
		return null;
	}
	
	public DrugSummaryPage validateSelectPharmacyPage() {
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

	
	public void validatePremiumForPlan(String premium, String plantype, String planName) {
		if (plantype.equalsIgnoreCase("MAPD")) {
			validateNew(mapdPlanToggle);
			jsClickNew(mapdPlanToggle);
			System.out.println("MAPD Plan Toggle Clicked");
		}
		else if(plantype.equalsIgnoreCase("PDP")){
			validateNew(pdpPlanToggle);
			jsClickNew(pdpPlanToggle);
			System.out.println("PDP Plan Toggle Clicked");
		}
		else{
			validateNew(snpPlanToggle);
			jsClickNew(snpPlanToggle);
			System.out.println("SNP Plan Toggle Clicked");
		}
		WebElement PremiumforPlan = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]//ancestor::*[contains(@class, 'uhc-card__header')]//following-sibling::*//*[contains(text(), 'Monthly Premium')]//following-sibling::*[contains(text(), '$')]"));
		validateNew(PremiumforPlan);
		String PremiumDisplayed	= PremiumforPlan.getText();
		System.out.println("Premium Displayed for Plan : "+PremiumDisplayed);
		if(!PremiumDisplayed.contains(premium)) {
			Assert.fail("Expected Premium not displayed, Expected : "+premium+"    Actual Displayed : "+PremiumDisplayed);
		}
	}
	
	public Map<String, String> captureDrugCosts(String planName) {
		Map<String, String> DrugDetails = new HashMap<String, String>();
		
		WebElement drugCosts_AvgMonDrugCost_Amount = driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/ancestor::*[contains(@class,'uhc-card__header')]//following-sibling::*[contains(@class,'uhc-card__content')]//*[contains(text(), 'Average Monthly Drug Cost')]//following-sibling::div[contains(text(), '$')]"));
		WebElement drugCosts_MonthlyPremium_Amount = driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/ancestor::*[contains(@class,'uhc-card__header')]//following-sibling::*[contains(@class,'uhc-card__content')]//*[contains(text(), 'Monthly Premium')]//following-sibling::div[contains(text(), '$')]"));
		WebElement drugCosts_AnnualEstTotal_Amount = driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/ancestor::*[contains(@class,'uhc-card__header')]//following-sibling::*[contains(@class,'uhc-card__content')]//*[contains(text(), 'Annual Estimated')]//following-sibling::div[contains(text(), '$')]"));

		

		String AVG_MONTHLY = drugCosts_AvgMonDrugCost_Amount.getText();
		String MONTHLY_PREMIUM = drugCosts_MonthlyPremium_Amount.getText();
		String ANNUAL_ESTIMATED_TOTAL = drugCosts_AnnualEstTotal_Amount.getText();
		String COVERED_DRUGS_COUNT = drugsCovered.getText();
		System.out.println("Covered Drug Text : "+COVERED_DRUGS_COUNT);
		DrugDetails.put("AVG_MONTHLY", AVG_MONTHLY);
		DrugDetails.put("MONTHLY_PREMIUM", MONTHLY_PREMIUM);
		DrugDetails.put("ANNUAL_ESTIMATED_TOTAL", ANNUAL_ESTIMATED_TOTAL);
		DrugDetails.put("COVERED_DRUGS_COUNT", COVERED_DRUGS_COUNT);
		
		return DrugDetails;
	}
	
	
	// Code change Start - Added by F&F for Drug Summary Regression Scenario - Switch to Generic	

	@FindBy(xpath = "//*[@id='modal-label' and contains(text(), 'Switch to Generic')]")
	public WebElement SwitchPageHeader;
	
	@FindBy(xpath = "//img[contains(@class,'uhc-modal__close')]")
	public WebElement SwitchPageCloseBtn;
	
	public SwitchToGeneric clickSwitchGeneric(String brandDrug) {
		CommonUtility.waitForPageLoadNew(driver, DrugPricing_CloseBtn, 20);
		validateNew(DrugPricing_Header);
		WebElement SwitchLink = driver.findElement(By.xpath("//*[contains(text(), '"+brandDrug+"')]//following::a[contains(text(), 'Switch ')]"));
		jsClickNew(SwitchLink);
		CommonUtility.waitForPageLoadNew(driver, SwitchPageHeader, 20);
		if(validateNew(SwitchPageHeader) && validateNew(SwitchPageCloseBtn)) {
			return new SwitchToGeneric(driver);
		}
		Assert.fail("Did not Navigate to Switch To Generic Page");
		return null;
	}
	
	
	@FindBy(xpath = "//h3[contains(text(), 'Drug Pricing')]")
	public WebElement DrugPricing_Header;
	
	@FindBy(xpath = "//*[contains(@id, 'cancelicon')]")
	public WebElement DrugPricing_CloseBtn;
	
	public void ValidatesDrugsList(String druglistObject) {
		CommonUtility.waitForPageLoadNew(driver, DrugPricing_CloseBtn, 20);
		validateNew(DrugPricing_Header);
		String[] Drugs = druglistObject.split("&");
		int DrugCount_Total = Drugs.length-1;
		String currentAddedDrug;
		int i;
		System.out.println("Total Added Drug Count : "+DrugCount_Total);
		for(i=1; i<=DrugCount_Total; i++) {
			currentAddedDrug = Drugs[i];
			System.out.println("Current Added Drug Name : "+currentAddedDrug);
			WebElement DrugName = driver.findElement(By.xpath("//span[contains(text(), '"+currentAddedDrug+"')]"));
			WebElement DrugYouPay = driver.findElement(By.xpath("//span[contains(text(), '"+currentAddedDrug+"')]//following::*[contains(text(), '$')]"));

			if(validateNew(DrugName) && validateNew(DrugYouPay)) {
				System.out.println("Drug Summary Page, Drug Pricing Modal -  Validated Drug List for Drug and You Pay : "+currentAddedDrug);
			}
			else
				Assert.fail("Drug Summary Page, Drug Pricing Modal -  Validation FAILED for Drug List for Drug and You Pay : "+currentAddedDrug);
		}	
		validateNew(DrugPricing_CloseBtn);
		jsClickNew(DrugPricing_CloseBtn);
	}

	@FindBy(xpath = "//h5[contains(text(), 'Drugs Covered')]//following-sibling::*[contains(text(), ' of ')]")
	public WebElement DrugsCoveredText;

	public void ValidateNCPharmacyCoveredDrugs() {
		
		if(validateNew(DrugsCoveredText)) {
			System.out.println("Drug Summary Page, Drug Covered Text Displayed for Not Covered Pharmacy");
		}
		else
			Assert.fail("Drug Summary Page, Drug Covered Text NOT Displayed for Not Covered Pharmacy");
	}
	
	// Code change End - Added by F&F for Drug Summary Regression Scenario - Switch to Generic and for NC Pharmacy Covered text validation




	public PlanDetailsPage clickViewplanDetailsForPlan(String plantype, String planName) {
		// TODO Auto-generated method stub
		if (plantype.equalsIgnoreCase("MAPD")) {
			validateNew(mapdPlanToggle);
			jsClickNew(mapdPlanToggle);
			System.out.println("MAPD Plan Toggle Clicked");
			WebElement PlanDetailsLinkforPlan = driver.findElement(By.xpath("//button[contains(@aria-label, 'View Plan Details') and contains(@aria-label, '"+planName+"')]"));
			validateNew(PlanDetailsLinkforPlan);
			jsClickNew(PlanDetailsLinkforPlan);
			System.out.println("View Plan details Clicked for MAPD Plan : "+planName);

		}
		else if(plantype.equalsIgnoreCase("PDP")){
			validateNew(pdpPlanToggle);
			jsClickNew(pdpPlanToggle);
			System.out.println("PDP Plan Toggle Clicked");
			WebElement PlanDetailsLinkforPlan = driver.findElement(By.xpath("//button[contains(@aria-label, 'View Plan Details') and contains(@aria-label, '"+planName+"')]"));
			validateNew(PlanDetailsLinkforPlan);
			jsClickNew(PlanDetailsLinkforPlan);
			System.out.println("View Plan details Clicked for PDP Plan : "+planName);

		}
		else{
			validateNew(snpPlanToggle);
			jsClickNew(snpPlanToggle);
			System.out.println("SNP Plan Toggle Clicked");
			WebElement PlanDetailsLinkforPlan = driver.findElement(By.xpath("//button[contains(@aria-label, 'View Plan Details') and contains(@aria-label, '"+planName+"')]"));
			validateNew(PlanDetailsLinkforPlan);
			jsClickNew(PlanDetailsLinkforPlan);
			System.out.println("View Plan details Clicked for SNP Plan : "+planName);

		}		
			return new PlanDetailsPage(driver);
		
	}
}
