package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * 
 * @author sdwaraka
 *
 */

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.ordermaterials.bluelayer" }, 
		features = { "feature/ordermaterials/bluelayer" }, 
		format = {
				"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@PDPgroupComboValidateHeaderandTabs"})

public class RunMRAtddTestOrderPlanMaterialsBLayer {
	
	
}
