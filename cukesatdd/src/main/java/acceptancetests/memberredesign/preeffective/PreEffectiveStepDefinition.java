/**
 * 
 */
/**
 * @author jkuma14
 *
 */
package acceptancetests.memberredesign.preeffective;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import acceptancetests.memberredesign.claims.ClaimsCommonConstants;
import acceptancetests.memberredesign.claims.ClaimsSearchNavigateStepDefinition;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;
import pages.regression.claims.ClaimsSummaryPage;
import pages.regression.contactus.ContactUsPage;
import pages.regression.formsandresources.FormsAndResourcesPage;
import pages.regression.login.HSIDLoginPage;
import pages.regression.login.HsidRegistrationPersonalCreateAccount;
import pages.regression.login.HsidRegistrationPersonalInformationPage;
import pages.regression.login.SaveProfilePrefrencePage;
import pages.regression.payments.PaymentHistoryPage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;
import pages.regression.testharness.TestHarness;
/**
 * 
 * @author jkuma14
 *
 */

public class PreEffectiveStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/** 
	 * 
	 */

@Given("^verify that preeffective message is displayed on the home page or test harness page$")
public void verifyPreEffectiveMessageDisplayedOnDashboardHomePage() throws Throwable {
	
	if ((MRScenario.environment.equalsIgnoreCase("stage") & "NO".equalsIgnoreCase(MRScenario.isTestHarness))|| (MRScenario.environment.equals("prod")) || (MRScenario.environment.equals("offline")))
	{
		
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		AccountHomePage.checkForIPerceptionModel(accountHomePage.driver);
		System.out.println("Now checking for pre-effective message on Dashboard home page");
		accountHomePage.validatePreEffectiveMessagePresent();	
		getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
	}
	
	else if ((MRScenario.environment.equalsIgnoreCase("team-h")) || (MRScenario.environment.equalsIgnoreCase("stage") & "YES".equalsIgnoreCase(MRScenario.isTestHarness)))
	{
		TestHarness testHarnessPage = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
		System.out.println("Now checking for pre-effective header text on Team-h or stage test harness page");
		testHarnessPage.validatePreEffectiveMessagePresent();	
		System.out.println("Pre-effective text on header of test harness page was displayed.");
	    getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, testHarnessPage);
	}
	else {
		System.out.println("Not verifying that preeffective message is displayed as the environment is not set to team-h or Stage");
	}
	}
	

@Given("^verify that preeffective message is displayed on the test harness page$")
public void verifyPreEffectiveMessageDisplayedOnTestHarnessPage() throws Throwable {
	
	TestHarness testHarnessPage = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
	testHarnessPage.validatePreEffectiveMessagePresent();	
    getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, testHarnessPage);
	
}

@Given("^verify that payment tab is displayed to Preeffective member on dashboard or test harness page$")
public void verifyPaymentsTabNotDisplayedOnDashboardHomePage(DataTable givenAttributes) throws Throwable {
	/* Reading the given attribute from feature file */
	List<DataTableRow> memberAttributesRow = givenAttributes
			.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
	}

	String memberType = memberAttributesMap.get("Member Type");
	String planType = memberAttributesMap.get("PlanType");

	if (memberType.equalsIgnoreCase("preeffectiveIndMA")|| memberType.equalsIgnoreCase("preeffectiveIndMAPD")|| memberType.equalsIgnoreCase("preeffectiveIndPDP") || memberType.equalsIgnoreCase("preeffectiveSHIPOnly") || memberType.equalsIgnoreCase("preeffectivePDPSHIPCOMBO")) 
	{	
		if ((MRScenario.environment.equalsIgnoreCase("stage") & "NO".equalsIgnoreCase(MRScenario.isTestHarness)) || (MRScenario.environment.equals("prod") || MRScenario.environment.equals("offline")))
		{
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
			
			System.out.println("Not checking if Premium Payments tab is displayed on Dashboard");
			AccountHomePage.checkForIPerceptionModel(accountHomePage.driver);
			accountHomePage.validatePremiumPaymentTabDisplayedOnDashboard(planType);	
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
		}
		
		else if ((MRScenario.environment.equalsIgnoreCase("team-h")) || (MRScenario.environment.equalsIgnoreCase("stage") & "YES".equalsIgnoreCase(MRScenario.isTestHarness)))
		{
			
			System.out.println("Now checking for Payments tab on Team-h or stage test harness page");
			TestHarness testHarnessPage = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			testHarnessPage.validatePremiumPaymentTabIsDisplayed();	
			System.out.println("Payments tab on Team-h or stage test harness page was displayed");
			getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, testHarnessPage);
		}
		else {
			System.out.println("Not verifying that Premium payment tab is displayed as the environment is not set to team-h or Stage or offline or prod");
		}
	}	
	
	else
	{
		System.out.println("Premium Payments tab was not validated for the member type as they are not eligible for payments and the step was skipped");
	}
   }
	
