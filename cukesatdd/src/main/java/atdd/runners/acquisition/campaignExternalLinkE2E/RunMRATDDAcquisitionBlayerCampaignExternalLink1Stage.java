package atdd.runners.acquisition.campaignExternalLinkE2E;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for
 * RunMRATDDAcquisitionBlayerCampaignExternalLink1Stage
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount = 1, screenShotSize = "", screenShotLocation = "/screenshots/", jsonReport = "target/cucumber-RunMRATDDAcquisitionBlayerCampaignExternalLink1Stage.json", detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionBlayerCampaignExternalLink1Stage")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, monochrome = true, features = {
		"src/main/resources/feature/acquisition/CampaignExternalLinksE2E" }, plugin = { "pretty",
				"html:reports/test-report",
				"json:target/cucumber-RunMRATDDAcquisitionBlayerCampaignExternalLink1Stage.json" }, tags = {
						"@CampaignExternal_Scenario1_UHC_Stage" })
public class RunMRATDDAcquisitionBlayerCampaignExternalLink1Stage {

}
