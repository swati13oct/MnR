package acceptancetests.acquisition.dceredesign;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

import acceptancetests.data.PageConstants;
import cucumber.api.java.en.When;
import pages.acquisition.dceredesign.DrugDetailsPage;
import pages.acquisition.dceredesign.DrugSummaryPage;

public class DCEStepDefinition_Depricated_ToberemovedSteps {

	//Removing these step definition, added new validation step for combined validation for all 3 stages text validation fro LIS buydown plans
	/*
	 * @Then("^the user verifies the catastrophic coverage message$") public void
	 * the_user_verifies_the_catastrophic_coverage_message(DataTable
	 * givenAttributes) throws Throwable { DrugDetailsPage drugDetailsPage = new
	 * DrugDetailsPage(driver); List<DataTableRow> memberAttributesRow =
	 * givenAttributes.getGherkinRows(); Map<String, String> memberAttributesMap =
	 * new HashMap<String, String>(); for (int i = 0; i <
	 * memberAttributesRow.size(); i++) {
	 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
	 * memberAttributesRow.get(i).getCells().get(1)); } String catastrophicMessage =
	 * memberAttributesMap.get("catastrophicCoverage");
	 * drugDetailsPage.validateCatastrophicCoverageMessage(catastrophicMessage);
	 * getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails,
	 * drugDetailsPage); }
	 * 
	 * @Then("^the user verifies the coverage gap message$") public void
	 * the_user_verifies_the_coverage_gap_message(DataTable givenAttributes) throws
	 * Throwable { DrugDetailsPage drugDetailsPage = new DrugDetailsPage(driver);
	 * List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
	 * Map<String, String> memberAttributesMap = new HashMap<String, String>(); for
	 * (int i = 0; i < memberAttributesRow.size(); i++) {
	 * memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
	 * memberAttributesRow.get(i).getCells().get(1)); } String coverageGapMessage =
	 * memberAttributesMap.get("coverageGap");
	 * drugDetailsPage.validateCoverageGapMessage(coverageGapMessage);
	 * getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails,
	 * drugDetailsPage); }
	 */
	

	/*
	 * public void validateCatastrophicCoverageMessage(String message) { if
	 * (validateNew(catastrophicCoverage)) { catastrophicCoverage.click();
	 * System.out.println(coverageMsg.getText()); System.out.println(message);
	 * String catastrophicCoverage =
	 * StringUtils.normalizeSpace(coverageMsg.getText()); modalCloseIcon.click();
	 * Assert.assertTrue("Catastrophic coverage message is incorrect",
	 * catastrophicCoverage.equals(message)); } else {
	 * Assert.fail("Catastrophic coverage Modal not displayed"); } }
	 * 
	 * public void validateCoverageGapMessage(String message) throws
	 * InterruptedException { if (validateNew(coverageGap)) {
	 * waitforElementNew(coverageGap, 30); coverageGap.click();
	 * System.out.println(coverageMsg.getText()); System.out.println(message);
	 * String coverageGap = coverageMsg.getText(); modalCloseIcon.click();
	 * Assert.assertTrue("Coverage gap message is incorrect",
	 * coverageGap.equals(message)); } else {
	 * Assert.fail("Coverage gap Modal not displayed"); } }
	 */
	
	

	/*
	 * @When("^user change the pharmacy to view no prescription coverage$") public
	 * void user_change_pharmacy_from_details_page_in_AARP() throws
	 * InterruptedException { DrugDetailsPage drugDetailsPage = new
	 * DrugDetailsPage(driver); drugDetailsPage.changePharmacyAndSave();
	 * drugDetailsPage.validatePharmVlaues();
	 * getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails,
	 * drugDetailsPage); }
	 */
	/*
	 * @When("^user validate the monthly premium value on detail page$") public void
	 * user_validate_monthly_value_in_AARP() throws InterruptedException {
	 * DrugDetailsPage drugDetailsPage = new DrugDetailsPage(driver);
	 * drugDetailsPage.validatePharmVlaues();
	 * getLoginScenario().saveBean(PageConstants.DCE_Redesign_DrugDetails,
	 * drugDetailsPage); }
	 */

	/*
	 * public void changePharmacyAndSave() { validateNew(selectRockPharm);
	 * selectRockPharm.click(); validateNew(saveDrugBtn); saveDrugBtn.click(); }
	 * 
	 * public void validatePharmVlaues() { validateNew(rockPharmAlertText);
	 * System.out.println(rockPharmAlertText.getText()); validateNew(monthlyValue);
	 * assertTrue(monthlyValue.getText() != "");
	 * System.out.println("Monthly Value: " + monthlyValue.getText()); }
	 */
	
/*
	@When("^user click on Switch To Generic$")
	public void User_click_on_Switch_To_Generic_in_AARP() throws Throwable {
		DrugDetailsPage drugDetailsPage = (DrugDetailsPage) getLoginScenario()
				.getBean(PageConstants.DCE_Redesign_DrugDetails);
		drugDetailsPage.clickswitchToGeneric();

	}*/
	
/*
	@When("^user click on Switch To Generic on drug summary$")
	public void User_click_on_Switch_To_Generic_drug_summary() throws Throwable {
		DrugSummaryPage drugSummaryPage = new DrugSummaryPage(driver);
		drugSummaryPage.clickswitchToGeneric();

	}*/
	
}
