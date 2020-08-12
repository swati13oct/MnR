package acceptancetests.memberredesign.planDocumentsAndResources;

import gherkin.formatter.model.DataTableRow;
import pages.regression.accounthomepage.AccountHomePage;
import pages.regression.planDocumentsAndResources.PlanDocApiResponse;
import pages.regression.planDocumentsAndResources.PlanDocumentsAndResourcesFnRDocsHelper;
import pages.regression.planDocumentsAndResources.PlanDocumentsAndResourcesPage;
import pages.regression.planDocumentsAndResources.PlanDocumentsAndResourcesUsersHelper;
import pages.regression.planDocumentsAndResources.PlanDocumentsAndResourcesUsersHelperProd;
import pages.regression.testharness.TestHarness;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import atdd.framework.*;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

/**
 * @Functionality : Plan Documents and Resources page step definition for validation
 */
public class PlanDocumentsAndResourcesStepDefinition {

	//note: if enabling this, you must run 'documents are able to load successfully' step in the scenario
	//note: if input given, input will be used  - step: I want to customize test setup
	//note: default will be false if no input given - step: user navigates to plan documents and resources page validation
	boolean validateApi;
	//note: global bypass the click link and validate destination URL check to speed things up if needed for debug
	//note: if input given, input will be used  - step: I want to customize test setup
	//note: default will be false if no input given - step: user navigates to plan documents and resources page validation
	boolean skipLnkDestCheck;

