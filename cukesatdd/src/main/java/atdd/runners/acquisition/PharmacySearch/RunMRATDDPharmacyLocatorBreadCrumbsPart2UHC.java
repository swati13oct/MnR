package atdd.runners.acquisition.PharmacySearch;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDPharmacyLocatorBreadCrumbsPart2UHC
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDPharmacyLocatorBreadCrumbsPart2UHC.json",
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDPharmacyLocatorBreadCrumbsPart2UHC")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition/pharmacylocator" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDPharmacyLocatorBreadCrumbsPart2UHC.json" }, tags = { "@breadcrumbPharmacySearch_UHC_Part2"})

public class RunMRATDDPharmacyLocatorBreadCrumbsPart2UHC {

}
