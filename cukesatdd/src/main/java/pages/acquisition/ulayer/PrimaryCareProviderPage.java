/**
 * 
 */
package pages.acquisition.ulayer;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.PageData;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class PrimaryCareProviderPage extends UhcDriver{
	

	@FindBy(id = "pcpprevious")
	private WebElement pageHeadingPlanPaymentopt;
	
	@FindBy(id = "pcpprevious")
	private WebElement pcpprevious;
	
	
	
	@FindBy(id = "pcpsaveandcont")
	private WebElement pcpsaveandcont;
	
	@FindBy(id = "pcpcancel")
	private WebElement pcpcancel;
	
	
	@FindBy(xpath = "//*[@id='pcpsaveandcont']")
	private WebElement saveandcontinuepcp;
	

	
	private PageData primarycareproviderInformation;

	public JSONObject primarycareproviderInformationJson;
	
	
 public PrimaryCareProviderPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	
	}

	@Override
	public void openAndValidate() {
	
		
	}

		
	public Object navigatesToNextStep(String premium) {
			pcpsaveandcont.click();
//			if(premium.equalsIgnoreCase("$0.00 a month")){
//				return new OptionalRidersPage(driver);
//			}else{
				return new PlanPaymentOptions(driver);
				
//			}
		}

	public PlanPaymentOptions clickdisclaimer() {
		
		
		validate(saveandcontinuepcp);
		saveandcontinuepcp.click();
	
		
		
		if (driver.getTitle().equalsIgnoreCase("Medicare Advantage Enrollment | AARP� Medicare Plans from UnitedHealthcare�")) {
			return new PlanPaymentOptions(driver);
		}
		return null;
		
		
		
	}
	@FindBy(xpath = ".//*[@id='pcpInfo']/p")
	private WebElement pcpHeader;
	
	@FindBy(xpath = ".//*[@id='enrollment-step-1-part-7']/div[1]/div/div[2]/fieldset/a")
	private WebElement lookupProviderBtn;
	
	public boolean validatePCPPage(){
		boolean flag = false;
		if(validate(pcpHeader)&&validate(saveandcontinuepcp)&&validate(pcpcancel)&&validate(pcpprevious)&&
		validate(lookupProviderBtn))
			flag = true;
		return flag;
	}
	
	public void clickOnLookupProviderBtn(){
		lookupProviderBtn.click();
	}
	
		
	
	}
