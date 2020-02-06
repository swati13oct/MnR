package pages.regression.ordermaterials;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import atdd.framework.UhcDriver;

public class OrderMaterialsWebElements extends UhcDriver  {
	@FindBy(xpath = "//*[@id='PoweredByiPerceptions']")
	protected WebElement iPerceptionPopUp;

	@FindBy(xpath = "//*[@id = 'closeButton']")
	protected WebElement iPerceptionClose;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Med') and contains(.,'Drug')]") 
	protected WebElement OPM_comboTab_MAPD;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Supplement')]") 
	protected WebElement OPM_comboTab_SHIP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Prescription Drug Plan') and not(contains(.,'Med'))]") 
	protected WebElement OPM_comboTab_PDP;

	@FindBy(xpath="//*[@id='profileTabHeader']//div[@class='tabs-desktop']//li//a[contains(.,'Senior Supplement Plan')]") 
	protected WebElement OPM_comboTab_SSUP;

	@FindBy(xpath="//label[@for='replacement-id']//a[text()='VIEW MEMBER ID CARD']")
	protected WebElement link_fed_memberIDcardLink;

	@FindBy(xpath="//label[@for='member-id-card']//a[text()='VIEW HEALTH INSURANCE CARD']")
	protected WebElement link_ship_memberIDcardLink;

	@FindBy(xpath="//a[contains(text(),'CARD')]")
	protected WebElement viewIdCard;

	@FindBy(xpath="//h1[@id='modal-header']")
	protected WebElement memberIdCardsPageHeader;

	@FindBy(xpath="//button[@class='modal-close-btn']")
	protected WebElement idCardCloseButton;

	@FindBy(xpath = "//div[@id='ui-view-page']//a[@track='ORDER_MATERIALS']")
	protected WebElement orderMaterial_Dashboard;

	//note: if changing this xpath, make sure it works for both order and confirm pages
	@FindBy(xpath="//div[@id='notShipRadio' or contains(@class,'success')]//a[contains(@onclick,'/dashboard/modal/id-cards')]")
	protected WebElement nonship_idCardLinkOrderPage;

	//note: if changing this xpath, make sure it works for both order and confirm pages
	@FindBy(xpath="//div[@id='shipRadio'  or contains(@class,'success')]//a[contains(@onclick,'/dashboard/modal/id-cards')]")
	protected WebElement ship_idCardLinkOrderPage;

	@FindBy(xpath="//a[contains(@onclick,'https://member.int.uhc.com') and contains(@onclick,'https://member.int.mymedicareaccount.uhc.com') and contains(@onclick,'/dashboard/modal/id-cards')]")
	protected WebElement idCardLinkOrderConfirmedPage;
	
	@FindBy(id="additionalMaterialsText")
	protected WebElement addOrderMaterialLink_OrderConfirmation;
	
	@FindBy(xpath="//h1[contains(text(),'Order Plan Materials')]")
	protected WebElement orderPlanPgHeader;

	@FindBy(xpath = "//[contains(text(), 'Hospital Indemnity')]")
	protected WebElement planTab_HIP;

	@FindBy(xpath = "//[contains(text(), 'Medicare Prescription Drug Plan')]")
	protected WebElement planTab_PDP;

	@FindBy(xpath = "//[contains(text(), 'Medicare Supplement Insurance Plan')]")
	protected WebElement planTab_MedSupp;

	@FindBy(xpath = "//[contains(text(), 'Senior Supplement Plan')]")
	protected WebElement planTab_SrSupp;

	@FindBy(xpath = "//*[@id='order-materials-serviceFail-error']")
	protected WebElement errorMsg_serviceFail;

	@FindBy(id = "order-materials-error")
	protected WebElement errorMsg_OrderMaterials;

	@FindBy(xpath = "//*[@id = 'ppe-id']/..")
	protected WebElement option_premiumPayment;

	@FindBy(xpath = "//*[@id = 'medicareHospital-id']/..")
	protected WebElement option_ship_hospitalDirectory;

	@FindBy(xpath="//select[@id='state']")
	protected WebElement option_ship_hospitalDirectory_stateDropdown;

