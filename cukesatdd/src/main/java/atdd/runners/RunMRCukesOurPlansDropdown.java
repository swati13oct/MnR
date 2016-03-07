/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author naggarw2
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.ourplansdropdown.ulayer" }, 
		features = { "feature/ourplans-dropdown" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@ourplans"})
public class RunMRCukesOurPlansDropdown {

}