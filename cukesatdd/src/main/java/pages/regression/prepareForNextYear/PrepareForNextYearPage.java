package pages.regression.prepareForNextYear;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;

public class PrepareForNextYearPage  extends PrepareForNextYearBase {

	public PrepareForNextYearPage(WebDriver driver) {
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

	public PrepareForNextYearPage fromBenefitsPgNavigateToPrepareForNextYearPage(String planType, String memberType, boolean expComboTab) {
		System.out.println("TEST - attempt to click the PrepareForNextYear tab to go to the PrepareForNextYear page...");
		if (noWaitValidate(prepareForNextYearTab)) {
			prepareForNextYearTab.click();
		}
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, prepareForNextYearPgHeader, 10);
		checkModelPopup(driver,1);
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

	public List<String>  validateTimeLineBoxContent(boolean expNoBlue_t1, boolean expNoBlue_t2, boolean expNoBlue_t3, boolean expNoBlue_t4, boolean expNoBlue_t5) {
		List<String> note=new ArrayList<String>();
		String targetItem="Time line section";
		WebElement targetElement=tl_section;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line box header";
		targetElement=tl_sectionHeader;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		//note: milestone1 - Sept 15 ----------------------------------
		String dateStr="September 15";
		targetItem="Time line '"+dateStr+"' - Line";
		targetElement=tl_milestone1Line;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		if (expNoBlue_t1) {
			targetItem=targetItem+" - no blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", !targetElement.getAttribute("class").contains("blue"));
		} else {
			targetItem=targetItem+" - blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", targetElement.getAttribute("class").contains("blue"));
		}
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Circle";
		if (expNoBlue_t1) {
			targetItem=targetItem+" - no blue";
			targetElement=tl_milestone1Dot_noBlue;
		} else {
			targetItem=targetItem+" - blue";
			targetElement=tl_milestone1Dot_blue;
		}
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Date";
		targetElement=tl_milestone1Date;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);


		targetItem="Time line '"+dateStr+"' - Text";
		targetElement=tl_milestone1Text;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		String targetActText=targetElement.getText();
		String targetExpText="Your Annual Notice of Changes and plan documents for next year will start to be available.";
		Assert.assertTrue("PROBLEM - text content for element '"+targetItem+"' is not as expected.  "
				+ "Expected='"+targetExpText+"' | Actual='"+targetActText+"'", targetActText.contains(targetExpText));
		note.add("\t  PASSED - validation for "+targetItem);

		//note: milestone2 - Oct 1 ----------------------------------
		dateStr="October 1";
		targetItem="Time line '"+dateStr+"' - Line";
		targetElement=tl_milestone2Line;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		if (expNoBlue_t2) {
			targetItem=targetItem+" - no blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", !targetElement.getAttribute("class").contains("blue"));
		} else {
			targetItem=targetItem+" - blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", targetElement.getAttribute("class").contains("blue"));
		}
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Circle";
		if (expNoBlue_t2) {
			targetItem=targetItem+" - no blue";
			targetElement=tl_milestone2Dot_noBlue;
		} else {
			targetItem=targetItem+" - blue";
			targetElement=tl_milestone2Dot_blue;
		}
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Date";
		targetElement=tl_milestone2Date;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Text";
		targetElement=tl_milestone2Text;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//targetActText=targetElement.getText();
		//targetExpText="You'll be able to compare next year's plan with your current plan to find out how your coverage may change.";
		//Assert.assertTrue("PROBLEM - text content for element '"+targetItem+"' is not as expected.  "
		//		+ "Expected='"+targetExpText+"' | Actual='"+targetActText+"'", targetActText.contains(targetExpText));
		note.add("\t  PASSED - validation for "+targetItem);


		//note: milestone3 - Oct 15 ----------------------------------
		dateStr="October 15";
		targetItem="Time line '"+dateStr+"' - Line";
		targetElement=tl_milestone3Line;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		if (expNoBlue_t3) {
			targetItem=targetItem+" - no blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", !targetElement.getAttribute("class").contains("blue"));
		} else {
			targetItem=targetItem+" - blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", targetElement.getAttribute("class").contains("blue"));
		}
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Circle";
		if (expNoBlue_t3) {
			targetItem=targetItem+" - no blue";
			targetElement=tl_milestone3Dot_noBlue;
		} else {
			targetItem=targetItem+" - blue";
			targetElement=tl_milestone3Dot_blue;
		}
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Date";
		targetElement=tl_milestone3Date;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Text";
		targetElement=tl_milestone3Text;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//targetActText=targetElement.getText();
		//targetExpText="If your needs have changed and you want a different plan for next year, you can switch to a new plan.";
		//Assert.assertTrue("PROBLEM - text content for element '"+targetItem+"' is not as expected.  "
		//		+ "Expected='"+targetExpText+"' | Actual='"+targetActText+"'", targetActText.contains(targetExpText));
		note.add("\t  PASSED - validation for "+targetItem);


		//note: milestone4 - Dec 7 ----------------------------------
		dateStr="December 7";
		targetItem="Time line '"+dateStr+"' - Line";
		targetElement=tl_milestone4Line;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		if (expNoBlue_t4) {
			targetItem=targetItem+" - no blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", !targetElement.getAttribute("class").contains("blue"));
		} else {
			targetItem=targetItem+" - blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", targetElement.getAttribute("class").contains("blue"));
		}
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Circle";
		if (expNoBlue_t4) {
			targetItem=targetItem+" - no blue";
			targetElement=tl_milestone4Dot_noBlue;
		} else {
			targetItem=targetItem+" - blue";
			targetElement=tl_milestone4Dot_blue;
		}
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Date";
		targetElement=tl_milestone4Date;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Text";
		targetElement=tl_milestone4Text;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//targetActText=targetElement.getText();
		//targetExpText="This is the last day you can join a new plan for next year.";
		//Assert.assertTrue("PROBLEM - text content for element '"+targetItem+"' is not as expected.  "
		//		+ "Expected='"+targetExpText+"' | Actual='"+targetActText+"'", targetActText.contains(targetExpText));
		note.add("\t  PASSED - validation for "+targetItem);


		//note: milestone5 - Jan 1 ----------------------------------
		dateStr="January 1";
		targetItem="Time line '"+dateStr+"' - Line";
		targetElement=tl_milestone5Line;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		if (expNoBlue_t5) {
			targetItem=targetItem+" - no blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", !targetElement.getAttribute("class").contains("blue"));
		} else {
			targetItem=targetItem+" - blue";
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", targetElement.getAttribute("class").contains("blue"));
		}
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Circle";
		if (expNoBlue_t5) {
			targetItem=targetItem+" - no blue";
			targetElement=tl_milestone5Dot_noBlue;
		} else {
			targetItem=targetItem+" - blue";
			targetElement=tl_milestone5Dot_blue;
		}
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Date";
		targetElement=tl_milestone5Date;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Time line '"+dateStr+"' - Text";
		targetElement=tl_milestone5Text;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		//targetActText=targetElement.getText();
		//targetExpText="Your 2021 plan coverage starts today.";
		//Assert.assertTrue("PROBLEM - text content for element '"+targetItem+"' is not as expected.  "
		//		+ "Expected='"+targetExpText+"' | Actual='"+targetActText+"'", targetActText.contains(targetExpText));
		note.add("\t  PASSED - validation for "+targetItem);
		return note;
	}

	public List<String> validateFindUpdatesSectionContent(String memberType, Date currentDate, boolean showSectionDoc_f1, boolean showSectionDoc_f2, boolean showSectionDoc_f3, boolean showSectionDoc_f4, HashMap<String, Boolean> docDisplayMap) {
		List<String> note=new ArrayList<String>();
		if (memberType.contains("GRP")) {
			note.add("\t  SKIP - Find Updates section content validation for now, work in progress");
			return note;
		}
		
		String targetItem="Find updates to your plan benefits section";
		WebElement targetElement=findUpdatesSection;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Find updates to your plan benefits section header";
		targetElement=findUpdatesSection_header;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem="Find updates for next year's plan section text";
		targetElement=findUpdatesSection_text;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		//---------------------------------------------
		if (memberType.contains("IND")) {
			note.add("\t  =============================================");
			String section="Review plan changes";
			targetItem=section+" - section";
			targetElement=ind_reviewPlanChangesSection;
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
			note.add("\t  PASSED - validation for "+targetItem);

			targetItem=section+" - Circle";
			targetElement=ind_reviewPlanChanges_circle;
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
			note.add("\t  PASSED - validation for "+targetItem);

			targetItem=section+" - header";
			targetElement=ind_reviewPlanChanges_header;
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
			note.add("\t  PASSED - validation for "+targetItem);

			targetItem=section+" - text";
			targetElement=ind_reviewPlanChanges_text;
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
			note.add("\t  PASSED - validation for "+targetItem);

			section=section+" - document ";
			targetItem=section+" section";
			targetElement=ind_reviewPlanChanges_docSection;
			if (showSectionDoc_f1) {
				Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
				note.add("\t  PASSED - validation for "+targetItem);

				targetItem=section+" - language dropdown and options";
				targetElement=ind_reviewPlanChanges_docSection_langDropdown;
				Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
				Select select = new Select(ind_reviewPlanChanges_docSection_langDropdown);           
				String actualSelectedLang = select.getFirstSelectedOption().getText();
				String expectedSelectedLang="ENGLISH";
				Assert.assertTrue("PROBLEM - default selected language option is not as expected. "
						+ "Expected='"+expectedSelectedLang+"' | Actual='"+actualSelectedLang+"'", 
						actualSelectedLang.equals(actualSelectedLang));
				Assert.assertTrue("PROBLEM - unable to locate language option for English", noWaitValidate(ind_lang_english));
				Assert.assertTrue("PROBLEM - unable to locate language option for Spanish", noWaitValidate(ind_lang_spanish));
				Assert.assertTrue("PROBLEM - unable to locate language option for Chinese", noWaitValidate(ind_lang_chinese));
				note.add("\t  PASSED - validation for "+targetItem);

				
				targetItem=section+" - checkmark";
				targetElement=ind_reviewPlanChanges_docSection_checkMark;
				Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
				note.add("\t  PASSED - validation for "+targetItem);

				int year = Calendar.getInstance().get(Calendar.YEAR);
				String byDateStr="09/30/"+String.valueOf(year);
				Date byDate=convertStrToDate(byDateStr);
				
				//if it's supposed to have the doc
				//note: ANOC only show after 9/30
				/* tbd
				if (!docDisplayMap.get("Annual Notice of Changes English")) {
					targetItem=section+" - Compare Your Current Plan To Next Year's Plan link";
					targetElement=ind_reviewPlanChanges_docSection_preCompareYourCurrentPlanLnk;
					Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
					note.add("\t  PASSED - validation for "+targetItem);

					targetItem=section+" - the 'or' text";
					targetElement=ind_reviewPlanChanges_docSection_preOrTextForAnoc;
					Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"'", !noWaitValidate(targetElement));
					note.add("\t  PASSED - validation for "+targetItem);
					
					targetItem=section+" - gray 'Open Annual Notice of Changes (PDF)'";
					targetElement=ind_reviewPlanChanges_docSection_preGrayAnoc;
					Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"'", !noWaitValidate(targetElement));
					note.add("\t  PASSED - validation for "+targetItem);
					
					targetItem=section+" - blue 'Available By 9/30'";
					targetElement=ind_reviewPlanChanges_docSection_preBlueBySept30;
					Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"'", !noWaitValidate(targetElement));
					note.add("\t  PASSED - validation for "+targetItem);
				} else { */
					if (currentDate.before(byDate)) {
						//note: current system date is before 9/30
						note.add("\t  =============================================");
						targetItem=section+" - Compare Your Current Plan To Next Year's Plan link";
						targetElement=ind_reviewPlanChanges_docSection_preCompareYourCurrentPlanLnk;
						Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
						note.add("\t  PASSED - validation for "+targetItem);

						//TODO - click the Compare Your Current Plan link

						targetItem=section+" - the 'or' text";
						targetElement=ind_reviewPlanChanges_docSection_preOrTextForAnoc;
						Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
						note.add("\t  PASSED - validation for "+targetItem);
						
						targetItem=section+" - gray 'Open Annual Notice of Changes (PDF)'";
						targetElement=ind_reviewPlanChanges_docSection_preGrayAnoc_us;
						Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
						note.add("\t  PASSED - validation for "+targetItem);

						
						targetItem=section+" - blue 'Available By 9/30'";
						targetElement=ind_reviewPlanChanges_docSection_preBlueBySept30;
						Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
						note.add("\t  PASSED - validation for "+targetItem);
					} else {
						//note: current system date is after 9/30
						note.add("\t  =============================================");
						targetItem=section+" - no blue 'Available By 9/30'";
						targetElement=ind_reviewPlanChanges_docSection_preBlueBySept30;
						Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"'", !noWaitValidate(targetElement));
						note.add("\t  PASSED - validation for "+targetItem);

						targetItem=section+" - Compare Your Current Plan To Next Year's Plan link";
						targetElement=ind_reviewPlanChanges_docSection_activeCompareYourCurrentPlanLnk;
						Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
						note.add("\t  PASSED - validation for "+targetItem);

						//TODO - click the Compare Your Current Plan link
						
						note.add("\t  =============================================");
						if (docDisplayMap.get("Annual Notice of Changes English")) {
							targetItem=section+" - the 'or' text";
							targetElement=ind_reviewPlanChanges_docSection_activeOrTextForAnoc;
							CommonUtility.waitForPageLoad(driver, targetElement, 10);
							Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
							note.add("\t  PASSED - validation for "+targetItem);

							targetItem=section+" - English 'Annual Notice of Changes (PDF)'";
							targetElement=ind_reviewPlanChanges_docSection_activeAnoc_us;
							Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));

							List<String> subSectionNote=validatePdf(targetItem, targetElement);
							note.addAll(subSectionNote);
							note.add("\t  PASSED - validation for "+targetItem);

							targetItem=section+" - Arrow after 'Annual Notice of Changes (PDF)'";
							targetElement=ind_reviewPlanChanges_docSection_arrowAfterActiveAnoc;
							Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
							note.add("\t  PASSED - validation for "+targetItem);
						} else {
							//TODO - should have text Coming soon, need to get the right xpath
							targetItem=section+" Coming soon text";
							targetElement=comingSoonText;
							Assert.assertTrue("PROBLEM - user input doesn't expect English doc, unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
							note.add("\t  PASSED - validation for "+targetItem);
						}

						//note: if there is spanish doc
						note.add("\t  =============================================");
						targetItem=section+" - Spanish 'Annual Notice of Changes (PDF)'";
						if (docDisplayMap.get("Annual Notice of Changes Spanish")) {
							select = new Select(ind_reviewPlanChanges_docSection_langDropdown);           
							select.selectByValue("es");

							targetElement=ind_reviewPlanChanges_docSection_activeAnoc_es;
							CommonUtility.waitForPageLoad(driver, targetElement, 10);
							Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));

							List<String> subSectionNote=validatePdf(targetItem, targetElement);
							note.addAll(subSectionNote);
							note.add("\t  PASSED - validation for "+targetItem);

							targetItem=section+" - Arrow after 'Annual Notice of Changes (PDF)'";
							targetElement=ind_reviewPlanChanges_docSection_arrowAfterActiveAnoc;
							Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
							note.add("\t  PASSED - validation for "+targetItem);

						} else {
							//keep - activate later when code is ready
							//ind_reviewPlanChanges_docSection_langDropdown.click();
							//targetItem="Spanish language dropdown option'";
							//targetElement=ind_lang_spanish;
							//Assert.assertTrue("PROBLEM - user input doesn't expect Spanish doc, should not be able to locate element for '"+targetItem+"'", !noWaitValidate(targetElement));
							//note.add("\t  PASSED - validation for NO "+targetItem);

							//note: for now it will display, it will change later
							select = new Select(ind_reviewPlanChanges_docSection_langDropdown);           
							select.selectByValue("es");

							targetElement=ind_reviewPlanChanges_docSection_preGrayAnoc_es;
							CommonUtility.waitForPageLoad(driver, targetElement, 10);
							Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));

							note.add("\t  PASSED - validation for "+targetItem);
						}
						
						//note: if there is chinese doc
						note.add("\t  =============================================");
						targetItem=section+" - Chinese 'Annual Notice of Changes (PDF)'";
						if (docDisplayMap.get("Annual Notice of Changes Chinese")) {
							select = new Select(ind_reviewPlanChanges_docSection_langDropdown);           
							select.selectByValue("zh");

							targetElement=ind_reviewPlanChanges_docSection_activeAnoc_zh;
							CommonUtility.waitForPageLoad(driver, targetElement, 10);
							Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));

							List<String> subSectionNote=validatePdf(targetItem, targetElement);
							note.addAll(subSectionNote);

							note.add("\t  PASSED - validation for "+targetItem);
						} else {
							//keep - activate later when code is ready
							//ind_reviewPlanChanges_docSection_langDropdown.click();
							//targetItem="Chinese language dropdown option'";
							//targetElement=ind_lang_chinese;
							//Assert.assertTrue("PROBLEM - user input doesn't expect Chinese doc, should not be able to locate element for '"+targetItem+"'", !noWaitValidate(targetElement));
							//note.add("\t  PASSED - validation for NO "+targetItem);
							select = new Select(ind_reviewPlanChanges_docSection_langDropdown);           
							select.selectByValue("zh");

							targetElement=ind_reviewPlanChanges_docSection_preGrayAnoc_zh;
							CommonUtility.waitForPageLoad(driver, targetElement, 10);
							Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));

							note.add("\t  PASSED - validation for "+targetItem);
						}
						
						
					}
				//tbd }
				
			} else {
				Assert.assertTrue("PROBLEM - should not able to locate element for '"+targetItem+"'", !noWaitValidate(targetElement));
				note.add("\t  PASSED - validation for "+targetItem);
			}				

		} else if (memberType.contains("GRP")) {
			String section="Review plan changes";
			targetItem=section+" - section";
			targetElement=grp_reviewPlanChangesSection;
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
			note.add("\t  PASSED - validation for "+targetItem);

			targetItem=section+" - Circle";
			targetElement=grp_reviewPlanChanges_circle;
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
			note.add("\t  PASSED - validation for "+targetItem);

			targetItem=section+" - header";
			targetElement=grp_reviewPlanChanges_header;
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
			note.add("\t  PASSED - validation for "+targetItem);

			targetItem=section+" - text";
			targetElement=grp_reviewPlanChanges_text;
			Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
			note.add("\t  PASSED - validation for "+targetItem);

			section=section+" - document ";
			targetItem=section+" section";
			targetElement=grp_reviewPlanChanges_docSection;
			if (showSectionDoc_f1) {
				Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
				note.add("\t  PASSED - validation for "+targetItem);

				targetItem=section+" - language dropdown";
				targetElement=grp_reviewPlanChanges_docSection_langDropdown;
				Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
				note.add("\t  PASSED - validation for "+targetItem);

				targetItem=section+" - checkmark";
				targetElement=grp_reviewPlanChanges_docSection_checkMark;
				Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
				note.add("\t  PASSED - validation for "+targetItem);

				targetItem=section+" - Compare Your Current Plan To Next Year's Plan link";
				targetElement=grp_reviewPlanChanges_docSection_langDropdown;
				Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
				note.add("\t  PASSED - validation for "+targetItem);
				//TODO

			} else {
				Assert.assertTrue("PROBLEM - should not able to locate element for '"+targetItem+"'", !noWaitValidate(targetElement));
				note.add("\t  PASSED - validation for "+targetItem);
			}
		} else {
			Assert.assertTrue("PROBLEM - ATDD code only coded to handle individual 'IND' or group 'GRP' case. Your memberType have neither.  current memebrTYpe='"+memberType+"' ", false);
		}



		/* TODO
		//---------------------------------------------
		section="Review plan materials";
		targetItem=section+" - section";
		targetElement=reviewPlanMaterials;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem=section+" - Circle";
		targetElement=reviewPlanMaterials_circle;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem=section+" - header";
		targetElement=reviewPlanMaterials_header;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem=section+" - text";
		targetElement=reviewPlanMaterials_text;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		//---------------------------------------------
		section="Compare plans online";
		targetItem=section+" - section";
		targetElement=comparePlanOnline;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem=section+" - Circle";
		targetElement=comparePlanOnline_circle;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem=section+" - header";
		targetElement=comparePlanOnline_header;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem=section+" - text";
		targetElement=comparePlanOnline_text;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		//---------------------------------------------
		section="Enroll in the plan that works for you";
		targetItem=section+" - section";
		targetElement=enrollInPlan;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem=section+" - Circle";
		targetElement=enrollInPlan_circle;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem=section+" - header";
		targetElement=enrollInPlan_header;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);

		targetItem=section+" - text";
		targetElement=enrollInPlan_text;
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\t  PASSED - validation for "+targetItem);
		 */
		return note;
	}
	
	public void validateReturnToPrevPgLnk() {
		Assert.assertTrue("PROBLEM - unable to locate the 'RETURN TO PREVIOUS PAGE' link on 'Prepare For Next Year' page'", noWaitValidate(returnToPrevPgLnk));
		returnToPrevPgLnk.click();
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, benefitsPgHeaderText, 10);
		Assert.assertTrue("PROBLEM - unable to navigate back to benefits page by clicking 'RETURN TO PREVIOUS PAGE' link",noWaitValidate(benefitsPgHeaderText));
		if (noWaitValidate(prepareForNextYearTab)) {
			prepareForNextYearTab.click();
		}
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, prepareForNextYearPgHeader, 10);
		checkModelPopup(driver,1);
		Assert.assertTrue("PROBLEM - unable to navigate again to 'Prepare For Next Year' page via 'Prepare For Next Year' tab on Benefit sub menu", noWaitValidate(prepareForNextYearPgHeader));
	}

	public List<String> validateBeforeM1Content(String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
		List<String> sectionNote1=new ArrayList<String>();
		boolean expNoBlue_t1=true;
		boolean expNoBlue_t2=true;
		boolean expNoBlue_t3=true;
		boolean expNoBlue_t4=true;
		boolean expNoBlue_t5=true;
		List<String> s1=validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
		sectionNote1.addAll(s1);

		if (MRScenario.environment.contains("team-a")) {
			boolean f1=false;
			boolean f2=false;
			boolean f3=false;
			boolean f4=false;
			List<String> s2=validateFindUpdatesSectionContent(memberType, currentDate, f1, f2, f3, f4, docDisplayMap);
			sectionNote1.addAll(s2);
		}
		return sectionNote1;
	}

	public List<String>  validateAfterOrEqualM1BeforeM2Content(String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
		List<String> sectionNote1=new ArrayList<String>();
		boolean expNoBlue_t1=false;
		boolean expNoBlue_t2=true;
		boolean expNoBlue_t3=true;
		boolean expNoBlue_t4=true;
		boolean expNoBlue_t5=true;
		List<String> s1=validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
		sectionNote1.addAll(s1);

		if (MRScenario.environment.contains("team-a")) {
		boolean f1=true;
		boolean f2=false;
		boolean f3=false;
		boolean f4=false;
		List<String> s2=validateFindUpdatesSectionContent(memberType, currentDate, f1, f2, f3, f4, docDisplayMap);
		sectionNote1.addAll(s2);
		}
		return sectionNote1;
	}
	public List<String>  validateAfterOrEqalM2BeforeM3Content(String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
		List<String> sectionNote1=new ArrayList<String>();
		boolean expNoBlue_t1=false;
		boolean expNoBlue_t2=false;
		boolean expNoBlue_t3=true;
		boolean expNoBlue_t4=true;
		boolean expNoBlue_t5=true;
		List<String> s1=validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
		sectionNote1.addAll(s1);

		if (MRScenario.environment.contains("team-a")) {
		boolean f1=true;
		boolean f2=false;
		boolean f3=false;
		boolean f4=false;
		List<String> s2=validateFindUpdatesSectionContent(memberType, currentDate, f1, f2, f3, f4, docDisplayMap);
		sectionNote1.addAll(s2);
		}
		return sectionNote1;
	}
	public List<String>  validateAfterOrEqalM3BeforeM4Content(String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
		List<String> sectionNote1=new ArrayList<String>();
		boolean expNoBlue_t1=false;
		boolean expNoBlue_t2=false;
		boolean expNoBlue_t3=false;
		boolean expNoBlue_t4=true;
		boolean expNoBlue_t5=true;
		List<String> s1=validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
		sectionNote1.addAll(s1);

		if (MRScenario.environment.contains("team-a")) {
		boolean f1=true;
		boolean f2=false;
		boolean f3=false;
		boolean f4=false;
		List<String> s2=validateFindUpdatesSectionContent(memberType, currentDate, f1, f2, f3, f4, docDisplayMap);
		sectionNote1.addAll(s2);
		}
		return sectionNote1;
	}
	public List<String>  validateAfterOrEqalM4BeforeM5Content(String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
		List<String> sectionNote1=new ArrayList<String>();
		boolean expNoBlue_t1=false;
		boolean expNoBlue_t2=false;
		boolean expNoBlue_t3=false;
		boolean expNoBlue_t4=false;
		boolean expNoBlue_t5=true;
		List<String> s1=validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
		sectionNote1.addAll(s1);

		if (MRScenario.environment.contains("team-a")) {
		boolean f1=true;
		boolean f2=false;
		boolean f3=false;
		boolean f4=false;
		List<String> s2=validateFindUpdatesSectionContent(memberType, currentDate, f1, f2, f3, f4, docDisplayMap);
		sectionNote1.addAll(s2);
		}
		return sectionNote1;
	}
	public List<String>  validateAfterOrEqalM5Content(String memberType, Date currentDate, HashMap<String, Boolean> docDisplayMap) {
		List<String> sectionNote1=new ArrayList<String>();
		boolean expNoBlue_t1=false;
		boolean expNoBlue_t2=false;
		boolean expNoBlue_t3=false;
		boolean expNoBlue_t4=false;
		boolean expNoBlue_t5=false;
		List<String> s1=validateTimeLineBoxContent(expNoBlue_t1, expNoBlue_t2, expNoBlue_t3, expNoBlue_t4, expNoBlue_t5);
		sectionNote1.addAll(s1);

		if (MRScenario.environment.contains("team-a")) {
		boolean f1=true;
		boolean f2=false;
		boolean f3=false;
		boolean f4=false;
		List<String> s2=validateFindUpdatesSectionContent(memberType, currentDate, f1, f2, f3, f4, docDisplayMap);
		sectionNote1.addAll(s2);
		}
		return sectionNote1;
	}

	public void validateBookmarkError() {
		String tmpUrl=driver.getCurrentUrl();
		String tmp[]=tmpUrl.split("/benefits");
		String bookmark=tmp[0]+"/planfornextyear/overview.html";
		driver.get(bookmark);
		CommonUtility.checkPageIsReady(driver);
		checkModelPopup(driver,1);
		Assert.assertTrue("PROBLEM - unable to locate error message when attempting to access bookmark when tab hasn't met conditions to be displayed", noWaitValidate(bookmarkErrMsg));
		String actMsg=bookmarkErrMsg.getText();;
		String expMsg="Your requested cannot be processed .Please try later";
		Assert.assertTrue("PROBLEM - error message is not as expected.  Expect='"+expMsg+"' | Actual='"+actMsg+"'", actMsg.contains(expMsg));
		Assert.assertTrue("PROBLEM - unable to locate the link that would allow user to go back to home page", noWaitValidate(bookmarkErrPgGoBackHome));

	}
	
	public List<String> validatePdf(String targetDocName, WebElement pdfLink) {
		List<String> note=new ArrayList<String>();
		note.add("\t  =============================================");
		note.add("\t  Validation for PDF ='"+targetDocName+"'");
		String winHandleBefore = driver.getWindowHandle();
		
		ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		int beforeClicked_numTabs=beforeClicked_tabs.size();	
		CommonUtility.waitForPageLoad(driver, pdfLink, 5);
		sleepByMillSec(300);
		scrollElementToCenterScreen(pdfLink);
		pdfLink.click();
		CommonUtility.checkPageIsReady(driver);

		ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		int afterClicked_numTabs=afterClicked_tabs.size();
		Assert.assertTrue("PROBLEM - Did not get expected new tab after clicking '"+targetDocName+"' link", (afterClicked_numTabs-beforeClicked_numTabs)==1);
		driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
		CommonUtility.checkPageIsReady(driver);
		sleepBySec(5);

		String actUrl=driver.getCurrentUrl();
		String expUrl=".pdf";
		Assert.assertTrue("PROBLEM - not getting expected destination URL.  Expect to contain '"+expUrl+"' | Actual URL='"+actUrl+"'", actUrl.contains(expUrl));
		
		if (!MRScenario.environment.contains("team-a")) {
			try {
				URL TestURL = new URL(driver.getCurrentUrl());
				sleepBySec(5); //note: let the page settle before validating content
				BufferedInputStream TestFile = new BufferedInputStream(TestURL.openStream());
				PDDocument document = PDDocument.load(TestFile);
				String PDFText = new PDFTextStripper().getText(document);
				System.out.println("PDF text : "+PDFText);
				if(PDFText!=null && !PDFText.equals("")){
					note.add("\t  PASSED - validated pdf content is not null");
				} else {
					note.add("\t  * FAILED - unable to validate pdf content - content either null or empty");
					Assert.assertTrue("PROBLEM - unable to validate pdf content - content either null or empty - doc name="+targetDocName, false);
				}
			} catch (MalformedURLException e) {
				note.add("\t  * FAILED - unable to validate pdf content - MalformedURLException");
				e.printStackTrace();
				Assert.assertTrue("PROBLEM - unable to validate pdf content - MalformedURLException - doc name="+targetDocName, false);
			} catch (IOException e) {
				note.add("\t  * FAILED - unable to validate pdf content - IOException");
				e.printStackTrace();
				//keep Assert.assertTrue("PROBLEM - unable to validate pdf content - IOException - doc name="+targetDocName, false);
			}
		} else {
			note.add("\t  On lower env, skip validating PDF content");
		}

		driver.close();
		driver.switchTo().window(winHandleBefore);


		return note;
		
	}
	
}