@Given("^verify that payment tab is displayed to Preeffective member on test harness page$")
public void verifyPaymentsTabNotDisplayedOnDashTestHarnessPage() throws Throwable {
	TestHarness  testHarnessPage = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
	testHarnessPage.validatePremiumPaymentTabIsDisplayed();	
	getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, testHarnessPage);
	
}

@And("^user goes to payments page and verifies that correct view is displayed$")
public void verifyPaymentsPage() throws Throwable {
	TestHarness  testHarnessPage = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
	PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) testHarnessPage.navigateToPaymentOverview();	
	getLoginScenario().saveBean(PageConstants.PAYMENT_HISTORY_PAGE, paymentHistoryPage);
	
}

@Then("^user clicks on the benefits and coverage tab on the dashboard home page or test harness page$")
public void userClicksOnBenefitAndCoveragePage() throws Throwable {
	if (MRScenario.environment.contains("stage") & "NO".equalsIgnoreCase(MRScenario.isTestHarness))
	{
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		Thread.sleep(3000);
		AccountHomePage.checkForIPerceptionModel(accountHomePage.driver);
		//BenefitsAndCoveragePage benefitsCoveragePage = accountHomePage.clickOnBenefitsandCoverageTab();
		
		BenefitsAndCoveragePage benefitsCoveragePage = accountHomePage.navigateDirectToBnCPag();
		getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE, benefitsCoveragePage);
		
	}
	else if ((MRScenario.environment.equalsIgnoreCase("team-f")) || (MRScenario.environment.equalsIgnoreCase("team-h")) || (MRScenario.environment.contains("stage") & "YES".equalsIgnoreCase(MRScenario.isTestHarness)))
	{
		
		System.out.println("Now clicking on Coverage and Benefits tab from Team-f or Team-h or Stage test harness page");
		TestHarness testHarnessPage = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
		BenefitsAndCoveragePage coverageandbenefitsPage = testHarnessPage.clickOnBenefitsandCoverageTab();
		getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE, coverageandbenefitsPage);
		System.out.println("Now waiting for 20 seconds");
	}
	
	else {
		System.out.println("Not clicking on coverage & benefits tab as the environment is not set to team-h or Stage");
	}
}

@Then("^user clicks on the benefits and coverage tab from Payments page$")
public void userGoesToBenefitAndCoveragePage() throws Throwable {
	PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario().getBean(PageConstants.PAYMENT_HISTORY_PAGE);
	BenefitsAndCoveragePage benefitsCoveragePage = paymentHistoryPage.clickOnBenefitsAndCoverageTab();
	getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE, benefitsCoveragePage);
	
}

@Then("^verify that subnavigation is supressed on the coverage and benefits page$")
public void validateBenefitsAndCoverageSubNavigationIsNotDisplayed() throws Throwable {
	BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
			.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
	benefitsCoveragePage.validatePlanBenefitsSummarySubNavNotDisplayed();
	benefitsCoveragePage.validatePlanDocumentsResourcesSubNavNotDisplayed();
	benefitsCoveragePage.validateOrderPlanMaterialsSubNavNotDisplayed();
}

@Then("^verify that correct preeffective message is displayed on coverage and benefits page$")
public void validateCorrectMessageIsDisplayedOnBenefitsCoevargePage() throws Throwable {
	BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
			.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
	
	benefitsCoveragePage.verifyCorrectMessageForPreEffectiveMembers();

}

