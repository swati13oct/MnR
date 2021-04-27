package atdd.runners.AEM;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAEMDataLayer.json",detailedReport = true, detailedAggregatedReport = true, 
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAEMDataLayer")

@CucumberOptions(glue = { "atdd.framework", "acceptancetests/AEM" }, features = { "src/main/resources/feature/AEM" }, 
plugin = {"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAEMDataLayer.json" }, 
tags = { "@AEM_DataLayer" })

public class RunMRATDDAEMDataLayer {

}
