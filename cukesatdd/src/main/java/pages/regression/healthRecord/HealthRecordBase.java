package pages.regression.healthRecord;

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
import acceptancetests.util.CommonUtility;

public class HealthRecordBase  extends HealthRecordWebElements {

	public HealthRecordBase(WebDriver driver) {
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
				System.out.println("TEST - lookForPlanCategory="+lookForPlanCategory);
				System.out.println("TEST - actualPlanCategory="+actualPlanCategory);
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

}