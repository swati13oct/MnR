package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * 
 * @author naggarw2
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.rallytool.bluelayer.acquisition" }, 
		features = { "feature/uhc-retiree" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@RallytoolUHCSAcquisition"})

public class RunMRAtddRallytoolUhcs {
	
	
	
	
}
