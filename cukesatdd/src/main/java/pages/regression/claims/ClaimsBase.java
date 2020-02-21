package pages.regression.claims;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/** methods used by either of both Claims Summary and Claim Details page */
public class ClaimsBase extends UhcDriver  {

	@FindBy (xpath= "//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li")
	protected List<WebElement> comboTabs;	

	@FindBy(xpath="//div[contains(@class,'claimsSummaryAllTables')]/table[not(contains(@class,'ng-hide'))]")
	protected WebElement anyTypeOfClaimsTbl;

	@FindBy(xpath="//span[@id='numClaims1']")	
	protected WebElement numClaimsMed;

	@FindBy(xpath="//span[@id='numClaims4']")	
	protected WebElement numClaimsDrugCustSrch;

	@FindBy(xpath="//span[contains(@class,'days-title')]//span[@id='numClaims2']")
	protected WebElement numClaimsMedlCustSrch;

	@FindBy(xpath="//span[@id='numClaims6']")	
	protected WebElement numClaimsShipCustSrch;

	@FindBy(xpath="//span[@id='numClaims3']")	
	protected WebElement numClaimsDrug;

	@FindBy(xpath="//span[@id='numClaims5']")	
	protected WebElement numClaimsShip;

	@FindBy(xpath="//p[contains(text(),'There are no claims available')]")
	protected WebElement noClaimsRedTxt;

	//note: need help section
	@FindBy(xpath="//h2[contains(@class,'atdd-need-help')]")
	protected WebElement needHelp_SectionHeader;

	//note: need help - technical section
	@FindBy(xpath="//div[contains(@class,'technical section')]")
	protected WebElement needHelp_TechSupp;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[1]//img")
	protected WebElement needHelp_TechSupp_img;

	@FindBy(xpath="//div[contains(@class,'technical section')]/div/div/p[1]")
	protected WebElement needHelp_TechSupp_ph;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[2]")
	protected WebElement needHelp_TechSupp_tty;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[3]")
	protected WebElement needHelp_TechSupp_wkdyHrs;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[4]")
	protected WebElement needHelp_TechSupp_wkndHrs;

	//note: need help - general section
	@FindBy(xpath="//div[contains(@class,'general section')]")
	protected WebElement needHelp_GenQue;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[1]//img")
	protected WebElement needHelp_GenQue_img;

	@FindBy(xpath="//div[contains(@class,'general section')]/div/div/p[1]")
	protected WebElement needHelp_GenQue_ph;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[2]")
	protected WebElement needHelp_GenQue_tty;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[3]")
	protected WebElement needHelp_GenQue_wkdyHrs;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[4]")
	protected WebElement needHelp_GenQue_wkndHrs;

	//note: need help - claims section
	@FindBy(xpath="//div[contains(@class,'claims section')]")
	protected WebElement needHelp_ClaimsSupp;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[1]//img")
	protected WebElement needHelp_ClaimsSupp_img;

	@FindBy(xpath="//div[contains(@class,'claims section')]/div/div/div/p[1]")
	protected WebElement needHelp_ClaimsSupp_ph;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[2]")
	protected WebElement needHelp_ClaimsSupp_tty;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[3]")
	protected WebElement needHelp_ClaimsSupp_wkdyHrs;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[4]")
	protected WebElement needHelp_ClaimsSupp_wkndHrs;

	//note: need help - plan support
	@FindBy(xpath="//div[contains(@class,'plan section')]")
	protected WebElement needHelp_PlanSupp;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[1]//img")
	protected WebElement needHelp_PlanSupp_img;

	@FindBy(xpath="//div[contains(@class,'plan section')]/div/div/p[1]")
	protected WebElement needHelp_PlanSupp_ph;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[2]")
	protected WebElement needHelp_PlanSupp_tty;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[3]")
	protected WebElement needHelp_PlanSupp_wkdyHrs;

