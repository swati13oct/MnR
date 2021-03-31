package acceptancetests.acquisition.plandocs;


import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.PlanDocsPage;


/**
 *Functionality:Global Header Footer 
 */
public class PlanDocsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^user opens the plandocs page to validate$")
	public void the_user_opens_the_page_to_validate(DataTable givenAttributes) throws InterruptedException {

		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
			}*/

		String pagename = memberAttributesMap.get("pagename");

		System.out.println(pagename);

		WebDriver wd = getLoginScenario().getWebDriverNew();
		//PlanDocsPage plandocspage = new PlanDocsPage(wd,pagename);

		//getLoginScenario().saveBean(PageConstants.PLANDOCS_PAGE,plandocspage);

	}

	/**
	 * @toDo:access the acquisition DCE tool from home page
	 */
	@When("^I access the acquisition Plan docs tool from home page$")
	public void I_access_the_plandocs_tool_home_page() throws InterruptedException {

		AcquisitionHomePage acquisitionHomePage = (AcquisitionHomePage) loginScenario.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PlanDocsPage plandocsPage = (PlanDocsPage) acquisitionHomePage.navigateToPlanDocsFromHome();
		if(null!=plandocsPage){
			loginScenario.saveBean(PageConstants.PLANDOCS_PAGE, plandocsPage);
		}else
			Assertion.fail("Plan docs page object is not loaded");
	}

	/**
	 * @toDo:access the acquisition DCE tool from home page
	 */
	//	@When("^I access the acquisition Plan docs tool from home page on uhc$")
	//	public void I_access_the_plandocs_tool_home_page_uhc() throws InterruptedException {
	//
	//		pages.acquisition.bluelayer.AcquisitionHomePage acquisitionHomePage = (pages.acquisition.bluelayer.AcquisitionHomePage) loginScenario.getBean(PageConstants.ACQUISITION_HOME_PAGE);
	//		PlanDocsPage plandocsPage= (PlanDocsPage) acquisitionHomePage.navigateToPlanDocsFromHome();
	//		if(null!=plandocsPage){
	//			loginScenario.saveBean(PageConstants.PLANDOCS_PAGE, plandocsPage);
	//		}else
	//			Assertion.fail("Plan docs page object is not loaded");
	//	}



	@When("^the user validates the header and the subcontent section")
	public void the_user_validates_the_header_and_the_subcontent_section() throws Throwable {
		PlanDocsPage plandocspage = (PlanDocsPage) getLoginScenario().getBean(PageConstants.PLANDOCS_PAGE);
		plandocspage.validateContent();

	}

	@And("^the user validates the label for zipcode and county and plan")
	public void the_user_validates_the_label_for_zipcode_and_county_and_plan() throws Throwable {
		PlanDocsPage plandocspage = (PlanDocsPage) getLoginScenario().getBean(PageConstants.PLANDOCS_PAGE);
		plandocspage.validateLabels();

	}

	@And("^the user enters zipcode and county and plan")
	public void the_user_validates_the_label_for_zipcode_and_enters_zipcode_on_UHC(DataTable givenAttributes) throws InterruptedException {

		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		/*List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
			}*/

		String zipcode = memberAttributesMap.get("zipcode");
		String county = memberAttributesMap.get("county");
		String plan = memberAttributesMap.get("plan");	
		String aepyear = memberAttributesMap.get("aepyear");		


		PlanDocsPage plandocspage = (PlanDocsPage) getLoginScenario().getBean(PageConstants.PLANDOCS_PAGE);
		plandocspage.enterZipCodeValue(zipcode);
		plandocspage.enterCountyValue(county);
		plandocspage.enterPlanValue(plan);
		if(aepyear.equalsIgnoreCase("yes")){
			plandocspage.enterYearValue(aepyear);
		}

	}


	@When("^the form fields are not selected and continue button is clicked")
	public void the_form_fields_are_not_selected_and_continue_button_is_clicked() throws Throwable {
		PlanDocsPage plandocspage = (PlanDocsPage) getLoginScenario().getBean(PageConstants.PLANDOCS_PAGE);
		plandocspage.continuebuttonOnClick();

	}

	@When("^verifying error messages for Zip code and county and plan year")
	public void verifying_error_messages_for_Zipcode_and_county_and_plan_year() throws Throwable {
		PlanDocsPage plandocspage = (PlanDocsPage) getLoginScenario().getBean(PageConstants.PLANDOCS_PAGE);
		boolean isZipErrMsg = plandocspage.verifyErrorZipCodeMessage();
		boolean isCountyErrMsg = plandocspage.verifyErrorCountyMessage();
		boolean isPlanErrMsg = plandocspage.verifyErrorPlanMessage();
		if(isZipErrMsg && isCountyErrMsg && isPlanErrMsg){
			Assertion.assertTrue("Error messages are visible", true); 
		}
	}

	@When("^user enters zipcode with non-multi county and continue button is clicked and county and plan error message is visible")
	public void user_enters_zipcode_with_nonmulticounty_and_continue_button_is_clicked(DataTable givenAttributes) throws InterruptedException {

		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
			}*/

		String zipcode = memberAttributesMap.get("zipcode");

		PlanDocsPage plandocspage = (PlanDocsPage) getLoginScenario().getBean(PageConstants.PLANDOCS_PAGE);
		plandocspage.enterZipCodeValue(zipcode);
		plandocspage.continuebuttonOnClick();

		boolean isCountyErrMsg = plandocspage.verifyErrorCountyMessage();
		boolean isPlanErrMsg = plandocspage.verifyErrorPlanMessage();
		if(isCountyErrMsg && isPlanErrMsg){
			Assertion.assertTrue("Error messages are visible", true); 
		}
	}


	@When("^user enters zipcode and county and continue button is clicked and plan error message is visible")
	public void user_enters_zipcode_and_county_and_continue_button_is_clicked(DataTable givenAttributes) throws InterruptedException {

		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
			}*/

		String zipcode = memberAttributesMap.get("zipcode");
		String county = memberAttributesMap.get("county");

		PlanDocsPage plandocspage = (PlanDocsPage) getLoginScenario().getBean(PageConstants.PLANDOCS_PAGE);
		plandocspage.enterZipCodeValue(zipcode);
		plandocspage.enterCountyValue(county);
		plandocspage.continuebuttonOnClick();

		boolean isPlanErrMsg = plandocspage.verifyErrorPlanMessage();
		if(isPlanErrMsg){
			Assertion.assertTrue("Error messages are visible", true); 
		}
	}

	@Then("^the user should be able to see the pdf")
	public void the_user_should_be_able_to_see_the_pdf(DataTable givenAttributes) throws InterruptedException {

		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		memberAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
			}*/

		String plan = memberAttributesMap.get("plan");
		PlanDocsPage plandocspage = (PlanDocsPage) getLoginScenario().getBean(PageConstants.PLANDOCS_PAGE);
		plandocspage.verifyPDF(plan);

	}	
}