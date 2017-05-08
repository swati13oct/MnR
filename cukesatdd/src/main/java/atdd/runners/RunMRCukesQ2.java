package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * 
 * @author naggarw2
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.UHCRetiree","acceptancetests.rallytool" }, 
		features = { "feature/uhc-retiree","feature/rallytoolacquisition"}, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@Q2"})

public class RunMRCukesQ2 {
	
	
	
	
}