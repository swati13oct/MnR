package pages.regression.benefitandcoverage;


import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import pages.regression.formsandresources.FormsAndResourcesPage;
import pages.regression.payments.PaymentHistoryPage;
import pages.regression.testharness.TestHarness;
import pages.regression.drugcostestimator.DrugCostEstimatorPage;
/**
 * @Functionality : To check Benefits and Coverage page
 */
public class BenefitsAndCoverageBase extends BenefitsAndCoverageWebElements {

	public BenefitsAndCoverageBase(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	
	public void openAndValidate() {
	}
	
	public void clickPlanDocsAndResourcesTab(){
		formsAndResourcesTab.click();
		validateNew(docsAndResourcesHeader,0);
	}

	public void clickOrderMaterialsNavTab() {
		orderMaterialsTab.click();
		validateNew(orderMaterialsHeader,0);	
	}
	
	
	public void sleepBySec(int sec) {
		System.out.println("Sleeping for '"+sec+"' sec");
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void scrollElementToCenterScreen(WebElement element) {
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
		                                            + "var elementTop = arguments[0].getBoundingClientRect().top;"
		                                            + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
		((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
		System.out.println("TEST - move element to center view"); 
	}

	public void moveMouseToElement(WebElement targetElement) {
		Actions action = new Actions(driver);
		action.moveToElement(targetElement).build().perform(); 
	}

	public WebElement getLinkBackToTop_copy() {
		return linkBackToTop_copy;
	}

	public WebElement getJmpLinkToDrugCopaysAndDiscountsPDPUHC() {
		return jmpLinkToDrugCopaysAndDiscountsPDPUHC;
	}

	public WebElement getJmpLinkToPlanDocumentsAndResourcesPDPUHC() {
		return jmpLinkToPlanDocumentsAndResourcesPDPUHC;
	}

	public WebElement getJmpLinkToMedicalCopaysOrCoinsuranceSSUP() {
		return jmpLinkToMedicalCopaysOrCoinsuranceSSUP;
	}

	public WebElement getJmpLinkToOutofPocketMaximumSSUP() {
		return jmpLinkToOutofPocketMaximumSSUP;
	}

	public WebElement getJmpLinkToPrimaryCareProviderSSUP() {
		return jmpLinkToPrimaryCareProviderSSUP;
	}

	public WebElement getJmpLinkToPlanDocumentsAndResourcesSSUP() {
		return jmpLinkToPlanDocumentsAndResourcesSSUP;
	}

	public WebElement getPrimaryCareProviderSectionHeaderGroup() {
		return primaryCareProviderSectionHeaderGroup;
	}

	public WebElement getAdditionalBenefitsSectionHeader() {
		return additionalBenefitsSectionHeader;
	}

	public WebElement getJmpLinkToPlanDocumentsAndResourcesMAPDGroup() {
		return jmpLinkToPlanDocumentsAndResourcesMAPDGroup;
	}

	public WebElement getJmpLinkToadditionalBenefits() {
		return jmpLinkToadditionalBenefits;
	}

	public List<WebElement> getDirectorySectionPDP() {
		return directorySection;
	}

	public List<WebElement> getDirectorySectionSSUP() {
		return directorySection;
	}

	public WebElement getWaysToSaveMoneySectionHeader() {
		return waysToSaveMoneySectionHeader;
	}

	public WebElement getJmpLinkToDrugCopaysAndDiscountsPDP() {
		return jmpLinkToDrugCopaysAndDiscountsPDP;
	}

	public WebElement getJmpLinkToDrugCoveragePDP() {
		return jmpLinkToDrugCoveragePDP;
	}

	public WebElement getJmpLinkToPlanDocumentsAndResourcesPDP() {
		return jmpLinkToPlanDocumentsAndResourcesPDP;
	}

	public WebElement getJmpLinkToWaysToSaveMoneyPDP() {
		return jmpLinkToWaysToSaveMoneyPDP;
	}

	public List<WebElement> getDirectorySection(String memberType) {
		return directorySection;
	}

	public List<WebElement> getDirectorySection(String planType, String memberType) {
		int planId=0;
		/*     Menu                                                     
		 * 1-MAPD
		 * 2-MA
		 * 3-MedSupp
		 * 4-PDP
		 * 5-SSUP
		 *  
		 */
		if(planType.equalsIgnoreCase("MAPD"))
			planId=1;
		if(planType.equalsIgnoreCase("MA"))
			planId=2;
		if(planType.equalsIgnoreCase("MedSupp"))
			planId=3;
		if(planType.equalsIgnoreCase("PDP"))
			planId=4;
		if(planType.equalsIgnoreCase("SSUP"))
			planId=5;
		switch (planId) {

		case 1:
			return getDirectorySection(memberType);

		case 2:
			return getDirectorySectionMA();

		case 3:
			return getDirectorySectionMedSupp();

		case 4:
			return getDirectorySectionPDP();

		case 5:
			return getDirectorySectionSSUP();

		default:
			System.out.println("Plan Not Found");
			break;
		}
		return null;
	}

	public List<WebElement> getDirectorySectionMA() {
		return directorySection;
	}

	public List<WebElement> getDirectorySectionMedSupp() {
		return directorySectionMedSupp;
	}

	public WebElement getTextdiscountservices() {
		return textdiscountservices;
	}

	public WebElement getBenefitsSummarySectionHeader() {
		return benefitsSummarySectionHeader;
	}

	public WebElement getJmpLinkToBenefitSummaryMedSupp() {
		return jmpLinkToBenefitSummaryMedSupp;
	}

	public WebElement getJmpLinkToDiscountsAndServicesMedSupp() {
		return jmpLinkToDiscountsAndServicesMedSupp;
	}

	public WebElement getJmpLinkToPlanDocumentsAndResourcesMedSupp() {
		return jmpLinkToPlanDocumentsAndResourcesMedSupp;
	}

	public WebElement getJmpLinkToMedicalCopaysOrCoinsuranceMA(String memberType) {
		if (memberType.equalsIgnoreCase("Individual"))
			return jmpLinkToMedicalCopaysOrCoinsuranceMA;
		else
			return jmpLinkToMedicalCopaysOrCoinsuranceMAGroup;
	}

	public WebElement getJmpLinkToOutofPocketMaximumMA(String memberType) {
		if (memberType.equalsIgnoreCase("Individual"))
			return jmpLinkToOutofPocketMaximumMA;
		else
			return jmpLinkToOutofPocketMaximumMAGroup;
	}

	public WebElement getJmpLinkToPrimaryCareProviderMA(String memberType) {
		if (memberType.equalsIgnoreCase("Individual"))
			return jmpLinkToPrimaryCareProviderMA;
		else
			return jmpLinkToPrimaryCareProviderMAGroup;
	}

	public WebElement getJmpLinkToPlanDocumentsAndResourcesMA(String memberType) {
		if (memberType.equalsIgnoreCase("Individual"))
			return jmpLinkToPlanDocumentsAndResourcesMA;
		else
			return jmpLinkToPlanDocumentsAndResourcesMAGroup;
	}

	public WebElement getJmpLinkToOptionalServicesRiders(String planType) {
		int planId=0;
		/*     Menu                                                     
		 * 1-MAPD
		 * 2-MA
		 * 3-MedSupp
		 * 4-PDP
		 * 5-SSUP
		 *  
		 */

		if(planType.equalsIgnoreCase("MAPD"))
			planId=1;
		if(planType.equalsIgnoreCase("MA"))
			planId=2;
		/*                          if(planType.equalsIgnoreCase("MedSupp"))
                                             planId=3;
                              if(planType.equalsIgnoreCase("PDP"))
                                             planId=4;
                              if(planType.equalsIgnoreCase("SSUP"))
                                             planId=5;*/

		switch (planId) {

		case 1:
			return jmpLinkToOptionalServicesRiders;

		case 2:
			return jmpLinkToOptionalServicesRidersMA;

		default:
			System.out.println("Plan Not Found");
			break;
		}

		return null;
	}

	public WebElement getJmpLinkToOptionalServicesRiders() {
		return jmpLinkToOptionalServicesRiders;
	}

	public WebElement getOptionalServicesRidersSectionHeader() {
		return OptionalServicesRidersSectionHeader;
	}

	public WebElement getLinkBackToTop() {
		return linkBackToTop;
	}

	public List<WebElement> getDirectorySection() {
		return directorySection;
	}

	public WebElement getDrugCoverageSectionHeader() {
		return DrugCoverageSectionHeader;
	}

	public WebElement getPlanDocumentsAndResourcesSectionHeader() {
		return PlanDocumentsAndResourcesSectionHeader;
	}

	public WebElement getDrugCopaysAndDiscountsSectionHeader() {
		return DrugCopaysAndDiscountsSectionHeader;
	}

	public WebElement getOutOfPocketSectionHeader() {
		return outOfPocketSectionHeader;
	}

	public WebElement getJmpLinkToMedicalCopaysOrCoinsurance() {
		return jmpLinkToMedicalCopaysOrCoinsurance;
	}

	public WebElement getJmpLinkToOutofPocketMaximum() {
		return jmpLinkToOutofPocketMaximum;
	}

	public WebElement getJmpLinkToPrimaryCareProvider() {
		return jmpLinkToPrimaryCareProvider;
	}

	public WebElement getJmpLinkToDrugCopaysAndDiscounts() {
		return jmpLinkToDrugCopaysAndDiscounts;
	}

	public WebElement getJmpLinkToDrugCoverage() {
		return jmpLinkToDrugCoverage;
	}

	public WebElement getJmpLinkToPlanDocumentsAndResources() {
		return jmpLinkToPlanDocumentsAndResources;
	}

	public WebElement getCopayscoinsuranceheader() {
		return Copayscoinsuranceheader;
	}

	public WebElement getPrimaryCareProviderHeaderInd() {
		return PrimaryCareProviderHeaderInd;
	}

	/**
	 * @throws InterruptedException 
	 * Validates that the learnmore stage link
	 */
	public void clickOnLearnmoreaboutlinkstage() throws InterruptedException {
		Assert.assertTrue("Could not find the Learn more about drug link", Learnmorestagelink.getText().contains("LEARN MORE ABOUT DRUG PAYMENT STAGES"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", Learnmorestagelink);
		js.executeScript("arguments[0].click();", Learnmorestagelink); 
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;
		CommonUtility.waitForPageLoad(driver, LearnmorestageExpandedArea, 10);
		System.out.println(LearnmorestageExpandedArea.getAttribute("aria-expanded"));
		// validating expanded stage of the link-LEARN MORE ABOUT DRUG PAYMENT STAGES
		if(LearnmorestageExpandedArea.getAttribute("aria-expanded").equalsIgnoreCase("true")){
			System.out.println("LEARN MORE ABOUT DRUG PAYMENT STAGES link has been expanded successfully");
			Assert.assertTrue("LEARN MORE ABOUT DRUG PAYMENT STAGES link has been expanded successfully", true);           
		}
		else{
			System.err.println("LEARN MORE ABOUT DRUG PAYMENT STAGES link has not been expanded successfully");
			Assert.fail("LEARN MORE ABOUT DRUG PAYMENT STAGES link has not been expanded");
		}
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;
		scrollElementToCenterScreen(LearnmorestagelinkForCollapse);
		LearnmorestagelinkForCollapse.click();
		if (!validate(LearnmorestagelinkAfterCollapse,0)) { //note: not sure why sometimes first click didn't work
			LearnmorestagelinkForCollapse.click();
		}

		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS) ;
		scrollElementToCenterScreen(LearnmorestagelinkAfterCollapse);
		//validating collapsed stage of the link-LEARN MORE ABOUT DRUG PAYMENT STAGES
		if(LearnmorestagelinkAfterCollapse.getAttribute("aria-expanded").equalsIgnoreCase("false")){
			System.out.println("LEARN MORE ABOUT DRUG PAYMENT STAGES link has  been collapsed successfully");
			Assert.assertTrue("LEARN MORE ABOUT DRUG PAYMENT STAGES link has been collapsed successfully", true);           
		}
		else{
			System.err.println("LEARN MORE ABOUT DRUG PAYMENT STAGES link has not been expanded successfully");
			Assert.fail("LEARN MORE ABOUT DRUG PAYMENT STAGES link has not been expanded");
		}
	}

	/**
	 * @throws InterruptedException 
	 * Validates that the learnmore tier link
	 */
	public void clickOnLearnmoreaboutlinktier() {
		System.out.println("Click on the link-LEARN MORE ABOUT DRUG TIERS ");
		Learnmoretierslink.click();
		sleepBySec(2);
		// validating expanded stage of the link-LEARN MORE ABOUT DRUG TIERS 
		if(LearnmoretierslinkArea.getAttribute("aria-expanded").equalsIgnoreCase("true")){
			System.out.println("LEARN MORE ABOUT DRUG TIERS link has been expanded successfully");
			Assert.assertTrue("LEARN MORE ABOUT DRUG TIERS link has been expanded successfully", true);          
		}
		else{
			System.err.println("LEARN MORE ABOUT DRUG TIERS link has not been expanded successfully");
			Assert.fail("LEARN MORE ABOUT DRUG TIERS link has not been expanded");
		}

		LearnmoretierslinkForCollapsed.click();
		sleepBySec(2);
		//validating collapsed stage of the link-LEARN MORE ABOUT DRUG TIERS
		if(LearnmoretierslinkAfterCollapsed.getAttribute("aria-expanded").equalsIgnoreCase("false")){
			System.out.println("LEARN MORE ABOUT DRUG TIERS link has been collapsed successfully");
			Assert.assertTrue("LEARN MORE ABOUT DRUG TIERS link has been collapsed successfully", true);          
		}
		else{
			System.err.println("LEARN MORE ABOUT DRUG TIERS link has not been collapsed successfully");
			Assert.fail("LEARN MORE ABOUT DRUG TIERS link has not been collapsed");
		}
	}

	/**
	 * The user checks the More Information link in the Need help section
	 */
	public void clickOnmoreinformation() {
		// TODO Auto-generated method stub
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", moreinformation);
		validateWithValue("More Information link", moreinformation);
		moreinformation.click();
		sleepBySec(4);
		if(moreinformationArea.getAttribute("aria-expanded").equalsIgnoreCase("true"))
		{
			Assert.assertTrue("More information  has been expanded", true);
			System.out.println("More information  has been expanded");
		}
		else
		{
			System.err.println("More information aria has not been expanded");
			Assert.fail("More information aria has not been expanded");}
	}


	public void clickOnmoreinformationship() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
		validateWithValue("Link- More Inforamation", moreinformation);
		moreinformation.click();
		sleepBySec(4);
		if(moreinformationArea.getAttribute("aria-expanded").equalsIgnoreCase("true"))
		{
			Assert.assertTrue("More information are has been expanded", true);
			System.out.println("More information are has been expanded");
		}
		else
		{
			System.err.println("More information are has not been expanded");
			Assert.fail("More information are has not been expanded");}
	}

	public void clicksOnJumpLinksAndCheckRespectiveSectionsMA(String rider, String planType, String memberType) {
		clicksOnLinkAndBackToTop(getJmpLinkToMedicalCopaysOrCoinsuranceMA(memberType), getCopayscoinsuranceheader());
		clicksOnLinkAndBackToTop(getJmpLinkToOutofPocketMaximumMA(memberType), getOutOfPocketSectionHeader());

		if (memberType.equalsIgnoreCase("Individual"))
			clicksOnLinkAndBackToTop(getJmpLinkToPrimaryCareProviderMA(memberType), getPrimaryCareProviderHeaderInd());
		else
			clicksOnLinkAndBackToTop(getJmpLinkToPrimaryCareProviderMA(memberType),
					getPrimaryCareProviderSectionHeaderGroup());

		if (rider.toString().trim().equals("Rider"))
			clicksOnLinkAndBackToTop(getJmpLinkToOptionalServicesRiders(planType),
					getOptionalServicesRidersSectionHeader());
		/*
		 * clicksOnLinkAndBackToTop(getJmpLinkToDrugCopaysAndDiscounts(),
		 * getDrugCopaysAndDiscountsSectionHeader());
		 * clicksOnLinkAndBackToTop(getJmpLinkToDrugCoverage(),
		 * getDrugCoverageSectionHeader());
		 */
		clicksOnLinkAndBackToTop(getJmpLinkToPlanDocumentsAndResourcesMA(memberType),
				getPlanDocumentsAndResourcesSectionHeader());
		System.out.println("All sections are present for the MA Plan");
	}

	public void clicksOnJumpLinksAndCheckRespectiveSectionsMAPD(String rider, String planType, String memberType) {
		clicksOnLinkAndBackToTop(getJmpLinkToMedicalCopaysOrCoinsurance(), getCopayscoinsuranceheader());
		clicksOnLinkAndBackToTop(getJmpLinkToOutofPocketMaximum(), getOutOfPocketSectionHeader());
		if (rider.toString().trim().equals("Rider"))
			clicksOnLinkAndBackToTop(getJmpLinkToOptionalServicesRiders(planType),
					getOptionalServicesRidersSectionHeader());
		clicksOnLinkAndBackToTop(getJmpLinkToDrugCopaysAndDiscounts(), getDrugCopaysAndDiscountsSectionHeader());

		if (memberType.equalsIgnoreCase("Individual")) {
			clicksOnLinkAndBackToTop(getJmpLinkToPrimaryCareProvider(), getPrimaryCareProviderHeaderInd());
			clicksOnLinkAndBackToTop(getJmpLinkToDrugCoverage(), getDrugCoverageSectionHeader());
			clicksOnLinkAndBackToTop(getJmpLinkToPlanDocumentsAndResources(),
					getPlanDocumentsAndResourcesSectionHeader());
		} else {
			clicksOnLinkAndBackToTop(getJmpLinkToPrimaryCareProvider(), getPrimaryCareProviderSectionHeaderGroup());
			clicksOnLinkAndBackToTop(getJmpLinkToadditionalBenefits(), getAdditionalBenefitsSectionHeader()); // for
			// group
			// member
			clicksOnLinkAndBackToTop(getJmpLinkToPlanDocumentsAndResourcesMAPDGroup(),
					getPlanDocumentsAndResourcesSectionHeader());
		}
		System.out.println("All sections are present for the MAPD Plan");
	}

	public void clicksOnJumpLinksAndCheckRespectiveSectionsMedSupp(String rider, String planType, String memberType) {
		clicksOnLinkAndBackToTop(getJmpLinkToBenefitSummaryMedSupp(), getBenefitsSummarySectionHeader());
		clicksOnLinkAndBackToTop(getJmpLinkToDiscountsAndServicesMedSupp(), getTextdiscountservices());
		clicksOnLinkAndBackToTop(getJmpLinkToPlanDocumentsAndResourcesMedSupp(),
				getPlanDocumentsAndResourcesSectionHeader());
		System.out.println("All sections are present for the MedSupp Plan");
	}

	public void clicksOnJumpLinksAndCheckRespectiveSectionsPDP(String rider, String planType, String memberType,
			String Identifier) {
		if (Identifier.contains("UHC")) {
			clicksOnLinkAndBackToTop(getJmpLinkToDrugCopaysAndDiscountsPDPUHC(),
					getDrugCopaysAndDiscountsSectionHeader());
			clicksOnLinkAndBackToTop(getJmpLinkToPlanDocumentsAndResourcesPDPUHC(),
					getPlanDocumentsAndResourcesSectionHeader());
		} else {
			clicksOnLinkAndBackToTop(getJmpLinkToDrugCopaysAndDiscountsPDP(), getDrugCopaysAndDiscountsSectionHeader());
			clicksOnLinkAndBackToTop(getJmpLinkToDrugCoveragePDP(), getDrugCoverageSectionHeader());
			clicksOnLinkAndBackToTop(getJmpLinkToPlanDocumentsAndResourcesPDP(),
					getPlanDocumentsAndResourcesSectionHeader());
			clicksOnLinkAndBackToTop(getJmpLinkToWaysToSaveMoneyPDP(), getWaysToSaveMoneySectionHeader());
		}
		System.out.println("All sections are present for the PDP Plan");
	}

	public void clicksOnJumpLinksAndCheckRespectiveSectionsSSUP(String rider, String planType, String memberType) {
		clicksOnLinkAndBackToTop(getJmpLinkToMedicalCopaysOrCoinsuranceSSUP(), getCopayscoinsuranceheader());
		clicksOnLinkAndBackToTop(getJmpLinkToOutofPocketMaximumSSUP(), getOutOfPocketSectionHeader());
		/*
		 * if(memberType.equalsIgnoreCase("Individual"))
		 * clicksOnLinkAndBackToTop(getJmpLinkToPrimaryCareProviderSSUP(),
		 * getPrimaryCareProviderHeaderInd()); else
		 */
		clicksOnLinkAndBackToTop(getJmpLinkToPrimaryCareProviderSSUP(), getPrimaryCareProviderSectionHeaderGroup());

		clicksOnLinkAndBackToTop(getJmpLinkToPlanDocumentsAndResourcesSSUP(),
				getPlanDocumentsAndResourcesSectionHeader());
		System.out.println("All sections are present for SSUP Plan");
	}

	public void clicksOnLinkAndBackToTop(WebElement element_1,WebElement element_2 ) {
		element_1.click();
		sleepBySec(1);
		verifyElementPresence(element_2);
		try {
			getLinkBackToTop_copy().click();
		}catch(Exception ex){
			getLinkBackToTop().click();
		}
		sleepBySec(1);
	}

	public FormsAndResourcesPage clickViewPlanDocumentsButton() throws InterruptedException 
	{
		CommonUtility.waitForPageLoadNew(driver, viewPlanDocumentsButton, 45);
		System.out.println("Now clicking the View Plan Documents Button");
		viewPlanDocumentsButton.click();
		CommonUtility.checkPageIsReadyNew(driver);
		return new FormsAndResourcesPage(driver);
	}
	
	public void verifyElementPresence(WebElement element) {
		Assert.assertTrue("Section/Link isn't displayed",element.isDisplayed());
		System.out.println(element.getText());     
	}

	public void directoryLinksCount(int linkCount, String rider, String planType, String memberType) {
		int count = 0;
		if (planType.equals("MA") || planType.equals("MAPD")) {
			if (memberType.equalsIgnoreCase("Individual")) {
				count = getDirectorySection(planType, memberType).size() - 1;
				if (rider.toString().trim().equals("Rider"))
					count += 1;
			} else if (memberType.equalsIgnoreCase("Group")) {
				if (planType.equals("MAPD"))
					count = getDirectorySection(planType, memberType).size();
				else
					count = getDirectorySection(planType, memberType).size()-1;
			}
			else
				count = getDirectorySection(planType, memberType).size();
		} else
			count = getDirectorySection(planType, memberType).size();
		System.out.println("The link count is " + count);
		Assert.assertTrue("Irrelevant links are present", count == linkCount);
		System.out.println("No irrelevant links found");
	}

	public boolean validateWithValue(String value, WebElement element) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		try {
			if (element.isDisplayed()) {
				System.out.println("Element " +value+ " found!!!!");
				Assert.assertTrue("Element " +value+ " not found!!!!", true);
				return true;
			} else {
				System.out.println("Element " +value+ " not found/not visible");
				Assert.fail("Element " +value+ " not found/not visible");
			}
		} catch (Exception e) {
			System.err.println("Exception: Element " +value+ "  not found/not visible");
			Assert.fail("Element " +value+ " not found/not visible");
		}
		//note: default in UhcDriver is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		return false;
	}

	public boolean validateNotDisplay(String value, WebElement element) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		//note: validate element doesn't exist/display on the page
		try {
			if (element.isDisplayed()) {
				System.out.println("Element " +value+ " found");
				Assert.assertTrue("Element " +value+ " not found", false);
			} else {
				System.out.println("Element " +value+ " not found/not visible");
				Assert.assertTrue("Element " +value+ " found/visible", true);
			}
		} catch (Exception e) {
			System.err.println("Exception: Element " +value+ "  not found/not visible");
			Assert.assertTrue("Element " +value+ " found/not visible", true);
		}
		//note: default in UhcDriver is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		return false;
	}

	/**
	 * The user checks the view label in Documents section
	 */
	public boolean getview_label() {
		return validateWithValue("View label",view_label);
	}

	/**
	 * The user checks the get Document label in Documents section
	 */
	public boolean getdocuments_label() {
		return validateWithValue("Header- Plan Material", documents_label);
	}

	public void languagevalidation() {
		if (langdropdown.isDisplayed()) {

			Select dropdown = new Select(langdropdown);
			List<WebElement> webElements = dropdown.getOptions();
			for (WebElement element : webElements) {

				if (element.getText().equals("SPANISH") || element.getText().equals("CHINESE")) {
					Assert.fail("The element" + element.getText() + "should not display");
					System.out.println("The element " + element.getText() + "should not display");
				} else {
					Assert.assertTrue("Spanish and Chinese language are not display in dropdown as expected", true);
				}
			}
		}
	}

	/**
	 * The user validates the language dropdown in Documents section and validates the default selected language
	 */
	public void validate_langdropdown_first_selection() {
		// WebElement langdropdown;
		if (langdropdown.isDisplayed()) {
			Select langdropdwn = new Select(langdropdown);
			if (langdropdwn.getFirstSelectedOption().getText().equals("ENGLISH")) {
				System.out.println("Text" + langdropdwn.getFirstSelectedOption().getText());
				Assert.assertTrue("The default language selected is "+langdropdwn.getFirstSelectedOption().getText(),true);
			} else
				Assert.fail("Issue in English selection");
		} else
			Assert.fail("Plan year dropdown not displayed");

	}


	public void Select_langdropdown_selection(String language) {
		if (langdropdown.isDisplayed()) {
			Select langdropdwn = new Select(langdropdown);
			int languageindex = Integer.parseInt(language);
			langdropdwn.selectByIndex(languageindex);
			System.out.println("The selected language  is " + langdropdwn.getFirstSelectedOption().getText());
			Assert.assertTrue("The selected language  is "+langdropdwn.getFirstSelectedOption().getText(),true);
		} else
			Assert.fail("Issue in language selection");
	} 

	/**
	 * The user validates the language dropdown in Documents section and make a selection in the dropdown
	 */
	public void validate_langdropdown_select(String language) {
		Select langdropdwn = new Select(langdropdown);
		langdropdwn.selectByVisibleText(language);
		System.out.println(langdropdwn.getFirstSelectedOption().getText());
	}

	public void validatePdfLinks(String planType){
		sleepBySec(15);
		if(planType.equalsIgnoreCase("MAPD")){
			if(mapdPdfLinks.size()!=0){
				System.out.println(" PDF links size:"+ mapdPdfLinks.size());
			}else
				Assert.fail("No PDFs found");
		}else if(planType.equalsIgnoreCase("PDP")){
			if(pdpPdfLinks.size()!=0){
				System.out.println(" PDF links size:"+ pdpPdfLinks.size());
			}else
				Assert.fail("No PDFs found");
		}
	}

	public void navigateToDocumentsAndResourcesPage(String planType){
		if(planType.equalsIgnoreCase("SHIP")||planType.equalsIgnoreCase("MEDSUPP")){
			validateNew(viewDocsAndResourcesLinkShip,0);
			viewDocsAndResourcesLinkShip.click();
		}
		else{
			validateNew(viewDocsAndResourcesLink,0);
			viewDocsAndResourcesLink.click();
		}
		if(!validateNew(docsAndResourcesHeader,0))
			Assert.fail("Error in loading the documents and resources page");		
	}

	public void navigateToOrderPlanMaterialsPage(){
		validateNew(orderMaterialsTab,0);
		orderMaterialsTab.click();
	}

	public void validateOrderPlanMaterialsPage(String planType){
		if(planType.equalsIgnoreCase("MEDSUPP") || planType.equalsIgnoreCase("SHIP")){
			validateNew(radioBtnsSectionShip,0);
		}else
			validateNew(radioBtnsSectionNonShip,0);

		validateNew(submitOrderBtn,0);
		validateNew(planDocsAndResourcesBtn,0);
	}

	public PaymentHistoryPage navigateToPaymentsPage(){
		paymentsTab.click();

		if(validateNew(paymentsHeader,0))
			return new PaymentHistoryPage(driver);
		return null;
	}

	public void validatePlanNavTab(String planType) {

		if(planType.equalsIgnoreCase("MAPD")||planType.equalsIgnoreCase("MA")){
			if(validate(mapdNavTab,0))
				mapdNavTab.click();	
		}else if(planType.equalsIgnoreCase("PDP")&&validate(pdpNavTab,0)){
			pdpNavTab.click();
		}else if((planType.equalsIgnoreCase("MEDSUPP")||planType.equalsIgnoreCase("SHIP"))){
			if(validate(medsuppNavTab,0))
				medsuppNavTab.click();
		}		
	}

	public void validatePlanNavTabOrderMaterialsPage(String planType) {

		if(planType.equalsIgnoreCase("MAPD")||planType.equalsIgnoreCase("MA")){
			if(validate(mapdNavTab,0))
				mapdNavTab.click();	
		}else if(planType.equalsIgnoreCase("PDP")&&validate(pdpNavTab,0)){
			pdpNavTabOrderMaterials.click();
		}else if((planType.equalsIgnoreCase("MEDSUPP")||planType.equalsIgnoreCase("SHIP"))){
			if(validate(medsuppNavTab,0))
				medsuppNavTabOrderMaterials.click();
		}
	}

	public void validateNavTabs() {
		validateNew(benefitsSummarySection,0);
		validateNew(formsAndResourcesTab,0);
		validateNew(orderMaterialsTab,0);
	}

	/**
	 * The user validates the headers in Need help section
	 */
	public void validateNeedhelpheader() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
		validateWithValue("Header Need help", NeedHelpHeader);
		validateWithValue("Technical Support",TechnicalSupport);
		validateWithValue("Plan Support",PlanSupport);
	}

	/**
	 * The user validates the headers in Need help section
	 */
	public void validateNeedhelpheader1() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,3000)", "");
		validateNew(NeedHelpHeader,0);
		System.out.println("***Need help header is validated ***");
	}

	/**
	 * The user validates the Contact us section in Need help section
	 */
	public void validatecontactussection() {
		System.out.println("the user validates contactus section");
		if (Contactussection.getText().contains("See more ways to contact us")) {
			System.out.println("contactus section is coming ");
			Assert.assertTrue("contactus section is coming ",true);
		} else {
			Assert.fail("Contactussection.getText() >>>>>>" + Contactussection.getText());
		}
	}

	/**
	 * The user validates the Contact us link in Need help section
	 */
	public void contactUslink() {
		validateWithValue("Link- Contact US", contactUslink);
		if (contactUslink.isEnabled()) {
			contactUslink.click();
			sleepBySec(10);
			Assert.assertTrue("Contact Us page is loaded successfully",driver.getCurrentUrl().contains("contact-us/overview.html"));
			System.out.println("Contact Us page is loaded successfully");
		}
		else{
			Assert.fail("Contact Us page is not loaded successfully");
			System.err.println("Contact Us page is not loaded successfully");
		}
	}

	public void  rally_dashboardValues() {
		driver.get("https://member.int.uhc.com/retiree/dashboard");
		sleepBySec(4);
		try {
			validateNew(PrescriptionDrugCostsrkSectionHeaderONRally,0);
			validateNew(ViewAllBenefitsLinkONRally,0);
			Assert.assertTrue("Prescription DrugCost Section Header and View All Benefits Link are displaying on the Rally page", true);
		} catch (Exception e) {
			Assert.fail("Prescription DrugCost Section Header and View All Benefits Link are not displaying on the Rally page");
		}
	}


	public void scrollToViewexpressScriptsLink() {
		// TODO Auto-generated method stub
		System.out.println("Scrolling to Access Your Drug Benefits Header for Express Scripts Link");
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", accessYourDrugBenefitsHeader); 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void clickExpressScriptsLink() {
		// TODO Auto-generated method stub
		System.out.println("Clicking on Express Scripts Link");
		expressScriptsLink.click();   	
		System.out.println("Now clicking on proceed button of site leaving popup");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		proceedButtonExpressScriptsSSOSiteLeavingPopup.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//switching to Kentucky SSO window
		
		String mainwindow = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(mainwindow)) {
				driver.switchTo().window(currentWindowHandle);
			}
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("URL opened in new window is:   "+driver.getCurrentUrl());
		if (MRScenario.environment.equalsIgnoreCase("stage"))
		{
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println("Now waiting for Express Scripts logo to show up in Stage");
		CommonUtility.waitForPageLoad(driver, ExpressScriptsLogo, 20);
		if (driver.getCurrentUrl().contains("https://wwwuat.express-scripts.com/medco/consumer/SSO") && 
				ExpressScriptsLogo.isDisplayed())
		{
			System.out.println("Express Scripts logo was displayed and SSO URL was correct in Stage");
		}
		
		}
		else if ((MRScenario.environment.equalsIgnoreCase("prod")) || (MRScenario.environment.equalsIgnoreCase("offline")))
		{
			System.out.println("Now waiting for Express Scripts logo to show up in PROD or Offline PROD");
			CommonUtility.checkPageIsReadyNew(driver);
			CommonUtility.waitForPageLoad(driver, ExpressScriptsLogoPROD, 20);
			if (driver.getCurrentUrl().contains("https://www.express-scripts.com/frontend/consumer/#/") && 
					ExpressScriptsLogoPROD.isDisplayed())
			{
				System.out.println("Express Scripts logo was displayed and SSO URL was correct in Offline PROD or PROD");
			}
		}
		else
		{
			System.out.println("Either Express Scripts SSO URL was incorrect or Express Scripts logo was not displayed, failing test script");
			Assert.fail();
		}
		
	}

	public void scrollToOptumRxSSOLink(String optumrxssolink ) {
		// TODO Auto-generated method stub
		String linktobetested = optumrxssolink;
		if (linktobetested.equalsIgnoreCase("VIEW YOUR CURRENT PRESCRIPTION DRUG COST SUMMARY AT OPTUMRX.COM"))
		{
		System.out.println("Scrolling to section containing VIEW YOUR CURRENT PRESCRIPTION DRUG COST SUMMARY AT OPTUMRX.COM");
		JavascriptExecutor jse2 = (JavascriptExecutor)driver;
		jse2.executeScript("arguments[0].scrollIntoView()", lisDrugCopayHeader); 
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (linktobetested.equalsIgnoreCase("LookUpDrugsButton"))
		{
		System.out.println("Scrolling to LookUpDrugs Button Section");
		JavascriptExecutor jse3 = (JavascriptExecutor)driver;
		jse3.executeScript("arguments[0].scrollIntoView()", LookUpDrugsButtonSection); 
		try {
			Thread.sleep(2000);
		    } 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		}
		
		if (linktobetested.equalsIgnoreCase("viewDetailsAtOptumrxLink"))
		{
		System.out.println("Scrolling to section conytaining view Details At Optumrx Link");
		JavascriptExecutor jse4 = (JavascriptExecutor)driver;
		jse4.executeScript("arguments[0].scrollIntoView()", viewDetailsAtOptumrxLinkSection); 
		try {
			Thread.sleep(2000);
		    } 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}
			
	
	
	public void clicksToOptumRxSSOLink(String optumrxssolink ) {
		// TODO Auto-generated method stub
		
		String linktobetested = optumrxssolink;
		if (linktobetested.equalsIgnoreCase("VIEW YOUR CURRENT PRESCRIPTION DRUG COST SUMMARY AT OPTUMRX.COM"))
		{	
		System.out.println("Clicking on VIEW YOUR CURRENT PRESCRIPTION DRUG COST SUMMARY AT OPTUMRX.COM Link");
		TestHarness.checkForIPerceptionModel(driver);
		viewYourCurrentPrescriptionDrugCostSummaryLink.click();   	
		System.out.println("VIEW YOUR CURRENT PRESCRIPTION DRUG COST SUMMARY AT OPTUMRX.COM Link has been clicked");
		}
		
		if (linktobetested.equalsIgnoreCase("LookUpDrugsButton"))
		{	
		System.out.println("Clicking on LookUpDrugs Button");
		TestHarness.checkForIPerceptionModel(driver);
		LookUpDrugsButton.click();   	
		System.out.println("LookUpDrugs Button has been clicked");
		}
		
		if (linktobetested.equalsIgnoreCase("viewDetailsAtOptumrxLink"))
		{	
		System.out.println("Clicking on View Details At Optumrx Link");
		TestHarness.checkForIPerceptionModel(driver);
		viewDetailsAtOptumrxLink.click();   	
		System.out.println("View Details At Optumrx Link has been clicked");
		}
		
		try {
			System.out.println("Now waiting for 4 seconds");
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("switching to OptumRx  window");		
		String mainwindow = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(mainwindow)) {
				driver.switchTo().window(currentWindowHandle);
			}
		}
		try {
			System.out.println("Now waiting for 20 seconds");
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		if ((linktobetested.equalsIgnoreCase("VIEW YOUR CURRENT PRESCRIPTION DRUG COST SUMMARY AT OPTUMRX.COM")) 
				|| (linktobetested.equalsIgnoreCase("viewDetailsAtOptumrxLink")))
		{
		System.out.println("Now waiting for Benefits Information header to show up");
		CommonUtility.waitForPageLoad(driver, BenefitsInformationHeaderOptumRx, 20);
		System.out.println("URL opened in new window is:   "+driver.getCurrentUrl());
		System.out.println("Page title is:   "+driver.getTitle());
		String getHeaderText = BenefitsInformationHeaderOptumRx.getText();
		System.out.println("Header text of page is  "+getHeaderText);
		if (driver.getCurrentUrl().contains("optumrx.com/secure/benefits-and-claims/benefits-information") 
				&& BenefitsInformationHeaderOptumRx.getText().contains("Benefits Information"))
		{
			System.out.println("Benefit Information Header was displayed on page and OptumRx SSO URL was correct");
		}
		else
		{
			System.out.println("OptumRx SSO URL was incorrect or Benefit Information header was not displayed, failing test script");
			Assert.fail();
		}
		}
		
		if (linktobetested.equalsIgnoreCase("LookUpDrugsButton"))
		{
		System.out.println("Now waiting for Search for a drug header to show up");
		CommonUtility.waitForPageLoad(driver, searchForADrugHeaderOptumRx, 20);
		System.out.println("URL opened in new window is:   "+driver.getCurrentUrl());
		System.out.println("Page title is:   "+driver.getTitle());
		String getHeaderText = searchForADrugHeaderOptumRx.getText();
		System.out.println("Header text of page is  "+getHeaderText);
		if (driver.getCurrentUrl().contains("optumrx.com/secure/member-tools/drug-search") 
				&& searchForADrugHeaderOptumRx.getText().contains("Search for a drug"))
		{
			System.out.println("Search for a drug header was displayed on page and OptumRx SSO URL was correct");
		}
		else
		{
			System.out.println("OptumRx SSO URL was incorrect or Drug pricing header was not displayed, failing test script");
			Assert.fail();
		}
		}
	}

}

