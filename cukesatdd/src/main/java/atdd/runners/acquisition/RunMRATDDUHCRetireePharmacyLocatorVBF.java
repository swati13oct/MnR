package atdd.runners.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for Retiree Pharmacy Locator
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDUHCRetireePharmacyLocatorVBF.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDUHCRetireePharmacyLocatorVBF")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition.retiree" }, features = { "src/main/resources/feature/acquisition/retiree" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDUHCRetireePharmacyLocatorVBF.json" }, tags = { "@retireePharmacylocator_Smoke" })
public class RunMRATDDUHCRetireePharmacyLocatorVBF {

}

