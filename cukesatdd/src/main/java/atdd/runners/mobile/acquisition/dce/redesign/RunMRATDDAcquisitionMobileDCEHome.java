package atdd.runners.mobile.acquisition.dce.redesign;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionMobileDCEHome
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionMobileDCEHome.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionMobileDCEHome")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile.acquisition" },monochrome=true, features = { "src/main/resources/feature/mobile/acquisition/dceredesign" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionMobileDCEHome.json" }, tags = { "@dce_redesign_home" })


public class RunMRATDDAcquisitionMobileDCEHome {

}
