package atdd.runners.mobile.prod.sanity;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for
 * RunMRATDDAcquisitionDCEDrugSummaryMobile
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 0, screenShotSize = "", screenShotLocation = "/screenshots/", 
jsonReport = "target/cucumber-RunMRATDDAcquisitionDCEDrugSummaryMobileProdSanity.json", detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionDCEDrugSummaryMobileProdSanity")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" }, monochrome = true, features = {
		"src/main/resources/feature/mobile/acquisition/dceredesign" }, plugin = { "pretty", "html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionDCEDrugSummaryMobileProdSanity.json" }, tags = {
						"@dce_redesign_Drug_summary_AARP", "@F426576","@OnlyProd" }, dryRun=false)

public class RunMRATDDAcquisitionDCEDrugSummaryMobileProdSanity {

}
