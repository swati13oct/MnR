package acceptancetests.profandpref.redesign;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.redesign.BlueLayerHomePage;
import pages.redesign.BlueLayerLoginPage;
import pages.redesign.MyProfilesPage;
import pages.redesign.UlayerHomePage;
import pages.redesign.UlayerLoginPage;

public class MyProfPrefRedesignStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered AMP member with following attributes$")
	public void registered_AMP_member_with_following_attributes(DataTable arg1) {
		
		/*
		 * Reading the given attribute from feature file List<DataTableRow>
		 * memberAttributesRow = memberAttributes .getGherkinRows(); Map<String,
		 * String> memberAttributesMap = new LinkedHashMap<String, String>();
		 * for (int i = 0; i < memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells()
		 * .get(0), memberAttributesRow.get(i).getCells().get(1)); } String
		 * planType = memberAttributesMap.get("Plan Type"); String businessType
		 * = "SHIP";
		 * 
		 * getLoginScenario().saveBean(ClaimsCommonConstants.BUSINESS_TYPE,
		 * businessType);
		 * 
		 * Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		 * List<String> desiredAttributes = new ArrayList<String>();
		 * desiredAttributes.add("SHIP"); for (Iterator<String> iterator =
		 * memberAttributesKeySet.iterator(); iterator .hasNext();) { { String
		 * key = iterator.next(); if (!memberAttributesMap.get(key).isEmpty()) {
		 * desiredAttributes.add(memberAttributesMap.get(key)); } } }
		 * System.out.println("desiredAttributes.." + desiredAttributes);
		 * Map<String, String> loginCreds = loginScenario
		 * .getAMPMemberWithDesiredAttributes(desiredAttributes);
		 * 
		 * String userName = null; String pwd = null; if (loginCreds == null) {
		 * // no match found System.out.println(
		 * "Member Type data could not be setup !!!"); Assert.fail(
		 * "unable to find a " + desiredAttributes + " member"); } else {
		 * userName = loginCreds.get("user"); pwd = loginCreds.get("pwd");
		 * System.out.println("User is..." + userName); System.out.println(
		 * "Password is..." + pwd); getLoginScenario()
		 * .saveBean(LoginCommonConstants.USERNAME, userName);
		 * getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd); }
		 * 
		 * 
		 */
		String userName = "q3_sep_ulayer029";
		String pwd = "Password@1";

		getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
		getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		UlayerLoginPage loginPage = new UlayerLoginPage(wd);

		UlayerHomePage accountHomePage = (UlayerHomePage) loginPage.loginWith(userName, pwd);

		getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);

	}
	
	@Given("^registered UHC member with following attributes$")
	public void registered_UHC_member_with_following_attributes(DataTable arg1) {

		/*
		 * Reading the given attribute from feature file List<DataTableRow>
		 * List<DataTableRow> memberAttributesRow = memberAttributes
		 * .getGherkinRows(); Map<String, String> memberAttributesMap = new
		 * LinkedHashMap<String, String>(); for (int i = 0; i <
		 * memberAttributesRow.size(); i++) {
		 * 
		 * memberAttributesMap.put(memberAttributesRow.get(i).getCells()
		 * .get(0), memberAttributesRow.get(i).getCells().get(1)); }
		 * 
		 * String category = memberAttributesMap.get("Member Type");
		 * 
		 * Set<String> memberAttributesKeySet = memberAttributesMap.keySet();
		 * List<String> desiredAttributes = new ArrayList<String>(); 
		 * for (Iterator<String> iterator = memberAttributesKeySet.iterator();
		 * iterator .hasNext();) { { String key = iterator.next();
		 * desiredAttributes.add(memberAttributesMap.get(key)); }
		 * 
		 * } System.out.println("desiredAttributes.." + desiredAttributes);
		 * 
		 * Map<String, String> loginCreds = loginScenario
		 * .getUMSMemberWithDesiredAttributes(desiredAttributes); String
		 * userName = null; String pwd = null; if (loginCreds == null) { // no
		 * match found System.out.println(
		 * "Member Type data could not be setup !!!"); Assert.fail(
		 * "unable to find a " + desiredAttributes + " member"); } else {
		 * userName = loginCreds.get("user"); pwd = loginCreds.get("pwd");
		 * System.out.println("User is..." + userName); System.out.println(
		 * "Password is..." + pwd); getLoginScenario()
		 * .saveBean(LoginCommonConstants.USERNAME, userName);
		 * getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd); }
		 * 
		 */

		String userName = "q3_sep_grp028";
		String pwd = "Password@1";
		String category = "Group";

		getLoginScenario().saveBean(LoginCommonConstants.USERNAME, userName);
		getLoginScenario().saveBean(LoginCommonConstants.PASSWORD, pwd);

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		BlueLayerLoginPage loginPage = new BlueLayerLoginPage(wd);

		BlueLayerHomePage accountHomePage = (BlueLayerHomePage) loginPage.loginWith(userName, pwd, category);

		getLoginScenario().saveBean(PageConstants.ACCOUNT_HOME_PAGE, accountHomePage);

	}


	@When("^the user Navigates to AARP Member Redesign My Profile and Preferences page$")
	public void the_user_Navigates_to_Member_Redesign_My_Profile_and_Preferences_page() {
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
	public void the_user_Navigates_to_UMS_Member_Redesign_My_Profile_and_Preferences_page() {
		BlueLayerHomePage accountHomePage = (BlueLayerHomePage) getLoginScenario().getBean(PageConstants.ACCOUNT_HOME_PAGE);
		MyProfilesPage myProfilepage = accountHomePage.navigateToProfAndPref();
		if (myProfilepage != null) {
			System.out.println("Profile page Loaded");
			getLoginScenario().saveBean(PageConstants.PROF_AND_PREF_PAGE, myProfilepage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Error in Loading Profile and Preferences Summary Page");
		}

	}

	@Then("^the user Validates all Error Messages for Edit Email scenarios$")
	public void the_user_Validates_all_Error_Messages_for_Edit_Email_scenarios() {
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
	public void the_user_Validates_all_Error_Messages_for_Alt_Temp_Address_scenarios() {
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
		
	}


