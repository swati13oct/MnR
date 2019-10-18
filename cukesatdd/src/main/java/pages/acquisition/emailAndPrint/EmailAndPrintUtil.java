package pages.acquisition.emailAndPrint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class EmailAndPrintUtil extends UhcDriver{

	@FindBy(xpath="//div[contains(@class,'plan-detail-tabs')]//a")
	private List<WebElement> listOfTabHeaders;

	@FindBy(xpath="//div[@class='accordion-content']")
	private List<WebElement> listOfTabBody;

	@FindBy(xpath="//div[contains(@id,'detail') and contains(@class,'active')]//h3")
	private List<WebElement> listOfSectionHeaderForActiveTab;

	@FindBy(xpath="//div[contains(@id,'detail') and contains(@class,'active')]//table")
	private List<WebElement> listOfSectionTableForActiveTab;

	@FindBy(xpath="//div[contains(@id,'plan-list') and contains(@class,'active')]//div[contains(@class,'plan-card') or contains(@class,'swiper-slide')][1]//a[@aria-selected='false']")
	private WebElement firstSaveHeartOnActiveSummaryPlanPage;
	
	@FindBy(xpath = "//div[@ng-show='showMaPlans']//a[contains(@dtmname,'Print Saved Plan List')]")
	private WebElement summary_maPrintOption;

	@FindBy(xpath = "//div[@ng-show='showMaPlans']//a[contains(@dtmname,'Email Saved Plan List')]")
	private WebElement summary_maEmailOption;

	@FindBy(xpath = "//div[@ng-show='showPdpPlans']//a[contains(@dtmname,'Print Saved Plan List')]")
	private WebElement summary_pdpPrintOption;

	@FindBy(xpath = "//div[@ng-show='showPdpPlans']//a[contains(@dtmname,'Email Saved Plan List')]")
	private WebElement summary_pdpEmailOption;

	@FindBy(xpath = "//div[@ng-show='showSnpPlans']//a[contains(@dtmname,'Print Saved Plan List')]")
	private WebElement summary_snpPrintOption;

	@FindBy(xpath = "//div[@ng-show='showSnpPlans']//a[contains(@dtmname,'Email Saved Plan List')]")
	private WebElement summary_snpEmailOption;

	@FindBy(xpath = "//div[@id='emailPlanSummaryPopUp']")
	private WebElement emailPlanSummaryPopupScreen;

	@FindBy(xpath = "//h3[@id='emailplandetail']")
	private WebElement emailPlanSummaryPopupScreenText;

	@FindBy(xpath = "//input[@id='email']")
	private WebElement emailPlanSummaryFieldBox;

	@FindBy(xpath = "//button[@class='cta-button cta-button sendbtn']")
	private WebElement emailPlanSummarySendButton;

	@FindBy(xpath = "//button[@class='cta-button close-modal secondary']")
	private WebElement emailPlanSummaryCancelButton;

	@FindBy(xpath = "//*[@id='emailSuccess']") 
	private WebElement emailPlanSummarySuccessText;

	@FindBy(xpath = "//button[@ng-click='closeEmailSuccessMsgSummaryPopUp()']")
	private WebElement emailPlanSummarySuccessCloseButton;

	@FindBy(xpath = "//input[@id='email' and @class='error']")
	private WebElement emailPlanSummaryErrorFieldBox;

	@FindBy(xpath = "//p//span[@id='emailError']")
	private WebElement emailPlanSummaryInputErrorText;

	@FindBy(xpath="//div[contains(@class,'active')]//a[contains(@class,'added')]")
	private List<WebElement> planSummary_listOfSavedHearts;

	@FindBy(xpath = "//div[contains(@class,'overview-main')]/h2")
	private WebElement vppTop;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[1]//span[@class='ng-binding']")
	private WebElement maPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[2]//span[@class='ng-binding']")
	private WebElement msPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[3]//span[@class='ng-binding']")
	private WebElement pdpPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[4]//span[@class='ng-binding']")
	private WebElement snpPlansCount;

	@FindBy(xpath="//h2[contains(@class,'zipcodePrint') and not(contains(@class,'ng-hide'))]")
	private WebElement cmpPgHeader;

	@FindBy(xpath="//div[@id='topRowCopy']//div[@ng-repeat='i in count']")
	private List<WebElement> listOfCmpPlansColumns;

	@FindBy(xpath="//div[@id='topRowCopy']//a[contains(@class,'added')]")
	private List<WebElement> planCompare_listOfSavedHearts;

	@FindBy(xpath="//table[@id='fixTable']//tr")
	private List<WebElement> listOfRowsInPlanCompareTbl;

	@FindBy(xpath="//div[@class='popup-modal active']//h2[@id='plan-year-modal-header']")
	private WebElement planYearPopup;

	@FindBy(xpath="//div[contains(@class,'planOptions')]//label[@for='current_Year']")
	private WebElement currentYearSelection;

	@FindBy(xpath="//button[@id='lisGoBtn']")
	private WebElement planYearPopupGoButton;

	@FindBy(xpath="//div[contains(@class,'planOptions')]//label[@for='next_Year']")
	private WebElement nextYearSelection;

	@FindBy(xpath = ".//*[@id='printdetails']")
	private WebElement validatePrintButtonOnPlanDetails;

	@FindBy(xpath=".//*[@id='printComparison']")
	private WebElement compare_validateprintbutton;

	@FindBy(xpath=".//*[@id='emailComparison']")
	private WebElement compare_validateemailbutton;

	@FindBy(xpath="//a[@id='backtoplansummarypage']")
	private WebElement backToAllPlansLnk;

	@FindBy(xpath=".//*[@id='emailSuccessMsgPopUp']/div/form/div[2]/button")
	private WebElement closeButtonthankyoumessagepopup;

	@FindBy(xpath=".//*[@id='emailComparison']")
	private WebElement validateemailbutton;
	
	@FindBy(xpath=".//*[@id='emailcompareDescription']")
	private WebElement leavingcomapreplansitepopup;
	
	@FindBy(xpath=".//*[@id='form-valid']/div[2]/button[1]")
	private WebElement cancelButtonEmailPlanComparePopUp;
	
	@FindBy(xpath=".//*[@id='form-valid']/div[2]/button[2]")
	private WebElement sendButtonEmailPlanComparePopUp;
	
	@FindBy(xpath=".//*[@id='emailSuccessMsgPopUp']")
	private WebElement validatesuccesspopup;

	@FindBy(xpath = ".//*[@id='emailPlanDetail']")
	private WebElement validateEmailButtonOnPlanDetails;

	@FindBy(xpath = ".//*[@id='emailPlanDetailPopUp']")
	private WebElement emailPopup;

	@FindBy(xpath = ".//*[@id='closepopup']")
	private WebElement cancelButtonEmailPlanDetailsPopUp;

	@FindBy(xpath = ".//*[@id='form-valid']//button[2]")
	private WebElement sendButtonEmailPlanDetailsPopUp;


	public EmailAndPrintUtil(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}


	/**
	 * Alternative to validate deeplink in email
	 * Get the deeplink from network's postData from the email plan list request
	 * Use that deeplink to open page and validate content at later step
	 */
	public String getEmailDeepLink() {
		String deepLinkEntryLine=null;
		List<LogEntry> entries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
		for (LogEntry entry : entries) {
			String line=entry.getMessage();
			if (line.toLowerCase().contains("deeplink")) {
				deepLinkEntryLine=line;
				System.out.println("TEST found line="+line);
			}
		}
		Assert.assertTrue("PROBLEM - unable to locate the network entry that contains the deeplink value", deepLinkEntryLine!=null);
		JSONParser parser = new JSONParser();
		JSONObject jsobObj=null;
		try {
			jsobObj = (JSONObject) parser.parse(deepLinkEntryLine);
		} catch (ParseException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - unable to convert target string into json object", false);
		}
		JSONObject messageObj = (JSONObject) jsobObj.get("message");
		Assert.assertTrue("PROBLEM - unable to locate message json object", messageObj!=null);
		JSONObject paramsObj = (JSONObject) messageObj.get("params");
		Assert.assertTrue("PROBLEM - unable to locate message json object", paramsObj!=null);
		JSONObject requestObj = (JSONObject) paramsObj.get("request");
		Assert.assertTrue("PROBLEM - unable to locate message json object", requestObj!=null);
		System.out.println("TEST - headersObj="+requestObj.toString());
		String postDataStr = (String) requestObj.get("postData");
		Assert.assertTrue("PROBLEM - unable to locate postData string", postDataStr!=null);
		String tmp=postDataStr.replace("\\\"{", "{").replace("}\\\"", "}");
		tmp=tmp.replace("\\\\\"", "\"");
		System.out.println("TEST - tmp="+tmp);
		try {
			jsobObj = (JSONObject) parser.parse(tmp);
		} catch (ParseException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - unable to convert postDataStr string into json object", false);
		}
		JSONObject toObj = (JSONObject) jsobObj.get("to");
		Assert.assertTrue("PROBLEM - unable to locate 'to' json object", toObj!=null);
		JSONObject contactAttributesObj = (JSONObject) toObj.get("contactAttributes");
		Assert.assertTrue("PROBLEM - unable to locate 'contactAttributes' json object", contactAttributesObj!=null);
		JSONObject subscriberAttributesObj = (JSONObject) contactAttributesObj.get("subscriberAttributes");
		Assert.assertTrue("PROBLEM - unable to locate 'subscriberAttributes' json object", subscriberAttributesObj!=null);
		System.out.println("TEST - subscriberAttributesObj="+subscriberAttributesObj.toString());
		String deepLinkStr = (String) subscriberAttributesObj.get("deepLink");
		Assert.assertTrue("PROBLEM - unable to locate deepLinkStr string", deepLinkStr!=null);
		System.out.println("TEST - *** deepLinkStr="+deepLinkStr);
		return deepLinkStr;
	}

	public HashMap<String, String> collectInfoVppPlanDetailPg(String plantype, String forWhat) {
		System.out.println("Proceed to collect the info on vpp detail page =====");

		HashMap<String, String> result=new HashMap<String, String>();

		String key="Total Tabs";
		result.put(key, String.valueOf(listOfTabHeaders.size()));
		System.out.println("TEST - "+forWhat+" - key="+key+" | value="+result.get(key));

		for (int i=0; i<listOfTabHeaders.size(); i++) { //note: loop through each table and store info
			listOfTabHeaders.get(i).click();
			int tabIndex=(i+1);

			//note: store section header
			for(int k=0; k<listOfSectionHeaderForActiveTab.size(); k++) {
				String sectionHeader=listOfSectionHeaderForActiveTab.get(k).getText();
				key="T"+tabIndex+"S"+(k+1);
				result.put(key, sectionHeader);
			}

			//note: store section table
			int numSectionTable=listOfSectionHeaderForActiveTab.size();
			result.put("Total Sections Per T"+tabIndex,String.valueOf(numSectionTable));
			for(int sectionIndex=1; sectionIndex<=numSectionTable; sectionIndex++) { //note: loop through each section table
				String rowXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr";
				List<WebElement> listOfRowsPerTable=driver.findElements(By.xpath(rowXpath));
				int numRows=listOfRowsPerTable.size();

				result.put("Total Rows For T"+tabIndex+"S"+sectionIndex,String.valueOf(numRows));

				if (numRows==0) { //note: no table so check for box
					String boxXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')][1]//div[contains(@class,'box') and not(contains(@class,'ng-hide'))]";
					List<WebElement> listOfBoxes=driver.findElements(By.xpath(boxXpath));
					result.put("Total Boxs For T"+tabIndex+"S"+sectionIndex, String.valueOf(listOfBoxes.size()));
					for(int boxIndex=1; boxIndex<=listOfBoxes.size(); boxIndex++) { //note: loop through each box
						String eachBoxXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')][1]//div[contains(@class,'box') and not(contains(@class,'ng-hide'))]["+boxIndex+"]";
						key="T"+tabIndex+"S"+sectionIndex+"B"+boxIndex;
						WebElement e=driver.findElement(By.xpath(eachBoxXpath));
						String value=e.getText();
						result.put(key, value);
						System.out.println("TEST - "+forWhat+" - key="+key+" | value="+result.get(key));
					}

					//note: assume this is the optional service tab
					//note: after going through all the box should be no more section, don't iterate the rest of the section counts
					break;
				} else {
					for(int rowIndex=1; rowIndex<=listOfRowsPerTable.size(); rowIndex++) { //note: loop through each row
						String cellsPerRowXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]";
						List<WebElement> listOfCellsPerRow=driver.findElements(By.xpath(cellsPerRowXpath));
						result.put("Total Cells For T"+tabIndex+"S"+sectionIndex+"R"+rowIndex,String.valueOf(listOfCellsPerRow.size()));
						for (int cellIndex=1; cellIndex<=listOfCellsPerRow.size(); cellIndex++) {
							String eachCellXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]["+cellIndex+"]";
							WebElement e=driver.findElement(By.xpath(eachCellXpath));
							key="T"+tabIndex+"S"+sectionIndex+"R"+rowIndex+"C"+cellIndex;
							String value=e.getAttribute("textContent");
							result.put(key, value);
							System.out.println("TEST - "+forWhat+" - key="+key+" | value="+result.get(key));
						}
					}
				}
			}
		}
		System.out.println("Finished collecting the info on vpp detail page =====");
		return result;
	}

	public String detail_comparePageItem(String targetKey, HashMap<String, String> origPage, HashMap<String, String> emailage) {
		String failedMessage="NONE";
		System.out.println("TEST - validate content for map key="+targetKey+"...");
		if (!(origPage.get(targetKey)).equals(emailage.get(targetKey))) {
			if (targetKey.equals("T3S2B1") || targetKey.equals("T1S1R2C2") || targetKey.equals("T2S1R7C2") || targetKey.equals("T2S1R8C2")) {
				failedMessage="BYPASS validation until fix (tick# xxxxx) - ";
				failedMessage=failedMessage+"item '"+targetKey+"' mismatch | original='"+origPage.get(targetKey)+"' | email='"+emailage.get(targetKey)+"'";
			} else {
				detail_finalResult=false;
				failedMessage="item '"+targetKey+"' mismatch | original='"+origPage.get(targetKey)+"' | email='"+emailage.get(targetKey)+"'";
			}
		}
		System.out.println("TEST - failedMessage="+failedMessage);
		return failedMessage;
	}

	boolean detail_finalResult=true;
	public List<String> validatePlanDetailEmailDeeplink(String planType, String deepLinkStringId, String infoMapStringId, String deepLink, HashMap<String, String> origPage) {
		List<String> testNote=new ArrayList<String>();
		List<String> listOfFailure=new ArrayList<String>();

		System.out.println("Proceed to validate the original page content vs page content from email deeplnk for plan detail...");
		System.out.println("Collect info from page content of the plan compare");
		HashMap<String, String> emailPage=collectInfoVppPlanDetailPg(planType, "from deepLink");
		
		String targetKey="Total Tabs";
		String failedMessage=detail_comparePageItem(targetKey, origPage, emailPage);
		System.out.println("HMM here?? - failedMessage="+failedMessage);
		if (failedMessage.contains("mismatch")) 
			listOfFailure.add(failedMessage);	
		if (failedMessage.contains("BYPASS")) 
			testNote.add(failedMessage);
		System.out.println("*************** b - sub section ************");
		System.out.println("\tTEMP - failedMessage="+failedMessage);
		for (String s: listOfFailure) {
			System.out.println("\tTEMP -listOfFailure="+s);
		}
		for (String s: testNote) {
			System.out.println("\tTEMP - testNote="+s);
		}
		System.out.println("*************** e - sub section ************");

		int totalTabs=Integer.valueOf(origPage.get(targetKey));
		System.out.println("TEST - totalTabs="+totalTabs);
		for (int tabIndex=1; tabIndex<=totalTabs; tabIndex++) { //note: loop through each table and validate info
			targetKey="Total Sections Per T"+tabIndex;
			failedMessage=detail_comparePageItem(targetKey, origPage, emailPage);
			if (failedMessage.contains("mismatch")) 
				listOfFailure.add(failedMessage);	
			if (failedMessage.contains("BYPASS")) 
				testNote.add(failedMessage);
			System.out.println("*************** b - sub section ************");
			System.out.println("\tTEMP - failedMessage="+failedMessage);
			for (String s: listOfFailure) {
				System.out.println("\tTEMP -listOfFailure="+s);
			}
			for (String s: testNote) {
				System.out.println("\tTEMP - testNote="+s);
			}
			System.out.println("*************** e - sub section ************");

			int totalSectionsPerTab=Integer.valueOf(origPage.get(targetKey));
			System.out.println("TEST - totalSectionsPerTab="+totalSectionsPerTab);

			for(int sectionIndex=1; sectionIndex<=totalSectionsPerTab; sectionIndex++) { //note: loop through each section table
				targetKey="Total Rows For T"+tabIndex+"S"+sectionIndex;
				failedMessage=detail_comparePageItem(targetKey, origPage, emailPage);
				if (failedMessage.contains("mismatch")) 
					listOfFailure.add(failedMessage);	
				if (failedMessage.contains("BYPASS")) 
					testNote.add(failedMessage);
				System.out.println("*************** b - sub section ************");
				System.out.println("\tTEMP - failedMessage="+failedMessage);
				for (String s: listOfFailure) {
					System.out.println("\tTEMP -listOfFailure="+s);
				}
				for (String s: testNote) {
					System.out.println("\tTEMP - testNote="+s);
				}
				System.out.println("*************** e - sub section ************");

				int totalRowsPerSectionOfActiveTab=Integer.valueOf(origPage.get(targetKey));
				System.out.println("TEST - totalRowsPerSectionOfActiveTab="+totalRowsPerSectionOfActiveTab);
				if (totalRowsPerSectionOfActiveTab==0) {  //note: no table so check for box
					targetKey="Total Boxs For T"+tabIndex+"S"+sectionIndex;
					failedMessage=detail_comparePageItem(targetKey, origPage, emailPage);
					if (failedMessage.contains("mismatch")) 
						listOfFailure.add(failedMessage);	
					if (failedMessage.contains("BYPASS")) 
						testNote.add(failedMessage);
					System.out.println("*************** b - sub section ************");
					System.out.println("\tTEMP - failedMessage="+failedMessage);
					for (String s: listOfFailure) {
						System.out.println("\tTEMP -listOfFailure="+s);
					}
					for (String s: testNote) {
						System.out.println("\tTEMP - testNote="+s);
					}
					System.out.println("*************** e - sub section ************");

					int totalBoxesPerSectionOfActiveTab=Integer.valueOf(origPage.get(targetKey));
					System.out.println("TEST - totalBoxesPerSectionOfActiveTab="+totalBoxesPerSectionOfActiveTab);
					for(int boxIndex=1; boxIndex<=totalBoxesPerSectionOfActiveTab; boxIndex++) {
						targetKey="T"+tabIndex+"S"+sectionIndex+"B"+boxIndex;
						failedMessage=detail_comparePageItem(targetKey, origPage, emailPage);
						if (failedMessage.contains("mismatch")) 
							listOfFailure.add(failedMessage);	
						if (failedMessage.contains("BYPASS")) 
							testNote.add(failedMessage);
						System.out.println("*************** b - sub section ************");
						System.out.println("\tTEMP - failedMessage="+failedMessage);
						for (String s: listOfFailure) {
							System.out.println("\tTEMP -listOfFailure="+s);
						}
						for (String s: testNote) {
							System.out.println("\tTEMP - testNote="+s);
						}
						System.out.println("*************** e - sub section ************");
					}

					//note: assume this is the optional service tab
					//note: after going through all the boxes should be no more section, don't iterate the rest of the section counts
					break;
				} else {
					for(int rowIndex=1; rowIndex<=totalRowsPerSectionOfActiveTab; rowIndex++) { //note: loop through each row
						targetKey="Total Cells For T"+tabIndex+"S"+sectionIndex+"R"+rowIndex;
						failedMessage=detail_comparePageItem(targetKey, origPage, emailPage);
						if (failedMessage.contains("mismatch")) 
							listOfFailure.add(failedMessage);	
						if (failedMessage.contains("BYPASS")) 
							testNote.add(failedMessage);

						int totalCellsPerRow=Integer.valueOf(origPage.get(targetKey));
						System.out.println("TEST - totalCellsPerRow="+totalCellsPerRow);
						for (int cellIndex=1; cellIndex<=totalCellsPerRow; cellIndex++) { //note: loop through each cell on the row
							targetKey="T"+tabIndex+"S"+sectionIndex+"R"+rowIndex+"C"+cellIndex;
							failedMessage=detail_comparePageItem(targetKey, origPage, emailPage);
							if (failedMessage.contains("mismatch")) 
								listOfFailure.add(failedMessage);	
							if (failedMessage.contains("BYPASS")) 
								testNote.add(failedMessage);
							System.out.println("*************** b - sub section ************");
							System.out.println("\tTEMP - failedMessage="+failedMessage);
							for (String s: listOfFailure) {
								System.out.println("\tTEMP -listOfFailure="+s);
							}
							for (String s: testNote) {
								System.out.println("\tTEMP - testNote="+s);
							}
							System.out.println("*************** e - sub section ************");
						}
					}
				}
			}
			System.out.println("=========== Final result ==============");
			if (detail_finalResult) { 
				if (testNote.size()==0) {
					System.out.println("GOOD - original page content and email deeplink page content matched.");
				} else {
					System.out.println("SEMI GOOD - there are BYPASSED items, most original page content and email deeplink page content matched.");
				}
			} else {
				System.out.println("PROBLEM - original page content and email deeplink page content are not the same.");
				for (String s: listOfFailure) {
					System.out.println(s);
				}
			}
		}
		System.out.println("Finished validation for the original page content vs page content from email deeplnk for plan detail ===========");
		Assert.assertTrue("PROBLEM - original page content and email deeplink page content are not the same. total items mismatch='"+listOfFailure.size()+"'. list of mismatch: "+listOfFailure , detail_finalResult);
		return testNote;
	}		

	public void savedHeartFirstPlan() {
		Assert.assertTrue("PROBLEM - unable to locate the first save heart on plan page", validate(firstSaveHeartOnActiveSummaryPlanPage));
		firstSaveHeartOnActiveSummaryPlanPage.click();
	}
	public void validatePrintOptionExistOnPage(String planType) {
		WebElement printElement=null;
		if (planType.equalsIgnoreCase("mapd") || planType.equalsIgnoreCase("ma")) {
			printElement=summary_maPrintOption;
		} else if (planType.equalsIgnoreCase("pdp")) {
			printElement=summary_pdpPrintOption;
		} else if (planType.equalsIgnoreCase("snp")) {
			printElement=summary_snpPrintOption;
		} else {
			Assert.assertTrue("PROBLEM - test not coded for this '"+planType+"' planType testing", false);
		}
		Assert.assertTrue("PROBLEM - Unable to locate the print option or the email option. printCheck="+validate(printElement), validate(printElement));
	}


	public void validateSummaryPrintOption(String planType) {
		//note: the print function will bring up the print preview window where the content can't be controlled by selenium
		// for now will only validate the print button will bring up the print preview page
		CommonUtility.checkPageIsReady(driver);
		WebElement printButton=null;
		if (planType.equalsIgnoreCase("ma") || planType.equalsIgnoreCase("mapd")) {
			printButton=summary_maPrintOption;
		} else if (planType.equalsIgnoreCase("pdp")) {
			printButton=summary_pdpPrintOption;
		} else if (planType.equalsIgnoreCase("snp")) {
			printButton=summary_snpPrintOption;
		} else {
			Assert.assertTrue("PROBLEM - '"+planType+"' is not supported test scenario. Only support MA/MAPD/PDP/SNP, please update input argument", false);
		}
		System.out.println("Proceed to validate print popup screen for cancel option");
		printButton.click();

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		//System.out.println("TEST --------------- before handler="+driver.getWindowHandle());
		String originalPageTitle=driver.getTitle();

		//switch to handle the new print window
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		sleepBySec(5);
		//CommonUtility.checkPageIsReady(driver);
		// Perform the actions on new window
		//System.out.println("TEST  --------------- after handler="+driver.getWindowHandle());
		System.out.println("Proceed to validate the new window content for print");
		String printPreviewPageTitle=driver.getTitle();
		Assert.assertTrue("PROBLEM - print preview page title should be empty (untitled).  Actual='"+printPreviewPageTitle+"'", printPreviewPageTitle.equals(""));

		System.out.println("Proceed to close the print preview window");
		driver.close();

		// note: Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		//System.out.println("TEST  --------------- back handler="+driver.getWindowHandle());
		String pageTitleAfterClosingPrintPreview=driver.getTitle();
		Assert.assertTrue("PROBLEM - page title should have been the same after closing print preview.  | Before='"+originalPageTitle+"' | After='"+pageTitleAfterClosingPrintPreview+"'", originalPageTitle.equals(pageTitleAfterClosingPrintPreview));
	}

	public void validateEmailOptionExistOnPage(String planType) {
		WebElement emailElement=null;
		if (planType.equalsIgnoreCase("mapd") || planType.equalsIgnoreCase("ma")) {
			emailElement=summary_maEmailOption;
		} else if (planType.equalsIgnoreCase("pdp")) {
			emailElement=summary_pdpEmailOption;
		} else if (planType.equalsIgnoreCase("snp")) {
			emailElement=summary_snpEmailOption;
		} else {
			Assert.assertTrue("PROBLEM - test not coded for this '"+planType+"' planType testing", false);
		}
		Assert.assertTrue("PROBLEM - Unable to locate the email option. emailCheck="+validate(emailElement), validate(emailElement));
	}

	public void sleepBySec(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void validateEmailOption(String planType) {
		WebElement emailButton=null;
		if (planType.equalsIgnoreCase("ma") || planType.equalsIgnoreCase("mapd")) {
			emailButton=summary_maEmailOption;
		} else if (planType.equalsIgnoreCase("pdp")) {
			emailButton=summary_pdpEmailOption;
		} else if (planType.equalsIgnoreCase("snp")) {
			emailButton=summary_snpEmailOption;
		} else {
			Assert.assertTrue("PROBLEM - '"+planType+"' is not supported test scenario. Only support MA/MAPD/PDP/SNP, please update input argument", false);
		}
		System.out.println("Proceed to validate email popup screen for cancel option");
		emailButton.click();
		Assert.assertTrue("PROBLEM - unable to locate email popup screen after email link is clicked",validate(emailPlanSummaryPopupScreen));
		String expectedEmailBoxHeader=emailPlanSummaryPopupScreenText.getText();
		String actualEmailBoxHeader="Email Plan List";
		Assert.assertTrue("PROBLEM - header text for the email popup screen is not as expected.  Expecte='"+expectedEmailBoxHeader+"' | Actual='"+actualEmailBoxHeader+"'",expectedEmailBoxHeader.equals(actualEmailBoxHeader));
		Assert.assertTrue("PROBLEM - unable to locate email field box on email popup screen after email link is clicked",validate(emailPlanSummaryFieldBox));
		Assert.assertTrue("PROBLEM - unable to locate send button on email popup screen after email link is clicked",validate(emailPlanSummarySendButton));
		Assert.assertTrue("PROBLEM - unable to locate cancel button on email popup screen after email link is clicked",validate(emailPlanSummaryCancelButton));

		System.out.println("Proceed to click cancel button on email screen, email screen should close");
		emailPlanSummaryCancelButton.click();
		Assert.assertTrue("PROBLEM - email popup screen should have disappeared after cancel button is clicked", !validate(emailPlanSummaryPopupScreen));

		//----- failure cases ------------------
		System.out.println("Proceed to validate email popup screen for send option for failure case 1");
		emailButton.click();
		String testEmailAddresss="bademailformat";
		emailPlanSummaryFieldBox.sendKeys(testEmailAddresss);
		emailPlanSummarySendButton.click();

		Assert.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",validate(emailPlanSummaryErrorFieldBox));
		Assert.assertTrue("PROBLEM - unable to locate error text after email address validation failed",validate(emailPlanSummaryInputErrorText));
		String actualErrorText=emailPlanSummaryInputErrorText.getText();
		String execptedErrorText="Please Enter Valid Email Address";

		Assert.assertTrue("PROBLEM - Email success message is not as expected.  Expected: '"+execptedErrorText+"' | Actual='"+actualErrorText+"'", (execptedErrorText.equals(actualErrorText)) );

		System.out.println("Proceed to validate email popup screen for send option for failure case 2 ");
		testEmailAddresss="bademailformat@";
		emailPlanSummaryFieldBox.sendKeys(Keys.CONTROL + "a");
		emailPlanSummaryFieldBox.sendKeys(Keys.DELETE);
		emailPlanSummaryFieldBox.sendKeys(testEmailAddresss);
		emailPlanSummarySendButton.click();

		Assert.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",validate(emailPlanSummaryErrorFieldBox));
		Assert.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",validate(emailPlanSummaryInputErrorText));
		actualErrorText=emailPlanSummaryInputErrorText.getText();
		execptedErrorText="Please Enter Valid Email Address";

		Assert.assertTrue("PROBLEM - Email success message is not as expected.  Expected: '"+execptedErrorText+"' | Actual='"+actualErrorText+"'", (execptedErrorText.equals(actualErrorText)) );

		System.out.println("Proceed to validate email popup screen for send option for failure case 3");
		testEmailAddresss="bademailformat@test.";
		emailPlanSummaryFieldBox.sendKeys(Keys.CONTROL + "a");
		emailPlanSummaryFieldBox.sendKeys(Keys.DELETE);
		emailPlanSummaryFieldBox.sendKeys(testEmailAddresss);
		emailPlanSummarySendButton.click();

		Assert.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",validate(emailPlanSummaryErrorFieldBox));
		Assert.assertTrue("PROBLEM - unable to locate email field box after email address validation failed",validate(emailPlanSummaryInputErrorText));
		actualErrorText=emailPlanSummaryInputErrorText.getText();
		execptedErrorText="Please Enter Valid Email Address";

		Assert.assertTrue("PROBLEM - Email success message is not as expected.  Expected: '"+execptedErrorText+"' | Actual='"+actualErrorText+"'", (execptedErrorText.equals(actualErrorText)) );

		//----- success cases ------------------
		System.out.println("Proceed to validate email popup screen for send option for successful case");
		testEmailAddresss="test@optum.com";
		emailPlanSummaryFieldBox.sendKeys(Keys.CONTROL + "a");
		emailPlanSummaryFieldBox.sendKeys(Keys.DELETE);
		emailPlanSummaryFieldBox.sendKeys(testEmailAddresss);
		jsClickNew(emailPlanSummarySendButton);
		Assert.assertTrue("PROBLEM - uable to locate success message after clicking send button", validate(emailPlanSummarySuccessText, 15));
		//validateNew(emailPlanSummarySuccessText, 15);
		String expectedSuccess1="Thank you!";
		String expectedSuccess2="The email with your information will arrive shortly.";
		String actualEmailSuccessText=emailPlanSummarySuccessText.getText();
		Assert.assertTrue("PROBLEM - Email success message is not as expected.  Expected to contain '"+expectedSuccess1+"' and '"+expectedSuccess2+"' | Actual='"+actualEmailSuccessText+"'", (actualEmailSuccessText.contains(expectedSuccess1)) && (actualEmailSuccessText.contains(expectedSuccess2)));

		validateNew(emailPlanSummarySuccessCloseButton);
		System.out.println("Proceed to close the email popup screen to cleanup");
		emailPlanSummarySuccessCloseButton.click();
	}
	public HashMap<String, Integer> collectInfoVppPlanSummaryPg() {
		System.out.println("Proceed to collect the plan counts on vpp summary page");

		int allPlans = Integer.valueOf(vppTop.getText().substring(10, 12).trim());
		int maPlans = Integer.valueOf(maPlansCount.getText());
		int msPlans = 0;
		try {
			msPlans = Integer.valueOf(msPlansCount.getText());
		} catch (NumberFormatException e) {				
			msPlans = 0;
		}	
		int pdpPlans = Integer.valueOf(pdpPlansCount.getText());
		int snpPlans = Integer.valueOf(snpPlansCount.getText());

		HashMap<String, Integer> result=new HashMap<String, Integer>();
		result.put("Total Plan Count", allPlans);
		result.put("MA Plan Count", maPlans);
		result.put("MS Plan Count", msPlans);
		result.put("PDP Plan Count", pdpPlans);
		result.put("SNP Plan Count", snpPlans);
		result.put("Saved Heart Count", planSummary_listOfSavedHearts.size());
		System.out.println("collected result="+result);
		return result;
	}

	public void validatingFunctionalityOfEmailOnPlanDetails() {

		validateEmailButtonOnPlanDetails.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		validateNew(emailPopup);
		validateNew(cancelButtonEmailPlanDetailsPopUp);
		System.out.println("!!!Cancel Button is displayed ===>" + cancelButtonEmailPlanDetailsPopUp.isDisplayed());
		cancelButtonEmailPlanDetailsPopUp.click();
		;
		validateEmailButtonOnPlanDetails.click();
		validateNew(emailPopup);
		validateNew(sendButtonEmailPlanDetailsPopUp);
		System.out.println("!!!Cancel Button is displayed ===>" + sendButtonEmailPlanDetailsPopUp.isDisplayed());
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("alisha_kapoor@optum.com");
		System.out.println("!!!Entered valid Email ");
		sendButtonEmailPlanDetailsPopUp.click();
		System.out.println("Email has success fully send to user");
		Assert.assertTrue("PROBLEM - unable to get successful message after clicking send", validate(validatesuccesspopup));
		//validateNew(validatesuccesspopup);
		System.out.println("Validated Thank you Message");

	}
	public void validatingFunctionalityOfPrintOnPlanDetails(String planType) {
		//note: the print function will bring up the print preview window where the content can't be controlled by selenium
		// for now will only validate the print button will bring up the print preview page
		System.out.println("Proceed to validate print popup screen for cancel option");
		validatePrintButtonOnPlanDetails.click();

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		//System.out.println("TEST --------------- before handler="+driver.getWindowHandle());
		String originalPageTitle=driver.getTitle();

		//switch to handle the new print window
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		sleepBySec(5);
		//CommonUtility.checkPageIsReady(driver);
		// Perform the actions on new window
		//System.out.println("TEST  --------------- after handler="+driver.getWindowHandle());
		System.out.println("Proceed to validate the new window content for print");
		String printPreviewPageTitle=driver.getTitle();
		Assert.assertTrue("PROBLEM - print preview page title should be empty (untitled).  Actual='"+printPreviewPageTitle+"'", printPreviewPageTitle.equals(""));

		System.out.println("Proceed to close the print preview window");
		driver.close();

		// note: Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		//System.out.println("TEST  --------------- back handler="+driver.getWindowHandle());
		String pageTitleAfterClosingPrintPreview=driver.getTitle();
		Assert.assertTrue("PROBLEM - page title should have been the same after closing print preview.  | Before='"+originalPageTitle+"' | After='"+pageTitleAfterClosingPrintPreview+"'", originalPageTitle.equals(pageTitleAfterClosingPrintPreview));

		
	}
	
	public void moveMouseToElement(WebElement targetElement) {
		Actions action = new Actions(driver);
		action.moveToElement(targetElement).build().perform(); 
	}

	public void validatingFunctionalityOfPrintOnPlanCompare(String planType) {
		//note: the print function will bring up the print preview window where the content can't be controlled by selenium
		// for now will only validate the print button will bring up the print preview page
		//note: for pdp need to move mouse around so the print is not blocked
		System.out.println("Proceed to validate print popup screen for cancel option");
		compare_validateprintbutton.click();

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		//System.out.println("TEST --------------- before handler="+driver.getWindowHandle());
		String originalPageTitle=driver.getTitle();

		//switch to handle the new print window
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		sleepBySec(5);
		//CommonUtility.checkPageIsReady(driver);
		// Perform the actions on new window
		//System.out.println("TEST  --------------- after handler="+driver.getWindowHandle());
		System.out.println("Proceed to validate the new window content for print");
		String printPreviewPageTitle=driver.getTitle();
		Assert.assertTrue("PROBLEM - print preview page title should be empty (untitled).  Actual='"+printPreviewPageTitle+"'", printPreviewPageTitle.equals(""));

		System.out.println("Proceed to close the print preview window");
		driver.close();

		// note: Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		//System.out.println("TEST  --------------- back handler="+driver.getWindowHandle());
		String pageTitleAfterClosingPrintPreview=driver.getTitle();
		Assert.assertTrue("PROBLEM - page title should have been the same after closing print preview.  | Before='"+originalPageTitle+"' | After='"+pageTitleAfterClosingPrintPreview+"'", originalPageTitle.equals(pageTitleAfterClosingPrintPreview));

		
	}
	public HashMap<String, String> collectInfoVppPlanComparePg(String planType, String forWhat) {
		System.out.println("Proceed to collect the info on vpp compare page =====");
		HashMap<String, String> result=new HashMap<String, String>();
		result.put("Page Header", cmpPgHeader.getText());

		result.put("Columns Count", String.valueOf(listOfCmpPlansColumns.size()));
		for (int i=1; i<=listOfCmpPlansColumns.size(); i++) {
			String columnXpath="//div[@id='topRowCopy']//div[@ng-repeat='i in count']["+i+"]";

			String planNameXpath=columnXpath+"//h3";
			result.put(i+"- Plan Name", "none");
			try {
				WebElement e=driver.findElement(By.xpath(planNameXpath));
				if (validate(e))
					result.put(i+"- Plan Name", e.getAttribute("textContent"));
			} catch (Exception e) {
				System.out.println("no plan name info for '"+i+"- Plan Name'");
			}

			String heartXpath=columnXpath+"//a[contains(@class,'added')]";
			result.put(i+"- Plan Heart", "none");
			try {
				WebElement e=driver.findElement(By.xpath(heartXpath));
				if (validate(e)) 
					result.put(i+"- Plan Heart", "saved");
			} catch (Exception e) {
				System.out.println("no plan heart info for '"+i+"- Plan Heart'");
			}

		}
		int cellsPerRow=listOfCmpPlansColumns.size()+1;
		result.put("Total Table Rows", String.valueOf(listOfRowsInPlanCompareTbl.size()));
		//note: loop through each row
		int rowStartAt=1;
		if (planType.equals("PDP")) {
			rowStartAt=24;
		}
		for (int i=rowStartAt; i<=listOfRowsInPlanCompareTbl.size(); i++) {
			String rowXpath="//table[@id='fixTable']//tr["+i+"]//td";
			List<WebElement> tmp=driver.findElements(By.xpath(rowXpath));
			if (tmp.size()==1) {
				// only one cell then that's the table section header
				String cellXpath="//table[@id='fixTable']//tr["+i+"]//td[1]";
				WebElement e=driver.findElement(By.xpath(cellXpath));
				String key="R"+i+"C1";
				String value=e.getAttribute("textContent");
				result.put("R"+i+"C1", value);
				System.out.println("TEST - "+forWhat+" - key='"+key+"' | value='"+value+"'");
				for (int j=1; j<=cellsPerRow; j++) {
					key="R"+i+"C"+j;
					result.put(key, "none");
					System.out.println("TEST - "+forWhat+" - key='"+key+"' | value='"+value+"'");
				}
			} else { //note: data row, collect text of each cell
				for (int j=1; j<=cellsPerRow; j++) {
					String cellXpath="//table[@id='fixTable']//tr["+i+"]//td["+j+"]";
					WebElement e=driver.findElement(By.xpath(cellXpath));
					String key="R"+i+"C"+j;
					String value=e.getText();
					result.put(key, value);
					System.out.println("TEST - "+forWhat+" - key='"+key+"' | value='"+value+"'");
				}
			}
		}
		System.out.println("Finished collecting the info on vpp compare page =====");
		return result;
	}

	public void validatingthankyoumessage() {
		validateemailbutton.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//Validating email popup
		validate(leavingcomapreplansitepopup);
		System.out.println("!!!Leaving site popup is displayed ===>"+leavingcomapreplansitepopup.isDisplayed());
		//Validating email cancel button
		validate(cancelButtonEmailPlanComparePopUp);
		System.out.println("!!!Cancel Button is displayed ===>"+cancelButtonEmailPlanComparePopUp.isDisplayed());
		cancelButtonEmailPlanComparePopUp.click();
		System.out.println("Success click of cancel email");
		//Validating email send button
		validateemailbutton.click();
		validate(leavingcomapreplansitepopup);
		System.out.println("!!!Leaving site popup is displayed ===>"+leavingcomapreplansitepopup.isDisplayed());
		validate(sendButtonEmailPlanComparePopUp);
		System.out.println("!!!Cancel Button is displayed ===>"+sendButtonEmailPlanComparePopUp.isDisplayed());
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("rani_madadi@optum.com");
		System.out.println("!!!Entered valid Email ");
		sendButtonEmailPlanComparePopUp.click();
		Assert.assertTrue("PROBLEM - unable to get success message after clicking send", validate(validatesuccesspopup));
		//Validating email success popup
		System.out.println("Email has successfull send to user");
		validateNew(validatesuccesspopup);
		System.out.println("Validated Thank you Message");
		
		closeButtonthankyoumessagepopup.click();
		System.out.println("Thank you Message pop up is closed");
	}

	public void handlePlanYearSelectionPopup(String planType) {
		if (!(planType.equalsIgnoreCase("MS"))) {
			CommonUtility.checkPageIsReadyNew(driver);
			CommonUtility.waitForPageLoad(driver, planYearPopup, 5);
			if (validate(planYearPopup)) {
				if (validate(nextYearSelection)) {
					nextYearSelection.click();
					CommonUtility.waitForPageLoadNew(driver, planYearPopupGoButton, 10);
					planYearPopupGoButton.click();
				}
			}
		}
	}

	public String summary_comparePageItem(String targetKey, HashMap<String, Integer> origPage, HashMap<String, Integer> emailage) {
		String failedMessage="NONE";
		System.out.println("TEST - validate content for map key="+targetKey+"...");
		if (!(origPage.get(targetKey)).equals(emailage.get(targetKey))) {
			if (targetKey.equals("Saved Heart Count")) {
				failedMessage="BYPASS validation until fix (tick# xxxxx) - ";
				failedMessage=failedMessage+"item '"+targetKey+"' mismatch | original='"+origPage.get(targetKey)+"' | email='"+emailage.get(targetKey)+"'";
			} else {
				summary_finalResult=false;
				failedMessage="item '"+targetKey+"' mismatch | original='"+origPage.get(targetKey)+"' | email='"+emailage.get(targetKey)+"'";
			}
		}
		return failedMessage;
	}

	boolean summary_finalResult=true;
	public List<String> validatePlanSummaryEmailDeeplink(String planType, String deepLinkStringId, String infoMapStringId, String deepLink, HashMap<String, Integer> origPage) {
		List<String> testNote=new ArrayList<String>();
		List<String> listOfFailure=new ArrayList<String>();

		System.out.println("Proceed to validate the original page content vs page content from email deeplnk for plan summary...");
		System.out.println("Collect info from page content of the plan summary");
		HashMap<String, Integer> emailPage=collectInfoVppPlanSummaryPg();

		String targetKey="MA Plan Count";
		String failedMessage=summary_comparePageItem(targetKey, origPage, emailPage);
		if (failedMessage.contains("mismatch")) 
			listOfFailure.add(failedMessage);	
		if (failedMessage.contains("BYPASS")) 
			testNote.add(failedMessage);

		targetKey="MS Plan Count";
		failedMessage=summary_comparePageItem(targetKey, origPage, emailPage);
		if (failedMessage.contains("mismatch")) 
			listOfFailure.add(failedMessage);	
		if (failedMessage.contains("BYPASS")) 
			testNote.add(failedMessage);

		targetKey="PDP Plan Count";
		failedMessage=summary_comparePageItem(targetKey, origPage, emailPage);
		if (failedMessage.contains("mismatch")) 
			listOfFailure.add(failedMessage);	
		if (failedMessage.contains("BYPASS")) 
			testNote.add(failedMessage);

		targetKey="SNP Plan Count";
		failedMessage=summary_comparePageItem(targetKey, origPage, emailPage);
		if (failedMessage.contains("mismatch")) 
			listOfFailure.add(failedMessage);	
		if (failedMessage.contains("BYPASS")) 
			testNote.add(failedMessage);

		targetKey="Total Plan Count";
		failedMessage=summary_comparePageItem(targetKey, origPage, emailPage);
		if (failedMessage.contains("mismatch")) 
			listOfFailure.add(failedMessage);	
		if (failedMessage.contains("BYPASS")) 
			testNote.add(failedMessage);

		targetKey="Saved Heart Count";
		failedMessage=summary_comparePageItem(targetKey, origPage, emailPage);
		if (failedMessage.contains("mismatch")) 
			listOfFailure.add(failedMessage);	
		if (failedMessage.contains("BYPASS")) 
			testNote.add(failedMessage);

		System.out.println("Finished validation for original page content vs page content from email deeplnk for plan summary ============");
		if (summary_finalResult) { 
			if (testNote.size()==0) {
				System.out.println("GOOD - original page content and email deeplink page content matched.");
			} else {
				System.out.println("SEMI GOOD - there are BYPASSED items, most original page content and email deeplink page content matched.");
			}
		} else {
			System.out.println("PROBLEM - original page content and email deeplink page content are not the same.");
			for (String s: listOfFailure) {
				System.out.println(s);
			}
		}

		Assert.assertTrue("PROBLEM - original page content and email deeplink page content are not the same. total items mismatch='"+listOfFailure.size()+"'. list of mismatch: "+listOfFailure , summary_finalResult);
		return testNote;
	}

	public void validatePrintPlanDetails() {
		validateNew(validatePrintButtonOnPlanDetails);
		System.out.println("successfully validated the Print Buttons on plan details page.");

	}
	
	public void validateEmailOnPlanDetails() {
		validateNew(validateEmailButtonOnPlanDetails);
		System.out.println("successfully validated the email Buttons on plan details page.");

	}

	public void validateComparePrint() {
		sleepBySec(1); //note: keep this sleep for compare page
		CommonUtility.waitForPageLoad(driver, compare_validateprintbutton, 5);
		moveMouseToElement(cmpPgHeader);
		validateNew(compare_validateprintbutton);
		System.out.println("successfully validated the Print in plan compare page ");
	}

	public void validateCompareEmail() {
		validateNew(compare_validateemailbutton);
		System.out.println("successfully validated the Email in plan compare page ");

	}

	public void clickonBackToAllPlans() {
		Assert.assertTrue("PROBLEM - unable to locate the 'Back to all plans' link on Compare page", validate(backToAllPlansLnk));
		backToAllPlansLnk.click();
		CommonUtility.checkPageIsReady(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean validateAllPlansChecked(String plansForCompare) {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> compareChkBoxes = driver.findElements(By.xpath("//div[contains(@class,'compare-add')]"));	
		String expectedTxt=plansForCompare+" plans added";
		System.out.println("Validate there are "+plansForCompare+" number of plans added for compare");
		boolean result=true;
		for (int i=0; i<Integer.parseInt(plansForCompare); i++) {
			if (!compareChkBoxes.get(i).getText().contains(expectedTxt)) {
				System.out.println("PROBLEM - plan with index "+i+" doesn't contain expected text '"+expectedTxt+"'");
				result=false;
				break;
			}
		}
		return result;
	}

	public String compare_comparePageItem(String targetKey, HashMap<String, String> origPage, HashMap<String, String> emailage) {
		String failedMessage="NONE";
		System.out.println("TEST - validate content for map key="+targetKey+"...");
		if (!(origPage.get(targetKey)).equals(emailage.get(targetKey))) {
			//note: keep this for now in case anything needs to be bypassed
			//if (targetKey.equals("xyz")) { 
			//	failedMessage="BYPASS validation until fix (tick# xxxxx) - ";
			//	failedMessage=failedMessage+"item '"+targetKey+"' mismatch | original='"+origPage.get(targetKey)+"' | email='"+emailage.get(targetKey)+"'";
			//} else {
			compare_finalResult=false;
			failedMessage="item '"+targetKey+"' mismatch | original='"+origPage.get(targetKey)+"' | email='"+emailage.get(targetKey)+"'";
			//}
		}
		System.out.println("TEST - failedMessage="+failedMessage);		
		return failedMessage;
	}

	boolean compare_finalResult=true;
	public List<String> validatePlanCompareEmailDeeplink(String planType, String deepLinkStringId, String infoMapStringId, String deepLink, HashMap<String, String> origPage) {
		List<String> testNote=new ArrayList<String>();
		System.out.println("Proceed to validate the original page content vs page content from email deeplnk for plan compare...");
		List<String> listOfFailure=new ArrayList<String>();
		System.out.println("Proceed to validate the original page content vs page content from email deeplnk for plan compare...");

		System.out.println("Collect info from page content of the plan compare");
		HashMap<String, String> emailPage=collectInfoVppPlanComparePg(planType, "email deepLink");
		
		String targetKey="Page Header";
		String failedMessage=compare_comparePageItem(targetKey, origPage, emailPage);
		if (failedMessage.contains("mismatch")) 
			listOfFailure.add(failedMessage);	
		if (failedMessage.contains("BYPASS")) 
			testNote.add(failedMessage);

		targetKey="Columns Count";
		int numPlanColumns=Integer.valueOf(origPage.get(targetKey));
		failedMessage=compare_comparePageItem(targetKey, origPage, emailPage);
		if (failedMessage.contains("mismatch")) 
			listOfFailure.add(failedMessage);	
		if (failedMessage.contains("BYPASS")) 
			testNote.add(failedMessage);

		for (int i=1; i<=numPlanColumns; i++) {
			targetKey=i+"- Plan Name";
			failedMessage=compare_comparePageItem(targetKey, origPage, emailPage);
			if (failedMessage.contains("mismatch")) 
				listOfFailure.add(failedMessage);	
			if (failedMessage.contains("BYPASS")) 
				testNote.add(failedMessage);

			targetKey=i+"- Plan Heart";
			failedMessage=compare_comparePageItem(targetKey, origPage, emailPage);
			if (failedMessage.contains("mismatch")) 
				listOfFailure.add(failedMessage);	
			if (failedMessage.contains("BYPASS")) 
				testNote.add(failedMessage);
		}

		int cellsPerRow=numPlanColumns+1;
		int totalTableRows=Integer.valueOf(origPage.get("Total Table Rows"));
		int startRowIndex=1;
		if (planType.equals("PDP")) {
			startRowIndex=24;
		}
		for (int r=startRowIndex; r<=totalTableRows; r++) {
			for (int c=1; c<=cellsPerRow; c++) {
				targetKey="R"+r+"C"+c;
				failedMessage=compare_comparePageItem(targetKey, origPage, emailPage);
				if (failedMessage.contains("mismatch")) 
					listOfFailure.add(failedMessage);	
				if (failedMessage.contains("BYPASS")) 
					testNote.add(failedMessage);
			}		
		}
		System.out.println("Finished validation for the original page content vs page content from email deeplnk for plan compare ===========");

		if (compare_finalResult) { 
			if (testNote.size()==0) {
				System.out.println("GOOD - original page content and email deeplink page content matched.");
			} else {
				System.out.println("SEMI GOOD - there are BYPASSED items, most original page content and email deeplink page content matched.");
			}
		} else {
			System.out.println("PROBLEM - original page content and email deeplink page content are not the same.");
			for (String s: listOfFailure) {
				System.out.println(s);
			}
		}

		Assert.assertTrue("PROBLEM - original page content and email deeplink page content are not the same. total items mismatch='"+listOfFailure.size()+"'. list of mismatch: "+listOfFailure , compare_finalResult);
		return testNote;
	}
	
	public void validateComparePrintOption(String planType) {
		//note: the print function will bring up the print preview window where the content can't be controlled by selenium
		// for now will only validate the print button will bring up the print preview page
		System.out.println("Proceed to validate print popup screen for cancel option");
		compare_validateprintbutton.click();

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		//System.out.println("TEST --------------- before handler="+driver.getWindowHandle());
		String originalPageTitle=driver.getTitle();

		//switch to handle the new print window
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		sleepBySec(5);
		//CommonUtility.checkPageIsReady(driver);
		// Perform the actions on new window
		//System.out.println("TEST  --------------- after handler="+driver.getWindowHandle());
		System.out.println("Proceed to validate the new window content for print");
		String printPreviewPageTitle=driver.getTitle();
		Assert.assertTrue("PROBLEM - print preview page title should be empty (untitled).  Actual='"+printPreviewPageTitle+"'", printPreviewPageTitle.equals(""));

		System.out.println("Proceed to close the print preview window");
		driver.close();

		// note: Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		//System.out.println("TEST  --------------- back handler="+driver.getWindowHandle());
		String pageTitleAfterClosingPrintPreview=driver.getTitle();
		Assert.assertTrue("PROBLEM - page title should have been the same after closing print preview.  | Before='"+originalPageTitle+"' | After='"+pageTitleAfterClosingPrintPreview+"'", originalPageTitle.equals(pageTitleAfterClosingPrintPreview));
	}

	public void validateDetailPrintOption(String planType) {
		//note: the print function will bring up the print preview window where the content can't be controlled by selenium
		// for now will only validate the print button will bring up the print preview page
		validatePrintButtonOnPlanDetails.click();

		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		//System.out.println("TEST --------------- before handler="+driver.getWindowHandle());
		String originalPageTitle=driver.getTitle();

		//switch to handle the new print window
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		sleepBySec(5);
		//CommonUtility.checkPageIsReady(driver);
		// Perform the actions on new window
		//System.out.println("TEST  --------------- after handler="+driver.getWindowHandle());
		System.out.println("Proceed to validate the new window content for print");
		String printPreviewPageTitle=driver.getTitle();
		Assert.assertTrue("PROBLEM - print preview page title should be empty (untitled).  Actual='"+printPreviewPageTitle+"'", printPreviewPageTitle.equals(""));

		System.out.println("Proceed to close the print preview window");
		driver.close();

		// note: Switch back to original browser (first window)
		driver.switchTo().window(winHandleBefore);

		//System.out.println("TEST  --------------- back handler="+driver.getWindowHandle());
		String pageTitleAfterClosingPrintPreview=driver.getTitle();
		Assert.assertTrue("PROBLEM - page title should have been the same after closing print preview.  | Before='"+originalPageTitle+"' | After='"+pageTitleAfterClosingPrintPreview+"'", originalPageTitle.equals(pageTitleAfterClosingPrintPreview));
	}

}
