package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.responsive.Blayer" }, 
		features = { "feature/responsive/Blayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@sprint1"})
public class RunMRATddTestResponsiveUHCVpp {

}
