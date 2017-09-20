/**
 * 
 */
package pages.member.ulayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import junit.framework.Assert;

/**
 * @author pperugu
 *
 */
public class OrderplanmaterialsPage extends UhcDriver {
	
	@FindBy(xpath = "//a[contains(text(), 'Medicare Advantage Plan')]")
	private WebElement MAPlanTab;

	@FindBy(xpath = "//a[contains(text(), 'Hospital Indemnity')]")
	private WebElement HIPplanTab;
	
	@FindBy(xpath = "//a[contains(text(), 'Medicare Prescription Drug Plan')]")
	private WebElement PDPPlanTab;

	@FindBy(xpath = "//a[contains(text(), 'Medicare Supplement Insurance Plan')]")
	private WebElement MedSuppPlanTab;
	
	@FindBy(id = "member-materials")
	private WebElement memberMaterialsfield;

	@FindBy(id = "replacement-id")
	private WebElement replacementIdField;
	
	@FindBy(id = "member-id-card")
	private WebElement MemberIDcardField;
	
	@FindBy(id = "eft-id")
	private WebElement EFTbrochureField;

	@FindBy(id = "ppe-id")
	private WebElement premiumPayment;

	@FindBy(xpath = "//*[@id='shipRadio']/div[4]/div")
	private WebElement couponBook;

	@FindBy(id = "medicareHospital-id")
	private WebElement medicareHospital;

	@FindBy(id = "claimsEnvelope-id")
	private WebElement claimsEnvelope;

	@FindBy(id = "coi-id")
	private WebElement certificateInsurance;

	//@FindBy(id = "memberPlanList")
	//private WebElement planField;

	
	@FindBy(xpath = "//button[@class = 'btn btn-primary select-item-submit']")
	private WebElement submitButton;
	
	//@FindBy(className = "orderplancontsec")
	@FindBy(className = "orderplanmaterials")
	private WebElement OrderPlanMaterialsSection;
	
	//@FindBy(id = "shipDocumentStateCodeId")
	@FindBy(id = "state")
	private WebElement shipDocumentStateCodeId;

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	public OrderplanmaterialsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//openAndValidate();
	}
	
	@SuppressWarnings("deprecation")
	public void navigatePlanTabs(String PlanType){
		
		if (PlanType.contains("MA") || PlanType.contains("MAPD")) {
		validate(MAPlanTab);
			MAPlanTab.click();
			Assert.assertTrue("Cant navigate to MA / MAPD Plan Tab", memberMaterialsfield.isDisplayed());
			System.out.println("*************Displaying Medicare Advantage Plan Tab **********");
		}
		
		else if (PlanType.contains("HIP")) {
			validate(HIPplanTab);
			HIPplanTab.click();
			Assert.assertTrue("Cant navigate to HIP Plan Tab", MemberIDcardField.isDisplayed());
			System.out.println("*************Displaying SHIP - HIP Plan Tab **********");
			
		}
		else if (PlanType.contains("PDP")) {
			validate(PDPPlanTab);
			PDPPlanTab.click();
			Assert.assertTrue("Cant navigate to PDP Plan Tab", memberMaterialsfield.isDisplayed());
			System.out.println("*************Displaying PDP Plan Tab **********");
			
		}
		else if (PlanType.contains("MedSupp")) {
			validate(MedSuppPlanTab);
			MedSuppPlanTab.click();
			Assert.assertTrue("Cant navigate to Med Supp PlanTab Plan Tab", MemberIDcardField.isDisplayed());
			System.out.println("*************Displaying SHIP - Med Supp Plan Tab Plan Tab **********");
			
		}
		else{
			System.out.println("Invalid Plan Type / Plan Type not found");
		}	
	}

	public boolean ValidateHeader(){
		if (driver.findElement(By.xpath("//h1[@class='h4 margin-none']")).isDisplayed() && driver.findElement(By.xpath("//h2[@class='h3 medium margin-large']")).isDisplayed()){
			System.out.println("*************Header Text and Subtext displayed for Order materials Page***************");
			
			return true;
		}
		else{ 
			System.out.println("************Header Text and Subtext not displayed for Order materials Page***************");
			return false;}
		
	}
	public boolean ValidateErrorMessage(){
		if (driver.findElement(By.xpath("//*[contains(text(), 'Please select one of the items above')]")).isDisplayed()){
			System.out.println("*************Error Message Displayed displayed for Order materials Page***************");
			return true;
		}
		else{ 
			System.out.println("************Error message not displayed for Order materials Page***************");
			return false;}
		
	}
	public boolean ValidateSHIPErrorMessage(){
		if (driver.findElement(By.xpath("//*[contains(text(), 'Your request cannot be processed at this time. For help, please contact Customer Servic')]")).isDisplayed()){
			System.out.println("*************Error Message Displayed displayed for SHIP invalid Selection in Order materials Page***************");
			return true;
		}
		else{ 
			System.out.println("************Error message not displayed for SHIP invalid Selection - Order materials Page***************");
			return false;}
		
	}
	
	public PlanMaterialConfirmationPage selectsOption(String option) {
		
		CommonUtility.checkPageIsReady(driver);

		if (option.contains("Member Materials") || option.contains("Welcome Guide")) {
			memberMaterialsfield.submit();
		}
		
		if (option.contains("Replacement ID card")) {
			replacementIdField.click();
		}
		
//		if (option.contains("Welcome")) {
//			MemberIDcardField.click();
//		}

		if (option.contains("Electronic Funds Transfer (EFT) Brochure")) {
			EFTbrochureField.click();
		}

		if (option.contains("Premium Payment Envelopes")) {
			premiumPayment.click();
		}

		if (option.contains("Coupon Book")) {
			System.out.println("*************Selecting Coupon Book Radio***************");

			couponBook.click();
			
			if(!couponBook.isSelected()){
				System.out.println("*************NOT ABLE to SELECT Coupon Book Radio***************");
				
			}
		}
		
		if (option.contains("None")) {
			System.out.println("No option for order material selected");
		}
		

		/*
		 * if (option.contains("Medicare Select Hospital Directory")){
		 * medicareHospital.click(); shipDocumentStateCodeId.click();
		 * shipDocumentStateCodeId.sendKeys(statecode); }
		 */
		if (option.contains("Claims Envelope")) {
			claimsEnvelope.click();
		}

		if (option.contains("Certificate of Insurance")) {
			certificateInsurance.click();
		}

/*		if (submitButton.getTagName() == "button"){
			System.out.print("Submit Button enabled");
		}
*/		submitButton.submit();
		submitButton.click();

		/*
		 * if (driver.findElement(By.className("orderplanconttext")).getText()
		 
				.contains("Plan Materials Order Confirmation")) {
			return new PlanMaterialConfirmationPage(driver);
		} else
			return null;
		*/
		
		
		if (driver.findElement(By.className("orderplanmaterials")).getText()
				.contains("The following documents have been ordered")) {
			return new PlanMaterialConfirmationPage(driver);
		} 
			return null;
		
		
	}

	public String getOrderPlanMaterialsContent() {
		return OrderPlanMaterialsSection.getText();
	}

	public void logOut() {
		logOut.click();

	}

	@Override
	public void openAndValidate() {

		validate(memberMaterialsfield);
		validate(logOut);
	}

}
