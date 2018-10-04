/**
 * 
 */
/**
 * @author jkuma14
 *
 */
package acceptancetests.memberredesign.preeffective;
import org.springframework.beans.factory.annotation.Autowired;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;
import pages.regression.claims.ClaimSummarypage;
import pages.regression.formsandresources.FormsAndResourcesPage;
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
@Given("^verify that payment tab is not displayed to Preeffective member on dashboard$")
public void verifyPaymentsTabNotDisplayedOnDashboardHomePage() throws Throwable {
	AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
	Thread.sleep(3000);	
	AccountHomePage.checkForIPerceptionModel(accountHomePage.driver);
	accountHomePage.validatePremiumPaymentTabNotDisplayed();	
	getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);
	
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
}