package pages.regression.planDocumentsAndResources;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang.time.StopWatch;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;

public class PlanDocumentsAndResourcesBaseHelper extends PlanDocumentsAndResourcesWebElements  {
	
	public PlanDocumentsAndResourcesBaseHelper(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
	}

	@Override
	public void openAndValidate() throws InterruptedException {

	}

	/**
	 * to validate whether element exists, default up to 2 seconds timeout
	 * @param element
	 * @return
	 */
	public boolean planDocValidate(WebElement element) {
		long timeoutInSec=0;
		return planDocValidate(element, timeoutInSec);
	} 

	public boolean planDocValidate(String inputXpath) {
		long timeoutInSec=0;
		return planDocValidate(inputXpath, timeoutInSec);
	} 
	/**
	 * to validate whether element exists with input timeout value control
	 * note: use this instead of the one from UhcDriver which takes up to 30 sec to timeout
	 * @param element
	 * @param timeoutInSec
	 * @return
	 */
	public boolean planDocValidate(WebElement element, long timeoutInSec) {
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
	

	public boolean planDocValidate(String inputXpath, long timeoutInSec) {
		//note: if ever need to control the wait time out, use the one in UhcDriver validate(element, timeoutInSec)
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		try {
			WebElement element=driver.findElement(By.xpath(inputXpath));
			if (element.isDisplayed()) {
				System.out.println("Element '"+element.toString()+"' found!!!!");
				return true;
			} else {
				System.out.println("Element '"+element.toString()+"' not found/not visible");
			}
		} catch (Exception e) {
			System.out.println("Element with xpath='"+inputXpath+"' not found/not visible. Exception");
		}
		//note: default in UhcDriver is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		return false;
	} 
	
	public void handleHowIsYourVisit() {
		int counter = 0;
		do {
			System.out.println("current value of counter: " + counter);
			if (IPerceptionsSmileySurveyFrame.isEmpty()) {
				sleepBySec(1);
			} else {
				System.out.println("iperception smiley survey was displayed, check to see if need to close it");
				driver.switchTo().frame("artEXPOiFrame");
				try {
					closeBtn.click();
					System.out.println("closed the iperception smiley survey");
				} catch (WebDriverException e) {
					System.out.println("nothing need to click for iperception smiley survey");
				}
				driver.switchTo().defaultContent();
				break;
			}
			counter++;
		} while (counter < 2);
	}
	
	/**
	 * Helper method to go back to prior page via browser back, 
	 * also handles the case if combo tab is involved
	 * note: Tab structure is Suppressed if the information provided on both the tabs is exactly similar. 
	 * note: So in this case we not show the P&P page in case of a standalone ship member 
	 * note: and will show the P&P page without any Plan Tabs in case of a combo member
	 * @param planType
	 * @param memberType
	 * @param originalUrl
	 * @throws InterruptedException 
	 */
	public void goBackToPriorPgViaBack(String planType, String memberType, String origUrlBeforeClick) {
		driver.navigate().back();
		sleepBySec(5);
		isAlertPresent();
		CommonUtility.checkPageIsReady(driver);
		String expUrl="/member/documents/overview.html";
		String actUrl=driver.getCurrentUrl();
		if (!actUrl.contains(expUrl)) { //note: give it one more try before giving up
			driver.get(origUrlBeforeClick);
			sleepBySec(5);
			isAlertPresent();
			actUrl=driver.getCurrentUrl();
		}
		Assert.assertTrue("PROBLEM - unable to go back to Plan Documents and Resources page. "
				+ "Expect URL contain '"+expUrl+"' | Actual URL='"+actUrl+"'", actUrl.contains(expUrl));
		if (memberType.toLowerCase().contains("combo")) { 
			System.out.println("This test is for combo plans, select the tab accordingly");
			goToSpecificComboTab(planType); //note: click the target tab for testing, manual run one click is okay
			goToSpecificComboTab(planType); //note: but selenium needs 2 clicks for this to work here, dunno why
		}
		
		checkModelPopup(driver, 5);
		StopWatch pageLoad = new StopWatch();
		pageLoad.start();
		try {
			driver.manage().timeouts().pageLoadTimeout((forceTimeoutInMin*60), TimeUnit.SECONDS);
			System.out.println("Set pageLoadTimeout to "+forceTimeoutInMin+" min");
    		CommonUtility.checkPageIsReady(driver);
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("waited "+forceTimeoutInMin+" min for the page to finish loading, give up now");
			driver.quit(); //note: force the test to fail instead of waiting time
			Assert.assertTrue("PROBLEM - page still laoding after "+forceTimeoutInMin+" min, probably stuck, kill test now",false);
		} catch (WebDriverException we) {
			System.out.println("Got driver exception while waiting for page to finish loading, give up now");
			driver.quit(); //force the test to fail instead of waiting time
			Assert.assertTrue("PROBLEM - Got driver exception while waiting for page to finish loading",false);
		}
		int sec=5;
		if (MRScenario.environment.contains("team-a")) 
			sec=10;
		System.out.println("page load should stopped loading now, give it "+sec+" more sec to settle down");
		sleepBySec(sec); // note: give it a bit more time to settle down
		pageLoad.stop();
		long pageLoadTime_ms = pageLoad.getTime();
		long pageLoadTime_Seconds = pageLoadTime_ms / 1000;
		System.out.println("Total Page Load Time: " + pageLoadTime_ms + " milliseconds");
		System.out.println("Total Page Load Time: " + pageLoadTime_Seconds + " seconds");
	}
	
	public void refreshPage(String planType, String memberType, String origUrlBeforeClick) {
		driver.navigate().refresh();
		sleepBySec(5);
		isAlertPresent();
		CommonUtility.checkPageIsReady(driver);
		String expUrl="/member/documents/overview.html";
		String actUrl=driver.getCurrentUrl();
		if (!actUrl.contains(expUrl)) { //note: give it one more try before giving up
			driver.get(origUrlBeforeClick);
			sleepBySec(5);
			isAlertPresent();
			actUrl=driver.getCurrentUrl();
		}
		Assert.assertTrue("PROBLEM - unable to refresh Plan Documents and Resources page. "
				+ "Expect URL contain '"+expUrl+"' | Actual URL='"+actUrl+"'", actUrl.contains(expUrl));
		if (memberType.toLowerCase().contains("combo")) { 
			System.out.println("This test is for combo plans, select the tab accordingly");
			goToSpecificComboTab(planType); //note: click the target tab for testing, manual run one click is okay
			goToSpecificComboTab(planType); //note: but selenium needs 2 clicks for this to work here, dunno why
		}
		
		checkModelPopup(driver, 5);
		StopWatch pageLoad = new StopWatch();
		pageLoad.start();
		try {
			driver.manage().timeouts().pageLoadTimeout((forceTimeoutInMin*60), TimeUnit.SECONDS);
			System.out.println("Set pageLoadTimeout to "+forceTimeoutInMin+" min");
    		CommonUtility.checkPageIsReady(driver);
		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("waited "+forceTimeoutInMin+" min for the page to finish loading, give up now");
			driver.quit(); //note: force the test to fail instead of waiting time
			Assert.assertTrue("PROBLEM - page still laoding after "+forceTimeoutInMin+" min, probably stuck, kill test now",false);
		} catch (WebDriverException we) {
			System.out.println("Got driver exception while waiting for page to finish loading, give up now");
			driver.quit(); //force the test to fail instead of waiting time
			Assert.assertTrue("PROBLEM - Got driver exception while waiting for page to finish loading",false);
		}
		int sec=5;
		if (MRScenario.environment.contains("team-a")) 
			sec=10;
		System.out.println("page load should stopped loading now, give it "+sec+" more sec to settle down");
		sleepBySec(sec); // note: give it a bit more time to settle down
		pageLoad.stop();
		long pageLoadTime_ms = pageLoad.getTime();
		long pageLoadTime_Seconds = pageLoadTime_ms / 1000;
		System.out.println("Total Page Load Time: " + pageLoadTime_ms + " milliseconds");
		System.out.println("Total Page Load Time: " + pageLoadTime_Seconds + " seconds");
	}




	/**
	 * Navigate to specific plan for combo user, default will fail it if user doesn't have combo
	 * @param planType
	 */
	public void goToSpecificComboTab(String planType) {
		try {
			if (planType.equalsIgnoreCase("mapd")) {
				Assert.assertTrue("PROBLEM - unable to locate combo tab for MAPD", planDocValidate(comboTab_MAPD));
				scrollElementToCenterScreen(comboTab_MAPD);
				comboTab_MAPD.click();
			} else if (planType.equalsIgnoreCase("ship")) {
				Assert.assertTrue("PROBLEM - unable to locate combo tab for SHIP", planDocValidate(comboTab_SHIP));
				scrollElementToCenterScreen(comboTab_SHIP);
				comboTab_SHIP.click();
			} else if (planType.equalsIgnoreCase("pdp")) {
				Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", planDocValidate(comboTab_PDP));
				scrollElementToCenterScreen(comboTab_PDP);
				comboTab_PDP.click();
			} else if (planType.equalsIgnoreCase("ssp")) {
				Assert.assertTrue("PROBLEM - unable to locate combo tab for SSP", planDocValidate(comboTab_SSP));
				scrollElementToCenterScreen(comboTab_SSP);
				comboTab_SSP.click();
			} else {
				Assert.assertTrue("PROBLEM - need to enhance code to cover planType '"+planType+"' for combo testing", false);
			} 
		} catch (Exception e) {
			e.printStackTrace();
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
					if (planDocValidate(comboTab_MAPD)) {
						scrollElementToCenterScreen(comboTab_MAPD);
						comboTab_MAPD.click();
					}
				} else if (planType.equalsIgnoreCase("ship")) {
					if (planDocValidate(comboTab_SHIP)) {
						scrollElementToCenterScreen(comboTab_SHIP);
						comboTab_SHIP.click();
					}
				} else if (planType.equalsIgnoreCase("pdp")) {
					if (planDocValidate(comboTab_PDP)) {
						scrollElementToCenterScreen(comboTab_PDP);
						comboTab_PDP.click();
					}
				} else if (planType.equalsIgnoreCase("ssp")) {
					if (planDocValidate(comboTab_SSP)) {
						scrollElementToCenterScreen(comboTab_SSP);
						comboTab_SSP.click();
					}
				} 
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		sleepBySec(2);
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
	
	public void sleepByMillSec(int millsec) {
		System.out.println("Sleeping for '"+millsec+"' sec");
		try {
			Thread.sleep(millsec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void planDocCheckModelPopup(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
		checkModelPopup(driver,5);
		//note: UhcDriver default is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 

	}
	
	public void backToTopOfPage(String planType, String memberType) {
		//moveMouseToElement(pageHeader);
		checkModelPopup(driver, 5);
		if (!planDocValidate(backToTopLink)) {
			String origUrlBeforeClick=driver.getCurrentUrl();
			refreshPage(planType, memberType, origUrlBeforeClick);
		}
		backToTopLink.click();  //note: validation should already been done for this if invoking to use this at this point
		if (memberType.toLowerCase().contains("combo")) { 
			System.out.println("This test is for combo plans, select the tab accordingly");
			goToSpecificComboTab(planType); //note: click the target tab for testing, manual run one click is okay
			goToSpecificComboTab(planType); //note: but selenium needs 2 clicks for this to work here, dunno why
		}
	}

	/**
	 * helper - for test note
	 * @param text
	 * @param noteList
	 * @return
	 */
	public List<String> doNoteAndText(String text, List<String> noteList) {
		noteList.add(text);
		System.out.println(text);
		return noteList;
	}
	
	/**
	 * helper - for test note
	 * @param inputList
	 * @param noteList
	 * @return
	 */
	public List<String> doNoteAndText(List<HashMap<String, Document>> inputList, List<String> noteList) {
		String docs="";
		for (HashMap<String, Document> item: inputList) {
			//tbd noteList=doNoteAndText("    "+item.keySet(), noteList);
			docs=docs+" "+item.keySet();
		}
		noteList=doNoteAndText("    "+docs, noteList);
		return noteList;
	}

	public String getCurrentYear() {
		String currentEnvTime=getMemTestEnvSysTime();
		String[] tmpDateAndTime=currentEnvTime.split("\\\", \\\"systemtimeinmillis");
		String[] tmpDate=tmpDateAndTime[0].split("UTC ");
		String envTimeYear=tmpDate[tmpDate.length-1];
		System.out.println("TEST - sysTimeYear="+envTimeYear);
		return envTimeYear;
	}
	
	public void scrollElementToCenterScreen(WebElement element) {
		String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
		                                            + "var elementTop = arguments[0].getBoundingClientRect().top;"
		                                            + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
		((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);
		System.out.println("TEST - move element to center view"); 
		/* JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element); */
	}

	public boolean isAlertPresent() {
		try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				System.out.println("Detected Alert popup, accept it and move on...");
		} catch (NoAlertPresentException Ex) {
			System.out.println("DID NOT detect Alert popup, move on...");
			return false;
		}
		return true;
	}


	
}