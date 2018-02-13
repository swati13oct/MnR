package acceptancetests.deprecated.profandpref.redesign;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.deprecated.atdd.data.CommonConstants;
import acceptancetests.deprecated.atdd.data.member.PageConstants;
import acceptancetests.deprecated.claims.data.ClaimsCommonConstants;
import acceptancetests.deprecated.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.redesign.RedesignLoginPage;
import pages.redesign.UlayerHomePage;
import pages.redesign.GoGreenPreferencesPage;
import pages.redesign.MyProfilesPage;
import pages.redesign.OrderplanmaterialsPage;

public class MyProfPrefRedesignStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered AMP member with following attributes$")
	public void registered_AMP_member_with_following_attributes(DataTable memberAttributes) throws InterruptedException {
		
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

	
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario.getAMPMemberWithDesiredAttributes(desiredAttributes);
//				.getUMSMemberWithDesiredAttributes(desiredAttributes);
		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			getLoginScenario()
					.saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}



		 
		/*Hardcoding Username and Pwd 
		String userName = "q3_sep_ulayer029";
		String pwd = "Password@1";
*/
		getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
		getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		RedesignLoginPage loginPage = new RedesignLoginPage(wd);

		UlayerHomePage accountHomePage = (UlayerHomePage) loginPage.loginWith(userName, pwd);

		getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);

	}
	
	@Given("^registered UHC member with following attributes$")
	public void registered_UHC_member_with_following_attributes(DataTable memberAttributes) throws InterruptedException {

		
		/* Reading the given attribute from feature file */
		List<DataTableRow> memberAttributesRow = memberAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}

		String category = memberAttributesMap.get("Member Type");
		
		Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator
				.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(memberAttributesMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		Map<String, String> loginCreds = loginScenario
				.getUMSMemberWithDesiredAttributes(desiredAttributes);
		String userName = null;
		String pwd = null;
		if (loginCreds == null) {
			// no match found
			System.out.println("Member Type data could not be setup !!!");
			Assert.fail("unable to find a " + desiredAttributes + " member");
		} else {
			userName = loginCreds.get("user");
			pwd = loginCreds.get("pwd");
			System.out.println("User is..." + userName);
			System.out.println("Password is..." + pwd);
			getLoginScenario()
					.saveBean(LoginCommonConstants.USERNAME, userName);
			getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);
		}

		
		

