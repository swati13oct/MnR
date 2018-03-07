/**
 * 
 */
package pages.deprecated.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author saduri
 *
 */
public class TermsOfUseUmsPage extends UhcDriver{
	
	@FindBy(id = "gf_lnk_7")
	private WebElement disclaimersLink;

	public TermsOfUseUmsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	
	}

	@Override
	public void openAndValidate() {
		validateNew(disclaimersLink);
		
	}
	
	public DisclaimersPage disclaimersClick() {
		validateNew(disclaimersLink);
		disclaimersLink.click();
		validateNew(disclaimersLink);
		if(driver.getTitle().equalsIgnoreCase("Disclaimers | UnitedHealthcare®")){
			return new DisclaimersPage(driver);
		}
		return null;
			
		}

}
