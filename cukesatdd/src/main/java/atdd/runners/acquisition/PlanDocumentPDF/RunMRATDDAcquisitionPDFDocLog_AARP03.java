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
jsonReport = "target/cucumber-RunMRATDDAcquisitionPDFDocLog_AARP03.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDAcquisitionPDFDocLog_AARP03")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.acquisition" }, monochrome = true,
features = { "src/main/resources/feature/acquisition" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDAcquisitionPDFDocLog_AARP03.json" }, tags = { "@pdfDocLogAARP03" })
public class RunMRATDDAcquisitionPDFDocLog_AARP03 { 
//@PlanDocs_PDF_URLvalidation,@PlanDocs_PDF_URLvalidation,@PlanDocs_PDF_Textvalidation,
} 