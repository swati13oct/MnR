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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.benefitsandcoverage.ulayer"}, 
		features = {"feature/plan-benefits-and-coverage/ulayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@BenefitsSummaryShip"})
public class RunMRAtddTestUlayerBenefitsSummary {
}
