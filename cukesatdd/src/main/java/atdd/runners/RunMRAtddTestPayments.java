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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.payments.ulayer.onetimepayment" }, 
		features = { "feature/payments/OneTimePayment/ulayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@TeamHActual,@TeamHError"})
public class RunMRAtddTestPayments {

}
