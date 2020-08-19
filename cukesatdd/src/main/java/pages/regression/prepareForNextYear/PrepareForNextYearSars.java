package pages.regression.prepareForNextYear;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.MRScenario;

public class PrepareForNextYearSars extends PrepareForNextYearBase {

	private static final String m1="10/01/";
	private static final String m2="10/15/";

	public PrepareForNextYearSars(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	@Override
	public void openAndValidate(){
	}


	public List<String> validateComparePlanSection_ind(String planType, String memberType, Date currentDate, boolean showNxtYrPlanName) {
		List<String> note=new ArrayList<String>();
		note.add("\t==============================================================");
		String section="Compare plans online";
		note.add("\tValidate for section: "+section);
		String targetItem=section+" - section";
		WebElement targetElement=sars_compPlnsSec;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetElement=sars_compPlnsSec_circle_noGreen;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - header";
		targetElement=sars_compPlnsSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - text";
		targetElement=sars_compPlnsSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		String showDocDateStr1=m1+String.valueOf(getCurrentYear());
		Date showDocDate1=convertStrToDate(showDocDateStr1);
System.out.println("TEST - currentDate="+convertDateToStrFormat_MMDDYYYY(currentDate));
System.out.println("TEST - showDocDate1="+convertDateToStrFormat_MMDDYYYY(showDocDate1));
System.out.println("TEST - m1="+m1);
System.out.println("TEST - currentDate.equals(showDocDate1)="+currentDate.equals(showDocDate1));
System.out.println("TEST - currentDate.after(showDocDate1)="+currentDate.after(showDocDate1));
		
		boolean showSection=false;
		if (currentDate.equals(showDocDate1) || currentDate.after(showDocDate1)) {
			showSection=true;
		}

		section=section+" - document ";
		targetItem=section+" section";
		targetElement=sars_compPlnsSec_lrnOthPlnSec;
		if (showSection) {
			note.addAll(validateHaveItem(targetItem, targetElement));

			System.out.println("TEST - planType='"+planType+"' - Proceed to validate 'Learn about other plan choices' section");
			note.addAll(validateLearnOtherPlans(section, planType, memberType, currentDate, showNxtYrPlanName));

		} else {
			if (validateAsMuchAsPossible) {
				if (!noWaitValidate(targetElement))
					note.add("\tPASSED - validation for NOT HAVING "+targetItem);
				else
					note.add("\t * FAILED - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr1+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'");
			} else {
				Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr1+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
				note.add("\tPASSED - validation for NOT HAVING "+targetItem);
			}
		}		
		return note;
	}

	public List<String> validateLearnOtherPlans(String section, String planType, String memberType, Date currentDate, boolean showNxtYrPlanName) {
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Learn about other plan choices";

		String showDocDateStr1=m1+String.valueOf(getCurrentYear());
		Date showDocDate2=convertStrToDate(showDocDateStr1);

		WebElement targetElement=null;

		String targetItem=section+" - checkmark";
		targetElement=sars_compPlnsSec_lrnOthPlnSec_checkMark_noGreen;
		note.addAll(validateHaveItem(targetItem, targetElement));


		targetItem=section+subSection+" - header";
		targetElement=sars_compPlnsSec_lrnOthPlnSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - text";
		targetElement=sars_compPlnsSec_lrnOthPlnSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));


		// see link after m1 before m4 will see Compare link
		boolean showSection=false;
		if ((currentDate.equals(showDocDate2) || currentDate.after(showDocDate2))) {
			showSection=true;
		}

		targetItem=section+subSection+" - Compare New Plans Link";
		targetElement=sars_compPlnsSec_lrnOthPlnSec_compNewPlnsLnk;
		if (showSection) {
			note.addAll(validateHaveItem(targetItem, targetElement));

			//note - validate link destination
			String expUrl="/health-plans.html#/plan-summary";
			if (memberType.toUpperCase().contains("UHC"))
				if (MRScenario.environment.contains("stage"))
					expUrl="uhcmedicaresolutions.uhc.com"+expUrl;
				else
					expUrl="uhcmedicaresolutions.com"+expUrl;
			else 
				if (MRScenario.environment.contains("stage"))
					expUrl="aarpmedicareplans.uhc.com"+expUrl;
				else
					expUrl="aarpmedicareplans.com"+expUrl;
			WebElement expElement=acqPlanOverviewBox;
			note.addAll(validateLnkBehavior(planType, memberType, targetItem, targetElement, expUrl, expElement));

			targetItem=section+subSection+" - Compare New Plans Link Arrow";
			targetElement=sars_compPlnsSec_lrnOthPlnSec_compNewPlnsLnk_arrow;
			note.addAll(validateHaveItem(targetItem, targetElement));

			note.add("\n\tValidate after clicking 'Compare New Plans' link");
			//note: after link click, section circle should turn green
			targetItem=section+" - green circle";
			targetElement=sars_compPlnsSec_circle_green;
			note.addAll(validateHaveItem(targetItem, targetElement));
		} else {
			if (validateAsMuchAsPossible) {
				if (!noWaitValidate(targetElement)) {
					note.add("\tPASSED - validation for NOT HAVING "+targetItem);
				} else {
					note.add("\t * FAILED - should not be able to locate element for '"+targetItem+"' after or equal date '"+showDocDateStr1+"'  | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'");
				}
			} else {
				Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' after or equal date '"+showDocDateStr1+"'  | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
				note.add("\tPASSED - validation for NOT HAVING "+targetItem);
			}
		}

