package acceptancetests.acquisition.retiree;


import gherkin.formatter.model.DataTableRow;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import pages.acquisition.uhcretiree.DrugLookUpPage;
import pages.acquisition.uhcretiree.ProviderSearchPageUhcRetiree;
import pages.acquisition.uhcretiree.RetireeAcquisitionHomePage;
import acceptancetests.acquisition.retiree.RetireeCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class RetireeProviderSearchStepDefinition {


	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
				
	}
	
	

	/**
	 * @toDo: user performs Provider search using following information
	 */
	@When("^the user clicks on Provider Search on the Retiree Home Page$")
	public void providerSearch_details_in_Retiree_site_from_HomePage() {
		
		
		RetireeAcquisitionHomePage retireeacquisitionHomePage = (RetireeAcquisitionHomePage) getLoginScenario()
				.getBean(RetireeCommonConstants.RETIREE_HOME_PAGE);
		ProviderSearchPageUhcRetiree retireeProviderSearchpage = retireeacquisitionHomePage.navigateToProviderSearchTool();
		
		if (retireeProviderSearchpage != null) {
			getLoginScenario().saveBean(RetireeCommonConstants.RETIREE_PROVIDER_SEARCH_PAGE, retireeProviderSearchpage);
		} else {
			Assert.fail("Error Loading Rally tool from Retiree Home Page");
		}
	}
	
	
	/**
	 * @toDo: User Enters a zipcode in the Rally tool
	 */
	@When("^the user enters the zipcode and select a plan on the Rally tool on Retiree site$")
	public void user_enters_the_zipcode_on_the_Rally_tool(DataTable givenAttributes) {

			List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
			Map<String, String> memberAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
						memberAttributesRow.get(i).getCells().get(1));
			}

			String zipcode = memberAttributesMap.get("Zip Code");
			String planName = memberAttributesMap.get("Plan Name");

		{
			
			ProviderSearchPageUhcRetiree providerSearchPage = (ProviderSearchPageUhcRetiree)getLoginScenario().getBean(RetireeCommonConstants.RETIREE_PROVIDER_SEARCH_PAGE);
			providerSearchPage.entersZipcodeAndSelectsPlanName(zipcode,planName);
			

		}
	}
		
	/**
	 * @toDo:user user selects a provider
	 */
	@When("^user selects a provider and save it on Retiree site$")
	public void user_selects_provider_and_saves_it() {
		{
			ProviderSearchPageUhcRetiree providerSearchPage = (ProviderSearchPageUhcRetiree)getLoginScenario().getBean(RetireeCommonConstants.RETIREE_PROVIDER_SEARCH_PAGE);
			 providerSearchPage.selectProviderFromHomePage();

		}
	}
	

	

}		