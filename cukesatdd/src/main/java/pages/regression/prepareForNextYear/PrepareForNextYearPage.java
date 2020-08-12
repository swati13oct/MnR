package pages.regression.prepareForNextYear;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;

public class PrepareForNextYearPage extends PrepareForNextYearBase {

	public PrepareForNextYearPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	@Override
	public void openAndValidate(){
		validateAsMuchAsPossible=false;
	}

	public void openAndValidate(boolean input_validateAsMuchAsPossible){
		validateAsMuchAsPossible=input_validateAsMuchAsPossible;
	}

	public boolean hasPrepareForNextYearTabDisplay(boolean expectTab) {
		if (noWaitValidate(prepareForNextYearTab))
			return true;
		else 
			return false;
	}

	PrepareForNextYearTimelineIndividual pnfyTimeline_ind=new PrepareForNextYearTimelineIndividual(driver);
	PrepareForNextYearTimelineSars pnfyTimeline_sar=new PrepareForNextYearTimelineSars(driver);
	PrepareForNextYearIndividual pnfyIndividual=new PrepareForNextYearIndividual(driver);
	PrepareForNextYearGroup pnfyGroup=new PrepareForNextYearGroup(driver);
	PrepareForNextYearSars pnfySar=new PrepareForNextYearSars(driver);

	public PrepareForNextYearPage fromBenefitsPgNavigateToPrepareForNextYearPage(String planType, String memberType, boolean expComboTab) {
		System.out.println("TEST - attempt to click the PrepareForNextYear tab to go to the PrepareForNextYear page...");
		if (noWaitValidate(prepareForNextYearTab)) {
			checkModelPopup(driver,3);
			prepareForNextYearTab.click();
			//tbd Assert.assertTrue("PROBLEM - loader still spinning after 30 seconds.  Page may have trouble loading.",waitForElementToDisappear(driver, loadingSpinner, 30));
		}
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, prepareForNextYearPgHeader, 10);
		//tbd sleepBySec(2);
		String actUrl=driver.getCurrentUrl();
		String expUrl="/member/preparefornextyear/overview.html";
		Assert.assertTrue("PROBLEM - URL for 'Prepare For Next Year' page is not as expected.  Expect to contains '"+expUrl+"' | Acturl URL='"+actUrl+"'", actUrl.contains(expUrl));
		Assert.assertTrue("PROBLEM - unable to locate 'Prepare For Next Year' page header, assume trouble navigate to 'Prepare For Next Year' page via 'Prepare For Next Year' tab on Benefit sub menu", noWaitValidate(prepareForNextYearPgHeader));

