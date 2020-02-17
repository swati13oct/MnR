package pages.regression.planDocumentsAndResources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PlanDocumentsAndResourcesBase extends PlanDocumentsAndResourcesBaseHelper  {

	public PlanDocumentsAndResourcesBase(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void openAndValidate() throws InterruptedException {
		Assert.assertTrue("PROBLEM - unable to locate page header text element", planDocValidate(pageHeader));

	}

	/**
	 * Validate language dropdown
	 * @param langDropDown
	 * @param exp_elementAttributeValue
	 * @return
	 */
	public boolean validateLangDropDownAvaOptn(WebElement langDropDown, String exp_elementAttributeValue) {
		boolean found=false;
		Select langDropdown = new Select(langDropDown);
		List<WebElement> allOptions = langDropdown.getOptions();
		System.out.println("allOptions.size()="+allOptions.size());
		for(WebElement e: allOptions) {
			if (e.getAttribute("value").equals(exp_elementAttributeValue) && (!e.getAttribute("style").contains("display: none"))) {
				found=true;
				break;
			}
		}
		if (!found)
			System.out.println("Did not find the attribute value '"+exp_elementAttributeValue+"' in the list of dropdown options");
		return found;
	}

	/**
	 * Validate link destination upon clicking
	 * @param testInputInfoMap
	 * @param checkDestUrl
	 * @param switchTab
	 * @param targetDocName
	 * @param targetLinkElement
	 * @param expUrl
	 */
	public List<String> validateLinkDest(HashMap<String, String> testInputInfoMap, WebElement targetLinkElement) {
		List<String> section_note=new ArrayList<String>();

		String planType=testInputInfoMap.get("planType");
		String memberType=testInputInfoMap.get("memberType");
		String section=testInputInfoMap.get("section");

		boolean checkDestUrl=Boolean.valueOf(testInputInfoMap.get("checkDestUrl"));
		boolean switchTab=Boolean.valueOf(testInputInfoMap.get("switchTab"));
		String targetDocName=testInputInfoMap.get("docName");
		//note: this is a bypass for team-atest, lower env has issue w/ this but would be fine on stage according to developer
		if(MRScenario.environment.contains("team-a") 
				&& (!section.equals("Forms And Resources"))) {
			section_note.add("    SKIP - link destination validation for '"+targetDocName+"' on team env, lower env won't work right for this link");
			return section_note;
		}

		System.out.println("Proceed to validate clicking link element for doc='"+targetDocName+"'  | checkDestUrl="+checkDestUrl);
		String expUrl=testInputInfoMap.get("expectedUrl");
		String redirectUrl=testInputInfoMap.get("redirectUrl");
		if (!redirectUrl.equals("none")) {
			System.out.println("expect redirect for this link. original expUrl="+expUrl);
			expUrl=redirectUrl;
			System.out.println("after redirect expUrl="+expUrl);
		}
		
		//note: if skipLnkDestCheck=true, then overwrite whatever that's in checkDestUrl
		boolean skipLnkDestCheck=Boolean.valueOf(testInputInfoMap.get("skipLnkDestCheck"));
		if (skipLnkDestCheck) {
			System.out.println("NOTE - skipLnkDestCheck=true, will globally disable the click link and validate destination url check");
			section_note.add("    SKIP - element link in href attribute vs actual link URL after clicked validation");
			return section_note;
		}

		String origUrlBeforeClick=driver.getCurrentUrl();
		if (switchTab) { //note: for the case if link will bring up new tab
			System.out.println("Proceed to click link and validate link destination, this link is expected to open new tab");
			String winHandleBefore = driver.getWindowHandle();
			CommonUtility.waitForPageLoad(driver, targetLinkElement, 5);
			ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			int beforeClicked_numTabs=beforeClicked_tabs.size();	
			CommonUtility.waitForPageLoad(driver, targetLinkElement, 5);
			sleepByMillSec(300);
			scrollElementToCenterScreen(targetLinkElement);
			targetLinkElement.click();
			CommonUtility.checkPageIsReady(driver);
			System.out.println("Clicked the doc link...");
			sleepBySec(3);
			if (!redirectUrl.equals("none")) {
				System.out.println("if redirect then need to wait a little for the page to settle before checking destination link");
				sleepBySec(3);
				CommonUtility.checkPageIsReady(driver);
			}
			//note: for these doc, popup will show when clicking this link, validate the proceed and cancel button
			if (targetDocName.toUpperCase().contains("HEALTH PRODUCTS BENEFIT") 
					|| targetDocName.contains("Appointment of Representative Form")
					|| targetDocName.toUpperCase().contains("OVER THE COUNTER ESSENTIALS")
					|| targetDocName.contains("Health & Wellness Products Catalog")) {
				CommonUtility.waitForPageLoad(driver, siteLeavingPopup, 5);
				System.out.println("Proceed to validate the leaving site popup after clicking "+targetDocName+" link");
				Assert.assertTrue("PROBLEM - unable to locate the site-leaving popup after clicking the '"+targetDocName+"' link", planDocValidate(siteLeavingPopup));
				Assert.assertTrue("PROBLEM - unable to locate the site-leaving popup PROCEED button after clicking the '"+targetDocName+"' link", planDocValidate(siteLeavingPopup_proceedBtn));
				Assert.assertTrue("PROBLEM - unable to locate the site-leaving popup CANCEL button after clicking the '"+targetDocName+"' link", planDocValidate(siteLeavingPopup_cancelBtn));

				System.out.println("Proceed to validate the Cancel button on leaving site popup after clicking "+targetDocName+" link");
				siteLeavingPopup_cancelBtn.click();
				CommonUtility.checkPageIsReady(driver);
				Assert.assertTrue("PROBLEM - should not locate the site-leaving popup after clicking CANCEL button", !planDocValidate(siteLeavingPopup));

				CommonUtility.waitForPageLoad(driver, targetLinkElement, 5);
				targetLinkElement.click();
				CommonUtility.waitForPageLoad(driver, siteLeavingPopup, 5);
				System.out.println("Proceed to validate the Proceed button on leaving site popup after clicking "+targetDocName+" link");
				siteLeavingPopup_proceedBtn.click();
				CommonUtility.checkPageIsReady(driver);
				Assert.assertTrue("PROBLEM - should not locate the site-leaving popup after clicking PROCEED button", !planDocValidate(siteLeavingPopup));
			}

			ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			int afterClicked_numTabs=afterClicked_tabs.size();
			Assert.assertTrue("PROBLEM - Did not get expected new tab after clicking '"+targetDocName+"' link", (afterClicked_numTabs-beforeClicked_numTabs)==1);
			driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
			CommonUtility.checkPageIsReady(driver);
			sleepBySec(5);

			if (checkDestUrl) {
				String actUrl=driver.getCurrentUrl();
				Assert.assertTrue("PROBLEM - '"+targetDocName+"' link destination URL is not as expected. "
						+ "Expect to contain '"+expUrl+"' | Actual URL='"+actUrl+"'", actUrl.contains(expUrl));
				section_note.add("    PASSED - element link in href attribute vs actual link URL after clicked validation");
				if (actUrl.contains(".htm")) {
					//tbd Assert.assertTrue("PROBLEM - unable to locate page header text on the landing page", planDocValidate(generalPgHeader));
					if (planDocValidate(generalPgHeader))
						section_note.add("    PASSED - validated there is header text on landing page after clicked");
					else
						section_note.add("    * FAILED - unable to locate page header text on the landing page for doc '"+testInputInfoMap.get("docName")+"'");
				} 
			} else {
				section_note.add("    SKIP - element link in href attribute vs actual link URL after clicked validation");
			}
			driver.close();
			driver.switchTo().window(winHandleBefore);
			section_note.add("    PASSED - element link clicking validation");
		} else { //note: for the case if link will open on original tab
			System.out.println("Proceed to click link and validate link destination, this link is expected to open on original tab");
			if (checkDestUrl) {
				ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				int beforeClicked_numTabs=beforeClicked_tabs.size();		
				CommonUtility.waitForPageLoad(driver, targetLinkElement, 5);
				scrollElementToCenterScreen(targetLinkElement);
				targetLinkElement.click(); //note: if redirect then need to wait a little for the page to settle before checking destination link
				CommonUtility.checkPageIsReady(driver);
				
				sleepBySec(5);
				if (!redirectUrl.equals("none")) {
					System.out.println("if redirect then need to wait a little for the page to settle before checking destination link");
					CommonUtility.checkPageIsReady(driver);
				}
				ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				int afterClicked_numTabs=afterClicked_tabs.size();			
				Assert.assertTrue("PROBLEM - After clicking '"+targetDocName+"' link, no additional tab should be opened", afterClicked_numTabs==beforeClicked_numTabs);
				if (checkDestUrl) {
					if (testInputInfoMap.get("section").equals("Provider and Pharmacy Directories") || testInputInfoMap.get("section").equals("Provider Directory")) 
						CommonUtility.waitForPageLoad(driver, providerSearchPg_zipcodeInputField, 5);
					if (testInputInfoMap.get("docName").equals("ORDER PLAN MATERIALS"))
							CommonUtility.waitForPageLoad(driver, orderPlanPgHeader, 5);
					if (testInputInfoMap.get("docName").equals("SEARCH DOCUMENTS")) {
						CommonUtility.waitForPageLoad(driver, myDocumentsPgHeader, 5);
						sleepBySec(5);
						if (MRScenario.environment.contains("team-atest")) {
							System.out.println("Check if Alert popup present...if yes, handle it...");
							isAlertPresent();
						}
					}
					if (testInputInfoMap.get("docName").equals("SEARCH MEDICAL EOB HISTORY") || testInputInfoMap.get("docName").equals("SEARCH DRUG EOB HISTORY"))
						CommonUtility.waitForPageLoad(driver, eobPgHeader, 5);
					String actUrl=driver.getCurrentUrl();
					if (actUrl.contains("internal-error?errorUID"))
						section_note.add("    BYPASSED - element link in href attribute vs actual link URL after clicked validation - destination url got internal-error");
					else {
						Assert.assertTrue("PROBLEM - '"+targetDocName+"' link destination URL is not as expected. "
							+ "Expect to contain '"+expUrl+"' | Actual URL='"+actUrl+"'", actUrl.contains(expUrl));
						section_note.add("    PASSED - element link in href attribute vs actual link URL after clicked validation");
						if (actUrl.contains(".htm")) {
							//tbd Assert.assertTrue("PROBLEM - unable to locate page header text on the landing page for doc '"+testInputInfoMap.get("docName")+"'", planDocValidate(generalPgHeader));
							if (planDocValidate(generalPgHeader)) 
								section_note.add("    PASSED - validated there is header text on landing page after clicked");
							else
								section_note.add("    * FAILED - unable to locate page header text on the landing page for doc '"+testInputInfoMap.get("docName")+"'");
						}
					}
				} else {
					section_note.add("    SKIP - element link in href attribute vs actual link URL after clicked validation");
				}
				goBackToPriorPgViaBack(planType, memberType, origUrlBeforeClick);
				section_note.add("    PASSED - element link clicking validation");
			}
		}
		return section_note;
	}

	public void validatePageHeaderSection() {
		String section="Plan Documents & Resources";
		WebElement headerElement=pageHeader;

		Assert.assertTrue("PROBLEM - unable to locate page header text element", planDocValidate(headerElement));
		String actualHeaderText=headerElement.getText();
		String expectedHeaderText=section;
		Assert.assertTrue("PROBLEM - not getting expected header text.  Expected='"+expectedHeaderText+"' | Actual='"+actualHeaderText+"'", actualHeaderText.equals(expectedHeaderText));
	}
	
	public void validatePageBackToTopLink() {
		WebElement backToTopElement=backToTopLink;
		Assert.assertTrue("PROBLEM - unable to locate 'Back To Top' link on the page", planDocValidate(backToTopElement));
	}

	public String getApiResponse(String planType, String memberType, String inputUrl)  {

		String origUrlBeforeClick=driver.getCurrentUrl();
		String winHandleBefore = driver.getWindowHandle();
		System.out.println("Proceed to open a new blank tab to get API response");
		System.out.println("test URL= "+inputUrl);
		//open new tab
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('"+inputUrl+"','_blank');");
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		String apiResponseJsonStr=apiResponseJson.getText();
		System.out.println("apiResponseJsonStr="+apiResponseJsonStr);

		driver.close();
		driver.switchTo().window(winHandleBefore);
		
		//note: this particular user on lower env is getting stale element exception, refresh the page at this point to get it going
		if (MRScenario.environment.contains("team-a") && planType.equals("PDP") && memberType.contains("COMBO")) 
			refreshPage(planType, memberType, origUrlBeforeClick);
		return apiResponseJsonStr;
	}

	/** 
	 * Validate if the section has expected number of sub sections for year
	 * @param section
	 * @param expectedDocTypeDisplayMap
	 * @param yearsMap
	 * @param curYr_xpath
	 * @param nxtYr_xpath
	 */
	public void validateNumOfSubSections(String section, HashMap<String, Boolean> expectedDocTypeDisplayMap, HashMap<String, String> yearsMap, String curYr_xpath, String nxtYr_xpath) {
		//note: validate number of sections
		String currentYear=yearsMap.get("currentYear");
		String nextYear=yearsMap.get("nextYear");

		boolean doc_en_curYr=expectedDocTypeDisplayMap.get("doc_en_curYr");
		boolean doc_en_nxtYr=expectedDocTypeDisplayMap.get("doc_en_nxtYr");

		if (doc_en_curYr) {
			String expedYearText=currentYear;
			String testPath=curYr_xpath;

			Assert.assertTrue("PROBLEM - unable to locate year '"+expedYearText+"' sub-section in section '"+section+"'",planDocValidate(testPath));
			String actualYearText=driver.findElement(By.xpath(testPath)).getText();
			Assert.assertTrue("PROBLEM - year for sub-section is not as expected.  Expected='"+expedYearText+"' | Actual='"+actualYearText+"'", actualYearText.equals(expedYearText));
		} else {
			String expedYearText=currentYear;
			String testPath=curYr_xpath;
			Assert.assertTrue("PROBLEM - UI is showing current year '"+expedYearText+"' sub-section in section '"+section+"', input expect not to see it",!planDocValidate(testPath));
		}
		if (doc_en_nxtYr) {
			String expedYearText=nextYear;
			String testPath=nxtYr_xpath;

			Assert.assertTrue("PROBLEM - unable to locate year '"+expedYearText+"' sub-section in section '"+section+"'",planDocValidate(testPath));
			String actualYearText=driver.findElement(By.xpath(testPath)).getText();
			Assert.assertTrue("PROBLEM - year for sub-section is not as expected.  Expected='"+expedYearText+"' | Actual='"+actualYearText+"'", actualYearText.equals(expedYearText));
		} else {
			String expedYearText=nextYear;
			String testPath=nxtYr_xpath;
			Assert.assertTrue("PROBLEM - UI is showing next year '"+expedYearText+"' sub-section in section '"+section+"', input expect not to see it",!planDocValidate(testPath));
		}
	}

	/**
	 * helper - compare the doc list result from UI vs API
	 * @param section
	 * @param langValue
	 * @param act_docListFromUi
	 * @param exp_docListFromApi
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<String> compareUiApiDocList(HashMap<String, String> testInputInfoMap, List<HashMap<String, Document>> act_docListFromUi, List<HashMap<String, Document>> exp_docListFromApi, boolean anocFlag, boolean expDocDisplay, boolean checkDestUrl) {
		String planType=testInputInfoMap.get("planType");
		String memberType=testInputInfoMap.get("memberType");
		
		String section=testInputInfoMap.get("section");
		String targetLang=testInputInfoMap.get("targetLang");
		System.out.println("Proceed to compare '"+section+"' section '"+targetLang+"' language - UI vs API...");
		System.out.println("expDocDisplay="+expDocDisplay+" | anocFlag="+anocFlag+" | checkDestUrl="+checkDestUrl);
		
		List<String> noteList=new ArrayList<String> ();
		int expectedSize=exp_docListFromApi.size();
		int actualSize=act_docListFromUi.size();
		System.out.println("Compare number of doc: Expected="+expectedSize+" | Actual="+actualSize);
		if (!expDocDisplay) {
			boolean condition=false;
			if (section.equals("Annual Notice of Changes Documents")) {
				//note: if anoc flag is set to false but actual api contains doc, it's okay
				//note: OR if input expect not to display doc, by pass it
				System.out.println("TEST - anocFlag="+anocFlag);
				condition= (actualSize==0)  || (actualSize!=0 && !anocFlag);
			} else {
				condition= (actualSize==0);
			}
			Assert.assertTrue("PROBLEM - input didn't expect to see doc display for '"+section+"' section for language '"+targetLang+"' but actual list of doc is not 0.  Expected='0' | Actual='"+actualSize+"'", condition);
			noteList.add(0, "  CAN match expected result w/ input condition for section '"+section+"' for language '"+targetLang+"' - input expected not to see this doc");
			noteList.add(0, "API VALIDATOIN PASSED");
			return noteList; //note: if input doesn't expect to see list of doc for section and UI matches result, no need to validate what's in API
		}
		
		//note: not all docs on UI are coming via the same API, so only validate if actualFromUi >= expectedFromApi
		Assert.assertTrue("PROBLEM - number of documents in section '"+section+"' for language '"+targetLang+"' is not as expected as the ones from API. NOTE: If UI is matching with API but you are getting this error, check your input in PlanDocumentsAndResourcesUserHelper to see if expected list match with what's on UI.  API Expected='"+expectedSize+"' | UI Actual='"+actualSize+"'", actualSize>=expectedSize);
		
		boolean foundAll=true;

		for(HashMap<String, Document> act_docItem: act_docListFromUi) {
			System.out.println("===== attempt to validate each entry from UI ===========");
			for (Map.Entry act_mapElement : act_docItem.entrySet()) { 
				String act_category = (String)act_mapElement.getKey(); 
				Document act_doc=(Document) act_mapElement.getValue();

				System.out.println("TEST - Actual doc From UI: category="+act_category+" | segment="+act_doc.getSegmentId()+" | type="+act_doc.getType()+" | year="+act_doc.getYear()+" | code="+act_doc.getCompCode()+" | link="+act_doc.getLink());
				System.out.println("TEST - exp_docListFromApi size="+exp_docListFromApi.size());
				boolean found=false;
				for(HashMap<String, Document> exp_docItem: exp_docListFromApi) {
					for (Map.Entry exp_mapElement : exp_docItem.entrySet()) { 
						String exp_category = (String)exp_mapElement.getKey(); 
						Document exp_doc=(Document) exp_mapElement.getValue();
						System.out.println("=====");
						System.out.println("Check expected doc From API: category="+exp_category+" | exp_doc.segment="+exp_doc.getSegmentId()+" | type="+exp_doc.getType()+" | year="+exp_doc.getYear()+" | code="+exp_doc.getCompCode()+" | link="+exp_doc.getLink());
						System.out.println("Check expected doc From UI : category="+act_category+" | act_doc.segment="+act_doc.getSegmentId()+" | type="+act_doc.getType()+" | year="+act_doc.getYear()+" | code="+act_doc.getCompCode()+" | link="+act_doc.getLink());

						//note: if fidn a match with the name between UI and API
						//note: or for PDP/MAPD GROUP case if UI has Formulary/DrugList - Comprehensive and API has Comprehensive Formulary
						if (((exp_category.toLowerCase()).contains(act_category.toLowerCase()) || (act_category.toLowerCase()).contains(exp_category.toLowerCase()))
								|| (act_category.equals("Formulary/Drug List - Comprehensive") && exp_category.equals("Comprehensive Formulary") && (planType.equals("PDP")||planType.equals("MAPD")) && memberType.contains("GROUP"))
								) {
							boolean allMatch=true;
							System.out.println("TEST - found match for category, check for more values...");
							//note: for spanish, there is no id attribute for the li, so skip compCode
							if (!act_doc.getType().equals(exp_doc.getType())) {
								if (act_category.equals("Comprehensive Formulary")) {
									//note: tricky one, some has type 4 some has 1022. do this forn now, figure it out later
									if ((act_doc.getType().equals("4") || act_doc.getType().equals("1022") || act_doc.getType().equals("8002"))
										&& (exp_doc.getType().equals("4") || exp_doc.getType().equals("1022") || exp_doc.getType().equals("8002"))	){
										System.out.println("TEST - type - act_category=Comprehensive Formulary | Type: act="+act_doc.getType()+" : exp="+exp_doc.getType());
										System.out.println("TEST - type - let it slide for now, need to figure out better way to handle this");
									} else {
										allMatch=false;
									}
								} else {
									allMatch=false;
								}
							} 
							System.out.println("TEST - type - allMatch="+allMatch+" | Type: act="+act_doc.getType()+" : exp="+exp_doc.getType());
							
							if (!act_doc.getYear().equals(exp_doc.getYear())) {
								allMatch=false;
							}
							System.out.println("TEST - year - allMatch="+allMatch+" | Year: act="+act_doc.getYear()+" : exp="+exp_doc.getYear());
							
							if (!act_doc.getSegmentId().contains(exp_doc.getSegmentId())) {
								allMatch=false;
							}
							System.out.println("TEST - segemnt - allMatch="+allMatch+" | Segment: act="+act_doc.getSegmentId()+" : exp="+exp_doc.getSegmentId());
							if (checkDestUrl) {
								if (!act_doc.getLink().contains(exp_doc.getLink())) {
									allMatch=false;
								}
							}
							System.out.println("TEST - link - allMatch="+allMatch+" | link: act="+act_doc.getLink()+" : exp="+exp_doc.getLink());
							if (act_doc.getCompCode().equals("null")) //note: CompCode is text null
								System.out.println("TEST - compCode - actual CompCode from element is null, skip the CompCode validation");
							else if (!act_doc.getCompCode().equals("") && !act_doc.getCompCode().equals("null")) {
								//note: actual CompCode has something...
								if (!act_doc.getLanguage().toLowerCase().contains("es") && !act_category.contains("Pharmacy Directory")
										&& !act_category.contains("Vendor Information Sheet")
										&& !act_category.contains("Provider Directory")) {
									//note: and it's not spanish for Pharmacy Directory / Vendor Info Sheet / Provider Directory
									if (!act_doc.getCompCode().equals(exp_doc.getCompCode())) {
										allMatch=false;
									}
								}
							} else {
								System.out.println("TEST - compCode - actual CompCode from element is empty, skip the CompCode validation");
							}
							System.out.println("TEST - compCode - allMatch="+allMatch+" | CompCode: act="+act_doc.getCompCode()+" : exp="+exp_doc.getCompCode());
							if (allMatch) {
								found=true;
								System.out.println("FOUND - doc with link="+act_doc.getLink());
								break;
							} else {
								System.out.println("type match="+(act_doc.getType().equals(exp_doc.getType())));
								System.out.println("year match="+(act_doc.getYear().equals(exp_doc.getYear())));
								System.out.println("segment match="+(act_doc.getSegmentId().equals(exp_doc.getSegmentId())));
								System.out.println("link="+(act_doc.getLink().contains(exp_doc.getLink())));
							}
						}
					} 
				}
				if (!found && (act_category.equals("HEALTH PRODUCTS BENEFIT") 
						|| act_category.equals("Home Delivery Brochure")
						|| act_category.equals("OVER THE COUNTER ESSENTIALS"))
						|| act_category.equals("Over-the-Counter Drug List")
						|| act_category.equals("Health & Wellness Products Catalog")) {
					System.out.println(act_category+" doc doesn't come from this API, bypass this");
					noteList.add("    BYPASS look up for '"+act_category+"'  in API response");
					found=true;
				}
				if (found) {
					System.out.println("found match for act_category="+act_category);
					if (act_category.equals("HEALTH PRODUCTS BENEFIT") 
							|| act_category.equals("Home Delivery Brochure")  
							|| act_category.equals("OVER THE COUNTER ESSENTIALS")
							|| act_category.equals("Over-the-Counter Drug List")
							|| act_category.equals("Health & Wellness Products Catalog")) 
						noteList.add("    SKIP match for '"+act_category+"' (documnet name in '"+targetLang+"') in /formsAndResourcesFor*/ API response");
					else 
						noteList.add("    FOUND match for '"+act_category+"' (documnet name in '"+targetLang+"') in /formsAndResourcesFor*/ API response");
					break;
				} else {
					System.out.println("not found match for act_category="+act_category);
					foundAll=false;
					noteList.add("    * NOT FOUND match for '"+act_category+"' (documnet name in '"+targetLang+"') in /formsAndResourcesFor*/ API response or it is not expected to show in this section");
				}
			} 
		}
		if (foundAll) {
			System.out.println("found match for ALL");
			noteList.add(0, "  CAN match all docs in section '"+section+"' for language '"+targetLang+"'");
			noteList.add(0, "API VALIDATOIN PASSED");
		} else {
			System.out.println("not found match for ALL");
			foundAll=false;
			noteList.add(0, "  * CANNOT match all docs in section '"+section+"' for language '"+targetLang+"'");
			noteList.add(0, "API VALIDATOIN FAILED");
		}
		return noteList;
	}

	/**
	 * helper - display list of doc in detail
	 * @param section
	 * @param langValue
	 * @param docList
	 */
	@SuppressWarnings("rawtypes")
	public void printDocListDetail(String section, String langValue, List<HashMap<String, Document>> docList) {
		String language="English";
		if (langValue.equalsIgnoreCase("es")) {
			language="Spanish";
		} else if (langValue.equalsIgnoreCase("zh")) {
			language="Chinese";
		}

		System.out.println("Doc detail for section '"+section+"' and language '"+language+"'");
		for(HashMap<String, Document> docItem: docList) {
			Iterator it = docItem.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry)it.next();
				String category=(String) pair.getKey();
				Document doc=(Document) pair.getValue();
				System.out.println("Detail for doc='"+category+"':");
				doc.printDetail();
				it.remove(); // avoids a ConcurrentModificationException
			}		
		}
	}
	
	/**
	 * helper - get the type for the given doc
	 * NOTE: 
	 * if you are adding entry here, 
	 * make sure make corresponding update in Document.java - getDocType
	 * and PlanDocApiResponse.java - buildDocListMap
	 * @param docName
	 * @return
	 */
	public String getDocType(HashMap<String, String> testInputInfoMap, String docName) {
		String planType=testInputInfoMap.get("planType");
		if (docName.toLowerCase().equalsIgnoreCase("Benefit Highlights".toLowerCase()) || docName.toLowerCase().equalsIgnoreCase("Beneficios Importantes".toLowerCase())) 
			return "6002";
		if (docName.toLowerCase().equalsIgnoreCase("Summary of Benefits".toLowerCase()) || docName.toLowerCase().equalsIgnoreCase("Resumen de Beneficios".toLowerCase())) 
			return "3";
		if (docName.toLowerCase().equalsIgnoreCase("Evidence of Coverage".toLowerCase()) || docName.toLowerCase().equalsIgnoreCase("Comprobante de Cobertura".toLowerCase())) 
			return "2";
		if (docName.toLowerCase().equalsIgnoreCase("Comprehensive Formulary-Spanish".toLowerCase()) || docName.toLowerCase().equalsIgnoreCase("Formulario Completo-Spanish".toLowerCase())) 
			return "1022";
		if (docName.toLowerCase().equalsIgnoreCase("Comprehensive Formulary".toLowerCase()) || docName.toLowerCase().equalsIgnoreCase("Formulario completo".toLowerCase())) 
			return "4";
		if (docName.toLowerCase().equalsIgnoreCase("Alternative Drug List".toLowerCase()) ||  docName.toLowerCase().equalsIgnoreCase("Lista de Medicamentos".toLowerCase())||  docName.toLowerCase().equalsIgnoreCase("Lista de Medicamentos Alternativos".toLowerCase())) 
			return "7022";
		if (docName.toLowerCase().equalsIgnoreCase("Prior Authorization Criteria".toLowerCase())) 
			return "2019";
		if (docName.toLowerCase().equalsIgnoreCase("Step Therapy Criteria".toLowerCase())) 
			return "2020";
		if (docName.toLowerCase().equalsIgnoreCase("Formulary Additions".toLowerCase())) 
			return "2021";
		if (docName.toLowerCase().equalsIgnoreCase("Formulary Deletions".toLowerCase())) 
			return "2022";
		if (docName.toLowerCase().equalsIgnoreCase("Getting Started Guide".toLowerCase()) || docName.toLowerCase().equalsIgnoreCase("Quick Start Guide".toLowerCase())|| docName.toLowerCase().contains("para Comenzar".toLowerCase())) 
			return "8006";
		if (docName.toLowerCase().equalsIgnoreCase("Annual Notice of Changes".toLowerCase()) || docName.toLowerCase().equalsIgnoreCase("Aviso Annual de Cambios".toLowerCase())) 
			return "6014";
		if (docName.toLowerCase().equalsIgnoreCase("Provider Directory".toLowerCase()) || docName.toLowerCase().equalsIgnoreCase("Directorio de Proveedores".toLowerCase())) 
			return "1027";
		if (docName.toLowerCase().equalsIgnoreCase("Vendor Information Sheet".toLowerCase()) || docName.toLowerCase().contains("sobre proveedores".toLowerCase())) 
			return "7025";
		if ((!planType.equals("PDP")) && (docName.toLowerCase().equalsIgnoreCase("Pharmacy Directory".toLowerCase()) || docName.toLowerCase().equalsIgnoreCase("Pharmacy Directory Information".toLowerCase()) || docName.toLowerCase().contains("del Directorio de Farmacia".toLowerCase()))) 
			return "1028";
		if ((planType.equals("PDP")) && (docName.toLowerCase().equalsIgnoreCase("Pharmacy Directory".toLowerCase()) || docName.toLowerCase().equalsIgnoreCase("Pharmacy Directory Information".toLowerCase()) || docName.toLowerCase().contains("del Directorio de Farmacia".toLowerCase()))) 
			return "1026";
		if (docName.toLowerCase().equalsIgnoreCase("Certificate of Coverage".toLowerCase()) ) 
			if (planType.equals("SSP"))
				return "6011";
			else
				return "8003";
		if (docName.toLowerCase().equalsIgnoreCase("UnitedHealth Passport Program".toLowerCase()) || docName.toLowerCase().equalsIgnoreCase("Programa UnitedHealth Passport".toLowerCase())) 
			return "7001";
		if (docName.toLowerCase().equalsIgnoreCase("Moving to your new plan".toLowerCase()) ) 
			return "-99"; //note: don't know what it should be yet
		if (docName.toLowerCase().equalsIgnoreCase("Plan Benefits Table".toLowerCase()) ) 
			return "5002"; //note: SHIP
		if (docName.toLowerCase().equalsIgnoreCase("A Guide to Health Insurance for People with Medicare".toLowerCase())) 
			return "5006"; //note: SHIP
		if (docName.toLowerCase().equalsIgnoreCase("Formulary/Drug List - Comprehensive".toLowerCase())) 
			return "8002";
		if (docName.toLowerCase().equalsIgnoreCase("Additional Drug Coverage".toLowerCase())) 
			return "4005";
		if (docName.toLowerCase().equalsIgnoreCase("CDI Long Notice".toLowerCase()) || docName.toLowerCase().equalsIgnoreCase("Privacy Notice".toLowerCase())) 
			return "5009";
		if (docName.toLowerCase().equalsIgnoreCase("Schedule of benefits".toLowerCase()) ) 
			return "1021";
		if (docName.toLowerCase().equalsIgnoreCase("Your Plan Getting Started".toLowerCase()) ) 
			return "7010";
		System.out.println("TEST - unable to find a type match for docName="+docName);
		return "-2";
	}

	/**
	 * helper - get the english name for the given spanish doc
	 * @param docName
	 * @return
	 */
	public String getEnglishName(String docName) {
		String engName=null;
		if (docName.toLowerCase().equalsIgnoreCase("Beneficios Importantes".toLowerCase()))
			engName="Benefit Highlights";
		if (docName.toLowerCase().equalsIgnoreCase("Resumen de Beneficios".toLowerCase()))
			engName="Summary of Benefits";
		if (docName.toLowerCase().equalsIgnoreCase("Comprobante de Cobertura".toLowerCase())) 
			engName="Evidence of Coverage";
		if (docName.toLowerCase().equalsIgnoreCase("Comprehensive Formulary-Spanish".toLowerCase()) 
				|| docName.toLowerCase().equalsIgnoreCase("Formulario completo".toLowerCase())
				|| docName.toLowerCase().contains("Formulario Completo-Spanish".toLowerCase())) 
			engName="Comprehensive Formulary";
		if (docName.toLowerCase().contains("Lista de Medicamentos".toLowerCase())) 
			engName="Alternative Drug List";
		if (docName.toLowerCase().contains("para Comenzar".toLowerCase()))
			engName="Getting Started Guide";
		if (docName.toLowerCase().equalsIgnoreCase("Aviso Annual de Cambios".toLowerCase()))
			engName="Annual Notice of Changes";
		if (docName.toLowerCase().equalsIgnoreCase("Directorio de Proveedores".toLowerCase()))
			engName="Provider Directory";
		if (docName.toLowerCase().contains("sobre proveedore".toLowerCase()))
			engName="Vendor Information Sheet";
		if (docName.toLowerCase().contains("del Directorio de Farmacia".toLowerCase()))
			engName="Pharmacy Directory";
		if (docName.toLowerCase().contains("del Directorio de Farmacia".toLowerCase()))
			engName="Pharmacy Directory Information";
		if (docName.toLowerCase().contains("Lista de Medicamentos sin Receta".toLowerCase()))
			engName="Over-the-Counter Drug List";
		if (docName.toLowerCase().contains("Programa UnitedHealth Passport".toLowerCase()))
			engName="UnitedHealth Passport Program";
		if (docName.toLowerCase().contains("Vendor Information Sheet".toLowerCase())) //NOTE: may not need for real
			engName="Vendor Information Sheet";
		if (docName.toLowerCase().contains("pida para Comenzar".toLowerCase())) //NOTE: may not need for real
			engName="Quick Start Guide";
		Assert.assertTrue("PROBLEM - need to update ATDD code to handle '"+docName+"' spanish name to english name", engName!=null);
		return engName;
	} 
	
	
	
	public String getApiRequestUrl(HashMap<String, String> testInputInfoMap) {
		String planType=testInputInfoMap.get("planType");
		String memberType=testInputInfoMap.get("memberType");
		String apiReqeust=null;
		String lookForText1="formsAndResourcesFor";
		String lookForText2="responseReceived";
		List<LogEntry> entries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
		for (LogEntry entry : entries) {
			String line=entry.getMessage();
			if (memberType.contains("COMBO")) {
				if (line.contains(lookForText1) && line.contains(lookForText2) && line.contains(planType)) {
					apiReqeust=line;
					System.out.println("TEST found line="+line);
					break;
				}
			} else {
				if (line.contains(lookForText1) && line.contains(lookForText2)) {
					apiReqeust=line;
					System.out.println("TEST found line="+line);
					break;
				}
			}
		}
		Assert.assertTrue("PROBLEM - unable to locate the network entry that contains '"+lookForText1+"' and '"+lookForText2+"'", apiReqeust!=null);
		JSONParser parser = new JSONParser();
		JSONObject jsobObj=null;
		try {
			jsobObj = (JSONObject) parser.parse(apiReqeust);
		} catch (ParseException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - unable to convert target string into json object", false);
		}
		JSONObject messageObj = (JSONObject) jsobObj.get("message");
		Assert.assertTrue("PROBLEM - unable to locate message json object", messageObj!=null);
		JSONObject paramsObj = (JSONObject) messageObj.get("params");
		Assert.assertTrue("PROBLEM - unable to locate message json object", paramsObj!=null);
		JSONObject responseObj = (JSONObject) paramsObj.get("response");
		Assert.assertTrue("PROBLEM - unable to locate message json object", responseObj!=null);
		System.out.println("TEST - responseObj="+responseObj.toString());
		Long statusValue = (Long) responseObj.get("status");
		Assert.assertTrue("PROBLEM - unable to locate postData string", statusValue!=null);
		Assert.assertTrue("PROBLEM - API response is not getting status=200", statusValue==200 || statusValue==206);
		String urlStr = (String) responseObj.get("url");
		Assert.assertTrue("PROBLEM - unable to locate postData string", urlStr!=null);
		System.out.println("TEST - urlStr="+urlStr);
		return urlStr;
	}

	public void selectLangFromDropdown(String section, String targetLang) {
		WebElement langDropDown=null;
		String langElementValue="en_us";
		if (targetLang.equals("ES")) 
			langElementValue="es";
		else if (targetLang.equals("ZH")) 
			langElementValue="zh";

		if (section.equals("Plan Materials")) 
			langDropDown=langDropDown_PM;
		if (section.equals("Membership Materials")) 
			langDropDown=langDropDown_MM;
		if (section.equals("Annual Notice of Changes Documents")) 
			langDropDown=langDropDown_ANOC;
		if (section.equals("Provider and Pharmacy Directories") || section.equals("Provider Directory") || section.equals("Pharmacy Directory")) 
			langDropDown=langDropDown_PD;

		Select langDropdown = new Select(langDropDown);
		langDropdown.selectByValue(langElementValue);
	}

	/**
	 * Using the list of expected documentation supplied by test input (PlanDocumentsAndResourcesUsersHelper)
	 * will loop for each and call 'validateDoc' method to validate if it can be located on the UI for the test section.
	 * NOTE:
	 * if validateApi is enabled, will also validate if the list of doc in API response are displaying on the test section
	 * @param testInputInfoMap
	 * @param expDocList
	 * @param sectionNote
	 * @param api_planDocMap
	 * @return
	 */
	public List<String> validateDocOnUi(HashMap<String, String> testInputInfoMap, List<String> expDocList, List<String> sectionNote, PlanDocApiResponse api_planDocMap) {
		String planType=testInputInfoMap.get("planType");
		String memberType=testInputInfoMap.get("memberType");
		String section=testInputInfoMap.get("section");
		String targetSubSection=testInputInfoMap.get("targetSubSection");
		String targetLang=testInputInfoMap.get("targetLang");
		boolean checkDestUrl=Boolean.valueOf(testInputInfoMap.get("checkDestUrl"));
		
		boolean expDocDisplay=Boolean.valueOf(testInputInfoMap.get("expDocDisplay"));
		boolean validateApi=Boolean.valueOf(testInputInfoMap.get("validateApi"));
		List<HashMap<String, Document>> act_docListFromUi=new ArrayList<HashMap<String, Document>>();
		if (expDocDisplay  && !planType.equals("SHIP")) //note: for ship there is no language option
			selectLangFromDropdown(section, targetLang);

		for(String expDocName: expDocList) {
			HashMap<String, Document> act_doc=validateDoc(testInputInfoMap, expDocName);
			Assert.assertTrue("PROBLEM - unable to locate doc='"+expDocName+"'", act_doc!=null || !expDocDisplay);
			sectionNote.add("  PASSED - document '"+expDocName+"' validation UI vs expected list");
			act_docListFromUi.add(act_doc);
		}
		//note: if validateApi==false, then we are all done at this point for this validation
		//---------------------------------------
		//note: this section will only invoke if step definition decide to validate API also
		if (validateApi) {
			if (memberType.contains("TERM")) {
				sectionNote.add("  BYPASS - UI vs API validation because terminated user has no doc list");
				return sectionNote;
			}
			boolean anocFlag=false;
			List<HashMap<String, Document>> exp_docListFromApi=new ArrayList<HashMap<String, Document>>();
			//note: use hte right expected list of doc based on the seciton and language
			if (targetSubSection.equals("currentYear")) {
				anocFlag=api_planDocMap.isAnocCurrentYearFlag();
				System.out.println("TEST - api_planDocMap.isAnocCurrentYearFlag()="+anocFlag);
				if (section.equals("Plan Materials")) {
					exp_docListFromApi=api_planDocMap.getPlanMatl_en_curYr_docList();
					if (targetLang.equals("ES"))
						exp_docListFromApi=api_planDocMap.getPlanMatl_es_curYr_docList();
					else if (targetLang.equals("ZH"))
						exp_docListFromApi=api_planDocMap.getPlanMatl_zh_curYr_docList();
				} else if (section.equals("Membership Materials")) { 
					exp_docListFromApi=api_planDocMap.getMemMatl_en_curYr_docList();
					if (targetLang.equals("ES"))
						exp_docListFromApi=api_planDocMap.getMemMatl_es_curYr_docList();
					else if (targetLang.equals("ZH"))
						exp_docListFromApi=api_planDocMap.getMemMatl_zh_curYr_docList();
				} else if (section.equals("Annual Notice of Changes Documents")) {
					exp_docListFromApi=api_planDocMap.getAnnNotChgDoc_en_curYr_docList();
					if (targetLang.equals("ES"))
						exp_docListFromApi=api_planDocMap.getAnnNotChgDoc_es_curYr_docList();
					else if (targetLang.equals("ZH"))
						exp_docListFromApi=api_planDocMap.getAnnNotChgDoc_zh_curYr_docList();
				} else if (section.equals("Provider and Pharmacy Directories") || section.equals("Provider Directory") || section.equals("Pharmacy Directory")) {
					exp_docListFromApi=api_planDocMap.getProPhmDir_en_curYr_docList();
					if (targetLang.equals("ES"))
						exp_docListFromApi=api_planDocMap.getProPhmDir_es_curYr_docList();
					else if (targetLang.equals("ZH"))
						exp_docListFromApi=api_planDocMap.getProPhmDir_zh_curYr_docList();
				}
			} else {
				anocFlag=api_planDocMap.isAnocNextYearFlag();
				System.out.println("TEST - api_planDocMap.isAnocNextYearFlag()="+anocFlag);
				if (section.equals("Plan Materials")) {
					exp_docListFromApi=api_planDocMap.getPlanMatl_en_nxtYr_docList();
					if (targetLang.equals("ES"))
						exp_docListFromApi=api_planDocMap.getPlanMatl_es_nxtYr_docList();
					else if (targetLang.equals("ZH"))
						exp_docListFromApi=api_planDocMap.getPlanMatl_zh_nxtYr_docList();
				} else if (section.equals("Membership Materials")) { 
					exp_docListFromApi=api_planDocMap.getMemMatl_en_nxtYr_docList();
					if (targetLang.equals("ES"))
						exp_docListFromApi=api_planDocMap.getMemMatl_es_nxtYr_docList();
					else if (targetLang.equals("ZH"))
						exp_docListFromApi=api_planDocMap.getMemMatl_zh_nxtYr_docList();
				} else if (section.equals("Annual Notice of Changes Documents")) {
					exp_docListFromApi=api_planDocMap.getAnnNotChgDoc_en_nxtYr_docList();
					if (targetLang.equals("ES"))
						exp_docListFromApi=api_planDocMap.getAnnNotChgDoc_es_nxtYr_docList();
					else if (targetLang.equals("ZH"))
						exp_docListFromApi=api_planDocMap.getAnnNotChgDoc_zh_nxtYr_docList();
				} else if (section.equals("Provider and Pharmacy Directories") || section.equals("Provider Directory") || section.equals("Pharmacy Directory")) {
					exp_docListFromApi=api_planDocMap.getProPhmDir_en_nxtYr_docList();
					if (targetLang.equals("ES"))
						exp_docListFromApi=api_planDocMap.getProPhmDir_es_nxtYr_docList();
					else if (targetLang.equals("ZH"))
						exp_docListFromApi=api_planDocMap.getProPhmDir_zh_nxtYr_docList();
				}
			}
			List<String> docList_noteList=compareUiApiDocList(testInputInfoMap, act_docListFromUi, exp_docListFromApi, anocFlag, expDocDisplay, checkDestUrl);
			//note: fix up the note and send it back up level to take care of the validation
			if (docList_noteList.get(0).equals("API VALIDATOIN PASSED")) {
				docList_noteList.remove(0);
				sectionNote.addAll(docList_noteList);
				sectionNote.add(0, "API VALIDATOIN PASSED");
			} else if (docList_noteList.get(0).equals("API VALIDATOIN FAILED")) {
				docList_noteList.remove(0);
				sectionNote.addAll(docList_noteList);
				sectionNote.add(0, "API VALIDATOIN FAILED");
			} else {
				sectionNote.addAll(docList_noteList);
			}
		}
		return sectionNote;
	}

	/**
	 * For the given expected doc: 
	 * - go to the section in test 
	 * - select the correct language dropdown and validate if it shows up on the UI for the test section
	 * NOTE: 
	 * Sometimes may get staleElementException, will attempt one retry before giving up
	 * Retry involves refreshing the page and then retrying the validation 
	 * @param testInputInfoMap
	 * @param section
	 * @param langElementValue
	 * @param targetYear
	 * @param checkDestUrl
	 * @param expDocName
	 * @param expDocDisplay
	 * @return
	 */
	public HashMap<String, Document> validateDoc(HashMap<String, String> testInputInfoMap, String expDocName) {
		int count=0;
		int maxRetry=1;
		while (true) { 
			try {
				System.out.println("Proceed to validate expected document="+expDocName+" against what is showing on UI");
				String section=testInputInfoMap.get("section");
				String targetLang=testInputInfoMap.get("targetLang");
				String targetYr=testInputInfoMap.get("targetYr");
				boolean checkDestUrl=Boolean.valueOf(testInputInfoMap.get("checkDestUrl"));
				boolean expDocDisplay=Boolean.valueOf(testInputInfoMap.get("expDocDisplay"));
				HashMap<String, Document> planDocMap=null;

				WebElement langDropDown=null;

				//note: xpath for the documents and language dropdown for each section on the page
				String actualDocList_xpath="";
				if (section.equals("Plan Materials")) {
					langDropDown=langDropDown_PM;
					actualDocList_xpath="//div[contains(@class,'planMaterial') and not(contains(@class,'ng-hide'))]//div[contains(@class,'sectionWise_div_')]//li[not(contains(@class,'hide'))]";
				} else if (section.equals("Membership Materials")) { 
					langDropDown=langDropDown_MM;
					//actualDocList_xpath="//div[contains(@class,'WelcomeKit') and not(contains(@class,'ng-hide'))]//div[contains(@class,'sectionWise_div_')]//li";
					actualDocList_xpath="//div[contains(@class,'WelcomeKit') and not(contains(@class,'ng-hide'))]//div[contains(@class,'sectionWise_div_')]//li[not(contains(@class,'hide'))]";
				} else if (section.equals("Annual Notice of Changes Documents")) {
					langDropDown=langDropDown_ANOC;
					actualDocList_xpath="//div[contains(@class,'annualNotice') and not(contains(@class,'ng-hide'))]//div[contains(@class,'sectionWise_div_"+targetYr+"') and not(contains(@style,'display: none;'))]//li[not(contains(@class,'hide'))]";
				} else if (section.equals("Provider Directory") || section.equals("Pharmacy Directory") || section.equals("Provider and Pharmacy Directories")) {
					langDropDown=langDropDown_PD;
					actualDocList_xpath="//div[contains(@class,'Directories') and not(contains(@class,'ng-hide'))]//div[contains(@class,'sectionWise_div_"+targetYr+"') and not(contains(@style,'display: none;'))]//li[not(contains(@class,'hide'))]";
				}

				//note: actualListDoc is the list of documents display on the UI
				List<WebElement> actualListDoc = driver.findElements(By.xpath(actualDocList_xpath));
				int actualTotalNumDoc=actualListDoc.size();
				System.out.println("TEST - There are total of '"+actualTotalNumDoc+"' on UI for section="+section);
				if (!expDocDisplay) {
					//note: if don't expect to see any doc then
					//note: either language option is not display at all or if language option avaiable then no doc list showing
					Assert.assertTrue("PROBLEM - should not see any doc for section '"+section+"' language '"+targetLang+"'", 
							(validateLangDropDownAvaOptn(langDropDown, targetLang) && actualTotalNumDoc==0) 
							|| !validateLangDropDownAvaOptn(langDropDown, targetLang));
					return planDocMap;
				}

				//note: for PM doc, majority of those docs will open up new tab if clicked
				boolean switchTab=true;  
				String langValue="";
				String category="";
				if (targetLang.equals("EN")) {
					category=expDocName;
					langValue="en_us";
				} else if (targetLang.equals("ES")) { 
					category=getEnglishName(expDocName);
					langValue="es";
				} else if (targetLang.equals("ZH")) {
					//TODO if zh for chinese - assume english for now
					category=expDocName;
					langValue="zh";
				}

				//note: loop through each doc in the section from UI and see if can locate the expected doc
				System.out.println("Proceed to loop through the list of UI docs and compare to expected input doc to see if it is in the list...");
				boolean found=false;
				for (int i=1; i<=actualListDoc.size(); i++ ) { //note: xpath start w/ index 1
					WebElement eachDoc=actualListDoc.get(i-1); //note: list array index start w/ 0
					String actualDocName=eachDoc.getText();
					System.out.println("TEST ------------- UI doc list i="+i+" start validation for UI doc="+actualDocName+" for langauge="+langValue);

					//note: some doc has Evidence Of Coverage or Evidence of Coverage, just make it consistent to ease validation
					if (expDocName.contains("Evidence Of Coverage")) 
						expDocName=expDocName.replace("Evidence Of Coverage","Evidence of Coverage");
					if (actualDocName.contains("Evidence Of Coverage")) 
						actualDocName=actualDocName.replace("Evidence Of Coverage", "Evidence of Coverage");
					//note: use regex to find match for document name
					//note: because actual docName will have (PDF,xxxKB)... at the end of the string
					//note: also if spanish name, latin characters will not work well with "equals" or "contains" during jenkins run
					String expDocNamePattern=expDocName+"(.*?)";
					System.out.println("TEST - looking for match for expDocName='"+expDocName+"' | expDocNamePattern='"+expDocNamePattern+"'");
					Pattern p=Pattern.compile(expDocName+".*?");
					Matcher m=p.matcher(actualDocName);
					if (m.find()) {
						System.out.println("TEST - got a name match for the expected doc from the list of UI docs, proceed to validate in detail...");
						found=true;

						//note: find the element attributes and store it into document object in case want to do API validation later
						planDocMap=new HashMap<String, Document>();
						//note: find the element id and href 
						String segmentId="---";
						String classStr=eachDoc.getAttribute("class");
						System.out.println("TEST - need to determine and fix up the segment ID for the matched UI doc.  classStr="+classStr);
						String[] tmp=classStr.split("clearfix ");
						if (tmp.length>0) {  //note: in case one more field after for the PDP case
							segmentId=tmp[1];
							tmp=segmentId.split(" ");
							if (tmp.length>1) {
								System.out.println("TEST - segment still has whitespace");
								segmentId=tmp[0];
							}
						}
						System.out.println("TEST - fixed segmentId for the matched UI doc ="+segmentId);

						//note: find the element id and href for each of the doc
						System.out.println("TEST - need to detemine the href and id for the matched UI doc using xpath="+actualDocList_xpath+"["+i+"]//a");
						WebElement targetElement=driver.findElement(By.xpath(actualDocList_xpath+"["+i+"]//a"));
						String expUrl=targetElement.getAttribute("href");
						Document docObj=new Document();
						docObj.setName(actualDocName);
						docObj.setType(getDocType(testInputInfoMap, expDocName));
						docObj.setCompCode(eachDoc.getAttribute("id"));
						docObj.setLanguage(langValue);
						docObj.setLink(expUrl);
						docObj.setYear(targetYr);
						docObj.setSegmentId(segmentId);
						docObj.setCheckDestUrl(checkDestUrl);
						docObj.setSwitchTab(switchTab);
						planDocMap.put(category, docObj);
						testInputInfoMap.put("docName", actualDocName);
						testInputInfoMap.put("expectedUrl", expUrl);
						testInputInfoMap.put("redirectUrl", "none");
						testInputInfoMap.put("switchTab", String.valueOf(switchTab));
						System.out.println("TEST - need to determine whether new tab will open if link clicked... switchTab="+testInputInfoMap.get("switchTab"));

						//note: validate if link destination is correct
						validateLinkDest(testInputInfoMap, targetElement);

						//note: found the doc so no need to continue the loop
						break;
					}
				}
				if (found)
					System.out.println("FOUND doc: "+expDocName);
				else
					System.out.println("PROBLEM: CANNOT find doc: "+expDocName);
				return planDocMap;  //note: if no match find then planDocMap will be null
			} catch (StaleElementReferenceException e) {
				System.out.println("Got StaleElementReferenceException, will reload page and then try one more time before giving up");
				String origUrlBeforeClick=driver.getCurrentUrl();
				String planType=testInputInfoMap.get("planType");
				String memberType=testInputInfoMap.get("memberType");
				refreshPage(planType, memberType, origUrlBeforeClick);
				if (++count == maxRetry) {
					Assert.assertTrue("PROBLEM: Got StaleElementReferenceException and already reload page and retried once, giving up", false);
					throw e;
				}
			}
		}
	}
	
	public boolean determineSectionResult(List<String> resultList) {
		boolean sectionResult=true;
		for(String s: resultList) {
			if (s.contains("FAILED"))
				sectionResult=false;
		}
		return sectionResult;
	}

}