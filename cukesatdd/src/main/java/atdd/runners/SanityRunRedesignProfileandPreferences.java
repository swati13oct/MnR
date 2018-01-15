package atdd.runners;
import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.dashboard.profileandpreference" }, features = { "src/main/resources/feature/dashboard/profile-and-preference" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber.json" }, tags = { "@Sanity_ProfileAndPreference,@Sanity_GoGreen" })

public class SanityRunRedesignProfileandPreferences {

}
