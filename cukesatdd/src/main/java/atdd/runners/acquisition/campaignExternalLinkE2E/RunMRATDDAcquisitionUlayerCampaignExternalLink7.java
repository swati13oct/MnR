package atdd.runners.acquisition.campaignExternalLinkE2E;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * Run test cases for Campaign External Links - E2E Scenario 7 medicare-prescription-drug-plan-52
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 1, screenShotSize = "", screenShotLocation = "/screenshots/", jsonReport = "target/cucumber-RunMRATDDAcquisitionUlayerCampaignExternalLink7.json", detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionUlayerCampaignExternalLink7")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, monochrome = true, features = {
		"src/main/resources/feature/acquisition/CampaignExternalLinksE2E" }, plugin = { "pretty",
				"html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionUlayerCampaignExternalLink7.json" }, tags = {
						"@Scenario7_AARP" })

public class RunMRATDDAcquisitionUlayerCampaignExternalLink7 {

}
