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
@ExtendedCucumberOptions(retryCount=2,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDFixedTests5.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDFixedTests5")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisitionvbf" }, features = { "src/main/resources/feature/acquisitionvbf" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDFixedTests5.json" }, tags = { "@memberpharmacylocatorAARP,@druglookup,@druglookupUms" })
public class RunMRATDDFixedTests5 {

}
