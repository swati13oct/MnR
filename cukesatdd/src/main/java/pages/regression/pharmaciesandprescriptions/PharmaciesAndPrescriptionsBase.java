package pages.regression.pharmaciesandprescriptions;

import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.util.CommonUtility;

/**
 * Functionality : validations for Pharmacies & Prescriptions page
 */
public class PharmaciesAndPrescriptionsBase extends PharmaciesAndPrescriptionsWebElements{
	public PharmaciesAndPrescriptionsBase(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() { 
	}

	/**
	 * Validate Need Help section content
	 * note: Tab structure is Suppressed if the information provided on both the tabs is exactly similar. 
	 * note: So in this case we not show the P&P page in case of a standalone ship member 
	 * note: and will show the P&P page without any Plan Tabs in case of a combo member
	 * note: COMBO user with SHIP plan will have SHIP's need help content
	 * @param planType
	 * @param memberType
	 * @return
	 * @throws InterruptedException 
	 */
	public String validateNeedHelpSection(String planType, String memberType) 
			throws InterruptedException {
		//tbd handleComboTabIfComboUser(planType, memberType);
		if (planType.equalsIgnoreCase("SHIP") || planType.toUpperCase().contains("MEDSUPP")) {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",
					pnpValidate(needHelp_SectionHeader));

			String validateSection="Need Help - Technical Support";
			validateNeedHelpSectionContent(validateSection, needHelp_TechicalSupportSection, 
					needHelp_TechicalSupport_img, needHelp_TechicalSupport_phone, 
					needHelp_TechicalSupport_tty, needHelp_TechicalSupport_wkDayHrs,
					needHelp_TechicalSupport_wkEndHrs);

			validateSection="Need Help - General Questions";
			validateNeedHelpSectionContent(validateSection, needHelp_GeneralQuestionsSection, 
					needHelp_GeneralQuestions_img, needHelp_GeneralQuestions_phone, 
					needHelp_GeneralQuestions_tty, needHelp_GeneralQuestions_wkDayHrs,
					needHelp_GeneralQuestions_wkEndHrs);

			validateSection="Need Help - Claims Support";
			validateNeedHelpSectionContent(validateSection, needHelp_ClaimsSupportSection, 
					needHelp_ClaimsSupport_img, needHelp_ClaimsSupport_phone, 
					needHelp_ClaimsSupport_tty, needHelp_ClaimsSupport_wkDayHrs,
					needHelp_ClaimsSupport_wkEndHrs);

			System.out.println("Proceed to validate the Need Help - See More Ways section content");
			Assert.assertTrue("PROBLEM - unable to locate the 'See more ways to' text in Need Help section",
					pnpValidate(needHelp_seeMoreWaysTo));
			Assert.assertTrue("PROBLEM - unable to locate the 'contact us' link in Need Help section",
					pnpValidate(needHelp_contactUsLink));
			needHelp_contactUsLink.click();
			CommonUtility.checkPageIsReady(driver);
			//tbd handleComboTabIfComboUser(planType, memberType);
			String expContactUsTitle="Help & Contact Us";
			String expContactUsUrl="content/medicare/member/contact-us/overview.html#/contact-us-three";
			System.out.println("New window URL = "+driver.getCurrentUrl()+"| New window title = "+driver.getTitle());
			Assert.assertTrue("PROBLEM - not getting expected contact us URL. "
					+ "Expected to contains='"+expContactUsUrl+"' | Actual URL='"+driver.getCurrentUrl()+"'", 
					driver.getCurrentUrl().contains(expContactUsUrl));
			Assert.assertTrue("PROBLEM - not getting expected contact us Title. "
					+ "Expected to contains='"+expContactUsTitle+"' | Actual URL='"+driver.getTitle()+"'", 
					driver.getTitle().contains(expContactUsTitle));
			goBackToPriorPnPpgViaBack(planType, memberType);
		} else {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",
					pnpValidate(needHelp_SectionHeader));

			String validateSection="Need Help - Technical Support";
			validateNeedHelpSectionContent(validateSection, needHelp_TechicalSupportSection, 
					needHelp_TechicalSupport_img, needHelp_TechicalSupport_phone, 
					needHelp_TechicalSupport_tty, needHelp_TechicalSupport_wkDayHrs,null);

			validateSection="Need Help - Plan Support";
			validateNeedHelpSectionContent(validateSection, needHelp_PlanSupportSection, 
					needHelp_PlanSupport_img, needHelp_PlanSupport_phone, needHelp_PlanSupport_tty, 
					needHelp_PlanSupport_wkDayHrs, null);
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
		Assert.assertTrue("PROBLEM - unable to locate the "+section+" section element", pnpValidate(SectionElement));
		Assert.assertTrue("PROBLEM - unable to locate the img elemnt in "+section+" section", pnpValidate(imgElement));
		Assert.assertTrue("PROBLEM - unable to locate the phone elemnt in "+section+" section", pnpValidate(phoneElement));
		Assert.assertTrue("PROBLEM - unable to locate the TTY elemnt in "+section+" section", pnpValidate(ttyElement));
		Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section", pnpValidate(hrsOperationElement1));
		if (hrsOperationElement2!=null) {
			Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section", pnpValidate(hrsOperationElement2));
		}
	} 

