package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author akapoo18
 *
 */



@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework", "acceptancetests.ProfileandPreferencesredesign.ulayer" }, features = {
		"feature/myprofile-preferences/ulayer" }, format = { "pretty", "html:reports/test-report",
				"json:target/cucumber.json" }, tags = {"@CommunicationPreferences"})
public class RunMRAtddTestUlayerProfileandPreferences
{
}