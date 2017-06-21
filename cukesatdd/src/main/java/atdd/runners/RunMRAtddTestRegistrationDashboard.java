/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author akuma103
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetest.registration" }, 
		features = { "feature/registrationMemberRedesign" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@registrationRedesign"})
public class RunMRAtddTestRegistrationDashboard {

}
