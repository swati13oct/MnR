package atdd.runners.mobile.acquisition.clickToCall;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * this file is to run test cases for RunMRATDDAcqClickToCallUHCEnroll
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
        retryCount=0,
        screenShotSize="", 
        screenShotLocation="/screenshots/",
        jsonReport = "target/cucumber-RunMRATDDAcqClickToCallUHCEnroll.json",
        detailedReport = true,
        detailedAggregatedReport = true, 
        overviewReport = true, 
        toPDF = true, 
        outputFolder = "target/RunMRATDDAcqClickToCallUHCEnroll")
@CucumberOptions(
        glue = { "atdd.framework", "acceptancetests.mobile.acquisition" },
        monochrome=true, 
        features = { "src/main/resources/feature/mobile/acquisition/callChat" }, 
        plugin = { "pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqClickToCallUHCEnroll.json" }, 
        tags = { "@UHC_ShopPlan_Enroll" })


public class RunMRATDDAcqClickToCallUHCEnroll {
}
