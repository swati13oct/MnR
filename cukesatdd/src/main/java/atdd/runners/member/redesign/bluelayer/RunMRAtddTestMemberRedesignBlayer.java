package atdd.runners.member.redesign.bluelayer;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 *
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.member.redesign.bluelayer" }, 
		features = { "feature/member-redesign/bluelayer" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@member_redesign_header_ums"})


public class RunMRAtddTestMemberRedesignBlayer {

}
