
package acceptancetests.registration.Redesign;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.redesign.ReDesignRegistrationPage;

/**
 * @author sdwaraka
 *
 */
public class HICNtoMBIRegistrationFlowsStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^Server Date is set to the following date$")
	public void Server_Date_is_set_to_the_following_date(DataTable arg1) {
		List<DataTableRow> givenAttributesRow = arg1
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String ServerDate_MilliSeconds = givenAttributesMap.get("Server Date");
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		ReDesignRegistrationPage RegistrationPage = new ReDesignRegistrationPage(wd);
		RegistrationPage = RegistrationPage.SetServerDate(ServerDate_MilliSeconds);
		RegistrationPage = RegistrationPage.NavigateToRegistrationPage();
		if(RegistrationPage!=null){
			getLoginScenario().saveBean(PageConstants.NEW_REGISTRATION_PAGE,RegistrationPage);
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("***** Error in loading  Redesign Registration Page *****");
		}
	}

	@Given("^User adds the following details in Registration Page and click on Continue Button$")
	public void User_adds_the_following_details_in_Registration_Page_and_click_on_Continue_Button(DataTable arg1) {
		List<DataTableRow> givenAttributesRow = arg1
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String MemberNo = givenAttributesMap.get("Member Number");
		String DOB = givenAttributesMap.get("Date Of Birth");
		
		ReDesignRegistrationPage RegistrationPage = (ReDesignRegistrationPage) getLoginScenario().getBean(PageConstants.NEW_REGISTRATION_PAGE);
		
		RegistrationPage = RegistrationPage.Enter_MemberNo_DOB(MemberNo, DOB);
		if(RegistrationPage!=null){
			getLoginScenario().saveBean(PageConstants.NEW_REGISTRATION_PAGE,RegistrationPage);
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("***** Error in loading  Additional Information Section : Incorrect Member No or DOB entered *****");
		}


	}

	@When("^User enters Following No in the Member ID field$")
	public void User_enters_Following_No_in_the_Member_ID_field(DataTable arg1) {
		List<DataTableRow> givenAttributesRow = arg1
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {
			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String Type_MedicareID = givenAttributesMap.get("Identification Type");
		String Medicar_ID_Value = givenAttributesMap.get("Identification Value");
	}

	@Then("^Validate that Continue button is enabled$")
	public void Continue_button_should_be_enabled() {
		// Express the Regexp above with the code you wish you had
	}

	@Then("^User should successfully navigate to create User Account Page$")
	public void User_should_successfully_navigate_to_create_User_Account_Page() {
		// Express the Regexp above with the code you wish you had
	}

	@Then("^Validate that Continue button is Disabled$")
	public void Continue_button_should_be_Disabled() {
		// Express the Regexp above with the code you wish you had
	}

	@Then("^User should NOT be able navigate to create User Account Page$")
	public void User_should_NOT_be_able_navigate_to_create_User_Account_Page() {
		// Express the Regexp above with the code you wish you had
	}

	@Then("^The following Error Message should be Displayed$")
	public void The_following_Error_Message_should_be_Displayed() {
		// Express the Regexp above with the code you wish you had
	}

}
