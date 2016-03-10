package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * 
 * @author schak38
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.phr" }, 
		features = { "feature/phr" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@phr"})

public class RunMRAtddTestPhr {
	
	
}
