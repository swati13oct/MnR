package atdd.runners.acquisition;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for RunMRATDDAcquisitionDCE
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",jsonReport = "target/cucumber-RunMRATDDAcquisitionPDPInquiryKitUlayer.json",detailedReport = true,
 detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionPDPInquiryKitUlayer")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition.vpp","acceptancetests.acquisition.agentflow", "acceptancetests.acquisition.inquirykit" }, features = {"src/main/resources/feature/acquisition/inquirykit" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionPDPInquiryKitUlayer.json" }, tags = { "@pdpInquiryKitULayerRegression" })
public class RunMRATDDAcquisitionPDPInquiryKitUlayer { 
 
}