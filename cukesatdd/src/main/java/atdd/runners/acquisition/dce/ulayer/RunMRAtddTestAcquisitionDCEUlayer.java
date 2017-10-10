/**
 * 
 */
package atdd.runners.acquisition.dce.ulayer;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.acquisition.drugcostestimator.ulayer" }, 
		features = { "feature/dceacquisition/ULayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@acq_drug_cost_estimator_switch_to_generic_home_flow,@acq_drug_cost_estimator_ulayer_flow,@acq_drug_cost_estimator_switch_to_generic_vpp_flow,@acq_drug_cost_estimator_disclaimer"})
public class RunMRAtddTestAcquisitionDCEUlayer {
//
}

