package acceptancetests.dcevpp.bluelayer;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.AddDrugPage;
import pages.acquisition.bluelayer.EnterZipCodePage;
import pages.acquisition.bluelayer.EstimateDrugCostPage;
import pages.acquisition.bluelayer.ManageDrugPage;
import pages.acquisition.bluelayer.PharmacySearchPage;
import pages.acquisition.bluelayer.SelectDosagePage;
import pages.acquisition.bluelayer.SelectGenericPage;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;
import pages.acquisition.ulayer.SelectPharmacyPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.dce.data.DceCommonConstants;
import acceptancetests.vpp.data.VPPCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

/**
 * @author pagarwa5
 *
 */

public class DceVppPlanSummaryEditDrugUmsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^the zipcode and county information for DCE to Vpp Plan summary flow in UMS site$")
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
		getLoginScenario().saveBean(DceCommonConstants.ZIPCODE, zipCode);
		getLoginScenario().saveBean(DceCommonConstants.COUNTY_NAME, county);
		WebDriver wd = getLoginScenario().getWebDriver();
		AcquisitionHomePage acqusitionHomePage = new AcquisitionHomePage(wd);
		EstimateDrugCostPage estimateDrugCost = acqusitionHomePage
				.switchToPrescriptionDrug();
		EnterZipCodePage enterZipCode = estimateDrugCost.getStarted();
		AddDrugPage addDrugPage = enterZipCode.getZipCodeCounty(zipCode,county,planYear);

		if (addDrugPage != null) {
			getLoginScenario().saveBean("webDriver", wd);
			getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
					addDrugPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("unsuccessfull navigation to add drug page");
		}
	}

	@When("^user search the drug using the drug initials in UMS site$")
	public void user_validated_drugInformation(DataTable givenAttributes) {
		String drugInitials = givenAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		addDrugPage.enterDrugInitials(drugInitials);
		getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
				addDrugPage);
	}

	@And("^user access the drug list with having 5 drugs in UMS site$")
	public void drug_list_with_drugs() {
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		String drugDropDownList = addDrugPage.getDrugList();
		System.out.println("drugList=======>" + drugDropDownList);
		getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
				addDrugPage);

	}

	@And("^the user selects the following drug in UMS site$")
	public void user_selects_drugname_druglist(DataTable drugNameAttributes) {

		String drugName = drugNameAttributes.getGherkinRows().get(0).getCells()
				.get(0);
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

	@And("^user selects the following dosage info in UMS site$")
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
		String drugDosage = dosageAttributesMap.get("Drug Dosage");
		getLoginScenario().saveBean(DceCommonConstants.DRUG_WITH_DOSAGE,
				drugDosage);
		String drugQuantity = dosageAttributesMap.get("Drug Quantity");
		String drugFrequency = dosageAttributesMap.get("Drug Frequency");
		String packages = dosageAttributesMap.get("Packages");
		
		/*
		 * 
		 * TODO: CodeMonkeys Team: Please refer the Ulayer code to develop bluelayer code.
		 * 
		 * As of now passing making temporary changes, added cast to SelectGenericPage
		 * 
		 * */
		SelectGenericPage selectGenericPage = (SelectGenericPage) selectDosagePage.selectDosage(
				drugDosage, drugQuantity, drugFrequency,packages);
		if (selectGenericPage != null) {
			getLoginScenario().saveBean(PageConstants.SELECT_GENERIC_PAGE,
					selectGenericPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("dosage selection unsuccessful");
		}

	}
	
	@And("^the user selects low cost options in UMS site$")
	public void user_selects_lowCostOptions(DataTable drugAttributes) {
		String drugName = drugAttributes.getGherkinRows().get(0).getCells().get(0);
		SelectGenericPage selectGenericPage = (SelectGenericPage) getLoginScenario().getBean(PageConstants.SELECT_GENERIC_PAGE);
		/*
		 * TODO: CodeMonkeys Team: Please refer the Ulayer code to develop bluelayer code. As per the bluelayer flow Manage drug page is returned after selecting generic drug
		 * 
		 * As of now passing making temporary changes to remove errors so that Ulayer code can be tested
		 * 
		 * 
		 * */
		/*
		 * Start of code comment
		 * 
		 * AddDrugPage addDrugPage = selectGenericPage.selectGeneric(drugName);
		if (addDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
					addDrugPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("generic drug selection unsuccessful");
		}
		
		*End of code comment
		*/
		
	}
	@And("^user views all the drugs got added in UMS site$")
	public void user_views_drugs_added() {
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(PageConstants.ADD_DRUG_PAGE);
		String drugsAdded  = addDrugPage.validateDrugsAdded();
		System.out.println("drugsAdded"+ drugsAdded);
		getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
				addDrugPage);
	}
	
	@And("^user perform the pharmacy search in UMS site$")
	public void user_performs_paharmacySearch() {
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(PageConstants.ADD_DRUG_PAGE);
		
		/*
		 * TODO: CodeMonkeys Team: Please refer the Ulayer code to develop bluelayer code, As per bluelayer flow the above returned manage drug page is used to navigate to Pharmacy search page
		 * 
		 * As of now passing making temporary changes to remove errors so that Ulayer code can be tested
		 * 
		 * 
		 * */
		
		/*START of  code comment
		PharmacySearchPage pharmacySearchPage = addDrugPage.navigateToPharmacyPage();
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("navigated unsuccessfully to pharmacy page");
		}
		END of code comment
		*/
	}
	
	@And("^user selects pharmacy type and distance in UMS site$")
	public void user_selects_pharmacyType_and_distance(DataTable pharmacyAttributes) {
		List<DataTableRow> pharmacyAttributesRow = pharmacyAttributes
				.getGherkinRows();
		Map<String, String> pharmacyAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < pharmacyAttributesRow.size(); i++) {

			pharmacyAttributesMap.put(pharmacyAttributesRow.get(i).getCells()
					.get(0), pharmacyAttributesRow.get(i).getCells().get(1));
		}
		String pharmacyType = pharmacyAttributesMap.get("Pharmacy Type");
		getLoginScenario().saveBean(DceCommonConstants.PHARMACY_TYPE,
				pharmacyType);
		String distance = pharmacyAttributesMap.get("Distance");
		getLoginScenario().saveBean(DceCommonConstants.DISTANCE, distance);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario().getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacySearchPage updatedPharmacyPage = pharmacySearchPage.searchPharmacies(pharmacyType, distance);
		
		if (updatedPharmacyPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					updatedPharmacyPage);
			/* Get Actual Data */
			JSONObject availablePharmaciesActualJson = updatedPharmacyPage.availablePharmaciesJson;
			getLoginScenario().saveBean(
					DceCommonConstants.AVAILABLE_PHARMACIES_ACTUAL,
					availablePharmaciesActualJson);

			/* Get Expected Data */
			String zipcode = (String) getLoginScenario().getBean(
					DceCommonConstants.ZIPCODE);
			String county = (String) getLoginScenario().getBean(
					DceCommonConstants.COUNTY_NAME);

			String miles = "15 miles";
			//String pharmacyType = "All Pharmacies";
			String fileName = pharmacyType;
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
					+ File.separator + CommonConstants.SITE_BLUELAYER
					+ File.separator + DceCommonConstants.SELECT_PHARMACY_FLOW
					+ File.separator + zipcode + File.separator + county
					+ File.separator + miles + File.separator;
			JSONObject availablePharmaciesExpectedJson = updatedPharmacyPage
					.getExpectedData(fileName, directory);
			getLoginScenario().saveBean(
					DceCommonConstants.AVAILABLE_PHARMACIES_EXPECTED,
					availablePharmaciesExpectedJson);

		}

		
	}
	
	@Then("^the user validates the available pharmacies in the selected zipcode in UMS site$")
	public void validate_available_pharmacies() {
		JSONObject availablePharmaciesActualJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.AVAILABLE_PHARMACIES_ACTUAL);
		JSONObject availablePharmaciesExpectedJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.AVAILABLE_PHARMACIES_EXPECTED);
		try {
			JSONAssert.assertEquals(availablePharmaciesExpectedJson,
					availablePharmaciesActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@And("^user views list of pharmacies available in UMS site$")
	public void user_views_pharmacyList() {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario().getBean(PageConstants.PHARMACY_SEARCH_PAGE);	
		String pharmacyList = pharmacySearchPage.getPharmacyList();
		System.out.println("pharmacyList====>"+pharmacyList);
	}
	
	
	@And("^user selects the pharmacy from the list of pharmacies in UMS site$")
	public void user_selects_pharmacy(DataTable pharmacyAttributes){
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario().getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		String pharmacyName = pharmacyAttributes.getGherkinRows().get(0).getCells().get(0);
		getLoginScenario().saveBean(DceCommonConstants.PHARMACY_NAME,
				pharmacyName);
		 AddDrugPage addDrugPage = pharmacySearchPage.selectPharmacy(pharmacyName);
		 
		if (addDrugPage != null) {
				getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
						addDrugPage);
				Assert.assertTrue(true);
			} else {
				Assert.fail("pharmacy selection fails");
			}
		 
	}
	
	@When("^user switches to pharmacy page again in UMS site$")
	public void user_switches_to_pharmacy(){
	
		/*
		 * TODO: CodeMonkeys Team: Please refer the Ulayer code to develop bluelayer code. As per the bluelayer flow we should be on Manage drug page to navigate to search pharmacy
		 * 
		 * As of now passing making temporary changes to remove errors so that Ulayer code can be tested
		 * 
		 * 
		 * */
		/*
		 * START of code comment
		 * 
		 * AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(PageConstants.ADD_DRUG_PAGE);
		addDrugPage.swithedToSelectPharmacyTab();
		 
		 PharmacySearchPage pharmacySearch = addDrugPage.navigateToUpdatedPharmacyPage();
		 
		 
			
		 JSONObject availablePharmaciesActualJson = pharmacySearch.availablePharmaciesJson;
		 getLoginScenario().saveBean(DceCommonConstants.AVAILABLE_PHARMACIES_ACTUAL, availablePharmaciesActualJson);
		 
		 String zipcode = (String)getLoginScenario().getBean(DceCommonConstants.ZIPCODE);
		 String miles = "15 miles";
			String county =(String) getLoginScenario().getBean(DceCommonConstants.COUNTY_NAME);
			String fileName = "PharmacySelected";
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY+File.separator+CommonConstants.SITE_BLUELAYER+File.separator+DceCommonConstants.SELECT_PHARMACY_FLOW+File.separator+zipcode+File.separator+county+File.separator+miles+File.separator;
			JSONObject availablePharmaciesExpectedJson = pharmacySearch.getExpectedData(fileName,directory);
			getLoginScenario().saveBean(DceCommonConstants.AVAILABLE_PHARMACIES_EXPECTED, availablePharmaciesExpectedJson);
			System.out.println("=====availablePharmaciesActualJson======="+availablePharmaciesActualJson);
			System.out.println("======availablePharmaciesExpectedJson======"+availablePharmaciesExpectedJson);
			
			
			*END of code comment
			*
			*/
	}
	
	@Then("^the user validates the order of pharmacies in UMS site$")
	public void user_validates_pharmacy(){
		
		JSONObject availablePharmaciesActualJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.AVAILABLE_PHARMACIES_ACTUAL);
		JSONObject availablePharmaciesExpectedJson = (JSONObject) getLoginScenario()
				.getBean(DceCommonConstants.AVAILABLE_PHARMACIES_EXPECTED);
		
		try {
			JSONAssert.assertEquals(availablePharmaciesActualJson, availablePharmaciesExpectedJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@And("^user view the plan results in UMS site$")
	public void user_views_plan_results(){
		
		/*
		 * TODO: CodeMonkeys Team: Please refer the Ulayer code to develop bluelayer code. As per the bluelayer flow we should be on Manage drug page to navigate to search plans
		 * 
		 * As of now passing making temporary changes to remove errors so that Ulayer code can be tested
		 * 
		 * 
		 * */
		
		/*
		 * START of code comment
		 * 
		 * AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(PageConstants.ADD_DRUG_PAGE);
		VPPPlanSummaryPage healthPlansPage  = addDrugPage.navigateToHealthPlansPage();
		if (healthPlansPage != null) {
			getLoginScenario().saveBean(PageConstants.HEALTH_PLANS_PAGE,
					healthPlansPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("plans result page does not accesssed successfully");
		}
		
		*
		*END of code comment
		*/
	
	}
	
	@And("^user view the plan summary for the following plan in UMS site$")
	public void user_views_plan_summary(DataTable planAttributes){
		String planName  = planAttributes.getGherkinRows().get(0).getCells().get(0);
		getLoginScenario().saveBean(VPPCommonConstants.PLAN_NAME, planName);
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario().getBean(PageConstants.HEALTH_PLANS_PAGE);
		String planSummaryContent  = plansummaryPage.viewplans(planName);
		System.out.println("planSummaryContent=======>"+planSummaryContent);		
	}
	
	@And("^the user views plans of the below plan type in UMS site$")
	public void user_performs_planSearch_in_aarp_site(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}

		String plantype = givenAttributesMap.get("Plan Type");
		
		VPPPlanSummaryPage plansummaryPage = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.HEALTH_PLANS_PAGE);
		plansummaryPage = plansummaryPage.viewPlanSummary(plantype);

	}

	@When("^the user click the Edit Drug List link in plan summary page of UMS site$")
	public void user_clicks_edit_drug_list() {
		VPPPlanSummaryPage planSummaryPage = (VPPPlanSummaryPage)getLoginScenario().getBean(PageConstants.HEALTH_PLANS_PAGE);
		String planName = getLoginScenario().getBean(VPPCommonConstants.PLAN_NAME).toString();
		
		ManageDrugPage manageDrugListPage = planSummaryPage.navigateToEditDrugList(planName);
		getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE, manageDrugListPage);
		JSONObject manageDrugExpectedJson = null;
		JSONObject manageDrugListActualJson = null;
		if(manageDrugListPage!=null){
			manageDrugListActualJson = manageDrugListPage.manageDrugJson;
			
			String pharmacyName = (String) getLoginScenario().getBean(DceCommonConstants.PHARMACY_NAME);
			
			String fileName = pharmacyName;
			String drugWithDosage = (String)getLoginScenario().getBean(DceCommonConstants.DRUG_WITH_DOSAGE);
			String pharmacyType = (String)getLoginScenario().getBean(DceCommonConstants.PHARMACY_TYPE);
			String distance = (String)getLoginScenario().getBean(DceCommonConstants.DISTANCE);
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY+File.separator+CommonConstants.SITE_BLUELAYER+File.separator+DceCommonConstants.MANAGE_DRUG_FLOW+File.separator+planName+File.separator+drugWithDosage+File.separator;
			
				manageDrugExpectedJson  = manageDrugListPage.getExpectedData(fileName, directory);
			getLoginScenario().saveBean(DceCommonConstants.MANAGE_DRUG_EXPECTED, manageDrugExpectedJson);
		}
		
		try {
			JSONAssert.assertEquals(manageDrugExpectedJson, manageDrugListActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
   }
	
	@Then("^user validated estimated drug cost and tooltip in UMS site$")
	public void user_validates_estimated_drug_cost() {
		
		ManageDrugPage manageDrugPage = (ManageDrugPage)getLoginScenario().getBean(PageConstants.MANAGE_DRUG_PAGE);
		manageDrugPage.toolTipValidation();
		System.out.println("validated");
	}


	
	 @After
	    public void tearDown() {
		 WebDriver wd = (WebDriver) getLoginScenario().getBean("webDriver");
			wd.quit();
	    }
}