@Then("^verify that correct phone number is displayed in technical support section of coverage and benefits page$")
public void validateCorrectTechSupportNumberIsDisplayedOnBenefitsCoevargePage(DataTable givenAttributes) throws Throwable {
	/* Reading the Expected Technical TFN for the Member from feature file */
	List<DataTableRow> memberAttributesRow = givenAttributes
			.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
	}
	String TechnicalPhNo = memberAttributesMap.get("Technical TFN");
	
	BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
			.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
	benefitsCoveragePage.verifyCorrectTechSupportNumberForPreEffectiveMembers(TechnicalPhNo);

}

@Then("^verify that correct SHIP phone number is displayed in technical support section of coverage and benefits page$")
public void validateCorrectSHIPTechSupportNumberIsDisplayedOnBenefitsCoevargePage(DataTable givenAttributes) throws Throwable {
	/* Reading the Expected Technical TFN for the Member from feature file */
	List<DataTableRow> memberAttributesRow = givenAttributes
			.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
	}
	String TechnicalPhNo = memberAttributesMap.get("Technical TFN SHIP");
	
	BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
			.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
	benefitsCoveragePage.verifyCorrectTechSupportNumberForPreEffectiveMembers(TechnicalPhNo);

}

@Then("^verify that claim support header with phone number in Need Help is not displayed to SHIP Pre-effective members on coverage and benefits page$")
public void validateClaimSupportIsNOTDisplayedOnBenefitsCoevargePageForSHIPPreffective(DataTable givenAttributes)throws Throwable {
	
	List<DataTableRow> memberAttributesRow = givenAttributes
			.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
	}

	String memberType = memberAttributesMap.get("Member Type");
	/* Claim Support number is not displayed to SHIP members as pert of May 1 2019 release*/
	if (memberType.equalsIgnoreCase("preeffectiveSHIPOnly")) 	
	{BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
			.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
	
	benefitsCoveragePage.verifyClaimSupportSupportNumberNOTDisplayedForSHIPPreEffectiveMembers();
	benefitsCoveragePage.verifyClaimSupportSupportHeaderInNeedHelpNOTDisplayedForSHIPPreEffectiveMembers();
	}
	else 
	{
		System.out.println("Skipping the validation for the Claims Support number as this is not a SHIP member");
	}
}


@Then("^user click on the plan documents button$")
public void clickViewPlanDocumentsButton() throws Throwable {
	BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
			.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
	
    benefitsCoveragePage.clickViewPlanDocumentsButton();  
    FormsAndResourcesPage formsAndResourcesPage = new FormsAndResourcesPage(benefitsCoveragePage.driver);
	getLoginScenario().saveBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE, formsAndResourcesPage);
               
}

@Then("^user is navigated to Forms and Resource page$")
public void verifyTitleOfPlanDocumentAndResourcesPage() throws Throwable {
	FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
			.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);      
	formsAndResourcesPage.verifyTitleOfPage();
	getLoginScenario().saveBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE, formsAndResourcesPage);           
}

@Then("^user clicks on claims tab from Forms and Resources page$")
public void userClicksonClaimsTab() throws Throwable {
	FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
			.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);      
	formsAndResourcesPage.clickonClaimsTab();
	
	ClaimsSummaryPage newclaimsSummarypage = new ClaimsSummaryPage(formsAndResourcesPage.driver);
	getLoginScenario().saveBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE, newclaimsSummarypage);                      
}

@Then("^verify that subnavigation is supressed on the claims page$")
public void verifySubnavigationIsSuppressedOnClaimsPage() throws Throwable {
	
		ClaimsSummaryPage newclaimsSummarypage = (ClaimsSummaryPage) getLoginScenario()
				.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE); 
		newclaimsSummarypage.checkModelPopup(newclaimsSummarypage.driver);
		newclaimsSummarypage.validateClaimsSummarySubNavNotDisplayed();
		newclaimsSummarypage.validateExplanationOfBenefitsSubNavNotDisplayed();
	}
  

