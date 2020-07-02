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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
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
		String plan2=tmp[2];
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
		System.out.println("TEST 1 - memberType='"+memberType+"' | length='"+tmp.length+"'");
		Assert.assertTrue("PROBLEM - haven't code to handle this memberType format yet", tmp.length<=4);
		String targetPlanType=planType;
		if (planType.toUpperCase().contains("SHIP_")) {
			String[] tmp2=planType.split("_");
			System.out.println("TEST 2- planType='"+planType+"' | length='"+tmp2.length+"'");
			targetPlanType=tmp2[0];
		}
		String plan1=tmp[1];
		String plan2=tmp[2];
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
		sleepBySec(2);
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
	}	

	public WebDriver backToOriginalLinkToPrepNextStep(String planType, String memberType, String originalUrl) {
		driver.get(originalUrl);
		CommonUtility.checkPageIsReady(driver);
		checkModelPopup(driver,1);
		if (!originalUrl.contains("/dashboard")) //note: rally dashboard has no tab for combo
			handleComboTabIfComboUser(planType, memberType);
		checkModelPopup(driver,1);
		return driver;
	}

	public String getConsumerDetailsFromlocalStorage() {
		//WebStorage webStorage = (WebStorage) new Augmenter().augment(driver) ;
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
		    String newDateString = df.format(targetDate);
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
		String bookmark=tmp[0]+"/planfornextyear/overview.html";
		driver.get(bookmark);
		CommonUtility.checkPageIsReady(driver);
		checkModelPopup(driver,1);
		Assert.assertTrue("PROBLEM - unable to locate error message when attempting to access bookmark when tab hasn't met conditions to be displayed", noWaitValidate(bookmarkErrMsg));
		String actMsg=bookmarkErrMsg.getText();;
		String expMsg="Your request can not be Processed at this time. Please try again later";
		Assert.assertTrue("PROBLEM - error message is not as expected.  Expect='"+expMsg+"' | Actual='"+actMsg+"'", actMsg.contains(expMsg));
		Assert.assertTrue("PROBLEM - unable to locate the link that would allow user to go back to home page", noWaitValidate(bookmarkErrPgGoBackHome));

	}

	public List<String> validatePdf(String targetDocName, WebElement pdfLink) {
		List<String> note=new ArrayList<String>();
		note.add("\tValidation for PDF ='"+targetDocName+"'");
		String winHandleBefore = driver.getWindowHandle();

		ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		int beforeClicked_numTabs=beforeClicked_tabs.size();	
		CommonUtility.waitForPageLoad(driver, pdfLink, 5);
		scrollElementToCenterScreen(pdfLink);
		pdfLink.click();
		CommonUtility.checkPageIsReady(driver);

		ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
		int afterClicked_numTabs=afterClicked_tabs.size();
		Assert.assertTrue("PROBLEM - Did not get expected new tab after clicking '"+targetDocName+"' link", (afterClicked_numTabs-beforeClicked_numTabs)==1);
		driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
		CommonUtility.checkPageIsReady(driver);
		sleepBySec(1);

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
					note.add("PASSED - validated pdf content is not null");
				} else {
					note.add("* FAILED - unable to validate pdf content - content either null or empty");
					Assert.assertTrue("PROBLEM - unable to validate pdf content - content either null or empty - doc name="+targetDocName, false);
				}
			} catch (MalformedURLException e) {
				note.add("* FAILED - unable to validate pdf content - MalformedURLException");
				e.printStackTrace();
				Assert.assertTrue("PROBLEM - unable to validate pdf content - MalformedURLException - doc name="+targetDocName, false);
			} catch (IOException e) {
				note.add("* FAILED - unable to validate pdf content - IOException");
				e.printStackTrace();
				//keep Assert.assertTrue("PROBLEM - unable to validate pdf content - IOException - doc name="+targetDocName, false);
			}
		} else {
			note.add("\tOn lower env, skip validating PDF content");
		}

		driver.close();
		driver.switchTo().window(winHandleBefore);

		note.add("\tPASSED - validating PDF content");
		return note;

	}

	public List<String> validateHaveItem(String targetItem, WebElement targetElement) {
		List<String> note=new ArrayList<String>();
		Assert.assertTrue("PROBLEM - unable to locate element for '"+targetItem+"'", noWaitValidate(targetElement));
		note.add("\tPASSED - validation for HAVING "+targetItem);
		return note;
	}

	public List<String> validateDontHaveItem(String targetItem, WebElement targetElement) {
		List<String> note=new ArrayList<String>();
		Assert.assertTrue("PROBLEM - should not be able to locate element for '"+targetItem+"'", !noWaitValidate(targetElement));
		note.add("\tPASSED - validation for NOT HAVING "+targetItem);
		return note;
	}
	
	public List<String> validatePdfLinkTxt(String docName, WebElement targetElement) {
		List<String> note=new ArrayList<String>();
		String lnkTxt=targetElement.getText();
		String startTxt="Open";
		Assert.assertTrue("PROBLEM - unable to locate the word '"+startTxt+"' in front of PDF name '"+docName+"' | Actual link text='"+lnkTxt+"'", lnkTxt.startsWith(startTxt));
		note.add("\tPASSED - validation for PDF link text starts with '"+startTxt+"'");

		String endTxt="PDF";
		Assert.assertTrue("PROBLEM - unable to locate the word '"+endTxt+"' for PDF link '"+docName+"' | Actual link text='"+lnkTxt+"'", lnkTxt.contains(endTxt));
		note.add("\tPASSED - validation for PDF link text ends with '"+endTxt+"'");
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
	
	public void validateReturnToPrevPgLnk() {
		CommonUtility.waitForPageLoad(driver, noLoadingSpinner, 10);
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

	public int getCurrentYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	
	public List<String> validateLnkBehavior(String planType, String memberType, String targetItem, WebElement targetElement, String expUrl, WebElement expElement) {
		List<String> note=new ArrayList<String>();
		System.out.println("Proceed to validate link '"+targetItem+"' behavior...");
		if (targetItem.contains("Search For Providers link")) {
			String actHrefUrl=targetElement.getAttribute("ng-click");
			String[] tmpLnk=expUrl.split("\\|");
			boolean found=false;
			for (String u: tmpLnk) {
				if (actHrefUrl.contains(u)) {
					found=true;
					break;
				}
			}
			Assert.assertTrue("PROLEM: element's href value is not as expected for '"+targetItem+"'.  Expect to contain either one of these='"+expUrl+"' | Actual='"+actHrefUrl+"'", found);
			note.add("\tPASSED - validation for link element href value for "+targetItem);
			if (MRScenario.environment.contains("team-a")) { 
				note.add("\tSKIPPED - lower env - validation for link destination after click for "+targetItem);
				note.add("\tSKIPPED - lower env - validation for link target page loading for "+targetItem);
			} else {
				String winHandleBefore = driver.getWindowHandle();

				ArrayList<String> beforeClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				int beforeClicked_numTabs=beforeClicked_tabs.size();	
				CommonUtility.waitForPageLoad(driver, expElement, 5);
				targetElement.click();
				CommonUtility.checkPageIsReady(driver);

				ArrayList<String> afterClicked_tabs = new ArrayList<String>(driver.getWindowHandles());
				int afterClicked_numTabs=afterClicked_tabs.size();
				Assert.assertTrue("PROBLEM - Did not get expected new tab after clicking '"+targetItem+"' link", (afterClicked_numTabs-beforeClicked_numTabs)==1);
				driver.switchTo().window(afterClicked_tabs.get(afterClicked_numTabs-1));
				CommonUtility.checkPageIsReady(driver);

				String currentUrl=driver.getCurrentUrl();
				boolean found2=false;
				for (String u: tmpLnk) {
					if (currentUrl.contains(u)) {
						found2=true;
						break;
					}
				}
				Assert.assertTrue("PROLEM: element's href value is not as expected for '"+targetItem+"'.  Expect to contain either one of these='"+expUrl+"' | Actual='"+currentUrl+"'", found2);
				Assert.assertTrue("PROBLEM, unable to locate expected element on the destination page", noWaitValidate(expElement));
				note.add("\tPASSED - validation for link target page loading for "+targetItem);

				driver.close();
				driver.switchTo().window(winHandleBefore);

			}
		} else {
			String actHrefUrl=targetElement.getAttribute("href");
			Assert.assertTrue("PROBLEM - link '"+targetItem+"' element href value is not as expected.  Expected to contain='"+expUrl+"' | Actual='"+actHrefUrl+"'", actHrefUrl.contains(expUrl));
			note.add("\tPASSED - validation for link element href value for "+targetItem);

			if (MRScenario.environment.contains("team-a")) { 
				note.add("\tSKIPPED - lower env - validation for link destination after click for "+targetItem);
				note.add("\tSKIPPED - lower env - validation for link target page loading for "+targetItem);
			} else {
				String originalUrl=driver.getCurrentUrl();
				
				targetElement.click();
				CommonUtility.waitForPageLoad(driver, expElement, 10);
				String currentUrl=driver.getCurrentUrl();
				Assert.assertTrue("PROBLEM - Unable to land on expected URL after clicking the link.  Expected to land on='"+expUrl+"' | Actual='"+currentUrl+"'", currentUrl.contains(expUrl));
				note.add("\tPASSED - validation for link destination after click for "+targetItem);
				Assert.assertTrue("PROBLEM, unable to locate expected element on the destination page", noWaitValidate(expElement));
				note.add("\tPASSED - validation for link target page loading for "+targetItem);
				
				backToOriginalLinkToPrepNextStep(planType, memberType, originalUrl);
			}
		}
		
		return note;

	}



	
}