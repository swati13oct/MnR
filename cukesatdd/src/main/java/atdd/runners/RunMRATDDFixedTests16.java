package atdd.runners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * 
 * @author schak38
 *
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDFixedTests16.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDFixedTests16")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.fixedtestcases" }, features = { "src/main/resources/feature/fixedtestcases" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDFixedTests16.json" }, tags = { "@ssllabs" })
public class RunMRATDDFixedTests16 {

}
