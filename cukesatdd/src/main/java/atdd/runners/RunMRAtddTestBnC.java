/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author pjaising
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.benefitsandcoverage.bluelayer" }, 
		features = { "feature/plan-benefits-and-coverage/bluelayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@contactus,@PCPcontactus,@PCPaboutus,@aboutus"})
public class RunMRAtddTestBnC {

}
