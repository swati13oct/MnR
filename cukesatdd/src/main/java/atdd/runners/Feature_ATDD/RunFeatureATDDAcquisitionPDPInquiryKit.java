package atdd.runners.Feature_ATDD;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionPDPInquiryKit
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=2, screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunFeatureATDDAcquisitionPDPInquiryKit.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunFeatureATDDAcquisitionPDPInquiryKit")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, features = { "src/main/resources/feature/acquisition/inquirykit" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunFeatureATDDAcquisitionPDPInquiryKit.json" }, tags = { "@pdpInquiryKitBLayerSmoke, @pdpInquiryKitULayerSmoke" })
public class RunFeatureATDDAcquisitionPDPInquiryKit {

}
