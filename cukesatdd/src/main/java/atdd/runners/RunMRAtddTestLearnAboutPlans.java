/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author pperugu
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.learnaboutplans" }, 
		features = { "feature/learnaboutplans" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@learnaboutplans"})
public class RunMRAtddTestLearnAboutPlans {
}
