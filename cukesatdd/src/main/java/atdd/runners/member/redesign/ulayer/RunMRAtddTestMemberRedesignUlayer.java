package atdd.runners.member.redesign.ulayer;
import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.member.redesign.ulayer" }, 
		features = { "feature/member-redesign/ulayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@drug_cost_estimator1"})


public class RunMRAtddTestMemberRedesignUlayer {

}
