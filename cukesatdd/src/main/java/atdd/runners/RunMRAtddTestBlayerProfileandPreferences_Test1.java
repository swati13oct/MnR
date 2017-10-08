package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;
import atdd.runners.RunAtddCustomerRunner;

/**
 * @author akapoo18
 *
 */

@RunWith(RunAtddCustomerRunner.class)

@Cucumber.Options(glue = { "atdd.framework", "acceptancetests.ProfileandPreferencesredesign.bluelayer","ExecutionListener" }, features = {
		"feature/myprofile-preferences/bluelayer" }, format = { "pretty", "html:reports/test-report",
				"json:target/cucumber.json" }, tags = { "@Temporaryaddress"})
public class RunMRAtddTestBlayerProfileandPreferences_Test1
{
}