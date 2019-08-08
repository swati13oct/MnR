package atdd.runners.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionAEP
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionAepVppUHC.json",detailedReport = true, 
detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionAepVppUHC")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionAepVppUHC.json" }, tags = { "@Bluelayer10_01,@Bluelayer10_15" })
public class RunMRATDDAcquisitionAepVppUHC {

}
