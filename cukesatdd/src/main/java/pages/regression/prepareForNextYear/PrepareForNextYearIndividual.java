package pages.regression.prepareForNextYear;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;

public class PrepareForNextYearIndividual extends PrepareForNextYearBase {

	public PrepareForNextYearIndividual(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}


	@Override
	public void openAndValidate(){
	}

	public boolean hasPrepareForNextYearTabDisplay(boolean expectTab) {
		if (noWaitValidate(prepareForNextYearTab))
			return true;
		else 
			return false;
	}

	PrepareForNextYearTimeline pnfyTimeline=new PrepareForNextYearTimeline(driver);

	public List<String>  validateTimeLineBoxContent(boolean expNoBlue_t1, boolean expNoBlue_t2, boolean expNoBlue_t3, boolean expNoBlue_t4, boolean expNoBlue_t5) {
		return pnfyTimeline.validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
	}
	
	public List<String> validateReviewPlanChangesSection_ind(String planType, String memberType, Date currentDate, boolean showSectionDoc_f1, boolean showSectionDoc_f2, boolean showSectionDoc_f3, boolean showSectionDoc_f4, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String section="Review plan changes";
		note.add("\tValidate for section: "+section);
		String targetItem=section+" - section";
		WebElement targetElement=ind_reviewPlanChangesSection;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - Circle";
		targetElement=ind_reviewPlanChanges_circle;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - header";
		targetElement=ind_reviewPlanChanges_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - text";
		targetElement=ind_reviewPlanChanges_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		section=section+" - document ";
		targetItem=section+" section";
		targetElement=ind_reviewPlanChanges_docSection;
		if (showSectionDoc_f1) {
			note.addAll(validateHaveItem(targetItem, targetElement));

			note.add("\t=================");
			note.addAll(validateLanguageDropdown(section, ind_reviewPlanChanges_docSection_langDropdown, ind_reviewPlanChanges_lang_english, ind_reviewPlanChanges_lang_spanish, ind_reviewPlanChanges_lang_chinese));

			targetItem=section+" - checkmark";
			targetElement=ind_reviewPlanChanges_docSection_checkMark;
			note.addAll(validateHaveItem(targetItem, targetElement));

			note.add("\t=================");

			targetItem=section+" - Compare Your Current Plan To Next Year's Plan link";
			targetElement=ind_reviewPlanChanges_docSection_activeCompareYourCurrentPlanLnk;
			note.addAll(validateHaveItem(targetItem, targetElement));

			//TODO - click the Compare Your Current Plan link

			note.add("\t=================");
			if (docDisplayMap.get("Annual Notice of Changes English")) {
				targetItem=section+" - the 'or' text";
				targetElement=ind_reviewPlanChanges_docSection_activeOrTextForAnoc;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateHaveItem(targetItem, targetElement));

				targetItem=section+" - English 'Annual Notice of Changes (PDF)'";
				targetElement=ind_reviewPlanChanges_docSection_activeAnoc_us;
				note.addAll(validateHaveItem(targetItem, targetElement));

				note.addAll(validatePdf(targetItem, targetElement));

				targetItem=section+" - Arrow after 'Annual Notice of Changes (PDF)'";
				targetElement=ind_reviewPlanChanges_docSection_arrowAfterActiveAnoc;
				note.addAll(validateHaveItem(targetItem, targetElement));
			} else {
				Assert.assertTrue("SHOULD land on SAR page", false);;
			}

			//note: if there is spanish doc
			note.add("\t=================");
			targetItem=section+" - Spanish 'Annual Notice of Changes (PDF)'";
			if (docDisplayMap.get("Annual Notice of Changes Spanish")) {
				Select select = new Select(ind_reviewPlanChanges_docSection_langDropdown);           
				select.selectByValue("es");

				targetElement=ind_reviewPlanChanges_docSection_activeAnoc_es;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateHaveItem(targetItem, targetElement));

				note.addAll(validatePdf(targetItem, targetElement));

				targetItem=section+" - Arrow after 'Annual Notice of Changes (PDF)'";
				targetElement=ind_reviewPlanChanges_docSection_arrowAfterActiveAnoc;
				note.addAll(validateHaveItem(targetItem, targetElement));

			} else {
				//note: no doc then no dropdown
				ind_reviewPlanChanges_docSection_langDropdown.click();
				targetItem="Spanish language dropdown option'";
				targetElement=ind_reviewPlanChanges_lang_spanish;
				note.addAll(validateDontHaveItem(targetItem, targetElement));

			}

