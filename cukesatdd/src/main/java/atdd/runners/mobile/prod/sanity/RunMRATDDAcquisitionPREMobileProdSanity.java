package atdd.runners.mobile.prod.sanity;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for
 * RunMRATDDAcquisitionPREMobileProdSanity
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 0, screenShotSize = "", screenShotLocation = "/screenshots/", 
jsonReport = "target/cucumber-RunMRATDDAcquisitionPREMobileProdSanity.json", detailedReport = true, 
detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionPREMobileProdSanity")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" }, monochrome = true, features = {
		"src/main/resources/feature/mobile/acquisition/planrecommendationengine" }, plugin = { "pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionPREMobileProdSanity.json" }, tags = {
						"@ios"}, dryRun=false)

public class RunMRATDDAcquisitionPREMobileProdSanity {

}
