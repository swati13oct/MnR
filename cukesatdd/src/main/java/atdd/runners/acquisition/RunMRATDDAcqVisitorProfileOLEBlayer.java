package atdd.runners.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcqVisitorProfileOLEBlayer
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcqVisitorProfileOLEBlayer.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqVisitorProfileOLEBlayer")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition/visitorProfile" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqVisitorProfileOLEBlayer.json" }, tags = { "@vpOLE" })
public class RunMRATDDAcqVisitorProfileOLEBlayer { 
 
}
