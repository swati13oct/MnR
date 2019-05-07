package atdd.runners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for Fast and Furious User Stories in Acquisition sites
 */
@RunWith(ExtendedCucumber.class)

@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionRegressionVppPlanSummary.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDfastandfuriousAcquisitionTest")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition.vpp", "acceptancetests.acquisition.ole"  },
features = { "src/main/resources/feature/acquisition/vpp","src/main/resources/feature/acquisition/ole" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionRegressionVppPlanSummary.json" }, tags = { "@vppPlanCardsRegression, @rightRailRegression" })

public class RunMRATDDAcquisitionRegressionVppPlanSummary { 
	//note: these tags are for F265872: 
	//	@vppFavoritePlanRegression, @vppPrintRegression @vppEmailRegression
	//	@vppEmailRegression is turn off for now for april 2019 release
}