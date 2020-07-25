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
import atdd.framework.MRScenario;

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

	PrepareForNextYearTimeline pnfyTimeline=new PrepareForNextYearTimeline(driver);
	PrepareForNextYearIndividual pnfyIndividual=new PrepareForNextYearIndividual(driver);
	PrepareForNextYearGroup pnfyGroup=new PrepareForNextYearGroup(driver);
	PrepareForNextYearSar pnfySar=new PrepareForNextYearSar(driver);

	public PrepareForNextYearPage fromBenefitsPgNavigateToPrepareForNextYearPage(String planType, String memberType, boolean expComboTab) {
		System.out.println("TEST - attempt to click the PrepareForNextYear tab to go to the PrepareForNextYear page...");
		if (noWaitValidate(prepareForNextYearTab)) {
			prepareForNextYearTab.click();
			//tbd Assert.assertTrue("PROBLEM - loader still spinning after 30 seconds.  Page may have trouble loading.",waitForElementToDisappear(driver, loadingSpinner, 30));
		}
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, prepareForNextYearPgHeader, 10);
		checkModelPopup(driver,3);
		//tbd sleepBySec(2);
		Assert.assertTrue("PROBLEM - unable to navigate to 'Prepare For Next Year' page via 'Prepare For Next Year' tab on Benefit sub menu", noWaitValidate(prepareForNextYearPgHeader));

		if (expComboTab) 
			handleComboTabIfComboUser(planType, memberType);
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
	
	
	public List<String> validateReviewPlanChangesSection_grp(String planType, String memberType, Date currentDate, boolean showSectionDoc_f1, boolean showSectionDoc_f2, boolean showSectionDoc_f3, boolean showSectionDoc_f4, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		String section="Review plan changes";
		String targetItem=section+" - section";
		WebElement targetElement=grp_reviewPlanChangesSection;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - Circle";
		targetElement=grp_reviewPlanChanges_circle;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - header";
		targetElement=grp_reviewPlanChanges_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - text";
		targetElement=grp_reviewPlanChanges_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		section=section+" - document ";
		targetItem=section+" section";
		targetElement=grp_reviewPlanChanges_docSection;
		if (showSectionDoc_f1) {
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem=section+" - language dropdown";
			targetElement=grp_reviewPlanChanges_docSection_langDropdown;
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem=section+" - checkmark";
			targetElement=grp_reviewPlanChanges_docSection_checkMark_noGreen;
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem=section+" - Compare Your Current Plan To Next Year's Plan link";
			targetElement=grp_reviewPlanChanges_docSection_langDropdown;
			note.addAll(validateHaveItem(targetItem, targetElement));

		} else {
			note.addAll(validateDontHaveItem(targetItem, targetElement));
		}
		return note;
	}
	

	
	public List<String> validateReviewPlanMaterialsSection_grp(String memberType, Date currentDate, boolean showSectionDoc_f1, boolean showSectionDoc_f2, boolean showSectionDoc_f3, boolean showSectionDoc_f4, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		note.add("=============================================");
		String section="Review plan materials for group";
		String targetItem=section;
		note.add("TODO - validation for "+targetItem);
		return note;
	}
	
	
	public List<String> validateFindUpdatesSectionContent(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean showNxtYrPlanName) {
		List<String> note=new ArrayList<String>();
		if (memberType.contains("GRP")) {
			note.add("SKIP - Find Updates section content validation for now, work in progress");
			return note;
		}

		String targetItem="Find updates to your plan benefits section";
		WebElement targetElement=findUpdatesSection;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem="Find updates to your plan benefits section header";
		targetElement=findUpdatesSection_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem="Find updates for next year's plan section text";
		targetElement=findUpdatesSection_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		//---------------------------------------------
		if (memberType.contains("IND")) {
			System.out.println("Proceed to validate section content for individual user...");

			note.addAll(pnfyIndividual.validateReviewPlanChangesSection_ind(planType, memberType, currentDate, docDisplayMap));
			note.addAll(pnfyIndividual.validateReviewPlanMaterialsSection_ind(planType, memberType, currentDate, docDisplayMap));
			note.addAll(pnfyIndividual.validateComparePlanSection_ind(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName));
			note.addAll(pnfyIndividual.validateEnrollSection_ind(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName));
		} else {
			note.addAll(pnfyGroup.validateReviewPlanChangesSection_grp(planType, memberType, currentDate, docDisplayMap));
		}

		return note;
	}

	public List<String> validateBefM1Content(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean showNxtYrPlanName) {
		List<String> sectionNote1=new ArrayList<String>();
		boolean expNoBlue_t1=true;
		boolean expNoBlue_t2=true;
		boolean expNoBlue_t3=true;
		boolean expNoBlue_t4=true;
		boolean expNoBlue_t5=true;
		List<String> s1=pnfyTimeline.validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
		sectionNote1.addAll(s1);

		if (MRScenario.environment.contains("team-a")) {
			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
			sectionNote1.addAll(s2);
		}
		return sectionNote1;
	}

	public List<String> validateAftOrEqM1BefM2Content(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean showNxtYrPlanName) {
		List<String> sectionNote1=new ArrayList<String>();
		boolean expNoBlue_t1=false;
		boolean expNoBlue_t2=true;
		boolean expNoBlue_t3=true;
		boolean expNoBlue_t4=true;
		boolean expNoBlue_t5=true;
		List<String> s1=pnfyTimeline.validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
		sectionNote1.addAll(s1);

		if (MRScenario.environment.contains("team-a") || MRScenario.environment.contains("stage")) {
			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
			sectionNote1.addAll(s2);
		}
		return sectionNote1;
	}
	public List<String> validateAftOrEqM2BefM3Content(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean showNxtYrPlanName) {
		List<String> sectionNote1=new ArrayList<String>();
		boolean expNoBlue_t1=false;
		boolean expNoBlue_t2=false;
		boolean expNoBlue_t3=true;
		boolean expNoBlue_t4=true;
		boolean expNoBlue_t5=true;
		List<String> s1=pnfyTimeline.validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
		sectionNote1.addAll(s1);

		if (MRScenario.environment.contains("team-a") || MRScenario.environment.contains("stage")) {
			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
			sectionNote1.addAll(s2);
		}
		return sectionNote1;
	}
	public List<String> validateAftOrEqM3BefM4Content(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean showNxtYrPlanName) {
		List<String> sectionNote1=new ArrayList<String>();
		boolean expNoBlue_t1=false;
		boolean expNoBlue_t2=false;
		boolean expNoBlue_t3=false;
		boolean expNoBlue_t4=true;
		boolean expNoBlue_t5=true;
		List<String> s1=pnfyTimeline.validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
		sectionNote1.addAll(s1);

		if (MRScenario.environment.contains("team-a") || MRScenario.environment.contains("stage")) {
			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
			sectionNote1.addAll(s2);
		}
		return sectionNote1;
	}
	public List<String> validateAftOrEqM4BefM5Content(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean showNxtYrPlanName) {
		List<String> sectionNote1=new ArrayList<String>();
		boolean expNoBlue_t1=false;
		boolean expNoBlue_t2=false;
		boolean expNoBlue_t3=false;
		boolean expNoBlue_t4=false;
		boolean expNoBlue_t5=true;
		List<String> s1=pnfyTimeline.validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
		sectionNote1.addAll(s1);

		if (MRScenario.environment.contains("team-a") || MRScenario.environment.contains("stage")) {
			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
			sectionNote1.addAll(s2);
		}
		return sectionNote1;
	}
	public List<String>  validateAfterOrEqalM5Content(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap, boolean showNxtYrPlanName) {
		List<String> sectionNote1=new ArrayList<String>();
		boolean expNoBlue_t1=false;
		boolean expNoBlue_t2=false;
		boolean expNoBlue_t3=false;
		boolean expNoBlue_t4=false;
		boolean expNoBlue_t5=false;
		List<String> s1=pnfyTimeline.validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
		sectionNote1.addAll(s1);

		if (MRScenario.environment.contains("team-a") || MRScenario.environment.contains("stage")) {
			List<String> s2=validateFindUpdatesSectionContent(planType, memberType, currentDate, docDisplayMap, showNxtYrPlanName);
			sectionNote1.addAll(s2);
		}
		return sectionNote1;
	}

}