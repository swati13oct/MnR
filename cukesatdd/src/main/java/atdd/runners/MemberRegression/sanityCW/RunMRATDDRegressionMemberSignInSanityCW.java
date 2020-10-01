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
jsonReport = "target/cucumber-RunMRATDDRegressionMemberSignInSanityCW.json", detailedReport = true, detailedAggregatedReport = true, 
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionMemberSignInSanityCW")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, monochrome = true,
features = { "src/main/resources/feature/memberredesign/cwSanity/SignInSanityCW.feature" }, plugin = {
		"pretty", "html:reports/test-report","json:target/cucumber-RunMRATDDRegressionMemberSignInSanityCW.json" }, tags = { "@regressionMember" })
public class RunMRATDDRegressionMemberSignInSanityCW{

}