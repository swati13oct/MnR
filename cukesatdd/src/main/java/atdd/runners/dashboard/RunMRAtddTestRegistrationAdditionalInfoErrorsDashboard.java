/**
 * 
 */
package atdd.runners.dashboard;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author sarora29
 *
 */

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.dashboard.registration" }, features = { "feature/registrationMemberRedesign" }, format = { "pretty", "html:reports/test-report","json:target/RunJarvisCloaking-cucumber.json" }, tags = { "@registrationAdditionalInfoErrors" })

public class RunMRAtddTestRegistrationAdditionalInfoErrorsDashboard {

}
