package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * 
 * @author rkodumur
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.rally.sso" }, 
		features = { "feature/rally-SSO" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@RallySSO"})

public class RunMRAtddRallySSO {
	
	
	
	
}
