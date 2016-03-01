package acceptancetests.dcevpp.bluelayer;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.AddDrugPage;
import pages.acquisition.bluelayer.EnterZipCodePage;
import pages.acquisition.bluelayer.EstimateDrugCostPage;
import pages.acquisition.bluelayer.SelectDosagePage;
import pages.acquisition.bluelayer.SelectGenericPage;
import acceptancetests.atdd.data.acquisition.PageConstants;
import atdd.framework.MRScenario;
import cucumber.annotation.After;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;

public class DceVppAddDrugFowUmsStepDefinition {


	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Given("^zipcode and county information DCE to Vpp Plan summary flow in UMS site$")
	public void zipcode_and_planyear_details(DataTable givenAttributes) {
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String planYear = null;
		if(givenAttributesMap.containsKey("Plan Year"))
		{
			planYear = givenAttributesMap.get("Plan Year");
		}
		String zipCode = givenAttributesMap.get("Zip Code");
		String county = givenAttributesMap.get("County");
		WebDriver wd = getLoginScenario().getWebDriver();
		AcquisitionHomePage acqusitionHomePage = new AcquisitionHomePage(wd);
		EstimateDrugCostPage estimateDrugCost = acqusitionHomePage
				.switchToPrescriptionDrug();
		EnterZipCodePage enterZipCode = estimateDrugCost.getStarted();
		AddDrugPage addDrugPage = enterZipCode.getZipCodeCounty(zipCode,county,planYear);

		if (addDrugPage != null) {
			getLoginScenario().saveBean("webDriver", wd);
			getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
					addDrugPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("unsuccessfull navigation to add drug page");
		}
	}

	@When("^user wants to search the drug using drug initials in UMS site$")
	public void user_validated_drugInformation(DataTable givenAttributes) {
		String drugInitials = givenAttributes.getGherkinRows().get(0)
				.getCells().get(0);
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		addDrugPage.validateAddDrugFlow();
		addDrugPage.enterDrugInitials(drugInitials);
	}

	@And("^user wants to access the drug list having 5 drugs in UMS site$")
	public void drug_list_with_drugs() {
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		String drugDropDownList = addDrugPage.getDrugList();
		System.out.println("drugList=======>" + drugDropDownList);

	}

	@And("^the user wants to selects following drug in UMS site$")
	public void user_selects_drugname_druglist(DataTable drugNameAttributes) {

		String drugName = drugNameAttributes.getGherkinRows().get(0).getCells()
				.get(0);
		AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
				PageConstants.ADD_DRUG_PAGE);
		SelectDosagePage selectDosagePage = addDrugPage.selectDrug(drugName);
		if (selectDosagePage != null) {

			getLoginScenario().saveBean(PageConstants.SELECT_DOSAGE_PAGE,
					selectDosagePage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("unsuccessful selection of drug");
		}

	}

	@And("^user wants to selects the following dosage information in UMS site$")
	public void user_selects_dosage_information(DataTable dosagesAttributes) {
		SelectDosagePage selectDosagePage = (SelectDosagePage) getLoginScenario()
				.getBean(PageConstants.SELECT_DOSAGE_PAGE);
		List<DataTableRow> dosageAttributesRow = dosagesAttributes
				.getGherkinRows();
		Map<String, String> dosageAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < dosageAttributesRow.size(); i++) {

			dosageAttributesMap.put(dosageAttributesRow.get(i).getCells()
					.get(0), dosageAttributesRow.get(i).getCells().get(1));
		}
		String drugDosage = dosageAttributesMap.get("Drug Dosage");
		String drugQuantity = dosageAttributesMap.get("Drug Quantity");
		String drugFrequency = dosageAttributesMap.get("Drug Frequency");
		String packages = dosageAttributesMap.get("Packages");
		SelectGenericPage selectGenericPage = (SelectGenericPage) selectDosagePage.selectDosage(
				drugDosage, drugQuantity, drugFrequency,packages);
		if (selectGenericPage != null) {
			getLoginScenario().saveBean(PageConstants.SELECT_GENERIC_PAGE,
					selectGenericPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("dosage selection unsuccessful");
		}

	}
	
	
	@And("^the user wants to selects the low cost options in UMS site$")
	public void user_selects_lowCostOptions(DataTable drugAttributes) {
		String drugName = drugAttributes.getGherkinRows().get(0).getCells().get(0);
		SelectGenericPage selectGenericPage = (SelectGenericPage) getLoginScenario().getBean(PageConstants.SELECT_GENERIC_PAGE);
		
		/*
		 * TODO: CodeMonkeys Team: Please refer the Ulayer code to develop bluelayer code.
		 * 
		 * As of now passing making temporary changes to remove errors so that Ulayer code can be tested
		 * 
		 * 
		 * */
		
		
		/*
		 * START of code comment
		 * 
		 * AddDrugPage addDrugPage = selectGenericPage.selectGeneric(drugName);
		if (addDrugPage != null) {
			getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
					addDrugPage);
			Assert.assertTrue(true);
		} else {
			Assert.fail("generic drug selection unsuccessful");
		}
		addDrugPage.addDrugFlowCheck();
		addDrugPage.validateAddDrugFlow();
		
		*END of code comment
		*
		*/
	}
	 @After
	    public void tearDown() {
		 WebDriver wd = (WebDriver) getLoginScenario().getBean("webDriver");
			wd.quit();
	    }
	 