@Then("^verify that claim support header with phone number in Need Help is not displayed to SHIP Pre-effective members on Claims Page$")
public void validateClaimSupportIsNOTDisplayedOnClaimsPageForSHIPPreffective(DataTable givenAttributes)throws Throwable {
	
	List<DataTableRow> memberAttributesRow = givenAttributes
			.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
	}

	String memberType = memberAttributesMap.get("Member Type");
	/* Claim Support number is not displayed to SHIP members as pert of May 1 2019 release*/
	if (memberType.equalsIgnoreCase("preeffectiveSHIPOnly")) 
	{
	
		ClaimsSummaryPage newclaimsSummarypage = (ClaimsSummaryPage) getLoginScenario()
			.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);   
		newclaimsSummarypage.checkModelPopup(newclaimsSummarypage.driver);
		//tbd newclaimsSummarypage.checkForIPerceptionModel(newclaimsSummarypage.driver);
		newclaimsSummarypage.verifyClaimSupportSupportHeaderInNeedHelpNOTDisplayedForSHIPPreEffectiveMembers();
		newclaimsSummarypage.verifyClaimSupportSupportNumberNOTDisplayedForSHIPPreEffectiveMembers();
	}
	else 
	{
		System.out.println("Skipping the validation for the Claims Support number as this is not a SHIP member");
	}
}


@Then("^verify that correct preeffective message is displayed on claims page$")
public void verifyCorrectPreEffectiveMessageIsDisplayedOnClaimsPage() throws Throwable {
	
	ClaimsSummaryPage newclaimsSummarypage = (ClaimsSummaryPage) getLoginScenario()
			.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
	newclaimsSummarypage.checkModelPopup(newclaimsSummarypage.driver);
	//tbd newclaimsSummarypage.checkForIPerceptionModel(newclaimsSummarypage.driver);
	newclaimsSummarypage.verifyCorrectMessageForPreEffectiveMembers();
	
               
}

@Then("^verify segment ID on claims page$")
public void verifySegmentId(DataTable givenAttributes) throws Throwable {
	List<DataTableRow> memberAttributesRow = givenAttributes
			.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
	}
	
	ClaimsSummaryPage newclaimsSummarypage = (ClaimsSummaryPage) getLoginScenario()
			.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
	String planType = memberAttributesMap.get("Plan Type");
	String memberType = memberAttributesMap.get("Member Type");
	String expectedSegmentId = memberAttributesMap.get("Segment ID");
	//note: fix up the planType value first before sending it over to the claims method
	if (planType.contains("MA")) {
		if (planType.contains("MAPD")) 
			planType="MAPD";
		else 
			planType="MA";
	} else if(planType.contains("SSUP")) {
		planType="SSUP";
	} else if(planType.contains("PDP")) {
		planType="PDP";
	} else if(planType.contains("SHIP")) {
		planType="SHIP";
	}
	newclaimsSummarypage.validateSegmentId(planType, memberType, expectedSegmentId);	

}


//***** Updating the following Step for Contact Us Technical TFN validation as part for Fast and Furious Feature# F296012

@Then("^verify that correct phone number is displayed in technical support section of claims page$")
public void verifyCorrectTechnicalSupportPhoneNumberIsDisplayedOnClaimsPage(DataTable givenAttributes) throws Throwable {
	/* Reading the Expected Technical TFN for the Member from feature file */
	List<DataTableRow> memberAttributesRow = givenAttributes
			.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
	}
	String TechnicalPhNo = memberAttributesMap.get("Technical TFN");
	ClaimsSummaryPage newclaimsSummarypage = (ClaimsSummaryPage) getLoginScenario()
			.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
	newclaimsSummarypage.checkModelPopup(newclaimsSummarypage.driver);
	//tbd newclaimsSummarypage.checkForIPerceptionModel(newclaimsSummarypage.driver);
	newclaimsSummarypage.verifyCorrectTechSupportNumberForPreEffectiveMembers(TechnicalPhNo);
	
               
}

