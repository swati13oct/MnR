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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.dashboard.claims.bluelayer" }, 
features = { "feature/dashboard/claims/bluelayer" }, 
format = {
		"pretty", "html:reports/test-report" }, tags ={"@claimsEob"})
public class RunMRAtddTestClaims {

}

