package acceptancetests.acquisition.plandocs;

import gherkin.formatter.model.DataTableRow;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.DrugCostEstimatorPage;
import pages.acquisition.commonpages.PlanDocsPage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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
		
		List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
			}

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

		pages.acquisition.ulayer.AcquisitionHomePage acquisitionHomePage = (pages.acquisition.ulayer.AcquisitionHomePage) loginScenario.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PlanDocsPage plandocsPage = (PlanDocsPage) acquisitionHomePage.navigateToPlanDocsFromHome();
		if(null!=plandocsPage){
			loginScenario.saveBean(PageConstants.PLANDOCS_PAGE, plandocsPage);
		}else
			Assert.fail("Plan docs page object is not loaded");
	}
	
	/**
	 * @toDo:access the acquisition DCE tool from home page
	 */
	@When("^I access the acquisition Plan docs tool from home page on uhc$")
	public void I_access_the_plandocs_tool_home_page_uhc() throws InterruptedException {

		pages.acquisition.bluelayer.AcquisitionHomePage acquisitionHomePage = (pages.acquisition.bluelayer.AcquisitionHomePage) loginScenario.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		PlanDocsPage plandocsPage= (PlanDocsPage) acquisitionHomePage.navigateToPlanDocsFromHome();
		if(null!=plandocsPage){
			loginScenario.saveBean(PageConstants.PLANDOCS_PAGE, plandocsPage);
		}else
			Assert.fail("Plan docs page object is not loaded");
	}
	

	
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
		
		List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
			}

			String zipcode = memberAttributesMap.get("zipcode");
			String county = memberAttributesMap.get("county");
			String plan = memberAttributesMap.get("plan");	
			String currentplandrodown = memberAttributesMap.get("currentplandrodown");
			
		
			
		PlanDocsPage plandocspage = (PlanDocsPage) getLoginScenario().getBean(PageConstants.PLANDOCS_PAGE);
		plandocspage.enterValue(zipcode,county,plan,currentplandrodown);
		
	}
	
	@Then("^the user should be able to see the pdf")
	public void the_user_should_be_able_to_see_the_pdf(DataTable givenAttributes) throws InterruptedException {
		
		List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells()
						.get(0), memberAttributesRow.get(i).getCells().get(1));
			}

			String plan = memberAttributesMap.get("plan");
		PlanDocsPage plandocspage = (PlanDocsPage) getLoginScenario().getBean(PageConstants.PLANDOCS_PAGE);
		plandocspage.verifyPDF(plan);
		
	}	
}