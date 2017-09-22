package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.responsive.blayer" }, 
		features = { "feature/vpp/bluelayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/RunMRATddTestResponsiveUHCVppDCE-cucumberprint.json" }, tags ={"@VPP-DCE"})

public class RunMRATddTestResponsiveUHCVppDCE {
	
	

}