		return note;
	}

	public List<String> validateEnrollSection_ind(String planType, String memberType, Date currentDate, boolean showNxtYrPlanName) {
		List<String> note=new ArrayList<String>();
		note.add("\t==============================================================");
		String section="Enroll in the plan that works for you";

		note.add("\tValidate for section: "+section);
		String targetItem=section+" - section";
		WebElement targetElement=sars_enrolPlnSec;
		note.addAll(validateHaveItem(targetItem, targetElement));

		String showDocDateStr1=m1+String.valueOf(getCurrentYear());
		Date showDocDate1=convertStrToDate(showDocDateStr1);

		//note: circle would be green >= M4 w/o user doing anything
		targetItem=section+" - Circle";
		targetElement=sars_enrolPlnSec_circle_noGreen;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - header";
		targetElement=sars_enrolPlnSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - text";
		targetElement=sars_enrolPlnSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		boolean showSection=false;
		if ((currentDate.equals(showDocDate1) || currentDate.after(showDocDate1))) {
			showSection=true;
		}

		section=section+" - Choose your plan ";
		targetItem=section+" section";
		targetElement=sars_enrolPlnSec_choYurPlnSec;
		if (showSection) {
			note.addAll(validateHaveItem(targetItem, targetElement));

			System.out.println("TEST - planType='"+planType+"' - Proceed to validate 'Choose your plan");
			note.addAll(validateChoosePlan(section, planType, memberType, currentDate, showNxtYrPlanName));

		} else {
			if (validateAsMuchAsPossible) {
				if (!noWaitValidate(targetElement)) 
					note.add("\tPASSED - validation for NOT HAVING "+targetItem);
				else
					note.add("\t * FAILED - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr1+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'");
			} else {
				Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' after or equal date '"+showDocDateStr1+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
				note.add("\tPASSED - validation for NOT HAVING "+targetItem);
			}
		}


		return note;
	}

	public List<String> validateChoosePlan(String section, String planType, String memberType, Date currentDate, boolean showNxtYrPlanName) {
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Choose your plan";

		String targetItem=section+" - checkmark";
		WebElement targetElement=sars_enrolPlnSec_choYurPlnSec_checkMark_noGreen;
		note.addAll(validateHaveItem(targetItem, targetElement));


		targetItem=section+subSection+" - header";
		targetElement=sars_enrolPlnSec_choYurPlnSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		//---------------------------
		System.out.println("Proceed to validate 'Compare next year plan' link behavior...");
		String showDocDateStr2=m2+String.valueOf(getCurrentYear());
		Date showDocDate1=convertStrToDate(showDocDateStr2);
		boolean showSection=false;
		if (showDocDate1.equals(currentDate)  || currentDate.after(showDocDate1)) {
			showSection=true;
		}
		System.out.println("TEST -showSection="+showSection);			
		targetItem=section+subSection+" - Compare New Plans Link";
		targetElement=sars_enrolPlnSec_choYurPlnSec_stayInPln_compNewPlnsLnk;
		if (showSection) {
			note.addAll(validateHaveItem(targetItem, targetElement));

			//note - validate link destination
			String expUrl="/health-plans.html#/plan-summary";
			if (memberType.toUpperCase().contains("UHC"))
				if (MRScenario.environment.contains("stage"))
					expUrl="uhcmedicaresolutions.uhc.com"+expUrl;
				else
					expUrl="uhcmedicaresolutions.com"+expUrl;
			else 
				if (MRScenario.environment.contains("stage"))
					expUrl="aarpmedicareplans.uhc.com"+expUrl;
				else
					expUrl="aarpmedicareplans.com"+expUrl;

			WebElement expElement=acqPlanOverviewBox;
			note.addAll(validateLnkBehavior(planType, memberType, targetItem, targetElement, expUrl, expElement));

			targetItem=section+subSection+" - Compare New Plans Link Arrow";
			targetElement=sars_enrolPlnSec_choYurPlnSec_stayInPln_compNewPlnsLnk_arrow;
			note.addAll(validateHaveItem(targetItem, targetElement));

			note.add("\n\tValidate after clicking 'Compare New Plans' link");
			//note: after link click, little check should turn green
			targetItem=section+" - green checkmark";
			targetElement=sars_enrolPlnSec_choYurPlnSec_checkMark_green;
			note.addAll(validateHaveItem(targetItem, targetElement));

			//note: after link click, section circle should turn green
			targetItem=section+" - green circle";
			targetElement=sars_enrolPlnSec_circle_green;
			note.addAll(validateHaveItem(targetItem, targetElement));

		} else {
			if (validateAsMuchAsPossible) {
				if (!noWaitValidate(targetElement)) 
					note.add("\tPASSED - validation for NOT HAVING "+targetItem);
				else
					note.add("\t * FAILED - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr2+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'");
			} else {
				Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr2+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
				note.add("\tPASSED - validation for NOT HAVING "+targetItem);
			}
		}	

		return note;
	}

	
	

	

}