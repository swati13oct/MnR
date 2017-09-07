/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author pjaising
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.benefitsandcoveragejenkins.ulayer"}, 
		features = {"feature/plan-benefits-and-coverage/ulayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@PlanOverview"})
public class RunMRAtddTestUlayerBnC {
}
