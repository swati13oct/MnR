package acceptancetests.dashboard.registration;
import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.dashboard.acquisition.RegistrationInformationPage;
import pages.dashboard.member.ulayer.MemberNewSignInPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.member.PageConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.table.DataTable;

public class RegistartionPageNaviagtionstepdefination {

	@Autowired
	MRScenario loginScenario;


	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	WebDriver driver;
	@Given("^the member is on sign in page of new portal part of redesign$")
	public void I_am_a_memebr_on_the_signin_page (DataTable Url) throws Exception {

		WebDriver wd = getLoginScenario().getWebDriver();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		List<DataTableRow> AttributesRow = Url
				.getGherkinRows();
		Map<String, String> urlAttributesMap = new HashMap<String, String>();

		for (int i = 0; i < AttributesRow.size(); i++) {

			urlAttributesMap .put(AttributesRow.get(i).getCells()
					.get(0), AttributesRow.get(i).getCells().get(1));
		}
		String url = urlAttributesMap.get("URL");
		wd.get(url);

		MemberNewSignInPage sign_Page = new MemberNewSignInPage(wd);
		sign_Page.validateNewSignPage();
		if (sign_Page != null) {
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			getLoginScenario().saveBean(PageConstants.NEW_SIGN_PAGE,sign_Page);
			Assert.assertTrue(true);
		}
	}
	@And("^User clicks on the register button$")
    public void registerbutton() {
    	
    	MemberNewSignInPage sign_Page  = (MemberNewSignInPage) getLoginScenario()
				.getBean(PageConstants.NEW_SIGN_PAGE);
        
        //RegistrationInformationPage registrationInformationPage = new RegistrationInformationPage(driver);
        sign_Page.clickRegisterbutton();
        
        /*if(sign_Page!= null){
			getLoginScenario().saveBean(PageConstants.REGISTRATION_INFORMATION_PAGE,
					registrationInformationPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("Registration page not found");
		}*/
	}
}
