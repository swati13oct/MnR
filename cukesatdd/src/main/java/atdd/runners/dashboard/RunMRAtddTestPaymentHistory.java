/**
 * 
 */
package atdd.runners.dashboard;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author sunya
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.dashboard.payments" }, 
		features = { "feature/dashboard/payments" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@payment_history"})
public class RunMRAtddTestPaymentHistory {

}

