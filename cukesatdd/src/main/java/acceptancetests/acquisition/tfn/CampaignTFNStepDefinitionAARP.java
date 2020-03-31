package acceptancetests.acquisition.tfn;

/**
 * @author Tamzid
 *
 */


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.tfn.CampaignTFNPage;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.ulayer.GlobalWebElements;
import pages.acquisition.ulayer.UlayerTFNPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;

public class CampaignTFNStepDefinitionAARP {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}

	@Given("^the user retrieves TFNSessionCookie and Federal and MedSupp TFN for AARP site$")
	public void the_user_retrieves_TFNSessionCookie_and_Federal_and_MedSupp_TFN_for_AARP_site() throws Throwable {
		WebDriver driver = (WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);

		CampaignTFNPage tfnPage = new CampaignTFNPage(driver);
		getLoginScenario().saveBean(PageConstants.CAMPAIGN_TFN_PAGE, tfnPage);
		tfnPage.retrieveTFNcookie();
	}

	@Then("^the user validates PSC code for AARP site$")
	public void the_user_validates_PSC_code_for_AARP_site(DataTable inputAttributes) throws Throwable {
		Map<String, String> inputAttributesMap=parseInputArguments(inputAttributes);
		String pscCode = inputAttributesMap.get("PSC Code");
		CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
		tfnPage.validatePSCcode(pscCode);
	}
	

@Then("^the user navigates to following MA Plan Page URL and validate Federal TFN$")
public void the_user_navigates_to_following_MA_Plan_Page_URL_and_validate_Federal_TFN(DataTable arg1) throws Throwable {
	Map<String, String> inputAttributesMap=parseInputArguments(arg1);
	String URLpath = inputAttributesMap.get("MA URL");
	String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
	CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
	tfnPage.navigateToUrl(URLpath);
	tfnPage.validateFederalTFN(TFN_Xpath);
}

@Then("^the user navigate to following PDP Plan Page URL and validate Federal TFN$")
public void the_user_navigate_to_following_PDP_Plan_Page_URL_and_validate_Federal_TFN(DataTable arg1) throws Throwable {
	Map<String, String> inputAttributesMap=parseInputArguments(arg1);
	String URLpath = inputAttributesMap.get("PDP URL");
	String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
	CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
	tfnPage.navigateToUrl(URLpath);
	tfnPage.validateFederalTFN(TFN_Xpath);
}

@Then("^the user navigate to following SNP Plan page URL and validate Federal TFN$")
public void the_user_navigate_to_following_SNP_Plan_page_URL_and_validate_Federal_TFN(DataTable arg1) throws Throwable {
	Map<String, String> inputAttributesMap=parseInputArguments(arg1);
	String URLpath = inputAttributesMap.get("SNP URL");
	String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
	CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
	tfnPage.navigateToUrl(URLpath);
	tfnPage.validateFederalTFN(TFN_Xpath);
}

@Then("^the user navigate to following Med Supp Plan URL and validate MedSupp TFN$")
public void the_user_navigate_to_following_Med_Supp_Plan_URL_and_validate_MedSupp_TFN(DataTable arg1) throws Throwable {
	Map<String, String> inputAttributesMap=parseInputArguments(arg1);
	String URLpath = inputAttributesMap.get("MedSupp URL");
	String TFN_Xpath = inputAttributesMap.get("TFN Xpath");
	CampaignTFNPage tfnPage = (CampaignTFNPage) getLoginScenario().getBean(PageConstants.CAMPAIGN_TFN_PAGE);
	tfnPage.navigateToUrl(URLpath);
	tfnPage.validateMedSuppTFN(TFN_Xpath);
}

@Given("^the user is on AARP medicare acquisition site from Campaign Traffic$")
public void the_user_lands_on_AARP_from_Campaign_Traffic(DataTable arg1) throws Throwable  {
	
}
	
}












