package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * 
 * @author schak38
 *
 */

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.ordermaterials.ulayer" }, 
		features = { "feature/ordermaterials/ulayer" }, 
		format = {
				"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@ValidateErrorMessage, @ValidateHeaderTabs"})

public class RunMRAtddTestOrderPlanMaterials {
	
	
}
