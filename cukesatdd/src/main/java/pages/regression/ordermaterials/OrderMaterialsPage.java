package pages.regression.ordermaterials;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import pages.regression.accounthomepage.AccountHomePage;

/**
 * @author rkodumur
 */
public class OrderMaterialsPage extends UhcDriver  {
	@FindBy(xpath = "//*[@id='PoweredByiPerceptions']")
	private WebElement iPerceptionPopUp;

	@FindBy(xpath = "//*[@id = 'closeButton']")
	private WebElement iPerceptionClose;

	@FindBy(xpath = "//[contains(text(), 'Hospital Indemnity')]")
	private WebElement planTab_HIP;

	@FindBy(xpath = "//[contains(text(), 'Medicare Prescription Drug Plan')]")
	private WebElement planTab_PDP;

	@FindBy(xpath = "//[contains(text(), 'Medicare Supplement Insurance Plan')]")
	private WebElement planTab_MedSupp;

	@FindBy(xpath = "//[contains(text(), 'Senior Supplement Plan')]")
	private WebElement planTab_SrSupp;

	@FindBy(xpath = "//*[@id='order-materials-serviceFail-error']")
	private WebElement errorMsg_SHIP;

	@FindBy(id = "order-materials-error")
	private WebElement errorMsg_OrderMaterials;

	@FindBy(xpath = "//*[@id = 'ppe-id']/..")
	private WebElement option_premiumPayment;

	@FindBy(xpath = "//*[@id = 'medicareHospital-id']/..")
	private WebElement option_ship_hospitalDirectory;

	@FindBy(xpath="//select[@id='state']")
	private WebElement option_ship_hospitalDirectory_stateDropdown;

	@FindBy(xpath = "//*[@class='nav nav-tabs']//a")
	private List <WebElement> comboTabs;

	@FindBy(xpath="//h3[contains(text(),'Technical Support') or contains(text(),'Plan Support')]/ancestor::div[@class='col-md-4']")
	private WebElement needHelpComponent;

	@FindBy(xpath = "//*[contains(text(),'Plan Materials Order Confirmation')]")
	private WebElement header_OrderConfirmation;

	@FindBy(id="additionalMaterialsText")
	private WebElement addOrderMaterialLink_OrderConfirmation;

	@FindBy(className = "orderplanmaterials")
	private WebElement orderPlanMaterialsSection;

	@FindBy(id = "disclosure_link")
	private WebElement logout_link;

	@FindBy(xpath="//h1[@class='main-heading margin-none']")
	private WebElement common_header_orderPlanMaterialsPage; 

	@FindBy(xpath="//h2[@class='med-heading medium margin-large']")
	private WebElement common_subSectionHeader;

	@FindBy(xpath="//div[contains(@class,'header')]//div[contains(@class,'federal')]//p")
	private WebElement subSectionText_fed;

	@FindBy(xpath="//div[contains(@class,'header')]//div[contains(@class,'ship')]//p")
	private WebElement subSectionText_ship;

	@FindBy(xpath="//form[@id='ordermaterial_form_id']//div[contains(@class,'federal')]//p")
	private WebElement selectionInstruction_fed;

	@FindBy(xpath="//form[@id='ordermaterial_form_id']")
	private WebElement common_selectionSection;

	@FindBy(xpath = "//*[@id = 'member-materials']/..")
	private WebElement option_fed_memberMaterialsfield;

	@FindBy(xpath = "//*[@id='replacement-id']/..")
	private WebElement option_fed_replacementIdField;

	@FindBy(xpath="//label[@for='replacement-id']//a[text()='VIEW MEMBER ID CARD']")
	private WebElement link_fed_memberIDcardLink;

	@FindBy(xpath="//h1[@id='modal-header']")
	private WebElement memberIdCardsPageHeader;

	@FindBy(xpath = "//div[@id='ui-view-page']//a[@track='ORDER_MATERIALS']")
	private WebElement orderMaterial_Dashboard;

	@FindBy(xpath="//form[@id='ordermaterial_form_id']//div[contains(@class,'ship')]//p")
	private WebElement selectionInstruction_ship;

	@FindBy(xpath = "//*[@id='member-id-card']/..")
	private WebElement option_ship_memberIDcardField;

	@FindBy(xpath="//label[@for='member-id-card']//a[text()='VIEW HEALTH INSURANCE CARD']")
	private WebElement link_ship_memberIDcardLink;

	@FindBy(xpath = "//*[@id='eft-id']/..")
	private WebElement option_ship_brochureField_EFT;

	@FindBy(xpath = "//*[@id = 'couponBook-id']/..")
	private WebElement option_ship_couponBook;