@Then("^verify that payment tab is displayed to Preeffective member from secondary pages$")
public void verifyPaymentTabIsDisplayedOnClaimsPage(DataTable givenAttributes)throws Throwable {
	/* Reading the given attribute from feature file */
	List<DataTableRow> memberAttributesRow = givenAttributes
			.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
	}

	String memberType = memberAttributesMap.get("Member Type");
	/* Premium payment tab is always displayed to Individual members, therefore checking only for them*/
	if (memberType.equalsIgnoreCase("preeffectiveIndMA")|| memberType.equalsIgnoreCase("preeffectiveIndMAPD")|| memberType.equalsIgnoreCase("preeffectiveIndPDP") || memberType.equalsIgnoreCase("preeffectiveSHIPOnly") || memberType.equalsIgnoreCase("preeffectivePDPSHIPCOMBO"))  
	{	
	
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
		.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);      
		formsAndResourcesPage.verifyPaymentTabIsDisplayedForPreEffectiveMembers();
		getLoginScenario().saveBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE, formsAndResourcesPage);           
	}
	
	else
	{
		System.out.println("Premium Payments tab was not validated and the step was skipped");
	}
}

@Given("^the user clicks on Account Profile tab & selects Account Settings from the drop down$")
public void userClicksOn_Account_settings() throws Throwable {
	AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
	AccountHomePage.checkForIPerceptionModel(accountHomePage.driver);
	ProfileandPreferencesPage ppp = accountHomePage.navigateDirectToProfilePage();
	getLoginScenario().saveBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE,ppp);	
}

@Given("^the user clicks on Account Profile tab & selects Account Settings from the drop down from claims page$")
public void userClicksOn_Account_settings_from_claims_page() throws Throwable {
	ClaimsSummaryPage newClaimsSummaryPage = (ClaimsSummaryPage) getLoginScenario()
			.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
	ProfileandPreferencesPage profileAndPrefPage = newClaimsSummaryPage.navigateToProfilePage();
	getLoginScenario().saveBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE,profileAndPrefPage);	
}

@Given("^preuser is navigated to Account Settings page$")
public void userlands_on_Account_Settings_Page() throws Throwable {
		ProfileandPreferencesPage profilePreferencesPage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			profilePreferencesPage = testHarness.navigateDirectToProfilePageFromTestHarnessPage();
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			profilePreferencesPage = accountHomePage.navigateDirectToProfilePage();
		}
		if (profilePreferencesPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE, profilePreferencesPage);
		} else {
			Assert.fail("Profile preference page not loaded");
		}	
}	

@And("^the preuser validates the Plan Name, Member name, Member ID and account section in UMS site")
public void user_Validates_FED_PROFILE_MEMBERNAME_ID_AccountProfile() {
	ProfileandPreferencesPage profilePreferencesPage = (ProfileandPreferencesPage) getLoginScenario()
			.getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);

	if (profilePreferencesPage == null) {
		System.out.println("Profile and Preferences page variable is Null");
	}
	profilePreferencesPage.validatePlanNameMemberidNameAcountProfilepre();
}
@Given("^verify that the pre effecctive member can access the account settings page to view security and sign-in preferences$")
public void verify_preffectiev_member_can_access_the_page() throws Throwable {
	ProfileandPreferencesPage ppp = (ProfileandPreferencesPage) getLoginScenario().getBean(PageConstantsMnR.PROFILE_AND_PREFERENCES_PAGE);
	ProfileandPreferencesPage.checkForIPerceptionModel(ppp.driver);
	ppp.validatepermanentaddress();
	ppp.validatePhonepreffective();
}

@Given("^verify that the pre effecctive group member can access the account settings page to view security and sign-in preferences$")
public void verify_preffectiev_group_member_can_access_the_page() throws Throwable {
	ProfileandPreferencesPage ppp = (ProfileandPreferencesPage) getLoginScenario().getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
	ProfileandPreferencesPage.checkForIPerceptionModel(ppp.driver);
	ppp.validatepermanentaddress();
	ppp.validatePhonepreffective();
	//ppp.validatepreffectiveemail2();
}
@Given("^the preuser is on medicare sign in page$")
public void the_user_is_on_medicare_sign_in_page() throws Throwable {
	WebDriver wd = getLoginScenario().getWebDriver();
	HSIDLoginPage hsidLoginPage = new HSIDLoginPage(wd);
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	getLoginScenario().saveBean(PageConstants.HSID_LOGIN_PAGE, hsidLoginPage);
}

