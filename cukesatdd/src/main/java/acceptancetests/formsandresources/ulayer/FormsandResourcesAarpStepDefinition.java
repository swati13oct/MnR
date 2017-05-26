/**
 * 
 */
package acceptancetests.formsandresources.ulayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.PlanPreviewPage;
import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.FormsandresourcesPage;
import pages.member.ulayer.LoginPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.benefitsandcoverage.data.PlanBenefitsAndCoverageCommonConstants;
import acceptancetests.formsandresources.data.FnRCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import acceptancetests.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pperugu
 *
 */
public class FormsandResourcesAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered member for forms and resources in AARP Site$")
	public void registered_member_formsandresources_aarp(
			DataTable memberAttributes) {

		/* Reading the given attribute from feature file */
		List<List<String>> dataTable = memberAttributes.raw();
		List<String> desiredAttributes = new ArrayList<String>();

		for (List<String> data : dataTable) {
			desiredAttributes.add(data.get(0));
		}
		System.out.println("desiredAttributes.." + desiredAttributes);
		Map<String, String> loginCreds = loginScenario
				.getAMPMemberWithDesiredAttributes(desiredAttributes);

		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			getLoginScenario()
					.saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd);
		//JSONObject accountHomeActualJson = null;
		 
		/* Get expected data */
		/*Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);*/

		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			/*Assert.assertTrue(true);
			accountHomeActualJson = accountHomePage.accountHomeJson;*/
		}

		/*try {
			JSONAssert.assertEquals(accountHomeExpectedJson,
					accountHomeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);*/

	}

	@When("^the user view forms and resources in AARP site$")
	public void views_forms_resources_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToFormsandResourceAarpPage();

		/* Get expected data */
		/*JSONObject formsAndResourcesActualJson = null;
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
				.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject formsAndResourcesExpectedJson = formsAndResourcesPage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				FnRCommonConstants.FORMS_AND_RESOURCES_EXPECTED,
				formsAndResourcesExpectedJson);*/

		/* Actual data */
		/*if (formsAndResourcesPage != null) {
			getLoginScenario().saveBean(PageConstants.FORMS_AND_RESOURCES_PAGE,
					formsAndResourcesPage);
			Assert.assertTrue(true);
			formsAndResourcesActualJson = formsAndResourcesPage.formsAndResourcesJson;
		}
		getLoginScenario().saveBean(
				FnRCommonConstants.FORMS_AND_RESOURCES_ACTUAL,
				formsAndResourcesActualJson);*/
	}

	@Then("^the user validates the plan materials under plan document section$")
	public void validates_plan_materials_plan_document_section() {
		FormsandresourcesPage formsandresourcesAarpPage = (FormsandresourcesPage) getLoginScenario()
				.getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);
		JSONObject formsAndResourcesActualJson = (JSONObject) getLoginScenario()
				.getBean(FnRCommonConstants.FORMS_AND_RESOURCES_ACTUAL);
		JSONObject formsAndResourcesExpectedJson = (JSONObject) getLoginScenario()
				.getBean(FnRCommonConstants.FORMS_AND_RESOURCES_EXPECTED);
		System.out.println("formsAndResourcesActualJson=====>"
				+ formsAndResourcesActualJson);
		System.out.println("formsAndResourcesExpectedJson=====>"
				+ formsAndResourcesExpectedJson);
		/* Validations */
		try {
			JSONAssert.assertEquals(formsAndResourcesExpectedJson,
					formsAndResourcesActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		//formsandresourcesAarpPage.logOut();

	}
	
	@Then("^the user validates next year ANOC and Annual directory section$")
	public void user_validates_ANOC_Annual_directory()
	{
		FormsandresourcesPage formsandresourcesAarpPage = (FormsandresourcesPage) getLoginScenario()
				.getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);
		JSONObject planDocsPDFActualJson = formsandresourcesAarpPage.getActualPdfLinksData();
		
		String username= (String) getLoginScenario().getBean(LoginCommonConstants.USERNAME);
		
		/* Get expected data */
		String directory = CommonConstants.FR_NEXTYEAR_DIRECTORY;
		System.out.println(directory);
		JSONObject planDocsPDFExpectedJson = MRScenario.readExpectedJson(
				username, directory);
		System.out.println(planDocsPDFExpectedJson);
		
		try {
			JSONAssert.assertEquals(planDocsPDFExpectedJson,
					planDocsPDFActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	
	@And("^the user click on pdf links$")
	public void user_click_on_pdf_links() {
		FormsandresourcesPage formsandresourcesAarpPage = (FormsandresourcesPage) getLoginScenario().getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);
		formsandresourcesAarpPage.clickOnPDF();
		formsandresourcesAarpPage.logOut();
	}
	
	@Then("^the user validates prescription drug transistion in AARP site$")
	public void views_drug_transistion_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToPrescriptionDrugAarpPage();
	}
	
	@When("^the user view privacy policy in AARP site$")
	public void views_privacy_policy_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToPrivacyPolicyAarpPage();
	}
	
	@Then("^the user validates privacy policy in AARP site$")
	public void views_privacy_policy_page_aarp() {
		try {
			
			JSONObject actual=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL);
			
			JSONObject expected=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
			
			if(actual!=null && expected !=null){
				JSONAssert.assertEquals(expected, actual, true);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
	@Then("^the user view appeals in AARP site$")
	public void views_appeals_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToappealsAarpPage();
	}
	
	
	@Then("^the user validates appeals content in AARP site$")
	public void views_appeals_page_aarp() {
		try {
			
			JSONObject actual=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL);
			
			JSONObject expected=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
			
			if(actual!=null && expected !=null){
				JSONAssert.assertEquals(expected, actual, true);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
	@Then("^the user validate download link in AARP site$")
	public void views_validate_download_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToDownloadAarpPage();
	}
	
	@Then("^the user validate view link in AARP site$")
	public void views_validate_view_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToViewAarpPage();
	}
	
	@Then("^the user validate backtoprevious link in AARP site$")
	public void views_validate_back_to_previous_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToBackToPreviousAarpPage();
	}

	
	
	@Then("^the user view member right responsibilities in AARP site$")
	public void views_member_responsibility_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToMemberResponsibilitiesAarpPage();
	}
	
	
	@Then("^the user validates member right responsibilities in AARP site$")
	public void views_member_responsibilities_page_aarp() {
		try {
			
			JSONObject actual=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL);
			
			JSONObject expected=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
			
			if(actual!=null && expected !=null){
				JSONAssert.assertEquals(expected, actual, true);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Then("^the user view seasonal flu shot information in AARP site$")
	public void views_seasonal_flu_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToSeasonalFluInformationAarpPage();
	}
	
	@Then("^the user validates seasonal flu shot information in AARP site$")
	public void validate_seasonal_flu_page_aarp() {
		try {
			
			JSONObject actual=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL);
			
			JSONObject expected=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
			
			if(actual!=null && expected !=null){
				JSONAssert.assertEquals(expected, actual, true);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Then("^the user view terms of use in AARP site$")
	public void views_terms_of_use_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToTermsOfUseAarpPage();
	}
	
	@Then("^the user validates terms of use in AARP site$")
	public void validate_terms_of_use_page_aarp() {
		try {
			
			JSONObject actual=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL);
			
			JSONObject expected=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
			
			if(actual!=null && expected !=null){
				JSONAssert.assertEquals(expected, actual, true);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Then("^the user view medical therapy management program in AARP site$")
	public void views_medical_therapy_program_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToMedicalTherapyProgramAarpPage();
	}

@Then("^the user validate medical therapy management program in AARP site$")
	public void validate_medical_therapy_page_aarp() {
		try {
			
			JSONObject actual=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL);
			
			JSONObject expected=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
			
			if(actual!=null && expected !=null){
				JSONAssert.assertEquals(expected, actual, true);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("^the user view mymenu in AARP site$")
	public void views_mymenu_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToMymenuAarpPage();
	}

	@When("^the user view preffered mail service pharmacy in AARP site$")
	public void views_prefered_mail_service_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToPreferedMailServiceAarpPage();
	}
	
	@Then("^the user validate preffered mail service pharmacy in AARP site$")
	public void validate_prefered_mail_service_page_aarp() {
		try {
			
			JSONObject actual=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL);
			
			JSONObject expected=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
			
			if(actual!=null && expected !=null){
				JSONAssert.assertEquals(expected, actual, true);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Then("^the user view disenrollment rights responsibilities in AARP site$")
	public void views_disenrollment_rights_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateTodisenrollmentAarpPage();
	}

	@Then("^the user validate disenrollment rights responsibilities in AARP site$")
		public void validate_disenrollment_rights_responsibilities_page_aarp() {
			try {
				
				JSONObject actual=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL);
				
				JSONObject expected=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
				
				if(actual!=null && expected !=null){
					JSONAssert.assertEquals(expected, actual, true);
				}			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


	@Then("^the user view medication therapy management in AARP site$")
	public void views_medication_therapy_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToMedicationTherapyManagementAarpPage();
	}

	@Then("^the user validate medication therapy management in AARP site$")
	public void validate_medication_therapy_management_page_aarp() {
	try {
		
		JSONObject actual=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL);
		
		JSONObject expected=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
		
		if(actual!=null && expected !=null){
			JSONAssert.assertEquals(expected, actual, true);
		}			
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
	@Then("^the user view coverage appeals and grievances in AARP site$")
	public void views_coverage_appeals_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToCoverageAppealsAndGrievancesAarpPage();
	}


	@Then("^the user validate coverage appeals and grievances in AARP site$")
		public void validate_coverage_appeals_and_grievances_page_aarp() {
			try {
				
				JSONObject actual=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL);
				
				JSONObject expected=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
				
				if(actual!=null && expected !=null){
					JSONAssert.assertEquals(expected, actual, true);
				}			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	@Then("^the user view preferred mail service pharmacy benefit in AARP site$")
	public void views_preferred_mail_benefit_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToPreferredMailPharmacyBenefitAarpPage();
	}


	@Then("^the user validate preferred mail service pharmacy benefit in AARP site$")
		public void validate_preferred_mail_service_benefit_page_aarp() {
			try {
				
				JSONObject actual=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL);
				
				JSONObject expected=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
				
				if(actual!=null && expected !=null){
					JSONAssert.assertEquals(expected, actual, true);
				}			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	@When("^the user view benefit and coverage in AARP site$")
	public void views_benefit_and_coverage_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToBenefitAndCoverageAarpPage();
	}

@Then("^the user view lower tier drug and click on learnmore in AARP site$")
	public void views_lower_drug_learnmore_aarp_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToLowerTierDrugLearnmoreAarpPage();
	}


	@Then("^the user validate lower tier drug learnmore in AARP site$")
		public void validate_lower_drug_learn_more_page_aarp() {
			try {
				
				JSONObject actual=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL);
				
				JSONObject expected=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
				
				if(actual!=null && expected !=null){
					JSONAssert.assertEquals(expected, actual, true);
				}			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	



	
	/*@After
	public void tearDown() {

		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}*/

}