	@FindBy(xpath = "//*[@id = 'medicareHospital-id']/..")
	private WebElement option_ship_medicareHospital;

	@FindBy(xpath = "//*[@id = 'claimsEnvelope-id']/..")
	private WebElement option_ship_claimsEnvelope;

	@FindBy(xpath = "//*[@id = 'coi-id']/..")
	private WebElement option_ship_certificateInsurance;

	@FindBy(xpath="//button[@class='modal-close-btn']")
	private WebElement idCardCloseButton;

	@FindBy(xpath="//h3[contains(text(),'Shipping Address')]")
	private WebElement common_sectionShipAddress;

	@FindBy(xpath="//h3[contains(text(),'Shipping Address')]/../div")
	private WebElement common_sectionShipAddressContent;

	@FindBy(xpath="//h3[contains(text(),'Shipping Address')]/../div//a")
	private WebElement common_sectionShipAddressContent_needHelpLink;

	//note: need help section
	@FindBy(xpath="//h2[contains(@class,'atdd-need-help')]")
	private WebElement needHelp_SectionHeader;

	//note: need help - technical section
	@FindBy(xpath="//div[contains(@class,'technical section')]")
	private WebElement needHelp_TechicalSupportSection;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[1]//img")
	private WebElement needHelp_TechicalSupport_img;

	@FindBy(xpath="//div[contains(@class,'technical section')]/div/div/p[1]")
	private WebElement needHelp_TechicalSupport_phone;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[2]")
	private WebElement needHelp_TechicalSupport_tty;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[3]")
	private WebElement needHelp_TechicalSupport_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[4]")
	private WebElement needHelp_TechicalSupport_wkEndHrs;

	//note: need help - general section
	@FindBy(xpath="//div[contains(@class,'general section')]")
	private WebElement needHelp_GeneralQuestionsSection;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[1]//img")
	private WebElement needHelp_GeneralQuestions_img;

	@FindBy(xpath="//div[contains(@class,'general section')]/div/div/p[1]")
	private WebElement needHelp_GeneralQuestions_phone;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[2]")
	private WebElement needHelp_GeneralQuestions_tty;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[3]")
	private WebElement needHelp_GeneralQuestions_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[4]")
	private WebElement needHelp_GeneralQuestions_wkEndHrs;

	//note: need help - claims section
	@FindBy(xpath="//div[contains(@class,'claims section')]")
	private WebElement needHelp_ClaimsSupportSection;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[1]//img")
	private WebElement needHelp_ClaimsSupport_img;

	@FindBy(xpath="//div[contains(@class,'claims section')]/div/div/div/p[1]")
	private WebElement needHelp_ClaimsSupport_phone;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[2]")
	private WebElement needHelp_ClaimsSupport_tty;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[3]")
	private WebElement needHelp_ClaimsSupport_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[4]")
	private WebElement needHelp_ClaimsSupport_wkEndHrs;

	//note: need help - plan support
	@FindBy(xpath="//div[contains(@class,'plan section')]")
	private WebElement needHelp_PlanSupportSection;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[1]//img")
	private WebElement needHelp_PlanSupport_img;

	@FindBy(xpath="//div[contains(@class,'plan section')]/div/div/p[1]")
	private WebElement needHelp_PlanSupport_phone;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[2]")
	private WebElement needHelp_PlanSupport_tty;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[3]")
	private WebElement needHelp_PlanSupport_wkDayHrs;

	//note: need help - more ways
	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')][contains(text(),'See more ways to')]")
	private WebElement needHelp_seeMoreWaysTo;

	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')]//a[contains(text(),'contact us')]")
	private WebElement needHelp_contactUsLink;

	@FindBy(id="submit-order-materials")
	private WebElement submitButton;

	@FindBy(xpath="//h2[contains(text(),'Printable Documents')]")
	private WebElement printableDocSection;

	@FindBy(xpath="//div[@class='card-body']//a[contains(text(),'PLAN DOCUMENTS & RESOURCES')]")
	private WebElement printableDocLink;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Med') and contains(.,'Drug')]") 
	private WebElement comboTab_MAPD;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Supplement')]") 
	private WebElement comboTab_SHIP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Prescription Drug Plan')]") 
	private WebElement comboTab_PDP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Senior Supplement Plan')]") 
	private WebElement comboTab_SSUP;

	//vvv --------- note: for VBF --------------------------------------
	@FindBy(xpath = "//h1[contains(@class,'margin-none')]")
	private WebElement vbf_orderMaterialHeading1;

	@FindBy(xpath = "//h2[contains(@class,'margin-large')]")
	private WebElement vbf_orderMaterialHeading2;
	//^^^ --------- note: for VBF --------------------------------------

