package atdd.runners.MemberRegression.PlanDocAndRes;

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
jsonReport = "target/cucumber-RunMRATDDRegressionPlanDocAndRes_P2_TermMaMapd.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionPlanDocAndRes_P2_TermMaMapd")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" },
features = { "src/main/resources/feature/memberredesign/planDocumentsAndResources" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionPlanDocAndRes_P2_TermMaMapd.json" }, tags = { "@planAndDocuments02","@terminated_ma_mapd" })
public class RunMRATDDRegressionPlanDocAndRes_P2_TermMaMapd {
}
