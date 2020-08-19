package atdd.runners.MemberRegression.PlanDocAndRes.OfflineProdOrOnlineProd;

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
jsonReport = "target/cucumber-RunMRATDDRegressionPlanDocAndResMemAuth_P6_ActPcp_P6aof7.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionPlanDocAndResMemAuth_P6_ActPcp_P6aof7")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" },
features = { "src/main/resources/feature/memberredesign/planDocumentsAndResources" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionPlanDocAndResMemAuth_P6_ActPcp_P6aof7.json" }, tags = { "@prod_planAndDocuments06_6aof7","@prod_active_pcp_6aof7" })
public class RunMRATDDRegressionPlanDocAndResMemAuth_P6_ActPcp_P6aof7 {
}
