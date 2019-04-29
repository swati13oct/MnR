/**
 * 
 */
package pages.regression.ordermaterials;

import java.util.List;
import java.util.NoSuchElementException;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author rkodumur
 *
 */
public class OrderMaterialsPage extends UhcDriver  {
	@FindBy(xpath = "//*[@id='PoweredByiPerceptions']")
	private WebElement iPerceptionPopUp;

	@FindBy(xpath = "//*[@id = 'closeButton']")
	private WebElement iPerceptionClose;
	
	@FindBy(xpath = "//a[contains(text(), 'Medicare Advantage Plan')]")
	private WebElement MAPlanTab;

	@FindBy(xpath = "//[contains(text(), 'Hospital Indemnity')]")
	private WebElement HIPplanTab;
	
	@FindBy(xpath = "//[contains(text(), 'Medicare Prescription Drug Plan')]")
	private WebElement PDPPlanTab;

	@FindBy(xpath = "//[contains(text(), 'Medicare Supplement Insurance Plan')]")
	private WebElement MedSuppPlanTab;
	
	@FindBy(xpath = "//[contains(text(), 'Senior Supplement Plan')]")
	private WebElement SrSuppTab;

	@FindBy(xpath = "//*[@id = 'member-materials']/..")
	private WebElement memberMaterialsfield;

	@FindBy(xpath = "//*[@id='replacement-id']/..")
	private WebElement replacementIdField;
	
	@FindBy(xpath = "//*[@id='member-id-card']/..")
	private WebElement MemberIDcardField;
	
	@FindBy(xpath = "//*[@id='eft-id']/..")
	private WebElement EFTbrochureField;

	@FindBy(xpath = "//*[@id='order-materials-serviceFail-error']")
	private WebElement SHIPerrorMsg;
	
	@FindBy(id = "order-materials-error")
	private WebElement OrderMaterialsErrorMsg;
	
	@FindBy(xpath = "//*[@id = 'ppe-id']/..")
	private WebElement premiumPayment;

	@FindBy(xpath = "//*[@id = 'couponBook-id']/..")
	private WebElement couponBook;

/*	@FindBy(xpath = "//*[@id='shipRadio']/div[3]/div")
	private WebElement couponBook;
*/	
	@FindBy(xpath = "//*[@id = 'medicareHospital-id']/..")
	private WebElement medicareHospital;

	@FindBy(xpath = "//*[@id = 'claimsEnvelope-id']/..")
	private WebElement claimsEnvelope;

	@FindBy(xpath = "//*[@id = 'coi-id']/..")
	private WebElement certificateInsurance;
	
	@FindBy(xpath = "//*[@class='nav nav-tabs']//a")
	private List <WebElement> ComboTabs;


	@FindBy(xpath="//h3[contains(text(),'Technical Support') or contains(text(),'Plan Support')]/ancestor::div[@class='col-md-4']")
	private WebElement needhelpcomponent;
	
	//@FindBy(id = "memberPlanList")
	//private WebElement planField;

	
	@FindBy(id="submit-order-materials")
	private WebElement submitButton;
	
	@FindBy(xpath = "//*[contains(text(),'Plan Materials Order Confirmation')]")
	private WebElement OrderConfirmationHeader;
	
	@FindBy(id="additionalMaterialsText")
	private WebElement OrderConfirmation_addordermaterialLink;
	
	//@FindBy(className = "orderplancontsec")
	@FindBy(className = "orderplanmaterials")
	private WebElement OrderPlanMaterialsSection;
	

	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	

