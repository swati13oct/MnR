package pages.regression.benefitandcoverage;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import pages.member_deprecated.bluelayer.ProfilePreferencesPage;
import pages.memberrdesignVBF.TestHarness;
import pages.regression.benefitandcoverage.ValueAddedServicepage;
import pages.regression.payments.PaymentHistoryPage;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;

/**
 * @Functionality : To check Benefits and Coverage page
 */
public class BenefitsAndCoveragePage extends BenefitsAndCoverageBase {

	private static String PAGE_URL = MRConstants.STAGE_DASHBOARD_NEW_DOMAIN_URL;

	public PageData benefitsCoverage;

	public JSONObject benefitsandcoverageJson;

	public static final String learnmorestagetext_xpath = ".//*[@id='collapseStages']";

	public static final String learnmorelinktiertext_xpath = ".//*[@id='collapseTiers']";

	public static final String disclaimertextarea_xpath = "//*[@id='collapseDisclaimer']";

	public BenefitsAndCoveragePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	/**
	 *To check headers on Benefits and coverage page
	 */
	public void validateFieldsOnBenefitsAndCoveragePage() {
		try {
			validateNew(planName,0);
			validateNew(memberId,0);
			validateNew(memberName,0);
			validateNew(effectiveDate,0);
		} catch (Exception e) {
			System.out.println("Elements are not found ...");
		}
	}

	/**
	 * To check benefits and coverage page has opened
	 */
	@Override
	public void openAndValidate() {
		checkModelPopup(driver);
		validateFieldsOnBenefitsAndCoveragePage();
	}

	public void feebackpopupClose()
	{ //waitForloader(driver,overlay, 20);
		sleepBySec(20);
		if (validate(iPerceptionframe,0)) {

			switchToNewIframe(iPerceptionframe);
			iPerceptionclosebtn.click();
			driver.switchTo().defaultContent();
			//iPerceptionAutoPopUp.click();
		} else {
			System.out.println("iPerception Pop Up not displayed");
		}
	}

