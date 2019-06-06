package pages.regression.ordermaterials;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.regression.accounthomepage.AccountHomePage;

/**
 * @author sdwaraka
 */
public class OrderPlanMaterialConfirmationPage extends UhcDriver {

	@FindBy(xpath = "//*[contains(text() 'We value your feedback')]")
	private WebElement iPerceptionPopUp;

	@FindBy(xpath = "//*[@id = 'closeButton']")
	private WebElement iPerceptionClose;

	@FindBy(id ="disclosure_link")
	private WebElement logout_link;

	@FindBy(id="additionalMaterialsText")
	private WebElement addOrderMaterialLink_OrderConfirmation;

	@FindBy(xpath="//a[contains(text(),'CARD')]")
	private WebElement viewIdCard;

	@FindBy(xpath="//h2[contains(text(),'Confirmation')]/../div[contains(@class,'success')]")
	private WebElement SuccessMsgbox;

	@FindBy(xpath="//div[contains(@class,'confirmationtext')]//p")
	private WebElement SuccessMsgText;

	@FindBy(xpath="//div[contains(@class,'orderplanmaterials')]//div[contains(@class,'otherPages') and not(contains(@class,'ng-hide'))]")
	private WebElement orderedItem;

	@FindBy(xpath="//div[contains(@class,'orderplanmaterials')]//li")
	private WebElement orderedItem_ship;

	@FindBy(xpath="//span[contains(text(),'card') or contains(text(),'Card')]")
	private WebElement orderedItem_idCard;

	@FindBy(xpath="//h2[contains(text(), 'Confirmation')]")
	private WebElement confirmationPageSubHeader;

	@FindBy(xpath="//h1[@id='modal-header']")
	private WebElement memberIdCardsPageHeader;

	@FindBy(xpath="//button[@class='modal-close-btn']")
	private WebElement idCardCloseButton;

	@FindBy(xpath = "//div[@id='ui-view-page']//a[@track='ORDER_MATERIALS']")
	private WebElement orderMaterial_Dashboard;

	public OrderPlanMaterialConfirmationPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		String expectedConfirmSubHeader="Plan Materials Order Confirmation";
		Assert.assertTrue("PROBLEM - unable to locate the sub header element for confirmation",validate(confirmationPageSubHeader));
		Assert.assertTrue("PROBLEM - not getting expected sub header text for confirmation.  Expected='"+expectedConfirmSubHeader+"' | Actual='"+confirmationPageSubHeader.getText()+"'",expectedConfirmSubHeader.equals(confirmationPageSubHeader.getText()));
		Assert.assertTrue("PROBLEM - unable to locate the add additional order link",validate(addOrderMaterialLink_OrderConfirmation));
	}

	/**
	 * Validate the success message element and content
	 * If applicable, will validate the view ID link that shows up in success message box
	 * @param planType
	 * @param memberType
	 * @param expectedOrderedItem
	 * @throws InterruptedException
	 */
	public void validateSuccessmessage(String planType, String memberType, String expectedOrderedItem, boolean skipIdCheck) throws InterruptedException {
		Assert.assertTrue("PROBLEM - unable to locate the successful message box element for confirmation",validate(SuccessMsgbox));
		Assert.assertTrue("PROBLEM - unable to locate the successful message text element for confirmation",validate(SuccessMsgText));
		//note: jenkins run doesn't parse the string with - as expected, so breaking the string into two for validation
		String expectedSuccessPattern="Your order has been submitted. You should be receiving the following plan materials by mail in about 7 (.*) 10 business days.";
		String expectedSuccessMsg1="Your order has been submitted. You should be receiving the following plan materials by mail in about 7";
		String expectedSuccessMsg2="10 business days.";
		String actualSuccessMsg=SuccessMsgText.getText();
		Assert.assertTrue("PROBLEM - sucess message is not as expected.  \nExpected to contain '"+expectedSuccessMsg1+"' and '"+expectedSuccessMsg2+"' \nActual='"+actualSuccessMsg+"'",actualSuccessMsg.contains(expectedSuccessMsg1) && actualSuccessMsg.contains(expectedSuccessMsg2) );
		if (actualSuccessMsg.matches(expectedSuccessPattern)) 
			System.out.println("TEST - matched msg the pattern");
		else 
			System.out.println("TEST - CANNOT matched msg the pattern");
		if (!validate(orderedItem_idCard)) {
			if (planType.equalsIgnoreCase("SHIP")) {
				Assert.assertTrue("PROBLEM - unable to locate the ordered item element for confirmation",validate(orderedItem_ship));
				Assert.assertTrue("PROBLEM - ordered item is not as expected in success message.  \nExpected='"+expectedOrderedItem+"' \nActual='"+orderedItem_ship.getText()+"'",expectedOrderedItem.equals(orderedItem_ship.getText()));
			} else {
				Assert.assertTrue("PROBLEM - unable to locate the ordered item element for confirmation",validate(orderedItem));
				Assert.assertTrue("PROBLEM - ordered item is not as expected in success message.  \nExpected='"+expectedOrderedItem+"' \nActual='"+orderedItem.getText()+"'",expectedOrderedItem.equals(orderedItem.getText()));
			}
		} else {
			Assert.assertTrue("PROBLEM - unable to locate the ordered item element for confirmation",validate(orderedItem_idCard));
			Assert.assertTrue("PROBLEM - ordered item is not as expected in success message.  \nExpected='"+expectedOrderedItem+"' \nActual='"+orderedItem_idCard.getText()+"'",expectedOrderedItem.equals(orderedItem_idCard.getText()));
			Assert.assertTrue("PROBLEM - unable to locate the VIEW MEMEBR ID CARD element for confirmation",validate(viewIdCard));

			String expected_url="dashboard/modal/id-cards";
			String cardType="";
			if (skipIdCheck) {
				System.out.println("Test is for VBF, skip ID check");
			} else {
				//note: if testing from testharness will validate element contains the right URL only.
				//note: UHC user's ID card link will redirect to 'systest3.myhc.com' instead.
				if (MRScenario.isTestHarness.equalsIgnoreCase("YES")) {
					System.out.println("For UHC user testing via testharness, the ID link will get redirect to systest3, so just validate the link element has the correct link");
					WebElement e=driver.findElement(By.xpath("//a[contains(@onclick,'https://member.int.uhc.com') and contains(@onclick,'https://member.int.mymedicareaccount.uhc.com') and contains(@onclick,'/dashboard/modal/id-cards')]"));
					Assert.assertTrue("PROBLEM - not getting expected ID card link element with expected URL",validate(e));
				} else {
					viewIdCard.click();
					System.out.println("Clicked view ID card...");

					CommonUtility.checkPageIsReady(driver);
					CommonUtility.waitForPageLoad(driver, memberIdCardsPageHeader, 10);

					Assert.assertTrue("PROBLEM - not getting expected URL after clicking '"+cardType+"' link.  Expected URL to contain '"+expected_url+"' | Actual URL='"+driver.getCurrentUrl()+"'",driver.getCurrentUrl().contains(expected_url));
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
			}
		}
	}
	
	//vvv --------- note: for VBF --------------------------------------
	public boolean navigateToValidateOrderConfirmationInRedesignPage() {
		CommonUtility.waitForPageLoadNew(driver, addOrderMaterialLink_OrderConfirmation, 60);
		addOrderMaterialLink_OrderConfirmation.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().contains("Order Plan Material")) {
			return true;
		}
		return false;
	}
	//^^^ --------- note: for VBF --------------------------------------


}
