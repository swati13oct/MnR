/**
 * 
 */
package acceptancetests.dceretiree;

import java.io.File;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.uhcretiree.AcquisitionHomePage;
import pages.acquisition.uhcretiree.EnterDrugPage;
import pages.acquisition.uhcretiree.SelectFormularyPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.dceretiree.data.DCERetireeCommonConstants;
import acceptancetests.globalfooter.data.AcquistionCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
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

		Assert.assertEquals(selectFormularyExpectedJSON, selectFormularyActualJSON);


	}

	@And("^the user clicks on drugLinks available on the links page in UHCRetiree site$")
	public void click_specificDrugFLowLink() {
		SelectFormularyPage selectFormularyPage = (SelectFormularyPage) getLoginScenario()
				.getBean(PageConstants.UHCRETIREE_ACQ_Formulary_PAGE);

		EnterDrugPage enterDrugPage = selectFormularyPage.specificDrugFLowLink(); 
	} 

	//	@And("^the user search the drug with drugInitials in UHCRetiree site$")
	//	public void enterDrugName(DataTable givenAttributes)
	//	{
	//		String drugName = givenAttributes
	//				.getGherkinRows().get(0).getCells().get(0);
	//		EnterDrugPage enterDrugPage = (EnterDrugPage) getLoginScenario()
	//				.getBean(PageConstants.UHCRETIREE_ACQ_ENTER_DRUG_PAGE);
	//		if(enterDrugPage != null){
	////			JSONObject ourPlansDropdownActualJson = enterDrugPage.enterDrugName(drugName);
	//
	//			/* Get expected data */
	//			String fileName = "ourPlansDropdownErrorExpected";
	//			String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY
	//					+ File.separator + CommonConstants.SITE_BLUELAYER
	//					+ File.separator
	//					+ AcquistionCommonConstants.HEADER_FLOW_NAME
	//					+ File.separator;
	//			JSONObject ourPlansDropdownExpectedJson = MRScenario.readExpectedJson(
	//					fileName, directory);
	// 
	//			getLoginScenario().saveBean(
	//					AcquistionCommonConstants.OUR_PLANS_ACTUAL,
	//					ourPlansDropdownActualJson);
	//			getLoginScenario().saveBean(
	//					AcquistionCommonConstants.OUR_PLANS_EXPECTED,
	//					ourPlansDropdownExpectedJson);
	//			Assert.assertTrue(true);
	//			}
	//			else{
	//				Assert.fail("Error in Home page");
	//			}


}
