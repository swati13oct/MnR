package acceptancetests.acquisition.visitorprofile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.shopperprofile.ProfileSearch;
import pages.acquisition.shopperprofile.ShopperProfileAgentLogin;
import pages.acquisition.ulayer.VPPPlanSummaryPage;
/**
 * @author bnaveen4
 * Functionality:Shopper Profile
 */
public class ShopperProfileStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^I am an agent logged into the cloak in tool$")
	public void i_am_an_agent_logged_into_the_cloak_in_tool(DataTable userData){
		
		List<DataTableRow> givenAttributesRow = userData.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String userName = givenAttributesMap.get("User Name");
		String password = givenAttributesMap.get("Password");
	    
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		
		ShopperProfileAgentLogin shopperProfilePage = new ShopperProfileAgentLogin(wd);
		getLoginScenario().saveBean(PageConstants.SHOPPER_PROFILE_PAGE, shopperProfilePage);
		
		ProfileSearch profileSearch = shopperProfilePage.doAgentLogin(userName, password);
		getLoginScenario().saveBean(PageConstants.PROFILE_SEARCH, profileSearch);
		
	}

	@Then("^I ask the shopper calling in to provide me with the Name and Search$")
	public void i_ask_the_shopper_calling_in_to_provide_me_with_the_Name_And_Search(DataTable email){
	    
		List<DataTableRow> givenAttributesRow = email.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String fname = givenAttributesMap.get("First Name");
		String lname = givenAttributesMap.get("Last Name");
		
		ProfileSearch profileSeacrh = (ProfileSearch) getLoginScenario()
				.getBean(PageConstants.PROFILE_SEARCH);
		
		profileSeacrh.searchProfileByName(fname, lname);
	}

	@Then("^the profile is found and i click on the CLOAK IN button$")
	public void the_profile_is_found_and_i_click_on_the_CLOAK_IN_button(){
		
		try {
			ProfileSearch profileSeacrh = (ProfileSearch) getLoginScenario()
					.getBean(PageConstants.PROFILE_SEARCH);
			
			VPPPlanSummaryPage vppPlanSumamry = profileSeacrh.doCloakIn();
			
			Thread.sleep(15000);
			
			getLoginScenario().saveBean(PageConstants.VPP_PLAN_SUMMARY_PAGE, vppPlanSumamry);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^I land on the plan summary page of VPP$")
	public void i_land_on_the_plan_summary_page_of_VPP(DataTable planName){
		
		List<DataTableRow> givenAttributesRow = planName.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String plan = givenAttributesMap.get("Plan Name");
	    
		VPPPlanSummaryPage vppPlanSumamry = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		
		vppPlanSumamry.validateAgentModeBanners(plan);
	}

	@Then("^I ask the shopper calling in to provide me with the Email Address and Search$")
	public void i_ask_the_shopper_calling_in_to_provide_me_with_the_Email_Address_And_Search(DataTable email){
	    
		List<DataTableRow> givenAttributesRow = email.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String emailID = givenAttributesMap.get("Email");
		
		ProfileSearch profileSeacrh = (ProfileSearch) getLoginScenario()
				.getBean(PageConstants.PROFILE_SEARCH);
		
		profileSeacrh.searchProfileByEmail(emailID);
	}
	
} 


