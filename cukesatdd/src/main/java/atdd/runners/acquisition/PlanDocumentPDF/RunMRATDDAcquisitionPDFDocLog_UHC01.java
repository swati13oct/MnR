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
jsonReport = "target/cucumber-RunMRATDDAcquisitionPDFDocLog_UHC01.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionPDFDocLog_UHC01")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition.vpp" }, monochrome = true,
features = { "src/main/resources/feature/acquisition/vpp" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionPDFDocLog_UHC01.json" }, tags = { "@pdfDocLogUHC01" })
public class RunMRATDDAcquisitionPDFDocLog_UHC01 { 
//@PlanDocs_PDF_URLvalidation,@PlanDocs_PDF_URLvalidation,@PlanDocs_PDF_Textvalidation,
} 