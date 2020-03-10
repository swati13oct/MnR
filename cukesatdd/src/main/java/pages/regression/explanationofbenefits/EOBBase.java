/**
 * 
 */
package pages.regression.explanationofbenefits;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.joda.time.DateTime;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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

	public int waitForEobPageToLoad() {
		int maxTry=10;
		int numberOfSeconds=1;
		return waitForEobPageToLoad(maxTry, numberOfSeconds);
	}
	
	public int waitForEobPageToLoad(int maxTry, int numberOfSeconds) {
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
		sleepBySec(5);
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
		if (planType.equalsIgnoreCase("SHIP") || planType.toUpperCase().contains("MEDSUPP")) {
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
				} else if (planType.equalsIgnoreCase("ship")) {
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
}


