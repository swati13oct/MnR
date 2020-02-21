package pages.regression.ordermaterials;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import pages.regression.accounthomepage.AccountHomePage;

public class OrderMaterialsBase extends OrderMaterialsWebElements  {

	public OrderMaterialsBase(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openAndValidate() throws InterruptedException {
	}

	/**
	 * Help method to click on ID card link (if applicable) and validate landing URL
	 * @param testFor
	 * @param planType
	 * @param x
	 * @throws InterruptedException
	 */
	public void validateIDCard(String testFor, String planType, WebElement x) throws InterruptedException {
		WebElement idCard=nonship_idCardLinkOrderPage;
		//note: currently the order page and the confirm page can use the same xpath so no need to do if/else loop
		//if (testFor.equalsIgnoreCase("orderPage")) {
			if (planType.equalsIgnoreCase("SHIP") || planType.toUpperCase().contains("MEDSUPP")) 
				idCard=ship_idCardLinkOrderPage;
			//else
			//	idCard=nonship_idCardLinkOrderPage;
		//}
		CommonUtility.waitForPageLoad(driver, idCard, 5);
		Assert.assertTrue("PROBLEM - not getting expected ID card link element",orderValidate(idCard));
		if (MRScenario.isTestHarness.equalsIgnoreCase("YES")) {
			System.out.println("For testharness will only validate ID card element exists with expected URL.  UHC user's ID link will get redirect to systest3.");
			if (!testFor.equalsIgnoreCase("orderPage")) { //note: already order so need to get back to order page to prep for next step
				navigateToOrderMore();
			}
			return;
		}
		idCard.click();
		System.out.println("Clicked view ID card...");

		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, memberIdCardsPageHeader, 10);

		String expected_url="dashboard/modal/id-cards";
		Assert.assertTrue("PROBLEM - not getting expected URL after clicking view ID card link.  Expected URL to contain '"+expected_url+"' | Actual URL='"+driver.getCurrentUrl()+"'",driver.getCurrentUrl().contains(expected_url));
		System.out.println("Successfully validated expected content for selection section on Order Plan Materials page");

		Assert.assertTrue("PROBLEM - unable to locate the close button on the ID card page",orderValidate(idCardCloseButton));
		idCardCloseButton.click();
		System.out.println("Attempt to close the ID card view and move onto next step...should be back to dashboard page...");
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, orderMaterial_Dashboard, 10);

