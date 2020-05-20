package acceptancetests.memberredesign.healthRecord;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.LoginCommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import gherkin.formatter.model.DataTableRow;
import pages.regression.healthRecord.HealthRecordPage;

public class HealthRecordStepDefinition {

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

	//note: added code to print test results note in jenkins report at the end of test for successful cases
	@cucumber.api.java.After
	public void testResultNote(Scenario scenario) { 
		if(null!=getLoginScenario().getBean(HealthRecordCommonConstants.TEST_NOTE)) {   
			@SuppressWarnings("unchecked")   
			List<String> testNote=(List<String>) getLoginScenario()
			.getBean(HealthRecordCommonConstants.TEST_NOTE);
			for (String s: testNote) {   
				scenario.write(s);
			}
			testNote.clear(); 
		}
	}

	@Then("^the user validates Health Record link display behavior on Account Profile dropdown base on test input$")
	public void user_validate_healthRecordLink(DataTable memberAttributes) throws InterruptedException {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  

		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		List<String> testNote=(List<String>) getLoginScenario().getBean(HealthRecordCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="Initial landing page after login";
		testNote.add("===================================================");
		testNote.add("\tValidation for page '"+targetPage+"'");
		Map<String, String> memberAttributesMap=parseInputArguments(memberAttributes);
		String tmp=memberAttributesMap.get("Expect Link");
		Assert.assertTrue("PROBLEM - input 'Expect Link' value should either be 'true' or 'false' | Actual='"+tmp+"', please correct and retry",tmp.equalsIgnoreCase("true") || tmp.equalsIgnoreCase("false"));
		boolean expHealthRecordLnk=Boolean.valueOf(tmp);
		getLoginScenario().saveBean(HealthRecordCommonConstants.EXPECT_IHR_LINK, expHealthRecordLnk);	

		HealthRecordPage healthRecordPage = new HealthRecordPage(wd);
		boolean expComboTab=false;
		if (memberType.toLowerCase().contains("combo"))
			expComboTab=true;
		boolean hasHealthRecordLnk=healthRecordPage.isHeathRecordLnkOnAcctProfDropdownOption(planType, memberType, expComboTab, targetPage);
		Assert.assertTrue("PROBLEM - health record link display behavior is not as expected.  Expected to display='"+expHealthRecordLnk+"' | Actual display='"+hasHealthRecordLnk+"'", expHealthRecordLnk==hasHealthRecordLnk);
		if (expHealthRecordLnk) {
			testNote.add("\tHealth Record link IS displaying on dropdown option and href is as expected");
		} else
			testNote.add("\tHealth Record link is NOT display on dropdown option or href is not as expected");

		getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}				

	@Then("^the user validates clicking Health Record link will open new tab to the target page$")
	public void user_validate_healthRecordLinkDestination() throws InterruptedException {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		List<String> testNote=(List<String>) getLoginScenario().getBean(HealthRecordCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		boolean expHealthRecordLnk=(Boolean) getLoginScenario().getBean(HealthRecordCommonConstants.EXPECT_IHR_LINK);	
		if (!expHealthRecordLnk || MRScenario.environment.contains("team-a")) {
			System.out.println("test scenario doesn't expect iHR link, skipping step to validate link navigation");
			testNote.add("\tSkip Health Record link destination validation");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			return;
		}

		String originalUrl=wd.getCurrentUrl();
		HealthRecordPage healthRecordPage = new HealthRecordPage(wd);
		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness)) {
			healthRecordPage.navigateFromTestHarnessToHeathRecordPageAndThenCloseTab();
		} else {
			healthRecordPage.navigateFromDashboardToHeathRecordPageAndThenCloseTab();
		}
		testNote.add("\tPASSED - Health Record link destination validation");
		healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
		getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}	

