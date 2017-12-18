package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.vpp.ulayer" }, 
		features = { "feature/dcevpp/ulayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/RunMRATddTestResponsiveAARPVppDCE-cucumber.json" }, tags ={"@acq_drug_cost_estimator"})

public class RunMRATddTestResponsiveAARPVppDCE {
	
	

}
