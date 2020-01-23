package atdd.runners.Prod;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for Email and Print plan details on VPP 
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionProdEmailAndPrintUlayer.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionProdEmailAndPrintUlayer")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition.vpp" }, features = { "src/main/resources/feature/acquisition/vpp/VPP-AARP-EmailAndPrint.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionProdEmailAndPrintUlayer.json" }, tags = { "@prodRegression" })
public class RunMRATDDAcquisitionProdEmailAndPrintUlayer {
}
