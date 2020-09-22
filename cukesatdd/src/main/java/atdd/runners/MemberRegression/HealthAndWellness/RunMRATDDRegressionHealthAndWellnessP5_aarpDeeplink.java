package atdd.runners.MemberRegression.HealthAndWellness;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * 
 * @author schak38
 *
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDRegressionHealthAndWellnessP5_aarpDeeplink.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionHealthAndWellnessP5_aarpDeeplink")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/healthandwellness" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionHealthAndWellnessP5_aarpDeeplink.json" }, tags = { "@regressionMember","@healthAndWellness03_aarpDeeplink" })
public class RunMRATDDRegressionHealthAndWellnessP5_aarpDeeplink {

}
