package atdd.runners;
import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;


/**
 * this file is to run test cases for RunMRATDDAcquisitionNewOLE
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionNewOLEVBF.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionNewOLEVBF")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisitionvbf"},features={"src/main/resources/feature/acquisitionvbf.ole"},plugin = {"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionNewOLEVBF.json"}, tags = {"@OLE_Ulayer,@OLE_UHC"})
public class RunMRATDDAcquisitionNewOLEVBF {

}
