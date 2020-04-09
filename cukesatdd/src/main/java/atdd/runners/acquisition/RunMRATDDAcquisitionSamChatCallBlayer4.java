package atdd.runners.acquisition;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionSamChatCallBlayer4
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionSamChatCallBlayer4.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionSamChatCallBlayer4")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" },monochrome=true, features = { "src/main/resources/feature/acquisition" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionSamChatCallBlayer4.json" }, tags = { "@footerUHC_3,@footerUHC_2,@footerUHC_1" })



public class RunMRATDDAcquisitionSamChatCallBlayer4 {

}
