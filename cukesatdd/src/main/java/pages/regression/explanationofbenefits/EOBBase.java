/**
 * 
 */
package pages.regression.explanationofbenefits;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteExecuteMethod;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.html5.RemoteWebStorage;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.util.CommonUtility;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;

public class EOBBase extends EOBWebElements{

	public EOBBase(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}
	
	public void moveMouseToElement(WebElement targetElement) {
		Actions action = new Actions(driver);
		action.moveToElement(targetElement).build().perform(); 
	}

	public void sleepBySec(int sec) {
		System.out.println("Sleeping for '"+sec+"' sec");
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void eobCheckModelPopup(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
		checkModelPopup(driver,5);
		//note: UhcDriver default is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 

	}

	public int waitForEobPageToLoad(boolean mayHaveEob) {
		int maxTry=30;
		int numberOfSeconds=5;
		if (!mayHaveEob) {
			maxTry=0;
		}
		return waitForEobPageToLoad(maxTry, numberOfSeconds,mayHaveEob);
	}

	public int waitForEobPageToLoad() {
		boolean mayHaveEob=true;
		int maxTry=30;
		int numberOfSeconds=5;
		return waitForEobPageToLoad(maxTry, numberOfSeconds,mayHaveEob);
	}

	public int waitForEobPageToLoad(int maxTry, int numberOfSeconds) {
		boolean mayHaveEob=true;
		return waitForEobPageToLoad(maxTry, numberOfSeconds, mayHaveEob);
	}
	
	public int waitForEobPageToLoad(int maxTry, int numberOfSeconds, boolean mayHaveEob) {
		int c=0;
		int total=0;
		while (c<maxTry) {
			c=c+1;
			sleepBySec(numberOfSeconds);
			total=c*numberOfSeconds;
			if (!eobValidate(eobLoadingimage)) {
				break;
			} 
			System.out.println("slept total of '"+(total)+"' seconds...");
		}
		System.out.println("waited total of '"+(total)+"' seconds for the eobLoadingimage to disappear...");
		if (mayHaveEob)
			sleepBySec(5); //note: keep to let the page settle down w/ the pdf loading in the background
		return total;
	}
	
	/**
	 * Validate Need Help section content
	 * @param planType
	 * @param memberType
	 * @return
	 * @throws InterruptedException 
	 */
	public String validateNeedHelpSection(String planType, String memberType) throws InterruptedException {
		handleComboTabIfComboUser(planType, memberType);
		if (planType.contains("SHIP") || planType.toUpperCase().contains("MEDSUPP")) {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",eobValidate(needHelp_SectionHeader));

			String validateSection="Need Help - Technical Support";
			validateNeedHelpSectionContent(validateSection, needHelp_TechicalSupportSection, needHelp_TechicalSupport_img, needHelp_TechicalSupport_phone, needHelp_TechicalSupport_tty, needHelp_TechicalSupport_wkDayHrs,needHelp_TechicalSupport_wkEndHrs);

			validateSection="Need Help - General Questions";
			validateNeedHelpSectionContent(validateSection, needHelp_GeneralQuestionsSection, needHelp_GeneralQuestions_img, needHelp_GeneralQuestions_phone, needHelp_GeneralQuestions_tty, needHelp_GeneralQuestions_wkDayHrs,needHelp_GeneralQuestions_wkEndHrs);

			validateSection="Need Help - Claims Support";
			validateNeedHelpSectionContent(validateSection, needHelp_ClaimsSupportSection, needHelp_ClaimsSupport_img, needHelp_ClaimsSupport_phone, needHelp_ClaimsSupport_tty, needHelp_ClaimsSupport_wkDayHrs,needHelp_ClaimsSupport_wkEndHrs);

			System.out.println("Proceed to validate the Need Help - See More Ways section content");
			Assert.assertTrue("PROBLEM - unable to locate the 'See more ways to' text in Need Help section",eobValidate(needHelp_seeMoreWaysTo));
			Assert.assertTrue("PROBLEM - unable to locate the 'contact us' link in Need Help section",eobValidate(needHelp_contactUsLink));
			String originalUrl=driver.getCurrentUrl();
			needHelp_contactUsLink.click();
			CommonUtility.checkPageIsReady(driver);
			handleComboTabIfComboUser(planType, memberType);
			String expContactUsTitle="Help & Contact Us";
			String expContactUsUrl="content/medicare/member/contact-us/overview.html#/contact-us-three";
			System.out.println("New window URL = "+driver.getCurrentUrl()+"| New window title = "+driver.getTitle());
			Assert.assertTrue("PROBLEM - not getting expected contact us URL. Expected to contains='"+expContactUsUrl+"' | Actual URL='"+driver.getCurrentUrl()+"'", driver.getCurrentUrl().contains(expContactUsUrl));
			Assert.assertTrue("PROBLEM - not getting expected contact us Title. Expected to contains='"+expContactUsTitle+"' | Actual URL='"+driver.getTitle()+"'", driver.getTitle().contains(expContactUsTitle));
			goBackToPriorPageViaBack(planType, memberType, originalUrl);
		} else {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",eobValidate(needHelp_SectionHeader));

			String validateSection="Need Help - Technical Support";
			validateNeedHelpSectionContent(validateSection, needHelp_TechicalSupportSection, needHelp_TechicalSupport_img, needHelp_TechicalSupport_phone, needHelp_TechicalSupport_tty, needHelp_TechicalSupport_wkDayHrs,null);

			validateSection="Need Help - Plan Support";
			validateNeedHelpSectionContent(validateSection, needHelp_PlanSupportSection, needHelp_PlanSupport_img, needHelp_PlanSupport_phone, needHelp_PlanSupport_tty, needHelp_PlanSupport_wkDayHrs, null);
		}
		System.out.println("Main window = "+driver.getTitle());
		return driver.getCurrentUrl();
	}

	/**
	 * Helper method for validating Need Help section
	 * @param section
	 * @param SectionElement
	 * @param imgElement
	 * @param phoneElement
	 * @param ttyElement
	 * @param hrsOperationElement1
	 * @param hrsOperationElement2
	 */
	public void validateNeedHelpSectionContent(String section, WebElement SectionElement, WebElement imgElement, 
			WebElement phoneElement, WebElement ttyElement, WebElement hrsOperationElement1, WebElement hrsOperationElement2) {
		System.out.println("Proceed to validate the "+section+" section content");
		Assert.assertTrue("PROBLEM - unable to locate the "+section+" section element",eobValidate(SectionElement));
		Assert.assertTrue("PROBLEM - unable to locate the img elemnt in "+section+" section",eobValidate(imgElement));
		Assert.assertTrue("PROBLEM - unable to locate the phone elemnt in "+section+" section",eobValidate(phoneElement));
		Assert.assertTrue("PROBLEM - unable to locate the TTY elemnt in "+section+" section",eobValidate(ttyElement));
		Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section",eobValidate(hrsOperationElement1));
		if (hrsOperationElement2!=null) {
			Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section",eobValidate(hrsOperationElement2));
		}
	}
	
	/**
	 * Helper method to go back to prior page via browser back, also handles the case if combo tab is involved
	 * @param planType
	 * @param memberType
	 * @param originalUrl
	 * @throws InterruptedException 
	 */
	public void goBackToPriorPageViaBack(String planType, String memberType,String originalUrl) throws InterruptedException {
		if (memberType.toLowerCase().contains("combo")) {
			driver.get(originalUrl);
			goToSpecificComboTab(planType); 
		} else {
			driver.navigate().back();
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
					if (eobValidate(comboTab_MAPD))
						comboTab_MAPD.click();
				} else if (planType.toLowerCase().contains("ma") && !planType.toLowerCase().contains("pd")) {
					if (eobValidate(comboTab_MA))
						comboTab_MA.click();
				} else if (planType.equalsIgnoreCase("ship") || planType.toLowerCase().contains("ship")) {
					if (eobValidate(comboTab_SHIP)) 
						comboTab_SHIP.click();
				} else if (planType.equalsIgnoreCase("pdp")) {
					if (eobValidate(comboTab_PDP))
						comboTab_PDP.click();
				} else if (planType.equalsIgnoreCase("ssp")) {
					if (eobValidate(comboTab_SSP)) 
						comboTab_SSP.click();
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
				Assert.assertTrue("PROBLEM - unable to locate combo tab for MAPD", eobValidate(comboTab_MAPD));
				comboTab_MAPD.click();
			} else if (planType.toLowerCase().contains("ma") && !planType.toLowerCase().contains("pd")) {
				Assert.assertTrue("PROBLEM - unable to locate combo tab for MA", eobValidate(comboTab_MA));
				comboTab_MA.click();
			} else if (planType.toLowerCase().contains("ship_hip")) {
				Assert.assertTrue("PROBLEM - unable to locate combo tab for SHIP_HIP", eobValidate(comboTab_SHIP_HIP));
				comboTab_SHIP_HIP.click();
			} else if (planType.toLowerCase().contains("ship")) {
				Assert.assertTrue("PROBLEM - unable to locate combo tab for SHIP", eobValidate(comboTab_SHIP));
				comboTab_SHIP.click();
			} else if (planType.toLowerCase().contains("pdp")) {
				Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", eobValidate(comboTab_PDP));
				comboTab_PDP.click();
			} else if (planType.toLowerCase().contains("ssp")) {
				Assert.assertTrue("PROBLEM - unable to locate combo tab for SSP", eobValidate(comboTab_SSP));
				comboTab_SSP.click();
			} else {
				Assert.assertTrue("PROBLEM - need to enhance code to cover planType '"+planType+"' for combo testing", false);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Helper method to click on the target test plan on combo tab
	 * @param planType
	 * @param memberType
	 * @throws InterruptedException 
	 */
	public void handleComboTabIfComboUser(String planType, String memberType) throws InterruptedException {
		if (memberType.toLowerCase().contains("combo")) {
			System.out.println("This test is for combo plans, select the tab accordingly");
			goToSpecificComboTab(planType);
		} else {
			boolean flagNonCombo=false;
			goToSpecificComboTab(planType,flagNonCombo);
		}
	}

	public boolean eobValidate(WebElement element) {
		long timeoutInSec=0;
		return eobValidate(element, timeoutInSec);
	} 

	/**
	 * to validate whether element exists with input timeout value control
	 * note: use this instead of the one from UhcDriver which takes up to 30 sec to timeout
	 * @param element
	 * @param timeoutInSec
	 * @return
	 */
	public boolean eobValidate(WebElement element, long timeoutInSec) {
		//note: if ever need to control the wait time out, use the one in UhcDriver validate(element, timeoutInSec)
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		try {
			if (element.isDisplayed()) {
				System.out.println("Element '"+element.toString()+"' found!!!!");
				return true;
			} else {
				System.out.println("Element '"+element.toString()+"' not found/not visible");
			}
		} catch (Exception e) {
			System.out.println("Element '"+element.toString()+"' not found/not visible. Exception");
		}
		//note: default in UhcDriver is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		return false;
	} 

	/**
	 * the method navigates user to eob page
	 */
	public EOBPage navigateDirectToEOBPag(){
		eobCheckModelPopup(driver);
		Assert.assertTrue("PROBLEM - unable to locate EOB link to go to EOB page", eobValidate(eobLink));
		eobLink.click();
		CommonUtility.checkPageIsReady(driver);
		return new EOBPage(driver);
	}

	public BenefitsAndCoveragePage navigateToBncPage(){ //note: used by member auth page
		Assert.assertTrue("PROBLEM - unable to locate Benefits and Coverage Tab", eobValidate(bncTab));
		bncTab.click();
		CommonUtility.waitForPageLoad(driver, bncPageHeader, 30);
		Assert.assertTrue("PROBLEM - unable to locate Benefits and Coverage header after navigating to Benefits and Coverage page", eobValidate(bncPageHeader));
			return new BenefitsAndCoveragePage(driver);
	}

	public void validatePlanNavTab(String planType) { //note: used by member auth page
		if(planType.equalsIgnoreCase("MAPD")||planType.equalsIgnoreCase("MA")){
			if(eobValidate(mapdNavTab))
				mapdNavTab.click();	
		}else if(planType.equalsIgnoreCase("PDP")&&eobValidate(pdpNavTab)){
			pdpNavTab.click();
		}else if((planType.equalsIgnoreCase("MEDSUPP")||planType.equalsIgnoreCase("SHIP"))){
			if(eobValidate(medsuppNavTab))
				medsuppNavTab.click();
		}	
	}
	
	public String getUuid() {
		String consumerDetails=getConsumerDetailsFromlocalStorage();
		String uuid=getUuidInConsumerDetails(consumerDetails);
		return uuid;
	}
	
	public String getConsumerDetailsFromlocalStorage() {
		//WebStorage webStorage = (WebStorage) new Augmenter().augment(driver) ;
		 RemoteExecuteMethod executeMethod = new RemoteExecuteMethod((RemoteWebDriver) driver);
		 RemoteWebStorage webStorage = new RemoteWebStorage(executeMethod);
		LocalStorage localStorage = webStorage.getLocalStorage();
		String consumerDetails=localStorage.getItem("consumerDetails");
		return consumerDetails;
	}
	
	public String getMemberId(Boolean isComboUser, String planType) {
		//note: if planType is for SHIP, parse the value to get the actual plan category name
		String lookForPlanCategory= planType;
		if (planType.contains("SHIP")) {
			String[] tmp=planType.split("SHIP_");
			Assert.assertTrue("PROBLEM - input setup for planType for SHIP needs to include planCategory which is used for validation, e.g. SHIP_<planCategory>", tmp.length>1);
			lookForPlanCategory=tmp[1];
		}
		String consumerDetails=getConsumerDetailsFromlocalStorage();
		String memberId = getMemberIdInConsumerDetails(isComboUser, lookForPlanCategory, consumerDetails);
		return memberId;
	}
	
	public String getUuidInConsumerDetails(String consumerDetails) {
		String actualUuid=null;
		try {
			JSONParser parser = new JSONParser();
			JSONObject apiResponseJsobObj=(JSONObject) parser.parse(consumerDetails);
			actualUuid = (String) apiResponseJsobObj.get("userTag");
		} catch (ParseException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - encounted problem reading the json result from localStorage.consumerDetails", false);
		}
		//note: clean up the string
		if (actualUuid!=null) {
			if (actualUuid.contains("[")) {
				String[] tmp=actualUuid.split("\\[");
				actualUuid=tmp[0];
			}
		}
		
		return actualUuid;
	}
	
	public String getMemberIdInConsumerDetails(boolean isComboUser, String lookForPlanCategory, String consumerDetails) {
		//System.out.println("TEST - consumerDetails="+consumerDetails);
		String actualMemberId=null;
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
				System.out.println("TEST - lookForPlanCategory="+lookForPlanCategory);
				System.out.println("TEST - actualPlanCategory="+actualPlanCategory);
				if (lookForPlanCategory.equals(actualPlanCategory)) {
					actualMemberId = (String) planProfilesObj.get("memberNumber");
					Assert.assertTrue("PROBLEM - unable to locate memberNumber from localStorage.consumerDetails, "
							+ "please check to see if getConsumerInfo API response contains non-null memberNumber, consumerDetails="+consumerDetails, 
							actualMemberId!=null);
				} 
			}			
			Assert.assertTrue("PROBLEM - unable to locate the expected planType from localStorage.consumerDetails, "
					+ "please check to see if feature file input parameter planType contains the actual planType that is in getConsumerInfo API, consumerDetails="+consumerDetails, 
					actualMemberId!=null);
			

		} catch (ParseException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - encounted problem reading the json result from localStorage.consumerDetails", false);
		}
		return actualMemberId;
	}

	public String parseLine(String apiReqeust) {
		JSONParser parser = new JSONParser();
		JSONObject jsobObj=null;
		try {
			jsobObj = (JSONObject) parser.parse(apiReqeust);
		} catch (ParseException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - unable to convert target string into json object", false);
		}
		JSONObject messageObj;
		messageObj = (JSONObject) jsobObj.get("message");
		Assert.assertTrue("PROBLEM - unable to locate message json object", messageObj!=null);
		JSONObject paramsObj = (JSONObject) messageObj.get("params");
		Assert.assertTrue("PROBLEM - unable to locate message json object", paramsObj!=null);
		JSONObject responseObj = (JSONObject) paramsObj.get("response");
		Assert.assertTrue("PROBLEM - unable to locate message json object", responseObj!=null);
		System.out.println("TEST - responseObj="+responseObj.toString());
		Long statusValue = (Long) responseObj.get("status");
		Assert.assertTrue("PROBLEM - unable to locate postData string", statusValue!=null);
		Assert.assertTrue("PROBLEM - API response is not getting status=200 or 206.  Actual statusValue='"+statusValue+"'", statusValue==200 || statusValue==206);
		String urlStr = (String) responseObj.get("url");
		Assert.assertTrue("PROBLEM - unable to locate postData string", urlStr!=null);
		System.out.println("TEST - urlStr="+urlStr);
		return urlStr;

	}
	
	public List<String> getApiRequestUrl(String planType, String memberType, String eobType) {
		List<String> urlList=new ArrayList<String>();
		String apiReqeust=null;
		List<LogEntry> entries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
		
		if (eobType.equals("dream")) {
			//note: need to do two search
			System.out.println("TEST - first API request...");
			String lookForText1="/dreamEob/search?memberNumber=";
			String lookForText2="responseReceived";

			for (LogEntry entry : entries) {
				String line=entry.getMessage();
				//System.out.println("TEST each line="+line);
					if (line.contains(lookForText1) && line.contains(lookForText2)) {
						apiReqeust=line;
						System.out.println("TEST found line="+line);
						//break; //note: only break if looking for the first response, otherwise always take the latest line
					}
			}
			Assert.assertTrue("PROBLEM - unable to locate the network entry that contains '"+lookForText1+"' and '"+lookForText2+"'", apiReqeust!=null);
			String m_urlStr=parseLine(apiReqeust);
			System.out.println("TEST - m_urlStr="+m_urlStr);
			urlList.add(m_urlStr);
			
			if (!planType.equals("MA")) {
				System.out.println("TEST - second API request...");
				lookForText1="/dreamEob/rx/search?medicareId";
				for (LogEntry entry : entries) {
					String line=entry.getMessage();
					if (line.contains(lookForText1) && line.contains(lookForText2)) {
						apiReqeust=line;
						System.out.println("TEST found line="+line);
						//break; //note: only break if looking for the first response, otherwise always take the latest line
					}
				}
				String r_urlStr=parseLine(apiReqeust);
				System.out.println("TEST - r_urlStr="+r_urlStr);
				urlList.add(r_urlStr);
			}
			return urlList; 
		} else {
			String lookForText1="/member/claims/eob/search";  //note: non-Dream case
			String lookForText2="responseReceived";
			String lookForText3="/medical";
			if (planType.equals("PDP")) {
				lookForText3="/rx";
			} else if (planType.contains("SHIP")) {
				lookForText3="/ship";
			}
			
			for (LogEntry entry : entries) {
				String line=entry.getMessage();
				//System.out.println("TEST each line="+line);
				if (memberType.contains("COMBO")) {
					if (line.contains(lookForText1) && line.contains(lookForText2) && line.contains(lookForText3)) {
						apiReqeust=line;
						System.out.println("TEST found line="+line);
						//break;  //note: only break if looking for the first response, otherwise always take the latest line
					}
				} else {
					if (line.contains(lookForText1) && line.contains(lookForText2)) {
						apiReqeust=line;
						System.out.println("TEST found line="+line);
						//break; //note: only break if looking for the first response, otherwise always take the latest line
					}
				} 
			}
			Assert.assertTrue("PROBLEM - unable to locate the network entry that contains '"+lookForText1+"' and '"+lookForText2+"'", apiReqeust!=null);
			String urlStr=parseLine(apiReqeust);
			urlList.add(urlStr);
			System.out.println("TEST - urlStr="+urlStr);
			return urlList; 
		}
	}
	
	public String getApiResponse(String planType, String memberType, String inputUrl)  {
		String winHandleBefore = driver.getWindowHandle();
		System.out.println("Proceed to open a new blank tab to get API response");
		System.out.println("test URL= "+inputUrl);
		//open new tab
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('"+inputUrl+"','_blank');");
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
		String apiResponseJsonStr="";
		if (eobValidate(apiResponseJson)) {		
			apiResponseJsonStr=apiResponseJson.getText();
			if (!apiResponseJsonStr.contains("\"errorCode\":\"200\"") && !apiResponseJsonStr.contains("\"errorCode\":\"206\"")) {
				sleepBySec(5);
				System.out.println("Retry one more time before giving up...");
				driver.get(inputUrl);
				apiResponseJsonStr=apiResponseJson.getText();
				System.out.println("apiResponseJsonStr="+apiResponseJsonStr);
			}
		} else {
			String pgStr=driver.getPageSource();
			System.out.println("TEST - whole page source="+pgStr);
			String errorCodeStr=pgStr.substring(pgStr.indexOf("<errorCode>"),pgStr.indexOf("</errorCode>"))+"\"</errorCode>";
			errorCodeStr=errorCodeStr.replace("<errorCode>\"", "<errorCode>");
			String successStr=pgStr.substring(pgStr.indexOf("<success>"),pgStr.indexOf("</success>"))+"</success>";
			System.out.println("TEST - errorCodeStr="+errorCodeStr);
			String dataStr="";
			String[] tmp=pgStr.split("<data>");
			System.out.println("TEST - tmp.length="+tmp.length);
			for (String s: tmp) {
				if (s.contains("<esp>")) {
					String[] tmp1=s.split("</data>");
					String line="<data>"+tmp1[0]+"</data>";
					System.out.println("TEST - tmp1[0]="+tmp1[0]);
					System.out.println("TEST - line="+line);
					System.out.println("TEST - before dataStr="+dataStr);
					dataStr=dataStr+line;
					System.out.println("TEST - after dataStr="+dataStr);
				}
			}
			//tbd System.out.println("TEST - dataStr="+dataStr);
			//tbd System.out.println("TEST - successStr="+successStr);
			String xmlStr=errorCodeStr+successStr+dataStr;
			//tbd System.out.println("TEST - xmlStr="+xmlStr);
			try {
				org.json.JSONObject xmlJSONObj = XML.toJSONObject(xmlStr);
				apiResponseJsonStr = xmlJSONObj.toString();
				//tbd System.out.println("TEST - apiResponseJsonStr="+apiResponseJsonStr);
				apiResponseJsonStr=apiResponseJsonStr.replace("\\\"\"", "\"");
			} catch (JSONException je) {
				Assert.assertTrue("PROBLEM - unable to convert xml to json. xmlStr='"+xmlStr+"' |  Exception="+je.getMessage(), false);
			}
		}
		System.out.println("apiResponseJsonStr="+apiResponseJsonStr);
		driver.close();
		driver.switchTo().window(winHandleBefore);
		return apiResponseJsonStr;
	}

	public String getInfoFromApi(String planType, String memberType, String eobType) {
		//note: if calling this then assume it's non-dream, only one api call
		String apiRequestUrl=getApiRequestUrl(planType, memberType, eobType).get(0);
		System.out.println("TEST - apiRequestUrl="+apiRequestUrl);
		String apiResponseJson=getApiResponse(planType, memberType, apiRequestUrl);
		//System.out.println("TEST - apiResponseJson="+apiResponseJson);
		return apiResponseJson;
		
	}
	
	public EobApiResponse parseApiResponse(String apiResponseJson) {
		JSONParser parser = new JSONParser();
		JSONObject apiResponseJsobObj=null;
		try {
			apiResponseJsobObj = (JSONObject) parser.parse(apiResponseJson);
		} catch (ParseException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - unable to convert target string into json object. inputStr="+apiResponseJson, false);
		}
		Assert.assertTrue("PROBLEM - apiResponseJsobObj should not be null", apiResponseJsobObj!=null);
		boolean success = (Boolean) apiResponseJsobObj.get("success");
		String errorCode = (String) apiResponseJsobObj.get("errorCode");

		if (!success) {
			System.out.println("Unable to get a successful API response");
			return null;
		}
		EobApiResponse apiResponse=new EobApiResponse();
		apiResponse.setSuccess(success);
		apiResponse.setErrorCode(errorCode);


		JSONArray dataListArrayObj = (JSONArray) apiResponseJsobObj.get("data");
		if (dataListArrayObj==null) {
			System.out.println("TEST - API dataListArrayObj is null - there is no EOB in this search range");
			return apiResponse;
		} 
		for (int i=0; i<dataListArrayObj.size(); i++) {
			JSONObject eachObj = (JSONObject) dataListArrayObj.get(i);
			String eobDate = (String) eachObj.get("eobDate");
			String esp = (String) eachObj.get("esp");
			String eobType = (String) eachObj.get("eobType");
			String compoundDoc=(String) eachObj.get("compoundDoc");
			
			if (eobType!=null && !eobType.equals("")) { 
				System.out.println("TEST - this is DREAM EOB - eobDate="+eobDate+" | espType="+eobType+" | esp="+esp+" | compoundDoc="+compoundDoc);
				apiResponse.addEob(eobDate, esp, eobType, compoundDoc);
			} else {
				System.out.println("TEST - this is NON-DREAM EOB - eobDate="+eobDate+" | esp="+esp+" | compoundDoc="+compoundDoc);
				apiResponse.addEob(eobDate, esp, compoundDoc);
			}
		} 
		return apiResponse;
	}

	/**
	 * this method is to validate number of pages displayed
	 */
	public int numberOfPageDisplayed(int eobCount){
		//TODO: figure out what this one is trying to validate
		double pageCount= eobCount/10.0;
		System.out.println("TEST - pageCount="+pageCount+" = "+eobCount+"/10.0");
		int numberOfPageDisplayed = (int) Math.ceil(pageCount);
		System.out.println("TEST - numberOfPageDisplayed="+numberOfPageDisplayed+" = Math.ceil("+pageCount+")");
		System.out.println(numberOfPageDisplayed + " Page displayed for EOBs");
		return numberOfPageDisplayed;
	}

	public boolean findEobOptionUnderClaims() {
		return eobValidate(eobOptionUnderClaimsMenu);
	}
	
	public void scrollElementToCenterScreen(WebElement element) {
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
				+ "var elementTop = arguments[0].getBoundingClientRect().top;"
				+ "window.scrollBy(0, elementTop-(viewPortHeight/2));";
		((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
		System.out.println("TEST - move element to center view"); 
	}

}


