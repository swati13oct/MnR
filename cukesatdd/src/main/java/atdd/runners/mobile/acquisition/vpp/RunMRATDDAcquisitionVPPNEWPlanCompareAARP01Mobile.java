package atdd.runners.mobile.acquisition.vpp;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * 
 * this file is to run test cases for RunMRATDDAcquisitionVppPlanSummary
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionVPPNEWPlanCompareAARP01Mobile.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionVPPNEWPlanCompareAARP01Mobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" }, 
features = { "src/main/resources/feature/mobile/acquisition/vpp/" },  plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionVPPNEWPlanCompareAARP01Mobile.json" }, 
tags = { "@VppPlanCompareCommon_AARP01"}, dryRun=false)//"@vppPlanCompareAARPRun01New" })
public class RunMRATDDAcquisitionVPPNEWPlanCompareAARP01Mobile { 
 
}

//@VBFTEAMC , @VppPlanCompareCommon_AARP01