/**
 * 
 */
package acceptancetests.memberredesign.pharmacylocator;

import gherkin.formatter.model.DataTableRow;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author sdwaraka
 * Functionality: Pharmacy locator in New Member redesign
 */
public class PharmacyLocatorMemberRedesignStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/**
	* @todo : Navigate to pharmacy tool from dashboard
	*/
	
	@When("^the user navigates to pharmacy search page in Redesign site$")
	public void navigateToPharmacyLocatorPage() throws InterruptedException {
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
		PharmacySearchPage pharmacySearchPage = accountHomePage.navigateToRedesignPharmacyLocaterPage();
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
	}

	/**
	* @todo : Changing the distance in pharmacy locator 
	*/

	@And("^the user enters distance details in Redesign site$")
	public void enterDistance(DataTable zipAttributes) throws InterruptedException {

		List<DataTableRow> zipAttributesRow = zipAttributes.getGherkinRows();
		Map<String, String> zipAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < zipAttributesRow.size(); i++) {

			zipAttributesMap.put(zipAttributesRow.get(i).getCells().get(0),
					zipAttributesRow.get(i).getCells().get(1));
		}
		String distance = zipAttributesMap.get("Distance");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.DISTANCE,
				distance);


		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		System.out.println("Select Distance from Dropdown : "+distance);
		pharmacySearchPage = pharmacySearchPage.enterDistanceDetails(distance);
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}

	}

	/**
	* @todo : Verify the pharmacies as per the filter criteria
	*/
	
	@Then("^the user validates the pharmacies available in Redesign site$")
	public void validatesPharmaciesAvailable() throws InterruptedException {

		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);

		PharmacySearchPage PharmacySearchPage = pharmacySearchPage.searchesPharmacy();
		if (PharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE,
					PharmacySearchPage);
			Assert.assertTrue(true);

		}
		else{
			Assert.fail("Pharmacy Results Not Displayed");
		}
	}

	/**
	* @todo : Choosing the different set of combination in Pharmacy filter
	*/
	
	@When("^the user selects Pharmacy Types to Filter in Redesign Site$")
	public void selectsPharmacyTypesfilter(DataTable pharmacyAttributes) throws InterruptedException {

		List<DataTableRow> PharmacyAttributesRow = pharmacyAttributes.getGherkinRows();
		Map<String, String> PharmacyAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < PharmacyAttributesRow.size(); i++) {

			PharmacyAttributesMap.put(PharmacyAttributesRow.get(i).getCells().get(0),
					PharmacyAttributesRow.get(i).getCells().get(1));
		}
		String PlanType = PharmacyAttributesMap.get("Pharmacy Type");
		System.out.println("Filter Type to Select : "+PlanType);
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.Select_PlanType_Filter(PlanType);
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
	}

	/**
	* @todo : Filter criteria verification in pharmacy tool page
	*/
	
	
	@And("^the user enters following details for pharmacy search in Redesign Site$")
	public void enterZipCodeForNewSearch(DataTable zipAttributes) throws InterruptedException {
		List<DataTableRow> zipAttributesRow = zipAttributes.getGherkinRows();
		Map<String, String> zipAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < zipAttributesRow.size(); i++) {

			zipAttributesMap.put(zipAttributesRow.get(i).getCells().get(0),
					zipAttributesRow.get(i).getCells().get(1));
		}
		String zipcode = zipAttributesMap.get("Zip Code");

		String distance = zipAttributesMap.get("Distance");
		getLoginScenario().saveBean(PharmacySearchCommonConstants.ZIPCODE,
				zipcode);

		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		System.out.println("Zip Code is"+zipcode);
		System.out.println("Distance is"+distance);

		pharmacySearchPage = pharmacySearchPage.enterDistanceZipDetails(distance, zipcode);

		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE,
					pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page");
		}
	}

	/**
	* @todo : Verifying show on map link clickable for pharmacies appearing in the search results
	*/
	
	@Then("^the user Validates show on map link in Redesign Site$")
	public void viewsShowOnMapResult() throws InterruptedException {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacySearchPage PharmacySearchPage = pharmacySearchPage
				.ValidateShowOnMapLinks();
		if (PharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE,
					PharmacySearchPage);
			Assert.assertTrue(true);

		}
		else{
			Assert.fail("SHOW ON MAP Links Not Displayed");
		}
	}

/**
	* @todo : Verify Create a PDF in pharmacy search page
*/
	
	@Then("^the user Validates view search PDF link in Redesign Site$")
	public void viewsSearchResultPdf() throws InterruptedException {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacySearchPage PharmacySearchPage = pharmacySearchPage
				.ValidateSearchPdfResult();
		if (PharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE,
					PharmacySearchPage);
			Assert.assertTrue(true);
			System.out.println("PDF Result Page is Displayed");
		}
		else{
			Assert.fail("PDF Results Page Not Displayed");
		}
	}

