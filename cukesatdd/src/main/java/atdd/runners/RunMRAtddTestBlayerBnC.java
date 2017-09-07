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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.benefitsandcoveragejenkins.bluelayer"}, 
		features = {"feature/plan-benefits-and-coverage/bluelayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@drugcopaysectionlis"})



public class RunMRAtddTestBlayerBnC {
}
