package atdd.runners.MemberRegression.DCE;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * 
 * @author schak38
 *
 */

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(retryCount=1,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/cucumber-RunMRATDDSanityDCE_Mapd_Medica.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDSanityDCE_Mapd_Medica")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/drugcostestimator" },monochrome= true, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDSanityDCE_Mapd_Medica.json" }, tags = { "@Stage_Sanity02" })

public class RunMRATDDSanityDCE_Mapd_Medica {

}
