package acceptancetests.acquisition.dceredesign;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

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
}
