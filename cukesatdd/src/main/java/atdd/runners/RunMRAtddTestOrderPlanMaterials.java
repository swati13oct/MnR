package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * 
 * @author schak38
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.ordermaterials.bluelayer" }, 
		features = { "feature/ordermaterials/bluelayer" }, 
		format = {
				"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@radiobuttonmassup,@radiobuttonpdpgroup,@radiobuttonmaindiv,@radiobuttonmapdindi,@radiobuttonvalidationmaandssup,@radiobuttonvalidationpdpgrp,@radiobuttonvalidationmapdandmaindi,@US627227,@radiobuttonvalidationmapdandssrdgrp,@radiobuttonmapdssrdgroup"})

public class RunMRAtddTestOrderPlanMaterials {
	
	
}
