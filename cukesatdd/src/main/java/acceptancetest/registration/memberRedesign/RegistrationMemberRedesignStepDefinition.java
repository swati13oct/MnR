package acceptancetest.registration.memberRedesign;

import gherkin.formatter.model.DataTableRow;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.dashboard.acquisition.RegistrationInformationPage;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import atdd.framework.MRScenario;

/**
 * @author akuma103
 *
 */

public class RegistrationMemberRedesignStepDefinition {

	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

@Given("^the member is on registration page of new portal part of redesign$")
public void navigateToRegistrationRedesignPage() {
	// navigate to Registration page
	WebDriver wd = getLoginScenario().getWebDriver();
	getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	

	//create registration context
	RegistrationInformationPage registrationInformationPage = new RegistrationInformationPage(wd);
	getLoginScenario().saveBean(PageConstants.REGISTRATION_INFORMATION_PAGE, registrationInformationPage);
    
}

@When("^the member enter the member ID into Member ID field$")
public void enterMemberID(DataTable givenAttributes) {
	// get test variables
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
	    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
	}

	// get member ID
	String memberId = memberAttributesMap.get("Plan Member ID");
  	// navigate to registration page
	RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
			getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
	registrationInformationPage.enterMemberID(memberId);
}

@When("^member enter date of birth in the date of birth dropdown$")
public void enterDate(DataTable givenAttributes) {
	// get test variables
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
	    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
	}

	// get date of birth
	String dateOfBirth = memberAttributesMap.get("Date of birth");
	String[] splitDate = dateOfBirth.split("-");
	String month = splitDate[0];
	String day= splitDate[1];
	String year = splitDate[2];
	
	RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
			getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
	
	registrationInformationPage.enterMonth(month);
	registrationInformationPage.enterDay(day);
	registrationInformationPage.enterYear(year);
	   
}

@When("^member click Next$")
public void clickNext() {
	RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
			getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
	registrationInformationPage.clickNext();
	    
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@Then("^member will be navigated to registration plan information page$")
public void RegistrationPlanInformation() {
	RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
			getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
	Assert.assertTrue(registrationInformationPage.currentUrl().contains("memberRegistration-Step2"));
	}

@Then("^Verify correct plan name id displayed$")
public void verifyRegistrationPlanInformation(DataTable givenAttributes){
	// get test variables
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
	    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
	}

	// get plan name
	String expectedPlanName = memberAttributesMap.get("Plan name");	
	RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
			getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
	String actualPlanName = registrationInformationPage.getPlanName().getText();
	Assert.assertEquals(expectedPlanName, actualPlanName);
	}


@Then("^the member navigate to additional information section$")
public void VerifyAdditionInformtionSeaction() {
	RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
			getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
	registrationInformationPage.getAdditionalInfoHeader().isEnabled();
	}

@Then("^member enter additional information$")
public void enterAdditionalInformation(DataTable givenAttributes) {
	// get test variables
	List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
	for (int i = 0; i < memberAttributesRow.size(); i++) {
	    memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
	}
	// get member ID
	String zipCode = memberAttributesMap.get("Zip Code");
	String fName = memberAttributesMap.get("First Name");
	String lName = memberAttributesMap.get("Last Name");
	RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
			getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);	
	registrationInformationPage.enterZip(zipCode);
	registrationInformationPage.enterFirstName(fName);
	registrationInformationPage.enterLastName(lName);

}

@Then("^the member validate existing member error message$")
public void existingMemberErrorMessage() {
	RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
			getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
	registrationInformationPage.getExistingMemberError().isDisplayed();
	}

@Then("^the member validate inactive or terminated error message$")
public void inactiveTerminatedErrorMessage() {
	RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
			getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
	registrationInformationPage.getInactiveTerminatedError().isDisplayed(); 
	}

@Then("^the member validate future effective error message$")
public void futureEffectiveErrorMessage() {
	RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
			getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
	registrationInformationPage.getFutureEffectiveError().isDisplayed();
   }

@Then("^the member validate member not found error message$")
public void memberNotFoundErrorMessage() {
	RegistrationInformationPage registrationInformationPage = (RegistrationInformationPage) 
			getLoginScenario().getBean(PageConstants.REGISTRATION_INFORMATION_PAGE);
	registrationInformationPage.getmemberNotFoundError().isDisplayed();
	}
}
