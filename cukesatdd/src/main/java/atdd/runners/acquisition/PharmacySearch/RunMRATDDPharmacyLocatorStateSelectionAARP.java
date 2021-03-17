package atdd.runners.acquisition.PharmacySearch;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDPharmacyLocatorStateSelectionAARP
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDPharmacyLocatorStateSelectionAARP.json",
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDPharmacyLocatorStateSelectionAARP")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition/pharmacylocator/PharmacySearch-Common.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDPharmacyLocatorStateSelectionAARP.json" }, tags = { "@PharmacyLocatorCommonAARP07"})//"@pharmacyLocatorRegression","@pharmacylocatorulayer07,@pharmacylocatorulayer08" })
public class RunMRATDDPharmacyLocatorStateSelectionAARP{ 
 
}
