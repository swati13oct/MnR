package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * 
 * @author sdwaraka
 * Runner file for testing Error Messages Features in My Profile and Preferences page in Redesign site.
 *
 */

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.profandpref.redesign" }, 
		features = { "feature/myprofile-preferences/redesign/" }, 
		format = {
				"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@MyProfileErrorMessages"})

public class RunMRAtddTestMyProfPrefErrorMsgs {
	//@MyProfileErrorMessages,@TempAltAddressErrorMessagesAARP
	
}
