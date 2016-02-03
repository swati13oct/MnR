package acceptancetests.dcevpp.ulayer;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.PlanDetailsPage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.AddDrugPage;
import pages.acquisition.ulayer.GetStartedPage;
import pages.acquisition.ulayer.LocationSearchPage;
import pages.acquisition.ulayer.ManageDrugPage;
import pages.acquisition.ulayer.SelectDosagePage;
import pages.acquisition.ulayer.SelectGenericPage;
import pages.acquisition.ulayer.SelectPharmacyPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.dce.data.DceCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pagarwa5
 *
 */

public class DceVppPlanDetailsAarpStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the zipcode county name for drug search in the AARP site$")
	public void zipcode_and_planyear_details(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String planYear = null;
		if(givenAttributesMap.containsKey("Plan Year"))
		{
			planYear = givenAttributesMap.get("Plan Year");
		}
		String zipCode = givenAttributesMap.get("Zip Code");
		String county = givenAttributesMap.get("County");
		WebDriver wd = getLoginScenario().getWebDriver();
		AcquisitionHomePage acqusitionHomePage = new AcquisitionHomePage(wd);
		GetStartedPage estimateDrugCost = acqusitionHomePage.navigateToPrescriptionDrug();
		LocationSearchPage enterZipCode = estimateDrugCost.getStarted();
		ManageDrugPage manageDrugPage = enterZipCode.enterLocation(zipCode, county, planYear);
		/*PlansummaryPage pg = new PlansummaryPage(wd);
		PlanDetailsPage planDetailsPage = pg.navigateToPlanDetails("AARP MedicareComplete SecureHorizons Plan 2 (HMO)");
		String planDetails = planDetailsPage.getPlanDetails();
		System.out.println("planDetails===========>"+planDetails);*/
		if (manageDrugPage != null) {
			getLoginScenario().saveBean("webDriver", wd);
			getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
					manageDrugPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("unsuccessfull navigation to add drug page");
		}
	}

	@When("^the user search the drug with drug initials in the AARP site$")
	public void user_validated_drugInformation(DataTable givenAttributes) {
		String drugInitials = givenAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.MANAGE_DRUG_PAGE);
		addDrugPage.enterDrugInitials(drugInitials);
	}

	@And("^a drug list appears with 5 drugs in the AARP site$")
	public void drug_list_with_drugs() {
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		String drugDropDownList = addDrugPage.getDrugList();
		System.out.println("drugList=======>" + drugDropDownList);

	}

	@And("^the user selects drug name in the drug list in the AARP site$")
	public void user_selects_drugname_druglist(DataTable drugNameAttributes) {

		String drugName = drugNameAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		getLoginScenario().saveBean(DceCommonConstants.DRUG_NAME, drugName);
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		SelectDosagePage selectDosagePage = addDrugPage.selectDrug(drugName);
		if (selectDosagePage != null) {

			getLoginScenario().saveBean(PageConstants.SELECT_DOSAGE_PAGE,
					selectDosagePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("unsuccessful selection of drug");
		}

	}

	@And("^the user selects the following dosage information in the AARP site$")
	public void user_selects_dosage_information(DataTable dosagesAttributes) {
		SelectDosagePage selectDosagePage = (SelectDosagePage) getLoginScenario()
				.getBean(PageConstants.SELECT_DOSAGE_PAGE);
		List<DataTableRow> dosageAttributesRow = dosagesAttributes
				.getGherkinRows();
		Map<String, String> dosageAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < dosageAttributesRow.size(); i++) {

			dosageAttributesMap.put(dosageAttributesRow.get(i).getCells()
					.get(0), dosageAttributesRow.get(i).getCells().get(1));
		}
		
		getLoginScenario().saveBean(DceCommonConstants.DOSAGE_INFORMATION, dosageAttributesMap);
		String drugDosage = dosageAttributesMap.get("Drug Dosage");
		String drugQuantity = dosageAttributesMap.get("Drug Quantity");
		String drugFrequency = dosageAttributesMap.get("Drug Frequency");
		String packages = dosageAttributesMap.get("Packages");
		Object object = selectDosagePage.selectDosage(
				drugDosage, drugQuantity, drugFrequency,packages);
		System.out.println("class returned---->"+object.getClass().toString());
		if (object != null) {
			getLoginScenario().saveBean(PageConstants.SELECT_GENERIC_PAGE,
					object);
			
		}
	}
	
	@And("^the user selects low cost options in AARP site$")
	public void user_selects_lowCostOptions(DataTable drugAttributes) {
		String drugDosage = drugAttributes.getGherkinRows().get(0).getCells().get(0);
		String drugName = (String)getLoginScenario().getBean(DceCommonConstants.DRUG_NAME);
		System.out.println("drugName with dosage--->"+drugDosage);
		SelectGenericPage selectGenericPage = (SelectGenericPage) getLoginScenario().getBean(PageConstants.SELECT_GENERIC_PAGE);
		JSONObject selectGenericActualJson = selectGenericPage.genericDrugJson;
		JSONObject selectGenericExpectedJson = selectGenericPage.getExpectedData(drugName, drugDosage);
		
		try {
			JSONAssert.assertEquals(selectGenericExpectedJson, selectGenericActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ManageDrugPage manageDrugPage = selectGenericPage.selectGeneric(drugName);
		if (manageDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
					manageDrugPage);
			
		} 
	}
	@And("^the user views all the added drugs in the AARP site$")
	public void user_views_drugs_added() {
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario().getBean(PageConstants.MANAGE_DRUG_PAGE);
		
	}
	
	@And("^the user performs pharmacy search in the AARP site$")
	public void user_performs_paharmacySearch() {
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario().getBean(PageConstants.MANAGE_DRUG_PAGE);
		SelectPharmacyPage pharmacySearchPage = manageDrugPage.navigateToPharmacyPage();
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("navigated unsuccessfully to pharmacy page");
		}
	}
	
	@And("^the user selects the pharmacy type and distance in the AARP site$")
	public void user_selects_pharmacyType_and_distance(DataTable pharmacyAttributes) {
		List<DataTableRow> pharmacyAttributesRow = pharmacyAttributes
				.getGherkinRows();
		Map<String, String> pharmacyAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < pharmacyAttributesRow.size(); i++) {

			pharmacyAttributesMap.put(pharmacyAttributesRow.get(i).getCells()
					.get(0), pharmacyAttributesRow.get(i).getCells().get(1));
		}
		String pharmacyType = pharmacyAttributesMap.get("Pharmacy Type");
		String distance = pharmacyAttributesMap.get("Distance");
		SelectPharmacyPage pharmacySearchPage = (SelectPharmacyPage) getLoginScenario().getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage.selectPharmacyType(pharmacyType, distance);
	}
	
	@And("^the user views list of pharmacies available in the AARP site$")
	public void user_views_pharmacyList() {
		SelectPharmacyPage pharmacySearchPage = (SelectPharmacyPage) getLoginScenario().getBean(PageConstants.PHARMACY_SEARCH_PAGE);	
		String pharmacyList = pharmacySearchPage.getPharmacyList();
		System.out.println("pharmacyList====>"+pharmacyList);
	}
	
	
	@And("^the user selects from the list of pharmacies in the AARP site$")
	public void user_selects_pharmacy(DataTable pharmacyAttributes){
		SelectPharmacyPage pharmacySearchPage = (SelectPharmacyPage) getLoginScenario().getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		String pharmacyName = pharmacyAttributes.getGherkinRows().get(0).getCells().get(0);
		String pharmacyType = (String) getLoginScenario().getBean(DceCommonConstants.PHARMACY_TYPE);
		 ManageDrugPage manageDrugPage = pharmacySearchPage.selectPharmacy(pharmacyName, pharmacyType);
		 if (manageDrugPage != null) {
				getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
						manageDrugPage);
				Assert.assertTrue(true);
			} else {
				Assert.fail("pharmacy selection fails");
			}
		
	}
	
	@And("^the user views the plan results in the AARP site$")
	public void user_views_plan_results(){
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario().getBean(PageConstants.MANAGE_DRUG_PAGE);
		VPPPlanSummaryPage healthPlansPage  = manageDrugPage.navigateToPlanSummaryPage();
		if (healthPlansPage != null) {
			getLoginScenario().saveBean(PageConstants.HEALTH_PLANS_PAGE,
					healthPlansPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("plans result page does not accesssed successfully");
		}
	
	}
	
	/*@And("^user views the plan summary for the following plan in AARP site$")
	public void user_views_plan_summary(DataTable planAttributes){
		String planName  = planAttributes.getGherkinRows().get(0).getCells().get(0);
		PlansummaryPage plansummaryPage = (PlansummaryPage) getLoginScenario().getBean(DceCommonConstants.HEALTH_PLANS_PAGE);
		String planSummaryContent  = plansummaryPage.viewplans(planName);
		System.out.println("planSummaryContent=======>"+planSummaryContent);		
	}*/
	
	@And("^user views the plan details for the following plan in AARP site$")
	public void user_views_plan_details(DataTable planAttributes){
		String planName  = planAttributes.getGherkinRows().get(0).getCells().get(0);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.HEALTH_PLANS_PAGE);
		PlanDetailsPage planDetailsPage = null;//TOD: change the method implementation or pass planType here plansummaryPage.navigateToPlanDetails(planName);
		String planDetailsContent  = planDetailsPage.getPlanDetails();
		System.out.println("planDetailsContent============>"+planDetailsContent);
	}
	
	 @After
	    public void tearDown() {
		 WebDriver wd = (WebDriver) getLoginScenario().getBean("webDriver");
			wd.quit();
	    }
}
