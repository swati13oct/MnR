package atdd.runners.mobile.prod.sanity;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for
 * RunMRATDDAcquisitionDCEVisitorProfileMobileProd
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 0, screenShotSize = "", screenShotLocation = "/screenshots/", jsonReport = "target/cucumber-RunMRATDDAcquisitionDCEVisitorProfileMobileProdSanity.json", detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionDCEVisitorProfileMobileProdSanity")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile.acquisition" }, monochrome = true, features = {
		"src/main/resources/feature/mobile/acquisition/dceredesign" }, plugin = { "pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionDCEVisitorProfileMobileProdSanity.json" }, tags = { "@DCE_VisitorProfile", "@prodSanity" })

public class RunMRATDDAcquisitionDCEVisitorProfileMobileProdSanity {

}
