package atdd.runners.acquisition.GlobalComponents;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionGlobalComponentsZipSubNavUHC.json",
detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, 
outputFolder = "target/RunMRATDDAcquisitionGlobalComponentsZipSubNavUHC")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition/globalComponents/GlobalComponents-AARP.feature" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionGlobalComponentsZipSubNavUHC.json" }, tags = { "@Global_Comps_ZipSubNav_UHC" })

public class RunMRATDDAcquisitionGlobalComponentsZipSubNavUHC {

}