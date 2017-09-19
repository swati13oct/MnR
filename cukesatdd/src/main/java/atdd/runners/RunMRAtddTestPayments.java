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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.AutomaticPayments.ulayer" }, 
		features = { "feature/payments/AutomaticPayment/ulayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@TeamH,@TeamHError"})
public class RunMRAtddTestPayments {

}