	public OrderMaterialsPage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		//tbd Thread.sleep(5000);
		//tbd CommonUtility.checkPageIsReady(driver);
		CommonUtility.checkPageIsReadyNew(driver);
		try{
			if(validate(iPerceptionPopUp)){
				System.out.println("FeedBack Modal Present");

				iPerceptionClose.click();
				if (validate(iPerceptionPopUp)){
					System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked");
				}
				else
					System.out.println("FeedBack Modal Closed");
			}
		}
		catch (Exception e) {
			System.out.println("FeedBack Modal NOT Present");

		}
		//openAndValidate();
	}
	/**
	* @todo : ordermatials page options based on plan type
	*/

	@SuppressWarnings("deprecation")
	public boolean navigatePlanTabs(String PlanType){
		driver.navigate().refresh();
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try{
			if(validate(iPerceptionPopUp)){
				System.out.println("FeedBack Modal Present");

				iPerceptionClose.click();
				if (validate(iPerceptionPopUp)){
					System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked");
				}
				else
					System.out.println("FeedBack Modal Closed");
			}
		}
		catch (Exception e) {
			System.out.println("FeedBack Modal NOT Present");
		}

		CommonUtility.checkPageIsReady(driver);

		if(validate(ComboTabs.get(0))){
			WebElement FirstTab = ComboTabs.get(0);
			WebElement Secondtab = ComboTabs.get(1);
			System.out.println("First Tab ====> "+FirstTab.getText());
			System.out.println("Second Tab ====> "+Secondtab.getText());
			WebElement mapdTab=null;
			WebElement medsuppTab=null;
			WebElement pdpTab=null;
			WebElement ssupTab=null;
			WebElement hipTab=null;
			//note: ship and hip will likely need fixing, no available working user to work with right now
			if (FirstTab.getText().contains("MEDICARE SUPPLEMENT INSURANCE PLAN")) {
				medsuppTab=FirstTab;
			} else if (FirstTab.getText().contains("MEDICARE ADVANTAGE")) {
				mapdTab=FirstTab;
			} else if (FirstTab.getText().contains("Prescription Drug Plan") && !FirstTab.getText().contains("MEDICARE ADVANTAGE")) {
				pdpTab=FirstTab;
			} else if (FirstTab.getText().contains("Senior Supplement Plan")) {
				ssupTab=FirstTab;
			} else if (FirstTab.getText().contains("Hospital Indemnity Insurance Plan")) {
				hipTab=FirstTab;
			}
				
			if (Secondtab.getText().contains("MEDICARE SUPPLEMENT INSURANCE PLAN")) {
				medsuppTab=Secondtab;
			} else if (Secondtab.getText().contains("MEDICARE ADVANTAGE")) {
				mapdTab=Secondtab;
			} else if (Secondtab.getText().contains("Prescription Drug Plan") && !Secondtab.getText().contains("MEDICARE ADVANTAGE")) {
				pdpTab=Secondtab;
			} else if (Secondtab.getText().contains("Senior Supplement Plan")) {
				ssupTab=Secondtab;
			} else if (Secondtab.getText().contains("Hospital Indemnity Insurance Plan")) {
				hipTab=Secondtab;
			}
			System.out.println("Combo Tabs are Displayed - Member with multiple Plans");
			if (PlanType.contentEquals("MA") || PlanType.contentEquals("MAPD")) {
				if (validate(mapdTab)){
					mapdTab.click();
				//tbd if (validate(FirstTab)){
					//tbd FirstTab.click();
					//Assert.assertTrue("Cant navigate to MA / MAPD Plan Tab", memberMaterialsfield.isDisplayed());
					System.out.println("*************Displaying Medicare Advantage Plan Tab **********");
					return true;
				}
			}
			
			else if (PlanType.contentEquals("SHIP")) {
				if (validate(medsuppTab)){
					medsuppTab.click();
				//tbd if (validate(Secondtab)){
					//tbd Secondtab.click();
					//Assert.assertTrue("Cant navigate to Med Supp PlanTab Plan Tab", MemberIDcardField.isDisplayed());
					System.out.println("*************Displaying SHIP - Med Supp Plan Tab Plan Tab **********");
					return true;
				}
				else if (validate(Secondtab)){
					Secondtab.click();
					//Assert.assertTrue("Cant navigate to HIP Plan Tab", MemberIDcardField.isDisplayed());
					System.out.println("*************Displaying SHIP - HIP Plan Tab **********");
					return true;
				}
				else {
					System.out.println("*************No SHIP Plans available for this Member **********");
					return false;
				}
			}

			else if (PlanType.contentEquals("HIP")) {
				if (validate(hipTab)){
					hipTab.click();
				//tbd if (validate(Secondtab)){
					//tbd Secondtab.click();
					//Assert.assertTrue("Cant navigate to HIP Plan Tab", MemberIDcardField.isDisplayed());
					System.out.println("*************Displaying SHIP - HIP Plan Tab **********");
					return true;
				}
				
			}
			else if (PlanType.contentEquals("PDP")) {
				//tbd if (validate(FirstTab)){
					//tbd FirstTab.click();
				if (validate(pdpTab)){
					pdpTab.click();
					//Assert.assertTrue("Cant navigate to PDP Plan Tab", memberMaterialsfield.isDisplayed());
					System.out.println("*************Displaying PDP Plan Tab **********");
					return true;
				}
				
			}
			else if (PlanType.contentEquals("MedSupp")) {
				if (validate(medsuppTab)){
					medsuppTab.click();
				//tbd if (validate(Secondtab)){
					//tbd Secondtab.click();
					//Assert.assertTrue("Cant navigate to Med Supp PlanTab Plan Tab", MemberIDcardField.isDisplayed());
					System.out.println("*************Displaying SHIP - Med Supp Plan Tab Plan Tab **********");
					return true;
				}
			}
			else if (PlanType.contentEquals("SSUP")) {
				if (validate(ssupTab)){
					ssupTab.click();
				//tbd if (validate(Secondtab)){
					//tbd Secondtab.click();
					//Assert.assertTrue("Cant navigate to Med Supp PlanTab Plan Tab", MemberIDcardField.isDisplayed());
					System.out.println("*************Displaying UHC Senior Supplement Plan Tab **********");
					return true;
				}
			}

			System.out.println("@@@@@@@@@@@@ Invalid Plan Type / Plan Tab not found @@@@@@@@@@@@@@");
			return false;

		}

		System.out.println("@@@@@@@@@@@@ Invalid Plan Type / Plan Tab not found @@@@@@@@@@@@@@");
		return false;
	}
	/**
	* @todo : displaying error messages of order plan materials for different plans
	*/

	@SuppressWarnings("deprecation")
	public void ValidateOptions(String PlanType){
		System.out.println("Proceed to validate for planType="+PlanType);
		if (PlanType.contentEquals("MA") || PlanType.contentEquals("MAPD") || PlanType.contentEquals("PDP")|| PlanType.contentEquals("SSUP")) {
			if (validate(memberMaterialsfield) && validate(replacementIdField) ){
				Assert.assertTrue(true);
				System.out.println("*************Displaying All Order Plan Material Options for "+PlanType+ "**********");
			}
			else{
				System.out.println("************* All Order Plan Material Options are NOT DISPLAYED for "+PlanType+ "**********");
				Assert.fail();
				
			}
		}
		else if (PlanType.contentEquals("HIP") || PlanType.contentEquals("MedSupp") ||PlanType.contentEquals("SHIP")) {
			if (validate(MemberIDcardField) && validate(EFTbrochureField) && validate(couponBook) && validate(claimsEnvelope) && validate(certificateInsurance) && validate(medicareHospital) ){
				Assert.assertTrue(true);
				System.out.println("*************Displaying All Order Plan Material Options for "+PlanType+ "**********");
			}
			else{
				System.out.println("*************All Order Plan Material Options are NOT DISPLAYED for "+PlanType+ "**********");
				Assert.fail();

			}
		}
		else{
			System.out.println("Invalid Plan Type / Plan Type not found");
			Assert.fail();
		}
	}
	/**
	* @todo : Validate header in order materials page
	*/

	
	public boolean ValidateHeader(){
		//if (driver.findElement(By.xpath("//h1[@class='h4 margin-none']")).isDisplayed() && driver.findElement(By.xpath("//h2[@class='h3 medium margin-large']")).isDisplayed()){
		String targetH1Xpath="//h1[@class='main-heading margin-none']";
		String targetH2Xpath="//*[@id='globalContentIdForSkipLink']/div[4]/div/div/div/section[1]/div[2]/div[2]/div/h2";
		if (driver.findElement(By.xpath(targetH1Xpath)).isDisplayed() && driver.findElement(By.xpath(targetH2Xpath)).isDisplayed()){
			System.out.println("*************Header Text and Subtext displayed for Order materials Page***************");
			
			return true;
		}
		else{ 
			System.out.println("************Header Text and Subtext not displayed for Order materials Page***************");
			return false;}
		
	}
	
	/**
	* @todo : Display error message
	*/

	public boolean ValidateErrorMessage() throws InterruptedException{
		CommonUtility.waitForPageLoad(driver, OrderMaterialsErrorMsg, 5);
		//tbd Thread.sleep(3000);
		if (validate(OrderMaterialsErrorMsg)){
			System.out.println("*************Error Message Displayed displayed for Order materials Page***************");
			System.out.println("*************Error Message : "+OrderMaterialsErrorMsg.getText()+" ***************");
			return true;
		} else{ 
			System.out.println("************Error message not displayed for Order materials Page***************");
			return false;
		}
	}

	/**
	* @throws InterruptedException 
	 * @todo : error message for ship members
	*/

	public boolean ValidateSHIPErrorMessage() throws InterruptedException{
		/* tbd-remove
		try {
			Thread.sleep(8000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		CommonUtility.waitForPageLoad(driver, SHIPerrorMsg, 10);
		if (validate(SHIPerrorMsg)){
			if(SHIPerrorMsg.getText().contains("request cannot be processed at this time")){
				System.out.println("*************Error Message Displayed displayed for SHIP invalid Selection in Order materials Page***************");
				System.out.println("*************Error Message : "+SHIPerrorMsg.getText()+"***************");
				return true;
			} else {
				System.out.println("************Error message not displayed for SHIP invalid Selection - Order materials Page***************");
				return false;
			}
		} else {
			System.out.println("************Error message not displayed for SHIP invalid Selection - Order materials Page***************");
			return false;
		}
	}
	
	/**
	* @todo : Plan confirmation page validation of order materials page
	*/

	public OrderPlanMaterialConfirmationPage selectsOption(String option) throws InterruptedException {

		driver.navigate().refresh();
		/* tbd-remove
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
		CommonUtility.waitForPageLoad(driver, iPerceptionPopUp, 5);
		if(validate(iPerceptionPopUp)){
			System.out.println("FeedBack Modal Present");

			iPerceptionClose.click();
			if (validate(iPerceptionPopUp)){
				System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked");
			}
			else
				System.out.println("FeedBack Modal Closed");
		}

		CommonUtility.checkPageIsReady(driver);

		if (option.contains("Member Materials") || option.contains("Welcome Guide") || option.contains("Welcome kit")) {
			System.out.println("*************Selecting Member materials Radio***************");
			memberMaterialsfield.click();
			if(!memberMaterialsfield.isEnabled()){
				System.out.println("*************NOT ABLE to SELECT Member materials Radio***************");
			}
		}
		if (option.contains("Replacement ID card")) {
			System.out.println("*************Selecting Replacement ID card Radio***************");
			replacementIdField.click();
			if(!replacementIdField.isEnabled()){
				System.out.println("*************NOT ABLE to SELECT Replacement ID card Radio***************");
			}
		}
		
		if (option.contains("Member ID Card")) {
			System.out.println("*************Selecting Member ID Card Radio***************");
			MemberIDcardField.click();
			if(!MemberIDcardField.isEnabled()){
				System.out.println("*************NOT ABLE to SELECT Member ID Card Radio***************");
			}
		}

		if (option.contains("Electronic Funds Transfer (EFT) Brochure")) {
			System.out.println("*************Selecting Electronic Funds Transfer (EFT) Brochure Radio***************");
			EFTbrochureField.click();
			if(!EFTbrochureField.isEnabled()){
				System.out.println("*************NOT ABLE to SELECT Electronic Funds Transfer (EFT) Brochure Radio***************");
			}

		}

		if (option.contains("Premium Payment Envelopes")) {
			System.out.println("*************Selecting Premium Payment Envelopes Radio***************");
			premiumPayment.click();
			if(!premiumPayment.isEnabled()){
				System.out.println("*************NOT ABLE to SELECT Premium Payment Envelopes Radio***************");
			}

		}

		if (option.contains("Coupon Book")) {
			System.out.println("*************Selecting Coupon Book Radio***************");
			couponBook.click();
			if(!couponBook.isEnabled()){
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
			System.out.println("*************Selecting Claims Envelope Radio***************");
			claimsEnvelope.click();
			if(!claimsEnvelope.isEnabled()){
				System.out.println("*************NOT ABLE to SELECT Claims Envelope Radio***************");
			}

		}

		if (option.contains("Certificate of Insurance")) {
			System.out.println("*************Selecting Certificate of Insurance Radio***************");
			certificateInsurance.click();
			if(!certificateInsurance.isEnabled()){
				System.out.println("*************NOT ABLE to SELECT Certificate of Insurance Radio***************");
			}

		}
		
		CommonUtility.waitForPageLoad(driver, submitButton, 5);
		//tbd-remove Thread.sleep(5000);

		//submitButton.submit();
		if(validate(submitButton)){
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", submitButton); 
			System.out.println("****** Submit Button Clicked ********");
		}

		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CommonUtility.checkPageIsReady(driver);
		if (validate(OrderConfirmationHeader) || validate(OrderConfirmation_addordermaterialLink)) {
			System.out.println("@@@@ Opder Plan Material COnfirmation Page is Displayed @@@@");
			return new OrderPlanMaterialConfirmationPage(driver);
		}
		
		/* note: try this when working data is available
		int x=0;
		while(x<5) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {	e.printStackTrace(); }
			if (validate(OrderConfirmationHeader) || validate(OrderConfirmation_addordermaterialLink)) {
				System.out.println("@@@@ Opder Plan Material COnfirmation Page is Displayed @@@@");
				return new OrderPlanMaterialConfirmationPage(driver);
			}
			x=x+1;
			System.out.println("waited x seconds for either OrderConfirmationHeader or OrderConfirmation_addordermaterialLink to show");
		}
		*/
			return null;
	}
	/**
	* @throws InterruptedException 
	 * @todo : Verify help component in order materials page
	*/

	public OrderMaterialsPage verifyneedHelpcomponent() throws InterruptedException{
		boolean present;
		try{
			validate(needhelpcomponent);
			present=true;
		}catch(NoSuchElementException e)
		{
			present=false;
		}
		if(present){
			System.out.println("Able to find needhelp component");
			return new OrderMaterialsPage(driver);
		}
		
		System.out.println("No needhelp component is displayed");
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