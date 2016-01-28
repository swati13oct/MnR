package acceptancetests.dcevpp.ulayer;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.AddDrugPage;
import pages.acquisition.ulayer.GetStartedPage;
import pages.acquisition.ulayer.LocationSearchPage;
import pages.acquisition.ulayer.ManageDrugPage;
import pages.acquisition.ulayer.SelectDosagePage;
import pages.acquisition.ulayer.SelectGenericPage;
import pages.acquisition.ulayer.SelectPharmacyPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.dce.data.DceCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

public class DceVppSelectPharmacyAarpStepDefinition {


	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^user is on the AARP medicare home page$")
	public void landing_page_aarpsite1()
	{
		WebDriver wd = getLoginScenario().getWebDriver();
		
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
	}

	@When("^the user wants to performs drug search using the following details in AARP site$")	
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
		else
		{
			int year = Calendar.getInstance().get(Calendar.YEAR);
			System.out.println("year---->"+year);
			getLoginScenario().saveBean(DceCommonConstants.PLAN_YEAR, String.valueOf(year));
		}
		String zipCode = givenAttributesMap.get("Zip Code");
		String county = givenAttributesMap.get("County");
		
		getLoginScenario().saveBean(DceCommonConstants.ZIPCODE, zipCode);
		getLoginScenario().saveBean(DceCommonConstants.COUNTY_NAME, county);
		AcquisitionHomePage acqusitionHomePage =(AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		GetStartedPage getStartedPage = acqusitionHomePage
				.navigateToPrescriptionDrug();
		LocationSearchPage enterZipCode = getStartedPage.getStarted();
		AddDrugPage addDrugPage = enterZipCode.enterLoc(zipCode,county, planYear);
		if (addDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
					addDrugPage);
			
		} 
	}
	
	@When("^user wants to search the drug using drug initials in AARP site$")
	public void user_validated_drugInformation(DataTable givenAttributes) {
		String drugInitials = givenAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		addDrugPage.enterDrugInitials(drugInitials);
		
		/*Get actual Json*/
		JSONObject drugListActualJson = addDrugPage.drugListJson;
		getLoginScenario().saveBean(DceCommonConstants.DRUG_LIST_ACTUAL, drugListActualJson);
		
		/*Get Expected Json*/
		String fileName = drugInitials;
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY+File.separator+CommonConstants.SITE_ULAYER+File.separator+DceCommonConstants.ADD_DRUG_FLOW+File.separator;
		JSONObject drugListExpectedJson = addDrugPage.getExpectedData(fileName, directory);
		getLoginScenario().saveBean(DceCommonConstants.DRUG_LIST_EXPECTED, drugListExpectedJson);
		
		getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE, addDrugPage);
		
	}
	
	@Then("^user wants to validates the drug list that has above mentioned drug initials in AARP site$")
	public void validate_drugList()
	{
		JSONObject drugListExpectedJson = (JSONObject) getLoginScenario().getBean(DceCommonConstants.DRUG_LIST_EXPECTED);
		JSONObject drugListActualJson = (JSONObject) getLoginScenario().getBean(DceCommonConstants.DRUG_LIST_ACTUAL);
		try {
			JSONAssert.assertEquals(drugListExpectedJson, drugListActualJson, true);
		} catch (JSONException e) {
			System.out.println("Exception ocurred comparing actual and expected drug list : "+e);
		}
		
	}
	
	@And("^user wants to selects following drug in AARP site$")
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
			
			/*Get Actual Data*/
			JSONObject drugDosageActualJson = selectDosagePage.drugDosageJson;
			getLoginScenario().saveBean(DceCommonConstants.DRUG_DOSAGE_ACTUAL, drugDosageActualJson);
			
			/*Get Expected Data*/
			String fileName = drugName;
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY+File.separator+CommonConstants.SITE_ULAYER+File.separator+DceCommonConstants.DRUG_DOSAGE_FLOW+File.separator;
			JSONObject drugDosageExpectedJson = MRScenario.readExpectedJson(fileName, directory);
			getLoginScenario().saveBean(DceCommonConstants.DRUG_DOSAGE_EXPECTED, drugDosageExpectedJson);
			
			
		} 
	}
	
	@Then("^user wants to validates the available drug information in AARP site$")
	public void drug_dosage_validations()
	{
		JSONObject drugDosageExpectedJson = (JSONObject)getLoginScenario().getBean(DceCommonConstants.DRUG_DOSAGE_EXPECTED);
		JSONObject drugDosageActualJson = (JSONObject)getLoginScenario().getBean(DceCommonConstants.DRUG_DOSAGE_ACTUAL);
		
		try {
			JSONAssert.assertEquals(drugDosageExpectedJson, drugDosageActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@And("^user wants to selects the following dosage information in AARP site$")
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
		String quantity = dosageAttributesMap.get("Quantity");
		String drugFrequency = dosageAttributesMap.get("Drug Frequency");
		String packages = dosageAttributesMap.get("Packages");
		SelectGenericPage selectGenericPage = (SelectGenericPage)selectDosagePage.selectDosage(
				drugDosage, quantity, drugFrequency,packages);
		if (selectGenericPage != null) {
			getLoginScenario().saveBean(PageConstants.SELECT_GENERIC_PAGE,
					selectGenericPage);
		} 

	}
	
	
	@And("^user wants to selects low cost options for above selected drug in AARP site$")
	public void user_selects_lowCostOptions(DataTable drugAttributes) {
		String drugDosage = drugAttributes.getGherkinRows().get(0).getCells().get(0);
		getLoginScenario().saveBean(DceCommonConstants.DRUG_WITH_DOSAGE, drugDosage);
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
		ManageDrugPage manageDrugPage = selectGenericPage.selectGeneric(drugDosage);
		/*AddDrugPage addDrugFlowTest=  manageDrugPage.addDrugFlowCheck();
		addDrugFlowTest.validateAddDrugFlow();*/
		if (manageDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.MANAGE_DRUG_PAGE,
					manageDrugPage);
			
			JSONObject manageDrugActualJson = manageDrugPage.manageDrugJson;
			getLoginScenario().saveBean(DceCommonConstants.MANAGE_DRUG_ACTUAL, manageDrugActualJson);
			
			/*Get Expected data*/
			String fileName = drugDosage;
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY+File.separator+CommonConstants.SITE_ULAYER+File.separator+DceCommonConstants.MANAGE_DRUG_FLOW+File.separator;
			JSONObject manageDrugExpectedJson = manageDrugPage.getExpectedData(fileName, directory);
			getLoginScenario().saveBean(DceCommonConstants.MANAGE_DRUG_EXPECTED, manageDrugExpectedJson);
		} 
		
	}
	@Then("^user wants to validates all the drugs added in dce flow in AARP site$")
	public void user_views_drugs_added() {
		JSONObject manageDrugActualJson = (JSONObject) getLoginScenario().getBean(DceCommonConstants.MANAGE_DRUG_ACTUAL);
		System.out.println("manageDrugActualJson after drug addition---->"+manageDrugActualJson);
		JSONObject manageDrugExpectedJson = (JSONObject) getLoginScenario().getBean(DceCommonConstants.MANAGE_DRUG_EXPECTED);
		System.out.println("manageDrugExpectedJson after drug addition---->"+manageDrugExpectedJson);
		
		try {
			JSONAssert.assertEquals(manageDrugExpectedJson, manageDrugActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@When("^user wants to search for pharmacies in dce flow in AARP site$")
	public void user_performs_paharmacySearch() {
		ManageDrugPage manageDrugPage = (ManageDrugPage) getLoginScenario().getBean(PageConstants.MANAGE_DRUG_PAGE);
		SelectPharmacyPage selectPharmacyPage = manageDrugPage.navigateToPharmacyPage();
		if (selectPharmacyPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					selectPharmacyPage);
			
			/*Get Actual Data*/
			JSONObject availablePharmaciesActualJson = selectPharmacyPage.availablePharmaciesJson;
			getLoginScenario().saveBean(DceCommonConstants.AVAILABLE_PHARMACIES_ACTUAL, availablePharmaciesActualJson);
			
			/*Get Expected Data*/
			String zipcode = (String)getLoginScenario().getBean(DceCommonConstants.ZIPCODE);
			String county =(String) getLoginScenario().getBean(DceCommonConstants.COUNTY_NAME);
			
			String miles = "15 miles";
			String pharmacyType = "All Pharmacies";
			String fileName = pharmacyType;
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY+File.separator+CommonConstants.SITE_ULAYER+File.separator+DceCommonConstants.SELECT_PHARMACY_FLOW+File.separator+zipcode+File.separator+county+File.separator+miles+File.separator;
			JSONObject availablePharmaciesExpectedJson = selectPharmacyPage.getExpectedData(fileName,directory);
			getLoginScenario().saveBean(DceCommonConstants.AVAILABLE_PHARMACIES_EXPECTED, availablePharmaciesExpectedJson);
			
			
		} 
	}
	
	@Then("^user wants to validates the available pharmacies in the selected zipcode in AARP site$")
	public void validate_available_pharmacies(){
		JSONObject availablePharmaciesActualJson =(JSONObject) getLoginScenario().getBean(DceCommonConstants.AVAILABLE_PHARMACIES_ACTUAL);
		JSONObject availablePharmaciesExpectedJson = (JSONObject)getLoginScenario().getBean(DceCommonConstants.AVAILABLE_PHARMACIES_EXPECTED);
		try {
			JSONAssert.assertEquals(availablePharmaciesExpectedJson, availablePharmaciesActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@And("^user wants to selects the pharmacy type and distance in AARP site$")
	public void user_selects_pharmacyType_and_distance(DataTable pharmacyAttributes) {
		List<DataTableRow> pharmacyAttributesRow = pharmacyAttributes
				.getGherkinRows();
		Map<String, String> pharmacyAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < pharmacyAttributesRow.size(); i++) {

			pharmacyAttributesMap.put(pharmacyAttributesRow.get(i).getCells()
					.get(0), pharmacyAttributesRow.get(i).getCells().get(1));
		}
		String pharmacyType = pharmacyAttributesMap.get("Pharmacy Type");
		getLoginScenario().saveBean(DceCommonConstants.PHARMACY_TYPE, pharmacyType);
		String distance = pharmacyAttributesMap.get("Distance");
		getLoginScenario().saveBean(DceCommonConstants.DISTANCE, distance);
		
		SelectPharmacyPage pharmacySearchPage = (SelectPharmacyPage) getLoginScenario().getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		SelectPharmacyPage updatedPharmacyPage = pharmacySearchPage.searchPharmacies(pharmacyType, distance);
		
		/*Get Actual Data*/
		JSONObject availablePharmaciesActualJson = updatedPharmacyPage.availablePharmaciesJson;
		getLoginScenario().saveBean(DceCommonConstants.AVAILABLE_PHARMACIES_ACTUAL, availablePharmaciesActualJson);
		
		/*Get Expected Data*/
		String zipcode = (String)getLoginScenario().getBean(DceCommonConstants.ZIPCODE);
		String county =(String) getLoginScenario().getBean(DceCommonConstants.COUNTY_NAME);
		String fileName = pharmacyType;
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY+File.separator+CommonConstants.SITE_ULAYER+File.separator+DceCommonConstants.SELECT_PHARMACY_FLOW+File.separator+zipcode+File.separator+county+File.separator+distance+File.separator;
		JSONObject availablePharmaciesExpectedJson = updatedPharmacyPage.getExpectedData(fileName,directory);
		getLoginScenario().saveBean(DceCommonConstants.AVAILABLE_PHARMACIES_EXPECTED, availablePharmaciesExpectedJson);
		
	}
	
	@Then("^user wants to validates the available pharmacies based on selection made above in AARP site$")
	public void user_views_pharmacyList() {
		JSONObject availablePharmaciesActualJson =(JSONObject) getLoginScenario().getBean(DceCommonConstants.AVAILABLE_PHARMACIES_ACTUAL);
		JSONObject availablePharmaciesExpectedJson = (JSONObject)getLoginScenario().getBean(DceCommonConstants.AVAILABLE_PHARMACIES_EXPECTED);
		try {
			JSONAssert.assertEquals(availablePharmaciesExpectedJson, availablePharmaciesActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@When("^user wants to selects a pharmacy from the list of pharmacies in AARP site$")
	public void user_selects_pharmacy(DataTable pharmacyAttributes){
		
		SelectPharmacyPage pharmacySearchPage = (SelectPharmacyPage) getLoginScenario().getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		String pharmacyName = pharmacyAttributes.getGherkinRows().get(0).getCells().get(0);
		getLoginScenario().saveBean(DceCommonConstants.PHARMACY_NAME, pharmacyName);
		 ManageDrugPage manageDrugPage = pharmacySearchPage.selectPharmacy(pharmacyName);
		 manageDrugPage.swithedToSelectPharmacyTab();
		 
		 SelectPharmacyPage pharmacySearch = manageDrugPage.navigateToUpdatedPharmacyPage();
		 JSONObject availablePharmaciesActualJson = pharmacySearch.availablePharmaciesJson;
		 getLoginScenario().saveBean(DceCommonConstants.AVAILABLE_PHARMACIES_ACTUAL, availablePharmaciesActualJson);
		 
		 String zipcode = (String)getLoginScenario().getBean(DceCommonConstants.ZIPCODE);
		 String miles = "25 miles";
			String county =(String) getLoginScenario().getBean(DceCommonConstants.COUNTY_NAME);
			String fileName = "PharmacySelected";
			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY+File.separator+CommonConstants.SITE_ULAYER+File.separator+DceCommonConstants.SELECT_PHARMACY_FLOW+File.separator+zipcode+File.separator+county+File.separator+miles+File.separator;
			JSONObject availablePharmaciesExpectedJson = pharmacySearchPage.getExpectedData(fileName,directory);
			getLoginScenario().saveBean(DceCommonConstants.AVAILABLE_PHARMACIES_EXPECTED, availablePharmaciesExpectedJson);
			System.out.println("=====availablePharmaciesActualJson======="+availablePharmaciesActualJson);
			System.out.println("======availablePharmaciesExpectedJson======"+availablePharmaciesExpectedJson);
			try {
				JSONAssert.assertEquals(availablePharmaciesActualJson, availablePharmaciesExpectedJson, true);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Then("^user wants to validates the selected drug and selected pharmacy on manage drug list page in AARP site$")
	public void validate_selected_drug_pharmacy()
	{
		JSONObject manageDrugActualJson = (JSONObject)getLoginScenario().getBean(DceCommonConstants.MANAGE_DRUG_ACTUAL);
		System.out.println("manageDrugActualJson after selecting drug and pharmacy--->"+manageDrugActualJson);
		JSONObject manageDrugExpectedJson = (JSONObject)getLoginScenario().getBean(DceCommonConstants.MANAGE_DRUG_EXPECTED);
		System.out.println("manageDrugExpectedJson after selecting drug and pharmacy--->"+manageDrugExpectedJson);
		
		try {
			JSONAssert.assertEquals(manageDrugExpectedJson, manageDrugActualJson, true);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
