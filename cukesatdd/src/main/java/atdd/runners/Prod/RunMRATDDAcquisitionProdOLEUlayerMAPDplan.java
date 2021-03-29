package atdd.runners.Prod;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionOLEBlayer
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionProdOLEUlayerMAPDplan.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionProdOLEUlayerMAPDplan")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" },monochrome=true, features = { "src/main/resources/feature/acquisition/ole/oleFuture/OLE-PlanSummary-MAPD.feature" }, plugin = {
				"pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionProdOLEUlayerMAPDplan.json" }, tags = {
						"@prodRegression_AARP" })



public class RunMRATDDAcquisitionProdOLEUlayerMAPDplan {

}