	/**
	 * The user validates the PlanDocuments Section
	 */
	public void PlanDocumentssection() {
		try {
			validateNew(planBenefitsDocuments,0);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	public void validate_drugCostDropdown_select() {
		Select drugCostdropdwn = new Select(drugCostDropdown);
		System.out.println(drugCostdropdwn.getFirstSelectedOption().getText());
		if(drugCostdropdwn.getFirstSelectedOption().getText().equalsIgnoreCase("Preferred Retail Pharmacy")){

			Assert.assertTrue("The Prefererd Retail Pharmacy should come by default in dropdown", true);
			System.out.println("The Prefererd Retail Pharmacy should come by default in dropdown");
		}
		else{
			Assert.fail("The Prefererd Retail Pharmacy is not displaying by default in dropdown");
			System.err.println("The Prefererd Retail Pharmacy is not displaying by default in dropdown");

		}
	}


	public void validate_drugCostDropdownzIndividualMAPD_select() {
		scrollToView(drugCostDropdown);
		Select drugCostdropdwn = new Select(drugCostDropdown);
		System.out.println(drugCostdropdwn.getFirstSelectedOption().getText());
		if(drugCostdropdwn.getFirstSelectedOption().getText().equalsIgnoreCase("Standard Retail Pharmacy")){

			Assert.assertTrue("The Prefererd Retail Pharmacy should come by default in dropdown", true);
			System.out.println("The Prefererd Retail Pharmacy should come by default in dropdown");
		}
		else{
			Assert.fail("The Prefererd Retail Pharmacy is not displaying by default in dropdown");
			System.err.println("The Prefererd Retail Pharmacy is not displaying by default in dropdown");

		}
	}

	/**
	 * The user validates the Hearing section of Ancillary
	 */
	public void HearingSection() {
		try {
			validateWithValue("HEARING", Hearingsection);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
		try {
			validateWithValue("Hearing Content", HearingContent);
			System.out.println(HearingContent.getText());
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	/**
	 * The user validates the Hearing aid section of Ancillary Benefits
	 */
	public void HearingAid() {
		validateWithValue("Exclusive hearing savings", Hearingaid);
	}

	/**
	 * The user validates the Vision section of Ancillary Benefits
	 */
	public void Vision() {
		validateWithValue("VISION header", Visionsection);
		validateWithValue("Vision Content",VisionContent);
	}

	/**
	 * The user validates the Dental section of Ancillary Benefits
	 */
	public void Dental() {
		validateWithValue("DENTAL header", Dentalsection);
		validateWithValue("Dental Content",DentalContent);
	}

	/**
	 * The user validates the Header section
	 */
	public void Header() {
		validateWithValue("ADDITIONAL BENEFITS", Headersection);
		if(Headersection.isDisplayed()){
			Assert.assertTrue("ADDITIONAL BENEFITS header is displaying", true);
		}
		else{
			Assert.fail("ADDITIONAL BENEFITS header is notdisplaying");
		}
	}

	/**
	 * The user validates the chiropractic section of Ancillary benefits
	 */
	public void chiropracticsection() {

		try {
			validateNew(chiropracticsection,0);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	/**
	 * The user validates the Disclaimers link under Exclusive hearing
	 *       section of Ancillary benefits
	 */
	public void ExclusiveDisclaimers() {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-50)", "");
		try {
			validateNew(Exclusivedisclaimer,0);
			Exclusivedisclaimer.click();
			sleepBySec(30);
			validateNew(Disclaimertext,0);
			System.out.println("Disclaimers' text:" + Disclaimertext.getText());

		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	public void VIEW_ALL_ANCILLARY_BENEFITS() throws InterruptedException {
		validateNew(ancillaryBenefitsHeader,0);
		validateNew(ancillaryBenefitsHeaderText,0);
	
	}


	/**
	 * @return 
	 * The user validates the Learn more button under Exclusive hearing
	 *       section of Ancillary benefits
	 */
	public void Exclusivelearnmore() {
			validateNew(LearnmoreButton,0);
			LearnmoreButton.click();
			sleepBySec(30);
			
			/*ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));*/
			System.out.println(driver.getCurrentUrl());
			if (driver.getCurrentUrl().contains("uhchearing.com")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Not able to navigate to UHC Hearing site");
			}
	}

	/**
	 * The user validates the DrugCoverage section headers and text
	 */
	public void validatedrugcoverageheaderandtext() {
		validateWithValue("Drug Coverage Header", DrugCoverageHeader);
		validateWithValue("Drug Coverage text",DrugCoveragetext);
	}

	public void validatedrugcoverageheaderandtext_pdplis() {
		validateWithValue("Drug Coverage Header", DrugCoverageHeader);
		validateWithValue("Drug Coverage text",DrugCoveragetext_pdpIndi);
	}

	/**
	 * The user validates the DrugCoverage section headers and text for group
	 */
	public void validatedrugcoverageheaderandtextgroup() {
		System.out.println(validate(DrugCoverageHeader,0));
		Assert.assertTrue(!validate(DrugCoverageHeader,0));
		Assert.assertTrue(!validate(DrugCoveragetext,0));
	}

	/**
	 * Validates Look Up Drugs button in the DrugCosts section
	 */
	public void validatelookupdrugsbutton(String plantype) 
	{
		System.out.println("****the user validates Look Up Drugs button should be visible***");
		validateWithValue("Look Up Drugs Button", LookUpDrugsButton);
	}

	public void validategrouplookupdrugsbutton() 
	{
		sleepBySec(10);
		validateNew(LookUpDrugsButton,0);
		LookUpDrugsButton.click();
		sleepBySec(40);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(0));

	}

	/**
	 * Validates the text for the Look Up Drugs section
	 */
	public void validate_lookupdrugstext() {
		validateWithValue("Text-Estimate your drug costs and view ways to save",LookupDrugstext);

	}

	/**
	 * Validates the headers in DrugCopays and Discount section
	 */
	public void validate_drugcopayheaderntext() {
		validateWithValue("Drug Copay Header", DrugCopayHeader);
		validateWithValue("Drug Copay Text",DrugCopayText);
	}

	/**
	 * Validates the Drug Cost header and text
	 */
	public void validate_drugcostheaderntext() {
		validateWithValue("DRUG LOOKUP",DrugCostheaderandtext);
	}

	public void validate_locatepharmacy() {
		validateWithValue("Text-PHARMACY LOCATOR", locateapharmacysection);
		validateWithValue("Locate a Pharmacy Button ",locateapharmacybutton);
	}

	/**
	 * Validates the text in locate a pharmacy section
	 */
	public void validate_locateapharmacysection(String plantype) {
		validateWithValue("PHARMACY LOCATOR",locateapharmacysection);
		validateWithValue("LOCATE A PHARMACY button",locateapharmacybutton);
	}

	/**
	 * Validates the Learnmore tiers links for a Lis member
	 */
	public void validate_tierlinknotdisplay() {
		try {
			if (LearnMoreDrugPricingTiersLink.isDisplayed()) {
				Assert.fail("The element" + LearnMoreDrugPricingTiersLink.getText() + "should not display");
				System.out.println("The element " + LearnMoreDrugPricingTiersLink.getText() + "should not display");
			} else {
				Assert.assertTrue(true);
			}
		} catch (NoSuchElementException e) {
			System.out.println("The element Learn More Durg Pricing Tiers Link is not displayed. "+e);
			Assert.assertTrue(true);
		}
	}

	public void validate_tierlinknotdisplay_pdpLis() {
		//note: for pdp lis user, this element will display in dom but it will not be visible on page (i.e. hidden)
		try {
			if (LearnMoreDrugPricingTiersLink_hidden_pdpLis.isDisplayed()) {
				Assert.assertTrue("The element 'Learn more about drug tiers' should not be visible on page", true);
			} 
		} catch (NoSuchElementException e) {
			if (LearnMoreDrugPricingTiersLink_visble_pdpLis.isDisplayed()) {
				Assert.assertTrue("The element 'Learn more about drug tiers' should have been hidden on page", false);
			} else {
				// neither of the elements are located so assume the element doesn't exist
				Assert.assertTrue("The element 'Learn more about drug tiers' should not be visible/hidden on page", true);
			}
		}
	}

	/**
	 * Validates the Pharmacy selection dropdown for a Lis member
	 */
	public void validate_dropdownnotdisplay() {
		sleepBySec(30);
		try {
			if (drugCostDropdownHiding.isDisplayed()) {
				Assert.fail("The element" + drugCostDropdownHiding.getText() + "should not display");
				System.out.println("The element " + drugCostDropdownHiding.getText() + "should not display");
			} else {
				Assert.assertTrue(true);
			}
		} catch (NoSuchElementException e) {
			System.out.println("The element Drug Cost Dropdown is not displayed " + e);
			Assert.assertTrue(true);
		}
	}

	/**
	 * Validates the Pharmacy selection dropdown for a non Lis member
	 */
	public void validate_drugCostDropdownoptions()

	{
		validateWithValue("Drug cost drop down ", drugCostDropdown);
		validateWithValue("Drug Cost Header",DrugCostHeader);
        scrollToView(drugCostDropdown);
		Select dropdown = new Select(drugCostDropdown);
		List<WebElement> webElements = dropdown.getOptions();

		for (WebElement element : webElements) {
			System.out.println(">>>>>>>>>>>>>>>Drug Costs dropdown option being validated <<<<<<<<<<<<<<<<<<: "+element.getText());
			if (element.getText().contains("Standard Retail Pharmacy")) {
				System.out.println(element.getText());
				Assert.assertTrue("The element" + element.getText() + "should display", true);

			} else if (element.getText().contains("Preferred Mail Service Pharmacy")) {
				Assert.assertTrue("The element" + element.getText() + "should display", true);
				System.out.println(element.getText());
			} else if (element.getText().contains("Preferred Retail Pharmacy")) {
				Assert.assertTrue("The element" + element.getText() + "should display", true);
				System.out.println(element.getText());
			} else {
				Assert.fail();
			}
		}
	}


	/**
	 * Validates the Learn More links for a Non Lis member
	 */
	public void validate_learnmoreaboutlink() {
		validateWithValue("Learn more tiers link", Learnmoretierslink);
		validateWithValue("Learn more stage link",Learnmorestagelink);
	}

	/**
	 * Validates the Learn More links for a Lis member
	 */
	public void validate_learnmoreaboutstagelink() {
		validateWithValue("LEARN MORE ABOUT DRUG PAYMENT STAGES link",Learnmorestagelink);
		Learnmorestagelink.click();
		sleepBySec(2);
		Learnmorestagelink.click();
	}

	/**
	 * Validates the headers in DrugCopays and Discount section for a
	 *       Lis member
	 */
	public void validate_lisdrugcopayheaderntext() {
		validateWithValue("LIS header", lisDrugCopayHeader);
		validateWithValue("LIS header text", lisDrugCopayHeadertext);
		System.out.println(" ***********LIS header and text is validated***********");
	}

	/**
	 * Validates the Drug costs table for a Non Lis member
	 */
	public void validatedrugcopaytable() {
		validate(drugcopaytable,0);
	}

	/**
	 * validateNews the Drug costs table for a Lis member
	 */
	public void validatedrugcosttable() {
		CommonUtility.waitForPageLoad(driver, RetailDrugCost_Table, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RetailDrugCost_Table);
		validateNew(RetailDrugCost_Table,0);
		System.out.println("********** Drug cost table is seen ==>"+RetailDrugCost_Table.isDisplayed());
		validate(columncoveragegenericdrugs,0);
		String targetXpath=".//*[@id='mapdPageLis']/div[1]/div/div/table/tbody/tr[2]/th/p";
		WebElement targetElement=driver.findElement(By.xpath(targetXpath));
		Assert.assertEquals(targetElement.getAttribute("innerHTML"), "Covered Generic Drugs");
	}

	public void validatedrugcosttable1() {
		validate(RetailDrugCost_Table1,0);
		System.out.println("********** Drug cost table is seen ==>"+RetailDrugCost_Table1.isDisplayed());
		validate(columncoveragegenericdrugs,0);
	}

	/**
	 * Validates the Ways to save section
	 */
	public void validateWaystoSave() {
		validateNew(waysToSave,0);
		validateNew(TextWaystoSave,0);

		System.out.println(TextWaystoSave.getText());
	}

	/**
	 * Validates the Plan overview section for a Non lis member
	 */
	public void validatePlanOverviewgroup() {
		validateWithValue("Plan name", planName);
		validateWithValue("Name label", nameLabel);
		validateWithValue("Member ID label", memberID);
		validateWithValue("Group id label",GroupId);
		validateWithValue("Effective date label", effective_Date);
		validateWithValue("Extra Help Level ",ExtraHelp);
		//below verifies values of the lavel

		if(!memberNameValueBNC.getText().equalsIgnoreCase("") && !memberIdValueBNC.getText().equalsIgnoreCase("") 
				&& !effectivedateValueBNC.getText().equalsIgnoreCase("")&& !GroupId.getText().equalsIgnoreCase("")){
			Assert.assertTrue("Values of plan overview is displaying", true);
			System.out.println("Values of plan overview is displaying");
		}
		else{  

			Assert.assertFalse("Values of plan overview are not displaying", true);
			System.out.println("Values of plan overview are not displaying");
		}
	}
	/**
	 * Validates the Plan overview section for a Non lis member
	 */
	public void validatePlanOverviewNonLISIndi() {
		validateWithValue("Plan name", planName);
		validateWithValue("Name label", nameLabel);
		validateWithValue("Member ID label", memberID);
		validateWithValue("Effective date label", effective_Date);
		validateWithValue("Extra Help Level ",ExtraHelp);
		//below verifies values of the lavel

		if(!memberNameValueBNC.getText().equalsIgnoreCase("") && !memberIdValueBNC.getText().equalsIgnoreCase("") 
				&& !effectivedateValueBNC.getText().equalsIgnoreCase("")){
			Assert.assertTrue("Values of plan overview is displaying", true);
			System.out.println("Values of plan overview is displaying");
		}
		else{  

			Assert.assertFalse("Values of plan overview are not displaying", true);
			System.out.println("Values of plan overview are not displaying");
		}
	}

	public void validatePlanOverviewgroupNONLIS() {
		CommonUtility.waitForPageLoadNew(driver, planName, 30);
		validateWithValue("Plan name", planName);
		validateWithValue("Name label", nameLabel);
		validateWithValue("Member ID label", memberID);
		validateWithValue("Group id label",GroupId);
		validateWithValue("Effective date label", effective_Date);
		//below verifies values of the lavel

		if(!memberNameValueBNC.getText().equalsIgnoreCase("") && !memberIdValueBNC.getText().equalsIgnoreCase("") 
				&& !effectivedateValueBNC.getText().equalsIgnoreCase("")&& !GroupId.getText().equalsIgnoreCase("")){
			Assert.assertTrue("Values of plan overview is displaying", true);
			System.out.println("Values of plan overview is displaying");
		}
		else{  
			Assert.assertFalse("Values of plan overview are not displaying", true);
			System.out.println("Values of plan overview are not displaying");
		}
	}



	public void validatePlanOverviewInd(String name, String memberid, String effectivedate, String monthlypremium) {
		validateWithValue("Plan name", planName);
		validateWithValue("Name label", nameLabel);
		validateWithValue("Member ID label", memberID);
		validateWithValue("Effective date label", effective_Date);
		validateWithValue("Monthly premium label",monthlypremiumlabel);

		validateWithValue("Member Name Value",memberNameValueBNC);
		validateWithValue("Member Id Value",memberIdValueBNC);
		validateWithValue("Effective date Value",effectivedateValueBNC);
	}


	public void validateHeaders() {
		validate(BenefitsSummaryHeader,0);
		validateNew(Copayscoinsuranceheader,0);
		validateNew(HospitalVisits,0);
		validateNew(OfficeVisits,0);
		validateNew(OutpatientSurgeryCenter,0);
		validateNew(OutpatientSurgeryCenterValue,0);
		validateNew(OfficVisitsValue,0);

		Assert.assertEquals(OfficeVisits.getText(), "OFFICE VISITS ");
		Assert.assertTrue(OutpatientSurgeryCenter.getText().contains("OUTPATIENT"));
		Assert.assertEquals(HospitalVisits.getText(), "HOSPITAL VISITS ");

		if (StringUtils.isEmpty(OutpatientSurgeryCenterValue.getText())) {
			Assert.fail();
		}
		if (StringUtils.isEmpty(OfficVisitsValue.getText())) {
			Assert.fail();
		}
	}
	
	public void validatevillagetabletext(String text1)
	{
		WebElement villagetabletext = driver.findElement(By.xpath(".//*[@id='preferredRetailBenefit']/div/div[1]/div/div/div/table/tbody/tr[2]/td[4]/div[3]/div[2]"));
		if(villagetabletext.getText().equalsIgnoreCase(text1))
		{
			System.out.println(villagetabletext.getText());
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	}


	/**
	 * Validate Plan overview for PDP Individual Members
	 */
	public void validatePlanOverviewSectionForMembers() {
		validateWithValue("Plan name", planName2);
		validateWithValue("Member Name: label", nameLabel1);
		validateWithValue("Member ID: label", memberID1);
		validateWithValue("Effective Date: label",effective_Date1);
	}

	/**
	 * @toDo: Validate Drug Look Up Link
	 */
	public void validate_druglookuplink() {
		validateWithValue("DRUG LOOKUP header",DrugLookUpLink);
		validateWithValue("Look Up Drugs Button", LookUpDrugsButton);
	}

	/**
	 * Validates the Plan overview section for a lis member
	 */
	public void validatePlanOverviewLis() {
		validateNew(planName,0);
		validateNew(nameLabel,0);
		validateNew(memberID,0);
		validateNew(effective_Date,0);
		// validateNew(Monthly_Premium);
		validateNew(ExtraHelp,0);
	}

	/**
	 * Validates the Plan overview section for a individual members with LEP amount
	 */
	public void validatePlanOverviewLEP() throws InterruptedException {
		System.out.println("validate LEP amount ");
		validate(planName,0);
		validateNew(nameLabel,0);
		validateNew(memberID,0);
		validateNew(effective_Date,0);
		validateNew(Monthly_Premium,0);
		validate(ExtraHelp,0);
		validateNew(LEPAmount,0);
	}

	/**
	 * Validates the headers section for individual members
	 */

	public void validateHeaders(String planType) {
		//note: for PDP user, there will be NO Benefits Summary Header section
		if (planType.equalsIgnoreCase("PDP")) {
			System.out.println("User has planType=PDP, validate should not have Benefits Summary section at all");
			validateNotDisplay("Benefits Summary Header", BenefitsSummaryHeader);
			validateNotDisplay("Copays coinsurance header",Copayscoinsuranceheader);
		} else {
			validateWithValue("Benefits Summary Header", BenefitsSummaryHeader);
			validateWithValue("Copays coinsurance header",Copayscoinsuranceheader);
			validateWithValue("Hospital Visits",HospitalVisits);
			validateWithValue("Office Visits",OfficeVisits);
			validateWithValue("Outpatient Surgery Center",OutpatientSurgeryCenter);
			validateWithValue("Outpatient Surgery Center Value",OutpatientSurgeryCenterValue);
			validateWithValue("Offic Visits Value",OfficVisitsValue);
			Assert.assertEquals(OfficeVisits.getText(), "OFFICE VISITS ");
			Assert.assertTrue("OUTPATIENT field text was changed or not found" ,OutpatientSurgeryCenter.getText().contains("OUTPATIENT"));
			Assert.assertTrue("Hospital Visits field text was changed or not found" ,HospitalVisits.getText().contains("HOSPITAL CARE"));

			if (StringUtils.isEmpty(OutpatientSurgeryCenterValue.getText())) {
				Assert.fail("Problem>>>>>>>>>>>>>.Outpatient Surgery Center Value is not displaying<<<<<<<<<<<<<<<<<<<<<<<<<<");
			}
			if (StringUtils.isEmpty(OfficVisitsValue.getText())) {
				System.out.println(">>>>>>>>>>Office Visits value is not displaying<<<<<<<<<<<<<<<<<<<<");
				Assert.fail();
			}
		}
	}

	/**
	 * Validates the headers section for group members
	 */
	public void validateHeadersGroup() {

		validateWithValue("Header-Benefits Summary", BenefitsSummaryHeader);
		validateWithValue("Header- Medical Copays or Coinsurance", Copayscoinsuranceheader);
		validateWithValue("Header-EMERGENCY CARE", EmergencyHeader);
		validateWithValue("Header-AMBULANCE", BenefitsSummaryHeader);
		validateWithValue("Header-Ambulance Header", AmbulanceHeader);
		validateWithValue("Header-Hospital Visits", HospitalVisits);
		validateWithValue("Header-Office Visits", OfficeVisits);
		validateWithValue("Header-Outpatient Surgery Center", OutpatientSurgeryCenter);
		Assert.assertEquals(OfficeVisits.getText(), "OFFICE VISITS ");
		Assert.assertTrue(OutpatientSurgeryCenter.getText().contains("OUTPATIENT HOSPITAL SERVICES"));
		Assert.assertTrue(HospitalVisits.getText().contains("HOSPITAL"));
		System.out.println(AmbulanceHeader.getText());
		Assert.assertEquals(AmbulanceHeader.getText(), "AMBULANCE");
		System.out.println(EmergencyHeader.getText());
		Assert.assertEquals(EmergencyHeader.getText(), "EMERGENCY CARE");
		if (StringUtils.isEmpty(OutpatientSurgeryCenterValue.getText())) {
			System.out.println(">>>>>>>>>>Outpatient Surgery Center Value is blank<<<<<<<<<<<<<<<<<<<<");
			Assert.fail();
		}
		if (StringUtils.isEmpty(OfficVisitsValue.getText())) {
			System.out.println(">>>>>>>>>>Office Visits value is blank<<<<<<<<<<<<<<<<<<<<");
			Assert.fail();
		}

	}

	/**
	 * Validates the Primary care provider section
	 */
	public void validatePrimaryCareProvider(String plantype) {

		validateWithValue("Primary Care Provider Header",PrimaryCareProviderHeaderInd);
		validateWithValue("Your Primary Care Provider", YourPrimaryCareProvider);
		try{
			if (Addaprovider.isDisplayed()) {
				validate(Addaprovider);
				Addaprovider.click();
			} 
		} catch(Exception e){
			validateWithValue("CHANGE YOUR PROVIDER ",ChangeYourPcpButton);
			ChangeYourPcpButton.click();
		}
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			System.err.println("CHANGE YOUR PROVIDER page not loaded");
		}
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("/member/contact-us")) {
			System.out.println("CHANGE YOUR PROVIDER has been clicked and navigated to Contact us page successfully");
			Assert.assertTrue(true);
		} else {
			System.out.println("CHANGE YOUR PROVIDER has not been clicked and not navigated to Contact us page successfully");
			Assert.fail();

		}
		navigateToBenefitsPg(plantype);

		validateNew(SearchProvider,0);
		validateWithValue("Provider Search", SearchProvider);
		validateWithValue("SEARCH FOR PROVIDERS",StartSearch);
		StartSearch.click();

		switchToNewTab();
		System.out.println(driver.getCurrentUrl());

		if (driver.getCurrentUrl().contains("werally.in")) {
			Assert.assertTrue(true);
		}
		else if (driver.getCurrentUrl().contains("systest3.myuhc.com"))
		{
			Assert.assertTrue(true);
		}
		else{
			System.out.println("Problem Spotted>>>>>>>>>Unable to navigate to Provider Search Page<<<<<<<<<<<<<<<");
			Assert.fail();        
		}
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		navigateToBenefitsPg(plantype);
	}

	/**
	 * Validates the Primary care provider section for group members
	 */
	public void validatePrimaryCareProviderForGroup() {

		validateNew(PrimaryCareProviderHeaderHMO,0);
		validateNew(PCPtext,0);
	}

	/**
	 * validateNews the Out Of Pocket Maximum section
	 */
	public void validateOutofPocketMax() {
		validateWithValue("Out of pocket section ", OutofPocketMaximum);
		validateWithValue("Out of pocket text",OutofPocketMaximumText);
		validateWithValue("In-Network text",INNETWORKTEXT);
		validateWithValue("Out-Network text",OUTOFNETWORKTEXT);
	}

	/**
	 * Validates the Benefits page
	 */
	public void validateBnCPag() {
		sleepBySec(20);
		validateNew(planName1,0);
	}

	public pages.member_deprecated.bluelayer.ProfilePreferencesPage navigateDirectToProfilePagee() throws InterruptedException {
		System.out.println(driver.getTitle());
		accountToggleDropdown.click();
		validateNew(accountSettingOption,0);
		accountSettingOption.click();
		sleepBySec(30);
		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("Profile")) {
			System.out.println("Pass!");
			return new ProfilePreferencesPage(driver);
		}
		gopaperlessbutton.click();
		return null;

	}

	/**
	 * @param benefitsExpectedCount 
	 * Validates the headers for ship members
	 */
	public void validateHeadersShip(String benefitsExpectedCount) {

		validateNew(MemberName,0);
		validateNew(MemberId,0);
		validateNew(EffectiveDate,0);
		validateNew(BenefitsSummaryHeadership,0);
		int i = 0;
		int benefitsCountExpected = Integer.parseInt(benefitsExpectedCount);	
		List<WebElement> tilelist = driver.findElements(By.xpath(".//*[@id='benefitShipCard']"));
		int benefitsActualCount=tilelist.size();
		for(i=0;i<tilelist.size();i++)
		{
			validateNew(tilelist.get(i));
		}
		Assert.assertTrue("PROBLEM -Benfits count doesn't Match."
				+ "Expected='"+benefitsExpectedCount+"' | Actual='"+benefitsActualCount,benefitsCountExpected==benefitsActualCount);

	}



	/**
	 * Validates the hand image in discount and services section for
	 *       ship members
	 */
	public void handimage() {
		validateNew(handimage,0);

	}

	/**
	 * Validates the Value added services section for ship members
	 */
	public void vasSection() {
		validateNew(textdiscountservices,0);
	}

	/**
	 * Validates the Learnmore Button for ship members
	 */
	public void learnmorebutton() {
		validateNew(learnmorebutton,0);
	}

	/**
	 * Validates the Value added services page for ship members
	 */
	public ValueAddedServicepage navigateToValueAddService() {
		validateNew(learnmorebutton,0);
		sleepBySec(30);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
		learnmorebutton.click();
		sleepBySec(30);
		if (this.driver.getTitle().equalsIgnoreCase("Value Added Services")) {
			System.out.println(driver.getTitle());
			return new ValueAddedServicepage(driver);
		}
		driver.navigate().to(PAGE_URL + "medicare/member/benefits-coverage.html");
		sleepBySec(10);
		return null;

	}

	public ValueAddedServicepage navigateToValueAddServicetest() {
		validateNew(learnmorebutton,0);
		sleepBySec(30);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
		learnmorebutton.click();
		sleepBySec(20);
		if (this.driver.getTitle().contains("Value Added Services")) {

			System.out.println(driver.getTitle());
			return new ValueAddedServicepage(driver);
		}
		sleepBySec(10);
		return null;

	}

	/**
	 * Validates the Need help section headers for a ship member
	 */
	public void validateneedhelpheaderShip() {
		validateNew(NeedhelpShip,0);
		validateNew(TechnicalSupportShip,0);
		validateNew(GeneralQuestionShip,0);
		validateNew(ClaimsSupportShip,0);
	}

	/**
	 * Validates the see more ways to contact us section for ship members in Need help section
	 */
	public void validateContactUsNeedHelp() {
		validateNew(needHelpSection,0);
		validateNew(Seemorewaystext,0);
	}

	/**
	 * Validates the contact us page on clicking on the link of contact us in Need help section
	 */
	public void contactUslinkShip() {
		sleepBySec(30);
		validateNew(contactUslink,0);
		/*contactUslink.click();
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Title is " + getTitle());
		driver.navigate().to(PAGE_URL + "medicare/member/benefits-coverage.html");
*/
		//Assert.assertTrue(getTitle().equalsIgnoreCase("Contact"));
	}

	public void valiadateCatastrophicCoverageValue(String copayType) {
		validateNew(catastrophicCoverageStage);
		if (copayType.equals("wotCMSValue")) {
		}
	}

	/**
	 * To validate pdfs on Benefit&Coverage Page
	 */
	public boolean verifypdfname(String a[]) {
		boolean checkflag = true;
		Select langdropdwn = new Select(langdropdown);
		sleepBySec(5);
		if(langdropdwn.getFirstSelectedOption().getText().contains("ENGLISH"))
		{
			List<WebElement> pdfs = driver.findElements(By.xpath("//div/span/div/ul/li[@class=' clearfix']/a"));
			System.out.println(">>>>>>>>>>>>.Size of Pdf's<<<<<<<<<<<<<<<< "+pdfs.size());
			for (int i=0;i<pdfs.size();i++)
			{  
				String pdfnames = null;
				pdfnames= (pdfs.get(i).getText());
				System.out.println(">>>>>>>>>>PDF visible<<<<<<<: "+pdfnames);
			}
			Assert.assertTrue("PROBLEM - not getting expected number of PDFs.  Expected='"+a.length+"' | Actual='"+pdfs.size()+"'",a.length==pdfs.size());
			//tbd if(a.length==pdfs.size())
			//tbd {
				for (int i=0;i<pdfs.size();i++)
				{  
					String pdf1[] = pdfs.get(i).getText().split(Pattern.quote("("));
					Assert.assertTrue("PROBLEM - PDF name should not be empty string.  Actual='"+pdf1[0]+"'", StringUtils.isNotEmpty(pdf1[0]));
					//tbd if(StringUtils.isNotEmpty(pdf1[0]))
					//tbd {
						System.out.println(pdf1[0]);
						System.out.println(a[i]);
						if((pdf1[0]).toLowerCase().contains((a[i]).toLowerCase())){
							checkflag = true;
						}
						else {
							checkflag=false;
							break;
						}
						//tbd }
						//tbd else
						//tbd {
						//tbd Assert.fail();
						//tbd }
				}
			//tbd }
			//tbd else
				//tbd {
				//tbd 	Assert.fail();
				//tbd }
		}
		else if(langdropdwn.getFirstSelectedOption().getText().contains("ESPAÃOL"))
		{
			List<WebElement> pdfs = driver.findElements(By.xpath("//div/span/div/ul/li[@class=' clearfix']/a"));

			System.out.println("Number of documents are - "+pdfs.size());
			for (int i=0;i<pdfs.size();i++)
			{  
				String pdfnames = null;
				pdfnames= (pdfs.get(i).getText());
				System.out.println(pdfnames);
			}

			if(a.length==pdfs.size())
			{
				for (int i=0;i<pdfs.size();i++)
				{  
					String pdf1[] = pdfs.get(i).getText().split(Pattern.quote("("));
					if(StringUtils.isNotEmpty(pdf1[0]))
					{
						System.out.println(pdf1[0]);
						if(pdf1[0].contains(a[i])){
							checkflag = true;
						}
						else {
							checkflag=false;
							break;
						}
					}
					else
					{
						Assert.fail();
					}
				}
			}
			else
			{
				Assert.fail("Documents are not displaying succcessfully");
				System.out.println("Documents are not displaying succcessfully");
			}
		}
		else if(langdropdwn.getFirstSelectedOption().getText().contains("ä¸­æ"))
		{
			System.out.println("NO PDFs in chinese yet.if PDFs come then above same code can be used");
			checkflag = true;
		}
		return checkflag;
	}
	
	/**
	 * To validate pdfs on Benefit&Coverage Page - whether pdf has content or not
	 */
	public boolean verifyDocContent(String a[]) {
		boolean checkflag = true;
		Select langdropdwn = new Select(langdropdown);
		if(langdropdwn.getFirstSelectedOption().getText().contains("ENGLISH"))	{
			List<WebElement> pdfs = driver.findElements(By.xpath("//div/span/div/ul/li[@class=' clearfix']/a"));
			validateEachPdfContent(pdfs);
		} else if(langdropdwn.getFirstSelectedOption().getText().contains("ESPAÃOL")) {
			List<WebElement> pdfs = driver.findElements(By.xpath("//div/span/div/ul/li[@class=' clearfix']/a"));
			validateEachPdfContent(pdfs);
		} else if(langdropdwn.getFirstSelectedOption().getText().contains("ä¸­æ")) {
			System.out.println("NO PDFs in chinese yet.if PDFs come then above same code can be used");
			checkflag = true;
		}
		return checkflag;

	}
	
	public void validateEachPdfContent(List<WebElement> pdfs) {
		for (WebElement pdf: pdfs) {
			String targetDocName=pdf.getText();
			//note: need to switch tab and then close tab when done with validation
			String winHandleBefore = driver.getWindowHandle();
			ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			int beforeClicked_numTabs=beforeClicked_tabs.size();	

			pdf.click();
			
			CommonUtility.checkPageIsReady(driver);
			System.out.println("Clicked the doc link...");

			sleepBySec(2);
			if (validate(siteLeavingPopup,0)) {
				System.out.println("Proceed to validate the leaving site popup after clicking "+targetDocName+" link");
				Assert.assertTrue("PROBLEM - unable to locate the site-leaving popup after clicking the '"+targetDocName+"' link", validate(siteLeavingPopup,0));
				Assert.assertTrue("PROBLEM - unable to locate the site-leaving popup PROCEED button after clicking the '"+targetDocName+"' link", validate(siteLeavingPopup_proceedBtn,0));
				Assert.assertTrue("PROBLEM - unable to locate the site-leaving popup CANCEL button after clicking the '"+targetDocName+"' link", validate(siteLeavingPopup_cancelBtn,0));

				siteLeavingPopup_proceedBtn.click();
				CommonUtility.checkPageIsReady(driver);
				Assert.assertTrue("PROBLEM - should not locate the site-leaving popup after clicking PROCEED button", !validate(siteLeavingPopup,0));
				sleepBySec(2);
			}
			
			
			ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			int afterClicked_numTabs=afterClicked_tabs.size();
			Assert.assertTrue("PROBLEM - Did not get expected new tab after clicking '"+targetDocName+"' link", (afterClicked_numTabs-beforeClicked_numTabs)==1);
			driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
			CommonUtility.checkPageIsReady(driver);
			sleepBySec(5);
			String actUrl=driver.getCurrentUrl();
			//note: validate page content
			validatePageContent(targetDocName, actUrl);			
			driver.close();
			driver.switchTo().window(winHandleBefore);
		}
	}
	
	public void validatePageContent(String targetDocName, String actUrl) {
		//note: validate page content
		if (actUrl.contains(".pdf")) {
			if (MRScenario.environment.contains("team-a")) {
				System.out.println("lower env will not load certain PDF docs, skip this page content validation");
				return;
			} else {
				try {
					URL TestURL = new URL(driver.getCurrentUrl());
					BufferedInputStream TestFile = new BufferedInputStream(TestURL.openStream());
					PDDocument document = PDDocument.load(TestFile);
					String PDFText = new PDFTextStripper().getText(document);
					System.out.println("PDF text : "+PDFText);
					Assert.assertTrue("PROBLEM - '"+targetDocName+"' PDF content is either null or empty", PDFText!=null && !PDFText.equals(""));
				} catch (MalformedURLException e) {
					e.printStackTrace();
					Assert.assertTrue("PROBLEM - unable to validate pdf '"+targetDocName+"' content - MalformedURLException", false);
				} catch (IOException e) {
					Assert.assertTrue("PROBLEM - unable to validate pdf '"+targetDocName+"' content - MalformedURLException", false);
				}
				System.out.println("Verified PDF '"+targetDocName+"' content is not null or empty");
			}
		} else {
			//note: for html or any url that's not pdf related
			Assert.assertTrue("PROBLEM - unable to locate page header text element on the landing page for doc '"+targetDocName+"'", validate(generalPgHeader,0));
			System.out.println("Verified page '"+targetDocName+"' content contains some kind of header element, i.e. page is not empty");
		}							
	}

	public void validatestaticlinksinpdf(String plantype) {
		validateWithValue("Link-Medication Therapy Management Program", Medicationlinkinpdfsec);
	}

	public void validatestaticlinksinpdfpdp(String plantype)
	{
		String originalUrl=driver.getCurrentUrl();
		String targetDocName="Medication Therapy management Program";
		System.out.println("Proceed to validate '"+targetDocName+"' link");
		validateNew(Medicationlinkinpdfsecpdp);
		sleepBySec(10);
		Medicationlinkinpdfsecpdp.click();
		String expectedUrl="/documents/medication-program";
		sleepBySec(5);
		String actualUrl=driver.getCurrentUrl();
		validatePageContent(targetDocName, actualUrl);
		Assert.assertTrue("PROBLEM - '"+targetDocName+"' destination URL not as expected. Expected to contain '"+expectedUrl+"' | Actual = '"+actualUrl+"'", actualUrl.contains(expectedUrl));
		driver.get(originalUrl);
		//tbd navigateToBenefitsPg(plantype);		
		CommonUtility.checkPageIsReady(driver);
		System.out.println("landing URL is ="+driver.getCurrentUrl());
		sleepBySec(10);

		targetDocName="VIEW OTHER DOCUMENTS AND RESOURCES";
		System.out.println("Proceed to validate '"+targetDocName+"' link");
		validateNew(Viewotherdocsinpdfpdp);
		Viewotherdocsinpdfpdp.click();
		sleepBySec(10);
		expectedUrl="/member/documents/overview.html";
		actualUrl=driver.getCurrentUrl();
		validatePageContent(targetDocName, actualUrl);
		Assert.assertTrue("PROBLEM - '"+targetDocName+"' destination URL not as expected. Expected to contain '"+expectedUrl+"' | Actual = '"+actualUrl+"'", actualUrl.contains(expectedUrl));
		sleepBySec(20);
		//tbd navigateToBenefitsPg(plantype);
		driver.get(originalUrl);
	}

	public void navigateToBenefitsPg(String plantype) {
		System.out.println("Go back to Benefits page...");
		if(plantype.equalsIgnoreCase("MAPD") || plantype.equalsIgnoreCase("PDP")) {
			//driver.navigate().to(PAGE_URL+"medicare/member/benefits-coverage.html");
			driver.navigate().to(PAGE_URL+"content/medicare/member/benefits/overview.html");
		} else if (plantype.equalsIgnoreCase("Medica"))	{
			driver.navigate().to("https://"+MRScenario.environment+"-mymedicareaccount.uhc.com/medica/member/benefits-coverage.html");
		} else if (plantype.equalsIgnoreCase("PCP")) {
			driver.navigate().to("https://"+MRScenario.environment+"-mymedicareaccount.uhc.com/pcp/member/benefits-coverage.html");
		}
		CommonUtility.checkPageIsReady(driver);
		System.out.println("landing URL is ="+driver.getCurrentUrl());
	}
	
	public void validatevillagetabletext1()	{
		String cellText="no more than 37% for generic drugs or 25% for brand name drugs";
		System.out.println("TEST-"+driver.findElement(By.xpath("//table//tr[2]/td[4]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//table//tr[2]/td[4]")).getText(),cellText);
		validateWithValue(cellText,driver.findElement(By.xpath("//table//tr[2]/td[4]")));
	}


	public boolean Validate_Catastrophic_Stage_Language(String updatedLanguage, String displayFlag) {
		List<WebElement> UpdatedLanguageCount = driver
				.findElements(By.xpath("//*[contains(text(),'" + updatedLanguage + "')]"));
		//System.out.println(updatedLanguage);
		System.out.println(UpdatedLanguageCount.get(0));
		boolean Expectedflag = (displayFlag.equalsIgnoreCase("true")) ? true : false;
		System.out.println(Expectedflag);
		boolean ActualFlag = (UpdatedLanguageCount.size() > 0) ? true : false;
		System.out.println(ActualFlag);
		if (Expectedflag == ActualFlag) {
			System.out.println("Updated Language is Displayed/Not DIsplayed as expected");
			return true;
		} else {
			System.out.println("Updated Language validation : Failed");
			return false;
		}
	}

	public void tabledynamicdata() {
		int i =0;
		int j = 0;
		List<WebElement> rows =  driver.findElements(By.xpath(".//*[@id='preferredRetailBenefit']/div/div[1]/div/div/div/table/tbody/tr/th"));
		List<WebElement> cols =  driver.findElements(By.xpath(".//*[@id='preferredRetailBenefit']/div/div[1]/div/div/div/table/tbody/tr/td[1]"));
		//tbd WebElement tabletext  = driver.findElement(By.xpath(".//*[@id='preferredRetailBenefit']/div/div[1]/div/div/div/table/tbody/tr[i]/td[j]/div"));

		for( i = 0 ; i<rows.size();i++)
		{
			for ( j = 0 ; j<cols.size();j++)
			{
				System.out.println(driver.findElement(By.xpath(".//*[@id='preferredRetailBenefit']/div/div[1]/div/div/div/table/tbody/tr["+i+"]/td["+j+"]/div")).getText());
			}
		}
	}

	public void grouptabledynamicdata(String plantype) {
		if (plantype.contentEquals("MAPD"))
		{
			//System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[3]")).getText());
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[3]")).getText(),"$7.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[4]")).getText(),"$7.00");
			// Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[5]")).getText(),"Greater of $3.35 or 5.00%");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]//td[1]")).getText(),"$15.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]//td[2]")).getText(),"$15.00");
			// Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]//td[3]")).getText(),"Greater of $8.35 or 5.00%");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]//td[1]")).getText(),"$15.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]//td[2]")).getText(),"$15.00");
			// Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]//td[3]")).getText(),"Greater of $8.35 or 5.00%");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]//td[1]")).getText(),"$100.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]//td[2]")).getText(),"$100.00");
			// Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]//td[3]")).getText(),"Greater of $8.35 or 5.00%");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[2]")).getText(),"No Deductible");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//td[7]")).getText(),"$3.40 copay for all generic drugs and $8.50 copay for brand name drugs.");

			validateNew(annualDeductibleColumnheader);
			validateNew(initialCoverageColumnheader);
			validateNew(coverageGaStageColumnheader);
			validateNew(catastrophicCoverageStageColumnheader);
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/th")).getText(),"Tier 1 ");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]/th")).getText(),"Tier 2 ");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]/th")).getText(),"Tier 3 ");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]/th")).getText(),"Tier 4 ");
		}
		else if (plantype.contentEquals("MAPDRX"))
		{
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[2]/td[3]")).getText(),"$10.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[2]/td[4]")).getText(),"$10.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[2]/td[5]")).getText(),"$10.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[3]/td[1]")).getText(),"$25.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[3]/td[2]")).getText(),"$25.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[3]/td[3]")).getText(),"$25.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[4]/td[1]")).getText(),"$40.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[4]/td[1]")).getText(),"$40.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[4]/td[1]")).getText(),"$40.00");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[5]/td[1]")).getText(),"25% coinsurance with a $100.00 maximum");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[5]/td[2]")).getText(),"25% coinsurance with a $100.00 maximum");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[5]/td[3]")).getText(),"25% coinsurance with a $100.00 maximum");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[2]/th")).getText(),"Tier 1 ");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[3]/th")).getText(),"Tier 2 ");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[4]/th")).getText(),"Tier 3 ");
			Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-rx187grptable']//tr[5]/th")).getText(),"Tier 4 ");
		}
	}

	public void validateImagePresent(String logoToBeDisplayedOnSecondaryPage) throws InterruptedException {
		CommonUtility.waitForPageLoad(driver,logoImage,15);
		String logo_src = logoImage.getAttribute("src");
		String logo_alt = logoImage.getAttribute("alt");
		System.out.println("Actual logo's source on Secondary page is   "+logo_src+" and Expected logo source is  "+logoToBeDisplayedOnSecondaryPage+" . ");                     
		System.out.println("logo's alt text on secondary page is   "+logo_alt);          
		Assert.assertTrue(logo_src.contains(logoToBeDisplayedOnSecondaryPage));
		System.out.println("Secondary page main logo assert condition for image source is passed");  
		
		System.out.println("naturalWidth of logo is "+logoImage.getAttribute("naturalWidth"));
        System.out.println("Now checking that image naturalWidth is not zero , which identifies that image is actually displayed on page");
			        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", logoImage);
			        if (!ImagePresent)
			        {
			         System.out.println("naturalWidth of logo is "+logoImage.getAttribute("naturalWidth"));
			         System.out.println("naturalWidth is not greater than zero , logo image was not displayed.");
			         Assert.fail("naturalWidth is not greater than zero , logo image was not displayed.");
			        }
			        else
			        {
			        	System.out.println("naturalWidth of logo is "+logoImage.getAttribute("naturalWidth"));
			            System.out.println("naturalWidth is not zero , Logo image was displayed.");
			         }

	}
	
	public void validateCoLogoImagePresent(String cologoToBeDisplayedOnSecondaryPage) throws InterruptedException {
		CommonUtility.waitForPageLoad(driver,cologoImage,15);
		String cologo_src = cologoImage.getAttribute("src");
		String cologo_alt = cologoImage.getAttribute("alt");
		System.out.println("Actual cologo's source on secondary page is   " + cologo_src
				+ " and Expected logo source is  " + cologoToBeDisplayedOnSecondaryPage + " . ");
		System.out.println("logo's alt text on secondary page is   " + cologo_alt);
		Assert.assertTrue(cologo_src.contains(cologoToBeDisplayedOnSecondaryPage));
		System.out.println("Secondary page co logo assert condition for image source is passed");
		System.out.println("Now checking that co-image naturalwidth is not zero , which identifies that image is actually displayed on page");
		System.out.println("naturalwidth of cologo is : "+cologoImage.getAttribute("naturalWidth"));
        Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", cologoImage);
        if (!ImagePresent)
        {
         System.out.println("naturalwidth of cologo is : "+cologoImage.getAttribute("naturalWidth"));
         System.out.println("naturalwidth is zero , co-logo image was not displayed.");
         Assert.fail("naturalwidth is zero , co-logo image was not displayed.");
        }
        else
        {
        	System.out.println("naturalwidth of cologo is : "+cologoImage.getAttribute("naturalWidth"));
            System.out.println("naturalwidth is not zero , co-logo image was displayed.");
            
        }
	}
	
	public void validatePlanOverviewIndlis(String name, String memberid, String effectivedate, String monthlypremium,
			String extrahelp) {
		validateWithValue("Paln name", planName2);
		validateWithValue("Member Name: label", nameLabel1);
		validateWithValue("Member ID: label", memberID1);
		validateWithValue("Effective Date: label",effective_Date1);
		validateWithValue("monthly Premium",monthlypremiumlabel);
		validateWithValue("Extra Help", ExtraHelp);
	}

	public boolean vasnotdisplayed() {
		if (textdiscountservices.isDisplayed()) {
			System.out.println("Vas is present");
			return false;
		}
		else {
			System.out.println("Vas is not present");
			return true;
		}
	}

	//note: Dec2018 - modified to handle NoSuchElement Exception
	public boolean ancillarynotdisplayed() {
		try {
			if (Headersection.isDisplayed()) {
				System.out.println("Ancillary is present");
				return false;
			} else {
				System.out.println("ancillary is not present");

				return true;
			}
		} catch (NoSuchElementException e) {
			System.out.println("ancillary is not present");
			return true;
		}
	}

	public boolean optumRxLinkdisplayed() {
		if (optumRxBtn.isDisplayed()) {
			System.out.println("Optum Rx button is present");
			return true;
		} else {
			System.out.println("Optum Rx button is not present");
			return false;
		}
	}

	public void validatehartfortprescriptiondrugtable() {
		sleepBySec(5);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-500)", "");
		validateNew(hartfortdrugtable);
		String TableData="Standard Network Pharmacy Retail Drug Costs\n"
		        +"Copay *\n"
				+"footnote\n"
				+"Initial Coverage Stage *\n"
				+"footnote\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"$5.00 copay\n"
				+"$5.00 copay\n"
				+"After your total drug costs reach $4,020, the plan continues to pay its share of the cost of your drugs and you pay your share of the cost.\n"
				+"When your total out-of-pocket costs for Part D prescription drugs reach $6,350, you will pay a $0 copay for your drugs for the rest of the plan year.\n"
				+"Tier 2\n"
				+"$25.00 copay\n"
				+"$25.00 copay\n"
				+"Tier 3\n"
				+"$40.00 copay\n"
				+"$40.00 copay\n"
				+"Tier 4\n"
				+"$40.00 copay\n"
				+"$40.00 copay";

		if(hartfortdrugtable.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>   The Expected table value is    <<<<<<<<<<<<     \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+hartfortdrugtable.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
	}

	public void validateTownOfGreenwichdrugtable() {
		sleepBySec(5);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", GreenwichTable);
		validateNew(GreenwichTable);
		String TableData="Standard Network Pharmacy Retail Drug Costs\n"
		        +"Copay *\n"
				+"footnote\n"
				+"Initial Coverage Stage *\n"
				+"footnote\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"$5.00 copay\n"
				+"$5.00 copay\n"
				+"After your total drug costs reach $4,020, the plan continues to pay its share of the cost of your drugs and you pay your share of the cost.\n"
				+"When your total out-of-pocket costs for Part D prescription drugs reach $6,350, you will pay a $0 copay for your drugs for the rest of the plan year.\n"
				+"Tier 2\n"
				+"$5.00 copay\n"
				+"$5.00 copay\n"
				+"Tier 3\n"
				+"$20.00 copay\n"
				+"$20.00 copay\n"
				+"Tier 4\n"
				+"$35.00 copay\n"
				+"$35.00 copay\n"
				+"Tier 5\n"
				+"$35.00 copay\n"
				+"$35.00 copay";

		if(GreenwichTable.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>   The Expected table value is    <<<<<<<<<<<<     \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+GreenwichTable.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
	}

	public void validatedrugCostSectionTexas() {
		//note Dec2018 - wait for element to load before validation
		CommonUtility.waitForPageLoad(driver, pharmacyDropdownTexas, 5);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-500)", "");
		validateNew(pharmacyDropdownTexas);
	}

	public void validateRetailCostSharingdrugtable() {
		Select drpPharmacy = new Select(pharmacyDropdownTexas);
		drpPharmacy.selectByValue("Retail Cost Sharing");
		System.out.println("Retail Cost Sharing dropdown value selected");
		validateNew(retailTable);
		String TableData= "Annual Prescription Deductible Initial Coverage Stage Coverage Gap Stage Catastrophic Coverage Stage\n"
				+"30-day supply (non-maintenance drugs) 30-day supply (maintenance drugs*) 31- to 60-day supply** 61- to 90-day supply**\n"
				+"Tier 1\n"
				+"You pay 100% of costs until $50 deductible is met*\n"
				+"$10 copay\n"
				+"$10 copay\n"
				+"$20 copay\n"
				+"$30 copay\n"
				+"After your total drug costs reach $4,020, the plan covers all formulary drugs through the coverage gap at the same copays listed under the Initial Coverage Stage\n"
				+"When your out-of-pocket costs reach the $6,350 limit for the plan year, you move to the Catastrophic Coverage Stage.  In this stage, you will continue to pay the same cost share that you paid in the Initial Coverage Stage.\n"
				+"The catastrophic coverage will go toward Part D covered medications.\n"
				+"Tier 2\n"
				+"$35 copay\n"
				+"$45 copay\n"
				+"$70 copay\n"
				+"$105 copay\n"
				+"Tier 3\n"
				+"$60 copay\n"
				+"$75 copay\n"
				+"$120 copay\n"
				+"$180 copay";

		System.out.println("Expected table  is >>>>>>>>>>>>>"+"\n"+TableData.toString());
		System.out.println("Actual table value is >>>>>>>>>> "+"\n"+retailTable.getText());

		if(retailTable.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
	}


	public void validateMailOrderCostSharing_Drugtable() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,+200)", "");
		Select drpPharmacy = new Select(pharmacyDropdownTexas);
		drpPharmacy.selectByValue("Mail Order Cost Sharing");
		sleepBySec(5);
		waitforElementNew(MailOrderTable);
		String TableData= "Annual Prescription Deductible Initial Coverage Stage Coverage Gap Stage Catastrophic Coverage Stage\n"
				+"31- to 60-day supply 61- to 90-day supply\n"
				+"Tier 1 :\n"
				+"You pay 100% of costs until $50 deductible is met*\n"
				+"$20 copay\n"
				+"$30 copay\n"
				+"After your total drug costs reach $4,020, the plan covers all formulary drugs through the coverage gap at the same copays listed under the Initial Coverage Stage\n"
				+"When your out-of-pocket costs reach the $6,350 limit for the plan year, you move to the Catastrophic Coverage Stage.  In this stage, you will continue to pay the same cost share that you paid in the Initial Coverage Stage.\n"
				+"The catastrophic coverage will go toward Part D covered medications.\n"
				+"Tier 2 :\n"
				+"$70 copay\n"
				+"$105 copay\n"
				+"Tier 3 :\n"
				+"$120 copay\n"
				+"$180 copay";
		//+"* Please see Additional Drug Coverage for a list of the plan’s maintenance drugs. ERS is continuing to offer additional coverage on some prescription drugs that are normally excluded from coverage on your Formulary. Please see your Additional Drug Coverage list for more information.";

		System.out.println(">>>>>>>>>>>>>>Expected table  is >>>>>>>>>>>>>"+"\n"+TableData.toString());
		System.out.println(">>>>>>>>>>>>>>>Actual table value is >>>>>>>>>> "+"\n"+MailOrderTable.getText());

		if(MailOrderTable.getText().trim().equals(TableData.toString().trim())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
	}

	public void validateOfficeVisitssection() {
		//note: Dec2018 - wait for element to load before validation
		CommonUtility.waitForPageLoad(driver, OfficeVisits, 5);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-100)", "");

		validateNew(OfficeVisits);
		validateNew(pcpValue);
		validateNew(specialistValue);

		String input = pcpValue.getText();
		Assert.assertTrue("PROBLEM - unable to locate value for the element", !input.equals(""));
		System.out.println("PCP value to be validated: "+ input);

		Pattern pattern = Pattern.compile("^\\d{1,4}\\.\\d{2}\\%$"); if
		(pattern.matcher(input).matches()) {
			Assert.assertTrue("PCP values exists", true); } else { throw new
				IllegalArgumentException("Invalid String"); }

		String input1 = specialistValue.getText();

		if (pattern.matcher(input1).matches()) {
			Assert.assertTrue("Specialist values exists", true); } 
		else { throw
			new IllegalArgumentException("Invalid String"); }
	}

	public void validateoutpatientsurgerycenterVisitssection() {
		try {
			feebackpopupClose();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-50)", "");
			validateNew(outpatientsurgeryVisits,0);
		} catch (Exception e) {
		}
	}

	public void OutpatientSurgeryCentervisits_withprovidertiering(){
		//Sardar Start
		//String TableData="OUTPATIENT SURGERY CENTER VISITS \n"
		//	+"Type 1: $75.00\n"
		//+"Type 2:  $150.00";
		String TableData="OUTPATIENT";
		if(outPatientSection.getText().contains(TableData.toString())){
			//Sardar End
			Assert.assertTrue("The data in the outPatient section is displaying correctly", true);
			System.out.println("The data in the outPatient section  is displaying correctly");  
		}
		else{
			System.err.println("The data in the outPatient section  is not displaying correctly");
			Assert.fail("The data in the outPatient section is not displaying correctly");
		}}

	public void outpatientcenterwithoutprovidertier(){
		//Sardar Start
		//String TableData="OUTPATIENT SURGERY CENTER VISITS\n"
		//            +"20.00%";
		//if(outPatientSection.getText().equals(TableData.toString())){
		String TableData="OUTPATIENT";
		if(outPatientSection.getText().contains(TableData.toString())){
			//Sardar End

			Assert.assertTrue("Problem>>>>>>>>>>>>>>>>The data in the outPatient section is displaying correctly", true);
			System.out.println("Problem>>>>>>>>>>>>>>>>The data in the outPatient section  is displaying correctly");  
		}
		else{
			System.err.println("Problem>>>>>>>>>>>>>>>>The data in the outPatient section  is not displaying correctly");
			Assert.fail("Problem>>>>>>>>>>>>>>>>The data in the outPatient section is not displaying correctly");
		}}

	public void validateWaysToSaveSection(String planType, String memberType) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", waysToSaveSection);

		if(planType.equalsIgnoreCase("PDP")){
			if (memberType.contains("Wallgreens")) {
				validateNew(waysToSaveSection);
				validateNew(lowTierdrugs);    
				validateWithValue("Lower-tier Drugs",lowTierdrugsText);        //validate Lower-tier Drugs
				validateNew(wallGreensWidget);
				validateWithValue("Walgreens Preferred Retail Pharmacy", wallGreensWidgetText);             //validate Walgreens Preferred Retail Pharmacy
				validateNew(PreferredMailServicePharmacyLogo);
				validateWithValue("Preferred Mail Service Pharmacy", PreferredMailServicePharmacyText); 
			} else if (memberType.contains("MailOrderPharamacy")) {
				validateNew(waysToSaveSection);
				validateNew(lowTierdrugs);    
				validateWithValue("Lower-tier Drugs",lowTierdrugsText);        //validate Lower-tier Drugs

				validateNew(retailpharmacylogo);
				validateWithValue("Preferred Retail Pharmacy", PreferredRetailPharmacyText);

				validateNew(PreferredMailServicePharmacyLogo);
				validateWithValue("Preferred Mail Service Pharmacy", PreferredMailServicePharmacyText); 
			}	
		} else  {
			//note: by default there will be one id=waystosave element on the page regardless memberType, so check to see it's less than 2 instead of 1
			if (waysToSaveSectionvalidate.size() < 2) {
				Assert.assertTrue("ways to save section doesnt exist for a non PDP memeber", true);
			} else {
				Assert.assertFalse("ways to save section exists for a non PDP memeber", true);
			}
		}
	}

	public void fedtabledata() {
		//System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[3]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[3]")).getText(),"$4.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[4]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]/td[1]")).getText(),"$10.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]/td[2]")).getText(),"$47.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]/td[3]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]/td[1]")).getText(),"$95.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[6]/td[1]")).getText(),"29%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[6]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[2]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]/td[1]")).getText(),"100% until the $215.00 deductible is met.*");
		//System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[2]")).getText());
		//Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[6]")).getText(),"25%");
	}

	public void fedpdptabledata() {
		System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[2]/td[3]")).getText());
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[2]/td[3]")).getText(),"$0.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[2]/td[4]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[3]/td[1]")).getText(),"$5.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[3]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[4]/td[2]")).getText(),"$30.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[4]/td[3]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[5]/td[1]")).getText(),"32%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[5]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[6]/td[1]")).getText(),"25%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[6]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferedretailpharmcytable']//tr[4]/td[1]")).getText(),"100% until the $415.00 deductible is met.*");

		drugCostDropdown.sendKeys("Preferred Mail Service Pharmacy");
		sleepBySec(15);
		/*
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[2]/td[3]")).getText(),"$3.00");
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[2]/td[4]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[3]/td[1]")).getText(),"$9.00");
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[3]/td[2]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[4]/td[1]")).getText(),"$102.00");
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[4]/td[2]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[5]/td[1]")).getText(),"30%");
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[5]/td[2]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[6]/td[1]")).getText(),"25%");
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[6]/td[2]")).getText(),"no more than 44% for generic drugs or 35% for brand name drugs");
                              Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[2]/td[2]")).getText(),"100% until the $405.00 deductible is met.");
                              System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[2]/td[6]")).getText());
		 */
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[2]/td[3]")).getText(),"$0.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[2]/td[4]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[3]/td[1]")).getText(),"$15.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[3]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[4]/td[2]")).getText(),"$90.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[4]/td[3]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[5]/td[1]")).getText(),"32%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[5]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[6]/td[1]")).getText(),"25%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[6]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[4]/td[1]")).getText(),"100% until the $415.00 deductible is met.*");
		System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-preferdmailpharmcytable']//tr[2]/td[6]")).getText());

		drugCostDropdown.sendKeys("Standard Retail Pharmacy");
		sleepBySec(15);
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[3]")).getText(),"$15.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[4]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]/td[1]")).getText(),"$20.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[3]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]/td[2]")).getText(),"$45.00");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]/td[3]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]/td[1]")).getText(),"33%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[5]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[6]/td[1]")).getText(),"25%");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[6]/td[2]")).getText(),"no more than 37% for generic drugs or 25% for brand name drugs");
		Assert.assertEquals(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[4]/td[1]")).getText(),"100% until the $415.00 deductible is met.*");
		System.out.println(driver.findElement(By.xpath(".//*[@class='table-white atdd-bnc-standrdretailpharmcytable']//tr[2]/td[6]")).getText());
	}


	public void ValidatePeehipsection() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,700)", "");
		validateNew(PeehipTable);

		System.out.println(annualDeductibleColumn.size() + initialCoverageColumn.size() + coverageGaStageColumn.size()
		+ catastrophicCoverageStageColumn.size());
		if (annualDeductibleColumn.size() > 0 && initialCoverageColumn.size() > 0 && coverageGaStageColumn.size() > 0
				&& catastrophicCoverageStageColumn.size() > 0) {
			Assert.assertTrue("The columns are correct in Peehip table", true);

		} else {
			Assert.assertFalse("The columns are incorrect in Peehip table", true);
		}

		validateNew(PeehipTier1ValueIC);
		String input = PeehipTier1ValueIC.getText();
		Pattern pattern = Pattern.compile("^\\$\\d{1,4}\\.\\d{2}$");
		if (pattern.matcher(input).matches()) {
			Assert.assertTrue("value  in IC column exists", true);
		} else {
			throw new IllegalArgumentException("Invalid String");
		}
		validateNew(PeehipTier1ValueCG);

		input = PeehipTier1ValueCG.getText();
		if (pattern.matcher(input).matches()) {
			Assert.assertTrue("Value in Coverage gap stage column exists", true);
		} else {
			throw new IllegalArgumentException("Invalid String");
		}

		if (PeehipTier1ValueCC.size() > 0) {
			Assert.assertTrue("Catastrophic Coverage stage has some value", true);

		} else {
			Assert.assertFalse("Catastrophic Coverage stage doesn't have any value", true);
		}
		// special character is not validating
		//validatePeehiptableValues();
	}

	//note: Dec2018 - handle SSUP case
	//public void ValidateMAsection() {
	public void validateBncPageSections(String planType) {
		if (planType.equalsIgnoreCase("SSUP")) {
			System.out.println("proceed to locate senior supplement plan tab and click it");
			WebElement ssupTab=driver.findElement(By.xpath("//ul[@class='nav nav-tabs']//li[2]"));
			if (ssupTab.isDisplayed()) {
				ssupTab.click();
				System.out.println("located senior supplement plan tab and clicked it");
				//validateNew(ssupExclusiveHearingSavings);
				//validateNew(ssupVision); 
				//validateNew(ssupDental);
				// benefits summary section
				validateNew(benefitsSummarySection);
				validateNew(officeVisitSection);
				validateNew(hospitalVisitsSection);
				validateNew(OutpatientSurgeryCenterSection);

				// out of pocket maximum section
				validateNew(outOfPocketSection);
				validateNew(inNetworkSection);
				validateNew(outOfNetworkSection);
			} 
		} else if (planType.equalsIgnoreCase("MEDSUPP")|| planType.equalsIgnoreCase("SHIP")) {
			if(validateNew(medsuppNavTab))
				medsuppNavTab.click();
			System.out.println("located medicare supplement plan tab and clicked it");	
		} else if(planType.contains("MA")){
			if(validate(mapdNavTab))
				mapdNavTab.click();
			// benefits summary section
			validateNew(benefitsSummarySection);
			validateNew(officeVisitSection);
			validateNew(hospitalVisitsSection);
			validateNew(OutpatientSurgeryCenterSection);

			// out of pocket maximum section
			validateNew(outOfPocketSection);
			validateNew(inNetworkSection);
			validateNew(outOfNetworkSection);

			// PCP section
			validateNew(PrimaryCareProviderHeaderInd);
			validateNew(YourPrimaryCareProvider);
			validateNew(ChangeYourPcpButton);
			validateNew(StartSearch);
			//validateNew(drugCostDropdown);
			//validateNew(drugCopaysAndDiscountSection);
			System.out.println();
		} else if(planType.equalsIgnoreCase("PDP")){
			if(validate(pdpNavTab))
				pdpNavTab.click();
			validateNew(drugCostDropdown);
			validateNew(drugCopaysAndDiscountSection);
		}
		// plan Overview section
		validateNew(planName);
		validateNew(nameLabel);
		validateNew(memberID);
		validateNew(effective_Date);

		// plan documents section
		validateNew(planDocumentsTitle);
		validateNew(planDocumentsLangDropdown);
		validateNew(view_label);

		// Need help section
		validateNew(needHelpSection);
		validateNew(NeedHelpHeader);
		validateNew(contactUslink);
		validateNew(moreinformation);
	}

	public void validateCopayCoinsuranceInDrugTable() {
		//note: Dec2018 - wait for the element to show up before validation
		validateNew(drugTableNonLisMember);
		if (annualDeductibleColumnFederal.size() > 0 && initialCoverageColumnFederal.size() > 0
				&& coverageGaStageColumnFederal.size() > 0 && catastrophicCoverageStageColumnFederal.size() > 0) {
			Assert.assertTrue("The columns are correct in Drug Costs table", true);

		} else {
			Assert.assertFalse("The columns are incorrect in drug Costs table", true);
		}
		validateNew(federalValueIC);
		String input = federalValueIC.getText();
		System.out.println(">>>>>>>>Value in the Initial Coverage Stage is:"+input);
		Pattern pattern = Pattern.compile("^\\$\\d{1,4}\\.\\d{2}$");
		if (pattern.matcher(input).matches()) {
			Assert.assertTrue("value  in IC column exists", true);
		} else {
			throw new IllegalArgumentException("Invalid String");
		}
	}

	public void ValidatesBenefitsForCombo() {
		int numberOfTabsForCombo;
		// TODO Auto-generated method stub
		numberOfTabsForCombo = tabsForComboMember.size();
		if (numberOfTabsForCombo > 1) {
			String memberid1;
			validateNew(memberIdForPlan);
			memberid1 = memberIdForPlan.getText();
			if (memberid1.contains("-11")) {
				validateNew(MemberName);
				validateNew(MemberId);
				validateNew(EffectiveDate);
				validateNew(BenefitsSummaryHeadership);
				
				System.out.println(">>>>>>>>>Validating the benefits for a Ship Plan<<<<<<<<<<<<");
				List<WebElement> tilelist = driver.findElements(By.xpath(".//*[@id='benefitShipCard']"));
				int benefitsActualCount=tilelist.size();
				for(int i=0;i<tilelist.size();i++)
				{
					validateNew(tilelist.get(i));
				}
				Assert.assertTrue("PROBLEM -No Benefit ship Card Present",benefitsActualCount>0);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,900)", "");
				validateNew(shipClaimsSupportHeader);
			} else {
				System.out.println(">>>>>>>>>>Validating the benefits of a Federal Plan of a combo Member<<<<<<<<<<<<");
				validateNew(drugCopaysAndDiscount);
			}

			tabsForComboMember.get(1).click();
			validateNew(memberIdForPlan);
			memberid1 = memberIdForPlan.getText();
			if (memberid1.contains("-11")) {
				validateNew(MemberName);
				validateNew(MemberId);
				validateNew(EffectiveDate);
				validateNew(BenefitsSummaryHeadership);
				
				System.out.println(">>>>>>>>>Validating the benefits for a Ship Plan<<<<<<<<<<<<");
				List<WebElement> tilelist = driver.findElements(By.xpath(".//*[@id='benefitShipCard']"));
				int benefitsActualCount=tilelist.size();
				for(int i=0;i<tilelist.size();i++)
				{
					validateNew(tilelist.get(i));
				}
				Assert.assertTrue("PROBLEM -No Benefit ship Card Present",benefitsActualCount>0);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,900)", "");
				validateNew(shipClaimsSupportHeader);
			} else {
				System.out.println(">>>Validating the benefits of a Federal Plan of a combo Member<<<<<<<<");
				validateNew(drugCopaysAndDiscount);
			}
		}
		else{
			Assert.fail(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Member is not a Combo user.Please replace the user<<<<<<<<<<<<<<<<<<<<<,, ");
		}
	}

	public void validatesAddRider() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,1500)", "");
		validateNew(addRiderSection);
		int numberOfAddRiderButtons = addRiderButton.size();
		if (numberOfAddRiderButtons > 0) {
			addRiderButton.get(numberOfAddRiderButtons - 1).click();
			validateNew(addBenefitPopup);
			validateNew(addRiderButtonOnPopup);
			addRiderButtonOnPopup.click();
		}
		sleepBySec(20);
	}

	public void validatesRemoveRider() {
		sleepBySec(10);
		int numberOfAddRiderButtons = addRiderButton.size();
		CommonUtility.waitForPageLoadNew(driver, removeRiderButton, 20);
		validateNew(removeRiderButton);
		removeRiderButton.click();
		sleepBySec(4);
		CommonUtility.waitForPageLoadNew(driver, removeRiderPopup, 20);
		validateNew(removeRiderPopup);
		validateNew(removeRiderButtonOnPopup);
		removeRiderButtonOnPopup.click();
		sleepBySec(20);

		int numberOfAddRiderButtonsAfterremovingRider = addRiderButton.size();

		System.out.println(numberOfAddRiderButtonsAfterremovingRider);
		if (numberOfAddRiderButtonsAfterremovingRider == numberOfAddRiderButtons + 1)
			Assert.assertTrue("Add and remove Rider is successfully done",true);
		else
			Assert.assertFalse("Add and remove Rider is not successfully done",true);

	}
	public void validate_locateapharmacysection1() {
		validate(locateapharmacysection);
		System.out.println("Pharmacy locator text is seen");
		validate(locateapharmacybutton);
		System.out.println("*******Pharmacy locator button is seen ==>"+locateapharmacybutton.isDisplayed());
	}


	public void validateOfficeVisitssectionWidget() {
		sleepBySec(2);
		try {
			feebackpopupClose();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-100)", "");
			validateNew(OfficeVisits);
			validateNew(pcpValue);
			validateNew(specialistValue);
		} catch (Exception e) {
		}
	}

	/*
	 * this method checks that Plan Benefits Summary Sub Navigation Link 
	 * under Benefits and Coverage is NOT displayed. This method is very useful when
	 * element is available in DOM but element is not displayed on UI
	 */ 
	public void validatePlanBenefitsSummarySubNavNotDisplayed() throws InterruptedException 
	{
		System.out.println("Now checking for Plan Benefits Summary sub navigation of Benefits and Coverage");
		Dimension size = driver.findElement(By.id("benefitssummary")).getSize();
		System.out.println(size);
		int height = size.getHeight();
		System.out.println("Height is "+height);
		int width = size.getWidth();
		System.out.println("Width is "+width);
		if (height == 0)
		{
			System.out.println("Plan Benefits Summary Sub Navigation Link under Benefits and Coverage was NOT displayed");
		}
		else 
		{
			System.out.println("Plan Benefits Summary Sub Navigation Link under Benefits and Coverage was displayed, Test step is failed due to it");
			Assert.fail("Plan Benefits Summary Sub Navigation Link under Benefits and Coverage was displayed, Test step is failed due to it");       
		}
	}              

	/*
	 * this method checks that Plan Documents and Resources Sub Navigation Link 
	 * under Benefits and Coverage is NOT displayed
	 */
	public void validatePlanDocumentsResourcesSubNavNotDisplayed() throws InterruptedException 
	{
		System.out.println("Now checking for Plan Documents and Resources sub navigation of Benefits and Coverage");
		Dimension size = driver.findElement(By.id("formsandresourcesC1")).getSize();
		System.out.println(size);
		int height = size.getHeight();
		System.out.println("Height is "+height);
		int width = size.getWidth();
		System.out.println("Width is "+width);
		if (height == 0)
		{
			System.out.println("Plan Documents and Resources Sub Navigation Link under Benefits and Coverage was NOT displayed");
		}
		else 
		{
			System.out.println("Plan Documents and Resources Sub Navigation Link under Benefits and Coverage was displayed, Test step is failed due to it");
			Assert.fail("Plan Documents and Resources Sub Navigation Link under Benefits and Coverage was displayed, Test step is failed due to it");             
		}
	} 

	/*
	 * this method checks that Order Plan Materials Sub Navigation Link 
	 * under Benefits and Coverage is NOT displayed
	 */
	public void validateOrderPlanMaterialsSubNavNotDisplayed()
	{
        
        System.out.println("Now checking for Order Plan Materials sub navigation of Benefits and Coverage");

        Dimension size = driver.findElement(By.id("ordermaterials")).getSize();
        System.out.println(size);
        int height = size.getHeight();
        System.out.println("Height is "+height);
        int width = size.getWidth();
        System.out.println("Width is "+width);
        if (height == 0)
        {
                       System.out.println("Order Plan Materials Sub Navigation Link under Benefits and Coverage was NOT displayed");
        }

        else 
        {
                       System.out.println("Order Plan Materials Sub Navigation Link under Benefits and Coverage was displayed, Test step is failed due to it");
                       Assert.fail("Order Plan Materials Sub Navigation Link under Benefits and Coverage was displayed, Test step is failed due to it");       
        }

}

	public void verifyCorrectMessageForPreEffectiveMembers() throws InterruptedException 
	{
		CommonUtility.waitForPageLoadNew(driver, viewPlanDocsBtn, 20);
		System.out.println("View Plan Documents button was displayed");
		System.out.println("Now checking for message on Benefits and Coverage Page for Pre-effective members");
		System.out.println("The message displayed on screen is "+messageForPreeffective.getText());
		if(!messageForPreeffective.getText().contains("When your plan starts,"))
			Assert.fail("Correct message is not displayed");
	}

	public void verifyCorrectTechSupportNumberForPreEffectiveMembers(String technicalPhNo) throws InterruptedException 
	{
		System.out.println("Now checking for Tech Support Number for Pre-effective members");
		System.out.println("The Tech Support phone number displayed on screen is "+preEffectiveTechSupportNumber.getText());
		System.out.println("Expected Tech Support phone number from feature file is "+technicalPhNo);
		Assert.assertEquals(preEffectiveTechSupportNumber.getText(),technicalPhNo);
		System.out.println("Assert for correct Tech Suppport Phone Number  was passed");

	}

	public void verifyClaimSupportSupportNumberNOTDisplayedForSHIPPreEffectiveMembers() throws InterruptedException 
	{
		System.out.println("Now checking for Claim Support Number for SHIP Pre-effective members");
		try {
			preEffectiveClaimsSupportNumber.isDisplayed();                            	  
			System.out.println("Claim Support Number for SHIP Pre-effective members was displayed");
			Assert.fail("Claim Support Number for SHIP Pre-effective members was displayed, Test step is failed due to it");
		} catch (Exception e) {
			System.out.println("Claim Support Number for SHIP Pre-effective members was NOT displayed, Test step is passed due to it");
		}

	}

	public void verifyClaimSupportSupportHeaderInNeedHelpNOTDisplayedForSHIPPreEffectiveMembers() throws InterruptedException 
	{
		System.out.println("Now checking for Claim Support Header in Need Help Section for SHIP Pre-effective members");
		try {
			preEffectiveClaimsSupportHeader.isDisplayed();
			System.out.println("Claim Support Header in Need Help Section for SHIP Pre-effective members was displayed");
			Assert.fail("Claim Support Header in Need Help Sectionr for SHIP Pre-effective members was displayed, Test step is failed due to it");
		} catch (Exception e) {
			System.out.println("Claim Support Header in Need Help Section for SHIP Pre-effective members was NOT displayed, Test step is passed due to it");
		}

	}


	public void verifyPresenceOfJumpLinksMAPD(String rider, String planType, String memberType) {
		CommonUtility.waitForPageLoad(driver, logoImage, 15);
		Assert.assertTrue("jmpLinkToMedicalCopaysOrCoinsurance isn't displayed",
				getJmpLinkToMedicalCopaysOrCoinsurance().isDisplayed());
		Assert.assertTrue("jmpLinkToOutofPocketMaximum isn't displayed",
				getJmpLinkToOutofPocketMaximum().isDisplayed());
		Assert.assertTrue("jmpLinkToPrimaryCareProvider isn't displayed",
				getJmpLinkToPrimaryCareProvider().isDisplayed());
		if (rider.toString().trim().equals("Rider"))
			Assert.assertTrue("jmpLinkToPrimaryCareProvider isn't displayed",
					getJmpLinkToOptionalServicesRiders(planType).isDisplayed());
		Assert.assertTrue("jmpLinkToDrugCopaysAndDiscounts isn't displayed",
				getJmpLinkToDrugCopaysAndDiscounts().isDisplayed());

		if (memberType.equalsIgnoreCase("Individual")) {
			Assert.assertTrue("jmpLinkToDrugCoverage isn't displayed", getJmpLinkToDrugCoverage().isDisplayed());
			Assert.assertTrue("jmpLinkToPlanDocumentsAndResources isn't displayed",
					getJmpLinkToPlanDocumentsAndResources().isDisplayed());
		} else {
			Assert.assertTrue("jmpLinkToDrugCoverage isn't displayed", getJmpLinkToadditionalBenefits().isDisplayed()); // for
			// group
			// member
			Assert.assertTrue("jmpLinkToDrugCoverage isn't displayed",
					getJmpLinkToPlanDocumentsAndResourcesMAPDGroup().isDisplayed());
		}
		System.out.println("All Jump links are displayed for the MAPD Plan");
	}

	// For MA Plan
	public void verifyPresenceOfJumpLinksMA(String rider, String planType, String memberType) {
		CommonUtility.waitForPageLoad(driver, logoImage, 15);
		Assert.assertTrue("jmpLinkToMedicalCopaysOrCoinsurance isn't displayed",
				getJmpLinkToMedicalCopaysOrCoinsuranceMA(memberType).isDisplayed());
		Assert.assertTrue("jmpLinkToOutofPocketMaximum isn't displayed",
				getJmpLinkToOutofPocketMaximumMA(memberType).isDisplayed());
		Assert.assertTrue("jmpLinkToPrimaryCareProvider isn't displayed",
				getJmpLinkToPrimaryCareProviderMA(memberType).isDisplayed());
		if (rider.toString().trim().equals("Rider"))
			Assert.assertTrue("jmpLinkToPrimaryCareProvider isn't displayed",
					getJmpLinkToOptionalServicesRiders(planType).isDisplayed());
		Assert.assertTrue("jmpLinkToDrugCopaysAndDiscounts isn't displayed",
				getJmpLinkToPlanDocumentsAndResourcesMA(memberType).isDisplayed());
		/*
		 * Assert.assertTrue("jmpLinkToDrugCoverage isn't displayed",
		 * getJmpLinkToDrugCoverage().isDisplayed());
		 * Assert.assertTrue("jmpLinkToPlanDocumentsAndResources isn't displayed",
		 * getJmpLinkToPlanDocumentsAndResources().isDisplayed());
		 */
		System.out.println("All Jump links are displayed for the MA Plan");
	}

	// MedSupp
	public void verifyPresenceOfJumpLinksMedSupp(String rider, String planType, String memberType) {
		CommonUtility.waitForPageLoad(driver, logoImage, 15);
		Assert.assertTrue("jmpLinkToMedicalCopaysOrCoinsurance isn't displayed",
				getJmpLinkToBenefitSummaryMedSupp().isDisplayed());
		Assert.assertTrue("jmpLinkToOutofPocketMaximum isn't displayed",
				getJmpLinkToDiscountsAndServicesMedSupp().isDisplayed());
		Assert.assertTrue("jmpLinkToPrimaryCareProvider isn't displayed",
				getJmpLinkToPlanDocumentsAndResourcesMedSupp().isDisplayed());
		System.out.println("All Jump links are displayed for the MedSupp Plan");
	}

	// PDP
	public void verifyPresenceOfJumpLinksPDP(String rider, String planType, String memberType, String Identifier) {
		CommonUtility.waitForPageLoad(driver, logoImage, 15);

		if (Identifier.contains("UHC")) {
			Assert.assertTrue("jmpLinkToMedicalCopaysOrCoinsurance isn't displayed",
					getJmpLinkToDrugCopaysAndDiscountsPDPUHC().isDisplayed());

			Assert.assertTrue("jmpLinkToMedicalCopaysOrCoinsurance isn't displayed",
					getJmpLinkToPlanDocumentsAndResourcesPDPUHC().isDisplayed());
		} else {
			Assert.assertTrue("jmpLinkToMedicalCopaysOrCoinsurance isn't displayed",
					getJmpLinkToDrugCopaysAndDiscountsPDP().isDisplayed());
			Assert.assertTrue("JmpLinkToDrugCoveragePDP isn't displayed", getJmpLinkToDrugCoveragePDP().isDisplayed());
			Assert.assertTrue("JmpLinkToPlanDocumentsAndResourcesPDP isn't displayed",
					getJmpLinkToPlanDocumentsAndResourcesPDP().isDisplayed());
			Assert.assertTrue("JmpLinkToWaysToSaveMoneyPDP isn't displayed",
					getJmpLinkToWaysToSaveMoneyPDP().isDisplayed());
		}
		System.out.println("All Jump links are displayed for the PDP Plan");
	}

	// SSUP
	public void verifyPresenceOfJumpLinksSSUP(String rider, String planType, String memberType) {
		CommonUtility.waitForPageLoad(driver, logoImage, 15);
		Assert.assertTrue("jmpLinkToMedicalCopaysOrCoinsurance isn't displayed",
				getJmpLinkToMedicalCopaysOrCoinsuranceSSUP().isDisplayed());
		Assert.assertTrue("jmpLinkToOutofPocketMaximum isn't displayed",
				getJmpLinkToOutofPocketMaximumSSUP().isDisplayed());
		Assert.assertTrue("jmpLinkToPrimaryCareProvider isn't displayed",
				getJmpLinkToPrimaryCareProviderSSUP().isDisplayed());
		Assert.assertTrue("jmpLinkToDrugCopaysAndDiscounts isn't displayed",
				getJmpLinkToPlanDocumentsAndResourcesSSUP().isDisplayed());
		System.out.println("All Jump links are displayed for SSUP Plan");
	}
	// SSUP ends here


	public boolean ValidatePDFTextSection() {
		sleepBySec(5);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,2900)", "");
		System.out.println("Page scrolled down");
		sleepBySec(2);
		if(PDFUpdatedText.getText().contains("Updated"))
		{                     
			Assert.assertTrue("The UpdatedText is present", true);
			return true;
		} else {
			Assert.assertFalse("The UpdatedText is not present", true);
			return false;
		}
	}


	public boolean ValidateBnCNoDeductible() {
		sleepBySec(5);
		boolean Validation_Flag = true;
		if(validate(MedicalDeductibleCard1)){
			if(!NoDeductible1Text.getText().contains("$")){
				System.out.println("No $ Amount is displayed for Member with No Deductible");
				System.out.println("Text displayed in Deductible1 Card : "+NoDeductible1Text.getText());
				Validation_Flag = true;
			}
			else{
				System.out.println("Validation Failed -  $ Amount is displayed for Member with No Deductible");
				System.out.println("Text displayed in Deductible1 Card : "+NoDeductible1Text.getText());
				Validation_Flag = false;
			}
		}
		else{
			System.out.println("Validation Failed - Medical Deductible Card is NOT Displayed for Group MA/MAPD Member");
			Validation_Flag = false;
		}
		return Validation_Flag;
	}


	public boolean ValidateBnCSingleDeductible(String deductibleAmount1) {
		sleepBySec(5);
		boolean Validation_Flag = true;
		if(validate(MedicalDeductibleCard1)){
			if(Deductible1Text.getText().contains(deductibleAmount1)){
				System.out.println("Expected $ Amount "+deductibleAmount1+" is displayed for Member with Single Deductible");
				System.out.println("Text displayed in Deductible1 Card : "+Deductible1Text.getText());
				Validation_Flag = true;
			}
			else{
				System.out.println("Validation Failed -  Expected Deductible Amount is NOT displayed for Member with Single Deductible");
				System.out.println("Text displayed in Deductible1 Card : "+Deductible1Text.getText());
				Validation_Flag = false;
			}
		}
		else{
			System.out.println("Validation Failed - Medical Deductible Card is NOT Displayed for Group MA/MAPD Member");
			Validation_Flag = false;
		}
		return Validation_Flag;
	}


	public boolean ValidateBnC_DualDeductible(String deductibleAmount1, String deductibleAmount2) {
		sleepBySec(5);
		boolean Validation_Flag = true;
		if(validate(MedicalDeductibleCard1) && validate(MedicalDeductibleCard2) ){
			if(Deductible1Text.getText().contains(deductibleAmount1) && Deductible2Text.getText().contains(deductibleAmount2)){
				System.out.println("Expected $ Amount "+deductibleAmount1+" AND "+deductibleAmount2+" is displayed for Member with Dual Deductible");
				System.out.println("Text displayed in Deductible1 Card : "+Deductible1Text.getText());
				System.out.println("Text displayed in Deductible2 Card : "+Deductible2Text.getText());
				Validation_Flag = true;
			}
			else{
				System.out.println("Validation Failed -  Expected Deductible Amount is NOT displayed for Member with Dual Deductible");
				System.out.println("Text displayed in Deductible1 Card : "+Deductible1Text.getText());
				System.out.println("Text displayed in Deductible2 Card : "+Deductible2Text.getText());
				Validation_Flag = false;
			}
		}
		else{
			System.out.println("Validation Failed - Both Medical Deductible Card is NOT Displayed for Group MA/MAPD Member with Dual Deductible");
			Validation_Flag = false;
		}
		return Validation_Flag;
	}

	/**
	 * Validate the Access your Drug Benefits 
	 * @return
	 */
	public boolean validateAccessDrugsBenfitsBlock() {
		boolean bAccessDrugsBenfitsBlockValidation = true;
		if(validateNew(accessDrugsBenfitsBlock) && validate(accessDrugsBenfitsBlockHeader) && validate(accessDrugsBenfitsBlockExpressScriptsLink)){
			bAccessDrugsBenfitsBlockValidation = true;
		}else
			bAccessDrugsBenfitsBlockValidation = false;
		return bAccessDrugsBenfitsBlockValidation;
	}

	/**
	 * Validate the Access your Drug Benefits 
	 * @return
	 */
	public boolean validateSiteLeavingPopUp() {
		boolean bAccessDrugsBenfitsBlockValidation = true;
		if(validate(siteLeavingPopUp)){
			bAccessDrugsBenfitsBlockValidation = true;
		}else
			bAccessDrugsBenfitsBlockValidation = false;
		return bAccessDrugsBenfitsBlockValidation;
	}

	/**
	 * Validate the Access your Drug Benefits 
	 * @return
	 */
	public boolean validateSiteLeavingPopUpCancelFlow() {
		accessDrugsBenfitsBlockExpressScriptsLink.click();
		waitforElement(siteLeavingPopUp);
		boolean bAccessDrugsBenfitsBlockValidation = false;
		jsClickNew(siteLeavingPopUpCancelBtn);
		if(driver.findElements(By.cssSelector("div.siteleaving-popup-footer>div")).size()>0){
			bAccessDrugsBenfitsBlockValidation = true;
		}else
			bAccessDrugsBenfitsBlockValidation = false;
		return bAccessDrugsBenfitsBlockValidation;
	}

	/**
	 * Validate the Access your Drug Benefits 
	 * @return
	 */
	public boolean validateSiteLeavingPopUpProceedFlow() {
		accessDrugsBenfitsBlockExpressScriptsLink.click();
		waitforElement(siteLeavingPopUp);
		boolean bAccessDrugsBenfitsBlockValidation = true;
		jsClickNew(siteLeavingPopUpProceedBtn);
		if(driver.getWindowHandles().size()>0) {
			bAccessDrugsBenfitsBlockValidation=true;
			Assert.assertTrue(driver.getWindowHandles().size()>0);
		}else {
			bAccessDrugsBenfitsBlockValidation=false;
		}
		return bAccessDrugsBenfitsBlockValidation;
	}

	public void validate_provider_search_link() {
		driver.navigate().to("https://stage-mymedicareaccount.uhc.com/pcp/member/benefits/overview.html");
		waitforElement(providersearchlink);
		validateNew(providersearchlink);

		String ParentWindow = driver.getTitle();
		providersearchlink.click();
		sleepBySec(60);
		Set<String> handles1 = driver.getWindowHandles();
		for (String windowHandle : handles1) {
			if (!windowHandle.equals(ParentWindow)) {
				driver.switchTo().window(windowHandle);
				String title = driver.getTitle();
				System.out.println("Window title is : " + title);
				if (title.contains("Medical | Find Care")) {
					System.out.println("user is on provider search page");							
					break;
				}
			} else {
				System.out.println("Not found Expected window");
				driver.switchTo().window(ParentWindow);
			}

		}

	}

	public void validatedrugcosttableMAPDLIS4() {
		CommonUtility.waitForPageLoad(driver, RetailDrugCost_Table, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RetailDrugCost_Table);

		if(RetailDrugCost_Table.getText().contains("Annual Deductible Stage")&&RetailDrugCost_Table.getText().contains("Initial Coverage Stage")){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}

	}
	public void validatedrugcosttablePDPLIS3() {
		CommonUtility.waitForPageLoad(driver, RetailDrugCost_Table, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RetailDrugCost_Table);
		validateWithValue("Drug cost table is diplaying for MAPD GROUP LIS 4", RetailDrugCost_Table);
		String mapdGroupTable= "Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Covered Generic Drugs\n"
				+"No Deductible\n"
				+"$0.00\n"
				+"$0.00\n"
				+"All Other Covered Drugs\n"
				+"$0.00\n"
				+"$0.00";
		System.out.println("the hardcoded value" +mapdGroupTable);
		System.out.println("the hardcoded value" +RetailDrugCost_Table.getText());
		if(RetailDrugCost_Table.getText().equals(mapdGroupTable.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>>>>>The Expected Table  value is<<<<<<<<<<<<<<<<< \n" +mapdGroupTable);
			System.out.println(">>>>>>>>>>>>>The Actual Table value is<<<<<<<<<<<<<<<<<<<< \n" +RetailDrugCost_Table.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}

	}

	public void validatedrugcosttableMAPD_NONLIS() {
		CommonUtility.waitForPageLoad(driver, RetailDrugCost_TableNONLIS, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RetailDrugCost_TableNONLIS);
		validateWithValue("Drug cost table is diplaying for MAPD GROUP NON LIS USER", RetailDrugCost_TableNONLIS);
		String mapdGroupTable= "Additional Drug Coverage\n"
				+"Annual Deductible Stage \n"
				+"Initial Coverage Stage \n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage \n"
				+"Tier 1 \n"
				+"No Deductible\n"
				+"$3.00\n"
				+"$3.00\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2 \n"
				+"$28.00\n"
				+"You pay 25% of the total cost for generic drugs and 25% of the cost (plus a portion of the dispensing fee) for brand name drugs.\n"
				+"Tier 3 \n"
				+"$55.00\n"
				+"Tier 4 \n"
				+"$55.00";
		if(RetailDrugCost_TableNONLIS.getText().equals(mapdGroupTable.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>>>>>The Expected Table  value is<<<<<<<<<<<<<<<<< \n"+mapdGroupTable.toString());
			System.out.println(">>>>>>>>>>>>>The Actual Table value is<<<<<<<<<<<<<<<<<<<< \n"+RetailDrugCost_TableNONLIS.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}

	}


	public void validatedrugcosttablePDPGroupLIS1() {
		CommonUtility.waitForPageLoad(driver, RetailDrugCost_Table, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RetailDrugCost_Table);
		validateWithValue("Drug cost table is diplaying for PDP GROUP LIS 1", RetailDrugCost_Table);
		String mapdGroupTable= "Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Covered Generic Drugs\n"
				+"$0.00\n"
				+"$3.60\n"
				+"$0.00\n"
				+"All Other Covered Drugs\n"
				+"$8.95\n"
				+"$0.00";

		if(RetailDrugCost_Table.getText().equals(mapdGroupTable.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else {
			System.out.println(">>>>>>>>>>>>>The Expected Table  value is<<<<<<<<<<<<<<<<<"+mapdGroupTable.toString());
			System.out.println(">>>>>>>>>>>>>The Actual Table value is<<<<<<<<<<<<<<<<<<<<"+RetailDrugCost_Table.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}

	}
	public void validatedrugcosttablePDPGroup_NONLIS() {
		CommonUtility.waitForPageLoad(driver, RetailDrugCost_TableNONLIS, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RetailDrugCost_TableNONLIS);
		validateWithValue("Drug cost table is diplaying for MAPD GROUP LIS 4", RetailDrugCost_TableNONLIS);
		String mapdGroupTable= "Additional Drug Coverage\n"
				+"Annual Deductible Stage \n"
				+"Initial Coverage Stage \n"
				+"Coverage Gap Stage \n"
				+"Catastrophic Coverage Stage \n"
				+"Tier 1 \n"
				+"No Deductible\n"
				+"$10.00\n"
				+"$10.00\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2 \n"
				+"$20.00\n"
				+"$20.00\n"
				+"Tier 3\n"
				+"$35.00\n"
				+"$35.00\n"
				+"Tier 4\n"
				+"$35.00\n"
				+"$35.00";

		if(RetailDrugCost_TableNONLIS.getText().equals(mapdGroupTable.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>>>>>The Expected Table  value is<<<<<<<<<<<<<<<<<"+mapdGroupTable.toString());
			System.out.println(">>>>>>>>>>>>>The Actual Table value is<<<<<<<<<<<<<<<<<<<<"+RetailDrugCost_TableNONLIS.getText());
			System.err.println(">>>>>>>>Problem<<<<<<<<<<<<<<<The data in the drug cost table is not displaying correctly<<<<<<<<<<<<<");
			Assert.fail(">>>>>>>>Problem<<<<<<<<<<<<<<<The data in the drug cost table is not displaying correctly<<<<<<<<<<<<<<<<<<<<<");
		}
	}

	public void validatedrugcosttablePDPIndi_NONLIS() throws InterruptedException {
		preferredRetailBenefitTableIndipdp();
		preferredMailBenefitTableIndipdp();
		standardRetailBenefitTableIndipdp3();
	}

	public void preferredRetailBenefitTableIndipdp(){
		CommonUtility.waitForPageLoad(driver, preferredRetailBenefitTableIndipdp, 15);
		validateWithValue("Drug cost table", preferredRetailBenefitTableIndipdp);
		String TableData= "Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No deductible.\n"
				+"$0.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2\n"
				+"$5.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 3\n"
				+"100% until the $435.00 deductible is met.*\n"
				+"$40.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 4\n"
				+"32%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 5\n"
				+"25%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"*Once you reach the Coverage Gap Stage, you pay co-pays or co-insurance defined by your plan for all Tier 1 through Tier 5 drugs regardless of whether your full deductible has been met.";

		if(preferredRetailBenefitTableIndipdp.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>>>>>>>>>>>The Expected table value is-<<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is-<<<<<<<<<<<<<   \n"+preferredRetailBenefitTableIndipdp.getText());

			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
		validateWithValue("Preferred Retail Pharmacy Drug Costs Text", PreferredRetailPharmacyDrugCostsText);
		validateWithValue("Preferred Retail Pharmacy DrugCosts Text Line", PreferredRetailPharmacyDrugCostsTextLinePDP);
	}
	
	public void preferredMailBenefitTableIndipdp() throws InterruptedException{
		scrollToView(drugCostDropdown);
		Select drugCostdropdwn = new Select(drugCostDropdown);
		drugCostdropdwn.selectByVisibleText("Preferred Mail Service Pharmacy");

		CommonUtility.waitForPageLoad(driver, preferedMail_Table1PDP, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", preferedMail_Table1PDP);
		validateWithValue("Drug cost table is diplaying for MAPD GROUP LIS 4", preferedMail_Table1PDP);
		String TableData= "Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No deductible.\n"
				+"$0.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2\n"
				+"$15.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 3\n"
				+"100% until the $435.00 deductible is met.*\n"
				+"$120.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 4\n"
				+"32%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 5\n"
				+"25%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"*Once you reach the Coverage Gap Stage, you pay copays or coinsurance defined by your plan for all Tier 1 through Tier 5 drugs regardless of whether your full deductible has been met.";

		if(preferedMail_Table1PDP.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>>>>>The Expected Table  value is<<<<<<<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+preferedMail_Table1PDP.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
		validateWithValue("Preferred Mail Service Pharmacy Drug Costs", PreferredMailServicePharmacyDrugCostsText);
		validateWithValue("Preferred Mail Service Pharmacy Drug Costs Text Line", PreferredMailServicePharmacyDrugCostsTextLinePDP);
	}

	public void standardRetailBenefitTableIndipdp3() throws InterruptedException{
		Select drugCostdropdwn = new Select(drugCostDropdown);
		drugCostdropdwn.selectByVisibleText("Standard Retail Pharmacy");
		String TableData= "Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No Deductible\n"
				+"$15.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2\n"
				+"$20.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 3\n"
				+"$435.00\n"
				+"$47.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 4\n"
				+"33%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 5\n"
				+"25%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"*Once you reach the Coverage Gap Stage, you pay copays or coinsurance defined by your plan for all Tier 1 through Tier 5 drugs regardless of whether your full deductible has been met.";

		if(standardDetail_Table1PDP.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>>>>>The Expected Table  value is<<<<<<<<<<<<<<<<<< \n- "+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+standardDetail_Table1PDP.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
		validateWithValue("Standard Network Pharmacy Retail Drug Text", StandardNetworkPharmacyRetailDrugCostsText);
		validateWithValue("Standard Network Pharmacy Retail Drug Text Line", StandardNetworkPharmacyRetailDrugCostsTextLinePDP);
	}

	public void validatevillagetabletext() throws InterruptedException{
		CommonUtility.waitForPageLoad(driver, RetailDrugCost_TableNONLIS, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RetailDrugCost_TableNONLIS);
		validateWithValue("Drug cost table is diplaying for MAPD GROUP LIS 4", RetailDrugCost_TableNONLIS);
		String TableData= "Additional Drug Coverage\n"
				+"Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No Deductible\n"
				+"$3.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2\n"
				+"$10.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs \n"
				+"Tier 3\n"
				+"$45.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 4\n"
				+"$95.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 5\n"
				+"33%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs";

		if(RetailDrugCost_TableNONLIS.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{

			System.out.println(">>>>>>>>>>>>>The Expected Table  value is<<<<<<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+RetailDrugCost_TableNONLIS.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
		validateWithValue("Standard Network Pharmacy Retail Drug Text", StandardNetworkPharmacyRetailDrugCostsText);
		validateWithValue("Standard Network Pharmacy Retail Drug Text Line", StandardNetworkPharmacyRetailDrugCostsTextLineVellage);
	}

	public void validatevillageCopaySection() throws InterruptedException{
		officeVisitSection();
		hospitalVisitSection();
		outPatientSection();
		inNetworkSection();
		outNetworkSection();
	}

	public void officeVisitSection(){
		String TableData= "OFFICE VISITS \n"
				+"Primary care provider:\n"
				+"$0.00\n\n"

+"Specialist:\n"
+"$25.00";

		if(officeVisitSection.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the Office visit section is displaying correctly", true);
			System.out.println("The data in the Office visit section  is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>The Expected value is<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual value is- <<<<<<<<<<<<< \n"+officeVisitSection.getText());
			System.err.println("The data in the Office visit section  is not displaying correctly");
			Assert.fail("The data in the Office visit section is not displaying correctly");
		}
	}
	
	public void hospitalVisitSection(){
		String TableData= "INPATIENT HOSPITAL CARE\n"
				+"days 1 - 8 : $150.00 Copay per day\n"
				+"days 9 - 90 : $0.00 Copay per day";
	

		if(hospitalVisitSection.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the hospital Visit Section is displaying correctly", true);
			System.out.println("The data in the hospital Visit Section  is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>The Expected table value is<<<<<<<<<<<<- \n"+TableData.toString());
			System.out.println(">>>>>>>>>>The Actual table value is<<<<<<<<<<<<<- \n"+hospitalVisitSection.getText());
			System.err.println(">>>>>>>>>>>The data in the hospital Visit Section  is not displaying correctly<<<<<<<<<");
			Assert.fail(">>>>>>>>>>>>>>>>>>The data in the hospital Visit Section is not displaying correctly<<<<<<<<<<");
		}
	}


	public void outPatientSection(){
		String TableData="OUTPATIENT HOSPITAL SERVICES (INCLUDES AMBULATORY SERVICES)\n"
				+"Type 1: $0.00 - $100.00\n"
				+"Type 2:  $0.00 - $150.00";
		if(outPatientSection.getText().contains(TableData.toString())){
			Assert.assertTrue("The data in the outPatient section is displaying correctly", true);
			System.out.println("The data in the outPatient section  is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>The Expected table value is<<<<<<<<<<<<- \n"+TableData.toString());
			System.out.println(">>>>>>>>>>The Actual table value is<<<<<<<<<<<<<- \n"+outPatientSection.getText());
			System.err.println(">>>>>>>>>>>>>>>The data in the outPatient section  is not displaying correctly<<<<<<<<<<<<<<");
			Assert.fail(">>>>>>>>>>>>>>>>>>>>>The data in the outPatient section is not displaying correctl<<<<<<<<<<<<<<<<<<");
		}
	}

	public void inNetworkSection(){
		String TableData= "IN-NETWORK\n"
				+"$3,400.00";
		

		if(inNetworkSection.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the InNetwork section is displaying correctly", true);
			System.out.println("The data in the InNetwork section  is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>The Expected table value is<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+inNetworkSection.getText());
			System.err.println(">>>>>>>>>>>>>>>>>>>>The data in the InNetwork section  is not displaying correctly<<<<<<<<<<<<<");
			Assert.fail(">>>>>>>>>>>>>>>>>>>>>>>The data in the InNetwork Section is not displaying correctly<<<<<<<<<<");
		}
	}

	public void outNetworkSection(){
		String TableData= "OUT-OF-NETWORK\n"

+"$7,500.00";
		

		if(outNetworkSection.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the out Network Section is displaying correctly", true);
			System.out.println("The data in the out Network Section  is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>The Expected value is<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual value is- <<<<<<<<<<<<< \n"+outNetworkSection.getText());
			System.err.println(">>>>>>>>>>>>>>>>>>The data in the Oout Network Section  is not displaying correctly<<<<<<<<<");
			Assert.fail(">>>>>>>>>>>>>>>>>>>>The data in the out Network Section is not displaying correctly<<<<<<<<<<<<<<<<<");
		}
	}

	public void validatePeehiptableValues(){
		String TableData= "Annual Deductible Stage Initial Coverage Stage Coverage Gap Stage Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No Deductible\n"
				+"$6.00\n"
				+"$6.00\n"
				+"Your share of the cost for a covered drug will be either co-insurance or a copay, whichever is the lesser amount between:\n"
				+"either — $6.00\n"
				+"or — 5% co-insurance on the cost of the drug OR a co-pay of $3.40 for a generic drug or a drug that is treated like a generic and $8.50 for all other drugs, whichever is the larger amount.\n"
				+"Tier 2\n"
				+"$40.00\n"
				+"$40.00\n"
				+"Your share of the cost for a covered drug will be either co-insurance or a copay, whichever is the lesser amount between:\n"
				+"either — $40.00\n"
				+"or — 5% co-insurance on the cost of the drug OR a co-pay of $3.40 for a generic drug or a drug that is treated like a generic and $8.50 for all other drugs, whichever is the larger amount.\n"
				+"Tier 3\n"
				+"$60.00\n"
				+"$60.00\n"
				+"Your share of the cost for a covered drug will be either co-insurance or a copay, whichever is the lesser amount between:\n"
				+"either — $60.00\n"
				+"or — 5% co-insurance on the cost of the drug OR a co-pay of $3.40 for a generic drug or a drug that is treated like a generic and $8.50 for all other drugs, whichever is the larger amount.\n"
				+"Tier 4\n"
				+"$60.00\n"
				+"$60.00\n"
				+"Your share of the cost for a covered drug will be either co-insurance or a copay, whichever is the lesser amount between:\n"
				+"either — $60.00\n"
				+"or — 5% co-insurance on the cost of the drug OR a co-pay of $3.40 for a generic drug or a drug that is treated like a generic and $8.50 for all other drugs, whichever is the larger amount.";

		if(PeehipTable.getText().toString().equals(TableData.toString())){
			Assert.assertTrue("The data in the table is displaying correctly", true);
			System.out.println("The data in the table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>The Expected table value is<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+PeehipTable.getText());

			System.err.println("The data in the table is not displaying correctly");
			Assert.fail("The data in the table is not displaying correctly");
		}
	}

	public void validategroupdrugtableMAPD() throws InterruptedException{
		standardRetailBenefitTableIndiMAPD();
		preferredMailBenefitTableIndiMAPD();
	}

	public void standardRetailBenefitTableIndiMAPD() throws InterruptedException{
		Select drugCostdropdwn = new Select(drugCostDropdown);
		drugCostdropdwn.selectByVisibleText("Standard Retail Pharmacy");

		String TableData="Annual Deductible Stage\n"
				+"Initial Coverage Stage\n" 
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No Deductible\n"
				+"$3.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2\n"
				+"$10.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 3\n"
				+"$150.00\n"
				+"$45.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 4\n"
				+"$95.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 5\n"
				+"30%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"*Once you reach the Coverage Gap Stage, you pay copays or coinsurance defined by your plan for all Tier 1 through Tier 5 drugs regardless of whether your full deductible has been met.";

		if(standardDetail_Table1PDP.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>The Expected table value is<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+standardDetail_Table1PDP.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
		validateWithValue("Standard Network Pharmacy Retail Drug Text", StandardNetworkPharmacyRetailDrugCostsText);
		validateWithValue("Standard Network Pharmacy Retail Drug Text Line", StandardNetworkPharmacyRetailDrugCostsTextLine);
	}

	public void preferredMailBenefitTableIndiMAPD() throws InterruptedException{
		Select drugCostdropdwn = new Select(drugCostDropdown);
		drugCostdropdwn.selectByVisibleText("Preferred Mail Service Pharmacy");

		CommonUtility.waitForPageLoad(driver, preferedMail_Table1PDP, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", preferedMail_Table1PDP);
		validateWithValue("Drug cost table", preferedMail_Table1PDP);
		String TableData= "Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No deductible.\n"
				+"$0.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2\n"
				+"$0.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 3\n"
				+"100% until the $150.00 deductible is met.*\n"
				+"$125.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 4\n"
				+"$275.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 5\n"
				+"30%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"*Once you reach the Coverage Gap Stage, you pay copays or coinsurance defined by your plan for all Tier 1 through Tier 5 drugs regardless of whether your full deductible has been met.";

		if(preferedMail_Table1PDP.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>The Expected table value is<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+preferedMail_Table1PDP.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
		validateWithValue("Preferred Mail Service Pharmacy Drug Costs", PreferredMailServicePharmacyDrugCostsText);
		validateWithValue("Preferred Mail Service Pharmacy Drug Costs Text Line", PreferredMailServicePharmacyDrugCostsTextLine);
	}

	public void validategroupdrugtableMedica() throws InterruptedException{
		standardRetailBenefitTableIndiMedica();
		preferredMailBenefitTableIndiMedica();
	}

	public void preferredMailBenefitTableIndiMedica() {
		Select drugCostdropdwn = new Select(drugCostDropdown);
		sleepBySec(2);
		drugCostdropdwn.selectByVisibleText("Preferred Mail Service Pharmacy");
		sleepBySec(2);

		CommonUtility.waitForPageLoad(driver, preferedMail_Table1PDP, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", preferedMail_Table1PDP);
		validateWithValue("Drug cost table is diplaying for MAPD GROUP LIS 4", preferedMail_Table1PDP);
		String TableData= "Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No Deductible\n"
				+"$0.00\n"
				+"$0.00\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2\n"
				+"$0.00\n"
				+"$0.00\n"
				+"Tier 3\n"
				+"$80.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 4\n"
				+"$185.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 5\n"
				+"33%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs";

		if(preferedMail_Table1PDP.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>The Expected table value is<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+preferedMail_Table1PDP.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
	}
	
	public void standardRetailBenefitTableIndiMedica() throws InterruptedException{
		Select drugCostdropdwn = new Select(drugCostDropdown);
		sleepBySec(2);
		drugCostdropdwn.selectByVisibleText("Standard Retail Pharmacy");
		sleepBySec(2);
		String TableData= "Additional Drug Coverage\n"
		        +"Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No Deductible\n"
				+"$0.00\n"
				+"$0.00\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2\n"
				+"$0.00\n"
				+"$0.00\n"
				+"Tier 3\n"
				+"$30.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 4\n"
				+"$65.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 5\n"
				+"33%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs";

		if(standardDetail_Table1PDP.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>The Expected table value is<<<<<<<<<<<< "+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+standardDetail_Table1PDP.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
	}


	public void validategroupdrugtablePCP() throws InterruptedException{
		standardRetailBenefitTableIndiPCP();
		preferredMailBenefitTableIndiPCP();
	}
	public void preferredMailBenefitTableIndiPCP() throws InterruptedException{
		Select drugCostdropdwn = new Select(drugCostDropdown);
		sleepBySec(2);
		drugCostdropdwn.selectByVisibleText("Preferred Mail Service Pharmacy");
		sleepBySec(2);

		CommonUtility.waitForPageLoad(driver, preferedMail_Table1PDP, 15);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", preferedMail_Table1PDP);
		validateWithValue("Drug cost table is diplaying for MAPD GROUP LIS 4", preferedMail_Table1PDP);
		String TableData= "Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No Deductible\n"
				+"$0.00\n"
				+"$0.00\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2\n"
				+"$0.00\n"
				+"$0.00\n"
				+"Tier 3\n"
				+"$131.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 4\n"
				+"$290.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 5\n"
				+"33%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs";

		if(preferedMail_Table1PDP.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>The Expected table value is<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+preferedMail_Table1PDP.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
	}

	public void standardRetailBenefitTableIndiPCP() throws InterruptedException{
		Select drugCostdropdwn = new Select(drugCostDropdown);
		sleepBySec(2);
		drugCostdropdwn.selectByVisibleText("Standard Retail Pharmacy");
		sleepBySec(2);
		String TableData= "Additional Drug Coverage\n"
		        +"Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Coverage Gap Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Tier 1\n"
				+"No Deductible\n"
				+"$0.00\n"
				+"$0.00\n"
				+"Your share of the cost for a covered drug will be either coinsurance or a copayment whichever is the larger amount:\n"
				+"-either- coinsurance of 5% of the cost of the drug\n"
				+"-or- $3.60 for a generic drug or a drug that is treated like a generic and $8.95 for all other drugs.\n"
				+"Tier 2\n"
				+"$5.00\n"
				+"$5.00\n"
				+"Tier 3\n"
				+"$47.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 4\n"
				+"$100.00\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs\n"
				+"Tier 5\n"
				+"33%\n"
				+"no more than 25% for generic drugs or 25% for brand name drugs";
		
		if(standardDetail_Table1PDP.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.out.println(">>>>>>>>>The Expected table value is<<<<<<<<<<<< \n"+TableData.toString());
			System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+standardDetail_Table1PDP.getText());
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
	}

	public void validatedrugcosttableMapdLIS() throws InterruptedException{
		Select drugCostdropdwn = new Select(drugCostDropdown);
		drugCostdropdwn.selectByVisibleText("Standard Retail Pharmacy");
		sleepBySec(2);
		String TableData= "Annual Deductible Stage\n"
				+"Initial Coverage Stage\n"
				+"Catastrophic Coverage Stage\n"
				+"Covered Generic Drugs\n"
				+"No Deductible\n"
				+"$3.60\n"
				+"$0.00\n"
				+"All Other Covered Drugs\n"
				+"$8.95\n"
				+"$0.00";
		System.out.println(">>>>>>>>>The Expected table value is<<<<<<<<<<<< \n"+TableData.toString());
		System.out.println(">>>>>>>>>>>>>>>>>>>The Actual table value is- <<<<<<<<<<<<< \n"+RetailDrugCost_Table.getText());

		if(RetailDrugCost_Table.getText().equals(TableData.toString())){
			Assert.assertTrue("The data in the drug cost table is displaying correctly", true);
			System.out.println("The data in the drug cost table is displaying correctly");  
		}
		else{
			System.err.println("The data in the drug cost table is not displaying correctly");
			Assert.fail("The data in the drug cost table is not displaying correctly");
		}
	}

	public void validatePrimaryCareProviderSection() {
		validateNew(PrimaryCareProviderHeaderInd,0);
		validateNew(YourPrimaryCareProvider,0);
		validateNew(ChangeYourPcpButton,0);
		validateNew(SearchProvider,0);
		validateNew(StartSearch,0);
	}
	
	public void navigateToSHIPTab() {
		TestHarness.checkForIPerceptionModel(driver);
		CommonUtility.waitForPageLoad(driver, ShipTab, 20);
		System.out.println("Now clicking on SHIP Plan Tab");
		try {
			ShipTab.click();
			CommonUtility.checkPageIsReadyNew(driver);
			Thread.sleep(4000);
		} catch (Exception e) {
			System.out.println("SHIP Plan Tab was not displayed");
			Assert.fail("SHIP Plan Tab was not displayed");
		}
	}

	public void navigateToSSUPTab() {
		TestHarness.checkForIPerceptionModel(driver);
		System.out.println("Now clicking on Group SSUP Plan Tab");
		try {
			SSUPTab.click();
			CommonUtility.checkPageIsReadyNew(driver);
			Thread.sleep(4000);
		} catch (Exception e) {
			System.out.println("SSUP Plan Tab was not displayed");
			Assert.fail("SSUP Plan Tab was not displayed");
		}
	}
}
