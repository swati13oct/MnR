package acceptancetests.memberredesign.expalnationofbenefits;

import gherkin.formatter.model.DataTableRow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import pages.regression.explanationofbenefits.DreamEOBPage;
import pages.regression.explanationofbenefits.EOBPage;
import pages.regression.explanationofbenefits.Eob;
import pages.regression.explanationofbenefits.EobApiResponse;
import pages.regression.testharness.TestHarness;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.regression.footer.*;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.claims.ClaimsSummaryPage;

public class EobStepDefinition {
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	public static Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}	


	/**
	 * This method is to validate the How to read Medical EOB link and Video link is working
	 */
	@Then("^the user validates Learn More how to read medical eob PDF$")
	public void the_user_validates_how_to_read_medical_eob_PDF() {
		String eobTypeData = (String) getLoginScenario().getBean(EobCommonConstants.EOB_TYPE);
		int eobCount=(Integer) getLoginScenario().getBean(EobCommonConstants.EOB_COUNT);

		if (eobCount>0) {
			EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
			if(eobTypeData.toLowerCase().contains("medical")) {
				eobPage.validateReadPDF();		 
			} else {
				eobPage.validateLearnMoreText();
			}
		} else {
			System.out.println("Skip step because there is 0 EOB");
		}
	}

	/**
	 * the method validates site leaving popup on EOB page
	 */
	@Then("^the user validates site leaving pop up after clicking Adobe link$")
	public void user_validates_site_leaving_poup(){
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateSiteLeaveingPopUP();
	}

	//note: added code to print test results note in jenkins report at the end of test for successful cases
	@cucumber.api.java.After
	public void testResultNote(Scenario scenario) { 
		if(null!=getLoginScenario().getBean(EobCommonConstants.TEST_RESULT_NOTE)) {   
			@SuppressWarnings("unchecked")   
			List<String> testNote=(List<String>) getLoginScenario()
			.getBean(EobCommonConstants.TEST_RESULT_NOTE);
			for (String s: testNote) {   
				scenario.write(s);
			}
			testNote.clear(); 
		}
	}

	/**
	 * the method validates the date range functionality on EOB page
	 */	
	@SuppressWarnings("unchecked")
	@And("^the user selects the desired date range$")
	public void user_selects_date_range(DataTable givenAttributes){
		Map<String, String> memberAttributesMap=parseInputArguments(givenAttributes);
		String dateRange = memberAttributesMap.get("Date Range");
		getLoginScenario().saveBean(EobCommonConstants.DATE_RANGE, dateRange);
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		String eobTypeData=(String) getLoginScenario().getBean(EobCommonConstants.EOB_TYPE);

		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		HashMap<String, Integer> searchResultMap=eobPage.selectDateRange(planType,memberType, dateRange, eobTypeData);
		getLoginScenario().saveBean(EobCommonConstants.EOB_COUNT, searchResultMap.get(dateRange));
		//note: store info to display at end of test
		List<String> searchNote=(List<String>) getLoginScenario()
				.getBean(EobCommonConstants.TEST_RESULT_NOTE);
		if (searchNote==null) {
			searchNote=new ArrayList<String>();
			searchNote.add("----- TEST NOTE ------------------------------");
			String tmp=(String) getLoginScenario().getBean(EobCommonConstants.EOB_TYPE);
			if (tmp==null) 
				searchNote.add("DREAM EOB");
			else
				searchNote.add("EOB TYPE="+tmp);
		}
		searchNote.add("Date range='"+dateRange+"' has EOB count="+searchResultMap.get(dateRange));
		getLoginScenario().saveBean(EobCommonConstants.TEST_RESULT_NOTE,searchNote);

		//note: track the eob count for each search range for later validation
		HashMap<String, Integer> eobCountMap=(HashMap<String, Integer>) getLoginScenario().getBean(EobCommonConstants.EOB_COUNT_MAP);
		if (eobCountMap==null) {
			eobCountMap=new HashMap<String, Integer>();
		}
		eobCountMap.putAll(searchResultMap);
		System.out.println("TEST - back from search: hashMap="+Arrays.asList(eobCountMap)); 
		getLoginScenario().saveBean(EobCommonConstants.EOB_COUNT_MAP, eobCountMap);
		getLoginScenario().saveBean(EobCommonConstants.TESTAPI, false);
	}

	@Then("^the user obtains API response info for validation$")
	public void getApiResponse() {
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		String eobTypeData = (String) getLoginScenario().getBean(EobCommonConstants.EOB_TYPE);
		
		String eobType="";
		String apiResponseJson="";
		if (eobTypeData==null) {
			eobType="dream";
			//note: there are two requests for dream, need to fix up the string
			List<String> tmpResponsJson=eobPage.getApiRequestUrl(planType, memberType, eobType);
			String m_requestUrl=tmpResponsJson.get(0);
			System.out.println("TEST - m_requestUrl="+m_requestUrl);
			String m_apiResponseJson=eobPage.getApiResponse(planType, memberType, m_requestUrl);
			EobApiResponse eobResponseObj=eobPage.parseApiResponse(m_apiResponseJson);
			Assert.assertTrue("PROBLEM - unable to get a successful API response for further testing. resp1="+m_apiResponseJson, eobResponseObj!=null);
			System.out.println("Before cleanup, 1st call size="+eobResponseObj.getListOfEob().size());

			EobApiResponse r_eobResponseObj=new EobApiResponse();
			if (!planType.equals("MA")) {
				String r_requestUrl=tmpResponsJson.get(1);
				System.out.println("TEST - r_requestUrl="+r_requestUrl);
				String r_apiResponseJson=eobPage.getApiResponse(planType, memberType, r_requestUrl);
				r_eobResponseObj=eobPage.parseApiResponse(r_apiResponseJson);
				Assert.assertTrue("PROBLEM - unable to get a successful API response for further testing. resp2="+r_apiResponseJson, r_eobResponseObj!=null);
				System.out.println("Before cleanup, 2nd call size="+r_eobResponseObj.getListOfEob().size());
			}
			//note: remove duplicated compoundDoc
			List<Eob> uniqueEobList=new ArrayList<Eob>();
			if (eobResponseObj.getListOfEob().size()>0) {
				uniqueEobList.add(eobResponseObj.getListOfEob().get(0));
				for(int i=1; i<eobResponseObj.getListOfEob().size(); i++) {
					boolean found=false;
					System.out.println("TEST - 1 - check to see if compoundDoc='"+eobResponseObj.getListOfEob().get(i).getCompoundDoc()+"' has been added to the list yet");
					for(int k=0; k<uniqueEobList.size(); k++) {
						if (eobResponseObj.getListOfEob().get(i).getCompoundDoc().equals(uniqueEobList.get(k).getCompoundDoc())) {
							found=true;
							System.out.println("TEST - already added, skip");
							break;
						}
					}
					if (!found) {
						System.out.println("TEST - not yet added, add it");
						uniqueEobList.add(eobResponseObj.getListOfEob().get(i));
					}
				}
			}
			for(int i=0; i<r_eobResponseObj.getListOfEob().size(); i++) {
				boolean found=false;
				System.out.println("TEST - 2 - check to see if compoundDoc='"+r_eobResponseObj.getListOfEob().get(i).getCompoundDoc()+"' has been added to the list yet");
				for(int k=0; k<uniqueEobList.size(); k++) {
					if (r_eobResponseObj.getListOfEob().get(i).getCompoundDoc().equals(uniqueEobList.get(k).getCompoundDoc())) {
						found=true;
						System.out.println("TEST - already added, skip");
						break;
					}
				}
				if (!found) {
					System.out.println("TEST - not yet added, add it");
					uniqueEobList.add(r_eobResponseObj.getListOfEob().get(i));
				}
			}
			
			
			System.out.println("After cleaning up the duplicates...");
			for (Eob e: uniqueEobList) {
				e.printDetail();
			}
			System.out.println("--------------------------------...");
			//note: merge the two into one
			
			EobApiResponse UniqueEobResponseObj= new EobApiResponse();
			UniqueEobResponseObj.setErrorCode(eobResponseObj.getErrorCode());
			UniqueEobResponseObj.setSuccess(eobResponseObj.isSuccess());
			UniqueEobResponseObj.setListOfEob(uniqueEobList);
			
			UniqueEobResponseObj.sortListOfEobLatestFirst();
			getLoginScenario().saveBean(EobCommonConstants.API_EOB_RESPONSE, UniqueEobResponseObj);
			
		} else {
			eobType=eobTypeData;
			apiResponseJson=eobPage.getInfoFromApi(planType, memberType, eobType);

			EobApiResponse eobResponseObj=eobPage.parseApiResponse(apiResponseJson);
			Assert.assertTrue("PROBLEM - unable to parse API response successfully for further testing. apiResponseJson="+apiResponseJson, eobResponseObj!=null);
			getLoginScenario().saveBean(EobCommonConstants.API_EOB_RESPONSE, eobResponseObj);
		}
		
		
		boolean isComboUser=false;
		if (memberType.toUpperCase().contains("COMBO")) 
			isComboUser=true;
		String memberId=eobPage.getMemberId(isComboUser, planType);
		getLoginScenario().saveBean(EobCommonConstants.MEMBERID, memberId);
		getLoginScenario().saveBean(EobCommonConstants.TESTAPI, true);
	}
	
	
	@SuppressWarnings("unchecked")
	@Then("^the user validates the eob count for all available search ranges$") 
	public void validateEobCountForAllSearchRanges(DataTable givenAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(givenAttributes);
		String flagZeoEob_str = memberAttributesMap.get("Flag Zero EOB User");
		Assert.assertTrue("PROBLEM - 'Flag Zero EOB User' input should either be 'true' or 'false' | Actual='"+flagZeoEob_str+"'", 
				flagZeoEob_str.equalsIgnoreCase("true")|| flagZeoEob_str.equalsIgnoreCase("false")); 
		boolean flagZeoEob=Boolean.valueOf(flagZeoEob_str);

		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		HashMap<String, Integer> eobCountMap=(HashMap<String, Integer>) getLoginScenario().getBean(EobCommonConstants.EOB_COUNT_MAP);
		System.out.println("TEST - FINAL : hashMap="+Arrays.asList(eobCountMap)); 

		if (planType.contains("SHIP")) {
			int last90Days=eobCountMap.get("Last 90 Days");
			int last3_6months=eobCountMap.get("Last 3-6 months");
			int last6_12months=eobCountMap.get("Last 6-12 months");
			int last12_18months=eobCountMap.get("Last 12-18 months");

			if (flagZeoEob) { 
				Assert.assertTrue("PROBLEM - this test user has no EOB on any Search Range, while the UI validation is completed, it may not be able to validate all coverage", 
						(last90Days>0)	|| (last3_6months>0)
						|| (last6_12months>0) 
						|| (last12_18months>0));
			} else {
				System.out.println("TEST - flagZeoEob=false - this test user has no EOB on any Search Range, while the UI validation is completed, it may not be able to validate all coverage");
			}

		} else {
			int last90Days=eobCountMap.get("Last 90 Days");
			int last6months=eobCountMap.get("Last 6 months");
			int last12months=eobCountMap.get("Last 12 months");
			int last18months=eobCountMap.get("Last 18 months");
			int customSearch=eobCountMap.get("Custom Search");

			if (flagZeoEob) { 
				Assert.assertTrue("PROBLEM - this test user has no EOB on any Search Range, while the UI validation is completed, it may not be able to validate all coverage", 
						(last90Days>0)	|| (last6months>0)
						|| (last12months>0) || (last18months>0)
						|| (customSearch>0));
			} else {
				System.out.println("TEST - flagZeoEob=false - this test user has no EOB on any Search Range, while the UI validation is completed, it may not be able to validate all coverage");
			}
			Assert.assertTrue("PROBLEM - EOB count for 'last90Days' result should be less than or equal to 'last6months' result.  "
					+ "Actual: last90Days='"+last90Days+"' | last6months='"+last6months+"'", 
					(last90Days<=last6months));

			Assert.assertTrue("PROBLEM - EOB count for 'last6months' result should be less than or equal to 'last12months' result.  "
					+ "Actual: last6months='"+last6months+"' | last12months='"+last12months+"'", 
					(last6months<=last12months));

			Assert.assertTrue("PROBLEM - EOB count for 'last12months' result should be less than or equal to 'last18months' result.  "
					+ "Actual: last12months='"+last12months+"' | last18months='"+last18months+"'", 
					(last12months<=last18months));

			Assert.assertTrue("PROBLEM - EOB count for 'customSearch' result should be less than or equal to 'last18months' result.  "
					+ "Actual: customSearch='"+customSearch+"' | last18months='"+last18months+"'", 
					(customSearch<=last18months));
		}
	}

	@When("^the user selects Custom Search with blank From and To Date values$")
	public void user_selects_date_range_invalidCustSearch_blankDates(){
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.doInvalidCustomSearchBlankDate();
	}

	@Then("^the user validates blank Date errors$")
	public void validate_date_range_invalidCustSearch_blankDates_error(){
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateBlankDateFieldError();
	}

	@When("^the user selects Custom Search with future date for From and To Date values$")
	public void user_selects_date_range_invalidCustSearch_futureDates(){
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.doInvalidCustomSearchFutureDate();
	}

	@Then("^the user validates future Date errors$")
	public void validate_date_range_invalidCustSearch_futureDates_error(){
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateFutureDateError();
	}

	@When("^the user selects Custom Search with To Date older From Date values$")
	public void user_selects_date_range_invalidCustSearch_ToOlderThanFrom(){
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.doInvalidCustomSearchToDateOlderThanFromDate();
	}

	@Then("^the user validates To Date older than From Date errors$")
	public void validate_date_range_invalidCustSearch_ToOlderThanFrom_error(){
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateToDateOlderThanFromDateError();
	}

	@When("^the user selects Custom Search with Date Range greater than 18 months")
	public void user_selects_date_range_invalidCustSearch_rangeGreaterThanEighteenMonths(){
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.doInvalidCustomSearchRangeGreaterThanEighteenMonths();
	}

	@Then("^the user validates greater than 18 months error$")
	public void validate_date_range_invalidCustSearch_rangeGreaterThanEighteenMonths_error(){
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateRangeGreaterThanEighteenMonthsError();
	}

	@Then("^the user validates the header section content$")
	public void validate_headerSection() {
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateHeaderSectionContent(planType);
		//note: if multiple plans of the same planType, no tab will be shown
		eobPage.validateComboTab(memberType);
	}
	
	@Then("^the user validates the header section content on DREAM EOB$")
	public void validate_headerSection_DREAMEOB() {
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateHeaderSectionContent_DREAMEOB(planType);
	}

	@Then("^the user validates the right rail section content$")
	public void validate_rightRail() {
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		int ui_eobResultCount=eobPage.getNumEobAfterSearch_dream();
		getLoginScenario().saveBean(EobCommonConstants.UI_EOB_COUNT, ui_eobResultCount);
		eobPage.validateRightRail_DREAMEOB(planType, memberType, ui_eobResultCount);
	}

	@Then("^the user validate sub option EXPLANATION OF BENEFITS under Claims option$")
	public void validate_sspContent() {
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		if(memberType.contains("GROUP"))
			Assert.assertTrue("PROBLEM - SSP Group user should be able to see the EOB sub tab on top menu for Claims option", eobPage.findEobOptionUnderClaims()); 
		else
			Assert.assertTrue("PROBLEM - SSP Individual user should NOT be able to see the EOB sub tab on top menu for Claims option", !eobPage.findEobOptionUnderClaims()); 
		//keep  eobPage.validateSspContent();
	}

	@Then("^the user validates the eob page content for PHIP$")
	public void validate_phipContent() {
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validatePhipContent();
	}
	
	@Then("^the user validates Need Help section$")
	public void validateNeedHelpSection() throws InterruptedException{ 
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);

		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateNeedHelpSection(planType, memberType);
	}

	@And("^the user selects the eob type$")
	public void user_selects_eobType(DataTable givenAttributes){
		Map<String, String> memberAttributesMap=parseInputArguments(givenAttributes);
		String eobTypeData   = memberAttributesMap.get("EOB Type");
		getLoginScenario().saveBean(EobCommonConstants.EOB_TYPE, eobTypeData);
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.selectEobType(planType, eobTypeData);
	}	


	/**
	 * the method validates the content displayed on EOB page
	 */
	@Then("^the user validates content displayed on EOB page without EOB type dropdown$")
	public void user_validates_content_displayed_on_EOB_page_without_combo_tabs(){
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateEobTypeDropDowns(planType);
	}

	@Then("^the user validates search result section content$")
	public void user_validate_searchResult() {
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		String eobTypeData = (String) getLoginScenario().getBean(EobCommonConstants.EOB_TYPE);
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		int ui_eobResultCount=eobPage.getNumEobAfterSearch();
		getLoginScenario().saveBean(EobCommonConstants.UI_EOB_COUNT, ui_eobResultCount);

		if (ui_eobResultCount>0) {
			EobApiResponse eobApiResponse=(EobApiResponse) getLoginScenario().getBean(EobCommonConstants.API_EOB_RESPONSE);
			eobPage.validateTextElements(planType, memberType, eobTypeData);
			eobPage.validateEOBStatements(ui_eobResultCount, eobApiResponse);
		} else {
			System.out.println("TEST - EOB has no EOB for this search period, skip the text validation");
		} 
	}
	
	@Then("^the user validates EOB count between API and UI are the same$")
	public void user_validate_api_ui_count_match() {
		int eobResultCount= (Integer) getLoginScenario().getBean(EobCommonConstants.UI_EOB_COUNT);
		boolean testApiFlag=(Boolean) getLoginScenario().getBean(EobCommonConstants.TESTAPI);
		Assert.assertTrue("PROBLEM - should not run this step if you are not running 'Then the user obtains API response info for validation' step...", testApiFlag);
		EobApiResponse eobApiResponse=(EobApiResponse) getLoginScenario().getBean(EobCommonConstants.API_EOB_RESPONSE);
		int eobCountFromApi=eobApiResponse.getNumEobs();
		Assert.assertTrue("PROBLEM - number of EOB count is not the same between API and UI.  UI has '"+eobResultCount+"' | API has '"+eobCountFromApi+"' ", eobResultCount==eobCountFromApi);
	}
	
	
	@SuppressWarnings("unchecked")
	@Then("^the user validates search result section content for DREAM EOB$")
	public void user_validate_searchResult_dream() {
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		boolean testApiFlag=(Boolean) getLoginScenario().getBean(EobCommonConstants.TESTAPI);
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		int ui_eobResultCount=eobPage.getNumEobAfterSearch_dream();
		getLoginScenario().saveBean(EobCommonConstants.UI_EOB_COUNT, ui_eobResultCount);

		if (ui_eobResultCount>0) {
			EobApiResponse eobApiResponse=(EobApiResponse) getLoginScenario().getBean(EobCommonConstants.API_EOB_RESPONSE);
			eobPage.validateSearchResultTableHeader_DREAMEOB();
			eobPage.validateContactUsStmt_DREAMEOB(planType);
			List<String> testNote=eobPage.validateEOBStatements_dream(ui_eobResultCount, eobApiResponse, testApiFlag);
			List<String> existingNote=(List<String>) getLoginScenario().getBean(EobCommonConstants.TEST_RESULT_NOTE);
			existingNote.addAll(testNote);
			getLoginScenario().saveBean(EobCommonConstants.TEST_RESULT_NOTE,existingNote);
		} else {
			System.out.println("TEST - EOB has no EOB for this search period, skip the text validation");
		}
	}

	@And("^the user clicks on first eob from the list to validate pdf$")
	public void the_user_clicks_on_first_eob_from_the_list() {
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberId=(String) getLoginScenario().getBean(EobCommonConstants.MEMBERID);
		int eobCount=(Integer) getLoginScenario().getBean(EobCommonConstants.EOB_COUNT);
		if (eobCount>0) {
			EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
			eobPage.validateEobEntries(planType, memberId);
		} else {
			System.out.println("Skip step because there is 0 EOB");
		}
	}

	@SuppressWarnings("unchecked")
	@And("^the user clicks on each eob on first page to validate pdf for DREAM EOB$")
	public void the_user_clicks_on_first_eob_from_the_list_dream() {
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberId=(String) getLoginScenario().getBean(EobCommonConstants.MEMBERID);
		boolean testApiFlag=(Boolean) getLoginScenario().getBean(EobCommonConstants.TESTAPI);
		int eobCount=(Integer) getLoginScenario().getBean(EobCommonConstants.EOB_COUNT);
		if (eobCount>0) {
			EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
			List<String> testNote=eobPage.validateEobEntries_dream(planType, memberId, testApiFlag, eobCount);
			List<String> existingNote=(List<String>) getLoginScenario().getBean(EobCommonConstants.TEST_RESULT_NOTE);
			existingNote.addAll(testNote);
			getLoginScenario().saveBean(EobCommonConstants.TEST_RESULT_NOTE,existingNote);
		} else {
			System.out.println("Skip step because there is 0 EOB");
		}
	}
	
	@Then("^the user navigates to EOB page$")
	public void user_views_EOBpagehsid() throws InterruptedException {   
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		System.out.println("****the user navigates to EOB page****");
		pages.regression.explanationofbenefits.EOBPage eobPage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			eobPage = testHarness.navigateDirectToEOBPag();
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			eobPage = accountHomePage.navigateDirectToEOBPag();
		}

		Assert.assertTrue("PROBLEM - EOB Page is not Displayed", eobPage!=null);
		if (memberType.contains("COMBO")) 
			eobPage.goToSpecificComboTab(planType);
		getLoginScenario().saveBean(PageConstants.EOB_Page, eobPage);
		FooterPage footerPage=new FooterPage(eobPage.driver);
		getLoginScenario().saveBean(PageConstants.footer_page,footerPage);
		System.out.println("user is on the EOB page"); 
		eobPage.waitForEobPageToLoad();
	}

	@Then("^the user validate Spending Cost Summary tab on top sub menu$")
	public void user_validate_spendingCostSummaryTab(DataTable givenAttributes) throws InterruptedException {   
		Map<String, String> memberAttributesMap=parseInputArguments(givenAttributes);
		String fromPage = memberAttributesMap.get("From Page");
		if (MRScenario.environment.contains("team-a") && fromPage.equalsIgnoreCase("claims")) {
			System.out.println("team env doesn't support Rally claims, skipping this step...");
			return;
		}
		String expectTabStr = memberAttributesMap.get("Expect Tab");
		Assert.assertTrue("PROBLEM - input value for 'Expect Tab' in feature file should either be true or false.  Actual='"+expectTabStr+"'",expectTabStr.equalsIgnoreCase("true") || expectTabStr.equalsIgnoreCase("false"));
		boolean expectTab=Boolean.valueOf(expectTabStr);
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateSpendingCostSummaryTab(expectTab);
	}

	@Then("^the user validate MyClaims top menu sub option$")
	public void validateMyClaimsTopMenuOption() {
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateMyClaimsTopSubMenu();
		
	}
	
	@Then("the user click MyClaims top menu sub option")
	public void clickMyClaimsTopMenuOption() {
		if (MRScenario.environment.contains("team-a")) {
			System.out.println("team env doesn't support Rally claims, skipping this step...");
			return;
		}
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		ClaimsSummaryPage claimsSummaryPage=eobPage.clickMyClaimsTopSubMenu();
		Assert.assertTrue("PROBLEM - unable to navigate to MyClaims page from EOB page using top sub menu MyClaims", claimsSummaryPage!=null);
		getLoginScenario().saveBean(PageConstantsMnR.NEW_CLAIMS_SUMMARY_PAGE, claimsSummaryPage);
		getLoginScenario().saveBean(PageConstantsMnR.CLAIM_SUMMARY_PAGE, claimsSummaryPage);
	}

	//--------------------------------------------------------------
	/**
	 * DREAM EOB Step Definition
	 */

	@Then("^the user navigates to Dream EOB Page$")
	public void user_views_dream_EOB() throws InterruptedException {   
		System.out.println("****the user navigates to EOB page_hsid****");
		DreamEOBPage DreameobPage;
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			TestHarness testHarness = (TestHarness) getLoginScenario()
					.getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			DreameobPage = testHarness.navigateDirectToDreamEOBPag();
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario()
					.getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			DreameobPage = accountHomePage.navigateDirectToDreamEOBPag();
		}

		if (DreameobPage!=null){
			getLoginScenario().saveBean(PageConstants.EOB_Page, DreameobPage);
			System.out.println("user is on the EOB page"); 
		}     
		else
			Assert.assertTrue("Issue : EOB Page is not Displayed", DreameobPage!=null);
	}


	@Then("^the user validates EOB type dropdown is not displayed on Dream EOB page$")
	public void the_user_validates_EOB_type_dropdown_is_not_displayed_on_Dream_EOB_page() throws Throwable {
		DreamEOBPage eobPage = (DreamEOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validate_EOBdropDownNotDisplayed();
	}

	@Then("^the user validates Learn More Link and section on Dream EOB Page$")
	public void the_user_validates_Learn_More_Link_and_section_on_Dream_EOB_Page() throws Throwable {
		DreamEOBPage eobPage = (DreamEOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validate_LearnMoreSection();

	}

	@Then("^the user validates the EOB table for Medical only EOBs$")
	public void the_user_validates_the_EOB_table_for_Medical_only_EOBs() throws Throwable {
		DreamEOBPage eobPage = (DreamEOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validate_MedicalOnlyEOB();

	}

	@Then("^the user validates the EOB table for Rx only EOBs$")
	public void the_user_validates_the_EOB_table_for_Rx_only_EOBs() throws Throwable {
		DreamEOBPage eobPage = (DreamEOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validate_RxOnlyEOB();

	}

	@Then("^the user validates the date range dropdown$")
	public void the_user_valiudates_the_date_range_dropdown() throws Throwable {
		DreamEOBPage eobPage = (DreamEOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateDateRangeDropDowns();

	}

	@Then("^the user selects the desired date range on Dream EOB Page$")
	public void the_user_slects_the_desired_date_range_on_Dream_EOB_Page(DataTable arg1) throws Throwable {
		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		List<DataTableRow> memberAttributesRow = arg1.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String dateRange = memberAttributesMap.get("Date Range");
		eobPage.selectDateRange_dream(dateRange);
		//note: default will not validate w/ API info unless the step to get API response is executed
		getLoginScenario().saveBean(EobCommonConstants.TESTAPI, false);
	}


	@Then("^the user selects the desired eob type on Dream EOB Page$")
	public void the_user_slects_the_desired_eobType_on_Dream_EOB_Page(DataTable arg1) throws Throwable {
		EOBPage eobPage = (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		List<DataTableRow> memberAttributesRow = arg1.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));
		}

		String dateRange = memberAttributesMap.get("Date Range");
		eobPage.selectDateRange_dream(dateRange);
	}

	@Then("^the user validates EOB count on Dream EOB Page$")
	public void the_user_validates_EOB_count_on_Dream_EOB_Page(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> memberAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> memberAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {

			memberAttributesMap.put(memberAttributesRow.get(i).getCells()
					.get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		String eobCount = memberAttributesMap.get("EOB COUNT");
		EOBPage eobPage =  (EOBPage) getLoginScenario().getBean(PageConstants.EOB_Page);
		eobPage.validateEOBStatements_dream(eobCount);
	}

	@Then("^the user validates EOB PDF size is not (\\d+)kb on Dream EOB Page$")
	public void the_user_validates_EOB_PDF_size_is_not_kb_on_Dream_EOB_Page(int arg1) throws Throwable {
	}

}

