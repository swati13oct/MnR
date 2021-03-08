package atdd.runners.mobile.acquisition.vpp;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionVppPlanSummary
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionVPPPlanDetailsAARP03Mobile.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionVPPPlanDetailsAARP03Mobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" }, 
features = { "src/main/resources/feature/mobile/acquisition/vpp/" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionVPPPlanDetailsAARP03Mobile.json" }, 
tags = { "@VppPlanDetailsCommon_AARP03"}  , dryRun=false)//"@VppPlanDetailsCommon_AARP02"})// "@vppPlanDetailsAARPRun03","@vppPlanDetailsAARPRegression" })
public class RunMRATDDAcquisitionVPPPlanDetailsAARP03Mobile { 
 
}
