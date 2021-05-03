package atdd.runners.acquisition.ole;


import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionOLEBlayer
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionOLEBlayerPlanBenefits.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionOLEBlayerPlanBenefits")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" },monochrome=true, features = { "src/main/resources/feature/acquisition/ole" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionOLEBlayerPlanBenefits.json" }, tags = { "@OLE_PlanBenefits_AARP" })



public class RunMRATDDAcquisitionOLEBlayerPlanBenefits {

}
