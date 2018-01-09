/**
 * 
 */
package atdd.mobile.runners.ulayer;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * @author sunya
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.mobile.dashboard.payments" }, 
		features = { "feature/mobile/dashboard" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@payment_history_mobile"})
public class RunMRAtddTestPaymentHistory {

}

