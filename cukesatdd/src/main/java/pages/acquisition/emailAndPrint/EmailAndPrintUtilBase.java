package pages.acquisition.emailAndPrint;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.util.CommonUtility;

public class EmailAndPrintUtilBase extends EmailAndPrintUtilWebElements{

	public EmailAndPrintUtilBase(WebDriver driver) {
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

	public void savedHeartFirstPlanOnSummaryPage() {
		Assert.assertTrue("PROBLEM - unable to locate the first save heart on plan page", validate(firstSaveHeartOnActiveSummaryPlanPage));
		firstSaveHeartOnActiveSummaryPlanPage.click();
	}
	
	public void validatePrintOptionExistOnSummaryPage(String planType) {
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

	public void sleepBySec(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void moveMouseToElement(WebElement targetElement) {
		Actions action = new Actions(driver);
		action.moveToElement(targetElement).build().perform(); 
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

	public void validatePrintOptionOnPage(String pageType, String planType) {
		//note: the print function will bring up the print preview window where the content can't be controlled by selenium
		// for now will only validate the print button will bring up the print preview page
		CommonUtility.checkPageIsReady(driver);
		int numWinHandleBefore=driver.getWindowHandles().size();
		String winHandleBefore = driver.getWindowHandle();
		String originalPageTitle=driver.getTitle();
		System.out.println("Current title: "+driver.getTitle());
		if (pageType.equalsIgnoreCase("summary")) {
			WebElement summary_printButton=null;
			if (planType.equalsIgnoreCase("ma") || planType.equalsIgnoreCase("mapd")) {
				summary_printButton=summary_maPrintOption;
			} else if (planType.equalsIgnoreCase("pdp")) {
				summary_printButton=summary_pdpPrintOption;
			} else if (planType.equalsIgnoreCase("snp")) {
				summary_printButton=summary_snpPrintOption;
			} else {
				Assert.assertTrue("PROBLEM - '"+planType+"' is not supported test scenario. Only support MA/MAPD/PDP/SNP, please update input argument", false);
			}
			summary_printButton.click();
		} else if (pageType.equalsIgnoreCase("compare")) {
			compare_validateprintbutton.click();
		} else if (pageType.equalsIgnoreCase("detail")) {
			validatePrintButtonOnPlanDetails.click();
		} else {
			Assert.assertTrue("PROBLEM - need to code Print Option for this page type: "+pageType, false);
		}
		CommonUtility.checkPageIsReady(driver);
		int numWinHandleAfter=driver.getWindowHandles().size();
		//note: Store the current window handle
		Assert.assertTrue("PROBLEM - Print window was never opened after the click",numWinHandleAfter-numWinHandleBefore==1);
		boolean flag = false;// flag will be used to determine a new window was opened after the click of print button
		//note: switch to handle the new print window
		for(String winHandle : driver.getWindowHandles()){
			if(!winHandle.equals(winHandleBefore))
	          {
				driver.switchTo().window(winHandle);
				driver.close();
				driver.switchTo().window(winHandleBefore);
	          }
		}
		//note: keep for the print page to load
		//CommonUtility.checkPageIsReady(driver);
		// Perform the actions on new window
		//System.out.println("TEST  --------------- after handler="+driver.getWindowHandle());

		// note: Switch back to original browser (first window)
		//System.out.println("TEST  --------------- back handler="+driver.getWindowHandle());
		String pageTitleAfterClosingPrintPreview=driver.getTitle();
		Assert.assertTrue("PROBLEM - page title should have been the same after closing print preview.  | Before='"+originalPageTitle+"' | After='"+pageTitleAfterClosingPrintPreview+"'", originalPageTitle.equals(pageTitleAfterClosingPrintPreview));
	}
	
	/** 
	 * Need to keep the original sesson on sauce lab alive by refreshing the page
	 * TODO - look into custom extending the sauce lab session
	 * @param sessionFrom
	 * @param targetDriver
	 */
	public void keepSessionAlive(String sessionFrom, WebDriver targetDriver) {
		if (sessionFrom.equals("from deepLink"))
			targetDriver.navigate().refresh();
	}

}
