package atdd.runners.sanity.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * 
 * @author schak38
 *
 */



@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionOLEULayerMedSupVBF.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionOLEULayerMedSupVBF")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, 
features = { "src/main/resources/feature/acquisition/oleMedSup" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionOLEULayerMedSupVBF.json" }, tags = { "@MedSuppOLEULayerSmoke" })
public class RunMRATDDAcquisitionOLEULayerMedSupVBF {

}
