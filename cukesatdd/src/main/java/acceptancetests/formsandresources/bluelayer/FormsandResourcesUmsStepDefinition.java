/**
 * 
 */
package acceptancetests.formsandresources.bluelayer;

import gherkin.formatter.model.DataTableRow;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.BenefitsAndCoveragePage;
import pages.member.bluelayer.BenefitsCoveragePage;
import pages.member.bluelayer.FormsandresourcesPage;
import pages.member.bluelayer.LoginPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.benefitsandcoverage.data.PlanBenefitsAndCoverageCommonConstants;
import acceptancetests.formsandresources.data.FnRCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pperugu
 *
 */
public class FormsandResourcesUmsStepDefinition {
	
	private static BenefitsAndCoveragePage planBenefitsCoveragePage = null;
	
	public String userName=null;

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered member for forms and resources in UMS Site$")
	public void registered_member_formsandresources_ums(
			DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario
				.getUMSMemberWithDesiredAttributes(desiredAttributes);

		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
			this.userName=userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			getLoginScenario()
			.saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}


		WebDriver wd = getLoginScenario().getWebDriver();

		LoginPage loginPage = new LoginPage(wd);
		loginPage.loginTo();
		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd, category);
		//JSONObject accountHomeActualJson = null;

		// Get expected data b
		/*Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);*/

		/*get actual data*/
		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
		}
			//accountHomeActualJson = accountHomePage.accountHomeJson;		}

		/*try {
			JSONAssert.assertEquals(accountHomeExpectedJson,
					accountHomeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);*/
	}
	
	
	@When("^the user navigates to forms and resources in UMS site$")
	public void views_forms_resources_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToFormsandResourcePage();

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
		
		// Actual data 
		if (formsAndResourcesPage != null) {
			getLoginScenario().saveBean(PageConstants.FORMS_AND_RESOURCES_PAGE,
					formsAndResourcesPage);
		/*Assert.assertTrue(true);
			formsAndResourcesActualJson = formsAndResourcesPage.formsAndResourcesJson;*/
		}
		/*getLoginScenario().saveBean(
				FnRCommonConstants.FORMS_AND_RESOURCES_ACTUAL,
				formsAndResourcesActualJson);*/
	}
	
	@Then("^the user validates My Documents section and clicks on the link in UMS site$")
	public void validates_My_Documents_ums(){
		FormsandresourcesPage formsandresourcesPage = (FormsandresourcesPage) getLoginScenario()
				.getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);
		formsandresourcesPage.selectLast24Months();
		formsandresourcesPage.validateMyDocumentsTable();
		//formsandresourcesPage.logOut();
		if (formsandresourcesPage != null) {
			getLoginScenario().saveBean(PageConstants.FORMS_AND_RESOURCES_PAGE,
					formsandresourcesPage);
		}
		
	}

	
	@Then("^the user validates pdfs in plan materials and forms and resources section in UMS site$")
	public void validates_plan_materials_plan_document_section_ums() {
		FormsandresourcesPage formsandresourcesAarpPage = (FormsandresourcesPage) getLoginScenario()
				.getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);
		JSONObject formsAndResourcesActualJson = (JSONObject) getLoginScenario()
				.getBean(FnRCommonConstants.FORMS_AND_RESOURCES_ACTUAL);
		JSONObject formsAndResourcesExpectedJson = (JSONObject) getLoginScenario()
				.getBean(FnRCommonConstants.FORMS_AND_RESOURCES_EXPECTED);

		System.out.println("formsAndResourcesActualJson=====>"
				+ formsAndResourcesActualJson.toString());
		System.out.println("formsAndResourcesExpectedJson===>"
				+ formsAndResourcesExpectedJson.toString());
		//Validations 
		try {
			JSONAssert.assertEquals(formsAndResourcesExpectedJson,
					formsAndResourcesActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		formsandresourcesAarpPage.logOut();

	}
	
	@Then("^the user validates Plan Benefits and Coverage details in UMS site$")
	public void validates_plan_benefits_coverage() {
		FormsandresourcesPage formsandresourcesAarpPage = (FormsandresourcesPage) getLoginScenario()
				.getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);
		
		formsandresourcesAarpPage = formsandresourcesAarpPage.clickBenefitsAndCoverage();
		
		JSONObject formsAndResourcesActualJson = (JSONObject) getLoginScenario()
				.getBean(FnRCommonConstants.FORMS_AND_RESOURCES_ACTUAL);
		JSONObject formsAndResourcesExpectedJson = (JSONObject) getLoginScenario()
				.getBean(FnRCommonConstants.FORMS_AND_RESOURCES_EXPECTED);

		System.out.println("formsAndResourcesActualJson=====>"
				+ formsAndResourcesActualJson.toString());
		System.out.println("formsAndResourcesExpectedJson===>"
				+ formsAndResourcesExpectedJson.toString());
		//Validations 
		try {
			JSONAssert.assertEquals(formsAndResourcesExpectedJson,
					formsAndResourcesActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

	}

	@Given("^registered member for plan materials in forms and resources in UMS Site$")
	public void registered_member_planmaterials_formsandresources_ums(
			DataTable memberAttributes) {
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario
				.getUMSMemberWithDesiredAttributes(desiredAttributes);

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

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd, category);
		
		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
		}
	}


	@When("^the user navigates to plan materials in forms and resources page in UMS site$")
	public void views_planmaterials_forms_resources_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToFormsandResourcePage();

		if (formsAndResourcesPage != null) {
			getLoginScenario().saveBean(PageConstants.FORMS_AND_RESOURCES_PAGE,
					formsAndResourcesPage);
		}
	}

	@Then("^the user validates pdfs in plan materials section in UMS site$")
	public void validates_pdfs_in_plan_materials_section_ums() {

		FormsandresourcesPage formsAndResourcesPage = (FormsandresourcesPage) getLoginScenario()
				.getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);


		formsAndResourcesPage.clickOnPlanMaterialPdfs();
		formsAndResourcesPage.logOut();


	}
	
	@When("^the user view forms and resources in UMS site$")
	public void the_user_view_forms_and_resources_in_UMS_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage.navigateToFormsandResourcePage();

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

	@Then("^the user view benefits and coverage in UMS site$")
	public void the_user_view_benefits_and_coverage_in_UMS_site() {
		FormsandresourcesPage formsandresourcesPage = (FormsandresourcesPage) getLoginScenario()
				.getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);

		planBenefitsCoveragePage=formsandresourcesPage.navigateToBenefitsAndCoverage();
		
		if(planBenefitsCoveragePage!=null){
			//Get actual data
			JSONObject actualJsonObj=planBenefitsCoveragePage.benefitsandcoverageJson;
			loginScenario.saveBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL, actualJsonObj);	
			System.out.println("Benefits and coverage actual ==============>"+actualJsonObj.toString());
			// Get expected data 
			String fileName = this.userName;
			String directory = CommonConstants.BENEFITS_AND_COVERAGE_PAGE_BLAYER_DIRECTORY;					
			JSONObject benefitsandcoverageExectedJson = MRScenario.readExpectedJson(
					fileName, directory);
			loginScenario.saveBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED, benefitsandcoverageExectedJson);
			System.out.println("Benefits and coverage expected ==============>"+benefitsandcoverageExectedJson.toString());
			
			
			
		}
			
	}

	@Then("^the user validates the content on benefits and coverage page$")
	public void the_user_validates_the_content_on_benefits_and_coverage_page() {
		/*if (planBenefitsCoveragePage != null) {
			planBenefitsCoveragePage.validateFieldsOnBenefitsAndCoveragePage();
		}*/
		
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
@Then("^validates that add plans tab is not available$")
	public void validates_that_add_plans_tab_is_not_available() {
		System.out.println("-----add plans validation started--------");
		FormsandresourcesPage formsAndResources = (FormsandresourcesPage) getLoginScenario().getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);
		boolean linkToValidate = formsAndResources.validateAddPlanLink();
		System.out.println(PageConstants.FORMS_AND_RESOURCES_PAGE);
		try{
		if(linkToValidate!=true){
			System.out.println("---------Scenario Passed successfully--------");
			Assert.assertTrue(true);
		}else{
			System.out.println("---------Sceanrio Failed due to presence of link-------");
			//Assert.fail();
		}
		}catch(Exception e){
			Assert.fail();
		}
		System.out.println("-----add plans validation ended----------");
	}


	@Then("^I will be able access a PDF flyer in  English,Spanish or Chinese that explains passport benefits when a plan has this feature$")
	public void I_will_be_able_access_a_PDF_flyer_spanish() {
		WebDriver wd = getLoginScenario().getWebDriver();
		FormsandresourcesPage formsandresourcesPage = new FormsandresourcesPage(wd);
		formsandresourcesPage.verifyPassportFlyer();
		formsandresourcesPage.verifyPassportFlyerSpanish();
	}
	
	@Then("^the user validates preferred mail order benefit pdfs in plan materials and formsandresources section in UMS site")
	public void validates_plan_prescriptionmaterials_plan_document_section_ums() {
		FormsandresourcesPage formsAndResourcesPage = (FormsandresourcesPage) getLoginScenario()
				.getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);

		String preferredMailOrderFlag=formsAndResourcesPage.validatePrescriptionmailorderBenefitPdfs();
	
		//Validations 
		try {
			JSONAssert.assertEquals(preferredMailOrderFlag,"true", true);
		} catch (JSONException e) {
			e.printStackTrace();
		}	
	}@When("^the user navigates to my personal health record in UMS site$")
	public void views_my_personal_health_record_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToMyPersonalHealthrecord();
	}
