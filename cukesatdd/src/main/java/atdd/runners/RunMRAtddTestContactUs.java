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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.contactus" }, 
		features = { "feature/contactus" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@contactUsTest"})
public class RunMRAtddTestContactUs {

}
