package pages.regression.prepareForNextYear;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PrepareForNextYearGroup extends PrepareForNextYearBase {

	public PrepareForNextYearGroup(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	@Override
	public void openAndValidate(){
	}




	public List<String> validateReviewPlanChangesSection_grp(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
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


	public List<String> validateComparePlanSection_grp(String memberType, Date currentDate, boolean showSectionDoc_f1, boolean showSectionDoc_f2, boolean showSectionDoc_f3, boolean showSectionDoc_f4, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		note.add("=============================================");
		//---------------------------------------------
		String section="Compare plans online";
		String targetItem=section+" - section";
		note.add("TODO - validation for "+targetItem);
		return note;
	}

	public List<String> validateEnrollSection_grp(String memberType, Date currentDate, boolean showSectionDoc_f1, boolean showSectionDoc_f2, boolean showSectionDoc_f3, boolean showSectionDoc_f4, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		note.add("=============================================");
		String section="Enroll in the plan that works for you";
		String targetItem=section+" - section";
		note.add("TODO - validation for "+targetItem);
		return note;
	}



}