		Assert.assertTrue("PROBLEM - unable to be back on dashboard page after closing ID card page", driver.getCurrentUrl().contains("dashboard"));
		AccountHomePage accountHomePage=new AccountHomePage(driver);
		accountHomePage.navigateToOrderPlanMaterialsPageFromTopMenu();
		System.out.println("Able to come back to order plan material page from top menu access");
	}

	/**
	 * Navigate to specific plan for combo user, default will fail it if user doesn't have combo
	 * @param planType
	 */
	public void goToSpecificComboTabOnOrderPlanPage(String planType) throws InterruptedException {
		CommonUtility.checkPageIsReady(driver);
		WebElement targetTab=null;
		if (planType.equalsIgnoreCase("MAPD")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for MAPD", orderValidate(OPM_comboTab_MAPD));
			targetTab=OPM_comboTab_MAPD;
		} else if (planType.equalsIgnoreCase("SHIP") || planType.equalsIgnoreCase("MEDSUPP")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for SHIP", orderValidate(OPM_comboTab_SHIP));
			targetTab=OPM_comboTab_SHIP;
		} else if (planType.equalsIgnoreCase("PDP")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", orderValidate(OPM_comboTab_PDP));
			targetTab=OPM_comboTab_PDP;
		} else if (planType.equalsIgnoreCase("SSUP")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", orderValidate(OPM_comboTab_SSUP));
			targetTab=OPM_comboTab_SSUP;
		} else {
			Assert.assertTrue("PROBLEM - need to enhance code to cover planType '"+planType+"' for combo testing", false);
		}
		targetTab.click();
		targetTab.click();
		CommonUtility.checkPageIsReady(driver);
		Thread.sleep(1000); //note: keep to give it a sec to stable
	}

	/**
	 * Helper method to go to a specific combo tab based on given planType on Order Plan page
	 * @param planType
	 * @param flagNonCombo
	 * @throws InterruptedException 
	 */
	public void goToSpecificComboTabOnOrderPlanPage(String planType, boolean flagNonCombo) throws InterruptedException {
		if (flagNonCombo) {
			goToSpecificComboTabOnOrderPlanPage(planType);
		} else {
			CommonUtility.checkPageIsReady(driver);
			WebElement targetTab=null;
			if (planType.equalsIgnoreCase("MAPD")) {
				if (orderValidate(OPM_comboTab_MAPD))
					targetTab=OPM_comboTab_MAPD;
				else 
					return;
			} else if (planType.equalsIgnoreCase("SHIP") || planType.equalsIgnoreCase("MEDSUPP")) {
				if (orderValidate(OPM_comboTab_SHIP))
					targetTab=OPM_comboTab_SHIP;
				else
					return;
			} else if (planType.equalsIgnoreCase("PDP")) {
				if (orderValidate(OPM_comboTab_PDP)) 
					targetTab=OPM_comboTab_PDP;
				else
					return;
			} else if (planType.equalsIgnoreCase("SSUP")) {
				if (orderValidate(OPM_comboTab_SSUP))
					targetTab=OPM_comboTab_SSUP;
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

	/**
	 * Helper method to click on the target test plan on combo tab
	 * @param planType
	 * @param memberType
	 * @throws InterruptedException 
	 */
	public void handleComboTabIfComboUser(String planType, String memberType) throws InterruptedException {
		if (memberType.toLowerCase().contains("combo")) {
			System.out.println("This test is for combo plans, select the tab accordingly");
			goToSpecificComboTabOnOrderPlanPage(planType);
		} else {
			boolean flagNonCombo=false;
			goToSpecificComboTabOnOrderPlanPage(planType,flagNonCombo);
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
			goToSpecificComboTabOnOrderPlanPage(planType); 
		} else {
			driver.navigate().back();
			boolean flagNonCombo=false;
			goToSpecificComboTabOnOrderPlanPage(planType,flagNonCombo);
		}
	}

	/**
	 * Navigate to order plan materials page from top menu option (Benefits & Coverage --> sub menu to order plan materials)
	 * @throws InterruptedException
	 */
	public void navigateToOrderPlanMaterialsPageFromTopMenu() throws InterruptedException {
		CommonUtility.checkPageIsReady(driver);
		AccountHomePage accountHomePage=new AccountHomePage(driver);
		OrderMaterialsPage OrderMaterialsPage=accountHomePage.navigateToOrderPlanMaterialsPageFromTopMenu();
		Assert.assertTrue("PROBLEM - unable to navigate to order plan material page via top menu sub option under BnC", OrderMaterialsPage!=null);
	}

	/**
	 * Helper method to go back to prior page via Plan Documents and Resources page Order Plan Materials link, also handles the case if combo tab is involved
	 * @param planType
	 * @param memberType
	 * @param originalUrl
	 */
	public void goBackToPriorPageViaPlanMaterialsOrderPlanMaterials(String planType, String memberType,String originalUrl, String onPage) {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		try {
			if(onPage.equalsIgnoreCase("formsAndResourcesPage")) {
				driver.navigate().back();
			} else {
				String testXpath="//div[contains(@class,'Callouts"+year+"') and not(contains(@class,'ng-hide'))]//a[@class='callout_chk' and contains(text(),'ORDER PLAN MATERIALS')]";
				if (planType.toUpperCase().contains("MEDICA")) {
					testXpath="//div[contains(@class,'Callouts_Medica_PCP_"+year+"') and not(contains(@class,'ng-hide'))]//a[@class='callout_chk' and contains(text(),'ORDER PLAN MATERIALS')]";
				} 
				System.out.println("TEST - testXpath="+testXpath);
				WebElement orderPlanMaterialsLink=driver.findElement(By.xpath(testXpath));
				CommonUtility.waitForPageLoad(driver, orderPlanMaterialsLink, 120);
				orderPlanMaterialsLink.click(); //note: this will navigate back to order page
			}
			CommonUtility.checkPageIsReady(driver);
			CommonUtility.waitForPageLoad(driver, orderPlanPgHeader, 15);
			handleComboTabIfComboUser(planType, memberType);
		} catch(Exception e) {
			Assert.assertTrue("PROBLEM - unable to go back to Order Plan Materials page via 'Plan Documents & Resources' page's 'ORDER PLAN MATERIALS' link", false);
		}
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
		Assert.assertTrue("PROBLEM - unable to locate the "+section+" section element",orderValidate(SectionElement));
		Assert.assertTrue("PROBLEM - unable to locate the img elemnt in "+section+" section",orderValidate(imgElement));
		Assert.assertTrue("PROBLEM - unable to locate the phone elemnt in "+section+" section",orderValidate(phoneElement));
		Assert.assertTrue("PROBLEM - unable to locate the TTY elemnt in "+section+" section",orderValidate(ttyElement));
		Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section",orderValidate(hrsOperationElement1));
		if (hrsOperationElement2!=null) {
			Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section",orderValidate(hrsOperationElement2));
		}
	}

	/** Helper method - handle the iPerception PopUp if any */
	public void takeCareiPerceptionPopUp() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); 
		checkModelPopup(driver,5);
		//note: UhcDriver default is 10
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		/* tbd 
		try{
			CommonUtility.waitForPageLoad(driver, iPerceptionPopUp, 5);
			if(orderValidate(iPerceptionPopUp)){
				System.out.println("FeedBack Modal Present");
				iPerceptionClose.click();
				if (validate(iPerceptionPopUp)){
					System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked");
				} else
					System.out.println("FeedBack Modal Closed");
			}
		} catch (Exception e) {
			System.out.println("FeedBack Modal NOT Present");
		} */

	}

	/**
	 * Helper method to click on the link for ordering additional materials.
	 * @return
	 */
	public boolean navigateToOrderMore() {
		CommonUtility.waitForPageLoadNew(driver, addOrderMaterialLink_OrderConfirmation, 60);
		addOrderMaterialLink_OrderConfirmation.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().contains("Order Plan Material")) {
			return true;
		}
		return false;
	}
	
	/**
	 * to validate whether element exists, default up to 2 seconds timeout
	 * @param element
	 * @return
	 */
	public boolean orderValidate(WebElement element) {
		long timeoutInSec=0;
		return orderValidate(element, timeoutInSec);
	} 
	
	/**
	 * to validate whether element exists with input timeout value control
	 * note: use this instead of the one from UhcDriver which takes up to 30 sec to timeout
	 * @param element
	 * @param timeoutInSec
	 * @return
	 */
	public boolean orderValidate(WebElement element, long timeoutInSec) {
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

}