package acceptancetests.memberrdesignVBF.forms;

import gherkin.formatter.model.DataTableRow;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.springframework.beans.factory.annotation.Autowired;

import pages.memberrdesignVBF.RallyDashboardPage;
import pages.memberrdesignVBF.TestHarness;
import pages.memberrdesignVBF.FormsAndResourcesPage;
import atdd.framework.*;
import acceptancetests.data.PageConstants;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * @Functionality : Forms and resources page navigation from dashboard and
 *                sections validation
 */
@SuppressWarnings("deprecation")
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
			Assert.assertTrue("all pdfs are coming correctly", true);
			System.out.println("all pdfs are coming correctly");
		} else {
			Assert.fail("pdfs not coming correctly");
			System.out.println("pdfs not coming correctly");
		}
	}

	@And("^for active member Temporary Id Card and Plan Order Material links are displayed$")
	public void linksdisplayedforactivemembers() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		formsAndResourcesPage.getOrderPlanMaterialLink().isDisplayed();

		formsAndResourcesPage.getTemporaryIdcardlink().isDisplayed();

	}

	@Then("^validate that the EOB section is displayed$")
	public void eobsec() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		Assert.assertTrue("eob section header present", formsAndResourcesPage.geteobmapdsection().isDisplayed());
		System.out.println("eob section header present");

	}

	/**
	 * @throws InterruptedException
	 * @toDo :for MAPD member both types of EOB are present
	 */

	@And("^both the Drug and Medical EOB links are displayed$")
	public void bothEOBSpresent() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		Assert.assertTrue("medical eob present", formsAndResourcesPage.getEOBMedicaButton().isDisplayed());
		System.out.println("medical eob present");
		Assert.assertTrue("drug eob present", formsAndResourcesPage.getEOBDrugButton().isDisplayed());
		System.out.println("drug eob present");

	}

	/* to verify the my doc section */
	@Then("^validate that My document section is displayed$")
	public void mydocumentsectionisdispayed() throws InterruptedException {

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		Assert.assertTrue("my doc sec is present", formsAndResourcesPage.getMyDocumentSection().isDisplayed());
		Assert.assertTrue("search doc sec is present", formsAndResourcesPage.getSearchDocument().isDisplayed());

	}

	@Then("^validate that the anoc section is displayed$")
	public void anocsec() throws InterruptedException {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		if (formsAndResourcesPage.getANOCSection().isDisplayed()) {
			Assert.assertTrue("anoc section is present", true);
			System.out.println("anoc section is present");

		} else {
			Assert.fail("anoc section is not present");
		}

	}

	@Then("^validate that the annual directories section is displayed$")
	public void annualdirectory() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		Assert.assertTrue("annual directory section is present",
				formsAndResourcesPage.getAnnualDirectorySection().isDisplayed());
	}

	@And("^both the Pharmacy locator and provider search links are displayed$")
	public void pharmacyprovider() {
		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);
		Assert.assertTrue("pharmacy locator is present", formsAndResourcesPage.getpharmacysearchlink().isDisplayed());
		Assert.assertTrue("provider search link is present",
				formsAndResourcesPage.getprovisesearchlink().isDisplayed());
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
			Assert.assertTrue("Plan Materials section exists...", true);
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
	 * @throws InterruptedException
	 * @toDo : verifies the forms and resources section
	 */
	@Then("^validate that the forms and resources section is displayed$")
	public void validateFNRSection() throws InterruptedException {

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		Assert.assertTrue("forms and resources sec is present",
				formsAndResourcesPage.getFormsandResourcesSection().isDisplayed());
		System.out.println("forms and resources sec is present");

		formsAndResourcesPage.validateFormsResourcesLinks();
	}

	@Then("^validate that the renew magazine section is displayed$")
	public void validateRenewSection() throws InterruptedException {

		FormsAndResourcesPage formsAndResourcesPage = (FormsAndResourcesPage) getLoginScenario()
				.getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE);

		if (formsAndResourcesPage.getRenewMagazineSection().isDisplayed()) {
			System.out.println("renew sec is present");
		} else
			Assert.fail("renw sec not coming");

	}
}
