package atdd.runners.tfn;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for TFN AARP
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionTFNUlayer.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionTFNUlayer")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, monochrome = true, features = { "src/main/resources/feature/acquisition/tfn" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionTFNUlayer.json" }, tags = {"@tfn_aarp "})

public class RunMRATDDAcquisitionTFNUlayer {

}
