package atdd.runners.member.dce.bluelayer;
import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.dashboard.drugcostestimator.bluelayer" }, 
		features = { "feature/dashboard/drugcostestimator/April_2017_Release" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@drug_cost_estimator1,@drug_cost_estimator2,@drug_cost_estimator4,  @drug_cost_estimator_with_mail_service"})

public class RunMRAtddTestMemberDCEBlayer {

}