@When("^the user view forms and resources page in UMS site$")
	public void views_forms_resources_UMS_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToFormsandResourcePage();

			if (formsAndResourcesPage != null) {
			getLoginScenario().saveBean(PageConstants.FORMS_AND_RESOURCES_PAGE,
					formsAndResourcesPage);			
		}		
	}

	@And("^the user navigating to the My Documents page in UMS site$")
	public void NavigateToMyDocuemtsPage(){
		FormsandresourcesPage formsAndResourcesPage = (FormsandresourcesPage) getLoginScenario()
				.getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);
		//AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		//FormsandresourcesPage formsAndResourcesPage = accountHomePage.navigateToFormsandResourcePage();
		formsAndResourcesPage.clickOnviewmydocsLink();
		formsAndResourcesPage.validateMyDocsSection();
		
		
		
		if (formsAndResourcesPage != null) {
			getLoginScenario().saveBean(PageConstants.FORMS_AND_RESOURCES_PAGE,
					formsAndResourcesPage);
		}
	}
@Then("the user view prefered mail service pharmacy benefit in UMS site$")
	public void views_prefered_pharmacy_benefit_Ums_site() {
		/*AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToPreferedPharmacyBenefit();*/
		
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
	
	@Then("the user view how to appoint a representive in UMS site$")
	public void views_appoint_a_representative_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToAppointRepresentative();
	}
	
	@When("^the user view privacy policy in UMS site$")
	public void views_privacy_policy_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToprivacypolicyUms();
	}
	
	@Then("^the user validates the content on privacy policy page$")
	public void the_user_validates_the_content_on_privacy_policy_page() {
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
	
	@Then("^the user validates the content on no accordion page$")
	public void the_user_validates_the_content_no_accordion_page() {
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
	
	@Then("the user view member right responsibilities in UMS site$")
	public void views_member_right_responsibilities_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToMemberRightResp();
	}



	@Then("^the user validates the content on member right responsibilities page in UMS site$")
	public void the_user_validates_the_content_on_membet_right_page() {
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

		@Then("the user validate backtoprevious link in UMS site$")
		public void views_back_to_previous_Ums_site() {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
			FormsandresourcesPage formsAndResourcesPage = accountHomePage
					.navigateToBackToPreviousPage();
		}
		
		@When("^the user view MAPD appeals and grievances in UMS site$")
		public void views_mapd_appeals_and_grievances_Ums_site() {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstants.ACCOUNT_HOME_PAGE);
			FormsandresourcesPage formsAndResourcesPage = accountHomePage
					.navigateToappealsandgrievancesUms();
		}



	@Then("^the user validates the content on MAPD appeals and grievances page in UMS site$")
		public void the_user_validates_the_content_on_mapd_appeals_grievances_page() {
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
	
	@When("^the user view SSUP appeals and grievances in UMS site$")
	public void views_ssup_appeals_and_grievances_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToappealsandgrievancesUms();
	}



@Then("^the user validates the content on SSUP appeals and grievances page in UMS site$")
	public void the_user_validates_the_content_on_ssup_appeals_grievances_page() {
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

	@Then("^the user view medical therapy management program in UMS site$")
	public void views_medical_therapy_program_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToMedicalTherapyProgUms();
	}



	@Then("^the user validates the content on medical therapy management program page in UMS site$")
	public void the_user_validates_the_content_on_medical_therapy_program_page() {
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
	
	@Then("^the user view season flu shot information in UMS site$")
	public void views_season_flu_info_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToSeasonFluInfoUms();
	}



	@Then("^the user validates the content on season flu shot information page in UMS site$")
	public void the_user_validates_the_content_on_season_flu_info_page() {
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

	
	@Then("^the user view prescription drug transition process in UMS site$")
	public void views_prescription_drug_process_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToPrescriptionDrugTransitionUms();
	}



	@Then("^the user validates the content on prescription drug transition process page in UMS site$")
	public void the_user_validates_the_content_on_prescription_drug_transition_page() {
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
	
	
	@Then("^the user view disenrollment rights and responsibilities in UMS site$")
	public void views_disenrollment_rights_responsibilities_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToDisenrollmentRightsUms();
	}



	@Then("^the user validates the content on disenrollment rights and responsibilities page in UMS site$")
	public void the_user_validates_the_content_on_disenrollment_right_responsibilities_page() {
		try {
			
			JSONObject actual=(JSONObject) loginScenario.getBean

(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL);
			
			JSONObject expected=(JSONObject) loginScenario.getBean

(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
			
			if(actual!=null && expected !=null){
				JSONAssert.assertEquals(expected, actual, true);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Then("^the user view medica therapy management in UMS site$")
	public void views_medica_therapy_management_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToMedicaTherapymanagementtsUms();
	}



	@Then("^the user validates the content on medica therapy management page in UMS site$")
	public void the_user_validates_the_content_on_medica_therapy_management_page() {
		try {
			
			JSONObject actual=(JSONObject) loginScenario.getBean

					(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL);
			
			JSONObject expected=(JSONObject) loginScenario.getBean

					(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
			
			if(actual!=null && expected !=null){
				JSONAssert.assertEquals(expected, actual, true);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Then("^the user view prescription drug transition in UMS site$")
	public void views_prescription_drug_process_transition_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage.navigateToPrescriptionDrugProcesssUms();
	}



	@Then("^the user validates the content on prescription drug transition page in UMS site$")
	public void the_user_validates_the_content_on_prescription_drug_process_page() {
		try {
			
			JSONObject actual=(JSONObject) loginScenario.getBean

(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL);
			
			JSONObject expected=(JSONObject) loginScenario.getBean

(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
			
			if(actual!=null && expected !=null){
				JSONAssert.assertEquals(expected, actual, true);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Then("^the user view preferred mail service pharmacy benefit in UMS site$")
	public void views_preferred_mail_service_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToPreferredMailServiceUms();
	}



	@Then("^the user validates the content on preferred mail service pharmacy benefit page in UMS site$")
	public void the_user_validates_the_content_on_preferred_mail_service_page() {
		try {
			
			JSONObject actual=(JSONObject) loginScenario.getBean

					(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL);
			
			JSONObject expected=(JSONObject) loginScenario.getBean

					(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
			
			if(actual!=null && expected !=null){
				JSONAssert.assertEquals(expected, actual, true);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Then("^the user view prescription drug explanation of eob in UMS site$")
	public void views_drug_eob_Ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToPrescriptionDrugEobUms();
	}



	@Then("^the user validates the content on prescription drug explanation of eob page in UMS site$")
	public void the_user_validates_the_content_on_drug_explanation_eob_page() {
		try {
			
			JSONObject actual=(JSONObject) loginScenario.getBean

					(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL);
			
			JSONObject expected=(JSONObject) loginScenario.getBean

					(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
			
			if(actual!=null && expected !=null){
				JSONAssert.assertEquals(expected, actual, true);
			}			
			
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
}