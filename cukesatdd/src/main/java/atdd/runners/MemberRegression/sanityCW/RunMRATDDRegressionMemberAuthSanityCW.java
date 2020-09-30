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
jsonReport = "target/cucumber-RunMRATDDRegressionMemberAuthSanityCW.json", detailedReport = true, detailedAggregatedReport = true, 
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionMemberAuthSanityCW")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, monochrome = true,
features = { "src/main/resources/feature/memberredesign/cw5minTurnAround/memberAuthSanityCW.feature" }, plugin = {
		"pretty", "html:reports/test-report","json:target/cucumber-RunMRATDDRegressionMemberAuthSanityCW.json" }, tags = { "@regressionMember" })
public class RunMRATDDRegressionMemberAuthSanityCW {

}
