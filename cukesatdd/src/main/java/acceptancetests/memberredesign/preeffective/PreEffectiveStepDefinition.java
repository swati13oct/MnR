/**
 * 
 */
/**
 * @author jkuma14
 *
 */
package acceptancetests.memberredesign.preeffective;
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
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.testharness.*;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;
import pages.regression.claims.ClaimSummarypage;
import pages.regression.formsandresources.FormsAndResourcesPage;
import pages.regression.login.HSIDLoginPage;
import pages.regression.login.HsidRegistrationPersonalCreateAccount;
import pages.regression.login.HsidRegistrationPersonalInformationPage;
import pages.regression.login.SaveProfilePrefrencePage;
import pages.regression.profileandpreferences.ProfileandPreferencesPage;
/**
 * 
 * @author jkuma14
 *
 */

public class PreEffectiveStepDefinition{
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/** 
	 * 
	 */

@Given("^verify that preeffective message is displayed on the home page$")
public void verifyPreEffectiveMessageDisplayedOnDashboardHomePage() throws Throwable {
	AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
	Thread.sleep(10000);
	AccountHomePage.checkForIPerceptionModel(accountHomePage.driver);
	accountHomePage.validatePreEffectiveMessagePresent();	
    getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
	
}

@Given("^verify that preeffective message is displayed on the test harness page$")
public void verifyPreEffectiveMessageDisplayedOnTestHarnessPage() throws Throwable {
	TestHarness testHarnessPage = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
	testHarnessPage.validatePreEffectiveMessagePresent();	
    getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, testHarnessPage);
	
}

@Given("^verify that payment tab is displayed to Preeffective member on dashboard$")
public void verifyPaymentsTabNotDisplayedOnDashboardHomePage() throws Throwable {
	AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
	Thread.sleep(3000);	
	AccountHomePage.checkForIPerceptionModel(accountHomePage.driver);
	accountHomePage.validatePremiumPaymentTabNotDisplayed();	
	getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
	
}

@Given("^verify that payment tab is displayed to Preeffective member on test harness page$")
public void verifyPaymentsTabNotDisplayedOnDashTestHarnessPage() throws Throwable {
	TestHarness  testHarnessPage = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);
	testHarnessPage.validatePremiumPaymentTabIsDisplayed();	
	getLoginScenario().saveBean(PageConstants.TEST_HARNESS_PAGE, testHarnessPage);
	
}

@Then("^user clicks on the benefits and coverage tab on the dashboard home page$")
public void userClicksOnBenefitAndCoveragePage() throws Throwable {
	AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
	Thread.sleep(3000);
	AccountHomePage.checkForIPerceptionModel(accountHomePage.driver);
	BenefitsAndCoveragePage benefitsCoveragePage = accountHomePage.clickOnBenefitsandCoverageTab();
	getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE, benefitsCoveragePage);
	
}

@Then("^verify that subnavigation is supressed on the coverage and benefits page$")
public void validateBenefitsAndCoverageSubNavigationIsNotDisplayed() throws Throwable {
	BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
			.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
	Thread.sleep(5000);
	BenefitsAndCoveragePage.checkModelPopup(benefitsCoveragePage.driver);
	benefitsCoveragePage.validatePlanBenefitsSummarySubNavNotDisplayed();
	benefitsCoveragePage.validatePlanDocumentsResourcesSubNavNotDisplayed();
	benefitsCoveragePage.validateOrderPlanMaterialsSubNavNotDisplayed();
}

@Then("^verify that correct preeffective message and plan documents button are displayed on coverage and benefits page$")
public void validateCorrectMessageIsDisplayedOnBenefitsCoevargePage() throws Throwable {
	BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
			.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
	Thread.sleep(2000);
	benefitsCoveragePage.verifyCorrectMessageForPreEffectiveMembers();

}

@Then("^verify that correct phone number is displayed in technical support section of coverage and benefits page$")
public void validateCorrectTechSupportNumberIsDisplayedOnBenefitsCoevargePage() throws Throwable {
	BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
			.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
	BenefitsAndCoveragePage.checkModelPopup(benefitsCoveragePage.driver);
	benefitsCoveragePage.verifyCorrectTechSupportNumberForPreEffectiveMembers();

}

