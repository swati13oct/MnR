package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**	
 * 
 * @author schak38
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.profandpref" }, 
		features = { "feature/myprofile-preferences" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@profileandpreferences"})

public class RunMRAtddTestProfAndPref {
	
	 	
}