	//note: need help - more ways
	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')][contains(text(),'See more ways to')]")
	protected WebElement needHelp_seeMoreWaysTo;

	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')]//a[contains(text(),'contact us')]")
	protected WebElement needHelp_contactUsLink;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Med') and contains(.,'Drug')]") 
	protected WebElement comboTab_MAPD;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Supplement')]") 
	protected WebElement comboTab_SHIP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Prescription Drug Plan') and not(contains(.,'Med'))]") 
	protected WebElement comboTab_PDP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Senior Supplement Plan')]") 
	protected WebElement comboTab_SSUP;

	@FindBy(xpath="//div[contains(@class,'AdobeAcrobatComponent') and not(contains(@class,'ng-hide'))]//p//b[contains(text(),'This page contains PDF documents')]")
	protected WebElement adobePdfDocText;
	
	@FindBy(id="artEXPOiFrame")
	protected List<WebElement> IPerceptionsSmileySurveyFrame;

	@FindBy(xpath="//div[@id='expoIconSection']//button[@id='expoBtnClose']")
	protected WebElement closeBtn;
	
	@FindBy(xpath="//div[contains(@class,'claimloadingimage')]")
	protected WebElement claimloadingimage;

	public ClaimsBase(WebDriver driver) {
		super(driver);
		onlyTestUiFlag=false;
	}

	@Override
	public void openAndValidate() throws InterruptedException {
	}

	boolean onlyTestUiFlag;
	
	public void setOnlyTestUiFlag(boolean input) {
		System.out.println("Setting onlyTestUiFlag="+onlyTestUiFlag);
		onlyTestUiFlag=input;
	}

	public boolean getOnlyTestUiFlag() {
		return onlyTestUiFlag;
	}
	
