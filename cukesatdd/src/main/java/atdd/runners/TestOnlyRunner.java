/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**	
 * @author ganilku1
 *
 */
@RunWith(Cucumber.class)	
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.testonly" }, 
		features = { "feature/test_only" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@test-only"})
public class TestOnlyRunner {
	
}
