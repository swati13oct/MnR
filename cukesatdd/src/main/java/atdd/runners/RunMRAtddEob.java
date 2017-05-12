/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**	
 * @author pagarwa5
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.eob" }, 
		features = { "feature/explanation-of-benefits/Ulayer" }, 
		format = { 
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@eobStatments"})
public class RunMRAtddEob {

}
