package atdd.runners.Prod;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for Email and Print plan details on VPP 
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionProdEmailAndPrintBlayer.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionProdEmailAndPrintBlayer")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = {
		"src/main/resources/feature/acquisition/vpp/VPP-EmailAndPrint-Common.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionProdEmailAndPrintBlayer.json" }, tags = { "@VppEmailandPrintProdSanity_UHC" })
public class RunMRATDDAcquisitionProdEmailAndPrintBlayer {
}
