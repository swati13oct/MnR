package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.responsive.bluelayer" }, 
		features = { "feature/responsive/Blayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@addtocomparenotdisplayed,@enrollnowforsnpnotdisplayed,@benefittable,@benefittablema,@learnmore"})

public class RunMRATddTestResponsiveVPP {

}