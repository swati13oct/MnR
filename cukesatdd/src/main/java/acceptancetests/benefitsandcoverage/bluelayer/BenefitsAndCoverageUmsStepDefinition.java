package acceptancetests.benefitsandcoverage.bluelayer;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.ArrayList;
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
import org.openqa.selenium.By;

import pages.member.bluelayer.AccountHomePage;
import pages.member.bluelayer.BenefitsCoveragePage;
import pages.member.bluelayer.LoginPage;
import pages.member.bluelayer.BenefitsAndCoveragePage;
import pages.member.bluelayer.FormsandresourcesPage;
import pages.member.ulayer.PlanBenefitsCoveragePage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.benefitsandcoverage.data.PlanBenefitsAndCoverageCommonConstants;
import acceptancetests.formsandresources.data.FnRCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
/**
 * @author pagarwa5
 *
 */
public class BenefitsAndCoverageUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;
	
	private String userName=null;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered UHC with following details for plan benefits and coverage flow in UMS site$")
	public void login_with_member(DataTable memberAttributes) {
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
		JSONObject accountHomeActualJson = null;

		/* Get expected data */
		Map<String, JSONObject> expectedDataMap = loginScenario.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);

		/* get actual data */
		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
			accountHomeActualJson = accountHomePage.accountHomeJson;
		}
		System.out.println("accountHomeActualJson====>"
				+ accountHomeActualJson.toString());
		System.out.println("accountHomeExpectedJson====>"
				+ accountHomeExpectedJson.toString());

		try {
			JSONAssert.assertEquals(accountHomeExpectedJson,
					accountHomeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);

	}

	@Given("^registered member to login in UMS site$")
	public void login_with_member_UMS(DataTable memberAttributes) {
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



	@When("^the user navigates to plan benefits and Coverage in UMS site$")
	public void navigates_benefits_and_Coverage() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		BenefitsCoveragePage benefitsCoveragePage = accountHomePage
				.navigateToBnC();

		/* Get expected data */
		JSONObject benefitsAndCoverageActualJson = null;
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario()
		.getBean(CommonConstants.EXPECTED_DATA_MAP);
		JSONObject benefitsAndCoverageExpectedJson = benefitsCoveragePage
				.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(
				PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_EXPECTED,
				benefitsAndCoverageExpectedJson);


		/* Actual data */
		if (benefitsCoveragePage != null) {
			getLoginScenario().saveBean(
					PageConstants.BENEFITS_AND_COVERAGE_PAGE,
					benefitsCoveragePage);
			/*Assert.assertTrue(true);
			benefitsAndCoverageActualJson = benefitsCoveragePage.benefitsAndCoverageJson;*/
		}
		/*getLoginScenario().saveBean(
				PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_ACTUAL,
				benefitsAndCoverageActualJson);*/
	}

	@When("^the user navigates to benefits and coverage page under my plans in UMS site$")
	public void navigates_benefits_and_Coverage_UMS() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		BenefitsCoveragePage benefitsCoveragePage = accountHomePage
				.navigateToBnC();

		if (benefitsCoveragePage != null) {
			getLoginScenario().saveBean(
					PageConstants.BENEFITS_AND_COVERAGE_PAGE,
					benefitsCoveragePage);
		}
	}


	@Then("^the user validates plan benefits and coverage details in UMS site$")
	public void details_validation(DataTable attributes) {
		BenefitsCoveragePage benefitsCoveragePage = (BenefitsCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		JSONObject benefitsAndCoverageActualJson = (JSONObject) getLoginScenario()
				.getBean(
						PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_ACTUAL);
		JSONObject benefitsAndCoverageExpectedJson = (JSONObject) getLoginScenario()
				.getBean(
						PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_EXPECTED);

		System.out.println("benefitsAndCoverageActualJson=====>"
				+ benefitsAndCoverageActualJson.toString());
		System.out.println("benefitsAndCoverageExpectedJson===>"
				+ benefitsAndCoverageExpectedJson.toString());
		/* Validations */
		try {
			JSONAssert.assertEquals(benefitsAndCoverageExpectedJson,
					benefitsAndCoverageActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		benefitsCoveragePage.logOut();
	}
	
	@Given("^the user is on the UHC medicare site login page$")
	public void uhc_login_page() {
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		getLoginScenario().saveBean(PageConstants.LOGIN_PAGE, loginPage);

	}
	

	@Then("^the user validates plan and member details after login in UHC site$")
	public void login_validation() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		JSONObject accountHomeActual = (JSONObject) getLoginScenario().getBean(
				LoginCommonConstants.ACCOUNT_HOME_ACTUAL);
		JSONObject accountHomeExpected = (JSONObject) getLoginScenario()
				.getBean(LoginCommonConstants.ACCOUNT_HOME_EXPECTED);
		System.out.println("accountHomeActual=====>"
				+ accountHomeActual.toString());
		System.out.println(accountHomeActual.toString());
		System.out.println("accountHomeExpected======>"
				+ accountHomeExpected.toString());		
		try {
			JSONAssert.assertEquals(accountHomeExpected, accountHomeActual,
					true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^the user validates pharmacy saver widget in UMS site$")
	public void user_validates_pharmacySaver_UMS(){
		BenefitsCoveragePage benefitsCoveragePage = (BenefitsCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatesPharmacySaver();
		benefitsCoveragePage.logOut();
	}
	
	@Then("^the user validates drug cost table in UMS site$")
	public void user_validates_drug_cost_table_UMS(){
		BenefitsCoveragePage benefitsCoveragePage = (BenefitsCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatesDrugCostTable();
		benefitsCoveragePage.logOut();
	}

	
	
	@Then("^the user validatespdf links after login in UHC site$")
	public void validate_Pdf_Links() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		BenefitsCoveragePage benefitsCoveragePage = accountHomePage
				.navigateToBnC();

		JSONObject planDocsPDFActualJson = benefitsCoveragePage
				.getActualPdfLinksData();

		String fileName = "benefitsandcoverage";
		String directory = CommonConstants.MEMBER_EXPECTED_DIRECTORY
				+ File.separator + CommonConstants.SITE_BLUELAYER_MEMBER
				+ File.separator
				+ LoginCommonConstants.MEMBER_BENEFITS_AND_COVERAGE
				+ File.separator;
		JSONObject benefitsAndCoverageExpextedJson = MRScenario
				.readExpectedJson(fileName, directory);

		System.out
				.println("planDocsPDFActualJson---->" + planDocsPDFActualJson);

		System.out.println("planDocsPDFExpectedJson---->"
				+ benefitsAndCoverageExpextedJson);

		getLoginScenario().saveBean(
				PageConstants.MEMBER_BENEFITS_AND_COVERAGE_ACTUAL,
				planDocsPDFActualJson);
		getLoginScenario().saveBean(
				PageConstants.MEMBER_BENEFITS_AND_COVERAGE_EXPECTED,
				benefitsAndCoverageExpextedJson);

	}
	
	
	@Then("^valiadte the actual and expected data of bluelayer benefets and coverage pdfs$")
	public void member_uhcm_login_validation() {
		JSONObject planDocsPDFActual = (JSONObject) getLoginScenario().getBean(
				PageConstants.MEMBER_BENEFITS_AND_COVERAGE_ACTUAL);
		JSONObject planDocsPDFExpected = (JSONObject) getLoginScenario()
				.getBean(PageConstants.MEMBER_BENEFITS_AND_COVERAGE_EXPECTED);
		try {
			JSONAssert.assertEquals(planDocsPDFActual, planDocsPDFExpected,
					true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}


	@Then("^the user validates riders,benefit tiering and split tier deductibles 3,4,5 after login in UHC site$")
	public void validate_Riders() {
		BenefitsCoveragePage benefitsCoveragePage = (BenefitsCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		JSONObject benefitsAndCoverageActualJson = (JSONObject) getLoginScenario()
				.getBean(PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_ACTUAL);
		JSONObject benefitsAndCoverageExpectedJson = (JSONObject) getLoginScenario()
				.getBean(PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_EXPECTED);

		System.out.println("benefitsAndCoverageActualJson=====>" + benefitsAndCoverageActualJson.toString());
		System.out.println("benefitsAndCoverageExpectedJson===>" + benefitsAndCoverageExpectedJson.toString());
		/* Validations */
		try {
			JSONAssert.assertEquals(benefitsAndCoverageExpectedJson, benefitsAndCoverageActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		benefitsCoveragePage.logOut();

	}

	@Then("^the user validates My Optional Service and PDF links$")
	public void validates_My_OPtional_Services_PDF_UMS() {
		BenefitsCoveragePage benefitsCoveragePage = (BenefitsCoveragePage) getLoginScenario()
				.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);

		benefitsCoveragePage.validateRidersWidgetandPDFLinks();
		benefitsCoveragePage.clickOnMyDrugCostAndBenefitSummaryLink();

		benefitsCoveragePage.logOut();

	}
	
	@Then("^the user validates riders after login in UHC site$")
	public void validate_Riders__Available_Not() {


	BenefitsCoveragePage benefitsCoveragePage = (BenefitsCoveragePage) getLoginScenario()
	.getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
	JSONObject benefitsAndCoverageActualJson = (JSONObject) getLoginScenario()
	.getBean(
	PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_ACTUAL);
	JSONObject benefitsAndCoverageExpectedJson = (JSONObject) getLoginScenario()
	.getBean(
	PlanBenefitsAndCoverageCommonConstants.PLAN_BENEFITS_EXPECTED);

	System.out.println("benefitsAndCoverageActualJson=====>"
	+ benefitsAndCoverageActualJson.toString());
	System.out.println("benefitsAndCoverageExpectedJson===>"
	+ benefitsAndCoverageExpectedJson.toString());
	/* Validations */
	try {
	JSONAssert.assertEquals(benefitsAndCoverageExpectedJson,
	benefitsAndCoverageActualJson, true);
	} catch (JSONException e) {
	e.printStackTrace();
	}
	}
	
	
	@When("^the user navigates directly to plan benefits and Coverage in UMS site$")
	public void the_user_navigates_directly_to_plan_benefits_and_Coverage_in_UMS_site() {
		
		WebDriver wd = loginScenario.getWebDriver();
		String currentUrl = wd.getCurrentUrl().substring(0, wd.getCurrentUrl().indexOf(".com") + ".com".length());
		
		wd.navigate().to(currentUrl + "/home/my-plans/benefits-and-coverage-page.html");
		//Assert.assertTrue(wd.getTitle().equalsIgnoreCase("UnitedHealthcare Medicare Solutions | Plan Benefits and Coverage"));
	}

	@Then("^the user validates PCP$")
	public void the_user_validates_PCP() {
		WebDriver wd = loginScenario.getWebDriver();
		WebElement pcpHeader = wd.findElement(By.className("bs-primaryCareProviderGroupHeaderText"));
		List<WebElement> pcpTextList = wd.findElements(By.className("bs-primaryCareProviderGroupText"));

		Assert.assertTrue(pcpHeader.isDisplayed());

		Iterator<WebElement> i = pcpTextList.iterator();
		boolean isDisplayed = false;
		while (i.hasNext()) {
			WebElement we = i.next();
			if (we.isDisplayed()) {
				isDisplayed = true;
				break;
			}
		}
		Assert.assertTrue(isDisplayed);
	}
	
	
	@Given("^registered member in UMS Site$")
	public void registered_member_in_UMS_Site(
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
		JSONObject accountHomeActualJson = null;

		// Get expected data 
		Map<String, JSONObject> expectedDataMap = loginScenario
				.getExpectedJson(userName);
		JSONObject accountHomeExpectedJson = accountHomePage
				.getExpectedData(expectedDataMap);

		/*get actual data*/
		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
			accountHomeActualJson = accountHomePage.accountHomeJson;
		}

		try {
			JSONAssert.assertEquals(accountHomeExpectedJson,
					accountHomeActualJson, true);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		getLoginScenario().saveBean(CommonConstants.EXPECTED_DATA_MAP,
				expectedDataMap);
	}
	

	@When("^the user view forms and resources in UMS site$")
	public void views_forms_resources_ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage=null;
		if(accountHomePage.validateGogreenPopup()){
			accountHomePage.closeGogreenPopup();
			formsAndResourcesPage = accountHomePage.navigateToFormsandResourceUmsPage();
		}else{
			formsAndResourcesPage = accountHomePage.navigateToFormsandResourceUmsPage();
		}

		/* Get expected data */
		/*JSONObject formsAndResourcesActualJson = null;
		@SuppressWarnings("unchecked")
		Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario().getBean(
				CommonConstants.EXPECTED_DATA_MAP);
		JSONObject formsAndResourcesExpectedJson = formsAndResourcesPage.getExpectedData(expectedDataMap);
		getLoginScenario().saveBean(FnRCommonConstants.FORMS_AND_RESOURCES_EXPECTED, formsAndResourcesExpectedJson);
*/
		/* Actual data */
		if (formsAndResourcesPage != null) {
			getLoginScenario().saveBean(PageConstants.FORMS_AND_RESOURCES_PAGE, formsAndResourcesPage);
		}
			/*Assert.assertTrue(true);
			//formsAndResourcesActualJson = formsAndResourcesPage.formsAndResourcesJson;*/
		//}
		//getLoginScenario().saveBean(FnRCommonConstants.FORMS_AND_RESOURCES_ACTUAL, formsAndResourcesActualJson);
	}
	
	@Then("^the user view benefits and coverage in UMS site")
	public void user_views_BenefitsAndCoverage() {

		FormsandresourcesPage formsandresourcesPage = (FormsandresourcesPage) getLoginScenario().getBean(
				PageConstants.FORMS_AND_RESOURCES_PAGE);

		BenefitsAndCoveragePage benefitsCoveragePage = formsandresourcesPage.navigateToBenefitsAndCoverage();
		if (benefitsCoveragePage != null) {
		
			getLoginScenario().saveBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE,benefitsCoveragePage);
		
		}
		if(benefitsCoveragePage!=null){
			//Get actual data
			
			JSONObject actualJsonObj=benefitsCoveragePage.benefitsandcoverageJson;
			loginScenario.saveBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_ACTUAL, actualJsonObj);	
			System.out.println("Benefits and coverage actual ==============>"+actualJsonObj.toString());
			// Get expected data 
			/*String fileName = this.userName;
			String directory = CommonConstants.BENEFITS_AND_COVERAGE_PAGE_DIRECTORY;					
			JSONObject benefitsandcoverageExectedJson = MRScenario.readExpectedJson(
					fileName, directory);*/
			Map<String, JSONObject> expectedDataMap = (Map<String, JSONObject>) getLoginScenario().getBean(
					CommonConstants.EXPECTED_DATA_MAP);
		    JSONObject benefitsandcoverageExectedJson = benefitsCoveragePage.getExpectedData(expectedDataMap);
			loginScenario.saveBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED, benefitsandcoverageExectedJson);
			System.out.println("Benefits and coverage expected ==============>"+benefitsandcoverageExectedJson.toString());	
			//JSONObject benefitsandcoverageExpectedJson =(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
			benefitsCoveragePage.clickOnDisclaimers(benefitsandcoverageExectedJson);
		}
		

	}
	
	@Then("^the user validates Needhelp header and disclaimer header")
	public void validateneedhelpheader() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario().getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validateNeedhelpheader();
     }
	
	@Then("^the user validates Plan Documents section")
	public void validateContentOnBenefitsAndCoveragePage1() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario().getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.PlanDocumentssection();
	}
	
	@Then("^the user validates the content on benefits and coverage page")
	public void validatecontentonbnc() {
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
	@Then("^the user validates contactus section")
	public void validatecontactussection() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario().getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
		benefitsCoveragePage.validatecontactussection();
     }
	
	@Then("^the user clicks on Disclaimers link$")
	public void the_user_clicks_on_Disclaimers_link() {
		BenefitsAndCoveragePage benefitsCoveragePage = (BenefitsAndCoveragePage) getLoginScenario().getBean(PageConstants.BENEFITS_COVERAGE_PAGE);
		JSONObject benefitsandcoverageExectedJson =(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.BENEFITS_AND_COVERAGE_EXPECTED);
		benefitsCoveragePage.clickOnDisclaimers(benefitsandcoverageExectedJson);
	}
	
	
	@Then("^the user view mydocument in UMS site$")
	public void views_mydocument_ums_site() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		//FormsandresourcesPage formsAndResourcesPage=null;
		FormsandresourcesPage formsAndResourcesPage = accountHomePage.navigateToMydocumentUmsPage();		
	}
	
	//jma duplicate step definition
	//@Then("^the user validates the content on mydocument page$")
	public void views_mydoument_validation_ums_site() {
		try {
			
			JSONObject actual=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.MYDOCUMENT_ACTUAL);
			
			JSONObject expected=(JSONObject) loginScenario.getBean(PlanBenefitsAndCoverageCommonConstants.MYDOCUMENT_EXPECTED);
			
			if(actual!=null && expected !=null){
				JSONAssert.assertEquals(expected, actual, true);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}
	
	@Then("^the user validates the backtopreviouspage link on mydocument page in UMS site$")
	public void view(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		//FormsandresourcesPage formsAndResourcesPage=null;
		FormsandresourcesPage formsAndResourcesPage = accountHomePage.navigatebackToformsandresourcesUmsPage();
	}



	@Then("^I will be able access a PDF flyer in  English,Spanish or Chinese that explains passport benefits when a plan has this feature$")
	public void I_will_be_able_access_a_PDF_flyer() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		BenefitsCoveragePage benefitsCoveragePage = accountHomePage
				.navigateToBnC();
		benefitsCoveragePage.verifyPassportFlyerPdf();
}


	@Then("^validates that add plans tab is not available$")
	public void validates_that_add_plans_tab_is_not_available() {
	       System.out.println("-----add plans validation started--------");
	       //BenefitsCoveragePage benefitsCoveragePage = (BenefitsCoveragePage) getLoginScenario().getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
	       BenefitsCoveragePage benefitsCoveragePage = (BenefitsCoveragePage) getLoginScenario().getBean(PageConstants.BENEFITS_AND_COVERAGE_PAGE);
	       boolean linkToValidate = benefitsCoveragePage.validateAddPlanLink();
	        try{
	       if(linkToValidate!=true){
	              System.out.println("---------Scenario Passed successfully--------");
	              Assert.assertTrue(true);
	       }else{
	              System.out.println("---------Sceanrio Failed due to presence of link-------");
	              Assert.fail();
	       }
	       }catch(Exception e){
	              Assert.fail();
	       }
	       System.out.println("-----add plans validation ended----------");
	}
	
	

	//jma duplicate step definition
	//@Then("^the user validates the view/download link on mydocument page$")
	public void view_download_link_validation_ums_site(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		//FormsandresourcesPage formsAndResourcesPage=null;
		FormsandresourcesPage formsAndResourcesPage = accountHomePage.navigateToviewdownloadlinkUmsPage();
	}
	//jma duplicate step definition
	//@Then("^the user validates the pagination link on mydocument page$")
	public void view_pagination_link_validation_ums_site(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		//FormsandresourcesPage formsAndResourcesPage=null;
		FormsandresourcesPage formsAndResourcesPage = accountHomePage.navigateTopaginationlinkUmsPage();
	}
	
	//jma duplicate step definition
	//@Then("^the user validates the custom search on mydocument page$")
	public void view_custom_search_link_validation_ums_site(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		//FormsandresourcesPage formsAndResourcesPage=null;
		FormsandresourcesPage formsAndResourcesPage = accountHomePage.navigateTocustomsearchlinkUmsPage();
	}
	

//jma duplicate step definition
//@Then("^the user validates the sorting link on mydocument page$")
	public void view_sorting_search_link_validation_ums_site(){
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		//FormsandresourcesPage formsAndResourcesPage=null;
		FormsandresourcesPage formsAndResourcesPage = accountHomePage.navigateTosortingsearchlinkUmsPage();
	}

	

}
	

