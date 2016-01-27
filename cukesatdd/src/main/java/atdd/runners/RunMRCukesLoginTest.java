package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


/**
 * 
 * @author schak38
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.login" }, 
		features = { "feature/login" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@loginTestAARP"})

public class RunMRCukesLoginTest {
	
	
}
