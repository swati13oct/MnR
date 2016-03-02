/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**	
 * @author pagarwa5
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.healthandwellness" }, 
		features = { "feature/health-and-wellness" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@HWaarp"})
public class RunMRCukesHealthAndWellness {

}
