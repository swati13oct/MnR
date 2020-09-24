package atdd.runners.mobile.acquisition.clickToCall;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcqClickToCallAARPMedEd
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
        retryCount=0,
        screenShotSize="", 
        screenShotLocation="/screenshots/",
        jsonReport = "target/cucumber-RunMRATDDAcqClickToCallAARPMedEd.json",
        detailedReport = true,
        detailedAggregatedReport = true, 
        overviewReport = true, 
        toPDF = true, 
        outputFolder = "target/RunMRATDDAcqClickToCallAARPMedEd")
@CucumberOptions(
        glue = { "atdd.framework", "acceptancetests.mobile.acquisition" },
        monochrome=true, 
        features = { "src/main/resources/feature/mobile/acquisition/callChat" }, 
        plugin = { "pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqClickToCallAARPMedEd.json" }, 
        tags = { "@AARP_MedEd" })


public class RunMRATDDAcqClickToCallAARPMedEd {
}
