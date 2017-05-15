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
				"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@medicationtherapy,@coverageappealspdp,@coverageappealsmapd,@preferedmailbenefit,@lowertierdruglearnmore"})
public class RunMRAtddTestFormsandResources {

}

