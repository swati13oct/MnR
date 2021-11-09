/**
 * 
 */
package pages.mobile.acquisition.commonpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.mobile.acquisition.ole.PlanPremiumPageMobile;
import pages.mobile.acquisition.ole.PrimaryCarePhysicianPageMobile;

/**
 *@author sdwaraka
 *
 */
public class ProposedEffectiveDatePageMobile extends UhcDriver{
	
	//OLE Common Elements
	@FindBy(xpath = "//*[@class = 'logo']")
	private WebElement SiteLogo;
	
	@FindBy(css = "#ole-form-next-button")
	private WebElement NextBtn;
	
	@FindBy(css = "#ole-form-back-button")
	private WebElement BackBtn;

	@FindBy(xpath = "//*[@id='ole-form-cancel-button' or @id = 'cancel-enrollment']")
	private WebElement CancelEnrollmentLink;

	//Page Header
	//@FindBy(xpath = "//*[contains(@class, 'ole-form-header')]//*[contains(@class,'only-prelim')]")
	@FindBy(xpath = "//*[contains(@id, 'ProposedEffectiveDateFieldSet')]")
	private WebElement ProposedEffectiveDatePageHeader;

	@FindBy(xpath = "//*[@type='radio']//following-sibling::label")
	private List <WebElement> ProposedEffectiveDateOptions;

	
	//Right Rail Elements

	@FindBy(xpath = "//*[@id='learn-more-ole']/a")
	private WebElement RightRail_LearnMoreLink;
	
	@FindBy(css = "#tty-number")
	private WebElement RightRailTFN;
	
	@FindBy(xpath = "//*[@id='ole-plan-name']")
	private WebElement PlanYear_PlanName;
	
	@FindBy(xpath = "//*[@id='ole-zip']")
	private WebElement ZipCode_County;
	
	@FindBy(xpath = "//*[@id='ole-premium']")
	private WebElement PremiumDisplay;

	public ProposedEffectiveDatePageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, ProposedEffectiveDatePageHeader, 30);		
		System.out.println("Page header is Displayed"+ProposedEffectiveDatePageHeader.getText());
		
	}
	
	public boolean validate_proposed_effective_date_options(){
		boolean validation_Flag = true;
		validate(ProposedEffectiveDatePageHeader);
	//	jsClickNew(ProposedEffectiveDatePageHeader);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count = ProposedEffectiveDateOptions.size();
		if(count>0){
			validation_Flag = true;
			System.out.println("Proposed Effective Date displayed");
			for(WebElement Dateoption : ProposedEffectiveDateOptions){
				System.out.println(Dateoption.getText());
			}
		}
		else{
			System.out.println("Proposed Effective Date is NOT displayed");
			validation_Flag = false;
		}
		return validation_Flag;
	}
	
	public String get_proposed_effective_date(){
		String proposedEfDate = null;
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count = ProposedEffectiveDateOptions.size();
		if(count>0){
			System.out.println("Proposed Effective Date displayed");
			proposedEfDate= ProposedEffectiveDateOptions.get(0).getText();
		 }
		else{
			System.out.println("Proposed Effective Date is NOT displayed");
			
		}
		return proposedEfDate;
	}
	
	
	public Object navigate_to_PCP_Page(String planType) {

		validateNew(NextBtn);
		jsClickNew(NextBtn);
		threadsleep(2000);
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextBtn);*/
		
		if(planType.contentEquals("PDP")){
			//if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Plan Payment Information')]")))){
				if(validateNew(driver.findElement(By.xpath("(//*[contains(@id,'planWith')])[1]")))){
				System.out.println("OLE Monthly Plan Premium Page is Displayed");
				return new PlanPremiumPageMobile(driver);
			}
			else{
				System.out.println("OLE Monthly Plan Premium Page is Not Displayed");
				return null;
			}
		}
		else{
		//	if (validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Provider')]")))){
			if (validateNew(driver.findElement(By.xpath("(//*[contains(@id,'primaryCare')])[1]")))){
				System.out.println("OLE Primary Care Physician Page is Displayed");
				return new PrimaryCarePhysicianPageMobile(driver);
			}
			else{
				System.out.println("OLE Primary Care Physician Page is Not Displayed");
				return null;
			}
		}
	}

	public void clickOnSaveAndContinue(String plantype) {
		// TODO Auto-generated method stub
		
	}
}