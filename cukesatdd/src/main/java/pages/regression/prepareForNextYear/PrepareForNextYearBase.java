package pages.regression.prepareForNextYear;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.html5.RemoteWebStorage;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;

public class PrepareForNextYearBase  extends PrepareForNextYearWebElements {
	protected static boolean validateAsMuchAsPossible=false;
	
	public PrepareForNextYearBase(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate(){
	}

	public void moveMouseToElement(WebElement targetElement) {
		Actions action = new Actions(driver);
		action.moveToElement(targetElement).build().perform(); 
	}

	public void scrollElementToCenterScreen(WebElement element) {
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
				+ "var elementTop = arguments[0].getBoundingClientRect().top;"
				+ "window.scrollBy(0, elementTop-(viewPortHeight/2));";
		((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
		System.out.println("TEST - move element to center view"); 
	}

	public WebElement expandRootElement(WebElement element) {
		WebElement ele = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].shadowRoot",
				element);
		return ele;
	}

	public boolean noWaitValidate(WebElement element) {
		try {
			if (element.isDisplayed()) {
				System.out.println("Element found!!!!");
				return true;
			} else
				System.out.println("Element not found/not visible");
		} catch (Exception e) {
			System.out.println("Exception: Element not found/not visible. Exception message - "+e.getMessage());
		}
		return false;
	}

	public WebDriver getWebDriver() {
		return driver;
	}

	/**
	 * Helper method to click on the target test plan on combo tab
	 * @param planType
	 * @param memberType
	 * @throws InterruptedException 
	 */
	public void handlePaymentComboTabIfComboUser(String planType, String memberType) {
		if (memberType.toLowerCase().contains("combo")) {
			System.out.println("This test is for combo plans, select the tab accordingly");
			goToSpecificPaymentComboTab(planType, memberType);
		} else {
			boolean flagNonCombo=false;
			goToSpecificPaymentComboTab(planType,memberType, flagNonCombo);
		}
	}

	public void goToSpecificPaymentComboTab(String planType, String memberType,boolean flagNonCombo) {
		if (flagNonCombo) {
			goToSpecificPaymentComboTab(planType, memberType);
		}
		String paymentTabListXpath="//div[contains(@class,'tabs')]//li";
		String[] tmp=memberType.split("_");
		Assert.assertTrue("PROBLEM - haven't code to handle this memberType format yet", tmp.length<=3);
		String targetPlanType=planType;
		if (planType.toUpperCase().contains("SHIP_")) {
			String[] tmp2=planType.split("_");
			targetPlanType=tmp2[0];
		}
		String plan1=tmp[1];
		String targetTabXpath="";
		if (targetPlanType.equalsIgnoreCase(plan1)) {
			targetTabXpath=paymentTabListXpath+"[1]//a";
		} else {
			targetTabXpath=paymentTabListXpath+"[2]//a";
		}
		try {
			WebElement tab=driver.findElement(By.xpath(targetTabXpath));
			tab.click();
		} catch (Exception e) {
			System.out.println("unable to locate combo tab for plan, moving on");
		}
	}

	public void goToSpecificPaymentComboTab(String planType, String memberType) {
		String paymentTabListXpath="//div[contains(@class,'tabs')]//li";
		String[] tmp=memberType.split("_");
		//note: assumption - combo of 2 plans only with format of COMBO_<plan1>_<plan2>_<featureIdentifier>
		Assert.assertTrue("PROBLEM - haven't code to handle this memberType format yet", tmp.length<=4);
		String targetPlanType=planType;
		if (planType.toUpperCase().contains("SHIP_")) {
			String[] tmp2=planType.split("_");
			targetPlanType=tmp2[0];
		}
		String plan1=tmp[1];
		String targetTabXpath="";
		if (targetPlanType.equalsIgnoreCase(plan1)) {
			targetTabXpath=paymentTabListXpath+"[1]//a";
		} else {
			targetTabXpath=paymentTabListXpath+"[2]//a";
		}
		try {
			WebElement tab=driver.findElement(By.xpath(targetTabXpath));
			tab.click();
		} catch (Exception e) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for plan '"+planType+"'", false);
		}
	}

	/**
	 * Helper method to click on the target test plan on combo tab
	 * @param planType
	 * @param memberType
	 * @throws InterruptedException 
	 */
	public void handleComboTabIfComboUser(String planType, String memberType) {
		if (memberType.toLowerCase().contains("combo")) {
			System.out.println("This test is for combo plans, select the tab accordingly");
			goToSpecificComboTab(planType);
		} else {
			boolean flagNonCombo=false;
			goToSpecificComboTab(planType,flagNonCombo);
		}
	}

