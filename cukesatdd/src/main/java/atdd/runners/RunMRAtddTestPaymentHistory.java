/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author sunya
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.paymenthistory.ulayer" }, 
		features = { "feature/payments/PaymentHistory/ulayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@payment_history"})
public class RunMRAtddTestPaymentHistory {

}

