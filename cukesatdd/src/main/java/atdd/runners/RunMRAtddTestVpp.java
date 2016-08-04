package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * 
 * @author pgrover1
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.vpp" }, 
		features = { "feature/vpp/ulayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@vppaarp"})

public class RunMRAtddTestVpp {
	
	
}