	public OrderMaterialsPage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.checkPageIsReadyNew(driver);
		try{
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
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		Assert.assertTrue("PROBLEM - unable to locate the header element",validate(common_header_orderPlanMaterialsPage));
	}

	/**
	 * Determine if there is combo tabs on screen
	 * @return
	 */
	public boolean hasComboTabs() {
		if (comboTabs.size()>1) {
			return true;
		}
		return false;
	}

	/**
	 * Validate header section content
	 */
	public void validateHeaderSection() {
		String expectedHeaderText="Order Plan Materials";
		Assert.assertTrue("PROBLEM - unable to locate the header text element on Order Plan Materials",validate(common_header_orderPlanMaterialsPage));
		Assert.assertTrue("PROBLEM - header text on Order Plan Materials is not as expected. Expected='"+expectedHeaderText+"' | Actual='"+common_header_orderPlanMaterialsPage.getText()+"'",expectedHeaderText.equals(common_header_orderPlanMaterialsPage.getText()));

		String expectedSubSectionHeader="Get plan documents and materials by mail.";
		Assert.assertTrue("PROBLEM - unable to locate the sub section header element on Order Plan Materials",validate(common_subSectionHeader));
		Assert.assertTrue("PROBLEM - sub section header content on Order Plan Materials is not as expected. Expected='"+expectedSubSectionHeader+"' | Actual='"+common_subSectionHeader.getText()+"'",expectedSubSectionHeader.equals(common_subSectionHeader.getText()));
	}

	/**
	 * Validate sub header section content
	 * @param planType
	 */
	public void validateSubHeaderSection(String planType) {
		if (planType.equalsIgnoreCase("SHIP")) {
			Assert.assertTrue("PROBLEM - unable to locate the sub section text element on Order Plan Materials",validate(subSectionText_ship));
		} else {
			Assert.assertTrue("PROBLEM - unable to locate the sub section text element on Order Plan Materials",validate(subSectionText_fed));
		}
	}

