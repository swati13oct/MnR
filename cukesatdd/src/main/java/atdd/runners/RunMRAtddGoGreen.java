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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.gogreen" }, 
		features = { "feature/go-green" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@goGreen"})
public class RunMRAtddGoGreen {

}
