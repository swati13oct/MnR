package atdd.runners.acquisition.campaignExternalLinkE2E;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionOLEBlayer
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionOLEUlayerCampaignExternalLink6Stage.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionOLEUlayerCampaignExternalLink6Stage")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" },monochrome=true, features = { "src/main/resources/feature/acquisition/CampaignExternalLinksE2E" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionOLEUlayerCampaignExternalLink6Stage.json" }, tags = { "@CampaignExternalLink_E2E_Scenario_6_Stage" })



public class RunMRATDDAcquisitionOLEUlayerCampaignExternalLink6Stage {

}
