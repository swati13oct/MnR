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
jsonReport = "target/cucumber-RunMRATDDRegressionPlanDocAndRes_P6_PreeffMapd_P6bof7.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionPlanDocAndRes_P6_PreeffMapd_P6bof7")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" },
features = { "src/main/resources/feature/memberredesign/planDocumentsAndResources" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionPlanDocAndRes_P6_PreeffMapd_P6bof7.json" }, tags = { "@planAndDocuments06_6bof7","@preeffective_mapd_6bof7" })
public class RunMRATDDRegressionPlanDocAndRes_P6_PreeffMapd_P6bof7 {
}
