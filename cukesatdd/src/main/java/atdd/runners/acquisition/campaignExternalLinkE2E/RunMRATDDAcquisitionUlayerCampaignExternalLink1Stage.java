package atdd.runners.acquisition.campaignExternalLinkE2E;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionUlayerCampaignExternalLink1Stage
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionUlayerCampaignExternalLink1Stage.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionUlayerCampaignExternalLink1Stage")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" },monochrome=true, features = { "src/main/resources/feature/acquisition/CampaignExternalLinksE2E" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionUlayerCampaignExternalLink1Stage.json" }, tags = { "@CampaignExternal_Scenario1_AARP_Stage" })
public class RunMRATDDAcquisitionUlayerCampaignExternalLink1Stage {

}
