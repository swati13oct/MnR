/**
 * 
 */
package atdd.runners.dashboard;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.dashboard.drugcostestimator.bluelayer" }, 
		features = { "feature/dashboard/drugcostestimator/bluelayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@drug_cost_estimatorstep5"})
public class RunMRAtddTestDCE {

}

