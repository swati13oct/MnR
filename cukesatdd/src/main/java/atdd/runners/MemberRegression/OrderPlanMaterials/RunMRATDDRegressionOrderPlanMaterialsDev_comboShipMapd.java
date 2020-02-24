package atdd.runners.MemberRegression.OrderPlanMaterials;

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
jsonReport = "target/cucumber-RunMRATDDRegressionOrderPlanMaterialsDev_comboShipMapd.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDRegressionOrderPlanMaterialsDev_comboShipMapd")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" },
features = { "src/main/resources/feature/memberredesign/orderplanmaterials" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDRegressionOrderPlanMaterialsDev_comboShipMapd.json" }, tags = { "@devRegression","@combo_ship_mapd" })
public class RunMRATDDRegressionOrderPlanMaterialsDev_comboShipMapd {
//,@regression_06_06_18
}
