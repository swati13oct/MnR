package atdd.runners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionDCE
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAprilRelease.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAprilRelease")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisitionvbf" }, features = { "src/main/resources/feature/acquisitionvbf" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAprilRelease.json" }, tags = { "@aprilRelease2018" })
public class RunMRATDDAprilRelease { 
 
}
