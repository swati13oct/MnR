package atdd.runners.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for retiree drug search
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDUHCRetireeDrugSearchVBF.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDUHCRetireeDrugSearchVBF")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition.retiree" }, features = { "src/main/resources/feature/acquisition/retiree" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDUHCRetireeDrugSearchVBF.json" }, tags = { "@retireedrugsearch_Smoke" })
public class RunMRATDDUHCRetireeDrugSearchVBF {

}

