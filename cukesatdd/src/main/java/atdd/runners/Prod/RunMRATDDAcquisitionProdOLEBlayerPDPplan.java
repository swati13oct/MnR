package atdd.runners.Prod;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionOLEBlayer
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionProdOLEBlayerPDPplan.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionProdOLEBlayerPDPplan")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, monochrome = true, features = {
		"src/main/resources/feature/acquisition/ole/oleFuture/OLE-PlanDetails-PDP.feature" }, plugin = {
				"pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionProdOLEBlayerPDPplan.json" }, tags = {
						"@prodRegression_UHC" })



public class RunMRATDDAcquisitionProdOLEBlayerPDPplan {

}
