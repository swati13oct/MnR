/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**	
 * @author sunya
 *
 */
@RunWith(Cucumber.class)	
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.testonly.blayer" }, 
		features = { "feature/testonly/blayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@testonly-seirra003"})
public class RunOnlySierraRunner {
	
}