	@Then("^the user navigates to Find Care page if applicable and validate Health Record link display behavior$")
	public void user_toFindCare() {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		List<String> testNote=(List<String>) getLoginScenario().getBean(HealthRecordCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="Find Care";
		testNote.add("===================================================");
		testNote.add("\tValidation for page '"+targetPage+"'");
		if (planType.toUpperCase().contains("SHIP") || planType.equalsIgnoreCase("SSUP")) {
			System.out.println(planType+" user doesn't have '"+targetPage+"' page, skipping step...");
			testNote.add("\tSkip Health Record validation for plan type '"+MRScenario.environment+"'");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			return;
		}
		if (MRScenario.environment.contains("team-a")) {
			System.out.println("team-atest env doesn't support Rally '"+targetPage+"' page, skipping step...");
			testNote.add("\tSkip Health Record validation on env '"+MRScenario.environment+"'");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			return;
		}
		String originalUrl=wd.getCurrentUrl();
		HealthRecordPage healthRecordPage = new HealthRecordPage(wd);
		wd=healthRecordPage.navigateToFindCarePage();

		boolean expHealthRecordLnk=(Boolean) getLoginScenario().getBean(HealthRecordCommonConstants.EXPECT_IHR_LINK);	
		boolean expComboTab=false;
		//note: this page will not have combo tab even for combo user
		//if (memberType.toLowerCase().contains("combo"))
		//	expComboTab=true;
		boolean hasHealthRecordLnk=healthRecordPage.isHeathRecordLnkOnAcctProfDropdownOption(planType, memberType, expComboTab, targetPage);
		Assert.assertTrue("PROBLEM - '"+targetPage+"' page health record link display behavior is not as expected.  Expected to display='"+expHealthRecordLnk+"' | Actual display='"+hasHealthRecordLnk+"'", expHealthRecordLnk==hasHealthRecordLnk);
		if (expHealthRecordLnk) {
			testNote.add("\tHealth Record link IS displaying on dropdown option and href is as expected");
		} else
			testNote.add("\tHealth Record link is NOT display on dropdown option or href is not as expected");
		if (!expHealthRecordLnk || MRScenario.environment.contains("team-a")) {
			testNote.add("\tSkip Health Record link destination validation");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
			return;
		}

		//tbd if ("YES".equalsIgnoreCase(MRScenario.isTestHarness))
		//tbd 	healthRecordPage.navigateFromTestHarnessToHeathRecordPageAndThenCloseTab();
		//tbd else
			healthRecordPage.navigateFromDashboardToHeathRecordPageAndThenCloseTab();
		testNote.add("\tPASSED - Health Record link destination validation");

		healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
		getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}

	@Then("^the user navigates to Claims page if applicable and validate Health Record link display behavior$")
	public void user_toClaims() {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		List<String> testNote=(List<String>) getLoginScenario().getBean(HealthRecordCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="Claims";
		testNote.add("===================================================");
		testNote.add("\tValidation for page '"+targetPage+"'");
		if (MRScenario.environment.contains("team-a")) {
			System.out.println("team-atest env doesn't support Rally page '"+targetPage+"', skipping step...");
			testNote.add("\tSkip Health Record validation on env '"+MRScenario.environment+"'");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			return;
		}
		String originalUrl=wd.getCurrentUrl();
		HealthRecordPage healthRecordPage = new HealthRecordPage(wd);
		wd=healthRecordPage.navigateToClaimsPage();

		boolean expHealthRecordLnk=(Boolean) getLoginScenario().getBean(HealthRecordCommonConstants.EXPECT_IHR_LINK);	
		boolean expComboTab=false;
		//note: this page will not have combo tab even for combo user
		//if (memberType.toLowerCase().contains("combo"))
		//	expComboTab=true;
		boolean hasHealthRecordLnk=healthRecordPage.isHeathRecordLnkOnAcctProfDropdownOption(planType, memberType, expComboTab, targetPage);
		Assert.assertTrue("PROBLEM - health record link display behavior is not as expected.  Expected to display='"+expHealthRecordLnk+"' | Actual display='"+hasHealthRecordLnk+"'", expHealthRecordLnk==hasHealthRecordLnk);
		if (expHealthRecordLnk) {
			testNote.add("\tHealth Record link IS displaying on dropdown option and href is as expected");
		} else
			testNote.add("\tHealth Record link is NOT display on dropdown option or href is not as expected");
		if (!expHealthRecordLnk || MRScenario.environment.contains("team-a")) {
			testNote.add("\tSkip Health Record link destination validation");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
			return;
		}

		//tbd if ("YES".equalsIgnoreCase(MRScenario.isTestHarness))
		//tbd 	healthRecordPage.navigateFromTestHarnessToHeathRecordPageAndThenCloseTab();
		//tbd else
			healthRecordPage.navigateFromDashboardToHeathRecordPageAndThenCloseTab();

		testNote.add("\tPASSED - Health Record link destination validation");
		healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
		getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}

	@Then("^the user navigates to EOB page and validate Health Record link display behavior$")
	public void user_toEob() {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		List<String> testNote=(List<String>) getLoginScenario().getBean(HealthRecordCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="EOB";
		testNote.add("===================================================");
		testNote.add("\tValidation for page '"+targetPage+"'");
		if (planType.equalsIgnoreCase("SSP") || memberType.toUpperCase().contains("PREEFF")) {
			System.out.println(planType+" user doesn't have '"+targetPage+"' page, skipping step...");
			testNote.add("\tSkip Health Record validation for plan type '"+MRScenario.environment+"'");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			return;
		}
		String originalUrl=wd.getCurrentUrl();
		HealthRecordPage healthRecordPage = new HealthRecordPage(wd);
		if (MRScenario.environment.contains("team-a")) {
			wd=healthRecordPage.navigateToEobPageViaTestharnessTbl();
		} else {
			wd=healthRecordPage.navigateToEobPage();
		}

		boolean expHealthRecordLnk=(Boolean) getLoginScenario().getBean(HealthRecordCommonConstants.EXPECT_IHR_LINK);	
		boolean expComboTab=false;
		if (memberType.toLowerCase().contains("combo") && !planType.equalsIgnoreCase("SSP"))
			expComboTab=true;
		boolean hasHealthRecordLnk=healthRecordPage.isHeathRecordLnkOnAcctProfDropdownOption(planType, memberType, expComboTab, targetPage);
		Assert.assertTrue("PROBLEM - health record link display behavior is not as expected.  Expected to display='"+expHealthRecordLnk+"' | Actual display='"+hasHealthRecordLnk+"'", expHealthRecordLnk==hasHealthRecordLnk);
		if (expHealthRecordLnk) {
			testNote.add("\tHealth Record link IS displaying on dropdown option and href is as expected");
		} else
			testNote.add("\tHealth Record link is NOT display on dropdown option or href is not as expected");
		if (!expHealthRecordLnk || MRScenario.environment.contains("team-a")) {
			testNote.add("\tSkip Health Record link destination validation");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
			return;
		}

		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness))
			healthRecordPage.navigateFromTestHarnessToHeathRecordPageAndThenCloseTab();
		else
			healthRecordPage.navigateFromDashboardToHeathRecordPageAndThenCloseTab();

		testNote.add("\tPASSED - Health Record link destination validation");
		healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
		getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}	

	@Then("^the user navigates to Benefits page and validate Health Record link display behavior$")
	public void user_toBenefits() {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		List<String> testNote=(List<String>) getLoginScenario().getBean(HealthRecordCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="Coverage and Benefits";
		testNote.add("===================================================");
		testNote.add("\tValidation for page '"+targetPage+"'");
		String originalUrl=wd.getCurrentUrl();
		HealthRecordPage healthRecordPage = new HealthRecordPage(wd);
		wd=healthRecordPage.navigateToBenefitsPage();

		boolean expHealthRecordLnk=(Boolean) getLoginScenario().getBean(HealthRecordCommonConstants.EXPECT_IHR_LINK);	
		boolean expComboTab=false;
		if (memberType.toLowerCase().contains("combo"))
			expComboTab=true;
		boolean hasHealthRecordLnk=healthRecordPage.isHeathRecordLnkOnAcctProfDropdownOption(planType, memberType, expComboTab, targetPage);
		Assert.assertTrue("PROBLEM - health record link display behavior is not as expected.  Expected to display='"+expHealthRecordLnk+"' | Actual display='"+hasHealthRecordLnk+"'", expHealthRecordLnk==hasHealthRecordLnk);
		if (expHealthRecordLnk) {
			testNote.add("\tHealth Record link IS displaying on dropdown option and href is as expected");
		} else
			testNote.add("\tHealth Record link is NOT display on dropdown option or href is not as expected");
		if (!expHealthRecordLnk || MRScenario.environment.contains("team-a")) {
			testNote.add("\tSkip Health Record link destination validation");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
			return;
		}

		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness))
			healthRecordPage.navigateFromTestHarnessToHeathRecordPageAndThenCloseTab();
		else
			healthRecordPage.navigateFromDashboardToHeathRecordPageAndThenCloseTab();

		testNote.add("\tPASSED - Health Record link destination validation");
		healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
		getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}	

