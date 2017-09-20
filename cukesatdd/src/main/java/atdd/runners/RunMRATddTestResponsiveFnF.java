package atdd.runners;
import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.responsive.bluelayer" }, 
		features = { "feature/responsive/Blayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumberprint5.json" }, tags ={"@US638058, @planCount, @planhighlights, @rightRail , @enrollPlan ,@suplementPlan , @enrollnowforsnpnotdisplayed , @Benefittable, @Benefittablema , @Learnmore"})
public class RunMRATddTestResponsiveFnF {
	
	

}