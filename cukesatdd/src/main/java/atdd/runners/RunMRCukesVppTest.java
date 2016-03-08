package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * 
 * @author schak38
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.vpp" }, 
		features = { "feature/vpp" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@vpp"})

public class RunMRCukesVppTest {
	
	
}
