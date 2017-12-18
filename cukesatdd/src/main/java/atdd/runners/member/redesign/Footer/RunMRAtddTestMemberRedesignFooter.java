package atdd.runners.member.redesign.Footer;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 *@author bpilli10
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.member.redesign.footer" }, 
		features = { "feature/member-redesign/footer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@member_redesign_footer"})



public class RunMRAtddTestMemberRedesignFooter {

}
