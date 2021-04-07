package atdd.runners.mobile.prod.sanity.ios;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionFavoritePlanMobile
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionFavoritePlanMobileIOS.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, 
 outputFolder = "target/RunMRATDDAcquisitionFavoritePlanMobileIOS")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile.acquisition" }, 
features = { "src/main/resources/feature/mobile/acquisition/FavoritePlan" },
plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionFavoritePlanMobileIOS.json" }, 
tags = {"@ios"}, dryRun=false)
public class RunMRATDDAcquisitionFavoritePlanMobileIOS { 
 
}

