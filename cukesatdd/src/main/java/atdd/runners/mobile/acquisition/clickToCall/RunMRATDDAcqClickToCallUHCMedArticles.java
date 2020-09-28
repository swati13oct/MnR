package atdd.runners.mobile.acquisition.clickToCall;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * this file is to run test cases for RunMRATDDAcqClickToCallUHCMedArticles
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
        retryCount=0,
        screenShotSize="", 
        screenShotLocation="/screenshots/",
        jsonReport = "target/cucumber-RunMRATDDAcqClickToCallUHCMedArticles.json",
        detailedReport = true,
        detailedAggregatedReport = true, 
        overviewReport = true, 
        toPDF = true, 
        outputFolder = "target/RunMRATDDAcqClickToCallUHCMedArticles")
@CucumberOptions(
        glue = { "atdd.framework", "acceptancetests.mobile.acquisition" },
        monochrome=true, 
        features = { "src/main/resources/feature/mobile/acquisition/callChat" }, 
        plugin = { "pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqClickToCallUHCMedArticles.json" }, 
        tags = { "@UHC_MedArticles" })


public class RunMRATDDAcqClickToCallUHCMedArticles {
}
