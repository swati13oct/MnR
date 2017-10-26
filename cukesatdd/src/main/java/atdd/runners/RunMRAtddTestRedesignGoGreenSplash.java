package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.redesign" }, 
		features = { "feature/re-design"}, 
		format = {"pretty", "html:reports/test-report","json:target/cucumber.json"}, tags ={"@goGreen"})
public class RunMRAtddTestRedesignGoGreenSplash {

}

