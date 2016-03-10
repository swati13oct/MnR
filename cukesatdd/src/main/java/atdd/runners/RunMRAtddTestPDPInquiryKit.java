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
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.pdpenquirykit" }, 
		features = { "feature/pdp-enquirykit" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@pdpInquiryKit"})
public class RunMRAtddTestPDPInquiryKit {

}
