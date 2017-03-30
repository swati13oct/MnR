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
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@drug_cost_estimator_switch_to_generic_case_2"})
public class RunMRAtddTestDCE {

}

