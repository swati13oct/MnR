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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.plansummary" }, 
		features = { "feature/plan-summary" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@plansummary"})
public class RunMRCukesPlanSummaryTest {

}

