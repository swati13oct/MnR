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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.benefitsandcoverage" }, 
		features = { "feature/plan-benefits-and-coverage" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@bncfnf"})
public class RunMRAtddTestBnC {

}

