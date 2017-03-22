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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.benefitsandcoveragejenkins.ulayer" }, 
		features = { "feature/plan-benefits-and-coverage" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@needHelp1"})
public class RunMRAtddTestBnC {

}
