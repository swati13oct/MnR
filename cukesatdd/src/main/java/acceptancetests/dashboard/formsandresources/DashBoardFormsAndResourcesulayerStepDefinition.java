package acceptancetests.dashboard.formsandresources;

import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import junit.framework.Assert;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import pages.dashboard.formsandresources.FormsAndResourcesPageulayer;
import pages.member.ulayer.AccountHomePage;
import pages.member.ulayer.LoginPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.acquisition.PageConstants;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en_au.When;
import cucumber.table.DataTable;

public class DashBoardFormsAndResourcesulayerStepDefinition {

	@Autowired
	MRScenario loginScenario;
	
	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	
	
	@Given("^registered member lands on forms and resources in member U Layer Site$")
    public void navigateToULayerPage() {
        // navigate to U layer login site
        WebDriver wd = getLoginScenario().getWebDriver();
        getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
        // create F& R context
        FormsAndResourcesPageulayer formsAndResourcesPageULAYER = new FormsAndResourcesPageulayer(
                                        wd);
        getLoginScenario().saveBean(
                                        PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE_Ulayer,
                                        formsAndResourcesPageULAYER);

}

	@When("^member click on member sign in link on ulayer$")
	public void membeClicksOnMemberSignInulayer() {
		FormsAndResourcesPageulayer formsAndResourcesPageULAYER = (FormsAndResourcesPageulayer) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE_Ulayer);
		formsAndResourcesPageULAYER.clickMemberSignIn();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@And("^the member enters userId and member enter password on ulayer$")
	public void memberEntersUserIdPassword(DataTable givenAttributes) {
		// get test variables
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		System.out.println(memberAttributesMap);
		// get userId
		String userId = memberAttributesMap.get("USER_ID");
		String password = memberAttributesMap.get("PASSWORD");
		// navigate to registration page
		FormsAndResourcesPageulayer formsAndResourcesPageULAYER = (FormsAndResourcesPageulayer) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE_Ulayer);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		formsAndResourcesPageULAYER.enterUserid(userId);
		formsAndResourcesPageULAYER.enterPassword(password);
	}

	@And("^member click signin button and logs in on ulayer$")
	public void membeClicksOnSignInButton() {
		FormsAndResourcesPageulayer formsAndResourcesPageULAYER = (FormsAndResourcesPageulayer) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE_Ulayer);
		formsAndResourcesPageULAYER.clickMemberSignInButton();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Then("^open u layer test harnesss page in a new tab$")
	public void openTestHarnessPageInNewTab() {
		FormsAndResourcesPageulayer formsAndResourcesPageULAYER = (FormsAndResourcesPageulayer) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE_Ulayer);
		
		formsAndResourcesPageULAYER.openTestHarnessPage();
	}
	
	@And("^click on the forms and resource link and navigate to forms and resource page for ulayer$")
	public void clickOnFormAndResourcesLink() {
		FormsAndResourcesPageulayer formsAndResourcesPageULAYER = (FormsAndResourcesPageulayer) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE_Ulayer);
		formsAndResourcesPageULAYER.clickonFormsAndResourcesLinkOnTestHarness();
	}
	@SuppressWarnings("deprecation")
	@And("^validate plan materials section$")
	public void validateplanSection() throws InterruptedException {
		FormsAndResourcesPageulayer formsAndResourcesPageULAYER = (FormsAndResourcesPageulayer) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE_Ulayer);
		Thread.sleep(5000);
		formsAndResourcesPageULAYER.getPlanMaterialSection().isDisplayed();
		Assert.assertTrue(formsAndResourcesPageULAYER.getPlanMaterialSection().getText().contains("Plan Materials"));

	}

	@SuppressWarnings("deprecation")
	@And("^click on the order plan materials and view temporary id card link$")
	public void validateRenewMagazineSection(DataTable givenAttributes) throws InterruptedException {
FormsAndResourcesPageulayer formsAndResourcesPageULAYER = (FormsAndResourcesPageulayer) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE_Ulayer);
        formsAndResourcesPageULAYER.planordermaterialslink().isDisplayed();
        Thread.sleep(1000);
        Assert.assertTrue(formsAndResourcesPageULAYER.planordermaterialslink().getText().contains("ORDER"));     
		formsAndResourcesPageULAYER.getTemporarycardlink().isDisplayed();
		Thread.sleep(1000);
		Assert.assertTrue(formsAndResourcesPageULAYER.getTemporarycardlink().getText().contains("VIEW TEMPORARY"));
		formsAndResourcesPageULAYER.planordermaterialslink().click();
		formsAndResourcesPageULAYER.navigatebacktofnrpage();
		formsAndResourcesPageULAYER.getTemporarycardlink().click();
		formsAndResourcesPageULAYER.navigatebacktofnrpage();
	}
	
	@And("^validate that english is default language in dropdown$")
	public void validatelangdrop() throws InterruptedException {
     FormsAndResourcesPage formsAndResourcesPageULAYER = (FormsAndResourcesPageulayer) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE_Ulayer);
             Thread.sleep(1000);
      formsAndResourcesPageULAYER.englanguagedefault();       
	
	}
	
	@And("^change the language in the language dropdown$")
	public void changelanguage() throws InterruptedException {
FormsAndResourcesPageulayer formsAndResourcesPageULAYER = (FormsAndResourcesPageulayer) getLoginScenario().getBean(PageConstants.DASHBOARD_FORMS_AND_RESOURCES_PAGE_Ulayer);
         Thread.sleep(1000);
      formsAndResourcesPageULAYER.selectlanguage();
        
        
	}

	

	
	

}
