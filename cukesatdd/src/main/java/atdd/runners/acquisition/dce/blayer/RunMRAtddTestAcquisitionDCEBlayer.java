/**
 * 
 */
package atdd.runners.acquisition.dce.blayer;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.acquisition.drugcostestimator.bluelayer" }, 
		features = { "feature/dceacquisition/blueLayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@acq_drug_cost_estimator_blayer_flow"})
public class RunMRAtddTestAcquisitionDCEBlayer {
//
}

