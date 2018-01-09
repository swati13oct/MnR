package atdd.runners.member.redesign.healthnwellness;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
*@author bpilli10
*/
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.member.redesign.healthandwellness" }, 
		features = { "feature/member-redesign/health-and-wellness" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@member_redesign_H&W"})



public class RunMRAtddTestMemberRedesignHealthnWellness {

}
