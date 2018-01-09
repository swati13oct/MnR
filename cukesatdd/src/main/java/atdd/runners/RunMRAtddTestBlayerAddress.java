package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author akapoo18
 *
 */

@RunWith(Cucumber.class)

@Cucumber.Options(glue = { "atdd.framework", "acceptancetests.ProfileandPreferencesredesign.bluelayer" }, features = {
		"feature/myprofile-preferences/bluelayer" }, format = { "pretty", "html:reports/test-report",
				"json:target/cucumber.json" }, tags = {"@ValidateEmail,@EmailEdit1,@EmailEdit2,@PermanentAddress"})
public class RunMRAtddTestBlayerAddress
{
}