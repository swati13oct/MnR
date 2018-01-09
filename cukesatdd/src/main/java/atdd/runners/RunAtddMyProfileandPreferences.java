/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**	
 * @author gkarthee
 *
 */
@RunWith(Cucumber.class)	
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.redesign" }, 
		features = { "feature/re-design" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@profilepreferences"})
public class RunAtddMyProfileandPreferences {
	
}