/**
	* @todo : Verify search results based on plan type
*/
	
	@And("^the user validate more information content based on plan type in Redesign Site$")
	public void validateMoreInformationContent() throws InterruptedException {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacySearchPage PharmacySearchPage = pharmacySearchPage.validateMoreInfoContent();
		if (PharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE,
					PharmacySearchPage);
			Assert.assertTrue(true);
			System.out.println("More Info Disclaimer is Displayed");
		}
		else{
			Assert.fail("More Info Disclaimer is NOT Displayed");
		}
	}

	/**
	* @todo : Verifying more information content appearing based on plan type
*/
	@And("^the user validates more information content for Limited Access Disclaimer$")
	public void validateLimitedAccessDisclaimer(DataTable zipAttributes) throws InterruptedException {
		
		List<DataTableRow> zipAttributesRow = zipAttributes.getGherkinRows();
		Map<String, String> zipAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < zipAttributesRow.size(); i++) {

			zipAttributesMap.put(zipAttributesRow.get(i).getCells().get(0),
					zipAttributesRow.get(i).getCells().get(1));
		}
		String DisclaimerText = zipAttributesMap.get("Disclaimer Text");
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacySearchPage PharmacySearchPage = pharmacySearchPage.validateLimitedAccessDisclaimer(DisclaimerText);
		if (PharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE,
					PharmacySearchPage);
			Assert.assertTrue(true);
			System.out.println("Limited Access Disclaimer is Displayed");
		}
		else{
			Assert.fail("Limited Access Disclaimer is NOT Displayed");
		}
	}

/**
	* @todo : Verifying chat widget 
*/	
	@And("^the user validate chat widget in Redesign Site$")
	public void validateChatWidget() throws InterruptedException {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacySearchPage PharmacySearchPage = pharmacySearchPage.validateChatWidget();
		if (PharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE,
					PharmacySearchPage);
			Assert.assertTrue(true);
			System.out.println("Chat Widget is Displayed");
		}
		else{
			Assert.fail("Chat Widget is NOT Displayed");
		}
	}

/**
	* @todo : Verifying TFN widget
*/	
	@And("^the user validate TFN widget in Redesign Site$")
	public void validateTfnWidget() throws InterruptedException {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacySearchPage PharmacySearchPage = pharmacySearchPage.validateTfnWidget();
		if (PharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE,
					PharmacySearchPage);
			Assert.assertTrue(true);
			System.out.println("TFN Widget is Displayed");
		}
		else{
			Assert.fail("TFN Widget is NOT Displayed");
		}
	}

/**
	* @todo : Verifying the pharmacy search tool in Chinese languages
*/	
	@Then("^the user Selects Chinese Language in Redesign Site$")
	public void selectChinese() throws InterruptedException {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.clickChinese();
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Failed to load Pharmacy search page - Chinese Language Selected");
		}
	}
/**
	* @todo : Verifying the pharmacy search tool in Spanish language
*/	
	@Then("^the user Selects Spanish Language in Redesign site$")
	public void selectSpanish() throws InterruptedException {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacySearchPage PharmacySearchPage = pharmacySearchPage
				.selectspanLanguage();
		if (PharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchPage);
			Assert.assertTrue(true);
		} 
		else{
			Assert.fail("Failed to load Pharmacy search page - Spanish Language Selected");
		}
	}
/**
	* @todo : Verifying the pharmacy search tool in different languages
*/	
	@And("^the user searches multi lang for pharmacy search results available in Redesign site$")
	public void viewsMultiLangPharmacySearch() throws InterruptedException {
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		PharmacySearchPage PharmacySearchPage = pharmacySearchPage.multilangPharmacySearchResult();
		if (PharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstantsMnR.PHARMACY_RESULT_PAGE, PharmacySearchPage);
			Assert.assertTrue(true);
			System.out.println("Pharmacy Results are Displayed");
		}
		else{
			Assert.fail("Pharmacy Results are NOT Displayed");
		}
	}
/**
	* @todo : Verifying the error message in pharmacy search tool
*/	
	@And("^the user verify error messages in pharmacy locator page in Redesign site$")
	public void verifyPharmacyErrorMessages() throws InterruptedException{
		PharmacySearchPage pharmacySearchPage = (PharmacySearchPage) getLoginScenario()
				.getBean(PageConstants.PHARMACY_SEARCH_PAGE);
		pharmacySearchPage = pharmacySearchPage.verifyPharmacyErrormessages();
		if (pharmacySearchPage != null) {
			getLoginScenario().saveBean(PageConstants.PHARMACY_SEARCH_PAGE, pharmacySearchPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error Messages not Displayed for Invalid Zipcode entered");
		}
	}
	
	@Then("^the user will not be able to see the locate a pharmacy on home page$")
	public void verifyPharmacyLinkIsNotDisplayedToMaShip() throws InterruptedException{
		AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
				.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
	

		Assert.assertTrue(accountHomePage.checkPharmacyLinkNotAvailable());
	}

}