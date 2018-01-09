package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * 
 * @author nmishra7
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.rallytool.ulayer.acquisition" }, 
		features = { "feature/rallytoolacquisition/ulayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@RallytoolAARPAcquisition"})

public class RunMRAtddRallytoolAarp {
	
	
	
	
}
