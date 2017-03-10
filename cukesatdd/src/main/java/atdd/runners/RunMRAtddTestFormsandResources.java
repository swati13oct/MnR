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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.formsandresources" }, 
		features = { "feature/forms-and-resources" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@formsandresourcesfnf"})
public class RunMRAtddTestFormsandResources {

}

