package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.responsive.ulayer" }, 
		features = { "feature/vpp/ulayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/RunMRATddTestResponsiveAARPVppDCE-cucumber.json" }, tags ={"@VPP-DCE-ULayer"})

public class RunMRATddTestResponsiveAARPVppDCE {
	
	

}
