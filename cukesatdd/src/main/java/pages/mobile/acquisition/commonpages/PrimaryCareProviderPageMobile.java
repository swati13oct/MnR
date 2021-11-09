/**
 * 
 */
package pages.mobile.acquisition.commonpages;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.acquisition.commonpages.PageTitleConstants;

/**
 * @author pperugu
 *
 */
public class PrimaryCareProviderPageMobile extends UhcDriver {


	@FindBy(css = "#pcpprevious")
	private WebElement pcpprevious;

	@FindBy(css = "#pcpsaveandcont")
	private WebElement pcpsaveandcont;
	
	
	@FindBy(css = "#pcpcancel")
	private WebElement pcpcancel;

	@FindBy(xpath = "//*[@id='pcpsaveandcont']")
	private WebElement saveandcontinuepcp;

	public JSONObject primarycareproviderInformationJson;

	public PrimaryCareProviderPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	@Override
	public void openAndValidate() {

	}

	public Object navigatesToNextStep(String premium) {
		pcpsaveandcont.click();
		// if(premium.equalsIgnoreCase("$0.00 a month")){
		// return new OptionalRidersPage(driver);
		// }else{
		return new PlanPaymentOptionsMobile(driver);

		// }
	}

	public PlanPaymentOptionsMobile clickdisclaimer() {

		validate(saveandcontinuepcp);
		saveandcontinuepcp.click();

		if (driver.getTitle()
				.equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_ADVANTAGE_ENROLLMENT)) {
			return new PlanPaymentOptionsMobile(driver);
		}
		return null;

	}
	@FindBy(xpath = ".//*[@id='pcpInfo']/p")
	private WebElement pcpHeader;
	
	@FindBy(xpath = ".//*[@id='enrollment-step-1-part-7']//a[@class='cta-button secondary pcp-lookup-button look-but']")
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