	@FindBy(xpath = "//*[@class='nav nav-tabs']//a")
	protected List <WebElement> comboTabs;

	@FindBy(xpath="//h3[contains(text(),'Technical Support') or contains(text(),'Plan Support')]/ancestor::div[@class='col-md-4']")
	protected WebElement needHelpComponent;

	@FindBy(xpath = "//*[contains(text(),'Plan Materials Order Confirmation')]")
	protected WebElement header_OrderConfirmation;

	@FindBy(className = "orderplanmaterials")
	protected WebElement orderPlanMaterialsSection;

	@FindBy(id = "disclosure_link")
	protected WebElement logout_link;

	@FindBy(xpath="//h1[@class='main-heading margin-none']")
	protected WebElement common_header_orderPlanMaterialsPage; 

	@FindBy(xpath="//h2[@class='med-heading medium margin-large']")
	protected WebElement common_subSectionHeader;

	@FindBy(xpath="//div[contains(@class,'header')]//div[contains(@class,'federal')]//p")
	protected WebElement subSectionText_fed;

	@FindBy(xpath="//div[contains(@class,'header')]//div[contains(@class,'ship')]//p")
	protected WebElement subSectionText_ship;

	//tbd @FindBy(xpath="//form[@id='ordermaterial_form_id']//div[contains(@class,'federal')]//p")
	@FindBy(xpath="//div[contains(@class,'federal')]//p")
	protected WebElement selectionInstruction_fed;

	@FindBy(xpath="//form[@id='ordermaterial_form_id']")
	protected WebElement common_selectionSection;

	@FindBy(xpath="//*[@id = 'member-materials']/..//div[contains(@class,'group') and not(contains(@class,'ng-hide'))]")
	protected WebElement option_fed_memberMaterialsfield_WelcomeKit;

	@FindBy(xpath = "//*[@id = 'member-materials']/..")
	protected WebElement option_fed_memberMaterialsfield;

	@FindBy(xpath = "//*[@for='replacement-id']/..")
	protected WebElement option_fed_replacementIdField;

	@FindBy(xpath="//form[@id='ordermaterial_form_id']//div[contains(@class,'ship')]//p")
	protected WebElement selectionInstruction_ship;

	@FindBy(xpath = "//*[@id='member-id-card']/..")
	protected WebElement option_ship_memberIDcardField;

	@FindBy(xpath = "//*[@id='eft-id']/..")
	protected WebElement option_ship_brochureField_EFT;

	@FindBy(xpath = "//*[@id = 'couponBook-id']/..")
	protected WebElement option_ship_couponBook;

	@FindBy(xpath = "//*[@id = 'medicareHospital-id']/..")
	protected WebElement option_ship_medicareHospital;

	@FindBy(xpath = "//*[@id = 'claimsEnvelope-id']/..")
	protected WebElement option_ship_claimsEnvelope;

	@FindBy(xpath = "//*[@id = 'coi-id']/..")
	protected WebElement option_ship_certificateInsurance;

	@FindBy(xpath="//h3[contains(text(),'Shipping Address')]")
	protected WebElement common_sectionShipAddress;

	@FindBy(xpath="//h3[contains(text(),'Shipping Address')]/../div")
	protected WebElement common_sectionShipAddressContent;

	@FindBy(xpath="//h3[contains(text(),'Shipping Address')]/../div//a")
	protected WebElement common_sectionShipAddressContent_needHelpLink;

	//note: need help section
	@FindBy(xpath="//h2[contains(@class,'atdd-need-help')]")
	protected WebElement needHelp_SectionHeader;

	//note: need help - technical section
	@FindBy(xpath="//div[contains(@class,'technical section')]")
	protected WebElement needHelp_TechicalSupportSection;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[1]//img")
	protected WebElement needHelp_TechicalSupport_img;

