package atdd.runners;
import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.responsive.bluelayer" }, 
		features = { "feature/responsive/Blayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumberprint5.json" }, tags ={"@rightRail, @US657089, @US657296,  @US646136, @US670704, @US670869, @US638058"})
public class RunMRATddTestResponsiveFnF {
	
	

}