package atdd.runners.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionDCE
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionPDPInquiryKitBlayer.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionPDPInquiryKitBlayer")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition.vpp","acceptancetests.acquisition.agentflow", "acceptancetests.acquisition.inquirykit" }, 
features = {"src/main/resources/feature/acquisition/inquirykit" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionPDPInquiryKitBlayer.json" }, tags = { "@pdpInquiryKitBLayerRegression" })
public class RunMRATDDAcquisitionPDPInquiryKitBlayer { 
 
}