	public boolean valiateNoShipComboTab() {
		if (noWaitValidate(comboTab_SHIP) || noWaitValidate(comboTab_SHIP_HIP))
			return false;
		return true;
	}
	
	public boolean findComboTab(String planType) {
		if (planType.equalsIgnoreCase("mapd")) {
			if (noWaitValidate(comboTab_MAPD) || noWaitValidate(comboTab_MAPD_planDoc))
				return true;
		} else if (planType.equalsIgnoreCase("ma")) {
			if (noWaitValidate(comboTab_MA) || noWaitValidate(comboTab_MA_planDoc)) 
				return true;
		} else if (planType.equalsIgnoreCase("ship")) {
			if (noWaitValidate(comboTab_SHIP) || noWaitValidate(comboTab_SHIP_planDoc)) 
				return true;
		} else if (planType.toLowerCase().contains("ship_hip")) {
			if (noWaitValidate(comboTab_SHIP_HIP) || noWaitValidate(comboTab_SHIP_HIP_planDoc)) 
				return true;
		} else if (planType.equalsIgnoreCase("pdp")) {
			if (noWaitValidate(comboTab_PDP) || noWaitValidate(comboTab_PDP_planDoc))
				return true;
		} else if (planType.equalsIgnoreCase("ssp") || noWaitValidate(comboTab_SSP_planDoc)) {
			return true;
		} 
		return false;
	}
	