@Then("^user click on the plan documents button$")
public void clickViewPlanDocumentsButton() throws Throwable {
	BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario()
			.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
	BenefitsAndCoveragePage.checkModelPopup(benefitsCoveragePage.driver);
    benefitsCoveragePage.clickViewPlanDocumentsButton();
    System.out.println("Now waiting for 85 seconds as this page takes a lot of time to load :( ");
    Thread.sleep(85000);    
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
	
	ClaimSummarypage newclaimsSummarypage = new ClaimSummarypage(formsAndResourcesPage.driver);
	getLoginScenario().saveBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE, newclaimsSummarypage);                      
}

@Then("^verify that subnavigation is supressed on the claims page$")
public void verifySubnavigationIsSuppressedOnClaimsPage() throws Throwable {
	
	ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario()
			.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);   
	Thread.sleep(5000);
	//write code for handling iperception pop-up
	//newclaimsSummarypage.feebackpopupClose();
	ClaimSummarypage.checkForIPerceptionModel(newclaimsSummarypage.driver);
	newclaimsSummarypage.validateClaimsSummarySubNavNotDisplayed();
	newclaimsSummarypage.validateExplanationOfBenefitsSubNavNotDisplayed();
	
               
}

@Then("^verify that correct preeffective message is displayed on claims page$")
public void verifyCorrectPreEffectiveMessageIsDisplayedOnClaimsPage() throws Throwable {
	
	ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario()
			.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
	ClaimSummarypage.checkForIPerceptionModel(newclaimsSummarypage.driver);
	newclaimsSummarypage.verifyCorrectMessageForPreEffectiveMembers();
	
               
}

@Then("^verify that correct phone number is displayed in technical support section of claims page$")
public void verifyCorrectTechnicalSupportPhoneNumberIsDisplayedOnClaimsPage() throws Throwable {
	
	ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario()
			.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);
	ClaimSummarypage.checkForIPerceptionModel(newclaimsSummarypage.driver);
	newclaimsSummarypage.verifyCorrectTechSupportNumberForPreEffectiveMembers();
	
               
}

@Then("^verify that payment tab is not displayed to Preeffective member from secondary pages$")
public void verifyPaymentTabIsNOTDisplayedOnClaimsPage() throws Throwable {
	
	ClaimSummarypage newclaimsSummarypage = (ClaimSummarypage) getLoginScenario()
			.getBean(PageConstants.NEW_CLAIMS_SUMMARY_PAGE);   
	ClaimSummarypage.checkForIPerceptionModel(newclaimsSummarypage.driver);
	newclaimsSummarypage.verifyPaymentTabIsNotDisplayedForPreEffectiveMembers();
	

}

@Given("^the user clicks on Account Profile tab & selects Account Settings from the drop down$")
public void userClicksOn_Account_settings() throws Throwable {
	AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
	Thread.sleep(3000);
	AccountHomePage.checkForIPerceptionModel(accountHomePage.driver);
	ProfileandPreferencesPage ppp = accountHomePage.navigateDirectToProfilePage();
	getLoginScenario().saveBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE,ppp);	
}

@Given("^user is navigated to Account Settings page$")
public void userlands_on_Account_Settings_Page() throws Throwable {
	ProfileandPreferencesPage ppp = (ProfileandPreferencesPage) getLoginScenario().getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);      
	ProfileandPreferencesPage.checkForIPerceptionModel(ppp.driver);
	ppp.validateprefrencepageURL();
	
}
@Given("^verify that the pre effecctive member can access the account settings page to view security and sign-in preferences$")
public void verify_preffectiev_member_can_access_the_page() throws Throwable {
	ProfileandPreferencesPage ppp = (ProfileandPreferencesPage) getLoginScenario().getBean(PageConstants.PROFILE_AND_PREFERENCES_PAGE);
	ProfileandPreferencesPage.checkForIPerceptionModel(ppp.driver);
	ppp.validatepermanentaddress();
	ppp.validatePhonepreffective();
	ppp.validatepreffectiveemail();
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
}