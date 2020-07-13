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
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDRegressionPlanDocAndResMemAuthProd_P1_ActPdpInd.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionPlanDocAndResMemAuthProd_P1_ActPdpInd")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" },
features = { "src/main/resources/feature/memberredesign/planDocumentsAndResources" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionPlanDocAndResMemAuthProd_P1_ActPdpInd.json" }, tags = { "@prod_planAndDocuments01","@prod_active_pdp_ind" })
public class RunMRATDDRegressionPlanDocAndResMemAuthProd_P1_ActPdpInd {
}