			//note: if there is chinese doc
			note.add("\t=================");
			targetItem=section+" - Chinese 'Annual Notice of Changes (PDF)'";
			if (docDisplayMap.get("Annual Notice of Changes Chinese")) {
				Select select = new Select(ind_reviewPlanChanges_docSection_langDropdown);           
				select.selectByValue("zh");

				targetElement=ind_reviewPlanChanges_docSection_activeAnoc_zh;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateHaveItem(targetItem, targetElement));

				note.addAll(validatePdf(targetItem, targetElement));

			} else {
				note.add("\t* TODO - no Chinese dropdown");
				//note: no doc then no dropdown
				//TODO ind_reviewPlanChanges_docSection_langDropdown.click();
				//TODO targetItem="Chinese language dropdown option'";
				//TODO targetElement=ind_reviewPlanChanges_lang_chinese;
				//TODO note.addAll(validateDontHaveItem(targetItem, targetElement));
			}

			//note: reset back to english option at the end
			Select select = new Select(ind_reviewPlanChanges_docSection_langDropdown);           
			select.selectByValue("en_us");

		
		} else {
			note.addAll(validateDontHaveItem(targetItem, targetElement));
		}		
		return note;
	}
	

	public List<String> validateReviewPlanMaterialsSection_ind(String planType, String memberType, Date currentDate, boolean showSectionDoc_f1, boolean showSectionDoc_f2, boolean showSectionDoc_f3, boolean showSectionDoc_f4, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String section="Review Plan Materials";
		note.add("\tValidate for section: "+section);
		String targetItem=section+" - section";
		WebElement targetElement=reviewPlanMaterials;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - Circle";
		targetElement=ind_reviewPlanMaterials_circle;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - header";
		targetElement=ind_reviewPlanMaterials_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - text";
		targetElement=ind_reviewPlanMaterials_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		section=section+" - document ";
		targetItem=section+" section";
		targetElement=ind_reviewPlanMaterials_docSection;
		if (showSectionDoc_f1) {
			note.addAll(validateHaveItem(targetItem, targetElement));

			note.add("\t=================");
			note.addAll(validateLanguageDropdown(section, ind_reviewPlanMaterials_docSection_langDropdown, ind_reviewPlanMaterials_lang_english, ind_reviewPlanMaterials_lang_spanish, ind_reviewPlanMaterials_lang_chinese));


			note.add("\t=================");
			validateReviewYourBenefitsPlans(section, planType, memberType, currentDate, showSectionDoc_f1, showSectionDoc_f2, showSectionDoc_f3, showSectionDoc_f4, docDisplayMap);
			
			if (planType.equalsIgnoreCase("MAPD") || planType.equalsIgnoreCase("PDP") ) 
				validateReviewYourPresDrug(section, planType, memberType, currentDate, showSectionDoc_f1, showSectionDoc_f2, showSectionDoc_f3, showSectionDoc_f4, docDisplayMap);

			if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD") ) 
				validateReviewProviderInfo(section, planType, memberType, currentDate, showSectionDoc_f1, showSectionDoc_f2, showSectionDoc_f3, showSectionDoc_f4, docDisplayMap);

			if (planType.equalsIgnoreCase("MAPD") || planType.equalsIgnoreCase("PDP") ) 
				validateReviewPharmacyInfo(section, planType, memberType, currentDate, showSectionDoc_f1, showSectionDoc_f2, showSectionDoc_f3, showSectionDoc_f4, docDisplayMap);
			
		} else {
			Assert.assertTrue("PROBLEM - should not able to locate element for '"+targetItem+"'", !noWaitValidate(targetElement));
			note.add("PASSED - validation for "+targetItem);
		}		
		
		return note;
	}

	public List<String> validateReviewYourBenefitsPlans(String section, String planType, String memberType, Date currentDate, boolean showSectionDoc_f1, boolean showSectionDoc_f2, boolean showSectionDoc_f3, boolean showSectionDoc_f4, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Review your plan benefits and costs for next year";

		String targetItem=section+" - checkmark";
		WebElement targetElement=ind_reviewPlanMaterials_docSection_benefits_checkMark;
		note.addAll(validateHaveItem(targetItem, targetElement));

		
		 targetItem=section+subSection+" - header";
		 targetElement=ind_reviewPlanMaterials_docSection_planBenefitsSectionHeader;
		note.addAll(validateHaveItem(targetItem, targetElement));
		
		targetItem=section+subSection+" - text";
		targetElement=ind_reviewPlanMaterials_docSection_planBenefitsSectionText;
		note.addAll(validateHaveItem(targetItem, targetElement));

		note.add("TODO - validate EOC");

		/** TODO
		if (docDisplayMap.get("Evidence of Coverage English")) {
			targetItem=section+" - English 'Annual Notice of Changes (PDF)'";
			targetElement=ind_reviewPlanMaterials_docSection_activeEoc_us;
			note.addAll(validateHaveItem(targetItem, targetElement));

			note.addAll(validatePdf(targetItem, targetElement));
		} else {
			Assert.assertTrue("SHOULD land on SAR page", false);;
		}

		//note: if there is spanish doc
			note.add("\t=================");
		targetItem=section+" - Spanish 'Evidence of Coverage (PDF)'";
		if (docDisplayMap.get("Annual Notice of Changes Spanish")) {
			Select select = new Select(ind_reviewPlanMaterials_docSection_langDropdown);           
			select.selectByValue("es");

			targetElement=ind_reviewPlanMaterials_docSection_activeEoc_es;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateHaveItem(targetItem, targetElement));

			note.addAll(validatePdf(targetItem, targetElement));
		} else {
			//note: no doc then no dropdown
			ind_reviewPlanMaterials_docSection_langDropdown.click();
			targetItem="Spanish language dropdown option'";
			targetElement=ind_reviewPlanChanges_lang_spanish;
			note.addAll(validateDontHaveItem(targetItem, targetElement));

		}

		//note: if there is chinese doc
			note.add("\t=================");
		targetItem=section+" - Chinese 'Evidence of Coverage (PDF)'";
		if (docDisplayMap.get("Annual Notice of Changes Chinese")) {
			Select select = new Select(ind_reviewPlanMaterials_docSection_langDropdown);           
			select.selectByValue("zh");

			targetElement=ind_reviewPlanMaterials_docSection_activeEoc_zh;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateHaveItem(targetItem, targetElement));

			note.addAll(validatePdf(targetItem, targetElement));
		} else {
			//note: no doc then no dropdown
			ind_reviewPlanChanges_docSection_langDropdown.click();
			targetItem="Chinese language dropdown option'";
			targetElement=ind_reviewPlanMaterials_lang_chinese;
			note.addAll(validateDontHaveItem(targetItem, targetElement));
		}
		
		//note: reset back to english option at the end
		Select select = new Select(ind_reviewPlanMaterials_docSection_langDropdown);           
		select.selectByValue("en_us");
		**/
		
		return note;

	}
	
	
	public List<String> validateReviewYourPresDrug(String section, String planType, String memberType, Date currentDate, boolean showSectionDoc_f1, boolean showSectionDoc_f2, boolean showSectionDoc_f3, boolean showSectionDoc_f4, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Review your Prescription drug coverage for next year";
		String targetItem=section+subSection;
		WebElement targetElement=ind_reviewPlanMaterials_docSection_presDrug_checkMark;
		note.addAll(validateHaveItem(targetItem, targetElement));
		
		targetItem=section+subSection+" - header";
		targetElement=ind_reviewPlanMaterials_docSection_presDrugSectionHeader;
		note.addAll(validateHaveItem(targetItem, targetElement));
		
		targetItem=section+subSection+" - text";
		targetElement=ind_reviewPlanMaterials_docSection_presDrugSectionText;
		note.addAll(validateHaveItem(targetItem, targetElement));

		note.add("TODO - validate Comprehensive Formulary");

		/** TODO

		if (docDisplayMap.get("Comprehensive Formulary English")) {
			targetItem=section+" - English 'Comprehensive Formulary (PDF)'";
			targetElement=ind_reviewPlanMaterials_docSection_activeCf_us;
			note.addAll(validateHaveItem(targetItem, targetElement));

			note.addAll(validatePdf(targetItem, targetElement));
		} else {
			Assert.assertTrue("SHOULD land on SAR page", false);;
		}

		//note: if there is spanish doc
			note.add("\t=================");
		targetItem=section+" - Spanish 'Comprehensive Formulary (PDF)'";
		if (docDisplayMap.get("Comprehensive Formulary Spanish")) {
			Select select = new Select(ind_reviewPlanChanges_docSection_langDropdown);           
			select.selectByValue("es");

			targetElement=ind_reviewPlanMaterials_docSection_activeCf_es;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateHaveItem(targetItem, targetElement));

			note.addAll(validatePdf(targetItem, targetElement));
		} else {
			//note: no doc then no dropdown
			ind_reviewPlanMaterials_docSection_langDropdown.click();
			targetItem="Spanish language dropdown option'";
			targetElement=ind_reviewPlanChanges_lang_spanish;
			note.addAll(validateDontHaveItem(targetItem, targetElement));
		}

		//note: if there is chinese doc
			note.add("\t=================");
		targetItem=section+" - Chinese 'Comprehensive Formulary (PDF)'";
		if (docDisplayMap.get("Comprehensive Formulary Chinese")) {
			Select select = new Select(ind_reviewPlanChanges_docSection_langDropdown);           
			select.selectByValue("zh");

			targetElement=ind_reviewPlanMaterials_docSection_activeCf_zh;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateHaveItem(targetItem, targetElement));

			note.addAll(validatePdf(targetItem, targetElement));
		} else {
			//note: no doc then no dropdown
			ind_reviewPlanChanges_docSection_langDropdown.click();
			targetItem="Chinese language dropdown option'";
			targetElement=ind_reviewPlanMaterials_lang_chinese;
			note.addAll(validateDontHaveItem(targetItem, targetElement));
		}

		Select select = new Select(ind_reviewPlanChanges_docSection_langDropdown);           
		select.selectByValue("en_es");
		*/
		return note;
	}

	

	
	public List<String> validateReviewProviderInfo(String section, String planType, String memberType, Date currentDate, boolean showSectionDoc_f1, boolean showSectionDoc_f2, boolean showSectionDoc_f3, boolean showSectionDoc_f4, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Review provider information for next year";
		String targetItem=section+subSection;
		note.add("TODO - validation for "+targetItem);
		return note;
	}
	

	public List<String> validateReviewPharmacyInfo(String section, String planType, String memberType, Date currentDate, boolean showSectionDoc_f1, boolean showSectionDoc_f2, boolean showSectionDoc_f3, boolean showSectionDoc_f4, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Review pharmacy information for next year";
		String targetItem=section+subSection;
		note.add("TODO - validation for "+targetItem);
		return note;
	}
	
	
	
	public List<String> validateComparePlanSection_ind(String memberType, Date currentDate, boolean showSectionDoc_f1, boolean showSectionDoc_f2, boolean showSectionDoc_f3, boolean showSectionDoc_f4, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		note.add("=============================================");
		//---------------------------------------------
		String section="Compare plans online";
		String targetItem=section+" - section";
		note.add("TODO - validation for "+targetItem);
		return note;
	}

	
	
	public List<String> validateEnrollSection_ind(String memberType, Date currentDate, boolean showSectionDoc_f1, boolean showSectionDoc_f2, boolean showSectionDoc_f3, boolean showSectionDoc_f4, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		note.add("=============================================");
		String section="Enroll in the plan that works for you";
		String targetItem=section+" - section";
		note.add("TODO - validation for "+targetItem);
		return note;
	}
	
	



}