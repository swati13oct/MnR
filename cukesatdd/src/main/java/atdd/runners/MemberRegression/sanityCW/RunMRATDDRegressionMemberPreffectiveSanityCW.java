package atdd.runners.MemberRegression.sanityCW;

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
@ExtendedCucumberOptions(retryCount = 0, screenShotSize = "", screenShotLocation = "/screenshots/", 
jsonReport = "target/cucumber-RunMRATDDRegressionMemberPreffectiveSanityCW.json", detailedReport = true, detailedAggregatedReport = true, 
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionMemberPreffectiveSanityCW")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, monochrome = true,
features = { "src/main/resources/feature/memberredesign/cw5minTurnAround/pre-effectiveSanityCW.feature" }, plugin = {
		"pretty", "html:reports/test-report","json:target/cucumber-RunMRATDDRegressionMemberPreffectiveSanityCW.json" }, tags = { "@regressionMember" })
public class RunMRATDDRegressionMemberPreffectiveSanityCW{

}
