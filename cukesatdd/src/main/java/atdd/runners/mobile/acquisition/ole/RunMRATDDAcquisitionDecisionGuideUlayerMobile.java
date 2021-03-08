package atdd.runners.mobile.acquisition.ole;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionDecisionGuideUlayer
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionDecisionGuideUlayerMobile.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionDecisionGuideUlayerMobile")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.mobile" }, features = { "src/main/resources/feature/mobile/acquisition/ole" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionDecisionGuideUlayerMobile.json" }, tags = { "@IS_DecisionGuide_Common_AARP"})//"@IS_DecisionGuide_AARP" })
public class RunMRATDDAcquisitionDecisionGuideUlayerMobile { 
 
}