	/**
	 * Validate selection section content based on planType, memberType
	 * Will validate click to open ID view if applicable
	 * @param planType
	 * @param memberType
	 * @throws InterruptedException
	 */
	public void validateSelectionSection(String planType, String memberType) throws InterruptedException {
		Assert.assertTrue("PROBLEM - unable to locate the selection section on Order Plan Materials",validate(common_selectionSection));
		if (planType.equalsIgnoreCase("SHIP")) {
			Assert.assertTrue("PROBLEM - unable to locate the selection instruction element on Order Plan Materials",validate(selectionInstruction_ship));

			Assert.assertTrue("PROBLEM - unable to locate 'Member ID Card (Health Insurance Card)' selection option on Order Plan Materials",validate(option_ship_memberIDcardField));
			Assert.assertTrue("PROBLEM - unable to locate 'VIEW HEALTH INSURANCE CARD' link on Order Plan Materials",validate(link_ship_memberIDcardLink));
			Assert.assertTrue("PROBLEM - unable to locate 'Electronic Funds Transfer(EFT) Brochure' selection option on Order Plan Materials",validate(option_ship_brochureField_EFT));
			Assert.assertTrue("PROBLEM - unable to locate 'Coupon Book' selection option on Order Plan Materials",validate(option_ship_couponBook));
			Assert.assertTrue("PROBLEM - unable to locate 'Medicare Select Hospital Directory' selection option on Order Plan Materials",validate(option_ship_medicareHospital));
			Assert.assertTrue("PROBLEM - unable to locate 'Claims Envelope' selection option on Order Plan Materials",validate(option_ship_medicareHospital));
			Assert.assertTrue("PROBLEM - unable to locate 'Certificate of Insurance' selection option on Order Plan Materials",validate(option_ship_certificateInsurance));
		} else {
			Assert.assertTrue("PROBLEM - unable to locate the selection instruction on Order Plan Materials",validate(selectionInstruction_fed));

			Assert.assertTrue("PROBLEM - unable to locate 'Welcome Guide' selection option on Order Plan Materials",validate(option_fed_memberMaterialsfield));
			Assert.assertTrue("PROBLEM - unable to locate 'Replacement ID card' selection option on Order Plan Materials",validate(option_fed_replacementIdField));
			Assert.assertTrue("PROBLEM - unable to locate 'VIEW MEMBER ID CARD' link on Order Plan Materials",validate(link_fed_memberIDcardLink));
		}

		String expected_url="dashboard/modal/id-cards";
		String cardType="";
		if (MRScenario.isTestHarness.equalsIgnoreCase("YES") && memberType.toUpperCase().contains("UHC")) {
			//note: if testing from testharness, UHC user's ID card link will redirect to 'systest3.myhc.com' instead.
			System.out.println("For UHC user testing via testharness, the ID link will get redirect to systest3, so just validate the link element has the correct link");
			WebElement e=driver.findElement(By.xpath("//div[@id='notShipRadio']//a[contains(@onclick,'https://member.int.uhc.com') and contains(@onclick,'https://member.int.mymedicareaccount.uhc.com') and contains(@onclick,'/dashboard/modal/id-cards')]"));
			Assert.assertTrue("PROBLEM - not getting expected ID card link element with expected URL",validate(e));
		} else {
			if (planType.equalsIgnoreCase("SHIP")) {
				cardType="VIEW HEALTH INSURANCE CARD";
				link_ship_memberIDcardLink.click();
			} else {
				cardType="VIEW MEMBER ID CARD";
				link_fed_memberIDcardLink.click();
			}
			System.out.println("Clicked view ID card...");

			CommonUtility.checkPageIsReady(driver);
			CommonUtility.waitForPageLoad(driver, memberIdCardsPageHeader, 10);
			Assert.assertTrue("PROBLEM - not getting expected URL after clicking '"+cardType+"' link.  Expected URL to contain '"+expected_url+"' | Actual URL='"+driver.getCurrentUrl()+"'",driver.getCurrentUrl().contains(expected_url));
			System.out.println("Successfully validated expected content for selection section on Order Plan Materials page");

			Assert.assertTrue("PROBLEM - unable to locate the close button on the ID card page",validate(idCardCloseButton));
			idCardCloseButton.click();
			System.out.println("Attempt to close ID card view...should go back to dashboard view after...");
			CommonUtility.checkPageIsReady(driver);
			CommonUtility.waitForPageLoad(driver, orderMaterial_Dashboard, 10);
			Assert.assertTrue("PROBLEM - unable to be back on dashboard page after closing ID card page", driver.getCurrentUrl().contains("dashboard"));
			navigateToOrderPlanMaterialsPageFromTopMenu();
			System.out.println("Able to come back to order plan material page from top menu access");
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
	 * Helper method to go back to prior page via browser back, also handles the case if combo tab is involved
	 * @param planType
	 * @param memberType
	 * @param originalUrl
	 */
	public void goBackToPriorPageViaBack(String planType, String memberType,String originalUrl) {
		if (memberType.toLowerCase().contains("combo")) {
			driver.get(originalUrl);
			goToSpecificComboTab(planType); 
		} else 
			driver.navigate().back();
	}
	
	/**
	 * Helper method to go back to prior page via Plan Documents and Resources page Order Plan Materials link, also handles the case if combo tab is involved
	 * @param planType
	 * @param memberType
	 * @param originalUrl
	 */
	public void goBackToPriorPageViaPlanMaterialsOrderPlanMaterials(String planType, String memberType,String originalUrl) {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		try {
			WebElement orderPlanMaterialsLink=driver.findElement(By.xpath("//div[contains(@class,'PlanDocumentsActiveCallouts"+year+"') and not(contains(@class,'ng-hide'))]//a[@class='callout_chk' and contains(text(),'ORDER PLAN MATERIALS')]"));
			CommonUtility.waitForPageLoad(driver, orderPlanMaterialsLink, 10);
			orderPlanMaterialsLink.click();
			CommonUtility.checkPageIsReady(driver);
			if (memberType.toLowerCase().contains("combo")) {
				goToSpecificComboTab(planType); 
			} 
		} catch(Exception e) {
			Assert.assertTrue("PROBLEM - unable to go back to Order Plan Materials page via 'Plan Documents & Resources' page's 'ORDER PLAN MATERIALS' link", false);
		}
	}

	/**
	 * Validate the shipping address section content
	 */
	public void validateShippingAddressSection() {
		Assert.assertTrue("PROBLEM - unable to locate the 'Shipping Address' section header element on Order Plan Materials",validate(common_sectionShipAddress));
		Assert.assertTrue("PROBLEM - unable to locate the 'Shipping Address' section content element on Order Plan Materials",validate(common_sectionShipAddressContent));
		Assert.assertTrue("PROBLEM - unable to locate the 'Shipping Address' contact Customer Service link element on Order Plan Materials",validate(common_sectionShipAddressContent_needHelpLink));

		common_sectionShipAddressContent_needHelpLink.click();
		CommonUtility.checkPageIsReady(driver);
		Assert.assertTrue("PROBLEM - unable to locate the 'Shipping Address' contact Customer Service link element on Order Plan Materials",validate(common_sectionShipAddressContent_needHelpLink));
		Assert.assertTrue("PROBLEM - unable to locate the 'Need Help' section header after clicking contact Customer Service link on Order Plan Materials",needHelp_SectionHeader.isDisplayed());
	}

	/**
	 * Validate submit button is located
	 */
	public void validateSubmitButton() {
		Assert.assertTrue("PROBLEM - unable to locate the 'Submit' button element on Order Plan Materials",validate(submitButton));
	}

	/**
	 * Validate Printable Documents section content
	 * Will validate clicking of the link
	 * @param planType
	 * @param memberType
	 */
	public void validatePrintableDocSection(String planType, String memberType) {
		//"member/documents/overview.html"
		Assert.assertTrue("PROBLEM - unable to locate the 'Printable Documents' section header element on Order Plan Materials",validate(printableDocSection));
		Assert.assertTrue("PROBLEM - unable to locate the 'Printable Documents' link element on Order Plan Materials",validate(printableDocLink));
		String originalUrl=driver.getCurrentUrl();
		printableDocLink.click();
		String expectedUrl="member/documents/overview.html";
		Assert.assertTrue("PROBOEM - not getting expected URL after clicking '' link.  Expected URL to contain '"+expectedUrl+"' | Actual URL='"+driver.getCurrentUrl()+"'", driver.getCurrentUrl().contains(expectedUrl));
		goBackToPriorPageViaPlanMaterialsOrderPlanMaterials(planType, memberType, originalUrl);
	}

	/**
	 * Validate error message related element and text for case when no selection was made when submit button was clicked
	 * @throws InterruptedException
	 */
	public void validateErrorMessage() throws InterruptedException{
		CommonUtility.waitForPageLoad(driver, errorMsg_OrderMaterials, 5);
		Assert.assertTrue("PROBLEM - unable to locate error message after submitting without selection", validate(errorMsg_OrderMaterials));
		Assert.assertTrue("PROBLEM - unable to locate error message text after submitting without selection", validate(errorMsg_OrderMaterials));
		String expectedErrorText="Please select one of the items above.";
		Assert.assertTrue("PROBLEM - not getting expected error text. Expected='"+expectedErrorText+"' | Actual='"+errorMsg_OrderMaterials.getText()+"'", expectedErrorText.equals(errorMsg_OrderMaterials.getText()));
		System.out.println("*************Error Message Displayed: "+errorMsg_OrderMaterials.getText()+" ***************");
	}

	/**
	 * Validate the error message element and text for the SHIP error cases
	 * @throws InterruptedException
	 */
	public void validateShipErrorMessage() throws InterruptedException{
		CommonUtility.waitForPageLoad(driver, errorMsg_SHIP, 10);
		Assert.assertTrue("PROBLEM - unable to locate error message after submitting without selection", validate(errorMsg_SHIP));
		System.out.println("*************Error Message displayed for SHIP invalid Selection in Order materials Page***************");
		String expectedErrorText="request cannot be processed at this time";
		Assert.assertTrue("PROBLEM - error text is not as expected.  Expected to contain '"+expectedErrorText+"' | Actual error msg='"+errorMsg_SHIP.getText()+"'", errorMsg_SHIP.getText().contains(expectedErrorText));
	}

	/**
	 * Select the material option based on input and submit the request
	 * Will return the selected order item for further validation
	 * @param option
	 * @return
	 * @throws InterruptedException
	 */
	public String selectOption(String option) throws InterruptedException {
		driver.navigate().refresh();
		if(validate(iPerceptionPopUp)){
			System.out.println("FeedBack Modal Present");
			iPerceptionClose.click();
			if (validate(iPerceptionPopUp)){
				System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked");
			} else
				System.out.println("FeedBack Modal Closed");
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", common_subSectionHeader);

		CommonUtility.checkPageIsReady(driver);
		String itemType="";
		WebElement itemToOrderElement=null;
		if (option.contains("Member Materials") || option.contains("Welcome Guide") || option.contains("Welcome kit")) {
			itemType="Member materials / Welcome Guide / Welcome kit";
			itemToOrderElement=option_fed_memberMaterialsfield;
		} else if (option.contains("Replacement ID card")) {
			itemType="Replacement ID card";
			itemToOrderElement=option_fed_replacementIdField;
		} else if (option.contains("Member ID Card")) {
			itemType="Member ID Card";
			itemToOrderElement=option_ship_memberIDcardField;			
		} else if (option.contains("Electronic Funds Transfer (EFT) Brochure")) {
			itemType="Electronic Funds Transfer (EFT) Brochure";
			itemToOrderElement=option_ship_brochureField_EFT;			
		} else if (option.contains("Premium Payment Envelopes")) {
			itemType="Premium Payment Envelopes";
			itemToOrderElement=option_premiumPayment;			
		} else if (option.contains("Medicare Select Hospital Directory")) {
			itemType="Medicare Select Hospital Directory";
			itemToOrderElement=option_ship_hospitalDirectory;			
		} else if (option.contains("Coupon Book")) {
			itemType="Coupon Book";
			itemToOrderElement=option_ship_couponBook;			
		} else if (option.contains("Claims Envelope")) {
			itemType="Claims Envelope";
			itemToOrderElement=option_ship_claimsEnvelope;			
		} else if (option.contains("Certificate of Insurance")) {
			itemType="Certificate of Insurance";
			itemToOrderElement=option_ship_certificateInsurance;			
		} else if (option.contains("None")){
			System.out.println("validate error case where no option is selected followed by clicking submit button");
		} else {
			Assert.assertTrue("PROBLEM - option '"+option+"' is not an expected available option", false);
		}

		String result="";
		if (option.contains("None")) {
			System.out.println("No option for order material selected");
		} else {
			System.out.println("************* Selecting "+itemType+" Radio***************");
			itemToOrderElement.click();
			if (!itemToOrderElement.isEnabled()) {
				System.out.println("************* NOT ABLE to SELECT "+itemType+" Radio***************");
			}
			if (option.contains("Medicare Select Hospital Directory")) {
				//note: extra checking for this option
				Assert.assertTrue("PROBLEM - unable to locate the state dropdown element", validate(option_ship_hospitalDirectory_stateDropdown));
				Select ship_hopspitalStateDropdown = new Select(option_ship_hospitalDirectory_stateDropdown);
				Assert.assertTrue("PROBLEM - there should be total of 58 options from dropdown.  Actual="+ship_hopspitalStateDropdown.getOptions().size(), ship_hopspitalStateDropdown.getOptions().size()==58);
				for(int i=0; i<ship_hopspitalStateDropdown.getOptions().size(); i++) {
					System.out.println("Located dropdown option ==> "+ship_hopspitalStateDropdown.getOptions().get(i).getText());
				} 
			}
			result=itemToOrderElement.getText();
		}

		CommonUtility.waitForPageLoad(driver, submitButton, 5);
		if(validate(submitButton)){
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", submitButton); 
			System.out.println("****** Submit Button Clicked ********");
		}

		CommonUtility.checkPageIsReady(driver);
		CommonUtility.waitForPageLoad(driver, addOrderMaterialLink_OrderConfirmation, 10);
		if (validate(header_OrderConfirmation) || validate(addOrderMaterialLink_OrderConfirmation)) {
			System.out.println("@@@@ Opder Plan Material COnfirmation Page is Displayed @@@@");
			if (result.contains("VIEW")) {
				String[] tmp=result.split("VIEW");
				result=tmp[0].trim();
			}
			return result;
		}
		return null;
	}

	/**
	 * Validate Need Help section content
	 * @param planType
	 * @param memberType
	 * @return
	 */
	public String validateNeedHelpSection(String planType, String memberType) {
		if (planType.equalsIgnoreCase("SHIP")) {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",validate(needHelp_SectionHeader));

			String validateSection="Need Help - Technical Support";
			validateNeedHelpSectionContent(validateSection, needHelp_TechicalSupportSection, needHelp_TechicalSupport_img, needHelp_TechicalSupport_phone, needHelp_TechicalSupport_tty, needHelp_TechicalSupport_wkDayHrs,needHelp_TechicalSupport_wkEndHrs);

			validateSection="Need Help - General Questions";
			validateNeedHelpSectionContent(validateSection, needHelp_GeneralQuestionsSection, needHelp_GeneralQuestions_img, needHelp_GeneralQuestions_phone, needHelp_GeneralQuestions_tty, needHelp_GeneralQuestions_wkDayHrs,needHelp_GeneralQuestions_wkEndHrs);

			validateSection="Need Help - Claims Support";
			validateNeedHelpSectionContent(validateSection, needHelp_ClaimsSupportSection, needHelp_ClaimsSupport_img, needHelp_ClaimsSupport_phone, needHelp_ClaimsSupport_tty, needHelp_ClaimsSupport_wkDayHrs,needHelp_ClaimsSupport_wkEndHrs);

			System.out.println("Proceed to validate the Need Help - See More Ways section content");
			Assert.assertTrue("PROBLEM - unable to locate the 'See more ways to' text in Need Help section",validate(needHelp_seeMoreWaysTo));
			Assert.assertTrue("PROBLEM - unable to locate the 'contact us' link in Need Help section",validate(needHelp_contactUsLink));
			String originalUrl=driver.getCurrentUrl();
			needHelp_contactUsLink.click();
			CommonUtility.checkPageIsReady(driver);
			if (memberType.toLowerCase().contains("combo")) {
				System.out.println("This test is for combo plans, select the tab accordingly");
				goToSpecificComboTab(planType); //note: click the target tab for testing
				goToSpecificComboTab(planType); //note: manually one click is okay, but for selenium needs 2 clicks for this to work here, don't know why
			}
			String expContactUsTitle="Help & Contact Us";
			String expContactUsUrl="content/medicare/member/contact-us/overview.html#/contact-us-three";
			System.out.println("New window URL = "+driver.getCurrentUrl());
			System.out.println("New window title = "+driver.getTitle());
			Assert.assertTrue("PROBLEM - not getting expected contact us URL. Expected to contains='"+expContactUsUrl+"' | Actual URL='"+driver.getCurrentUrl()+"'", driver.getCurrentUrl().contains(expContactUsUrl));
			Assert.assertTrue("PROBLEM - not getting expected contact us Title. Expected to contains='"+expContactUsTitle+"' | Actual URL='"+driver.getTitle()+"'", driver.getTitle().contains(expContactUsTitle));
			goBackToPriorPageViaBack(planType, memberType, originalUrl);
		} else {
			System.out.println("Proceed to validate the Need Help section header");
			Assert.assertTrue("PROBLEM - unable to locate the Need Help section header element",validate(needHelp_SectionHeader));

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
	 * Helper method to go to a specific combo tab based on given planType
	 * @param planType
	 */
	public void goToSpecificComboTab(String planType) {
		if (planType.equalsIgnoreCase("mapd")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for MAPD", validate(comboTab_MAPD));
			comboTab_MAPD.click();
		} else if (planType.equalsIgnoreCase("ship") || planType.equalsIgnoreCase("medsupp")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for SHIP", validate(comboTab_SHIP));
			comboTab_SHIP.click();
		} else if (planType.equalsIgnoreCase("pdp")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", validate(comboTab_PDP));
			comboTab_PDP.click();
		} else if (planType.equalsIgnoreCase("ssup")) {
			Assert.assertTrue("PROBLEM - unable to locate combo tab for PDP", validate(comboTab_SSUP));
			comboTab_SSUP.click();
		} else {
			Assert.assertTrue("PROBLEM - need to enhance code to cover planType '"+planType+"' for combo testing", false);
		}
	}

	/**
	 * Validate order material functionality
	 * Will order each available item one at a time, will click on order additional material to order next item
	 * @param planType
	 * @param memberType
	 * @throws InterruptedException
	 */
	public void validateOrderAllItemsIndvidually(String planType, String memberType) throws InterruptedException {
		List<String> listOfItems=new ArrayList<String>();
		if (planType.equalsIgnoreCase("SHIP")) {
			listOfItems.add("Member ID Card");
			listOfItems.add("Electronic Funds Transfer (EFT) Brochure");
			listOfItems.add("Medicare Select Hospital Directory");
			listOfItems.add("Coupon Book");
			listOfItems.add("Claims Envelope");
			listOfItems.add("Certificate of Insurance");
		} else {
			listOfItems.add("Member Materials");
			listOfItems.add("Replacement ID card");
		}
		boolean result=true;
		List<String> problemItems=new ArrayList<String>();
		for (String item: listOfItems) {
			String orderedItem = selectOption(item);
			if (orderedItem==null) {
				if (planType.equalsIgnoreCase("SHIP") && memberType.toUpperCase().contains("EFT")) {
					if (!validate(errorMsg_SHIP)) {
						System.out.println("PROBLEM - for SHIP user with 'EFT' setup should have gotten error message when attempting to order 'coupon book'");
						problemItems.add(item+"-should NOT be able to order");
						result=false;
					} else 
						System.out.println("Expected - NOT able to order item="+item);
					//note: no need to click order additional material link because would still be on order page
				} else if (planType.equalsIgnoreCase("SHIP") && !memberType.toUpperCase().contains("MEDSELECTPLAN")) {
					if (!validate(errorMsg_SHIP)) {
						System.out.println("PROBLEM - for SHIP user without 'MEDICARE_SELECT_PLAN' setup should have gotten error message when attempting to order 'Medicare Select Hospital Directory'");
						problemItems.add(item+"-should NOT be able to order");
						result=false;
					} else
						System.out.println("Expected - NOT able to order item="+item);
				} else if (!planType.equalsIgnoreCase("PDP") && memberType.toUpperCase().contains("GROUP") && item.equalsIgnoreCase("Member Materials")) {
					if (!validate(errorMsg_SHIP)) {
						System.out.println("PROBLEM - for non-PDP user should have gotten error message when attempting to order 'Welcome kit'");
						problemItems.add(item+"-should NOT be able to order");
						result=false;
					} else
						System.out.println("Expected - NOT able to order item="+item);
				} else {
					System.out.println("PROBLEM - unable to order this material: "+item);
					problemItems.add(item+"-should BE able to order");
					result=false;
				}
			} else {
				System.out.println("Expected - ABLE to order item="+item);
				OrderPlanMaterialConfirmationPage planMaterialConfirmationPage=new OrderPlanMaterialConfirmationPage(driver);
				boolean skipIdCheck=false; //note: for regression test will validate ID card link
				planMaterialConfirmationPage.validateSuccessmessage(planType, memberType, orderedItem, skipIdCheck);
				if (orderedItem.contains("Replacement ID card") || orderedItem.contains("Member ID Card")) {
					System.out.println("After validating success result for Replacement ID card, would be landing back on the order page instead, so no need to look for order additional item link in this case");
				} else {
					System.out.println("Proceed to click 'ORDER ADDITIONAL MATERIALS' link");
					addOrderMaterialLink_OrderConfirmation.click();
				}
			}
		}
		Assert.assertTrue("PROBLEM - unable to order all available materials individually. Problem ones are: "+problemItems, result);
	}

	//vvv --------- note: for VBF --------------------------------------
	public boolean vbfValidateHeader() {
		if (vbf_orderMaterialHeading1.isDisplayed() && vbf_orderMaterialHeading2.isDisplayed()) {
			System.out.println("*************Header Text and Subtext displayed for Order materials Page***************");
			return true;
		} else {
			System.out.println("************Header Text and Subtext not displayed for Order materials Page***************");
			return false;
		}
	}

	public OrderPlanMaterialConfirmationPage vbfValidateOrderItem(String planType, String memberType, String option) throws InterruptedException {
		boolean result=true;
		boolean skipIdCheck=true; //note: for VBF, will skip ID card link validation
		String orderedItem = selectOption(option);
		if (orderedItem==null) {
			if (planType.equalsIgnoreCase("SHIP") && memberType.toUpperCase().contains("EFT")) {
				if (!validate(errorMsg_SHIP)) {
					System.out.println("PROBLEM - for SHIP user with 'EFT' setup should have gotten error message when attempting to order 'coupon book'");
					result=false;
				} else 
					System.out.println("Expected - NOT able to order item="+option);
				//note: no need to click order additional material link because would still be on order page
			} else if (planType.equalsIgnoreCase("SHIP") && !memberType.toUpperCase().contains("MEDSELECTPLAN")) {
				if (!validate(errorMsg_SHIP)) {
					System.out.println("PROBLEM - for SHIP user without 'MEDICARE_SELECT_PLAN' setup should have gotten error message when attempting to order 'Medicare Select Hospital Directory'");
					result=false;
				} else
					System.out.println("Expected - NOT able to order item="+option);
			} else if (!planType.equalsIgnoreCase("PDP") && memberType.toUpperCase().contains("GROUP") && option.equalsIgnoreCase("Member Materials")) {
				if (!validate(errorMsg_SHIP)) {
					System.out.println("PROBLEM - for non-PDP user should have gotten error message when attempting to order 'Welcome kit'");
					result=false;
				} else
					System.out.println("Expected - NOT able to order item="+option);
			} else {
				System.out.println("PROBLEM - unable to order this material: "+option);
				result=false;
			}
		} else {
			System.out.println("Expected - ABLE to order item="+option);
			OrderPlanMaterialConfirmationPage planMaterialConfirmationPage=new OrderPlanMaterialConfirmationPage(driver);
			planMaterialConfirmationPage.validateSuccessmessage(planType, memberType, orderedItem, skipIdCheck);
			if (orderedItem.contains("Replacement ID card") || orderedItem.contains("Member ID Card")) {
				System.out.println("After validating success result for Replacement ID card, would be landing back on the order page instead, so no need to look for order additional item link in this case");
			} else {
				System.out.println("Proceed to click 'ORDER ADDITIONAL MATERIALS' link");
				addOrderMaterialLink_OrderConfirmation.click();
			}
		}
		Assert.assertTrue("PROBLEM - unable to order material '"+option+"'", result);
		return new OrderPlanMaterialConfirmationPage(driver);
	}
	//^^^ --------- note: for VBF --------------------------------------
}