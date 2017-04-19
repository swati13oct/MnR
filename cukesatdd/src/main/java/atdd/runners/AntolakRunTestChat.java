/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author jantolak
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.benefitsandcoverage" }, 
		features = { "feature/debug" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@jantolakTest"})
public class AntolakRunTestChat {

}