	 @Given("^user doing drug search using the following details in ums site$")
		public void ums_landing_page(DataTable givenAttributes) {
			List<DataTableRow> givenAttributesRow = givenAttributes
					.getGherkinRows();
			Map<String, String> givenAttributesMap = new HashMap<String, String>();
			for (int i = 0; i < givenAttributesRow.size(); i++) {

				givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
						givenAttributesRow.get(i).getCells().get(1));
			}
			String planYear = null;
			if(givenAttributesMap.containsKey("Plan Year"))
			{
				planYear = givenAttributesMap.get("Plan Year");
			}
			String zipCode = givenAttributesMap.get("Zip Code");
			String county = givenAttributesMap.get("County");
			String planType = givenAttributesMap.get("Plan Type");
			
			System.out.println("======plan type==="+planType);
			
			WebDriver wd = getLoginScenario().getWebDriver();
			AcquisitionHomePage acqusitionHomePage = new AcquisitionHomePage(wd);
			pages.acquisition.bluelayer.VPPPlanSummaryPage vppSummary = acqusitionHomePage.enterZipcode(zipCode,county,planYear);
			EstimateDrugCostPage getStartedPage = (EstimateDrugCostPage)vppSummary.navigateToSummaryPage(planType);
			pages.acquisition.bluelayer.AddDrugPage addDrugPage = (pages.acquisition.bluelayer.AddDrugPage)getStartedPage.navigateToDCE();

			if (addDrugPage != null) {
				getLoginScenario().saveBean("webDriver", wd);
				getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
						addDrugPage);
				Assert.assertTrue(true);
			} else {
				Assert.fail("unsuccessfull navigation to add drug page");
			}
	 }
			
			@And("^user selects the low cost options in UMS site$")
			public void user_selects_lowCost(DataTable drugAttributes) {
				String drugName = drugAttributes.getGherkinRows().get(0).getCells().get(0);
				SelectGenericPage selectGenericPage = (SelectGenericPage) getLoginScenario().getBean(PageConstants.SELECT_GENERIC_PAGE);
				
				/*
				 * TODO: CodeMonkeys Team: Please refer the Ulayer code to develop bluelayer code.
				 * 
				 * As of now passing making temporary changes to remove errors so that Ulayer code can be tested
				 * 
				 * 
				 * */
				
				
				
				/*
				 * START of code comment
				 * 
				 * 
				 * AddDrugPage addDrugPage = selectGenericPage.selectGeneric(drugName);
				if (addDrugPage != null) {
					getLoginScenario().saveBean(PageConstants.ADD_DRUG_PAGE,
							addDrugPage);
					Assert.assertTrue(true);
				} else {
					Assert.fail("generic drug selection unsuccessful");
				}
				
				*END of code comment
				*/
			}
			@And("^the user wants to add some more drug$")
			public void user_select_anotherdrug(){
				AddDrugPage addDrugPage = (AddDrugPage) getLoginScenario().getBean(
						PageConstants.ADD_DRUG_PAGE);
				addDrugPage.clickAddImage();
			}
}
