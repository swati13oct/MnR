package atdd.runners.acquisition.PlanDocumentPDF;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * this file is to run test cases for Fast and Furious User Stories in Acquisition sites
 */
@RunWith(ExtendedCucumber.class)

@ExtendedCucumberOptions(retryCount=0,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDAcquisitionPDFDocLog_UHC05.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionPDFDocLog_UHC05")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition.vpp" }, monochrome = true,
features = { "src/main/resources/feature/acquisition" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionPDFDocLog_UHC05.json" }, tags = { "@pdfDocLogUHC05" })
public class RunMRATDDAcquisitionPDFDocLog_UHC05 { 
//@PlanDocs_PDF_URLvalidation,@PlanDocs_PDF_URLvalidation,@PlanDocs_PDF_Textvalidation,
} 