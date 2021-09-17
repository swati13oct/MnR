package pages.mobile.acquisition.commonpages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.dceredesign.DCERedesignCommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import io.appium.java_client.AppiumDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import pages.acquisition.commonpages.ComparePlansPage;



public class ShopperProfileAgentLogin extends UhcDriver {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@FindBy(id = "loginusername")
	private WebElement username;

	@FindBy(id = "loginpassword")
	private WebElement password;

	@FindBy(xpath = "//button")
	private WebElement btnLogin;

	@FindBy(id = "visitorsEmail")
	private WebElement visitorEmail;

	public ShopperProfileAgentLogin(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	private static String AARP_TELESALES_AGENT_PAGE_URL_STAGE = MRConstants.AARP_TELESALES_AGENT_PAGE_URL_STAGE;
	private static String AARP_TELESALES_AGENT_TEAM_E_PAGE_URL = MRConstants.AARP_TELESALES_AGENT_TEAM_E_PAGE_URL;
	private static String AARP_TELESALES_AGENT_PAGE_URL = MRConstants.AARP_TELESALES_AGENT_PAGE_URL;

	public void openAndValidate() {
		if (MRScenario.environment.equals("offline-stage")) {
			startNewMobile(AARP_TELESALES_AGENT_PAGE_URL_STAGE);
			//CommonUtility.waitForPageLoadNew(driver, username, 45);
		} else if (MRScenario.environment.equals("stage")) {
			startNewMobile(AARP_TELESALES_AGENT_PAGE_URL_STAGE);

			if (driver.findElements(By.id("loginusername")).size() > 0) {
				//CommonUtility.waitForPageLoadNew(driver, username, 45);
			} else
				CommonUtility.waitForPageLoadNew(driver, visitorEmail, 45);
		} else if (MRScenario.environment.equals("team-e")) {
			startNewMobile(AARP_TELESALES_AGENT_TEAM_E_PAGE_URL);
		} else {
			startNewMobile(AARP_TELESALES_AGENT_PAGE_URL);
			//CommonUtility.waitForPageLoadNew(driver, username, 45);
		}
		System.out.println("Current page URL: " + driver.getCurrentUrl());
	}
	
	@Then("^I land on the plan compare page$")
	public void i_land_on_the_plan_compare_page(DataTable userData){
		
		HashMap<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(userData);
		/*List<DataTableRow> givenAttributesRow = userData.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		ComparePlansPageMobile comparePlansPage = (ComparePlansPageMobile) getLoginScenario()
				.getBean(PageConstants.PLAN_COMPARE_PAGE);
		
//		comparePlansPage.validateMemberDetails(userData);
		comparePlansPage.validateMemberDetails(givenAttributesMap);
		getLoginScenario().saveBean(DCERedesignCommonConstants.DRUGLIST, givenAttributesMap.get("Drugs"));
	}
	
	@Then("^the profile is found and i click on the CLOAK IN button$")
	public void the_profile_is_found_and_i_click_on_the_CLOAK_IN_button(){
		
		try {
			ProfileSearch profileSeacrh = (ProfileSearch) getLoginScenario()
					.getBean(PageConstants.PROFILE_SEARCH);
			
			ComparePlansPageMobile comparePlansPage = profileSeacrh.doCloakIn();
			getLoginScenario().saveBean(PageConstants.PLAN_COMPARE_PAGE, comparePlansPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Then("^I ask the shopper calling in to provide me with the Email Address and Search$")
	public void i_ask_the_shopper_calling_in_to_provide_me_with_the_Email_Address_And_Search(DataTable email){
	    
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(email);
		/*List<DataTableRow> givenAttributesRow = email.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String emailID = givenAttributesMap.get("Email");
		
		ProfileSearch profileSeacrh = (ProfileSearch) getLoginScenario()
				.getBean(PageConstants.PROFILE_SEARCH);
		
		profileSeacrh.searchProfileByEmail(emailID);
	}

	/**
	 * Agent Login with Username and Password
	 * 
	 * @param userName
	 * @param passWord
	 * @return
	 */
	public ProfileSearch doAgentLogin(String userName, String passWord) {
		if (MRScenario.environment.equals("offline")) {
		} else if (MRScenario.environment.equals("stage")) {
			if (driver.findElements(By.id("loginusername")).size() > 0) {
				waitforElement(username);
				sendkeys(username, userName);
				sendkeys(password, passWord);
				btnLogin.click();
				CommonUtility.checkPageIsReadyNew(driver);
				CommonUtility.waitForPageLoadNew(driver, visitorEmail, 45);
			} else
				System.out.println("########Skipping sign In for stage########");
		} else {
			waitforElement(username);
			sendkeys(username, userName);
			sendkeys(password, passWord);
			btnLogin.click();
			CommonUtility.waitForPageLoadNew(driver, visitorEmail, 45);
		}
		if (driver.getCurrentUrl().contains("search-profile")) {
			return new ProfileSearch(driver);
		} else {
			System.out.println("Agent login is failed");
			return null;
		}
	}

}
