package atdd.runners.mobile.acquisition.siteSearch;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionSitesearchAARPMobile
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionSitesearchAARPMobile.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true,
 outputFolder = "target/RunMRATDDAcquisitionSitesearchAARPMobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" }, 
features = { "src/main/resources/feature/mobile/acquisition/Sitesearch" }, 
plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionSitesearchAARPMobile.json" }, 
tags = { "@SiteSearchRegressionAARP" }, dryRun=false)
public class RunMRATDDAcquisitionSitesearchAARPMobile { 
 
}

//"@SiteSearchRegressionAARP"