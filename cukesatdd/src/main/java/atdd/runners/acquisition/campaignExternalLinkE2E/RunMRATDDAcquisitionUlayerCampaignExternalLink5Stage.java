package atdd.runners.acquisition.campaignExternalLinkE2E;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * Run test cases for Campaign External Links - E2E Scenario 5_morganstanley
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 1, screenShotSize = "", screenShotLocation = "/screenshots/", jsonReport = "target/cucumber-RunMRATDDAcquisitionUlayerCampaignExternalLink5Stage.json", detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionUlayerCampaignExternalLink5Stage")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, monochrome = true, features = {
		"src/main/resources/feature/acquisition/CampaignExternalLinksE2E" }, plugin = { "pretty",
				"html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionUlayerCampaignExternalLink5Stage.json" }, tags = {
						"@Scenario5_AARP_Stage" })
public class RunMRATDDAcquisitionUlayerCampaignExternalLink5Stage {

}