@When("^the preuser clicks on Register now link$")
public void the_user_clicks_on_Register_now_link() throws Throwable {
	
	HSIDLoginPage hsidLoginPage = (HSIDLoginPage) loginScenario.getBean(PageConstants.HSID_LOGIN_PAGE);
	HsidRegistrationPersonalInformationPage hsidRegistrationPersonalInfoPage = hsidLoginPage.clickRegister();
	getLoginScenario().saveBean(PageConstants.HSID_REGISTRATION_PERSONALINFOPAGE, hsidRegistrationPersonalInfoPage);
	
}
@When("^the pre enter first name, last name, date of birth, zip code, member id and click continue$")
public void enter_first_name_last_name_date_of_birth_zip_code_member_id_and_click_continue(DataTable memberAttributes) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	HsidRegistrationPersonalInformationPage hsidRegistrationPersonalInfoPage = 
			(HsidRegistrationPersonalInformationPage) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALINFOPAGE);
	
	List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
	}
	
	String firstName = memberAttributesMap.get("firstName");
	String lastName = memberAttributesMap.get("lastName");
	String dob = memberAttributesMap.get("dob");
	String zipcode = memberAttributesMap.get("zipcode");
	String memberId = memberAttributesMap.get("memberid");
	System.out.println("firstName: "+firstName +"lastName: "+lastName +"dob: "+dob+"memberId: "+memberId +"zipcode: " + zipcode);
	hsidRegistrationPersonalInfoPage.populatefields(firstName, lastName, dob,zipcode, memberId);
	/*HsidRegistrationPersonalCreateAccount hsidRegistrationPersonalCreateAccount 
									= hsidRegistrationPersonalInfoPage.clickContinue1();
	if(hsidRegistrationPersonalCreateAccount!=null){
		getLoginScenario().saveBean(PageConstants.HSID_REGISTRATION_PERSONALCREATEACCOUNT, hsidRegistrationPersonalCreateAccount);
	System.out.println(" ***The page is not null *** ");

	}*/	
}
@When("^preuser is navigated to step two:create account page$")
public void user_is_navigated_to_step_two_create_account_page() throws Throwable {
HsidRegistrationPersonalCreateAccount hsidRegistrationPersonalCreateAccount = (HsidRegistrationPersonalCreateAccount) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALCREATEACCOUNT);
	System.out.println("*** Test - navigated to create Account page ***");
	
	hsidRegistrationPersonalCreateAccount.verifyCreateAccountSection1();		
}
@When("^preuser enter username, password, re-enter password, email, re-enter email$")
public void enter_username_password_re_enter_password_email_re_enter_email(DataTable memberAttributes) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    // For automatic transformation, change DataTable to one of
    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	System.out.println("*** In method enter details ***");
	
	HsidRegistrationPersonalCreateAccount hsidRegistrationPersonalCreateAccount = 
			(HsidRegistrationPersonalCreateAccount) loginScenario.getBean(PageConstants.HSID_REGISTRATION_PERSONALCREATEACCOUNT);
	
	List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
	}
	
	String password = memberAttributesMap.get("password");
	String email = memberAttributesMap.get("email");
	
	String userName = hsidRegistrationPersonalCreateAccount.getUserName();
	getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
	getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, password);
	System.out.println("userName: "+userName +"password: "+password +"email: "+email);
	hsidRegistrationPersonalCreateAccount.enterUsername(userName);
	hsidRegistrationPersonalCreateAccount.enterPassword(password);
	hsidRegistrationPersonalCreateAccount.enterConfirmPassword(password);
	hsidRegistrationPersonalCreateAccount.enterEmail(email);
	hsidRegistrationPersonalCreateAccount.enterConfirmEmail(email);	
    
}
@When("^Preffective user lands on the splash page & clicks on Save Prefrences$")
public void preffective_user_lands_on_splash_page(){
	
	SaveProfilePrefrencePage SplashPage = (SaveProfilePrefrencePage) loginScenario.getBean(PageConstantsMnR.GO_GREEN_SPLASH_PAGE);

		System.out.println("*** navigated to Splash page ***");
		SplashPage.verifyTitleOfPage();
		SplashPage.validateonlinedelivery();
		pages.regression.accounthomepage.AccountHomePage accountHomePage = SplashPage.NavigateToAccHomePage(); 	
		if (accountHomePage!= null){
			loginScenario.saveBean(PageConstantsMnR.ACCOUNT_HOME_PAGE, accountHomePage);    	
			Assert.assertTrue(true);

		}	
}
@When("^the Preffective member lands on the dashboard$")
public void preffective_member_lands_on_dashboard() throws Throwable{
	AccountHomePage accounthomepage = (AccountHomePage) loginScenario.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
System.out.println("	going to validate account home page ");
	accounthomepage.validateHomePage1();
}