	/**
	 * Navigate to specific plan for combo user
	 * @param planType
	 * @param flagNonCombo
	 */
	public void goToSpecificComboTab(String planType,boolean flagNonCombo) {
		if (flagNonCombo)
			goToSpecificComboTab(planType);
		else {
			try {
				if (planType.equalsIgnoreCase("mapd")) {
					if (noWaitValidate(comboTab_MAPD))
						comboTab_MAPD.click();
					else if (noWaitValidate(comboTab_MAPD_planDoc))
						comboTab_MAPD_planDoc.click();
				} else if (planType.equalsIgnoreCase("ma")) {
					if (noWaitValidate(comboTab_MA)) 
						comboTab_MA.click();
					else if (noWaitValidate(comboTab_MA_planDoc)) 
						comboTab_MA_planDoc.click();
				} else if (planType.equalsIgnoreCase("ship")) {
					if (noWaitValidate(comboTab_SHIP)) 
						comboTab_SHIP.click();
					else if (noWaitValidate(comboTab_SHIP_planDoc)) 
						comboTab_SHIP_planDoc.click();
				} else if (planType.toLowerCase().contains("ship_hip")) {
					if (noWaitValidate(comboTab_SHIP_HIP)) 
						comboTab_SHIP_HIP.click();
					else if (noWaitValidate(comboTab_SHIP_HIP_planDoc)) 
						comboTab_SHIP_HIP_planDoc.click();
				} else if (planType.equalsIgnoreCase("pdp")) {
					if (noWaitValidate(comboTab_PDP))
						comboTab_PDP.click();
					else if (noWaitValidate(comboTab_PDP_planDoc))
						comboTab_PDP_planDoc.click();
				} else if (planType.equalsIgnoreCase("ssp")) {
					if (noWaitValidate(comboTab_SSP)) 
						comboTab_SSP.click();
					else if (noWaitValidate(comboTab_SSP_planDoc))
						comboTab_SSP_planDoc.click();
				} 
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		checkModelPopup(driver,3);
	}

	/**
	 * Navigate to specific plan for combo user, default will fail it if user doesn't have combo
	 * @param planType
	 */
	public void goToSpecificComboTab(String planType) {
		//TODO: need to enhance it to handle multi plans of the same plan type, e.g. multiple ship plans each w/ different ship plan category name
		try {
			if (planType.toLowerCase().contains("mapd")) {
				Assert.assertTrue("PROBLEM - unable to locate combo tab for MAPD", noWaitValidate(comboTab_MAPD) || noWaitValidate(comboTab_MAPD_planDoc));
				if (noWaitValidate(comboTab_MAPD)) 
					comboTab_MAPD.click();
				else if (noWaitValidate(comboTab_MAPD_planDoc)) 
					comboTab_MAPD_planDoc.click();
			} else if (planType.toLowerCase().contains("ma") && !planType.toLowerCase().contains("pd")) {
				Assert.assertTrue("PROBLEM - unable to locate combo tab for MA", noWaitValidate(comboTab_MA) || noWaitValidate(comboTab_MA_planDoc));
				if (noWaitValidate(comboTab_MA)) 
					comboTab_MA.click();
				else if (noWaitValidate(comboTab_MA_planDoc)) 
					comboTab_MA_planDoc.click();
			} else if (planType.toLowerCase().contains("ship_hip")) {
				Assert.assertTrue("PROBLEM - unable to locate combo tab for SHIP_HIP", noWaitValidate(comboTab_SHIP_HIP) || noWaitValidate(comboTab_SHIP_HIP_planDoc));
				if (noWaitValidate(comboTab_SHIP_HIP)) 
					comboTab_SHIP_HIP.click();
				else if (noWaitValidate(comboTab_SHIP_HIP_planDoc)) 
					comboTab_SHIP_HIP_planDoc.click();
			} else if (planType.toLowerCase().contains("ship")) {
				Assert.assertTrue("PROBLEM - unable to locate combo tab for SHIP", noWaitValidate(comboTab_SHIP) || noWaitValidate(comboTab_SHIP_planDoc));
				if (noWaitValidate(comboTab_SHIP)) 
					comboTab_SHIP.click();
				else if (noWaitValidate(comboTab_SHIP_planDoc)) 
					comboTab_SHIP_planDoc.click();
			} else if (planType.toLowerCase().contains("pdp")) {
				Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", noWaitValidate(comboTab_PDP) || noWaitValidate(comboTab_PDP_planDoc));
				if (noWaitValidate(comboTab_PDP)) 
					comboTab_PDP.click();
				else if (noWaitValidate(comboTab_PDP_planDoc)) 
					comboTab_PDP_planDoc.click();
			} else if (planType.toLowerCase().contains("ssp")) {
				Assert.assertTrue("PROBLEM - unable to locate combo tab for SSP", noWaitValidate(comboTab_SSP) || noWaitValidate(comboTab_SSP_planDoc));
				if (noWaitValidate(comboTab_SSP))
					comboTab_SSP.click();
				else if (noWaitValidate(comboTab_SSP_planDoc))
					comboTab_SSP_planDoc.click();
			} else {
				Assert.assertTrue("PROBLEM - need to enhance code to cover planType '"+planType+"' for combo testing", false);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		checkModelPopup(driver,3);
	}	

	public WebDriver backToOriginalLinkToPrepNextStep(String planType, String memberType, String originalUrl) {
		driver.get(originalUrl);
		CommonUtility.checkPageIsReady(driver);
		checkModelPopup(driver,1);
		if (!originalUrl.contains("/dashboard")) //note: rally dashboard has no tab for combo
			handleComboTabIfComboUser(planType, memberType);
		CommonUtility.waitForPageLoad(driver, noLoadingSpinner, 10);
		checkModelPopup(driver,3);
		return driver;
	}

	public String getConsumerDetailsFromlocalStorage() {
		RemoteExecuteMethod executeMethod = new RemoteExecuteMethod((RemoteWebDriver) driver);
		RemoteWebStorage webStorage = new RemoteWebStorage(executeMethod);
		LocalStorage localStorage = webStorage.getLocalStorage();
		String consumerDetails=localStorage.getItem("consumerDetails");
		return consumerDetails;
	}


	public boolean getPremiumPaymentInConsumerDetails(boolean isComboUser, String lookForPlanCategory, String consumerDetails) {
		//System.out.println("TEST - consumerDetails="+consumerDetails);
		boolean actualPremiumPayment=false;
		try {
			JSONParser parser = new JSONParser();
			JSONObject apiResponseJsobObj=(JSONObject) parser.parse(consumerDetails);
			JSONArray planProfilesArrayObj=(JSONArray) apiResponseJsobObj.get("planProfiles");
			if (isComboUser) 
				Assert.assertTrue("PROBLEM - test data expect this user to be a combo user "
						+ "but the localStorage.consumerDetails has only one planProfiles.  "
						+ "Please double check and correct test data", planProfilesArrayObj.size()>1);
			for (int i = 0; i < planProfilesArrayObj.size(); i++) {
				JSONObject planProfilesObj= (JSONObject) planProfilesArrayObj.get(i);
				String actualPlanCategory = (String) planProfilesObj.get("planCategory");
				//System.out.println("TEST - lookForPlanCategory="+lookForPlanCategory);
				//System.out.println("TEST - actualPlanCategory="+actualPlanCategory);
				if (lookForPlanCategory.equals(actualPlanCategory)) {
					actualPremiumPayment = (Boolean) planProfilesObj.get("premiumPayment");
				} 
			}			
		} catch (ParseException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - encounted problem reading the json result from localStorage.consumerDetails", false);
		}
		return actualPremiumPayment;
	}

	public void sleepBySec(int sec) {
		System.out.println("Sleeping for '"+sec+"' sec");
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Date getCurrentSystemDate() {
		if (MRScenario.environment.equalsIgnoreCase("offline") || MRScenario.environment.equalsIgnoreCase("prod")) {
			//note: offline-prod and online-prod should always have current date anyway...
			return new Date();
		} else {
			String dateTimeStr=getMemTestEnvSysTime();
			String[] tmp=dateTimeStr.split(" ");
			String month=tmp[1];
			String day=tmp[2];
			String year=tmp[5];
			String s=month+" "+day+","+year;		
			DateFormat df = new SimpleDateFormat("MMM dd,yyyy"); 
			df.setTimeZone(TimeZone.getTimeZone("UTC"));
			Date targetDate;
			try {
				targetDate = df.parse(s);
			    String newDateString = df.format(targetDate);
			    System.out.println("currentSystemDate="+newDateString);
			    return targetDate;
			} catch (java.text.ParseException e) {
			    e.printStackTrace();
			    return null;
			}
		}
	}

	public String convertDateToAemFieldFormat(Date inputDate) {
		DateFormat df = new SimpleDateFormat("MM/dd/yy"); 
		String newDateString = df.format(inputDate);
		//System.out.println(newDateString);
		return newDateString;
	}
	
	
	public Date convertStrToDate(String strDate) {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy"); 
		df.setTimeZone(TimeZone.getTimeZone("UTC"));
		Date targetDate;
		try {
			targetDate = df.parse(strDate);
		    //String newDateString = df.format(targetDate);
		    //System.out.println(newDateString);
		    return targetDate;
		} catch (java.text.ParseException e) {
		    e.printStackTrace();
		    return null;
		}
	}
	
	public boolean validateJavaDate(String strDate) {
		if (strDate.trim().equals("")) {
		    return true;
		} else {
		    SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
		    sdfrmt.setTimeZone(TimeZone.getTimeZone("UTC"));
		    sdfrmt.setLenient(false);
		    try {
		        Date javaDate = sdfrmt.parse(strDate); 
		        //System.out.println(strDate+" is valid date format");
		    } catch (java.text.ParseException e) {
		        //System.out.println(strDate+" is Invalid Date format");
		        return false;
		    }
		    return true;
		}
	}
	
	public String convertDateToStrFormat_MMDDYYYY(Date d) {
		String pattern = "MM/dd/yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		return simpleDateFormat.format(d);
	}
	
	public Long convertDateToUctMillisecondsStr(Date inputDate) {
		return inputDate.getTime();
	}
	
	public void sleepByMillSec(int millsec) {
		System.out.println("Sleeping for '"+millsec+"' sec");
		try {
			Thread.sleep(millsec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void validateBookmarkError() {
		String tmpUrl=driver.getCurrentUrl();
		String tmp[]=tmpUrl.split("/benefits");
		String bookmark=tmp[0]+"/preparefornextyear/overview.html";
		driver.get(bookmark);
		CommonUtility.checkPageIsReady(driver);
		checkModelPopup(driver,1);
		Assert.assertTrue("PROBLEM - unable to locate error message when attempting to access bookmark when tab hasn't met conditions to be displayed", noWaitValidate(bookmarkErrMsg));
		//note: re-enable when the error msg is settle
		//String actMsg=bookmarkErrMsg.getText();
		//String expMsg="Your request can not be Processed at this time. Please try again later";
		//Assert.assertTrue("PROBLEM - error message is not as expected.  Expect='"+expMsg+"' | Actual='"+actMsg+"'", actMsg.contains(expMsg));
		Assert.assertTrue("PROBLEM - unable to locate the link that would allow user to go back to home page", noWaitValidate(bookmarkErrPgGoBackHome));

	}

	public List<String> validatePdf(String targetDocName, WebElement pdfLink) {
		checkModelPopup(driver,1);
		List<String> note=new ArrayList<String>();
		note.add("\n\tValidation for PDF ='"+targetDocName+"'");
		String winHandleBefore = driver.getWindowHandle();

		ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		int beforeClicked_numTabs=beforeClicked_tabs.size();	
		CommonUtility.waitForPageLoad(driver, pdfLink, 5);
		scrollElementToCenterScreen(pdfLink);
		pdfLink.click();
		CommonUtility.checkPageIsReady(driver);

		ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		int afterClicked_numTabs=afterClicked_tabs.size();
		if (validateAsMuchAsPossible) {
			if ((afterClicked_numTabs-beforeClicked_numTabs)!=1) {
				note.add("\t * FAILED - Did not get expected new tab after clicking '"+targetDocName+"' link");
				note.add("\t * FAILED - validating PDF content");
				return note;
			}
		} else {
			Assert.assertTrue("PROBLEM - Did not get expected new tab after clicking '"+targetDocName+"' link", (afterClicked_numTabs-beforeClicked_numTabs)==1);
		}
		driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
		CommonUtility.checkPageIsReady(driver);
		sleepBySec(1);

		String actUrl=driver.getCurrentUrl();
		String expUrl=".pdf";
		if (!actUrl.contains(expUrl)) {
			note.add("\t * FAILED - not getting expected destination URL.  Expect to contain '"+expUrl+"' | Actual URL='"+actUrl+"'");
			note.add("\t * FAILED - validating PDF content");
			return note;
		}
		Assert.assertTrue("PROBLEM - not getting expected destination URL.  Expect to contain '"+expUrl+"' | Actual URL='"+actUrl+"'", actUrl.contains(expUrl));

		//note: for provider directory, it will take a while to load b/c it's a big file
		if (MRScenario.environment.equals("offline")) {
			try {
				URL TestURL = new URL(driver.getCurrentUrl());
				sleepBySec(3); //note: let the page settle before validating content
				BufferedInputStream TestFile = new BufferedInputStream(TestURL.openStream());
				PDDocument document = PDDocument.load(TestFile);
				String PDFText = new PDFTextStripper().getText(document);
				//keepForDebug System.out.println("PDF text : "+PDFText);
				if(PDFText!=null && !PDFText.equals("")){
					note.add("\tPASSED - validated pdf content is not null");
				} else {
					if (validateAsMuchAsPossible) 
					note.add("\t* FAILED - unable to validate pdf content - content either null or empty");
					else 
					Assert.assertTrue("PROBLEM - unable to validate pdf content - content either null or empty - doc name="+targetDocName, false);
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
				if (validateAsMuchAsPossible)
				note.add("\t* FAILED - unable to validate pdf content - MalformedURLException");
				else
				Assert.assertTrue("PROBLEM - unable to validate pdf content - MalformedURLException - doc name="+targetDocName, false);
			} catch (IOException e) {
				e.printStackTrace();
				if (validateAsMuchAsPossible)
				note.add("\t* FAILED - unable to validate pdf content - IOException");
				else
				Assert.assertTrue("PROBLEM - unable to validate pdf content - IOException - doc name="+targetDocName, false);
			}
		} else  {
			note.add("\tOn '"+MRScenario.environment+"' env, skip validating PDF content to speed up the run");
		} 

		driver.close();
		driver.switchTo().window(winHandleBefore);

		note.add("\tPASSED - validating PDF content");
		return note;

	}

	public List<String> validateHaveItem(String targetItem, WebElement targetElement) {
		List<String> note=new ArrayList<String>();
		if (validateAsMuchAsPossible) {
			if (noWaitValidate(targetElement))
				note.add("\tPASSED - validation for HAVING "+targetItem);
			else
				if (noWaitValidate(systemError)) 
					note.add("\t * FAILED - unable to locate element for '"+targetItem+"' - got system error on screen");
				else
					note.add("\t * FAILED - unable to locate element for '"+targetItem+"'");
		} else {
			if (noWaitValidate(systemError)) 
				Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"' - got system error on screen", noWaitValidate(targetElement));
			else
				Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
			note.add("\tPASSED - validation for HAVING "+targetItem);
		}
	
		return note;
	}

	public List<String> validateDontHaveItem(String targetItem, WebElement targetElement) {
		List<String> note=new ArrayList<String>();
		System.out.println("TEST - check validateAsMuchAsPossible="+validateAsMuchAsPossible);

		if (validateAsMuchAsPossible) {
			if (!noWaitValidate(targetElement)) 
				note.add("\tPASSED - validation for NOT HAVING "+targetItem);
			else
				if (noWaitValidate(systemError)) 
					note.add("\t * FAILED - should not be able to locate element for '"+targetItem+"' - got system error on screen");
				else
					note.add("\t * FAILED - should not be able to locate element for '"+targetItem+"'");
		} else {
			if (noWaitValidate(systemError)) 
				Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"' - got system error on screen", !noWaitValidate(targetElement));
			else 
				Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"'", !noWaitValidate(targetElement));
			note.add("\tPASSED - validation for NOT HAVING "+targetItem);
		}
		return note;
	}
	
	public List<String> validatePdfLinkTxt(String docName, WebElement targetElement) {
		List<String> note=new ArrayList<String>();
		String lnkTxt=targetElement.getText();

		String endTxt="PDF";
		if (validateAsMuchAsPossible) {
			if (lnkTxt.contains(endTxt)) 
				note.add("\tPASSED - validation for PDF link text ends with '"+endTxt+"'");
			else
				note.add("\t * FAILED - unable to locate the word '"+endTxt+"' for PDF link '"+docName+"' | Actual link text='"+lnkTxt+"'");
		} else {
			Assert.assertTrue("PROBLEM - unable to locate the word '"+endTxt+"' for PDF link '"+docName+"' | Actual link text='"+lnkTxt+"'", lnkTxt.contains(endTxt));
			note.add("\tPASSED - validation for PDF link text ends with '"+endTxt+"'");
		}
		return note;
	}
	
	 
	public List<String> validateLanguageDropdown(String section, WebElement langDropdown, WebElement engOption, WebElement esOption, WebElement zhOption) {
		List<String> note=new ArrayList<String>();
		note.add("\tValidate language dropdown...");
		String targetItem=section+" - language dropdown and options";
		WebElement targetElement=langDropdown;
		note.addAll(validateHaveItem(targetItem, targetElement));

		Select select = new Select(langDropdown);           
		String actualSelectedLang = select.getFirstSelectedOption().getText();
		String expectedSelectedLang="ENGLISH";
		Assert.assertTrue("PROBLEM - default selected language option is not as expected. "
				+ "Expected='"+expectedSelectedLang+"' | Actual='"+actualSelectedLang+"'", 
				actualSelectedLang.equals(actualSelectedLang));

		targetItem=section+" - language dropdown English option";
		targetElement=langDropdown;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - language dropdown Spanish option";
		targetElement=engOption;
		note.addAll(validateHaveItem(targetItem, targetElement));

		targetItem=section+" - language dropdown Chinese option";
		targetElement=zhOption;
		note.addAll(validateHaveItem(targetItem, targetElement));
		return note;
	}
	
	public int getCurrentYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	
	public List<String> validateLnkBehavior(String planType, String memberType, String targetItem, WebElement targetElement, String expUrl, WebElement expElement) {
		List<String> note=new ArrayList<String>();
		System.out.println("Proceed to validate link '"+targetItem+"' behavior...");
		//		String actHrefUrl=targetElement.getAttribute("href");
			String winHandleBefore = driver.getWindowHandle();
			String urlBeforeClick=driver.getCurrentUrl();
			ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			int beforeClicked_numTabs=beforeClicked_tabs.size();	
			CommonUtility.waitForPageLoad(driver, expElement, 5);
			scrollElementToCenterScreen(targetElement);
			targetElement.click();
			CommonUtility.checkPageIsReady(driver);
			checkModelPopup(driver,5);
			ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
			int afterClicked_numTabs=afterClicked_tabs.size();
			if (validateAsMuchAsPossible) {
				if ((afterClicked_numTabs-beforeClicked_numTabs)!=1) {
					note.add("\t * FAILED - Did not get expected new tab after clicking '"+targetItem+"' link. Number of existing tab before link click='"+beforeClicked_numTabs+"' | After='"+afterClicked_numTabs+"'");
					//note: back to prior page and move on
					if (!driver.getCurrentUrl().contains("preparefornextyear/overview.html")) {
						driver.get(urlBeforeClick);
					}
					return note;
				} else {
					System.out.println("TEST - link opened on new tab as expected...moving on...");
				}
			} else {
					Assert.assertTrue("PROBLEM - Did not get expected new tab after clicking '"+targetItem+"' link. Number of existing tab before link click='"+beforeClicked_numTabs+"' | After='"+afterClicked_numTabs+"'", (afterClicked_numTabs-beforeClicked_numTabs)==1);
			}
			driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
			CommonUtility.checkPageIsReady(driver);
			CommonUtility.waitForPageLoad(driver, expElement, 10);
			checkModelPopup(driver,5);
			String currentUrl=driver.getCurrentUrl();
			if (validateAsMuchAsPossible) {
				if (!currentUrl.contains(expUrl))
					note.add("\t * FAILED: destination URL is not as expected for '"+targetItem+"'.  Expect to contain ='"+expUrl+"' | Actual='"+currentUrl+"'");
			} else {
				Assert.assertTrue("PROLEM: destination URL is not as expected for '"+targetItem+"'.  Expect to contain ='"+expUrl+"' | Actual='"+currentUrl+"'", currentUrl.contains(expUrl));
			}
			
			if (noWaitValidate(acqPopupExit))
				acqPopupExit.click();
			if (validateAsMuchAsPossible) {
				if (noWaitValidate(expElement))
					note.add("\tPASSED - validation for link target page loading for "+targetItem);
				else {
					if (targetItem.contains("Drug Search link") && MRScenario.environment.contains("stage"))
						note.add("\t * SKIP - validation for link target page loading for "+targetItem+" - acqusition DCE page has problem loading on stage");
					else
						note.add("\t * FAILED, unable to locate expected element on the destination page");
				}
			} else {
				if (targetItem.contains("Drug Search link") && MRScenario.environment.contains("stage"))
					note.add("\t * SKIP - validation for link target page loading for "+targetItem+" - acqusition DCE page has problem loading on stage");
				else
					Assert.assertTrue("PROBLEM, unable to locate expected element on the destination page", noWaitValidate(expElement));
					note.add("\tPASSED - validation for link target page loading for "+targetItem);
			}

			driver.close();
			System.out.println("TEST - Closed tab for '"+targetItem+"'");
			driver.switchTo().window(winHandleBefore);
			System.out.println("TEST - Switched back to prior tab");
		
		return note;

	}

	public String validateAdobePdfDocText() {
		System.out.println("Validate PDF Doc text section exists");
		Assert.assertTrue("PROBLEM - unable to locate the Adobe PDF section",noWaitValidate(adobePdfDocText));

		System.out.println("Validate PDF Doc text section exists");
		Assert.assertTrue("PROBLEM - unable to locate the Adobe link",noWaitValidate(adobeLink));

		validateSiteLeaveingPopUP(adobeLink);
		
		return "\tPASSED Adobe PDF doc text validation";
	}

	public String validateSiteLeaveingPopUP(WebElement targetLink) {
		Assert.assertTrue("PROBLEM - unable to locate Adobe link", noWaitValidate(targetLink));
		jsClickNew(targetLink);
		CommonUtility.waitForPageLoad(driver, siteLeavingProceedButton, 10);
		Assert.assertTrue("PROBLEM - unable to locate Leaving Site Proceed button", noWaitValidate(siteLeavingProceedButton));
		Assert.assertTrue("PROBLEM - unable to locate Leaving Site Cancel button", noWaitValidate(siteLeavingCancelButton));
		//note: click cancel and validate any element on page
		checkModelPopup(driver,2);
		siteLeavingCancelButton.click();
		sleepBySec(1);
		Assert.assertTrue("PROBLEM - unable to locate Adobe link after clicking Leave Site Cancel button", noWaitValidate(targetLink));
		noWaitValidate(targetLink);
		return "\tPASSED Site Leaving Proceed/Cancel Popup validation";
	}

	/**
	 * deleteCookie - return true if successfully deleted the cookie
	 * @param cookieName
	 * @return
	 */
	public boolean deleteCookie(String cookieName) {
		driver.manage().deleteCookieNamed(cookieName);
		return getCookie(cookieName);
	}
	
	public boolean getCookie(String cookieName) {
		Cookie cookie=driver.manage().getCookieNamed(cookieName);
		if (cookie==null) 
			return false;
		else
			return true;
	}	
	
	public boolean selectValueFromDropdown(WebElement dropdownElement, String targetLang) {
		try {
			String value="en_us";
			if (targetLang.equals("Spanish"))
				value="es";
			else if (targetLang.equals("Chinese"))
				value="zh";
			
			scrollElementToCenterScreen(dropdownElement);
			Select select = new Select(dropdownElement);    
			waitTillElementClickableInTime(dropdownElement,10);
			try {
				dropdownElement.click();
			} catch (WebDriverException e) { //note: in case it's timing, try one more time before giving up
				sleepBySec(1);
				dropdownElement.click();
			}
			select.selectByValue(value);
		} catch (WebDriverException e) {
			e.printStackTrace();
			if (validateAsMuchAsPossible) {
				System.out.println("unable to select expected langauge "+targetLang+" option from dropdown");
				return false;
			} else {
				Assert.assertTrue("PROBLEM - unable to select expected langauge "+targetLang+" option from dropdown", false);
				return false;
			}
		}
		return true;
	}

	
	public void deleteCookieAndReloadPgn(String cookieName) {
		deleteCookie(cookieName);
		driver.navigate().refresh();
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, noLoadingSpinner, 10);
		if (noWaitValidate(loadingSpinnerOnScreen)) {
			System.out.println("Give it one more try before givng up...");
			driver.navigate().refresh();
			CommonUtility.checkPageIsReady(driver);
			CommonUtility.waitForPageLoad(driver, noLoadingSpinner, 10);
			Assert.assertTrue("PROBLEM - loading spinner won't go away...", !noWaitValidate(loadingSpinnerOnScreen));
		}
		CommonUtility.waitForPageLoad(driver, prepareForNextYearPgHeader, 5);
		checkModelPopup(driver,3);
	}
	
	public List<String> validatePdfInSubSection(
			String planType, 
			HashMap<String, Boolean> docDisplayMap, 
			String section, String subSection, 
			String docName, String targetLang, 
			WebElement langDropdownElement1, WebElement langDropdown1_targetLangOptionElement, WebElement langDropdownElement2, boolean expLangDropOption,
			WebElement pdfElement, WebElement arrowAftPdfElement, WebElement svgAftPdfElement,
			String subSecCookie, WebElement subSecChkmrkgreen1, WebElement subSecChkmrkgreen2,
			boolean willDeleteCookie) {

		List<String> note=new ArrayList<String> ();
		String targetItem=section+" - "+targetLang+" '"+docName+" (PDF)'";
		if (docDisplayMap.get(docName+" "+targetLang)) {
			note.add("\tEXPECT "+targetLang+" '"+docName+"' document to display");
			if (selectValueFromDropdown(langDropdownElement1, targetLang)) {
				if (langDropdownElement2!=null) {
					Select select2 = new Select(langDropdownElement2);           
					String otherDropDownSelectedValue=select2.getFirstSelectedOption().getText();
					if (validateAsMuchAsPossible) {
						if (!otherDropDownSelectedValue.equalsIgnoreCase("ENGLISH")) 
							note.add("\t * FAILED - switching language option in one section should not have impacted the langage option in other section");
					} else {
						Assert.assertTrue("PROBLEM - switching language option in one section should not have impacted the langage option in other section", otherDropDownSelectedValue.equalsIgnoreCase("ENGLISH"));
					}
				}

				CommonUtility.waitForPageLoad(driver, pdfElement, 10);
				note.addAll(validateHaveItem(targetItem, pdfElement));
				if (noWaitValidate(pdfElement)) {
					note.addAll(validatePdfLinkTxt(docName, pdfElement));
					note.addAll(validatePdf(targetItem, pdfElement));
				}

				//targetItem=section+" - arrow before pdf";
				//note.addAll(validateHaveItem(targetItem, arrowBefPdfElement));

				//targetItem=section+" - the 'or' text";
				//note.addAll(validateHaveItem(targetItem, orTextBefPdfElement));

				targetItem=section+" - Arrow after '"+docName+"' doc link'";
				if (docName.contains("Annual Notice of Changes")) 
					note.addAll(validateDontHaveItem(targetItem, arrowAftPdfElement));
				else
					note.addAll(validateHaveItem(targetItem, arrowAftPdfElement));

				targetItem=section+" - svg after '"+docName+"' doc link'";
				if (docName.contains("Annual Notice of Changes")) 
					note.addAll(validateDontHaveItem(targetItem, arrowAftPdfElement));
				else
					note.addAll(validateHaveItem(targetItem, arrowAftPdfElement));

				//note: after link click, little check should turn green
				//note: some section has inconsistent way to locate the green chkmrk xpath...that's why need to figure out which xpath to use
				note.add("\n\tValidate after clicking "+targetLang+" '"+docName+"' link");
				targetItem=section+" - green checkmark";
				WebElement subSecChkmrkgreen=subSecChkmrkgreen1;
				if (noWaitValidate(subSecChkmrkgreen1)) {
					subSecChkmrkgreen=subSecChkmrkgreen1;
				} else {
					subSecChkmrkgreen=subSecChkmrkgreen2;
				}
				note.addAll(validateHaveItem(targetItem, subSecChkmrkgreen));

				if (willDeleteCookie) {
					note.add("\n\tValidate after cookie remove for '"+subSection+"' subsection cookie");
					deleteCookieAndReloadPgn(subSecCookie);
					note.addAll(validateDontHaveItem(targetItem, subSecChkmrkgreen));
				}

			} else {
				note.add("\t * FAILED - unable to select expected langauge "+targetLang+" option from dropdown");
			}

		} else {
			//note: if there is no English ANOC, it should be the SAR case
			//note: for now just stay here and validate dropdown has English but nothing else.
			//keep-for-now if (targetLang.equalsIgnoreCase("ENGLISH")) {
				//keep-for-now note.add("\tDO NOT EXPECT "+targetLang+" '"+docName+"' document to display");
				//keep-for-now Assert.assertTrue("SHOULD land on SAR page", false);

			//keep-for-now } else {
				if (expLangDropOption) {
					note.add("\tEXPECT "+targetLang+" '"+docName+"' document to display because other sub section has this language");
					targetItem=targetLang+" language dropdown option'";
					note.addAll(validateHaveItem(targetItem, langDropdown1_targetLangOptionElement));
				} else {
					note.add("\tDO NOT EXPECT "+targetLang+" '"+docName+"' document to display");
					//note: no doc then no dropdown
					targetItem=targetLang+" language dropdown option'";
					note.addAll(validateDontHaveItem(targetItem, langDropdown1_targetLangOptionElement));
				}

				targetItem=section+" - "+targetLang+" '"+docName+" (PDF)'";
				CommonUtility.waitForPageLoad(driver, pdfElement, 5);
				note.addAll(validateDontHaveItem(targetItem, pdfElement));

				targetItem=section+" - Arrow after '"+docName+"' doc link'";
				note.addAll(validateDontHaveItem(targetItem, arrowAftPdfElement));
				//keep-for-now }
		}
		return note;

	}
	
	public String getPlanNameComboUser() {
		Assert.assertTrue("PROBLEM - unable to locate the plan name on benefits page for this combo user", noWaitValidate(planNameComboUser_benefitsPg));
		return planNameComboUser_benefitsPg.getText();
	}
	
	
}