		if (expComboTab) 
			Assert.assertTrue("PROBLEM - unable to locate the combo tab for planType '"+planType+"' on Prepare For Next Year page", findComboTab(planType));
		//tbd handleComboTabIfComboUser(planType, memberType);
		return new PrepareForNextYearPage(driver);
	}

	public WebDriver navigateToBenefitsPage(String planType, String memberType, boolean expComboTab) {
		checkModelPopup(driver,1);
		if (noWaitValidate(benefitsTopMenuLnk)) {
			benefitsTopMenuLnk.click();
		} else 	if (noWaitValidate(shadowRootHeader)) {
			System.out.println("located shadow-root element, attempt to process further...");
			WebElement root1 = expandRootElement(shadowRootHeader);
			try {
				WebElement benefitsTopMenuShadowRootLink = root1.findElement(By.cssSelector("a[data-testid*=nav-link-coverage]"));
				benefitsTopMenuShadowRootLink.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - unable to locate Benefits link on top menu", false);
			}
		}
		checkModelPopup(driver,1);
		if (expComboTab) 
			handleComboTabIfComboUser(planType, memberType);

		return driver;
	}

	public List<String> validateFindUpdatesSectionContent(String planType, String memberType, Date currentDate, boolean showNxtYrPlanName) {
		Assert.assertTrue("PROBLEM - NON-SARS member type will need to provide user input for document display expected behavior in feature file.  This memberType='"+memberType+"'", memberType.toUpperCase().contains("SARS"));
		HashMap<String, Boolean> docDisplayMap=null;
		return validateFindUpdatesSectionContent(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
	}
	
	
	public List<String> validateFindUpdatesSectionContent(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean showNxtYrPlanName) {
		List<String> note=new ArrayList<String>();
		//---------------------------------------------
		if (memberType.contains("IND")) {
			System.out.println("Proceed to validate section content for individual user...");

			String targetItem="Find updates to your plan benefits section";
			WebElement targetElement=ind_findUpdatesSection;
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem="Find updates to your plan benefits section header";
			targetElement=ind_findUpdatesSection_header;
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem="Find updates for next year's plan section text";
			targetElement=ind_findUpdatesSection_text;
			note.addAll(validateHaveItem(targetItem, targetElement));


			note.addAll(pnfyIndividual.validateReviewPlanChangesSection_ind(planType, memberType, currentDate, docDisplayMap));
			note.addAll(pnfyIndividual.validateReviewPlanMaterialsSection_ind(planType, memberType, currentDate, docDisplayMap));
			note.addAll(pnfyIndividual.validateComparePlanSection_ind(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName));
			note.addAll(pnfyIndividual.validateEnrollSection_ind(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName));
		} else if (memberType.contains("GRP")) {
			String targetItem="Find updates to your plan benefits section";
			WebElement targetElement=grp_findUpdatesSection;
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem="Find updates to your plan benefits section header";
			targetElement=grp_findUpdatesSection_header;
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem="Find updates to your plan benefits section text";
			targetElement=grp_findUpdatesSection_text;
			note.addAll(validateHaveItem(targetItem, targetElement));

			String section="Compare Plan Online"; //note: should not have
			targetItem=section;
			targetElement=grp_comparePlanOnlineSection;
			note.addAll(validateDontHaveItem(targetItem, targetElement));

			section="Enroll Plan";  //note: should not have
			targetItem=section;
			targetElement=grp_enrollPlanSection;
			note.addAll(validateDontHaveItem(targetItem, targetElement));

			note.addAll(pnfyGroup.validateReviewPlanDocumentsSection_grp(planType, memberType, currentDate, docDisplayMap));
		} else if (memberType.contains("SARS")) {
			String targetItem="Find updates to your plan benefits section";
			WebElement targetElement=sars_findUpdatesSection;
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem="Find updates to your plan benefits section header";
			targetElement=sars_findUpdatesSection_header;
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem="Find updates to your plan benefits section text";
			targetElement=sars_findUpdatesSection_text;
			note.addAll(validateHaveItem(targetItem, targetElement));

			String section="Compare Plan Online"; 
			targetItem=section;
			targetElement=sars_comparePlanOnlineSection;
			note.addAll(validateHaveItem(targetItem, targetElement));

			section="Enroll Plan";  
			targetItem=section;
			targetElement=sars_enrollPlanSection;
			note.addAll(validateHaveItem(targetItem, targetElement));

			note.addAll(pnfySar.validateComparePlanSection_ind(planType, memberType, currentDate, showNxtYrPlanName));
			note.addAll(pnfySar.validateEnrollSection_ind(planType, memberType, currentDate, showNxtYrPlanName));
		}

		return note;
	}

	public List<String> validateBefM1Content(String planType, String memberType, Date currentDate, boolean showNxtYrPlanName) {
		Assert.assertTrue("PROBLEM - NON-SARS member type will need to provide user input for document display expected behavior in feature file.  This memberType='"+memberType+"'", memberType.toUpperCase().contains("SARS"));
		HashMap<String, Boolean> docDisplayMap=null;
		return validateBefM1Content(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
	}
	
	public List<String> validateBefM1Content(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean showNxtYrPlanName) {
		List<String> sectionNote1=new ArrayList<String>();
		if (memberType.toUpperCase().contains("IND")) {
			//note: individual is on team-atest | online-stage | offline-prod | online-prod already
			boolean expNoBlue_t1=true;
			boolean expNoBlue_t2=true;
			boolean expNoBlue_t3=true;
			boolean expNoBlue_t4=true;
			boolean expNoBlue_t5=true;
			List<String> s1=pnfyTimeline_ind.validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
			sectionNote1.addAll(s1);

			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
			sectionNote1.addAll(s2);
		} else if (memberType.toUpperCase().contains("GRP")) {
			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
			sectionNote1.addAll(s2);
		} else if (memberType.toUpperCase().contains("SARS")) {
			//note: individual is on team-atest | online-stage | offline-prod | online-prod already
			boolean expNoBlue_t1=false;
			boolean expNoBlue_t2=false;
			boolean expNoBlue_t3=false;
			List<String> s1=pnfyTimeline_sar.validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3);
			sectionNote1.addAll(s1);

			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, showNxtYrPlanName);
			sectionNote1.addAll(s2);

		} else {
			Assert.assertTrue("NOTE: This is not IND or GRP or SARs case, not supported", false);
		}

		return sectionNote1;
	}

	public List<String> validateAftOrEqM1BefM2Content(String planType, String memberType, Date currentDate, boolean showNxtYrPlanName) {
		Assert.assertTrue("PROBLEM - NON-SARS member type will need to provide user input for document display expected behavior in feature file.  This memberType='"+memberType+"'", memberType.toUpperCase().contains("SARS"));
		HashMap<String, Boolean> docDisplayMap=null;
		return validateAftOrEqM1BefM2Content(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
	}
	
	public List<String> validateAftOrEqM1BefM2Content(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean showNxtYrPlanName) {
		List<String> sectionNote1=new ArrayList<String>();
		if (memberType.toUpperCase().contains("IND")) {
			//note: individual is on team-atest | online-stage | offline-prod | online-prod already
			boolean expNoBlue_t1=false;
			boolean expNoBlue_t2=true;
			boolean expNoBlue_t3=true;
			boolean expNoBlue_t4=true;
			boolean expNoBlue_t5=true;
			List<String> s1=pnfyTimeline_ind.validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
			sectionNote1.addAll(s1);

			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
			sectionNote1.addAll(s2);
		} else if (memberType.toUpperCase().contains("GRP")) {
			//note: group is on team-atest 
			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
			sectionNote1.addAll(s2);
		} else if (memberType.toUpperCase().contains("SARS")) {
			//note: individual is on team-atest | online-stage | offline-prod | online-prod already
			boolean expNoBlue_t1=false;
			boolean expNoBlue_t2=true;
			boolean expNoBlue_t3=true;
			List<String> s1=pnfyTimeline_sar.validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3);
			sectionNote1.addAll(s1);

			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, showNxtYrPlanName);
			sectionNote1.addAll(s2);

		} else {
			Assert.assertTrue("NOTE: This is not IND or GRP or SARs case, not supported", false);
		}
		return sectionNote1;
	}

	public List<String> validateAftOrEqM2BefM3Content(String planType, String memberType, Date currentDate, boolean showNxtYrPlanName) {
		Assert.assertTrue("PROBLEM - NON-SARS member type will need to provide user input for document display expected behavior in feature file.  This memberType='"+memberType+"'", memberType.toUpperCase().contains("SARS"));
		HashMap<String, Boolean> docDisplayMap=null;
		return validateAftOrEqM2BefM3Content(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
	}

	public List<String> validateAftOrEqM2BefM3Content(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean showNxtYrPlanName) {
		List<String> sectionNote1=new ArrayList<String>();
		if (memberType.toUpperCase().contains("IND")) {
			//note: individual is on team-atest | online-stage | offline-prod | online-prod already
			boolean expNoBlue_t1=false;
			boolean expNoBlue_t2=false;
			boolean expNoBlue_t3=true;
			boolean expNoBlue_t4=true;
			boolean expNoBlue_t5=true;
			List<String> s1=pnfyTimeline_ind.validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
			sectionNote1.addAll(s1);

			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
			sectionNote1.addAll(s2);
		} else if (memberType.toUpperCase().contains("GRP")) {
			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
			sectionNote1.addAll(s2);
		} else if (memberType.toUpperCase().contains("SARS")) {
			//note: individual is on team-atest | online-stage | offline-prod | online-prod already
			boolean expNoBlue_t1=false;
			boolean expNoBlue_t2=false;
			boolean expNoBlue_t3=true;
			List<String> s1=pnfyTimeline_sar.validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3);
			sectionNote1.addAll(s1);

			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
			sectionNote1.addAll(s2);
		} else {
			Assert.assertTrue("NOTE: This is not IND or GRP or SARs case, not supported", false);
		}
		return sectionNote1;
	}

	public List<String> validateAftOrEqM3BefM4Content(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean showNxtYrPlanName) {
		List<String> sectionNote1=new ArrayList<String>();
		if (memberType.toUpperCase().contains("IND")) {
			//note: individual is on team-atest | online-stage | offline-prod | online-prod already
			boolean expNoBlue_t1=false;
			boolean expNoBlue_t2=false;
			boolean expNoBlue_t3=false;
			boolean expNoBlue_t4=true;
			boolean expNoBlue_t5=true;
			List<String> s1=pnfyTimeline_ind.validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
			sectionNote1.addAll(s1);

			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
			sectionNote1.addAll(s2);
		} else if (memberType.toUpperCase().contains("GRP")) {
			//note: group is on team-atest 
			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
			sectionNote1.addAll(s2);
		} else {
			Assert.assertTrue("NOTE: This is not Individual or Gropu case, this method is not applicable", false);
		}
		return sectionNote1;
	}

	public List<String> validateAftOrEqM4BefM5Content(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean showNxtYrPlanName) {
		List<String> sectionNote1=new ArrayList<String>();
		if (memberType.toUpperCase().contains("IND")) {
			//note: individual is on team-atest | online-stage | offline-prod | online-prod already
			boolean expNoBlue_t1=false;
			boolean expNoBlue_t2=false;
			boolean expNoBlue_t3=false;
			boolean expNoBlue_t4=false;
			boolean expNoBlue_t5=true;
			List<String> s1=pnfyTimeline_ind.validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
			sectionNote1.addAll(s1);

			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
			sectionNote1.addAll(s2);
		} else if (memberType.toUpperCase().contains("GRP")) {
			List<String> s1=pnfyTimeline_ind.validateNoTimeLineBoxContent();
			sectionNote1.addAll(s1);

			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
			sectionNote1.addAll(s2);
		} else {
			Assert.assertTrue("NOTE: This is not Individual or Gropu case, this method is not applicable", false);
		}
		return sectionNote1;
	}

	
	public List<String>  validateAfterOrEqalM5Content(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean showNxtYrPlanName) {
		List<String> sectionNote1=new ArrayList<String>();
		if (memberType.toUpperCase().contains("IND")) {
			//note: individual is on team-atest | online-stage | offline-prod | online-prod already
			boolean expNoBlue_t1=false;
			boolean expNoBlue_t2=false;
			boolean expNoBlue_t3=false;
			boolean expNoBlue_t4=false;
			boolean expNoBlue_t5=false;
			List<String> s1=pnfyTimeline_ind.validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
			sectionNote1.addAll(s1);

			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
			sectionNote1.addAll(s2);
		} else if (memberType.toUpperCase().contains("GRP")) {
			//note: group is on team-atest 
			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
			sectionNote1.addAll(s2);
		} else {
			Assert.assertTrue("NOTE: This is not Individual or Gropu case, this method is not applicable", false);
		}
		return sectionNote1;
	}

	public List<String>  validateAfterOrEqalM3Content(String planType, String memberType, Date currentDate, boolean showNxtYrPlanName) {
		List<String> sectionNote1=new ArrayList<String>();
		if (memberType.toUpperCase().contains("SARS")) {
			//note: individual is on team-atest | online-stage | offline-prod | online-prod already
			boolean expNoBlue_t1=false;
			boolean expNoBlue_t2=false;
			boolean expNoBlue_t3=false;
			List<String> s1=pnfyTimeline_sar.validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3);
			sectionNote1.addAll(s1);

			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, showNxtYrPlanName);
			sectionNote1.addAll(s2);
		} else {
			Assert.assertTrue("NOTE: This is not SARs case, this method is not applicable", false);
		}
		return sectionNote1;
	}
}