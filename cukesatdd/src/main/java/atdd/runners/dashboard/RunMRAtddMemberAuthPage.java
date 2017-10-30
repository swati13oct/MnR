/**
 * 
 */
package atdd.runners.dashboard;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.dashboard.memberAuth" }, 
		features = { "feature/dashboard/memberAuth" }, 
		format = {
		"pretty", "html:reports/test-report","RunMRAtddMemberAuthPage-json:target/cucumber.json" }, tags ={"@memberAuth"})
public class RunMRAtddMemberAuthPage {

}