/*		String userName = "q3_sep_grp028";
		String pwd = "Password@1";
		String category = "Group";
*/
		getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
		getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		RedesignLoginPage loginPage = new RedesignLoginPage(wd);

		UlayerHomePage accountHomePage = (UlayerHomePage) loginPage.loginWith(userName, pwd);

		getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);

	}


	@When("^the user Navigates to AARP Member Redesign My Profile and Preferences page$")
	public void the_user_Navigates_to_Member_Redesign_My_Profile_and_Preferences_page() throws InterruptedException {
		UlayerHomePage accountHomePage = (UlayerHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		MyProfilesPage myProfilepage = accountHomePage.navigateToProfAndPref();
		if (myProfilepage != null) {
			System.out.println("Profile page Loaded");
			getLoginScenario().saveBean(PageConstants.PROF_AND_PREF_PAGE, myProfilepage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in Loading Profile and Preferences Summary Page");
		}

	}

	@When("^the user Navigates to BlueLayer Member Redesign My Profile and Preferences page$")
	public void the_user_Navigates_to_UMS_Member_Redesign_My_Profile_and_Preferences_page() throws InterruptedException {
		UlayerHomePage accountHomePage = (UlayerHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		MyProfilesPage myProfilepage = accountHomePage.navigateToProfAndPref();
		if (myProfilepage != null) {
			System.out.println("Profile page Loaded");
			getLoginScenario().saveBean(PageConstants.PROF_AND_PREF_PAGE, myProfilepage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in Loading Profile and Preferences Summary Page");
		}

	}
	
	
	@When("^user navigates to Redesign Go Green Page from My Profile Page$")
	public void the_user_Navigates_to_UMS_Member_Redesign_GoGreen_page() throws InterruptedException {
		MyProfilesPage myProfilepage = (MyProfilesPage) getLoginScenario().getBean(PageConstants.PROF_AND_PREF_PAGE);
		GoGreenPreferencesPage goGreenPage = myProfilepage.NavigateTo_GoGreen_MyPreferences_Page();
		if (goGreenPage != null) {
			System.out.println("@@@@ Go Green Preferences page is Loaded @@@@");
			getLoginScenario().saveBean(PageConstants.MY_PREFERENCES_PAGE, goGreenPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("@@@@ Error in Loading Go Green Preferences page @@@@");
		}

	}


	@Then("^the user Validates all Error Messages for Edit Email scenarios$")
	public void the_user_Validates_all_Error_Messages_for_Edit_Email_scenarios() throws InterruptedException {
		MyProfilesPage myProfilepage = (MyProfilesPage) getLoginScenario().getBean(PageConstants.PROF_AND_PREF_PAGE);
		boolean flag = myProfilepage.ValidateEmailErrorMessages();

		if (flag) {
			System.out.println("*********Edit Email Scenarios Error Messages Displayed**********");
			Assert.assertTrue(true);
		} else {
			System.out.println("**********Edit Email Scenarios Error Messages is NOT Displayed***********");
			Assert.fail();
		}
	}

	@Then("^the user Validates all Error Messages for Alt/Temp Address scenarios$")
	public void the_user_Validates_all_Error_Messages_for_Alt_Temp_Address_scenarios() throws InterruptedException {
		MyProfilesPage myProfilepage = (MyProfilesPage) getLoginScenario().getBean(PageConstants.PROF_AND_PREF_PAGE);
		boolean flag = myProfilepage.ValidateAddTempAddressModal();
		if (flag) {
			System.out.println("******* Add Alternate/Temp Address Modal is Displayed *********");
			Assert.assertTrue(true);
		} else {
			System.out.println("******* Add Alternate/Temp Address Modal is not Displayed *********");
			Assert.fail();
		}
		
		flag = myProfilepage.ValidateTempAddressMandatoryFieldsErrorMessages();
		if (flag) {
			System.out.println("******* Alternate/Temp Address Mandatory Fileds Error Messages are Displayed *********");
			Assert.assertTrue(true);
		} else {
			System.out.println("******* Alternate/Temp Address Mandatory Fileds Error Messages are not Displayed *********");
			Assert.fail();
		}
		flag = myProfilepage.ValidateSpecialCharsStreetFieldsErrorMessages();
		if (flag) {
			System.out.println("******* Street Address Fields Error Messages are Displayed *********");
			System.out.println("******* Street Address Fields accepting Allowed Chars *********");

			Assert.assertTrue(true);
		} else {
			System.out.println("******* Alternate/Temp Address Error Messages are not Displayed *********");
			System.out.println("******* Street Address Fields NOT accepting Allowed Chars *********");
			Assert.fail();
		}

		flag = myProfilepage.ValidateZipcodeMismatchError();
		if (flag) {
			System.out.println("******* ZipCode Mismatch Error Messages are Displayed *********");
			Assert.assertTrue(true);
		} else {
			System.out.println("******* ZipCode Mismatch Error Messages are not Displayed *********");
			Assert.fail();
		}
		flag = myProfilepage.ValidateEndDateErrorMessages();
		if (flag) {
			System.out.println("******* Incorrect End Date Error Messages are Displayed *********");
			Assert.assertTrue(true);
		} else {
			System.out.println("******* Incorrect End Date Error Messages are not Displayed *********");
			Assert.fail();
		}
	}
	
	
	/*
	 * Code Added By Praveen for Ph No and Password Error Messages
	 * 
	 */
	@Then("^the user edits password in preference page in AARP Site$")
	public void user_edits_password(DataTable profileAttributes) {
		List<DataTableRow> profileAttributesRow = profileAttributes
				.getGherkinRows();
		Map<String, String> profileAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < profileAttributesRow.size(); i++) {

			profileAttributesMap.put(profileAttributesRow.get(i).getCells()
					.get(0), profileAttributesRow.get(i).getCells().get(1));
		}
		MyProfilesPage profAndPrefPage = (MyProfilesPage) getLoginScenario()
				.getBean(PageConstants.PROF_AND_PREF_PAGE);
		profAndPrefPage.editPasswordVerifyBlankPasswordErrorMsg(profileAttributesMap.get("Current password") ,profileAttributesMap.get("New pass Error Msg"), profileAttributesMap.get("Conf Pass Error Msg"));

	}
	
	@Then("^the user verify diff password error msg in preference page in AARP Site$")
	public void user_verify_diff_password_error_msg(DataTable profileAttributes){
		List<DataTableRow> profileAttributesRow = profileAttributes
				.getGherkinRows();
		Map<String, String> profileAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < profileAttributesRow.size(); i++) {

			profileAttributesMap.put(profileAttributesRow.get(i).getCells()
					.get(0), profileAttributesRow.get(i).getCells().get(1));
		}
		MyProfilesPage profAndPrefPage = (MyProfilesPage) getLoginScenario()
				.getBean(PageConstants.PROF_AND_PREF_PAGE);
		profAndPrefPage.diffPasswordErrorMsg(profileAttributesMap.get("Current password") ,profileAttributesMap.get("New password") ,profileAttributesMap.get("Confirm Password"));
	}
	
	@Then("^the user verify incorrect format password error msg in preference page in AARP Site$")
	public void user_verify_incorrect_format_error_msg(DataTable profileAttributes){
		List<DataTableRow> profileAttributesRow = profileAttributes
				.getGherkinRows();
		Map<String, String> profileAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < profileAttributesRow.size(); i++) {

			profileAttributesMap.put(profileAttributesRow.get(i).getCells()
					.get(0), profileAttributesRow.get(i).getCells().get(1));
		}
		MyProfilesPage profAndPrefPage = (MyProfilesPage) getLoginScenario()
				.getBean(PageConstants.PROF_AND_PREF_PAGE);
		profAndPrefPage.incorrectFormatPasswordErrormsg(profileAttributesMap.get("Current password") ,profileAttributesMap.get("New password"), profileAttributesMap.get("Incorrect Format ErrMsg"));
		
	}

	@Then("^the user validate phone number error messages$")
	public void user_validate_phone_number_error_messages(DataTable profileAttributes){
		List<DataTableRow> profileAttributesRow = profileAttributes
				.getGherkinRows();
		Map<String, String> profileAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < profileAttributesRow.size(); i++) {

			profileAttributesMap.put(profileAttributesRow.get(i).getCells()
					.get(0), profileAttributesRow.get(i).getCells().get(1));
		}
		MyProfilesPage profAndPrefPage = (MyProfilesPage) getLoginScenario()
				.getBean(PageConstants.PROF_AND_PREF_PAGE);
		profAndPrefPage.phonemumberErrorMessage(profileAttributesMap.get("day time phone number") ,profileAttributesMap.get("Phone error message"));
		}
	
	@Then("^the user Validates Single Tab for all SHIP Plans$")
	public void the_user_Validates_Single_Tab_for_all_SHIP_Plans() {
		MyProfilesPage profAndPrefPage = (MyProfilesPage) getLoginScenario()
				.getBean(PageConstants.PROF_AND_PREF_PAGE);
		if(profAndPrefPage.Validate_Single_Tab_SHIP() ){
			System.out.println("**********Single Tab displayed for all SHIP Plans");
			Assert.assertTrue(true);
		}
		else{
			System.out.println("**********Single Tab NOT displayed for all SHIP Plans");
			Assert.fail();
			}

	}

	@Then("^the user Validates Separate PHIP tab$")
	public void the_user_Validates_Separate_PHIP_Tab() {
		MyProfilesPage profAndPrefPage = (MyProfilesPage) getLoginScenario()
				.getBean(PageConstants.PROF_AND_PREF_PAGE);
		String PlanType = "PHIP";
		System.out.println("********** Plan Tab to Validate :"+PlanType+"*********");
		Boolean Flag = profAndPrefPage.navigatePlanTabs(PlanType);
		if(Flag){
			System.out.println("********** Separate PHIP Tab is Displayed **********");
			Assert.assertTrue(true);
		}
		else{
			System.out.println("********* Separate PHIP Tab is NOT Displayed **********");
			Assert.fail();
			}

	}

	@Then("^user navigates to Tabs for all Plan Types$")
	public void user_navigates_Plan_Tabs(DataTable givenAttributes) {

		MyProfilesPage profAndPrefPage = (MyProfilesPage) getLoginScenario()
				.getBean(PageConstants.PROF_AND_PREF_PAGE);
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String PlanTypes = givenAttributesMap.get("Combo Plans");
		String[] Plans= PlanTypes.split(",");
		for(String currentPlan: Plans){
			boolean TabPresent = profAndPrefPage.navigatePlanTabs(currentPlan);
			if(!TabPresent){
				System.out.println("Plan Tab not displayed "+currentPlan);
				Assert.fail("***** Plan Tab not displayed "+currentPlan+"*****");
			}
		}
	}
}






