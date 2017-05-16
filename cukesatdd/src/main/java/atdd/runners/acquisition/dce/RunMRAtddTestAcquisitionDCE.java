/**
 * 
 */
package atdd.runners.acquisition.dce;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.acquisition.drugcostestimator.ulayer" }, 
		features = { "feature/dceacquisition/ULayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@acq_drug_cost_estimator"})
public class RunMRAtddTestAcquisitionDCE {
//
}

