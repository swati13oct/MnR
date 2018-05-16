package acceptancetests.memberrdesignVBF.forms;

import gherkin.formatter.model.DataTableRow;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import junit.framework.Assert;

import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;
import pages.memberrdesignVBF.BenefitsAndCoveragePage;
import pages.memberrdesignVBF.FormsAndResourcesPage;
import pages.member.redesign.NewLoginPage;

import pages.member.ulayer.LoginPage;
import pages.member.ulayer.RallyDashboard;
import atdd.framework.*;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @Functionality : Forms and resources page navigation from dashboard and
 *                sections validation
 */
public class FormsAndResourcesStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/***
	 * 
	 * @throws InterruptedException
	 */
	@And("^the user navigates to Forms and Resources Page$")
	public void user_navigates_to_FormsAndResources_Page() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario().getBean(PageConstants.TEST_HARNESS_PAGE);

			formsAndResourcesPage = testHarness.navigateDirectToFnRPage();
		} else {
			RallyDashboardPage rallyDashboardPage = (RallyDashboardPage) getLoginScenario()
					.getBean(PageConstants.RALLY_DASHBOARD_PAGE);
			formsAndResourcesPage = rallyDashboardPage.navigateDirectToFnRPage();
		}

		if (null == formsAndResourcesPage) {
			System.out.println("Forms and Resources page is not loaded!!!");
			Assert.fail("Forms and Resources page is not loaded!!!");
		} else {
			getLoginScenario().saveBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE, formsAndResourcesPage);
		}

	}

	/**
	 * @toDo : correct pdfs are coming
	 */
	@SuppressWarnings("deprecation")
	@And("^the user verifies that the correct pdfs are coming in the plan material section$")
	public void verifypdfscoming(DataTable givenAttributes) throws InterruptedException {

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		System.out.println(memberAttributesRow);
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		Collection<String> values = memberAttributesMap.values();
		String[] targetArray = values.toArray(new String[values.size()]);
		boolean arraycheck = formsAndResourcesPage.verifypdfname(targetArray);
		if (arraycheck == true) {
			Assert.assertTrue("all pdfs are coming correctly",true);
			System.out.println("all pdfs are coming correctly");
		} else {
			Assert.fail("pdfs not coming correctly");
			System.out.println("pdfs not coming correctly");
		}
	}

	@And("^the user changes the laguage in the language dropdown$")
	public void changelanguageforpdfs() throws InterruptedException {

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		/*formsAndResourcesPage.scroll();
		Thread.sleep(5000);*/
		formsAndResourcesPage.changelanguage();
	}

	/**
	 * @toDo : show that order plan material is not visible for terminated
	 *       member
	 */

	@And("^for terminated member order plan materials link is not displayed$")
	public void linknotdisplayedforterminated() {

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		// formsAndResourcesPage.checkOrderPlanMaterialLinkforterminated();
		Assert.assertTrue(formsAndResourcesPage.checkPOrderPlanMaterialLinkNotAvailable());

	}

	@And("^Renew Magazine section is not displayed for termibated members$")
	public void renewsectionfortermed() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.scroll();
		formsAndResourcesPage.scroll();
		formsAndResourcesPage.checkRenewsectionforterminated();
	}

	@And("^for active member Temporary Id Card and Plan Order Material links are displayed$")
	public void linksdisplayedforactivemembers() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		formsAndResourcesPage.getOrderPlanMaterialLink().isDisplayed();

		formsAndResourcesPage.getTemporaryIdcardlink().isDisplayed();

	}

	@And("^clicking on the order plan materials link the user is navigated to the Order Plan Material Page$")
	public void planmateriallink() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		Thread.sleep(2000);
		formsAndResourcesPage.validateOrderPlanMaterial();

	}

	@And("^clicking on the view temporary id card link the modal id popups open up$")
	public void temporaryidcardlink() throws InterruptedException {

	}

	/**
	 * @toDo :clicking on cross symbol on id cards to navigate back to the rally
	 *       dashboard page
	 */

	@And("^clicking on cross symbol the user is navigated back to the rally dashboard page$")
	public void clickoncross() throws InterruptedException {

	}

	@SuppressWarnings("deprecation")
	@Then("^validate that the EOB section is displayed$")
	public void eobsec() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		/*formsAndResourcesPage.scroll();
		Thread.sleep(2000);*/
			Assert.assertTrue("eob section header present",formsAndResourcesPage.geteobmapdsection().isDisplayed());
			System.out.println("eob section header present");

	}

	/**
	 * @throws InterruptedException
	 * @toDo :for MAPD member both types of EOB are present
	 */

	@SuppressWarnings("deprecation")
	@And("^both the Drug and Medical EOB links are displayed$")
	public void bothEOBSpresent() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		/*Thread.sleep(2000);
		formsAndResourcesPage.scroll();*/
			Assert.assertTrue("medical eob present",formsAndResourcesPage.getEOBMedicaButton().isDisplayed());
			System.out.println("medical eob present");
			Assert.assertTrue("drug eob present",formsAndResourcesPage.getEOBDrugButton().isDisplayed());
			System.out.println("drug eob present");

	}

	/* to verify the my doc section */
	@SuppressWarnings("deprecation")
	@Then("^validate that My document section is displayed$")
	public void mydocumentsectionisdispayed() throws InterruptedException {

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		//Thread.sleep(2000);
			Assert.assertTrue("my doc sec is present",formsAndResourcesPage.getMyDocumentSection().isDisplayed());
			Assert.assertTrue("search doc sec is present",formsAndResourcesPage.getSearchDocument().isDisplayed());
			
	}

	@SuppressWarnings("deprecation")
	@Then("^validate that the anoc section is displayed$")
	public void anocsec() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		/*formsAndResourcesPage.scroll();
		Thread.sleep(2000);*/
		if (formsAndResourcesPage.getANOCSection().isDisplayed()) {
			Assert.assertTrue("anoc section is present",true);
			System.out.println("anoc section is present");

		} else {
			Assert.fail("anoc section is not present");
		}

	}

	@SuppressWarnings("deprecation")
	@Then("^validate that the annual directories section is displayed$")
	public void annualdirectory() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
			Assert.assertTrue("annual directory section is present",formsAndResourcesPage.getAnnualDirectorySection().isDisplayed());
	}

	@SuppressWarnings("deprecation")
	@And("^both the Pharmacy locator and provider search links are displayed$")
	public void pharmacyprovider() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
			Assert.assertTrue("pharmacy locator is present",formsAndResourcesPage.getpharmacysearchlink().isDisplayed());
			Assert.assertTrue("provider search link is present",formsAndResourcesPage.getprovisesearchlink().isDisplayed());
	}

	/**
	 * @toDo : verifies the EOB section
	 */
	@SuppressWarnings("deprecation")
	@Then("^validate EOB section$")
	public void validateEOBSection(DataTable givenAttributes) {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		formsAndResourcesPage.scroll();
		String eobMedicalLink = memberAttributesMap.get("EOB_MEDICAL_LINK");
		String eobDrugLink = memberAttributesMap.get("EOB_DRUG_LINK");
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String isEOBMedicalButtonVisible = isButtonVisible(formsAndResourcesPage.getEOBMedicaButton()) ? "YES" : "NO";
		String isEOBDrugButtonVisible = isButtonVisible(formsAndResourcesPage.getEOBDrugButton()) ? "YES" : "NO";
		Assert.assertEquals(eobMedicalLink, isEOBMedicalButtonVisible);
		Assert.assertEquals(eobDrugLink, isEOBDrugButtonVisible);

	}

	/**
	 * @toDo : verifies my document section
	 */
	@SuppressWarnings("deprecation")
	@And("^validate my document section$")
	public void validateMyDocumentSection(DataTable givenAttributes) {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String myDocumentSection = memberAttributesMap.get("MY_DOCUMENT_SECTION");
		String isMyDocumentVisible = isButtonVisible(formsAndResourcesPage.getMyDocumentSection()) ? "YES" : "NO";
		Assert.assertEquals(myDocumentSection, isMyDocumentVisible);
	}

	/**
	 * @toDo : verifies renew magazine section
	 */
	@SuppressWarnings("deprecation")
	@And("^validate renew magazine section$")
	public void validateRenewMagazineSection(DataTable givenAttributes) {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		formsAndResourcesPage.scroll();
		String renewMagazine = memberAttributesMap.get("RENEW_MAGAZINE_SECTION");
		String isRenewMagazineVisible = isButtonVisible(formsAndResourcesPage.getRenewMagazineSection()) ? "YES" : "NO";
		Assert.assertEquals(renewMagazine, isRenewMagazineVisible);

	}

	/**
	 * @throws InterruptedException
	 * @toDo : verifies the plan material section
	 */
	@Then("^validate that the plan materials section is displayed$")
	public void validatePlanMaterialSection() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		if (formsAndResourcesPage.getplanmaterialsection().isDisplayed()) {
			System.out.println("Plan Materials section exists...");
			Assert.assertTrue("Plan Materials section exists...",true);
		} else {
			Assert.fail("plan material section is not present");
		}

	}

	/**
	 * @toDo : clicks order plan materials and view temporary id card links
	 */
	@And("^validates the view temporary id card link$")
	public void clicklinksonplanmaterials() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		Thread.sleep(10000);

		//formsAndResourcesPage.getTemporaryIdcardlink().isDisplayed();
		formsAndResourcesPage.validateIDCard();

	}

	/**
	 * @toDo : verifies default language displayed in the drop down
	 */
	@And("^validate that english is default language in dropdown$")
	public void validatelanguage() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		formsAndResourcesPage.validateEngDefault();
	}

	/**
	 * @toDo : verifies the anoc section
	 */
	@Then("^validate the anoc section$")
	public void validateAnocSection(DataTable givenAttributes) {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		formsAndResourcesPage.scroll();
		String anocsection = memberAttributesMap.get("ANOC_SECTION");
		String isANOCSECTIONVisible = isButtonVisible(formsAndResourcesPage.getANOCSection()) ? "YES" : "NO";
		Assert.assertEquals(anocsection, isANOCSECTIONVisible);

	}

	/**
	 * @toDo : user switches to a different language than the default one
	 */
	@And("^change the language in the language dropdown$")
	public void changelanguage() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		formsAndResourcesPage.changelanguage();

	}

	/**
	 * @toDo : verifies the annual directories section
	 */
	@Then("^validate the annual directories section$")
	public void validatePlanMaterialSection(DataTable givenAttributes) {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}
		formsAndResourcesPage.scroll();
		String AnnualDirectoriesSection = memberAttributesMap.get("ANNUAL_DIRECTORIES_SECTION");
		String providersearchLink = memberAttributesMap.get("PROVIDER_SEARCHLINK");
		String pharmacylocatorLink = memberAttributesMap.get("PHARMACY_SEARCHLINK");
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		String isPharmacyLocatorLinkVisible = isButtonVisible(formsAndResourcesPage.getpharmacysearchlink()) ? "YES"
				: "NO";
		String isproviderSearchVisible = isButtonVisible(formsAndResourcesPage.getprovisesearchlink()) ? "YES" : "NO";
		Assert.assertEquals(providersearchLink, isproviderSearchVisible);
		Assert.assertEquals(pharmacylocatorLink, isPharmacyLocatorLinkVisible);

		String isannualdirectoryVisible = isButtonVisible(formsAndResourcesPage.getAnnualDirectorySection()) ? "YES"
				: "NO";
		Assert.assertEquals(AnnualDirectoriesSection, isannualdirectoryVisible);

	}

	/**
	 * @throws InterruptedException
	 * @toDo : verifies the eob statemnets for ship member
	 */

	@And("^validate that the EOB statemnets section is displayed$")
	public void validateEOBship() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		Thread.sleep(5000);
		System.out.println("eob section");
		formsAndResourcesPage.validateshipeob();
	}

	/**
	 * @throws InterruptedException
	 * @toDo : verifies the forms and resources section
	 */
	@SuppressWarnings("deprecation")
	@Then("^validate that the forms and resources section is displayed$")
	public void validateFNRSection() throws InterruptedException {

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		/*formsAndResourcesPage.scroll();
		Thread.sleep(5000);*/
		/* formsAndResourcesPage.clickonperceptionpopup(); */
			Assert.assertTrue("forms and resources sec is present",formsAndResourcesPage.getFormsandResourcesSection().isDisplayed());
			System.out.println("forms and resources sec is present");

		formsAndResourcesPage.validateFormsResourcesLinks();
	}

	@Then("^validate that the renew magazine section is displayed$")
	public void validateRenewSection() throws InterruptedException {

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
/*
		formsAndResourcesPage.scroll();
		Thread.sleep(5000);*/
		/* formsAndResourcesPage.clickonperceptionpopup(); */
		//System.out.println("fnr section");
		if (formsAndResourcesPage.getRenewMagazineSection().isDisplayed()) {
			System.out.println("renew sec is present");
		} else
			Assert.fail("renw sec not coming");

	}

	private boolean isButtonVisible(WebElement button) {
		try {
			if (button.isDisplayed()) {
				return true;
			}
		} catch (NoSuchElementException noSuchElementException) {
			return false;
		}
		return false;
	}
}
