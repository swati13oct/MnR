/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

/**	
 * @author pagarwa5
 *
 */
@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",detailedReport = true, detailedAggregatedReport = true, overviewReport = true, toPDF = true, outputFolder = "target")
@CucumberOptions(glue = { "atdd.framework","acceptancetests.dcevpp" }, 
		features = { "src/main/resources/feature/dcevpp" }, plugin = {
		"pretty", "html:reports/test-report", "json:target/cucumber.json" }, tags ={"@dceVpp"})
public class RunMRAtddTestDce {

}