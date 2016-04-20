/**
 * 
 */
package acceptancetests.dceretiree;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.OurPlansPage;
import pages.acquisition.uhcretiree.AcquisitionHomePage;
import pages.acquisition.uhcretiree.DrugDetailsPage;
import pages.acquisition.uhcretiree.EnterDrugPage;
import pages.acquisition.uhcretiree.SelectDosagePage;
import pages.acquisition.uhcretiree.SelectFormularyPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.dceretiree.data.DCERetireeCommonConstants;
import acceptancetests.globalfooter.data.AcquistionCommonConstants;
import acceptancetests.lookupzipcode.data.ZipLookupCommonConstants;
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

	@And("^the user clicks on drugLinks available on the links page in UHCRetiree site$")
	public void click_specificDrugFLowLink(DataTable givenAttributes) {
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
	//	JSONObject selectEnterDrugPage = enterDrugPage.
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
		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_DRUG_NAME, drugName);
		EnterDrugPage drugSearchPage = (EnterDrugPage) getLoginScenario()
				.getBean(PageConstants.UHCRETIREE_ACQ_SEARCH_RESULTS_PAGE);
		SelectDosagePage selectDosagePage;
		/*If it page is already on Drug Details page, pass false to clickDrugName so it does not click something that doesn't exist. 
		* Otherwise send true so it clicks on the appropriate drug name*/
		try {
			if ( drugSearchPage.formularyListJson.has("DrugName") && drugSearchPage.formularyListJson.get("DrugName").equals(drugName)){
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
				//Assert.assertEquals(drugDosageExpectedJson.toString(), drugDosageExpectedJson.toString());
			} else {
				Assert.fail("Error");
			}	
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			JSONAssert.assertEquals(drugDosageExpectedJson, drugDosageActualJson, true);
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
