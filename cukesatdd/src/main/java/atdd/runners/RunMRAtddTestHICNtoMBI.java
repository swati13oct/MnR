package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * 
 * @author sdwaraka
 *
 */

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.registration.Redesign" }, 
		features = { "feature/HICN-MBI" }, 
		format = {
				"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@TeamPredators,@ordermaterials"})


public class RunMRAtddTestHICNtoMBI {
	
	//,@TeamPredators,@ordermaterials
	//acceptancetests/registration.Redesign
}
