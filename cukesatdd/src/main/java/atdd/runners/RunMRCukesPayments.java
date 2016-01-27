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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.payments" }, 
		features = { "feature/payments" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@paymen"})
public class RunMRCukesPayments {

}
