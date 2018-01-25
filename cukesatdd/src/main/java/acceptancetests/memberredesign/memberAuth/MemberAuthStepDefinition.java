package acceptancetests.memberredesign.memberAuth;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.data.MRConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.dashboard.memberAuth.MemberAuthLoginPage;
/**
 * 
 * @author pdas101
 *
 */


public class MemberAuthStepDefinition{
	
	private static final MemberAuthLoginPage MemberAuthLoginPage = null;
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user is on member auth login page$")
	public void the_user_is_on_member_auth_login_page(){
		WebDriver wd = getLoginScenario().getWebDriver();	
		
		MemberAuthLoginPage memberauth = new MemberAuthLoginPage(wd);
		memberauth.navigateToLoginURL();
		
		if(memberauth!=null){
getLoginScenario().saveBean(MRConstants.MEMBER_AUTH, memberauth);
		}
	}
	/*public void uhc_login_page(){
        WebDriver wd = getLoginScenario().getWebDriver();
        getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

       // LoginPage loginPage = new LoginPage(wd);
        MemberAuthLoginPage memberauth = new MemberAuthLoginPage(wd);
        getLoginScenario().saveBean(MRConstants.MEMBER_AUTH, memberauth);*/
        
//}
		
	@Then ("^the member tries to login with invalid username and correct password and verify the error message$")
	public void member_tries_to_login_with_credentials(DataTable profileAttributes) throws InterruptedException{
		

		MemberAuthLoginPage memberauth = (MemberAuthLoginPage) getLoginScenario().getBean(MRConstants.MEMBER_AUTH);
		
		List<DataTableRow> profileAttributesRow = profileAttributes
				.getGherkinRows();
				Map<String, String> profileAttributesMap = new LinkedHashMap<String, String>();
				for (int i = 0; i < profileAttributesRow.size(); i++) {

				profileAttributesMap.put(profileAttributesRow.get(i).getCells()
				.get(0), profileAttributesRow.get(i).getCells().get(1));
				}
			//MemberAuthLoginPage memberauth =  (MemberAuthLoginPage);
				
				memberauth.validateErrorMessage(profileAttributesMap.get("Username") ,profileAttributesMap.get("Password"), profileAttributesMap.get("Error Message"));
				//memberauth.validateErrorMessage(loginname, loginpassword);
				
	}

	

}
