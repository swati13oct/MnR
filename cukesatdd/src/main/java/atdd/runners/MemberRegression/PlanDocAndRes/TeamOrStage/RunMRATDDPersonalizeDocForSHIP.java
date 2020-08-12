package atdd.runners.MemberRegression.PlanDocAndRes.TeamOrStage;

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
jsonReport = "target/cucumber-RunMRATDDPersonalizeDocForSHIP.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDPersonalizeDocForSHIP")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" },
features = { "src/main/resources/feature/memberredesign/planDocumentsAndResources/PersonalizeDocumentForSHIP.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDPersonalizeDocForSHIP.json" }, tags = { "@CodeWarriors" })
public class RunMRATDDPersonalizeDocForSHIP {
}