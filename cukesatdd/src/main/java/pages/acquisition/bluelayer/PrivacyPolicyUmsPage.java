/**
 * 
 */
package pages.acquisition.bluelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

/**
 * @author saduri
 *
 */
public class PrivacyPolicyUmsPage extends UhcDriver{
	
	@FindBy(id = "gf_lnk_6")
	private WebElement termsOfUseLink;

	public PrivacyPolicyUmsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(termsOfUseLink);
		
	}
	
	public TermsOfUseUmsPage termsOfUseClick() {
		validate(termsOfUseLink);
		termsOfUseLink.click();
		validate(termsOfUseLink);
		if(driver.getTitle().equalsIgnoreCase("Terms of Use | UnitedHealthcare®")){
			return new TermsOfUseUmsPage(driver);
		}
		return null;
			
		}

}
