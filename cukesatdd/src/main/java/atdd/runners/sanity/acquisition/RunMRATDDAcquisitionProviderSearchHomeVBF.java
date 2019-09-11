package atdd.runners.sanity.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionProviderSearchHomeVBF
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionProviderSearchHomeVBF.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionProviderSearchHomeVBF")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition/providersearch" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionProviderSearchHomeVBF.json" }, tags = { "@ProviderSearchFromHomePageUlayerSmoke,@ProviderSearchFromHomePageBlayerSmoke" })
public class RunMRATDDAcquisitionProviderSearchHomeVBF {

}
