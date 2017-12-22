
package atdd.runners.dashboard;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.dashboard.registration" }, 
		features = { "feature/registrationMemberRedesign" }, 
		format = {
				"pretty", "html:reports/test-report","json:target/RunMRAtddTestRegistrationStepThreeDashboard-cucumber.json"  }, tags ={"@registrationStepThreeErrormessages"})
public class RunMRAtddTestRegistrationStepThreeDashboard {

}
