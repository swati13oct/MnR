package atdd.runners;
 

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.rallytool.ulayer.member" }, 
		features = { "feature/rallyToolMember/uLayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@RallytoolAARPMember"})

public class RunMRAtddRallyToolAarpMember {

}
