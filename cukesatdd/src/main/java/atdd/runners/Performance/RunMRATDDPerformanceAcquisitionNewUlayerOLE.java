package atdd.runners.Performance;
import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;


/**
 * this file is to run test cases for RunMRATDDAcquisitionNewOLE
 */


@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDPerformanceAcquisitionNewUlayerOLE.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDPerformanceAcquisitionNewUlayerOLE")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition/ole" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDPerformanceAcquisitionNewUlayerOLE.json" }, tags = { "@oleVppUlayerSmoke" })
public class RunMRATDDPerformanceAcquisitionNewUlayerOLE {

}
