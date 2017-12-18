
package atdd.runners.dashboard;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.dashboard.newsignIn.aarplayer" }, 
features = { "feature/dashboard/newSignInPage/aarplayer" }, 
format = {
		"pretty", "html:reports/test-report" }, tags ={"@signInErrorMessages1,@signInErrorMessages2,@signInErrorMessages3"})
public class RunMRAtddTestNewSignInPage {

}

