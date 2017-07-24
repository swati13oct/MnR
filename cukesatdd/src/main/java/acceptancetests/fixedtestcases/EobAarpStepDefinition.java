package acceptancetests.fixedtestcases;

import gherkin.formatter.model.DataTableRow;

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

import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.FormsandresourcesPage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.MedicalEobPage;
import pages.member.ulayer.PrescriptionDrugEobPage;
import pages.member.ulayer.SupplementalInsuranceEobPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.claims.data.ClaimsCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.DataTable;

/**
 * @author pperugu
 *
 */
public class EobAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered AMP with following details for EOB flow$")
	public void registered_AMP_with_attributes_eob_aarp(
			DataTable memberAttributes) {
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String planType = memberAttributesMap.get("Plan Type");
		String businessType = null;
		if (planType.equalsIgnoreCase("MA")
				|| planType.equalsIgnoreCase("MAPD")
				|| planType.equalsIgnoreCase("PDP")) {
			businessType = "GOVT";
		} else {
			businessType = "SHIP";
		}
		getLoginScenario().saveBean(ClaimsCommonConstants.BUSINESS_TYPE,
				businessType);

		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				if (!memberAttributesMap.get(key).isEmpty()) {
					desiredAttributes.add(memberAttributesMap.get(key));
				}
			}
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

		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
			
		}

	}
	
	@When("^the user views forms and resources in AARP site$")
	public void user_views_forms_resources_page_aarp() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		FormsandresourcesPage formsAndResourcesPage = accountHomePage
				.navigateToFormsandResourceAarpPage();

		if (formsAndResourcesPage != null) {
			getLoginScenario().saveBean(PageConstants.FORMS_AND_RESOURCES_PAGE,
					formsAndResourcesPage);
			Assert.assertTrue(true);
			
		}

	}
	@And("^the user clicks My Medical Explanation of Benefits link in forms and resources page in AARP site$")
	public void user_clicks_medical_eob_forms_and_resources_aarp() {
		FormsandresourcesPage formsandresourcesPage = (FormsandresourcesPage) getLoginScenario()
				.getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);
		MedicalEobPage medicalEobPage = formsandresourcesPage
				.navigateToMedicalEob();

		
		if (medicalEobPage != null) {
			getLoginScenario().saveBean(PageConstants.MEDICAL_EOB_PAGE,
					medicalEobPage);
			Assert.assertTrue(true);
			
		}
	}

	@And("^the user searches EOB history for the date range in AARP site and validates$")
	public void user_searches_eob_date_range_aarp(DataTable dateAttributes) {
		List<DataTableRow> dateAttributesRow = dateAttributes.getGherkinRows();
		Map<String, String> dateAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < dateAttributesRow.size(); i++) {

			dateAttributesMap.put(dateAttributesRow.get(i).getCells().get(0),
					dateAttributesRow.get(i).getCells().get(1));
		}
		String dateRange = dateAttributesMap.get("Date Range");

		MedicalEobPage medicalEobPage = (MedicalEobPage) getLoginScenario()
				.getBean(PageConstants.MEDICAL_EOB_PAGE);
		medicalEobPage = medicalEobPage.searchesMedicalEob(dateRange);
		if (medicalEobPage != null) {
			getLoginScenario().saveBean(PageConstants.MEDICAL_EOB_PAGE,
					medicalEobPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error loading Eob Page");
		}
	}


	/* Below methods are implemented for Prescription Drug EOB */
	
	@And("^the user clicks My Prescription Drug Explanation of Benefits link in forms and resources page in AARP site$")
	public void user_clicks_prescription_drug_eob_forms_and_resources_aarp(DataTable attributes) {
		FormsandresourcesPage formsandresourcesPage = (FormsandresourcesPage) getLoginScenario()
				.getBean(PageConstants.FORMS_AND_RESOURCES_PAGE);
		List<DataTableRow> attributesRow = attributes.getGherkinRows();
		String planType = attributesRow.get(0).getCells().get(1);
		PrescriptionDrugEobPage prescriptionDrugEobPage = formsandresourcesPage
				.navigateToPresDrugEob(planType);

		
		if (prescriptionDrugEobPage != null) {
			getLoginScenario().saveBean(
					PageConstants.PRESCRIPTION_DRUG_EOB_PAGE,
					prescriptionDrugEobPage);
			Assert.assertTrue(true);
			
		}
	}
	
	@And("^the user searches prescription drug EOB history for the date range in AARP site and validates$")
	public void user_searches_prescription_drug_eob_date_range_aarp(
			DataTable dateAttributes) {
		List<DataTableRow> dateAttributesRow = dateAttributes.getGherkinRows();
		Map<String, String> dateAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < dateAttributesRow.size(); i++) {

			dateAttributesMap.put(dateAttributesRow.get(i).getCells().get(0),
					dateAttributesRow.get(i).getCells().get(1));
		}

		PrescriptionDrugEobPage prescriptionDrugEobPage = (PrescriptionDrugEobPage) getLoginScenario()
				.getBean(PageConstants.PRESCRIPTION_DRUG_EOB_PAGE);
		prescriptionDrugEobPage = prescriptionDrugEobPage
				.searchesPresDrugEob(dateAttributesMap);


		if (prescriptionDrugEobPage != null) {
			getLoginScenario().saveBean(
					PageConstants.PRESCRIPTION_DRUG_EOB_PAGE,
					prescriptionDrugEobPage);
			if(prescriptionDrugEobPage.validateRxEob())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in validating rx eobs");
		}else
			Assert.fail("Error in loading the Prescription Drug EOB Page");
			
	}

}
