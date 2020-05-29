package atdd.runners.MemberRegression;

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
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDRegressionMemberAuthCT.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionMemberAuthCTPROD")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/memberAuth/MemberAuthCTPROD.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionMemberAuthCTPROD.json" }, tags = { "@regressionMemberPROD" })
public class RunMRATDDRegressionMemberAuthCTPROD {

}
