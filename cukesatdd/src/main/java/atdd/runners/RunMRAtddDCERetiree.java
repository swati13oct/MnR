/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author eb
 *
 */

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.dceretiree" }, 
		features = { "feature/druglookup/uhcretiree" }, 
		format = {"pretty", "html:reports/test-report" }, tags ={"@druglookupUhcRetiree"})
public class RunMRAtddDCERetiree {

}