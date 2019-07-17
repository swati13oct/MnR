package pages.regression.ordermaterials;

import java.util.Calendar;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.regression.accounthomepage.AccountHomePage;

public class OrderMaterialsBase extends UhcDriver  {
	@FindBy(xpath = "//*[@id='PoweredByiPerceptions']")
	private WebElement iPerceptionPopUp;

	@FindBy(xpath = "//*[@id = 'closeButton']")
	private WebElement iPerceptionClose;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Med') and contains(.,'Drug')]") 
	private WebElement OPM_comboTab_MAPD;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Supplement')]") 
	private WebElement OPM_comboTab_SHIP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Prescription Drug Plan')]") 
	private WebElement OPM_comboTab_PDP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Senior Supplement Plan')]") 
	private WebElement OPM_comboTab_SSUP;

	@FindBy(xpath="//label[@for='replacement-id']//a[text()='VIEW MEMBER ID CARD']")
	private WebElement link_fed_memberIDcardLink;

	@FindBy(xpath="//label[@for='member-id-card']//a[text()='VIEW HEALTH INSURANCE CARD']")
	private WebElement link_ship_memberIDcardLink;

	@FindBy(xpath="//a[contains(text(),'CARD')]")
	private WebElement viewIdCard;

	@FindBy(xpath="//h1[@id='modal-header']")
	private WebElement memberIdCardsPageHeader;

	@FindBy(xpath="//button[@class='modal-close-btn']")
	private WebElement idCardCloseButton;

	@FindBy(xpath = "//div[@id='ui-view-page']//a[@track='ORDER_MATERIALS']")
	private WebElement orderMaterial_Dashboard;

	@FindBy(xpath="//div[@id='notShipRadio']//a[contains(@onclick,'https://member.int.uhc.com') and contains(@onclick,'https://member.int.mymedicareaccount.uhc.com') and contains(@onclick,'/dashboard/modal/id-cards')]")
	private WebElement nonship_idCardLinkOrderPage;

	@FindBy(xpath="//div[@id='shipRadio']//a[contains(@onclick,'https://member.int.uhc.com') and contains(@onclick,'https://member.int.mymedicareaccount.uhc.com') and contains(@onclick,'/dashboard/modal/id-cards')]")
	private WebElement ship_idCardLinkOrderPage;

	@FindBy(xpath="//a[contains(@onclick,'https://member.int.uhc.com') and contains(@onclick,'https://member.int.mymedicareaccount.uhc.com') and contains(@onclick,'/dashboard/modal/id-cards')]")
	private WebElement idCardLinkOrderConfirmedPage;
	
	@FindBy(id="additionalMaterialsText")
	public WebElement addOrderMaterialLink_OrderConfirmation;

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
		WebElement idCard=idCardLinkOrderConfirmedPage;
		if (testFor.equalsIgnoreCase("orderPage")) {
			if (planType.equalsIgnoreCase("SHIP") || planType.toUpperCase().contains("MEDSUPP")) 
				idCard=ship_idCardLinkOrderPage;
			else
				idCard=nonship_idCardLinkOrderPage;
		}
		Assert.assertTrue("PROBLEM - not getting expected ID card link element with expected URL",validate(idCard));
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

		Assert.assertTrue("PROBLEM - unable to locate the close button on the ID card page",validate(idCardCloseButton));
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
	 * Helper method to go to a specific combo tab based on given planType on Order Plan page
	 * @param planType
	 */
	public void goToSpecificComboTabOnOrderPlanPage(String planType) {
		CommonUtility.checkPageIsReady(driver);
		WebElement targetTab=null;
		if (planType.equalsIgnoreCase("MAPD")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for MAPD", validate(OPM_comboTab_MAPD));
			targetTab=OPM_comboTab_MAPD;
		} else if (planType.equalsIgnoreCase("SHIP") || planType.equalsIgnoreCase("MEDSUPP")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for SHIP", validate(OPM_comboTab_SHIP));
			targetTab=OPM_comboTab_SHIP;
		} else if (planType.equalsIgnoreCase("PDP")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", validate(OPM_comboTab_PDP));
			targetTab=OPM_comboTab_PDP;
		} else if (planType.equalsIgnoreCase("SSUP")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", validate(OPM_comboTab_SSUP));
			targetTab=OPM_comboTab_SSUP;
		} else {
			Assert.assertTrue("PROBLEM - need to enhance code to cover planType '"+planType+"' for combo testing", false);
		}
		targetTab.click();
		targetTab.click();
		CommonUtility.checkPageIsReady(driver);
	}

