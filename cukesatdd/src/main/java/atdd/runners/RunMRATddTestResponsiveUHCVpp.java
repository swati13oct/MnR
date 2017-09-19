package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.responsive.bluelayer" }, 
		features = { "feature/responsive/Blayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumberprint5.json" }, tags ={"@planDetailUhc,@US698836,@US699362,@US689310,@US689260,@US702406,@US699059, @planCount, @planhighlights, @enrollPlan, @dceBlayerE2E, @dceBlayer, @planYearToggle, @rightRail, @planCount12	, @suplementPlan, @enrollnowforsnpnotdisplayed, @benefittable, @benefittablema, @learnmore, @US689021, @US689345, @US689475, @US689477, @connectormodel, @US689310, @US689260, @US702406, @US699059, @US699362, @US698836, @US689475"})

public class RunMRATddTestResponsiveUHCVpp {
	
	

}
