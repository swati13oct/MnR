/**
 * 
 */
package pages.vbfacquisition_deprecated.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.vbfacquisition_deprecated.ulayer.PageTitleConstants;

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
		validate(disclaimersLink);
		
	}
	
	public DisclaimersPage disclaimersClick() {
		validate(disclaimersLink);
		disclaimersLink.click();
		validate(disclaimersLink);
		if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_DISCLAIMERS)){
			return new DisclaimersPage(driver);
		}
		return null;
			
		}

}
