/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author saduri
 *
 */

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.headernavigation.ulayer" }, 
		features = { "feature/medicare-education" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@medicareEducationUlayer"})
public class RunMRCukesNavigationMedicareEducation {

}
