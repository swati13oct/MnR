/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author saduri
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.alreadymember.bluelayer" }, 
		features = { "feature/already-member" },
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@headerBLayerAlreadyMemberOneTest"})
public class RunMRCukesAlreadyMemberBlueLayer {

}

