/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.dashboard.claims.aarplayer" }, 
features = { "feature/dashboard/claims/aarplayer" }, 
format = {
		"pretty", "html:reports/test-report", "json:target/cucumber.json" }, tags ={"@claimsSummarySHIP"})
public class RunMRAtddTestClaimsRedesign {

}