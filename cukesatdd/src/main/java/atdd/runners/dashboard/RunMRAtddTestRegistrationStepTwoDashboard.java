
package atdd.runners.dashboard;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author akuma103
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.dashboard.registration" }, 
		features = { "feature/registrationMemberRedesign" }, 
		format = {"pretty", "html:reports/test-report","json:target/RunMRAtddTestRegistrationStepTwoDashboard-cucumber.json"},
		tags ={"@registrationStepTwo,@registrationStepThree"})

public class RunMRAtddTestRegistrationStepTwoDashboard {

}