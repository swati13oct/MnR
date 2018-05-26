/**
 * 
 */
package pages.acquisition.ole;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 *@author sdwaraka
 *
 */
public class ProposedEffectiveDatePage extends UhcDriver{
	
	//OLE Common Elements
	@FindBy(xpath = "//*[@class = 'logo']")
	private WebElement SiteLogo;
	
	@FindBy(id = "ole-form-next-button")
	private WebElement NextBtn;
	
	@FindBy(id = "ole-form-back-button")
	private WebElement BackBtn;

	@FindBy(xpath = "//*[@id='ole-form-cancel-button' or @id = 'cancel-enrollment']")
	private WebElement CancelEnrollmentLink;

	//Page Header
	@FindBy(xpath = "//*[@class='only-prelim']")
	private WebElement ProposedEffectiveDatePageHeader;

	@FindBy(xpath = "//*[@type='radio']//following-sibling::label")
	private List <WebElement> ProposedEffectiveDateOptions;

	
	//Right Rail Elements

	@FindBy(xpath = "//*[@id='learn-more-ole']/a")
	private WebElement RightRail_LearnMoreLink;
	
	@FindBy(id = "tty-number")
	private WebElement RightRailTFN;
	
	@FindBy(xpath = "//*[@id='ole-plan-name']")
	private WebElement PlanYear_PlanName;
	
	@FindBy(xpath = "//*[@id='ole-zip']")
	private WebElement ZipCode_County;
	
	@FindBy(xpath = "//*[@id='ole-premium']")
	private WebElement PremiumDisplay;

	public ProposedEffectiveDatePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(ProposedEffectiveDatePageHeader);
		
		System.out.println("Page header is Displayed"+ProposedEffectiveDatePageHeader.getText());
		
	}
	
	public boolean validate_proposed_effective_date_options(){
		boolean validation_Flag = true;
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
	
	public Object navigate_to_PCP_Page(String planType) {

		validate(NextBtn);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextBtn);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(planType.contentEquals("PDP")){
			if(driver.getCurrentUrl().contains("monthly-premium")){
				System.out.println("OLE Monthly Plan Premium Page is Displayed");
				return new PlanPremiumPage(driver);
			}
			else{
				System.out.println("OLE Monthly Plan Premium Page is Not Displayed");
				return null;
			}
		}
		else{
			if (driver.getCurrentUrl().contains("provider-search")){
				System.out.println("OLE Primary Care Physician Page is Displayed");
				return new PrimaryCarePhysicianPage(driver);
			}
			else{
				System.out.println("OLE Primary Care Physician Page is Not Displayed");
				return null;
			}
		}
	}
}