package acceptancetests.fixedtestcases;

import gherkin.formatter.model.DataTableRow;

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
import pages.member.bluelayer.AddDrugPage;
import pages.member.bluelayer.DrugDosagePage;
import pages.member.bluelayer.LoginPage;
import pages.member.bluelayer.LowCostOptPage;
import pages.member.bluelayer.ManageDrugPage;
import pages.member.bluelayer.SelectPharmacyPage;
import pages.member.bluelayer.ViewDrugCostPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.dce.data.DceCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.DataTable;

/**
 * @author pperugu
 * 
 * 
 */
public class EstimateCostsUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered UHC member with following details for estimate drug cost$")
	public void registered_UMS_with_attributes(DataTable memberAttributes) {

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
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd, category);
		getLoginScenario().saveBean(DceCommonConstants.CATEGORY, category);
		
		if (accountHomePage != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			Assert.assertTrue(true);
		}

	}

	@When("^the user navigates to estimate costs$")
	public void attemp_to_view_drug_details() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		String category = (String) getLoginScenario().getBean(
				DceCommonConstants.CATEGORY);
		ManageDrugPage manageDrugPage = accountHomePage
				.navigateToEstimateCost(category);
		
		if (manageDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
					manageDrugPage);
			if(manageDrugPage.validateDrugListSection())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in validating the Manage Drug Section");
		}

	}

	@When("^the user searches the drug with drug initials in UMS site$")
	public void user_validated_drugInformation(DataTable givenAttributes) {
		String drugInitials = givenAttributes.getGherkinRows().get(0)
				.getCells().get(0);

		String category = (String) getLoginScenario().getBean(
				DceCommonConstants.CATEGORY);
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		AddDrugPage addDrugPage = manageDrugPage.searchDrug(drugInitials,
				category);

		if (addDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
					addDrugPage);
			Assert.assertTrue(true);
		}

	}

	@And("^the user selects a drug and views the available dosages in UMS site$")
	public void user_views_dosage_available_selected_Drugs(
			DataTable drugNameAttributes) {

		String drugName = drugNameAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		String category = (String) getLoginScenario().getBean(
				DceCommonConstants.CATEGORY);

		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		DrugDosagePage drugDosagePage = addDrugPage.selectDrug(drugName,
				category);

		if (drugDosagePage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_DOSAGE_PAGE,
					drugDosagePage);
			if(drugDosagePage.validateDrugDosageSection())
				Assert.assertTrue(true);
			else
				Assert.fail("Error in validating Add Drug Section");
		}
		
	}

	@And("^the user selects the following drug dosage information in UMS site$")
	public void user_selects_dosage_information(DataTable dosageAttributes) {

		DrugDosagePage drugDosagePage = (DrugDosagePage) getLoginScenario()
				.getBean(PageConstants.DRUG_DOSAGE_PAGE);
		String category = (String) getLoginScenario().getBean(
				DceCommonConstants.CATEGORY);
		List<DataTableRow> dosageAttributesRow = dosageAttributes
				.getGherkinRows();
		Map<String, String> dosageAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < dosageAttributesRow.size(); i++) {

			dosageAttributesMap.put(dosageAttributesRow.get(i).getCells()
					.get(0), dosageAttributesRow.get(i).getCells().get(1));
		}
		Object pageObject = drugDosagePage.selectDosage(dosageAttributesMap,
				category);
		getLoginScenario().saveBean(DceCommonConstants.DOSAGE_ATTRIBUTES_MAP,
				dosageAttributesMap);

		if (pageObject.getClass().getName().contains("LowCostOptPage")) {

			LowCostOptPage lowCostOptionsPage = (LowCostOptPage) pageObject;

			/* Actual data */
			if (lowCostOptionsPage != null) {
				getLoginScenario().saveBean(PageConstants.LOW_COST_OPT_PAGE,
						lowCostOptionsPage);
				if(lowCostOptionsPage.validateLowCostSection())
					Assert.assertTrue(true);
				else
					Assert.fail("Error in validating the low cost options page");
			}
		
		} else {

			ManageDrugPage manageDrugPage = (ManageDrugPage) pageObject;

			if (manageDrugPage != null) {
				getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
						manageDrugPage);
				if(manageDrugPage.validateDrugAdded())
					Assert.assertTrue(true);
				else
					Assert.fail("Error in validating that drug was added");
				
			}

		}
	}

	@And("^the user selects the low cost options in UMS site$")
	public void user_selects_branded_generic_drug(
			DataTable selectedDrugTypeAttributes) {
		String drugType = selectedDrugTypeAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		String category = (String) getLoginScenario().getBean(
				DceCommonConstants.CATEGORY);

		@SuppressWarnings("unchecked")
		Map<String, String> dosageAttributesMap = (Map<String, String>) getLoginScenario()
		.getBean(DceCommonConstants.DOSAGE_ATTRIBUTES_MAP);

		if (!drugType.equalsIgnoreCase("null") && null != drugType) {
			LowCostOptPage lowCostOptpage = (LowCostOptPage) getLoginScenario()
					.getBean(PageConstants.LOW_COST_OPT_PAGE);
			ManageDrugPage manageDrugPage = lowCostOptpage.selectDrugType(
					drugType, category);

			
			if (manageDrugPage != null) {
				getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
						manageDrugPage);
				if(manageDrugPage.validateDrugAdded())
					Assert.assertTrue(true);
				else
					Assert.fail("Error in validating that drug was added");
				
			}
		}

	}

	@And("^the user selects the pharmacy type and the distance in UMS site$")
	public void user_selects_pharmacy_type_distance(DataTable pharmacyAttributes) {

		List<DataTableRow> pharmacyAttributesRow = pharmacyAttributes
				.getGherkinRows();
		Map<String, String> pharmacyAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < pharmacyAttributesRow.size(); i++) {

			pharmacyAttributesMap.put(pharmacyAttributesRow.get(i).getCells()
					.get(0), pharmacyAttributesRow.get(i).getCells().get(1));
		}
		String pharmacyType = pharmacyAttributesMap.get("Pharmacy Type");
		getLoginScenario().saveBean(DceCommonConstants.PHARMACYTYPE, pharmacyType);
		String distance = pharmacyAttributesMap.get("Distance");

		String category = (String) getLoginScenario().getBean(
				DceCommonConstants.CATEGORY);
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		SelectPharmacyPage selectPharmacyPage = manageDrugPage
				.navigateToPharmacyPage(category);

		if (selectPharmacyPage != null) {
			getLoginScenario().saveBean(PageConstants.SELECT_PHARMACY_PAGE,
					selectPharmacyPage);
			Assert.assertTrue(true);
		}

		/* Selecting pharmacyType and distance */
		selectPharmacyPage = selectPharmacyPage.selectTypeDistance(
				pharmacyType, distance, category);

		if (selectPharmacyPage != null) {
			getLoginScenario().saveBean(PageConstants.SELECT_PHARMACY_PAGE,
					selectPharmacyPage);
			Assert.assertTrue(true);

		}
	}

	@And("^the user selects a pharmacy from the given list in UMS site$")
	public void user_selects_pharmacies(DataTable pharmacyNameAttribute) {

		String pharmacyName = pharmacyNameAttribute.getGherkinRows().get(0)
				.getCells().get(0);
		String category = (String) getLoginScenario().getBean(
				DceCommonConstants.CATEGORY);
		SelectPharmacyPage selectPharmacyPage = (SelectPharmacyPage) getLoginScenario()
				.getBean(PageConstants.SELECT_PHARMACY_PAGE);
		ViewDrugCostPage viewDrugCostPage = selectPharmacyPage.selectPharmacy(
				pharmacyName, category);
		if (selectPharmacyPage != null) {
		getLoginScenario().saveBean(PageConstants.SELECT_PHARMACY_PAGE,
				selectPharmacyPage);
		}

		/* Actual data */
		if (viewDrugCostPage != null) {
			getLoginScenario().saveBean(PageConstants.VIEW_DRUG_COST_PAGE,
					viewDrugCostPage);
			Assert.assertTrue(true);
			
		}

	}
	
	@Then("^user will validate the view Drug cost page in UMS site$")
	public void user_will_validate_the_Drug_cost_information(DataTable pharmacyNameAttribute) {
		ViewDrugCostPage viewDrugCostPage = (ViewDrugCostPage) getLoginScenario()
				.getBean(PageConstants.VIEW_DRUG_COST_PAGE);
		String drugDosage = pharmacyNameAttribute.getGherkinRows().get(0)
				.getCells().get(1);
		if(viewDrugCostPage != null){
			if(viewDrugCostPage.validateViewDrugPage(drugDosage)){
				Assert.assertTrue(true);
			}else
				Assert.fail("Error in validating the View Drug Cost Page");
		}

		/* Deleting added drug */
		ManageDrugPage manageDrugPage = viewDrugCostPage.editDrugList();

		manageDrugPage.logOut();

	}
	

}




	
	
	
	
	
	
	
	
	
	
	

