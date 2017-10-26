/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**	
 * @author pagarwa5
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.loginassistance.ulayer" }, 
		features = { "feature/login-assistance/ulayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@US738867"})
//US738867 LoginAssistanceErrorMessages
public class RunMRAtddTestLoginAssistance {

}