	@Then("^the user navigates to Plan Documents and Resources page and My Documents page and validate Health Record link display behavior$")
	public void user_toBenefitsToPlanDocToMyDoc() {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		List<String> testNote=(List<String>) getLoginScenario().getBean(HealthRecordCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="Plan Documents and Resources";
		testNote.add("===================================================");
		testNote.add("\tValidation for page '"+targetPage+"'");
		String originalUrl=wd.getCurrentUrl();
		HealthRecordPage healthRecordPage = new HealthRecordPage(wd);
		//note: navigate to benefits then planDoc
		wd=healthRecordPage.navigateToBenefitsPage();
		if (memberType.toUpperCase().contains("PREEFF")) 
			wd=healthRecordPage.navigateToPlanDocPage_preEff();
		else
			wd=healthRecordPage.navigateToPlanDocPage();

		boolean expHealthRecordLnk=(Boolean) getLoginScenario().getBean(HealthRecordCommonConstants.EXPECT_IHR_LINK);	
		boolean expComboTab=false;
		if (memberType.toLowerCase().contains("combo"))
			expComboTab=true;
		boolean hasHealthRecordLnk=healthRecordPage.isHeathRecordLnkOnAcctProfDropdownOption(planType, memberType, expComboTab, targetPage);
		Assert.assertTrue("PROBLEM - health record link display behavior is not as expected.  Expected to display='"+expHealthRecordLnk+"' | Actual display='"+hasHealthRecordLnk+"'", expHealthRecordLnk==hasHealthRecordLnk);
		if (expHealthRecordLnk) {
			testNote.add("\tHealth Record link IS displaying on dropdown option and href is as expected");
		} else
			testNote.add("\tHealth Record link is NOT display on dropdown option or href is not as expected");
		if (!expHealthRecordLnk || MRScenario.environment.contains("team-a")) {
			testNote.add("\tSkip Health Record link destination validation");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			//note: in this case, don't go back yet, keep going to validate MyDoc page
			//healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
			//return;
		} else {
			String planDocUrl=wd.getCurrentUrl();
			if ("YES".equalsIgnoreCase(MRScenario.isTestHarness))
				healthRecordPage.navigateFromTestHarnessToHeathRecordPageAndThenCloseTab();
			else
				healthRecordPage.navigateFromDashboardToHeathRecordPageAndThenCloseTab();
			testNote.add("\tPASSED - Health Record link destination validation");
			healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, planDocUrl);
			CommonUtility.checkPageIsReady(wd);
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		}

		//---------------------------------
		//note: navigate to myDoc (take too much time to navigate to plan doc, so once you are on it, validate this one too)
		targetPage="My Documents";
		testNote.add("===================================================");
		testNote.add("\tValidation for page '"+targetPage+"'");
		if (planType.toUpperCase().contains("SHIP")) {
			System.out.println(planType+" user doesn't have '"+targetPage+"' page, skipping step...");
			testNote.add("\tSkip Health Record validation for plan type '"+MRScenario.environment+"'");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
			return;
		}

		wd=healthRecordPage.navigateToMyDocPage();
		expComboTab=false;
		//note: this page will not have combo tab even for combo user
		//if (memberType.toLowerCase().contains("combo"))
		//	expComboTab=true;
		hasHealthRecordLnk=healthRecordPage.isHeathRecordLnkOnAcctProfDropdownOption(planType, memberType, expComboTab, targetPage);
		Assert.assertTrue("PROBLEM - health record link display behavior is not as expected.  Expected to display='"+expHealthRecordLnk+"' | Actual display='"+hasHealthRecordLnk+"'", expHealthRecordLnk==hasHealthRecordLnk);
		if (expHealthRecordLnk) {
			testNote.add("\tHealth Record link IS displaying on dropdown option and href is as expected");
		} else
			testNote.add("\tHealth Record link is NOT display on dropdown option or href is not as expected");
		if (!expHealthRecordLnk || MRScenario.environment.contains("team-a")) {
			testNote.add("\tSkip Health Record link destination validation");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
			return;
		}

		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness))
			healthRecordPage.navigateFromTestHarnessToHeathRecordPageAndThenCloseTab();
		else
			healthRecordPage.navigateFromDashboardToHeathRecordPageAndThenCloseTab();

		testNote.add("\tPASSED - Health Record link destination validation");
		healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
		getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}	

	@Then("^the user navigates to Order Plan Material page and validate Health Record link display behavior$")
	public void user_toBenefitsToOrder() {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		List<String> testNote=(List<String>) getLoginScenario().getBean(HealthRecordCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="Order Plan Materials";
		testNote.add("===================================================");
		testNote.add("\tValidation for page '"+targetPage+"'");
		if (memberType.toUpperCase().contains("PREEFF")) {
			System.out.println(planType+" user doesn't have '"+targetPage+"' page, skipping step...");
			testNote.add("\tSkip Health Record validation for plan type '"+MRScenario.environment+"'");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			return;
		}
		String originalUrl=wd.getCurrentUrl();
		HealthRecordPage healthRecordPage = new HealthRecordPage(wd);
		//note: navigate to benefits then order
		wd=healthRecordPage.navigateToBenefitsPage();
		wd=healthRecordPage.navigateToOrderPage();

		boolean expHealthRecordLnk=(Boolean) getLoginScenario().getBean(HealthRecordCommonConstants.EXPECT_IHR_LINK);	
		boolean expComboTab=false;
		if (memberType.toLowerCase().contains("combo"))
			expComboTab=true;
		boolean hasHealthRecordLnk=healthRecordPage.isHeathRecordLnkOnAcctProfDropdownOption(planType, memberType, expComboTab, targetPage);
		Assert.assertTrue("PROBLEM - health record link display behavior is not as expected.  Expected to display='"+expHealthRecordLnk+"' | Actual display='"+hasHealthRecordLnk+"'", expHealthRecordLnk==hasHealthRecordLnk);
		if (expHealthRecordLnk) {
			testNote.add("\tHealth Record link IS displaying on dropdown option and href is as expected");
		} else
			testNote.add("\tHealth Record link is NOT display on dropdown option or href is not as expected");
		if (!expHealthRecordLnk || MRScenario.environment.contains("team-a")) {
			testNote.add("\tSkip Health Record link destination validation");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
			return;
		}

		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness))
			healthRecordPage.navigateFromTestHarnessToHeathRecordPageAndThenCloseTab();
		else
			healthRecordPage.navigateFromDashboardToHeathRecordPageAndThenCloseTab();
		testNote.add("\tPASSED - Health Record link destination validation");
		healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
		getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}

	@Then("^the user navigates to Payments page and validate Health Record link display behavior$")
	public void user_toPayments() {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		List<String> testNote=(List<String>) getLoginScenario().getBean(HealthRecordCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="Payments";
		testNote.add("===================================================");
		testNote.add("\tValidation for page '"+targetPage+"'");

		HealthRecordPage healthRecordPage = new HealthRecordPage(wd);

		String consumerDetailStr=healthRecordPage.getConsumerDetailsFromlocalStorage();
		boolean isComboUser=memberType.toLowerCase().contains("combo");
		String lookForPlanCategory=planType;
		if (planType.toUpperCase().contains("SHIP")) {
			String[] tmp=planType.split("_");
			Assert.assertTrue("PROBLEM - for SHIP user planType value needs to have format SHIP_<planCategory>, please update input in feature file", tmp.length>1);
			lookForPlanCategory=tmp[1];
		}
		boolean hasPaymentTab=healthRecordPage.getPremiumPaymentInConsumerDetails(isComboUser, lookForPlanCategory, consumerDetailStr);
		if (!hasPaymentTab) {
			System.out.println(planType+" user hasPaymentTab=false, doesn't have '"+targetPage+"' page, skipping step...");
			testNote.add("\tSkip Health Record validation for plan type '"+MRScenario.environment+"'");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			return;
		}

		String originalUrl=wd.getCurrentUrl();
		wd=healthRecordPage.navigateToPaymentsPage();

		boolean expHealthRecordLnk=(Boolean) getLoginScenario().getBean(HealthRecordCommonConstants.EXPECT_IHR_LINK);	
		boolean expComboTab=false;
		if (memberType.toLowerCase().contains("combo"))
			expComboTab=true;
		boolean hasHealthRecordLnk=healthRecordPage.isHeathRecordLnkOnAcctProfDropdownOption(planType, memberType, expComboTab, targetPage);
		Assert.assertTrue("PROBLEM - health record link display behavior is not as expected.  Expected to display='"+expHealthRecordLnk+"' | Actual display='"+hasHealthRecordLnk+"'", expHealthRecordLnk==hasHealthRecordLnk);
		if (expHealthRecordLnk) {
			testNote.add("\tHealth Record link IS displaying on dropdown option and href is as expected");
		} else
			testNote.add("\tHealth Record link is NOT display on dropdown option or href is not as expected");
		if (!expHealthRecordLnk || MRScenario.environment.contains("team-a")) {
			testNote.add("\tSkip Health Record link destination validation");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
			return;
		}

		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness))
			healthRecordPage.navigateFromTestHarnessToHeathRecordPageAndThenCloseTab();
		else
			healthRecordPage.navigateFromDashboardToHeathRecordPageAndThenCloseTab();
		testNote.add("\tPASSED - Health Record link destination validation");
		healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
		getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}

	@Then("^the user navigates to Pharmacies and Prescriptions page and validate Health Record link display behavior$")
	public void user_toPharmaciesAndPrescriptions() {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		List<String> testNote=(List<String>) getLoginScenario().getBean(HealthRecordCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="Pharmacies and Prescriptions";
		testNote.add("===================================================");
		testNote.add("\tValidation for page '"+targetPage+"'");
		if ((planType.toUpperCase().contains("SHIP") && !memberType.toUpperCase().contains("COMBO")) 
				|| (planType.equalsIgnoreCase("MA")  && !memberType.toUpperCase().contains("COMBO"))
				|| planType.equalsIgnoreCase("SSUP") || memberType.toUpperCase().contains("TERM")) {
			System.out.println(planType+" user doesn't have '"+targetPage+"' page, skipping step...");
			testNote.add("\tSkip Health Record validation for plan type '"+MRScenario.environment+"'");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			return;
		}
		String originalUrl=wd.getCurrentUrl();
		HealthRecordPage healthRecordPage = new HealthRecordPage(wd);
		wd=healthRecordPage.navigateToPnpPage();

		boolean expHealthRecordLnk=(Boolean) getLoginScenario().getBean(HealthRecordCommonConstants.EXPECT_IHR_LINK);	
		if (memberType.toUpperCase().contains("COMBO") && 
				(memberType.toUpperCase().contains("MA") && memberType.toUpperCase().contains("PDP") && memberType.toUpperCase().contains("SSP"))) {
				expHealthRecordLnk=true; //note: if fed is part of combo plan, iHR will show even though SHIP may have priority in some cases
		}
		boolean expComboTab=false;
		//note: this page will not have combo tab even for combo user
		//if (memberType.toLowerCase().contains("combo"))
		//	expComboTab=true;
		boolean hasHealthRecordLnk=healthRecordPage.isHeathRecordLnkOnAcctProfDropdownOption(planType, memberType, expComboTab, targetPage);
		Assert.assertTrue("PROBLEM - health record link display behavior is not as expected.  Expected to display='"+expHealthRecordLnk+"' | Actual display='"+hasHealthRecordLnk+"'", expHealthRecordLnk==hasHealthRecordLnk);
		if (expHealthRecordLnk) {
			testNote.add("\tHealth Record link IS displaying on dropdown option and href is as expected");
		} else
			testNote.add("\tHealth Record link is NOT display on dropdown option or href is not as expected");
		if (!expHealthRecordLnk || MRScenario.environment.contains("team-a")) {
			testNote.add("\tSkip Health Record link destination validation");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
			return;
		}

		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness))
			healthRecordPage.navigateFromTestHarnessToHeathRecordPageAndThenCloseTab();
		else
			healthRecordPage.navigateFromDashboardToHeathRecordPageAndThenCloseTab();
		testNote.add("\tPASSED - Health Record link destination validation");
		healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
		getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}

	@Then("^the user navigates to Health and Wellness page and validate Health Record link display behavior$")
	public void user_toHealthAndWellness() {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		List<String> testNote=(List<String>) getLoginScenario().getBean(HealthRecordCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="Health and Wellness";
		testNote.add("===================================================");
		testNote.add("\tValidation for page '"+targetPage+"'");
		if (memberType.toUpperCase().contains("TERM")) {
			System.out.println(planType+" user doesn't have '"+targetPage+"' page, skipping step...");
			testNote.add("\tSkip Health Record validation for plan type '"+MRScenario.environment+"'");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			return;
		}
		String originalUrl=wd.getCurrentUrl();
		HealthRecordPage healthRecordPage = new HealthRecordPage(wd);
		wd=healthRecordPage.navigateToHwPage();

		boolean expHealthRecordLnk=(Boolean) getLoginScenario().getBean(HealthRecordCommonConstants.EXPECT_IHR_LINK);	
		if (memberType.toUpperCase().contains("COMBO") && 
				(memberType.toUpperCase().contains("MA") && memberType.toUpperCase().contains("PDP") && memberType.toUpperCase().contains("SSP"))) {
				expHealthRecordLnk=true; //note: if fed is part of combo plan, iHR will show even though SHIP may have priority in some cases
		}
		boolean expComboTab=false;
		//note: this page will not have combo tab even for combo user
		//if (memberType.toLowerCase().contains("combo"))
		//	expComboTab=true;
		boolean hasHealthRecordLnk=healthRecordPage.isHeathRecordLnkOnAcctProfDropdownOption(planType, memberType, expComboTab, targetPage);
		Assert.assertTrue("PROBLEM - health record link display behavior is not as expected.  Expected to display='"+expHealthRecordLnk+"' | Actual display='"+hasHealthRecordLnk+"'", expHealthRecordLnk==hasHealthRecordLnk);
		if (expHealthRecordLnk) {
			testNote.add("\tHealth Record link IS displaying on dropdown option and href is as expected");
		} else
			testNote.add("\tHealth Record link is NOT display on dropdown option or href is not as expected");
		if (!expHealthRecordLnk || MRScenario.environment.contains("team-a")) {
			testNote.add("\tSkip Health Record link destination validation");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
			return;
		}

		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness))
			healthRecordPage.navigateFromTestHarnessToHeathRecordPageAndThenCloseTab();
		else
			healthRecordPage.navigateFromDashboardToHeathRecordPageAndThenCloseTab();
		testNote.add("\tPASSED - Health Record link destination validation");
		healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
		getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}

	@Then("^the user navigates to Contact Us page and validate Health Record link display behavior$")
	public void user_toContactUs() {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		List<String> testNote=(List<String>) getLoginScenario().getBean(HealthRecordCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="Contact Us";
		testNote.add("===================================================");
		testNote.add("\tValidation for page '"+targetPage+"'");
		String originalUrl=wd.getCurrentUrl();
		HealthRecordPage healthRecordPage = new HealthRecordPage(wd);
		wd=healthRecordPage.navigateToContactUsPage();

		boolean expHealthRecordLnk=(Boolean) getLoginScenario().getBean(HealthRecordCommonConstants.EXPECT_IHR_LINK);	
		boolean expComboTab=false;
		if (memberType.toLowerCase().contains("combo"))
			expComboTab=true;
		boolean hasHealthRecordLnk=healthRecordPage.isHeathRecordLnkOnAcctProfDropdownOption(planType, memberType, expComboTab, targetPage);
		Assert.assertTrue("PROBLEM - health record link display behavior is not as expected.  Expected to display='"+expHealthRecordLnk+"' | Actual display='"+hasHealthRecordLnk+"'", expHealthRecordLnk==hasHealthRecordLnk);
		if (expHealthRecordLnk) {
			testNote.add("\tHealth Record link IS displaying on dropdown option and href is as expected");
		} else
			testNote.add("\tHealth Record link is NOT display on dropdown option or href is not as expected");
		if (!expHealthRecordLnk || MRScenario.environment.contains("team-a")) {
			testNote.add("\tSkip Health Record link destination validation");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
			return;
		}

		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness))
			healthRecordPage.navigateFromTestHarnessToHeathRecordPageAndThenCloseTab();
		else
			healthRecordPage.navigateFromDashboardToHeathRecordPageAndThenCloseTab();
		testNote.add("\tPASSED - Health Record link destination validation");
		healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
		getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}

	@Then("^the user navigates to Pharmacy Locator page and validate Health Record link display behavior$")
	public void user_toPharmacyLocator() {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		List<String> testNote=(List<String>) getLoginScenario().getBean(HealthRecordCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="Pharmacy Locator";
		testNote.add("===================================================");
		testNote.add("\tValidation for page '"+targetPage+"'");
		if (planType.toUpperCase().contains("SHIP") || planType.equalsIgnoreCase("MA") 
				|| planType.equalsIgnoreCase("SSUP") || memberType.toUpperCase().contains("TERM")) {
			System.out.println(planType+" user doesn't have '"+targetPage+"' page, skipping step...");
			testNote.add("\tSkip Health Record validation for plan type '"+MRScenario.environment+"'");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			return;
		}
		String originalUrl=wd.getCurrentUrl();
		HealthRecordPage healthRecordPage = new HealthRecordPage(wd);
		wd=healthRecordPage.navigateToPharmacyLocatorPage();

		boolean expHealthRecordLnk=(Boolean) getLoginScenario().getBean(HealthRecordCommonConstants.EXPECT_IHR_LINK);	
		boolean expComboTab=false;
		//note: this page will not have combo tab even for combo user
		//if (memberType.toLowerCase().contains("combo"))
		//	expComboTab=true;
		boolean hasHealthRecordLnk=healthRecordPage.isHeathRecordLnkOnAcctProfDropdownOption(planType, memberType, expComboTab, targetPage);
		Assert.assertTrue("PROBLEM - health record link display behavior is not as expected.  Expected to display='"+expHealthRecordLnk+"' | Actual display='"+hasHealthRecordLnk+"'", expHealthRecordLnk==hasHealthRecordLnk);
		if (expHealthRecordLnk) {
			testNote.add("\tHealth Record link IS displaying on dropdown option and href is as expected");
		} else
			testNote.add("\tHealth Record link is NOT display on dropdown option or href is not as expected");
		if (!expHealthRecordLnk || MRScenario.environment.contains("team-a")) {
			testNote.add("\tSkip Health Record link destination validation");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
			return;
		}

		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness))
			healthRecordPage.navigateFromTestHarnessToHeathRecordPageAndThenCloseTab();
		else
			healthRecordPage.navigateFromDashboardToHeathRecordPageAndThenCloseTab();
		testNote.add("\tPASSED - Health Record link destination validation");
		healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
		getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}

	@Then("^the user navigates to DCE page and validate Health Record link display behavior$")
	public void user_toDce() {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		List<String> testNote=(List<String>) getLoginScenario().getBean(HealthRecordCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="DCE";
		testNote.add("===================================================");
		testNote.add("\tValidation for page '"+targetPage+"'");
		if (planType.toUpperCase().contains("SHIP") || planType.equalsIgnoreCase("MA") 
				|| planType.equalsIgnoreCase("SSUP") || memberType.toUpperCase().contains("TERM")) {
			System.out.println(planType+" user doesn't have '"+targetPage+"' page, skipping step...");
			testNote.add("\tSkip Health Record validation for plan type '"+MRScenario.environment+"'");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			return;
		}
		String originalUrl=wd.getCurrentUrl();
		HealthRecordPage healthRecordPage = new HealthRecordPage(wd);
		wd=healthRecordPage.navigateToDcePage();

		boolean expHealthRecordLnk=(Boolean) getLoginScenario().getBean(HealthRecordCommonConstants.EXPECT_IHR_LINK);	
		boolean expComboTab=false;
		//note: this page will not have combo tab even for combo user
		//if (memberType.toLowerCase().contains("combo"))
		//	expComboTab=true;
		boolean hasHealthRecordLnk=healthRecordPage.isHeathRecordLnkOnAcctProfDropdownOption(planType, memberType, expComboTab, targetPage);
		Assert.assertTrue("PROBLEM - health record link display behavior is not as expected.  Expected to display='"+expHealthRecordLnk+"' | Actual display='"+hasHealthRecordLnk+"'", expHealthRecordLnk==hasHealthRecordLnk);
		if (expHealthRecordLnk) {
			testNote.add("\tHealth Record link IS displaying on dropdown option and href is as expected");
		} else
			testNote.add("\tHealth Record link is NOT display on dropdown option or href is not as expected");
		if (!expHealthRecordLnk || MRScenario.environment.contains("team-a")) {
			testNote.add("\tSkip Health Record link destination validation");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
			return;
		}

		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness))
			healthRecordPage.navigateFromTestHarnessToHeathRecordPageAndThenCloseTab();
		else
			healthRecordPage.navigateFromDashboardToHeathRecordPageAndThenCloseTab();
		testNote.add("\tPASSED - Health Record link destination validation");
		healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
		getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}

	@Then("^the user navigates to Account Settings page and validate Health Record link display behavior$")
	public void user_toAcctSettings() {
		WebDriver wd=(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER);
		wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		String planType=(String) getLoginScenario().getBean(LoginCommonConstants.PLANTYPE);
		String memberType=(String) getLoginScenario().getBean(LoginCommonConstants.CATOGERY);
		List<String> testNote=(List<String>) getLoginScenario().getBean(HealthRecordCommonConstants.TEST_NOTE);
		if (testNote==null)
			testNote=new ArrayList<String>();
		String targetPage="Account Settings";
		testNote.add("===================================================");
		testNote.add("\tValidation for page '"+targetPage+"'");
		String originalUrl=wd.getCurrentUrl();
		HealthRecordPage healthRecordPage = new HealthRecordPage(wd);
		wd=healthRecordPage.navigateToAccountSettings();

		boolean expHealthRecordLnk=(Boolean) getLoginScenario().getBean(HealthRecordCommonConstants.EXPECT_IHR_LINK);	
		boolean expComboTab=false;
		if (memberType.toLowerCase().contains("combo"))
			expComboTab=true;
		boolean hasHealthRecordLnk=healthRecordPage.isHeathRecordLnkOnAcctProfDropdownOption(planType, memberType, expComboTab, targetPage);
		Assert.assertTrue("PROBLEM - health record link display behavior is not as expected.  Expected to display='"+expHealthRecordLnk+"' | Actual display='"+hasHealthRecordLnk+"'", expHealthRecordLnk==hasHealthRecordLnk);
		if (expHealthRecordLnk) {
			testNote.add("\tHealth Record link IS displaying on dropdown option and href is as expected");
		} else
			testNote.add("\tHealth Record link is NOT display on dropdown option or href is not as expected");
		if (!expHealthRecordLnk || MRScenario.environment.contains("team-a")) {
			testNote.add("\tSkip Health Record link destination validation");
			getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
			getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
			healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
			return;
		}

		if ("YES".equalsIgnoreCase(MRScenario.isTestHarness))
			healthRecordPage.navigateFromTestHarnessToHeathRecordPageAndThenCloseTab();
		else
			healthRecordPage.navigateFromDashboardToHeathRecordPageAndThenCloseTab();
		testNote.add("\tPASSED - Health Record link destination validation");
		healthRecordPage.backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
		getLoginScenario().saveBean(HealthRecordCommonConstants.TEST_NOTE, testNote);
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
	}



}





