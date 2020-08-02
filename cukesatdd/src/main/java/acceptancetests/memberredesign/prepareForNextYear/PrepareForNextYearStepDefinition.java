package acceptancetests.memberredesign.prepareForNextYear;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.HashMap;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.prepareForNextYear.AemPage;
import pages.regression.prepareForNextYear.PrepareForNextYearPage;

public class PrepareForNextYearStepDefinition {
	
	protected static Boolean validateAsMuchAsPossible=false;
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	static final String aemUrl="http://author-team-atest.ocp-elr-core-nonprod.optum.com/cf#/content/medicare/member.html";

	public static Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), 
					memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}	

	//note: added code to print test results note in jenkins report at the end of test for successful cases
	@cucumber.api.java.After
	public void testResultNote(Scenario scenario) { 
		if(null!=getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE)) {   
			@SuppressWarnings("unchecked")   
			List<String> testNote=(List<String>) getLoginScenario()
			.getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
			for (String s: testNote) {   
				scenario.write(s);
			}
			testNote.clear(); 
		}
	}

	@cucumber.api.java.After
	@SuppressWarnings("unchecked")
	public void finalCheckSysDate(Scenario scenario) { 
		if (!MRScenario.environment.contains("team-a")) {
			return;
		}		

		boolean needRollBackTime=false;
		if (getLoginScenario().getBean(PrepareForNextYearCommonConstants.END_OF_TEST_ROLL_BACK_TIME) != null)
			needRollBackTime=(Boolean) getLoginScenario().getBean(PrepareForNextYearCommonConstants.END_OF_TEST_ROLL_BACK_TIME);
		if (needRollBackTime) {
			WebDriver wd = getLoginScenario().getWebDriverNew();
			wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  

			PrepareForNextYearPage pfnyPg = new PrepareForNextYearPage(wd);

			Date orig_currentDate=(Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.ORIG_CURRENT_SYSTEM_DATE);
			Long orig_currentDate_millisec=(Long) getLoginScenario().getBean(PrepareForNextYearCommonConstants.ORIG_CURRENT_SYSTEM_DATE_MILLISEC);

			List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
			if (testNote==null)
				testNote=new ArrayList<String>();
			String text="===================================================";
			testNote.add(text);
			System.out.println(text);
			Date currentDate=pfnyPg.getCurrentSystemDate();
			if (orig_currentDate!=null) {
				System.out.println("orig_currentDate != null, need to do a final check to make sure system date is back to original date");
				if (!orig_currentDate.equals(currentDate)) {
					String dateChangeUrl="http://ucp-user-management-team-atest.ocp-elr-core-nonprod.optum.com/UCPUserManagement/zadmin/time/joda?millis="+orig_currentDate_millisec;
					System.out.println("TEST dateChangeUrl="+dateChangeUrl);
					wd.get(dateChangeUrl);
					CommonUtility.checkPageIsReady(wd);
					pfnyPg.sleepBySec(2);
					currentDate=pfnyPg.getCurrentSystemDate();
					Assert.assertTrue("PROBLEM - unable to convert 'Test System Date' to valid Date object for further processing", currentDate!=null);
					Assert.assertTrue("PROBLEM - unable to rollback system date to original system date.  "
							+ "current system date='"+pfnyPg.convertDateToStrFormat_MMDDYYYY(currentDate)+"' | attemp to rollback to original date='"+pfnyPg.convertDateToStrFormat_MMDDYYYY(orig_currentDate)+"'", 
							pfnyPg.convertDateToStrFormat_MMDDYYYY(currentDate).equals(pfnyPg.convertDateToStrFormat_MMDDYYYY(orig_currentDate)));
				}
				text="Test Clean up - Final Check - System Date is able to roll back to original ='"+pfnyPg.convertDateToStrFormat_MMDDYYYY(orig_currentDate)+"' or millsec '"+pfnyPg.convertDateToUctMillisecondsStr(orig_currentDate)+"'";
				testNote.add(text);
				System.out.println(text);
				getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
			} else {
				System.out.println("TEST - orig_currentDate=null, assume no date changed involved, no need to do final check");
			}
			wd.quit();
		} else {
			System.out.println("TEST - skip final system date check");
		}
	}

	
	@SuppressWarnings("unchecked")
	@Then("^the user validates Prepare For Next Year tab display behavior on Benefits page$")
	public void user_toBenefits_validateTabBasedOnFeatureFileInput() throws InterruptedException {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);

		PrepareForNextYearPage pfnyPg = new PrepareForNextYearPage(wd);

		Date tabStartDate =(Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.AEM_TabStartDate);	
		Date tabEndDate = (Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.AEM_TabEndDate);	
		boolean aem_tabToggle = (Boolean) getLoginScenario().getBean(PrepareForNextYearCommonConstants.AEM_TOGGLE);	

		Date currentDate=pfnyPg.getCurrentSystemDate();

		Assert.assertTrue("PROBLEM - unable to convert Current System Date Time: '"+currentDate+"' to valid Date object for further processing", currentDate!=null);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.CURRENT_SYSTEM_DATE, currentDate);	

		//note: if tabStartDate<= currentDate <= tabEndDate && toggle=ON
		boolean expPrepareForNextYearTab=true;
		if (tabStartDate.after(currentDate)|| tabEndDate.before(currentDate)) 
			expPrepareForNextYearTab=false;
		if ((tabStartDate.before(currentDate) || tabStartDate.equals(currentDate)) 
				&& (tabEndDate.after(currentDate) || tabEndDate.equals(currentDate)) 
				&& (!aem_tabToggle))	
			expPrepareForNextYearTab=false;
		if (planType.toUpperCase().contains("SHIP") || memberType.toUpperCase().contains("COMBO") || memberType.toUpperCase().contains("PREEFF") || memberType.toUpperCase().contains("TERM")) 
			expPrepareForNextYearTab=false;
		if (memberType.toUpperCase().contains("GRP") && memberType.toUpperCase().contains("OFFCYC"))
			expPrepareForNextYearTab=false;
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.EXPECT_PREPARE_FOR_NEXT_YEAR_TAB, expPrepareForNextYearTab);	

		List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="Coverage and Benefits";
		testNote.add("===================================================");
		if (MRScenario.returnJobURL()!=null)
			testNote.add("\tThis sauceLab session url: "+MRScenario.returnJobURL()+"\n");

		testNote.add("\tValidation for Prepare For Next Year tab on page '"+targetPage+"'");
		testNote.add("\t  AEM tab startDate ="+pfnyPg.convertDateToStrFormat_MMDDYYYY(tabStartDate));
		testNote.add("\t  AEM tab endDate ="+pfnyPg.convertDateToStrFormat_MMDDYYYY(tabEndDate));
		testNote.add("\t  AEM toggle ="+aem_tabToggle);
		testNote.add("\t  System Date ="+pfnyPg.convertDateToStrFormat_MMDDYYYY(currentDate));
		if (memberType.toUpperCase().contains("OFFCYC")) 
			testNote.add("\t  User plan start date type = offcycle");
		testNote.add("\t  Expect tab to show ="+expPrepareForNextYearTab);

		boolean expComboTab=false;
		if (memberType.toLowerCase().contains("combo"))
			expComboTab=true;
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.EXPECT_COMBO_TAB, expComboTab);

		wd=pfnyPg.navigateToBenefitsPage(planType, memberType, expComboTab);

		boolean hasPrepareForNextYearTab=pfnyPg.hasPrepareForNextYearTabDisplay(expPrepareForNextYearTab);
		if (expPrepareForNextYearTab==hasPrepareForNextYearTab) {
			if (expPrepareForNextYearTab)
				testNote.add("\tPASSED - Prepare For Next Year tab IS displaying on Benefits page sub navigation menu as expected");
			else
				testNote.add("\tPASSED - Prepare For Next Year tab IS NOT displaying on Benefits page sub navigation menu as expected");
		} else
			testNote.add("\tFAILED - Prepare For Next Year tab display behavior is not as expected on Benefits page sub navigation menu. Expected to display='"+expPrepareForNextYearTab+"' | Actual display='"+hasPrepareForNextYearTab+"'");
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);

		Assert.assertTrue("PROBLEM - Prepare For Next Year tab display behavior is not as expected.  Expected to display='"+expPrepareForNextYearTab+"' | Actual display='"+hasPrepareForNextYearTab+"'", expPrepareForNextYearTab==hasPrepareForNextYearTab);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}	
	

	@Then("^test setup stores documents expectation info$")
	public void storeDocInfo(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);

		String inputField="Show Next Year PlanName";
		String tmp=memberAttributesMap.get(inputField);
		Assert.assertTrue("PROBLEM - input '"+inputField+"' value should either be 'true' or 'false' | Actual='"+tmp+"', please correct and retry",tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean showNxtYrPlanName=Boolean.valueOf(tmp);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.SHOW_NEXT_YEAR_PLANNAME,showNxtYrPlanName);
		
		HashMap<String, Boolean> docDisplayMap=new HashMap<String, Boolean>();
		//----------------------------------
		String docName="Annual Notice of Changes";
		inputField=docName+" English";
		tmp=memberAttributesMap.get(inputField);
		Assert.assertTrue("PROBLEM - input '"+inputField+"' value should either be 'true' or 'false' | Actual='"+tmp+"', please correct and retry",tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean display=Boolean.valueOf(tmp);
		docDisplayMap.put(inputField, display);

		inputField=docName+" Spanish";
		tmp=memberAttributesMap.get(inputField);
		Assert.assertTrue("PROBLEM - input '"+inputField+"' value should either be 'true' or 'false' | Actual='"+tmp+"', please correct and retry",tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		display=Boolean.valueOf(tmp);
		docDisplayMap.put(inputField, display);
	
		inputField=docName+" Chinese";
		tmp=memberAttributesMap.get(inputField);
		Assert.assertTrue("PROBLEM - input '"+inputField+"' value should either be 'true' or 'false' | Actual='"+tmp+"', please correct and retry",tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		display=Boolean.valueOf(tmp);
		docDisplayMap.put(inputField, display);

		//----------------------------------
		docName="Evidence of Coverage";
		inputField=docName+" English";
		tmp=memberAttributesMap.get(inputField);
		Assert.assertTrue("PROBLEM - input '"+inputField+"' value should either be 'true' or 'false' | Actual='"+tmp+"', please correct and retry",tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		display=Boolean.valueOf(tmp);
		docDisplayMap.put(inputField, display);

		inputField=docName+" Spanish";
		tmp=memberAttributesMap.get(inputField);
		Assert.assertTrue("PROBLEM - input '"+inputField+"' value should either be 'true' or 'false' | Actual='"+tmp+"', please correct and retry",tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		display=Boolean.valueOf(tmp);
		docDisplayMap.put(inputField, display);
	
		inputField=docName+" Chinese";
		tmp=memberAttributesMap.get(inputField);
		Assert.assertTrue("PROBLEM - input '"+inputField+"' value should either be 'true' or 'false' | Actual='"+tmp+"', please correct and retry",tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		display=Boolean.valueOf(tmp);
		docDisplayMap.put(inputField, display);

		//----------------------------------
		docName="Comprehensive Formulary";
		inputField=docName+" English";
		tmp=memberAttributesMap.get(inputField);
		Assert.assertTrue("PROBLEM - input '"+inputField+"' value should either be 'true' or 'false' | Actual='"+tmp+"', please correct and retry",tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		display=Boolean.valueOf(tmp);
		docDisplayMap.put(inputField, display);

		inputField=docName+" Spanish";
		tmp=memberAttributesMap.get(inputField);
		Assert.assertTrue("PROBLEM - input '"+inputField+"' value should either be 'true' or 'false' | Actual='"+tmp+"', please correct and retry",tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		display=Boolean.valueOf(tmp);
		docDisplayMap.put(inputField, display);

		inputField=docName+" Chinese";
		tmp=memberAttributesMap.get(inputField);
		Assert.assertTrue("PROBLEM - input '"+inputField+"' value should either be 'true' or 'false' | Actual='"+tmp+"', please correct and retry",tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		display=Boolean.valueOf(tmp);
		docDisplayMap.put(inputField, display);
		

		//----------------------------------
		docName="Provider Directory";
		inputField=docName+" English";
		tmp=memberAttributesMap.get(inputField);
		Assert.assertTrue("PROBLEM - input '"+inputField+"' value should either be 'true' or 'false' | Actual='"+tmp+"', please correct and retry",tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		display=Boolean.valueOf(tmp);
		docDisplayMap.put(inputField, display);

		inputField=docName+" Spanish";
		tmp=memberAttributesMap.get(inputField);
		Assert.assertTrue("PROBLEM - input '"+inputField+"' value should either be 'true' or 'false' | Actual='"+tmp+"', please correct and retry",tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		display=Boolean.valueOf(tmp);
		docDisplayMap.put(inputField, display);

		inputField=docName+" Chinese";
		tmp=memberAttributesMap.get(inputField);
		Assert.assertTrue("PROBLEM - input '"+inputField+"' value should either be 'true' or 'false' | Actual='"+tmp+"', please correct and retry",tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		display=Boolean.valueOf(tmp);
		docDisplayMap.put(inputField, display);
		
		//----------------------------------
		docName="Vendor Information Sheet";
		inputField=docName+" English";
		tmp=memberAttributesMap.get(inputField);
		Assert.assertTrue("PROBLEM - input '"+inputField+"' value should either be 'true' or 'false' | Actual='"+tmp+"', please correct and retry",tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		display=Boolean.valueOf(tmp);
		docDisplayMap.put(inputField, display);

		inputField=docName+" Spanish";
		tmp=memberAttributesMap.get(inputField);
		Assert.assertTrue("PROBLEM - input '"+inputField+"' value should either be 'true' or 'false' | Actual='"+tmp+"', please correct and retry",tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		display=Boolean.valueOf(tmp);
		docDisplayMap.put(inputField, display);

		inputField=docName+" Chinese";
		tmp=memberAttributesMap.get(inputField);
		Assert.assertTrue("PROBLEM - input '"+inputField+"' value should either be 'true' or 'false' | Actual='"+tmp+"', please correct and retry",tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		display=Boolean.valueOf(tmp);
		docDisplayMap.put(inputField, display);
		
		//----------------------------------
		docName="Pharmacy Directory Information";
		inputField=docName+" English";
		tmp=memberAttributesMap.get(inputField);
		Assert.assertTrue("PROBLEM - input '"+inputField+"' value should either be 'true' or 'false' | Actual='"+tmp+"', please correct and retry",tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		display=Boolean.valueOf(tmp);
		docDisplayMap.put(inputField, display);

		inputField=docName+" Spanish";
		tmp=memberAttributesMap.get(inputField);
		Assert.assertTrue("PROBLEM - input '"+inputField+"' value should either be 'true' or 'false' | Actual='"+tmp+"', please correct and retry",tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		display=Boolean.valueOf(tmp);
		docDisplayMap.put(inputField, display);

		inputField=docName+" Chinese";
		tmp=memberAttributesMap.get(inputField);
		Assert.assertTrue("PROBLEM - input '"+inputField+"' value should either be 'true' or 'false' | Actual='"+tmp+"', please correct and retry",tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		display=Boolean.valueOf(tmp);
		docDisplayMap.put(inputField, display);

		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.DOC_DISPLAY_MAP, docDisplayMap);
	}

	

	@SuppressWarnings("unchecked")
	@Then("^the user validates Prepare For Next Year page content for individual$")
	public void user_validatePrepareForNextYearPageContent_individual() throws InterruptedException {

		boolean expPrepareForNextYearTab = (Boolean) getLoginScenario().getBean(PrepareForNextYearCommonConstants.EXPECT_PREPARE_FOR_NEXT_YEAR_TAB);	
		if (!expPrepareForNextYearTab) {
			List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
			if (testNote==null)
				testNote=new ArrayList<String>();
			testNote.add("\tNo tab show for this test setup, skipping Prepare For Next Year page content validation...");
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
			return;
		}
		//note: if able to get to this point means the page should exist
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  

		PrepareForNextYearPage pfnyPg = new PrepareForNextYearPage(wd);

		//note: validate Return to previous page link
		List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
		if (MRScenario.environment.contains("team-a")) {
			if (testNote==null)
				testNote=new ArrayList<String>();
			testNote.add("\t=================");
			pfnyPg.validateReturnToPrevPgLnk();
			testNote.add("\tPASSED - 'RETURN TO PREVIOUS PAGE' link behavior");
		}
		
		pfnyPg.validateAdobePdfDocText();
		testNote.add("\tPASSED - disclaimer 'This page contains PDF'");
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
		
		boolean showNxtYrPlanName=(Boolean) getLoginScenario().getBean(PrepareForNextYearCommonConstants.SHOW_NEXT_YEAR_PLANNAME);
		
		//note: validate timeline and Find update section content
		Date milestone1Date = (Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.MILESTONE1_DATE);
		Date milestone2Date = (Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.MILESTONE2_DATE);
		Date milestone3Date = (Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.MILESTONE3_DATE);
		Date milestone4Date = (Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.MILESTONE4_DATE);
		Date milestone5Date = (Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.MILESTONE5_DATE);

		Date currentDate=pfnyPg.getCurrentSystemDate();

		System.out.println("milestone1Date = "+pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone1Date));
		System.out.println("milestone2Date = "+pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone2Date));
		System.out.println("milestone3Date = "+pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone3Date));
		System.out.println("milestone4Date = "+pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone4Date));
		System.out.println("milestone5Date = "+pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone5Date));
		System.out.println("currentDate = "+pfnyPg.convertDateToStrFormat_MMDDYYYY(currentDate));
		
		Assert.assertTrue("PROBLEM - unable to convert Current System Date Time: '"+currentDate+"' to valid Date object for further processing", currentDate!=null);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.CURRENT_SYSTEM_DATE, currentDate);	


		testNote.add("\t=================");
		pfnyPg.hasPrepareForNextYearTabDisplay(true);
		testNote.add("\tPASSED - benefits sub menu tabs is displayed on Prepare For Next Year page");

		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		HashMap<String, Boolean> docDisplayMap=(HashMap<String, Boolean>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.DOC_DISPLAY_MAP);

		List<String> sectionNote=new ArrayList<String>();
		if (currentDate.before(milestone1Date)) {
			System.out.println("TEST - 1");
			testNote.add("\tValidation for current date '"+pfnyPg.convertDateToStrFormat_MMDDYYYY(currentDate)+"' < milestone 1 '"+pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone1Date)+"'");
			sectionNote=pfnyPg.validateBefM1Content(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
		} else if ((currentDate.after(milestone1Date) || currentDate.equals(milestone1Date)) && currentDate.before(milestone2Date)) {
			System.out.println("TEST - 2");
			testNote.add("\tValidation for milestone 1 '"+pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone1Date)+"' <= current date '"+pfnyPg.convertDateToStrFormat_MMDDYYYY(currentDate)+"' < milestone 2 '"+pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone2Date)+"'");
			sectionNote=pfnyPg.validateAftOrEqM1BefM2Content(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
		} else if ((currentDate.after(milestone2Date) || currentDate.equals(milestone2Date)) && currentDate.before(milestone3Date)) {
			System.out.println("TEST - 3");
			testNote.add("\t  Validation for milestone 2 '"+pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone2Date)+"' <= current date '"+pfnyPg.convertDateToStrFormat_MMDDYYYY(currentDate)+"' < milestone 3 '"+pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone3Date)+"'");
			sectionNote=pfnyPg.validateAftOrEqM2BefM3Content(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
		} else if ((currentDate.after(milestone3Date) || currentDate.equals(milestone3Date)) && currentDate.before(milestone4Date)) {
			System.out.println("TEST - 4");
			testNote.add("\tValidation for milestone 3 '"+pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone3Date)+"'<= current date '"+pfnyPg.convertDateToStrFormat_MMDDYYYY(currentDate)+"' < milestone 4 '"+pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone4Date)+"'");
			sectionNote=pfnyPg.validateAftOrEqM3BefM4Content(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
		} else if ((currentDate.after(milestone4Date) || currentDate.equals(milestone4Date)) && currentDate.before(milestone5Date)) {
			System.out.println("TEST - 5");
			testNote.add("\tValidation for milestone 4 '"+pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone4Date)+"' <= current date '"+pfnyPg.convertDateToStrFormat_MMDDYYYY(currentDate)+"' < milestone 5 '"+pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone5Date)+"'");
			sectionNote=pfnyPg.validateAftOrEqM4BefM5Content(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
		} else if (currentDate.after(milestone5Date) || currentDate.equals(milestone5Date)) {
			System.out.println("TEST - 6");
			testNote.add("\tValidation for milestone 5 '"+pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone5Date)+"' <= current date '"+pfnyPg.convertDateToStrFormat_MMDDYYYY(currentDate)+"'");
			sectionNote=pfnyPg.validateAfterOrEqalM5Content(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
		} else {
			Assert.assertTrue("PROBLEM - shouldn't be here, please check whether the milestone input dates are corrected...", false);
		}
		testNote.addAll(sectionNote);

		boolean finalCheck=true;
		for(String s: testNote) {
			if (s.contains("FAILED")) {
				finalCheck=false;
				break;
			}
		}
		testNote.add("\t=================");
		if (finalCheck)
			testNote.add("\tPASSED - page content validation");
		else 
			testNote.add("\t * FAILED - page content validation");
			
		//tbd testNote.add("\t=================");
		//tbd testNote.add("\tPASSED - page content validation");
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
		
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		Assert.assertTrue("PROBLEM - encountered FAILED validation during test, please review TEST NOTE for detail", finalCheck);
		
	}	

	@SuppressWarnings("unchecked")
	@Then("^the user navigate to Prepare For Next Year page via Prepare For Next Year tab$")
	public void user_toPrepareForNextYearPg() throws InterruptedException {
		boolean expPrepareForNextYearTab = (Boolean) getLoginScenario().getBean(PrepareForNextYearCommonConstants.EXPECT_PREPARE_FOR_NEXT_YEAR_TAB);	
		if (!expPrepareForNextYearTab) {
			List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
			if (testNote==null)
				testNote=new ArrayList<String>();
			testNote.add("\tNo tab show for this test setup, skipping navigation to Prepare For Next Year page step...");
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
			return;
		}
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		PrepareForNextYearPage pfnyPg = new PrepareForNextYearPage(wd); //note: at this point still on benefits page
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		boolean expComboTab=(Boolean) getLoginScenario().getBean(PrepareForNextYearCommonConstants.EXPECT_COMBO_TAB);

		pfnyPg.fromBenefitsPgNavigateToPrepareForNextYearPage(planType, memberType, expComboTab);
		pfnyPg.setValidateAsMuchAsPossible(validateAsMuchAsPossible);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.PREPARE_FOR_NEXT_YEAR_PAGE, pfnyPg);	
	}
	
	
	
	@SuppressWarnings("unchecked")
	@Then("^the user validate bookmark behavior if tab hasn't met the condition to be displayed$")
	public void validateBookmark() {
		boolean expPrepareForNextYearTab = (Boolean) getLoginScenario().getBean(PrepareForNextYearCommonConstants.EXPECT_PREPARE_FOR_NEXT_YEAR_TAB);	
		List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		if (!expPrepareForNextYearTab) {
			testNote.add("\tValidate bookmark behavior when tab hasn't met the condition to be displayed...");
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
			WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
			wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  

			PrepareForNextYearPage pfnyPg = new PrepareForNextYearPage(wd);
			pfnyPg.validateBookmarkError();
			
		} else {
			testNote.add("\tPrepare For Next Year tab is showing, skip bookmark error validation when tab hasn't met the condition to be displayed...");
			
		}
	}

	//---------------------------------------------------
	//----- begin - test setup for date changing on test environment
	//---------------------------------------------------
	@SuppressWarnings("unchecked")
	@Then("^test setup stores original system date for roll back later$")
	public void storeOriginalSysDate() {
		if (!MRScenario.environment.contains("team-a")) {
			Assert.assertTrue("PROBLEM - will only work with system time change on team env.  You are trying to run this on env='"+MRScenario.environment+"', aborting test now", false);
			return;
		}		

		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		PrepareForNextYearPage pfnyPg = new PrepareForNextYearPage(wd);
		
		Date currentDate=pfnyPg.getCurrentSystemDate();
		Assert.assertTrue("PROBLEM - unable to convert 'Test System Date' to valid Date object for further processing", currentDate!=null);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.ORIG_CURRENT_SYSTEM_DATE, currentDate);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.ORIG_CURRENT_SYSTEM_DATE_MILLISEC, pfnyPg.convertDateToUctMillisecondsStr(currentDate));

		List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String text="===================================================";
		testNote.add(text);
		System.out.println(text);
		text="Test Setup - Store original current system date for roll back later.  Original current system date='"+pfnyPg.convertDateToStrFormat_MMDDYYYY(currentDate)+"' | milliseconds='"+pfnyPg.convertDateToUctMillisecondsStr(currentDate)+"'";
		testNote.add(text);
		System.out.println(text);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
	}
	
	@SuppressWarnings("unchecked")
	@Then("^test setup changes system date to before AEM start date$")
	public void setupSysDateBeforeAemStartDate(DataTable memberAttributes) {
		if (!MRScenario.environment.contains("team-a")) {
			Assert.assertTrue("PROBLEM - will only work with system time change on team env.  You are trying to run this on env='"+MRScenario.environment+"', aborting test now", false);
			return;
		}		
		Date tabStartDate =(Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.AEM_TabStartDate);	
		
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		PrepareForNextYearPage pfnyPg = new PrepareForNextYearPage(wd);

		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String testSystemDateStr=memberAttributesMap.get("Test System Date");
		Date testSystemDate=pfnyPg.convertStrToDate(testSystemDateStr);

		String sysDate=pfnyPg.convertDateToStrFormat_MMDDYYYY(testSystemDate);
		String sysDate_ms=String.valueOf(pfnyPg.convertDateToUctMillisecondsStr(testSystemDate));
		String aemDate=pfnyPg.convertDateToStrFormat_MMDDYYYY(tabStartDate);
		
		List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String text="===================================================";
		testNote.add(text);
		System.out.println(text);
		text="Test Setup - System date '"+sysDate+"' or millsec '"+sysDate_ms+"'  < AEM start date '"+aemDate+"'";
		testNote.add(text);
		System.out.println(text);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);

		changeSystemDate(testSystemDate);
	}
	
	@SuppressWarnings("unchecked")
	@Then("^test setup changes system date to after AEM start date before milestone1 date$")
	public void setupSysDateAfterOrEqualAemBeforeM1(DataTable memberAttributes) {
		if (!MRScenario.environment.contains("team-a")) {
			Assert.assertTrue("PROBLEM - will only work with system time change on team env.  You are trying to run this on env='"+MRScenario.environment+"', aborting test now", false);
			return;
		}		

		Date tabStartDate =(Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.AEM_TabStartDate);	
		Date milestone1Date = (Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.MILESTONE1_DATE);
		
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		PrepareForNextYearPage pfnyPg = new PrepareForNextYearPage(wd);

		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String testSystemDateStr=memberAttributesMap.get("Test System Date");
		Date testSystemDate=pfnyPg.convertStrToDate(testSystemDateStr);

		String sysDate=pfnyPg.convertDateToStrFormat_MMDDYYYY(testSystemDate);
		String sysDate_ms=String.valueOf(pfnyPg.convertDateToUctMillisecondsStr(testSystemDate));
		String aemDate=pfnyPg.convertDateToStrFormat_MMDDYYYY(tabStartDate);
		String m1Date=pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone1Date);
		
		List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String text="===================================================";
		testNote.add(text);
		System.out.println(text);
		text="Test Setup - AEM start date '"+aemDate+"' <= System date '"+sysDate+"' or millsec '"+sysDate_ms+"'  < milestone1 date '"+m1Date+"'";
		testNote.add(text);
		System.out.println(text);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);

		changeSystemDate(testSystemDate);
	}
	
	@SuppressWarnings("unchecked")
	@Then("^test setup changes system date to after or equal milestone1 date and before milestone2$")
	public void setupSysDateAfterOrEqualM1BeforeM2(DataTable memberAttributes) {
		if (!MRScenario.environment.contains("team-a")) {
			Assert.assertTrue("PROBLEM - will only work with system time change on team env.  You are trying to run this on env='"+MRScenario.environment+"', aborting test now", false);
			return;
		}		

		Date milestone1Date = (Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.MILESTONE1_DATE);
		Date milestone2Date = (Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.MILESTONE2_DATE);

		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		PrepareForNextYearPage pfnyPg = new PrepareForNextYearPage(wd);

		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String testSystemDateStr=memberAttributesMap.get("Test System Date");
		Date testSystemDate=pfnyPg.convertStrToDate(testSystemDateStr);

		String sysDate=pfnyPg.convertDateToStrFormat_MMDDYYYY(testSystemDate);
		String sysDate_ms=String.valueOf(pfnyPg.convertDateToUctMillisecondsStr(testSystemDate));
		String m1Date=pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone1Date);
		String m2Date=pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone2Date);
		
		List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String text="===================================================";
		testNote.add(text);
		System.out.println(text);
		text="Test Setup - milestone1 date '"+m1Date+"' <= System date '"+sysDate+"' or millsec '"+sysDate_ms+"'  < milestone2 date '"+m2Date+"'";
		testNote.add(text);
		System.out.println(text);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);

		changeSystemDate(testSystemDate);
	}
	
	@SuppressWarnings("unchecked")
	@Then("^test setup changes system date to after or equal milestone2 date and before milestone3$")
	public void setupSysDateAfterOrEqualM2BeforeM3(DataTable memberAttributes) {
		if (!MRScenario.environment.contains("team-a")) {
			Assert.assertTrue("PROBLEM - will only work with system time change on team env.  You are trying to run this on env='"+MRScenario.environment+"', aborting test now", false);
			return;
		}		
		Date milestone2Date = (Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.MILESTONE2_DATE);
		Date milestone3Date = (Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.MILESTONE3_DATE);

		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		PrepareForNextYearPage pfnyPg = new PrepareForNextYearPage(wd);

		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String testSystemDateStr=memberAttributesMap.get("Test System Date");
		Date testSystemDate=pfnyPg.convertStrToDate(testSystemDateStr);

		String sysDate=pfnyPg.convertDateToStrFormat_MMDDYYYY(testSystemDate);
		String sysDate_ms=String.valueOf(pfnyPg.convertDateToUctMillisecondsStr(testSystemDate));
		String m2Date=pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone2Date);
		String m3Date=pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone3Date);
		
		List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String text="===================================================";
		testNote.add(text);
		System.out.println(text);
		text="Test Setup - milestone2 date '"+m2Date+"' <= System date '"+sysDate+"' or millsec '"+sysDate_ms+"'  < milestone3 date '"+m3Date+"'";
		testNote.add(text);
		System.out.println(text);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);

		changeSystemDate(testSystemDate);
	}

	@SuppressWarnings("unchecked")
	@Then("^test setup changes system date to after or equal milestone3 date and before milestone4$")
	public void setupSysDateAfterOrEqualM3BeforeM4(DataTable memberAttributes) {
		if (!MRScenario.environment.contains("team-a")) {
			Assert.assertTrue("PROBLEM - will only work with system time change on team env.  You are trying to run this on env='"+MRScenario.environment+"', aborting test now", false);
			return;
		}		
		Date milestone3Date = (Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.MILESTONE3_DATE);
		Date milestone4Date = (Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.MILESTONE4_DATE);

		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		PrepareForNextYearPage pfnyPg = new PrepareForNextYearPage(wd);

		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String testSystemDateStr=memberAttributesMap.get("Test System Date");
		Date testSystemDate=pfnyPg.convertStrToDate(testSystemDateStr);

		String sysDate=pfnyPg.convertDateToStrFormat_MMDDYYYY(testSystemDate);
		String sysDate_ms=String.valueOf(pfnyPg.convertDateToUctMillisecondsStr(testSystemDate));
		String m3Date=pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone3Date);
		String m4Date=pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone4Date);
		
		List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String text="===================================================";
		testNote.add(text);
		System.out.println(text);
		text="Test Setup - milestone3 date '"+m3Date+"' <= System date '"+sysDate+"' or millsec '"+sysDate_ms+"'  < milestone4 date '"+m4Date+"'";
		testNote.add(text);
		System.out.println(text);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);

		changeSystemDate(testSystemDate);
	}

	@SuppressWarnings("unchecked")
	@Then("^test setup changes system date to after or equal milestone4 date and before milestone5$")
	public void setupSysDateAfterOrEqualM4BeforeM5(DataTable memberAttributes) {
		if (!MRScenario.environment.contains("team-a")) {
			Assert.assertTrue("PROBLEM - will only work with system time change on team env.  You are trying to run this on env='"+MRScenario.environment+"', aborting test now", false);
			return;
		}		
		Date milestone4Date = (Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.MILESTONE4_DATE);
		Date milestone5Date = (Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.MILESTONE5_DATE);

		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		PrepareForNextYearPage pfnyPg = new PrepareForNextYearPage(wd);

		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String testSystemDateStr=memberAttributesMap.get("Test System Date");
		Date testSystemDate=pfnyPg.convertStrToDate(testSystemDateStr);

		String sysDate=pfnyPg.convertDateToStrFormat_MMDDYYYY(testSystemDate);
		String sysDate_ms=String.valueOf(pfnyPg.convertDateToUctMillisecondsStr(testSystemDate));
		String m4Date=pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone4Date);
		String m5Date=pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone5Date);
		
		List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String text="===================================================";
		testNote.add(text);
		System.out.println(text);
		text="Test Setup - milestone4 date '"+m4Date+"' <= System date '"+sysDate+"' or millsec '"+sysDate_ms+"'  < milestone5 date '"+m5Date+"'";
		testNote.add(text);
		System.out.println(text);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);

		changeSystemDate(testSystemDate);
	}
	
	@SuppressWarnings("unchecked")
	@Then("^test setup changes system date to after or equal milestone5 and before AEM end date$")
	public void setupSysDateAfterOrEqualM5BeforeAemEndDate(DataTable memberAttributes) {
		if (!MRScenario.environment.contains("team-a")) {
			Assert.assertTrue("PROBLEM - will only work with system time change on team env.  You are trying to run this on env='"+MRScenario.environment+"', aborting test now", false);
			return;
		}		

		Date milestone5Date = (Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.MILESTONE5_DATE);
		Date tabEndDate = (Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.AEM_TabEndDate);	

		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		PrepareForNextYearPage pfnyPg = new PrepareForNextYearPage(wd);

		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String testSystemDateStr=memberAttributesMap.get("Test System Date");
		Date testSystemDate=pfnyPg.convertStrToDate(testSystemDateStr);

		String sysDate=pfnyPg.convertDateToStrFormat_MMDDYYYY(testSystemDate);
		String sysDate_ms=String.valueOf(pfnyPg.convertDateToUctMillisecondsStr(testSystemDate));
		String aem=pfnyPg.convertDateToStrFormat_MMDDYYYY(tabEndDate);
		String m5Date=pfnyPg.convertDateToStrFormat_MMDDYYYY(milestone5Date);
		
		List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String text="===================================================";
		testNote.add(text);
		System.out.println(text);
		text="Test Setup - milestone5 date '"+m5Date+"' <= System date '"+sysDate+"' or millsec '"+sysDate_ms+"'  < AEM end date '"+aem+"'";
		testNote.add(text);
		System.out.println(text);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);

		changeSystemDate(testSystemDate);
	}

	@SuppressWarnings("unchecked")
	@Then("^test setup changes system date to after or equal AEM end date$")
	public void setupSysDateAfterOrEqualAemEndDate(DataTable memberAttributes) {
		if (!MRScenario.environment.contains("team-a")) {
			Assert.assertTrue("PROBLEM - will only work with system time change on team env.  You are trying to run this on env='"+MRScenario.environment+"', aborting test now", false);
			return;
		}		

		Date tabEndDate = (Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.AEM_TabEndDate);	

		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		PrepareForNextYearPage pfnyPg = new PrepareForNextYearPage(wd);

		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String testSystemDateStr=memberAttributesMap.get("Test System Date");
		Date testSystemDate=pfnyPg.convertStrToDate(testSystemDateStr);

		String sysDate=pfnyPg.convertDateToStrFormat_MMDDYYYY(testSystemDate);
		String sysDate_ms=String.valueOf(pfnyPg.convertDateToUctMillisecondsStr(testSystemDate));
		String aem=pfnyPg.convertDateToStrFormat_MMDDYYYY(tabEndDate);
		
		List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String text="===================================================";
		testNote.add(text);
		System.out.println(text);
		text="Test Setup - AEM end date '"+aem+"' <= System date '"+sysDate+"' or millsec '"+sysDate_ms+"'";
		testNote.add(text);
		System.out.println(text);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);

		changeSystemDate(testSystemDate);
	}

	
	public void changeSystemDate(Date testSystemDate) {
		//note: change system date
		MRScenario m=new MRScenario();
		WebDriver d=m.getWebDriverNew();
		PrepareForNextYearPage prepareForNextYearPage = new PrepareForNextYearPage(d);

		Assert.assertTrue("PROBLEM - unable to convert 'Test System Date' to valid Date object for further processing", testSystemDate!=null);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_SYSTEM_DATE, testSystemDate);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_SYSTEM_DATE_MILLISEC, prepareForNextYearPage.convertDateToUctMillisecondsStr(testSystemDate));
		
		String dateChangeUrl="http://ucp-user-management-team-atest.ocp-elr-core-nonprod.optum.com/UCPUserManagement/zadmin/time/joda?millis="+prepareForNextYearPage.convertDateToUctMillisecondsStr(testSystemDate);
		System.out.println("TEST dateChangeUrl="+dateChangeUrl);
		d.get(dateChangeUrl);
		CommonUtility.checkPageIsReady(d);
		prepareForNextYearPage.sleepBySec(2);
		Date currentDate=prepareForNextYearPage.getCurrentSystemDate();
		Assert.assertTrue("PROBLEM - unable to convert 'Test System Date' to valid Date object for further processing", currentDate!=null);
		Assert.assertTrue("PROBLEM - unable to setup system date to the test setup date.  "
				+ "system date='"+prepareForNextYearPage.convertDateToStrFormat_MMDDYYYY(currentDate)+"' | test setup date='"+prepareForNextYearPage.convertDateToStrFormat_MMDDYYYY(testSystemDate)+"'", 
				prepareForNextYearPage.convertDateToStrFormat_MMDDYYYY(currentDate).equals(prepareForNextYearPage.convertDateToStrFormat_MMDDYYYY(testSystemDate)));
		d.quit();
		

	}
	
	@Then("^test setup stores AEM and timeline milestones info$")
	public void storeAemAndMilestonesInfo(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String tmp_start=memberAttributesMap.get("AEM Show Tab StartDate");
		String tmp_end=memberAttributesMap.get("AEM Show Tab EndDate");

		String rollbackStr=memberAttributesMap.get("EndOfTestRollBackTime");
		Assert.assertTrue("PROBLEM - input 'EndOfTestRollBackTime' value should either be 'true' or 'false' | Actual='"+rollbackStr+"', please correct and retry",rollbackStr.equalsIgnoreCase("true") || rollbackStr.equalsIgnoreCase("false"));
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.END_OF_TEST_ROLL_BACK_TIME, Boolean.parseBoolean(rollbackStr));

		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  

		//----- note: AEM -----------------------------------------
		PrepareForNextYearPage pfnyPg = new PrepareForNextYearPage(wd);
		Assert.assertTrue("PROBLEM - AEM Show Tab StartDate is not format as expected. Expected format 'MM/dd/yyyy'", pfnyPg.validateJavaDate(tmp_start));
		Assert.assertTrue("PROBLEM - AEM Show Tab EndDate is not format as expected. Expected format 'MM/dd/yyyy'", pfnyPg.validateJavaDate(tmp_end));

		Date tabStartDate=pfnyPg.convertStrToDate(tmp_start);
		Assert.assertTrue("PROBLEM - unable to convert 'AEM Show Tab StartDate' to valid Date object for further processing", tabStartDate!=null);
		Date tabEndDate=pfnyPg.convertStrToDate(tmp_end);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.AEM_TabStartDate, tabStartDate);	
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.AEM_TabEndDate, tabEndDate);	

		Assert.assertTrue("PROBLEM - unable to convert 'AEM Show Tab EndDate' to valid Date object for further processing", tabEndDate!=null);

		String tmp_toggle=memberAttributesMap.get("AEM Toggle");
		Assert.assertTrue("PROBLEM - input 'Toggle' value should either be 'ON' or 'OFF' | Actual='"+tmp_toggle+"', please correct and retry",tmp_toggle.equalsIgnoreCase("ON") || tmp_toggle.equalsIgnoreCase("OFF"));
		boolean aem_tabToggle=true;
		if (tmp_toggle.equalsIgnoreCase("OFF"))
			aem_tabToggle=false;
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.AEM_TOGGLE, aem_tabToggle);	

		//----- note: milestones -----------------------------------------
		String tmp_milestone1=memberAttributesMap.get("Milestone 1 Date");
		String tmp_milestone2=memberAttributesMap.get("Milestone 2 Date");
		String tmp_milestone3=memberAttributesMap.get("Milestone 3 Date");
		String tmp_milestone4=memberAttributesMap.get("Milestone 4 Date");
		String tmp_milestone5=memberAttributesMap.get("Milestone 5 Date");

		Assert.assertTrue("PROBLEM - 'Milestone 1 Date' is not format as expected. Expected format 'MM/dd/yyyy'", pfnyPg.validateJavaDate(tmp_milestone1));
		Assert.assertTrue("PROBLEM - 'Milestone 2 Date' is not format as expected. Expected format 'MM/dd/yyyy'", pfnyPg.validateJavaDate(tmp_milestone2));
		Assert.assertTrue("PROBLEM - 'Milestone 3 Date' is not format as expected. Expected format 'MM/dd/yyyy'", pfnyPg.validateJavaDate(tmp_milestone3));
		Assert.assertTrue("PROBLEM - 'Milestone 4 Date' is not format as expected. Expected format 'MM/dd/yyyy'", pfnyPg.validateJavaDate(tmp_milestone4));
		Assert.assertTrue("PROBLEM - 'Milestone 5 Date' is not format as expected. Expected format 'MM/dd/yyyy'", pfnyPg.validateJavaDate(tmp_milestone5));

		Date milestone1Date=pfnyPg.convertStrToDate(tmp_milestone1);
		Assert.assertTrue("PROBLEM - unable to convert 'Milestone 1 Date' to valid Date object for further processing", milestone1Date!=null);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.MILESTONE1_DATE, milestone1Date);
		
		Date milestone2Date=pfnyPg.convertStrToDate(tmp_milestone2);
		Assert.assertTrue("PROBLEM - unable to convert 'Milestone 2 Date' to valid Date object for further processing", milestone2Date!=null);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.MILESTONE2_DATE, milestone2Date);

		Date milestone3Date=pfnyPg.convertStrToDate(tmp_milestone3);
		Assert.assertTrue("PROBLEM - unable to convert 'Milestone 3 Date' to valid Date object for further processing", milestone3Date!=null);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.MILESTONE3_DATE, milestone3Date);

		Date milestone4Date=pfnyPg.convertStrToDate(tmp_milestone4);
		Assert.assertTrue("PROBLEM - unable to convert 'Milestone 4 Date' to valid Date object for further processing", milestone4Date!=null);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.MILESTONE4_DATE, milestone4Date);

		Date milestone5Date=pfnyPg.convertStrToDate(tmp_milestone5);
		Assert.assertTrue("PROBLEM - unable to convert 'Milestone 5 Date' to valid Date object for further processing", milestone5Date!=null);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.MILESTONE5_DATE, milestone5Date);
		
		
	}

	
	@SuppressWarnings("unchecked")
	@Then("^test setup rolls back system date to current date for clean up after test$")
	public void setupSysDateRollbackOrigDate() {
		if (!MRScenario.environment.contains("team-a")) {
			Assert.assertTrue("PROBLEM - will only work with system time change on team env.  You are trying to run this on env='"+MRScenario.environment+"', aborting test now", false);
			return;
		}		

		MRScenario m=new MRScenario();
		WebDriver d=m.getWebDriverNew();
		PrepareForNextYearPage pfnyPg = new PrepareForNextYearPage(d);

		Date orig_currentDate=(Date) getLoginScenario().getBean(PrepareForNextYearCommonConstants.ORIG_CURRENT_SYSTEM_DATE);
		Long orig_currentDate_millisec=(Long) getLoginScenario().getBean(PrepareForNextYearCommonConstants.ORIG_CURRENT_SYSTEM_DATE_MILLISEC);
		
		List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String text="===================================================";
		testNote.add(text);
		System.out.println(text);
		text="Test Setup - Rollback System date to original '"+pfnyPg.convertDateToStrFormat_MMDDYYYY(orig_currentDate)+"' or millsec '"+pfnyPg.convertDateToUctMillisecondsStr(orig_currentDate)+"'";
		testNote.add(text);
		System.out.println(text);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
		
		String dateChangeUrl="http://ucp-user-management-team-atest.ocp-elr-core-nonprod.optum.com/UCPUserManagement/zadmin/time/joda?millis="+orig_currentDate_millisec;
		System.out.println("TEST dateChangeUrl="+dateChangeUrl);
		d.get(dateChangeUrl);
		CommonUtility.checkPageIsReady(d);
		pfnyPg.sleepBySec(2);
		Date currentDate=pfnyPg.getCurrentSystemDate();
		Assert.assertTrue("PROBLEM - unable to convert 'Test System Date' to valid Date object for further processing", currentDate!=null);
		Assert.assertTrue("PROBLEM - unable to rollback system date to original system date.  "
				+ "current system date='"+pfnyPg.convertDateToStrFormat_MMDDYYYY(currentDate)+"' | attemp to rollback to original date='"+pfnyPg.convertDateToStrFormat_MMDDYYYY(orig_currentDate)+"'", 
				pfnyPg.convertDateToStrFormat_MMDDYYYY(currentDate).equals(pfnyPg.convertDateToStrFormat_MMDDYYYY(orig_currentDate)));
		d.quit();
	}	
	
	//---------------------------------------------------
	//----- end - test setup for date changing on test environment
	//---------------------------------------------------
	
	//---------------------------------------------------
	//----- begin - keep the following steps for AEM update attempts
	//---------------------------------------------------
	@Given("^the user update AEM setting$")
	public void user_updateAEM() {
		if (!MRScenario.environment.contains("team-a")) {
			Assert.assertTrue("PROBLEM - will only test AEM update on team env.  You are trying to run this on env='"+MRScenario.environment+"', aborting test now", false);
			return;
		}

		System.out.println("AEM page URL="+aemUrl);
		MRScenario m=new MRScenario();
		WebDriver d=m.getWebDriverNew();
		AemPage aemPage=new AemPage(d);
		try {
			d.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
			d.get(aemUrl);
			CommonUtility.checkPageIsReady(d);
			aemPage.aemSignin();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception connecting to AEM",false);
		}

		try {
			HashMap<String, String> origSettingMap=aemPage.getCurrentToggleDateTime();
			System.out.println("----- original AEM setting ----");
			aemPage.printMapContent(origSettingMap);
			System.out.println("------------------------------");
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.ORIGINAL_AEM_SETTING, origSettingMap);	
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while saving original AEM setting",false);
		}

		/* keep 
		try {
			aemPage.updateToggle(false);
			aemPage.updateStartDate("09/15/21");
			aemPage.updateStartTime("02:00 AM");
			aemPage.updateEndDate("12/31/21");
			aemPage.updateEndTime("10:30 PM");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while updating field one by one",false);
		}
		try {
			aemPage.aemPgAction_activatePg();
			HashMap<String, String> updatedSettingMap=aemPage.getCurrentToggleDateTime();

			System.out.println("----- 1 upadted AEM setting ----");
			aemPage.printMapContent(updatedSettingMap);
			System.out.println("------------------------------");

		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while activing page for updating field one by one",false);
		}
		 */

		try { 
			aemPage.updateAllFields(true, "03/15/20", "10:45 AM", "04/31/20", "11:45 PM");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while updating all fields at once",false);
		}

		try {
			aemPage.aemPgAction_activatePg();
			HashMap<String, String> updatedSettingMap=aemPage.getCurrentToggleDateTime();
			System.out.println("----- upadted AEM setting ----");
			aemPage.printMapContent(updatedSettingMap);
			System.out.println("------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while activing page for updating all fields at once",false);
		}

		d.quit();
	}

	@SuppressWarnings("unchecked")
	@Given("^the user update AEM setting with current date in range and toggle off$")
	public void user_updateAEM_currentDateInRangeToggleOff() {
		if (!MRScenario.environment.contains("team-a")) {
			Assert.assertTrue("PROBLEM - will only test AEM update on team env.  You are trying to run this on env='"+MRScenario.environment+"', aborting test now", false);
			return;
		}
		List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String text="===================================================";
		testNote.add(text);
		System.out.println(text);
		text="Case - AEM data with current date within range and toggle off";
		testNote.add(text);
		System.out.println(text);
		System.out.println("AEM page URL="+aemUrl);
		MRScenario m=new MRScenario();
		WebDriver d=m.getWebDriverNew();
		if (MRScenario.returnJobURL()!=null)
			testNote.add("This sauceLab session url: "+MRScenario.returnJobURL());
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);

		AemPage aemPage=new AemPage(d);
		try {
			d.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
			d.get(aemUrl);
			CommonUtility.checkPageIsReady(d);
			aemPage.aemSignin();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception connecting to AEM",false);
		}

		try {
			HashMap<String, String> origSettingMap=aemPage.getCurrentToggleDateTime();
			System.out.println("----- original AEM setting ----");
			aemPage.printMapContent(origSettingMap);
			System.out.println("------------------------------");
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.ORIGINAL_AEM_SETTING, origSettingMap);	
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while saving original AEM setting",false);
		}

		/* keep - Example of updating each field individually 
		try {
			aemPage.updateToggle(false);
			aemPage.updateStartDate("09/15/21");
			aemPage.updateStartTime("02:00 AM");
			aemPage.updateEndDate("12/31/21");
			aemPage.updateEndTime("10:30 PM");
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while updating field one by one",false);
		}
		 */
		Date currentDate=aemPage.getCurrentSystemDate();
		String currentDate_aemStr=aemPage.convertDateToAemFieldFormat(currentDate);
		System.out.println("Current Date (AEM format)="+currentDate_aemStr);

		Date newStartDateTwoDayBeforeCurrentDate = DateUtils.addDays(currentDate,-2);
		String newStartDateTwoDayBeforeCurrentDate_aemStr=aemPage.convertDateToAemFieldFormat(newStartDateTwoDayBeforeCurrentDate);
		System.out.println("New StartsDate two days before current date (AEM format)="+newStartDateTwoDayBeforeCurrentDate_aemStr);

		Date newEndDateTwoDayAfterCurrentDate = DateUtils.addDays(currentDate,+2);
		String newEndDateTwoDayAfterCurrentDate_aemStr=aemPage.convertDateToAemFieldFormat(newEndDateTwoDayAfterCurrentDate);
		System.out.println("New EndDate one day before current date (AEM format)="+newEndDateTwoDayAfterCurrentDate_aemStr);

		text="Date setting: "+newStartDateTwoDayBeforeCurrentDate_aemStr+" < "+currentDate_aemStr+" < "+newEndDateTwoDayAfterCurrentDate_aemStr;
		testNote.add(text);
		System.out.println(text);

		boolean toggle=false;
		testNote.add("Toggle setting: "+toggle);
		String startDate=newStartDateTwoDayBeforeCurrentDate_aemStr;
		String startTime="01:00 AM";
		String endDate=newEndDateTwoDayAfterCurrentDate_aemStr;
		String endTime="11:45 PM";

		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
		try { 
			aemPage.updateAllFields(toggle, startDate, startTime, endDate, endTime);
		} catch (Exception e) {
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while updating all fields at once",false);
		}

		try {
			aemPage.aemPgAction_activatePg();
			HashMap<String, String> updatedSettingMap=aemPage.getCurrentToggleDateTime();
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.CURRENT_AEM_SETTING, updatedSettingMap);
			
			System.out.println("----- upadted AEM setting ----");
			aemPage.printMapContent(updatedSettingMap);
			System.out.println("------------------------------");
		} catch (Exception e) {
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while activing page for updating all fields at once",false);
		}

		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
		d.quit();
	}

	@SuppressWarnings("unchecked")
	@When("^the user update AEM setting with current date in range and toggle on$")
	public void user_updateAEM_currentDateInRangeToggleOn() {
		if (!MRScenario.environment.contains("team-a")) {
			Assert.assertTrue("PROBLEM - will only test AEM update on team env.  You are trying to run this on env='"+MRScenario.environment+"', aborting test now", false);
			return;
		}

		List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String text="===================================================";
		testNote.add(text);
		System.out.println(text);
		text="Case - AEM data with current date within range and toggle on";
		testNote.add(text);
		System.out.println(text);
		System.out.println("AEM page URL="+aemUrl);
		MRScenario m=new MRScenario();
		WebDriver d=m.getWebDriverNew();
		if (MRScenario.returnJobURL()!=null)
			testNote.add("This sauceLab session url: "+MRScenario.returnJobURL());
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
		
		AemPage aemPage=new AemPage(d);
		try {
			d.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
			d.get(aemUrl);
			CommonUtility.checkPageIsReady(d);
			aemPage.aemSignin();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception connecting to AEM",false);
		}

		try {
			HashMap<String, String> origSettingMap=aemPage.getCurrentToggleDateTime();
			System.out.println("----- original AEM setting ----");
			aemPage.printMapContent(origSettingMap);
			System.out.println("------------------------------");
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.ORIGINAL_AEM_SETTING, origSettingMap);	
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while saving original AEM setting",false);
		}

		Date currentDate=aemPage.getCurrentSystemDate();
		String currentDate_aemStr=aemPage.convertDateToAemFieldFormat(currentDate);
		System.out.println("Current Date (AEM format)="+currentDate_aemStr);

		Date newStartDateTwoDayBeforeCurrentDate = DateUtils.addDays(currentDate,-2);
		String newStartDateTwoDayBeforeCurrentDate_aemStr=aemPage.convertDateToAemFieldFormat(newStartDateTwoDayBeforeCurrentDate);
		System.out.println("New StartsDate two days before current date (AEM format)="+newStartDateTwoDayBeforeCurrentDate_aemStr);

		Date newEndDateTwoDayAfterCurrentDate = DateUtils.addDays(currentDate,+2);
		String newEndDateTwoDayAfterCurrentDate_aemStr=aemPage.convertDateToAemFieldFormat(newEndDateTwoDayAfterCurrentDate);
		System.out.println("New EndDate one day before current date (AEM format)="+newEndDateTwoDayAfterCurrentDate_aemStr);

		text="Date setting: "+newStartDateTwoDayBeforeCurrentDate_aemStr+" < "+currentDate_aemStr+" < "+newEndDateTwoDayAfterCurrentDate_aemStr;
		testNote.add(text);
		System.out.println(text);

		boolean toggle=true;
		testNote.add("Toggle setting: "+toggle);
		String startDate=newStartDateTwoDayBeforeCurrentDate_aemStr;
		String startTime="01:00 AM";
		String endDate=newEndDateTwoDayAfterCurrentDate_aemStr;
		String endTime="11:45 PM";

		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
		try { 
			aemPage.updateAllFields(toggle, startDate, startTime, endDate, endTime);
		} catch (Exception e) {
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while updating all fields at once",false);
		}

		try {
			aemPage.aemPgAction_activatePg();
			HashMap<String, String> updatedSettingMap=aemPage.getCurrentToggleDateTime();
			System.out.println("----- upadted AEM setting ----");
			aemPage.printMapContent(updatedSettingMap);
			System.out.println("------------------------------");
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.CURRENT_AEM_SETTING, updatedSettingMap);
		} catch (Exception e) {
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while activing page for updating all fields at once",false);
		}

		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
		d.quit();
	}

	@SuppressWarnings("unchecked")
	@When("^the user update AEM setting with current date before range and toggle on$")
	public void user_updateAEM_currentDateBeforeRangeToggleOn() {
		if (!MRScenario.environment.contains("team-a")) {
			Assert.assertTrue("PROBLEM - will only test AEM update on team env.  You are trying to run this on env='"+MRScenario.environment+"', aborting test now", false);
			return;
		}

		List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String text="===================================================";
		testNote.add(text);
		System.out.println(text);
		text="Case - AEM data with current date within range before toggle on";
		testNote.add(text);
		System.out.println(text);
		System.out.println("AEM page URL="+aemUrl);
		MRScenario m=new MRScenario();
		WebDriver d=m.getWebDriverNew();
		if (MRScenario.returnJobURL()!=null)
			testNote.add("This sauceLab session url: "+MRScenario.returnJobURL());
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);

		AemPage aemPage=new AemPage(d);
		try {
			d.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
			d.get(aemUrl);
			CommonUtility.checkPageIsReady(d);
			aemPage.aemSignin();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception connecting to AEM",false);
		}

		try {
			HashMap<String, String> origSettingMap=aemPage.getCurrentToggleDateTime();
			System.out.println("----- original AEM setting ----");
			aemPage.printMapContent(origSettingMap);
			System.out.println("------------------------------");
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.ORIGINAL_AEM_SETTING, origSettingMap);	
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while saving original AEM setting",false);
		}

		Date currentDate=aemPage.getCurrentSystemDate();
		String currentDate_aemStr=aemPage.convertDateToAemFieldFormat(currentDate);
		System.out.println("Current Date (AEM format)="+currentDate_aemStr);

		Date newStartDateOneDayAfterCurrentDate = DateUtils.addDays(currentDate,+1);
		String newStartDateOneDayAfterCurrentDate_aemStr=aemPage.convertDateToAemFieldFormat(newStartDateOneDayAfterCurrentDate);
		System.out.println("New StartDate one day after current date (AEM format)="+newStartDateOneDayAfterCurrentDate_aemStr);

		Date newEndDateOneDayAfterCurrentDate = DateUtils.addDays(currentDate,+5);
		String newEndDateFiveDayAfterCurrentDate_aemStr=aemPage.convertDateToAemFieldFormat(newEndDateOneDayAfterCurrentDate);
		System.out.println("New EndDate five days after current date (AEM format)="+newEndDateFiveDayAfterCurrentDate_aemStr);

		text="Date setting: "+currentDate_aemStr+" < "+newStartDateOneDayAfterCurrentDate_aemStr+" < "+newEndDateFiveDayAfterCurrentDate_aemStr;
		testNote.add(text);
		System.out.println(text);

		boolean toggle=true;
		testNote.add("Toggle setting: "+toggle);
		String startDate=newStartDateOneDayAfterCurrentDate_aemStr;
		String startTime="01:00 AM";
		String endDate=newEndDateFiveDayAfterCurrentDate_aemStr;
		String endTime="11:45 PM";

		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
		try { 
			aemPage.updateAllFields(toggle, startDate, startTime, endDate, endTime);
		} catch (Exception e) {
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while updating all fields at once",false);
		}

		try {
			aemPage.aemPgAction_activatePg();
			HashMap<String, String> updatedSettingMap=aemPage.getCurrentToggleDateTime();
			System.out.println("----- upadted AEM setting ----");
			aemPage.printMapContent(updatedSettingMap);
			System.out.println("------------------------------");
		} catch (Exception e) {
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while activing page for updating all fields at once",false);
		}

		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
		d.quit();
	}

	@SuppressWarnings("unchecked")
	@When("^the user update AEM setting with current date after range and toggle on$")
	public void user_updateAEM_currentDateAfterRangeToggleOn() {
		if (!MRScenario.environment.contains("team-a")) {
			Assert.assertTrue("PROBLEM - will only test AEM update on team env.  You are trying to run this on env='"+MRScenario.environment+"', aborting test now", false);
			return;
		}

		List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String text="===================================================";
		testNote.add(text);
		System.out.println(text);
		text="Case - AEM data with current date after range and toggle on";
		testNote.add(text);
		System.out.println(text);
		System.out.println("AEM page URL="+aemUrl);
		MRScenario m=new MRScenario();
		WebDriver d=m.getWebDriverNew();
		if (MRScenario.returnJobURL()!=null)
			testNote.add("This sauceLab session url: "+MRScenario.returnJobURL());
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);

		AemPage aemPage=new AemPage(d);
		try {
			d.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
			d.get(aemUrl);
			CommonUtility.checkPageIsReady(d);
			aemPage.aemSignin();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception connecting to AEM",false);
		}

		try {
			HashMap<String, String> origSettingMap=aemPage.getCurrentToggleDateTime();
			System.out.println("----- original AEM setting ----");
			aemPage.printMapContent(origSettingMap);
			System.out.println("------------------------------");
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.ORIGINAL_AEM_SETTING, origSettingMap);	
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while saving original AEM setting",false);
		}

		Date currentDate=aemPage.getCurrentSystemDate();
		String currentDate_aemStr=aemPage.convertDateToAemFieldFormat(currentDate);
		System.out.println("Current Date (AEM format)="+currentDate_aemStr);

		Date newStartDateFiveDayBeforeCurrentDate = DateUtils.addDays(currentDate,-5);
		String newStartDateFiveDayBeforeCurrentDate_aemStr=aemPage.convertDateToAemFieldFormat(newStartDateFiveDayBeforeCurrentDate);
		System.out.println("New StartsDate five days before current date (AEM format)="+newStartDateFiveDayBeforeCurrentDate_aemStr);

		Date newEndDateOneDayBeforeCurrentDate = DateUtils.addDays(currentDate,-1);
		String newEndDateOneDayBeforeCurrentDate_aemStr=aemPage.convertDateToAemFieldFormat(newEndDateOneDayBeforeCurrentDate);
		System.out.println("New EndDate one day before current date (AEM format)="+newEndDateOneDayBeforeCurrentDate_aemStr);

		text="Date setting: "+newStartDateFiveDayBeforeCurrentDate_aemStr+" < "+newEndDateOneDayBeforeCurrentDate_aemStr+" < "+currentDate_aemStr;
		testNote.add(text);
		System.out.println(text);

		boolean toggle=true;
		testNote.add("Toggle setting: "+toggle);
		String startDate=newStartDateFiveDayBeforeCurrentDate_aemStr;
		String startTime="01:00 AM";
		String endDate=newEndDateOneDayBeforeCurrentDate_aemStr;
		String endTime="11:45 PM";
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);

		try { 
			aemPage.updateAllFields(toggle, startDate, startTime, endDate, endTime);
		} catch (Exception e) {
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while updating all fields at once",false);
		}

		try {
			aemPage.aemPgAction_activatePg();
			HashMap<String, String> updatedSettingMap=aemPage.getCurrentToggleDateTime();
			System.out.println("----- upadted AEM setting ----");
			aemPage.printMapContent(updatedSettingMap);
			System.out.println("------------------------------");
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.CURRENT_AEM_SETTING, updatedSettingMap);
		} catch (Exception e) {
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while activing page for updating all fields at once",false);
		}

		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
		d.quit();
	}

	@SuppressWarnings("unchecked")
	@When("^the user rollback AEM setting$")
	public void user_updateAEM_reset() {
		if (!MRScenario.environment.contains("team-a")) {
			Assert.assertTrue("PROBLEM - will only test AEM update on team env.  You are trying to run this on env='"+MRScenario.environment+"', aborting test now", false);
			return;
		}

		List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String text="===================================================";
		testNote.add(text);
		System.out.println(text);
		text="Case - AEM data with current date after range and toggle on";
		testNote.add(text);
		System.out.println(text);
		System.out.println("AEM page URL="+aemUrl);
		MRScenario m=new MRScenario();
		WebDriver d=m.getWebDriverNew();
		if (MRScenario.returnJobURL()!=null)
			testNote.add("This sauceLab session url: "+MRScenario.returnJobURL());
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);

		AemPage aemPage=new AemPage(d);
		try {
			d.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
			d.get(aemUrl);
			CommonUtility.checkPageIsReady(d);
			aemPage.aemSignin();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception connecting to AEM",false);
		}

		try {
			HashMap<String, String> origSettingMap=aemPage.getCurrentToggleDateTime();
			System.out.println("----- original AEM setting ----");
			aemPage.printMapContent(origSettingMap);
			System.out.println("------------------------------");
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.ORIGINAL_AEM_SETTING, origSettingMap);	
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while saving original AEM setting",false);
		}

		boolean defaultToggle=true;
		String defaultStartDate="06/01/20";
		String defaultStartTime="01:00 AM";
		String defaultEndDate="12/31/20";
		String defaultEndTime="11:45 PM";

		text="Toggle setting: "+defaultToggle;
		testNote.add(text);
		System.out.println(text);
		text="Start Date/Time setting: "+defaultStartDate+" | "+defaultStartTime;
		testNote.add(text);
		System.out.println(text);
		text="End Date/Time setting: "+defaultEndDate+" | "+defaultEndTime;
		testNote.add(text);
		System.out.println(text);

		try { 
			aemPage.updateAllFields(defaultToggle, defaultStartDate, defaultStartTime, defaultEndDate, defaultEndTime);
		} catch (Exception e) {
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while updating all fields at once",false);
		}

		try {
			aemPage.aemPgAction_activatePg();
			HashMap<String, String> updatedSettingMap=aemPage.getCurrentToggleDateTime();
			System.out.println("----- upadted AEM setting ----");
			aemPage.printMapContent(updatedSettingMap);
			System.out.println("------------------------------");
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.CURRENT_AEM_SETTING, updatedSettingMap);
		} catch (Exception e) {
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while activing page for updating all fields at once",false);
		}

		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
		d.quit();
	}


	//-------------- this line below is for accessing AEM only
	@SuppressWarnings("unchecked")
	@Then("^the user validates Prepare For Next Year tab display behavior on Benefits page base on AEM current setting$")
	public void user_toBenefits_validateTabBasedOnCurrentAemSetting() throws InterruptedException {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  

		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);

		PrepareForNextYearPage prepareForNextYearPage = new PrepareForNextYearPage(wd);

		HashMap<String,String> currentAemSettingMap=(HashMap<String,String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.CURRENT_AEM_SETTING);
		boolean tmp_toggle=Boolean.parseBoolean(currentAemSettingMap.get("featureToggle"));
		String tmp_startDate=currentAemSettingMap.get("startDate");
		String tmp_endDate=currentAemSettingMap.get("endDate");
		

		Date tabStartDate=prepareForNextYearPage.convertStrToDate(tmp_startDate);
		Assert.assertTrue("PROBLEM - unable to convert 'AEM Show Tab StartDate' to valid Date object for further processing", tabStartDate!=null);
		Date tabEndDate=prepareForNextYearPage.convertStrToDate(tmp_endDate);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.AEM_TabStartDate, tabStartDate);	
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.AEM_TabEndDate, tabEndDate);	

		Assert.assertTrue("PROBLEM - unable to convert 'AEM Show Tab EndDate' to valid Date object for further processing", tabEndDate!=null);

		boolean aem_tabToggle=tmp_toggle;
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.AEM_TOGGLE, aem_tabToggle);	

		Date currentDate=prepareForNextYearPage.getCurrentSystemDate();

		Assert.assertTrue("PROBLEM - unable to convert Current System Date Time: '"+currentDate+"' to valid Date object for further processing", currentDate!=null);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.CURRENT_SYSTEM_DATE, currentDate);	

		//note: if tabStartDate<= currentDate <= tabEndDate && toggle=ON
		boolean expPrepareForNextYearTab=false;
		if ((tabStartDate.before(currentDate) || tabStartDate.equals(currentDate))
				&& (tabEndDate.after(currentDate) || tabEndDate.equals(currentDate))		
				&& (aem_tabToggle)
				&& (!memberType.toUpperCase().contains("PREEFF") && !memberType.toUpperCase().contains("TERM") && !memberType.toUpperCase().contains("COMBO"))
				)
			expPrepareForNextYearTab=true;
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.EXPECT_PREPARE_FOR_NEXT_YEAR_TAB, expPrepareForNextYearTab);	

		List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="Coverage and Benefits";
		testNote.add("===================================================");
		testNote.add("\tValidation for Prepare For Next Year tab on page '"+targetPage+"'");
		testNote.add("\t  AEM tab startDate ="+prepareForNextYearPage.convertDateToStrFormat_MMDDYYYY(tabStartDate));
		testNote.add("\t  AEM tab endDate ="+prepareForNextYearPage.convertDateToStrFormat_MMDDYYYY(tabEndDate));
		testNote.add("\t  AEM toggle ="+aem_tabToggle);
		testNote.add("\t  System Date ="+prepareForNextYearPage.convertDateToStrFormat_MMDDYYYY(currentDate));
		testNote.add("\t  Expect tab to show ="+expPrepareForNextYearTab);

		boolean expComboTab=false;
		if (memberType.toLowerCase().contains("combo"))
			expComboTab=true;
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.EXPECT_COMBO_TAB, expComboTab);

		wd=prepareForNextYearPage.navigateToBenefitsPage(planType, memberType, expComboTab);

		boolean hasPrepareForNextYearTab=prepareForNextYearPage.hasPrepareForNextYearTabDisplay(expPrepareForNextYearTab);
		if (expPrepareForNextYearTab==hasPrepareForNextYearTab) {
			testNote.add("\tPrepare For Next Year tab IS displaying on Benefits page sub navigation menu as expected");
		} else
			testNote.add("\tPrepare For Next Year tab is NOT displaying on Benefits page sub navigation menu as expected. Expected to display='"+expPrepareForNextYearTab+"' | Actual display='"+hasPrepareForNextYearTab+"'");
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.EXPECT_PREPARE_FOR_NEXT_YEAR_TAB, expPrepareForNextYearTab);
		Assert.assertTrue("PROBLEM - Prepare For Next Year tab display behavior is not as expected.  Expected to display='"+expPrepareForNextYearTab+"' | Actual display='"+hasPrepareForNextYearTab+"'", expPrepareForNextYearTab==hasPrepareForNextYearTab);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}	
	//---------------------------------------------------
	//----- end - keep the following steps for AEM update attempts
	//---------------------------------------------------

}





