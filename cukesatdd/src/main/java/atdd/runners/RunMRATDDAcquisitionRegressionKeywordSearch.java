package atdd.runners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for Keyword Search User Stories in Acquisition sites
 */


@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionRegressionKeywordSearch.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionRegressionKeywordSearch")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, 
features = { "src/main/resources/feature/acquisition/keywordSearch" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionRegressionKeywordSearch.json" }, tags = { "@Keywordsearch_AARP" })
public class RunMRATDDAcquisitionRegressionKeywordSearch {

}

//note: these tags are for  
	//	@Keyword_Search_UHC  @KeywordSearch_AARP