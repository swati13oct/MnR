package atdd.runners.sanity.AEP.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionProviderSearchHomeNextYrVBF
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionProviderSearchHomeNextYrVBF.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionProviderSearchHomeNextYrVBF")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition/providersearch" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionProviderSearchHomeNextYrVBF.json" }, tags = { "@ProviderSearchFromHomePageNextYrBlayerSmoke,@ProviderSearchFromHomePageNextYrUlayerSmoke" })
public class RunMRATDDAcquisitionProviderSearchHomeNextYrVBF {

}