	@FindBy(xpath="//div[contains(@class,'technical section')]/div/div/p[1]")
	protected WebElement needHelp_TechicalSupport_phone;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[2]")
	protected WebElement needHelp_TechicalSupport_tty;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[3]")
	protected WebElement needHelp_TechicalSupport_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'technical section')]//p[4]")
	protected WebElement needHelp_TechicalSupport_wkEndHrs;

	//note: need help - general section
	@FindBy(xpath="//div[contains(@class,'general section')]")
	protected WebElement needHelp_GeneralQuestionsSection;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[1]//img")
	protected WebElement needHelp_GeneralQuestions_img;

	@FindBy(xpath="//div[contains(@class,'general section')]/div/div/p[1]")
	protected WebElement needHelp_GeneralQuestions_phone;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[2]")
	protected WebElement needHelp_GeneralQuestions_tty;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[3]")
	protected WebElement needHelp_GeneralQuestions_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'general section')]//p[4]")
	protected WebElement needHelp_GeneralQuestions_wkEndHrs;

	//note: need help - claims section
	@FindBy(xpath="//div[contains(@class,'claims section')]")
	protected WebElement needHelp_ClaimsSupportSection;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[1]//img")
	protected WebElement needHelp_ClaimsSupport_img;

	@FindBy(xpath="//div[contains(@class,'claims section')]/div/div/div/p[1]")
	protected WebElement needHelp_ClaimsSupport_phone;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[2]")
	protected WebElement needHelp_ClaimsSupport_tty;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[3]")
	protected WebElement needHelp_ClaimsSupport_wkDayHrs;

	@FindBy(xpath="//div[contains(@class,'claims section')]//p[4]")
	protected WebElement needHelp_ClaimsSupport_wkEndHrs;

	//note: need help - plan support
	@FindBy(xpath="//div[contains(@class,'plan section')]")
	protected WebElement needHelp_PlanSupportSection;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[1]//img")
	protected WebElement needHelp_PlanSupport_img;

	@FindBy(xpath="//div[contains(@class,'plan section')]/div/div/p[1]")
	protected WebElement needHelp_PlanSupport_phone;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[2]")
	protected WebElement needHelp_PlanSupport_tty;

	@FindBy(xpath="//div[contains(@class,'plan section')]//p[3]")
	protected WebElement needHelp_PlanSupport_wkDayHrs;

	//note: need help - more ways
	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')][contains(text(),'See more ways to')]")
	protected WebElement needHelp_seeMoreWaysTo;

	@FindBy(xpath="//p[contains(@id,'seeMoreWaysAtdd')]//a[contains(text(),'contact us')]")
	protected WebElement needHelp_contactUsLink;

	@FindBy(id="submit-order-materials")
	protected WebElement submitButton;

	@FindBy(xpath="//h2[contains(text(),'Printable Documents')]")
	protected WebElement printableDocSection;

	@FindBy(xpath="//div[@class='card-body']//a[contains(text(),'PLAN DOCUMENTS & RESOURCES')]")
	protected WebElement printableDocLink;

	@FindBy(xpath="//h2[contains(text(),'Confirmation')]/../div[contains(@class,'success')]")
	protected WebElement SuccessMsgbox;

	@FindBy(xpath="//div[contains(@class,'confirmationtext')]//p")
	protected WebElement SuccessMsgText;

	@FindBy(xpath="//div[contains(@class,'orderplanmaterials')]//div[contains(@class,'otherPages') and not(contains(@class,'ng-hide'))]")
	protected WebElement orderedItem;

	@FindBy(xpath="//div[contains(@class,'orderplanmaterials')]//li")
	protected WebElement orderedItem_ship;

	@FindBy(xpath="//span[contains(text(),'card') or contains(text(),'Card')]")
	protected WebElement orderedItem_idCard;

	@FindBy(xpath="//h2[contains(text(), 'Confirmation')]")
	protected WebElement confirmationPageSubHeader;

	@FindBy(xpath="//a[@id='ordermaterials']")
	protected WebElement benefitPgOrderPlnMaterialLnk;
	
	@FindBy(xpath="//h1[contains(text(),'Plan Documents')]")
	protected WebElement planDocAndResPgHeader;
	
	public OrderMaterialsWebElements(WebDriver driver) {
		super(driver);
	}

	@Override
	public void openAndValidate() throws InterruptedException {
	}
}