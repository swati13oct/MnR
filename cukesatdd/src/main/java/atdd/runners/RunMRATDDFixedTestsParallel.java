package atdd.runners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.github.mkolisnyk.cucumber.runner.ExtendedParallelCucumber;

import cucumber.api.CucumberOptions;

/**
 * 
 * @author schak38
 *
 */

@RunWith(ExtendedParallelCucumber.class)
@ExtendedCucumberOptions(threadsCount=15, screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDFixedTestsParallel.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.fixedtestcases" }, features = { "src/main/resources/feature/fixedtestcases" }, plugin = {
		"html:reports/test-report", "json:target/cucumber-RunMRATDDFixedTestsParallel.json" }, tags = { "@pharmacylocatorUHC" })
public class RunMRATDDFixedTestsParallel {

}