	/**
	 * helper method to validate Need Help section content bases on input
	 * @param section
	 * @param SectionElement
	 * @param imgElement
	 * @param phoneElement
	 * @param ttyElement
	 * @param hrsOperationElement1
	 * @param hrsOperationElement2
	 */
	public void validateNeedHelpSection(String section, WebElement SectionElement, 
			WebElement imgElement, WebElement phoneElement, WebElement ttyElement, 
			WebElement hrsOperationElement1, WebElement hrsOperationElement2) {
		System.out.println("Proceed to validate the "+section+" section content");
		Assert.assertTrue("PROBLEM - unable to locate the "+section+" section element",
				claimsValidate(SectionElement));
		Assert.assertTrue("PROBLEM - unable to locate the img elemnt in "+section+" section",
				claimsValidate(imgElement));
		Assert.assertTrue("PROBLEM - unable to locate the phone elemnt in "+section+" section",
				claimsValidate(phoneElement));
		Assert.assertTrue("PROBLEM - unable to locate the TTY elemnt in "+section+" section",
				claimsValidate(ttyElement));
		Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section",
				claimsValidate(hrsOperationElement1));
		if (hrsOperationElement2!=null) {
			Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section",
					claimsValidate(hrsOperationElement2));
		}
	}

	/**
	 * helper method to retrieve the previously stored number of claims value for a given search range for validation
	 * @param range
	 * @param claimType
	 * @return
	 */
	public int getNumClaims(String range, String claimType) {
		CommonUtility.checkPageIsReady(driver);
		int sec=waitForClaimPageToLoad();
		Assert.assertTrue("PROBLEM - waited total of '"+sec+"' seconds and still seeing claimloadingimage at this point, something maybe wrong...", !claimsValidate(claimloadingimage));
		WebElement numClaimsElement=numClaimsMed;
		if (range.equalsIgnoreCase("custom search")) {
			if (claimType.equalsIgnoreCase("prescription drug")) {
				numClaimsElement=numClaimsDrugCustSrch;
			} else if (claimType.equalsIgnoreCase("medical")) {
				if (claimsValidate(numClaimsMedlCustSrch))
					numClaimsElement=numClaimsMedlCustSrch;
			} else {
				numClaimsElement=numClaimsShipCustSrch;
			}
		} else {
			if (claimType.equalsIgnoreCase("prescription drug")) {
				numClaimsElement=numClaimsDrug;
			} else if (claimType.equalsIgnoreCase("medical")) {
				numClaimsElement=numClaimsMed;
			} else {
				numClaimsElement=numClaimsShip;
			}
		}
		if (getOnlyTestUiFlag() && !claimsValidate(numClaimsElement)) { //note: if test UI only then just return claims=0 when element not found  
			return 0;
		} else {
			Assert.assertTrue("PROBLEM - unable to locate the element for number of claims for range="+range, 
				claimsValidate(numClaimsElement));
		}
		try {
			sleepBySec(15); //note: force a wait here, sometime it takes long to see the result
			int numClaims=Integer.valueOf(numClaimsElement.getText().trim());
			System.out.println("numClaims="+numClaims);	
			if (numClaims>0)
				Assert.assertTrue("PROBLEM - 'There are no claims..' message should not show when number of claims >0",!claimsValidate(noClaimsRedTxt));
			return numClaims;
		} catch (Exception e) {
			System.out.println("Exception e: "+e);
			Assert.assertTrue("PROBLEM: Unable to locate the value for number of claim for given range="+range,false);
		}
		return 0;
	}

	/** 
	 * helper method to convert date string format for validation
	 * @param inputDateString
	 * @return
	 */
	public String convertDateFormat(String inputDateString) {
		String dateStr="";
		try {
			DateFormat srcDf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = srcDf.parse(inputDateString);	 // parse the date string into Date object
			DateFormat destDf = new SimpleDateFormat("MM/dd/yyyy");
			dateStr = destDf.format(date);	// format the date into another format
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dateStr;
	}

	/**
	 * Validate each section in Need Help section on claims summary page
	 * @param planType
	 */
	public String validateSectionInNeedHelp(String planType, String memberType) {
		if (planType.equalsIgnoreCase("SHIP")) {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",
					claimsValidate(needHelp_SectionHeader));

			String validateSection="Need Help - Technical Support";
			validateNeedHelpSection(validateSection, needHelp_TechSupp, 
					needHelp_TechSupp_img, needHelp_TechSupp_ph, 
					needHelp_TechSupp_tty, needHelp_TechSupp_wkdyHrs,
					needHelp_TechSupp_wkndHrs);

			validateSection="Need Help - General Questions";
			validateNeedHelpSection(validateSection, needHelp_GenQue, 
					needHelp_GenQue_img, needHelp_GenQue_ph, 
					needHelp_GenQue_tty, needHelp_GenQue_wkdyHrs,
					needHelp_GenQue_wkndHrs);

			validateSection="Need Help - Claims Support";
			validateNeedHelpSection(validateSection, needHelp_ClaimsSupp, 
					needHelp_ClaimsSupp_img, needHelp_ClaimsSupp_ph, 
					needHelp_ClaimsSupp_tty, needHelp_ClaimsSupp_wkdyHrs,
					needHelp_ClaimsSupp_wkndHrs);

			System.out.println("Proceed to validate the Need Help - See More Ways section content");
			Assert.assertTrue("PROBLEM - unable to locate the 'See more ways to' text in Need Help section",
					claimsValidate(needHelp_seeMoreWaysTo));
			Assert.assertTrue("PROBLEM - unable to locate the 'contact us' link in Need Help section",
					claimsValidate(needHelp_contactUsLink));
			String originalUrl=driver.getCurrentUrl();
			needHelp_contactUsLink.click();
			CommonUtility.checkPageIsReady(driver);
			//note: handle combo tab
			//note: if specific scenario target combo user then flag if no combo, else just select right plan and move on
			if (memberType.toLowerCase().contains("combo")) { 
				System.out.println("This test is for combo plans, select the tab accordingly");
				goToSpecificComboTab(planType); //note: click the target tab for testing, manual run one click is okay
				goToSpecificComboTab(planType); //note: but selenium needs 2 clicks for this to work here, dunno why
			} else {
				boolean flagNonCombo=false; //note: if user has combo then select the right plan
				goToSpecificComboTab(planType, flagNonCombo); 
				goToSpecificComboTab(planType, flagNonCombo); 
			}
			String expContactUsTitle="Help & Contact Us";
			String expContactUsUrl="content/medicare/member/contact-us/overview.html#/contact-us-three";
			System.out.println("New window URL = "+driver.getCurrentUrl()+" | New window title = "+driver.getTitle());
			Assert.assertTrue("PROBLEM - not getting expected contact us URL. "
					+ "Expected to contains='"+expContactUsUrl+"' | Actual URL='"+driver.getCurrentUrl()+"'", 
					driver.getCurrentUrl().contains(expContactUsUrl));
			Assert.assertTrue("PROBLEM - not getting expected contact us Title. "
					+ "Expected to contains='"+expContactUsTitle+"' | Actual URL='"+driver.getTitle()+"'", 
					driver.getTitle().contains(expContactUsTitle));
			//note: handle combo tab
			//note: if specific scenario target combo user then flag if no combo, else just select right plan and move on
			if (memberType.toLowerCase().contains("combo")) {
				driver.get(originalUrl);
				goToSpecificComboTab(planType); 
			} else {
				driver.navigate().back();
				boolean flagNonCombo=false; //note: if user has combo then select the right plan
				goToSpecificComboTab(planType, flagNonCombo); 
			}
		} else {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",
					claimsValidate(needHelp_SectionHeader));

			String validateSection="Need Help - Technical Support";
			validateNeedHelpSection(validateSection, needHelp_TechSupp, needHelp_TechSupp_img, 
					needHelp_TechSupp_ph, needHelp_TechSupp_tty, needHelp_TechSupp_wkdyHrs,null);

			validateSection="Need Help - Plan Support";
			validateNeedHelpSection(validateSection, needHelp_PlanSupp, needHelp_PlanSupp_img, 
					needHelp_PlanSupp_ph, needHelp_PlanSupp_tty, needHelp_PlanSupp_wkdyHrs, null);
		}
		System.out.println("Main window = "+driver.getTitle());
		return driver.getCurrentUrl();
	}

	/**
	 * Navigate to specific plan for combo user, default will fail it if user doesn't have combo
	 * @param planType
	 */
	public void goToSpecificComboTab(String planType) {
		try {
			if (planType.equalsIgnoreCase("mapd")) {
				Assert.assertTrue("PROBLEM - unable to locate combo tab for MAPD", claimsValidate(comboTab_MAPD));
				comboTab_MAPD.click();
			} else if (planType.equalsIgnoreCase("ship")) {
				Assert.assertTrue("PROBLEM - unable to locate combo tab for SHIP", claimsValidate(comboTab_SHIP));
				comboTab_SHIP.click();
			} else if (planType.equalsIgnoreCase("pdp")) {
				Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", claimsValidate(comboTab_PDP));
				comboTab_PDP.click();
			} else if (planType.equalsIgnoreCase("ssup")) {
				Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", claimsValidate(comboTab_SSUP));
				comboTab_SSUP.click();
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
					if (claimsValidate(comboTab_MAPD))
						comboTab_MAPD.click();
				} else if (planType.equalsIgnoreCase("ship")) {
					if (claimsValidate(comboTab_SHIP)) 
						comboTab_SHIP.click();
				} else if (planType.equalsIgnoreCase("pdp")) {
					if (claimsValidate(comboTab_PDP))
						comboTab_PDP.click();
				} else if (planType.equalsIgnoreCase("ssup")) {
					if (claimsValidate(comboTab_SSUP)) 
						comboTab_SSUP.click();
				} 
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}


	/**
	 * Validate Adobe PDF section on claims summary and details page
	 * @return
	 */
	public boolean validateAdobePdfDocText() {
		boolean bypass_INC11365785_containsPdfDocText=false;
		System.out.println("Validate PDF Doc text section exists");
		if (claimsValidate(adobePdfDocText)) {
			Assert.assertTrue("PROBLEM - unable to locate the Adobe PDF section",claimsValidate(adobePdfDocText));
		} else {
			System.out.println("Encountered issue from INC11365785, ignore for now until it's fixed.  "
					+ "TODO: When fixed, take out this else portion");
			bypass_INC11365785_containsPdfDocText=true;
		}
		return bypass_INC11365785_containsPdfDocText;
	}

	/**
	 * Helper method for data gathering
	 * @param elementXpath
	 * @return
	 */
	public double findValue(String elementXpath) {
		WebElement r=driver.findElement(By.xpath(elementXpath));
		return Double.valueOf(r.getText().replace("$", "").replace(",",""));
	}

	/**
	 * Helper method for data gathering
	 */
	public double findValue(WebElement e) {
		return Double.valueOf(e.getText().replace("$", "").replace(",",""));
	}

	public double format(double x) {
		return Math.round(x * 100.0) / 100.0;
	}


	/**
	 * to validate whether element exists, default up to 2 seconds timeout
	 * @param element
	 * @return
	 */
	public boolean claimsValidate(WebElement element) {
		long timeoutInSec=0;
		return claimsValidate(element, timeoutInSec);
	} 

	/**
	 * to validate whether element exists with input timeout value control
	 * note: use this instead of the one from UhcDriver which takes up to 30 sec to timeout
	 * @param element
	 * @param timeoutInSec
	 * @return
	 */
	public boolean claimsValidate(WebElement element, long timeoutInSec) {
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
	
	public void moveMouseToElement(WebElement targetElement) {
		Actions action = new Actions(driver);
		action.moveToElement(targetElement).build().perform(); 
	}
	
	public void sleepBySec(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//System.out.println("slept for '"+sec+"' sec");
	}

	public int waitForClaimPageToLoad() {
		int maxTry=10;
		int numberOfSeconds=1;
		return waitForClaimPageToLoad(maxTry, numberOfSeconds);
	}
	
	public int waitForClaimPageToLoad(int maxTry, int numberOfSeconds) {
		int c=0;
		int total=0;
		while (c<maxTry) {
			c=c+1;
			sleepBySec(numberOfSeconds);
			total=c*numberOfSeconds;
			if (!claimsValidate(claimloadingimage)) {
				break;
			} 
			System.out.println("slept total of '"+(total)+"' seconds...");
		}
		System.out.println("waited total of '"+(total)+"' seconds for the claimloadingimage to disappear...");
		return total;
	}
	
	public void validateCurrencyFormat(String inputKey, String inputStr) {
		inputStr=inputStr.replaceAll("\\s", "");
		Number number = null;
		try {
		    number = NumberFormat.getCurrencyInstance(Locale.US).parse(inputStr);
		} catch(ParseException pe) {
		    Assert.assertTrue("PROBLEM - unable to parse value to currency format", false);
		}
		Assert.assertTrue("PROBLEM - '"+inputKey+"' field data value format is not expected currency format.  Expected: $xx.xx | Actual: "+inputStr, number !=null);
		System.out.println("'"+inputKey+"' data value '"+inputStr+"' passed currency format validation");
	}

	public void validateMonthFirstDateFormat(String inputKey, String inputStr, String delimiter) {
		String datePattern="\\d{2}"+delimiter+"\\d{2}"+delimiter+"\\d{4}";
		Assert.assertTrue("PROBLEM - '"+inputKey+"' field data format is not as expected. Expected: MM"+delimiter+"dd"+delimiter+"yyyy.  "
				+ "Current: "+inputStr, 
				inputStr.matches(datePattern));
		System.out.println("'"+inputKey+"' data value '"+inputStr+"' passed date format validation");
	}
	
	public void validateYearFirstDateFormat(String inputKey, String inputStr, String delimiter) {
		String datePattern="\\d{4}"+delimiter+"\\d{2}"+delimiter+"\\d{2}";
		Assert.assertTrue("PROBLEM - '"+inputKey+"' field data format is not as expected. Expected: yyyy"+delimiter+"MM"+delimiter+"dd.  "
				+ "Current: "+inputStr, 
				inputStr.matches(datePattern));
		System.out.println("'"+inputKey+"' data value '"+inputStr+"' passed date format validation");
	}
	
	public void claimCheckModelPopup(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
		checkModelPopup(driver,5);
		//note: UhcDriver default is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 

	}
}