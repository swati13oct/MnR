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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.healthandwellnessdropdown.ulayer" }, 
		features = { "feature/HealthAndWellness-DropDown" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@healthandwellnessULayerTest"})
public class RunMRCukesHealthAndWellnessDropdown {

}