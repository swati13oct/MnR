package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.responsive.bluelayer" }, 
		features = { "feature/responsive/Blayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@sprint2", "@planYearToggle", "@rightRail", "@planCount12", "@suplementPlan", "@addtocomparenotdisplayed", "@enrollnowforsnpnotdisplayed",  "@benefittable", "@benefittablema", "@learnmore", "@rightRail", "@US699059", "@connectormodel"})

public class RunMRATddTestResponsiveUHCVpp {
	

}
