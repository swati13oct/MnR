/**
 * 
 */
package pages.member.bluelayer;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class OrderplanmaterialsPage extends UhcDriver {

/*	@FindBy(id = "documentIdName1")
	private WebElement memberMaterialsfield;

	@FindBy(id = "documentIdName2")
	private WebElement replacementIdField;

	@FindBy(linkText = "submit")
	private WebElement submitButton;

	@FindBy(id = "shipDocumentStateCodeId")
	private WebElement shipDocumentStateCodeId;
	*/

	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	
	@FindBy(id="addAnotherPlanLink")
	private WebElement addPlansTab;
	 
	@FindBy(className="selected")
	private WebElement orderMaterial;

	@FindBy(xpath = "//a[contains(text(), 'Medicare Prescription Drug Plan')]")
	private WebElement PDPPlanTab;
	
	@FindBy(xpath = "//a[contains(text(), 'Senior Supplement Plan')]")
	private WebElement SSUPPlanTab;
	
	@FindBy(id = "member-materials")
	private WebElement memberMaterialsfield;

	@FindBy(id = "replacement-id")
	private WebElement replacementIdField;
	
	@FindBy(xpath = "//div[@class='orderplanconttext']/h3")
	private WebElement planMaterialHeading;
	
	@FindBy(xpath = "//button")
	private WebElement submitButton;
	
	
	@SuppressWarnings("deprecation")
	public void navigatePlanTabs(String PlanType){
		
		if (PlanType.contains("PDP")) {
			validate(PDPPlanTab);
			PDPPlanTab.click();
			Assert.assertTrue("Cant navigate to PDP Plan Tab", memberMaterialsfield.isDisplayed());
			System.out.println("*************Displaying PDP Plan Tab **********");
			
		}
		else if (PlanType.contains("SSUP")) {
			validate(SSUPPlanTab);
			SSUPPlanTab.click();
			Assert.assertTrue("Cant navigate to Med Supp PlanTab Plan Tab", replacementIdField.isDisplayed());
			System.out.println("*************Displaying Senior Supplement Plan Tab Plan Tab **********");
			
		}
		else{
			System.out.println("Invalid Plan Type / Plan Type not found");
		}	
	}

	@SuppressWarnings("deprecation")
	public boolean ValidateHeader(){
		if (driver.findElement(By.xpath("//h1[@class='h4 margin-none']")).isDisplayed() && driver.findElement(By.xpath("//h2[@class='h3 medium margin-large']")).isDisplayed()){
			System.out.println("*************Header Text and Subtext displayed for Order materials Page***************");
			
			return true;
		}
		else{ 
			System.out.println("************Header Text and Subtext not displayed for Order materials Page***************");
			return false;}
		
	}
	
	public OrderplanmaterialsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//CommonUtility.waitForPageLoad(driver, planMaterialHeading, CommonConstants.TIMEOUT_30);
		//openAndValidate();
	}

	public PlanMaterialConfirmationPage selectsOption(String option) {

		if (option.contains("Member Materials")) {
			memberMaterialsfield.click();
		}

		if (option.contains("Replacement ID card")) {
			replacementIdField.click();
		}

		submitButton.click();

		if (planMaterialHeading.getText().contains(
				"Plan Materials Order Confirmation")) {
			return new PlanMaterialConfirmationPage(driver);
		} else
			return null;

	}
	public void validatePlanName(){
    	String planName = LoginCommonConstants.PLAN_NAME;
    	System.out.println(planName);
    	List<WebElement> planWebElement = driver.findElements(By.xpath("//*[text()='"+LoginCommonConstants.PLAN_NAME+"']"));
    	for(int i=0; i<planWebElement.size();i++){
    		if(planWebElement.get(i).getText().contains("HealthSelect Medicare Rx ")){
    			System.out.println("----------Failed due to presence of HealthSelect Medicare Rx ------------");
    			Assert.fail();
    		}
    		else if(planWebElement.get(i).getText().equalsIgnoreCase(LoginCommonConstants.PLAN_NAME)){
    			System.out.println("----------Plan name displayed as expected="+planName);
    		}  		 
    	}
       }
	public void logOut() {
		logOut.click();

	}
	
	public boolean validateAddPlanLink(){
		boolean flag = false;
		try{
		waitforElement(orderMaterial);	
		if(orderMaterial.getText().equals("Order Materials")){
		if(addPlansTab.isDisplayed()){
			System.out.println(addPlansTab.getText()+" is displayed, hence scenario failed");
			//Assert.assertTrue(flag);
			flag=true;
			return flag;
		}else{
			System.out.println("addPlansTab is not displayed");
			//Assert.fail();!
			return flag;
		}
		}}
		catch(Exception e){
			System.out.println("Exception failing - element not visible");
			//Assert.fail();
		}
		return flag;
	}

	@Override
	public void openAndValidate() {

		validate(planMaterialHeading);
		validate(logOut);
	}

}
