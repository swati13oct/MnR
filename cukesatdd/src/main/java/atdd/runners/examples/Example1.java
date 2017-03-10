/**
 * 
 */
package atdd.runners.examples;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author jantolak
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.benefitsandcoverage" }, 
		features = { "feature/debug" }, 
		format = {
		"pretty", "html:reports/test-report", "json:target/cucumber.json" }, tags ={"@Example1"})
public class Example1 {

}