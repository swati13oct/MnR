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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.learnaboutplans.ulayer" }, 
		features = { "feature/learnaboutplans/ulayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@learnaboutplans"})
public class RunMRAtddTestLearnAboutPlans {
}
