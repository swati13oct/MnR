package acceptancetests.acquisitionvbf;

import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.AddDrugPage;
import pages.member.ulayer.DrugDosagePage;
import pages.member.ulayer.LoginPage;
import pages.member.ulayer.LowCostOptPage;
import pages.member.ulayer.ManageDrugPage;
import pages.member.ulayer.SelectPharmacyPage;
import pages.member.ulayer.ViewDrugCostPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.dce.data.DceCommonConstants;
//import acceptancetests.dceretiree.data.DCERetireeCommonConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *Functionality:
 */
public class DrugLookupAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;
	
	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered AMP user with following attributes for drug search$")
	public void login_with_member(DataTable memberAttributes) {

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
		String planType = memberAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			System.out.println("Plan Type: "+planType);
			getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
			getLoginScenario().saveBean(CommonConstants.PLAN_TYPE, planType);
		}

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		LoginPage loginPage = new LoginPage(wd);
		AccountHomePage accountHomePage = (AccountHomePage)loginPage.loginWith(userName, pwd);
	
		if (accountHomePage != null) {
			getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE,
					accountHomePage);
			if(accountHomePage.validateAccountHome()){
				Assert.assertTrue(true); 
			}else
				Assert.fail("Error in validating the Account Home Page");
		}

	}
	
	@And("^the user selects the plan and clicks on continue$")
	public void selectPlan(DataTable memberAttributes){
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		String planname = memberAttributesRow.get(0).getCells().get(1);
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		manageDrugPage.enterPlanDetails(planname);
	}

	@When("^the user navigates to drug search in AARP site$")
	public void attemp_to_view_drug_details() {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstants.ACCOUNT_HOME_PAGE);
		ManageDrugPage manageDrugPage = accountHomePage.navigateToDrugLookup();

		if (manageDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
					manageDrugPage);
		}
	}
	
	@When("^the user search the drug with drugInitials in AARP site$")
	public void user_validated_drugInformation(DataTable givenAttributes) throws JSONException {
		String drugInitials = givenAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		AddDrugPage addDrugPage = manageDrugPage.searchDrug(drugInitials);

		if (addDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
					addDrugPage);
			Assert.assertTrue(true);
			
		}
	}

	@And("^the user selects drugName in the drug list in AARP site$")
	public void user_views_dosage_available_selected_Drugs(
			DataTable drugNameAttributes) {
		String drugName = drugNameAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		DrugDosagePage drugDosagePage = addDrugPage.selectDrug(drugName);
		
		if (drugDosagePage != null) {
			getLoginScenario().saveBean(PageConstants.DRUG_DOSAGE_PAGE,
					drugDosagePage);
			if(drugDosagePage.validateDrugDosagePage()){
				Assert.assertTrue(true);
			}else
				Assert.fail("Error in validating the Drug Dosage Page");
			
			
		}
	}

	@And("^the user selects the following dosage information in AARP site$")
	public void user_selects_dosage_information(DataTable dosageAttributes) {

		DrugDosagePage drugDosagePage = (DrugDosagePage) getLoginScenario()
				.getBean(PageConstants.DRUG_DOSAGE_PAGE);
		List<DataTableRow> dosageAttributesRow = dosageAttributes
				.getGherkinRows();
		Map<String, String> dosageAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < dosageAttributesRow.size(); i++) {

			dosageAttributesMap.put(dosageAttributesRow.get(i).getCells()
					.get(0), dosageAttributesRow.get(i).getCells().get(1));
		}
		Object pageObject = drugDosagePage.selectDosage(dosageAttributesMap);
		getLoginScenario().saveBean(DceCommonConstants.DOSAGE_ATTRIBUTES_MAP,
				dosageAttributesMap);
		String drugDosage = dosageAttributesRow.get(0).getCells().get(1);
		if (pageObject.getClass().getName().contains("LowCostOptPage")) {

			LowCostOptPage lowCostOptionsPage = (LowCostOptPage) pageObject;
			String drugType = dosageAttributesMap.get("Drug Type");
			if (lowCostOptionsPage != null) {
				getLoginScenario().saveBean(PageConstants.LOW_COST_OPT_PAGE,
						lowCostOptionsPage);
				if(lowCostOptionsPage.validateLowCostSection(drugDosage)){
					Assert.assertTrue(true);System.out.println("low cost PASSED");
					
					if (!drugType.equalsIgnoreCase("null") && null != drugType) {
							ManageDrugPage manageDrugPage= (ManageDrugPage) lowCostOptionsPage.selectDrugType(drugType);

							if (manageDrugPage != null) {
								getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
										manageDrugPage);
								if(manageDrugPage.validateDrugAdded()){
									Assert.assertTrue(true);System.out.println("drug added PASSED");
								}else
									Assert.fail("Error in validating that the drug was added");					
							}
					}
				}else
					Assert.fail("Error in validating the Low Cost Options Page");
			}
		} else {

			ManageDrugPage manageDrugPage = (ManageDrugPage) pageObject;

			if (manageDrugPage != null) {
				getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
						manageDrugPage);
				if(manageDrugPage.validateDrugAdded()){
					Assert.assertTrue(true);System.out.println("drug added PASSED");
				}else
					Assert.fail("Error in validating that the drug was added");	
			}
		}
	}

	@And("^the user selects the following branded or generic drug in AARP site$")
	public void user_selects_branded_generic_drug(
			DataTable selectedDrugTypeAttributes) {
		String drugType = selectedDrugTypeAttributes.getGherkinRows().get(0)
				.getCells().get(0);

		ManageDrugPage manageDrugPage = null;
		if (!drugType.equalsIgnoreCase("null") && null != drugType) {
			if (getLoginScenario().getBean(PageConstants.LOW_COST_OPT_PAGE) != null){
				LowCostOptPage lowCostOptPage = (LowCostOptPage) getLoginScenario()
					.getBean(PageConstants.LOW_COST_OPT_PAGE);		

				manageDrugPage= lowCostOptPage
						.selectDrugType(drugType);

				if (manageDrugPage != null) {
					getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
							manageDrugPage);
					if(manageDrugPage.validateDrugAdded()){
						Assert.assertTrue(true);System.out.println("drug added PASSED");
					}else
						Assert.fail("Error in validating that the drug was added");					
				}
			} else {
				ManageDrugPage manageDrug = (ManageDrugPage) getLoginScenario().getBean(PageConstants.MANAGE_DRUG_PAGE);
				manageDrug = manageDrug.selectDrugType(drugType);
				 getLoginScenario()
					.saveBean(PageConstants.MANAGE_DRUG_PAGE, manageDrug);
				Assert.assertTrue(true);
			}

		}
	}

	@And("^the user search for pharmacies using the following information in AARP site$")
	public void user_selects_pharmacy_type_distance(DataTable pharmacyAttributes) throws JSONException {
		List<DataTableRow> pharmacyAttributesRow = pharmacyAttributes
				.getGherkinRows();
		Map<String, String> pharmacyAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < pharmacyAttributesRow.size(); i++) {

			pharmacyAttributesMap.put(pharmacyAttributesRow.get(i).getCells()
					.get(0), pharmacyAttributesRow.get(i).getCells().get(1));
		}
		String pharmacyType = pharmacyAttributesMap.get("Pharmacy Type");
		String distance = pharmacyAttributesMap.get("Distance");
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		SelectPharmacyPage selectPharmacyPage = manageDrugPage
				.navigateToPharmacyPage();		

		if (selectPharmacyPage != null) {
			selectPharmacyPage = selectPharmacyPage.selectTypeDistance(
					pharmacyType, distance);
			getLoginScenario().saveBean(PageConstants.SELECT_PHARMACY_PAGE,
					selectPharmacyPage);
			Assert.assertTrue(true);
			
		}		

	}

	@And("^the user selects a pharmacy from the list of pharmacies in AARP site$")
	public void user_selects_pharmacies(DataTable pharmacyNameAttribute) {
		SelectPharmacyPage selectPharmacyPage = (SelectPharmacyPage) getLoginScenario()
				.getBean(PageConstants.SELECT_PHARMACY_PAGE);
		selectPharmacyPage.selectPharmacy();
		ViewDrugCostPage viewDrugCostPage = selectPharmacyPage.navigateToStep3();	

		
		if (viewDrugCostPage != null) {
			getLoginScenario().saveBean(PageConstants.VIEW_DRUG_COST_PAGE,
					viewDrugCostPage);
			Assert.assertTrue(true);
			
		}else
			Assert.fail("View Drug Cost Page found to be null");
	}

	@And("^the user validates drug cost page in AARP site$")
	public void user_will_validate_the_Drug_cost_information(DataTable pharmacyNameAttribute) {
		
		ViewDrugCostPage viewDrugCostPage = (ViewDrugCostPage) getLoginScenario()
				.getBean(PageConstants.VIEW_DRUG_COST_PAGE);
		
		if(viewDrugCostPage!=null){
				Assert.assertTrue(true);
		}
		viewDrugCostPage.editDrugList();
		viewDrugCostPage.logOut();

	}
	
	@Then("^the user checks and verifies that the plans shown are AARP plans$")
	public void user_checks_and_verifies_plans(){
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario()
				.getBean(PageConstants.MANAGE_DRUG_PAGE);
		if(manageDrugPage.verifyPlans()){
			Assert.assertTrue(true);
		}else
			Assert.fail("Error in validating that plans are AARP plans");
	}
}