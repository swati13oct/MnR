/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author pperugu
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.formsandresources.ulayer" }, 
		features = { "feature/forms-and-resources/ulayer" }, 
		format = {
				"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@appeals,@udrugtrasition,@memberright,@seasonalflu,@termofuse,@medicaltherapy,@pharmacymail,@disenrollment"})
public class RunMRAtddTestFormsandResources {

}

