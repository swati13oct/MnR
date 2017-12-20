package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * 
 * @author sdwaraka
 * Runner file for testing Error Messages and Combo Tabs Features in My Profile Page and Preferences page in Redesign site.
 *
 */

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.gogreen.redesign" }, 
		features = { "feature/go-green/redesign/" }, 
		format = {
				"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@ValidateGoGreenPageSHIPsingleTab,@ValidateGoGreenPagePHIPtab,@ValidateGoGreenPageComboTabsUHCPlans"})

public class RunMRAtddTestGoGreenPage {
	
	//@GoGreenPage,@ValidateGoGreenPageSHIPsingleTab,@ValidateGoGreenPagePHIPtab,@ValidateGoGreenPageComboTabsAARPPlans,@ValidateGoGreenPageComboTabsUHCPlans
	
}
