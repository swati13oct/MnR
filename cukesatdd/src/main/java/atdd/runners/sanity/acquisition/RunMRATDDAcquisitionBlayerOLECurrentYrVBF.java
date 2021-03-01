package atdd.runners.sanity.acquisition;
import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;


/**
 * this file is to run test cases for RunMRATDDAcquisitionNewOLE
 */


@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionBlayerOLECurrentYrVBF.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionBlayerOLECurrentYrVBF")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition/ole/OLE-UHC.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionBlayerOLECurrentYrVBF.json" }, tags = { "@oleVppBlayerCurrentYrSmoke"})
public class RunMRATDDAcquisitionBlayerOLECurrentYrVBF {

}
