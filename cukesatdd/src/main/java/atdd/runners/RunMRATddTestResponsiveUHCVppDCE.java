package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.fixedtestcases" }, 
		features = { "feature/dcevpp/blayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/RunMRATddTestResponsiveUHCVppDCE-cucumberprint.json" }, tags ={"@acq_drug_cost_estimator_blayer"})

public class RunMRATddTestResponsiveUHCVppDCE {
	
	

}
