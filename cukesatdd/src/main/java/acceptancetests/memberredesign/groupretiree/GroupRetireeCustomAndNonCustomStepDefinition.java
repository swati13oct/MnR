package acceptancetests.memberredesign.groupretiree;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.uhcretiree.GroupHomePage;
import pages.acquisition.uhcretiree.RetireeAcquisitionHomePage;

public class GroupRetireeCustomAndNonCustomStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on group retiree acquisition home page$")
	public void the_user_is_on_group_retiree_acquisition_home_page() throws Throwable {
		WebDriver wd = getLoginScenario().getWebDriver();
		RetireeAcquisitionHomePage acquisitionHomePage = new RetireeAcquisitionHomePage(wd);
		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_HOME_PAGE, acquisitionHomePage);
	}

	@When("^I find groups dropdown populated with different retiree group name$")
	public void i_find_groups_dropdown_populated_with_different_retiree_group_name() throws Throwable {
		RetireeAcquisitionHomePage acquisitionHomePage = (RetireeAcquisitionHomePage) loginScenario.getBean(PageConstants.UHCRETIREE_ACQ_HOME_PAGE);
		acquisitionHomePage.validateGroupDropdownList();
		
	}

	@When("^I select a group from list of group$")
	public void i_select_a_group_from_list_of_group(DataTable data) throws Throwable {
		RetireeAcquisitionHomePage acquisitionHomePage = (RetireeAcquisitionHomePage) loginScenario.getBean(PageConstants.UHCRETIREE_ACQ_HOME_PAGE);
		List<DataTableRow> memberAttributesRow = data.getGherkinRows();
		String groupName = memberAttributesRow.get(0).getCells().get(1);
		GroupHomePage groupHomePage = acquisitionHomePage.selectGroupFromList(groupName);
		groupHomePage.setGroupName(groupName);
		getLoginScenario().saveBean(PageConstants.UHCRETIREE_ACQ_RETIREES_OF_SELECTED_PLANS_HOME_PAGE, groupHomePage);
		
	}

	@When("^selected group page is loaded$")
	public void selected_group_page_is_loaded() throws Throwable {
		GroupHomePage groupHomePage = (GroupHomePage) loginScenario.getBean(PageConstants.UHCRETIREE_ACQ_RETIREES_OF_SELECTED_PLANS_HOME_PAGE);
		groupHomePage.validateSignInOrRegisterbtn();
	}

	@When("^click on Sign in or Register Now button$")
	public void click_on_Sign_in_or_Register_Now_button() throws Throwable {
		GroupHomePage groupHomePage = (GroupHomePage) loginScenario.getBean(PageConstants.UHCRETIREE_ACQ_RETIREES_OF_SELECTED_PLANS_HOME_PAGE);
		groupHomePage.validateSignInOrRegisterbtn();
		groupHomePage.clickSignInOrRegisterbtn();
	}

	@Then("^user is redirected to external hsid page$")
	public void user_is_redirected_to_external_hsid_page() throws Throwable {
	    
	    
	}
	
	
	/*@After
	public void tearDown() {
		WebDriver wd = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.quit();
		getLoginScenario().flushBeans();
	}*/



}
