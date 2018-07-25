package atdd.runners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedParallelCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**
 * 
 * @author ashah120
 *
 */

@RunWith(ExtendedParallelCucumber.class)
@ExtendedCucumberOptions(threadsCount=15,screenShotSize="", screenShotLocation="/screenshots/",
jsonReport = "target/RunMRATDDApplitoolsTest.json",detailedReport = true, detailedAggregatedReport = true,
overviewReport = true, toPDF = true, outputFolder = "target/RunMRATDDApplitoolsTest")
@CucumberOptions(glue = { "atdd.framework", "acceptancetests.vbfacquisition" }, 
features = { "src/main/resources/feature/vbfacquisition" }, plugin = {
		 "html:reports/test-report", "json:target/cucumber-RunMRATDDApplitoolsTest.json" }, tags = { "@applitoolsAARP_VPP,@applitoolsAARP_DCE,@applitoolsAARP_OLE" })
public class RunMRATDDApplitoolsTest {

}
