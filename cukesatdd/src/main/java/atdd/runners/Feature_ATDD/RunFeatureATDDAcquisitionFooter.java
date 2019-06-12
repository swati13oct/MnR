package atdd.runners.Feature_ATDD;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionFooter
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunFeatureATDDAcquisitionFooter.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunFeatureATDDAcquisitionFooter")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition/footer" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunFeatureATDDAcquisitionFooter.json" }, tags = { "@globalfooterULayerSmoke,@globalfooterBLayerSmoke" })
public class RunFeatureATDDAcquisitionFooter {

}
