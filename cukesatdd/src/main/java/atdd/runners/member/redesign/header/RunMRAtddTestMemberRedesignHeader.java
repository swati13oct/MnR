package atdd.runners.member.redesign.header;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 *@author bpilli10
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.member.redesign.header" }, 
		features = { "feature/member-redesign/header" }, 
		format = {
		"pretty", "html:reports/test-report","json:target/cucumber.json" }, tags ={"@member_redesign_header"})


public class RunMRAtddTestMemberRedesignHeader {

}
