package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * 
 * @author pperugu
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.providersearch" }, 
		features = { "feature/provider-search" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@po7Test"})

public class RunMRAtddTestPo7 {
	
	
}
