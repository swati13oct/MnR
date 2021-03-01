package atdd.runners.mobile.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionSamChatCallULayerTablet
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionSamChatCallULayerTablet.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionSamChatCallULayerTablet")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile.acquisition" },monochrome=true, features = { "src/main/resources/feature/mobile/acquisition/callChat" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionSamChatCallULayerTablet.json" }, tags = { "@acq_CALLCHAT_AARP_Tablet" })


public class RunMRATDDAcquisitionSamChatCallULayerTablet {

}
