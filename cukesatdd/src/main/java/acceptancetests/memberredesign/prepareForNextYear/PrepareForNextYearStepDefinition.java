package acceptancetests.memberredesign.prepareForNextYear;

import java.util.ArrayList;
import java.util.Arrays;
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

	@SuppressWarnings("unchecked")
	@Then("^the user validates Prepare For Next Year tab display behavior on Benefits page$")
	public void user_toBenefits_validateTabBasedOnFeatureFileInput(DataTable memberAttributes) throws InterruptedException {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  

		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);


		PrepareForNextYearPage prepareForNextYearPage = new PrepareForNextYearPage(wd);

		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String planStartType=memberAttributesMap.get("Plan Start Type");
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.PLAN_STARTDATE_TYPE, planStartType);	

		String tmp_start=memberAttributesMap.get("AEM Show Tab StartDate");
		String tmp_end=memberAttributesMap.get("AEM Show Tab EndDate");

		Assert.assertTrue("PROBLEM - AEM Show Tab StartDate is not format as expected. Expected format 'MM/dd/yyyy'", prepareForNextYearPage.validateJavaDate(tmp_start));
		Assert.assertTrue("PROBLEM - AEM Show Tab EndDate is not format as expected. Expected format 'MM/dd/yyyy'", prepareForNextYearPage.validateJavaDate(tmp_end));

		Date tabStartDate=prepareForNextYearPage.convertStrToDate(tmp_start);
		Assert.assertTrue("PROBLEM - unable to convert 'AEM Show Tab StartDate' to valid Date object for further processing", tabStartDate!=null);
		Date tabEndDate=prepareForNextYearPage.convertStrToDate(tmp_end);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.AEM_TabStartDate, tabStartDate);	
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.AEM_TabEndDate, tabEndDate);	

		Assert.assertTrue("PROBLEM - unable to convert 'AEM Show Tab EndDate' to valid Date object for further processing", tabEndDate!=null);

		String tmp_toggle=memberAttributesMap.get("AEM Toggle");
		Assert.assertTrue("PROBLEM - input 'Toggle' value should either be 'ON' or 'OFF' | Actual='"+tmp_toggle+"', please correct and retry",tmp_toggle.equalsIgnoreCase("ON") || tmp_toggle.equalsIgnoreCase("OFF"));
		boolean aem_tabToggle=true;
		if (tmp_toggle.equalsIgnoreCase("OFF"))
			aem_tabToggle=false;
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.AEM_TOGGLE, aem_tabToggle);	

		Date currentDate=prepareForNextYearPage.getCurrentSystemDate();

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
		testNote.add("\tValidation for Prepare For Next Year tab on page '"+targetPage+"'");
		testNote.add("\t  AEM tab startDate ="+prepareForNextYearPage.printDate(tabStartDate));
		testNote.add("\t  AEM tab endDate ="+prepareForNextYearPage.printDate(tabEndDate));
		testNote.add("\t  AEM toggle ="+aem_tabToggle);
		testNote.add("\t  System Date ="+prepareForNextYearPage.printDate(currentDate));
		if (memberType.toUpperCase().contains("OFFCYC")) 
			testNote.add("\t  User plan start date type = offcycle");
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

		Assert.assertTrue("PROBLEM - Prepare For Next Year tab display behavior is not as expected.  Expected to display='"+expPrepareForNextYearTab+"' | Actual display='"+hasPrepareForNextYearTab+"'", expPrepareForNextYearTab==hasPrepareForNextYearTab);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}	

	@SuppressWarnings("unchecked")
	@Then("^the user validates Prepare For Next Year page content$")
	public void user_validatePrepareForNextYearPageContent(DataTable memberAttributes) throws InterruptedException {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  

		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);


		PrepareForNextYearPage prepareForNextYearPage = new PrepareForNextYearPage(wd);

		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String tmp_milestone1=memberAttributesMap.get("Milestone 1 Date");
		String tmp_milestone2=memberAttributesMap.get("Milestone 2 Date");
		String tmp_milestone3=memberAttributesMap.get("Milestone 3 Date");
		String tmp_milestone4=memberAttributesMap.get("Milestone 4 Date");
		String tmp_milestone5=memberAttributesMap.get("Milestone 5 Date");

		Assert.assertTrue("PROBLEM - 'Milestone 1 Date' is not format as expected. Expected format 'MM/dd/yyyy'", prepareForNextYearPage.validateJavaDate(tmp_milestone1));
		Assert.assertTrue("PROBLEM - 'Milestone 2 Date' is not format as expected. Expected format 'MM/dd/yyyy'", prepareForNextYearPage.validateJavaDate(tmp_milestone2));
		Assert.assertTrue("PROBLEM - 'Milestone 3 Date' is not format as expected. Expected format 'MM/dd/yyyy'", prepareForNextYearPage.validateJavaDate(tmp_milestone3));
		Assert.assertTrue("PROBLEM - 'Milestone 4 Date' is not format as expected. Expected format 'MM/dd/yyyy'", prepareForNextYearPage.validateJavaDate(tmp_milestone4));
		Assert.assertTrue("PROBLEM - 'Milestone 5 Date' is not format as expected. Expected format 'MM/dd/yyyy'", prepareForNextYearPage.validateJavaDate(tmp_milestone5));

		Date milestone1Date=prepareForNextYearPage.convertStrToDate(tmp_milestone1);
		Assert.assertTrue("PROBLEM - unable to convert 'Milestone 1 Date' to valid Date object for further processing", milestone1Date!=null);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.MILESTONE1_DATE, milestone1Date);
		
		Date milestone2Date=prepareForNextYearPage.convertStrToDate(tmp_milestone2);
		Assert.assertTrue("PROBLEM - unable to convert 'Milestone 2 Date' to valid Date object for further processing", milestone2Date!=null);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.MILESTONE2_DATE, milestone2Date);

		Date milestone3Date=prepareForNextYearPage.convertStrToDate(tmp_milestone3);
		Assert.assertTrue("PROBLEM - unable to convert 'Milestone 3 Date' to valid Date object for further processing", milestone3Date!=null);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.MILESTONE3_DATE, milestone3Date);

		Date milestone4Date=prepareForNextYearPage.convertStrToDate(tmp_milestone4);
		Assert.assertTrue("PROBLEM - unable to convert 'Milestone 4 Date' to valid Date object for further processing", milestone4Date!=null);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.MILESTONE4_DATE, milestone4Date);

		Date milestone5Date=prepareForNextYearPage.convertStrToDate(tmp_milestone5);
		Assert.assertTrue("PROBLEM - unable to convert 'Milestone 5 Date' to valid Date object for further processing", milestone5Date!=null);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.MILESTONE5_DATE, milestone5Date);

		Date currentDate=prepareForNextYearPage.getCurrentSystemDate();

		System.out.println("milestone1Date = "+prepareForNextYearPage.printDate(milestone1Date));
		System.out.println("milestone2Date = "+prepareForNextYearPage.printDate(milestone2Date));
		System.out.println("milestone3Date = "+prepareForNextYearPage.printDate(milestone3Date));
		System.out.println("milestone4Date = "+prepareForNextYearPage.printDate(milestone4Date));
		System.out.println("milestone5Date = "+prepareForNextYearPage.printDate(milestone5Date));
		System.out.println("currentDate = "+prepareForNextYearPage.printDate(currentDate));
		
		Assert.assertTrue("PROBLEM - unable to convert Current System Date Time: '"+currentDate+"' to valid Date object for further processing", currentDate!=null);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.CURRENT_SYSTEM_DATE, currentDate);	

		//note: if tabStartDate<= currentDate <= tabEndDate && toggle=ON

		List<String> testNote=(List<String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		testNote.add("===================================================");
		if (currentDate.before(milestone1Date)) {
			testNote.add("\tValidation for current date '"+prepareForNextYearPage.printDate(currentDate)+"' < milestone 1 '"+prepareForNextYearPage.printDate(milestone1Date)+"'");
			List<String> sectionNote=prepareForNextYearPage.validateBeforeM1Content();
			testNote.addAll(sectionNote);
			testNote.add("\tPASSED - page content validation");
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
		} else if ((currentDate.after(milestone1Date) || currentDate.equals(milestone1Date)) && currentDate.before(milestone2Date)) {
			testNote.add("\tValidation for milestone 1 '"+prepareForNextYearPage.printDate(milestone1Date)+"' <= current date '"+prepareForNextYearPage.printDate(currentDate)+"' < milestone 2 '"+prepareForNextYearPage.printDate(milestone2Date)+"'");
			List<String> sectionNote=prepareForNextYearPage.validateAfterOrEqualM1BeforeM2Content();
			testNote.addAll(sectionNote);
			testNote.add("\tPASSED - page content validation");
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
		} else if ((currentDate.after(milestone2Date) || currentDate.equals(milestone2Date)) && currentDate.before(milestone3Date)) {
			testNote.add("\tValidation for milestone 2 '"+prepareForNextYearPage.printDate(milestone2Date)+"' <= current date '"+prepareForNextYearPage.printDate(currentDate)+"' < milestone 3 '"+prepareForNextYearPage.printDate(milestone3Date)+"'");
			List<String> sectionNote=prepareForNextYearPage.validateAfterOrEqalM2BeforeM3Content();
			testNote.addAll(sectionNote);
			testNote.add("\tPASSED - page content validation");
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
		} else if ((currentDate.after(milestone3Date) || currentDate.equals(milestone3Date)) && currentDate.before(milestone4Date)) {
			testNote.add("\tValidation for milestone 3 '"+prepareForNextYearPage.printDate(milestone3Date)+"'<= current date '"+prepareForNextYearPage.printDate(currentDate)+"' < milestone 4 '"+prepareForNextYearPage.printDate(milestone4Date)+"'");
			List<String> sectionNote=prepareForNextYearPage.validateAfterOrEqalM3BeforeM4Content();
			testNote.addAll(sectionNote);
			testNote.add("\tPASSED - page content validation");
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
		} else if ((currentDate.after(milestone4Date) || currentDate.equals(milestone4Date)) && currentDate.before(milestone5Date)) {
			testNote.add("\tValidation for milestone 4 '"+prepareForNextYearPage.printDate(milestone4Date)+"' <= current date '"+prepareForNextYearPage.printDate(currentDate)+"' < milestone 5 '"+prepareForNextYearPage.printDate(milestone5Date)+"'");
			List<String> sectionNote=prepareForNextYearPage.validateAfterOrEqalM4BeforeM5Content();
			testNote.addAll(sectionNote);
			testNote.add("\tPASSED - page content validation");
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
		} else if (currentDate.after(milestone5Date) || currentDate.equals(milestone5Date)) {
			testNote.add("\tValidation for milestone 5 '"+prepareForNextYearPage.printDate(milestone5Date)+"' <= current date '"+prepareForNextYearPage.printDate(currentDate)+"'");
			List<String> sectionNote=prepareForNextYearPage.validateAfterOrEqalM5Content();
			testNote.addAll(sectionNote);
			testNote.add("\tPASSED - page content validation");
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
		} else {
			Assert.assertTrue("PROBLEM - shouldn't be here, please check whether the milestone input dates are corrected...", false);
		}
		
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}	

	@Then("^the user navigate to Prepare For Next Year page via Prepare For Next Year tab$")
	public void user_toPrepareForNextYearPg() throws InterruptedException {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		PrepareForNextYearPage prepareForNextYearPage = new PrepareForNextYearPage(wd); //note: at this point still on benefits page

		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		boolean expComboTab=(Boolean) getLoginScenario().getBean(PrepareForNextYearCommonConstants.EXPECT_COMBO_TAB);

		prepareForNextYearPage=prepareForNextYearPage.fromBenefitsPgNavigateToPrepareForNextYearPage(planType, memberType, expComboTab);
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.PREPARE_FOR_NEXT_YEAR_PAGE, prepareForNextYearPage);	
	}

	//----------------------------------------------------------
	//note: begin - keep the following steps for AEM update attempts
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
			testNote.add("This session sauceLab session url: "+MRScenario.returnJobURL());
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
		//tbd getLoginScenario().saveBean(PrepareForNextYearCommonConstants.AEM_PAGE, aemPage);	
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
			testNote.add("This session sauceLab session url: "+MRScenario.returnJobURL());
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
			testNote.add("This session sauceLab session url: "+MRScenario.returnJobURL());
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
			testNote.add("This session sauceLab session url: "+MRScenario.returnJobURL());
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
			testNote.add("This session sauceLab session url: "+MRScenario.returnJobURL());
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

	@SuppressWarnings("unchecked")
	@Then("^TBD the user rollback AEM setting$")
	public void tbd_user_rollBackDefaultAEM() {
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
		text="FINAL - Rollback AEM data with current date in range and toggle on";
		testNote.add(text);
		System.out.println(text);
		String aemUrl="http://author-team-atest.ocp-elr-core-nonprod.optum.com/cf#/content/medicare/member.html";

		System.out.println("AEM page URL="+aemUrl);
		MRScenario m=new MRScenario();
		WebDriver d=m.getWebDriverNew();
		if (MRScenario.returnJobURL()!=null)
			testNote.add("This session sauceLab session url: "+MRScenario.returnJobURL());
		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);

		AemPage aemPage=new AemPage(d);
		try {
			d.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
			d.get(aemUrl);
			CommonUtility.checkPageIsReady(d);
			aemPage.aemSignin();
		} catch (Exception e) {
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception connecting to AEM",false);
		}

		try {
			boolean toggle=true;
			testNote.add("Toggle setting: "+toggle);
			String startDate="06/01/20";
			String startTime="01:00 AM";
			String endDate="12/31/20";
			String endTime="11:45 PM";

			text="Date setting: startDate="+startDate+" | startTime="+startTime+" | endDate="+endDate+" | endTime="+endTime;
			testNote.add(text);
			System.out.println(text);

			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
			aemPage.updateAllFields(toggle, startDate, startTime, endDate, endTime);
		} catch (Exception e) {
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while rolling back AEM fields all together",false);
		}

		try {
			aemPage.aemPgAction_activatePg();
			HashMap<String, String> updatedSettingMap=aemPage.getCurrentToggleDateTime();
			Arrays.toString(updatedSettingMap.entrySet().toArray());
			System.out.println("----- rolled back AEM setting ----");
			aemPage.printMapContent(updatedSettingMap);
			System.out.println("------------------------------");
		} catch (Exception e) {
			getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - got exception while activing page for rolling back AEM fields all together",false);
		}

		getLoginScenario().saveBean(PrepareForNextYearCommonConstants.TEST_NOTE, testNote);
		d.quit();
	}

	//-------------- this line below is for accessing AEM only
	@Then("^the user validates Prepare For Next Year tab display behavior on Benefits page base on AEM current setting$")
	public void user_toBenefits_validateTabBasedOnCurrentAemSetting(DataTable memberAttributes) throws InterruptedException {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  

		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);

		PrepareForNextYearPage prepareForNextYearPage = new PrepareForNextYearPage(wd);

		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		HashMap<String,String> currentAemSettingMap=(HashMap<String,String>) getLoginScenario().getBean(PrepareForNextYearCommonConstants.CURRENT_AEM_SETTING);
		boolean tmp_toggle=Boolean.parseBoolean(currentAemSettingMap.get("featureToggle"));
		String tmp_startDate=currentAemSettingMap.get("startDate");
		String tmp_startTime=currentAemSettingMap.get("startTime");
		String tmp_endDate=currentAemSettingMap.get("endDate");
		String tmp_endTime=currentAemSettingMap.get("endTime");
		

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
		testNote.add("\t  AEM tab startDate ="+prepareForNextYearPage.printDate(tabStartDate));
		testNote.add("\t  AEM tab endDate ="+prepareForNextYearPage.printDate(tabEndDate));
		testNote.add("\t  AEM toggle ="+aem_tabToggle);
		testNote.add("\t  System Date ="+prepareForNextYearPage.printDate(currentDate));
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

		Assert.assertTrue("PROBLEM - Prepare For Next Year tab display behavior is not as expected.  Expected to display='"+expPrepareForNextYearTab+"' | Actual display='"+hasPrepareForNextYearTab+"'", expPrepareForNextYearTab==hasPrepareForNextYearTab);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}	
	//note: end - keep the following steps for AEM update attempts
	//----------------------------------------------------------

}