//***** Adding the following Step for Contact Us Technical TFN validation as part for Fast and Furious Feature# F296012
@Given("^user clicks on the Contact Us link in Need help Section of Claims Page$")
public void user_clicks_on_the_Contact_Us_link_in_Need_help_Section_of_Claims_Page() throws Throwable {
    // User navigates to Contact Us page by clicking on "contact us" link in CLaims Page
	ClaimsSummaryPage newclaimsSummarypage = (ClaimsSummaryPage) getLoginScenario()
			.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);   
	newclaimsSummarypage.checkModelPopup(newclaimsSummarypage.driver);
	//tbd newclaimsSummarypage.checkForIPerceptionModel(newclaimsSummarypage.driver);
	ContactUsPage contactUsPage = newclaimsSummarypage.navigateToContactUsPage();
	getLoginScenario().saveBean(PageConstants.CONTACT_US_PAGE, contactUsPage);                      

}

//***** Adding the following Step for Contact Us Technical TFN validation as part for Fast and Furious Feature# F296012
@Given("^verity that correct phone number is displayed in Technical Support section of Contact Us Page$")
public void verity_that_correct_phone_number_is_displayed_in_Technical_Support_section_of_Contact_Us_Page(DataTable givenAttributes) throws Throwable {
	/* Reading the Expected Technical TFN for the Member from feature file */
	List<DataTableRow> memberAttributesRow = givenAttributes
			.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
	}
	String TechnicalPhNo = memberAttributesMap.get("Technical TFN");
	ContactUsPage contactUsPage= (ContactUsPage) getLoginScenario()
			.getBean(PageConstants.CONTACT_US_PAGE);
	contactUsPage.verifyCorrectTechSupportNumberForPreEffectiveMembers(TechnicalPhNo);
	
               
}

@Then("^user clicks on the Premium Payment tab from Forms and Resources Page$")
public void userClicksOnPremiumPaymentFromFormsAndResources(DataTable givenAttributes)throws Throwable {
	/* Reading the given attribute from feature file */
	List<DataTableRow> memberAttributesRow = givenAttributes
			.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
	}

	String memberType = memberAttributesMap.get("Member Type");
	/* Premium payment tab is always displayed to Individual members, therefore checking only for them*/
	if (memberType.equalsIgnoreCase("preeffectiveIndMA")|| memberType.equalsIgnoreCase("preeffectiveIndMAPD")|| memberType.equalsIgnoreCase("preeffectiveIndPDP") || memberType.equalsIgnoreCase("preeffectiveSHIPOnly") || memberType.equalsIgnoreCase("preeffectivePDPSHIPCOMBO")) 
	{	
	
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
		.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);      
		PaymentHistoryPage paymentHistoryPage = formsAndResourcesPage.userClicksOnPremiumPaymentFromFormsAndResources();
		if (paymentHistoryPage != null) {
			getLoginScenario().saveBean(PageConstants.Payments_History_Page, paymentHistoryPage);
			
		}           
	}
	
	else
	{
		System.out.println("Premium Payments tab was not validated and the step was skipped as per Member Type used");
	}
}

