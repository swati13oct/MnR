package atdd.runners.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for Retiree Provider Search
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDUHCRetireeProviderSearchVBF.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDUHCRetireeProviderSearchVBF")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition.retiree" }, features = { "src/main/resources/feature/acquisition/retiree" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDUHCRetireeProviderSearchVBF.json" }, tags = { "@retireeProviderSearch_Smoke" })
public class RunMRATDDUHCRetireeProviderSearchVBF {

}

