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

	public List<String> validateReviewPlanChangesSection_ind(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		note.add("\t==============================================================");
		String section="Review plan changes";
		note.add("\tValidate for section: "+section);
		String targetItem=section+" - section";
		WebElement targetElement=ind_revPlnChgSec;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - Circle";
		targetElement=ind_revPlnChgSec_circle;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - header";
		targetElement=ind_revPlnChgSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - text";
		targetElement=indrevPlnChgSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		//-------------------------------------
		section=section+" - document ";
		targetItem=section+" section";
		targetElement=ind_revPlnChgSec_docSec;

		String showDocDateStr="09/15/"+String.valueOf(getCurrentYear());
		Date showDocDate=convertStrToDate(showDocDateStr);
		boolean showSection=false;
		if (currentDate.equals(showDocDate) || currentDate.after(showDocDate)) {
			showSection=true;
		}
		if (showSection) {
			note.addAll(validateHaveItem(targetItem, targetElement));

			note.add("\t=================");
			note.addAll(validateLanguageDropdown(section, ind_revPlnChgSec_docSec_langDropdown, ind_revPlnChgSec_lang_en, ind_revPlnChgSec_lang_es, ind_revPlnChgSec_lang_zh));

			targetItem=section+" - checkmark";
			targetElement=ind_revPlnChgSec_docSec_checkMark;
			note.addAll(validateHaveItem(targetItem, targetElement));

			note.add("\t=================");

			targetItem=section+" - Compare Your Current Plan To Next Year's Plan link";
			targetElement=ind_revPlnChgSec_docSec_cmpYurCurrPlnLnk;
			note.addAll(validateHaveItem(targetItem, targetElement));

			String expUrl="https://www.aarpmedicareplans.com/";
			WebElement expElement=zipCodeField_acq;
			note.addAll(validateLnkBehavior(planType, memberType, targetItem, targetElement, expUrl, expElement));

			targetItem=section+" - Arrow after Compare Your Current Plan To Next Year's Plan link";
			targetElement=ind_revPlnChgSec_docSec_cmpYurCurrPlnLnk_arrow;
			note.addAll(validateHaveItem(targetItem, targetElement));

			String docName="Annual Notice of Changes";
			note.add("\t=================");
			String targetLang="English";
			if (docDisplayMap.get(docName+" "+targetLang)) {
				Select select = new Select(ind_revPlnChgSec_docSec_langDropdown);           
				select.selectByValue("en_us");

				note.add("\tEXPECT "+targetLang+" '"+docName+"' document to display");
				targetItem=section+" - the 'or' text";
				targetElement=ind_revPlnChgSec_docSec_befAnocOr;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateHaveItem(targetItem, targetElement));

				targetItem=section+" - "+targetLang+" '"+docName+" (PDF)'";
				targetElement=ind_revPlnChgSec_docSec_anoc_en;
				note.addAll(validateHaveItem(targetItem, targetElement));
				note.addAll(validatePdfLinkTxt(docName, targetElement));
				
				note.addAll(validatePdf(targetItem, targetElement));

				targetItem=section+" - Arrow after '"+docName+" (PDF)'";
				targetElement=ind_revPlnChgSec_docSec_anoc_en_arrow;
				note.addAll(validateHaveItem(targetItem, targetElement));
			} else {
				note.add("\tDO NOT EXPECT '"+docName+"' document to display");
				Assert.assertTrue("SHOULD land on SAR page", false);;
			}

			//note: if there is spanish doc
			note.add("\t=================");
			targetLang="Spanish";
			targetItem=section+" - "+targetLang+" '"+docName+" (PDF)'";
			if (docDisplayMap.get(docName+" "+targetLang)) {
				note.add("\tEXPECT "+targetLang+" '"+docName+"' document to display");
				Select select = new Select(ind_revPlnChgSec_docSec_langDropdown);           
				select.selectByValue("es");

				Select select2 = new Select(ind_revPlnMatlsSec_docSec_langDropdown);           
				String otherDropDownSelectedValue=select2.getFirstSelectedOption().getText();
				Assert.assertTrue("PROBLEM - switching language option in one section should not have impacted the langage option in other section", otherDropDownSelectedValue.equalsIgnoreCase("ENGLISH"));

				targetElement=ind_revPlnChgSec_docSec_anoc_es;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateHaveItem(targetItem, targetElement));
				note.addAll(validatePdfLinkTxt(docName, targetElement));

				note.addAll(validatePdf(targetItem, targetElement));

				targetItem=section+" - Arrow after 'Annual Notice of Changes (PDF)'";
				targetElement=ind_revPlnChgSec_docSec_anoc_es_arrow;
				note.addAll(validateHaveItem(targetItem, targetElement));

			} else {
				note.add("\tDO NOT "+targetLang+" EXPECT '"+docName+"' document to display");
				//note: no doc then no dropdown
				targetItem="Spanish language dropdown option'";
				targetElement=ind_revPlnChgSec_lang_es_ava;
				note.addAll(validateDontHaveItem(targetItem, targetElement));

				targetElement=ind_revPlnChgSec_docSec_anoc_es;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateDontHaveItem(targetItem, targetElement));

				targetItem=section+" - Arrow after '"+docName+" (PDF)'";
				targetElement=ind_revPlnChgSec_docSec_anoc_es_arrow;
				note.addAll(validateDontHaveItem(targetItem, targetElement));
			}

			//note: if there is chinese doc
			note.add("\t=================");
			targetLang="Chinese";
			targetItem=section+" - "+targetLang+" '"+docName+" (PDF)'";
			if (docDisplayMap.get(docName+" "+targetLang)) {
				note.add("\tEXPECT "+targetLang+" '"+docName+"' document to display");
				Select select = new Select(ind_revPlnChgSec_docSec_langDropdown);           
				select.selectByValue("zh");

				Select select2 = new Select(ind_revPlnMatlsSec_docSec_langDropdown);        
				String otherDropDownSelectedValue=select2.getFirstSelectedOption().getText();
				Assert.assertTrue("PROBLEM - switching language option in one section should not have impacted the langage option in other section", otherDropDownSelectedValue.equalsIgnoreCase("ENGLISH"));

				targetElement=ind_revPlnChgSec_docSec_anoc_zh;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateHaveItem(targetItem, targetElement));
				note.addAll(validatePdfLinkTxt(docName, targetElement));

				note.addAll(validatePdf(targetItem, targetElement));

				targetItem=section+" - Arrow after 'Annual Notice of Changes (PDF)'";
				targetElement=ind_revPlnChgSec_docSec_anoc_zh_arrow;
				note.addAll(validateHaveItem(targetItem, targetElement));

			} else {
				note.add("\tDO NOT EXPECT "+targetLang+" '"+docName+"' document to display");
				//note: no doc then no dropdown
				targetItem="Chinese language dropdown option'";
				targetElement=ind_revPlnChgSec_lang_zh_ava;
				note.addAll(validateDontHaveItem(targetItem, targetElement));

				targetElement=ind_revPlnChgSec_docSec_anoc_zh;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateDontHaveItem(targetItem, targetElement));

				targetItem=section+" - Arrow after 'Annual Notice of Changes (PDF)'";
				targetElement=ind_revPlnChgSec_docSec_anoc_zh_arrow;
				note.addAll(validateDontHaveItem(targetItem, targetElement));
			}
		} else {
			Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
			note.add("\tPASSED - validation for NOT HAVING "+targetItem);
		}	

		Select select = new Select(ind_revPlnChgSec_docSec_langDropdown);           
		select.selectByValue("en_us");

		return note;
	}

	public List<String> validateReviewPlanMaterialsSection_ind(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		note.add("\t==============================================================");
		String section="Review Plan Materials";
		note.add("\tValidate for section: "+section);
		String targetItem=section+" - section";
		WebElement targetElement=ind_revPlnMatlsSec;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - Circle";
		targetElement=ind_revPlnMatlsSec_circle;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - header";
		targetElement=ind_revPlnMatlsSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - text";
		targetElement=indrevPlnMatlsSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		String showDocDateStr="09/15/"+String.valueOf(getCurrentYear());
		Date showDocDate=convertStrToDate(showDocDateStr);
		boolean showSection=false;
		if (currentDate.equals(showDocDate) || currentDate.after(showDocDate)) {
			showSection=true;
		}

		section=section+" - document ";
		targetItem=section+" section";
		targetElement=ind_revPlnMatlsSec_docSec;
		if (showSection) {
			note.addAll(validateHaveItem(targetItem, targetElement));

			note.addAll(validateLanguageDropdown(section, ind_revPlnMatlsSec_docSec_langDropdown, ind_revPlnMatlsSec_lang_en, ind_revPlnMatlsSec_lang_es, ind_revPlnMatlsSec_lang_zh));

			System.out.println("TEST - planType='"+planType+"' - Proceed to validate 'Review your plan benefits and costs for next year' section");
			note.addAll(validateReviewYourBenefitsPlans(section, planType, memberType, currentDate, docDisplayMap));

			if (planType.equalsIgnoreCase("MAPD") || planType.equalsIgnoreCase("PDP")) {
				System.out.println("TEST - planType='"+planType+"' - Proceed to validate 'Review your Prescription drug coverage for next year' section");
				note.addAll(validateReviewYourPresDrug(section, planType, memberType, currentDate, docDisplayMap));
			}
			if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {
				System.out.println("TEST - planType='"+planType+"' - Proceed to validate 'Review provider information for next year' section");
				note.addAll(validateReviewProviderInfo(section, planType, memberType, currentDate, docDisplayMap));
			}
			if (planType.equalsIgnoreCase("MAPD") || planType.equalsIgnoreCase("PDP")) {
				System.out.println("TEST - planType='"+planType+"' - Proceed to validate 'Review pharmacy information for next year' section");
				note.addAll(validateReviewPharmacyInfo(section, planType, memberType, currentDate, docDisplayMap));
			}
		} else {
			Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
			note.add("PASSED - validation for NOT HAVING "+targetItem);
		}	
		return note;
	}

	public List<String> validateReviewYourBenefitsPlans(String section, String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Review your plan benefits and costs for next year";

		String targetItem=section+" - checkmark";
		WebElement targetElement=ind_revPlnMatlsSec_plnBeneSec_checkMark;
		note.addAll(validateHaveItem(targetItem, targetElement));


		targetItem=section+subSection+" - header";
		targetElement=ind_revPlnMatlsSec_plnBeneSec_Header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - text";
		targetElement=ind_revPlnMatlsSec_plnBeneSec_Text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		String showDocDateStr="09/15/"+String.valueOf(getCurrentYear());
		Date showDocDate=convertStrToDate(showDocDateStr);
		boolean showSection=false;
		if (currentDate.equals(showDocDate) || currentDate.after(showDocDate)) {
			showSection=true;
		}

		if (showSection) {
			String docName="Evidence of Coverage";
			String targetLang="English";
			if (docDisplayMap.get(docName+" "+targetLang)) {
				Select select = new Select(ind_revPlnMatlsSec_docSec_langDropdown);           
				select.selectByValue("en_us");

				note.add("\tEXPECT "+targetLang+" '"+docName+"' document to display");
				targetItem=section+" - "+targetLang+" '"+docName+" (PDF)'";
				targetElement=ind_revPlnMatlsSec_plnBeneSec_eoc_en;
				note.addAll(validateHaveItem(targetItem, targetElement));
				note.addAll(validatePdfLinkTxt(docName, targetElement));

				note.addAll(validatePdf(targetItem, targetElement));

				targetItem=section+" - Arrow after '"+docName+"' doc link'";
				targetElement=ind_revPlnMatlsSec_plnBeneSec_eoc_en_arrow;
				note.addAll(validateHaveItem(targetItem, targetElement));


			} else {
				note.add("\tDO NOT EXPECT "+targetLang+" '"+docName+"' document to display");
				Assert.assertTrue("SHOULD land on SAR page", false);;
			}

			//note: if there is spanish doc
			note.add("\t=================");
			targetLang="Spanish";
			targetItem=section+" - "+targetLang+" '"+docName+" (PDF)'";
			if (docDisplayMap.get(docName+" "+targetLang)) {
				note.add("\tEXPECT "+targetLang+" '"+docName+"' document to display");
				Select select = new Select(ind_revPlnMatlsSec_docSec_langDropdown);           
				select.selectByValue("es");

				Select select2 = new Select(ind_revPlnChgSec_docSec_langDropdown);           
				String otherDropDownSelectedValue=select2.getFirstSelectedOption().getText();
				Assert.assertTrue("PROBLEM - switching language option in one section should not have impacted the langage option in other section", otherDropDownSelectedValue.equalsIgnoreCase("ENGLISH"));

				targetElement=ind_revPlnMatlsSec_plnBeneSec_eoc_es;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateHaveItem(targetItem, targetElement));
				note.addAll(validatePdfLinkTxt(docName, targetElement));

				note.addAll(validatePdf(targetItem, targetElement));

				targetItem=section+" - Arrow after '"+docName+"' doc link'";
				targetElement=ind_revPlnMatlsSec_plnBeneSec_eoc_es_arrow;
				note.addAll(validateHaveItem(targetItem, targetElement));
			} else {
				note.add("\tDO NOT EXPECT "+targetLang+" '"+docName+"' document to display");
				//note: no doc then no dropdown
				targetItem="Spanish language dropdown option'";
				targetElement=ind_revPlnChgSec_lang_es_ava;
				note.addAll(validateDontHaveItem(targetItem, targetElement));

				targetElement=ind_revPlnMatlsSec_plnBeneSec_eoc_es;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateDontHaveItem(targetItem, targetElement));

				targetItem=section+" - Arrow after '"+docName+"' doc link'";
				targetElement=ind_revPlnMatlsSec_plnBeneSec_eoc_es_arrow;
				note.addAll(validateDontHaveItem(targetItem, targetElement));
			}

			//note: if there is chinese doc
			note.add("\t=================");
			targetLang="Chinese";
			targetItem=section+" - "+targetLang+" '"+docName+" (PDF)'";
			if (docDisplayMap.get(docName+" "+targetLang)) {
				note.add("\tEXPECT "+targetLang+" '"+docName+"' document to display");
				Select select = new Select(ind_revPlnMatlsSec_docSec_langDropdown);           
				select.selectByValue("zh");

				Select select2 = new Select(ind_revPlnChgSec_docSec_langDropdown);           
				String otherDropDownSelectedValue=select2.getFirstSelectedOption().getText();
				Assert.assertTrue("PROBLEM - switching language option in one section should not have impacted the langage option in other section", otherDropDownSelectedValue.equalsIgnoreCase("ENGLISH"));

				targetElement=ind_revPlnMatlsSec_plnBeneSec_eoc_zh;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateHaveItem(targetItem, targetElement));
				note.addAll(validatePdfLinkTxt(docName, targetElement));

				note.addAll(validatePdf(targetItem, targetElement));

				targetItem=section+" - Arrow after '"+docName+"' link'";
				targetElement=ind_revPlnMatlsSec_plnBeneSec_eoc_zh_arrow;
				note.addAll(validateHaveItem(targetItem, targetElement));

			} else {
				note.add("\tDO NOT EXPECT "+targetLang+" '"+docName+"' document to display");
				//note: no doc then no dropdown
				targetItem="Chinese language dropdown option'";
				targetElement=ind_revPlnChgSec_lang_zh_ava;
				note.addAll(validateDontHaveItem(targetItem, targetElement));

				targetElement=ind_revPlnMatlsSec_plnBeneSec_eoc_zh;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateDontHaveItem(targetItem, targetElement));

				targetItem=section+" - Arrow after '"+docName+"' link'";
				targetElement=ind_revPlnMatlsSec_plnBeneSec_eoc_zh_arrow;
				note.addAll(validateDontHaveItem(targetItem, targetElement));

			}

			Select select = new Select(ind_revPlnChgSec_docSec_langDropdown);           
			select.selectByValue("en_us");

		} else {
			Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
			note.add("PASSED - validation for NOT HAVING "+targetItem);
		}	
		return note;
	}

	public List<String> validateReviewYourPresDrug(String section, String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Review your Prescription drug coverage for next year";
		String targetItem=section+subSection;
		WebElement targetElement=ind_revPlnMatlsSec_presDrugSec_checkMark;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - header";
		targetElement=ind_revPlnMatlsSec_presDrugSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - text";
		targetElement=ind_revPlnMatlsSec_presDrugSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - Drug Search link";
		targetElement=ind_revPlnMatlsSec_presDrugSec_drugSrchLnk;
		note.addAll(validateHaveItem(targetItem, targetElement));

		String expUrl="member/drug-lookup/overview.html";
		WebElement expElement=dceHeader;
		note.addAll(validateLnkBehavior(planType, memberType, targetItem, targetElement, expUrl, expElement));
		
		targetItem=section+subSection+" - arrow after Drug Search link";
		targetElement=ind_revPlnMatlsSec_presDrugSec_drugSrchLnk_arrow;
		note.addAll(validateHaveItem(targetItem, targetElement));


		String docName="Comprehensive Formulary";
		String targetLang="English";
		if (docDisplayMap.get(docName+" "+targetLang)) {
			Select select = new Select(ind_revPlnMatlsSec_docSec_langDropdown);           
			select.selectByValue("en_us");

			note.add("\tEXPECT "+targetLang+" '"+docName+"' document to display");
			targetItem=section+" - "+targetLang+" '"+docName+" (PDF)'";
			targetElement=ind_revPlnMatlsSec_presDrugSec_cf_en;
			note.addAll(validateHaveItem(targetItem, targetElement));
			note.addAll(validatePdfLinkTxt(docName, targetElement));

			note.addAll(validatePdf(targetItem, targetElement));

			targetItem=section+" - 'OR' text before '"+docName+"' link'";
			targetElement=ind_revPlnMatlsSec_presDrugSec_cf_en_OR;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem=section+" - Arrow after '"+docName+"' link'";
			targetElement=ind_revPlnMatlsSec_presDrugSec_cf_en_arrow;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateHaveItem(targetItem, targetElement));

		} else {
			note.add("\tDO NOT EXPECT "+targetLang+" '"+docName+"' document to display");
			Assert.assertTrue("SHOULD land on SAR page", false);
		}

		//note: if there is spanish doc
		note.add("\t=================");
		targetLang="Spanish";
		targetItem=section+" - "+targetLang+" '"+docName+" (PDF)'";
		if (docDisplayMap.get(docName+" "+targetLang)) {
			note.add("\tEXPECT "+targetLang+" '"+docName+"' document to display");
			Select select = new Select(ind_revPlnMatlsSec_docSec_langDropdown);           
			select.selectByValue("es");

			targetElement=ind_revPlnMatlsSec_presDrugSec_cf_es;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateHaveItem(targetItem, targetElement));
			note.addAll(validatePdfLinkTxt(docName, targetElement));

			note.addAll(validatePdf(targetItem, targetElement));

			targetItem=section+" - Arrow after '"+docName+"' link'";
			targetElement=ind_revPlnMatlsSec_presDrugSec_cf_es_arrow;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateHaveItem(targetItem, targetElement));

		} else {
			note.add("\tDO NOT EXPECT "+targetLang+" '"+docName+"' document to display");
			//note: no doc then no dropdown
			targetItem="Spanish language dropdown option'";
			targetElement=ind_revPlnChgSec_lang_es_ava;
			note.addAll(validateDontHaveItem(targetItem, targetElement));

			targetElement=ind_revPlnMatlsSec_presDrugSec_cf_es;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateDontHaveItem(targetItem, targetElement));

			targetItem=section+" - Arrow after '"+docName+"' link'";
			targetElement=ind_revPlnMatlsSec_presDrugSec_cf_es_arrow;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateDontHaveItem(targetItem, targetElement));
		}

		//note: if there is chinese doc
		note.add("\t=================");
		targetLang="Chinese";
		targetItem=section+" - "+targetLang+" '"+docName+" (PDF)'";
		if (docDisplayMap.get(docName+" "+targetLang)) {
			note.add("\tEXPECT '"+docName+"' document to display");
			Select select = new Select(ind_revPlnMatlsSec_docSec_langDropdown);           
			select.selectByValue("zh");

			targetElement=ind_revPlnMatlsSec_presDrugSec_cf_zh;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateHaveItem(targetItem, targetElement));
			note.addAll(validatePdfLinkTxt(docName, targetElement));

			note.addAll(validatePdf(targetItem, targetElement));

			targetItem=section+" - Arrow after Comprehensive Formulary link'";
			targetElement=ind_revPlnMatlsSec_presDrugSec_cf_zh_arrow;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateHaveItem(targetItem, targetElement));

		} else {
			note.add("\tDO NOT EXPECT "+targetLang+" '"+docName+"' document to display");
			//note: no doc then no dropdown
			targetItem="Chinese language dropdown option'";
			targetElement=ind_revPlnChgSec_lang_zh_ava;
			note.addAll(validateDontHaveItem(targetItem, targetElement));

			targetElement=ind_revPlnMatlsSec_presDrugSec_cf_zh;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateDontHaveItem(targetItem, targetElement));

			targetItem=section+" - Arrow after Comprehensive Formulary link'";
			targetElement=ind_revPlnMatlsSec_presDrugSec_cf_zh_arrow;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateDontHaveItem(targetItem, targetElement));
		}

		Select select = new Select(ind_revPlnChgSec_docSec_langDropdown);           
		select.selectByValue("en_us");

		return note;
	}

	public List<String> validateReviewProviderInfo(String section, String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Review provider information for next year";
		String targetItem=section+subSection;
		WebElement targetElement=ind_revPlnMatlsSec_provInfoSec_checkMark;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - header";
		targetElement=ind_revPlnMatlsSec_provInfoSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - text";
		targetElement=ind_revPlnMatlsSec_provInfoSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		String showDocDateStr="10/01/"+String.valueOf(getCurrentYear());
		Date showDocDate=convertStrToDate(showDocDateStr);
		boolean showSection=false;
		if (currentDate.equals(showDocDate) || currentDate.after(showDocDate)) {
			showSection=true;
		}

		targetItem=section+subSection+" - Search For Providers link";
		targetElement=ind_revPlnMatlsSec_provInfoSec_provSrchLnk;
		if (showSection) {
			note.addAll(validateHaveItem(targetItem, targetElement));

			String expUrl="member.mymedicareaccount.com|member.uhc.com|connect.werally.com";
			WebElement expElement=providerSearchHeaderTxt;
			note.addAll(validateLnkBehavior(planType, memberType, targetItem, targetElement, expUrl, expElement));

			targetItem=section+subSection+" - arrow after Search For Providers link";
			targetElement=ind_revPlnMatlsSec_provInfoSec_provSrchLnk_arrow;
			note.addAll(validateHaveItem(targetItem, targetElement));


			String docName="Provider Directory";
			String targetLang="English";
			if (docDisplayMap.get(docName+" "+targetLang)) {
				Select select = new Select(ind_revPlnMatlsSec_docSec_langDropdown);           
				select.selectByValue("en_us");

				note.add("\tEXPECT "+targetLang+" '"+docName+"' document to display");
				targetItem=section+" - "+targetLang+" '"+docName+" (PDF)'";
				targetElement=ind_revPlnMatlsSec_provInfoSec_pr_en;
				note.addAll(validateHaveItem(targetItem, targetElement));
				note.addAll(validatePdfLinkTxt(docName, targetElement));

				note.addAll(validatePdf(targetItem, targetElement));

				targetItem=section+" - 'OR' text before '"+docName+"' link'";
				targetElement=ind_revPlnMatlsSec_provInfoSec_pr_en_OR;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateHaveItem(targetItem, targetElement));

				targetItem=section+" - Arrow after '"+docName+"' link'";
				targetElement=ind_revPlnMatlsSec_provInfoSec_pr_en_arrow;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateHaveItem(targetItem, targetElement));

			} else {
				note.add("\tDO NOT EXPECT "+targetLang+" '"+docName+"' document to display");
				Assert.assertTrue("SHOULD land on SAR page", false);
			}

			//note: if there is spanish doc
			note.add("\t=================");
			targetLang="Spanish";
			targetItem=section+" - "+targetLang+" '"+docName+" (PDF)'";
			if (docDisplayMap.get(docName+" "+targetLang)) {
				note.add("\tEXPECT "+targetLang+" '"+docName+"' document to display");
				Select select = new Select(ind_revPlnMatlsSec_docSec_langDropdown);           
				select.selectByValue("es");

				targetElement=ind_revPlnMatlsSec_provInfoSec_pr_es;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateHaveItem(targetItem, targetElement));
				note.addAll(validatePdfLinkTxt(docName, targetElement));

				note.addAll(validatePdf(targetItem, targetElement));

				targetItem=section+" - Arrow after '"+docName+"' link'";
				targetElement=ind_revPlnMatlsSec_provInfoSec_pr_es_arrow;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateHaveItem(targetItem, targetElement));

			} else {
				note.add("\tDO NOT EXPECT "+targetLang+" '"+docName+"' document to display");
				//note: no doc then no dropdown
				targetItem="Spanish language dropdown option'";
				targetElement=ind_revPlnChgSec_lang_es_ava;
				note.addAll(validateDontHaveItem(targetItem, targetElement));

				targetElement=ind_revPlnMatlsSec_provInfoSec_pr_es;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateDontHaveItem(targetItem, targetElement));

				targetItem=section+" - Arrow after '"+docName+"' link'";
				targetElement=ind_revPlnMatlsSec_provInfoSec_pr_es_arrow;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateDontHaveItem(targetItem, targetElement));
			}

			//note: if there is chinese doc
			note.add("\t=================");
			targetLang="Chinese";
			targetItem=section+" - "+targetLang+" '"+docName+" (PDF)'";
			if (docDisplayMap.get(docName+" "+targetLang)) {
				note.add("\tEXPECT '"+docName+"' document to display");
				Select select = new Select(ind_revPlnMatlsSec_docSec_langDropdown);           
				select.selectByValue("zh");

				targetElement=ind_revPlnMatlsSec_provInfoSec_pr_zh;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateHaveItem(targetItem, targetElement));
				note.addAll(validatePdfLinkTxt(docName, targetElement));

				note.addAll(validatePdf(targetItem, targetElement));

				targetItem=section+" - Arrow after '"+docName+"' link'";
				targetElement=ind_revPlnMatlsSec_provInfoSec_pr_zh_arrow;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateHaveItem(targetItem, targetElement));

			} else {
				note.add("\tDO NOT EXPECT "+targetLang+" '"+docName+"' document to display");
				//note: no doc then no dropdown
				targetItem="Chinese language dropdown option'";
				targetElement=ind_revPlnChgSec_lang_zh_ava;
				note.addAll(validateDontHaveItem(targetItem, targetElement));

				targetElement=ind_revPlnMatlsSec_presDrugSec_cf_zh;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateDontHaveItem(targetItem, targetElement));

				targetItem=section+" - Arrow after Comprehensive Formulary link'";
				targetElement=ind_revPlnMatlsSec_presDrugSec_cf_zh_arrow;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateDontHaveItem(targetItem, targetElement));
			}

			targetLang="English";
			docName="Vendor Information Sheet";
			if (docDisplayMap.get(docName+" "+targetLang)) {
				Select select = new Select(ind_revPlnMatlsSec_docSec_langDropdown);           
				select.selectByValue("en_us");

				note.add("\tEXPECT "+targetLang+" '"+docName+"' document to display");
				targetItem=section+" - "+targetLang+" '"+docName+" (PDF)'";
				targetElement=ind_revPlnMatlsSec_provInfoSec_ve_en;
				note.addAll(validateHaveItem(targetItem, targetElement));
				note.addAll(validatePdfLinkTxt(docName, targetElement));

				note.addAll(validatePdf(targetItem, targetElement));

				targetItem=section+" - Arrow after '"+docName+"' link'";
				targetElement=ind_revPlnMatlsSec_provInfoSec_ve_en_arrow;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateHaveItem(targetItem, targetElement));

			} else {
				note.add("\tDO NOT EXPECT "+targetLang+" '"+docName+"' document to display");
				Assert.assertTrue("SHOULD land on SAR page", false);
			}

			//note: if there is spanish doc
			note.add("\t=================");
			targetLang="Spanish";
			targetItem=section+" - "+targetLang+" '"+docName+" (PDF)'";
			if (docDisplayMap.get(docName+" "+targetLang)) {
				note.add("\tEXPECT "+targetLang+" '"+docName+"' document to display");
				Select select = new Select(ind_revPlnMatlsSec_docSec_langDropdown);           
				select.selectByValue("es");

				targetElement=ind_revPlnMatlsSec_provInfoSec_ve_es;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateHaveItem(targetItem, targetElement));
				note.addAll(validatePdfLinkTxt(docName, targetElement));

				note.addAll(validatePdf(targetItem, targetElement));

				targetItem=section+" - Arrow after '"+docName+"' link'";
				targetElement=ind_revPlnMatlsSec_provInfoSec_ve_es_arrow;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateHaveItem(targetItem, targetElement));

			} else {
				note.add("\tDO NOT EXPECT "+targetLang+" '"+docName+"' document to display");
				//note: no doc then no dropdown
				targetItem="Spanish language dropdown option'";
				targetElement=ind_revPlnChgSec_lang_es_ava;
				note.addAll(validateDontHaveItem(targetItem, targetElement));

				targetElement=ind_revPlnMatlsSec_provInfoSec_ve_es;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateDontHaveItem(targetItem, targetElement));

				targetItem=section+" - Arrow after '"+docName+"' link'";
				targetElement=ind_revPlnMatlsSec_provInfoSec_ve_es_arrow;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateDontHaveItem(targetItem, targetElement));
			}

			//note: if there is chinese doc
			note.add("\t=================");
			targetLang="Chinese";
			targetItem=section+" - "+targetLang+" '"+docName+" (PDF)'";
			if (docDisplayMap.get(docName+" "+targetLang)) {
				note.add("\tEXPECT '"+docName+"' document to display");
				Select select = new Select(ind_revPlnMatlsSec_docSec_langDropdown);           
				select.selectByValue("zh");

				targetElement=ind_revPlnMatlsSec_provInfoSec_ve_zh;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateHaveItem(targetItem, targetElement));
				note.addAll(validatePdfLinkTxt(docName, targetElement));

				note.addAll(validatePdf(targetItem, targetElement));

				targetItem=section+" - Arrow after '"+docName+"' link'";
				targetElement=ind_revPlnMatlsSec_provInfoSec_ve_zh_arrow;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateHaveItem(targetItem, targetElement));

			} else {
				note.add("\tDO NOT EXPECT "+targetLang+" '"+docName+"' document to display");
				/* TODO
				//note: no doc then no dropdown
				ind_reviewPlanChanges_docSection_langDropdown.click();
				targetItem="Chinese language dropdown option'";
				targetElement=ind_reviewPlanMaterials_lang_chinese;
				note.addAll(validateDontHaveItem(targetItem, targetElement));
				 */

				targetElement=ind_revPlnMatlsSec_provInfoSec_ve_zh;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateDontHaveItem(targetItem, targetElement));

				targetItem=section+" - Arrow after Comprehensive Formulary link'";
				targetElement=ind_revPlnMatlsSec_provInfoSec_ve_zh_arrow;
				CommonUtility.waitForPageLoad(driver, targetElement, 10);
				note.addAll(validateDontHaveItem(targetItem, targetElement));
			}		

			Select select = new Select(ind_revPlnChgSec_docSec_langDropdown);           
			select.selectByValue("en_us");

		} else {
			Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
			note.add("PASSED - validation for NOT HAVING "+targetItem);
		}	


		return note;
	}

	public List<String> validateReviewPharmacyInfo(String section, String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Review pharmacy information for next year";
		String targetItem=section+subSection;
		WebElement targetElement=ind_revPlnMatlsSec_pharInfoSec_checkMark;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - header";
		targetElement=ind_revPlnMatlsSec_pharInfoSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - text";
		targetElement=ind_revPlnMatlsSec_pharInfoSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - Provider Directory link";
		targetElement=ind_revPlnMatlsSec_pharInfoSec_pharSrchLnk;
		note.addAll(validateHaveItem(targetItem, targetElement));

		String expUrl="member/pharmacy-locator/overview.html";
		WebElement expElement=pharmacyHeader;
		note.addAll(validateLnkBehavior(planType, memberType, targetItem, targetElement, expUrl, expElement));


		targetItem=section+subSection+" - arrow after Drug Search link";
		targetElement=ind_revPlnMatlsSec_pharInfoSec_pharSrchLnk_arrow;
		note.addAll(validateHaveItem(targetItem, targetElement));


		String docName="Pharmacy Directory Information";
		String targetLang="English";
		if (docDisplayMap.get(docName+" "+targetLang)) {
			Select select = new Select(ind_revPlnMatlsSec_docSec_langDropdown);           
			select.selectByValue("en_us");

			note.add("\tEXPECT "+targetLang+" '"+docName+"' document to display");
			targetItem=section+" - "+targetLang+" '"+docName+" (PDF)'";
			targetElement=ind_revPlnMatlsSec_pharInfoSec_ph_en;
			note.addAll(validateHaveItem(targetItem, targetElement));
			note.addAll(validatePdfLinkTxt(docName, targetElement));

			note.addAll(validatePdf(targetItem, targetElement));

			targetItem=section+" - 'OR' text before '"+docName+"' link'";
			targetElement=ind_revPlnMatlsSec_pharInfoSec_ph_en_OR;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateHaveItem(targetItem, targetElement));


			targetItem=section+" - Arrow after '"+docName+"' link'";
			targetElement=ind_revPlnMatlsSec_pharInfoSec_ph_en_arrow;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateHaveItem(targetItem, targetElement));

		} else {
			note.add("\tDO NOT EXPECT "+targetLang+" '"+docName+"' document to display");
			Assert.assertTrue("SHOULD land on SAR page", false);
		}

		//note: if there is spanish doc
		note.add("\t=================");
		targetLang="Spanish";
		targetItem=section+" - "+targetLang+" '"+docName+" (PDF)'";
		if (docDisplayMap.get(docName+" "+targetLang)) {
			note.add("\tEXPECT "+targetLang+" '"+docName+"' document to display");
			Select select = new Select(ind_revPlnMatlsSec_docSec_langDropdown);           
			select.selectByValue("es");

			targetElement=ind_revPlnMatlsSec_pharInfoSec_ph_es;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateHaveItem(targetItem, targetElement));
			note.addAll(validatePdfLinkTxt(docName, targetElement));

			note.addAll(validatePdf(targetItem, targetElement));

			targetItem=section+" - Arrow after '"+docName+"' link'";
			targetElement=ind_revPlnMatlsSec_pharInfoSec_ph_es_arrow;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateHaveItem(targetItem, targetElement));

		} else {
			note.add("\tDO NOT EXPECT "+targetLang+" '"+docName+"' document to display");
			//note: no doc then no dropdown
			targetItem="Spanish language dropdown option'";
			targetElement=ind_revPlnMatlsSec_lang_es_ava;
			note.addAll(validateDontHaveItem(targetItem, targetElement));

			targetElement=ind_revPlnMatlsSec_pharInfoSec_ph_es;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateDontHaveItem(targetItem, targetElement));

			targetItem=section+" - Arrow after '"+docName+"' link'";
			targetElement=ind_revPlnMatlsSec_pharInfoSec_ph_es_arrow;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateDontHaveItem(targetItem, targetElement));
		}

		//note: if there is chinese doc
		note.add("\t=================");
		targetLang="Chinese";
		targetItem=section+" - "+targetLang+" '"+docName+" (PDF)'";
		if (docDisplayMap.get(docName+" "+targetLang)) {
			note.add("\tEXPECT '"+docName+"' document to display");
			Select select = new Select(ind_revPlnMatlsSec_docSec_langDropdown);           
			select.selectByValue("zh");

			targetElement=ind_revPlnMatlsSec_pharInfoSec_ph_zh;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateHaveItem(targetItem, targetElement));
			note.addAll(validatePdfLinkTxt(docName, targetElement));

			note.addAll(validatePdf(targetItem, targetElement));

			targetItem=section+" - Arrow after '"+docName+"' link'";
			targetElement=ind_revPlnMatlsSec_pharInfoSec_ph_zh_arrow;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateHaveItem(targetItem, targetElement));

		} else {
			note.add("\tDO NOT EXPECT "+targetLang+" '"+docName+"' document to display");
			//note: no doc then no dropdown
			targetItem="Chinese language dropdown option'";
			targetElement=ind_revPlnMatlsSec_lang_zh_ava;
			note.addAll(validateDontHaveItem(targetItem, targetElement));

			targetElement=ind_revPlnMatlsSec_pharInfoSec_ph_zh;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateDontHaveItem(targetItem, targetElement));

			targetItem=section+" - Arrow after Comprehensive Formulary link'";
			targetElement=ind_revPlnMatlsSec_pharInfoSec_ph_zh_arrow;
			CommonUtility.waitForPageLoad(driver, targetElement, 10);
			note.addAll(validateDontHaveItem(targetItem, targetElement));
		}

		return note;
	}


	public List<String> validateComparePlanSection_ind(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		note.add("\t==============================================================");
		String section="Compare plans online";
		note.add("\tValidate for section: "+section);
		String targetItem=section+" - section";
		WebElement targetElement=ind_compPlnsSec;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - Circle";
		targetElement=ind_compPlnsSec_circle;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - header";
		targetElement=ind_compPlnsSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - text";
		targetElement=ind_compPlnsSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		String showDocDateStr="10/01/"+String.valueOf(getCurrentYear());
		Date showDocDate=convertStrToDate(showDocDateStr);
		boolean showSection=false;
		if (currentDate.equals(showDocDate) || currentDate.after(showDocDate)) {
			showSection=true;
		}

		section=section+" - document ";
		targetItem=section+" section";
		targetElement=ind_compPlnsSec_lrnOthPlnSec;
		if (showSection) {
			note.addAll(validateHaveItem(targetItem, targetElement));

			System.out.println("TEST - planType='"+planType+"' - Proceed to validate 'Learn about other plan choices' section");
			note.addAll(validateLearnOtherPlans(section, planType, memberType, currentDate, docDisplayMap));
		} else {
			Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
			note.add("PASSED - validation for NOT HAVING "+targetItem);
		}		
		return note;
	}

	public List<String> validateLearnOtherPlans(String section, String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Learn about other plan choices";

		String targetItem=section+" - checkmark";
		WebElement targetElement=ind_compPlnsSec_lrnOthPlnSec_checkMark;
		note.addAll(validateHaveItem(targetItem, targetElement));


		targetItem=section+subSection+" - header";
		targetElement=ind_compPlnsSec_lrnOthPlnSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - text";
		targetElement=ind_compPlnsSec_lrnOthPlnSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));


		targetItem=section+subSection+" - Skip This Link";
		targetElement=ind_compPlnsSec_lrnOthPlnSec_skipThisLnk;
		note.addAll(validateHaveItem(targetItem, targetElement));

		//TODO - validate link destination

		targetItem=section+subSection+" - Skip This Link Arrow";
		targetElement=ind_compPlnsSec_lrnOthPlnSec_skipThisLnk_arrow;
		note.addAll(validateHaveItem(targetItem, targetElement));


		targetItem=section+subSection+" - 'OR' text before Compare New Plans Link";
		targetElement=ind_compPlnsSec_lrnOthPlnSec_compNewPlnsLnk_OR;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - Compare New Plans Link";
		targetElement=ind_compPlnsSec_lrnOthPlnSec_compNewPlnsLnk;
		note.addAll(validateHaveItem(targetItem, targetElement));

		//TODO - validate link destination

		targetItem=section+subSection+" - Compare New Plans Link Arrow";
		targetElement=ind_compPlnsSec_lrnOthPlnSec_compNewPlnsLnk_arrow;
		note.addAll(validateHaveItem(targetItem, targetElement));

		return note;
	}

	public List<String> validateEnrollSection_ind(String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		note.add("\t==============================================================");
		String section="Enroll in the plan that works for you";

		note.add("\tValidate for section: "+section);
		String targetItem=section+" - section";
		WebElement targetElement=ind_enrolPlnSec;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - Circle";
		targetElement=ind_enrolPlnSec_circle;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - header";
		targetElement=ind_enrolPlnSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - text";
		targetElement=ind_enrolPlnSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		section=section+" - document ";
		targetItem=section+" section";
		targetElement=ind_enrolPlnSec_choYurPlnSec;
		note.addAll(validateHaveItem(targetItem, targetElement));

		System.out.println("TEST - planType='"+planType+"' - Proceed to validate 'Choose your plan");
		note.addAll(validateChoosePlan(section, planType, memberType, currentDate, docDisplayMap));
		return note;
	}

	public List<String> validateChoosePlan(String section, String planType, String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		note.add("\t=================");
		String subSection=" - Choose your plan";

		String targetItem=section+" - checkmark";
		WebElement targetElement=ind_enrolPlnSec_choYurPlnSec_checkMark;
		note.addAll(validateHaveItem(targetItem, targetElement));


		targetItem=section+subSection+" - header";
		targetElement=ind_enrolPlnSec_choYurPlnSec_header;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+subSection+" - text";
		targetElement=ind_enrolPlnSec_choYurPlnSec_text;
		note.addAll(validateHaveItem(targetItem, targetElement));

		//---------------------------
		String showDocDateStr="12/07/"+String.valueOf(getCurrentYear());
		Date showDocDate=convertStrToDate(showDocDateStr);
		boolean showSection=false;
		if (currentDate.before(showDocDate) ) {
			showSection=true;
		}

		targetItem=section+subSection+" - Stay in Current Plan link";
		targetElement=ind_enrolPlnSec_choYurPlnSec_stayInPlnLnk;
		if (showSection) {
			note.addAll(validateHaveItem(targetItem, targetElement));

			//TODO - validate link destination

			targetItem=section+subSection+" - Stay in Current Plan link Arrow";
			targetElement=ind_enrolPlnSec_choYurPlnSec_stayInPlnLnk_arrow;
			note.addAll(validateHaveItem(targetItem, targetElement));


			//---------------------------
			showDocDateStr="10/15/"+String.valueOf(getCurrentYear());
			showDocDate=convertStrToDate(showDocDateStr);
			boolean showSection2=false;
			if (currentDate.equals(showDocDate) || currentDate.after(showDocDate)) {
				showSection2=true;
			}

			targetItem=section+subSection+" - Stay in Current Plan - Compare New Plans Link";
			targetElement=ind_enrolPlnSec_choYurPlnSec_stayInPln_compNewPlnsLnk;
			if (showSection2) {
				note.addAll(validateHaveItem(targetItem, targetElement));

				//TODO - validate link destination

				targetItem=section+subSection+" - Stay in Current Plan - 'OR' text before Compare New Plans Link";
				targetElement=ind_enrolPlnSec_choYurPlnSec_stayInPln_compNewPlnsLnk_OR;
				note.addAll(validateHaveItem(targetItem, targetElement));
				Assert.assertTrue("PROBLEM - unable to locate '"+targetItem+"'.  Actual line of text='"+targetElement.getText()+"'", targetElement.getText().contains(" or "));

				targetItem=section+subSection+" - Stay in Current Plan  - Compare New Plans Link Arrow";
				targetElement=ind_enrolPlnSec_choYurPlnSec_stayInPln_compNewPlnsLnk_arrow;
				note.addAll(validateHaveItem(targetItem, targetElement));
			} else {
				Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
				note.add("PASSED - validation for NOT HAVING "+targetItem);
			}	
			
			//---------------------------
			targetItem=section+subSection+" - Selected New Plan";
			targetElement=ind_enrolPlnSec_choYurPlnSec_seleNewPln_text;
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem=section+subSection+" - Selected New Plan - Compare New Plans Link";
			targetElement=ind_enrolPlnSec_choYurPlnSec_seleNewPln_compNewPlnsLnk;
			note.addAll(validateHaveItem(targetItem, targetElement));

			//TODO - validate link destination
		} else {
			Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
			note.add("PASSED - validation for NOT HAVING "+targetItem);
		}	

		showDocDateStr="12/07/"+String.valueOf(getCurrentYear());
		showDocDate=convertStrToDate(showDocDateStr);
		showSection=false;
		if (currentDate.after(showDocDate) ) {
			showSection=true;
		}
		targetItem=section+subSection+" - Stay in current plan";
		targetElement=ind_enrolPlnSec_choYurPlnSec_stayInCurrPln_text;
		if (showSection) {
			//---------------------------
			note.addAll(validateHaveItem(targetItem, targetElement));

			targetItem=section+subSection+" - Stay in current plan - Plan Name";
			targetElement=ind_enrolPlnSec_choYurPlnSec_stayInCurrPln_planName;
			note.addAll(validateHaveItem(targetItem, targetElement));

		} else {
			Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' before date '"+showDocDateStr+"' | currentDate='"+convertDateToStrFormat_MMDDYYYY(currentDate)+"'", !noWaitValidate(targetElement));
			note.add("\tPASSED - validation for NOT HAVING "+targetItem);
		}	
		return note;
	}




}