@Then("^verify that correct phone number is displayed in technical support section of Payments page$")
public void validateCorrectTechSupportNumberIsDisplayedOnPaymentsPage(DataTable givenAttributes) throws Throwable {
	/* Reading the Expected Technical TFN for the Member from feature file */
	List<DataTableRow> memberAttributesRow = givenAttributes
			.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
	}
	String TechnicalPhNo = memberAttributesMap.get("Technical TFN");
	String memberType = memberAttributesMap.get("Member Type");
	if (memberType.equalsIgnoreCase("preeffectiveIndMA")|| memberType.equalsIgnoreCase("preeffectiveIndMAPD")|| memberType.equalsIgnoreCase("preeffectiveIndPDP") || memberType.equalsIgnoreCase("preeffectiveSHIPOnly") || memberType.equalsIgnoreCase("preeffectivePDPSHIPCOMBO")) 
	{
    PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
			.getBean(PageConstants.Payments_History_Page);	
	paymentHistoryPage.verifyCorrectTechSupportNumberForPreEffectiveMembers(TechnicalPhNo);
	}
	else
	{
		System.out.println("Tech Support number on Premium Payments tab was not validated and the step was skipped as per Member Type used");
	}
	}

@When("^user clicks on SHIP Plan Tab on Benefits and Coverage tab$")
public void userClicksOnSHIPPlanTabOnBenefitsPage() throws InterruptedException {
	BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
			.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
	
	benefitsCoveragePage.navigateToSHIPTab();
	getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE, benefitsCoveragePage);
			 
}

@When("^user clicks on SSUP Plan Tab on Benefits and Coverage tab$")
public void userClicksOnSSUPPlanTabOnBenefitsPage() throws InterruptedException {
	BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
			.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
	
	benefitsCoveragePage.navigateToSSUPTab();
	getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE, benefitsCoveragePage);
			 
}

@When("^user clicks on SHIP Plan Tab on Payments page$")
public void userClicksOnSHIPPlanTabOnPaymentsPage() throws InterruptedException {
	PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
			.getBean(PageConstants.Payments_History_Page);	
	paymentHistoryPage.navigateToSHIPTab();
	getLoginScenario().saveBean(PageConstants.Payments_History_Page, paymentHistoryPage);
			 
}
@Then("^verify that correct SHIP phone number is displayed in technical support section of payments page$")
public void validateCorrectSHIPTechSupportNumberIsDisplayedOnPaymentsPage(DataTable givenAttributes) throws Throwable {
	/* Reading the Expected Technical TFN for the Member from feature file */
	List<DataTableRow> memberAttributesRow = givenAttributes
			.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
	}
	String TechnicalPhNo = memberAttributesMap.get("Technical TFN SHIP");
	
	PaymentHistoryPage paymentHistoryPage = (PaymentHistoryPage) getLoginScenario()
			.getBean(PageConstants.Payments_History_Page);	
	paymentHistoryPage.verifyCorrectTechSupportNumberForPreEffectiveMembers(TechnicalPhNo);
	getLoginScenario().saveBean(PageConstants.Payments_History_Page, paymentHistoryPage);
}

@Then("^verify that correct phone number is displayed in technical support section of forms and resources page$")
public void validateCorrectTechSupportNumberIsDisplayedOnFormsAndResourcesPage(DataTable givenAttributes) throws Throwable {
	/* Reading the Expected Technical TFN for the Member from feature file */
	List<DataTableRow> memberAttributesRow = givenAttributes
			.getGherkinRows();
	Map<String, String> memberAttributesMap = new HashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {

		memberAttributesMap.put(memberAttributesRow.get(i).getCells()
				.get(0), memberAttributesRow.get(i).getCells().get(1));
	}
	String TechnicalPhNo = memberAttributesMap.get("Technical TFN");
	
	FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
			.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
	formsAndResourcesPage.verifyCorrectTechSupportNumberForPreEffectiveMembers(TechnicalPhNo);
	getLoginScenario().saveBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE, formsAndResourcesPage);
}

@When("^user clicks on SSUP Plan Tab on forms and resources tab$")
public void userClicksOnSSUPPlanTabOnFormsAndResourcesPage() throws InterruptedException {
	FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
			.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
	
	formsAndResourcesPage.navigateToSSUPTab();
	getLoginScenario().saveBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE, formsAndResourcesPage);
			 
}


}