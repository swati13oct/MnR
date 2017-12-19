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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.plansummary.bluelayer" }, 
		features = { "feature/plan-summary/bluelayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@plansummarymail"})
public class RunMRAtddTestPlanSummary {

}

