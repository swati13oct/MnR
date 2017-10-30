/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**	
 * @author pdas101
 *
 */
@RunWith(Cucumber.class)	
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.compareplanpage.Ulayer" }, 
		features = { "feature/compareplanpage/ulayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@compareplanaarp"})
public class RunAtddTestCompareplan {
	
}
