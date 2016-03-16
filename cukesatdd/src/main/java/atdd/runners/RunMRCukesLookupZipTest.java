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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.lookupzipcode" }, 
		features = { "feature/lookup-zipcode" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@lookupZipcode"})
public class RunMRCukesLookupZipTest {

}
