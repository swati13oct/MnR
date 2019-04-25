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
jsonReport = "target/cucumber-RunMRATDDAcqRegressionPDPInqKit.json",detailedReport = true, detailedAggregatedReport = true, 
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcqRegressionPDPInqKit")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition.vpp","acceptancetests.acquisition.agentflow", "acceptancetests.acquisition.inquirykit"  },
features = { "src/main/resources/feature/acquisition/inquirykit" },
plugin = {"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcqRegressionPDPInqKit.json" }, tags = { "@pdpInquiryKitULayerRegression,@pdpInquiryKitBLayerRegression" })

public class RunMRATDDAcqRegressionPDPInqKit { 
}