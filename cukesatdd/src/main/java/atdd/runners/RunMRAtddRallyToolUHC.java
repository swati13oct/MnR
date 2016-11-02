package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.rallytool.blayer.member" }, 
		features = { "feature/rallyToolMember/blayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@RallytoolUHCMember"})
public class RunMRAtddRallyToolUHC {
	
}
