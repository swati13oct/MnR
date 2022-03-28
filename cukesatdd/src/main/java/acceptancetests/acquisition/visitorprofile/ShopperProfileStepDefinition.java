package acceptancetests.acquisition.visitorprofile;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.dceredesign.DCERedesignCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.acquisition.commonpages.ComparePlansPage;
import pages.acquisition.commonpages.ProviderSearchPage;
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.commonpages.VisitorProfilePage;
import pages.acquisition.shopperprofile.CloakProfile;
import pages.acquisition.shopperprofile.MemberCreateProfile;
import pages.acquisition.shopperprofile.NonMemberCreateProfile;
import pages.acquisition.shopperprofile.ProfileSearch;
import pages.acquisition.shopperprofile.ShopperProfileAgentLogin;

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
		
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(userData);
		/*List<DataTableRow> givenAttributesRow = userData.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String userName = givenAttributesMap.get("User Name");
		String password = givenAttributesMap.get("Password");
	    
		WebDriver wd = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		
		ShopperProfileAgentLogin shopperProfilePage = new ShopperProfileAgentLogin(wd);
		getLoginScenario().saveBean(PageConstants.SHOPPER_PROFILE_PAGE, shopperProfilePage);
		
		ProfileSearch profileSearch = shopperProfilePage.doAgentLogin(userName, password);
		getLoginScenario().saveBean(PageConstants.PROFILE_SEARCH, profileSearch);
		
	}

	@Then("^I ask the shopper calling in to provide me with the Name and Search$")
	public void i_ask_the_shopper_calling_in_to_provide_me_with_the_Name_And_Search(DataTable email){
	    
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(email);
		/*List<DataTableRow> givenAttributesRow = email.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String fname = givenAttributesMap.get("First Name");
		String lname = givenAttributesMap.get("Last Name");
		
		ProfileSearch profileSeacrh = (ProfileSearch) getLoginScenario()
				.getBean(PageConstants.PROFILE_SEARCH);
		
		profileSeacrh.searchProfileByName(fname, lname);
	}

	@Then("^the profile is found and i click on the CLOAK IN button$")
	public void the_profile_is_found_and_i_click_on_the_CLOAK_IN_button(DataTable email){
		
		try {
			HashMap<String, String> givenAttributesMap = new HashMap<String, String>();
			givenAttributesMap = DataTableParser.readDataTableAsMaps(email);
			
			ProfileSearch profileSeacrh = (ProfileSearch) getLoginScenario()
					.getBean(PageConstants.PROFILE_SEARCH);
			
			CloakProfile cloakProfile = profileSeacrh.cloakProfile();
			
			ComparePlansPage comparePlansPage = cloakProfile.doCloakIn(givenAttributesMap);
			
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, comparePlansPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^I land on the plan summary page of VPP$")
	public void i_land_on_the_plan_summary_page_of_VPP(DataTable planName){
		
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planName);
		/*List<DataTableRow> givenAttributesRow = planName.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String plan = givenAttributesMap.get("Plan Name");
		
		String enrolledPlan = givenAttributesMap.get("Enrolled Plan Name");
		
		String drugs = givenAttributesMap.get("Drugs");
		String providers = givenAttributesMap.get("Providers");
		String fname = givenAttributesMap.get("First Name");
		String lname = givenAttributesMap.get("Last Name");
		
	    
		VPPPlanSummaryPage vppPlanSumamry = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		
		vppPlanSumamry.validateAgentModeBanners(enrolledPlan, drugs, providers, plan,fname,lname);
	}
	
	@Then("^I land on the plan compare page$")
	public void i_land_on_the_plan_compare_page(DataTable userData){
		
		HashMap<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(userData);
		/*List<DataTableRow> givenAttributesRow = userData.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		ComparePlansPage comparePlansPage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		
//		comparePlansPage.validateMemberDetails(userData);
		comparePlansPage.validateMemberDetails(givenAttributesMap);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, givenAttributesMap.get("Drugs"));
	}

	@Then("^I ask the shopper calling in to provide me with the Email Address and Search$")
	public void i_ask_the_shopper_calling_in_to_provide_me_with_the_Email_Address_And_Search(DataTable email){
	    
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(email);
		/*List<DataTableRow> givenAttributesRow = email.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String emailID = givenAttributesMap.get("Email");
		
		ProfileSearch profileSeacrh = (ProfileSearch) getLoginScenario()
				.getBean(PageConstants.PROFILE_SEARCH);
		
		profileSeacrh.searchProfileByEmail(emailID);
	}
	
	@Then("^validate empty email firstname and lastname$")
	public void validate_empty_email_firstname_and_lastname(){
	    
		ProfileSearch profileSeacrh = (ProfileSearch) getLoginScenario()
				.getBean(PageConstants.PROFILE_SEARCH);
		
		profileSeacrh.validateErrorMessages(true,"","","");
	}
	
	@Then("^validate invalid email$")
	public void validate_invalid_email(DataTable email){
	    
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(email);
		/*List<DataTableRow> givenAttributesRow = email.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		
		ProfileSearch profileSeacrh = (ProfileSearch) getLoginScenario()
				.getBean(PageConstants.PROFILE_SEARCH);
		
		String emailID = givenAttributesMap.get("Email");
		
		profileSeacrh.validateErrorMessages(false,emailID,"","");
	}
	
	@Then("^validate invalid first name and last name$")
	public void validate_invalid_first_name_and_last_name(DataTable email){
	    
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(email);
		/*List<DataTableRow> givenAttributesRow = email.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		
		ProfileSearch profileSeacrh = (ProfileSearch) getLoginScenario()
				.getBean(PageConstants.PROFILE_SEARCH);
		
		String fname = givenAttributesMap.get("First Name");
		String lname = givenAttributesMap.get("Last Name");
		
		profileSeacrh.validateErrorMessages(false,"",fname,lname);
	}
	
	@Then("^I ask the shopper calling in to provide me with the Email Address$")
	public void i_ask_the_shopper_calling_in_to_provide_me_with_the_Email_Address(DataTable details){
	    
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(details);
		/*List<DataTableRow> givenAttributesRow = details.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String emailID = givenAttributesMap.get("Email");
		
		ProfileSearch profileSeacrh = (ProfileSearch) getLoginScenario()
				.getBean(PageConstants.PROFILE_SEARCH);
		
		profileSeacrh.searchProfileAndDelete(emailID);
		
	}
	
	@Then("^click on Create Profile button$")
	public void click_on_create_a_profile(){
	    
		ProfileSearch profileSeacrh = (ProfileSearch) getLoginScenario()
				.getBean(PageConstants.PROFILE_SEARCH);
		
		MemberCreateProfile createProfile = profileSeacrh.clickOnCreateProfile();
		
		getLoginScenario().saveBean(PageConstants.MEMBER_CREATE_A_PROFILE,createProfile);
	}
	
	@Then("^create a profile with the following details$")
	public void create_a_profile_with_the_following_details(DataTable details){
		HashMap<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(details);
		try {
			MemberCreateProfile createProfile = (MemberCreateProfile) getLoginScenario()
					.getBean(PageConstants.MEMBER_CREATE_A_PROFILE);
			ComparePlansPage comparePlansPage = createProfile.createProfile(givenAttributesMap);
			Thread.sleep(15000);
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, comparePlansPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Then("^click on Create Profile button for NonMember$")
	public void click_on_create_a_profile_non_member(){
	    
		ProfileSearch profileSeacrh = (ProfileSearch) getLoginScenario()
				.getBean(PageConstants.PROFILE_SEARCH);
		
		NonMemberCreateProfile createProfile = profileSeacrh.clickOnCreateProfileForNonMember();
		
		getLoginScenario().saveBean(PageConstants.NON_MEMBER_CREATE_A_PROFILE,createProfile);
	}
	
	@Then("^create a profile with the following details for NonMember$")
	public void create_a_profile_with_the_following_details_for_NonMember(DataTable details){
		HashMap<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(details);
		try {
			NonMemberCreateProfile createProfile = (NonMemberCreateProfile) getLoginScenario()
					.getBean(PageConstants.NON_MEMBER_CREATE_A_PROFILE);
			ComparePlansPage comparePlansPage = createProfile.createProfile(givenAttributesMap);
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, comparePlansPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Then("^I land on the plan summary page of VPP for NonMember$")
	public void i_land_on_the_plan_summary_page_of_VPP_for_NonMember(DataTable planName){
		
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(planName);
		/*List<DataTableRow> givenAttributesRow = planName.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String plan = givenAttributesMap.get("Plan Name");
		String drugs = givenAttributesMap.get("Drugs");
		String providers = givenAttributesMap.get("Providers");
		String fname = givenAttributesMap.get("First Name");
		String lname = givenAttributesMap.get("Last Name");
	    
		VPPPlanSummaryPage vppPlanSumamry = (VPPPlanSummaryPage) getLoginScenario()
				.getBean(PageConstants.VPP_PLAN_SUMMARY_PAGE);
		
		vppPlanSumamry.validateAgentModeBannersForNonMember(plan, drugs, providers,fname,lname);
	}
	
	@Then("^I ask the shopper calling in to provide me with the Email Address for NonMember$")
	public void i_ask_the_shopper_calling_in_to_provide_me_with_the_Email_Address_Non_Member(DataTable memberDetails){
		HashMap<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(memberDetails);
		ProfileSearch profileSeacrh = (ProfileSearch) getLoginScenario()
				.getBean(PageConstants.PROFILE_SEARCH);
		
		profileSeacrh.searchProfileAndDeleteNonMember(givenAttributesMap);
		
	}
	
	@Then("^I land on the plan compare page for NonMember$")
	public void i_land_on_the_plan_compare_page_For_Non_Member(DataTable userData){
		
		HashMap<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(userData);
		ComparePlansPage comparePlansPage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		
		comparePlansPage.validateAgentModeBannersForNonMember(givenAttributesMap);
	}
	
	@Then("^Navigate to Visitor Profile page from compare page$")
	public void navigate_to_Visitor_Profile_page_on_AARP_site() {
		ComparePlansPage comparePlansPage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		VisitorProfilePage visitorProfilePage = comparePlansPage.navigateToVisitorProfilePage();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}
	
	@Then("^All set and Navigate to Visitor Profile page from compare page$")
	public void all_set_and_navigate_to_Visitor_Profile_page_on_AARP_site() {
		ComparePlansPage comparePlansPage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		VisitorProfilePage visitorProfilePage = comparePlansPage.allSetAndNavigateToVisitorProfilePage();
		getLoginScenario().saveBean(PageConstants.VISITOR_PROFILE_PAGE, visitorProfilePage);
	}

	@Then("^user validate medsup compare link for telesales$")
	public void user_validate_medsup_compare_link_for_telesales() {
		ComparePlansPage comparePlansPage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		comparePlansPage.validateAgentMedSupCompareLink();
	}

	@Then("^user click on MAPD link and validates$")
	public void user_click_on_MAPD_link_and_validates() {
		ComparePlansPage comparePlansPage = (ComparePlansPage) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		comparePlansPage.validateAgentMAPDCompareLink();
	}
	
	@Then("^Validate PDFs loading for Current enrolled Plan")
	public void Validate_PDFs_loading_for_Current_enrolled_Plan(DataTable userData){
			
			HashMap<String, String> givenAttributesMap = new HashMap<String, String>();
			givenAttributesMap = DataTableParser.readDataTableAsMaps(userData);
			
			ComparePlansPage comparePlansPage = (ComparePlansPage) getLoginScenario()
					.getBean(PageConstants.PLAN_COMPARE_PAGE);
			comparePlansPage.validatePDFforEnrolledMember(givenAttributesMap);
		
	}

} 
