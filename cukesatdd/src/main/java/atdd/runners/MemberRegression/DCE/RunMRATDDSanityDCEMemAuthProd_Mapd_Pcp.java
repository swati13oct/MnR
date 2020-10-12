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
jsonReport = "target/cucumber-RunMRATDDSanityDCEMemAuthProd_Mapd_Pcp.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDSanityDCEMemAuthProd_Mapd_Pcp")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.memberredesign" }, 
features = { "src/main/resources/feature/memberredesign/drugcostestimator" },monochrome= true, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber-RunMRATDDSanityDCEMemAuthProd_Mapd_Pcp.json" }, tags = { "@prod_sanity_02" })

public class RunMRATDDSanityDCEMemAuthProd_Mapd_Pcp {

}