	/**
	 * Helper method to click on the target test plan on combo tab
	 * @param planType
	 * @param memberType
	 */
	public void handleComboTabIfComboUser(String planType, String memberType) {
		if (memberType.toLowerCase().contains("combo")) {
			System.out.println("This test is for combo plans, select the tab accordingly");
			goToSpecificComboTabOnOrderPlanPage(planType);
		}
	}


	/**
	 * Helper method to go back to prior page via browser back, also handles the case if combo tab is involved
	 * @param planType
	 * @param memberType
	 * @param originalUrl
	 */
	public void goBackToPriorPageViaBack(String planType, String memberType,String originalUrl) {
		if (memberType.toLowerCase().contains("combo")) {
			driver.get(originalUrl);
			goToSpecificComboTabOnOrderPlanPage(planType); 
		} else 
			driver.navigate().back();
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
			String testXpath="//div[contains(@class,'Callouts"+year+"') and not(contains(@class,'ng-hide'))]//a[@class='callout_chk' and contains(text(),'ORDER PLAN MATERIALS')]";
			if (planType.toUpperCase().contains("MEDICA")) {
				testXpath="//div[contains(@class,'Callouts_Medica_PCP_"+year+"') and not(contains(@class,'ng-hide'))]//a[@class='callout_chk' and contains(text(),'ORDER PLAN MATERIALS')]";
			} 
			System.out.println("TEST - testXpath="+testXpath);
			//tbd WebElement orderPlanMaterialsLink=driver.findElement(By.xpath("//div[contains(@class,'PlanDocumentsActiveCallouts') and not(contains(@class,'ng-hide'))]//a[@class='callout_chk' and contains(text(),'ORDER PLAN MATERIALS')]"));
			WebElement orderPlanMaterialsLink=driver.findElement(By.xpath(testXpath));
			CommonUtility.waitForPageLoad(driver, orderPlanMaterialsLink, 120);
			orderPlanMaterialsLink.click(); //note: this will navigate back to order page
			CommonUtility.checkPageIsReady(driver);
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
		Assert.assertTrue("PROBLEM - unable to locate the "+section+" section element",validate(SectionElement));
		Assert.assertTrue("PROBLEM - unable to locate the img elemnt in "+section+" section",validate(imgElement));
		Assert.assertTrue("PROBLEM - unable to locate the phone elemnt in "+section+" section",validate(phoneElement));
		Assert.assertTrue("PROBLEM - unable to locate the TTY elemnt in "+section+" section",validate(ttyElement));
		Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section",validate(hrsOperationElement1));
		if (hrsOperationElement2!=null) {
			Assert.assertTrue("PROBLEM - unable to locate the hours of operation for week elemnt in "+section+" section",validate(hrsOperationElement2));
		}
	}

	/**
	 * Helper method - handle the iPerception PopUp if any
	 */
	public void takeCareiPerceptionPopUp() {
		try{
			CommonUtility.waitForPageLoad(driver, iPerceptionPopUp, 5);
			if(validate(iPerceptionPopUp)){
				System.out.println("FeedBack Modal Present");
				iPerceptionClose.click();
				if (validate(iPerceptionPopUp)){
					System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked");
				} else
					System.out.println("FeedBack Modal Closed");
			}
		} catch (Exception e) {
			System.out.println("FeedBack Modal NOT Present");
		}

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

}