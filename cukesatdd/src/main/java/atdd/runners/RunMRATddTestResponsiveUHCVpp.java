package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.responsive.bluelayer" }, 
		features = { "feature/responsive/Blayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumberprint5.json" }, tags ={"@US699362,@US689310,@US689260,@US699059"})
//@US698836,,@US702406
public class RunMRATddTestResponsiveUHCVpp {
	
	

}