	PlanDocumentsAndResourcesFnRDocsHelper docHelper_FnR=new PlanDocumentsAndResourcesFnRDocsHelper();
	PlanDocumentsAndResourcesUsersHelper userHelper=new PlanDocumentsAndResourcesUsersHelper();
	PlanDocumentsAndResourcesUsersHelperProd userHelperProd=new PlanDocumentsAndResourcesUsersHelperProd();

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	//note: added code to print test results note in jenkins report at the end of test for successful cases
	@cucumber.api.java.After
	public void testResultNote(Scenario scenario) { 
		if(null!=getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE)) {   
			@SuppressWarnings("unchecked")   
			List<String> testNote=(List<String>) getLoginScenario()
			.getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
			for (String s: testNote) {   
				scenario.write(s);
			}
			testNote.clear(); 
		}
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
	 * NOTE: use this step to customize the test if neeed
	 * If Validate API = false, it will skip the validation between API response and the attributes in the UI elements
	 * If Skip Link Destination Validation = true, it will skip the click and check actual link vs target destination validation
	 *     And I want to customize test setup
	 *       | Validate API                     | true |
	 *       | Skip Link Destination Validation | true |
	 * @param memberAttributes
	 */
	@And("^I want to customize test setup$")
	public void customTestSetup(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		validateApi=Boolean.valueOf(memberAttributesMap.get("Validate API"));
		skipLnkDestCheck=Boolean.valueOf(memberAttributesMap.get("Skip Click and Check Link Destination URL Validation"));
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_VALIDATE_API, validateApi);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_SKIP_LINK_DEST_CHECK, skipLnkDestCheck);
		//System.out.println("TEST - at setup - customizing with validateApi='"+validateApi+"' | skipLnkDestCheck="+skipLnkDestCheck);
	}

	@And("^user navigates to plan documents and resources page validation$")
	public void navigateToPlanAndResourcePageForSegementId(DataTable memberAttributes) throws InterruptedException {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		//note: control the default test setup if no input specified
		this.validateApi=false;
		this.skipLnkDestCheck=false; 
		Boolean v=(Boolean) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_VALIDATE_API);
		if (v!=null)
			this.validateApi=v;
		Boolean s=(Boolean) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_SKIP_LINK_DEST_CHECK);
		if (s!=null)
			this.skipLnkDestCheck=s;
		//System.out.println("TEST - at navigation -  customizing with validateApi='"+validateApi+"' | skipLnkDestCheck="+skipLnkDestCheck);

		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType=memberAttributesMap.get("Plan Type");
		String memberType=memberAttributesMap.get("Member Type");
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE, planType);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE, memberType);

		HashMap<String, String> testInputInfoMap=new HashMap<String, String>();
		testInputInfoMap.put("planType", planType);
		testInputInfoMap.put("memberType", memberType);
		testInputInfoMap.put("skipLnkDestCheck", String.valueOf(skipLnkDestCheck));
		int forceTimeoutInMin=5;
		System.out.println("Proceeed to Plan Documents & Resources page");
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=null;
		if (("YES".equalsIgnoreCase(MRScenario.isTestHarness))) {
			TestHarness testharnessHomepage = (TestHarness) getLoginScenario().getBean(PageConstantsMnR.TEST_HARNESS_PAGE);
			planDocumentsAndResourcesPage = testharnessHomepage.navigateDirectToPlanDocPage(forceTimeoutInMin);
			testInputInfoMap.put("runOnTestharnessEnv", "true");
		} else {
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			planDocumentsAndResourcesPage = accountHomePage.navigateDirectToPlanDocPage(memberType,planType, forceTimeoutInMin);
			testInputInfoMap.put("runOnTestharnessEnv", "false");
		}
		Assert.assertTrue("PROBLEM - unable to navigate to Plan Documents and Resources page", planDocumentsAndResourcesPage!=null);
		if (memberType.toUpperCase().contains("COMBO")) 
			planDocumentsAndResourcesPage.goToSpecificComboTab(planType);
		else
			planDocumentsAndResourcesPage.goToSpecificComboTab(planType, false);
		int currentYear=0;
		if (MRScenario.environment.equalsIgnoreCase("prod") || MRScenario.environment.equalsIgnoreCase("offline")) {
			currentYear = Calendar.getInstance().get(Calendar.YEAR);
		} else {
			currentYear=Integer.parseInt(planDocumentsAndResourcesPage.getCurrentYear());
		}
		int nextYear=currentYear+1;
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_CURRENT_YEAR, String.valueOf(currentYear));
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_NEXT_YEAR, String.valueOf(nextYear));
		HashMap<String, String> yearsMap=new HashMap<String, String>();
		yearsMap.put("currentYear", String.valueOf(currentYear));
		yearsMap.put("nextYear", String.valueOf(nextYear));
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_YEARS_MAP, yearsMap);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO,testInputInfoMap);
		planDocumentsAndResourcesPage.sleepBySec(15);
		getLoginScenario().saveBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE,planDocumentsAndResourcesPage);
	}

	@SuppressWarnings("unchecked")
	@And("^documents are able to load successfully$")
	public void documents_are_able_to_load_successfully() {
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);

		System.out.println("Proceed to get API response...");
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);

		String planDocAndResources_apiResponse_url=planDocumentsAndResourcesPage.getApiRequestUrl(testInputInfoMap);
		System.out.println("TEST - planDocAndResources_apiResponse_url="+planDocAndResources_apiResponse_url);

		String apiResponseStr=planDocumentsAndResourcesPage.getApiResponse(planType, memberType, planDocAndResources_apiResponse_url);
		System.out.println("TEST - apiResponseStr="+apiResponseStr);
		HashMap<String, String> yearsMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_YEARS_MAP);

		String currentYear = yearsMap.get("currentYear");
		String nextYear = yearsMap.get("nextYear");
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_YEARS_MAP, yearsMap);

		PlanDocApiResponse planDocMap=new PlanDocApiResponse(String.valueOf(currentYear), String.valueOf(nextYear));
		boolean apiSuccess=planDocMap.buildDocListMap(testInputInfoMap, apiResponseStr);
		Assert.assertTrue("PROBLEM - unable to get a successful API response", apiSuccess);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_ACTUAL_DOC_LIST_MAP, planDocMap);

		List<String> noteList=planDocMap.printPlanDocDetail();
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);

		List<String> result_testNote=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		for (String s: result_testNote) {
			System.out.println(s);
		}
		getLoginScenario().saveBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE,planDocumentsAndResourcesPage);
	}

	@SuppressWarnings("unchecked")
	@And("^user validates header section content for Plan Documents and Resources page$")
	public void validate_PlanDoc_header_section() {
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		String page="Plan Documents and Resources";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation UI result for page='"+page+"'");
		planDocumentsAndResourcesPage.validatePageHeaderSection();
		sectionNote.add("PASSED - page '"+page+"' header validation");
		planDocumentsAndResourcesPage.validatePageBackToTopLink();
		sectionNote.add("PASSED - page '"+page+"' 'Back To Top' link validation");
		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);
	}

	@SuppressWarnings("unchecked")
	@Then("^user validates jumplink and listing of mandatory documents for section Plan Materials$")
	public void validateSection_PM(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);

		String section="Plan Materials";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));
		boolean orderPlanMaterialsDisplay=Boolean.valueOf(memberAttributesMap.get("Order Plan Materials"));
		boolean viewMemberCardIdDisplay=Boolean.valueOf(memberAttributesMap.get("View Member Card ID"));
		boolean doc_en_curYr=Boolean.valueOf(memberAttributesMap.get("English Documents"));
		boolean doc_es_curYr=Boolean.valueOf(memberAttributesMap.get("Spanish Documents"));
		boolean doc_zh_curYr=Boolean.valueOf(memberAttributesMap.get("Chinese Documents"));

		if (!sectionDisplay) {
			if (doc_en_curYr || doc_es_curYr || doc_zh_curYr)
				Assert.assertTrue("PROBLEM - logic error with input setup, please check sceanrio input.  If sectionDisplay is false, any doc display doesn't make sense to have true", false);
		}
		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		HashMap<String, String> yearsMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_YEARS_MAP);
		PlanDocApiResponse api_planDocMap=(PlanDocApiResponse) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_ACTUAL_DOC_LIST_MAP);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);

		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);

		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_PM(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");

		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_PM(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		//note: validate order plan material link and image
		planDocumentsAndResourcesPage.valiateOrderPlanMaterialsLink_PM(testInputInfoMap, orderPlanMaterialsDisplay);
		sectionNote.add("PASSED - Order Plan Materials link validation");

		//note: validate view member ID card link and image
		planDocumentsAndResourcesPage.valiateViewMemberIdCard_PM(testInputInfoMap, viewMemberCardIdDisplay);
		sectionNote.add("PASSED - View Member ID Card link validation");

		//note: validate default language selection
		planDocumentsAndResourcesPage.validateDefaultLangSelect_PM(testInputInfoMap, sectionDisplay);
		sectionNote.add("PASSED - Default language dropdown validation");

		boolean finalCheck=true;
		String problemText="";
		if (sectionDisplay) {
			boolean checkDestUrl=false; //note: for this sect of doc, the href link in element is not the same as the one after clicked

			//-----------------------------------------
			sectionNote.add("----- Validation for English documents");
			boolean expDocDisplay=doc_en_curYr;
			String targetLang="EN";
			String targetYr=yearsMap.get("currentYear");
			String language="English";

			List<String> expDocList=new ArrayList<String>();
			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				expDocList=userHelperProd.getTargetDocList(planType, memberType, section, targetLang);
			else
				expDocList=userHelper.getTargetDocList(planType, memberType, section, targetLang);
			testInputInfoMap.put("section",section);
			testInputInfoMap.put("targetSubSection","currentYear");
			testInputInfoMap.put("targetLang",targetLang);
			testInputInfoMap.put("targetYr",targetYr);
			testInputInfoMap.put("checkDestUrl",String.valueOf(checkDestUrl));
			testInputInfoMap.put("expDocDisplay",String.valueOf(expDocDisplay));
			testInputInfoMap.put("validateApi",String.valueOf(validateApi));

			sectionNote=planDocumentsAndResourcesPage.validateDocOnUi(testInputInfoMap, expDocList, sectionNote, api_planDocMap);
			sectionNote.add("PASSED - "+language+" documents UI validation");
			if (sectionNote.get(0).contains("API VALIDATOIN PASSED")) {
				sectionNote.add("PASSED - "+language+" documents API validation");

			} else if (sectionNote.get(0).contains("API VALIDATOIN FAILED")) {
				sectionNote.add("FAILED - "+language+" documents API validation");
				finalCheck=false;
				problemText=problemText+"FAILED - "+language+" documents API validation | ";
			} 
			sectionNote.remove(0);	

			//-----------------------------------------
			sectionNote.add("----- Validation for Spanish documents");
			expDocDisplay=doc_es_curYr;
			targetLang="ES";
			targetYr=yearsMap.get("currentYear");
			language="Spanish";

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))  
				expDocList=userHelperProd.getTargetDocList(planType, memberType, section, targetLang);
			else
				expDocList=userHelper.getTargetDocList(planType, memberType, section, targetLang);
			testInputInfoMap.put("section",section);
			testInputInfoMap.put("targetSubSection","currentYear");
			testInputInfoMap.put("targetLang",targetLang);
			testInputInfoMap.put("targetYr",targetYr);
			testInputInfoMap.put("checkDestUrl",String.valueOf(checkDestUrl));
			testInputInfoMap.put("expDocDisplay",String.valueOf(expDocDisplay));
			testInputInfoMap.put("validateApi",String.valueOf(validateApi));

			sectionNote=planDocumentsAndResourcesPage.validateDocOnUi(testInputInfoMap, expDocList, sectionNote, api_planDocMap);
			sectionNote.add("PASSED - "+language+" documents UI validation");
			if (sectionNote.get(0).contains("API VALIDATOIN PASSED")) {
				sectionNote.add("PASSED - "+language+" documents API validation");

			} else if (sectionNote.get(0).contains("API VALIDATOIN FAILED")) {
				sectionNote.add("FAILED - "+language+" documents API validation");
				finalCheck=false;
				problemText=problemText+"FAILED - "+language+" documents API validation | ";
			} 
			sectionNote.remove(0);	

			//-----------------------------------------
			sectionNote.add("----- Validation for Chinese documents");
			expDocDisplay=doc_zh_curYr;
			targetLang="ZH";
			targetYr=yearsMap.get("currentYear");
			language="Chinese";

			expDocList=new ArrayList<String>();

			testInputInfoMap.put("section",section);
			testInputInfoMap.put("targetSubSection","currentYear");
			testInputInfoMap.put("targetLang",targetLang);
			testInputInfoMap.put("targetYr",targetYr);
			testInputInfoMap.put("checkDestUrl",String.valueOf(checkDestUrl));
			testInputInfoMap.put("expDocDisplay",String.valueOf(expDocDisplay));
			testInputInfoMap.put("validateApi",String.valueOf(validateApi));

			sectionNote=planDocumentsAndResourcesPage.validateDocOnUi(testInputInfoMap, expDocList, sectionNote, api_planDocMap);
			sectionNote.add("PASSED - "+language+" documents UI validation");
			if (sectionNote.get(0).contains("API VALIDATOIN PASSED")) {
				sectionNote.add("PASSED - "+language+" documents API validation");

			} else if (sectionNote.get(0).contains("API VALIDATOIN FAILED")) {
				sectionNote.add("FAILED - "+language+" documents API validation");
				finalCheck=false;
				problemText=problemText+"FAILED - "+language+" documents API validation | ";
			} 
			sectionNote.remove(0);	

			//note: validate footer section
			sectionNote.add("PASSED - footer validation");
			planDocumentsAndResourcesPage.validateFooter_PM(testInputInfoMap);
		}
		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);

		Assert.assertTrue("PROBLEM - "+problemText, finalCheck);
	}

	@SuppressWarnings("unchecked")
	@Then("^user sanity validates section Plan Materials$")
	public void validateSection_PM_sanity(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Plan Materials";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);

		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);

		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_PM(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");

		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_PM(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		//note: validate default language selection
		planDocumentsAndResourcesPage.validateDefaultLangSelect_PM(testInputInfoMap, sectionDisplay);
		sectionNote.add("PASSED - Default language dropdown validation");

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);
	}



	@SuppressWarnings("unchecked")
	@Then("^user validates jumplink and listing of mandatory documents for section Membership Materials or Welcome Guide$")
	public void validateSection_MM(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Membership Materials";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));
		boolean doc_en_curYr=Boolean.valueOf(memberAttributesMap.get("English Documents"));
		boolean doc_es_curYr=Boolean.valueOf(memberAttributesMap.get("Spanish Documents"));
		boolean doc_zh_curYr=Boolean.valueOf(memberAttributesMap.get("Chinese Documents"));

		if (!sectionDisplay) {
			if (doc_en_curYr || doc_es_curYr || doc_zh_curYr)
				Assert.assertTrue("PROBLEM - logic error with input setup, please check sceanrio input.  If sectionDisplay is false, any doc display doesn't make sense to have true", false);
		}
		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		HashMap<String, String> yearsMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_YEARS_MAP);
		PlanDocApiResponse api_planDocMap=(PlanDocApiResponse) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_ACTUAL_DOC_LIST_MAP);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);

		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_MM(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");

		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_MM(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		//note: validate default language selection
		planDocumentsAndResourcesPage.validateDefaultLangSelect_MM(sectionDisplay);

		boolean finalCheck=true;
		String problemText="";
		if (sectionDisplay) {

			boolean checkDestUrl=false; //note: for this sect of doc, the href link in element is not the same as the one after clicked

			//-----------------------------------------
			sectionNote.add("  ----- Validation for English documents");
			boolean expDocDisplay=doc_en_curYr;
			String targetLang="EN";
			String targetYr=yearsMap.get("currentYear");
			String language="English";

			List<String> expDocList=new ArrayList<String>();
			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))  
				expDocList=userHelperProd.getTargetDocList(planType, memberType, section, targetLang);
			else 
				expDocList=userHelper.getTargetDocList(planType, memberType, section, targetLang);

			testInputInfoMap.put("section",section);
			testInputInfoMap.put("targetSubSection","currentYear");
			testInputInfoMap.put("targetLang",targetLang);
			testInputInfoMap.put("targetYr",targetYr);
			testInputInfoMap.put("checkDestUrl",String.valueOf(checkDestUrl));
			testInputInfoMap.put("expDocDisplay",String.valueOf(expDocDisplay));
			testInputInfoMap.put("validateApi",String.valueOf(validateApi));

			sectionNote=planDocumentsAndResourcesPage.validateDocOnUi(testInputInfoMap, expDocList, sectionNote, api_planDocMap);
			sectionNote.add("PASSED - "+language+" documents UI validation");
			if (sectionNote.get(0).contains("API VALIDATOIN PASSED")) {
				sectionNote.add("PASSED - "+language+" documents API validation");

			} else if (sectionNote.get(0).contains("API VALIDATOIN FAILED")) {
				sectionNote.add("FAILED - "+language+" documents API validation");
				finalCheck=false;
				problemText=problemText+"FAILED - "+language+" documents API validation | ";
			} 
			sectionNote.remove(0);	

			//-----------------------------------------
			sectionNote.add("  ----- Validation for Spanish documents");
			expDocDisplay=doc_es_curYr;
			targetLang="ES";
			targetYr=yearsMap.get("currentYear");
			language="Spanish";

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod"))  
				expDocList=userHelperProd.getTargetDocList(planType, memberType, section, targetLang);
			else
				expDocList=userHelper.getTargetDocList(planType, memberType, section, targetLang);
			testInputInfoMap.put("section",section);
			testInputInfoMap.put("targetSubSection","currentYear");
			testInputInfoMap.put("targetLang",targetLang);
			testInputInfoMap.put("targetYr",targetYr);
			testInputInfoMap.put("checkDestUrl",String.valueOf(checkDestUrl));
			testInputInfoMap.put("expDocDisplay",String.valueOf(expDocDisplay));
			testInputInfoMap.put("validateApi",String.valueOf(validateApi));

			sectionNote=planDocumentsAndResourcesPage.validateDocOnUi(testInputInfoMap, expDocList, sectionNote, api_planDocMap);
			sectionNote.add("PASSED - "+language+" documents UI validation");
			if (sectionNote.get(0).contains("API VALIDATOIN PASSED")) {
				sectionNote.add("PASSED - "+language+" documents API validation");

			} else if (sectionNote.get(0).contains("API VALIDATOIN FAILED")) {
				sectionNote.add("FAILED - "+language+" documents API validation");
				finalCheck=false;
				problemText=problemText+"FAILED - "+language+" documents API validation | ";
			} 
			sectionNote.remove(0);	

			//-----------------------------------------
			sectionNote.add("  ----- Validation for Chinese documents");
			expDocDisplay=doc_zh_curYr;
			targetLang="ZH";
			targetYr=yearsMap.get("currentYear");
			language="Chinese";

			expDocList=new ArrayList<String>();

			testInputInfoMap.put("section",section);
			testInputInfoMap.put("targetLang",targetLang);
			testInputInfoMap.put("targetSubSection","currentYear");
			testInputInfoMap.put("targetYr",targetYr);
			testInputInfoMap.put("checkDestUrl",String.valueOf(checkDestUrl));
			testInputInfoMap.put("expDocDisplay",String.valueOf(expDocDisplay));
			testInputInfoMap.put("validateApi",String.valueOf(validateApi));

			sectionNote=planDocumentsAndResourcesPage.validateDocOnUi(testInputInfoMap, expDocList, sectionNote, api_planDocMap);
			sectionNote.add("PASSED - "+language+" documents UI validation");
			if (sectionNote.get(0).contains("API VALIDATOIN PASSED")) {
				sectionNote.add("PASSED - "+language+" documents API validation");

			} else if (sectionNote.get(0).contains("API VALIDATOIN FAILED")) {
				sectionNote.add("FAILED - "+language+" documents API validation");
				finalCheck=false;
				problemText=problemText+"FAILED - "+language+" documents API validation | ";
			} 
			sectionNote.remove(0);	
		}

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);		

		Assert.assertTrue("PROBLEM - "+problemText, finalCheck);
	}

	@SuppressWarnings("unchecked")
	@Then("^user sanity validates section Membership Materials or Welcome Guide$")
	public void validateSection_MM_sanity(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Membership Materials";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);

		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_MM(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");

		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_MM(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		//note: validate default language selection
		planDocumentsAndResourcesPage.validateDefaultLangSelect_MM(sectionDisplay);

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);		

	}

	@SuppressWarnings("unchecked")
	@Then("^user validates jumplink and listing of mandatory documents for section Annual Notice of Changes Documents$")
	public void validateSection_ANOC(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Annual Notice of Changes Documents";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));
		boolean doc_en_curYr=Boolean.valueOf(memberAttributesMap.get("English Current Year"));
		boolean doc_es_curYr=Boolean.valueOf(memberAttributesMap.get("Spanish Current Year"));
		boolean doc_zh_curYr=Boolean.valueOf(memberAttributesMap.get("Chinese Current Year"));
		boolean doc_en_nxtYr=Boolean.valueOf(memberAttributesMap.get("English Next Year"));
		boolean doc_es_nxtYr=Boolean.valueOf(memberAttributesMap.get("Spanish Next Year"));
		boolean doc_zh_nxtYr=Boolean.valueOf(memberAttributesMap.get("Chinese Next Year"));

		HashMap<String, Boolean> expectedDocTypeDisplayMap=new HashMap<String, Boolean>();
		expectedDocTypeDisplayMap.put("doc_en_curYr", doc_en_curYr);
		expectedDocTypeDisplayMap.put("doc_es_curYr", doc_es_curYr);
		expectedDocTypeDisplayMap.put("doc_zh_curYr", doc_zh_curYr);
		expectedDocTypeDisplayMap.put("doc_en_nxtYr", doc_en_nxtYr);
		expectedDocTypeDisplayMap.put("doc_es_nxtYr", doc_es_nxtYr);
		expectedDocTypeDisplayMap.put("doc_zh_nxtYr", doc_zh_nxtYr);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_EXPECTED_DOC_TYPE__DISPLAY_MAP, expectedDocTypeDisplayMap);

		if (!sectionDisplay) {
			if (doc_en_curYr || doc_es_curYr || doc_zh_curYr
					|| doc_en_nxtYr || doc_es_nxtYr || doc_zh_nxtYr)
				Assert.assertTrue("PROBLEM - logic error with input setup, please check sceanrio input.  If sectionDisplay is false, any doc display doesn't make sense to have true", false);
		}

		boolean langDisplay_en=(doc_en_curYr || doc_en_nxtYr);
		System.out.println("TEST - langDisplay_en="+langDisplay_en+" | doc_en_curYr="+doc_en_curYr+" | doc_en_nxtYr="+doc_en_nxtYr+" | (||)="+(doc_en_curYr || doc_en_nxtYr));
		boolean langDisplay_es=(doc_es_curYr || doc_es_nxtYr);
		System.out.println("TEST - langDisplay_es="+langDisplay_es+" | doc_es_curYr="+doc_es_curYr+" | doc_es_nxtYr="+doc_es_nxtYr+" | (||)="+(doc_es_curYr || doc_es_nxtYr));
		boolean langDisplay_zh=(doc_zh_curYr || doc_zh_nxtYr);
		System.out.println("TEST - langDisplay_zh="+langDisplay_zh+" | doc_zh_curYr="+doc_zh_curYr+" | doc_zh_nxtYr="+doc_zh_nxtYr+" | (||)="+(doc_zh_curYr || doc_zh_nxtYr));

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		HashMap<String, String> yearsMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_YEARS_MAP);
		PlanDocApiResponse api_planDocMap=(PlanDocApiResponse) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_ACTUAL_DOC_LIST_MAP);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);

		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_ANOC(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");

		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_ANOC(sectionDisplay, expectedDocTypeDisplayMap, yearsMap);
		sectionNote.add("PASSED - section header validation");

		//note: validate default language selection
		planDocumentsAndResourcesPage.validateDefaultLangSelect_ANOC(sectionDisplay);
		sectionNote.add("PASSED - Default language dropdown validation");

		boolean finalCheck=true;
		String problemText="";
		if (sectionDisplay) {

			boolean checkDestUrl=false; //note: for this sect of doc, the href link in element is not the same as the one after clicked

			//-----------------------------------------
			sectionNote.add("----- Validation for current year English documents");
			String period="currentYear";
			String language="English";
			boolean expDocDisplay=doc_en_curYr;
			String targetLang="EN";
			String targetYr=yearsMap.get(period);

			List<String> expDocList=new ArrayList<String>();
			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				expDocList=userHelperProd.getTargetDocList(planType, memberType, section, targetLang+"-currentYear");
			else
				expDocList=userHelper.getTargetDocList(planType, memberType, section, targetLang+"-currentYear");

			testInputInfoMap.put("section",section);
			testInputInfoMap.put("targetSubSection","currentYear");
			testInputInfoMap.put("targetLang",targetLang);
			testInputInfoMap.put("targetYr",targetYr);
			testInputInfoMap.put("checkDestUrl",String.valueOf(checkDestUrl));
			testInputInfoMap.put("expDocDisplay",String.valueOf(expDocDisplay));
			testInputInfoMap.put("validateApi",String.valueOf(validateApi));

			sectionNote=planDocumentsAndResourcesPage.validateDocOnUi(testInputInfoMap, expDocList, sectionNote, api_planDocMap);
			sectionNote.add("PASSED - "+period+" "+language+" documents UI validation");
			if (sectionNote.get(0).contains("API VALIDATOIN PASSED")) {
				sectionNote.add("PASSED - "+period+" "+language+" documents API validation");

			} else if (sectionNote.get(0).contains("API VALIDATOIN FAILED")) {
				sectionNote.add("FAILED - "+period+" "+language+" documents API validation");
				finalCheck=false;
				problemText=problemText+"FAILED - "+period+" "+language+" documents API validation | ";
			} 
			sectionNote.remove(0);	

			//-----------------------------------------
			sectionNote.add("----- Validation for current year Spanish documents");
			period="currentYear";
			language="Spanish";
			expDocDisplay=doc_es_curYr;
			targetLang="ES";
			targetYr=yearsMap.get(period);

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				expDocList=userHelperProd.getTargetDocList(planType, memberType, section, targetLang+"-currentYear");
			else
				expDocList=userHelper.getTargetDocList(planType, memberType, section, targetLang+"-currentYear");

			testInputInfoMap.put("section",section);
			testInputInfoMap.put("targetLang",targetLang);
			testInputInfoMap.put("targetSubSection","currentYear");
			testInputInfoMap.put("targetYr",targetYr);
			testInputInfoMap.put("checkDestUrl",String.valueOf(checkDestUrl));
			testInputInfoMap.put("expDocDisplay",String.valueOf(expDocDisplay));
			testInputInfoMap.put("validateApi",String.valueOf(validateApi));

			sectionNote=planDocumentsAndResourcesPage.validateDocOnUi(testInputInfoMap, expDocList, sectionNote, api_planDocMap);
			sectionNote.add("PASSED - "+period+" "+language+" documents UI validation");
			if (sectionNote.get(0).contains("API VALIDATOIN PASSED")) {
				sectionNote.add("PASSED - "+period+" "+language+" documents API validation");

			} else if (sectionNote.get(0).contains("API VALIDATOIN FAILED")) {
				sectionNote.add("FAILED - "+period+" "+language+" documents API validation");
				finalCheck=false;
				problemText=problemText+"FAILED - "+period+" "+language+" documents API validation | ";
			} 
			sectionNote.remove(0);	

			//-----------------------------------------
			sectionNote.add("----- Validation for current year Chinese documents");
			period="currentYear";
			language="Chinese";
			expDocDisplay=doc_zh_curYr;
			targetLang="ZH";
			targetYr=yearsMap.get(period);

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				expDocList=userHelperProd.getTargetDocList(planType, memberType, section, targetLang+"-currentYear");
			else
				expDocList=userHelper.getTargetDocList(planType, memberType, section, targetLang+"-currentYear");
			testInputInfoMap.put("section",section);
			testInputInfoMap.put("targetSubSection","currentYear");
			testInputInfoMap.put("targetLang",targetLang);
			testInputInfoMap.put("targetYr",targetYr);
			testInputInfoMap.put("checkDestUrl",String.valueOf(checkDestUrl));
			testInputInfoMap.put("expDocDisplay",String.valueOf(expDocDisplay));
			testInputInfoMap.put("validateApi",String.valueOf(validateApi));

			sectionNote=planDocumentsAndResourcesPage.validateDocOnUi(testInputInfoMap, expDocList, sectionNote, api_planDocMap);
			sectionNote.add("PASSED - "+period+" "+language+" documents UI validation");
			if (sectionNote.get(0).contains("API VALIDATOIN PASSED")) {
				sectionNote.add("PASSED - "+period+" "+language+" documents API validation");

			} else if (sectionNote.get(0).contains("API VALIDATOIN FAILED")) {
				sectionNote.add("FAILED - "+period+" "+language+" documents API validation");
				finalCheck=false;
				problemText=problemText+"FAILED - "+period+" "+language+" documents API validation | ";
			} 
			sectionNote.remove(0);	

			//-----------------------------------------
			sectionNote.add("----- Validation for next year English documents");
			period="nextYear";
			language="English";
			expDocDisplay=doc_en_nxtYr;
			targetLang="EN";
			targetYr=yearsMap.get("nextYear");

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				expDocList=userHelperProd.getTargetDocList(planType, memberType, section, targetLang+"-nextYear");
			else
				expDocList=userHelper.getTargetDocList(planType, memberType, section, targetLang+"-nextYear");
			testInputInfoMap.put("section",section);
			testInputInfoMap.put("targetSubSection","nextYear");
			testInputInfoMap.put("targetLang",targetLang);
			testInputInfoMap.put("targetYr",targetYr);
			testInputInfoMap.put("checkDestUrl",String.valueOf(checkDestUrl));
			testInputInfoMap.put("expDocDisplay",String.valueOf(expDocDisplay));
			testInputInfoMap.put("validateApi",String.valueOf(validateApi));

			sectionNote=planDocumentsAndResourcesPage.validateDocOnUi(testInputInfoMap, expDocList, sectionNote, api_planDocMap);
			sectionNote.add("PASSED - "+period+" "+language+" documents UI validation");
			if (sectionNote.get(0).contains("API VALIDATOIN PASSED")) {
				sectionNote.add("PASSED - "+period+" "+language+" documents API validation");

			} else if (sectionNote.get(0).contains("API VALIDATOIN FAILED")) {
				sectionNote.add("FAILED - "+period+" "+language+" documents API validation");
				finalCheck=false;
				problemText=problemText+"FAILED - "+period+" "+language+" documents API validation | ";
			} 
			sectionNote.remove(0);	

			//-----------------------------------------
			sectionNote.add("----- Validation for next year Spanish documents");
			period="nextYear";
			language="Spanish";
			expDocDisplay=doc_es_nxtYr;
			targetLang="ES";
			targetYr=yearsMap.get(period);

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				expDocList=userHelperProd.getTargetDocList(planType, memberType, section, targetLang+"-nextYear");
			else
				expDocList=userHelper.getTargetDocList(planType, memberType, section, targetLang+"-nextYear");
			testInputInfoMap.put("section",section);
			testInputInfoMap.put("targetSubSection","nextYear");
			testInputInfoMap.put("targetLang",targetLang);
			testInputInfoMap.put("targetYr",targetYr);
			testInputInfoMap.put("checkDestUrl",String.valueOf(checkDestUrl));
			testInputInfoMap.put("expDocDisplay",String.valueOf(expDocDisplay));
			testInputInfoMap.put("validateApi",String.valueOf(validateApi));

			sectionNote=planDocumentsAndResourcesPage.validateDocOnUi(testInputInfoMap, expDocList, sectionNote, api_planDocMap);
			sectionNote.add("PASSED - "+period+" "+language+" documents UI validation");
			if (sectionNote.get(0).contains("API VALIDATOIN PASSED")) {
				sectionNote.add("PASSED - "+period+" "+language+" documents API validation");

			} else if (sectionNote.get(0).contains("API VALIDATOIN FAILED")) {
				sectionNote.add("FAILED - "+period+" "+language+" documents API validation");
				finalCheck=false;
				problemText=problemText+"FAILED - "+period+" "+language+" documents API validation | ";
			} 
			sectionNote.remove(0);	

			//-----------------------------------------
			sectionNote.add("----- Validation for next year Chinese documents");
			period="nextYear";
			language="Chinese";
			expDocDisplay=doc_zh_nxtYr;
			targetLang="ZH";
			targetYr=yearsMap.get("nextYear");

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				expDocList=userHelperProd.getTargetDocList(planType, memberType, section, targetLang+"-nextYear");
			else
				expDocList=userHelper.getTargetDocList(planType, memberType, section, targetLang+"-nextYear");
			testInputInfoMap.put("section",section);
			testInputInfoMap.put("targetSubSection","nextYear");
			testInputInfoMap.put("targetLang",targetLang);
			testInputInfoMap.put("targetYr",targetYr);
			testInputInfoMap.put("checkDestUrl",String.valueOf(checkDestUrl));
			testInputInfoMap.put("expDocDisplay",String.valueOf(expDocDisplay));
			testInputInfoMap.put("validateApi",String.valueOf(validateApi));

			sectionNote=planDocumentsAndResourcesPage.validateDocOnUi(testInputInfoMap, expDocList, sectionNote, api_planDocMap);
			sectionNote.add("PASSED - "+period+" "+language+" documents UI validation");
			if (sectionNote.get(0).contains("API VALIDATOIN PASSED")) {
				sectionNote.add("PASSED - "+period+" "+language+" documents API validation");

			} else if (sectionNote.get(0).contains("API VALIDATOIN FAILED")) {
				sectionNote.add("FAILED - "+period+" "+language+" documents API validation");
				finalCheck=false;
				problemText=problemText+"FAILED - "+period+" "+language+" documents API validation | ";
			} 
			sectionNote.remove(0);	
		}

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);		

		Assert.assertTrue("PROBLEM - "+problemText, finalCheck);
	}

	@SuppressWarnings("unchecked")
	@Then("^user sanity validates section Annual Notice of Changes Documents$")
	public void validateSection_ANOC_sanity(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Annual Notice of Changes Documents";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);

		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_ANOC(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");

		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_ANOC_sanity(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		//note: validate default language selection
		planDocumentsAndResourcesPage.validateDefaultLangSelect_ANOC(sectionDisplay);
		sectionNote.add("PASSED - Default language dropdown validation");

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);		
	}

	@SuppressWarnings("unchecked")
	@Then("^user validates jumplink and listing of mandatory documents for section Provider Directory or Pharmacy Directory or Provider and Pharmacy Directories$")
	public void validateSection_PD(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Provider and Pharmacy Directories";
		if (planType.equals("MA")) 
			section="Provider Directory";
		else if (planType.equals("PDP")) 
			section="Pharmacy Directory";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));
		boolean providerSearchDisplay=Boolean.valueOf(memberAttributesMap.get("Provider Search"));
		boolean pharmacyLocatorDisplay=Boolean.valueOf(memberAttributesMap.get("Pharmacy Locator"));
		boolean doc_en_curYr=Boolean.valueOf(memberAttributesMap.get("English Current Year"));
		boolean doc_es_curYr=Boolean.valueOf(memberAttributesMap.get("Spanish Current Year"));
		boolean doc_zh_curYr=Boolean.valueOf(memberAttributesMap.get("Chinese Current Year"));
		boolean doc_en_nxtYr=Boolean.valueOf(memberAttributesMap.get("English Next Year"));
		boolean doc_es_nxtYr=Boolean.valueOf(memberAttributesMap.get("Spanish Next Year"));
		boolean doc_zh_nxtYr=Boolean.valueOf(memberAttributesMap.get("Chinese Next Year"));

		HashMap<String, Boolean> expectedDocTypeDisplayMap=new HashMap<String, Boolean>();
		expectedDocTypeDisplayMap.put("doc_en_curYr", doc_en_curYr);
		expectedDocTypeDisplayMap.put("doc_es_curYr", doc_es_curYr);
		expectedDocTypeDisplayMap.put("doc_zh_curYr", doc_zh_curYr);
		expectedDocTypeDisplayMap.put("doc_en_nxtYr", doc_en_nxtYr);
		expectedDocTypeDisplayMap.put("doc_es_nxtYr", doc_es_nxtYr);
		expectedDocTypeDisplayMap.put("doc_zh_nxtYr", doc_zh_nxtYr);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_EXPECTED_DOC_TYPE__DISPLAY_MAP, expectedDocTypeDisplayMap);

		if (!sectionDisplay) {
			if (providerSearchDisplay || pharmacyLocatorDisplay
					|| doc_en_curYr || doc_es_curYr || doc_zh_curYr
					|| doc_en_nxtYr || doc_es_nxtYr || doc_zh_nxtYr)
				Assert.assertTrue("PROBLEM - logic error with input setup, please check sceanrio input.  If sectionDisplay is false, providerSearchDisplay or pharmacyLocatorDisplay or any doc display doesn't make sense to have true", false);
		}

		boolean langDisplay_en=(doc_en_curYr || doc_en_nxtYr);
		System.out.println("TEST - langDisplay_en="+langDisplay_en+" | doc_en_curYr="+doc_en_curYr+" | doc_en_nxtYr="+doc_en_nxtYr+" | (||)="+(doc_en_curYr || doc_en_nxtYr));
		boolean langDisplay_es=(doc_es_curYr || doc_es_nxtYr);
		System.out.println("TEST - langDisplay_es="+langDisplay_es+" | doc_es_curYr="+doc_es_curYr+" | doc_es_nxtYr="+doc_es_nxtYr+" | (||)="+(doc_es_curYr || doc_es_nxtYr));
		boolean langDisplay_zh=(doc_zh_curYr || doc_zh_nxtYr);
		System.out.println("TEST - langDisplay_zh="+langDisplay_zh+" | doc_zh_curYr="+doc_zh_curYr+" | doc_zh_nxtYr="+doc_zh_nxtYr+" | (||)="+(doc_zh_curYr || doc_zh_nxtYr));

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		HashMap<String, String> yearsMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_YEARS_MAP);
		PlanDocApiResponse api_planDocMap=(PlanDocApiResponse) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_ACTUAL_DOC_LIST_MAP);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);

		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_PD(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");

		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_PD(testInputInfoMap, sectionDisplay, expectedDocTypeDisplayMap, yearsMap);
		sectionNote.add("PASSED - section header validation");

		//note: validate Provider Search link and image
		sectionNote.addAll(planDocumentsAndResourcesPage.valiateProviderSearch_PD(testInputInfoMap, providerSearchDisplay));
		sectionNote.add("PASSED - Provider Search link validation");

		//note: validate Pharmacy Locator link and image
		sectionNote.addAll(planDocumentsAndResourcesPage.valiatePharmacyLocator_PD(testInputInfoMap, pharmacyLocatorDisplay));
		sectionNote.add("PASSED - Pharmacy locator link validation");

		//note: validate default language selection
		planDocumentsAndResourcesPage.validateDefaultLangSelect_PD(testInputInfoMap, sectionDisplay);
		sectionNote.add("PASSED - Default language dropdown validation");

		boolean finalCheck=true;
		String problemText="";
		if (sectionDisplay) {
			boolean checkDestUrl=false; //note: for this sect of doc, the href link in element is not the same as the one after clicked

			//-----------------------------------------
			sectionNote.add("----- Validation for current year English documents");
			String period="currentYear";
			String language="English";
			boolean expDocDisplay=doc_en_curYr;
			String targetLang="EN";
			String targetYr=yearsMap.get(period);

			List<String> expDocList=new ArrayList<String>();
			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				expDocList=userHelperProd.getTargetDocList(planType, memberType, section, targetLang+"-currentYear");
			else
				expDocList=userHelper.getTargetDocList(planType, memberType, section, targetLang+"-currentYear");
			testInputInfoMap.put("section",section);
			testInputInfoMap.put("targetSubSection","currentYear");
			testInputInfoMap.put("targetLang",targetLang);
			testInputInfoMap.put("targetYr",targetYr);
			testInputInfoMap.put("checkDestUrl",String.valueOf(checkDestUrl));
			testInputInfoMap.put("expDocDisplay",String.valueOf(expDocDisplay));
			testInputInfoMap.put("validateApi",String.valueOf(validateApi));

			sectionNote=planDocumentsAndResourcesPage.validateDocOnUi(testInputInfoMap, expDocList, sectionNote, api_planDocMap);
			sectionNote.add("PASSED - "+period+" "+language+" documents UI validation");
			if (sectionNote.get(0).contains("API VALIDATOIN PASSED")) {
				sectionNote.add("PASSED - "+period+" "+language+" documents API validation");

			} else if (sectionNote.get(0).contains("API VALIDATOIN FAILED")) {
				sectionNote.add("FAILED - "+period+" "+language+" documents API validation");
				finalCheck=false;
				problemText=problemText+"FAILED - "+period+" "+language+" documents API validation | ";
			} 
			sectionNote.remove(0);	

			//-----------------------------------------
			sectionNote.add("----- Validation for current year Spanish documents");
			period="currentYear";
			language="Spanish";
			expDocDisplay=doc_es_curYr;
			targetLang="ES";
			targetYr=yearsMap.get(period);

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				expDocList=userHelperProd.getTargetDocList(planType, memberType, section, targetLang+"-currentYear");
			else
				expDocList=userHelper.getTargetDocList(planType, memberType, section, targetLang+"-currentYear");
			testInputInfoMap.put("section",section);
			testInputInfoMap.put("targetSubSection","currentYear");
			testInputInfoMap.put("targetLang",targetLang);
			testInputInfoMap.put("targetYr",targetYr);
			testInputInfoMap.put("checkDestUrl",String.valueOf(checkDestUrl));
			testInputInfoMap.put("expDocDisplay",String.valueOf(expDocDisplay));
			testInputInfoMap.put("validateApi",String.valueOf(validateApi));

			sectionNote=planDocumentsAndResourcesPage.validateDocOnUi(testInputInfoMap, expDocList, sectionNote, api_planDocMap);
			sectionNote.add("PASSED - "+period+" "+language+" documents UI validation");
			if (sectionNote.get(0).contains("API VALIDATOIN PASSED")) {
				sectionNote.add("PASSED - "+period+" "+language+" documents API validation");

			} else if (sectionNote.get(0).contains("API VALIDATOIN FAILED")) {
				sectionNote.add("FAILED - "+period+" "+language+" documents API validation");
				finalCheck=false;
				problemText=problemText+"FAILED - "+period+" "+language+" documents API validation | ";
			} 
			sectionNote.remove(0);	

			//-----------------------------------------
			sectionNote.add("----- Validation for current year Chinese documents");
			period="currentYear";
			language="Chinese";
			expDocDisplay=doc_zh_curYr;
			targetLang="ZH";
			targetYr=yearsMap.get(period);

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				expDocList=userHelperProd.getTargetDocList(planType, memberType, section, targetLang+"-currentYear");
			else
				expDocList=userHelper.getTargetDocList(planType, memberType, section, targetLang+"-currentYear");
			testInputInfoMap.put("section",section);
			testInputInfoMap.put("targetSubSection","currentYear");
			testInputInfoMap.put("targetLang",targetLang);
			testInputInfoMap.put("targetYr",targetYr);
			testInputInfoMap.put("checkDestUrl",String.valueOf(checkDestUrl));
			testInputInfoMap.put("expDocDisplay",String.valueOf(expDocDisplay));
			testInputInfoMap.put("validateApi",String.valueOf(validateApi));

			sectionNote=planDocumentsAndResourcesPage.validateDocOnUi(testInputInfoMap, expDocList, sectionNote, api_planDocMap);
			sectionNote.add("PASSED - "+period+" "+language+" documents UI validation");
			if (sectionNote.get(0).contains("API VALIDATOIN PASSED")) {
				sectionNote.add("PASSED - "+period+" "+language+" documents API validation");

			} else if (sectionNote.get(0).contains("API VALIDATOIN FAILED")) {
				sectionNote.add("FAILED - "+period+" "+language+" documents API validation");
				finalCheck=false;
				problemText=problemText+"FAILED - "+period+" "+language+" documents API validation | ";
			} 
			sectionNote.remove(0);	

			//-----------------------------------------
			sectionNote.add("----- Validation for next year English documents");
			period="nextYear";
			language="English";
			expDocDisplay=doc_en_nxtYr;
			targetLang="EN";
			targetYr=yearsMap.get(period);

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				expDocList=userHelperProd.getTargetDocList(planType, memberType, section, targetLang+"-nextYear");
			else
				expDocList=userHelper.getTargetDocList(planType, memberType, section, targetLang+"-nextYear");
			testInputInfoMap.put("section",section);
			testInputInfoMap.put("targetSubSection","nextYear");
			testInputInfoMap.put("targetLang",targetLang);
			testInputInfoMap.put("targetYr",targetYr);
			testInputInfoMap.put("checkDestUrl",String.valueOf(checkDestUrl));
			testInputInfoMap.put("expDocDisplay",String.valueOf(expDocDisplay));
			testInputInfoMap.put("validateApi",String.valueOf(validateApi));

			sectionNote=planDocumentsAndResourcesPage.validateDocOnUi(testInputInfoMap, expDocList, sectionNote, api_planDocMap);
			sectionNote.add("PASSED - "+period+" "+language+" documents UI validation");
			if (sectionNote.get(0).contains("API VALIDATOIN PASSED")) {
				sectionNote.add("PASSED - "+period+" "+language+" documents API validation");

			} else if (sectionNote.get(0).contains("API VALIDATOIN FAILED")) {
				sectionNote.add("FAILED - "+period+" "+language+" documents API validation");
				finalCheck=false;
				problemText=problemText+"FAILED - "+period+" "+language+" documents API validation | ";
			} 
			sectionNote.remove(0);	

			//-----------------------------------------
			sectionNote.add("----- Validation for next year Spanish documents");
			period="nextYear";
			language="Spanish";
			expDocDisplay=doc_es_nxtYr;
			targetLang="ES";
			targetYr=yearsMap.get(period);

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				expDocList=userHelperProd.getTargetDocList(planType, memberType, section, targetLang+"-nextYear");
			else
				expDocList=userHelper.getTargetDocList(planType, memberType, section, targetLang+"-nextYear");
			testInputInfoMap.put("section",section);
			testInputInfoMap.put("targetSubSection","nextYear");
			testInputInfoMap.put("targetLang",targetLang);
			testInputInfoMap.put("targetYr",targetYr);
			testInputInfoMap.put("checkDestUrl",String.valueOf(checkDestUrl));
			testInputInfoMap.put("expDocDisplay",String.valueOf(expDocDisplay));
			testInputInfoMap.put("validateApi",String.valueOf(validateApi));

			sectionNote=planDocumentsAndResourcesPage.validateDocOnUi(testInputInfoMap, expDocList, sectionNote, api_planDocMap);
			sectionNote.add("PASSED - "+period+" "+language+" documents UI validation");
			if (sectionNote.get(0).contains("API VALIDATOIN PASSED")) {
				sectionNote.add("PASSED - "+period+" "+language+" documents API validation");

			} else if (sectionNote.get(0).contains("API VALIDATOIN FAILED")) {
				sectionNote.add("FAILED - "+period+" "+language+" documents API validation");
				finalCheck=false;
				problemText=problemText+"FAILED - "+period+" "+language+" documents API validation | ";
			} 
			sectionNote.remove(0);	

			//-----------------------------------------
			sectionNote.add("----- Validation for next year Chinese documents");
			period="nextYear";
			language="Chinese";
			expDocDisplay=doc_zh_nxtYr;
			targetLang="ZH";
			targetYr=yearsMap.get(period);

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				expDocList=userHelperProd.getTargetDocList(planType, memberType, section, targetLang+"-nextYear");
			else
				expDocList=userHelper.getTargetDocList(planType, memberType, section, targetLang+"-nextYear");
			testInputInfoMap.put("section",section);
			testInputInfoMap.put("targetSubSection","nextYear");
			testInputInfoMap.put("targetLang",targetLang);
			testInputInfoMap.put("targetYr",targetYr);
			testInputInfoMap.put("checkDestUrl",String.valueOf(checkDestUrl));
			testInputInfoMap.put("expDocDisplay",String.valueOf(expDocDisplay));
			testInputInfoMap.put("validateApi",String.valueOf(validateApi));

			sectionNote=planDocumentsAndResourcesPage.validateDocOnUi(testInputInfoMap, expDocList, sectionNote, api_planDocMap);
			sectionNote.add("PASSED - "+period+" "+language+" documents UI validation");
			if (sectionNote.get(0).contains("API VALIDATOIN PASSED")) {
				sectionNote.add("PASSED - "+period+" "+language+" documents API validation");

			} else if (sectionNote.get(0).contains("API VALIDATOIN FAILED")) {
				sectionNote.add("FAILED - "+period+" "+language+" documents API validation");
				finalCheck=false;
				problemText=problemText+"FAILED - "+period+" "+language+" documents API validation | ";
			} 
			sectionNote.remove(0);	
		}

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);		

		Assert.assertTrue("PROBLEM - "+problemText, finalCheck);
	}

	@SuppressWarnings("unchecked")
	@Then("^user sanity validates section Provider Directory or Pharmacy Directory or Provider and Pharmacy Directories$")
	public void validateSection_PD_sanity(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Provider and Pharmacy Directories";
		if (planType.equals("MA")) 
			section="Provider Directory";
		else if (planType.equals("PDP")) 
			section="Pharmacy Directory";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);

		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_PD(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");

		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_PD_sanity(testInputInfoMap, sectionDisplay);
		sectionNote.add("PASSED - section header validation");


		//note: validate default language selection
		planDocumentsAndResourcesPage.validateDefaultLangSelect_PD(testInputInfoMap, sectionDisplay);
		sectionNote.add("PASSED - Default language dropdown validation");

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);		

	}


	@SuppressWarnings("unchecked")
	@Then("^user validate My Documents section$")
	public void validateSection_MD(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="My Documents";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);
		//note: validate jumplink

		testInputInfoMap.put("section", section);

		planDocumentsAndResourcesPage.validateJumplink_MD(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");
		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_MD(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		//note: validate button and destination url
		planDocumentsAndResourcesPage.valiateSearchDocuments_MD(testInputInfoMap, sectionDisplay);
		sectionNote.add("PASSED - button and destination url validation");
	}

	@SuppressWarnings("unchecked")
	@Then("^user sanity validate My Documents section$")
	public void validateSection_MD_sanity(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="My Documents";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);
		//note: validate jumplink

		testInputInfoMap.put("section", section);

		planDocumentsAndResourcesPage.validateJumplink_MD(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");
		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_MD(sectionDisplay);
		sectionNote.add("PASSED - section header validation");
	}

	@SuppressWarnings("unchecked")
	@Then("^user validate Explanation of Benefits section$")
	public void validateSection_EOB(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Explanation of Benefits (EOB)";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));
		boolean searchMedicalEobHsitoryDisplay=Boolean.valueOf(memberAttributesMap.get("Search Medical EOB History"));
		boolean searchDrugEobHsitoryDisplay=Boolean.valueOf(memberAttributesMap.get("Search Drug EOB History"));

		if (!sectionDisplay && (searchMedicalEobHsitoryDisplay || searchDrugEobHsitoryDisplay)) {
			Assert.assertTrue("PROBLEM - logic error with input setup, please check sceanrio input.  If sectionDisplay is false, searchMedicalEobHsitoryDisplay or searchDrugEobHsitoryDisplay doesn't make sense to have true", false);
		}

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);
		//note: validate jumplink

		testInputInfoMap.put("section", section);

		planDocumentsAndResourcesPage.validateJumplink_EOB(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");

		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_EOB(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		//note: validate button for medical
		planDocumentsAndResourcesPage.valiateMedicalLnk_EOB(testInputInfoMap, searchMedicalEobHsitoryDisplay);
		sectionNote.add("PASSED - Search Medical EOB button validation");

		//note: validate button for drug
		planDocumentsAndResourcesPage.valiateDrugLnk_EOB(testInputInfoMap, searchDrugEobHsitoryDisplay);
		sectionNote.add("PASSED - Search Drug EOB button validation");
		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);		
	}

	@SuppressWarnings("unchecked")
	@Then("^user sanity validate Explanation of Benefits section$")
	public void validateSection_EOB_sanity(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Explanation of Benefits (EOB)";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);
		//note: validate jumplink

		testInputInfoMap.put("section", section);

		planDocumentsAndResourcesPage.validateJumplink_EOB(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");

		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_EOB(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);		
	}

	@SuppressWarnings("unchecked")
	@Then("^user validate Forms and Resources section$")
	public void validateSection_FnR(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Forms And Resources";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));
		boolean presDrugMailOrderFormDisplay=Boolean.valueOf(memberAttributesMap.get("Prescription Drug Mail Order Form"));
		boolean premiumPaymentInfoDisplay=Boolean.valueOf(memberAttributesMap.get("Premium Payment Information"));
		boolean reimbursementFormsDisplay=Boolean.valueOf(memberAttributesMap.get("Reimbursement Forms"));
		boolean authFormsAndInfoDisplay=Boolean.valueOf(memberAttributesMap.get("Authorization Forms and Information"));
		boolean medicationAuthFormsDisplay=Boolean.valueOf(memberAttributesMap.get("Medication Authorization Forms"));
		boolean otherResourcesDisplay=Boolean.valueOf(memberAttributesMap.get("Other Resources"));
		boolean disenrollmentInfoDisplay=Boolean.valueOf(memberAttributesMap.get("Disenrollment Information"));

		if (!sectionDisplay && 
				(presDrugMailOrderFormDisplay || premiumPaymentInfoDisplay || reimbursementFormsDisplay || authFormsAndInfoDisplay
						|| medicationAuthFormsDisplay|| otherResourcesDisplay || disenrollmentInfoDisplay)) {
			Assert.assertTrue("PROBLEM - logic error with input setup, please check sceanrio input.  If sectionDisplay is false, searchMedicalEobHsitoryDisplay or searchDrugEobHsitoryDisplay doesn't make sense to have true", false);
		}

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);

		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_FnR(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");
		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_FnR(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		boolean allPassed=true;
		if (sectionDisplay) { //note: list of items
			//-----------------------------
			String subSection="Premium Payment Information";
			boolean sectionPassed=true;
			testInputInfoMap.put("subSection", subSection);
			testInputInfoMap.put("expDisplay_FnR", String.valueOf(premiumPaymentInfoDisplay));
			List<String> docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
			sectionNote.addAll(docSection_note);

			List<String> targetDocList=new ArrayList<String>();
			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
			else
				targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
			for(String doc: targetDocList) {
				testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
				docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);
				if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
					sectionPassed=false;
			}
			planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
			System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
			if (sectionPassed)
				sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
			else {
				sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
				allPassed=false;
			}
			sectionNote.add("  ------------------------------------------------------");

			//-----------------------------
			subSection="Reimbursement Forms";
			sectionPassed=true; //note: reset - assume the section pass to begin with
			testInputInfoMap.put("subSection", subSection);
			testInputInfoMap.put("expDisplay_FnR", String.valueOf(reimbursementFormsDisplay));
			docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
			sectionNote.addAll(docSection_note);

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
			else
				targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
			for(String doc: targetDocList) {
				testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
				docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);
				if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
					sectionPassed=false;
			}
			planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
			System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
			if (sectionPassed)
				sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
			else {
				sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
				allPassed=false;
			}
			sectionNote.add("  ------------------------------------------------------");

			//-----------------------------
			subSection="Authorization Forms and Information";
			sectionPassed=true; //note: reset - assume the section pass to begin with
			if (memberType.toUpperCase().contains("GROUP")) 
				subSection="Authorization Forms";
			testInputInfoMap.put("subSection", subSection);
			testInputInfoMap.put("expDisplay_FnR", String.valueOf(authFormsAndInfoDisplay));
			docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
			sectionNote.addAll(docSection_note);

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
			else
				targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
			for(String doc: targetDocList) {
				testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
				docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);
				if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
					sectionPassed=false;
			}
			planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
			System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
			if (sectionPassed)
				sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
			else {
				sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
				allPassed=false;
			}
			sectionNote.add("  ------------------------------------------------------");

			//-----------------------------
			subSection="Medication Authorization Forms";
			sectionPassed=true; //note: reset - assume the section pass to begin with
			testInputInfoMap.put("subSection", subSection);
			testInputInfoMap.put("expDisplay_FnR", String.valueOf(medicationAuthFormsDisplay));
			docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
			sectionNote.addAll(docSection_note);

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
			else
				targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
			for(String doc: targetDocList) {
				testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
				docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);
				if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
					sectionPassed=false;
			}
			planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
			System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
			if (sectionPassed)
				sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
			else {
				sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
				allPassed=false;
			}
			sectionNote.add("  ------------------------------------------------------");

			//-----------------------------
			subSection="Other Resources";
			sectionPassed=true; //note: reset - assume the section pass to begin with
			testInputInfoMap.put("subSection", subSection);
			testInputInfoMap.put("expDisplay_FnR", String.valueOf(otherResourcesDisplay));
			docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
			sectionNote.addAll(docSection_note);

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
			else
				targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
			for(String doc: targetDocList) {
				testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
				docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);
				if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
					sectionPassed=false;
			}
			planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
			System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
			if (sectionPassed)
				sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
			else {
				sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
				allPassed=false;
			}
			sectionNote.add("  ------------------------------------------------------");

			//-----------------------------
			subSection="Disenrollment";
			sectionPassed=true; //note: reset - assume the section pass to begin with
			testInputInfoMap.put("subSection", subSection);
			testInputInfoMap.put("expDisplay_FnR", String.valueOf(disenrollmentInfoDisplay));
			docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
			sectionNote.addAll(docSection_note);

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
			else
				targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
			for(String doc: targetDocList) {
				testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
				docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);
				if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
					sectionPassed=false;
			}
			planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
			System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
			if (sectionPassed)
				sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
			else {
				sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
				allPassed=false;
			}
			sectionNote.add("  ------------------------------------------------------");

			//-----------------------------
			if (planType.equals("SHIP")) {
				subSection="SHIP"; //note: ship has no sub-section
				sectionPassed=true; //note: reset - assume the section pass to begin with
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", "true"); 
				//docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				//sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				//planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			}

			//-----------------------------
			if (planType.equals("PDP")) {
				subSection="Prescription Drug Mail Order Form";
				sectionPassed=true; //note: reset - assume the section pass to begin with
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", String.valueOf(presDrugMailOrderFormDisplay));
				docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			}
		} 

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);

		Assert.assertTrue("PROBLEM - not all FnR documents pass validation, see TEST NOTE in log for detail", allPassed);
	}

	@SuppressWarnings("unchecked")
	@Then("^user validate Forms and Resources section Part 1 of 2$")
	public void validateSection_FnR_Part1of2(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Forms And Resources";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));
		boolean presDrugMailOrderFormDisplay=Boolean.valueOf(memberAttributesMap.get("Prescription Drug Mail Order Form"));
		boolean premiumPaymentInfoDisplay=Boolean.valueOf(memberAttributesMap.get("Premium Payment Information"));
		boolean reimbursementFormsDisplay=Boolean.valueOf(memberAttributesMap.get("Reimbursement Forms"));
		boolean authFormsAndInfoDisplay=Boolean.valueOf(memberAttributesMap.get("Authorization Forms and Information"));

		if (!sectionDisplay && 
				(presDrugMailOrderFormDisplay || premiumPaymentInfoDisplay || reimbursementFormsDisplay || authFormsAndInfoDisplay)) {
			Assert.assertTrue("PROBLEM - logic error with input setup, please check sceanrio input.  If sectionDisplay is false, searchMedicalEobHsitoryDisplay or searchDrugEobHsitoryDisplay doesn't make sense to have true", false);
		}

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);

		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_FnR(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");
		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_FnR(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		boolean allPassed=true;
		if (sectionDisplay) { //note: list of items
			//-----------------------------
			String subSection="Premium Payment Information";
			boolean sectionPassed=true;
			testInputInfoMap.put("subSection", subSection);
			testInputInfoMap.put("expDisplay_FnR", String.valueOf(premiumPaymentInfoDisplay));
			List<String> docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
			sectionNote.addAll(docSection_note);

			List<String> targetDocList=new ArrayList<String>();
			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
			else
				targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
			for(String doc: targetDocList) {
				testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
				docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);
				if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
					sectionPassed=false;
			}
			planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
			System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
			if (sectionPassed)
				sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
			else {
				sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
				allPassed=false;
			}
			sectionNote.add("  ------------------------------------------------------");

			//-----------------------------
			subSection="Reimbursement Forms";
			sectionPassed=true; //note: reset - assume the section pass to begin with
			testInputInfoMap.put("subSection", subSection);
			testInputInfoMap.put("expDisplay_FnR", String.valueOf(reimbursementFormsDisplay));
			docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
			sectionNote.addAll(docSection_note);

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
			else
				targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
			for(String doc: targetDocList) {
				testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
				docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);
				if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
					sectionPassed=false;
			}
			planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
			System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
			if (sectionPassed)
				sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
			else {
				sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
				allPassed=false;
			}
			sectionNote.add("  ------------------------------------------------------");

			//-----------------------------
			subSection="Authorization Forms and Information";
			sectionPassed=true; //note: reset - assume the section pass to begin with
			if (memberType.toUpperCase().contains("GROUP")) 
				subSection="Authorization Forms";
			testInputInfoMap.put("subSection", subSection);
			testInputInfoMap.put("expDisplay_FnR", String.valueOf(authFormsAndInfoDisplay));
			docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
			sectionNote.addAll(docSection_note);

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
			else
				targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
			for(String doc: targetDocList) {
				testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
				docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);
				if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
					sectionPassed=false;
			}
			planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
			System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
			if (sectionPassed)
				sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
			else {
				sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
				allPassed=false;
			}
			sectionNote.add("  ------------------------------------------------------");

			//-----------------------------
			if (presDrugMailOrderFormDisplay) {
				subSection="Prescription Drug Mail Order Form";
				sectionPassed=true; //note: reset - assume the section pass to begin with
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", String.valueOf(presDrugMailOrderFormDisplay));
				docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			} 
		} 

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);

		Assert.assertTrue("PROBLEM - not all FnR documents pass validation, see TEST NOTE in log for detail", allPassed);
	}

	@SuppressWarnings("unchecked")
	@Then("^user validate Forms and Resources section Part 2 of 2$")
	public void validateSection_FnR_Part2of2(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Forms And Resources";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));
		boolean medicationAuthFormsDisplay=Boolean.valueOf(memberAttributesMap.get("Medication Authorization Forms"));
		boolean otherResourcesDisplay=Boolean.valueOf(memberAttributesMap.get("Other Resources"));
		boolean disenrollmentInfoDisplay=Boolean.valueOf(memberAttributesMap.get("Disenrollment Information"));

		if (!sectionDisplay && 
				(medicationAuthFormsDisplay|| otherResourcesDisplay || disenrollmentInfoDisplay)) {
			Assert.assertTrue("PROBLEM - logic error with input setup, please check sceanrio input.  If sectionDisplay is false, searchMedicalEobHsitoryDisplay or searchDrugEobHsitoryDisplay doesn't make sense to have true", false);
		}

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);

		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_FnR(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");
		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_FnR(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		boolean allPassed=true;
		if (sectionDisplay) { //note: list of items
			//-----------------------------
			List<String> targetDocList=new ArrayList<String>();
			String subSection="Medication Authorization Forms";
			boolean sectionPassed=true; //note: reset - assume the section pass to begin with
			testInputInfoMap.put("subSection", subSection);
			testInputInfoMap.put("expDisplay_FnR", String.valueOf(medicationAuthFormsDisplay));
			List<String>  docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
			sectionNote.addAll(docSection_note);

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
			else
				targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
			for(String doc: targetDocList) {
				testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
				docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);
				if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
					sectionPassed=false;
			}
			planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
			System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
			if (sectionPassed)
				sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
			else {
				sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
				allPassed=false;
			}
			sectionNote.add("  ------------------------------------------------------");

			//-----------------------------
			subSection="Other Resources";
			sectionPassed=true; //note: reset - assume the section pass to begin with
			testInputInfoMap.put("subSection", subSection);
			testInputInfoMap.put("expDisplay_FnR", String.valueOf(otherResourcesDisplay));
			docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
			sectionNote.addAll(docSection_note);

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
			else
				targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
			for(String doc: targetDocList) {
				testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
				docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);
				if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
					sectionPassed=false;
			}
			planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
			System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
			if (sectionPassed)
				sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
			else {
				sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
				allPassed=false;
			}
			sectionNote.add("  ------------------------------------------------------");

			//-----------------------------
			subSection="Disenrollment";
			sectionPassed=true; //note: reset - assume the section pass to begin with
			testInputInfoMap.put("subSection", subSection);
			testInputInfoMap.put("expDisplay_FnR", String.valueOf(disenrollmentInfoDisplay));
			docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
			sectionNote.addAll(docSection_note);

			if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
				targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
			else
				targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
			for(String doc: targetDocList) {
				testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
				docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);
				if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
					sectionPassed=false;
			}
			planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
			System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
			if (sectionPassed)
				sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
			else {
				sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
				allPassed=false;
			}
			sectionNote.add("  ------------------------------------------------------");

			//-----------------------------
			if (planType.equals("SHIP")) {
				subSection="SHIP"; //note: ship has no sub-section
				sectionPassed=true; //note: reset - assume the section pass to begin with
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", "true"); 
				//docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				//sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				//planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			}

		} 

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);

		Assert.assertTrue("PROBLEM - not all FnR documents pass validation, see TEST NOTE in log for detail", allPassed);
	}


	@SuppressWarnings("unchecked")
	@Then("^user validate Forms and Resources section Prescription Drug Mail Order Form$")
	public void validateSection_FnR_ppmo(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Forms And Resources";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));
		boolean presDrugMailOrderFormDisplay=Boolean.valueOf(memberAttributesMap.get("Prescription Drug Mail Order Form"));

		if (!sectionDisplay && presDrugMailOrderFormDisplay) {
			Assert.assertTrue("PROBLEM - logic error with input setup, please check sceanrio input.  If sectionDisplay is false, searchMedicalEobHsitoryDisplay or searchDrugEobHsitoryDisplay doesn't make sense to have true", false);
		}

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);

		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_FnR(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");
		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_FnR(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		boolean allPassed=true;
		List<String> targetDocList=new ArrayList<String>();
		List<String> docSection_note=new ArrayList<String>();
		String subSection="";
		boolean sectionPassed=false;
		if (sectionDisplay) { //note: list of items
			//-----------------------------
			if (planType.equals("SHIP")) {
				subSection="SHIP"; //note: ship has no sub-section
				sectionPassed=true; //note: reset - assume the section pass to begin with
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", "true"); 
				//docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				//sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				//planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			}

			if (presDrugMailOrderFormDisplay) {
				//-----------------------------
				subSection="Prescription Drug Mail Order Form";
				sectionPassed=true; //note: reset - assume the section pass to begin with
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", String.valueOf(presDrugMailOrderFormDisplay));
				docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			} 
		}

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);

		Assert.assertTrue("PROBLEM - not all FnR documents pass validation, see TEST NOTE in log for detail", allPassed);
	}

	@SuppressWarnings("unchecked")
	@Then("^user validate Forms and Resources section Premium Payment Information$")
	public void validateSection_FnR_ppi(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Forms And Resources";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));
		boolean premiumPaymentInfoDisplay=Boolean.valueOf(memberAttributesMap.get("Premium Payment Information"));

		if (!sectionDisplay && premiumPaymentInfoDisplay) {
			Assert.assertTrue("PROBLEM - logic error with input setup, please check sceanrio input.  If sectionDisplay is false, searchMedicalEobHsitoryDisplay or searchDrugEobHsitoryDisplay doesn't make sense to have true", false);
		}

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);

		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_FnR(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");
		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_FnR(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		boolean allPassed=true;
		List<String> targetDocList=new ArrayList<String>();
		List<String> docSection_note=new ArrayList<String>();
		String subSection="";
		boolean sectionPassed=false;
		if (sectionDisplay) { //note: list of items
			if (premiumPaymentInfoDisplay) {
				//-----------------------------
				subSection="Premium Payment Information";
				sectionPassed=true;
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", String.valueOf(premiumPaymentInfoDisplay));
				docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			}

			//-----------------------------
			if (planType.equals("SHIP")) {
				subSection="SHIP"; //note: ship has no sub-section
				sectionPassed=true; //note: reset - assume the section pass to begin with
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", "true"); 
				//docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				//sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				//planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			}
		} 

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);

		Assert.assertTrue("PROBLEM - not all FnR documents pass validation, see TEST NOTE in log for detail", allPassed);
	}

	@SuppressWarnings("unchecked")
	@Then("^user validate Forms and Resources section Reimbursement Forms$")
	public void validateSection_FnR_rf(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Forms And Resources";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));
		boolean reimbursementFormsDisplay=Boolean.valueOf(memberAttributesMap.get("Reimbursement Forms"));

		if (!sectionDisplay && reimbursementFormsDisplay) {
			Assert.assertTrue("PROBLEM - logic error with input setup, please check sceanrio input.  If sectionDisplay is false, searchMedicalEobHsitoryDisplay or searchDrugEobHsitoryDisplay doesn't make sense to have true", false);
		}

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);

		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_FnR(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");
		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_FnR(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		boolean allPassed=true;
		List<String> targetDocList=new ArrayList<String>();
		List<String> docSection_note=new ArrayList<String>();
		String subSection="";
		boolean sectionPassed=false;
		if (sectionDisplay) { //note: list of items
			if (reimbursementFormsDisplay) {
				//-----------------------------
				subSection="Reimbursement Forms";
				sectionPassed=true; //note: reset - assume the section pass to begin with
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", String.valueOf(reimbursementFormsDisplay));
				docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			}
			//-----------------------------
			if (planType.equals("SHIP")) {
				subSection="SHIP"; //note: ship has no sub-section
				sectionPassed=true; //note: reset - assume the section pass to begin with
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", "true"); 
				//docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				//sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				//planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			}
		} 

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);

		Assert.assertTrue("PROBLEM - not all FnR documents pass validation, see TEST NOTE in log for detail", allPassed);
	}

	@SuppressWarnings("unchecked")
	@Then("^user validate Forms and Resources section Authorization Forms and Information$")
	public void validateSection_FnR_afni(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Forms And Resources";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));
		boolean authFormsAndInfoDisplay=Boolean.valueOf(memberAttributesMap.get("Authorization Forms and Information"));

		if (!sectionDisplay && authFormsAndInfoDisplay) {
			Assert.assertTrue("PROBLEM - logic error with input setup, please check sceanrio input.  If sectionDisplay is false, searchMedicalEobHsitoryDisplay or searchDrugEobHsitoryDisplay doesn't make sense to have true", false);
		}

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);

		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_FnR(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");
		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_FnR(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		boolean allPassed=true;
		List<String> targetDocList=new ArrayList<String>();
		List<String> docSection_note=new ArrayList<String>();
		String subSection="";
		boolean sectionPassed=false;
		if (sectionDisplay) { //note: list of items
			if (authFormsAndInfoDisplay) {
				//-----------------------------
				subSection="Authorization Forms and Information";
				sectionPassed=true; //note: reset - assume the section pass to begin with
				if (memberType.toUpperCase().contains("GROUP")) 
					subSection="Authorization Forms";
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", String.valueOf(authFormsAndInfoDisplay));
				docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			}

			//-----------------------------
			if (planType.equals("SHIP")) {
				subSection="SHIP"; //note: ship has no sub-section
				sectionPassed=true; //note: reset - assume the section pass to begin with
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", "true"); 
				//docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				//sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				//planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			}

		} 

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);

		Assert.assertTrue("PROBLEM - not all FnR documents pass validation, see TEST NOTE in log for detail", allPassed);
	}

	@SuppressWarnings("unchecked")
	@Then("^user validate Forms and Resources section Medication Authorization Forms$")
	public void validateSection_FnR_maf(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Forms And Resources";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));
		boolean medicationAuthFormsDisplay=Boolean.valueOf(memberAttributesMap.get("Medication Authorization Forms"));

		if (!sectionDisplay && medicationAuthFormsDisplay) {
			Assert.assertTrue("PROBLEM - logic error with input setup, please check sceanrio input.  If sectionDisplay is false, searchMedicalEobHsitoryDisplay or searchDrugEobHsitoryDisplay doesn't make sense to have true", false);
		}

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);

		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_FnR(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");
		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_FnR(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		boolean allPassed=true;
		List<String> targetDocList=new ArrayList<String>();
		List<String> docSection_note=new ArrayList<String>();
		String subSection="";
		boolean sectionPassed=false;
		if (sectionDisplay) { //note: list of items
			if (medicationAuthFormsDisplay) {
				//-----------------------------
				subSection="Medication Authorization Forms";
				sectionPassed=true; //note: reset - assume the section pass to begin with
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", String.valueOf(medicationAuthFormsDisplay));
				docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			}
			//-----------------------------
			if (planType.equals("SHIP")) {
				subSection="SHIP"; //note: ship has no sub-section
				sectionPassed=true; //note: reset - assume the section pass to begin with
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", "true"); 
				//docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				//sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				//planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			}
		} 

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);

		Assert.assertTrue("PROBLEM - not all FnR documents pass validation, see TEST NOTE in log for detail", allPassed);
	}

	@SuppressWarnings("unchecked")
	@Then("^user validate Forms and Resources section Other Resources$")
	public void validateSection_FnR_or(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Forms And Resources";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));
		boolean otherResourcesDisplay=Boolean.valueOf(memberAttributesMap.get("Other Resources"));

		if (!sectionDisplay && otherResourcesDisplay) {
			Assert.assertTrue("PROBLEM - logic error with input setup, please check sceanrio input.  If sectionDisplay is false, searchMedicalEobHsitoryDisplay or searchDrugEobHsitoryDisplay doesn't make sense to have true", false);
		}

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);

		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_FnR(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");
		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_FnR(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		boolean allPassed=true;
		List<String> targetDocList=new ArrayList<String>();
		List<String> docSection_note=new ArrayList<String>();
		String subSection="";
		boolean sectionPassed=false;
		if (sectionDisplay) { //note: list of items
			if (otherResourcesDisplay) {
				//-----------------------------
				subSection="Other Resources";
				sectionPassed=true; //note: reset - assume the section pass to begin with
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", String.valueOf(otherResourcesDisplay));
				docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			}

			//-----------------------------
			if (planType.equals("SHIP")) {
				subSection="SHIP"; //note: ship has no sub-section
				sectionPassed=true; //note: reset - assume the section pass to begin with
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", "true"); 
				//docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				//sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				//planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			}
		} 

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);

		Assert.assertTrue("PROBLEM - not all FnR documents pass validation, see TEST NOTE in log for detail", allPassed);
	}

	@SuppressWarnings("unchecked")
	@Then("^user validate Forms and Resources section Other Resources Part1of2$")
	public void validateSection_FnR_or_p1of2(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Forms And Resources";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));
		boolean otherResourcesDisplay=Boolean.valueOf(memberAttributesMap.get("Other Resources"));

		if (!sectionDisplay && otherResourcesDisplay) {
			Assert.assertTrue("PROBLEM - logic error with input setup, please check sceanrio input.  If sectionDisplay is false, searchMedicalEobHsitoryDisplay or searchDrugEobHsitoryDisplay doesn't make sense to have true", false);
		}

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);

		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_FnR(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");
		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_FnR(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		boolean allPassed=true;
		List<String> targetDocList=new ArrayList<String>();
		List<String> docSection_note=new ArrayList<String>();
		String subSection="";
		boolean sectionPassed=false;
		if (sectionDisplay) { //note: list of items
			if (otherResourcesDisplay) {
				//-----------------------------
				subSection="Other Resources Part1of2";
				sectionPassed=true; //note: reset - assume the section pass to begin with
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", String.valueOf(otherResourcesDisplay));
				docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			}

			//-----------------------------
			if (planType.equals("SHIP")) {
				subSection="SHIP"; //note: ship has no sub-section
				sectionPassed=true; //note: reset - assume the section pass to begin with
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", "true"); 
				//docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				//sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				//planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			}
		} 

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);

		Assert.assertTrue("PROBLEM - not all FnR documents pass validation, see TEST NOTE in log for detail", allPassed);
	}

	@SuppressWarnings("unchecked")
	@Then("^user validate Forms and Resources section Other Resources Part2of2$")
	public void validateSection_FnR_or_p2of2(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Forms And Resources";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));
		boolean otherResourcesDisplay=Boolean.valueOf(memberAttributesMap.get("Other Resources"));

		if (!sectionDisplay && otherResourcesDisplay) {
			Assert.assertTrue("PROBLEM - logic error with input setup, please check sceanrio input.  If sectionDisplay is false, searchMedicalEobHsitoryDisplay or searchDrugEobHsitoryDisplay doesn't make sense to have true", false);
		}

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);

		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_FnR(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");
		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_FnR(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		boolean allPassed=true;
		List<String> targetDocList=new ArrayList<String>();
		List<String> docSection_note=new ArrayList<String>();
		String subSection="";
		boolean sectionPassed=false;
		if (sectionDisplay) { //note: list of items
			if (otherResourcesDisplay) {
				//-----------------------------
				subSection="Other Resources Part2of2";
				sectionPassed=true; //note: reset - assume the section pass to begin with
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", String.valueOf(otherResourcesDisplay));
				docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			}

			//-----------------------------
			if (planType.equals("SHIP")) {
				subSection="SHIP"; //note: ship has no sub-section
				sectionPassed=true; //note: reset - assume the section pass to begin with
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", "true"); 
				//docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				//sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				//planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			}
		} 

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);

		Assert.assertTrue("PROBLEM - not all FnR documents pass validation, see TEST NOTE in log for detail", allPassed);
	}

	@SuppressWarnings("unchecked")
	@Then("^user validate Forms and Resources section Disenrollment Information$")
	public void validateSection_FnR_di(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Forms And Resources";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));
		boolean disenrollmentInfoDisplay=Boolean.valueOf(memberAttributesMap.get("Disenrollment Information"));

		if (!sectionDisplay && disenrollmentInfoDisplay) {
			Assert.assertTrue("PROBLEM - logic error with input setup, please check sceanrio input.  If sectionDisplay is false, searchMedicalEobHsitoryDisplay or searchDrugEobHsitoryDisplay doesn't make sense to have true", false);
		}

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);

		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_FnR(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");
		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_FnR(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		boolean allPassed=true;
		List<String> targetDocList=new ArrayList<String>();
		List<String> docSection_note=new ArrayList<String>();
		String subSection="";
		boolean sectionPassed=false;
		if (sectionDisplay) { //note: list of items
			if (disenrollmentInfoDisplay) {
				//-----------------------------
				subSection="Disenrollment";
				sectionPassed=true; //note: reset - assume the section pass to begin with
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", String.valueOf(disenrollmentInfoDisplay));
				docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			}

			//-----------------------------
			if (planType.equals("SHIP")) {
				subSection="SHIP"; //note: ship has no sub-section
				sectionPassed=true; //note: reset - assume the section pass to begin with
				testInputInfoMap.put("subSection", subSection);
				testInputInfoMap.put("expDisplay_FnR", "true"); 
				//docSection_note=planDocumentsAndResourcesPage.validate_section_FnR(testInputInfoMap);
				//sectionNote.addAll(docSection_note);

				if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) 
					targetDocList=userHelperProd.getTargetDocList(planType, memberType, section, subSection);
				else
					targetDocList=userHelper.getTargetDocList(planType, memberType, section, subSection);
				for(String doc: targetDocList) {
					testInputInfoMap=docHelper_FnR.updateTestInputInfoMap(testInputInfoMap, doc);
					docSection_note=planDocumentsAndResourcesPage.validateDocs_FnR(testInputInfoMap);
					sectionNote.addAll(docSection_note);
					if (!planDocumentsAndResourcesPage.determineSectionResult(docSection_note))
						sectionPassed=false;
				}
				//planDocumentsAndResourcesPage.collapse_section_FnR(testInputInfoMap);
				System.out.println("Finished validation documents in sub-section '"+subSection+"' in '"+section+"' section...moving onto next step...");
				if (sectionPassed)
					sectionNote.add("  PASSED - subsection '"+subSection+"' documents validation");
				else {
					sectionNote.add("  FAILED - subsection '"+subSection+"' documents validation");
					allPassed=false;
				}
				sectionNote.add("  ------------------------------------------------------");
			}

		} 

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);

		Assert.assertTrue("PROBLEM - not all FnR documents pass validation, see TEST NOTE in log for detail", allPassed);
	}

	@SuppressWarnings("unchecked")
	@Then("^user sanity validate Forms and Resources section$")
	public void validateSection_FnR_sanity(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Forms And Resources";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);

		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_FnR(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");
		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_FnR(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);		
	}


	@SuppressWarnings("unchecked")
	@Then("^user validate Renew Magazine section$")
	public void validateSection_RM(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Renew Magazine";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);
		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_RM(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");

		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_RM(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		//note: text box and button
		String currentYear= (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_CURRENT_YEAR);
		planDocumentsAndResourcesPage.valiateCurrentIssue_RM(testInputInfoMap, sectionDisplay, currentYear);
		sectionNote.add("PASSED - Current Issue validation");
		planDocumentsAndResourcesPage.valiatePreviousIssue_RM(testInputInfoMap, sectionDisplay);
		sectionNote.add("PASSED - Previous Issue validation");

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);		
	}

	@SuppressWarnings("unchecked")
	@Then("^user sanity validate Renew Magazine section$")
	public void validateSection_RM_sanity(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		String section="Renew Magazine";
		List<String> sectionNote=new ArrayList<String>();
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");

		//--------------
		boolean sectionDisplay=Boolean.valueOf(memberAttributesMap.get("Section Display"));

		//--------------
		HashMap<String, String> testInputInfoMap=(HashMap<String, String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_INPUT_INFO);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		//note: first go back to top of the page
		planDocumentsAndResourcesPage.backToTopOfPage(planType, memberType);
		testInputInfoMap.put("section", section);

		//note: validate jumplink
		planDocumentsAndResourcesPage.validateJumplink_RM(sectionDisplay);
		sectionNote.add("PASSED - jumplink validation");

		//note: validate section header
		planDocumentsAndResourcesPage.validateSectionHeader_RM(sectionDisplay);
		sectionNote.add("PASSED - section header validation");

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);		
	}

	@SuppressWarnings("unchecked")
	@Then("^user validate Adobe section$")
	public void validateSection_Adobe() {
		List<String> sectionNote=new ArrayList<String>();
		String section="Adobe";
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		planDocumentsAndResourcesPage.validateAdobePdfDocText();
		sectionNote.add("PASSED - section '"+section+"' validation");

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);		
	}

	@SuppressWarnings("unchecked")
	@Then("^user validate Need Help section$")
	public void validateSection_NeedHelp() {
		List<String> sectionNote=new ArrayList<String>();
		String section="Need Help";
		sectionNote.add("\n===============================================================================");
		sectionNote.add("Validation result for section='"+section+"'");
		String planType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_PLAN_TYPE);
		String memberType = (String) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_MEMBER_TYPE);
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		planDocumentsAndResourcesPage.validateSectionInNeedHelp(planType, memberType);
		sectionNote.add("PASSED - section '"+section+"' validation");

		List<String> noteList=(List<String>) getLoginScenario().getBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE);
		if (noteList==null)
			noteList=new ArrayList<String>();
		noteList.addAll(sectionNote);
		getLoginScenario().saveBean(PlanDocumentsAndResourcesCommonConstants.TEST_RESULT_NOTE, noteList);		
	}
	
	@Then("^user validates text as NEW for Plan documents under Plan Materials$")
	public void validate_NEW_Text_Plan_Documents() {
		PlanDocumentsAndResourcesPage planDocumentsAndResourcesPage=(PlanDocumentsAndResourcesPage) getLoginScenario().getBean(PageConstants.PLAN_DOCUMENTS_AND_RESOURCES_PAGE);
		planDocumentsAndResourcesPage.validateNEWTextAgainstPlanDocument();
	}
}
