/**
 * 
 */
package acceptancetests.dceretiree;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.uhcretiree.AcquisitionHomePage;
import pages.acquisition.uhcretiree.DrugCoverageOptionsPage;
import pages.acquisition.uhcretiree.EnterDrugPage;
import pages.acquisition.uhcretiree.RetireesOfSelectedPlans;
import pages.acquisition.uhcretiree.SelectDosagePage;
import pages.acquisition.uhcretiree.SelectFormularyPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.dceretiree.data.DCERetireeCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en_au.When;
import cucumber.table.DataTable;

/**
 * @author eb
 *
 */


public class DCERetireeStepDefinition {



	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	} 


	@Given("^user navigates to the UHCRetiree site$")
	public void click_drugsearch() {
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		AcquisitionHomePage uhcRetireeAcqHomePage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_HOME_PAGE, uhcRetireeAcqHomePage);


	}

	@When("^the user navigates to drug search in UHCRetiree site$")
	public void click_prescriptionsDrugLink() {
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.UHCRETIREE_ACQ_HOME_PAGE);

		SelectFormularyPage selectFormularyPage = aquisitionhomepage.prescriptionsDrugLink();
		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_Formulary_PAGE, selectFormularyPage);
		JSONObject selectFormularyActualJSON = selectFormularyPage.formularyListJson;

		/* Get expected data */
		String fileName = "formularyList";
		String directory = CommonConstants.RETIREE_EXPECTED_DIRECTORY
				+ File.separator
				+ DCERetireeCommonConstants.FORMULARY_DRUG_SEARCH_FLOW_NAME
				+ File.separator;
		JSONObject selectFormularyExpectedJSON = MRScenario.readExpectedJson(
				fileName, directory);

		Assert.assertEquals(selectFormularyExpectedJSON.toString(), selectFormularyActualJSON.toString());
	}
	
	@When("^the user selects on the group from the Retirees of selected group plans drop down$")
	public void the_user_selects_on_the_group_from_the_Retirees_of_selected_group_plans_drop_down(DataTable givenAttributes) {
		String groupName = givenAttributes
				.getGherkinRows().get(0).getCells().get(0);
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.UHCRETIREE_ACQ_HOME_PAGE);
		RetireesOfSelectedPlans retireesOfSelectedPlans = aquisitionhomepage.openDropDown(groupName);
		if (retireesOfSelectedPlans != null) {
			getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_RETIREES_OF_SELECTED_PLANS_HOME_PAGE, retireesOfSelectedPlans);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error");
		}		
	}

	@And("^the user clicks on drugLinks available on the links page in UHCRetiree site$")
	public void click_specificDrugFLowLink(DataTable givenAttributes) 
	{
		String drugName = givenAttributes
				.getGherkinRows().get(0).getCells().get(0);
		SelectFormularyPage selectFormularyPage = (SelectFormularyPage) getLoginScenario()
				.getBean(PageConstants.UHCRETIREE_ACQ_Formulary_PAGE);
		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_DRUGLINK, drugName);
		
		EnterDrugPage enterDrugPage = selectFormularyPage.specificDrugFLowLink(drugName); 
		//added below
		if (enterDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_ENTER_DRUG_PAGE,
					enterDrugPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error");
		}
	} 

	@And("^the user clicks on the Understand prescription drug coverage options links")
	public void click_understandPrescriptionLink() 
	{
		RetireesOfSelectedPlans retireesOfSelectedPlans = (RetireesOfSelectedPlans) getLoginScenario()
				.getBean(PageConstants.UHCRETIREE_ACQ_RETIREES_OF_SELECTED_PLANS_HOME_PAGE);
		DrugCoverageOptionsPage drugCoverageOptionsPage = retireesOfSelectedPlans.clickDrugCoverageOptionsLink();
		if (drugCoverageOptionsPage != null) {
			getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_DRUG_COVERAGE_OPTIONS_PAGE, drugCoverageOptionsPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error");
		}	
		
	}
	@And("^the user clicks on the See if my medication is covered link")
	public void click_seeIfMyMedicationIsCovered()
	{
		DrugCoverageOptionsPage drugCoverageOptionsPage = (DrugCoverageOptionsPage) getLoginScenario()
				.getBean(PageConstants.UHCRETIREE_ACQ_DRUG_COVERAGE_OPTIONS_PAGE);
		EnterDrugPage enterDrugPage = drugCoverageOptionsPage.clickSeeIfMyMedicationLink();
		if (enterDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_ENTER_DRUG_PAGE,
					enterDrugPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error");
		}
	}
	@And("^the user search the drug with drugInitials in UHCRetiree site$")
	public void the_user_search_the_drug_with_drugInitials_in_UHCRetiree_site(DataTable givenAttributes)
		{
			String drugName = givenAttributes
					.getGherkinRows().get(0).getCells().get(0);
			EnterDrugPage enterDrugPage = (EnterDrugPage) getLoginScenario()
					.getBean(PageConstants.UHCRETIREE_ACQ_ENTER_DRUG_PAGE);
			if(enterDrugPage != null){
				EnterDrugPage actualFormularyDrugs = enterDrugPage.enterDrugName(drugName);				
				getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_SEARCH_RESULTS_PAGE,
						actualFormularyDrugs);
				/* Get expected data */
				String fileName = drugName.toLowerCase() + "searchresults";
				String directory = CommonConstants.RETIREE_EXPECTED_DIRECTORY
						+ File.separator
						+ DCERetireeCommonConstants.FORMULARY_DRUG_SEARCH_FLOW_NAME
						+ File.separator;

				JSONObject selectFormularyExpectedJSON = MRScenario.readExpectedJson(
						fileName, directory);

				Assert.assertEquals(selectFormularyExpectedJSON.toString(), actualFormularyDrugs.formularyListJson.toString());
			}
		}
	
	
	@And("^the user selects drugName in the drug list in UHCRetiree site")
	public void select_drugName(DataTable drugNameAttributes)
	{			
		String drugName = drugNameAttributes
				.getGherkinRows().get(0).getCells().get(0);
		if (drugName.contains(" ")){
			drugName = drugName.replace(' ', '_');
		}
		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_DRUG_NAME, drugName);
		EnterDrugPage drugSearchPage = (EnterDrugPage) getLoginScenario()
				.getBean(PageConstants.UHCRETIREE_ACQ_SEARCH_RESULTS_PAGE);
		SelectDosagePage selectDosagePage;
		if ( drugSearchPage.formularyListJson.has("DrugName")){
			selectDosagePage = drugSearchPage.clickDrugName(drugName, true);
		} else {
			selectDosagePage = drugSearchPage.clickDrugName(drugName, false);					
		}
		if(selectDosagePage != null){
			getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_DRUG_DETAILS_PAGE, selectDosagePage);
			
			/*Get Actual Data*/
			JSONObject drugDosageActualJson = selectDosagePage.drugDosageJson;
			getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_DRUG_DOSAGE_ACTUAL, drugDosageActualJson);
			String drugLink =  (String) getLoginScenario().getBean(PageConstants.UHCRETIREE_ACQ_DRUGLINK);
			System.out.println(getLoginScenario().getBean(PageConstants.UHCRETIREE_ACQ_ENTER_DRUG_PAGE));
			/*Get Expected Data*/
			String fileName = drugName.toLowerCase() + "_expectedDrugDosage";
			String directory = CommonConstants.RETIREE_EXPECTED_DIRECTORY
					+ File.separator
					+ DCERetireeCommonConstants.UHCRETIREE_DRUG_DOSAGES
					+ File.separator
					+ drugLink
					+ File.separator;
				
			JSONObject drugDosageExpectedJson = MRScenario.readExpectedJson(fileName, directory);
			getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_DRUG_DOSAGE_EXPECTED, drugDosageExpectedJson);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error");
		}				
			
	}	
	
	@Then("^the user validates drug dosages in UHCRetiree site")
	public void validate_drugName()
	{
		JSONObject drugDosageExpectedJson = (JSONObject) getLoginScenario()
				.getBean(PageConstants.UHCRETIREE_ACQ_DRUG_DOSAGE_EXPECTED);
		JSONObject drugDosageActualJson = (JSONObject) getLoginScenario()
				.getBean(PageConstants.UHCRETIREE_ACQ_DRUG_DOSAGE_ACTUAL);
		
		try {
			Assert.assertEquals(drugDosageExpectedJson.get("selectedDrug").toString(), drugDosageActualJson.get("selectedDrug").toString());
			Assert.assertEquals(drugDosageExpectedJson.get("genericTable").toString(), drugDosageActualJson.get("genericTable").toString());
			if (drugDosageExpectedJson.has("bonustable") || drugDosageActualJson.has("bonustable")){
				Assert.assertEquals(drugDosageExpectedJson.get("bonustable").toString(), drugDosageActualJson.get("bonustable").toString());
			}
			if (drugDosageExpectedJson.has("brandTable") || drugDosageActualJson.has("brandTable")){
				Assert.assertEquals(drugDosageExpectedJson.get("brandTable").toString(), drugDosageActualJson.get("brandTable").toString());
			}
		//	JSONAssert.assertEquals(drugDosageExpectedJson, drugDosageActualJson, true);
		} catch (JSONException e){
			System.out
			.println("error comparing drug dosages actual and expected response"
					+ e);
			
		}
	}
	
	@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(
				CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}
}
