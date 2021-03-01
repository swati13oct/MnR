package acceptancetests.acquisition.retiree;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.acquisition.uhcretiree.DrugLookUpPage;
import pages.acquisition.uhcretiree.RetireeAcquisitionHomePage;

/**
 * Functionality:UHC RETIREE site Drug Search
 */
public class RetireeDrugSearchStepDefinition {
	@Autowired
	MRScenario loginScenario;
	@SuppressWarnings("unused")
	private Object DrugLookUpPage;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^The user is on Retiree Home page$")
	public void the_user_is_on_Retiree_Home_page_Url_Pick() throws Throwable {
		WebDriver wd = getLoginScenario().getWebDriver();
		RetireeAcquisitionHomePage retireeacquisitionHomePage = new RetireeAcquisitionHomePage(wd);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(RetireeCommonConstants.RETIREE_HOME_PAGE, retireeacquisitionHomePage);
	}

	@Given("^The user navigates to the Search for a Drug page$")
	public void the_user_navigates_to_the_Search_for_a_Drug_page() {
		RetireeAcquisitionHomePage retireeacquisitionHomePage = (RetireeAcquisitionHomePage) getLoginScenario()
				.getBean(RetireeCommonConstants.RETIREE_HOME_PAGE);
		DrugLookUpPage retireedruglookuppage = retireeacquisitionHomePage.navigateToDrugLookUp();
		getLoginScenario().saveBean(RetireeCommonConstants.RETIREE_DRUG_LOOKUP_PAGE, retireedruglookuppage);
	}

	@When("^The User Selects the \"([^\"]*)\" Group name$")
	public void the_User_Selects_the_asprs_Group_name_selecting_the_group_link(String arg1) throws Throwable {
		DrugLookUpPage retireedruglookuppage = (DrugLookUpPage) getLoginScenario()
				.getBean(RetireeCommonConstants.RETIREE_DRUG_LOOKUP_PAGE);
		retireedruglookuppage.validateDrugLookUpPage();
		retireedruglookuppage.selectTheGroupName(arg1);
	}

	@When("^The user navigates to the SEARCH FOR A DRUG page and search for a drug$")
	public void the_user_navigates_to_the_SEARCH_FOR_A_DRUG_page_and_searchfor_a_drug() throws Throwable {
		DrugLookUpPage retireedruglookuppage = (DrugLookUpPage) getLoginScenario()
				.getBean(RetireeCommonConstants.RETIREE_DRUG_LOOKUP_PAGE);
		retireedruglookuppage.enterDrugNameToSearch();
	}

	@Then("^The User validate the Drug Details$")
	public void the_User_validate_the_Drug_Details() throws Throwable {
		DrugLookUpPage retireedruglookuppage = (DrugLookUpPage) getLoginScenario()
				.getBean(RetireeCommonConstants.RETIREE_DRUG_LOOKUP_PAGE);
		retireedruglookuppage.selectTheDrugFromSearchResults();
		retireedruglookuppage.validateDrugResults();
	}

	@Then("^The user return to the search results page$")
	public void the_user_return_to_the_search_results_page() throws Throwable {
		DrugLookUpPage retireedruglookuppage = (DrugLookUpPage) getLoginScenario()
				.getBean(RetireeCommonConstants.RETIREE_DRUG_LOOKUP_PAGE);
		retireedruglookuppage.validateBacktoSearchResults();
	}
}