package atdd.runners.MemberRegression.OrderPlanMaterials;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

/**
 *
 * @author schak38
 *
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
        jsonReport = "target/cucumber-RunMRATDDSanityRegressionOrderPlanMaterialsMemAuthProdP2.json",detailedReport = true, detailedAggregatedReport = true,
        overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDSanityRegressionOrderPlanMaterialsMemAuthProdP2")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" },
        features = { "src/main/resources/feature/memberredesign/orderplanmaterials" }, plugin = {
        "pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDSanityRegressionOrderPlanMaterialsMemAuthProdP2.json" }, tags = { "@prodSanity_MEDSUPP_order"})
public class RunMRATDDSanityRegressionOrderPlanMaterialsMemAuthProdP2 {
//,@regression_06_06_18
}
