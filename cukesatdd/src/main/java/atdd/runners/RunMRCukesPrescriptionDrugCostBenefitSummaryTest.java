/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author pperugu
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.prescriptiondrugcostbenefitsummary" }, 
		features = { "feature/prescription-drugCost-BenefitsSummary" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@prescriptionDrugcostandSummaryums"})
public class RunMRCukesPrescriptionDrugCostBenefitSummaryTest {

}

