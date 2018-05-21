package acceptancetests.memberredesign.memberAuth;

import gherkin.formatter.model.DataTableRow;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.dashboard.memberAuth.MemberAuthLoginPage;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
<<<<<<< HEAD
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.dashboard.memberAuth.MemberAuthLoginPage;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.memberauth.MemberAuthPage;
=======
>>>>>>> develop
/**
 * 
 * @author pdas101
 *
 */


public class MemberAuthStepDefinition{
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	/** 
	 * @todo :user to login for member auth
	 */
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

	/** 
	 * @todo :user to validate errors for member login with valid user and pwd 
	 */
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
	
	
	@Given("^the user is on member auth login flow page$")
	public void member_auth_login_flow_page(){
		WebDriver wd = getLoginScenario().getWebDriver();	

		MemberAuthPage memberauth = new MemberAuthPage(wd);
		memberauth.navigateToLoginURL();

		if(memberauth!=null){
			getLoginScenario().saveBean(MRConstants.MEMBER_AUTH, memberauth);
		}
	}
	
	
	
	@When ("^the member is able to login with correct username and password$")
	public void member_logins_with_credentials(DataTable profileAttributes) throws InterruptedException{


		MemberAuthPage memberauth = (MemberAuthPage) getLoginScenario().getBean(MRConstants.MEMBER_AUTH);

		List<DataTableRow> profileAttributesRow = profileAttributes
				.getGherkinRows();
		Map<String, String> profileAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < profileAttributesRow.size(); i++) {

			profileAttributesMap.put(profileAttributesRow.get(i).getCells()
					.get(0), profileAttributesRow.get(i).getCells().get(1));
		}		

		memberauth.FirstLogin(profileAttributesMap.get("Username") ,profileAttributesMap.get("Password"));
		
		if(memberauth!=null){
			getLoginScenario().saveBean(PageConstants.Member_Auth_Login, memberauth);
		}

	}
	
	@And("^Member Enters the Username he wants to search$")
	public void member_enters_username_and_searches(DataTable profileAttributes) throws InterruptedException{


		MemberAuthPage memberauth = (MemberAuthPage) getLoginScenario().getBean(PageConstants.Member_Auth_Login);

		List<DataTableRow> profileAttributesRow = profileAttributes
				.getGherkinRows();
		Map<String, String> profileAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < profileAttributesRow.size(); i++) {

			profileAttributesMap.put(profileAttributesRow.get(i).getCells()
					.get(0), profileAttributesRow.get(i).getCells().get(1));
		}		

		MemberAuthPage mauthPage = memberauth.MainMemberLogin(profileAttributesMap.get("MemUsername"));
		
		if(mauthPage!=null){
			getLoginScenario().saveBean(PageConstants.Member_Auth_PopUp, mauthPage);
		}

	}
	
	@And("^User Clicks on the Pop up displayed$")
	public void member_clicks_popup() throws InterruptedException{


		MemberAuthPage popupMauth = (MemberAuthPage) getLoginScenario().getBean(PageConstants.Member_Auth_PopUp);
		AccountHomePage NewWindow =  popupMauth.PopupClick();
		
		if(NewWindow!=null){
			getLoginScenario().saveBean(PageConstants.DashPage, NewWindow);
		}
	
	}
	
	/*@And("^User switches to new Tab opened$")
	public void Switch_To_New_Tab() throws InterruptedException{


		MemberAuthPage NewTab = (MemberAuthPage) getLoginScenario().getBean(PageConstants.New_Window);
		MemberAuthPage PayLink =  NewTab.NewTabValidation();
		
		if(NewWindow!=null){
			getLoginScenario().saveBean(PageConstants.New_Window, NewWindow);
		}
	
	}*/

}
