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
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionMemberAuthCTTeamH")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/memberAuth/MemberAuthCTTeamH.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionMemberAuthCTTeamH.json" }, tags = { "@regressionMember" })
public class RunMRATDDRegressionMemberAuthCTTeamH {

}
