/**
 * 
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * @author jantolak
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.vpp.bluelayer" }, 
		features = { "feature/chat/ulayer" }, 
		format = {
		"pretty", "html:reports/test-report" }, tags ={"@proactivechatOnVPPSummarypage"})
public class AntolakRunChatTest {

}