	/**
	 * Helper method to click on the target test plan on combo tab
	 * @param planType
	 * @param memberType
	 * @throws InterruptedException 
	 */
	public void handleComboTabIfComboUser(String planType, String memberType) 
			throws InterruptedException {
		if (memberType.toLowerCase().contains("combo")) {
			System.out.println("This test is for combo plans, select the tab accordingly");
			goToSpecificComboTabOnTargetPage(planType);
		} else {
			boolean flagNonCombo=false;
			goToSpecificComboTabOnOrderPlanPage(planType,flagNonCombo);
		}
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
	public void goBackToPriorPnPpgViaBack(String planType, String memberType) 
			throws InterruptedException {
		driver.navigate().back();
		CommonUtility.checkPageIsReady(driver);
		String expUrl="/member/pharmacy/overview.html";
		String actUrl=driver.getCurrentUrl();
		Assert.assertTrue("PROBLEM - unable to go back to PnP page. "
				+ "Expect URL contain '"+expUrl+"' | Actual URL='"+actUrl+"'", actUrl.contains(expUrl));
		//tbd handleComboTabIfComboUser(planType, memberType);
	}

	/**
	 * Navigate to specific plan for combo user, default will fail it if user doesn't have combo
	 * @param planType
	 */
	public void goToSpecificComboTabOnTargetPage(String planType) throws InterruptedException{
		CommonUtility.checkPageIsReady(driver);
		WebElement targetTab=null;
		if (planType.equalsIgnoreCase("MAPD")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for MAPD", 
					pnpValidate(comboTab_MAPD));
			targetTab=comboTab_MAPD;
		} else if (planType.equalsIgnoreCase("SHIP") 
				|| planType.equalsIgnoreCase("MEDSUPP")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for SHIP", 
					pnpValidate(comboTab_SHIP));
			targetTab=comboTab_SHIP;
		} else if (planType.equalsIgnoreCase("PDP")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", 
					pnpValidate(comboTab_PDP));
			targetTab=comboTab_PDP;
		} else if (planType.equalsIgnoreCase("SSUP")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", 
					pnpValidate(comboTab_SSUP));
			targetTab=comboTab_SSUP;
		} else {
			Assert.assertTrue("PROBLEM - need to enhance code to cover "
					+ "planType '"+planType+"' for combo testing", false);
		}
		targetTab.click();
		targetTab.click();
		CommonUtility.checkPageIsReady(driver);
		Thread.sleep(1000); //note: keep to give it a sec to stable	}
	}
	
	/**
	 * Helper method to go to a specific combo tab based on given planType on PnP page
	 * @param planType
	 * @throws InterruptedException 
	 */
	public void goToSpecificComboTabOnOrderPlanPage(String planType, boolean flagNonCombo) 
			throws InterruptedException {
		if (flagNonCombo) 
			goToSpecificComboTabOnTargetPage(planType);
		else {
			CommonUtility.checkPageIsReady(driver);
			WebElement targetTab=null;
			if (planType.equalsIgnoreCase("MAPD")) {
				if (pnpValidate(comboTab_MAPD))
					targetTab=comboTab_MAPD;
				else
					return;
			} else if (planType.equalsIgnoreCase("SHIP") 
					|| planType.equalsIgnoreCase("MEDSUPP")) {
				if (pnpValidate(comboTab_SHIP))
					targetTab=comboTab_SHIP;
				else
					return;
			} else if (planType.equalsIgnoreCase("PDP")) {
				if (pnpValidate(comboTab_PDP))
					targetTab=comboTab_PDP;
				else
					return;
			} else if (planType.equalsIgnoreCase("SSUP")) {
				if (pnpValidate(comboTab_SSUP))
					targetTab=comboTab_SSUP;
				else
					return;
			} else
				return;
			targetTab.click();
			targetTab.click();
			CommonUtility.checkPageIsReady(driver);
			Thread.sleep(1000); //note: keep to give it a sec to stable
		}
	}

	public String getConsumerDetailsFromlocalStorage() {
		WebStorage webStorage = (WebStorage) new Augmenter().augment(driver) ;
		LocalStorage localStorage = webStorage.getLocalStorage();
		String consumerDetails=localStorage.getItem("consumerDetails");
		return consumerDetails;
	}

	public String getInfoInConsumerDetails(String planType, String memberType, String infoType) {
		String lookForPlanCategory="";
		boolean isComboUser=false;
		if (memberType.toUpperCase().contains("COMBO"))
			isComboUser=true;
		if (planType.equalsIgnoreCase("SHIP") || planType.equalsIgnoreCase("MEDSUPP"))
			lookForPlanCategory="MEDICARE SUPPLEMENT";
		else if (planType.equalsIgnoreCase("SSUP")) 
			lookForPlanCategory="SSP";
		else if (planType.equalsIgnoreCase("PCP") || planType.equalsIgnoreCase("MEDICA")) 
			lookForPlanCategory="MAPD";
		else 
			lookForPlanCategory=planType;

		String consumerDetails=getConsumerDetailsFromlocalStorage();
		//System.out.println("TEST - consumerDetails="+consumerDetails);
		//note: if first / last name, no need to go into planProfiles - infoType: firstName | lastName 
		//note: LIS and segmentID needs to get within planProfiles - infoType: segmentId | planCategoryId 
		Assert.assertTrue("PROBLEM - code only support locating the following info "
				+ "at the moment: firstName, lastName, segmentId, planCategoryId | Actual='"+infoType+"'", 
				infoType.equals("firstName") || infoType.equals("lastName") 
				|| infoType.equals("segmentId") || infoType.equals("planCategoryId"));
		String resultInfo=null;
		try {
			JSONObject jsonObj = new JSONObject(consumerDetails);
			if (infoType.equals("firstName") || infoType.equals("lastName") ) {
				resultInfo=jsonObj.getString(infoType);
			}
			if (infoType.equals("segmentId") || infoType.equals("planCategoryId")) {
				JSONArray arr =jsonObj.getJSONArray("planProfiles");
				if (isComboUser) 
					Assert.assertTrue("PROBLEM - test data expect this user to be a combo user "
							+ "but the localStorage.consumerDetails has only one planProfiles.  "
							+ "Please double check and correct test data", arr.length()>1);
				for (int i = 0; i < arr.length(); i++) {
					String actualPlanCategory = arr.getJSONObject(i).getString("planCategory");
					//note: need to locate the right plan for plan related info
					if (lookForPlanCategory.equals(actualPlanCategory)) {
						resultInfo = arr.getJSONObject(i).getString(infoType);
					}
				}
			} 
			Assert.assertTrue("PROBLEM - unable to locate "+infoType+" from localStorage.consumerDetails, "
					+ "please double check input data planType matches user's actual planType", 
					resultInfo!=null);
		} catch (JSONException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - encounted problem reading the json result from localStorage.consumerDetails", false);
		}
		return resultInfo;
	}
	
	/**
	 * to validate whether element exists with input timeout value control
	 * note: use this instead of the one from UhcDriver which takes up to 30 sec to timeout
	 * @param element
	 * @param timeoutInSec
	 * @return
	 */
	public boolean pnpValidate(WebElement element) {
		long defaultTimeoutInSec=3; 
		return pnpValidate(element, defaultTimeoutInSec);
	}
	
	/**
	 * to validate whether element exists with input timeout value control
	 * note: use this instead of the one from UhcDriver which takes up to 30 sec to timeout
	 * @param element
	 * @param timeoutInSec
	 * @return
	 */
	public boolean pnpValidate(WebElement element, long timeoutInSec) {
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
	
	public void pnpCheckModelPopup(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
		checkModelPopup(driver,5);
		//note: UhcDriver default is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 

	}
	
	//F436319
		public boolean pnpNotificationPositionValidate(WebElement element) {
			return element.getCssValue("margin-top").equals("15px");
		}	
		
		//F436319
		public void closePnPNotification(WebElement element) {
			Actions actions = new Actions(driver);
			actions.moveToElement(element);
			actions.click().build().perform();
		}

}
