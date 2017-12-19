package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * 
 * @author sdwaraka
 * Runner file for testing Features in My Profile Page and Preferences page in Redesign site.
 *
 */

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.profandpref.redesign" }, 
		features = { "feature/myprofile-preferences/redesign/" }, 
		format = {
				"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@ValidateSHIPsingleTab,@ValidatePHIPtab,@ValidateComboTabsUHCPlans"})

public class RunMRAtddTestMyProfilePrefs {
	
	//@MyProfilePreferencePage,@ValidateSHIPsingleTab,@ValidatePHIPtab,@ValidateComboTabsAARPPlans,@ValidateComboTabsUHCPlans
	
	//@MyProfileErrorMessages,@EditEmailErrorMessagesAARP,@TempAltAddressErrorMessagesAARP,@EditEmailErrorMessagesUMS, @TempAltAddressErrorMessagesUMS
	//@blankpassworderrormessage,@phoneerrormessage,@diffpassworderrormessage,@incorrectpasswordformaterrormessage
}
