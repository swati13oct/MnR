package acceptancetests.dashboard.formsandresources;

import gherkin.formatter.model.DataTableRow;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import pages.dashboard.formsandresources.FormsAndResourcesPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en_au.When;
import cucumber.table.DataTable;

public class DashBoardFormsAndResourcesStepDefinition {

	@Autowired
	MRScenario loginScenario;
	
	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^registered member lands on forms and resources in member blue Layer Site$")
	public void navigateToBlueLayerLoginPage() {
		// navigate to Blue layer login site
		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		// create F& R context
		FormsAndResourcesPage formsAndResourcesPage = new FormsAndResourcesPage(
				wd);
		getLoginScenario().saveBean(
				PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE,
				formsAndResourcesPage);

	}

	@When("^member click on member sign in link$")
	public void membeClicksOnMemberSignIn() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.clickMemberSignIn();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@And("^the member enters userId and member enter password$")
	public void memberEntersUserIdAndPassword(DataTable givenAttributes) {
		// get test variables
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		System.out.println(memberAttributesMap);
		// get userId
		String userId = memberAttributesMap.get("USER_ID");
		String password = memberAttributesMap.get("PASSWORD");
		// navigate to registration page
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		formsAndResourcesPage.enterUserid(userId);
		formsAndResourcesPage.enterPassword(password);
	}

	@And("^member click signin button and logs in$")
	public void membeClicksOnSignInButton() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.clickMemberSignInButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Then("^open blue layer test harnesss page in a new tab$")
	public void openTestHarnessPageInNewTab() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.openTestHarnessPage();
	}
	
	@And("^click on the forms and resource link and navigate to forms and resource page$")
	public void clickOnFormAndResourcesLink() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.clickonFormsAndResourcesLinkOnTestHarness();
	}
	
	@SuppressWarnings("deprecation")
	@And("^validate EOB section$")
	public void validateEOBSection(DataTable givenAttributes) {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String eobMedicalLink = memberAttributesMap.get("EOB_MEDICAL_LINK");
		String eobDrugLink = memberAttributesMap.get("EOB_DRUG_LINK");
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		String isEOBMedicalButtonVisible = isButtonVisible(formsAndResourcesPage.getEOBMedicaButton()) ?"YES": "NO";
		String isEOBDrugButtonVisible =  isButtonVisible(formsAndResourcesPage.getEOBDrugButton()) ?"YES": "NO";
		Assert.assertEquals(eobMedicalLink, isEOBMedicalButtonVisible);
		Assert.assertEquals(eobDrugLink, isEOBDrugButtonVisible);
		
	}
	
	@SuppressWarnings("deprecation")
	@And("^validate my document section$")
	public void validateMyDocumentSection(DataTable givenAttributes) {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		
		String myDocumentSection = memberAttributesMap.get("MY_DOCUMENT_SECTION");
		String isMyDocumentVisible = isButtonVisible(formsAndResourcesPage.getMyDocumentSection()) ?"YES": "NO";
		Assert.assertEquals(myDocumentSection, isMyDocumentVisible);
	}

	@SuppressWarnings("deprecation")
	@And("^validate renew magazine section$")
	public void validateRenewMagazineSection(DataTable givenAttributes) {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String renewMagazine = memberAttributesMap.get("RENEW_MAGAZINE_SECTION");
		String isRenewMagazineVisible = isButtonVisible(formsAndResourcesPage.getRenewMagazineSection()) ?"YES": "NO";
		Assert.assertEquals(renewMagazine, isRenewMagazineVisible);
		
	}
	
	private boolean isButtonVisible(WebElement button){
		try{
			if(button.isDisplayed()){
				return true;
			}
		}catch(NoSuchElementException noSuchElementException){
			return false;
		}
		return false;
		
	}

	
	

}
